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
package org.eclipse.scada.configuration.driver.jdbc.lib;

import java.math.BigInteger;

import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.driver.jdbc.UpdateCommand;
import org.eclipse.scada.configuration.driver.jdbc.UpdateMapping;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.da.server.jdbc.configuration.ConfigurationFactory;
import org.eclipse.scada.da.server.jdbc.configuration.ConnectionType;
import org.eclipse.scada.da.server.jdbc.configuration.UpdateMappingType;
import org.eclipse.scada.da.server.jdbc.configuration.UpdateType;

public class UpdateCommandGenerator extends QueryGenerator<UpdateCommand>
{
    final UpdateCommand updateCommand;

    public UpdateCommandGenerator ( final UpdateCommand updateCommand )
    {
        super ( updateCommand );
        this.updateCommand = updateCommand;
    }

    @Override
    public void generate ( final GenerationContext context )
    {
        super.generate ( context );
        generateDriver ();
    }

    private void generateDriver ()
    {
        final ConnectionType con = findConnection ( this.updateCommand.getDatabase () );

        final UpdateType up = ConfigurationFactory.eINSTANCE.createUpdateType ();

        up.setId ( this.updateCommand.getName () );
        up.setSql ( this.updateCommand.getSql () );
        if ( this.updateCommand.getQueryTimeout () != null )
        {
            up.setTimeout ( BigInteger.valueOf ( this.updateCommand.getQueryTimeout () ) );
        }

        for ( final UpdateMapping m : this.updateCommand.getMappings () )
        {
            final UpdateMappingType umt = ConfigurationFactory.eINSTANCE.createUpdateMappingType ();
            umt.setNamedParameter ( m.getNamedParameter () );
            up.getMapping ().add ( umt );
        }

        con.getUpdate ().add ( up );
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        final CreationRequest<SourceItem> item = itemCreator.createSourceItem ( this.updateCommand.getRunsOn (), makeUpdateName ( this.updateCommand.getName () ) );
        item.addCustomizationTags ( this.updateCommand.getCustomizationTags () );
        item.dataType ( this.updateCommand.getDataType () );
        item.localTags ( this.updateCommand.getName () );
        item.create ();
    }
}
