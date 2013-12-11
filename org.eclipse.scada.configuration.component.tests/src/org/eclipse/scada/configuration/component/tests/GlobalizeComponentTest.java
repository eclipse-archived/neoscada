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
package org.eclipse.scada.configuration.component.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.GlobalizeComponent;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Globalize Component</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GlobalizeComponentTest extends DataComponentTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( GlobalizeComponentTest.class );
    }

    /**
     * Constructs a new Globalize Component test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GlobalizeComponentTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Globalize Component test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected GlobalizeComponent getFixture ()
    {
        return (GlobalizeComponent)fixture;
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
        setFixture ( ComponentFactory.eINSTANCE.createGlobalizeComponent () );
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

} //GlobalizeComponentTest
