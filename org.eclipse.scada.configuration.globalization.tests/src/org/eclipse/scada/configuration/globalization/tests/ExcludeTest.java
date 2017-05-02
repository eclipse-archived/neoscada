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

import org.eclipse.scada.configuration.globalization.Exclude;
import org.eclipse.scada.configuration.globalization.GlobalizeFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exclude</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExcludeTest extends PatternFilterTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ExcludeTest.class );
    }

    /**
     * Constructs a new Exclude test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExcludeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Exclude test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Exclude getFixture ()
    {
        return (Exclude)fixture;
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
        setFixture ( GlobalizeFactory.eINSTANCE.createExclude () );
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

} //ExcludeTest
