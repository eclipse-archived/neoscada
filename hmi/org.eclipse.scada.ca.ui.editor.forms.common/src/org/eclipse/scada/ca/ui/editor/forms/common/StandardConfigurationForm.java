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
package org.eclipse.scada.ca.ui.editor.forms.common;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.scada.ca.ui.editor.config.form.ConfigurationForm;
import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;

public abstract class StandardConfigurationForm implements ConfigurationForm
{

    private ScrolledForm form;

    private ConfigurationFormToolkit toolkit;

    @Override
    public void createFormPart ( final Composite parent, final ConfigurationEditorInput input )
    {
        this.toolkit = new ConfigurationFormToolkit ( parent.getDisplay () );

        this.form = this.toolkit.createScrolledForm ( parent, getTitle ( input ) );
        this.form.getBody ().setLayout ( new GridLayout ( getColumnCount (), true ) );

        // create
        populateFormContent ( this.toolkit, this.form, input );

        this.toolkit.getDataBindingContext ().updateTargets ();
    }

    protected int getColumnCount ()
    {
        return 2;
    }

    protected abstract String getTitle ( ConfigurationEditorInput input );

    protected abstract void populateFormContent ( ConfigurationFormToolkit toolkit, ScrolledForm form, ConfigurationEditorInput input );

    @Override
    public void dispose ()
    {
        this.form.dispose ();
        this.toolkit.dispose ();
    }

    @Override
    public void setFocus ()
    {
        this.form.setFocus ();
    }

}
