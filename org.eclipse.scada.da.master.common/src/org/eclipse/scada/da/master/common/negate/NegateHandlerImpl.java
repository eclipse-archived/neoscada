/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.master.common.negate;

import java.util.HashMap;
import java.util.Map;

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

public class NegateHandlerImpl extends AbstractCommonHandlerImpl
{
    private boolean active;

    private final String attrValueOriginal;

    private final String attrActive;

    public NegateHandlerImpl ( final String configurationId, final ObjectPoolTracker<MasterItem> poolTracker, final int priority, final ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker )
    {
        super ( configurationId, poolTracker, priority, caTracker, NegateHandlerFactoryImpl.FACTORY_ID, NegateHandlerFactoryImpl.FACTORY_ID );

        this.attrActive = getPrefixed ( "active", Activator.getStringInterner () );
        this.attrValueOriginal = getPrefixed ( "value.original", Activator.getStringInterner () );
    }

    @Override
    protected void processDataUpdate ( final Map<String, Object> context, final DataItemValue.Builder builder ) throws Exception
    {
        injectAttributes ( builder );

        if ( this.active )
        {
            builder.setAttribute ( this.attrValueOriginal, builder.getValue () );
        }

        final Variant val = builder.getValue ();
        if ( val == null || val.isNull () )
        {
            return;
        }

        builder.setValue ( handleDataUpdate ( builder.getValue () ) );
    }

    private Variant handleDataUpdate ( final Variant value )
    {
        if ( !this.active )
        {
            return value;
        }
        else
        {
            return Variant.valueOf ( !value.asBoolean () );
        }
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> parameters ) throws Exception
    {
        super.update ( userInformation, parameters );

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        this.active = cfg.getBoolean ( "active", false ); //$NON-NLS-1$

        reprocess ();
    }

    protected void injectAttributes ( final Builder builder )
    {
        builder.setAttribute ( this.attrActive, this.active ? Variant.TRUE : Variant.FALSE );
    }

    @Override
    protected WriteAttributeResults handleUpdate ( final Map<String, Variant> attributes, final OperationParameters operationParameters ) throws Exception
    {
        final Map<String, String> data = new HashMap<String, String> ();

        final Variant active = attributes.get ( "active" ); //$NON-NLS-1$

        if ( active != null && !active.isNull () )
        {
            data.put ( "active", active.asString () ); //$NON-NLS-1$
        }

        return updateConfiguration ( data, attributes, false, operationParameters );
    }

}
