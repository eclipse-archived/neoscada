/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.localization.timezone;

import java.util.TimeZone;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.scada.ui.localization.Activator;
import org.osgi.service.prefs.Preferences;

public class TimeZoneInitializer extends AbstractPreferenceInitializer
{
    private static final String EXTP_CFG_ID = "org.eclipse.scada.ui.localization.configuration"; //$NON-NLS-1$

    public TimeZoneInitializer ()
    {
    }

    @Override
    public void initializeDefaultPreferences ()
    {
        String defaultTimeZone = TimeZone.getDefault ().getID ();
        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_CFG_ID ) )
        {
            if ( !Activator.TIME_ZONE_KEY.equals ( ele.getName () ) )
            {
                continue;
            }
            defaultTimeZone = ele.getAttribute ( "id" ); //$NON-NLS-1$
        }
        final Preferences node = DefaultScope.INSTANCE.getNode ( Activator.PLUGIN_ID );
        node.put ( Activator.TIME_ZONE_KEY, defaultTimeZone );
    }
}
