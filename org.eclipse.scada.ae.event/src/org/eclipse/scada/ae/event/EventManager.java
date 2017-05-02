/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.event;

/**
 * A manager which generates events and provides the information to its
 * listeners
 * 
 * @author Jens Reimann
 */
public interface EventManager
{
    /**
     * Add this listener to the manager
     * <p>
     * If the listener was already added the request will be ignored.
     * </p>
     * <p>
     * If the listener was added to the manager, all current known events have
     * to be provided to the listener.
     * </p>
     * 
     * @param listener
     *            the listener to add
     */
    public void addEventListener ( EventListener listener );

    public void removeEventListener ( EventListener listener );
}
