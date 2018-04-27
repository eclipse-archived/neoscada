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
package org.eclipse.neoscada.configuration.iec60870;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>IEC Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getIECType()
 * @model
 * @generated
 */
public enum IECType implements Enumerator
{
    /**
     * The '<em><b>CSC NA 1</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CSC_NA_1_VALUE
     * @generated
     * @ordered
     */
    CSC_NA_1 ( 45, "C_SC_NA_1", "C_SC_NA_1" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>CSC TA 1</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CSC_TA_1_VALUE
     * @generated
     * @ordered
     */
    CSC_TA_1 ( 58, "C_SC_TA_1", "C_SC_TA_1" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>CSE NA 1</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CSE_NA_1_VALUE
     * @generated
     * @ordered
     */
    CSE_NA_1 ( 48, "C_SE_NA_1", "C_SE_NA_1" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>CSE TA 1</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CSE_TA_1_VALUE
     * @generated
     * @ordered
     */
    CSE_TA_1 ( 61, "C_SE_TA_1", "C_SE_TA_1" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>CSE NB 1</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CSE_NB_1_VALUE
     * @generated
     * @ordered
     */
    CSE_NB_1 ( 49, "C_SE_NB_1", "C_SE_NB_1" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>CSE TB 1</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CSE_TB_1_VALUE
     * @generated
     * @ordered
     */
    CSE_TB_1 ( 62, "C_SE_TB_1", "C_SE_TB_1" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>CSE NC 1</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CSE_NC_1_VALUE
     * @generated
     * @ordered
     */
    CSE_NC_1 ( 50, "C_SE_NC_1", "C_SE_NC_1" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>CSE TC 1</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CSE_TC_1_VALUE
     * @generated
     * @ordered
     */
    CSE_TC_1 ( 63, "C_SE_TC_1", "C_SE_TC_1" ); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>CSC NA 1</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CSC NA 1</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CSC_NA_1
     * @model name="C_SC_NA_1"
     * @generated
     * @ordered
     */
    public static final int CSC_NA_1_VALUE = 45;

    /**
     * The '<em><b>CSC TA 1</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CSC TA 1</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CSC_TA_1
     * @model name="C_SC_TA_1"
     * @generated
     * @ordered
     */
    public static final int CSC_TA_1_VALUE = 58;

    /**
     * The '<em><b>CSE NA 1</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CSE NA 1</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CSE_NA_1
     * @model name="C_SE_NA_1"
     * @generated
     * @ordered
     */
    public static final int CSE_NA_1_VALUE = 48;

    /**
     * The '<em><b>CSE TA 1</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CSE TA 1</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CSE_TA_1
     * @model name="C_SE_TA_1"
     * @generated
     * @ordered
     */
    public static final int CSE_TA_1_VALUE = 61;

    /**
     * The '<em><b>CSE NB 1</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CSE NB 1</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CSE_NB_1
     * @model name="C_SE_NB_1"
     * @generated
     * @ordered
     */
    public static final int CSE_NB_1_VALUE = 49;

    /**
     * The '<em><b>CSE TB 1</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CSE TB 1</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CSE_TB_1
     * @model name="C_SE_TB_1"
     * @generated
     * @ordered
     */
    public static final int CSE_TB_1_VALUE = 62;

    /**
     * The '<em><b>CSE NC 1</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CSE NC 1</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CSE_NC_1
     * @model name="C_SE_NC_1"
     * @generated
     * @ordered
     */
    public static final int CSE_NC_1_VALUE = 50;

    /**
     * The '<em><b>CSE TC 1</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CSE TC 1</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CSE_TC_1
     * @model name="C_SE_TC_1"
     * @generated
     * @ordered
     */
    public static final int CSE_TC_1_VALUE = 63;

    /**
     * An array of all the '<em><b>IEC Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final IECType[] VALUES_ARRAY = new IECType[] { CSC_NA_1, CSC_TA_1, CSE_NA_1, CSE_TA_1, CSE_NB_1, CSE_TB_1, CSE_NC_1, CSE_TC_1, };

    /**
     * A public read-only list of all the '<em><b>IEC Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<IECType> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>IEC Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static IECType get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            IECType result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>IEC Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static IECType getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            IECType result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>IEC Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static IECType get ( int value )
    {
        switch ( value )
        {
            case CSC_NA_1_VALUE:
                return CSC_NA_1;
            case CSC_TA_1_VALUE:
                return CSC_TA_1;
            case CSE_NA_1_VALUE:
                return CSE_NA_1;
            case CSE_TA_1_VALUE:
                return CSE_TA_1;
            case CSE_NB_1_VALUE:
                return CSE_NB_1;
            case CSE_TB_1_VALUE:
                return CSE_TB_1;
            case CSE_NC_1_VALUE:
                return CSE_NC_1;
            case CSE_TC_1_VALUE:
                return CSE_TC_1;
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
    private IECType ( int value, String name, String literal )
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

} //IECType
