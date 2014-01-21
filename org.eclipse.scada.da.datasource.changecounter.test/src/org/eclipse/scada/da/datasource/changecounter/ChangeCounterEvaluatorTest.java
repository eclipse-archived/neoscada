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
package org.eclipse.scada.da.datasource.changecounter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.datasource.data.DataItemValueLight;
import org.eclipse.scada.da.datasource.data.DataItemValueRange;
import org.junit.Test;

public class ChangeCounterEvaluatorTest
{

    @Test
    public void testHandleDeltaNoChanges ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.checkRange ();
        assertEquals ( 0, ChangeCounterEvaluator.handleDelta ( values, valueRange.getState (), ErrorHandling.ERROR ) );
    }

    @Test ( expected = IllegalArgumentException.class )
    public void testHandleDeltaWithError ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.NULL, SubscriptionState.CONNECTED, t, false, true ) );
        valueRange.checkRange ();
        ChangeCounterEvaluator.handleDelta ( values, valueRange.getState (), ErrorHandling.ERROR );
    }

    @Test
    public void testHandleDeltaWithIgnoredError ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.NULL, SubscriptionState.CONNECTED, t, false, true ) );
        valueRange.checkRange ();
        assertEquals ( 0, ChangeCounterEvaluator.handleDelta ( values, valueRange.getState (), ErrorHandling.IGNORE ) );
    }

    @Test
    public void testHandleDeltaWithCountedError ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.NULL, SubscriptionState.CONNECTED, t, false, true ) );
        valueRange.checkRange ();
        assertEquals ( 1, ChangeCounterEvaluator.handleDelta ( values, valueRange.getState (), ErrorHandling.COUNT ) );
    }

    @Test
    public void testHandleSetNoChanges ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.checkRange ();
        assertEquals ( 0, ChangeCounterEvaluator.handleSet ( values, valueRange.getState (), ErrorHandling.ERROR ) );
    }

    @Test ( expected = IllegalArgumentException.class )
    public void testHandleSetWithError ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.NULL, SubscriptionState.CONNECTED, t, false, true ) );
        valueRange.checkRange ();
        ChangeCounterEvaluator.handleSet ( values, valueRange.getState (), ErrorHandling.ERROR );
    }

    @Test
    public void testHandleSetWithIgnoredError ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.NULL, SubscriptionState.CONNECTED, t, false, true ) );
        valueRange.checkRange ();
        assertEquals ( 0, ChangeCounterEvaluator.handleSet ( values, valueRange.getState (), ErrorHandling.IGNORE ) );
    }

    @Test
    public void testHandleSetWithCountedError ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.NULL, SubscriptionState.CONNECTED, t, false, true ) );
        valueRange.checkRange ();
        assertEquals ( 1, ChangeCounterEvaluator.handleSet ( values, valueRange.getState (), ErrorHandling.COUNT ) );
    }

    @Test
    public void testHandleSetSameList ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        values.add ( Variant.valueOf ( 2 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 2 ), SubscriptionState.CONNECTED, t, false, false ) );
        valueRange.checkRange ();
        assertEquals ( 0, ChangeCounterEvaluator.handleSet ( values, valueRange.getState (), ErrorHandling.ERROR ) );
    }

    @Test
    public void testHandleSet1Change ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        values.add ( Variant.valueOf ( 2 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 2 ), SubscriptionState.CONNECTED, t, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 3 ), SubscriptionState.CONNECTED, t + 1, false, false ) );
        valueRange.checkRange ();
        assertEquals ( 1, ChangeCounterEvaluator.handleSet ( values, valueRange.getState (), ErrorHandling.ERROR ) );
    }

    @Test
    public void testHandleSet2Change ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        values.add ( Variant.valueOf ( 2 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 2 ), SubscriptionState.CONNECTED, t, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 3 ), SubscriptionState.CONNECTED, t + 1, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t + 2, false, false ) );
        valueRange.checkRange ();
        assertEquals ( 2, ChangeCounterEvaluator.handleSet ( values, valueRange.getState (), ErrorHandling.ERROR ) );
    }


    @Test
    public void testHandleSet3Change ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        values.add ( Variant.valueOf ( 2 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        long t = System.currentTimeMillis ();
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 2 ), SubscriptionState.CONNECTED, t, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 3 ), SubscriptionState.CONNECTED, t + 1, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, t + 2, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 2 ), SubscriptionState.CONNECTED, t + 3, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 2 ), SubscriptionState.CONNECTED, t + 4, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 2 ), SubscriptionState.CONNECTED, t + 5, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 7 ), SubscriptionState.CONNECTED, t + 6, false, false ) );
        valueRange.checkRange ();
        assertEquals ( 3, ChangeCounterEvaluator.handleSet ( values, valueRange.getState (), ErrorHandling.ERROR ) );
    }
}
