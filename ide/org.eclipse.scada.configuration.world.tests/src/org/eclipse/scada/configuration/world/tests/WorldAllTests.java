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
package org.eclipse.scada.configuration.world.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import org.eclipse.scada.configuration.world.deployment.tests.DeploymentTests;
import org.eclipse.scada.configuration.world.osgi.tests.OsgiTests;
import org.eclipse.scada.configuration.world.setup.tests.SetupTests;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Configuration</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorldAllTests extends TestSuite
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( suite () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Test suite ()
    {
        TestSuite suite = new WorldAllTests ( "World Tests" ); //$NON-NLS-1$
        suite.addTest ( WorldTests.suite () );
        suite.addTest ( OsgiTests.suite () );
        suite.addTest ( DeploymentTests.suite () );
        suite.addTest ( SetupTests.suite () );
        return suite;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WorldAllTests ( String name )
    {
        super ( name );
    }

} //ConfigurationAllTests
