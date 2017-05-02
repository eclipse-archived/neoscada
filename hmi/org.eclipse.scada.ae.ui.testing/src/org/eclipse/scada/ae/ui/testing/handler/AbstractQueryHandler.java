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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.ae.ui.testing.navigator.QueryBean;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;

public abstract class AbstractQueryHandler extends AbstractSelectionHandler
{
    protected Collection<QueryBean> getQueryList ()
    {
        final IStructuredSelection sel = getSelection ();

        if ( sel == null )
        {
            return Collections.emptyList ();

        }

        final Collection<QueryBean> result = new LinkedList<QueryBean> ();
        final Iterator<?> i = sel.iterator ();
        while ( i.hasNext () )
        {
            final Object o = i.next ();
            if ( o instanceof QueryBean )
            {
                result.add ( (QueryBean)o );
            }
        }

        return result;
    }

}