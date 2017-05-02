/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.validation;

import org.eclipse.scada.configuration.world.osgi.EventPool;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class EventPoolValidator extends TypedValidator<EventPool>
{
    public EventPoolValidator ()
    {
        super ( EventPool.class );
    }

    @Override
    protected void validate ( final EventPool target, final ValidationContext context )
    {
        if ( target.getSize () <= 0 )
        {
            context.add ( OsgiPackage.Literals.EVENT_POOL__SIZE, "Event pool size most be greater than zero" );
        }
    }
}
