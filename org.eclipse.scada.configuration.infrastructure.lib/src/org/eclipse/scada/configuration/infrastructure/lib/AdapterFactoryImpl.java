/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
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
import org.eclipse.scada.configuration.infrastructure.GenericVMSettings;
import org.eclipse.scada.configuration.infrastructure.HttpServiceModule;
import org.eclipse.scada.configuration.infrastructure.OracleVMSettings;
import org.eclipse.scada.configuration.infrastructure.RestExporterModule;
import org.eclipse.scada.configuration.infrastructure.WebAdminConsole;
import org.eclipse.scada.configuration.infrastructure.lib.internal.GenericVMSettingsModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.HttpServiceModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.OracleVMSettingsModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.RestExporterModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.internal.WebAdminConsoleHandler;

public class AdapterFactoryImpl implements IAdapterFactory
{

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Object getAdapter ( final Object adaptableObject, final Class adapterType )
    {
        if ( !ModuleHandler.class.equals ( adapterType ) )
        {
            return null;
        }

        if ( adaptableObject instanceof HttpServiceModule )
        {
            return new HttpServiceModuleHandler ();
        }
        else if ( adaptableObject instanceof RestExporterModule )
        {
            return new RestExporterModuleHandler ();
        }
        else if ( adaptableObject instanceof WebAdminConsole )
        {
            return new WebAdminConsoleHandler ();
        }
        else if ( adaptableObject instanceof OracleVMSettings )
        {
            return new OracleVMSettingsModuleHandler ();
        }
        else if ( adaptableObject instanceof GenericVMSettings )
        {
            return new GenericVMSettingsModuleHandler ();
        }
        return null;
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class<?>[] { ModuleHandler.class };
    }

}
