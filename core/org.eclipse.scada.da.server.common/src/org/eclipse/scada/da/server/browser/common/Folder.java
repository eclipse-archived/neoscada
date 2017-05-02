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
package org.eclipse.scada.da.server.browser.common;

import java.util.Stack;

import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.server.browser.NoSuchFolderException;

public interface Folder
{
    public Entry[] list ( Stack<String> path ) throws NoSuchFolderException;

    public void subscribe ( Stack<String> path, FolderListener listener, Object tag ) throws NoSuchFolderException;

    public void unsubscribe ( Stack<String> path, Object tag ) throws NoSuchFolderException;

    /**
     * Called when the folder was added to the browser space
     */
    public void added ();

    /**
     * Called when the folder was removed from the browser space
     *
     */
    public void removed ();
}
