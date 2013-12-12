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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.component.SummariesConfiguration;
import org.eclipse.scada.configuration.component.lib.Configurations;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.infrastructure.lib.WorldGenerator;
import org.eclipse.scada.configuration.world.osgi.SummaryGroup;

public class SummariesCompressor extends MasterApplicationProcessor
{
    private SummariesConfiguration configuration;

    public SummariesCompressor ()
    {
    }

    public SummariesCompressor ( final org.eclipse.scada.configuration.component.ComponentWorld system, final WorldGenerator world )
    {
        super ( system, world );
    }

    @Override
    protected void processContext ( final MasterContext app, final IProgressMonitor monitor )
    {
        this.configuration = Configurations.findDefaultConfiguration ( this.system, SummariesConfiguration.class );
        for ( final SummaryGroup group : app.getImplementation ().getSummaryGroups () )
        {
            processGroup ( group );
        }
    }

    private void processGroup ( final SummaryGroup group )
    {
        final List<SummaryGroup> removeGroups = new LinkedList<> ();

        int threshold;

        if ( this.configuration != null && this.configuration.getItemThreshold () != null )
        {
            threshold = this.configuration.getItemThreshold ();
        }
        else
        {
            threshold = 0;
        }

        if ( threshold <= 1 )
        {
            // values below 2 won't make a difference
            return;
        }

        for ( final SummaryGroup subGroup : group.getSubGroups () )
        {
            processGroup ( subGroup );
            if ( subGroup.getItems ().size () < threshold && subGroup.getSubGroups ().isEmpty () )
            {
                group.getItems ().addAll ( subGroup.getItems () );
                removeGroups.add ( subGroup );
            }
        }

        group.getSubGroups ().removeAll ( removeGroups );
    }
}
