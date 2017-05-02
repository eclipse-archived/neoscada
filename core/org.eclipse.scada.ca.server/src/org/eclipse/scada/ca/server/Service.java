/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ca.server;

import java.util.Collection;

import org.eclipse.scada.ca.Configuration;
import org.eclipse.scada.ca.Factory;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

/**
 * This interface specifies the operations provided by the server
 * 
 * @author Jens Reimann
 * @since 1.0.0
 */
public interface Service extends org.eclipse.scada.core.server.Service<Session>
{
    public NotifyFuture<Void> applyDiff ( Session session, Collection<DiffEntry> changeSet, OperationParameters operationParameters, CallbackHandler callbackHandler ) throws InvalidSessionException;

    public NotifyFuture<FactoryWithData> getFactory ( Session session, String factoryId ) throws InvalidSessionException;

    public NotifyFuture<Configuration[]> getConfigurations ( Session session, String factoryId ) throws InvalidSessionException;

    public NotifyFuture<Factory[]> getKnownFactories ( Session session ) throws InvalidSessionException;

    public NotifyFuture<Configuration> getConfiguration ( Session session, String factoryId, String configurationId ) throws InvalidSessionException;
}