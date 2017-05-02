/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.common;

/**
 * Provide a way to find hives
 * 
 * @author Jens Reimann
 * @since 0.1.0
 */
public interface HiveSource
{
    public void addListener ( HiveSourceListener listener );

    public void removeListener ( HiveSourceListener listener );
}
