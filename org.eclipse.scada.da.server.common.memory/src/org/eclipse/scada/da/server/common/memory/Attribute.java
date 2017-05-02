/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - refactor for generic memory devices
 *******************************************************************************/
package org.eclipse.scada.da.server.common.memory;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;

/**
 * This class defines a data handler generating attributes of a primary value
 * 
 * @see Variable
 * @author Jens Reimann
 */
public interface Attribute
{
    public void handleData ( IoBuffer data, Map<String, Variant> attributes, Variant timestamp );

    public void handleError ( Map<String, Variant> attributes );

    public String getName ();

    public void handleWrite ( Variant value );

    public void start ( final MemoryRequestBlock block, final int offset );

    public void stop ();
}
