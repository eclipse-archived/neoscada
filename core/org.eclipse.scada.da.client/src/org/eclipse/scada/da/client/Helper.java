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
package org.eclipse.scada.da.client;

import java.util.concurrent.Future;

import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class Helper 
{
    public static void transformWrite ( final NotifyFuture<WriteResult> future, final WriteOperationCallback callback )
    {
        if ( callback != null )
        {
            future.addListener ( new FutureListener<WriteResult> () {

                @Override
                public void complete ( final Future<WriteResult> future )
                {
                    try
                    {
                        future.get ();
                        callback.complete ();
                    }
                    catch ( final Exception e )
                    {
                        callback.error ( e );
                    }
                }
            } );
        }
    }

    public static void transformWriteAttributes ( final WriteAttributeOperationCallback callback, final NotifyFuture<WriteAttributeResults> future )
    {
        if ( callback != null )
        {
            future.addListener ( new FutureListener<WriteAttributeResults> () {

                @Override
                public void complete ( final Future<WriteAttributeResults> future )
                {
                    try
                    {
                        callback.complete ( future.get () );
                    }
                    catch ( final Exception e )
                    {
                        callback.error ( e );
                    }
                }
            } );
        }
    }
}
