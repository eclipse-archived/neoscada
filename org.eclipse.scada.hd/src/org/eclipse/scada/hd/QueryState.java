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
package org.eclipse.scada.hd;

public enum QueryState
{
    /**
     * The query is loading data.
     */
    LOADING,
    /**
     * The query loaded all data. The data is complete up to now.
     */
    COMPLETE,
    /**
     * The query is disconnected and will not receive any more updates.
     */
    DISCONNECTED,
    /**
     * The query was created or changed on the client and is waiting
     * for creation or update.
     */
    REQUESTED
}
