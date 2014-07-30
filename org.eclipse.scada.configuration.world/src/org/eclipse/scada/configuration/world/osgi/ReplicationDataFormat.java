/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.osgi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Replication Data Format</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getReplicationDataFormat()
 * @model
 * @generated
 */
public enum ReplicationDataFormat implements Enumerator
{
    /**
     * The '<em><b>BLOB</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BLOB_VALUE
     * @generated
     * @ordered
     */
    BLOB ( 0, "BLOB", "BLOB" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>BYTES</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BYTES_VALUE
     * @generated
     * @ordered
     */
    BYTES ( 1, "BYTES", "BYTES" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>JSON</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #JSON_VALUE
     * @generated
     * @ordered
     */
    JSON ( 2, "JSON", "JSON" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>ARRAY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ARRAY_VALUE
     * @generated
     * @ordered
     */
    ARRAY ( 3, "ARRAY", "ARRAY" ); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>BLOB</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BLOB</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #BLOB
     * @model
     * @generated
     * @ordered
     */
    public static final int BLOB_VALUE = 0;

    /**
     * The '<em><b>BYTES</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BYTES</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #BYTES
     * @model
     * @generated
     * @ordered
     */
    public static final int BYTES_VALUE = 1;

    /**
     * The '<em><b>JSON</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>JSON</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #JSON
     * @model
     * @generated
     * @ordered
     */
    public static final int JSON_VALUE = 2;

    /**
     * The '<em><b>ARRAY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ARRAY</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ARRAY
     * @model
     * @generated
     * @ordered
     */
    public static final int ARRAY_VALUE = 3;

    /**
     * An array of all the '<em><b>Replication Data Format</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final ReplicationDataFormat[] VALUES_ARRAY =
            new ReplicationDataFormat[]
            {
                    BLOB,
                    BYTES,
                    JSON,
                    ARRAY,
            };

    /**
     * A public read-only list of all the '<em><b>Replication Data Format</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<ReplicationDataFormat> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>Replication Data Format</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ReplicationDataFormat get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            ReplicationDataFormat result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Replication Data Format</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ReplicationDataFormat getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            ReplicationDataFormat result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Replication Data Format</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ReplicationDataFormat get ( int value )
    {
        switch ( value )
        {
            case BLOB_VALUE:
                return BLOB;
            case BYTES_VALUE:
                return BYTES;
            case JSON_VALUE:
                return JSON;
            case ARRAY_VALUE:
                return ARRAY;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private ReplicationDataFormat ( int value, String name, String literal )
    {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue ()
    {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral ()
    {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        return literal;
    }

} //ReplicationDataFormat
