/*******************************************************************************
 * Copyright (c) 2013, 2014 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     IBH SYSTEMS GmbH - add JDBC properties
 *******************************************************************************/
package org.eclipse.scada.da.server.jdbc;

import java.util.Properties;

public interface ConnectionFactory
{
    public java.sql.Connection createConnection ( String connectionClass, String uri, Properties properties, Integer timeout ) throws Exception;
}
