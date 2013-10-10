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
package org.eclipse.scada.sec.provider.jdbc;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.AuthenticationService;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.UserManagerService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcAuthenticationServiceFactory extends AbstractServiceConfigurationFactory<JdbcAuthenticationService>
{

    private final static Logger logger = LoggerFactory.getLogger ( JdbcAuthenticationServiceFactory.class );

    public JdbcAuthenticationServiceFactory ( final BundleContext context )
    {
        super ( context );
    }

    @Override
    protected Entry<JdbcAuthenticationService> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        logger.debug ( "Creating new service: {}", configurationId );
        final JdbcAuthenticationService service = new JdbcAuthenticationService ( context, configurationId );
        service.update ( parameters );

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( Constants.SERVICE_DESCRIPTION, "JDBC based authenticator" );
        properties.put ( Constants.SERVICE_PID, configurationId );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );

        final ServiceRegistration<?> handle;

        if ( service.isUserManager () )
        {
            handle = context.registerService ( new String[] { AuthenticationService.class.getName () }, service, properties );
        }
        else
        {
            handle = context.registerService ( new String[] { AuthenticationService.class.getName (), UserManagerService.class.getName () }, service, properties );
        }

        return new Entry<JdbcAuthenticationService> ( configurationId, service, handle );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final JdbcAuthenticationService service )
    {
        logger.debug ( "Disposing service: {}", configurationId );
        service.dispose ();
    }

    @Override
    protected Entry<JdbcAuthenticationService> updateService ( final UserInformation userInformation, final String configurationId, final Entry<JdbcAuthenticationService> entry, final Map<String, String> parameters ) throws Exception
    {
        logger.debug ( "Updating service: {}", configurationId );
        entry.getService ().update ( parameters );
        return null;
    }

}
