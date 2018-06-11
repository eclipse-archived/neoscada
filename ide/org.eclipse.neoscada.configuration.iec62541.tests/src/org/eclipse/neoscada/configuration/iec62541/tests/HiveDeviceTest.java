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
package org.eclipse.neoscada.configuration.iec62541.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.neoscada.configuration.iec62541.HiveDevice;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Hive Device</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HiveDeviceTest extends TestCase
{

    /**
     * The fixture for this Hive Device test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HiveDevice fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( HiveDeviceTest.class );
    }

    /**
     * Constructs a new Hive Device test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HiveDeviceTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Hive Device test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( HiveDevice fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Hive Device test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HiveDevice getFixture ()
    {
        return fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp () throws Exception
    {
        setFixture ( IEC62541Factory.eINSTANCE.createHiveDevice () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown () throws Exception
    {
        setFixture ( null );
    }

} //HiveDeviceTest
