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
package org.eclipse.scada.ca.ui.editor.forms.common.ae;

import org.eclipse.scada.ca.ui.editor.forms.common.ConfigurationFormToolkit;
import org.eclipse.scada.ca.ui.editor.forms.common.StandardConfigurationForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;

public class MonitorQueryEditorForm extends StandardConfigurationForm
{
    @Override
    protected String getTitle ( final ConfigurationEditorInput input )
    {
        return String.format ( "Eclipse SCADA Monitor Query: %s", input.getConfigurationId () );
    }

    @Override
    protected int getColumnCount ()
    {
        return 1;
    }

    @Override
    protected void populateFormContent ( final ConfigurationFormToolkit toolkit, final ScrolledForm form, final ConfigurationEditorInput input )
    {
        final Composite client = toolkit.createStandardComposite ( form.getBody () );
        client.setLayout ( new GridLayout ( 3, false ) );
        client.setLayoutData ( new GridData ( GridData.FILL_BOTH ) );

        toolkit.createStandardMultiText ( client, "filter", "Filter", "Filter expression", input.getDataMap (), null );
    }
}
