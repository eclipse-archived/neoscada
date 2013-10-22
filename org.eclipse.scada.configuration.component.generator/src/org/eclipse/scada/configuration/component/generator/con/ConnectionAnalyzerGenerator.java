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
package org.eclipse.scada.configuration.component.generator.con;

import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.generator.DataComponentGenerator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.component.lib.create.MasterListener;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.SourceItem;

public abstract class ConnectionAnalyzerGenerator extends DataComponentGenerator
{
    private static final String NAME_FORMAT_STATE = "org.eclipse.scada.%s.master.analyzer.connectionService.%s.state.state";

    private static final String NAME_FORMAT_CONNECTED = "org.eclipse.scada.%s.master.analyzer.connectionService.%s.state.connected";

    public ConnectionAnalyzerGenerator ( final DataComponent dataComponent )
    {
        super ( dataComponent );
    }

    private final class ConnectionMasterHandlerImpl implements MasterListener<SourceItem>
    {
        private final ConnectionProvider connectionProvider;

        private final String format;

        private ConnectionMasterHandlerImpl ( final String format, final ConnectionProvider connectionProvider )
        {
            this.format = format;
            this.connectionProvider = connectionProvider;
        }

        @Override
        public void setMaster ( final SourceItem item, final MasterServer master )
        {
            final Connection connection = this.connectionProvider.getConnection ( master );
            final String tag = connection.getTypeTag ();
            final String id = connection.getName ();
            item.setSourceName ( String.format ( this.format, tag, id ) );
        }
    }

    protected static interface ConnectionProvider
    {
        public Connection getConnection ( MasterServer master );
    }

    protected void createForConnection ( final ItemCreator creator, final ConnectionProvider connectionProvider )
    {

        {
            final CreationRequest<SourceItem> c = creator.createSelfItem ( null );
            c.localTags ( "CON" );
            c.dataType ( DataType.BOOLEAN );
            c.customizationTags ( "input" );
            c.addMasterListener ( new ConnectionMasterHandlerImpl ( NAME_FORMAT_CONNECTED, connectionProvider ) );
            c.create ();
        }
        {
            final CreationRequest<SourceItem> c = creator.createSelfItem ( null );
            c.localTags ( "STATE" );
            c.dataType ( DataType.STRING );
            c.customizationTags ( "input" );
            c.addMasterListener ( new ConnectionMasterHandlerImpl ( NAME_FORMAT_STATE, connectionProvider ) );
            c.create ();
        }
    }
}
