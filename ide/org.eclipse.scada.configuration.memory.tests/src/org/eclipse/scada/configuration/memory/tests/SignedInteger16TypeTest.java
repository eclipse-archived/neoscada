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
package org.eclipse.scada.configuration.memory.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.memory.MemoryFactory;
import org.eclipse.scada.configuration.memory.SignedInteger16Type;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Signed Integer16 Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SignedInteger16TypeTest extends OrderedTypeTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( SignedInteger16TypeTest.class );
    }

    /**
     * Constructs a new Signed Integer16 Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignedInteger16TypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Signed Integer16 Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected SignedInteger16Type getFixture ()
    {
        return (SignedInteger16Type)fixture;
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
        setFixture ( MemoryFactory.eINSTANCE.createSignedInteger16Type () );
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

} //SignedInteger16TypeTest
