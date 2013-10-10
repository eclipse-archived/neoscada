/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.datasource;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue.Builder;

public class Helper
{

    public static Long getTimestamp ( final Builder builder )
    {
        if ( builder == null || builder.getAttributes () == null )
        {
            return null;
        }

        final Variant attr = builder.getAttributes ().get ( "timestamp" );
        if ( attr == null )
        {
            return null;
        }
        return attr.asLong ( null );
    }

}
