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

/**
 * A progress monitor which does nothing
 * <p>
 * This can be used to prevent null checks on monitor variables
 * </p>
 * <p>
 * There is no need to create an instance of this class
 * {@link NullProgressMonitor#INSTANCE} can be used directly.
 * </p>
 *
 * @see ProgressMonitors#orDefault(ProgressMonitor)
 */
public class NullProgressMonitor implements ProgressMonitor
{
    public static final ProgressMonitor INSTANCE = new NullProgressMonitor ();

    private NullProgressMonitor ()
    {
    }

    @Override
    public void beginTask ( final String name, final int totalWork )
    {
    }

    @Override
    public void worked ( final int work )
    {
    }

    @Override
    public void done ()
    {
    }
}
