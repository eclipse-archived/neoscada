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
 *     IBH SYSTEMS GmbH - fix some issues
 *******************************************************************************/
package org.eclipse.scada.da.server.common.memory;

public class RequestBlockConfigurator implements VariableListener
{
    private final AbstractRequestBlock block;

    private final String type;

    public RequestBlockConfigurator ( final AbstractRequestBlock block, final String type )
    {
        this.block = block;
        this.type = type;
    }

    public void start ()
    {
        Activator.getVariableManager ().addVariableListener ( this.type, this );
    }

    public void stop ()
    {
        Activator.getVariableManager ().removeVariableListener ( this.type, this );
    }

    @Override
    public void variableConfigurationChanged ( final Variable[] variables )
    {
        this.block.setVariables ( variables );
    }
}
