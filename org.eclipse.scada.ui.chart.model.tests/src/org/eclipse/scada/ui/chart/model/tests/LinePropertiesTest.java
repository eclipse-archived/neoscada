/**
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse contribution
 */
package org.eclipse.scada.ui.chart.model.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.LineProperties;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Line Properties</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinePropertiesTest extends TestCase
{

    /**
     * The fixture for this Line Properties test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LineProperties fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( LinePropertiesTest.class );
    }

    /**
     * Constructs a new Line Properties test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LinePropertiesTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Line Properties test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( LineProperties fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Line Properties test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LineProperties getFixture ()
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
        setFixture ( ChartFactory.eINSTANCE.createLineProperties () );
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

} //LinePropertiesTest
