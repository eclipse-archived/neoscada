/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.Components;
import org.eclipse.scada.configuration.component.Configuration;
import org.eclipse.scada.configuration.component.System;
import org.eclipse.scada.configuration.component.lib.Configurations;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.Generator;
import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.configuration.generator.PreparationContext;

public abstract class ComponentGenerator implements Generator
{
    private final Component component;

    protected GeneratorContext context;

    public ComponentGenerator ( final Component component )
    {
        this.component = component;
    }

    protected <T extends Configuration> T findConfiguration ( final Class<T> clazz, final EClass eClazz )
    {
        final T result = Configurations.findDefaultConfiguration ( findSystem (), clazz );
        if ( result != null )
        {
            return result;
        }
        if ( eClazz == null )
        {
            return null;
        }
        return clazz.cast ( EcoreUtil.create ( eClazz ) );
    }

    protected System findSystem ()
    {
        EObject current = this.component.getLevel ();
        while ( current != null )
        {
            if ( current instanceof System )
            {
                return (System)current;
            }
            current = current.eContainer ();
        }
        return null;
    }

    @Override
    public void initialize ( final GeneratorContext context )
    {
        this.context = context;
    }

    @Override
    public void prepare ( final PreparationContext context )
    {
    }

    @Override
    public void finish ( final FinishContext context )
    {
    }

    public String getFullLevelName ()
    {
        return Components.makeFullQualified ( this.component );
    }
}
