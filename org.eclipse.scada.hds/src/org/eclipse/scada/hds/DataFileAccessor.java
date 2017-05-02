/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - change interface
 *******************************************************************************/
package org.eclipse.scada.hds;

import java.io.IOException;
import java.util.Date;

public interface DataFileAccessor
{
    public abstract void insertValue ( final double value, final Date date, final boolean error, final boolean manual, final boolean heartbeat ) throws IOException;

    public abstract boolean visit ( final ValueVisitor visitor ) throws Exception;

    public abstract void dispose ();

    public abstract boolean visitFirstValue ( ValueVisitor visitor ) throws Exception;

    /**
     * Forward correct entries<br/>
     * This deletes all entries which are after the specified date
     * 
     * @param value
     *            the value
     * @param afterDate
     *            the starting point, correct everything after
     * @throws Exception
     *             if anything goes wrong
     */
    public abstract void forwardCorrect ( double value, Date afterDate ) throws Exception;

    /**
     * Delete the accessors file. This is implicitly a dispose operation.
     */
    public void delete ();

    public Date getStart ();

    public Date getEnd ();
}