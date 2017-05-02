/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.memory.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.memory.FixedLengthStringType;
import org.eclipse.scada.configuration.memory.MemoryFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Fixed Length String Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FixedLengthStringTypeTest extends BaseScalarTypeTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( FixedLengthStringTypeTest.class );
    }

    /**
     * Constructs a new Fixed Length String Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FixedLengthStringTypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Fixed Length String Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected FixedLengthStringType getFixture ()
    {
        return (FixedLengthStringType)fixture;
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
        setFixture ( MemoryFactory.eINSTANCE.createFixedLengthStringType () );
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

} //FixedLengthStringTypeTest
