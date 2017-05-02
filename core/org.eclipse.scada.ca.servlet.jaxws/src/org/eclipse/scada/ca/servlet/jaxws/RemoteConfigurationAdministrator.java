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
package org.eclipse.scada.ca.servlet.jaxws;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import javax.jws.WebService;

import org.eclipse.scada.ca.data.ConfigurationInformation;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.data.FactoryInformation;

@WebService
public interface RemoteConfigurationAdministrator
{
    public abstract boolean hasService ();

    /* read calls */

    /**
     * Get factory information without content
     * 
     * @return the factories without a content
     */
    public abstract FactoryInformation[] getFactories ();

    public abstract FactoryInformation[] getCompleteConfiguration ();

    public abstract FactoryInformation getFactory ( String factoryId );

    public abstract ConfigurationInformation getConfiguration ( String factoryId, String configurationId );

    /* update calls */

    public abstract void purge ( final String factoryId, final int timeout ) throws InterruptedException, ExecutionException, TimeoutException;

    public abstract void delete ( final String factoryId, final String[] configurations, final int timeout ) throws InterruptedException, ExecutionException, TimeoutException;

    public abstract void update ( final String factoryId, final ConfigurationInformation[] configurations, final int timeout ) throws InterruptedException, ExecutionException, TimeoutException;

    public abstract void create ( final String factoryId, final ConfigurationInformation[] configurations, final int timeout ) throws InterruptedException, ExecutionException, TimeoutException;

    public abstract void applyDiff ( Collection<DiffEntry> changeSet, int timeout ) throws InterruptedException, ExecutionException, TimeoutException;
}