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
package org.eclipse.scada.da.ui.client.test.console;

import java.io.PrintStream;
import java.util.Date;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.core.client.ConnectionState;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.eclipse.scada.da.ui.client.test.Activator;
import org.eclipse.scada.da.ui.connection.data.AbstractItemHolder;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.ItemListenerHolder;
import org.eclipse.scada.da.ui.connection.data.ItemListenerHolder.HolderListener;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleListener;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.osgi.framework.FrameworkUtil;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

public class DataItemConsole
{
    private final Item item;

    private final IOConsole console;

    private final IConsoleListener consoleListener = new IConsoleListener () {

        @Override
        public void consolesRemoved ( final IConsole[] consoles )
        {
            for ( final IConsole console : consoles )
            {
                if ( console == DataItemConsole.this.console )
                {
                    dispose ();
                }
            }
        }

        @Override
        public void consolesAdded ( final IConsole[] consoles )
        {
            for ( final IConsole console : consoles )
            {
                if ( console == DataItemConsole.this.console )
                {
                    init ();
                }
            }
        }
    };

    private boolean running;

    private AbstractItemHolder holder;

    private final ItemUpdateListener itemListener = new ItemUpdateListener () {

        @Override
        public void notifySubscriptionChange ( final SubscriptionState subscriptionState, final Throwable subscriptionError )
        {
            processSubscriptionChange ( subscriptionState, subscriptionError );
        }

        @Override
        public void notifyDataChange ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
        {
            processDataChange ( value, attributes, cache );
        }
    };

    private final HolderListener holderListener = new HolderListener () {

        @Override
        public void connectionStateChange ( final Connection connection, final ConnectionState state, final Throwable error )
        {
            processConnectionStateChange ( connection, state, error );
        }

        @Override
        public void connectionChange ( final ConnectionService connection )
        {
            processConnectionChange ( connection );
        }
    };

    private IOConsoleOutputStream connectionStream;

    private IOConsoleOutputStream dataStream;

    private PrintStream connectionPrintStream;

    private PrintStream dataPrintStream;

    private CommandProcessorImpl processor;

    private final ItemTrace trace = new ItemTrace () {

        @Override
        public void stop ()
        {
            DataItemConsole.this.stop ();
        }
    };

    public DataItemConsole ( final Item item )
    {
        this.item = item;
        this.console = new ItemTraceIOConsole ( this.trace, item.toLabel (), "org.eclipse.scada.da.item.trace", Activator.getImageDescriptor ( "icons/16x16/item_trace.gif" ), "UTF-8", true );
        this.console.setWaterMarks ( 10_000, 100_000 );
        ConsolePlugin.getDefault ().getConsoleManager ().addConsoleListener ( this.consoleListener );
        this.running = true;
    }

    public IConsole getConsole ()
    {
        return this.console;
    }

    private static final DateFormat DF = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss.SSS" );

    protected void message ( final PrintStream stream, final String format, final Object... args )
    {
        message ( new Date (), stream, format, args );
    }

    protected void message ( final Date date, final PrintStream stream, final String format, final Object... args )
    {
        if ( stream == null )
        {
            return;
        }

        stream.print ( DF.format ( date ) + ": " );
        stream.printf ( format, args );
        stream.println ();
        stream.flush ();
    }

    protected void processConnectionChange ( final ConnectionService connection )
    {
        message ( this.connectionPrintStream, "Connection - %s", connection );
    }

    protected void processConnectionStateChange ( final Connection connection, final ConnectionState state, final Throwable error )
    {
        message ( this.connectionPrintStream, "Connection state - state: %s", state );
        if ( error != null )
        {
            error.printStackTrace ( this.connectionPrintStream );
        }
    }

    protected void processDataChange ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        final Date now = new Date ();

        message ( now, this.dataPrintStream, "Value change - value: %s, cache: %s, attributes: %s", value, cache, attributes );
        if ( attributes != null )
        {
            for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
            {
                message ( now, this.dataPrintStream, "\t%s -> %s", entry.getKey (), entry.getValue () );
            }
        }
    }

    protected void processSubscriptionChange ( final SubscriptionState subscriptionState, final Throwable subscriptionError )
    {
        message ( this.dataPrintStream, "Subscription state - %s", subscriptionState );
        if ( subscriptionError != null )
        {
            subscriptionError.printStackTrace ( this.dataPrintStream );
        }
    }

    protected void init ()
    {
        this.connectionStream = this.console.newOutputStream ();
        this.connectionPrintStream = new PrintStream ( this.connectionStream );

        this.dataStream = this.console.newOutputStream ();
        this.dataPrintStream = new PrintStream ( this.dataStream );

        this.processor = new CommandProcessorImpl ( this.item.toLabel (), this.console.getInputStream (), this.console.newOutputStream (), this.console.newOutputStream () );

        this.holder = new ItemListenerHolder ( FrameworkUtil.getBundle ( DataItemConsole.class ).getBundleContext (), this.item, this.itemListener, this.holderListener );

        createCommands ();
    }

    private void createCommands ()
    {
        final CommandHandler closeCommand = new CommandHandler () {

            @Override
            public void runCommand ( final CommandContext context ) throws Exception
            {
                removeConsole ();
            }
        };
        this.processor.addCommand ( "close", closeCommand );
        this.processor.addCommand ( "exit", closeCommand );

        this.processor.addCommand ( "stop", new CommandHandler () {

            @Override
            public void runCommand ( final CommandContext context ) throws Exception
            {
                stop ();
            }
        } );
    }

    protected void removeConsole ()
    {
        ConsolePlugin.getDefault ().getConsoleManager ().removeConsoles ( new IConsole[] { this.console } );
    }

    protected void dispose ()
    {
        stop ();

        if ( this.processor != null )
        {
            this.processor.dispose ();
            this.processor = null;
        }

        if ( this.connectionPrintStream != null )
        {
            this.connectionPrintStream.close ();
            this.connectionStream = null;
            this.connectionPrintStream = null;
        }
        if ( this.dataPrintStream != null )
        {
            this.dataPrintStream.close ();
            this.dataStream = null;
            this.dataPrintStream = null;
        }

        if ( this.running )
        {
            this.running = false;
            ConsolePlugin.getDefault ().getConsoleManager ().removeConsoleListener ( this.consoleListener );
        }
    }

    protected synchronized void stop ()
    {
        if ( this.holder != null )
        {
            this.holder.dispose ();
            this.holder = null;
        }
    }
}
