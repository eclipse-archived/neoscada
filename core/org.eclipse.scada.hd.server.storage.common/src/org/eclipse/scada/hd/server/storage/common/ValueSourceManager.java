/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.common;

import org.eclipse.scada.hd.data.QueryParameters;
import org.eclipse.scada.hds.ValueVisitor;

public interface ValueSourceManager
{

    public void queryClosed ( QueryImpl query );

    /**
     * Visit values
     * 
     * @param parameters
     *            the parameters to visit
     * @param visitor
     *            the visitor
     * @return <code>true</code> if the run was complete, <code>false</code> if
     *         is was aborted by the visitor
     */
    public boolean visit ( QueryParameters parameters, ValueVisitor visitor );

}
