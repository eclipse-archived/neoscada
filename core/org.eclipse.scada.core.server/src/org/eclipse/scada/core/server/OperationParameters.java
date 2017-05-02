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
package org.eclipse.scada.core.server;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.utils.lang.Immutable;

/**
 * @since 1.1
 */
@Immutable
public class OperationParameters
{
    private final UserInformation userInformation;

    private final Map<String, String> properties;

    private final CallbackHandler callbackHandler;

    public OperationParameters ( final UserInformation userInformation, final Map<String, String> properties, final CallbackHandler callbackHandler )
    {
        this.userInformation = userInformation;
        this.properties = properties == null ? Collections.<String, String> emptyMap () : Collections.<String, String> unmodifiableMap ( new HashMap<String, String> ( properties ) );
        this.callbackHandler = callbackHandler;
    }

    public CallbackHandler getCallbackHandler ()
    {
        return this.callbackHandler;
    }

    public UserInformation getUserInformation ()
    {
        return this.userInformation;
    }

    public Map<String, String> getProperties ()
    {
        return this.properties;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[OperationParameters - userInformation: %s, properties: %s, callbackHandler: %s]", this.userInformation, this.properties, this.callbackHandler );
    }

    public org.eclipse.scada.core.data.OperationParameters asData ()
    {
        final org.eclipse.scada.core.data.UserInformation ui = this.userInformation == null ? null : new org.eclipse.scada.core.data.UserInformation ( this.userInformation.getName () );
        return new org.eclipse.scada.core.data.OperationParameters ( ui, this.properties );
    }
}
