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
package org.eclipse.scada.da.core.server.browser;

import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public interface HiveBrowser
{
    public abstract void subscribe ( Session session, Location location ) throws NoSuchFolderException, InvalidSessionException;

    public abstract void unsubscribe ( Session session, Location location ) throws NoSuchFolderException, InvalidSessionException;

    public NotifyFuture<Entry[]> startBrowse ( Session session, Location location ) throws InvalidSessionException;
}
