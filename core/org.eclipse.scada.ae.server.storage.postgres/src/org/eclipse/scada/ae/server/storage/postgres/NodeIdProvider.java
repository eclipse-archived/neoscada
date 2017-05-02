/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.postgres;

import org.eclipse.scada.ae.server.storage.postgres.internal.JdbcStorage;

/**
 * potential network access, so we don't want to call in a constructor
 * getNodeId, therefor this interface will delegate it to {@link JdbcStorage}
 */
public interface NodeIdProvider
{
    String getNodeId ();
}
