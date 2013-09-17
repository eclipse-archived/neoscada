/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.factory;

/**
 * The bean helper helps you to create beans ;-)
 * 
 * @author Jens Reimann
 */
public class BeanHelper
{
    public static Object create ( final BeanFactory factory, final String reference ) throws BeanCreationException
    {
        try
        {
            return factory.create ( reference );
        }
        catch ( final Exception e )
        {
            throw new BeanCreationException ( e );
        }
    }

    public static Object create ( final Class<? extends BeanFactory> factoryClass, final String reference ) throws BeanCreationException
    {
        try
        {
            return factoryClass.newInstance ().create ( reference );
        }
        catch ( final Exception e )
        {
            throw new BeanCreationException ( e );
        }
    }

    @SuppressWarnings ( "unchecked" )
    public static Object create ( final String factoryClassName, final String reference ) throws BeanCreationException
    {
        try
        {
            return create ( (Class<BeanFactory>)Class.forName ( factoryClassName ), reference );
        }
        catch ( final ClassNotFoundException e )
        {
            throw new BeanCreationException ( e );
        }
    }

    /**
     * Create a new bean based with a required class
     * 
     * @param factoryClassName
     * @param reference
     * @param requiredClass
     *            the class that is required
     * @return the new instance which can be casted to requiredClass
     * @throws BeanCreationException
     *             in the case anything goes wrong or the bean created was not
     *             the required type
     */
    public static Object create ( final String factoryClassName, final String reference, final Class<?> requiredClass ) throws BeanCreationException
    {
        final Object o = create ( factoryClassName, reference );
        try
        {
            return requiredClass.cast ( o );
        }
        catch ( final ClassCastException e )
        {
            throw new BeanCreationException ( e );
        }
    }
}
