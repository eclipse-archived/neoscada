/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.exec.configuration.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.da.exec.configuration.ConfigurationFactory;
import org.eclipse.scada.da.exec.configuration.PlainStreamExtractorType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Plain Stream Extractor Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PlainStreamExtractorTypeTest extends ExtractorTypeTest
{

    //$NON-NLS-1$

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( PlainStreamExtractorTypeTest.class );
    }

    /**
     * Constructs a new Plain Stream Extractor Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PlainStreamExtractorTypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Plain Stream Extractor Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected PlainStreamExtractorType getFixture ()
    {
        return (PlainStreamExtractorType)fixture;
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
        setFixture ( ConfigurationFactory.eINSTANCE.createPlainStreamExtractorType () );
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

} //PlainStreamExtractorTypeTest
