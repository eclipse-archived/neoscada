/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.ui.server;

/**
 * A provider for pages
 * 
 * @author Jens Reimann
 * @since 0.2.0
 */
public interface PageProvider
{
    /**
     * Provide a label hierarchy <br/>
     * This hierarchy of labels is used to place the page in the navigation
     * tree.
     * 
     * @return this method must neither return <code>null</code> nor an empty
     *         array.
     */
    public String[] getPath ();

    /**
     * Get the name of the page
     * 
     * @return the name of the page
     */
    public String getName ();

    /**
     * Create the page
     * 
     * @return The new page instance
     */
    public Page createPage ();
}
