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
package org.eclipse.scada.sec.callback;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.eclipse.scada.utils.concurrent.NotifyFuture;

/**
 * Translates java {@link CallbackHandler} calls to Eclipse SCADA
 * {@link org.eclipse.scada.sec.callback.CallbackHandler} calls.
 * 
 * @since 1.1
 */
public class CallbackHandlerTranslator implements CallbackHandler
{

    private interface CallbackAdapter
    {
        public void complete ();

        public org.eclipse.scada.sec.callback.Callback getAdapter ();
    }

    private static class UserNameCallbackAdapter implements CallbackAdapter
    {
        private final NameCallback callback;

        private final UserNameCallback adapter;

        public UserNameCallbackAdapter ( final NameCallback callback, final int order )
        {
            this.callback = callback;
            this.adapter = new UserNameCallback ( callback.getPrompt (), order );
        }

        @Override
        public void complete ()
        {
            this.callback.setName ( this.adapter.getValue () );
        }

        @Override
        public org.eclipse.scada.sec.callback.Callback getAdapter ()
        {
            return this.adapter;
        }
    }

    private static class PasswordCallbackAdapter implements CallbackAdapter
    {
        private final PasswordCallback callback;

        private final org.eclipse.scada.sec.callback.PasswordCallback adapter;

        public PasswordCallbackAdapter ( final PasswordCallback callback, final int order )
        {
            this.callback = callback;
            this.adapter = new org.eclipse.scada.sec.callback.PasswordCallback ( callback.getPrompt (), order );
        }

        @Override
        public void complete ()
        {
            this.callback.setPassword ( this.adapter.getPlainPassword ().toCharArray () );
        }

        @Override
        public org.eclipse.scada.sec.callback.Callback getAdapter ()
        {
            return this.adapter;
        }
    }

    private final org.eclipse.scada.sec.callback.CallbackHandler callbackHandler;

    public CallbackHandlerTranslator ( final org.eclipse.scada.sec.callback.CallbackHandler callbackHandler )
    {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public void handle ( final Callback[] callbacks ) throws IOException, UnsupportedCallbackException
    {
        final org.eclipse.scada.sec.callback.Callback[] cbs = new org.eclipse.scada.sec.callback.Callback[callbacks.length];

        final CallbackAdapter[] adapters = new CallbackAdapter[callbacks.length];

        for ( int i = 0; i < callbacks.length; i++ )
        {
            final Callback c = callbacks[i];
            if ( c instanceof NameCallback )
            {
                adapters[i] = new UserNameCallbackAdapter ( (NameCallback)c, i );
            }
            else if ( c instanceof PasswordCallback )
            {
                adapters[i] = new PasswordCallbackAdapter ( (PasswordCallback)c, i );
            }
            else
            {
                throw new UnsupportedCallbackException ( c );
            }

            cbs[i] = adapters[i].getAdapter ();
        }

        final NotifyFuture<org.eclipse.scada.sec.callback.Callback[]> future = Callbacks.callback ( this.callbackHandler, cbs );
        try
        {
            future.get ();
        }
        catch ( final Exception e )
        {
            throw new IOException ( e );
        }

        for ( final CallbackAdapter adapter : adapters )
        {
            adapter.complete ();
        }
    }

}
