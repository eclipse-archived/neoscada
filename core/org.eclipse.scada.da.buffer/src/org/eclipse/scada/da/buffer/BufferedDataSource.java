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
package org.eclipse.scada.da.buffer;

public interface BufferedDataSource
{
    public final static String BUFFERED_DATA_SOURCE_ID = "buffered.datasource.id";

    public void addListener ( final BufferedDataSourceListener listener );

    public void removeListener ( final BufferedDataSourceListener listener );
}
