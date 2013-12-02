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
package org.eclipse.scada.configuration.world.lib.oscar;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.osgi.MasterServer;

public class MasterServerProcessor extends EquinoxApplicationProcessor
{

    private final MasterServer app;

    private final MasterHandlerPriorities priorities;

    public MasterServerProcessor ( final World world, final MasterServer app )
    {
        super ( app );
        this.priorities = new MasterHandlerPriorities ( world );
        this.app = app;
    }

    @Override
    protected void processForContext ( final OscarContext ctx, final IFolder output, final IProgressMonitor monitor )
    {
        // run stuff
        new AlarmsEventsModuleProcessor ( this.app, ctx ).process ( new SubProgressMonitor ( monitor, 1 ) );
        new ItemProcessor ( this.app, ctx, this.priorities ).process ();
        new ItemExportProcessor ( this.app, ctx ).process ();
        new MarkerGroupProcessor ( this.app, ctx, this.priorities ).process ();
        new AlarmsAndEventsProcessor ( this.app, ctx ).process ();
        new DataMapperProcessor ( this.app, ctx ).process ();
        new AverageProcessor ( this.app, ctx ).process ();
        new BlockingProcessor ( this.app, ctx ).process (); // this could actually run on different applications
    }

    @Override
    protected void customizeContext ( final OscarContext context )
    {
        super.customizeContext ( context );

        context.addIgnoreFields ( Factories.FACTORY_MASTER_HANDLER_MANUAL, "value", "user", "reason", "timestamp" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ 
        context.addIgnoreFields ( Factories.FACTORY_MASTER_HANDLER_BLOCK, "note", "active", "user", "timestamp" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ 
        context.addIgnoreFields ( Factories.FACTORY_AE_MONITOR_LEVEL, "preset", "active" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        context.addIgnoreFields ( Factories.FACTORY_AE_MONITOR_LIST, "active" ); //$NON-NLS-1$ 
        context.addIgnoreFields ( Factories.FACTORY_AE_MONITOR_BIT, "active", "reference" ); //$NON-NLS-1$ //$NON-NLS-2$
        context.addIgnoreFields ( Factories.FACTORY_MASTER_HANDLER_MARKER, "active" ); //$NON-NLS-1$
        context.addIgnoreFields ( Factories.FACTORY_MASTER_HANDLER_SCALE, "active", "factor" ); //$NON-NLS-1$ //$NON-NLS-2$ 
    }
}
