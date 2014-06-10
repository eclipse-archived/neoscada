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

import junit.textui.TestRunner;

import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserFactory;
import org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Url Input</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class UrlInputTest extends AbstractPeriodInputTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( UrlInputTest.class );
    }

    /**
     * Constructs a new Url Input test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UrlInputTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Url Input test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected UrlInput getFixture ()
    {
        return (UrlInput)fixture;
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
        setFixture ( ParserFactory.eINSTANCE.createUrlInput () );
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

} //UrlInputTest
