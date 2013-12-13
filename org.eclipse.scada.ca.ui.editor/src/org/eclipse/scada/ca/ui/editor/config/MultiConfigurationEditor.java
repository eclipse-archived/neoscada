/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.editor.config;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.scada.ca.ui.editor.ConfigurationFormInformation;
import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;
import org.eclipse.scada.ca.ui.editor.internal.Activator;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.statushandlers.StatusManager;

public class MultiConfigurationEditor extends MultiPageEditorPart
{

    public static final String EDITOR_ID = "org.eclipse.scada.ca.ui.connection.editors.MultiConfigurationEditor";

    private BasicEditor basicEditor;

    @Override
    public void init ( final IEditorSite site, final IEditorInput input ) throws PartInitException
    {
        setPartName ( input.toString () );
        setSite ( site );
        try
        {
            setInput ( input );
        }
        catch ( final Exception e )
        {
            throw new PartInitException ( "Failed to initialize editor", e );
        }
    }

    @Override
    protected void createPages ()
    {
        try
        {
            int i = 0;

            final String factoryId = getEditorInput ().getFactoryId ();
            for ( final ConfigurationFormInformation info : Activator.findMatching ( factoryId ) )
            {
                try
                {
                    addPage ( i, new FormEditor ( info ), getEditorInput () );
                    setPageText ( i, info.getLabel () );
                    i++;
                }
                catch ( final CoreException e )
                {
                    StatusManager.getManager ().handle ( e.getStatus (), StatusManager.SHOW );
                }
            }

            // add default editor 
            addPage ( i, this.basicEditor = new BasicEditor (), getEditorInput () );
            setPageText ( i, "Basic Editor" );

        }
        catch ( final PartInitException e )
        {
            StatusManager.getManager ().handle ( e.getStatus (), StatusManager.BLOCK );
        }
    }

    @Override
    protected void setInput ( final IEditorInput input )
    {
        final ConfigurationEditorInput configurationInput = (ConfigurationEditorInput)input;

        configurationInput.performLoad ( new NullProgressMonitor () );

        super.setInput ( input );
    }

    @Override
    public ConfigurationEditorInput getEditorInput ()
    {
        return (ConfigurationEditorInput)super.getEditorInput ();
    }

    @Override
    public void doSave ( final IProgressMonitor monitor )
    {
        getEditorInput ().performSave ( monitor );
    }

    @Override
    public void doSaveAs ()
    {
    }

    @Override
    public boolean isSaveAsAllowed ()
    {
        return false;
    }

    public void handleInsert ()
    {
        this.basicEditor.handleInsert ();
    }

    public void refresh ()
    {
        getEditorInput ().performLoad ( new NullProgressMonitor () );
    }

}
