/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.sfp.strategy;

import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.utils.concurrent.AbstractFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteHandler extends AbstractFuture<WriteResult>
{

    private final static Logger logger = LoggerFactory.getLogger ( WriteHandler.class );

    public void complete ( final org.eclipse.scada.protocol.sfp.messages.WriteResult writeResult )
    {
        logger.debug ( "Completing write operation - errorCode: {}, errorMessage: {}", writeResult.getErrorCode (), writeResult.getErrorMessage () );

        if ( writeResult.getErrorCode () == 0 )
        {
            setResult ( WriteResult.OK );
        }
        else
        {
            setError ( new RuntimeException ( makeErrorString ( writeResult ) ) );
        }
    }

    public static String makeErrorString ( final org.eclipse.scada.protocol.sfp.messages.WriteResult writeResult )
    {
        if ( writeResult.getErrorMessage () == null )
        {
            return String.format ( "%04x", writeResult.getErrorCode () );
        }
        else
        {
            return String.format ( "%04x: %s", writeResult.getErrorCode (), writeResult.getErrorMessage () );
        }
    }
}