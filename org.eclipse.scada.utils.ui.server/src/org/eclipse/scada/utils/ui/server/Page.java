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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;

/**
 * A server side page <br/>
 * <p>
 * A page gets created by the page provider. The
 * {@link #createContent(Composite)} must only be called once. Resources that be
 * page need must not be created before calling this method. If the method is
 * never called the page instance is simply subject to garbage collections. Once
 * the page content is created the page can attach itself to the parent
 * composite using
 * {@link Widget#addDisposeListener(org.eclipse.swt.events.DisposeListener)} to
 * get notified about disposal.
 * </p>
 * <p>
 * The request close method must also be allowed to be called if the
 * {@link #createContent(Composite)} was not called. In which case it should
 * simply return <code>true</code>. The {@link #requestClose()} method may also
 * be called multiple times, but only as long as the parent composite is not
 * disposed.
 * </p>
 * 
 * @author Jens Reimann
 * @since 0.2.0
 */
public interface Page
{
    /**
     * Create the page content
     * 
     * @param parent
     *            the parent composite
     */
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
