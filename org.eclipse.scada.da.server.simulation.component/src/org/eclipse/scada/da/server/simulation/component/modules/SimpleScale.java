/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.simulation.component.modules;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.simulation.component.Hive;
import org.eclipse.scada.utils.collection.MapBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleScale extends BaseModule
{
    private final static Logger logger = LoggerFactory.getLogger ( SimpleScale.class );

    private Thread thread = null;

    private final int minDelay = 2 * 1000;

    private final int maxDelay = 10 * 1000;

    private final int minWeight = 10000;

    private final int maxWeight = 30000;

    private final double errorRatio = 0.10;

    private final DataItemInputChained valueInput;

    private final DataItemInputChained errorInput;

    private final DataItemInputChained activeInput;

    private static final Random random = new Random ();

    public SimpleScale ( final Hive hive, final String id )
    {
        super ( hive, "scale." + id );

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "tag", Variant.valueOf ( "scale." + id ) );

        final DataItemCommand startCommand = getOutput ( "start", attributes );
        startCommand.addListener ( new DataItemCommand.Listener () {

            @Override
            public void command ( final Variant value )
            {
                startWeight ();
            }
        } );

        this.valueInput = getInput ( "value", attributes );
        this.errorInput = getInput ( "error", attributes );
        this.activeInput = getInput ( "active", new MapBuilder<String, Variant> ( attributes ).put ( "description", Variant.valueOf ( "An indicator if a weight process is active. True means: active, false: not active" ) ).getMap () );
        this.activeInput.updateData ( Variant.valueOf ( false ), null, null );
    }

    protected synchronized void startWeight ()
    {
        if ( this.thread != null )
        {
            return;
        }
        this.thread = new Thread ( new Runnable () {

            @Override
            public void run ()
            {
                performWeight ();
            }
        } );
        this.thread.start ();
    }

    protected void performWeight ()
    {
        final int delay = this.minDelay + random.nextInt ( this.maxDelay - this.minDelay );
        logger.debug ( String.format ( "Weight delay: %d", delay ) );

        this.activeInput.updateData ( Variant.TRUE, new MapBuilder<String, Variant> ().put ( "sim.scale.last-delay", Variant.valueOf ( delay ) ).getMap (), null );

        try
        {
            Thread.sleep ( delay );
        }
        catch ( final InterruptedException e )
        {
        }

        final boolean error = random.nextDouble () < this.errorRatio;

        if ( error )
        {
            final int errorCode = random.nextInt ( 255 );
            finishWithError ( errorCode );
        }
        else
        {
            final int weight = this.minWeight + random.nextInt ( this.maxWeight - this.minWeight );
            finishWeight ( weight );
        }

        this.activeInput.updateData ( Variant.valueOf ( false ), null, null );

        this.thread = null;
    }

    protected void finishWeight ( final int value )
    {
        this.valueInput.updateData ( Variant.valueOf ( value ), null, null );
        this.errorInput.updateData ( Variant.NULL, null, null );
    }

    protected void finishWithError ( final int errorCode )
    {
        this.valueInput.updateData ( Variant.NULL, null, null );
        this.errorInput.updateData ( Variant.valueOf ( errorCode ), null, null );
    }

}
