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
import org.eclipse.scada.configuration.world.deployment.Mappings;

public class MappingHandler extends AbstractMapper
{
    @Inject
    private EObject model;

    @Inject
    private Mappings mappings;

    @Inject
    private String targets;

    private Map<String, Set<String>> parsedMappings = new HashMap<> ();

    @Override
    protected Mappings getMappings ()
    {
        return this.mappings;
    }

    public void execute ( final IProgressMonitor monitor ) throws Exception
    {
        monitor.setTaskName ( "Mapping elements" );

        this.parsedMappings = parse ();

        final TreeIterator<EObject> i = this.model.eAllContents ();
        while ( i.hasNext () )
        {
            final EObject o = i.next ();

            final String className = o.eClass ().getName ();

            final Set<String> features = this.parsedMappings.get ( className );
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

        if ( this.targets == null || this.targets.isEmpty () )
        {
            return result;
        }

        for ( final String tok : this.targets.split ( ";" ) )
        {
            final String[] a = tok.split ( ":", 2 );
            result.put ( a[0], new HashSet<> ( Arrays.asList ( a[1].split ( "," ) ) ) );
        }

        return result;
    }

}
