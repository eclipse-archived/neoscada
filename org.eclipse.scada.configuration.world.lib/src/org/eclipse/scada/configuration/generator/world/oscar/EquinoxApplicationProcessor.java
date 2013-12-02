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

import java.io.FileOutputStream;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.scada.ca.oscar.OscarWriter;
import org.eclipse.scada.configuration.generator.world.AbstractFolderProcessor;
import org.eclipse.scada.configuration.generator.world.internal.Activator;
import org.eclipse.scada.configuration.generator.world.oscar.sec.SecurityProcessor;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;

public abstract class EquinoxApplicationProcessor extends AbstractFolderProcessor
{

    private final EquinoxApplication app;

    public EquinoxApplicationProcessor ( final EquinoxApplication app )
    {
        super ( app );
        this.app = app;
    }

    protected Collection<OscarProcessor> createProcessors ()
    {
        final Collection<OscarProcessor> result = new LinkedList<> ();

        result.addAll ( Activator.createProcessors () );

        return result;
    }

    @Override
    public void processLocal ( final IFolder output, final IProgressMonitor parentMonitor ) throws Exception
    {
        final IProgressMonitor monitor = new SubProgressMonitor ( parentMonitor, 11 );

        // create context

        final OscarContext ctx = createContext ();

        // generate common content

        new SecurityProcessor ( this.app, ctx ).process ( new SubProgressMonitor ( monitor, 1 ) );
        new JdbcUserServiceModuleProcessor ( this.app, ctx ).process ( new SubProgressMonitor ( monitor, 1 ) );
        new EventStoragePostgresModuleProcessor ( this.app, ctx ).process ( new SubProgressMonitor ( monitor, 1 ) );
        new EventStorageJdbcModuleProcessor ( this.app, ctx ).process ( new SubProgressMonitor ( monitor, 1 ) );
        new ConnectionProcessor ( this.app, ctx ).process ();
        new ExporterProcessor ( this.app, ctx ).process ();

        // generate based on processors

        final Collection<OscarProcessor> processors = createProcessors ();
        monitor.worked ( 1 );
        {
            final SubProgressMonitor subMonitor = new SubProgressMonitor ( monitor, 1 );
            subMonitor.beginTask ( "Process application modules", processors.size () );

            for ( final OscarProcessor processor : processors )
            {
                processor.process ( ctx, this.app, subMonitor );
                subMonitor.worked ( 1 );
            }
            subMonitor.done ();
        }

        // generate custom content

        processForContext ( ctx, output, monitor );

        // write out oscar context

        final OscarWriter writer = new OscarWriter ( ctx.getData (), ctx.getIgnoreFields () );
        monitor.worked ( 1 );

        final IFile file = output.getFile ( "configuration.oscar" ); //$NON-NLS-1$
        try (FileOutputStream fos = new FileOutputStream ( file.getRawLocation ().toOSString () ))
        {
            writer.write ( fos );
        }
        monitor.worked ( 1 );

        final IFile jsonFile = output.getFile ( "data.json" ); //$NON-NLS-1$
        try (final FileOutputStream fos = new FileOutputStream ( jsonFile.getRawLocation ().toOSString () ))
        {
            OscarWriter.writeData ( ctx.getData (), fos );
        }
        monitor.worked ( 1 );

        // write out profile
        new P2ProfileProcessor ( this.app ).process ( output.getLocation ().toFile (), monitor );
        monitor.worked ( 1 );

        // refresh
        output.refreshLocal ( IResource.DEPTH_INFINITE, monitor );

        monitor.done ();
    }

    protected abstract void processForContext ( OscarContext ctx, IFolder output, IProgressMonitor monitor ) throws Exception;

    private OscarContext createContext ()
    {
        final OscarContext result = new OscarContext ();

        customizeContext ( result );

        return result;
    }

    protected void customizeContext ( final OscarContext result )
    {
    }
}