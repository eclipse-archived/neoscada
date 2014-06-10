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
package org.eclipse.scada.configuration.world.deployment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Fallback Mapping Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getFallbackMappingMode()
 * @model
 * @generated
 */
public enum FallbackMappingMode implements Enumerator
{
    /**
     * The '<em><b>FAIL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FAIL_VALUE
     * @generated
     * @ordered
     */
    FAIL ( 0, "FAIL", "FAIL" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>IGNORE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #IGNORE_VALUE
     * @generated
     * @ordered
     */
    IGNORE ( 1, "IGNORE", "IGNORE" ); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>FAIL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FAIL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FAIL
     * @model
     * @generated
     * @ordered
     */
    public static final int FAIL_VALUE = 0;

    /**
     * The '<em><b>IGNORE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>IGNORE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #IGNORE
     * @model
     * @generated
     * @ordered
     */
    public static final int IGNORE_VALUE = 1;

    /**
     * An array of all the '<em><b>Fallback Mapping Mode</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final FallbackMappingMode[] VALUES_ARRAY =
            new FallbackMappingMode[]
            {
                    FAIL,
                    IGNORE,
            };

    /**
     * A public read-only list of all the '<em><b>Fallback Mapping Mode</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<FallbackMappingMode> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>Fallback Mapping Mode</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FallbackMappingMode get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            FallbackMappingMode result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Fallback Mapping Mode</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FallbackMappingMode getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            FallbackMappingMode result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Fallback Mapping Mode</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static FallbackMappingMode get ( int value )
    {
        switch ( value )
        {
            case FAIL_VALUE:
                return FAIL;
            case IGNORE_VALUE:
                return IGNORE;
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
    private FallbackMappingMode ( int value, String name, String literal )
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

} //FallbackMappingMode
