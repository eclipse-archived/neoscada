/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.exec.lib;

import org.eclipse.scada.configuration.component.exec.ExecComponentsPackage;
import org.eclipse.scada.configuration.component.exec.PingCheck;
import org.eclipse.scada.configuration.component.exec.PingCheckConfiguration;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.SourceItem;

public class PingCheckGenerator extends ExecJobGenerator
{

    private final PingCheck pingCheck;

    public PingCheckGenerator ( final PingCheck pingCheck )
    {
        super ( pingCheck );
        this.pingCheck = pingCheck;
    }

    @Override
    public void generate ( final GenerationContext context )
    {
        final PingCheckConfiguration cfg = findConfiguration ( PingCheckConfiguration.class, ExecComponentsPackage.Literals.PING_CHECK_CONFIGURATION );

        final PingCheckWriter writer = PingCheckWriter.find ( cfg, findRoot (), this.context );

        writer.addEntry ( this.pingCheck.getNode ().getHostName (), makeSourceName () );

        super.generate ( context );
    }

    protected String makeSourceName ()
    {
        return getFullLevelName () + "." + this.pingCheck.getNode ().getHostName (); //$NON-NLS-1$ 
    }

    @Override
    public void createItems ( final ItemCreator creator )
    {
        {
            final CreationRequest<SourceItem> c = creator.createSourceItem ( this.pingCheck.getRunsOn (), "PING.values." + makeSourceName () + ".reach" ); //$NON-NLS-1$ //$NON-NLS-2$
            c.localTags ( "REACH" ).dataType ( DataType.FLOAT ).customizationTags ( "input" ); //$NON-NLS-1$ //$NON-NLS-2$
            c.information ( String.format ( "Reachability of %s", this.pingCheck.getNode ().getHostName () ), null, null );
            c.create ();
        }
        {
            final CreationRequest<SourceItem> c = creator.createSourceItem ( this.pingCheck.getRunsOn (), "PING.values." + makeSourceName () + ".rtt" ); //$NON-NLS-1$ //$NON-NLS-2$
            c.localTags ( "RTT" ).dataType ( DataType.INT32 ).customizationTags ( "input" ); //$NON-NLS-1$ //$NON-NLS-2$
            c.information ( String.format ( "Round trip time to %s", this.pingCheck.getNode ().getHostName () ), "ms", null );
            c.create ();
        }
    }

    @Override
    protected void generateForMaster ( final GenerationContext context, final MasterContext master )
    {
        super.generateForMaster ( context, master );
        addDebianDependency ( master.getImplementation (), "eclipse-scada-ping" ); //$NON-NLS-1$
    }

}
