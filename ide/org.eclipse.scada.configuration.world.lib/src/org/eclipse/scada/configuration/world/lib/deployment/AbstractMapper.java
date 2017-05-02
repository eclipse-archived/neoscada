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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.scada.configuration.world.deployment.MappingEntry;
import org.eclipse.scada.configuration.world.deployment.Mappings;

public abstract class AbstractMapper
{

    protected abstract Mappings getMappings ();

    protected void replaceName ( final EObject object, final EStructuralFeature feature )
    {
        final String hostname = (String)object.eGet ( feature );

        if ( hostname == null )
        {
            return;
        }

        final Mappings mappings = getMappings ();

        for ( final MappingEntry entry : mappings.getEntries () )
        {
            final String newName = entry.map ( hostname );
            if ( newName != null )
            {
                object.eSet ( feature, newName );
                return;
            }
        }

        switch ( mappings.getFallbackMode () )
        {
            case IGNORE:
                return;
            case FAIL:
                throw new IllegalStateException ( String.format ( "No node mapping for: %s", hostname ) );
        }
    }

}
