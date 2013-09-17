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

public interface ValueVisitor
{
    /**
     * Gets called for each record found
     * 
     * @param value
     *            the value
     * @param date
     *            the timestamp of the value
     * @param error
     *            the error flag for the value
     * @param manual
     *            the manual flag for the value
     * @return <code>true</code> if the callee wants more data,
     *         <code>false</code> otherwise
     */
    public boolean value ( double value, Date date, boolean error, boolean manual );
}
