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
package org.eclipse.scada.configuration.component.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.SummariesConfiguration;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Summaries Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SummariesConfigurationTest extends ConfigurationTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( SummariesConfigurationTest.class );
    }

    /**
     * Constructs a new Summaries Configuration test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SummariesConfigurationTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Summaries Configuration test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected SummariesConfiguration getFixture ()
    {
        return (SummariesConfiguration)fixture;
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
        setFixture ( ComponentFactory.eINSTANCE.createSummariesConfiguration () );
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

} //SummariesConfigurationTest
