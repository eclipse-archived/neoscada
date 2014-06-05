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
package org.eclipse.scada.configuration.world.lib.deployment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.scada.configuration.utils.TypeVisitor;
import org.eclipse.scada.configuration.utils.TypeWalker;
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.deployment.NodeMappingEntry;
import org.eclipse.scada.configuration.world.deployment.NodeMappings;

public class NodeMappingHandler implements TypeVisitor<Node>
{
    @Inject
    private World worldModel;

    @Inject
    private NodeMappings nodeMappings;

    @Inject
    private String additionalTargets;

    private Map<String, Set<String>> additionalMappings = new HashMap<> ();

    public void execute ( final IProgressMonitor monitor ) throws Exception
    {
        monitor.setTaskName ( "Mapping nodes" );

        this.additionalMappings = parse ();

        new TypeWalker<Node> ( Node.class ).walk ( this.worldModel, this );

        final TreeIterator<EObject> i = this.worldModel.eAllContents ();
        while ( i.hasNext () )
        {
            final EObject o = i.next ();

            final String className = o.eClass ().getName ();

            final Set<String> features = this.additionalMappings.get ( className );
            if ( features == null )
            {
                continue;
            }
            for ( final String f : features )
            {
                final EStructuralFeature sf = o.eClass ().getEStructuralFeature ( f );
                if ( sf == null )
                {
                    throw new RuntimeException ( String.format ( "Class %s does not have feature %s", className, f ) );
                }
                replaceName ( o, sf );
            }
        }
    }

    private Map<String, Set<String>> parse ()
    {
        final Map<String, Set<String>> result = new HashMap<> ();

        if ( this.additionalTargets == null || this.additionalTargets.isEmpty () )
        {
            return result;
        }

        for ( final String tok : this.additionalTargets.split ( ";" ) )
        {
            final String[] a = tok.split ( ":", 2 );
            result.put ( a[0], new HashSet<> ( Arrays.asList ( a[1].split ( "," ) ) ) );
        }

        return result;
    }

    @Override
    public void visit ( final Node node ) throws Exception
    {
        replaceName ( node, WorldPackage.Literals.NODE__HOST_NAME );
    }

    protected void replaceName ( final EObject object, final EStructuralFeature feature )
    {
        final String hostname = (String)object.eGet ( feature );

        if ( hostname == null )
        {
            return;
        }

        for ( final NodeMappingEntry entry : this.nodeMappings.getEntries () )
        {
            final String newName = entry.mapNode ( hostname );
            if ( newName != null )
            {
                object.eSet ( feature, newName );
                return;
            }
        }

        switch ( this.nodeMappings.getFallbackMode () )
        {
            case IGNORE:
                return;
            case FAIL:
                throw new IllegalStateException ( String.format ( "No node mapping for: %s", hostname ) );
        }
    }
}
