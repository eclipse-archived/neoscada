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
package org.eclipse.scada.da.core.server.browser;

import java.util.List;
import java.util.Set;

import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.browser.Entry;

public interface FolderListener
{
    void folderChanged ( Location location, List<Entry> added, Set<String> removed, boolean full );
}
