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

/**
 * just a convenience class which provides a default implementation for
 * validate, which might be empty in most cases, and nullObject which would be
 * null if thats OK in context of caller
 * 
 * @param <T>
 */
public abstract class RowMapperAdapter<T> implements RowMapper<T>
{
    @Override
    public void validate ( final ResultSet resultSet ) throws SQLException, RowMapperValidationException
    {
        // do nothing
    }

    @Override
    public T nullObject ()
    {
        return null;
    }
}
