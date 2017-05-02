/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.globalization.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.globalization.GlobalizeFactory;
import org.eclipse.scada.configuration.globalization.Include;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Include</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IncludeTest extends PatternFilterTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( IncludeTest.class );
    }

    /**
     * Constructs a new Include test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IncludeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Include test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Include getFixture ()
    {
        return (Include)fixture;
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
        setFixture ( GlobalizeFactory.eINSTANCE.createInclude () );
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

} //IncludeTest
