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
package org.eclipse.scada.configuration.world.setup.tests;

import org.eclipse.scada.configuration.world.setup.SetupFactory;
import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Module Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.SetupModuleContainer#validateOperatingSystem(org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor, org.eclipse.scada.utils.ecore.validation.ValidationContext) <em>Validate Operating System</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SetupModuleContainerTest extends TestCase
{

    /**
     * The fixture for this Module Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SetupModuleContainer fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( SetupModuleContainerTest.class );
    }

    /**
     * Constructs a new Module Container test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SetupModuleContainerTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Module Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( SetupModuleContainer fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Module Container test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SetupModuleContainer getFixture ()
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
        setFixture ( SetupFactory.eINSTANCE.createSetupModuleContainer () );
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

    /**
     * Tests the '{@link org.eclipse.scada.configuration.world.setup.SetupModuleContainer#validateOperatingSystem(org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor, org.eclipse.scada.utils.ecore.validation.ValidationContext) <em>Validate Operating System</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.setup.SetupModuleContainer#validateOperatingSystem(org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor, org.eclipse.scada.utils.ecore.validation.ValidationContext)
     * @generated
     */
    public void testValidateOperatingSystem__OperatingSystemDescriptor_ValidationContext ()
    {
        // TODO: implement this operation test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

} //SetupModuleContainerTest
