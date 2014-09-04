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
 * A representation of the literals of the enumeration '<em><b>Average Reference Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAverageReferenceType()
 * @model
 * @generated
 */
public enum AverageReferenceType implements Enumerator
{
    /**
     * The '<em><b>MIN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MIN_VALUE
     * @generated
     * @ordered
     */
    MIN ( 0, "MIN", "min" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>MAX</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MAX_VALUE
     * @generated
     * @ordered
     */
    MAX ( 1, "MAX", "max" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>MEAN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MEAN_VALUE
     * @generated
     * @ordered
     */
    MEAN ( 2, "MEAN", "mean" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>MEDIAN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MEDIAN_VALUE
     * @generated
     * @ordered
     */
    MEDIAN ( 3, "MEDIAN", "median" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>DEVIATION</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DEVIATION_VALUE
     * @generated
     * @ordered
     */
    DEVIATION ( 4, "DEVIATION", "deviation" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>SUM</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SUM_VALUE
     * @generated
     * @ordered
     */
    SUM ( 5, "SUM", "sum" ); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>MIN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MIN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MIN
     * @model literal="min"
     * @generated
     * @ordered
     */
    public static final int MIN_VALUE = 0;

    /**
     * The '<em><b>MAX</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MAX</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MAX
     * @model literal="max"
     * @generated
     * @ordered
     */
    public static final int MAX_VALUE = 1;

    /**
     * The '<em><b>MEAN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MEAN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MEAN
     * @model literal="mean"
     * @generated
     * @ordered
     */
    public static final int MEAN_VALUE = 2;

    /**
     * The '<em><b>MEDIAN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MEDIAN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MEDIAN
     * @model literal="median"
     * @generated
     * @ordered
     */
    public static final int MEDIAN_VALUE = 3;

    /**
     * The '<em><b>DEVIATION</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DEVIATION</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DEVIATION
     * @model literal="deviation"
     * @generated
     * @ordered
     */
    public static final int DEVIATION_VALUE = 4;

    /**
     * The '<em><b>SUM</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SUM</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SUM
     * @model literal="sum"
     * @generated
     * @ordered
     */
    public static final int SUM_VALUE = 5;

    /**
     * An array of all the '<em><b>Average Reference Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final AverageReferenceType[] VALUES_ARRAY = new AverageReferenceType[] { MIN, MAX, MEAN, MEDIAN, DEVIATION, SUM, };

    /**
     * A public read-only list of all the '<em><b>Average Reference Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<AverageReferenceType> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>Average Reference Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static AverageReferenceType get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            AverageReferenceType result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Average Reference Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static AverageReferenceType getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            AverageReferenceType result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Average Reference Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static AverageReferenceType get ( int value )
    {
        switch ( value )
        {
            case MIN_VALUE:
                return MIN;
            case MAX_VALUE:
                return MAX;
            case MEAN_VALUE:
                return MEAN;
            case MEDIAN_VALUE:
                return MEDIAN;
            case DEVIATION_VALUE:
                return DEVIATION;
            case SUM_VALUE:
                return SUM;
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
    private AverageReferenceType ( int value, String name, String literal )
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

} //AverageReferenceType
