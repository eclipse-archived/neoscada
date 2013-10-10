/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client.samples;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.ItemManager;
import org.eclipse.scada.da.client.ItemManagerImpl;
import org.eclipse.scada.da.client.ItemUpdateListener;
import org.eclipse.scada.da.client.net.Connection;

public class GCTest1 extends SampleBase implements ItemUpdateListener
{
    private ItemManager itemManager;

    private String itemName = "time";

    public GCTest1 ( final String uri, final String className, final String itemName ) throws Exception
    {
        super ( uri, className );
        this.itemName = itemName;
    }

    @Override
    public void connect () throws Exception
    {
        super.connect ();
        this.itemManager = new ItemManagerImpl ( this.connection );
    }

    public void subscribe ()
    {
        // add us as item update listener
        // since we subscribe with "initial=true" we will get the current value
        // before any other event. Setting to "false" would ignore the current
        // value of this item and wait for the first change.
        this.itemManager.addItemUpdateListener ( this.itemName, this );
    }

    public void unsubscribe ()
    {
        // now remove the update listener
        this.itemManager.removeItemUpdateListener ( this.itemName, this );
    }

    @Override
    public void notifyDataChange ( final Variant value, final Map<String, Variant> attributes, final boolean cache )
    {
        if ( value != null )
        {
            // The value has changed
            // If it is an initial transmission it is not a change but the last change that occurred.
            System.out.println ( "Value of item changed: " + value.toString () + ( cache ? " (cache read)" : "" ) );
        }

        if ( attributes != null )
        {
            // Attributes have changed
            // If it is an "initial" transmission it is a complete set. Otherwise it is only
            // the set of changed attributes.
            System.out.println ( String.format ( "Attributes changed for item: %d update(s)%s", attributes.size (), cache ? " (cache read)" : "" ) );
            for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
            {
                System.out.println ( String.format ( "'%s' => '%s'", entry.getKey (), entry.getValue ().toString () ) );
            }
        }
    }

    @Override
    public void notifySubscriptionChange ( final SubscriptionState state, final Throwable subscriptionError )
    {
        System.out.println ( "Subscription state: " + state.name () + " Error: " + ( subscriptionError == null ? "<none>" : subscriptionError.getMessage () ) );
    }

    @Override
    protected void finalize () throws Throwable
    {
        System.out.println ( "Finalized GCTest1" );
        super.finalize ();
    }

    public static void main ( final String[] args ) throws Exception
    {
        final String uri = "da:net://localhost:1202";
        final String className = Connection.class.getName ();

        /*
        if ( args.length > 0 )
            uri = args[0];
        if ( args.length > 1 )
            className = args[1];
        String itemName = "time";
        if ( args.length > 2 )
            itemName = args[2];
            */
        final String itemName = "TW1.state";

        GCTest1 s = null;
        try
        {
            s = new GCTest1 ( uri, className, itemName );
            s.connect ();
            s.subscribe ();
            Thread.sleep ( 10 * 1000 );
            s.unsubscribe ();
        }
        catch ( final Throwable e )
        {
            e.printStackTrace ();
        }
        finally
        {
            if ( s != null )
            {
                s.dispose ();
            }
        }
        s = null;

        Thread.sleep ( 2 * 1000 );
        System.gc ();
        Thread.sleep ( 30 * 1000 );
    }
}
