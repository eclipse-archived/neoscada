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
package org.eclipse.scada.configuration.item.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.item.CustomScriptCustomizationPipeline;
import org.eclipse.scada.configuration.item.ItemFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Custom Script Customization Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomScriptCustomizationPipelineTest extends ScriptCustomizationPipelineTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( CustomScriptCustomizationPipelineTest.class );
    }

    /**
     * Constructs a new Custom Script Customization Pipeline test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomScriptCustomizationPipelineTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Custom Script Customization Pipeline test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected CustomScriptCustomizationPipeline getFixture ()
    {
        return (CustomScriptCustomizationPipeline)fixture;
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
        setFixture ( ItemFactory.eINSTANCE.createCustomScriptCustomizationPipeline () );
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

} //CustomScriptCustomizationPipelineTest
