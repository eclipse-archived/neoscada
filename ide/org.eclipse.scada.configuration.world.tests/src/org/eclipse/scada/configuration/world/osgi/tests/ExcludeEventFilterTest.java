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
package org.eclipse.scada.configuration.world.osgi.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.world.osgi.ExcludeEventFilter;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exclude Event Filter</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExcludeEventFilterTest extends FilterEventHandlerTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ExcludeEventFilterTest.class );
    }

    /**
     * Constructs a new Exclude Event Filter test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExcludeEventFilterTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Exclude Event Filter test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected ExcludeEventFilter getFixture ()
    {
        return (ExcludeEventFilter)fixture;
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
        setFixture ( OsgiFactory.eINSTANCE.createExcludeEventFilter () );
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

} //ExcludeEventFilterTest
