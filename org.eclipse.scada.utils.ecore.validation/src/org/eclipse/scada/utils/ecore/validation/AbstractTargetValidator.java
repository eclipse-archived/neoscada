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

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

public abstract class AbstractTargetValidator<T>
{
    private final Class<T> clazz;

    private final String contextId;

    public AbstractTargetValidator ( final Class<T> clazz, final String contextId )
    {
        this.clazz = clazz;
        this.contextId = contextId;
    }

    protected abstract void performValidation ( final T target, final ValidationContext ctx );

    /**
     * @return if the object is valid, <code>true</code> if the object is
     */
    public boolean validate ( final Object target, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        if ( target == null )
        {
            return true;
        }

        if ( !this.clazz.isAssignableFrom ( target.getClass () ) )
        {
            return true;
        }

        final T t = this.clazz.cast ( target );

        final ValidationContextImpl ctx = new ValidationContextImpl ( this.contextId, target );
        performValidation ( t, ctx );
        return ctx.apply ( diagnostics );
    }

}