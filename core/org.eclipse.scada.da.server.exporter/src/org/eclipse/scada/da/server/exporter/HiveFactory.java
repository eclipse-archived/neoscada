/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter;

import org.eclipse.scada.da.server.exporter.HiveConfigurationType;
import org.eclipse.scada.da.core.server.Hive;

/**
 * A hive factory which needs to create a new hive based on its implementation.
 * 
 * @author Jens Reimann
 */
public interface HiveFactory
{
    /**
     * Create a new hive based on the reference and the configuration
     * 
     * @param reference
     *            the reference to the hive
     * @param configuration
     *            the configuration of the hive that is provided in the master
     *            configuration
     * @return the new hive
     * @throws Exception
     *             if anything goes wrong
     */
    public abstract Hive createHive ( String reference, HiveConfigurationType configuration ) throws Exception;
}
