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
package org.eclipse.scada.da.server.exec.extractor;

import org.eclipse.scada.da.server.exec.command.ExecutionResult;

public abstract class AbstractReturnCodeExtractor extends AbstractBaseExtractor
{
    public AbstractReturnCodeExtractor ( final String id )
    {
        super ( id );
    }

    protected abstract void handleReturnCode ( final int rc );

    @Override
    protected void doProcess ( final ExecutionResult result ) throws Exception
    {
        final Integer rc = result.getExitValue ();

        if ( rc != null )
        {
            handleReturnCode ( rc );
        }
        else
        {
            setError ( new RuntimeException ( "No return code value" ).fillInStackTrace (), "No return code value" );
        }
    }

}