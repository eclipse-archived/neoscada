/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.ui.databinding.AdapterHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionHolderTester extends PropertyTester
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionHolderTester.class );

    @Override
    public boolean test ( final Object receiver, final String property, final Object[] args, final Object expectedValue )
    {
        logger.debug ( "Testing: {} for {}", receiver, property );
        final ConnectionHolder holder = AdapterHelper.adapt ( receiver, ConnectionHolder.class );
        if ( holder == null )
        {
            return false;
        }

        if ( "stored".equals ( property ) && expectedValue instanceof Boolean ) //$NON-NLS-1$
        {
            if ( holder.getDiscoverer () == null )
            {
                return false;
            }

            // check if the connection holder was coming from a store
            if ( (Boolean)expectedValue )
            {
                return holder.getDiscoverer ().getStore () != null;
            }
            else
            {
                return holder.getDiscoverer ().getStore () == null;
            }
        }

        if ( "interfaceName".equals ( property ) && expectedValue != null ) //$NON-NLS-1$
        {
            if ( holder.getConnectionInformation () == null )
            {
                return false;
            }
            if ( holder.getConnectionInformation ().getConnectionInformation () == null )
            {
                return false;
            }
            if ( holder.getConnectionInformation ().getConnectionInformation ().getInterface () == null )
            {
                return false;
            }
            return holder.getConnectionInformation ().getConnectionInformation ().getInterface ().equals ( expectedValue );
        }

        // default to false
        return false;
    }

}
