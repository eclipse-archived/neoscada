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
 * Extract information based on the nagios scheme using the return code
 * @author Jens Reimann
 *
 */
public class NagiosExtractor extends AbstractReturnCodeExtractor
{
    private DataItemInputChained errorItem;

    private DataItemInputChained warningItem;

    public NagiosExtractor ( final String id )
    {
        super ( id );
    }

    @Override
    protected void handleReturnCode ( final int rc )
    {
        if ( rc < 0 )
        {
            throw new RuntimeException ( String.format ( "Command excution failed: rc = %s", rc ) );
        }

        if ( rc == 0 )
        {
            this.errorItem.updateData ( Variant.valueOf ( rc >= 2 ), null, null );
            this.warningItem.updateData ( Variant.valueOf ( rc >= 1 ), null, null );
        }
    }

    @Override
    public void register ( final Hive hive, final FolderItemFactory folderItemFactory )
    {
        super.register ( hive, folderItemFactory );
        this.errorItem = createInput ( "error" );
        this.warningItem = createInput ( "warning" );
    }

}
