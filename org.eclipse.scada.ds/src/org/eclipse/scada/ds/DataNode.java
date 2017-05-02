/*******************************************************************************
 * Copyright (c) 2011, 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - some bugs fixed
 *******************************************************************************/
package org.eclipse.scada.ds;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.eclipse.scada.ds.internal.ClassLoaderObjectInputStream;
import org.eclipse.scada.utils.lang.Immutable;
import org.eclipse.scada.utils.osgi.BundleObjectInputStream;
import org.osgi.framework.Bundle;

import com.google.common.io.ByteStreams;

/**
 * A data node used for storing data in a {@link DataStore}.
 * <p>
 * Data nodes are equal by <code>id</code>.
 * </p>
 * 
 * @author Jens Reimann
 * @since 0.15.0
 */
@Immutable
public class DataNode
{
    private final String id;

    private final byte[] data;

    /**
     * Create a new data node and fill with byte buffer
     * <p>
     * The byte buffer is copied by the constructor
     * </p>
     * 
     * @param id
     *            The node id
     * @param data
     *            the data
     */
    public DataNode ( final String id, final byte[] data )
    {
        this.id = id;
        if ( data != null )
        {
            this.data = data.clone ();
        }
        else
        {
            this.data = null;
        }
    }

    /**
     * Create a new data node and fill with the input stream
     * <p>
     * The input stream is read into the data buffer of the node
     * </p>
     * <p>
     * The stream is not closed by the constructor.
     * </p>
     * 
     * @param id
     *            the node id
     * @param stream
     *            the stream to read from
     * @throws IOException
     *             if stream reading fails
     */
    public DataNode ( final String id, final InputStream stream ) throws IOException
    {
        this.id = id;

        if ( stream == null )
        {
            this.data = null;
        }
        else
        {
            this.data = ByteStreams.toByteArray ( stream );
        }
    }

    /**
     * Create a new data node and fill it with the serialized representation of
     * the data object provided.
     * 
     * @param id
     *            the node id
     * @param data
     *            the data to serialize
     */
    public DataNode ( final String id, final Serializable data )
    {
        this.id = id;

        if ( data == null )
        {
            this.data = null;
        }
        else
        {
            final ByteArrayOutputStream bos = new ByteArrayOutputStream ();
            try
            {
                final ObjectOutputStream os = new ObjectOutputStream ( bos );
                os.writeObject ( data );
                os.close ();
                this.data = bos.toByteArray ();
            }
            catch ( final IOException e )
            {
                throw new RuntimeException ( "Failed to store data node", e );
            }
        }
    }

    public String getId ()
    {
        return this.id;
    }

    /**
     * Get a copy of the data
     * 
     * @return the binary node data
     */
    public byte[] getData ()
    {
        return this.data.clone ();
    }

    public Object getDataAsObject () throws IOException, ClassNotFoundException
    {
        return getDataAsObject ( Thread.currentThread ().getContextClassLoader () );
    }

    protected Object getDataAsObject ( final ObjectInputStream stream ) throws IOException, ClassNotFoundException
    {
        try
        {
            if ( stream == null )
            {
                return null;
            }
            return stream.readObject ();
        }
        finally
        {
            if ( stream != null )
            {
                stream.close ();
            }
        }
    }

    public Object getDataAsObject ( final ClassLoader classLoader ) throws IOException, ClassNotFoundException
    {
        if ( this.data == null )
        {
            return null;
        }
        else
        {
            final ByteArrayInputStream bin = new ByteArrayInputStream ( this.data );
            final ObjectInputStream ois = new ClassLoaderObjectInputStream ( bin, classLoader );

            return getDataAsObject ( ois );
        }
    }

    public Object getDataAsObject ( final Bundle bundle ) throws IOException, ClassNotFoundException
    {
        if ( this.data == null )
        {
            return null;
        }
        else
        {
            final ByteArrayInputStream bin = new ByteArrayInputStream ( this.data );
            final ObjectInputStream ois = new BundleObjectInputStream ( bin, bundle );

            return getDataAsObject ( ois );
        }
    }

    public Object getDataAsObject ( final Object defaultValue )
    {
        try
        {
            final Object result = getDataAsObject ();
            if ( result == null )
            {
                return defaultValue;
            }
            else
            {
                return result;
            }
        }
        catch ( final Exception e )
        {
            return defaultValue;
        }
    }

    public Object getDataAsObject ( final Bundle bundle, final Object defaultValue )
    {
        try
        {
            final Object result = getDataAsObject ( bundle );
            if ( result == null )
            {
                return defaultValue;
            }
            else
            {
                return result;
            }
        }
        catch ( final Exception e )
        {
            return defaultValue;
        }
    }

    public Object getDataAsObject ( final ClassLoader classLoader, final Object defaultValue )
    {
        try
        {
            final Object result = getDataAsObject ( classLoader );
            if ( result == null )
            {
                return defaultValue;
            }
            else
            {
                return result;
            }
        }
        catch ( final Exception e )
        {
            return defaultValue;
        }
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.id == null ? 0 : this.id.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( ! ( obj instanceof DataNode ) )
        {
            return false;
        }
        final DataNode other = (DataNode)obj;
        if ( this.id == null )
        {
            if ( other.id != null )
            {
                return false;
            }
        }
        else if ( !this.id.equals ( other.id ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[DataNode - id: %s, data-len: %s]", this.id, this.data != null ? this.data.length : "null" );
    }

}
