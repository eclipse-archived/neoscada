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
package org.eclipse.scada.da.server.test.items;

import org.eclipse.scada.da.server.common.DataItemInputCommon;
import org.eclipse.scada.da.server.common.SuspendableDataItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuspendItem extends DataItemInputCommon implements SuspendableDataItem
{
    private final static Logger logger = LoggerFactory.getLogger ( SuspendItem.class );

    public SuspendItem ( final String name )
    {
        super ( name );
    }

    @Override
    public void suspend ()
    {
        logger.warn ( "Item {} suspended", getInformation ().getName () );
    }

    @Override
    public void wakeup ()
    {
        logger.warn ( "Item {} woken up", getInformation ().getName () );
    }

}
