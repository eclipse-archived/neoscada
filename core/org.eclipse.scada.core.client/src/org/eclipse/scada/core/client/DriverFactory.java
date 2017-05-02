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
package org.eclipse.scada.core.client;

import org.eclipse.scada.core.ConnectionInformation;

public interface DriverFactory
{
    public abstract DriverInformation getDriverInformation ( ConnectionInformation connectionInformation );

    public static final String INTERFACE_NAME = "interface";

    public static final String DRIVER_NAME = "driver";
}
