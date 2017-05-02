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
 * A representation of the literals of the enumeration '<em><b>Moving Average Reference Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMovingAverageReferenceType()
 * @model
 * @generated
 */
public enum MovingAverageReferenceType implements Enumerator
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
     * The '<em><b>MEDIAN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MEDIAN_VALUE
     * @generated
     * @ordered
     */
    MEDIAN ( 2, "MEDIAN", "median" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>ARITHMETIC</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ARITHMETIC_VALUE
     * @generated
     * @ordered
     */
    ARITHMETIC ( 3, "ARITHMETIC", "arithmetic" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>WEIGHTED</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #WEIGHTED_VALUE
     * @generated
     * @ordered
     */
    WEIGHTED ( 4, "WEIGHTED", "weighted" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>DEVIATION ARITHMETIC</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DEVIATION_ARITHMETIC_VALUE
     * @generated
     * @ordered
     */
    DEVIATION_ARITHMETIC ( 5, "DEVIATION_ARITHMETIC", "deviationArithmetic" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>DEVIATION WEIGHTED</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DEVIATION_WEIGHTED_VALUE
     * @generated
     * @ordered
     */
    DEVIATION_WEIGHTED ( 6, "DEVIATION_WEIGHTED", "deviationWeighted" ); //$NON-NLS-1$ //$NON-NLS-2$

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
    public static final int MEDIAN_VALUE = 2;

    /**
     * The '<em><b>ARITHMETIC</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ARITHMETIC</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ARITHMETIC
     * @model literal="arithmetic"
     * @generated
     * @ordered
     */
    public static final int ARITHMETIC_VALUE = 3;

    /**
     * The '<em><b>WEIGHTED</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>WEIGHTED</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #WEIGHTED
     * @model literal="weighted"
     * @generated
     * @ordered
     */
    public static final int WEIGHTED_VALUE = 4;

    /**
     * The '<em><b>DEVIATION ARITHMETIC</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DEVIATION ARITHMETIC</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DEVIATION_ARITHMETIC
     * @model literal="deviationArithmetic"
     * @generated
     * @ordered
     */
    public static final int DEVIATION_ARITHMETIC_VALUE = 5;

    /**
     * The '<em><b>DEVIATION WEIGHTED</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DEVIATION WEIGHTED</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DEVIATION_WEIGHTED
     * @model literal="deviationWeighted"
     * @generated
     * @ordered
     */
    public static final int DEVIATION_WEIGHTED_VALUE = 6;

    /**
     * An array of all the '<em><b>Moving Average Reference Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final MovingAverageReferenceType[] VALUES_ARRAY = new MovingAverageReferenceType[] { MIN, MAX, MEDIAN, ARITHMETIC, WEIGHTED, DEVIATION_ARITHMETIC, DEVIATION_WEIGHTED, };

    /**
     * A public read-only list of all the '<em><b>Moving Average Reference Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<MovingAverageReferenceType> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>Moving Average Reference Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static MovingAverageReferenceType get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            MovingAverageReferenceType result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Moving Average Reference Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static MovingAverageReferenceType getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            MovingAverageReferenceType result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Moving Average Reference Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static MovingAverageReferenceType get ( int value )
    {
        switch ( value )
        {
            case MIN_VALUE:
                return MIN;
            case MAX_VALUE:
                return MAX;
            case MEDIAN_VALUE:
                return MEDIAN;
            case ARITHMETIC_VALUE:
                return ARITHMETIC;
            case WEIGHTED_VALUE:
                return WEIGHTED;
            case DEVIATION_ARITHMETIC_VALUE:
                return DEVIATION_ARITHMETIC;
            case DEVIATION_WEIGHTED_VALUE:
                return DEVIATION_WEIGHTED;
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
    private MovingAverageReferenceType ( int value, String name, String literal )
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

} //MovingAverageReferenceType
