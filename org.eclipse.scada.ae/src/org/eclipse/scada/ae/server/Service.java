/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.server;

import java.util.Date;

import org.eclipse.scada.ae.Query;
import org.eclipse.scada.ae.QueryListener;
import org.eclipse.scada.ae.UnknownQueryException;
import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public interface Service extends org.eclipse.scada.core.server.Service<Session>
{
    // Event methods - online

    public void subscribeEventQuery ( Session session, String queryId ) throws InvalidSessionException, UnknownQueryException;

    public void unsubscribeEventQuery ( Session session, String queryId ) throws InvalidSessionException;

    // Event methods - offline

    public Query createQuery ( Session session, String queryType, String queryData, QueryListener listener ) throws InvalidSessionException;

    // Condition methods

    public void subscribeConditionQuery ( Session session, String queryId ) throws InvalidSessionException, UnknownQueryException;

    public void unsubscribeConditionQuery ( Session session, String queryId ) throws InvalidSessionException;

    public NotifyFuture<Void> acknowledge ( Session session, String conditionId, Date aknTimestamp, OperationParameters operationParameters, CallbackHandler callbackHandler ) throws InvalidSessionException;
}
