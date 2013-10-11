/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.ui.connection.dnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.eclipse.scada.hd.ui.connection.data.Item;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for serializing gadgets to/from a byte array
 */
public class ItemTransfer extends ByteArrayTransfer
{
    private static ItemTransfer instance = new ItemTransfer ();

    private static final String TYPE_NAME = "eclipse-scada-hd-item-transfer-format"; //$NON-NLS-1$

    private static final int TYPE_ID = registerType ( TYPE_NAME );

    private final static Logger logger = LoggerFactory.getLogger ( ItemTransfer.class );

    static
    {
        logger.info ( "Registered type '{}' with id '{}'", TYPE_NAME, TYPE_ID );
    }

    /**
     * Returns the singleton gadget transfer instance.
     */
    public static ItemTransfer getInstance ()
    {
        return instance;
    }

    /**
     * Avoid explicit instantiation
     */
    private ItemTransfer ()
    {
    }

    protected Item[] fromByteArray ( final byte[] bytes )
    {
        final DataInputStream in = new DataInputStream ( new ByteArrayInputStream ( bytes ) );

        try
        {
            /* read number of gadgets */
            final int n = in.readInt ();
            /* read gadgets */
            final Item[] items = new Item[n];
            for ( int i = 0; i < n; i++ )
            {
                final Item item = readItem ( null, in );
                if ( item == null )
                {
                    return null;
                }
                items[i] = item;
            }
            return items;
        }
        catch ( final IOException e )
        {
            logger.warn ( "Failed to deseriablize", e );
            return null;
        }
    }

    /*
     * Method declared on Transfer.
     */
    @Override
    protected int[] getTypeIds ()
    {
        return new int[] { TYPE_ID };
    }

    /*
     * Method declared on Transfer.
     */
    @Override
    protected String[] getTypeNames ()
    {
        return new String[] { TYPE_NAME };
    }

    /*
     * Method declared on Transfer.
     */
    @Override
    protected void javaToNative ( final Object object, final TransferData transferData )
    {
        final byte[] bytes = toByteArray ( (Item[])object );
        if ( bytes != null )
        {
            super.javaToNative ( bytes, transferData );
        }
    }

    /*
     * Method declared on Transfer.
     */
    @Override
    protected Object nativeToJava ( final TransferData transferData )
    {
        final byte[] bytes = (byte[])super.nativeToJava ( transferData );
        return fromByteArray ( bytes );
    }

    /**
     * Reads and returns a single gadget from the given stream.
     */
    private Item readItem ( final Item parent, final DataInputStream dataIn ) throws IOException
    {
        final Item item = new Item ();
        item.setConnectionString ( dataIn.readUTF () );
        item.setId ( dataIn.readUTF () );

        return item;
    }

    protected byte[] toByteArray ( final Item[] items )
    {

        final ByteArrayOutputStream byteOut = new ByteArrayOutputStream ();
        final DataOutputStream out = new DataOutputStream ( byteOut );

        byte[] bytes = null;

        try
        {
            /* write number of markers */
            out.writeInt ( items.length );

            /* write markers */
            for ( int i = 0; i < items.length; i++ )
            {
                writeItem ( items[i], out );
            }
            out.close ();
            bytes = byteOut.toByteArray ();
        }
        catch ( final IOException e )
        {
            logger.warn ( "Failed to encode", e );
            //when in doubt send nothing
        }
        return bytes;
    }

    /**
     * Writes the given item to the stream.
     */
    private void writeItem ( final Item item, final DataOutputStream dataOut ) throws IOException
    {
        dataOut.writeUTF ( item.getConnectionString () );
        dataOut.writeUTF ( item.getId () );
    }
}