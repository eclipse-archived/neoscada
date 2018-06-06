/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Alignment</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getAlignment()
 * @model
 * @generated
 */
public enum Alignment implements Enumerator
{
    /**
     * The '<em><b>LEFT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #LEFT_VALUE
     * @generated
     * @ordered
     */
    LEFT ( 1, "LEFT", "LEFT" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>CENTER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CENTER_VALUE
     * @generated
     * @ordered
     */
    CENTER ( 0, "CENTER", "CENTER" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>RIGHT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #RIGHT_VALUE
     * @generated
     * @ordered
     */
    RIGHT ( 2, "RIGHT", "RIGHT" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>TOP</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TOP_VALUE
     * @generated
     * @ordered
     */
    TOP ( 3, "TOP", "TOP" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>BOTTOM</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BOTTOM_VALUE
     * @generated
     * @ordered
     */
    BOTTOM ( 4, "BOTTOM", "BOTTOM" ); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>LEFT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>LEFT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #LEFT
     * @model
     * @generated
     * @ordered
     */
    public static final int LEFT_VALUE = 1;

    /**
     * The '<em><b>CENTER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>CENTER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #CENTER
     * @model
     * @generated
     * @ordered
     */
    public static final int CENTER_VALUE = 0;

    /**
     * The '<em><b>RIGHT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>RIGHT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #RIGHT
     * @model
     * @generated
     * @ordered
     */
    public static final int RIGHT_VALUE = 2;

    /**
     * The '<em><b>TOP</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TOP</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TOP
     * @model
     * @generated
     * @ordered
     */
    public static final int TOP_VALUE = 3;

    /**
     * The '<em><b>BOTTOM</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BOTTOM</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #BOTTOM
     * @model
     * @generated
     * @ordered
     */
    public static final int BOTTOM_VALUE = 4;

    /**
     * An array of all the '<em><b>Alignment</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final Alignment[] VALUES_ARRAY = new Alignment[] { LEFT, CENTER, RIGHT, TOP, BOTTOM, };

    /**
     * A public read-only list of all the '<em><b>Alignment</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<Alignment> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>Alignment</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static Alignment get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            Alignment result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Alignment</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static Alignment getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            Alignment result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Alignment</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static Alignment get ( int value )
    {
        switch ( value )
        {
            case LEFT_VALUE:
                return LEFT;
            case CENTER_VALUE:
                return CENTER;
            case RIGHT_VALUE:
                return RIGHT;
            case TOP_VALUE:
                return TOP;
            case BOTTOM_VALUE:
                return BOTTOM;
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
    private Alignment ( int value, String name, String literal )
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

} //Alignment
