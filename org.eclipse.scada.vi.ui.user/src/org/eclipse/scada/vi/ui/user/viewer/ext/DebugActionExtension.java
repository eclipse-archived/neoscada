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
package org.eclipse.scada.vi.ui.user.viewer.ext;

import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.ui.user.Activator;
import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchActionConstants;

public class DebugActionExtension implements ViewerExtension
{

    public static boolean hasDebug ()
    {
        return Boolean.getBoolean ( "vi.debug" ); //$NON-NLS-1$
    }

    public static class DebugHandler
    {

        private final Label label;

        private Action reloadAction;

        private final ViewManager viewManager;

        public DebugHandler ( final Composite parent, final ViewManager viewManager )
        {
            this.viewManager = viewManager;
            this.label = new Label ( parent, SWT.NONE );

            final ResourceManager manager = new LocalResourceManager ( JFaceResources.getResources ( this.label.getDisplay () ), this.label );

            this.label.setImage ( manager.createImageWithDefault ( ImageDescriptor.createFromURL ( FileLocator.find ( Activator.getDefault ().getBundle (), new Path ( "/resources/debugIcon.png" ), Collections.EMPTY_MAP ) ) ) ); //$NON-NLS-1$

            final MenuManager menuManager = new MenuManager ( "#PopupMenu", "org.eclipse.scada.vi.ui.user.debugMenu" ); //$NON-NLS-1$ //$NON-NLS-2$

            menuManager.setRemoveAllWhenShown ( true );

            this.label.setMenu ( menuManager.createContextMenu ( this.label ) );

            createActions ();

            menuManager.addMenuListener ( new IMenuListener () {
                @Override
                public void menuAboutToShow ( final IMenuManager menuManager )
                {
                    contextMenuAboutToShow ( menuManager );
                }
            } );

            viewManager.registerMenuManager ( menuManager );
        }

        public Control getControl ()
        {
            return this.label;
        }

        protected void contextMenuAboutToShow ( final IMenuManager menuManager )
        {
            menuManager.add ( this.reloadAction );
            menuManager.add ( new Separator () );
            menuManager.add ( new Separator ( IWorkbenchActionConstants.MB_ADDITIONS ) );
        }

        private void createActions ()
        {
            this.reloadAction = new Action ( "Reload" ) {
                @Override
                public void run ()
                {
                    DebugHandler.this.viewManager.reloadCurrentView ();
                }
            };
        }

    }

    @Override
    public Control create ( final Composite parent, final ViewManager viewManager, final boolean horizontal )
    {
        if ( !hasDebug () )
        {
            return null;
        }

        return new DebugHandler ( parent, viewManager ).getControl ();
    }

}
