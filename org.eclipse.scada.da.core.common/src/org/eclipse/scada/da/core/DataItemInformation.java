/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.core;

import java.util.Set;

import org.eclipse.scada.da.data.IODirection;

/**
 * Data item information
 * <p>
 * Data items information objects must be equal on their name!
 * 
 * @author Jens Reimann
 */
public interface DataItemInformation
{
    public abstract Set<IODirection> getIODirection ();

    /**
     * Get the ID of the data item
     * <p>
     * Although the getter is called <em>name</em> it returns the <em>id</em>
     * since somewhere in the past "name" was renamed to "id".
     * 
     * @return the id of the data item
     */
    public abstract String getName ();
}
