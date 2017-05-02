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
package org.eclipse.scada.ide.hd.hdsspy.decorators;

import java.util.Date;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.scada.hds.DataFileAccessorImpl;

import com.ibm.icu.text.DateFormat;

public class TimeRangeDecorator implements ILightweightLabelDecorator
{

    private static final String CONTENT_TYPE = "org.eclipse.scada.hds.archive";

    @Override
    public void decorate ( final Object element, final IDecoration decoration )
    {
        try
        {
            final IFile resource = (IFile)element;
            final String timeframe = getTimeframe ( resource );
            if ( timeframe != null )
            {
                decoration.addSuffix ( " " + timeframe );
            }
        }
        catch ( final Exception e )
        {
        }

    }

    private final DateFormat START = DateFormat.getDateTimeInstance ();

    private final DateFormat END = DateFormat.getTimeInstance ();

    private String getTimeframe ( final IFile resource ) throws Exception
    {
        final String id = resource.getContentDescription ().getContentType ().getId ();
        if ( !id.equals ( CONTENT_TYPE ) )
        {
            return null;
        }
        final DataFileAccessorImpl accessor = new DataFileAccessorImpl ( resource.getLocation ().toFile () );
        try
        {
            final Date start = accessor.getStart ();
            final Date end = accessor.getEnd ();
            return String.format ( "%s -> %s", this.START.format ( start ), this.END.format ( end ) );
        }
        finally
        {
            accessor.dispose ();
        }
    }

    @Override
    public void addListener ( final ILabelProviderListener listener )
    {
    }

    @Override
    public void dispose ()
    {
    }

    @Override
    public boolean isLabelProperty ( final Object element, final String property )
    {
        return false;
    }

    @Override
    public void removeListener ( final ILabelProviderListener listener )
    {
    }
}