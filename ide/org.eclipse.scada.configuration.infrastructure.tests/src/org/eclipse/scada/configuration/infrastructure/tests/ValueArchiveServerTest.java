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
import org.eclipse.scada.configuration.infrastructure.ValueArchiveServer;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Value Archive Server</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ValueArchiveServerTest extends EquinoxApplicationTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ValueArchiveServerTest.class );
    }

    /**
     * Constructs a new Value Archive Server test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueArchiveServerTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Value Archive Server test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected ValueArchiveServer getFixture ()
    {
        return (ValueArchiveServer)fixture;
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
        setFixture ( InfrastructureFactory.eINSTANCE.createValueArchiveServer () );
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

} //ValueArchiveServerTest
