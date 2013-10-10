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
package org.eclipse.scada.ae.protocol.ngp.codec;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.ngp.common.codec.osbp.BinaryContext;
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

    private static final ArrayListAllocator<org.eclipse.scada.ae.data.MonitorStatusInformation> ALLOC_MONITORSTATUSINFORMATION_LIST = new ArrayListAllocator<org.eclipse.scada.ae.data.MonitorStatusInformation> ();

    private static final HashSetAllocator<org.eclipse.scada.ae.data.MonitorStatusInformation> ALLOC_MONITORSTATUSINFORMATION_SET = new HashSetAllocator<org.eclipse.scada.ae.data.MonitorStatusInformation> ();

    protected static void inlineEncodeMonitorStatusInformation ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.ae.data.MonitorStatusInformation value ) throws Exception
    {
        // number of fields
        data.put ( (byte)10 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getId () );
        context.encodeEnum ( data, (byte)2, value.getStatus () );
        context.encodePrimitiveLong ( data, (byte)3, value.getStatusTimestamp () );
        context.encodeEnum ( data, (byte)4, value.getSeverity () );
        context.encodeVariant ( data, (byte)5, value.getValue () );
        context.encodeLong ( data, (byte)6, value.getLastAknTimestamp () );
        context.encodeString ( data, (byte)7, value.getLastAknUser () );
        context.encodeLong ( data, (byte)8, value.getLastFailTimestamp () );
        context.encodeVariant ( data, (byte)10, value.getLastFailValue () );
        context.encodeVariantMap ( data, (byte)9, value.getAttributes () );

    }

    protected static org.eclipse.scada.ae.data.MonitorStatusInformation inlindeDecodeMonitorStatusInformation ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String id = null;
        org.eclipse.scada.ae.data.MonitorStatus status = null;
        long statusTimestamp = 0L;
        org.eclipse.scada.ae.data.Severity severity = null;
        org.eclipse.scada.core.Variant value = null;
        Long lastAknTimestamp = null;
        String lastAknUser = null;
        Long lastFailTimestamp = null;
        org.eclipse.scada.core.Variant lastFailValue = null;
        java.util.Map<String, org.eclipse.scada.core.Variant> attributes = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    id = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    status = _context.decodeEnum ( _data, org.eclipse.scada.ae.data.MonitorStatus.class );
                }
                    break;
                case 3:
                {
                    statusTimestamp = _context.decodePrimitiveLong ( _data );
                }
                    break;
                case 4:
                {
                    severity = _context.decodeEnum ( _data, org.eclipse.scada.ae.data.Severity.class );
                }
                    break;
                case 5:
                {
                    value = _context.decodeVariant ( _data );
                }
                    break;
                case 6:
                {
                    lastAknTimestamp = _context.decodeLong ( _data );
                }
                    break;
                case 7:
                {
                    lastAknUser = _context.decodeString ( _data );
                }
                    break;
                case 8:
                {
                    lastFailTimestamp = _context.decodeLong ( _data );
                }
                    break;
                case 10:
                {
                    lastFailValue = _context.decodeVariant ( _data );
                }
                    break;
                case 9:
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
        return new org.eclipse.scada.ae.data.MonitorStatusInformation ( id, status, statusTimestamp, severity, value, lastAknTimestamp, lastAknUser, lastFailTimestamp, lastFailValue, attributes );
    }

    public static void encodeMonitorStatusInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.ae.data.MonitorStatusInformation value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeMonitorStatusInformation ( context, data, value );
        }
    }

    public static void encodeCollectionMonitorStatusInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.ae.data.MonitorStatusInformation> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.ae.data.MonitorStatusInformation entry : values )
        {
            inlineEncodeMonitorStatusInformation ( context, data, entry );
        }
    }

    public static org.eclipse.scada.ae.data.MonitorStatusInformation decodeMonitorStatusInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeMonitorStatusInformation ( context, data );
    }

    protected static void fillMonitorStatusInformationCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.ae.data.MonitorStatusInformation> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeMonitorStatusInformation ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.ae.data.MonitorStatusInformation>> T decodeMonitorStatusInformationCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.ae.data.MonitorStatusInformation, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillMonitorStatusInformationCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.ae.data.MonitorStatusInformation> decodeListMonitorStatusInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeMonitorStatusInformationCollection ( context, data, ALLOC_MONITORSTATUSINFORMATION_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.ae.data.MonitorStatusInformation> decodeSetMonitorStatusInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeMonitorStatusInformationCollection ( context, data, ALLOC_MONITORSTATUSINFORMATION_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.ae.data.BrowserEntry> ALLOC_BROWSERENTRY_LIST = new ArrayListAllocator<org.eclipse.scada.ae.data.BrowserEntry> ();

    private static final HashSetAllocator<org.eclipse.scada.ae.data.BrowserEntry> ALLOC_BROWSERENTRY_SET = new HashSetAllocator<org.eclipse.scada.ae.data.BrowserEntry> ();

    protected static void inlineEncodeBrowserEntry ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.ae.data.BrowserEntry value ) throws Exception
    {
        // number of fields
        data.put ( (byte)3 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getId () );
        context.encodeEnumSet ( data, (byte)2, value.getTypes () );
        context.encodeVariantMap ( data, (byte)3, value.getAttributes () );

    }

    protected static org.eclipse.scada.ae.data.BrowserEntry inlindeDecodeBrowserEntry ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String id = null;
        java.util.Set<org.eclipse.scada.ae.data.BrowserType> types = null;
        java.util.Map<String, org.eclipse.scada.core.Variant> attributes = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    id = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    types = _context.decodeEnumSet ( _data, org.eclipse.scada.ae.data.BrowserType.class );
                }
                    break;
                case 3:
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
        return new org.eclipse.scada.ae.data.BrowserEntry ( id, types, attributes );
    }

    public static void encodeBrowserEntry ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.ae.data.BrowserEntry value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeBrowserEntry ( context, data, value );
        }
    }

    public static void encodeCollectionBrowserEntry ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.ae.data.BrowserEntry> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.ae.data.BrowserEntry entry : values )
        {
            inlineEncodeBrowserEntry ( context, data, entry );
        }
    }

    public static org.eclipse.scada.ae.data.BrowserEntry decodeBrowserEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeBrowserEntry ( context, data );
    }

    protected static void fillBrowserEntryCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.ae.data.BrowserEntry> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeBrowserEntry ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.ae.data.BrowserEntry>> T decodeBrowserEntryCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.ae.data.BrowserEntry, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillBrowserEntryCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.ae.data.BrowserEntry> decodeListBrowserEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeBrowserEntryCollection ( context, data, ALLOC_BROWSERENTRY_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.ae.data.BrowserEntry> decodeSetBrowserEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeBrowserEntryCollection ( context, data, ALLOC_BROWSERENTRY_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.ae.data.EventInformation> ALLOC_EVENTINFORMATION_LIST = new ArrayListAllocator<org.eclipse.scada.ae.data.EventInformation> ();

    private static final HashSetAllocator<org.eclipse.scada.ae.data.EventInformation> ALLOC_EVENTINFORMATION_SET = new HashSetAllocator<org.eclipse.scada.ae.data.EventInformation> ();

    protected static void inlineEncodeEventInformation ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.ae.data.EventInformation value ) throws Exception
    {
        // number of fields
        data.put ( (byte)4 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getId () );
        context.encodePrimitiveLong ( data, (byte)2, value.getSourceTimestamp () );
        context.encodePrimitiveLong ( data, (byte)3, value.getEntryTimestamp () );
        context.encodeVariantMap ( data, (byte)4, value.getAttributes () );

    }

    protected static org.eclipse.scada.ae.data.EventInformation inlindeDecodeEventInformation ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String id = null;
        long sourceTimestamp = 0L;
        long entryTimestamp = 0L;
        java.util.Map<String, org.eclipse.scada.core.Variant> attributes = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    id = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    sourceTimestamp = _context.decodePrimitiveLong ( _data );
                }
                    break;
                case 3:
                {
                    entryTimestamp = _context.decodePrimitiveLong ( _data );
                }
                    break;
                case 4:
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
        return new org.eclipse.scada.ae.data.EventInformation ( id, sourceTimestamp, entryTimestamp, attributes );
    }

    public static void encodeEventInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.ae.data.EventInformation value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeEventInformation ( context, data, value );
        }
    }

    public static void encodeCollectionEventInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.ae.data.EventInformation> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.ae.data.EventInformation entry : values )
        {
            inlineEncodeEventInformation ( context, data, entry );
        }
    }

    public static org.eclipse.scada.ae.data.EventInformation decodeEventInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeEventInformation ( context, data );
    }

    protected static void fillEventInformationCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.ae.data.EventInformation> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeEventInformation ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.ae.data.EventInformation>> T decodeEventInformationCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.ae.data.EventInformation, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillEventInformationCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.ae.data.EventInformation> decodeListEventInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeEventInformationCollection ( context, data, ALLOC_EVENTINFORMATION_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.ae.data.EventInformation> decodeSetEventInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeEventInformationCollection ( context, data, ALLOC_EVENTINFORMATION_SET, allowNull );
    }

}
