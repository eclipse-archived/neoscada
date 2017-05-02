/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.exec.command;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.exec.Hive;

public class CommandQueueImpl implements CommandQueue
{

    private static class Entry
    {
        private final SingleCommand command;

        private final int period;

        private long lastTimestamp;

        public Entry ( final SingleCommand command, final int period )
        {
            this.command = command;
            this.period = period;
        }

        public SingleCommand getCommand ()
        {
            return this.command;
        }

        public boolean canExecute ()
        {
            return System.currentTimeMillis () - this.lastTimestamp >= this.period;
        }

        public void execute ()
        {
            this.lastTimestamp = System.currentTimeMillis ();
            this.command.execute ();
        }
    }

    @SuppressWarnings ( "unused" )
    private final String id;

    @SuppressWarnings ( "unused" )
    private final Hive hive;

    private final Collection<Entry> commands = new CopyOnWriteArrayList<Entry> ();

    private Timer timer;

    private final int loopDelay;

    public CommandQueueImpl ( final Hive hive, final String id, final int loopDelay )
    {
        this.hive = hive;
        this.id = id;
        this.loopDelay = loopDelay;
    }

    @Override
    public void addCommand ( final SingleCommand command, final int period )
    {
        this.commands.add ( new Entry ( command, period ) );
    }

    @Override
    public void removeCommand ( final SingleCommand command )
    {
        for ( final Iterator<Entry> i = this.commands.iterator (); i.hasNext (); )
        {
            final Entry entry = i.next ();
            if ( entry.getCommand () == command )
            {
                i.remove ();
                return;
            }
        }
    }

    @Override
    public void start ( final Hive hive, final FolderCommon baseFolder )
    {
        for ( final Entry entry : this.commands )
        {
            entry.getCommand ().register ( hive, baseFolder );
        }

        this.timer = new Timer ( true );
        this.timer.scheduleAtFixedRate ( new TimerTask () {

            @Override
            public void run ()
            {
                runOnce ();
            }
        }, new Date (), this.loopDelay );

    }

    @Override
    public void stop ()
    {
        if ( this.timer != null )
        {
            this.timer.cancel ();
            this.timer = null;
        }

        for ( final Entry entry : this.commands )
        {
            entry.getCommand ().unregister ();
        }
    }

    protected void runOnce ()
    {
        for ( final Entry entry : this.commands )
        {
            if ( entry.canExecute () )
            {
                entry.execute ();
            }
        }
    }

}
