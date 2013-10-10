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

import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import javax.script.ScriptEngineManager;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.AuthorizationService;
import org.eclipse.scada.sec.audit.AuditLogService;
import org.eclipse.scada.sec.authz.AuthorizationRule;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public class SignatureAuthorizationService implements AuthorizationService
{

    private final static Logger logger = LoggerFactory.getLogger ( SignatureAuthorizationService.class );

    private AuditLogService auditLogService;

    private AuthenticationImplementation authenticationImplementation;

    private final CertificateFactory cf;

    private ScheduledExportedExecutorService executor;

    public void setAuthenticationImplementation ( final AuthenticationImplementation authenticationImplementation )
    {
        this.authenticationImplementation = authenticationImplementation;
    }

    public void setAuditLogService ( final AuditLogService auditLogService )
    {
        this.auditLogService = auditLogService;
    }

    public SignatureAuthorizationService () throws CertificateException
    {
        this.cf = CertificateFactory.getInstance ( "X.509" );
    }

    public void activate ()
    {
        this.executor = new ScheduledExportedExecutorService ( "org.eclipse.scada.sec.authz.signature", 1 );
    }

    public void deactivate ()
    {
        this.executor.shutdown ();
        this.executor = null;
    }

    @Override
    public synchronized AuthorizationRule createRule ( final Map<String, String> properties ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final boolean indent = cfg.getBoolean ( "indent", false );

        final String script = cfg.getString ( "postProcessor", null );
        final String engine = cfg.getString ( "postProcessor.engine", "JavaScript" );

        ScriptExecutor postProcessor;
        if ( script != null )
        {
            postProcessor = new ScriptExecutor ( new ScriptEngineManager (), engine, script, SignatureAuthorizationService.class.getClassLoader () );
        }
        else
        {
            postProcessor = null;
        }

        final int reloadPeriod = cfg.getInteger ( "reloadPeriod", 0 );

        final X509KeySelector keySelector = makeKeySelector ( properties );

        return new RequestSignatureRuleImpl ( this.executor, new SignatureRequestBuilder (), new RequestValidator ( keySelector ), keySelector, this.auditLogService, indent, postProcessor, this.authenticationImplementation, reloadPeriod );
    }

    private X509KeySelector makeKeySelector ( final Map<String, String> properties ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final Collection<X509CA> cas = new LinkedList<X509CA> ();

        final Map<String, String> caProperties = cfg.getPrefixed ( "ca." );
        for ( final Map.Entry<String, String> entry : caProperties.entrySet () )
        {
            final String key = entry.getKey ();
            if ( key.equals ( "cert" ) )
            {
                final String caCertUrl = entry.getValue ();

                final Collection<String> crls = new LinkedList<String> ();
                crls.addAll ( new ConfigurationDataHelper ( caProperties ).getPrefixed ( "crl." ).values () );

                final String crlUrl = caProperties.get ( "crl" );
                if ( crlUrl != null )
                {
                    crls.add ( crlUrl );
                }

                logger.debug ( "CRL uris - {}", crls );

                cas.add ( new X509CA ( this.cf, caCertUrl, crls ) );
            }
            else if ( key.endsWith ( ".cert" ) )
            {
                final String caCertUrl = entry.getValue ();

                final Collection<String> crls = new LinkedList<String> ();

                final String prefix = key.substring ( 0, key.length () - ".cert".length () ) + ".crl";

                logger.debug ( "Using CRL prefix - {}", prefix );

                crls.addAll ( new ConfigurationDataHelper ( caProperties ).getPrefixed ( prefix + "." ).values () );

                final String crlUrl = caProperties.get ( prefix );
                if ( crlUrl != null )
                {
                    crls.add ( crlUrl );
                }

                logger.debug ( "CRL uris - {}", crls );

                cas.add ( new X509CA ( this.cf, caCertUrl, crls ) );
            }
        }

        if ( cas.isEmpty () )
        {
            throw new IllegalStateException ( "No key selector configuration found" );
        }
        else
        {
            return new X509KeySelector ( cas );
        }
    }
}
