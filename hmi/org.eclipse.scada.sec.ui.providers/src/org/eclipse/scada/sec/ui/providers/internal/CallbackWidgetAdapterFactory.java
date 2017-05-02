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
package org.eclipse.scada.sec.ui.providers.internal;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.sec.callback.XMLSignatureCallback;
import org.eclipse.scada.sec.ui.CallbackWidgetFactory;

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
        if ( adaptableObject instanceof XMLSignatureCallback )
        {
            return new XMLSignatureWidgetFactory ( (XMLSignatureCallback)adaptableObject );
        }
        else
        {
            return null;
        }
    }
}