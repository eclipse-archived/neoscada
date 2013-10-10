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
package org.eclipse.scada.ca;

import java.util.Map;

import org.eclipse.scada.utils.concurrent.NotifyFuture;

public interface SelfManagedConfigurationFactory
{
    /**
     * Add a new configuration listener to the factory
     * <p>
     * If the listener is already registered the method has no effect.
     * </p>
     * <p>
     * The listener is added to the factory and will receive updates from now on.
     * Before the method return it will call the listener once with the already
     * known configuration element using an "add" notification.
     * </p> 
     * @param listener The new listener to add
     */
    public void addConfigurationListener ( ConfigurationListener listener );

    /**
     * Remove a listener from the factory
     * <p>
     * If the listener is not currently attache to the factory the call has no effect.
     * </p>
     * @param listener
     */
    public void removeConfigurationListener ( ConfigurationListener listener );

    public NotifyFuture<Configuration> update ( String configurationId, Map<String, String> properties, boolean fullSet );

    public NotifyFuture<Configuration> delete ( String configurationId );

    /**
     * Delete all configurations at once
     * @return the future for this operation
     */
    public NotifyFuture<Void> purge ();
}
