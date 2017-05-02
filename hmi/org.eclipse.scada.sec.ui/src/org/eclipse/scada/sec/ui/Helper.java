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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public final class Helper
{

    private Helper ()
    {
    }

    public static List<CallbackWidgetFactory> makeFactories ( final Callback[] callbacks )
    {
        final List<CallbackWidgetFactory> result = new LinkedList<CallbackWidgetFactory> ();

        for ( final Callback cb : callbacks )
        {
            final CallbackWidgetFactory factory = AdapterHelper.adapt ( cb, CallbackWidgetFactory.class, true );
            if ( factory != null )
            {
                result.add ( factory );
            }
            else
            {
                cb.cancel ();
            }
        }

        return result;
    }
}
