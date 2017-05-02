/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ide;

import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class ScadaPerspectiveFactory implements IPerspectiveFactory
{

    @SuppressWarnings ( "deprecation" )
    @Override
    public void createInitialLayout ( final IPageLayout factory )
    {
        final IFolderLayout topLeft = factory.createFolder ( "topLeft", IPageLayout.LEFT, 0.25f, factory.getEditorArea () );
        topLeft.addPlaceholder ( IPageLayout.ID_RES_NAV );
        topLeft.addView ( JavaUI.ID_PACKAGES );
        topLeft.addPlaceholder ( JavaUI.ID_TYPE_HIERARCHY );
        topLeft.addView ( "org.eclipse.scada.core.ui.connection.ConnectionView" ); //$NON-NLS-1$

        final IFolderLayout bottom = factory.createFolder ( "bottomRight", IPageLayout.BOTTOM, 0.75f, factory.getEditorArea () );
        bottom.addView ( "org.eclipse.pde.runtime.LogView" ); //$NON-NLS-1$
        bottom.addView ( IPageLayout.ID_TASK_LIST );
        bottom.addView ( IPageLayout.ID_PROBLEM_VIEW );

        factory.addView ( IPageLayout.ID_OUTLINE, IPageLayout.RIGHT, 0.75f, factory.getEditorArea () );

        factory.addNewWizardShortcut ( "org.eclipse.pde.ui.NewProjectWizard" ); //$NON-NLS-1$
        factory.addNewWizardShortcut ( "org.eclipse.pde.ui.NewFeatureProjectWizard" ); //$NON-NLS-1$
    }
}
