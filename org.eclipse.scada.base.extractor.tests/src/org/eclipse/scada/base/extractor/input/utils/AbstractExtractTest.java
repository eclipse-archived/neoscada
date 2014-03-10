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
package org.eclipse.scada.base.extractor.input.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.ItemDescriptor;
import org.eclipse.scada.base.extractor.extract.ItemValue;
import org.eclipse.scada.core.Variant;
import org.junit.Assert;

public class AbstractExtractTest
{

    protected void expectValue ( final Map<String, ItemValue> values, final String valueName, final Variant value )
    {
        values.put ( valueName, new ItemValue ( value, null ) );
    }

    protected void expectMatchState ( final Map<String, ItemValue> values, final int groups )
    {
        final Map<String, Variant> attributes = new HashMap<> ();
        attributes.put ( "matcher.matches", Variant.TRUE );
        attributes.put ( "matcher.groupCount", Variant.valueOf ( groups ) );
        values.put ( "state", new ItemValue ( Variant.valueOf ( "MATCH" ), attributes ) );
    }

    protected void test ( final Extractor.Result result, final Map<String, ItemValue> values, final Throwable error )
    {
        dump ( result );

        // now test

        if ( error != null )
        {
            Assert.assertNull ( "There must be an error", result.getError () );
            Assert.assertEquals ( "Exception class", error.getClass (), result.getError ().getClass () );
        }
        else
        {
            Assert.assertNull ( "There must not be an error", result.getError () );
        }

        if ( values != null )
        {
            Assert.assertNull ( "There must be no error", result.getError () );
        }
        else
        {
            Assert.assertNotNull ( "There must be an error", result.getError () );
        }

        // test content
        for ( final Map.Entry<ItemDescriptor, ItemValue> entry : result.getItemValues ().entrySet () )
        {
            final ItemValue expectedValue = values.remove ( entry.getKey ().getLocalId () );
            Assert.assertNotNull ( String.format ( "Result '%s' was not expected", entry.getKey () ), expectedValue );

            Assert.assertEquals ( "Value", expectedValue.getValue (), entry.getValue ().getValue () );
            Assert.assertEquals ( "Attributes", expectedValue.getAttributes (), entry.getValue ().getAttributes () );
        }

        // since we removed everything we should have an empty map now
        Assert.assertTrue ( "Result expected more values than delivered", values.isEmpty () );
    }

    public static void dump ( final Extractor.Result result )
    {
        System.out.println ( "Result:" );
        System.out.println ( "=========" );

        if ( result.getError () != null )
        {
            result.getError ().printStackTrace ();
        }
        else if ( result.getItemValues () != null )
        {
            for ( final Map.Entry<ItemDescriptor, ItemValue> entry : result.getItemValues ().entrySet () )
            {
                System.out.println ( entry.getKey () + " => " + entry.getValue ().getValue () );
                for ( final Map.Entry<String, Variant> attr : entry.getValue ().getAttributes ().entrySet () )
                {
                    System.out.println ( "\t" + attr.getKey () + " => " + attr.getValue () );
                }
            }
        }
        else
        {
            System.out.println ( "No data at all" );
        }

        System.out.println ();
    }

}