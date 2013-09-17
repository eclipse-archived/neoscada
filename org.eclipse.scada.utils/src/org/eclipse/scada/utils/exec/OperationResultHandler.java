/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.exec;

/**
 * Interface for handling result notify asynchronously
 * 
 * @author jens
 * @param <R>
 *            The result type
 */
public interface OperationResultHandler<R>
{
    /**
     * Gets called in the case an error occurred.
     * 
     * @param e
     *            The exception that was thrown
     */
    public void failure ( Exception e );

    /**
     * Gets called when the operation succeeded
     * 
     * @param result
     */
    public void success ( R result );
}
