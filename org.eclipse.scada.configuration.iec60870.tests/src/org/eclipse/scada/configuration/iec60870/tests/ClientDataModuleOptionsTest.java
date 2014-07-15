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
package org.eclipse.scada.configuration.iec60870.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.iec60870.ClientDataModuleOptions;
import org.eclipse.scada.configuration.iec60870.IEC60870Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Client Data Module Options</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClientDataModuleOptionsTest extends TestCase
{

    /**
     * The fixture for this Client Data Module Options test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ClientDataModuleOptions fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ClientDataModuleOptionsTest.class );
    }

    /**
     * Constructs a new Client Data Module Options test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ClientDataModuleOptionsTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Client Data Module Options test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( ClientDataModuleOptions fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Client Data Module Options test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ClientDataModuleOptions getFixture ()
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
        setFixture ( IEC60870Factory.eINSTANCE.createClientDataModuleOptions () );
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

} //ClientDataModuleOptionsTest
