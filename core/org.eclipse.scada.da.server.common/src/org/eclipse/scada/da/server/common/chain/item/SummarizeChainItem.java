/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.common.chain.item;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.chain.BaseChainItemCommon;
import org.eclipse.scada.utils.str.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A chain item that sums up attribute entries that match a specific condition.
 * 
 * @author Jens Reimann &lt;jens.reimann@th4-systems.com&gt;
 */
public abstract class SummarizeChainItem extends BaseChainItemCommon
{

    private final static Logger logger = LoggerFactory.getLogger ( SummarizeChainItem.class );

    private final String sumStateName;

    private final String sumCountName;

    private final String sumListName;

    public SummarizeChainItem ( final String baseName )
    {
        this.sumStateName = baseName;
        this.sumCountName = baseName + ".count";
        this.sumListName = baseName + ".items";

        setReservedAttributes ( this.sumStateName, this.sumCountName, this.sumListName );
    }

    /**
     * The method that will check if the attribute entry matches the condition.
     * 
     * @param value
     *            The current item value
     * @param attributeName
     *            The attribute name
     * @param attributeValue
     *            The attribute value
     * @return <code>true</code> if the entry should match, <code>false</code>
     *         otherwise
     */
    protected abstract boolean matches ( Variant value, String attributeName, Variant attributeValue );

    @Override
    public Variant process ( final Variant value, final Map<String, Variant> attributes )
    {
        attributes.put ( this.sumStateName, null );
        attributes.put ( this.sumCountName, null );
        attributes.put ( this.sumListName, null );

        long count = 0;
        final List<String> items = new LinkedList<String> ();
        final Set<String> ignoreItems = getIgnoreItems ();

        for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
        {
            final String attributeName = entry.getKey ();

            // ignore our own entries
            if ( !attributeName.equals ( this.sumStateName ) && !attributeName.equals ( this.sumCountName ) && !attributeName.equals ( this.sumListName ) && !ignoreItems.contains ( attributeName ) )
            {
                try
                {
                    if ( matches ( value, attributeName, entry.getValue () ) )
                    {
                        if ( entry.getValue () != null && entry.getValue ().asBoolean () )
                        {
                            count++;
                            items.add ( entry.getKey () );
                        }
                    }
                }
                catch ( final Exception e )
                {
                    logger.warn ( String.format ( "Failed to summarize item '%s'", attributeName ), e );
                }
            }
        }

        attributes.put ( this.sumStateName, Variant.valueOf ( count > 0 ) );
        attributes.put ( this.sumCountName, Variant.valueOf ( count ) );
        attributes.put ( this.sumListName, Variant.valueOf ( StringHelper.join ( items, ", " ) ) );

        // no change
        return null;
    }

    protected Set<String> getIgnoreItems ()
    {
        return Collections.emptySet ();
    }

}
