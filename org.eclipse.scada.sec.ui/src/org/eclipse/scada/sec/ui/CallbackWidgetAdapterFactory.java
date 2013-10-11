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
package org.eclipse.scada.sec.ui;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.sec.callback.PasswordCallback;
import org.eclipse.scada.sec.callback.TextCallback;
import org.eclipse.scada.sec.callback.UserNameCallback;

public final class CallbackWidgetAdapterFactory implements IAdapterFactory
{
    @SuppressWarnings ( "rawtypes" )
    @Override
    public Class[] getAdapterList ()
    {
        return new Class[] { CallbackWidgetFactory.class };
    }

    @SuppressWarnings ( "rawtypes" )
    @Override
    public CallbackWidgetFactory getAdapter ( final Object adaptableObject, final Class adapterType )
    {
        if ( adaptableObject instanceof TextCallback )
        {
            return new TextWidgetFactory ( (TextCallback)adaptableObject );
        }
        else if ( adaptableObject instanceof UserNameCallback )
        {
            return new TextWidgetFactory ( (TextCallback)adaptableObject );
        }
        else if ( adaptableObject instanceof PasswordCallback )
        {
            return new PasswordWidgetFactory ( (PasswordCallback)adaptableObject );
        }
        else
        {
            return null;
        }
    }
}