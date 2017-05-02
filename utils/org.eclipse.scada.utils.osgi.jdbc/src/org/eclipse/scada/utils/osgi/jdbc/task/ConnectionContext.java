/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jürgen Rose - further development
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc.task;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.utils.osgi.jdbc.data.RowMapper;

public interface ConnectionContext
{
    public Connection getConnection ();

    public void setAutoCommit ( boolean autoCommit ) throws SQLException;

    public void commit () throws SQLException;

    public void rollback () throws SQLException;

    public <T> List<T> queryForList ( Class<T> clazz, String sql, Object... parameters ) throws SQLException;

    public <T> List<T> queryForList ( Class<T> clazz, String sql, Map<String, Object> parameters ) throws SQLException;

    public void query ( ResultSetProcessor resultSetProcessor, String sql, Object... parameters ) throws SQLException;

    public void query ( ResultSetProcessor resultSetProcessor, String sql, Map<String, Object> parameters ) throws SQLException;

    public int update ( String sql, Object... parameters ) throws SQLException;

    public int update ( String sql, Map<String, Object> parameters ) throws SQLException;

    public void query ( RowCallback callback, String sql, Object... parameters ) throws SQLException;

    public void query ( RowCallback callback, String sql, Map<String, Object> parameters ) throws SQLException;

    public <T> List<T> query ( RowMapper<T> rowMapper, String sql, Object... parameters ) throws SQLException;

    public <T> List<T> query ( RowMapper<T> rowMapper, String sql, Map<String, Object> parameters ) throws SQLException;

    public <T> T queryForObject ( RowMapper<T> rowMapper, String sql, Object... parameters ) throws SQLException;

    public <T> T queryForObject ( RowMapper<T> rowMapper, String sql, Map<String, Object> parameters ) throws SQLException;

}
