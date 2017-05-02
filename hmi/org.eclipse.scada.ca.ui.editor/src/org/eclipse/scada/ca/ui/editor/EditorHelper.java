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
package org.eclipse.scada.ca.ui.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.ca.ui.data.ConfigurationEditorSourceInformation;
import org.eclipse.scada.ca.ui.data.FactoryEditorSourceInformation;
import org.eclipse.scada.ca.ui.editor.config.MultiConfigurationEditor;
import org.eclipse.scada.ca.ui.editor.factory.FactoryEditor;
import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;
import org.eclipse.scada.ca.ui.editor.input.FactoryEditorInput;
import org.eclipse.scada.ca.ui.editor.internal.Activator;
import org.eclipse.scada.ui.databinding.AdapterHelper;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.statushandlers.StatusManager;

public class EditorHelper
{
    public static IEditorInput[] createInput ( final ISelection selection )
    {
        if ( selection instanceof IStructuredSelection )
        {
            final Iterator<?> i = ( (IStructuredSelection)selection ).iterator ();
            final List<IEditorInput> result = new ArrayList<IEditorInput> ();

            while ( i.hasNext () )
            {
                final Object o = i.next ();

                final FactoryEditorSourceInformation factory = AdapterHelper.adapt ( o, FactoryEditorSourceInformation.class );
                if ( factory != null )
                {
                    final FactoryEditorInput input = new FactoryEditorInput ( factory.getConnection (), factory.getFactoryId () );
                    result.add ( input );
                }

                final ConfigurationEditorSourceInformation config = AdapterHelper.adapt ( o, ConfigurationEditorSourceInformation.class );
                if ( config != null )
                {
                    final ConfigurationEditorInput input = new ConfigurationEditorInput ( config.getConnectionId (), config.getFactoryId (), config.getConfigurationId () );
                    result.add ( input );
                }

            }
            return result.toArray ( new IEditorInput[0] );
        }
        else
        {
            return new IEditorInput[0];
        }
    }

    public static void handleOpen ( final IWorkbenchPage page, final ISelection selection )
    {
        final MultiStatus status = new MultiStatus ( Activator.PLUGIN_ID, 0, "Open editor", null );

        final IEditorInput[] inputs = EditorHelper.createInput ( selection );

        for ( final IEditorInput input : inputs )
        {
            try
            {
                if ( input instanceof ConfigurationEditorInput )
                {
                    page.openEditor ( input, MultiConfigurationEditor.EDITOR_ID, true );
                }
                else if ( input instanceof FactoryEditorInput )
                {
                    page.openEditor ( input, FactoryEditor.EDITOR_ID, true );
                }
            }
            catch ( final PartInitException e )
            {
                status.add ( e.getStatus () );
            }
        }
    }

    public static void handleOpen ( final IWorkbenchPage page, final ISelectionProvider selectionProvider )
    {
        handleOpen ( page, selectionProvider.getSelection () );
    }

    public static void handleOpen ( final IWorkbenchPage page, final String connectionId, final String factoryId, final String configurationId )
    {
        try
        {
            page.openEditor ( new ConfigurationEditorInput ( connectionId, factoryId, configurationId ), MultiConfigurationEditor.EDITOR_ID, true );
        }
        catch ( final PartInitException e )
        {
            StatusManager.getManager ().handle ( e.getStatus () );
        }
    }
}
