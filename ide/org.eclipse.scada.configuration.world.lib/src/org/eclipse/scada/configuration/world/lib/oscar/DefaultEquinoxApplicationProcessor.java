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
package org.eclipse.scada.configuration.world.lib.oscar;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.world.osgi.DefaultEquinoxApplication;

public class DefaultEquinoxApplicationProcessor extends EquinoxApplicationProcessor
{
    public DefaultEquinoxApplicationProcessor ( final DefaultEquinoxApplication app )
    {
        super ( app );
    }

    @Override
    protected void processForContext ( final OscarContext ctx, final IFolder output, final IProgressMonitor monitor ) throws Exception
    {
        // nothing in addition
    }
}
