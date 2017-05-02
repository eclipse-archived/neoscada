/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.testing.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.ae.ui.testing.navigator.QueryBean;

public class RemoveHandler extends AbstractQueryHandler
{
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        for ( final QueryBean query : getQueryList () )
        {
            query.remove ();
        }
        return null;
    }
}
