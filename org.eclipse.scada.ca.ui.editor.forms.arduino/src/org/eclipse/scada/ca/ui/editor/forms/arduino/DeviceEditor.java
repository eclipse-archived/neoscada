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
package org.eclipse.scada.ca.ui.editor.forms.arduino;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.scada.ca.ui.editor.forms.common.ConfigurationFormToolkit;
import org.eclipse.scada.ca.ui.editor.forms.common.StandardConfigurationForm;
import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;

public class DeviceEditor extends StandardConfigurationForm
{

    @Override
    protected String getTitle ( final ConfigurationEditorInput input )
    {
        return String.format ( "Eclipse SCADA Arduino Device - %s: %s", input.getFactoryId (), input.getConfigurationId () );
    }

    @Override
    protected void populateFormContent ( final ConfigurationFormToolkit toolkit, final ScrolledForm form, final ConfigurationEditorInput input )
    {
        final Composite client = toolkit.createStandardComposite ( form.getBody () );
        client.setLayout ( new GridLayout ( 3, false ) );
        client.setLayoutData ( new GridData ( GridData.FILL_HORIZONTAL ) );

        toolkit.createStandardText ( client, "host", "Arduino host address", "Enter hostname or IP address of arduino device", input.getDataMap (), null );
        toolkit.createStandardText ( client, "port", "Arduino port number", "Enter port number of arduino device", input.getDataMap (), null );
    }

}
