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
package org.eclipse.scada.utils.ui.server.internal;

import java.util.Set;

/**
 * The session listener interface <br/>
 * <p>
 * The session listener will receive events from the security framework. The
 * {@link #opened(Session)} method will be called once (and only once) the users
 * ID has been verified.
 * </p>
 * <p>
 * All granted and revoked permissions may be notified using the
 * {@link #permissionsChanged(Set, Set)} method. This method may only be called
 * <em>after</em> the {@link #authenticated(String)} method was called and
 * returned.
 * </p>
 * <p>
 * If the user cannot be verified, or has no permission to connect, the method
 * {@link #closed(Throwable)} must be called once. The method may be called
 * directly or after the {@link #opened(Session)} method was already called.
 * However after the {@link #closed(Throwable)} method was called, no more
 * methods on this interface must be called, including the
 * {@link #closed(Throwable)} method.
 * </p>
 */
public interface SessionListener
{
    public void opened ( Session session );

    public void permissionsChanged ( Set<String> added, Set<String> removed );

    public void closed ( Throwable e );
}
