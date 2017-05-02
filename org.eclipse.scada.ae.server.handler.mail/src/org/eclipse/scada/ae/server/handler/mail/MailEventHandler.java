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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.server.handler.EventHandler;
import org.eclipse.scada.ae.server.handler.InjectionContext;
import org.eclipse.scada.base.pipe.PipeService;
import org.eclipse.scada.base.pipe.Producer;
import org.eclipse.scada.base.pipe.Worker;
import org.eclipse.scada.base.pipe.WorkerHandle;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.utils.osgi.BundleObjectInputStream;
import org.eclipse.scada.utils.str.Tables;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailEventHandler implements EventHandler
{

    private final static Logger logger = LoggerFactory.getLogger ( MailEventHandler.class );

    private Producer producer;

    private final Worker mailWorker = new Worker () {

        @Override
        public void work ( final byte[] data )
        {
            handleWork ( data );
        }
    };

    private WorkerHandle workerHandle;

    private final Bundle bundle;

    private MailSender sender;

    private final int maxSubjectLength = 64;

    private final int retries;

    public MailEventHandler ( final String id, final MailSender sender, final PipeService pipeService, final int retries ) throws Exception
    {
        this.bundle = FrameworkUtil.getBundle ( MailHandlerFactory.class );
        this.sender = sender;
        this.retries = retries;

        final String pipeName = "mail." + id;

        try
        {
            this.producer = pipeService.createProducer ( pipeName );
            this.workerHandle = pipeService.createWorker ( pipeName, this.mailWorker );
        }
        catch ( final Exception e )
        {
            if ( this.sender != null )
            {
                this.sender.dispose ();
                this.sender = null;
            }
        }
    }

    @Override
    public Event handleEvent ( final Event event, final InjectionContext context )
    {
        try
        {
            final ByteArrayOutputStream bos = new ByteArrayOutputStream ();
            final ObjectOutputStream os = new ObjectOutputStream ( bos );

            os.writeObject ( makeRequest ( event ) );
            os.close ();

            this.producer.publish ( bos.toByteArray (), this.retries );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to process event", e );
        }
        return event;
    }

    private MailRequest makeRequest ( final Event event ) throws IOException
    {
        final StringWriter sw = new StringWriter ();
        final PrintWriter pw = new PrintWriter ( sw );

        final Variant message = event.getAttributes ().get ( Event.Fields.MESSAGE.getName () );
        String mainMessage = null;
        if ( message != null && message.isString () )
        {
            mainMessage = message.asString ( null );
            pw.println ( message.asString ( "" ) );
            pw.println ();
        }

        final List<String> keys = new ArrayList<> ( event.getAttributes ().keySet () );
        Collections.sort ( keys );
        final List<List<String>> rows = new LinkedList<> ();
        for ( final String key : keys )
        {
            final List<String> row = new LinkedList<> ();
            row.add ( key );
            row.add ( "" + event.getAttributes ().get ( key ) );
            rows.add ( row );
        }

        Tables.showTable ( pw, Arrays.asList ( "Key", "Value" ), rows, 1 );

        pw.close ();

        String subject;
        if ( mainMessage != null )
        {
            subject = String.format ( "Event message: %s", message );
            if ( this.maxSubjectLength > 0 && subject.length () > this.maxSubjectLength )
            {
                subject = subject.substring ( 0, this.maxSubjectLength ) + "...";
            }
        }
        else
        {
            subject = String.format ( "Event message" );
        }

        final MailRequest request = new MailRequest ( "Event message", sw.toString () );
        return request;
    }

    @Override
    public void dispose ()
    {
        logger.info ( "Disposing" );

        if ( this.workerHandle != null )
        {
            this.workerHandle.close ();
            this.workerHandle = null;
        }
        if ( this.sender != null )
        {
            this.sender.dispose ();
            this.sender = null;
        }
    }

    protected void handleWork ( final byte[] data )
    {
        final Object o;

        try
        {
            try ( BundleObjectInputStream is = new BundleObjectInputStream ( new ByteArrayInputStream ( data ), this.bundle ) )
            {
                o = is.readObject ();
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to decode worker request", e );
            return;
        }

        if ( o instanceof MailRequest )
        {
            try
            {
                processWork ( (MailRequest)o );
            }
            catch ( final Exception e )
            {
                throw new RuntimeException ( e );
            }
        }
    }

    private void processWork ( final MailRequest request ) throws Exception
    {
        this.sender.send ( request.getSubject (), request.getText () );
    }

}
