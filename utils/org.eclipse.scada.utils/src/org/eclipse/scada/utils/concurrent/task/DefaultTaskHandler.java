/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.concurrent.task;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultTaskHandler implements TaskHandler
{

    private final static Logger logger = LoggerFactory.getLogger ( DefaultTaskHandler.class );

    private class HandleImpl implements Handle
    {
        private volatile Long id;

        private final DefaultTaskHandler handler;

        public HandleImpl ( final long id, final DefaultTaskHandler handler )
        {
            this.id = id;
            this.handler = handler;
        }

        @Override
        public Long getId ()
        {
            return this.id;
        }

        @Override
        protected void finalize () throws Throwable
        {
            this.handler.removeTask ( this.id );
            super.finalize ();
        }

        @Override
        public void dispose ()
        {
            this.handler.removeTask ( this.id );
            this.id = null;
        }
    }

    private final Map<Long, NotifyFuture<?>> taskMap = new HashMap<Long, NotifyFuture<?>> ();

    private final Random random = new Random ();

    protected long allocateId ( final NotifyFuture<?> task )
    {
        synchronized ( this.taskMap )
        {
            Long value = this.random.nextLong ();
            while ( this.taskMap.containsKey ( value ) )
            {
                value = this.random.nextLong ();
            }
            this.taskMap.put ( value, task );
            logger.debug ( "{} items are in the map", this.taskMap.size () );
            return value;
        }
    }

    @Override
    public Handle addTask ( final NotifyFuture<?> task )
    {
        return new HandleImpl ( allocateId ( task ), this );
    }

    @Override
    public boolean cancelTask ( final Long id )
    {
        if ( id == null )
        {
            return false;
        }

        final NotifyFuture<?> task;
        synchronized ( this )
        {
            task = this.taskMap.get ( id );
        }
        if ( task != null )
        {
            task.cancel ( true );
            return true;
        }
        return false;
    }

    @Override
    public void dispose ()
    {
        synchronized ( this.taskMap )
        {
            for ( final Map.Entry<Long, NotifyFuture<?>> entry : this.taskMap.entrySet () )
            {
                entry.getValue ().cancel ( true );
            }
            this.taskMap.clear ();
        }
    }

    @Override
    public boolean removeTask ( final Long id )
    {
        if ( id == null )
        {
            return false;
        }

        synchronized ( this.taskMap )
        {
            logger.debug ( "{} items are in the map", this.taskMap.size () );
            return this.taskMap.remove ( id ) != null;
        }
    }

}
