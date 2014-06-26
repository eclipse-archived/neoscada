/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.tools.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;

public class CompoundManager
{

    private final Map<EditingDomain, CompoundHandler> handlers = new HashMap<EditingDomain, CompoundHandler> ();

    public CompoundManager ()
    {
    }

    public void append ( final EditingDomain domain, final Command command )
    {
        CompoundHandler handler = this.handlers.get ( domain );
        if ( handler == null )
        {
            handler = new CompoundHandler ( domain );
            this.handlers.put ( domain, handler );
        }
        handler.addCommand ( command );
    }

    public void executeAll ()
    {
        for ( final CompoundHandler handler : this.handlers.values () )
        {
            handler.execute ();
        }
        this.handlers.clear ();
    }
}
