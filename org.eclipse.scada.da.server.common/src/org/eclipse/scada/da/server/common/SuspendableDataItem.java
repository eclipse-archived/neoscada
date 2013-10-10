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
package org.eclipse.scada.da.server.common;

/**
 * An interface for items that are interested if currently a listener is set or not.
 * <br/>
 * Note that this interface must be fed by someone. It is not automatically fed by the Hive
 * anymore since the item should take care itself of this state. See {@link DataItemBase} for
 * a class supporting this interface.
 * @author Jens Reimann &lt;jens.reimann@th4-systems.com&gt;
 * @see DataItemBase
 */
public interface SuspendableDataItem
{
    /**
     * Called when the listener is set from a valid listener to <code>null</code>
     *
     */
    public abstract void suspend ();

    /**
     * Called when the listener is set from <code>null</code> to a valid listener
     *
     */
    public abstract void wakeup ();
}
