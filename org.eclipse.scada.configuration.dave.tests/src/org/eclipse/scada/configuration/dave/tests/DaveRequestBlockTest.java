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
package org.eclipse.scada.configuration.dave.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.dave.DaveFactory;
import org.eclipse.scada.configuration.dave.DaveRequestBlock;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Request Block</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DaveRequestBlockTest extends TestCase
{

    /**
     * The fixture for this Request Block test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DaveRequestBlock fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( DaveRequestBlockTest.class );
    }

    /**
     * Constructs a new Request Block test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DaveRequestBlockTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Request Block test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( DaveRequestBlock fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Request Block test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DaveRequestBlock getFixture ()
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
        setFixture ( DaveFactory.eINSTANCE.createDaveRequestBlock () );
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

} //DaveRequestBlockTest
