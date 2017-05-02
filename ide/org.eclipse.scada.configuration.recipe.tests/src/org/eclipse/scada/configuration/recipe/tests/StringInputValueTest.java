/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.recipe.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.recipe.RecipeFactory;
import org.eclipse.scada.configuration.recipe.StringInputValue;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>String Input Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StringInputValueTest extends InputValueTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( StringInputValueTest.class );
    }

    /**
     * Constructs a new String Input Value test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StringInputValueTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this String Input Value test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected StringInputValue getFixture ()
    {
        return (StringInputValue)fixture;
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
        setFixture ( RecipeFactory.eINSTANCE.createStringInputValue () );
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

} //StringInputValueTest
