/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.infrastructure.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.infrastructure.ConfigurationAdminFileBackend;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Configuration Admin File Backend</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationAdminFileBackendTest extends TestCase
{

    /**
     * The fixture for this Configuration Admin File Backend test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConfigurationAdminFileBackend fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ConfigurationAdminFileBackendTest.class );
    }

    /**
     * Constructs a new Configuration Admin File Backend test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationAdminFileBackendTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Configuration Admin File Backend test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( ConfigurationAdminFileBackend fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Configuration Admin File Backend test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConfigurationAdminFileBackend getFixture ()
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
        setFixture ( InfrastructureFactory.eINSTANCE.createConfigurationAdminFileBackend () );
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

} //ConfigurationAdminFileBackendTest
