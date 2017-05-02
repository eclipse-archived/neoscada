/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hds;

import java.util.Date;

public interface ValueSource
{
    /**
     * Visit the value source
     * 
     * @param visitor
     *            the visitor
     * @param start
     *            the start timestamp
     * @param end
     *            the end timestamp
     * @return <code>true</code> if more data should be read, <code>false</code>
     *         otherwise
     */
    public boolean visit ( final ValueVisitor visitor, final Date start, final Date end );

    public void addListener ( final DataStoreListener listener );

    public void removeListener ( final DataStoreListener listener );
}
