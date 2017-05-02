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
package org.eclipse.scada.core.protocol.ngp.codec;

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

    private static final ArrayListAllocator<org.eclipse.scada.core.data.ErrorInformation> ALLOC_ERRORINFORMATION_LIST = new ArrayListAllocator<org.eclipse.scada.core.data.ErrorInformation> ();

    private static final HashSetAllocator<org.eclipse.scada.core.data.ErrorInformation> ALLOC_ERRORINFORMATION_SET = new HashSetAllocator<org.eclipse.scada.core.data.ErrorInformation> ();

    protected static void inlineEncodeErrorInformation ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.core.data.ErrorInformation value ) throws Exception
    {
        // number of fields
        data.put ( (byte)3 );

        // encode attributes
        context.encodeLong ( data, (byte)1, value.getCode () );
        context.encodeString ( data, (byte)2, value.getMessage () );
        context.encodeString ( data, (byte)3, value.getDiagnosticInformation () );

    }

    protected static org.eclipse.scada.core.data.ErrorInformation inlindeDecodeErrorInformation ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        Long code = null;
        String message = null;
        String diagnosticInformation = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    code = _context.decodeLong ( _data );
                }
                    break;
                case 2:
                {
                    message = _context.decodeString ( _data );
                }
                    break;
                case 3:
                {
                    diagnosticInformation = _context.decodeString ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.core.data.ErrorInformation ( code, message, diagnosticInformation );
    }

    public static void encodeErrorInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.core.data.ErrorInformation value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeErrorInformation ( context, data, value );
        }
    }

    public static void encodeCollectionErrorInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.core.data.ErrorInformation> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.core.data.ErrorInformation entry : values )
        {
            inlineEncodeErrorInformation ( context, data, entry );
        }
    }

    public static org.eclipse.scada.core.data.ErrorInformation decodeErrorInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeErrorInformation ( context, data );
    }

    protected static void fillErrorInformationCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.core.data.ErrorInformation> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeErrorInformation ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.core.data.ErrorInformation>> T decodeErrorInformationCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.core.data.ErrorInformation, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillErrorInformationCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.core.data.ErrorInformation> decodeListErrorInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeErrorInformationCollection ( context, data, ALLOC_ERRORINFORMATION_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.core.data.ErrorInformation> decodeSetErrorInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeErrorInformationCollection ( context, data, ALLOC_ERRORINFORMATION_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.core.data.Request> ALLOC_REQUEST_LIST = new ArrayListAllocator<org.eclipse.scada.core.data.Request> ();

    private static final HashSetAllocator<org.eclipse.scada.core.data.Request> ALLOC_REQUEST_SET = new HashSetAllocator<org.eclipse.scada.core.data.Request> ();

    protected static void inlineEncodeRequest ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.core.data.Request value ) throws Exception
    {
        // number of fields
        data.put ( (byte)1 );

        // encode attributes
        context.encodePrimitiveLong ( data, (byte)1, value.getRequestId () );

    }

    protected static org.eclipse.scada.core.data.Request inlindeDecodeRequest ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        long requestId = 0L;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    requestId = _context.decodePrimitiveLong ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.core.data.Request ( requestId );
    }

    public static void encodeRequest ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.core.data.Request value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeRequest ( context, data, value );
        }
    }

    public static void encodeCollectionRequest ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.core.data.Request> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.core.data.Request entry : values )
        {
            inlineEncodeRequest ( context, data, entry );
        }
    }

    public static org.eclipse.scada.core.data.Request decodeRequest ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeRequest ( context, data );
    }

    protected static void fillRequestCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.core.data.Request> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeRequest ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.core.data.Request>> T decodeRequestCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.core.data.Request, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillRequestCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.core.data.Request> decodeListRequest ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeRequestCollection ( context, data, ALLOC_REQUEST_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.core.data.Request> decodeSetRequest ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeRequestCollection ( context, data, ALLOC_REQUEST_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.core.data.Response> ALLOC_RESPONSE_LIST = new ArrayListAllocator<org.eclipse.scada.core.data.Response> ();

    private static final HashSetAllocator<org.eclipse.scada.core.data.Response> ALLOC_RESPONSE_SET = new HashSetAllocator<org.eclipse.scada.core.data.Response> ();

    protected static void inlineEncodeResponse ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.core.data.Response value ) throws Exception
    {
        // number of fields
        data.put ( (byte)1 );

        // encode attributes
        org.eclipse.scada.core.protocol.ngp.codec.Structures.encodeRequest ( context, data, (byte)1, value.getRequest () );

    }

    protected static org.eclipse.scada.core.data.Response inlindeDecodeResponse ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        org.eclipse.scada.core.data.Request request = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    request = org.eclipse.scada.core.protocol.ngp.codec.Structures.decodeRequest ( _context, _data, false );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.core.data.Response ( request );
    }

    public static void encodeResponse ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.core.data.Response value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeResponse ( context, data, value );
        }
    }

    public static void encodeCollectionResponse ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.core.data.Response> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.core.data.Response entry : values )
        {
            inlineEncodeResponse ( context, data, entry );
        }
    }

    public static org.eclipse.scada.core.data.Response decodeResponse ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeResponse ( context, data );
    }

    protected static void fillResponseCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.core.data.Response> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeResponse ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.core.data.Response>> T decodeResponseCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.core.data.Response, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillResponseCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.core.data.Response> decodeListResponse ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeResponseCollection ( context, data, ALLOC_RESPONSE_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.core.data.Response> decodeSetResponse ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeResponseCollection ( context, data, ALLOC_RESPONSE_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.core.data.UserInformation> ALLOC_USERINFORMATION_LIST = new ArrayListAllocator<org.eclipse.scada.core.data.UserInformation> ();

    private static final HashSetAllocator<org.eclipse.scada.core.data.UserInformation> ALLOC_USERINFORMATION_SET = new HashSetAllocator<org.eclipse.scada.core.data.UserInformation> ();

    protected static void inlineEncodeUserInformation ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.core.data.UserInformation value ) throws Exception
    {
        // number of fields
        data.put ( (byte)1 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getName () );

    }

    protected static org.eclipse.scada.core.data.UserInformation inlindeDecodeUserInformation ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String name = null;

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
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.core.data.UserInformation ( name );
    }

    public static void encodeUserInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.core.data.UserInformation value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeUserInformation ( context, data, value );
        }
    }

    public static void encodeCollectionUserInformation ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.core.data.UserInformation> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.core.data.UserInformation entry : values )
        {
            inlineEncodeUserInformation ( context, data, entry );
        }
    }

    public static org.eclipse.scada.core.data.UserInformation decodeUserInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeUserInformation ( context, data );
    }

    protected static void fillUserInformationCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.core.data.UserInformation> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeUserInformation ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.core.data.UserInformation>> T decodeUserInformationCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.core.data.UserInformation, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillUserInformationCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.core.data.UserInformation> decodeListUserInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeUserInformationCollection ( context, data, ALLOC_USERINFORMATION_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.core.data.UserInformation> decodeSetUserInformation ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeUserInformationCollection ( context, data, ALLOC_USERINFORMATION_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.core.data.OperationParameters> ALLOC_OPERATIONPARAMETERS_LIST = new ArrayListAllocator<org.eclipse.scada.core.data.OperationParameters> ();

    private static final HashSetAllocator<org.eclipse.scada.core.data.OperationParameters> ALLOC_OPERATIONPARAMETERS_SET = new HashSetAllocator<org.eclipse.scada.core.data.OperationParameters> ();

    protected static void inlineEncodeOperationParameters ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.core.data.OperationParameters value ) throws Exception
    {
        // number of fields
        data.put ( (byte)2 );

        // encode attributes
        org.eclipse.scada.core.protocol.ngp.codec.Structures.encodeUserInformation ( context, data, (byte)1, value.getUserInformation () );
        context.encodeProperties ( data, (byte)2, value.getProperties () );

    }

    protected static org.eclipse.scada.core.data.OperationParameters inlindeDecodeOperationParameters ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        org.eclipse.scada.core.data.UserInformation userInformation = null;
        java.util.Map<String, String> properties = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    userInformation = org.eclipse.scada.core.protocol.ngp.codec.Structures.decodeUserInformation ( _context, _data, true );
                }
                    break;
                case 2:
                {
                    properties = _context.decodeProperties ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.core.data.OperationParameters ( userInformation, properties );
    }

    public static void encodeOperationParameters ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.core.data.OperationParameters value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeOperationParameters ( context, data, value );
        }
    }

    public static void encodeCollectionOperationParameters ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.core.data.OperationParameters> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.core.data.OperationParameters entry : values )
        {
            inlineEncodeOperationParameters ( context, data, entry );
        }
    }

    public static org.eclipse.scada.core.data.OperationParameters decodeOperationParameters ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeOperationParameters ( context, data );
    }

    protected static void fillOperationParametersCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.core.data.OperationParameters> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeOperationParameters ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.core.data.OperationParameters>> T decodeOperationParametersCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.core.data.OperationParameters, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillOperationParametersCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.core.data.OperationParameters> decodeListOperationParameters ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeOperationParametersCollection ( context, data, ALLOC_OPERATIONPARAMETERS_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.core.data.OperationParameters> decodeSetOperationParameters ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeOperationParametersCollection ( context, data, ALLOC_OPERATIONPARAMETERS_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.core.data.CallbackRequest> ALLOC_CALLBACKREQUEST_LIST = new ArrayListAllocator<org.eclipse.scada.core.data.CallbackRequest> ();

    private static final HashSetAllocator<org.eclipse.scada.core.data.CallbackRequest> ALLOC_CALLBACKREQUEST_SET = new HashSetAllocator<org.eclipse.scada.core.data.CallbackRequest> ();

    protected static void inlineEncodeCallbackRequest ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.core.data.CallbackRequest value ) throws Exception
    {
        // number of fields
        data.put ( (byte)2 );

        // encode attributes
        context.encodeString ( data, (byte)1, value.getType () );
        context.encodeProperties ( data, (byte)2, value.getAttributes () );

    }

    protected static org.eclipse.scada.core.data.CallbackRequest inlindeDecodeCallbackRequest ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        String type = null;
        java.util.Map<String, String> attributes = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    type = _context.decodeString ( _data );
                }
                    break;
                case 2:
                {
                    attributes = _context.decodeProperties ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.core.data.CallbackRequest ( type, attributes );
    }

    public static void encodeCallbackRequest ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.core.data.CallbackRequest value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeCallbackRequest ( context, data, value );
        }
    }

    public static void encodeCollectionCallbackRequest ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.core.data.CallbackRequest> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.core.data.CallbackRequest entry : values )
        {
            inlineEncodeCallbackRequest ( context, data, entry );
        }
    }

    public static org.eclipse.scada.core.data.CallbackRequest decodeCallbackRequest ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeCallbackRequest ( context, data );
    }

    protected static void fillCallbackRequestCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.core.data.CallbackRequest> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeCallbackRequest ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.core.data.CallbackRequest>> T decodeCallbackRequestCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.core.data.CallbackRequest, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillCallbackRequestCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.core.data.CallbackRequest> decodeListCallbackRequest ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeCallbackRequestCollection ( context, data, ALLOC_CALLBACKREQUEST_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.core.data.CallbackRequest> decodeSetCallbackRequest ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeCallbackRequestCollection ( context, data, ALLOC_CALLBACKREQUEST_SET, allowNull );
    }

    private static final ArrayListAllocator<org.eclipse.scada.core.data.CallbackResponse> ALLOC_CALLBACKRESPONSE_LIST = new ArrayListAllocator<org.eclipse.scada.core.data.CallbackResponse> ();

    private static final HashSetAllocator<org.eclipse.scada.core.data.CallbackResponse> ALLOC_CALLBACKRESPONSE_SET = new HashSetAllocator<org.eclipse.scada.core.data.CallbackResponse> ();

    protected static void inlineEncodeCallbackResponse ( final BinaryContext context, final IoBuffer data, final org.eclipse.scada.core.data.CallbackResponse value ) throws Exception
    {
        // number of fields
        data.put ( (byte)2 );

        // encode attributes
        context.encodePrimitiveBoolean ( data, (byte)1, value.isCanceled () );
        context.encodeProperties ( data, (byte)2, value.getAttributes () );

    }

    protected static org.eclipse.scada.core.data.CallbackResponse inlindeDecodeCallbackResponse ( final BinaryContext _context, final IoBuffer _data ) throws Exception
    {
        // number of fields
        final byte numberOfFields = _data.get ();

        // decode attributes

        boolean canceled = false;
        java.util.Map<String, String> attributes = null;

        logger.trace ( "Decoding {} fields", numberOfFields );

        for ( int i = 0; i < numberOfFields; i++ )
        {

            final byte fieldNumber = _data.get ();
            switch ( fieldNumber )
            {
                case 1:
                {
                    canceled = _context.decodePrimitiveBoolean ( _data );
                }
                    break;
                case 2:
                {
                    attributes = _context.decodeProperties ( _data );
                }
                    break;
                default:
                    logger.warn ( "Received unknown field number: {}", fieldNumber );
                    break;
            }

        }

        // create object
        return new org.eclipse.scada.core.data.CallbackResponse ( canceled, attributes );
    }

    public static void encodeCallbackResponse ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final org.eclipse.scada.core.data.CallbackResponse value ) throws Exception
    {
        context.beginWriteStructure ( data, fieldNumber, value == null );

        if ( value != null )
        {
            inlineEncodeCallbackResponse ( context, data, value );
        }
    }

    public static void encodeCollectionCallbackResponse ( final BinaryContext context, final IoBuffer data, final byte fieldNumber, final Collection<org.eclipse.scada.core.data.CallbackResponse> values ) throws Exception
    {
        context.beginWriteStructureList ( data, fieldNumber, values );

        if ( values == null )
        {
            return;
        }

        for ( final org.eclipse.scada.core.data.CallbackResponse entry : values )
        {
            inlineEncodeCallbackResponse ( context, data, entry );
        }
    }

    public static org.eclipse.scada.core.data.CallbackResponse decodeCallbackResponse ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        final boolean isNull = context.beginReadStructure ( data, allowNull );

        if ( isNull )
        {
            return null;
        }

        return inlindeDecodeCallbackResponse ( context, data );
    }

    protected static void fillCallbackResponseCollection ( final BinaryContext context, final IoBuffer data, final int items, final Collection<org.eclipse.scada.core.data.CallbackResponse> values ) throws Exception
    {
        for ( int i = 0; i < items; i++ )
        {
            values.add ( inlindeDecodeCallbackResponse ( context, data ) );
        }
    }

    protected static <T extends Collection<org.eclipse.scada.core.data.CallbackResponse>> T decodeCallbackResponseCollection ( final BinaryContext context, final IoBuffer data, final CollectionAllocator<org.eclipse.scada.core.data.CallbackResponse, T> allactor, final boolean allowNull ) throws Exception
    {
        final Integer len = context.beginReadStructureList ( data, allowNull );

        if ( len == null )
        {
            return null;
        }
        else
        {
            final T result = allactor.allocate ( len );
            fillCallbackResponseCollection ( context, data, len, result );
            return result;
        }
    }

    public static List<org.eclipse.scada.core.data.CallbackResponse> decodeListCallbackResponse ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeCallbackResponseCollection ( context, data, ALLOC_CALLBACKRESPONSE_LIST, allowNull );
    }

    public static Set<org.eclipse.scada.core.data.CallbackResponse> decodeSetCallbackResponse ( final BinaryContext context, final IoBuffer data, final boolean allowNull ) throws Exception
    {
        return decodeCallbackResponseCollection ( context, data, ALLOC_CALLBACKRESPONSE_SET, allowNull );
    }

}
