/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.item.parser.wizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.ui.databinding.SelectionHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SelectPipelineTypeWizardPage extends WizardPage
{

    public static enum Type
    {
        EMPTY ( "empty.icm_js", "Empty skeleton file" ),
        DEFAULT ( "default.icm_js", "Default sample file" );

        private String resourceName;

        private String description;

        Type ( final String resourceName, final String description )
        {
            this.resourceName = resourceName;
            this.description = description;
        }

        @Override
        public String toString ()
        {
            return this.description;
        }

        public String getResourceName ()
        {
            return this.resourceName;
        }
    }

    private ComboViewer viewer;

    protected SelectPipelineTypeWizardPage ( final String pageName, final String title, final ImageDescriptor titleImage )
    {
        super ( pageName, title, titleImage );
    }

    @Override
    public void createControl ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );

        wrapper.setLayout ( new GridLayout ( 2, false ) );

        final Label label = new Label ( wrapper, SWT.NONE );
        label.setText ( "Initial content type:" );

        this.viewer = new ComboViewer ( wrapper );
        this.viewer.setContentProvider ( new ArrayContentProvider () );
        this.viewer.setInput ( Type.values () );
        this.viewer.setSelection ( new StructuredSelection ( Type.DEFAULT ) );

        setControl ( wrapper );
    }

    public Type getTypeSelection ()
    {
        return SelectionHelper.first ( this.viewer.getSelection (), Type.class );
    }
}
