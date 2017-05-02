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

import org.eclipse.scada.da.server.component.parser.factory.configuration.NumericGroupField;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Numeric Group Field</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NumericGroupFieldTest extends FieldTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( NumericGroupFieldTest.class );
    }

    /**
     * Constructs a new Numeric Group Field test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NumericGroupFieldTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Numeric Group Field test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected NumericGroupField getFixture ()
    {
        return (NumericGroupField)fixture;
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
        setFixture ( ParserFactory.eINSTANCE.createNumericGroupField () );
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

} //NumericGroupFieldTest
