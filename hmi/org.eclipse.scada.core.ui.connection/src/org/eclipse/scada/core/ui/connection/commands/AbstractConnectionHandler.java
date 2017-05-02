/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new Adapter and Selection Helper, cleanup
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.commands;

import java.util.Collection;

import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;

public abstract class AbstractConnectionHandler extends AbstractSelectionHandler
{
    protected Collection<ConnectionHolder> getConnections ()
    {
        return SelectionHelper.list ( getSelection (), ConnectionHolder.class );
    }

}