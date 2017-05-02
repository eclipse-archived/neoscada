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
package org.eclipse.scada.ae.event.logger.internal;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;

public class DataItemValueDiff
{
    private static final DataItemValue DEFAULT_VALUE = DataItemValue.DISCONNECTED;

    public static DataItemValue diff ( DataItemValue source, DataItemValue target )
    {
        final Builder builder = new Builder ();

        if ( source == null )
        {
            source = DEFAULT_VALUE;
        }
        if ( target == null )
        {
            target = DEFAULT_VALUE;
        }

        builder.setValue ( changed ( source.getValue (), target.getValue () ) );
        builder.setSubscriptionState ( changed ( source.getSubscriptionState (), target.getSubscriptionState () ) );
        builder.setAttributes ( AttributesHelper.diff ( source.getAttributes (), target.getAttributes () ) );

        return builder.build ();
    }

    /**
     * Check if data changed from source to target
     * @param <T> the type to check
     * @param source the original value
     * @param target the new value
     * @return the target value if it is different to the source value, <code>null</code> otherwise
     */
    private static <T> T changed ( final T source, final T target )
    {
        if ( source == target )
        {
            return null;
        }
        if ( source == null )
        {
            return target;
        }
        if ( target == null )
        {
            return null;
        }
        // now we are sure that neither source nor target are null
        if ( source.equals ( target ) )
        {
            return null;
        }
        return target;
    }
}
