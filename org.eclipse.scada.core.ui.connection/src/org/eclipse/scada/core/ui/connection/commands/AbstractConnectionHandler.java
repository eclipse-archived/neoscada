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
package org.eclipse.scada.core.ui.connection.commands;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.databinding.AdapterHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractConnectionHandler extends AbstractSelectionHandler
{
    private static final Logger logger = LoggerFactory.getLogger ( AbstractConnectionHandler.class );

    protected Collection<ConnectionHolder> getConnections ()
    {
        final Collection<ConnectionHolder> result = new LinkedList<ConnectionHolder> ();

        final IStructuredSelection sel = getSelection ();

        if ( sel != null && !sel.isEmpty () )
        {
            for ( final Iterator<?> i = sel.iterator (); i.hasNext (); )
            {
                final Object o = i.next ();

                logger.debug ( "Try to add: {}", o.getClass () ); //$NON-NLS-1$

                final ConnectionHolder holder = (ConnectionHolder)AdapterHelper.adapt ( o, ConnectionHolder.class );
                if ( holder != null )
                {
                    result.add ( holder );
                }
            }
        }

        return result;
    }

}