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
package org.eclipse.neoscada.configuration.iec60870.tests;

import org.eclipse.neoscada.configuration.iec60870.IEC60870Factory;
import org.eclipse.neoscada.configuration.iec60870.ProtocolOptions;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Protocol Options</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProtocolOptionsTest extends TestCase
{

    /**
     * The fixture for this Protocol Options test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProtocolOptions fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ProtocolOptionsTest.class );
    }

    /**
     * Constructs a new Protocol Options test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProtocolOptionsTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Protocol Options test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( ProtocolOptions fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Protocol Options test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProtocolOptions getFixture ()
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
        setFixture ( IEC60870Factory.eINSTANCE.createProtocolOptions () );
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

} //ProtocolOptionsTest
