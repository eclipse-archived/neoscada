/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.modbus.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.modbus.ModbusFactory;
import org.eclipse.scada.configuration.modbus.ModbusUInt32;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>UInt32</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusDataType#getName() <em>Name</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ModbusUInt32Test extends TestCase
{

    /**
     * The fixture for this UInt32 test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModbusUInt32 fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ModbusUInt32Test.class );
    }

    /**
     * Constructs a new UInt32 test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusUInt32Test ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this UInt32 test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( ModbusUInt32 fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this UInt32 test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModbusUInt32 getFixture ()
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
        setFixture ( ModbusFactory.eINSTANCE.createModbusUInt32 () );
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
     * Tests the '{@link org.eclipse.scada.configuration.modbus.ModbusDataType#getName() <em>Name</em>}' feature getter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.ModbusDataType#getName()
     * @generated
     */
    public void testGetName ()
    {
        // TODO: implement this feature getter test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

} //ModbusUInt32Test
