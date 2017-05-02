/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.infrastructure.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.JMXSettings;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>JMX Settings</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class JMXSettingsTest extends TestCase
{

    /**
     * The fixture for this JMX Settings test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JMXSettings fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( JMXSettingsTest.class );
    }

    /**
     * Constructs a new JMX Settings test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JMXSettingsTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this JMX Settings test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( JMXSettings fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this JMX Settings test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JMXSettings getFixture ()
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
        setFixture ( InfrastructureFactory.eINSTANCE.createJMXSettings () );
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

} //JMXSettingsTest
