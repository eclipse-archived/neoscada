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
package org.eclipse.scada.configuration.driver.jdbc.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.driver.jdbc.JdbcFactory;
import org.eclipse.scada.configuration.driver.jdbc.UpdateCommand;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Update Command</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UpdateCommandTest extends TestCase
{

    /**
     * The fixture for this Update Command test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UpdateCommand fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( UpdateCommandTest.class );
    }

    /**
     * Constructs a new Update Command test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UpdateCommandTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Update Command test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( UpdateCommand fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Update Command test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UpdateCommand getFixture ()
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
        setFixture ( JdbcFactory.eINSTANCE.createUpdateCommand () );
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

} //UpdateCommandTest
