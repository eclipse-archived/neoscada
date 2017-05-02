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
package org.eclipse.scada.configuration.generator.component.app;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.component.Configuration;
import org.eclipse.scada.configuration.component.lib.Configurations;
import org.eclipse.scada.configuration.infrastructure.EquinoxApplication;
import org.eclipse.scada.configuration.utils.TypeWalker;

public abstract class EquinoxApplicationProcessor<App extends EquinoxApplication>
{

    private final Class<App> clazz;

    @Inject
    @Named ( "componentModel" )
    protected org.eclipse.scada.configuration.component.ComponentWorld system;

    public EquinoxApplicationProcessor ( final Class<App> clazz )
    {
        this.clazz = clazz;
    }

    public EquinoxApplicationProcessor ( final Class<App> clazz, final org.eclipse.scada.configuration.component.ComponentWorld system )
    {
        this.clazz = clazz;
        this.system = system;
    }

    public void process ( final IProgressMonitor monitor ) throws Exception
    {
        final List<App> apps = new TypeWalker<> ( this.clazz ).toList ( this.system.getInfrastructure () );
        for ( final App app : apps )
        {
            process ( app, monitor );
        }
    }

    protected <T extends Configuration> T findDefaultConfiguration ( final Class<T> clazz )
    {
        return Configurations.findDefaultConfiguration ( this.system, clazz );
    }

    protected abstract void process ( App app, IProgressMonitor monitor ) throws Exception;

}
