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
import org.eclipse.scada.da.exec.configuration.EnvEntryType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Env Entry Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EnvEntryTypeTest extends TestCase
{

    //$NON-NLS-1$

    /**
     * The fixture for this Env Entry Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EnvEntryType fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( EnvEntryTypeTest.class );
    }

    /**
     * Constructs a new Env Entry Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EnvEntryTypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Env Entry Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( EnvEntryType fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Env Entry Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EnvEntryType getFixture ()
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
        setFixture ( ConfigurationFactory.eINSTANCE.createEnvEntryType () );
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

} //EnvEntryTypeTest
