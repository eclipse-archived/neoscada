/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.factory;

import org.eclipse.scada.utils.statuscodes.CodedException;

public class BeanCreationException extends CodedException
{

    public BeanCreationException ()
    {
        super ( StatusCodes.BEAN_CREATION_ERROR );
    }

    public BeanCreationException ( final String message )
    {
        super ( StatusCodes.BEAN_CREATION_ERROR, message );
    }

    public BeanCreationException ( final Throwable error )
    {
        super ( StatusCodes.BEAN_CREATION_ERROR, error );
    }

    /**
     * 
     */
    private static final long serialVersionUID = -7953315772984670546L;

}
