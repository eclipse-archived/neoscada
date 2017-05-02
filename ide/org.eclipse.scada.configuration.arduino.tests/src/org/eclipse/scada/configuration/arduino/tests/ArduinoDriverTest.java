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
package org.eclipse.scada.configuration.arduino.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.scada.configuration.arduino.ArduinoDriver;
import org.eclipse.scada.configuration.arduino.ArduinoFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Driver</b></em>'.
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
public class ArduinoDriverTest extends TestCase
{

    /**
     * The fixture for this Driver test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ArduinoDriver fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ArduinoDriverTest.class );
    }

    /**
     * Constructs a new Driver test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ArduinoDriverTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Driver test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( ArduinoDriver fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Driver test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ArduinoDriver getFixture ()
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
        setFixture ( ArduinoFactory.eINSTANCE.createArduinoDriver () );
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

} //ArduinoDriverTest
