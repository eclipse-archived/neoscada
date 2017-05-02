/*******************************************************************************
 * Copyright (c) 2013, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - minor enhancements
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.common;

import org.eclipse.scada.da.core.server.Hive;

/**
 * Used for registered to a HiveSource
 *
 * @author Jens Reimann
 */
@FunctionalInterface
public interface HiveSourceListener
{
    public void setHive ( Hive hive );
}
