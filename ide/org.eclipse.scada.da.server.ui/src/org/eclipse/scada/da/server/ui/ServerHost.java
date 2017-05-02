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

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.da.server.exporter.DocumentRoot;

public interface ServerHost
{
    public Collection<? extends ServerDescriptor> startServer ( String exporterFileUri ) throws CoreException;

    public Collection<? extends ServerDescriptor> startServer ( IFile exporterFile ) throws CoreException;

    public Collection<? extends ServerDescriptor> startServer ( URI exporterFileUri ) throws CoreException;

    public Collection<? extends ServerDescriptor> startServer ( DocumentRoot exporterRoot, String locationLabel ) throws CoreException;
}
