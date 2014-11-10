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
package org.eclipse.scada.configuration.setup.common.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.scada.configuration.setup.common.CommonFactory;
import org.eclipse.scada.configuration.setup.common.PostgresSetupModule;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Postgres Setup Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.world.setup.SetupModule#validateOperatingSystem(org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor, org.eclipse.emf.validation.IValidationContext)
 * <em>Validate Operating System</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PostgresSetupModuleTest extends TestCase
{

    /**
     * The fixture for this Postgres Setup Module test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PostgresSetupModule fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main ( final String[] args )
    {
        TestRunner.run ( PostgresSetupModuleTest.class );
    }

    /**
     * Constructs a new Postgres Setup Module test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public PostgresSetupModuleTest ( final String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Postgres Setup Module test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void setFixture ( final PostgresSetupModule fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Postgres Setup Module test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PostgresSetupModule getFixture ()
    {
        return this.fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp () throws Exception
    {
        setFixture ( CommonFactory.eINSTANCE.createPostgresSetupModule () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown () throws Exception
    {
        setFixture ( null );
    }

    /**
     * Tests the '
     * {@link org.eclipse.scada.configuration.world.setup.SetupModule#validateOperatingSystem(org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor, org.eclipse.emf.validation.IValidationContext)
     * <em>Validate Operating System</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.configuration.world.setup.SetupModule#validateOperatingSystem(org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor,
     *      org.eclipse.emf.validation.IValidationContext)
     * @generated NOT
     */
    public void testValidateOperatingSystem__OperatingSystemDescriptor_IValidationContext ()
    {
    }

} //PostgresSetupModuleTest
