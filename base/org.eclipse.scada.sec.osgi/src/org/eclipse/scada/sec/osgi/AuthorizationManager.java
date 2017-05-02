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
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public interface AuthorizationManager
{

    public NotifyFuture<AuthorizationReply> authorize ( AuthorizationContext context, AuthorizationResult defaultResult );

}
