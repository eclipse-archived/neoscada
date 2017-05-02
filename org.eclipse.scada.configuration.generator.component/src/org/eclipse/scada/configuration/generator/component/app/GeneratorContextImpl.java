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
package org.eclipse.scada.configuration.generator.component.app;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.lib.WorldGenerator;
import org.eclipse.scada.configuration.world.osgi.ValueArchiveServer;

public class GeneratorContextImpl implements GeneratorContext
{

    private final WorldGenerator worldGenerator;

    private final Map<Object, Map<String, Object>> attributes = new HashMap<> ();

    private final List<Runnable> postTriggers = new LinkedList<> ();

    public GeneratorContextImpl ( final WorldGenerator worldGenerator )
    {
        this.worldGenerator = worldGenerator;
    }

    @Override
    public MasterContext getMasterContext ( final MasterServer master )
    {
        return this.worldGenerator.getMasterContext ( master );
    }

    @Override
    public ValueArchiveServer getArchiveServer ( final org.eclipse.scada.configuration.world.osgi.MasterServer master )
    {
        return this.worldGenerator.getArchiveMap ().get ( master );
    }

    @Override
    public Map<Driver, org.eclipse.scada.configuration.world.Driver> getDriverMap ()
    {
        return this.worldGenerator.getDriverMap ();
    }

    @Override
    public org.eclipse.scada.configuration.world.osgi.MasterServer getEquinoxApplication ( final MasterServer app )
    {
        return this.worldGenerator.getMasterContext ( app ).getImplementation ();
    }

    @Override
    public Collection<org.eclipse.scada.configuration.world.osgi.MasterServer> getEquinoxApplications ( final Collection<MasterServer> applications )
    {
        final Collection<org.eclipse.scada.configuration.world.osgi.MasterServer> result = new LinkedList<> ();

        for ( final MasterServer app : applications )
        {
            result.add ( getEquinoxApplication ( app ) );
        }

        return result;
    }

    @Override
    public Object getAttribute ( final Object targetObject, final String key )
    {
        final Map<String, Object> map = this.attributes.get ( targetObject );
        if ( map == null )
        {
            return null;
        }
        return map.get ( key );
    }

    @Override
    public void setAttribute ( final Object targetObject, final String key, final Object value )
    {
        Map<String, Object> map = this.attributes.get ( targetObject );
        if ( map == null )
        {
            map = new HashMap<> ();
            this.attributes.put ( targetObject, map );
        }
        map.put ( key, value );
    }

    @Override
    public void addPostTrigger ( final Runnable runnable )
    {
        this.postTriggers.add ( runnable );
    }

    public void processPostTriggers ()
    {
        for ( final Runnable run : this.postTriggers )
        {
            run.run ();
        }
    }
}