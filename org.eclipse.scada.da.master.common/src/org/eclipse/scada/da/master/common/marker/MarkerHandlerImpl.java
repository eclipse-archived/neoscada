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
package org.eclipse.scada.da.master.common.marker;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.da.master.common.AbstractCommonHandlerImpl;
import org.eclipse.scada.da.master.common.internal.Activator;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.util.tracker.ServiceTracker;

public class MarkerHandlerImpl extends AbstractCommonHandlerImpl
{

    private static class Configuration extends AbstractConfiguration
    {
        private boolean active;

        private boolean exportAttribute;

        private boolean alwaysExport;

        private Map<String, Object> markers;

        public Configuration ( final Configuration currentConfiguration, final AbstractCommonHandlerImpl commonHandler, final EventProcessor eventProcessor )
        {
            super ( currentConfiguration, commonHandler, eventProcessor );
            if ( currentConfiguration != null )
            {
                this.active = currentConfiguration.active;
                this.exportAttribute = currentConfiguration.exportAttribute;
                this.alwaysExport = currentConfiguration.alwaysExport;
                this.markers = currentConfiguration.markers;
            }
        }

        public void setActive ( final UserInformation userInformation, final boolean active )
        {
            this.active = update ( userInformation, this.active, active );
        }

        public void setExportAttribute ( final boolean exportAttribute )
        {
            this.exportAttribute = exportAttribute;
        }

        public void setAlwaysExport ( final boolean alwaysExport )
        {
            this.alwaysExport = alwaysExport;
        }

        public void setMarkers ( final Map<String, Object> markers )
        {
            this.markers = markers;
        }

    }

    private Configuration configuration;

    private final EventProcessor eventProcessor;

    private final String attrActive;

    public MarkerHandlerImpl ( final String configurationId, final EventProcessor eventProcessor, final ObjectPoolTracker<MasterItem> poolTracker, final int priority, final ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker )
    {
        super ( configurationId, poolTracker, priority, caTracker, MarkerHandlerFactoryImpl.FACTORY_ID + "." + configurationId, MarkerHandlerFactoryImpl.FACTORY_ID );
        this.eventProcessor = eventProcessor;

        this.attrActive = getPrefixed ( "active", Activator.getStringInterner () );
    }

    @Override
    protected void processDataUpdate ( final Map<String, Object> context, final DataItemValue.Builder builder ) throws Exception
    {
        injectAttributes ( context, builder );
    }

    protected void injectAttributes ( final Map<String, Object> context, final Builder builder )
    {
        if ( this.configuration == null )
        {
            return;
        }

        if ( this.configuration.active )
        {
            context.putAll ( this.configuration.markers );
        }

        if ( this.configuration.exportAttribute )
        {
            if ( this.configuration.active || this.configuration.alwaysExport )
            {
                builder.setAttribute ( this.attrActive, Variant.valueOf ( this.configuration.active ) );
            }
        }
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> parameters ) throws Exception
    {
        super.update ( userInformation, parameters );

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final Configuration c = new Configuration ( this.configuration, this, this.eventProcessor );
        c.setActive ( userInformation, cfg.getBoolean ( "active", false ) );
        c.setExportAttribute ( cfg.getBoolean ( "exportAttribute", false ) );
        c.setAlwaysExport ( cfg.getBoolean ( "alwaysExport", false ) );

        // get markers
        final Map<String, Object> markers = new HashMap<String, Object> ();
        for ( final Map.Entry<String, String> entry : cfg.getPrefixed ( "marker." ).entrySet () )
        {
            final String value = entry.getValue ();
            if ( value == null || value.isEmpty () )
            {
                markers.put ( Activator.getStringInterner ().intern ( entry.getKey () ), true );
            }
            else
            {
                markers.put ( Activator.getStringInterner ().intern ( entry.getKey () ), value );
            }
        }
        c.setMarkers ( markers );

        this.configuration = c;
        c.sendEvents ();

        reprocess ();
    }

    @Override
    protected void injectEventAttributes ( final EventBuilder builder )
    {
        super.injectEventAttributes ( builder );
        builder.attribute ( Fields.MONITOR_TYPE, "MARKER" ); //$NON-NLS-1$
    }

    @Override
    protected WriteAttributeResults handleUpdate ( final Map<String, Variant> attributes, final OperationParameters operationParameters ) throws Exception
    {
        final Map<String, String> data = new HashMap<String, String> ();

        if ( this.configuration != null )
        {
            final Variant active = attributes.get ( "active" ); //$NON-NLS-1$

            if ( active != null && !active.isNull () )
            {
                data.put ( "active", active.asBoolean () ? "true" : "false" ); //$NON-NLS-1$
            }
        }

        return updateConfiguration ( data, attributes, false, operationParameters );
    }

}
