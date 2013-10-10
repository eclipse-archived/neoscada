/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.chain.WriteHandler;
import org.eclipse.scada.da.server.common.chain.WriteHandlerItem;
import org.eclipse.scada.da.server.common.item.factory.DefaultChainItemFactory;
import org.eclipse.scada.da.server.common.item.factory.FolderItemFactory;
import org.eclipse.scada.utils.lang.Immutable;
import org.eclipse.scada.utils.sql.SqlHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Update
{
    private final static Logger logger = LoggerFactory.getLogger ( Update.class );

    private final String id;

    private final String sql;

    private FolderItemFactory itemFactory;

    private final Connection connection;

    private WriteHandlerItem item;

    @Immutable
    public static class Mapping
    {
        private final String attributes;

        private final String namedParameter;

        /**
         * The constructor that maps the main value to a named parameter
         * 
         * @param namedParameter
         *            the name of the SQL parameter
         */
        public Mapping ( final String namedParameter )
        {
            this.attributes = null;
            this.namedParameter = namedParameter;
        }

        /**
         * A mapping that maps the specified attribute name to the
         * provided named parameter.
         * <p>
         * Note that if the attribute is <code>null</code> then is defines the
         * main value instead.
         * </p>
         * 
         * @param attribute
         *            the name of the attribute
         * @param namedParameter
         *            the name of the SQL parameter
         */
        public Mapping ( final String attribute, final String namedParameter )
        {
            this.attributes = attribute;
            this.namedParameter = namedParameter;
        }

        public String getAttributes ()
        {
            return this.attributes;
        }

        public String getNamedParameter ()
        {
            return this.namedParameter;
        }
    }

    private final Collection<Mapping> mappings = new LinkedList<Mapping> ();

    public Update ( final String id, final String sql, final Connection connection )
    {
        this.id = id;
        this.sql = sql;
        this.connection = connection;
    }

    public void register ( final DefaultChainItemFactory parentItemFactory )
    {
        this.itemFactory = parentItemFactory.createSubFolderFactory ( this.id );
        this.item = this.itemFactory.createInputOutput ( "START", null, new WriteHandler () {

            @Override
            public void handleWrite ( final Variant value, final OperationParameters operationParameters ) throws Exception
            {
                performUpdate ( value, operationParameters );
            }
        } );
    }

    protected void performUpdate ( final Variant value, final OperationParameters operationParameters )
    {
        try
        {
            final int result = doUpdate ( value );
            this.item.updateData ( Variant.valueOf ( result ), new HashMap<String, Variant> (), AttributeMode.SET );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to perform update", e );
            final Map<String, Variant> attributes = new HashMap<String, Variant> ();
            attributes.put ( "sql.error", Variant.TRUE );
            attributes.put ( "sql.error.message", Variant.valueOf ( e.getMessage () ) );
            this.item.updateData ( Variant.NULL, attributes, AttributeMode.SET );
        }
    }

    private int doUpdate ( final Variant value ) throws Exception
    {
        try (final java.sql.Connection connection = this.connection.createConnection ())
        {
            connection.setAutoCommit ( true );

            // create parameter map
            final Map<String, Object> parameters = new HashMap<String, Object> ();
            for ( final Mapping mapping : this.mappings )
            {
                if ( mapping.getAttributes () == null )
                {
                    parameters.put ( mapping.getNamedParameter (), value.getValue () );
                }
            }

            // convert to positional version
            final Map<String, List<Integer>> posMap = new HashMap<String, List<Integer>> ();
            final String positionalSql = SqlHelper.convertSql ( this.sql, posMap );
            final Object[] positionalParameters = SqlHelper.expandParameters ( posMap, parameters );

            try (final PreparedStatement stmt = connection.prepareStatement ( positionalSql ))
            {
                applyParameters ( stmt, positionalParameters );
                return stmt.executeUpdate ();
            }
        }
    }

    private void applyParameters ( final PreparedStatement stmt, final Object... parameters ) throws SQLException
    {
        if ( parameters != null )
        {
            for ( int i = 0; i < parameters.length; i++ )
            {
                logger.trace ( "Set parameter #{} - {}", i + 1, parameters[i] );
                stmt.setObject ( i + 1, parameters[i] );
            }
        }
    }

    public void unregister ()
    {
        this.itemFactory.dispose ();
        this.itemFactory = null;
    }

    /**
     * Add a mapping.
     * <p>
     * Note that the mappings are not unique and adding multiple mappings for
     * the same attribute is not allowed and will result in an undefined
     * behavior.
     * </p>
     * 
     * @param mapping
     *            the mapping to add
     */
    public void addMapping ( final Mapping mapping )
    {
        this.mappings.add ( mapping );
    }

}
