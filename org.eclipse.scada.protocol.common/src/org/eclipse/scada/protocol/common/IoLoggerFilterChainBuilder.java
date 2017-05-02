/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.common;

import org.apache.mina.core.filterchain.IoFilterChainBuilder;

public interface IoLoggerFilterChainBuilder extends IoFilterChainBuilder
{
    /**
     * Set the base name of the loggers when they are created
     * 
     * @param loggerName
     *            the logger base name
     */
    public void setLoggerName ( String loggerName );

    public void dispose ();
}
