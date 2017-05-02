/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login;

import org.osgi.framework.BundleContext;

public interface LoginHandler
{
    public void setStateListener ( StateListener stateListener );

    public void startLogin ();

    public void register ( BundleContext context );

    public void dispose ();

    public boolean isOk ();

    public boolean isComplete ();

    public boolean hasRole ( String role );

}
