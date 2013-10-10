/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.base;

public class NoConnectionException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = -5722669689966000196L;

    public NoConnectionException ()
    {
        super ( "No connection" );
    }
}
