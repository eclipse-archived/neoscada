/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae;

/**
 * Must be automatically garbage collected if the {@link QueryListener} implementation
 * does not store the instance itself 
 * @author Jens Reimann
 * @author Jürgen Rose
 * @since 0.15.0
 */
public interface Query
{
    /**
     * Load more data
     * @param count the number of entries to load, must be greater than zero
     * @throws IllegalArgumentException if the count is negative or zero
     */
    public void loadMore ( int count );

    public void close ();
}
