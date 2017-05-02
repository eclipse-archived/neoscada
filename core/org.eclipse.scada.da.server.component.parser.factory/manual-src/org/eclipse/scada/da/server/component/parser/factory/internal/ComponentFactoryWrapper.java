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
package org.eclipse.scada.da.server.component.parser.factory.internal;

import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.component.Component;
import org.eclipse.scada.da.server.component.ComponentFactory;
import org.eclipse.scada.da.server.component.Hive;

public class ComponentFactoryWrapper implements ComponentFactory
{
    private final org.eclipse.scada.da.server.component.parser.factory.configuration.Component component;

    private final String[] prefix;

    private final ScheduledExecutorService executor;

    public ComponentFactoryWrapper ( final ScheduledExecutorService executor, final org.eclipse.scada.da.server.component.parser.factory.configuration.Component component )
    {
        this.executor = executor;
        this.component = component;
        this.prefix = component.getId ().split ( "\\." );
    }

    @Override
    public String[] getPrefix ()
    {
        return this.prefix;
    }

    @Override
    public Component createComponent ( final Hive hive, final FolderCommon folder ) throws Exception
    {
        return new ComponentImpl ( this.executor, hive, folder, this.component );
    }

}
