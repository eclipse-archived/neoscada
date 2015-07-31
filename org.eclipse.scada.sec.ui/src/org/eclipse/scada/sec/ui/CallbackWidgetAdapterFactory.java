/*******************************************************************************
 * Copyright (c) 2013, 2015 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     IBH SYSTEMS GmbH - use new API
 *******************************************************************************/
package org.eclipse.scada.sec.ui;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.sec.callback.PasswordCallback;
import org.eclipse.scada.sec.callback.TextCallback;
import org.eclipse.scada.sec.callback.UserNameCallback;

public final class CallbackWidgetAdapterFactory implements IAdapterFactory
{
    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class[] { CallbackWidgetFactory.class };
    }

    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        if ( adaptableObject instanceof TextCallback )
        {
            return adapterType.cast ( new TextWidgetFactory ( (TextCallback)adaptableObject ) );
        }
        else if ( adaptableObject instanceof UserNameCallback )
        {
            return adapterType.cast ( new TextWidgetFactory ( (TextCallback)adaptableObject ) );
        }
        else if ( adaptableObject instanceof PasswordCallback )
        {
            return adapterType.cast ( new PasswordWidgetFactory ( (PasswordCallback)adaptableObject ) );
        }
        else
        {
            return null;
        }
    }
}
