/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.views;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.ae.ui.views.config.ConfigurationHelper;
import org.eclipse.scada.ae.ui.views.config.MonitorViewConfiguration;
import org.eclipse.scada.utils.str.StringHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class MonitorsView extends MonitorSubscriptionAlarmsEventsView
{

    private final static Logger logger = LoggerFactory.getLogger ( MonitorsView.class );

    public static final String ID = "org.eclipse.scada.ae.ui.views.views.monitors"; //$NON-NLS-1$

    private MonitorsViewTable monitorsTable = null;

    private List<ColumnProperties> initialColumnSettings = null;

    private final Gson gson = new GsonBuilder ().create ();

    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    @Override
    public void createPartControl ( final Composite parent )
    {
        super.createPartControl ( parent );

        this.monitorsTable = new MonitorsViewTable ( getContentPane (), getViewSite (), SWT.BORDER, this.monitors, this.initialColumnSettings );
        this.monitorsTable.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true, 1, 1 ) );

        loadConfiguration ();
    }

    private void loadConfiguration ()
    {
        final MonitorViewConfiguration cfg = ConfigurationHelper.findMonitorViewConfiguration ( getViewSite ().getSecondaryId () );
        if ( cfg != null )
        {
            try
            {
                setConfiguration ( cfg );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to apply configuration", e ); //$NON-NLS-1$
            }
        }
        else
        {
            logger.info ( "no configuration found" ); //$NON-NLS-1$
        }
    }

    protected void setConfiguration ( final MonitorViewConfiguration cfg ) throws Exception
    {
        setMonitorsId ( cfg.getMonitorQueryId () );
        switch ( cfg.getConnectionType () )
        {
            case URI:
                setConnectionUri ( cfg.getConnectionString () );
                break;
            case ID:
                setConnectionId ( cfg.getConnectionString () );
                break;
        }

        if ( cfg.getLabel () != null )
        {
            setPartName ( cfg.getLabel () );
        }
        if ( this.initialColumnSettings == null )
        {
            this.monitorsTable.applyColumSettings ( cfg.getColumns () );
        }
    }

    /**
     * Passing the focus request to the viewer's control.
     */
    @Override
    public void setFocus ()
    {
        this.monitorsTable.setFocus ();
    }

    @Override
    protected void watchPool ( final String poolId )
    {
        // pass
    }

    @Override
    protected void watchMonitors ( final String monitorsId )
    {
        setMonitorsId ( monitorsId );
    }

    @Override
    protected void updateStatusBar ()
    {
        scheduleJob ( new Runnable () {
            @Override
            public void run ()
            {
                setStatusBarText ( createStatusLabel () );
            }
        } );
    }

    protected void setStatusBarText ( final String string )
    {
        if ( getStateLabel ().isDisposed () )
        {
            return;
        }

        getStateLabel ().setText ( string );
    }

    protected String createStatusLabel ()
    {
        final List<String> labels = new LinkedList<String> ();
        labels.add ( getLabelForConnection () );

        if ( this.monitorSubscriptionState != null )
        {
            labels.add ( this.monitorSubscriptionState.toString () );
        }

        if ( this.monitorsId != null )
        {
            labels.add ( String.format ( Messages.MonitorsView_Label_Format_Monitors, this.monitorsId ) );
        }
        else
        {
            labels.add ( Messages.MonitorsView_Label_Format_NoMonitors );
        }

        labels.add ( String.format ( Messages.MonitorsView_Label_Format_CountMonitors, MonitorsView.this.monitors.size () ) );

        return StringHelper.join ( labels, Messages.MonitorsView_Sep );
    }

    @Override
    public void init ( final IViewSite site, final IMemento memento ) throws PartInitException
    {
        super.init ( site, memento );

        if ( memento != null )
        {
            final String s = memento.getString ( "columnSettings" ); //$NON-NLS-1$
            if ( s != null )
            {
                this.initialColumnSettings = this.gson.fromJson ( s, new TypeToken<List<ColumnProperties>> () {}.getType () );
            }
        }
    }

    @Override
    public void saveState ( final IMemento memento )
    {
        memento.putString ( "columnSettings", this.gson.toJson ( this.monitorsTable.getColumnSettings () ) ); //$NON-NLS-1$
        super.saveState ( memento );
    }
}