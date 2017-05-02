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

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.memory.MemoryFactory;
import org.eclipse.scada.configuration.memory.UnsignedInteger8Type;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Unsigned Integer8 Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnsignedInteger8TypeTest extends BaseScalarTypeTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( UnsignedInteger8TypeTest.class );
    }

    /**
     * Constructs a new Unsigned Integer8 Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UnsignedInteger8TypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Unsigned Integer8 Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected UnsignedInteger8Type getFixture ()
    {
        return (UnsignedInteger8Type)fixture;
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
        setFixture ( MemoryFactory.eINSTANCE.createUnsignedInteger8Type () );
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

} //UnsignedInteger8TypeTest
