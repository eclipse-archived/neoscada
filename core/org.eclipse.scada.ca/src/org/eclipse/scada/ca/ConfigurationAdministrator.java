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

import java.util.Collection;
import java.util.Map;

import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public interface ConfigurationAdministrator
{
    public static final String FACTORY_ID = "factoryId";

    /* modifiers */

    public NotifyFuture<Configuration> createConfiguration ( UserInformation userInformation, String factoryId, String configurationId, Map<String, String> initialProperties );

    public NotifyFuture<Configuration> updateConfiguration ( UserInformation userInformation, String factoryId, String configurationId, Map<String, String> newProperties, boolean fullSet );

    public NotifyFuture<Configuration> deleteConfiguration ( UserInformation userInformation, String factoryId, String configurationId );

    public NotifyFuture<Void> purgeFactory ( UserInformation userInformation, String factoryId );

    /**
     * Applies a change set to an existing configuration manager.
     * <p>
     * The operation must be atomic to the configuration system.
     * </p>
     * <p>
     * Note that there are two or more entries for one factory/configuration
     * combination it is unspecified which entry will be applied.
     * </p>
     * 
     * @param changeSet
     *            the change set to apply
     * @return a future which notifies the end of the operation
     */
    public NotifyFuture<Void> applyDiff ( UserInformation userInformation, Collection<DiffEntry> changeSet );

    /* readers */

    public Factory getFactory ( String factoryId );

    public Factory[] getKnownFactories ();

    public Configuration[] getConfigurations ( String factoryId );

    public Configuration getConfiguration ( String factoryId, String configurationId );
}
