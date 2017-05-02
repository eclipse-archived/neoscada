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
package org.eclipse.scada.hd;

import org.eclipse.scada.hd.data.QueryParameters;

/**
 * An interface for querying historical value data
 * <p>
 * See {@link QueryListener} for implementation requirements on data
 * notification.
 * </p>
 * 
 * @see QueryListener
 * @author Jens Reimann &lt;jens.reimann@th4-systems.com&gt;
 * @since 0.14.0
 */
public interface Query
{
    /**
     * Close the query
     */
    public void close ();

    /**
     * Request a change of parameters
     * 
     * @param parameters
     *            the new requested parameters
     */
    public void changeParameters ( QueryParameters parameters );
}
