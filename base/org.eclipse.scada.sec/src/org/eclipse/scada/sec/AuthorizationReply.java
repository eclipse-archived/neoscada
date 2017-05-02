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
package org.eclipse.scada.sec;

import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.utils.lang.Immutable;

/**
 * @since 1.1
 */
@Immutable
public class AuthorizationReply
{
    private final AuthorizationResult result;

    private final AuthorizationContext context;

    public AuthorizationReply ( final AuthorizationResult result, final AuthorizationContext context )
    {
        if ( result == null )
        {
            throw new IllegalArgumentException ( "'result' must not be null" );
        }
        if ( context == null )
        {
            throw new IllegalArgumentException ( "'context' must not be null" );
        }

        this.result = result;
        this.context = context;
    }

    public boolean isGranted ()
    {
        return this.result.isGranted ();
    }

    public AuthorizationResult getResult ()
    {
        return this.result;
    }

    public AuthorizationContext getContext ()
    {
        return this.context;
    }

    public UserInformation getUserInformation ()
    {
        return this.context.getRequest ().getUserInformation ();
    }

    @Override
    public String toString ()
    {
        return String.format ( "[AuthorizationReply - result: %s, request: %s]", this.result, this.context.getRequest () );
    }

    public static AuthorizationReply createGranted ( final AuthorizationContext context )
    {
        return new AuthorizationReply ( AuthorizationResult.GRANTED, context );
    }

    public static AuthorizationReply create ( final AuthorizationResult result, final AuthorizationContext context )
    {
        return new AuthorizationReply ( result, context );
    }

}
