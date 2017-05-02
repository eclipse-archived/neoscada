/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.utils.progress;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.utils.progress.ProgressMonitor;

public class ProgressAdapter implements ProgressMonitor
{
    private final IProgressMonitor monitor;

    public ProgressAdapter ( final IProgressMonitor monitor )
    {
        this.monitor = monitor;
    }

    @Override
    public void beginTask ( final String name, final int totalWork )
    {
        this.monitor.beginTask ( name, totalWork );
    }

    @Override
    public void worked ( final int work )
    {
        this.monitor.worked ( work );
    }

    @Override
    public void done ()
    {
        this.monitor.done ();
    }

    /**
     * Wraps an {@link IProgressMonitor} into a {@link ProgressAdapter} which
     * implements {@link ProgressMonitor}
     *
     * @param monitor
     *            the monitor to wrap
     * @return the wrapped monitor or <code>null</code> if the input was
     *         <code>null</code>
     */
    public static ProgressMonitor wrap ( final IProgressMonitor monitor )
    {
        if ( monitor == null )
        {
            return null;
        }
        return new ProgressAdapter ( monitor );
    }
}
