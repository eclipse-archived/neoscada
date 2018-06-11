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

import org.eclipse.neoscada.configuration.iec62541.DriverApplication;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Driver Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getProfile() <em>Get Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.Driver#getEndpoints() <em>Get Endpoints</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class DriverApplicationTest extends TestCase
{

    /**
     * The fixture for this Driver Application test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DriverApplication fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( DriverApplicationTest.class );
    }

    /**
     * Constructs a new Driver Application test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DriverApplicationTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Driver Application test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( DriverApplication fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Driver Application test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DriverApplication getFixture ()
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
        setFixture ( IEC62541Factory.eINSTANCE.createDriverApplication () );
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

    /**
     * Tests the '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getProfile() <em>Get Profile</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getProfile()
     * @generated
     */
    public void testGetProfile ()
    {
        // TODO: implement this operation test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

    /**
     * Tests the '{@link org.eclipse.scada.configuration.world.Driver#getEndpoints() <em>Get Endpoints</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.Driver#getEndpoints()
     * @generated
     */
    public void testGetEndpoints ()
    {
        // TODO: implement this operation test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

} //DriverApplicationTest
