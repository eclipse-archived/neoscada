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

import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserFactory;
import org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Plain Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition#createExtractor(org.eclipse.scada.da.server.component.parser.factory.CreationContext) <em>Create Extractor</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PlainTextTest extends TestCase
{

    /**
     * The fixture for this Plain Text test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PlainText fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( PlainTextTest.class );
    }

    /**
     * Constructs a new Plain Text test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PlainTextTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Plain Text test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( PlainText fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Plain Text test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PlainText getFixture ()
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
        setFixture ( ParserFactory.eINSTANCE.createPlainText () );
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
     * Tests the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition#createExtractor(org.eclipse.scada.da.server.component.parser.factory.CreationContext) <em>Create Extractor</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition#createExtractor(org.eclipse.scada.da.server.component.parser.factory.CreationContext)
     * @generated
     */
    public void testCreateExtractor__CreationContext ()
    {
        // TODO: implement this operation test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

} //PlainTextTest
