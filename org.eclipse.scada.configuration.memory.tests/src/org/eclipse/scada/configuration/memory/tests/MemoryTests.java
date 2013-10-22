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
package org.eclipse.scada.configuration.memory.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>memory</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class MemoryTests extends TestSuite
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
        TestSuite suite = new MemoryTests ( "memory Tests" ); //$NON-NLS-1$
        suite.addTestSuite ( BitTypeTest.class );
        suite.addTestSuite ( Float32TypeTest.class );
        suite.addTestSuite ( UserDefinedTypeTest.class );
        suite.addTestSuite ( UnsignedInteger16TypeTest.class );
        suite.addTestSuite ( UnsignedInteger32TypeTest.class );
        suite.addTestSuite ( UnsignedInteger8TypeTest.class );
        return suite;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MemoryTests ( String name )
    {
        super ( name );
    }

} //MemoryTests
