/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.core.server.browser;

import org.eclipse.scada.utils.statuscodes.CodedException;
import org.eclipse.scada.utils.str.StringHelper;

public class NoSuchFolderException extends CodedException
{
    private static final long serialVersionUID = -2354532100658455884L;

    public NoSuchFolderException ( final String[] path )
    {
        super ( StatusCodes.NO_SUCH_FOLDER, String.format ( "No such folder (%s)", StringHelper.join ( path, "/" ) ) );
    }
}
