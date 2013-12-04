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
package org.eclipse.scada.configuration.world.lib;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;

public interface NodeElementProcessor
{
    /**
     * Process a node
     * <p>
     * A processor should only do stuff it is supposed to do for the phase that
     * is is called. If the phase is <code>null</code> it should do all its
     * stuff at the same time.
     * </p>
     * 
     * @param phase
     *            the phase the processor should handle, or <code>null</code>
     * @param baseDir
     *            the base directory for output
     * @param monitor
     *            the monitor
     * @throws Exception
     *             if anything goes wrong
     */
    public void process ( String phase, IFolder baseDir, IProgressMonitor monitor ) throws Exception;
}
