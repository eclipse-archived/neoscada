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
package org.eclipse.scada.configuration.world.osgi.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Data Access Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.DataAccessConnection#getTypeTag() <em>Get Type Tag</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.DataAccessConnection#makeUri(boolean) <em>Make Uri</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class DataAccessConnectionTest extends ConnectionTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( DataAccessConnectionTest.class );
    }

    /**
     * Constructs a new Data Access Connection test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataAccessConnectionTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Data Access Connection test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected DataAccessConnection getFixture ()
    {
        return (DataAccessConnection)fixture;
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
        setFixture ( OsgiFactory.eINSTANCE.createDataAccessConnection () );
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
     * Tests the '{@link org.eclipse.scada.configuration.world.osgi.DataAccessConnection#getTypeTag() <em>Get Type Tag</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.DataAccessConnection#getTypeTag()
     * @generated
     */
    public void testGetTypeTag ()
    {
        // TODO: implement this operation test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

    /**
     * Tests the '{@link org.eclipse.scada.configuration.world.osgi.DataAccessConnection#makeUri(boolean) <em>Make Uri</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.DataAccessConnection#makeUri(boolean)
     * @generated
     */
    public void testMakeUri__boolean ()
    {
        // TODO: implement this operation test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

} //DataAccessConnectionTest
