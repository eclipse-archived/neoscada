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
import org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '
 * <em><b>Serial To Network Setup Module</b></em>'.
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
public class SerialToNetworkSetupModuleTest extends TestCase
{

    /**
     * The fixture for this Serial To Network Setup Module test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SerialToNetworkSetupModule fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main ( final String[] args )
    {
        TestRunner.run ( SerialToNetworkSetupModuleTest.class );
    }

    /**
     * Constructs a new Serial To Network Setup Module test case with the given
     * name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public SerialToNetworkSetupModuleTest ( final String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Serial To Network Setup Module test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void setFixture ( final SerialToNetworkSetupModule fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Serial To Network Setup Module test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SerialToNetworkSetupModule getFixture ()
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
        setFixture ( CommonFactory.eINSTANCE.createSerialToNetworkSetupModule () );
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

} //SerialToNetworkSetupModuleTest
