/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.generator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.configuration.globalization.Local;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.world.osgi.ValueArchiveServer;

public interface GeneratorContext
{
    public static class GlobalContext
    {
        private final Local local;

        private final MasterImport masterImport;

        public GlobalContext ( final Local local, final MasterImport masterImport )
        {
            super ();
            this.local = local;
            this.masterImport = masterImport;
        }

        public Local getLocal ()
        {
            return local;
        }

        public MasterImport getMasterImport ()
        {
            return masterImport;
        }
    }

    public static class MasterContext
    {
        private MasterServer definition;

        private org.eclipse.scada.configuration.world.osgi.MasterServer implementation;

        private Set<GlobalContext> globalContext;

        public MasterContext ()
        {
            globalContext = new HashSet<> ( 1 );
        }

        public MasterServer getDefinition ()
        {
            return definition;
        }

        public org.eclipse.scada.configuration.world.osgi.MasterServer getImplementation ()
        {
            return implementation;
        }

        public void setDefinition ( final MasterServer definition )
        {
            this.definition = definition;
        }

        public void setImplementation ( final org.eclipse.scada.configuration.world.osgi.MasterServer implementation )
        {
            this.implementation = implementation;
        }

        public Set<GlobalContext> getGlobalContext ()
        {
            return globalContext;
        }

        public void setGlobalContext ( final Set<GlobalContext> globalContext )
        {
            this.globalContext = globalContext;
        }

        @Override
        public String toString ()
        {
            if ( definition != null )
            {
                return definition.toString ();
            }
            else
            {
                return "null";
            }
        }
    }

    public Map<Driver, org.eclipse.scada.configuration.world.Driver> getDriverMap ();

    public Collection<org.eclipse.scada.configuration.world.osgi.MasterServer> getEquinoxApplications ( Collection<MasterServer> applications );

    public org.eclipse.scada.configuration.world.osgi.MasterServer getEquinoxApplication ( MasterServer application );

    public MasterContext getMasterContext ( MasterServer master );

    /**
     * Get the technical {@link ValueArchiveServer} for the provided
     * {@link org.eclipse.scada.configuration.world.osgi.MasterServer}
     * <p>
     * This can be <code>null</code> if the master server is not configured to
     * perform archiving.
     * </p>
     */
    public ValueArchiveServer getArchiveServer ( org.eclipse.scada.configuration.world.osgi.MasterServer master );

    public Object getAttribute ( Object targetObject, String key );

    public void setAttribute ( Object targetObject, String key, Object value );

    public void addPostTrigger ( Runnable runnable );
}
