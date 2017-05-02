/*******************************************************************************
 * Copyright (c) 2011, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ds;

/**
 * A listener on {@link DataNode}s of a {@link DataStore}
 * 
 * @author Jens Reimann
 * @since 0.15.0
 */
public interface DataListener
{
    /**
     * Gets called when the node changed.
     * 
     * @param node
     *            the current status or <code>null</code> if
     *            the does not exist or gets deleted.
     */
    public void nodeChanged ( DataNode node );
}
