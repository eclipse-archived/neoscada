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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.utils.lang.Immutable;

/**
 * @since 1.1
 */
@Immutable
public class AuthorizationRequest
{
    private final String objectType;

    private final String objectId;

    private final String action;

    private final UserInformation userInformation;

    private final Map<String, Object> context;

    public AuthorizationRequest ( final String objectType, final String objectId, final String action, final UserInformation userInformation, final Map<String, Object> context )
    {
        this.objectType = objectType;
        this.objectId = objectId;
        this.action = action;
        this.userInformation = userInformation;
        this.context = context == null ? null : Collections.unmodifiableMap ( new HashMap<String, Object> ( context ) );
    }

    public String getAction ()
    {
        return this.action;
    }

    public Map<String, Object> getContext ()
    {
        return this.context;
    }

    public String getObjectId ()
    {
        return this.objectId;
    }

    public String getObjectType ()
    {
        return this.objectType;
    }

    public UserInformation getUserInformation ()
    {
        return this.userInformation;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[type: %s, id: %s, action: %s, userInformation: %s, context: %s]", this.objectType, this.objectId, this.action, this.userInformation, this.context );
    }

    public static AuthorizationRequest changeUser ( final AuthorizationRequest request, final UserInformation userInformation )
    {
        if ( request == null )
        {
            return null;
        }

        return new AuthorizationRequest ( request.getObjectType (), request.getObjectId (), request.getAction (), userInformation, request.getContext () );
    }
}
