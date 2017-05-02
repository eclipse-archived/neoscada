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
package org.eclipse.scada.configuration.component.exec.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.component.exec.ExecComponentsFactory;
import org.eclipse.scada.configuration.component.exec.LoadAverage;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Load Average</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoadAverageTest extends ExecJobTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( LoadAverageTest.class );
    }

    /**
     * Constructs a new Load Average test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadAverageTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Load Average test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected LoadAverage getFixture ()
    {
        return (LoadAverage)fixture;
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
        setFixture ( ExecComponentsFactory.eINSTANCE.createLoadAverage () );
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

} //LoadAverageTest
