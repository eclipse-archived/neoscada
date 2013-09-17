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
package org.eclipse.scada.sec.authn;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.PasswordCallback;
import org.eclipse.scada.sec.callback.UserNameCallback;
import org.eclipse.scada.sec.utils.password.PasswordEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 * @author Jens Reimann
 */
public class CredentialsRequest
{

    private final static Logger logger = LoggerFactory.getLogger ( CredentialsRequest.class );

    private static final int ORDER_USERNAME = 100;

    private static final int ORDER_PASSWORD = 200;

    private static final Object TAG_USERNAME = new Object ();

    private static final Object TAG_PASSWORD = new Object ();

    private final Map<Object, Callback> callbackMap = new HashMap<Object, Callback> ();

    private final Locale locale;

    private final ResourceBundle bundle;

    private final List<List<PasswordEncoding>> passwordEncodings = new LinkedList<List<PasswordEncoding>> ();

    public CredentialsRequest ()
    {
        this ( null );
    }

    public CredentialsRequest ( final Locale locale )
    {
        this.locale = locale == null ? Locale.getDefault () : locale;
        this.bundle = ResourceBundle.getBundle ( "org/eclipse/scada/sec/authn/request", this.locale );
    }

    protected String getText ( final String textId, final Locale locale )
    {
        return this.bundle.getString ( textId );
    }

    public void askUsername ()
    {
        logger.debug ( "Ask for username" );
        if ( !this.callbackMap.containsKey ( CredentialsRequest.TAG_USERNAME ) )
        {
            logger.debug ( "Add username callback" );
            this.callbackMap.put ( CredentialsRequest.TAG_USERNAME, new UserNameCallback ( getText ( "username", this.locale ), ORDER_USERNAME ) );
        }
    }

    public void askPassword ( final PasswordEncoding type )
    {
        askPassword ( Collections.singletonList ( type ) );
    }

    public void askPassword ( final List<PasswordEncoding> types )
    {
        logger.debug ( "Asking for password: {}", types );

        if ( !this.callbackMap.containsKey ( CredentialsRequest.TAG_PASSWORD ) )
        {
            logger.debug ( "Add password callback" );
            this.callbackMap.put ( CredentialsRequest.TAG_PASSWORD, new PasswordCallback ( getText ( "password", this.locale ), ORDER_PASSWORD ) );
        }

        this.passwordEncodings.add ( types );
    }

    public Callback[] buildCallbacks ()
    {
        logger.debug ( "Building callbacks for: {}", this );

        final Callback[] result = this.callbackMap.values ().toArray ( new Callback[this.callbackMap.size ()] );
        Arrays.sort ( result, Callback.ORDER_COMPARATOR );

        for ( final Callback cb : result )
        {
            if ( cb instanceof PasswordCallback )
            {
                fillPasswordTypes ( (PasswordCallback)cb );
            }
        }

        return result;
    }

    private void fillPasswordTypes ( final PasswordCallback cb )
    {
        cb.setRequestedTypes ( this.passwordEncodings );
    }

    public Callback getCallback ( final Object tag )
    {
        return this.callbackMap.get ( tag );
    }

    @SuppressWarnings ( "unchecked" )
    public <T> T getTypedCallback ( final Object tag, final Class<T> clazz )
    {
        final Callback cb = getCallback ( tag );
        if ( cb != null && !clazz.isInstance ( cb ) )
        {
            return null;
        }
        else
        {
            return (T)cb;
        }
    }

    public UserNameCallback getUserNameCallback ()
    {
        return getTypedCallback ( CredentialsRequest.TAG_USERNAME, UserNameCallback.class );
    }

    public PasswordCallback getPasswordCallback ()
    {
        return getTypedCallback ( CredentialsRequest.TAG_PASSWORD, PasswordCallback.class );
    }

    public String getUserName ()
    {
        final UserNameCallback cb = getUserNameCallback ();
        if ( cb == null )
        {
            return null;
        }
        else
        {
            return cb.getValue ();
        }
    }

    public Map<PasswordEncoding, String> getPasswords ()
    {
        final PasswordCallback cb = getPasswordCallback ();
        if ( cb == null )
        {
            return null;
        }
        else
        {
            return cb.getPasswords ();
        }
    }

    public String getPassword ( final PasswordEncoding type )
    {
        final Map<PasswordEncoding, String> passwords = getPasswords ();
        if ( passwords == null )
        {
            return null;
        }
        else
        {
            return passwords.get ( type );
        }
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( "[CredentialsRequest - " );
        for ( final Map.Entry<Object, Callback> entry : this.callbackMap.entrySet () )
        {
            sb.append ( "\n" );
            sb.append ( "[" );
            sb.append ( entry.getKey () );
            sb.append ( " = " );
            sb.append ( entry.getValue () );
            sb.append ( "]" );
        }
        sb.append ( "]" );

        return sb.toString ();
    }
}
