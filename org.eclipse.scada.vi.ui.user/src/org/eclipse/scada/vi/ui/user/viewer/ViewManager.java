/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.user.viewer;

import org.eclipse.jface.action.MenuManager;

public interface ViewManager
{
    public void showView ( String id );

    public void showView ( String id, boolean force );

    public void reloadCurrentView ();

    public void addViewManagerListener ( ViewManagerListener listener );

    public void removeViewManagerListener ( ViewManagerListener listener );

    public void registerMenuManager ( MenuManager menuManager );
}
