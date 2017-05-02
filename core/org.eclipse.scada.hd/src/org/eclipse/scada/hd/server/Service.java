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
package org.eclipse.scada.hd.server;

import org.eclipse.scada.core.InvalidSessionException;
import org.eclipse.scada.hd.InvalidItemException;
import org.eclipse.scada.hd.Query;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.data.QueryParameters;

/**
 * This interface specifies the operations provided by the server
 * 
 * @author Jens Reimann
 * @since 0.14.0
 */
public interface Service extends org.eclipse.scada.core.server.Service<Session>
{
    public Query createQuery ( Session session, String itemId, QueryParameters parameters, QueryListener listener, boolean updateData ) throws InvalidSessionException, InvalidItemException;
}
