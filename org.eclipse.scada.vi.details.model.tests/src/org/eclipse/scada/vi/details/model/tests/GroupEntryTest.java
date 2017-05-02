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
import org.eclipse.scada.vi.details.model.GroupEntry;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Group Entry</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GroupEntryTest extends TestCase
{

    /**
     * The fixture for this Group Entry test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GroupEntry fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( GroupEntryTest.class );
    }

    /**
     * Constructs a new Group Entry test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroupEntryTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Group Entry test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( GroupEntry fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Group Entry test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GroupEntry getFixture ()
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
        setFixture ( DetailViewFactory.eINSTANCE.createGroupEntry () );
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

} //GroupEntryTest
