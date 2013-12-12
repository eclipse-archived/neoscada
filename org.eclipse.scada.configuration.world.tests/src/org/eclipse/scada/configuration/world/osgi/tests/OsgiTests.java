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

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>osgi</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class OsgiTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new OsgiTests("osgi Tests"); //$NON-NLS-1$
		suite.addTestSuite(DataAccessConnectionTest.class);
		suite.addTestSuite(DataAccessExporterTest.class);
		suite.addTestSuite(DefaultMasterServerTest.class);
		suite.addTestSuite(CustomMasterServerTest.class);
		suite.addTestSuite(AlarmsEventsExporterTest.class);
		suite.addTestSuite(AlarmsEventsConnectionTest.class);
		suite.addTestSuite(DefaultValueArchiveServerTest.class);
		suite.addTestSuite(HistoricalDataExporterTest.class);
		suite.addTestSuite(ConfigurationAdministratorExporterTest.class);
		suite.addTestSuite(EventStorageJdbcTest.class);
		suite.addTestSuite(EventStoragePostgresTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OsgiTests(String name) {
		super(name);
	}

} //OsgiTests
