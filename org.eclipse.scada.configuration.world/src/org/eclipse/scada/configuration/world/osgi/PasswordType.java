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
 * A representation of the literals of the enumeration '<em><b>Password Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getPasswordType()
 * @model
 * @generated
 */
public enum PasswordType implements Enumerator
{
    /**
     * The '<em><b>PLAIN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PLAIN_VALUE
     * @generated
     * @ordered
     */
    PLAIN ( 0, "PLAIN", "PLAIN" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>PLAIN IGNORE CASE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PLAIN_IGNORE_CASE_VALUE
     * @generated
     * @ordered
     */
    PLAIN_IGNORE_CASE ( 1, "PLAIN_IGNORE_CASE", "PLAIN_IGNORE_CASE" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>MD5 HEX</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MD5_HEX_VALUE
     * @generated
     * @ordered
     */
    MD5_HEX ( 2, "MD5_HEX", "MD5_HEX" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>SHA1 HEX</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SHA1_HEX_VALUE
     * @generated
     * @ordered
     */
    SHA1_HEX ( 3, "SHA1_HEX", "SHA1_HEX" ); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>PLAIN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>PLAIN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #PLAIN
     * @model
     * @generated
     * @ordered
     */
    public static final int PLAIN_VALUE = 0;

    /**
     * The '<em><b>PLAIN IGNORE CASE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>PLAIN IGNORE CASE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #PLAIN_IGNORE_CASE
     * @model
     * @generated
     * @ordered
     */
    public static final int PLAIN_IGNORE_CASE_VALUE = 1;

    /**
     * The '<em><b>MD5 HEX</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MD5 HEX</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MD5_HEX
     * @model
     * @generated
     * @ordered
     */
    public static final int MD5_HEX_VALUE = 2;

    /**
     * The '<em><b>SHA1 HEX</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SHA1 HEX</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #SHA1_HEX
     * @model
     * @generated
     * @ordered
     */
    public static final int SHA1_HEX_VALUE = 3;

    /**
     * An array of all the '<em><b>Password Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final PasswordType[] VALUES_ARRAY = new PasswordType[] { PLAIN, PLAIN_IGNORE_CASE, MD5_HEX, SHA1_HEX, };

    /**
     * A public read-only list of all the '<em><b>Password Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<PasswordType> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>Password Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PasswordType get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            PasswordType result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Password Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PasswordType getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            PasswordType result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Password Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static PasswordType get ( int value )
    {
        switch ( value )
        {
            case PLAIN_VALUE:
                return PLAIN;
            case PLAIN_IGNORE_CASE_VALUE:
                return PLAIN_IGNORE_CASE;
            case MD5_HEX_VALUE:
                return MD5_HEX;
            case SHA1_HEX_VALUE:
                return SHA1_HEX;
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
    private PasswordType ( int value, String name, String literal )
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

} //PasswordType
