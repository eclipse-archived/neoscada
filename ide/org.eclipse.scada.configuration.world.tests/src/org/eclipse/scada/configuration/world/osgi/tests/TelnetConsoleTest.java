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
package org.eclipse.scada.configuration.world.osgi.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.TelnetConsole;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Telnet Console</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TelnetConsoleTest extends TestCase
{

    /**
     * The fixture for this Telnet Console test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TelnetConsole fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( TelnetConsoleTest.class );
    }

    /**
     * Constructs a new Telnet Console test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TelnetConsoleTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Telnet Console test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( TelnetConsole fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Telnet Console test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TelnetConsole getFixture ()
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
        setFixture ( OsgiFactory.eINSTANCE.createTelnetConsole () );
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

} //TelnetConsoleTest
