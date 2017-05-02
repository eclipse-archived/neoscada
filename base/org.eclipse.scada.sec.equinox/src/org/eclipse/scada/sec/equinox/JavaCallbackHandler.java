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
package org.eclipse.scada.sec.equinox;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.TextInputCallback;

import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.callback.PasswordCallback;
import org.eclipse.scada.sec.callback.TextCallback;
import org.eclipse.scada.sec.callback.UserNameCallback;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class JavaCallbackHandler implements CallbackHandler
{

    private final javax.security.auth.callback.CallbackHandler callbackHandler;

    public JavaCallbackHandler ( final javax.security.auth.callback.CallbackHandler callbackHandler )
    {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public NotifyFuture<Callback[]> performCallback ( final Callback[] callbacks )
    {
        final List<javax.security.auth.callback.Callback> javaCallbacks = new LinkedList<javax.security.auth.callback.Callback> ();

        final Map<javax.security.auth.callback.Callback, Callback> cbMap = new HashMap<javax.security.auth.callback.Callback, Callback> ();

        for ( final Callback cb : callbacks )
        {
            final javax.security.auth.callback.Callback jcb = convert ( cb );
            if ( jcb != null )
            {
                cbMap.put ( jcb, cb );
            }
        }

        try
        {
            this.callbackHandler.handle ( javaCallbacks.toArray ( new javax.security.auth.callback.Callback[javaCallbacks.size ()] ) );
            for ( final javax.security.auth.callback.Callback jcb : javaCallbacks )
            {
                final Callback cb = cbMap.get ( jcb );
                if ( cb == null )
                {
                    continue;
                }

                fillResultFromCallback ( cb, jcb );
            }
            return new InstantFuture<Callback[]> ( callbacks );
        }
        catch ( final Exception e )
        {
            for ( final Callback cb : callbacks )
            {
                cb.cancel ();
            }
            return new InstantFuture<Callback[]> ( callbacks );
        }
    }

    private void fillResultFromCallback ( final Callback cb, final javax.security.auth.callback.Callback jcb )
    {
        if ( cb instanceof TextCallback && jcb instanceof TextInputCallback )
        {
            ( (TextCallback)cb ).setValue ( ( (TextInputCallback)jcb ).getText () );
        }
        else if ( cb instanceof UserNameCallback && jcb instanceof NameCallback )
        {
            ( (UserNameCallback)cb ).setValue ( ( (NameCallback)jcb ).getName () );
        }
        else if ( cb instanceof PasswordCallback && jcb instanceof javax.security.auth.callback.PasswordCallback )
        {
            ( (PasswordCallback)cb ).setPassword ( String.valueOf ( ( (javax.security.auth.callback.PasswordCallback)jcb ).getPassword () ) );
        }
        else
        {
            cb.cancel ();
        }
    }

    private javax.security.auth.callback.Callback convert ( final Callback cb )
    {
        if ( cb instanceof UserNameCallback )
        {
            return new NameCallback ( ( (UserNameCallback)cb ).getLabel () );
        }
        else if ( cb instanceof TextCallback )
        {
            return new TextInputCallback ( ( (TextCallback)cb ).getLabel () );
        }
        if ( cb instanceof PasswordCallback )
        {
            return new javax.security.auth.callback.PasswordCallback ( ( (PasswordCallback)cb ).getLabel (), false );
        }
        return null;
    }
}
