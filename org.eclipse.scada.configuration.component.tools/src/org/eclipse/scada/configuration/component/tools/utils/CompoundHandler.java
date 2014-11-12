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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

public class CompoundHandler
{
    private final EditingDomain domain;

    private final CompoundCommand command;

    public CompoundHandler ( final EditingDomain domain )
    {
        this.domain = domain;
        this.command = new CompoundCommand () {
            @Override
            public Collection<?> getAffectedObjects ()
            {
                // we do this in order to prevent the "Add" command to jump "somewhere"
                return Collections.EMPTY_LIST;
            }
        };
    }

    public void execute ()
    {
        this.domain.getCommandStack ().execute ( this.command );
    }

    public void addCommand ( final Command command )
    {
        this.command.append ( command );
    }

}
