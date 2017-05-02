/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>configuration</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParserTests extends TestSuite
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
        TestSuite suite = new ParserTests ( "configuration Tests" ); //$NON-NLS-1$
        suite.addTestSuite ( FileInputTest.class );
        suite.addTestSuite ( PlainTextTest.class );
        suite.addTestSuite ( UrlInputTest.class );
        suite.addTestSuite ( SinglePatternTest.class );
        suite.addTestSuite ( SplitTableTest.class );
        suite.addTestSuite ( StringTransformerTest.class );
        suite.addTestSuite ( MqttInputTest.class );
        return suite;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ParserTests ( String name )
    {
        super ( name );
    }

} //ParserTests
