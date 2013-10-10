/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.dave;

import org.eclipse.scada.da.server.common.memory.Activator;
import org.eclipse.scada.da.server.common.memory.Variable;
import org.eclipse.scada.da.server.common.memory.VariableListener;

public class DaveRequestBlockConfigurator implements VariableListener
{
    private final DaveRequestBlock block;

    private final String type;

    public DaveRequestBlockConfigurator ( final DaveRequestBlock block, final String type )
    {
        this.block = block;
        this.type = type;

        Activator.getVariableManager ().addVariableListener ( type, this );
    }

    public void dispose ()
    {
        Activator.getVariableManager ().removeVariableListener ( this.type, this );
    }

    @Override
    public void variableConfigurationChanged ( final Variable[] variables )
    {
        this.block.setVariables ( variables );
    }
}
