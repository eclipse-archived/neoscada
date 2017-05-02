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

import java.util.Map;
import java.util.Properties;

import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A callback handler which will act on the provided properties
 * 
 * @since 1.1
 * @author Jens Reimann
 */
public class PropertiesCredentialsCallback implements CallbackHandler
{

    private static final String PROP_USER = "user";

    private static final String PROP_PASSWORD = "password";

    private final static Logger logger = LoggerFactory.getLogger ( PropertiesCredentialsCallback.class );

    private final Properties props;

    public PropertiesCredentialsCallback ( final String username, final String password )
    {
        this.props = new Properties ();
        this.props.put ( PROP_USER, username );
        this.props.put ( PROP_PASSWORD, password );
    }

    public PropertiesCredentialsCallback ( final Properties props )
    {
        this.props = props;
    }

    public PropertiesCredentialsCallback ( final Map<String, String> properties )
    {
        this.props = new Properties ();
        this.props.putAll ( properties );
    }

    @Override
    public NotifyFuture<Callback[]> performCallback ( final Callback[] callbacks )
    {
        logger.debug ( "Processing callbacks based on properties" );

        for ( final Callback cb : callbacks )
        {
            logger.debug ( "Processing callback: {}", cb );

            if ( cb instanceof PasswordCallback && this.props.containsKey ( PROP_PASSWORD ) )
            {
                logger.debug ( "Answering password: ***" );
                ( (PasswordCallback)cb ).setPassword ( this.props.getProperty ( PROP_PASSWORD ) );
            }
            else if ( cb instanceof UserNameCallback && this.props.containsKey ( PROP_USER ) )
            {
                logger.debug ( "Answering user: {}", this.props.getProperty ( PROP_USER ) );
                ( (UserNameCallback)cb ).setValue ( this.props.getProperty ( PROP_USER ) );
            }
            else
            {
                logger.debug ( "Cancel callback" );
                cb.cancel ();
            }
        }

        return new InstantFuture<Callback[]> ( callbacks );
    }
}
