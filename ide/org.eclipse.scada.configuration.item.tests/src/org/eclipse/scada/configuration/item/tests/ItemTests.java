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

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>item</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ItemTests extends TestSuite
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( suite () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static Test suite ()
    {
        TestSuite suite = new ItemTests ( "item Tests" ); //$NON-NLS-1$
        suite.addTestSuite ( CompositePipelineTest.class );
        suite.addTestSuite ( CallTest.class );
        suite.addTestSuite ( CallSuperTest.class );
        suite.addTestSuite ( JavaScriptCustomizationPipelineTest.class );
        suite.addTestSuite ( CustomScriptCustomizationPipelineTest.class );
        suite.addTestSuite ( JavaScriptSelectorTest.class );
        suite.addTestSuite ( CustomScriptSelectorTest.class );
        return suite;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemTests ( String name )
    {
        super ( name );
    }

} //ItemTests
