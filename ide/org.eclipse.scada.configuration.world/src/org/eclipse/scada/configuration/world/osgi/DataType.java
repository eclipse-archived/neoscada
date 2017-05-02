/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Data Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getDataType()
 * @model
 * @generated
 */
public enum DataType implements Enumerator
{
    /**
     * The '<em><b>VARIANT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VARIANT_VALUE
     * @generated
     * @ordered
     */
    VARIANT ( 0, "VARIANT", "VARIANT" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>NULL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NULL_VALUE
     * @generated
     * @ordered
     */
    NULL ( 1, "NULL", "NULL" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>INT32</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INT32_VALUE
     * @generated
     * @ordered
     */
    INT32 ( 2, "INT32", "INT32" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>INT64</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INT64_VALUE
     * @generated
     * @ordered
     */
    INT64 ( 3, "INT64", "INT64" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>FLOAT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FLOAT_VALUE
     * @generated
     * @ordered
     */
    FLOAT ( 4, "FLOAT", "FLOAT" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>STRING</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #STRING_VALUE
     * @generated
     * @ordered
     */
    STRING ( 5, "STRING", "STRING" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>BOOLEAN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BOOLEAN_VALUE
     * @generated
     * @ordered
     */
    BOOLEAN ( 6, "BOOLEAN", "BOOLEAN" ); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>VARIANT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>VARIANT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #VARIANT
     * @model
     * @generated
     * @ordered
     */
    public static final int VARIANT_VALUE = 0;

    /**
     * The '<em><b>NULL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #NULL
     * @model
     * @generated
     * @ordered
     */
    public static final int NULL_VALUE = 1;

    /**
     * The '<em><b>INT32</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>INT32</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #INT32
     * @model
     * @generated
     * @ordered
     */
    public static final int INT32_VALUE = 2;

    /**
     * The '<em><b>INT64</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>INT64</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #INT64
     * @model
     * @generated
     * @ordered
     */
    public static final int INT64_VALUE = 3;

    /**
     * The '<em><b>FLOAT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FLOAT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FLOAT
     * @model
     * @generated
     * @ordered
     */
    public static final int FLOAT_VALUE = 4;

    /**
     * The '<em><b>STRING</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>STRING</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #STRING
     * @model
     * @generated
     * @ordered
     */
    public static final int STRING_VALUE = 5;

    /**
     * The '<em><b>BOOLEAN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BOOLEAN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #BOOLEAN
     * @model
     * @generated
     * @ordered
     */
    public static final int BOOLEAN_VALUE = 6;

    /**
     * An array of all the '<em><b>Data Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final DataType[] VALUES_ARRAY = new DataType[] { VARIANT, NULL, INT32, INT64, FLOAT, STRING, BOOLEAN, };

    /**
     * A public read-only list of all the '<em><b>Data Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<DataType> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>Data Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DataType get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            DataType result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Data Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DataType getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            DataType result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Data Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DataType get ( int value )
    {
        switch ( value )
        {
            case VARIANT_VALUE:
                return VARIANT;
            case NULL_VALUE:
                return NULL;
            case INT32_VALUE:
                return INT32;
            case INT64_VALUE:
                return INT64;
            case FLOAT_VALUE:
                return FLOAT;
            case STRING_VALUE:
                return STRING;
            case BOOLEAN_VALUE:
                return BOOLEAN;
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
    private DataType ( int value, String name, String literal )
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

} //DataType
