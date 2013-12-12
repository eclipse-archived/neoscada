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
package org.eclipse.scada.configuration.world.osgi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.osgi.AknProxy;
import org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule;
import org.eclipse.scada.configuration.world.osgi.EventPoolProxy;
import org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.PullEvents;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alarms Events Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsModuleImpl#getMonitorPoolProxies <em>Monitor Pool Proxies</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsModuleImpl#getEventPoolProxies <em>Event Pool Proxies</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsModuleImpl#getAknProxies <em>Akn Proxies</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsModuleImpl#getPullEvents <em>Pull Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlarmsEventsModuleImpl extends MinimalEObjectImpl.Container
		implements AlarmsEventsModule {
	/**
	 * The cached value of the '{@link #getMonitorPoolProxies() <em>Monitor Pool Proxies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitorPoolProxies()
	 * @generated
	 * @ordered
	 */
	protected EList<MonitorPoolProxy> monitorPoolProxies;

	/**
	 * The cached value of the '{@link #getEventPoolProxies() <em>Event Pool Proxies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventPoolProxies()
	 * @generated
	 * @ordered
	 */
	protected EList<EventPoolProxy> eventPoolProxies;

	/**
	 * The cached value of the '{@link #getAknProxies() <em>Akn Proxies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAknProxies()
	 * @generated
	 * @ordered
	 */
	protected EList<AknProxy> aknProxies;

	/**
	 * The cached value of the '{@link #getPullEvents() <em>Pull Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPullEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<PullEvents> pullEvents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlarmsEventsModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.ALARMS_EVENTS_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MonitorPoolProxy> getMonitorPoolProxies() {
		if (monitorPoolProxies == null) {
			monitorPoolProxies = new EObjectContainmentEList.Resolving<MonitorPoolProxy>(
					MonitorPoolProxy.class, this,
					OsgiPackage.ALARMS_EVENTS_MODULE__MONITOR_POOL_PROXIES);
		}
		return monitorPoolProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventPoolProxy> getEventPoolProxies() {
		if (eventPoolProxies == null) {
			eventPoolProxies = new EObjectContainmentEList.Resolving<EventPoolProxy>(
					EventPoolProxy.class, this,
					OsgiPackage.ALARMS_EVENTS_MODULE__EVENT_POOL_PROXIES);
		}
		return eventPoolProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AknProxy> getAknProxies() {
		if (aknProxies == null) {
			aknProxies = new EObjectContainmentEList.Resolving<AknProxy>(
					AknProxy.class, this,
					OsgiPackage.ALARMS_EVENTS_MODULE__AKN_PROXIES);
		}
		return aknProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PullEvents> getPullEvents() {
		if (pullEvents == null) {
			pullEvents = new EObjectContainmentEList.Resolving<PullEvents>(
					PullEvents.class, this,
					OsgiPackage.ALARMS_EVENTS_MODULE__PULL_EVENTS);
		}
		return pullEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OsgiPackage.ALARMS_EVENTS_MODULE__MONITOR_POOL_PROXIES:
			return ((InternalEList<?>) getMonitorPoolProxies()).basicRemove(
					otherEnd, msgs);
		case OsgiPackage.ALARMS_EVENTS_MODULE__EVENT_POOL_PROXIES:
			return ((InternalEList<?>) getEventPoolProxies()).basicRemove(
					otherEnd, msgs);
		case OsgiPackage.ALARMS_EVENTS_MODULE__AKN_PROXIES:
			return ((InternalEList<?>) getAknProxies()).basicRemove(otherEnd,
					msgs);
		case OsgiPackage.ALARMS_EVENTS_MODULE__PULL_EVENTS:
			return ((InternalEList<?>) getPullEvents()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OsgiPackage.ALARMS_EVENTS_MODULE__MONITOR_POOL_PROXIES:
			return getMonitorPoolProxies();
		case OsgiPackage.ALARMS_EVENTS_MODULE__EVENT_POOL_PROXIES:
			return getEventPoolProxies();
		case OsgiPackage.ALARMS_EVENTS_MODULE__AKN_PROXIES:
			return getAknProxies();
		case OsgiPackage.ALARMS_EVENTS_MODULE__PULL_EVENTS:
			return getPullEvents();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OsgiPackage.ALARMS_EVENTS_MODULE__MONITOR_POOL_PROXIES:
			getMonitorPoolProxies().clear();
			getMonitorPoolProxies().addAll(
					(Collection<? extends MonitorPoolProxy>) newValue);
			return;
		case OsgiPackage.ALARMS_EVENTS_MODULE__EVENT_POOL_PROXIES:
			getEventPoolProxies().clear();
			getEventPoolProxies().addAll(
					(Collection<? extends EventPoolProxy>) newValue);
			return;
		case OsgiPackage.ALARMS_EVENTS_MODULE__AKN_PROXIES:
			getAknProxies().clear();
			getAknProxies().addAll((Collection<? extends AknProxy>) newValue);
			return;
		case OsgiPackage.ALARMS_EVENTS_MODULE__PULL_EVENTS:
			getPullEvents().clear();
			getPullEvents().addAll((Collection<? extends PullEvents>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case OsgiPackage.ALARMS_EVENTS_MODULE__MONITOR_POOL_PROXIES:
			getMonitorPoolProxies().clear();
			return;
		case OsgiPackage.ALARMS_EVENTS_MODULE__EVENT_POOL_PROXIES:
			getEventPoolProxies().clear();
			return;
		case OsgiPackage.ALARMS_EVENTS_MODULE__AKN_PROXIES:
			getAknProxies().clear();
			return;
		case OsgiPackage.ALARMS_EVENTS_MODULE__PULL_EVENTS:
			getPullEvents().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case OsgiPackage.ALARMS_EVENTS_MODULE__MONITOR_POOL_PROXIES:
			return monitorPoolProxies != null && !monitorPoolProxies.isEmpty();
		case OsgiPackage.ALARMS_EVENTS_MODULE__EVENT_POOL_PROXIES:
			return eventPoolProxies != null && !eventPoolProxies.isEmpty();
		case OsgiPackage.ALARMS_EVENTS_MODULE__AKN_PROXIES:
			return aknProxies != null && !aknProxies.isEmpty();
		case OsgiPackage.ALARMS_EVENTS_MODULE__PULL_EVENTS:
			return pullEvents != null && !pullEvents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AlarmsEventsModuleImpl
