/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.handler.mail;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;

import org.eclipse.scada.ae.server.handler.EventHandler;
import org.eclipse.scada.ae.server.handler.EventHandlerFactory;
import org.eclipse.scada.base.pipe.PipeService;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailHandlerFactory implements EventHandlerFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( MailHandlerFactory.class );

    private PipeService pipeService;

    public MailHandlerFactory ()
    {
    }

    public void setPipeService ( final PipeService pipeService )
    {
        this.pipeService = pipeService;
    }

    public void unsetPipeService ()
    {
        this.pipeService = null;
    }

    @Override
    public EventHandler createHandler ( final Map<String, String> properties ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final List<InternetAddress> to = new LinkedList<InternetAddress> ();

        final String id = cfg.getStringNonEmptyChecked ( "queue.id", null );

        final String toStr = cfg.getString ( "to" );
        if ( toStr != null && !toStr.isEmpty () )
        {
            to.add ( new InternetAddress ( toStr ) );
        }
        for ( final String toStrEntry : cfg.getPrefixed ( "to." ).values () )
        {
            to.add ( new InternetAddress ( toStrEntry ) );
        }

        if ( to.isEmpty () )
        {
            throw new IllegalStateException ( "No recipients configured" );
        }

        final String fromString = cfg.getString ( "from" );
        InternetAddress from = null;
        if ( fromString != null && !fromString.isEmpty () )
        {
            from = new InternetAddress ( fromString );
        }

        final int retries = cfg.getInteger ( "retries", 60 );

        Authenticator auth = null;
        final String username = cfg.getString ( "username" );
        final String password = cfg.getString ( "password" );
        if ( username != null && password != null )
        {
            auth = new Authenticator () {
                @Override
                protected PasswordAuthentication getPasswordAuthentication ()
                {
                    return new PasswordAuthentication ( username, password );
                }
            };
        }

        final Properties props = cfg.getPrefixedProperties ( "session." );
        final Session session;
        if ( auth == null )
        {
            session = Session.getInstance ( props );
        }
        else
        {
            session = Session.getInstance ( props, auth );
        }

        if ( logger.isInfoEnabled () )
        {
            logger.info ( "Mail session properties: " );
            for ( final Map.Entry<Object, Object> entry : props.entrySet () )
            {
                logger.info ( "\t{} -> '{}'", entry.getKey (), entry.getValue () );
            }
        }

        final MailSender sender = new MailSender ( session, from, to.toArray ( new InternetAddress[0] ), password );

        return new MailEventHandler ( id, sender, this.pipeService, retries );
    }
}
