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
package org.eclipse.scada.configuration.infrastructure.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.SystemNode;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>System Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getMasters() <em>Masters</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getValueArchives() <em>Value Archives</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SystemNodeTest extends NodeTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( SystemNodeTest.class );
    }

    /**
     * Constructs a new System Node test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemNodeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this System Node test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected SystemNode getFixture ()
    {
        return (SystemNode)fixture;
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
        setFixture ( InfrastructureFactory.eINSTANCE.createSystemNode () );
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

    /**
     * Tests the '{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getMasters() <em>Masters</em>}' feature getter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode#getMasters()
     * @generated
     */
    public void testGetMasters ()
    {
        // TODO: implement this feature getter test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

    /**
     * Tests the '{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getValueArchives() <em>Value Archives</em>}' feature getter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode#getValueArchives()
     * @generated
     */
    public void testGetValueArchives ()
    {
        // TODO: implement this feature getter test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

} //SystemNodeTest
