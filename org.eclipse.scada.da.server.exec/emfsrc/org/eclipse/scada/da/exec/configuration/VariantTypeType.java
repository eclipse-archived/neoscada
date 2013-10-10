/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.exec.configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variant Type Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getVariantTypeType()
 * @model extendedMetaData="name='variantType_._type'"
 * @generated
 */
public enum VariantTypeType implements Enumerator
{
    /**
     * The '<em><b>BOOLEAN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BOOLEAN_VALUE
     * @generated
     * @ordered
     */
    BOOLEAN ( 0, "BOOLEAN", "BOOLEAN" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>INTEGER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INTEGER_VALUE
     * @generated
     * @ordered
     */
    INTEGER ( 1, "INTEGER", "INTEGER" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>LONG</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #LONG_VALUE
     * @generated
     * @ordered
     */
    LONG ( 2, "LONG", "LONG" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>DOUBLE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DOUBLE_VALUE
     * @generated
     * @ordered
     */
    DOUBLE ( 3, "DOUBLE", "DOUBLE" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>STRING</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #STRING_VALUE
     * @generated
     * @ordered
     */
    STRING ( 4, "STRING", "STRING" ); //$NON-NLS-1$ //$NON-NLS-2$

    //$NON-NLS-1$

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
    public static final int BOOLEAN_VALUE = 0;

    /**
     * The '<em><b>INTEGER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>INTEGER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #INTEGER
     * @model
     * @generated
     * @ordered
     */
    public static final int INTEGER_VALUE = 1;

    /**
     * The '<em><b>LONG</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>LONG</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #LONG
     * @model
     * @generated
     * @ordered
     */
    public static final int LONG_VALUE = 2;

    /**
     * The '<em><b>DOUBLE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DOUBLE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DOUBLE
     * @model
     * @generated
     * @ordered
     */
    public static final int DOUBLE_VALUE = 3;

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
    public static final int STRING_VALUE = 4;

    /**
     * An array of all the '<em><b>Variant Type Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final VariantTypeType[] VALUES_ARRAY = new VariantTypeType[] { BOOLEAN, INTEGER, LONG, DOUBLE, STRING, };

    /**
     * A public read-only list of all the '<em><b>Variant Type Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<VariantTypeType> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>Variant Type Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static VariantTypeType get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            VariantTypeType result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Variant Type Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static VariantTypeType getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            VariantTypeType result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Variant Type Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static VariantTypeType get ( int value )
    {
        switch ( value )
        {
            case BOOLEAN_VALUE:
                return BOOLEAN;
            case INTEGER_VALUE:
                return INTEGER;
            case LONG_VALUE:
                return LONG;
            case DOUBLE_VALUE:
                return DOUBLE;
            case STRING_VALUE:
                return STRING;
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
    private VariantTypeType ( int value, String name, String literal )
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

} //VariantTypeType
