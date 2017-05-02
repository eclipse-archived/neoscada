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

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.osgi.framework.BundleContext;

public interface Variable
{
    public void start ( String parentName, BundleContext context, MemoryRequestBlock block, int offset );

    public void stop ( BundleContext context );

    public void handleError ( int errorCode );

    public void handleFailure ( Throwable e );

    public void handleData ( IoBuffer data, Variant timestamp );

    public void handleDisconnect ();
}
