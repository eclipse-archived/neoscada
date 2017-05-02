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
import org.eclipse.scada.configuration.component.exec.SystemInformationVMStat;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>System Information VM Stat</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemInformationVMStatTest extends ExecJobTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( SystemInformationVMStatTest.class );
    }

    /**
     * Constructs a new System Information VM Stat test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemInformationVMStatTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this System Information VM Stat test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected SystemInformationVMStat getFixture ()
    {
        return (SystemInformationVMStat)fixture;
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
        setFixture ( ExecComponentsFactory.eINSTANCE.createSystemInformationVMStat () );
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

} //SystemInformationVMStatTest
