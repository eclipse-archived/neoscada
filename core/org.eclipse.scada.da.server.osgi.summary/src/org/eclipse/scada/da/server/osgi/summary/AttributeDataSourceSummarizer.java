/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.summary;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.datasource.DataSource;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.eclipse.scada.utils.str.StringHelper;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttributeDataSourceSummarizer extends AbstractDataSourceSummarizer
{

    private final static Logger logger = LoggerFactory.getLogger ( AttributeDataSourceSummarizer.class );

    private final Set<DataSource> matchingSources = new HashSet<DataSource> ();

    private final Builder countValue = new Builder ();

    private String attributeName;

    private boolean onlyMaster;

    private HashSet<String> blacklist;

    public AttributeDataSourceSummarizer ( final Executor executor, final ObjectPoolTracker<DataSource> tracker )
    {
        super ( executor, tracker );
        this.countValue.setSubscriptionState ( SubscriptionState.CONNECTED );
        this.countValue.setValue ( Variant.valueOf ( 0 ) );
        updateData ( this.countValue.build () );
    }

    @Override
    protected void handleAdding ( final DataSource source )
    {
    }

    @Override
    protected synchronized void handleRemoved ( final DataSource source )
    {
        if ( this.matchingSources.remove ( source ) )
        {
            updateStats ();
        }
    }

    @Override
    protected synchronized void handleStateChange ( final DataSource source, final DataItemValue value )
    {
        if ( isMatch ( source, value ) )
        {
            if ( this.matchingSources.add ( source ) )
            {
                updateStats ();
            }
        }
        else
        {
            if ( this.matchingSources.remove ( source ) )
            {
                updateStats ();
            }
        }
    }

    @Override
    protected boolean isMatch ( final DataSource source, final Dictionary<?, ?> properties )
    {
        final Object pid = properties.get ( Constants.SERVICE_PID );

        if ( ! ( pid instanceof String ) )
        {
            logger.debug ( "Rejecting datasource - invalid service.pid - {}", pid );
            return false;
        }

        if ( ! ( source instanceof MasterItem ) && this.onlyMaster )
        {
            logger.debug ( "Rejecting datasource ({}) - class {} but we require master items ", pid, source.getClass () );
            return false;
        }

        if ( this.blacklist.contains ( pid ) )
        {
            logger.debug ( "Rejecting datasource ({}) - service.pid is blacklisted", pid );
            return false;
        }

        return true;
    }

    protected boolean isMatch ( final DataSource source, final DataItemValue value )
    {
        if ( ! ( source instanceof MasterItem ) && this.onlyMaster )
        {
            return false;
        }

        if ( value == null )
        {
            return false;
        }
        if ( value.getAttributes () == null )
        {
            return false;
        }
        final Variant attrValue = value.getAttributes ().get ( this.attributeName );
        if ( attrValue == null )
        {
            return false;
        }
        return attrValue.asBoolean ();
    }

    protected void updateStats ()
    {
        final int count = this.matchingSources.size ();

        logger.debug ( "Update size: {}", count );

        this.countValue.setValue ( Variant.valueOf ( count ) );
        if ( count < 10 )
        {
            this.countValue.setAttribute ( "debug.info", Variant.valueOf ( StringHelper.join ( this.matchingSources, "," ) ) );
        }
        else
        {
            this.countValue.clearAttribute ( "debug.info" );
        }
        updateData ( this.countValue.build () );
    }

    public void dispose ()
    {
        close ();
    }

    public void update ( final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        close ();

        this.attributeName = cfg.getStringChecked ( "attribute", "'attribute' must be set" );
        this.onlyMaster = cfg.getBoolean ( "onlyMaster", false );

        this.blacklist = new HashSet<String> ( cfg.getPrefixed ( "blacklist." ).values () );

        open ();
    }

}
