/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.server;

import org.eclipse.scada.ca.Configuration;
import org.eclipse.scada.ca.Factory;

public class FactoryWithData
{
    private final Factory factory;

    private final Configuration[] configurations;

    public FactoryWithData ( final Factory factory, final Configuration[] configurations )
    {
        super ();
        this.factory = factory;
        this.configurations = configurations;
    }

    public Configuration[] getConfigurations ()
    {
        return this.configurations;
    }

    public Factory getFactory ()
    {
        return this.factory;
    }
}
