/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.ui.server;

import org.eclipse.swt.widgets.Composite;

/**
 * A server side page
 * 
 * @author Jens Reimann
 * @since 0.2.0
 */
public interface Page
{
    public void createContent ( Composite parent );

    /**
     * Called by the page manager to check if the page can be closed <br/>
     * It is possible for the page to trigger a message dialog first and
     * wait for the result.
     * 
     * @return <code>true</code> if the page can be closed, <code>false</code>
     *         otherwise
     */
    public boolean requestClose ();
}
