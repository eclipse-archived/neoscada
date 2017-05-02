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

package org.eclipse.scada.configuration.world.lib.validator.handler;

import java.util.Map;

import org.eclipse.scada.configuration.world.lib.validator.DataSourceDescriptor;

public class FormulaHandler extends MultiSourceAttributeHandler
{

    public FormulaHandler ()
    {
        super ( "datasource." );
    }

    @Override
    protected DataSourceDescriptor createNode ( final String configurationId, final Map<String, String> parameters )
    {
        final DataSourceDescriptor node = super.createNode ( configurationId, parameters );

        if ( parameters.containsKey ( "outputDatasource.id" ) )
        {
            node.addReference ( "datasource", parameters.get ( "outputDatasource.id" ) );
        }

        return node;
    }

}
