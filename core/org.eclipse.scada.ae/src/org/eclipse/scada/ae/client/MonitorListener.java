/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.client;

import java.util.List;
import java.util.Set;

import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.core.data.SubscriptionState;

public interface MonitorListener
{
    public void statusChanged ( SubscriptionState state );

    public void dataChanged ( List<MonitorStatusInformation> addedOrUpdated, Set<String> removed, boolean full );
}
