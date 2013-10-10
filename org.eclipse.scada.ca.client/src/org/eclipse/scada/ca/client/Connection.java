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
package org.eclipse.scada.ca.client;

import java.util.List;

import org.eclipse.scada.ca.data.ConfigurationInformation;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public interface Connection extends org.eclipse.scada.core.client.Connection
{
    public void addFactoriesListener ( FactoriesListener listener );

    public void removeFactoriesListener ( FactoriesListener listener );

    public NotifyFuture<FactoryInformation[]> getFactories ();

    public NotifyFuture<FactoryInformation> getFactoryWithData ( String factoryId );

    public NotifyFuture<ConfigurationInformation> getConfiguration ( String factoryId, String configurationId );

    public NotifyFuture<Void> applyDiff ( final List<DiffEntry> changeSet, OperationParameters operationParameters, CallbackHandler callbackHandler );
}
