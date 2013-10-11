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
package org.eclipse.scada.da.ui.connection.dnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.eclipse.scada.da.ui.connection.data.Item;
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

    private static final String TYPE_NAME = "eclipse-scada-da-item-transfer-format-v2"; //$NON-NLS-1$

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
        try
        {
            final ObjectInputStream in = new ObjectInputStream ( new ByteArrayInputStream ( bytes ) );
            return (Item[])in.readObject ();
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to decode", e );
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

    protected byte[] toByteArray ( final Item[] items )
    {

        final ByteArrayOutputStream byteOut = new ByteArrayOutputStream ();

        byte[] bytes = null;

        try
        {
            final ObjectOutputStream out = new ObjectOutputStream ( byteOut );
            out.writeObject ( items );
            out.close ();
            bytes = byteOut.toByteArray ();
        }
        catch ( final IOException e )
        {
            //when in doubt send nothing
        }
        return bytes;
    }

}