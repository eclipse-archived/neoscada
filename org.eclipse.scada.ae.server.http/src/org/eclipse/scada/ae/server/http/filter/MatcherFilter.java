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
import org.eclipse.scada.ae.filter.EventMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatcherFilter extends FilterEntry
{
    private final static Logger logger = LoggerFactory.getLogger ( MatcherFilter.class );

    private final EventMatcher eventMatcher;

    public MatcherFilter ( final String id, final long priority, final EventMatcher eventMatcher )
    {
        super ( id, priority );
        this.eventMatcher = eventMatcher;
    }

    @Override
    public boolean matches ( final Event event )
    {
        final boolean result = this.eventMatcher.matches ( event );

        logger.trace ( "Matching filter - event: {}, result: {}", event, result );

        return result;
    }

}
