/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.test.items;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.server.common.DataItemOutput;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestItem1 extends DataItemOutput
{

    private final static Logger logger = LoggerFactory.getLogger ( TestItem1.class );

    public TestItem1 ( final String name )
    {
        super ( name );
    }

    @Override
    public Map<String, Variant> getAttributes ()
    {
        return new HashMap<String, Variant> ();
    }

    @Override
    public NotifyFuture<WriteAttributeResults> startSetAttributes ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        final WriteAttributeResults results = new WriteAttributeResults ();

        for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
        {
            logger.info ( "Attribute: '{}' => '{}'", entry.getKey (), entry.getValue () );
            if ( entry.getKey ().startsWith ( "error" ) )
            {
                results.put ( entry.getKey (), new WriteAttributeResult ( new Exception ( "Testing error" ) ) );
            }
            else
            {
                results.put ( entry.getKey (), WriteAttributeResult.OK );
            }
        }

        return new InstantFuture<WriteAttributeResults> ( results );
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( final Variant value, final OperationParameters operationParameters )
    {
        logger.debug ( "set value: {}", value.toString () );

        String data;
        try
        {
            data = value.asString ();
            if ( data.startsWith ( "error" ) )
            {
                return new InstantErrorFuture<WriteResult> ( new InvalidOperationException () );
            }
            return new InstantFuture<WriteResult> ( new WriteResult () );
        }
        catch ( final Throwable e )
        {
            return new InstantErrorFuture<WriteResult> ( e );
        }
    }
}
