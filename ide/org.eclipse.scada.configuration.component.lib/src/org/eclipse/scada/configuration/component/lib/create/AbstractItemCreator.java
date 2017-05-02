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
package org.eclipse.scada.configuration.component.lib.create;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.configuration.component.lib.Activator;

public abstract class AbstractItemCreator implements ItemCreator
{
    @Override
    public void markUnsupported ()
    {
        createMarker ( new Status ( IStatus.INFO, Activator.PLUGIN_ID, "This generator does not support creating item information" ) );
    }
}
