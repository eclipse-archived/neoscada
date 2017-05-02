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
package org.eclipse.scada.ca.ui.editor.forms.common.level;

import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ca.ui.editor.forms.common.ConfigurationFormToolkit;
import org.eclipse.scada.ca.ui.editor.forms.common.StandardConfigurationForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;

public class LevelEditorForm extends StandardConfigurationForm
{

    private static final String[] COMMON_PREFIXES = new String[] { "min", "lowlow", "low", "heigh", "heighheigh", "max" };

    @Override
    protected String getTitle ( final ConfigurationEditorInput input )
    {
        return String.format ( "Eclipse SCADA Level - %s: %s", input.getFactoryId (), input.getConfigurationId () );
    }

    @Override
    protected void populateFormContent ( final ConfigurationFormToolkit toolkit, final ScrolledForm form, final ConfigurationEditorInput input )
    {
        {
            final Composite sectionClient = toolkit.createStandardSection ( form.getBody (), "Level Information" );

            // fields
            toolkit.createStandardText ( sectionClient, "preset", "Preset", "Preset value", input.getDataMap (), Double.class );
            toolkit.createStandardCheckbox ( sectionClient, "includedOk", "If the value is equal to the preset the value is ok", input.getDataMap (), String.class );
            toolkit.createStandardCheckbox ( sectionClient, "lowerOk", "If the value is lower than the preset it is ok", input.getDataMap (), String.class );
            toolkit.createStandardCheckbox ( sectionClient, "cap", "Limit the value to the preset (min or max)", input.getDataMap (), String.class );
        }

        {
            final Composite sectionClient = toolkit.createStandardSection ( form.getBody (), "Monitor Information" );
            // monitor
            toolkit.createStandardCheckbox ( sectionClient, "active", "Active", input.getDataMap (), String.class );
            // toolkit.createStandardCheckbox ( sectionClient, "error", "As error", input.getDataMap (), String.class );
            toolkit.createStandardCombo ( sectionClient, "prefix", "Prefix", LevelEditorForm.COMMON_PREFIXES, input.getDataMap (), String.class );
            toolkit.createStandardCombo ( sectionClient, "severity", "Severity", Severity.values (), input.getDataMap (), String.class );
            toolkit.createStandardCheckbox ( sectionClient, "requireAck", "Require acknowledge", input.getDataMap (), String.class );

        }

        {
            final Composite sectionClient = toolkit.createStandardSection ( form.getBody (), "Source Information" );

            // fields
            toolkit.createStandardLinkText ( sectionClient, "master.item", "master.id", "Master Item Id", "ID of the master item", input, null );
            toolkit.createStandardText ( sectionClient, "handlerPriority", "Handler Priority", "The sort order for the master handler list", input.getDataMap (), Integer.class );
        }

        toolkit.createInfoSection ( form, input );

    }

}
