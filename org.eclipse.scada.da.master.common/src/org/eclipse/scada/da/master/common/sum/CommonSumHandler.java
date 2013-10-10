/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.master.common.sum;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.eclipse.scada.da.master.AbstractMasterHandlerImpl;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;

public class CommonSumHandler extends AbstractMasterHandlerImpl
{

    private volatile List<Entry> entries = new LinkedList<Entry> ();

    public CommonSumHandler ( final ObjectPoolTracker<MasterItem> poolTracker )
    {
        super ( poolTracker );
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final Map<String, String> parameters ) throws Exception
    {
        super.update ( userInformation, parameters );
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final boolean debug = cfg.getBoolean ( "debug", false );

        final List<Entry> entries = new LinkedList<Entry> ();

        final String[] tags = cfg.getStringChecked ( "tag", "'tag' must be set" ).split ( ", ?" );
        for ( final String tag : tags )
        {
            final String prefix = cfg.getString ( String.format ( "tag.%s.prefix", tag ), "osgi.source" );
            final String suffix = cfg.getString ( String.format ( "tag.%s.suffix", tag ) );
            final String pattern = cfg.getString ( String.format ( "tag.%s.pattern", tag ) );
            entries.add ( new Entry ( tag, prefix, suffix, pattern, debug ) );
        }

        // now assign
        this.entries = entries;

        reprocess ();
    }

    @Override
    public void dataUpdate ( final Map<String, Object> context, final DataItemValue.Builder builder )
    {
        // convert source errors
        convertSource ( builder );

        for ( final Entry entry : this.entries )
        {
            entry.start ( context, builder );
        }

        // sum up
        for ( final Map.Entry<String, Variant> valueEntry : builder.getAttributes ().entrySet () )
        {
            final Variant pValue = valueEntry.getValue ();
            final String name = valueEntry.getKey ();

            for ( final Entry entry : this.entries )
            {
                entry.check ( name, pValue );
            }
        }

        for ( final Entry entry : this.entries )
        {
            entry.end ( context, builder );
        }
    }

    private void convertSource ( final Builder builder )
    {
        for ( final Entry entry : this.entries )
        {
            entry.convertSource ( builder );
        }
    }

}