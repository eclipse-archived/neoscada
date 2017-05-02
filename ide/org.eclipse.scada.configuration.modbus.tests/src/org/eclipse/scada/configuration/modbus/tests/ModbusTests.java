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
package org.eclipse.scada.configuration.modbus.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>modbus</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModbusTests extends TestSuite
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( suite () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Test suite ()
    {
        TestSuite suite = new ModbusTests ( "modbus Tests" ); //$NON-NLS-1$
        suite.addTestSuite ( ModbusDriverTest.class );
        suite.addTestSuite ( ModbusDoubleTest.class );
        suite.addTestSuite ( ModbusSInt16Test.class );
        suite.addTestSuite ( ModbusSInt32Test.class );
        suite.addTestSuite ( ModbusUInt16Test.class );
        suite.addTestSuite ( ModbusUInt32Test.class );
        return suite;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusTests ( String name )
    {
        super ( name );
    }

} //ModbusTests
