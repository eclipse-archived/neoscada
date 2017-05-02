/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.ui;

import org.eclipse.core.runtime.CoreException;

public interface ServerLifecycle
{
    public static final String PROP_RUNNING = "running";

    public static final String PROP_ERROR = "error";

    public void stop () throws CoreException;

    public void start () throws CoreException;

    public boolean isRunning ();

    public Throwable getError ();
}
