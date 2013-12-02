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
package org.eclipse.scada.configuration.generator.world;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;

public interface NodeElementProcessor
{
    public void process ( IFolder baseDir, IProgressMonitor monitor ) throws Exception;
}
