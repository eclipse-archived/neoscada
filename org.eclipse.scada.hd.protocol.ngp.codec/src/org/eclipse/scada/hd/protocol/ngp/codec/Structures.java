/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.hd.protocol.ngp.codec;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.BinaryContext;
import org.eclipse.scada.protocol.ngp.common.utils.ArrayListAllocator;
import org.eclipse.scada.protocol.ngp.common.utils.CollectionAllocator;
import org.eclipse.scada.protocol.ngp.common.utils.HashSetAllocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Structures
{

    private final static Logger logger = LoggerFactory.getLogger ( Structures.class );

    private Structures ()
    {
    }

    private static final ArrayListAllocator<org.eclipse.scada.hd.data.QueryParameters> ALLOC_QUERYPARAMETERS_LIST = new ArrayListAllocator<org.eclipse.scada.hd.data.QueryParameters> ();

    private static final HashSetAllocator<org.eclipse.scada.hd.data.QueryParameters> ALLOC_QUERYPARAMETERS_SET = new HashSetAllocator<org.eclipse.scada.hd.data.QueryParameters> ();

    protected static void inlineEncodeQueryParameters ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.hd.data.QueryParameters value ) throws Exception
    {
        // number of fields
        data.put ( (byte)3 );

        // encode attributes
        context.encodePrimitiveLong ( data, (byte)1, value.getStartTimestamp () );
        context.encodePrimitiveLong ( data, (byte)2, value.getEndTimestamp () );
        context.encodePrimitiveInt ( data, (byte)3, value.getNumberOfEntries () );

    }

    protected static org.eclipse.scada.hd.data.QueryParameters inlindeDecodeQueryParameters ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        long startTimestamp = 0L;
        long endTimestamp = 0L;
        int numberOfEntries = 0;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    startTimestamp = _context.decodePrimitiveLong ( _data );
                }
                    break;
                case 2:
                {
                    endTimestamp = _context.decodePrimitiveLong ( _data );
                }
                    break;
                case 3:
                {
                    numberOfEntries = _context.decodePrimitiveInt ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.hd.data.QueryParameters ( startTimestamp, endTimestamp, numberOfEntries );
    }

    public static void encodeQueryParameters ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.hd.data.QueryParameters value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeQueryParameters ( context, data, value );
        }
    }

    public static void encodeCollectionQueryParameters ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.hd.data.QueryParameters> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.hd.data.QueryParameters entry : values )
        {
            inlineEncodeQueryParameters ( context, data, entry );
        }
    }

    public static org.eclipse.scada.hd.data.QueryParameters decodeQueryParameters ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeQueryParameters ( context, data );
    }

    protected static void fillQueryParametersCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.hd.data.QueryParameters> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeQueryParameters ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.hd.data.QueryParameters>> T decodeQueryParametersCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.hd.data.QueryParameters, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillQueryParametersCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.hd.data.QueryParameters> decodeListQueryParameters ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeQueryParametersCollection ( context, data, ALLOC_QUERYPARAMETERS_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.hd.data.QueryParameters> decodeSetQueryParameters ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeQueryParametersCollection ( context, data, ALLOC_QUERYPARAMETERS_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.hd.data.HistoricalItemInformation> ALLOC_HISTORICALITEMINFORMATION_LIST = new ArrayListAllocator<org.eclipse.scada.hd.data.HistoricalItemInformation> ();

    private static final HashSetAllocator<org.eclipse.scada.hd.data.HistoricalItemInformation> ALLOC_HISTORICALITEMINFORMATION_SET = new HashSetAllocator<org.eclipse.scada.hd.data.HistoricalItemInformation> ();

    protected static void inlineEncodeHistoricalItemInformation ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.hd.data.HistoricalItemInformation value ) throws Exception
    {
        // number of fields
        data.put ( (byte)2 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getItemId () );
        context.encodeVariantMap ( data, (byte)2, value.getAttributes () );

    }

    protected static org.eclipse.scada.hd.data.HistoricalItemInformation inlindeDecodeHistoricalItemInformation ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String itemId = null;
        java.util.Map<String, org.eclipse.scada.core.Variant> attributes = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    itemId = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    attributes = _context.decodeVariantMap ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.hd.data.HistoricalItemInformation ( itemId, attributes );
    }

    public static void encodeHistoricalItemInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.hd.data.HistoricalItemInformation value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeHistoricalItemInformation ( context, data, value );
        }
    }

    public static void encodeCollectionHistoricalItemInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.hd.data.HistoricalItemInformation> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.hd.data.HistoricalItemInformation entry : values )
        {
            inlineEncodeHistoricalItemInformation ( context, data, entry );
        }
    }

    public static org.eclipse.scada.hd.data.HistoricalItemInformation decodeHistoricalItemInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeHistoricalItemInformation ( context, data );
    }

    protected static void fillHistoricalItemInformationCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.hd.data.HistoricalItemInformation> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeHistoricalItemInformation ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.hd.data.HistoricalItemInformation>> T decodeHistoricalItemInformationCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.hd.data.HistoricalItemInformation, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillHistoricalItemInformationCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.hd.data.HistoricalItemInformation> decodeListHistoricalItemInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeHistoricalItemInformationCollection ( context, data, ALLOC_HISTORICALITEMINFORMATION_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.hd.data.HistoricalItemInformation> decodeSetHistoricalItemInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeHistoricalItemInformationCollection ( context, data, ALLOC_HISTORICALITEMINFORMATION_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.hd.data.ValueInformation> ALLOC_VALUEINFORMATION_LIST = new ArrayListAllocator<org.eclipse.scada.hd.data.ValueInformation> ();

    private static final HashSetAllocator<org.eclipse.scada.hd.data.ValueInformation> ALLOC_VALUEINFORMATION_SET = new HashSetAllocator<org.eclipse.scada.hd.data.ValueInformation> ();

    protected static void inlineEncodeValueInformation ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.hd.data.ValueInformation value ) throws Exception
    {
        // number of fields
        data.put ( (byte)5 );

        // encode attributes
        context.encodePrimitiveDouble ( data, (byte)1, value.getQuality () );
        context.encodePrimitiveDouble ( data, (byte)2, value.getManualPercentage () );
        context.encodePrimitiveLong ( data, (byte)3, value.getStartTimestamp () );
        context.encodePrimitiveLong ( data, (byte)4, value.getEndTimestamp () );
        context.encodePrimitiveLong ( data, (byte)5, value.getSourceValues () );

    }

    protected static org.eclipse.scada.hd.data.ValueInformation inlindeDecodeValueInformation ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        double quality = 0.0;
        double manualPercentage = 0.0;
        long startTimestamp = 0L;
        long endTimestamp = 0L;
        long sourceValues = 0L;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    quality = _context.decodePrimitiveDouble ( _data );
                }
                    break;
                case 2:
                {
                    manualPercentage = _context.decodePrimitiveDouble ( _data );
                }
                    break;
                case 3:
                {
                    startTimestamp = _context.decodePrimitiveLong ( _data );
                }
                    break;
                case 4:
                {
                    endTimestamp = _context.decodePrimitiveLong ( _data );
                }
                    break;
                case 5:
                {
                    sourceValues = _context.decodePrimitiveLong ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.hd.data.ValueInformation ( quality, manualPercentage, startTimestamp, endTimestamp, sourceValues );
    }

    public static void encodeValueInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.hd.data.ValueInformation value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeValueInformation ( context, data, value );
        }
    }

    public static void encodeCollectionValueInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.hd.data.ValueInformation> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.hd.data.ValueInformation entry : values )
        {
            inlineEncodeValueInformation ( context, data, entry );
        }
    }

    public static org.eclipse.scada.hd.data.ValueInformation decodeValueInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeValueInformation ( context, data );
    }

    protected static void fillValueInformationCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.hd.data.ValueInformation> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeValueInformation ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.hd.data.ValueInformation>> T decodeValueInformationCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.hd.data.ValueInformation, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillValueInformationCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.hd.data.ValueInformation> decodeListValueInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeValueInformationCollection ( context, data, ALLOC_VALUEINFORMATION_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.hd.data.ValueInformation> decodeSetValueInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeValueInformationCollection ( context, data, ALLOC_VALUEINFORMATION_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.hd.data.ValueEntry> ALLOC_VALUEENTRY_LIST = new ArrayListAllocator<org.eclipse.scada.hd.data.ValueEntry> ();

    private static final HashSetAllocator<org.eclipse.scada.hd.data.ValueEntry> ALLOC_VALUEENTRY_SET = new HashSetAllocator<org.eclipse.scada.hd.data.ValueEntry> ();

    protected static void inlineEncodeValueEntry ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.hd.data.ValueEntry value ) throws Exception
    {
        // number of fields
        data.put ( (byte)2 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getValueType () );
        context.encodeDoubleCollection ( data, (byte)2, value.getValues () );

    }

    protected static org.eclipse.scada.hd.data.ValueEntry inlindeDecodeValueEntry ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String valueType = null;
        java.util.List<Double> values = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    valueType = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    values = _context.decodeDoubleList ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.hd.data.ValueEntry ( valueType, values );
    }

    public static void encodeValueEntry ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.hd.data.ValueEntry value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeValueEntry ( context, data, value );
        }
    }

    public static void encodeCollectionValueEntry ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.hd.data.ValueEntry> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.hd.data.ValueEntry entry : values )
        {
            inlineEncodeValueEntry ( context, data, entry );
        }
    }

    public static org.eclipse.scada.hd.data.ValueEntry decodeValueEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeValueEntry ( context, data );
    }

    protected static void fillValueEntryCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.hd.data.ValueEntry> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeValueEntry ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.hd.data.ValueEntry>> T decodeValueEntryCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.hd.data.ValueEntry, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillValueEntryCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.hd.data.ValueEntry> decodeListValueEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeValueEntryCollection ( context, data, ALLOC_VALUEENTRY_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.hd.data.ValueEntry> decodeSetValueEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeValueEntryCollection ( context, data, ALLOC_VALUEENTRY_SET, allowNull );
    }

}
