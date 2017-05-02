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
package org.eclipse.scada.utils.osgi.jdbc.data;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T>
{
    /**
     * validate result after query (for instance number of columns, etc
     * 
     * @param resultSet
     * @throws SQLException
     * @throws RowMapperValidationException
     */
    public void validate ( ResultSet resultSet ) throws SQLException, RowMapperValidationException;

    public T mapRow ( ResultSet resultSet ) throws SQLException, RowMapperMappingException;

    /**
     * if nulls are unwanted, a null object can be returned here
     * 
     * @return
     */
    public T nullObject ();
}