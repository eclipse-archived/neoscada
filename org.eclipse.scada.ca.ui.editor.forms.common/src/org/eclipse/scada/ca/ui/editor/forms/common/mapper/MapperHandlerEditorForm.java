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
package org.eclipse.scada.ca.ui.editor.forms.common.mapper;

import org.eclipse.scada.ca.ui.editor.forms.common.ConfigurationFormToolkit;
import org.eclipse.scada.ca.ui.editor.forms.common.StandardConfigurationForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;

public class MapperHandlerEditorForm extends StandardConfigurationForm
{
    @Override
    protected String getTitle ( final ConfigurationEditorInput input )
    {
        return String.format ( "Eclipse SCADA Mapper Master Handler: %s", input.getConfigurationId () );
    }

    @Override
    protected void populateFormContent ( final ConfigurationFormToolkit toolkit, final ScrolledForm form, final ConfigurationEditorInput input )
    {
        {
            final Composite sectionClient = toolkit.createStandardSection ( form.getBody (), "Mapper Information" );

            // fields
            toolkit.createStandardText ( sectionClient, "mapperId", "Value Mapper Id", "ID of a value mapper", input.getDataMap (), String.class );
            toolkit.createStandardText ( sectionClient, "sourceAttributeName", "Source Attribute Name", "Name of the source attribute (empty for main value)", input.getDataMap (), String.class );
            toolkit.createStandardText ( sectionClient, "targetAttributeName", "Target Attribute Name", "Name of the target attribute (empty for main value)", input.getDataMap (), String.class );
        }

        {
            final Composite sectionClient = toolkit.createStandardSection ( form.getBody (), "Master Item" );

            // fields
            toolkit.createStandardLinkText ( sectionClient, "master.item", "master.id", "Master Item Id", "ID of the master item", input, null );
        }

    }

}
