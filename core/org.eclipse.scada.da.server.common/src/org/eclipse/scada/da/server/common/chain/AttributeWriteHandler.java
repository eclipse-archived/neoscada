/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.chain;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.WriteAttributeResults;

public interface AttributeWriteHandler
{
    /**
     * Handle the write call
     * <p>
     * e.g. performs a write call to a subsystem
     * @param attributes the attributes to write
     * @throws Exception if anything goes wrong
     * @return a list of handled attributes including their result
     */
    public abstract WriteAttributeResults handleWrite ( Map<String, Variant> attributes ) throws Exception;

    public abstract void handleWrite ( Variant value ) throws Exception;
}
