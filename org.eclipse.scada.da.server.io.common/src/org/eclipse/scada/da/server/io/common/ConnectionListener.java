/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.io.common;

public interface ConnectionListener
{
    /**
     * Called when the connection is established
     */
    public abstract void opened ();

    /**
     * Called when the connection is broken
     * 
     * @param error
     *            the error or <code>null</code> if no error is known
     */
    public abstract void closed ( Throwable error );

    /**
     * The attempt to establish a connection has failed.
     * 
     * @param error
     *            the error or <code>null</code> if no error is known
     */
    public abstract void connectFailed ( Throwable error );
}
