/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.vi.model.BorderChild;
import org.eclipse.scada.vi.model.VisualInterfaceFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Border Child</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BorderChildTest extends ChildTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( BorderChildTest.class );
    }

    /**
     * Constructs a new Border Child test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BorderChildTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Border Child test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected BorderChild getFixture ()
    {
        return (BorderChild)fixture;
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
        setFixture ( VisualInterfaceFactory.eINSTANCE.createBorderChild () );
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

} //BorderChildTest
