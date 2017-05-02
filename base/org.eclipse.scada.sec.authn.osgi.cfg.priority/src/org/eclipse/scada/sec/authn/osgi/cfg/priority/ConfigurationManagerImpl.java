/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.authn.osgi.cfg.priority;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.sec.AuthenticationService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @since 1.1
 */
public class ConfigurationManagerImpl implements ConfigurationManager
{

    public static final class ConfigurationGroupImpl implements ConfigurationGroup
    {

        private final List<AuthenticationService> services;

        private final int retries = 3;

        public ConfigurationGroupImpl ()
        {
            this.services = new LinkedList<AuthenticationService> ();
        }

        @Override
        public int getRetries ()
        {
            return this.retries;
        }

        @Override
        public List<AuthenticationService> getServices ()
        {
            return this.services;
        }

        public void add ( final AuthenticationService service )
        {
            this.services.add ( service );
        }

        @Override
        public String toString ()
        {
            final StringBuilder sb = new StringBuilder ();
            sb.append ( "[ConfigurationGroup - retries: " + this.retries );
            sb.append ( ", services: " );
            for ( final AuthenticationService service : this.services )
            {
                sb.append ( "\n\t" + service );
            }
            sb.append ( "]" );
            return sb.toString ();
        }
    }

    public static final class ConfigurationImpl implements Configuration
    {
        private final List<ConfigurationGroup> groups;

        public ConfigurationImpl ( final List<ConfigurationGroup> groups )
        {
            this.groups = groups;
        }

        @Override
        public List<ConfigurationGroup> getGroups ()
        {
            return this.groups;
        }

        @Override
        public String toString ()
        {
            final StringBuilder sb = new StringBuilder ();
            sb.append ( "[Configuration - groups:" );

            for ( final ConfigurationGroup group : this.groups )
            {
                sb.append ( "\n" );
                sb.append ( group );
            }

            sb.append ( "]" );
            return sb.toString ();
        }
    }

    private final ServiceTracker<AuthenticationService, AuthenticationService> tracker;

    public ConfigurationManagerImpl ( final BundleContext context )
    {
        this.tracker = new ServiceTracker<AuthenticationService, AuthenticationService> ( context, AuthenticationService.class, null );
        this.tracker.open ();
    }

    public void dispose ()
    {
        this.tracker.close ();
    }

    @Override
    public Configuration getConfiguration ()
    {
        final List<ConfigurationGroup> groups = new LinkedList<ConfigurationGroup> ();

        Long lastRanking = null;
        ConfigurationGroupImpl lastGroup = null;

        for ( final Map.Entry<ServiceReference<AuthenticationService>, AuthenticationService> entry : this.tracker.getTracked ().entrySet () )
        {
            final Object o = entry.getKey ().getProperty ( Constants.SERVICE_RANKING );
            final long ranking = o instanceof Number ? ( (Number)o ).longValue () : 0;

            if ( lastRanking == null || lastRanking != ranking )
            {
                lastGroup = new ConfigurationGroupImpl ();
                groups.add ( lastGroup );
                lastRanking = ranking;
            }

            lastGroup.add ( entry.getValue () );
        }

        return new ConfigurationImpl ( groups );
    }

}
