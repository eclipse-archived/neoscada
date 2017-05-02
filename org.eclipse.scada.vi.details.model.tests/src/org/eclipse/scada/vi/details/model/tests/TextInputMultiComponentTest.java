/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.vi.details.model.DetailViewFactory;
import org.eclipse.scada.vi.details.model.TextInputMultiComponent;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Text Input Multi Component</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextInputMultiComponentTest extends WriteableComponentTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( TextInputMultiComponentTest.class );
    }

    /**
     * Constructs a new Text Input Multi Component test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextInputMultiComponentTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Text Input Multi Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected TextInputMultiComponent getFixture ()
    {
        return (TextInputMultiComponent)fixture;
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
        setFixture ( DetailViewFactory.eINSTANCE.createTextInputMultiComponent () );
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

} //TextInputMultiComponentTest
