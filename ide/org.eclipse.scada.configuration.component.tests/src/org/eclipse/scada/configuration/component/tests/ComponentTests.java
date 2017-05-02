/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>component</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentTests extends TestSuite
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
        TestSuite suite = new ComponentTests ( "component Tests" ); //$NON-NLS-1$
        suite.addTestSuite ( ConstantValueTest.class );
        suite.addTestSuite ( PersistentValueTest.class );
        suite.addTestSuite ( DriverConnectionAnalyzerTest.class );
        suite.addTestSuite ( MasterImportConnectionAnalyzerTest.class );
        suite.addTestSuite ( DataMapperAnalyzerTest.class );
        suite.addTestSuite ( MappedSourceValueTest.class );
        suite.addTestSuite ( CalculationComponentTest.class );
        suite.addTestSuite ( OutputDefinitionTest.class );
        suite.addTestSuite ( ItemReferenceInputDefinitionTest.class );
        suite.addTestSuite ( ItemReferenceOutputDefinitionTest.class );
        suite.addTestSuite ( ComponentReferenceInputDefinitionTest.class );
        suite.addTestSuite ( FormulaModuleTest.class );
        suite.addTestSuite ( AverageModuleTest.class );
        suite.addTestSuite ( ScriptModuleTest.class );
        suite.addTestSuite ( ExternalValueTest.class );
        suite.addTestSuite ( GlobalizeComponentTest.class );
        suite.addTestSuite ( TransientValueTest.class );
        suite.addTestSuite ( MasterComponentTest.class );
        suite.addTestSuite ( BufferedValueTest.class );
        suite.addTestSuite ( ChangeCounterTest.class );
        suite.addTestSuite ( MovingAverageModuleTest.class );
        suite.addTestSuite ( DeltaValueTest.class );
        suite.addTestSuite ( ComponentReferenceOutputDefinitionTest.class );
        return suite;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentTests ( String name )
    {
        super ( name );
    }

} //ComponentTests
