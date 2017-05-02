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
package org.eclipse.scada.da.server.common;

/**
 * The default validation strategy defines how item IDs are
 * validated. 
 * @author Jens Reimann
 *
 */
public enum ValidationStrategy
{
    /**
     * Perform a full check through all possible checks. If the item
     * does not exists and all factories reject creating the item
     * the item is considered "invalid".
     */
    FULL_CHECK,
    /**
     * Be permissive and grant everything. If the item does not exists
     * and all factories reject creating the item it is still considered
     * "currently unknown" and will be connected as "GRANTED" since it
     * might be accepted later.
     */
    GRANT_ALL
}
