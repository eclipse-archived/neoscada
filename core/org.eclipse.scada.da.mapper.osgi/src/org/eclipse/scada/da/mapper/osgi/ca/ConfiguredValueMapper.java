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
package org.eclipse.scada.da.mapper.osgi.ca;

import java.util.Map;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.da.mapper.AbstractValueMapper;
import org.eclipse.scada.da.mapper.ValueMapper;

public class ConfiguredValueMapper extends AbstractValueMapper implements ValueMapper
{

    public void update ( final Map<String, String> parameters )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        final Map<String, String> newData = cfg.getPrefixed ( "data." );
        final Variant newDefaultValue = makeDefaultValue ( cfg );

        configure ( newData, newDefaultValue );
    }

    private Variant makeDefaultValue ( final ConfigurationDataHelper cfg )
    {
        final String stringValue = cfg.getString ( "defaultValue", null );
        if ( stringValue == null )
        {
            return null;
        }
        return VariantEditor.toVariant ( stringValue );
    }

}
