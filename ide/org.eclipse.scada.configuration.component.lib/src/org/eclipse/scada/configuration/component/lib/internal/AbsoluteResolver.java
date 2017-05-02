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
package org.eclipse.scada.configuration.component.lib.internal;

import org.eclipse.scada.configuration.component.AbsoluteDanglingReference;
import org.eclipse.scada.configuration.component.DanglingItemReference;
import org.eclipse.scada.configuration.component.lib.DanglingReferenceResolver;
import org.eclipse.scada.configuration.component.lib.Items;
import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbsoluteResolver implements DanglingReferenceResolver
{

    private final static Logger logger = LoggerFactory.getLogger ( AbsoluteResolver.class );

    @Override
    public Item resolveReference ( final GeneratorContext ctx, final MasterServer master, final DanglingItemReference ref )
    {
        if ( ref instanceof AbsoluteDanglingReference )
        {
            logger.debug ( "Resolving reference: {}", ref );
            return Items.findMasterItem ( master, ( (AbsoluteDanglingReference)ref ).getName () );
        }
        return null;
    }

}
