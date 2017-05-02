/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc.task;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A row callback
 * 
 * @author Jens Reimann
 */
public interface RowCallback
{
    /**
     * Gets called for every row
     * <p>
     * {@link ResultSet#next()} was already called and must not be called by the
     * callback.
     * </p>
     * 
     * @param resultSet
     *            The result holding the data
     * @throws SQLException
     *             the callback may throw an {@link SQLException}
     */
    public void processRow ( ResultSet resultSet ) throws SQLException;
}
