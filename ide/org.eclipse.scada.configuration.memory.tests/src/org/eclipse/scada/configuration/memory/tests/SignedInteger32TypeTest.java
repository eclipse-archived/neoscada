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
import org.eclipse.scada.configuration.memory.SignedInteger32Type;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Signed Integer32 Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SignedInteger32TypeTest extends OrderedTypeTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( SignedInteger32TypeTest.class );
    }

    /**
     * Constructs a new Signed Integer32 Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignedInteger32TypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Signed Integer32 Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected SignedInteger32Type getFixture ()
    {
        return (SignedInteger32Type)fixture;
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
        setFixture ( MemoryFactory.eINSTANCE.createSignedInteger32Type () );
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

} //SignedInteger32TypeTest
