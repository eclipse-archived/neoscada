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
package org.eclipse.scada.configuration.world.lib.oscar.item.features;

import org.eclipse.scada.configuration.world.lib.oscar.BlockingProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.Factories;
import org.eclipse.scada.configuration.world.osgi.Block;
import org.eclipse.scada.configuration.world.osgi.BlockHandler;

/**
 * Handle {@link Block} item features
 * <p>
 * This processor handles only {@link Block} features, {@link BlockHandler}
 * features are handled by the {@link BlockingProcessor} since they span a group
 * of items, although the factory is the same.
 * </p>
 */
public class BlockProcessor extends EmptyItemFeatureProcessor
{

    public BlockProcessor ()
    {
        super ( Factories.FACTORY_MASTER_HANDLER_BLOCK );
    }
}
