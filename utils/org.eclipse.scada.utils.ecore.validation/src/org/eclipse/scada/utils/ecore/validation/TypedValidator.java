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
package org.eclipse.scada.utils.ecore.validation;

import org.eclipse.emf.ecore.EObject;

public abstract class TypedValidator<T extends EObject> implements Validator
{
    private final Class<T> clazz;

    public TypedValidator ( final Class<T> clazz )
    {
        this.clazz = clazz;
    }

    @Override
    public void validate ( final ValidationContext context )
    {
        final Object target = context.getTarget ();

        if ( target == null )
        {
            return;
        }

        if ( !this.clazz.isAssignableFrom ( target.getClass () ) )
        {
            return;
        }

        final T t = this.clazz.cast ( target );
        validate ( t, context );
    }

    protected abstract void validate ( final T target, final ValidationContext context );

}
