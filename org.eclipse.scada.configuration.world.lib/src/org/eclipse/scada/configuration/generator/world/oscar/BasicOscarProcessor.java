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
package org.eclipse.scada.configuration.generator.world.oscar;

import java.util.Map;

import org.eclipse.scada.configuration.generator.world.BasicProcessor;
import org.eclipse.scada.configuration.world.Documentable;

public class BasicOscarProcessor extends BasicProcessor
{

    protected final OscarContext ctx;

    public BasicOscarProcessor ( final Documentable documentable, final OscarContext ctx )
    {
        super ( documentable );
        this.ctx = ctx;
    }

    protected void addData ( final String factoryId, final String configurationId, final Map<String, String> data )
    {
        this.ctx.addData ( factoryId, configurationId, data );
    }

}
