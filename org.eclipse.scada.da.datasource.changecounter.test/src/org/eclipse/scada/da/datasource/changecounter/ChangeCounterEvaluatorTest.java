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
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, System.currentTimeMillis () - 66 * 1000, false, false ) );
        valueRange.checkRange ();
        assertEquals ( 0, ChangeCounterEvaluator.handleDelta ( values, valueRange.getState (), ErrorHandling.ERROR ) );
    }

    @Test ( expected = IllegalArgumentException.class )
    public void testHandleDeltaWithError ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, System.currentTimeMillis () - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.NULL, SubscriptionState.CONNECTED, System.currentTimeMillis (), false, true ) );
        valueRange.checkRange ();
        ChangeCounterEvaluator.handleDelta ( values, valueRange.getState (), ErrorHandling.ERROR );
    }

    @Test
    public void testHandleDeltaWithIgnoredError ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, System.currentTimeMillis () - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.NULL, SubscriptionState.CONNECTED, System.currentTimeMillis (), false, true ) );
        valueRange.checkRange ();
        assertEquals ( 0, ChangeCounterEvaluator.handleDelta ( values, valueRange.getState (), ErrorHandling.IGNORE ) );
    }

    @Test
    public void testHandleDeltaWithCountedError ()
    {
        List<Variant> values = new ArrayList<Variant> ();
        values.add ( Variant.valueOf ( 1 ) );
        DataItemValueRange valueRange = new DataItemValueRange ( 60 * 1000 );
        valueRange.add ( new DataItemValueLight ( Variant.valueOf ( 1 ), SubscriptionState.CONNECTED, System.currentTimeMillis () - 66 * 1000, false, false ) );
        valueRange.add ( new DataItemValueLight ( Variant.NULL, SubscriptionState.CONNECTED, System.currentTimeMillis (), false, true ) );
        valueRange.checkRange ();
        assertEquals ( 1, ChangeCounterEvaluator.handleDelta ( values, valueRange.getState (), ErrorHandling.COUNT ) );
    }
}
