/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ide.server.test;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

public class PortValidator implements IValidator
{

    private static final int MAX = Short.MAX_VALUE - 1;

    private static final int MIN = 1;

    @Override
    public IStatus validate ( final Object value )
    {
        if ( ! ( value instanceof Number ) )
        {
            return new Status ( IStatus.ERROR, Activator.PLUGIN_ID, "Value must be a number" );
        }

        final int port = ( (Number)value ).intValue ();

        if ( port < MIN || port > MAX )
        {
            return new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( "Port number must be between %s and %s (inclusive)", MIN, MAX ) );
        }

        if ( port < 1024 && isUnix () )
        {
            return new Status ( IStatus.WARNING, Activator.PLUGIN_ID, String.format ( "Port numbers below 1024 are reserved for privileged users (root) and may not be available for use." ) );
        }

        return Status.OK_STATUS;
    }

    private boolean isUnix ()
    {
        final String os = Platform.getOS ();
        if ( Platform.OS_WIN32.equals ( os ) )
        {
            return false;
        }
        return true;
    }
}
