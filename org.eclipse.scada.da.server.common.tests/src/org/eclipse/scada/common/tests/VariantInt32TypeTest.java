/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.common.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.scada.common.CommonFactory;
import org.eclipse.scada.common.VariantInt32Type;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Variant Int32 Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VariantInt32TypeTest extends TestCase
{

   

    /**
     * The fixture for this Variant Int32 Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariantInt32Type fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( VariantInt32TypeTest.class );
    }

    /**
     * Constructs a new Variant Int32 Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantInt32TypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Variant Int32 Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( VariantInt32Type fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Variant Int32 Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariantInt32Type getFixture ()
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
        setFixture ( CommonFactory.eINSTANCE.createVariantInt32Type () );
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

} //VariantInt32TypeTest
