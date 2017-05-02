/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new AdapterHelper
 *******************************************************************************/
package org.eclipse.scada.hd.ui.connection.handler;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.hd.ui.data.QueryBuffer;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public abstract class AbstractQueryHandler extends AbstractSelectionHandler
{
    protected Collection<QueryBuffer> getQueries ()
    {
        final Collection<QueryBuffer> result = new LinkedList<QueryBuffer> ();

        final IStructuredSelection sel = getSelection ();

        if ( sel != null && !sel.isEmpty () )
        {
            for ( final Iterator<?> i = sel.iterator (); i.hasNext (); )
            {
                final Object o = i.next ();

                final QueryBuffer item = AdapterHelper.adapt ( o, QueryBuffer.class );
                if ( item != null )
                {
                    result.add ( item );
                }
            }
        }

        return result;
    }

}