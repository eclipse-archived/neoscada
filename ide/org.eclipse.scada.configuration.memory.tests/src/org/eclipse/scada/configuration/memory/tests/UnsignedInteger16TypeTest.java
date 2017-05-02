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
import org.eclipse.scada.configuration.memory.UnsignedInteger16Type;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Unsigned Integer16 Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnsignedInteger16TypeTest extends OrderedTypeTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( UnsignedInteger16TypeTest.class );
    }

    /**
     * Constructs a new Unsigned Integer16 Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UnsignedInteger16TypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Unsigned Integer16 Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected UnsignedInteger16Type getFixture ()
    {
        return (UnsignedInteger16Type)fixture;
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
        setFixture ( MemoryFactory.eINSTANCE.createUnsignedInteger16Type () );
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

} //UnsignedInteger16TypeTest
