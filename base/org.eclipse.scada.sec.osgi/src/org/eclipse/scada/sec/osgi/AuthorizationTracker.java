/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.osgi;

import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;

public interface AuthorizationTracker
{

    public interface Listener
    {
        public void resultChanged ( AuthorizationReply result );
    }

    public interface Monitor
    {
        public void dispose ();
    }

    public abstract Monitor createMonitor ( Listener listener, AuthorizationRequest request );

}