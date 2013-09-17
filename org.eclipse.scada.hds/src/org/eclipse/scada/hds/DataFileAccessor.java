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

import java.io.IOException;
import java.util.Date;

public interface DataFileAccessor
{

    public abstract void insertValue ( final double value, final Date date, final boolean error, final boolean manual, final boolean heartbeat ) throws IOException;

    public abstract boolean visit ( final ValueVisitor visitor ) throws Exception;

    public abstract void dispose ();

    public abstract boolean visitFirstValue ( ValueVisitor visitor ) throws Exception;

    /**
     * Forward correct entries
     * <p>
     * </p>
     * 
     * @param value
     *            the value
     * @param date
     *            the starting point
     * @param error
     *            the error flag
     * @param manual
     *            the manual flag
     * @throws Exception
     */
    public abstract void forwardCorrect ( double value, Date date, boolean error, boolean manual ) throws Exception;

    /**
     * Delete the accessors file. This is implicitly a dispose operation.
     */
    public void delete ();

    public Date getStart ();

    public Date getEnd ();
}