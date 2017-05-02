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
package org.eclipse.scada.configuration.world.deployment.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.world.deployment.DeploymentFactory;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Redhat Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RedhatDeploymentMechanismTest extends CommonDeploymentMechanismTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( RedhatDeploymentMechanismTest.class );
    }

    /**
     * Constructs a new Redhat Deployment Mechanism test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RedhatDeploymentMechanismTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Redhat Deployment Mechanism test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected RedhatDeploymentMechanism getFixture ()
    {
        return (RedhatDeploymentMechanism)fixture;
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
        setFixture ( DeploymentFactory.eINSTANCE.createRedhatDeploymentMechanism () );
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

} //RedhatDeploymentMechanismTest
