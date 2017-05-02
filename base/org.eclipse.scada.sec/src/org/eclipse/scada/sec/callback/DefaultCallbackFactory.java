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
package org.eclipse.scada.sec.callback;

import java.util.Map;

/**
 * @since 1.1
 */
public class DefaultCallbackFactory implements CallbackFactory
{

    @Override
    public Callback createCallback ( final String type, final Map<String, String> attributes )
    {
        if ( UserNameCallback.TYPE.equals ( type ) )
        {
            return applyAttributes ( new UserNameCallback (), attributes );
        }
        if ( TextCallback.TYPE.equals ( type ) )
        {
            return applyAttributes ( new TextCallback (), attributes );
        }
        else if ( PasswordCallback.TYPE.equals ( type ) )
        {
            return applyAttributes ( new PasswordCallback (), attributes );
        }
        else if ( ConfirmationCallback.TYPE.equals ( type ) )
        {
            return applyAttributes ( new ConfirmationCallback (), attributes );
        }
        else if ( XMLSignatureCallback.TYPE.equals ( type ) )
        {
            return applyAttributes ( new XMLSignatureCallback (), attributes );
        }
        return null;
    }

    private Callback applyAttributes ( final Callback callback, final Map<String, String> attributes )
    {
        if ( callback != null )
        {
            callback.parseRequestAttributes ( attributes );
        }
        return callback;
    }
}
