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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.common.item.factory.FolderItemFactory;
import org.eclipse.scada.da.server.exec.Hive;
import org.eclipse.scada.da.server.exec.command.ExecutionResult;

/**
 * Extractor which takes the stream string value as value
 * @author Jens Reimann
 *
 */
public class PlainStreamExtractor extends AbstractBaseExtractor
{
    private DataItemInputChained valueItem;

    public PlainStreamExtractor ( final String id )
    {
        super ( id );
    }

    @Override
    protected void doProcess ( final ExecutionResult result )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        final Variant value = Variant.valueOf ( result.getOutput () );
        attributes.put ( "exec.error", Variant.FALSE );
        attributes.put ( "exec.error.message", null );
        fillNoError ( attributes );

        this.valueItem.updateData ( value, attributes, AttributeMode.UPDATE );
    }

    @Override
    public void register ( final Hive hive, final FolderItemFactory folderItemFactory )
    {
        super.register ( hive, folderItemFactory );
        this.valueItem = createInput ( "value" );
    }
}
