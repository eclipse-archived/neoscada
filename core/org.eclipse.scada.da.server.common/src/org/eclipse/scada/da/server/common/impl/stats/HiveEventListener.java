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
package org.eclipse.scada.da.server.common.impl.stats;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.da.server.common.DataItem;

public interface HiveEventListener
{

    public abstract void sessionCreated ( AbstractSessionImpl session );

    public abstract void sessionDestroyed ( AbstractSessionImpl session );

    public abstract void itemRegistered ( DataItem item );

    public abstract void startWriteAttributes ( Session session, String itemId, int size );

    public abstract void startWrite ( Session session, String itemName, Variant value );

    public abstract void attributesChanged ( DataItem item, int size );

    public abstract void valueChanged ( DataItem item, Variant variant, boolean cache );

    public abstract void itemUnregistered ( DataItem item );

}
