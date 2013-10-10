/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - refactored for generic memory driver approach
 *******************************************************************************/
package org.eclipse.scada.da.server.common.memory;

import org.eclipse.scada.da.server.common.memory.Activator;
import org.eclipse.scada.da.server.common.memory.Variable;
import org.eclipse.scada.da.server.common.memory.VariableListener;

public class RequestBlockConfigurator implements VariableListener
{
    private final AbstractRequestBlock block;

    private final String type;

    public RequestBlockConfigurator ( final AbstractRequestBlock block, final String type )
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
