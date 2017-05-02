/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.component.script;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.chain.WriteHandler;

public interface ScriptContext
{
    public static interface Item
    {
        public String getItemId ();

        public void updateData ( Variant value, Map<String, Variant> attributes, AttributeMode attributeMode );

        public void dispose ();
    };

    public Item registerItem ( String itemId, Map<String, Variant> attributes, WriteHandler writeHandler );

    public void unregisterItem ( String itemId );

    public void unregisterItem ( Item item );

    public void writeDataItem ( String connectionId, String itemId, Variant value, OperationParameters operationParameters ) throws Exception;

    public Map<String, String> getParameters ();

    public void dispose ();
}
