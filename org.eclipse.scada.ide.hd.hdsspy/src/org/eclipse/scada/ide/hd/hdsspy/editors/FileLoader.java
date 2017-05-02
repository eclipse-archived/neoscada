/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ide.hd.hdsspy.editors;

import java.io.IOException;
import java.util.Date;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.scada.hds.DataFileAccessorImpl;
import org.eclipse.scada.hds.DataFileAccessorImpl.EntryVisitor;
import org.eclipse.scada.ide.hd.hdsspy.Activator;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.IFileEditorInput;

public class FileLoader implements ArchiveLoader
{

    private final IFileEditorInput input;

    public FileLoader ( final IFileEditorInput input )
    {
        this.input = input;
    }

    @Override
    public void performLoad ( final WritableList list ) throws CoreException
    {
        final IFile file = this.input.getFile ();

        if ( file == null )
        {
            return;
        }

        DataFileAccessorImpl accessor;
        try
        {
            accessor = new DataFileAccessorImpl ( file.getLocation ().toFile () );
        }
        catch ( final Exception e )
        {
            throw new CoreException ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }

        try
        {
            accessor.forwardVisitAll ( new EntryVisitor () {

                @Override
                public boolean visitEntry ( final long timestamp, final double value, final byte flags )
                {
                    list.add ( new ArchiveEntry ( new Date ( timestamp ), value,
                            ( flags & DataFileAccessorImpl.FLAG_ERROR ) > 0,
                            ( flags & DataFileAccessorImpl.FLAG_MANUAL ) > 0,
                            ( flags & DataFileAccessorImpl.FLAG_DELETED ) > 0,
                            ( flags & DataFileAccessorImpl.FLAG_HEARTBEAT ) > 0 ) );
                    return true;
                }
            } );
        }
        catch ( final IOException e )
        {
            throw new CoreException ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
        finally
        {
            accessor.dispose ();
        }
    }
}
