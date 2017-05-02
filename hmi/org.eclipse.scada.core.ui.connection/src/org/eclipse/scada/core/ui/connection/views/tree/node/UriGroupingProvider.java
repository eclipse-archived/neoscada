/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.views.tree.node;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.ui.connection.ConnectionDescriptor;

public class UriGroupingProvider implements GroupingProvider
{

    @Override
    public List<String> getGroups ( final ConnectionDescriptor connectionDescriptor )
    {
        final ConnectionInformation info = connectionDescriptor.getConnectionInformation ();

        final ArrayList<String> list = new ArrayList<String> ();

        if ( info.getInterface () != null )
        {
            list.add ( info.getInterface () );
        }
        if ( info.getDriver () != null )
        {
            list.add ( info.getDriver () );
        }
        if ( info.getTarget () != null )
        {
            list.add ( info.getTarget () );
        }
        if ( info.getSecondaryTarget () != null )
        {
            list.add ( "" + info.getSecondaryTarget () );
        }

        return list;
    }

}
