/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.memory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Byte Order</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.memory.MemoryPackage#getByteOrder()
 * @model
 * @generated
 */
public enum ByteOrder implements Enumerator
{
    /**
     * The '<em><b>BIG ENDIAN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BIG_ENDIAN_VALUE
     * @generated
     * @ordered
     */
    BIG_ENDIAN ( 0, "BIG_ENDIAN", "BIG_ENDIAN" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>LITTLE ENDIAN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #LITTLE_ENDIAN_VALUE
     * @generated
     * @ordered
     */
    LITTLE_ENDIAN ( 1, "LITTLE_ENDIAN", "LITTLE_ENDIAN" ); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>BIG ENDIAN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BIG ENDIAN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #BIG_ENDIAN
     * @model
     * @generated
     * @ordered
     */
    public static final int BIG_ENDIAN_VALUE = 0;

    /**
     * The '<em><b>LITTLE ENDIAN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>LITTLE ENDIAN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #LITTLE_ENDIAN
     * @model
     * @generated
     * @ordered
     */
    public static final int LITTLE_ENDIAN_VALUE = 1;

    /**
     * An array of all the '<em><b>Byte Order</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final ByteOrder[] VALUES_ARRAY = new ByteOrder[] { BIG_ENDIAN, LITTLE_ENDIAN, };

    /**
     * A public read-only list of all the '<em><b>Byte Order</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<ByteOrder> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>Byte Order</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ByteOrder get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            ByteOrder result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Byte Order</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ByteOrder getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            ByteOrder result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Byte Order</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ByteOrder get ( int value )
    {
        switch ( value )
        {
            case BIG_ENDIAN_VALUE:
                return BIG_ENDIAN;
            case LITTLE_ENDIAN_VALUE:
                return LITTLE_ENDIAN;
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
    private ByteOrder ( int value, String name, String literal )
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

} //ByteOrder
