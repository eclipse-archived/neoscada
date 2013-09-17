/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.provider.dummy;

import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.osgi.AuthorizationManager;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class DummyAuthorizationProviderImpl implements AuthorizationManager
{

    @Override
    public NotifyFuture<AuthorizationReply> authorize ( final AuthorizationContext context, final AuthorizationResult defaultResult )
    {
        return new InstantFuture<AuthorizationReply> ( AuthorizationReply.createGranted ( context ) );
    }

}
