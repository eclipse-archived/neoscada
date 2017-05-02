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
package org.eclipse.scada.vi.details.swt.widgets;

import org.eclipse.scada.vi.details.swt.widgets.control.ControlImage;
import org.eclipse.scada.vi.details.swt.widgets.control.TrendControlImage;
import org.eclipse.swt.SWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Helper
{

    private final static Logger logger = LoggerFactory.getLogger ( Helper.class );

    public static TrendControlImage createTrendButton ( final ControlImage controlImage, final String connectionId, final String itemId, final String queryString )
    {
        logger.debug ( "Checking createTrendButton - connectionId: {}, itemId: {}, queryString: {}", new Object[] { connectionId, itemId, queryString } );

        if ( connectionId == null || connectionId.isEmpty () )
        {
            return null;
        }

        if ( itemId == null || itemId.isEmpty () )
        {
            return null;
        }

        return new TrendControlImage ( controlImage.getClientSpace (), SWT.NONE, connectionId, itemId, queryString );
    }
}
