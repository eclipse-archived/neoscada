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
import org.eclipse.scada.da.server.component.parser.factory.configuration.StringTransformer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>String Transformer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.TransformerDefinition#createTransformer(org.eclipse.scada.da.server.component.parser.factory.CreationContext) <em>Create Transformer</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class StringTransformerTest extends TestCase
{

    /**
     * The fixture for this String Transformer test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StringTransformer fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( StringTransformerTest.class );
    }

    /**
     * Constructs a new String Transformer test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StringTransformerTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this String Transformer test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( StringTransformer fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this String Transformer test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StringTransformer getFixture ()
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
        setFixture ( ParserFactory.eINSTANCE.createStringTransformer () );
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
     * Tests the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.TransformerDefinition#createTransformer(org.eclipse.scada.da.server.component.parser.factory.CreationContext) <em>Create Transformer</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.TransformerDefinition#createTransformer(org.eclipse.scada.da.server.component.parser.factory.CreationContext)
     * @generated
     */
    public void testCreateTransformer__CreationContext ()
    {
        // TODO: implement this operation test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

} //StringTransformerTest
