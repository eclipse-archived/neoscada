/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.scada.vi.details.model.DetailViewFactory;
import org.eclipse.scada.vi.details.model.HiddenComponent;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Hidden Component</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HiddenComponentTest extends TestCase
{

    /**
     * The fixture for this Hidden Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HiddenComponent fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( HiddenComponentTest.class );
    }

    /**
     * Constructs a new Hidden Component test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HiddenComponentTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Hidden Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( HiddenComponent fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Hidden Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HiddenComponent getFixture ()
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
        setFixture ( DetailViewFactory.eINSTANCE.createHiddenComponent () );
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

} //HiddenComponentTest
