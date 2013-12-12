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

import org.eclipse.scada.configuration.world.osgi.EventStoragePostgres;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Event Storage Postgres</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getJdbcDriverName() <em>Get Jdbc Driver Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getDriverBundles() <em>Get Driver Bundles</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class EventStoragePostgresTest extends AbstractEventStorageJdbcTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EventStoragePostgresTest.class);
	}

	/**
	 * Constructs a new Event Storage Postgres test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventStoragePostgresTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Event Storage Postgres test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EventStoragePostgres getFixture() {
		return (EventStoragePostgres) fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OsgiFactory.eINSTANCE.createEventStoragePostgres());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getJdbcDriverName() <em>Get Jdbc Driver Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getJdbcDriverName()
	 * @generated
	 */
	public void testGetJdbcDriverName() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getDriverBundles() <em>Get Driver Bundles</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getDriverBundles()
	 * @generated
	 */
	public void testGetDriverBundles() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //EventStoragePostgresTest
