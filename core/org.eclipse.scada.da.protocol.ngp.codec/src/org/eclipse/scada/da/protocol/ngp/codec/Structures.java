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
package org.eclipse.scada.da.protocol.ngp.codec;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.ngp.common.codec.osbp.BinaryContext;
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

    private static final ArrayListAllocator<org.eclipse.scada.da.data.AttributeWriteResultEntry> ALLOC_ATTRIBUTEWRITERESULTENTRY_LIST = new ArrayListAllocator<org.eclipse.scada.da.data.AttributeWriteResultEntry> ();

    private static final HashSetAllocator<org.eclipse.scada.da.data.AttributeWriteResultEntry> ALLOC_ATTRIBUTEWRITERESULTENTRY_SET = new HashSetAllocator<org.eclipse.scada.da.data.AttributeWriteResultEntry> ();

    protected static void inlineEncodeAttributeWriteResultEntry ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.da.data.AttributeWriteResultEntry value ) throws Exception
    {
        // number of fields
        data.put ( (byte)2 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getAttribute () );
        org.eclipse.scada.core.protocol.ngp.codec.Structures.encodeErrorInformation ( context, data, (byte)2, value.getErrorInformation () );

    }

    protected static org.eclipse.scada.da.data.AttributeWriteResultEntry inlindeDecodeAttributeWriteResultEntry ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String attribute = null;
        org.eclipse.scada.core.data.ErrorInformation errorInformation = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    attribute = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    errorInformation = org.eclipse.scada.core.protocol.ngp.codec.Structures.decodeErrorInformation ( _context, _data, true );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.da.data.AttributeWriteResultEntry ( attribute, errorInformation );
    }

    public static void encodeAttributeWriteResultEntry ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.da.data.AttributeWriteResultEntry value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeAttributeWriteResultEntry ( context, data, value );
        }
    }

    public static void encodeCollectionAttributeWriteResultEntry ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.da.data.AttributeWriteResultEntry> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.da.data.AttributeWriteResultEntry entry : values )
        {
            inlineEncodeAttributeWriteResultEntry ( context, data, entry );
        }
    }

    public static org.eclipse.scada.da.data.AttributeWriteResultEntry decodeAttributeWriteResultEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeAttributeWriteResultEntry ( context, data );
    }

    protected static void fillAttributeWriteResultEntryCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.da.data.AttributeWriteResultEntry> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeAttributeWriteResultEntry ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.da.data.AttributeWriteResultEntry>> T decodeAttributeWriteResultEntryCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.da.data.AttributeWriteResultEntry, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillAttributeWriteResultEntryCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.da.data.AttributeWriteResultEntry> decodeListAttributeWriteResultEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeAttributeWriteResultEntryCollection ( context, data, ALLOC_ATTRIBUTEWRITERESULTENTRY_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.da.data.AttributeWriteResultEntry> decodeSetAttributeWriteResultEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeAttributeWriteResultEntryCollection ( context, data, ALLOC_ATTRIBUTEWRITERESULTENTRY_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.da.data.BrowserEntry> ALLOC_BROWSERENTRY_LIST = new ArrayListAllocator<org.eclipse.scada.da.data.BrowserEntry> ();

    private static final HashSetAllocator<org.eclipse.scada.da.data.BrowserEntry> ALLOC_BROWSERENTRY_SET = new HashSetAllocator<org.eclipse.scada.da.data.BrowserEntry> ();

    protected static void inlineEncodeBrowserEntry ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.da.data.BrowserEntry value ) throws Exception
    {
        // number of fields
        data.put ( (byte)5 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getName () );
        context.encodeEnum ( data, (byte)2, value.getEntryType () );
        context.encodeString ( data, (byte)3, value.getItemId () );
        context.encodeVariantMap ( data, (byte)4, value.getAttributes () );
        context.encodeEnumSet ( data, (byte)5, value.getIoDirection () );

    }

    protected static org.eclipse.scada.da.data.BrowserEntry inlindeDecodeBrowserEntry ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String name = null;
        org.eclipse.scada.da.data.FolderEntryType entryType = null;
        String itemId = null;
        java.util.Map<String, org.eclipse.scada.core.Variant> attributes = null;
        java.util.Set<org.eclipse.scada.da.data.IODirection> ioDirection = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    name = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    entryType = _context.decodeEnum ( _data, org.eclipse.scada.da.data.FolderEntryType.class );
                }
                    break;
                case 3:
                {
                    itemId = _context.decodeString ( _data );
                }
                    break;
                case 4:
                {
                    attributes = _context.decodeVariantMap ( _data );
                }
                    break;
                case 5:
                {
                    ioDirection = _context.decodeEnumSet ( _data, org.eclipse.scada.da.data.IODirection.class );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.da.data.BrowserEntry ( name, entryType, itemId, attributes, ioDirection );
    }

    public static void encodeBrowserEntry ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.da.data.BrowserEntry value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeBrowserEntry ( context, data, value );
        }
    }

    public static void encodeCollectionBrowserEntry ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.da.data.BrowserEntry> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.da.data.BrowserEntry entry : values )
        {
            inlineEncodeBrowserEntry ( context, data, entry );
        }
    }

    public static org.eclipse.scada.da.data.BrowserEntry decodeBrowserEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeBrowserEntry ( context, data );
    }

    protected static void fillBrowserEntryCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.da.data.BrowserEntry> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeBrowserEntry ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.da.data.BrowserEntry>> T decodeBrowserEntryCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.da.data.BrowserEntry, T> allactor, final boolean allowNull ) throws Exception
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

    public static List<org.eclipse.scada.da.data.BrowserEntry> decodeListBrowserEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeBrowserEntryCollection ( context, data, ALLOC_BROWSERENTRY_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.da.data.BrowserEntry> decodeSetBrowserEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeBrowserEntryCollection ( context, data, ALLOC_BROWSERENTRY_SET, allowNull );
    }

}
