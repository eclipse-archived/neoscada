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
package org.eclipse.neoscada.configuration.iec60870.lib;

import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public final class Configurations
{
    private Configurations ()
    {
    }

    public static void encode ( final Map<String, String> data, final String prefix, final EObject object )
    {
        if ( object == null )
        {
            return;
        }

        for ( final EStructuralFeature sf : object.eClass ().getEAllStructuralFeatures () )
        {
            if ( sf.isMany () )
            {
                continue;
            }

            final EAnnotation an = sf.getEAnnotation ( "http://eclipse.org/SCADA/CA/Descriptor" ); //$NON-NLS-1$
            if ( an == null )
            {
                continue;
            }
            final String name = an.getDetails ().get ( "name" ); //$NON-NLS-1$
            if ( name == null )
            {
                continue;
            }
            final String format = an.getDetails ().get ( "format" ); //$NON-NLS-1$

            String key;
            String value;

            if ( prefix != null )
            {
                key = prefix + "." + name;
            }
            else
            {
                key = name;
            }

            final Object v = object.eGet ( sf );
            if ( v == null )
            {
                continue;
            }

            if ( format != null )
            {
                value = String.format ( format, v );
            }
            else
            {
                value = v == null ? null : v.toString ();
            }

            data.put ( key, value );
        }
    }

}
