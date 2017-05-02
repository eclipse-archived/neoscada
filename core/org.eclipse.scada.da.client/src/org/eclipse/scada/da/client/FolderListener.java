/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client;

import java.util.Collection;

import org.eclipse.scada.da.core.browser.Entry;

public interface FolderListener
{
    /**
     * Provide changes to the listener
     * <p>
     * If either no items were added or removed the corresponding list must
     * still be not null. The lists may not be altered by the listener
     * implementations and may by unmodifiable.
     * </p>
     * 
     * @param added
     *            the folder entries that were added
     * @param removed
     *            the folder entries that where removed
     * @param full
     *            <code>true</code> if this is not a change but a full
     *            transmission, in this case the <code>removed</code> parameter
     *            must be empty or <code>null</code>.
     */
    public void folderChanged ( Collection<Entry> added, Collection<String> removed, boolean full );
}
