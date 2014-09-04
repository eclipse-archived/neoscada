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
 * A representation of the literals of the enumeration '<em><b>Startup Mechanism</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getStartupMechanism()
 * @model
 * @generated
 */
public enum StartupMechanism implements Enumerator
{
    /**
     * The '<em><b>DEFAULT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DEFAULT_VALUE
     * @generated
     * @ordered
     */
    DEFAULT ( 0, "DEFAULT", "DEFAULT" ),
    /**
     * The '<em><b>UPSTART</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UPSTART_VALUE
     * @generated
     * @ordered
     */
    UPSTART ( 1, "UPSTART", "UPSTART" ), //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>REDHAT SYSV</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REDHAT_SYSV_VALUE
     * @generated
     * @ordered
     */
    REDHAT_SYSV ( 2, "REDHAT_SYSV", "REDHAT_SYSV" ),
    /**
     * The '<em><b>LSB SYSV</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #LSB_SYSV_VALUE
     * @generated
     * @ordered
     */
    LSB_SYSV ( 3, "LSB_SYSV", "LSB_SYSV" ); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The '<em><b>DEFAULT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DEFAULT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DEFAULT
     * @model
     * @generated
     * @ordered
     */
    public static final int DEFAULT_VALUE = 0;

    /**
     * The '<em><b>UPSTART</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>UPSTART</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #UPSTART
     * @model
     * @generated
     * @ordered
     */
    public static final int UPSTART_VALUE = 1;

    /**
     * The '<em><b>REDHAT SYSV</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>REDHAT SYSV</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #REDHAT_SYSV
     * @model
     * @generated
     * @ordered
     */
    public static final int REDHAT_SYSV_VALUE = 2;

    /**
     * The '<em><b>LSB SYSV</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>LSB SYSV</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #LSB_SYSV
     * @model
     * @generated
     * @ordered
     */
    public static final int LSB_SYSV_VALUE = 3;

    /**
     * An array of all the '<em><b>Startup Mechanism</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final StartupMechanism[] VALUES_ARRAY = new StartupMechanism[] { DEFAULT, UPSTART, REDHAT_SYSV, LSB_SYSV, };

    /**
     * A public read-only list of all the '<em><b>Startup Mechanism</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<StartupMechanism> VALUES = Collections.unmodifiableList ( Arrays.asList ( VALUES_ARRAY ) );

    /**
     * Returns the '<em><b>Startup Mechanism</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static StartupMechanism get ( String literal )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            StartupMechanism result = VALUES_ARRAY[i];
            if ( result.toString ().equals ( literal ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Startup Mechanism</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static StartupMechanism getByName ( String name )
    {
        for ( int i = 0; i < VALUES_ARRAY.length; ++i )
        {
            StartupMechanism result = VALUES_ARRAY[i];
            if ( result.getName ().equals ( name ) )
            {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Startup Mechanism</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static StartupMechanism get ( int value )
    {
        switch ( value )
        {
            case DEFAULT_VALUE:
                return DEFAULT;
            case UPSTART_VALUE:
                return UPSTART;
            case REDHAT_SYSV_VALUE:
                return REDHAT_SYSV;
            case LSB_SYSV_VALUE:
                return LSB_SYSV;
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
    private StartupMechanism ( int value, String name, String literal )
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

} //StartupMechanism
