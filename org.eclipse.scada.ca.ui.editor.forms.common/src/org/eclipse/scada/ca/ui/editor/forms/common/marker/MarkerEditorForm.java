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
package org.eclipse.scada.ca.ui.editor.forms.common.marker;

import org.eclipse.scada.ca.ui.editor.forms.common.ConfigurationFormToolkit;
import org.eclipse.scada.ca.ui.editor.forms.common.StandardConfigurationForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;

public class MarkerEditorForm extends StandardConfigurationForm
{

    @Override
    protected String getTitle ( final ConfigurationEditorInput input )
    {
        return String.format ( "Eclipse SCADA Marker Handler - %s: %s", input.getFactoryId (), input.getConfigurationId () );
    }

    @Override
    protected void populateFormContent ( final ConfigurationFormToolkit toolkit, final ScrolledForm form, final ConfigurationEditorInput input )
    {
        {
            final Composite sectionClient = toolkit.createStandardSection ( form.getBody (), "Marker Information" );

            // fields
            toolkit.createStandardCheckbox ( sectionClient, "active", "Is the marker active", input.getDataMap (), String.class );
            toolkit.createStandardCheckbox ( sectionClient, "exportAttribute", "Should the marker state be exported as DA attribute", input.getDataMap (), String.class );
            toolkit.createStandardCheckbox ( sectionClient, "alwaysExport", "Should the marker be exported as DA attribute even when it is inactive", input.getDataMap (), String.class );
        }

        {
            final Composite sectionClient = toolkit.createStandardSection ( form.getBody (), "Source Information" );

            // fields
            toolkit.createStandardLinkText ( sectionClient, "master.item", "master.id", "Master Item Id", "ID of the master item", input, null );
            toolkit.createStandardText ( sectionClient, "handlerPriority", "Handler Priority", "The sort order for the master handler list", input.getDataMap (), Integer.class );
        }

        toolkit.createListSection ( form, input, "master.id", "Master Items", ", ", ", ?" );
        toolkit.createTableSection ( form, input, "marker.", "Marker Values" );

    }

}
