/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common;

import java.util.EnumSet;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public abstract class DataItemOutput extends DataItemBase
{

    public DataItemOutput ( final String id )
    {
        super ( new DataItemInformationBase ( id, EnumSet.of ( IODirection.OUTPUT ) ) );
    }

    @Override
    public NotifyFuture<Variant> readValue () throws InvalidOperationException
    {
        throw new InvalidOperationException ();
    }

}
