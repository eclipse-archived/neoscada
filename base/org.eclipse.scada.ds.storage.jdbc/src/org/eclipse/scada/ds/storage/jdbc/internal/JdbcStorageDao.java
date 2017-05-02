/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ds.storage.jdbc.internal;

import java.util.Collection;

import org.eclipse.scada.ds.DataNode;

public interface JdbcStorageDao
{
    public DataNode readNode ( String nodeId );

    public Collection<DataNode> readAllNodes ();

    public void writeNode ( DataNode node );

    public void deleteNode ( String nodeId );

    public void dispose ();
}
