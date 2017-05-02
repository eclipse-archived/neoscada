/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login;

import java.util.Map;

public interface LoginFactory
{
    /**
     * Creates a new login handler that is not started
     * <p>
     * <em>Note:</em> login handlers must at some point be disposed using the
     * method {@link LoginHandler#dispose()} even if a login was never started.
     * </p>
     * 
     * @param properties
     *            implementation specific properties
     * @return a new login handler
     */
    public LoginHandler createHandler ( LoginContext context, String username, String password, Map<String, String> properties ) throws Exception;
}
