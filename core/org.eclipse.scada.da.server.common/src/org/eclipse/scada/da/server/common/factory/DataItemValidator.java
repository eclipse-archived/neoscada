/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.factory;

/**
 * A data item validator which validates if an item id is valid.
 * @author Jens Reimann
 *
 */
public interface DataItemValidator
{
    /**
     * Check if the data item id is valid.
     * @param itemId the item id to check
     * @return <code>true</code> if the item id is valid, <code>false</code> otherwise
     */
    public boolean isValid ( String itemId );
}
