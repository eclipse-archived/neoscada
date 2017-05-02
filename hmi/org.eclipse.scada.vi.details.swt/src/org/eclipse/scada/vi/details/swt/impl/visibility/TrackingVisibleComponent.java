/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl.visibility;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.widgets.GenericComposite;
import org.eclipse.swt.widgets.Control;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TrackingVisibleComponent implements VisibleComponent
{

    private final static Logger logger = LoggerFactory.getLogger ( TrackingVisibleComponent.class );

    private final List<Control> controls = new LinkedList<Control> ();

    private final WritableSet items = new WritableSet ();

    protected SummaryProvider summaryProvider;

    protected void trackControl ( final Control control )
    {
        this.controls.add ( control );
    }

    protected void untrackControl ( final Control control )
    {
        this.controls.remove ( control );
    }

    protected void setSummaryProvider ( final SummaryProvider summaryProvider )
    {
        this.summaryProvider = summaryProvider;
    }

    @Override
    public SummaryProvider getSummaryProvider ()
    {
        return this.summaryProvider;
    }

    @Override
    public void start ()
    {
        for ( final Control control : this.controls )
        {
            if ( control instanceof GenericComposite )
            {
                ( (GenericComposite)control ).start ();
            }
        }
    }

    @Override
    public void stop ()
    {
        for ( final Control control : this.controls )
        {
            if ( control instanceof GenericComposite )
            {
                ( (GenericComposite)control ).stop ();
            }
        }
    }

    @Override
    public void show ()
    {
        logger.debug ( "Showing component" );

        for ( final Control control : this.controls )
        {
            control.setVisible ( true );
        }
    }

    @Override
    public void hide ()
    {
        for ( final Control control : this.controls )
        {
            control.setVisible ( false );
        }
    }

    @Override
    public void dispose ()
    {
        for ( final Control control : this.controls )
        {
            control.dispose ();
        }
    }

    protected void trackItem ( final DataItemDescriptor item )
    {
        if ( item != null )
        {
            this.items.add ( item );
        }
    }

    protected void untrackItem ( final DataItemDescriptor item )
    {
        this.items.remove ( item );
    }

    @Override
    public IObservableSet getDescriptors ()
    {
        return this.items;
    }

}
