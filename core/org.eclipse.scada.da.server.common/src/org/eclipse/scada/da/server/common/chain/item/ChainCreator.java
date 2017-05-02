/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.common.chain.item;

import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.common.chain.DataItemBaseChained;

/**
 * A default chain creator
 * 
 * @author Jens Reimann
 */
public class ChainCreator
{
    public static void applyDefaultInputChain ( final DataItemBaseChained item )
    {
        item.addChainElement ( IODirection.INPUT, new SumAlarmChainItem () );
        item.addChainElement ( IODirection.INPUT, new SumErrorChainItem () );
    }
}
