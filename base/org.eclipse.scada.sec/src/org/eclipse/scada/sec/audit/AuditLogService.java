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
package org.eclipse.scada.sec.audit;

import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.authz.AuthorizationContext;

public interface AuditLogService
{
    public void info ( String message, Object... arguments );

    public void debug ( String message, Object... arguments );

    public void info ( String message, Throwable e, Object... arguments );

    public void debug ( String message, Throwable e, Object... arguments );

    public void authorizationRequested ( AuthorizationRequest request );

    public void authorizationFailed ( AuthorizationContext context, AuthorizationRequest request, Throwable error );

    public void authorizationDone ( AuthorizationContext context, AuthorizationRequest request, AuthorizationReply reply );
}
