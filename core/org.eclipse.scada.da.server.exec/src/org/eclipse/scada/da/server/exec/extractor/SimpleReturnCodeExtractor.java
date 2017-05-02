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
package org.eclipse.scada.da.server.exec.extractor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.item.factory.FolderItemFactory;
import org.eclipse.scada.da.server.exec.Hive;

/**
 * Extract information based on the return code of the process
 * @author Jens Reimann
 *
 */
public class SimpleReturnCodeExtractor extends AbstractReturnCodeExtractor
{
    private DataItemInputChained failedItem;

    public SimpleReturnCodeExtractor ( final String id )
    {
        super ( id );
    }

    @Override
    protected void handleReturnCode ( final int rc )
    {
        this.failedItem.updateData ( Variant.valueOf ( rc < 0 ), null, null );
    }

    @Override
    public void register ( final Hive hive, final FolderItemFactory folderItemFactory )
    {
        super.register ( hive, folderItemFactory );
        this.failedItem = createInput ( "failed" );
    }

}
