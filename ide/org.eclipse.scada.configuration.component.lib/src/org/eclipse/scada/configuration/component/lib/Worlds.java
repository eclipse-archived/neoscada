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
package org.eclipse.scada.configuration.component.lib;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.component.ComponentWorld;

public class Worlds
{
    private Worlds ()
    {
    }

    public static ComponentWorld findComponentWorld ( final EObject object )
    {
        EObject current = object;
        while ( ! ( current instanceof ComponentWorld ) )
        {
            if ( current == null )
            {
                return null;
            }
            current = current.eContainer ();
        }
        return (ComponentWorld)current;
    }
}
