/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.component.lib.create.ItemSource;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.lib.Nodes;
import org.eclipse.scada.configuration.utils.TypeVisitor;
import org.eclipse.scada.configuration.utils.TypeWalker;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.MasterServer;

public abstract class DataComponentGenerator extends ComponentGenerator implements ItemSource
{
    private final DataComponent component;

    public DataComponentGenerator ( final DataComponent component )
    {
        super ( component );
        this.component = component;
    }

    @Override
    public void generate ( final GenerationContext context )
    {
        for ( final org.eclipse.scada.configuration.infrastructure.MasterServer master : this.component.getMasterOn () )
        {
            final MasterContext mappedMaster = this.context.getMasterContext ( master );
            if ( mappedMaster == null )
            {
                throw new IllegalStateException ( String.format ( "No mapped master found for: %s", master ) );
            }
            generateForMaster ( context, mappedMaster );
        }
    }

    protected void generateForMaster ( final GenerationContext context, final MasterContext master )
    {
        createItems ( createItemCreator ( master ) );
    }

    protected ItemCreator createItemCreator ( final MasterContext master )
    {
        return new ItemCreatorImpl ( this.context, master, this.component );
    }

    @Override
    public abstract void createItems ( ItemCreator itemCreator );

    @Override
    public void finish ( final FinishContext context )
    {
        super.finish ( context );
        for ( final org.eclipse.scada.configuration.infrastructure.MasterServer master : this.component.getMasterOn () )
        {
            final MasterContext mappedMaster = this.context.getMasterContext ( master );
            if ( mappedMaster == null )
            {
                throw new IllegalStateException ( String.format ( "No mapped master found for: %s", master ) );
            }
            finishForMaster ( context, mappedMaster );
        }
    }

    protected void finishForMaster ( final FinishContext context, final MasterContext master )
    {
    }

    protected Collection<Endpoint> getEndpoints ( final EquinoxApplication app )
    {
        final Collection<Endpoint> result = new LinkedList<> ();

        if ( app == null )
        {
            return result;
        }

        for ( final Exporter exporter : app.getExporter () )
        {
            result.addAll ( exporter.getEndpoints () );
        }

        return result;
    }

    protected void addDebianDependency ( final MasterServer master, final String dependecy )
    {
        try
        {
            new TypeWalker<> ( DebianDeploymentMechanism.class ).walk ( Nodes.fromApp ( master ).getDeployments (), new TypeVisitor<DebianDeploymentMechanism> () {
                @Override
                public void visit ( final DebianDeploymentMechanism item ) throws Exception
                {
                    item.getAdditionalDependencies ().add ( dependecy );
                }
            } );
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( e );
        }
    }

}