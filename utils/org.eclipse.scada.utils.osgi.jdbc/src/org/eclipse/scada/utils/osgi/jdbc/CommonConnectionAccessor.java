/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CommonConnectionAccessor implements ConnectionAccessor
{

    private final static Logger logger = LoggerFactory.getLogger ( CommonConnectionAccessor.class );

    /**
     * Get a new connection that must be closed by the caller
     * 
     * @return a new open connection
     * @throws SQLException
     *             if anything goes wrong
     */
    public abstract Connection getConnection () throws SQLException;

    @Override
    public <R> R doWithConnection ( final ConnectionTask<R> connectionTask )
    {
        try
        {
            final Connection connection = getConnection ();
            try
            {
                return connectionTask.performTask ( connection );
            }
            finally
            {
                if ( connection != null )
                {
                    try
                    {
                        connection.close ();
                    }
                    catch ( final SQLException e )
                    {
                        logger.warn ( "Failed to close connection", e );
                    }
                }
            }
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( e );
        }
    }

    @Override
    public void dispose ()
    {
    }

}
