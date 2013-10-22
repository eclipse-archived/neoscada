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

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.scada.configuration.component.exec.ExecComponentsFactory;
import org.eclipse.scada.configuration.component.exec.ExecJob;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exec Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.ExecJob#hasExecDriver(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Exec Driver</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ExecJobTest extends TestCase
{

    /**
     * The fixture for this Exec Job test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExecJob fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ExecJobTest.class );
    }

    /**
     * Constructs a new Exec Job test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecJobTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Exec Job test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( ExecJob fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Exec Job test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExecJob getFixture ()
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
        setFixture ( ExecComponentsFactory.eINSTANCE.createExecJob () );
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
     * Tests the '{@link org.eclipse.scada.configuration.component.exec.ExecJob#hasExecDriver(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Exec Driver</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.exec.ExecJob#hasExecDriver(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     */
    public void testHasExecDriver__DiagnosticChain_Map ()
    {
        // TODO: implement this operation test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

} //ExecJobTest
