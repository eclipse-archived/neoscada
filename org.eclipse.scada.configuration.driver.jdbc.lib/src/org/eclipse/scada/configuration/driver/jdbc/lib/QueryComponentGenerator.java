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
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.driver.jdbc.ColumnMapping;
import org.eclipse.scada.configuration.driver.jdbc.QueryComponent;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.da.server.jdbc.configuration.ColumnMappingType;
import org.eclipse.scada.da.server.jdbc.configuration.ConfigurationFactory;
import org.eclipse.scada.da.server.jdbc.configuration.ConnectionType;
import org.eclipse.scada.da.server.jdbc.configuration.QueryType;

public class QueryComponentGenerator extends QueryGenerator<QueryComponent>
{
    final QueryComponent query;

    public QueryComponentGenerator ( final QueryComponent query )
    {
        super ( query );
        this.query = query;
    }

    @Override
    public void generate ( final GenerationContext context )
    {
        super.generate ( context );
        generateDriver ();
    }

    private void generateDriver ()
    {
        final ConnectionType con = findConnection ( this.query.getDatabase () );

        final QueryType q = ConfigurationFactory.eINSTANCE.createQueryType ();
        q.setId ( this.query.getName () );
        q.setPeriod ( this.query.getPeriod () );
        q.setSql ( this.query.getSql () );

        if ( this.query.getQueryTimeout () != null )
        {
            q.setTimeout ( BigInteger.valueOf ( this.query.getQueryTimeout () ) );
        }

        for ( final ColumnMapping m : this.query.getMappings () )
        {
            final ColumnMappingType cmt = ConfigurationFactory.eINSTANCE.createColumnMappingType ();
            cmt.setColumnNumber ( m.getColumnNumber () );
            cmt.setAliasName ( m.getName () );
            q.getColumnMapping ().add ( cmt );
        }

        con.getQuery ().add ( q );
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        for ( final ColumnMapping m : this.query.getMappings () )
        {
            final CreationRequest<SourceItem> item = itemCreator.createSourceItem ( this.query.getRunsOn (), makeQueryColumnName ( this.query.getName (), m.getName () ) );
            item.addCustomizationTags ( makeCustomizationTags ( m.getCustomizationTags () ) );
            item.dataType ( makeDataType ( m.getDataType () ) );
            item.localTags ( m.getName () );
            item.create ();
        }
    }

    private DataType makeDataType ( final DataType dataType )
    {
        if ( dataType == null || dataType.equals ( DataType.NULL ) )
        {
            return this.query.getDefaultDataType ();
        }
        return dataType;
    }

    private Collection<String> makeCustomizationTags ( final EList<String> customizationTags )
    {
        if ( customizationTags == null || customizationTags.isEmpty () )
        {
            return customizationTags;
        }
        else
        {
            return this.query.getDefaultCustomizationTags ();
        }
    }
}
