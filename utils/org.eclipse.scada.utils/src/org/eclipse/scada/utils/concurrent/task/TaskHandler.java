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

import org.eclipse.scada.utils.concurrent.NotifyFuture;

/**
 * A task handler which aids in creating task IDs for Future tasks
 * <p>
 * The task handler will hold a unique 64bit integer id for each registered
 * task. The task handle is the reference to this id. When it is finalized the
 * ID will be handed back to the pool and can be reassigned. This finalization
 * must be transparent to the user.
 * </p>
 * 
 * @author Jens Reimann
 */
public interface TaskHandler
{
    /**
     * A task handle which will hold a reference to the assigned task id
     * 
     * @author Jens Reimann
     */
    public interface Handle
    {
        /**
         * Get the Id unless the instance is disposed.
         * 
         * @return The task id or <code>null</code> if the instance is already
         *         disposed.
         */
        public Long getId ();

        /**
         * Will deallocate the ID immediately.
         * Calling {@link #dispose()} on an already disposed instance has no
         * effect.
         */
        public void dispose ();
    }

    public Handle addTask ( NotifyFuture<?> future );

    public boolean removeTask ( Long id );

    public boolean cancelTask ( Long id );

    /**
     * Dispose and cancel all tasks
     */
    public void dispose ();
}
