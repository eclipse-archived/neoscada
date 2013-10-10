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
package org.eclipse.scada.ca.protocol.ngp.codec;

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

    private static final ArrayListAllocator<org.eclipse.scada.ca.data.FactoryInformation> ALLOC_FACTORYINFORMATION_LIST = new ArrayListAllocator<org.eclipse.scada.ca.data.FactoryInformation> ();

    private static final HashSetAllocator<org.eclipse.scada.ca.data.FactoryInformation> ALLOC_FACTORYINFORMATION_SET = new HashSetAllocator<org.eclipse.scada.ca.data.FactoryInformation> ();

    protected static void inlineEncodeFactoryInformation ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.ca.data.FactoryInformation value ) throws Exception
    {
        // number of fields
        data.put ( (byte)4 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getId () );
        context.encodeString ( data, (byte)2, value.getDescription () );
        context.encodeEnum ( data, (byte)3, value.getState () );
        org.eclipse.scada.ca.protocol.ngp.codec.Structures.encodeCollectionConfigurationInformation ( context, data, (byte)4, value.getConfigurations () );

    }

    protected static org.eclipse.scada.ca.data.FactoryInformation inlindeDecodeFactoryInformation ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String id = null;
        String description = null;
        org.eclipse.scada.ca.data.FactoryState state = null;
        java.util.List<org.eclipse.scada.ca.data.ConfigurationInformation> configurations = null;

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
                    description = _context.decodeString ( _data );
                }
                    break;
                case 3:
                {
                    state = _context.decodeEnum ( _data, org.eclipse.scada.ca.data.FactoryState.class );
                }
                    break;
                case 4:
                {
                    configurations = org.eclipse.scada.ca.protocol.ngp.codec.Structures.decodeListConfigurationInformation ( _context, _data, true );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.ca.data.FactoryInformation ( id, description, state, configurations );
    }

    public static void encodeFactoryInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.ca.data.FactoryInformation value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeFactoryInformation ( context, data, value );
        }
    }

    public static void encodeCollectionFactoryInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.ca.data.FactoryInformation> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.ca.data.FactoryInformation entry : values )
        {
            inlineEncodeFactoryInformation ( context, data, entry );
        }
    }

    public static org.eclipse.scada.ca.data.FactoryInformation decodeFactoryInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeFactoryInformation ( context, data );
    }

    protected static void fillFactoryInformationCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.ca.data.FactoryInformation> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeFactoryInformation ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.ca.data.FactoryInformation>> T decodeFactoryInformationCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.ca.data.FactoryInformation, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillFactoryInformationCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.ca.data.FactoryInformation> decodeListFactoryInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeFactoryInformationCollection ( context, data, ALLOC_FACTORYINFORMATION_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.ca.data.FactoryInformation> decodeSetFactoryInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeFactoryInformationCollection ( context, data, ALLOC_FACTORYINFORMATION_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.ca.data.ConfigurationInformation> ALLOC_CONFIGURATIONINFORMATION_LIST = new ArrayListAllocator<org.eclipse.scada.ca.data.ConfigurationInformation> ();

    private static final HashSetAllocator<org.eclipse.scada.ca.data.ConfigurationInformation> ALLOC_CONFIGURATIONINFORMATION_SET = new HashSetAllocator<org.eclipse.scada.ca.data.ConfigurationInformation> ();

    protected static void inlineEncodeConfigurationInformation ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.ca.data.ConfigurationInformation value ) throws Exception
    {
        // number of fields
        data.put ( (byte)5 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getFactoryId () );
        context.encodeString ( data, (byte)2, value.getId () );
        context.encodeEnum ( data, (byte)3, value.getState () );
        context.encodeProperties ( data, (byte)4, value.getData () );
        context.encodeString ( data, (byte)5, value.getErrorInformation () );

    }

    protected static org.eclipse.scada.ca.data.ConfigurationInformation inlindeDecodeConfigurationInformation ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String factoryId = null;
        String id = null;
        org.eclipse.scada.ca.data.ConfigurationState state = null;
        java.util.Map<String, String> data = null;
        String errorInformation = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    factoryId = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    id = _context.decodeString ( _data );
                }
                    break;
                case 3:
                {
                    state = _context.decodeEnum ( _data, org.eclipse.scada.ca.data.ConfigurationState.class );
                }
                    break;
                case 4:
                {
                    data = _context.decodeProperties ( _data );
                }
                    break;
                case 5:
                {
                    errorInformation = _context.decodeString ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.ca.data.ConfigurationInformation ( factoryId, id, state, data, errorInformation );
    }

    public static void encodeConfigurationInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.ca.data.ConfigurationInformation value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeConfigurationInformation ( context, data, value );
        }
    }

    public static void encodeCollectionConfigurationInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.ca.data.ConfigurationInformation> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.ca.data.ConfigurationInformation entry : values )
        {
            inlineEncodeConfigurationInformation ( context, data, entry );
        }
    }

    public static org.eclipse.scada.ca.data.ConfigurationInformation decodeConfigurationInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeConfigurationInformation ( context, data );
    }

    protected static void fillConfigurationInformationCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.ca.data.ConfigurationInformation> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeConfigurationInformation ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.ca.data.ConfigurationInformation>> T decodeConfigurationInformationCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.ca.data.ConfigurationInformation, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillConfigurationInformationCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.ca.data.ConfigurationInformation> decodeListConfigurationInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeConfigurationInformationCollection ( context, data, ALLOC_CONFIGURATIONINFORMATION_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.ca.data.ConfigurationInformation> decodeSetConfigurationInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeConfigurationInformationCollection ( context, data, ALLOC_CONFIGURATIONINFORMATION_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.ca.data.DiffEntry> ALLOC_DIFFENTRY_LIST = new ArrayListAllocator<org.eclipse.scada.ca.data.DiffEntry> ();

    private static final HashSetAllocator<org.eclipse.scada.ca.data.DiffEntry> ALLOC_DIFFENTRY_SET = new HashSetAllocator<org.eclipse.scada.ca.data.DiffEntry> ();

    protected static void inlineEncodeDiffEntry ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.ca.data.DiffEntry value ) throws Exception
    {
        // number of fields
        data.put ( (byte)5 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getFactoryId () );
        context.encodeString ( data, (byte)2, value.getConfigurationId () );
        context.encodeEnum ( data, (byte)3, value.getOperation () );
        context.encodeProperties ( data, (byte)5, value.getAddedOrUpdatedData () );
        context.encodeStringCollection ( data, (byte)6, value.getRemovedData () );

    }

    protected static org.eclipse.scada.ca.data.DiffEntry inlindeDecodeDiffEntry ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String factoryId = null;
        String configurationId = null;
        org.eclipse.scada.ca.data.Operation operation = null;
        java.util.Map<String, String> addedOrUpdatedData = null;
        java.util.Set<String> removedData = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    factoryId = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    configurationId = _context.decodeString ( _data );
                }
                    break;
                case 3:
                {
                    operation = _context.decodeEnum ( _data, org.eclipse.scada.ca.data.Operation.class );
                }
                    break;
                case 5:
                {
                    addedOrUpdatedData = _context.decodeProperties ( _data );
                }
                    break;
                case 6:
                {
                    removedData = _context.decodeStringSet ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.ca.data.DiffEntry ( factoryId, configurationId, operation, null, addedOrUpdatedData, removedData );
    }

    public static void encodeDiffEntry ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.ca.data.DiffEntry value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeDiffEntry ( context, data, value );
        }
    }

    public static void encodeCollectionDiffEntry ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.ca.data.DiffEntry> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.ca.data.DiffEntry entry : values )
        {
            inlineEncodeDiffEntry ( context, data, entry );
        }
    }

    public static org.eclipse.scada.ca.data.DiffEntry decodeDiffEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeDiffEntry ( context, data );
    }

    protected static void fillDiffEntryCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.ca.data.DiffEntry> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeDiffEntry ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.ca.data.DiffEntry>> T decodeDiffEntryCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.ca.data.DiffEntry, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillDiffEntryCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.ca.data.DiffEntry> decodeListDiffEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeDiffEntryCollection ( context, data, ALLOC_DIFFENTRY_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.ca.data.DiffEntry> decodeSetDiffEntry ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeDiffEntryCollection ( context, data, ALLOC_DIFFENTRY_SET, allowNull );
    }

}
