/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.common;

import java.util.Map;

import org.eclipse.scada.ae.monitor.MonitorService;
import org.eclipse.scada.sec.UserInformation;

public interface DataItemMonitor extends MonitorService
{
    public abstract void update ( UserInformation userInformation, final Map<String, String> properties ) throws Exception;

    public abstract void dispose ();

}