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
package org.eclipse.scada.da.server.common.impl;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.subscription.SubscriptionListener;
import org.eclipse.scada.da.core.server.ItemChangeListener;
import org.eclipse.scada.da.server.common.DataItem;

/**
 * A subscription listener for data items
 * <p>
 * Interface is analog to {@link ItemChangeListener}
 * @author Jens Reimann
 *
 */
public interface DataItemSubscriptionListener extends SubscriptionListener
{
    public void dataChanged ( DataItem item, Variant value, Map<String, Variant> attributes, boolean cache );
}
