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
package org.eclipse.scada.utils.progress;

public final class ProgressMonitors
{
    private ProgressMonitors ()
    {
    }

    /**
     * Return the provided monitor instance or a no-op default
     *
     * @param monitor
     *            a monitor instance or {@code null}
     * @return either the provided or monitor instance of
     *         {@link NullProgressMonitor#INSTANCE} if {@code monitor} was
     *         {@code null}. Never returns {@code null} itself.
     */
    public static ProgressMonitor orDefault ( final ProgressMonitor monitor )
    {
        if ( monitor != null )
        {
            return monitor;
        }

        return NullProgressMonitor.INSTANCE;
    }
}
