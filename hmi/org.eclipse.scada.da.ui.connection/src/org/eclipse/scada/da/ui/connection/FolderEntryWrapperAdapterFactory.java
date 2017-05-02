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
package org.eclipse.scada.da.ui.connection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.da.core.browser.DataItemEntry;
import org.eclipse.scada.da.core.browser.FolderEntry;
import org.eclipse.scada.da.ui.connection.data.Item;

public class FolderEntryWrapperAdapterFactory implements IAdapterFactory
{

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Object adaptableObject, final Class adapterType )
    {
        if ( adaptableObject instanceof IAdaptable )
        {
            return ( (IAdaptable)adaptableObject ).getAdapter ( adapterType );
        }
        return null;
    }

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Class[] getAdapterList ()
    {
        return new Class[] { DataItemEntry.class, FolderEntry.class, Item.class };
    }

}
