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

import org.eclipse.neoscada.configuration.iec62541.IEC62541Device;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IEC62541DeviceTest extends TestCase
{

    /**
     * The fixture for this Device test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IEC62541Device fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( IEC62541DeviceTest.class );
    }

    /**
     * Constructs a new Device test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC62541DeviceTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Device test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( IEC62541Device fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Device test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IEC62541Device getFixture ()
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
        setFixture ( IEC62541Factory.eINSTANCE.createIEC62541Device () );
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

} //IEC62541DeviceTest
