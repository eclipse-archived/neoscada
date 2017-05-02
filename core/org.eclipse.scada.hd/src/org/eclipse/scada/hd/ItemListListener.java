/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd;

import java.util.Set;

import org.eclipse.scada.hd.data.HistoricalItemInformation;

public interface ItemListListener
{
    public void listChanged ( Set<HistoricalItemInformation> addedOrModified, Set<String> removed, boolean full );
}
