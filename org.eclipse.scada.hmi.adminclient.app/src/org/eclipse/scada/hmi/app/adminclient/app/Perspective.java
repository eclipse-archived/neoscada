/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hmi.app.adminclient.app;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory
{

    @Override
    public void createInitialLayout ( final IPageLayout layout )
    {
        layout.setEditorAreaVisible ( false );
        layout.addView ( "org.eclipse.scada.core.ui.connection.ConnectionView", IPageLayout.LEFT, 0.25f, IPageLayout.ID_EDITOR_AREA );
        final IFolderLayout folder = layout.createFolder ( "org.eclipse.scada.hmi.app.adminclient", IPageLayout.RIGHT, 0.4f, IPageLayout.ID_EDITOR_AREA ); //$NON-NLS-1$
        folder.addPlaceholder ( "*" );
    }
}
