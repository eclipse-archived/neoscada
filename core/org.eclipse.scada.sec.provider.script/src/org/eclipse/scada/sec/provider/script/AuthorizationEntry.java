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
package org.eclipse.scada.sec.provider.script;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import javax.script.SimpleScriptContext;

import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.authz.AuthorizationRule;
import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.callback.Callbacks;
import org.eclipse.scada.sec.callback.ConfirmationCallback;
import org.eclipse.scada.sec.callback.ConfirmationCallback.ConfirmationType;
import org.eclipse.scada.utils.concurrent.CallingFuture;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.eclipse.scada.utils.statuscodes.SeverityLevel;
import org.eclipse.scada.utils.statuscodes.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public class AuthorizationEntry implements AuthorizationRule
{
    private final static Logger logger = LoggerFactory.getLogger ( AuthorizationEntry.class );

    private final ScriptExecutor script;

    private final ScriptExecutor callbackScript;

    private final AuthenticationImplementation authenticationImplementation;

    public static class CallbackBuilder
    {
        private final CallbackHandler callbackHandler;

        public CallbackBuilder ( final CallbackHandler callbackHandler )
        {
            this.callbackHandler = callbackHandler;
        }

        public NotifyFuture<Callback[]> confirm ( final String message, final String type )
        {
            final ConfirmationType confirmationType = type == null || type.isEmpty () ? ConfirmationType.CONFIRM : ConfirmationType.valueOf ( type );
            return Callbacks.callback ( this.callbackHandler, new ConfirmationCallback ( confirmationType, message, 0 ) );
        }
    }

    public AuthorizationEntry ( final ScriptExecutor script, final ScriptExecutor callbackScript, final AuthenticationImplementation authenticationImplementation )
    {
        this.script = script;
        this.callbackScript = callbackScript;
        this.authenticationImplementation = authenticationImplementation;
    }

    @Override
    public void dispose ()
    {
    }

    protected Map<String, Object> makeBindings ( final AuthorizationContext context )
    {
        final AuthorizationRequest request = context.getRequest ();

        final String objectType = request.getObjectType ();
        final String objectId = request.getObjectId ();
        final String action = request.getAction ();
        final UserInformation userInformation = request.getUserInformation ();

        final Map<String, Object> contextData = request.getContext ();

        final Map<String, Object> bindings = new HashMap<String, Object> ();

        bindings.put ( "authorizationContext", context ); //$NON-NLS-1$
        bindings.put ( "request", request ); //$NON-NLS-1$
        bindings.put ( "id", objectId ); //$NON-NLS-1$
        bindings.put ( "type", objectType ); //$NON-NLS-1$
        bindings.put ( "action", action ); //$NON-NLS-1$
        bindings.put ( "user", userInformation ); //$NON-NLS-1$
        bindings.put ( "GRANTED", AuthorizationResult.GRANTED ); //$NON-NLS-1$
        bindings.put ( "ABSTAIN", AuthorizationResult.ABSTAIN ); //$NON-NLS-1$
        bindings.put ( "requestContext", contextData ); //$NON-NLS-1$
        bindings.put ( "authenticator", this.authenticationImplementation ); //$NON-NLS-1$
        bindings.put ( "Callbacks", new CallbackBuilder ( context.getCallbackHandler () ) ); //$NON-NLS-1$

        return bindings;
    }

    @Override
    public NotifyFuture<AuthorizationResult> authorize ( final AuthorizationContext context )
    {
        final Map<String, Object> bindings = makeBindings ( context );

        // now execute the script
        final SimpleScriptContext ctx = new SimpleScriptContext ();

        Object result;
        try
        {
            result = this.script.execute ( ctx, bindings );
            logger.debug ( "Result is: {}", result );
        }
        catch ( final Exception e )
        {
            logger.debug ( "Failed to execute", e );
            return new InstantErrorFuture<AuthorizationResult> ( e );
        }

        if ( result instanceof NotifyFuture<?> )
        {
            @SuppressWarnings ( "unchecked" )
            final NotifyFuture<Object> future = (NotifyFuture<Object>)result;
            return new CallingFuture<Object, AuthorizationResult> ( future ) {

                @Override
                public AuthorizationResult call ( final Future<Object> future ) throws Exception
                {
                    return handleCallback ( context, bindings, ctx, future );
                }
            };
        }
        else
        {
            return new InstantFuture<AuthorizationResult> ( generateResult ( context, result ) );
        }
    }

    protected AuthorizationResult handleCallback ( final AuthorizationContext context, final Map<String, Object> bindings, final SimpleScriptContext ctx, final Future<Object> future ) throws Exception
    {
        logger.debug ( "Called back: {}", future );

        bindings.put ( "future", future );
        final Object result = this.callbackScript.execute ( ctx, bindings );

        return generateResult ( context, result );
    }

    private AuthorizationResult generateResult ( final AuthorizationContext context, final Object eval )
    {
        logger.debug ( "Authentication result: {}", eval ); //$NON-NLS-1$

        if ( eval == null )
        {
            return AuthorizationResult.ABSTAIN;
        }

        // boolean return
        if ( eval instanceof Boolean )
        {
            if ( (Boolean)eval )
            {
                return AuthorizationResult.GRANTED;
            }
            else
            {
                return AuthorizationResult.createReject ( new StatusCode ( "OSSEC", "SCRIPT", 1, SeverityLevel.ERROR ), Messages.getString ( "AuthorizationEntry.error.1.message" ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
        }

        // numeric return
        if ( eval instanceof Number )
        {
            if ( ( (Number)eval ).longValue () == 0 )
            {
                return AuthorizationResult.GRANTED;
            }
            else
            {
                return AuthorizationResult.createReject ( new StatusCode ( "OSSEC", "SCRIPT", 2, SeverityLevel.ERROR ), String.format ( Messages.getString ( "AuthorizationEntry.error.2.message" ), eval ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
        }

        // string return
        if ( eval instanceof String )
        {
            if ( ( (String)eval ).isEmpty () )
            {
                return AuthorizationResult.GRANTED;
            }
            else
            {
                return AuthorizationResult.createReject ( new StatusCode ( "OSSEC", "SCRIPT", 3, SeverityLevel.ERROR ), String.format ( eval.toString (), eval ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }

        if ( eval instanceof StatusCode )
        {
            return AuthorizationResult.createReject ( (StatusCode)eval, Messages.getString ( "AuthorizationEntry.error.defaultMessage" ) ); //$NON-NLS-1$
        }

        if ( eval instanceof Throwable )
        {
            return AuthorizationResult.createReject ( (Throwable)eval );
        }

        if ( eval instanceof AuthorizationResult )
        {
            return (AuthorizationResult)eval;
        }

        if ( eval instanceof UserInformation )
        {
            context.changeUserInformation ( (UserInformation)eval );
            return AuthorizationResult.ABSTAIN;
        }

        if ( eval instanceof Result )
        {
            final Result result = (Result)eval;
            return AuthorizationResult.createReject ( result.getCode (), result.getMessage () );
        }

        // no more known results
        return AuthorizationResult.createReject ( new StatusCode ( "OSSEC", "SCRIPT", 4, SeverityLevel.ERROR ), String.format ( Messages.getString ( "AuthorizationEntry.unknownResultType" ), eval ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

}