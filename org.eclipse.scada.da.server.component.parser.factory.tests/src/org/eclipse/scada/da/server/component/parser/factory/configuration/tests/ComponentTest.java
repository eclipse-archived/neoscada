/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.scada.da.server.component.parser.factory.configuration.Component;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentTest extends TestCase
{

    /**
     * The fixture for this Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Component fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ComponentTest.class );
    }

    /**
     * Constructs a new Component test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( Component fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Component getFixture ()
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
        setFixture ( ParserFactory.eINSTANCE.createComponent () );
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

} //ComponentTest
