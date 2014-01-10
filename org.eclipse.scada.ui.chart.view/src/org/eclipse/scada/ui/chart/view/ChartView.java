/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.Charts;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.codec.Base64;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.statushandlers.StatusManager;

public class ChartView extends AbstractChartView
{
    public static final String VIEW_ID = "org.eclipse.scada.ui.chart.ChartView";

    private Chart configuration;

    @Override
    public void createPartControl ( final Composite parent )
    {
        super.createPartControl ( parent );

        if ( this.configuration == null )
        {
            this.configuration = Charts.makeDefaultConfiguration ();
            this.configuration.setMutable ( true );
        }

        createView ( this.configuration );
    }

    @Override
    public void init ( final IViewSite site, final IMemento memento ) throws PartInitException
    {
        super.init ( site, memento );

        if ( memento == null )
        {
            return;
        }

        final IMemento child = memento.getChild ( "configuration" );
        if ( child == null )
        {
            return;
        }

        final String data = child.getTextData ();
        if ( data == null || data.isEmpty () )
        {
            return;
        }

        try
        {
            this.configuration = load ( new ByteArrayInputStream ( Base64.decode ( data ) ) );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
        }
    }

    @Override
    public void saveState ( final IMemento memento )
    {
        super.saveState ( memento );
        if ( memento == null )
        {
            return;
        }

        final Resource resource = new XMIResourceFactoryImpl ().createResource ( null );
        resource.getContents ().add ( this.configuration );

        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream ();

        final Map<?, ?> options = new HashMap<Object, Object> ();

        try
        {
            resource.save ( outputStream, options );
            final IMemento child = memento.createChild ( "configuration" );

            child.putTextData ( Base64.encodeBytes ( outputStream.toByteArray () ) );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
        }
    }

}
