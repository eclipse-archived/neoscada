/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new adapter helper
 *******************************************************************************/
package org.eclipse.scada.da.ui.connection.views;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.scada.core.ui.connection.data.ConnectionHolder;
import org.eclipse.scada.da.core.browser.FolderEntry;
import org.eclipse.scada.da.ui.connection.internal.FolderEntryWrapper;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ConnectionObservableFactory implements IObservableFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionObservableFactory.class );

    @Override
    public IObservable createObservable ( final Object target )
    {
        logger.info ( "create observable: {}", target );

        if ( target instanceof ConnectionHolder )
        {
            return new RootFolderObserver ( (ConnectionHolder)target );
        }
        else if ( target instanceof FolderEntryWrapper )
        {
            final FolderEntry entry = AdapterHelper.adapt ( target, FolderEntry.class );
            if ( entry != null )
            {
                // only return a new observer if the folder entry is of type FolderEntry
                return new SubFolderObserver ( (FolderEntryWrapper)target );
            }
            else
            {
                return null;
            }
        }

        return null;
    }

}