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
import org.eclipse.scada.da.exec.configuration.ReturnCodeExtractorType;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Return Code Extractor Type</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReturnCodeExtractorTypeTest extends ExtractorTypeTest
{

    //$NON-NLS-1$

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ReturnCodeExtractorTypeTest.class );
    }

    /**
     * Constructs a new Return Code Extractor Type test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReturnCodeExtractorTypeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Return Code Extractor Type test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected ReturnCodeExtractorType getFixture ()
    {
        return (ReturnCodeExtractorType)fixture;
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
        setFixture ( ConfigurationFactory.eINSTANCE.createReturnCodeExtractorType () );
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

} //ReturnCodeExtractorTypeTest
