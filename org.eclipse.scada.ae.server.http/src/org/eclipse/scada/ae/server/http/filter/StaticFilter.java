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
package org.eclipse.scada.ae.server.http.filter;

import org.eclipse.scada.ae.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Static filter which always returns the preset result
 * @author Jens Reimann
 *
 */
public class StaticFilter extends FilterEntry
{

    private final static Logger logger = LoggerFactory.getLogger ( StaticFilter.class );

    private final boolean result;

    public StaticFilter ( final String id, final long priority, final boolean result )
    {
        super ( id, priority );
        this.result = result;
    }

    @Override
    public boolean matches ( final Event event )
    {
        logger.trace ( "Matching filter - event: {}, result: {}", event, this.result );
        return this.result;
    }

}
