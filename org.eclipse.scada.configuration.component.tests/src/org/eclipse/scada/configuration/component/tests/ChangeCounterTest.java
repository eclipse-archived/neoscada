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
package org.eclipse.scada.configuration.component.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.component.ChangeCounter;
import org.eclipse.scada.configuration.component.ComponentFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Change Counter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangeCounterTest extends SingleValueTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ChangeCounterTest.class );
    }

    /**
     * Constructs a new Change Counter test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChangeCounterTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Change Counter test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected ChangeCounter getFixture ()
    {
        return (ChangeCounter)fixture;
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
        setFixture ( ComponentFactory.eINSTANCE.createChangeCounter () );
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

} //ChangeCounterTest
