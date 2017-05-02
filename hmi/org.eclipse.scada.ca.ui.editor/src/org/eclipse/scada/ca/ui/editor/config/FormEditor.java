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
package org.eclipse.scada.ca.ui.editor.config;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.scada.ca.ui.editor.ConfigurationFormInformation;
import org.eclipse.scada.ca.ui.editor.config.form.ConfigurationForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

public class FormEditor extends AbstractConfigurationEditor
{

    private final ConfigurationForm form;

    public FormEditor ( final ConfigurationFormInformation formInformation ) throws CoreException
    {
        super ( true );
        this.form = formInformation.create ();
    }

    @Override
    public void setFocus ()
    {
        this.form.setFocus ();
    }

    @Override
    public void dispose ()
    {
        this.form.dispose ();
        super.dispose ();
    }

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
    public void createPartControl ( final Composite parent )
    {
        this.form.createFormPart ( parent, getEditorInput () );
    }

}
