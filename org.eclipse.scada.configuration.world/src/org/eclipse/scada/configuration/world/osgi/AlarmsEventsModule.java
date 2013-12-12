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
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alarms Events Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getMonitorPoolProxies <em>Monitor Pool Proxies</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getEventPoolProxies <em>Event Pool Proxies</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getAknProxies <em>Akn Proxies</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getPullEvents <em>Pull Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAlarmsEventsModule()
 * @model
 * @generated
 */
public interface AlarmsEventsModule extends ApplicationModule {
	/**
	 * Returns the value of the '<em><b>Monitor Pool Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Monitor Pool Proxies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitor Pool Proxies</em>' containment reference list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAlarmsEventsModule_MonitorPoolProxies()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<MonitorPoolProxy> getMonitorPoolProxies();

	/**
	 * Returns the value of the '<em><b>Event Pool Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.EventPoolProxy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Pool Proxies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Pool Proxies</em>' containment reference list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAlarmsEventsModule_EventPoolProxies()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<EventPoolProxy> getEventPoolProxies();

	/**
	 * Returns the value of the '<em><b>Akn Proxies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.AknProxy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Akn Proxies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Akn Proxies</em>' containment reference list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAlarmsEventsModule_AknProxies()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<AknProxy> getAknProxies();

	/**
	 * Returns the value of the '<em><b>Pull Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.PullEvents}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pull Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pull Events</em>' containment reference list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAlarmsEventsModule_PullEvents()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<PullEvents> getPullEvents();

} // AlarmsEventsModule
