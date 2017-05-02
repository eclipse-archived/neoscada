/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - remove derivation from ExceptionHelper
 *******************************************************************************/
package org.eclipse.scada.ui.utils.status;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.utils.ExceptionHelper;

public class StatusHelper
{
    public static IStatus convertStatus ( final String pluginId, final Throwable e )
    {
        return convertStatus ( pluginId, ExceptionHelper.getMessage ( e ), e );
    }

    public static IStatus convertStatus ( final String pluginId, final String message, final Throwable e )
    {
        if ( e == null )
        {
            return Status.OK_STATUS;
        }

        if ( e instanceof CoreException )
        {
            return ( (CoreException)e ).getStatus ();
        }

        return new Status ( IStatus.ERROR, pluginId, message, e );
    }

}
