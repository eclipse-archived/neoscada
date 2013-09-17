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

public interface ResultSetProcessor
{
    /**
     * Process the result set
     * <p>
     * Note that you need to call {@link ResultSet#next()} first!
     * </p>
     * <p>
     * There is no need to close the result set.
     * </p>
     * 
     * @param resultSet
     *            the result set to process
     * @throws SQLException
     *             any SQL exception
     */
    public void processResult ( ResultSet resultSet ) throws SQLException;
}
