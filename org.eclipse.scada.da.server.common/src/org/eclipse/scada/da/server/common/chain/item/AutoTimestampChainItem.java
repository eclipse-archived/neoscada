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

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.chain.BaseChainItemCommon;

/**
 * A chain item which will add a timestamp by default it none is provided.
 * 
 * @author Jens Reimann
 */
public class AutoTimestampChainItem extends BaseChainItemCommon
{
    private Variant lastValue = Variant.NULL;

    @Override
    public Variant process ( final Variant value, final Map<String, Variant> attributes )
    {
        if ( value == null )
        {
            // no value change
            return null;
        }

        if ( !this.lastValue.equals ( value ) )
        {
            if ( !attributes.containsKey ( "timestamp" ) )
            {
                attributes.put ( "timestamp", Variant.valueOf ( System.currentTimeMillis () ) );
            }
            this.lastValue = value;
        }
        return null;
    }

}
