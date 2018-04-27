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
package org.eclipse.neoscada.configuration.iec60870.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.neoscada.configuration.iec60870.IEC60870Factory;
import org.eclipse.neoscada.configuration.iec60870.ItemType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Item Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ItemTypeTest extends TestCase
{

    /**
     * The fixture for this Item Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemType fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ItemTypeTest.class );
    }

    /**
     * Constructs a new Item Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemTypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Item Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( ItemType fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Item Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemType getFixture ()
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
        setFixture ( IEC60870Factory.eINSTANCE.createItemType () );
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

} //ItemTypeTest
