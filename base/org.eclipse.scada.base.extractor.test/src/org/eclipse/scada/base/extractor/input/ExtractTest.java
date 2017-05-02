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
package org.eclipse.scada.base.extractor.input;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.scada.base.extractor.extract.ItemDescriptor;
import org.eclipse.scada.base.extractor.extract.ItemValue;
import org.eclipse.scada.base.extractor.extract.pattern.FieldSpec;
import org.eclipse.scada.base.extractor.extract.pattern.MainFieldSpec;
import org.eclipse.scada.base.extractor.extract.pattern.MultiPatternExtractor;
import org.eclipse.scada.base.extractor.extract.pattern.MultiPatternExtractor.Fields;
import org.eclipse.scada.base.extractor.extract.pattern.NumberFieldSpec;
import org.eclipse.scada.base.extractor.extract.pattern.SinglePatternExtractor;
import org.eclipse.scada.base.extractor.extract.pattern.ValueFieldDescriptor;
import org.eclipse.scada.base.extractor.input.utils.AbstractExtractTest;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantType;
import org.junit.Test;

public class ExtractTest extends AbstractExtractTest
{
    /**
     * Basic test
     */
    @Test
    public void test1 ()
    {
        final SinglePatternExtractor ex = new SinglePatternExtractor ( Pattern.compile ( "(.*)" ), true, new MainFieldSpec ( VariantType.STRING ), null );

        final Map<String, ItemValue> values = new HashMap<> ();

        expectValue ( values, "value", Variant.valueOf ( "test" ) );
        expectMatchState ( values, 1 );

        test ( ex.processData ( new Data ( "test", null ) ), values, null );
    }

    /**
     * Basic test - attribute
     */
    @Test
    public void test1a ()
    {
        final Map<String, FieldSpec> attributes = new HashMap<String, FieldSpec> ();
        attributes.put ( "attr", new MainFieldSpec () );

        final SinglePatternExtractor ex = new SinglePatternExtractor ( Pattern.compile ( "(.*)" ), true, new MainFieldSpec (), attributes );

        final Map<String, ItemValue> values = new HashMap<> ();

        final Map<String, Variant> attrs = new HashMap<> ();

        attrs.put ( "attr", Variant.valueOf ( "test" ) );

        values.put ( "value", new ItemValue ( Variant.valueOf ( "test" ), attrs ) );

        expectMatchState ( values, 1 );

        test ( ex.processData ( new Data ( "test", null ) ), values, null );
    }

    /**
     * Test with special VariantEditor syntax
     */
    @Test
    public void test2 ()
    {
        final SinglePatternExtractor ex = new SinglePatternExtractor ( Pattern.compile ( "(.*)" ), true, new MainFieldSpec ( VariantType.STRING ), null );

        final Map<String, ItemValue> values = new HashMap<> ();

        expectValue ( values, "value", Variant.valueOf ( "INT32#test" ) );
        expectMatchState ( values, 1 );

        test ( ex.processData ( new Data ( "INT32#test", null ) ), values, null );
    }

    @Test
    public void test3 ()
    {
        final String pattern = "a";
        final String data = "test";

        final SinglePatternExtractor ex = new SinglePatternExtractor ( Pattern.compile ( pattern ), true, new MainFieldSpec ( VariantType.STRING ), null );

        final Map<String, ItemValue> values = new HashMap<> ();
        {
            final Map<String, Variant> attributes = new HashMap<> ();
            attributes.put ( "nomatch.error", Variant.TRUE );
            values.put ( "value", new ItemValue ( Variant.NULL, attributes ) );
        }

        {
            final Map<String, Variant> attributes = new HashMap<> ();
            attributes.put ( "matcher.matches", Variant.FALSE );
            attributes.put ( "matcher.pattern", Variant.valueOf ( pattern ) );
            attributes.put ( "matcher.fullMatch", Variant.TRUE );
            attributes.put ( "matcher.input.data", Variant.valueOf ( data ) );
            values.put ( "state", new ItemValue ( Variant.valueOf ( "NO-MATCH" ), attributes ) );
        }

        test ( ex.processData ( new Data ( data, null ) ), values, null );
    }

    @Test
    public void test4 ()
    {
        final Map<ItemDescriptor, ValueFieldDescriptor> fields = new HashMap<ItemDescriptor, ValueFieldDescriptor> ();

        fields.put ( new ItemDescriptor ( "value1", null ), new ValueFieldDescriptor ( new NumberFieldSpec ( 1 ), null ) );
        fields.put ( new ItemDescriptor ( "value2", null ), new ValueFieldDescriptor ( new NumberFieldSpec ( 2 ), null ) );
        fields.put ( new ItemDescriptor ( "value3", null ), new ValueFieldDescriptor ( new MainFieldSpec (), null ) );

        final Fields f = new Fields ( fields );
        final MultiPatternExtractor ex = new MultiPatternExtractor ( Pattern.compile ( "(foo).*(bar)" ), f );

        final Map<String, ItemValue> values = new HashMap<> ();

        expectValue ( values, "value1", Variant.valueOf ( "foo" ) );
        expectValue ( values, "value2", Variant.valueOf ( "bar" ) );
        expectValue ( values, "value3", Variant.valueOf ( "footheworldbar" ) );
        expectMatchState ( values, 2 );

        test ( ex.processData ( new Data ( "footheworldbar", null ) ), values, null );
    }

    /**
     * Basic test - numeric
     */
    @Test
    public void test1b ()
    {
        final Map<ItemDescriptor, ValueFieldDescriptor> fields = new HashMap<ItemDescriptor, ValueFieldDescriptor> ();

        fields.put ( new ItemDescriptor ( "value1", null ), new ValueFieldDescriptor ( new MainFieldSpec ( VariantType.STRING ), null ) );
        fields.put ( new ItemDescriptor ( "value2", null ), new ValueFieldDescriptor ( new MainFieldSpec ( VariantType.INT32 ), null ) );
        fields.put ( new ItemDescriptor ( "value3", null ), new ValueFieldDescriptor ( new MainFieldSpec ( VariantType.INT64 ), null ) );
        fields.put ( new ItemDescriptor ( "value4", null ), new ValueFieldDescriptor ( new MainFieldSpec ( VariantType.DOUBLE ), null ) );
        fields.put ( new ItemDescriptor ( "value5", null ), new ValueFieldDescriptor ( new MainFieldSpec ( VariantType.BOOLEAN ), null ) );

        final MultiPatternExtractor ex = new MultiPatternExtractor ( Pattern.compile ( ".*" ), new Fields ( fields ) );

        final Map<String, ItemValue> values = new HashMap<> ();

        expectValue ( values, "value1", Variant.valueOf ( "123" ) );
        expectValue ( values, "value2", Variant.valueOf ( 123 ) );
        expectValue ( values, "value3", Variant.valueOf ( 123L ) );
        expectValue ( values, "value4", Variant.valueOf ( 123.0 ) );
        expectValue ( values, "value5", Variant.TRUE );

        expectMatchState ( values, 0 );

        test ( ex.processData ( new Data ( "123", null ) ), values, null );
    }
}
