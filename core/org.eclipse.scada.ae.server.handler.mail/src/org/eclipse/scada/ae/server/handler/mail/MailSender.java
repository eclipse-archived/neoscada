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

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender
{

    private final static Logger logger = LoggerFactory.getLogger ( MailSender.class );

    private final Session session;

    private final Address from;

    private final Address[] to;

    public MailSender ( final Session session, final Address from, final Address[] to, final String password ) throws NoSuchProviderException
    {
        this.session = session;
        this.from = from;
        this.to = to;
    }

    public void dispose ()
    {
    }

    public void send ( final String subject, final String text ) throws MessagingException
    {
        final Message message = new MimeMessage ( this.session );

        if ( this.from != null )
        {
            message.setFrom ( this.from );
        }
        else
        {
            message.setFrom ();
        }

        message.setHeader ( "Return-Path", "<>" );

        message.setRecipients ( javax.mail.Message.RecipientType.TO, this.to );
        message.setSubject ( subject );
        message.setText ( text );

        message.saveChanges ();

        final Transport transport = this.session.getTransport ();
        logger.debug ( "Connecting transport..." );
        transport.connect ();
        logger.debug ( "Connecting transport... done!" );
        try
        {
            logger.debug ( "Sending message..." );
            transport.sendMessage ( message, message.getAllRecipients () );
            logger.debug ( "Sending message... done!" );
        }
        finally
        {
            logger.debug ( "Closing transport..." );
            try
            {
                transport.close ();
                logger.debug ( "Closing transport... done!" );
            }
            catch ( final Exception e )
            {
                logger.info ( "Failed to close transport", e );
            }
        }
    }
}
