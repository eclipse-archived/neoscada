/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc;

import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionTask;

public interface ConnectionAccessor
{
    public <R> R doWithConnection ( ConnectionTask<R> connectionTask ) throws Exception;

    public void dispose ();
}
