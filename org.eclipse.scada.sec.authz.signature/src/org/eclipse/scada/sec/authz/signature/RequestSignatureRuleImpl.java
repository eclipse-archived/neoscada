/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.authz.signature;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;

import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.audit.AuditLogService;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.authz.AuthorizationRule;
import org.eclipse.scada.sec.authz.signature.RequestValidator.Result;
import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.Callbacks;
import org.eclipse.scada.sec.callback.XMLSignatureCallback;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.concurrent.TransformResultFuture;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

/**
 * @since 1.1
 */
public class RequestSignatureRuleImpl implements AuthorizationRule
{

    private final static Logger logger = LoggerFactory.getLogger ( RequestSignatureRuleImpl.class );

    private final SignatureRequestBuilder builder;

    private final RequestValidator validator;

    private final AuditLogService auditLogService;

    private final boolean indent;

    private final ScriptExecutor postProcessor;

    private final AuthenticationImplementation authenticator;

    private ScheduledFuture<?> job;

    private final X509KeySelector keySelector;

    public RequestSignatureRuleImpl ( final ScheduledExecutorService executor, final SignatureRequestBuilder builder, final RequestValidator validator, final X509KeySelector keySelector, final AuditLogService auditLogService, final boolean indent, final ScriptExecutor postProcessor, final AuthenticationImplementation authenticator, final int reloadPeriod )
    {
        this.builder = builder;
        this.validator = validator;
        this.auditLogService = auditLogService;
        this.indent = indent;
        this.postProcessor = postProcessor;
        this.authenticator = authenticator;
        this.keySelector = keySelector;

        if ( reloadPeriod > 0 )
        {
            logger.debug ( "Starting reload job: {} ms", reloadPeriod );

            this.job = executor.scheduleWithFixedDelay ( new Runnable () {

                @Override
                public void run ()
                {
                    reload ();
                }
            }, 0, reloadPeriod, TimeUnit.MILLISECONDS );
        }
        else
        {
            logger.debug ( "Reloading once" );
            reload ();
        }
    }

    protected void reload ()
    {
        logger.debug ( "Reloading" );
        this.keySelector.reload ();
    }

    @Override
    public void dispose ()
    {
        ScheduledFuture<?> job;

        synchronized ( this )
        {
            job = this.job;
            this.job = null;
        }

        if ( job != null )
        {
            logger.debug ( "Cancelling reload job" );
            job.cancel ( true );
        }
    }

    @Override
    public NotifyFuture<AuthorizationResult> authorize ( final AuthorizationContext context )
    {
        final Document doc = this.builder.buildFromRequest ( context.getRequest () );

        NotifyFuture<Callback[]> future;
        try
        {
            future = Callbacks.callback ( context.getCallbackHandler (), new XMLSignatureCallback ( this.builder.toString ( doc, this.indent ) ) );
        }
        catch ( final Exception e )
        {
            return new InstantErrorFuture<AuthorizationResult> ( e );
        }

        return new TransformResultFuture<Callback[], AuthorizationResult> ( future ) {

            @Override
            protected AuthorizationResult transform ( final Callback[] from ) throws Exception
            {
                return validateCallback ( context, doc, (XMLSignatureCallback)from[0] );
            }
        };
    }

    protected AuthorizationResult validateCallback ( final AuthorizationContext context, final Document doc, final XMLSignatureCallback callback )
    {
        if ( callback.isCanceled () || callback.getSignedDocument () == null )
        {
            return AuthorizationResult.createReject ( StatusCodes.VERIFY_NO_SIGNATURE, "No signature data found" );
        }

        try
        {
            final Document signedDoc = this.builder.fromString ( callback.getSignedDocument () );

            final Result result = this.validator.validate ( signedDoc );

            final String signatureString = this.builder.toString ( signedDoc, true );

            if ( !result.isValid () )
            {
                context.getContext ().put ( "failedSignature", signatureString );
                this.auditLogService.info ( "Validation failed:\n{}", signatureString );
                return AuthorizationResult.createReject ( StatusCodes.VERIFY_SIGNATURE_INVALID, "Signature is not valid" );
            }

            // next we need to check if the request was the request we actually wanted, somebody might just have sent some signed XML content
            try
            {
                this.builder.compare ( doc, signedDoc );
            }
            catch ( final Exception e )
            {
                context.getContext ().put ( "failedSignature", signatureString );
                this.auditLogService.info ( "Requests don't match\n\tOriginal: {}\n\tSigned: {}", this.builder.toString ( doc, true ), this.builder.toString ( signedDoc, true ) );
                return AuthorizationResult.createReject ( e );
            }

            context.getContext ().put ( "xmlsig.signatureString", signatureString );
            context.getContext ().put ( "xmlsig.signature", result.getSignature () );
            context.getContext ().put ( "xmlsig.keySelectorResult", result.getKeySelectorResult () );
            if ( result.getKeySelectorResult () instanceof X509KeySelectorResult )
            {
                context.getContext ().put ( "xmlsig.x509Certificate", ( (X509KeySelectorResult)result.getKeySelectorResult () ).getCertificate () );
            }

            postProcess ( context, result );

            // now we can create an abstain .. since the may be other rules to check
            return null;
        }
        catch ( final Exception e )
        {
            this.auditLogService.info ( "Failed to validate", e );
            return AuthorizationResult.createReject ( e );
        }
    }

    private void postProcess ( final AuthorizationContext context, final Result result ) throws Exception
    {
        if ( this.postProcessor == null )
        {
            return;
        }

        logger.debug ( "Running post processor" );

        final ScriptContext scriptContext = new SimpleScriptContext ();

        final Map<String, Object> scriptObjects = new HashMap<String, Object> ();
        scriptObjects.put ( "authorizationContext", context );
        scriptObjects.put ( "authenticator", this.authenticator );

        this.postProcessor.execute ( scriptContext, scriptObjects );
    }
}
