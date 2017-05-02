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

import org.eclipse.scada.sec.UserInformation;

public interface ConfigurationFactory
{
    /**
     * receive configuration update
     * @param userInformation the principal that performed the change, may be <code>null</code>
     * @param configurationId the configuration object to change
     * @param properties the new properties
     * @throws Exception can be thrown if anything goes wrong changing the configuration
     */
    public void update ( UserInformation userInformation, String configurationId, Map<String, String> properties ) throws Exception;

    /**
     * receive configuration delete request
     * @param userInformation the principal that performed the change, may be <code>null</code>
     * @param configurationId the configuration object to change
     * @throws Exception can be thrown if anything goes wrong changing the configuration
     */
    public void delete ( final UserInformation userInformation, String configurationId ) throws Exception;
}
