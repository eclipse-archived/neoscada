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
package org.eclipse.scada.core.server.common;

import java.util.Map;
import java.util.concurrent.Future;

import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.PermissionDeniedException;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.AbstractFuture;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

/**
 * @since 1.1
 */
public abstract class AuthorizedOperation<T, SI extends AbstractSessionImpl> extends AbstractFuture<T>
{

    private final String objectType;

    private final String objectId;

    private final String action;

    private final Map<String, Object> context;

    private final AuthorizationProvider<SI> authorizationProvider;

    private final CallbackHandler handler;

    private final AuthorizationResult defaultResult;

    private final OperationParameters operationParameters;

    public AuthorizedOperation ( final AuthorizationProvider<SI> authorizationProvider, final SI session, final String objectType, final String objectId, final String action, final Map<String, Object> context, final OperationParameters operationParameters, final CallbackHandler handler, final AuthorizationResult defaultResult )
    {
        this.authorizationProvider = authorizationProvider;
        this.objectType = objectType;
        this.objectId = objectId;
        this.action = action;
        this.context = context;
        this.handler = handler;
        this.defaultResult = defaultResult;
        this.operationParameters = operationParameters;

        final NotifyFuture<UserInformation> future = this.authorizationProvider.impersonate ( session, operationParameters == null ? null : operationParameters.getUserInformation ().getName (), handler );
        future.addListener ( new FutureListener<UserInformation> () {

            @Override
            public void complete ( final Future<UserInformation> future )
            {
                handleCompleteImpersonate ( future );
            }
        } );
    }

    protected void handleCompleteImpersonate ( final Future<UserInformation> future )
    {
        try
        {
            final UserInformation userInformation = future.get ();

            final NotifyFuture<AuthorizationReply> f = this.authorizationProvider.authorize ( makeRequest ( userInformation ), this.handler, this.defaultResult );

            f.addListener ( new FutureListener<AuthorizationReply> () {

                @Override
                public void complete ( final Future<AuthorizationReply> future )
                {
                    handleCompleteAuthorize ( future );
                }
            } );
        }
        catch ( final Exception e )
        {
            setError ( e );
        }
    }

    protected void handleCompleteAuthorize ( final Future<AuthorizationReply> future )
    {
        try
        {
            final AuthorizationReply result = future.get ();

            final PermissionDeniedException ex = result.getResult ().asException ();
            if ( ex != null )
            {
                // we got rejected
                setError ( ex );
                return;
            }

            final NotifyFuture<T> f = granted ( makeParameters ( result ) );
            f.addListener ( new FutureListener<T> () {

                @Override
                public void complete ( final Future<T> future )
                {
                    try
                    {
                        setResult ( future.get () );
                    }
                    catch ( final Exception e )
                    {
                        setError ( e );
                    }
                }
            } );
        }
        catch ( final Exception e )
        {
            setError ( e );
        }
    }

    private org.eclipse.scada.core.server.OperationParameters makeParameters ( final AuthorizationReply result )
    {
        return new org.eclipse.scada.core.server.OperationParameters ( result.getUserInformation (), this.operationParameters == null ? null : this.operationParameters.getProperties (), this.handler );
    }

    private AuthorizationRequest makeRequest ( final UserInformation effective )
    {
        return new AuthorizationRequest ( this.objectType, this.objectId, this.action, effective, this.context );
    }

    protected abstract NotifyFuture<T> granted ( org.eclipse.scada.core.server.OperationParameters effectiveOperationParameters );

}
