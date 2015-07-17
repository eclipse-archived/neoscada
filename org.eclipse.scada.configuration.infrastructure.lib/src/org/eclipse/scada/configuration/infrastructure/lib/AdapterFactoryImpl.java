/*******************************************************************************
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.lib;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.configuration.infrastructure.ConfigurationAdminFileBackend;
import org.eclipse.scada.configuration.infrastructure.DSFileBackend;
import org.eclipse.scada.configuration.infrastructure.EventInjectorHttp;
import org.eclipse.scada.configuration.infrastructure.EventInjectorSyslog;
import org.eclipse.scada.configuration.infrastructure.GenericVMSettings;
import org.eclipse.scada.configuration.infrastructure.HttpServiceModule;
import org.eclipse.scada.configuration.infrastructure.JMXSettings;
import org.eclipse.scada.configuration.infrastructure.OracleVMSettings;
import org.eclipse.scada.configuration.infrastructure.RestExporterModule;
import org.eclipse.scada.configuration.infrastructure.WebAdminConsole;
import org.eclipse.scada.configuration.infrastructure.lib.internal.CAFileModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.DSFileModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.EventInjectorHttpHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.EventInjectorSyslogHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.GenericVMSettingsModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.HttpServiceModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.JMXSettingsModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.OracleVMSettingsModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.RestExporterModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.WebAdminConsoleHandler;

public class AdapterFactoryImpl implements IAdapterFactory
{
    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        if ( !ModuleHandler.class.equals ( adapterType ) )
        {
            return null;
        }

        if ( adaptableObject instanceof HttpServiceModule )
        {
            return adapterType.cast ( new HttpServiceModuleHandler () );
        }
        else if ( adaptableObject instanceof RestExporterModule )
        {
            return adapterType.cast ( new RestExporterModuleHandler () );
        }
        else if ( adaptableObject instanceof WebAdminConsole )
        {
            return adapterType.cast ( new WebAdminConsoleHandler () );
        }
        else if ( adaptableObject instanceof EventInjectorHttp )
        {
            return adapterType.cast ( new EventInjectorHttpHandler () );
        }
        else if ( adaptableObject instanceof EventInjectorSyslog )
        {
            return adapterType.cast ( new EventInjectorSyslogHandler () );
        }
        else if ( adaptableObject instanceof OracleVMSettings )
        {
            return adapterType.cast ( new OracleVMSettingsModuleHandler () );
        }
        else if ( adaptableObject instanceof GenericVMSettings )
        {
            return adapterType.cast ( new GenericVMSettingsModuleHandler () );
        }
        else if ( adaptableObject instanceof JMXSettings )
        {
            return adapterType.cast ( new JMXSettingsModuleHandler () );
        }
        else if ( adaptableObject instanceof ConfigurationAdminFileBackend )
        {
            return adapterType.cast ( new CAFileModuleHandler () );
        }
        else if ( adaptableObject instanceof DSFileBackend )
        {
            return adapterType.cast ( new DSFileModuleHandler () );
        }
        return null;
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class<?>[] { ModuleHandler.class };
    }

}
