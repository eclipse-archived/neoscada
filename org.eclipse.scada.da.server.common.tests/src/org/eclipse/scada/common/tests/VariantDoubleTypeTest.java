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
import org.eclipse.scada.common.VariantDoubleType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Variant Double Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VariantDoubleTypeTest extends TestCase
{

   

    /**
     * The fixture for this Variant Double Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariantDoubleType fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( VariantDoubleTypeTest.class );
    }

    /**
     * Constructs a new Variant Double Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantDoubleTypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Variant Double Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( VariantDoubleType fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Variant Double Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariantDoubleType getFixture ()
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
        setFixture ( CommonFactory.eINSTANCE.createVariantDoubleType () );
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

} //VariantDoubleTypeTest
