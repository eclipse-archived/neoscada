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
package org.eclipse.scada.sec.authz;

import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

/**
 * @since 1.1
 */
public interface AuthorizationRule
{

    /**
     * Authorizes a requested operation
     * 
     * @return Returns a future which will receive the result of the
     *         authorization. The method never returns <code>null</code>. The
     *         future will either receive <code>null</code> if the service
     *         abstains (neither approves nor rejects the request).
     */
    public NotifyFuture<AuthorizationResult> authorize ( AuthorizationContext context );

    public void dispose ();

}
