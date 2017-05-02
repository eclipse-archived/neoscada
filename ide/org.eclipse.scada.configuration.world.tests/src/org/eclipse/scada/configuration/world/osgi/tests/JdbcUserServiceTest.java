/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.scada.configuration.world.osgi.JdbcUserService;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Jdbc User Service</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class JdbcUserServiceTest extends TestCase
{

    /**
     * The fixture for this Jdbc User Service test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JdbcUserService fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( JdbcUserServiceTest.class );
    }

    /**
     * Constructs a new Jdbc User Service test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JdbcUserServiceTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Jdbc User Service test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( JdbcUserService fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Jdbc User Service test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JdbcUserService getFixture ()
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
        setFixture ( OsgiFactory.eINSTANCE.createJdbcUserService () );
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

} //JdbcUserServiceTest
