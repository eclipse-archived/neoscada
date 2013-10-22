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
package org.eclipse.scada.configuration.item;

import java.util.List;

import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomizationRunner
{

    private final static Logger logger = LoggerFactory.getLogger ( CustomizationRunner.class );

    private final List<CustomizationPipeline> pipelines;

    public CustomizationRunner ( final List<CustomizationPipeline> pipelines )
    {
        this.pipelines = pipelines;
    }

    public void run ( final Item item, final CustomizationRequest request )
    {
        logger.debug ( "Customizing item - item: {}, pipelines: {}", item, this.pipelines );

        // execute the first that is not null 
        for ( final CustomizationPipeline pipeline : this.pipelines )
        {
            if ( pipeline != null )
            {
                logger.debug ( "Using pipeline: {}", pipeline );
                pipeline.customize ( request );
                return;
            }
        }
    }
}
