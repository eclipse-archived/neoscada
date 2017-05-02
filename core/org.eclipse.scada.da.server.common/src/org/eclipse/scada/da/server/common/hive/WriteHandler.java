/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.hive;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public interface WriteHandler
{
    public NotifyFuture<WriteResult> writeValue ( final String itemId, final Variant value, final OperationParameters effectiveOperationParameters );

    public NotifyFuture<WriteAttributeResults> writeAttributes ( final String itemId, final Map<String, Variant> attributes, final OperationParameters operationParameters );
}
