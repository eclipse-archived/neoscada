/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.master;

import org.eclipse.scada.da.datasource.DataSource;

public interface MasterItem extends DataSource
{

    public static final String MASTER_ID = "master.id";

    /**
     * remove sub condition
     * @param type the type of the handler that should be removed
     * @return 
     */
    public abstract void removeHandler ( final MasterItemHandler handler );

    /**
     * Add a new sub condition
     * @param handler new condition to add
     * @param the priority this entry has in the master item
     */
    public abstract void addHandler ( final MasterItemHandler handler, int priority );

    public abstract void reprocess ();
}