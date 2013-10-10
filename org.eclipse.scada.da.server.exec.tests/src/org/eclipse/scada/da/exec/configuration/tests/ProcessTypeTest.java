/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.exec.configuration.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.scada.da.exec.configuration.ConfigurationFactory;
import org.eclipse.scada.da.exec.configuration.ProcessType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Process Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessTypeTest extends TestCase
{

    //$NON-NLS-1$

    /**
     * The fixture for this Process Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProcessType fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ProcessTypeTest.class );
    }

    /**
     * Constructs a new Process Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessTypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Process Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( ProcessType fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Process Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProcessType getFixture ()
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
        setFixture ( ConfigurationFactory.eINSTANCE.createProcessType () );
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

} //ProcessTypeTest
