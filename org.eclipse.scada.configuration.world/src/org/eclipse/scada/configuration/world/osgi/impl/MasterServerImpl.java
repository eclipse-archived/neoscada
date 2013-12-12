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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.Average;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.DataMapper;
import org.eclipse.scada.configuration.world.osgi.EventPool;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.ExternalEventFilter;
import org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.Markers;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.MonitorPool;
import org.eclipse.scada.configuration.world.osgi.MovingAverage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.SummaryGroup;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Master Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getExporter <em>Exporter</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getCustomizationProfile <em>Customization Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getSecurityConfiguration <em>Security Configuration</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getSummaryGroups <em>Summary Groups</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getMarkers <em>Markers</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getAeServerInformationPrefix <em>Ae Server Information Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getMonitorPools <em>Monitor Pools</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getEventPools <em>Event Pools</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getDataMapper <em>Data Mapper</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getExternalEventMonitors <em>External Event Monitors</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getExternalEventFilters <em>External Event Filters</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getAverages <em>Averages</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl#getMovingAverages <em>Moving Averages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MasterServerImpl extends MinimalEObjectImpl.Container
		implements MasterServer {
	/**
	 * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortDescription()
	 * @generated
	 * @ordered
	 */
	protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> connections;

	/**
	 * The cached value of the '{@link #getExporter() <em>Exporter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExporter()
	 * @generated
	 * @ordered
	 */
	protected EList<Exporter> exporter;

	/**
	 * The cached value of the '{@link #getCustomizationProfile() <em>Customization Profile</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomizationProfile()
	 * @generated
	 * @ordered
	 */
	protected Profile customizationProfile;

	/**
	 * The cached value of the '{@link #getSecurityConfiguration() <em>Security Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecurityConfiguration()
	 * @generated
	 * @ordered
	 */
	protected Configuration securityConfiguration;

	/**
	 * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModules()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationModule> modules;

	/**
	 * The cached value of the '{@link #getSummaryGroups() <em>Summary Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSummaryGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<SummaryGroup> summaryGroups;

	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<Item> items;

	/**
	 * The cached value of the '{@link #getMarkers() <em>Markers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarkers()
	 * @generated
	 * @ordered
	 */
	protected Markers markers;

	/**
	 * The default value of the '{@link #getAeServerInformationPrefix() <em>Ae Server Information Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAeServerInformationPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String AE_SERVER_INFORMATION_PREFIX_EDEFAULT = "ae.server.info"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getAeServerInformationPrefix() <em>Ae Server Information Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAeServerInformationPrefix()
	 * @generated
	 * @ordered
	 */
	protected String aeServerInformationPrefix = AE_SERVER_INFORMATION_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMonitorPools() <em>Monitor Pools</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitorPools()
	 * @generated
	 * @ordered
	 */
	protected EList<MonitorPool> monitorPools;

	/**
	 * The cached value of the '{@link #getEventPools() <em>Event Pools</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventPools()
	 * @generated
	 * @ordered
	 */
	protected EList<EventPool> eventPools;

	/**
	 * The cached value of the '{@link #getDataMapper() <em>Data Mapper</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataMapper()
	 * @generated
	 * @ordered
	 */
	protected EList<DataMapper> dataMapper;

	/**
	 * The cached value of the '{@link #getExternalEventMonitors() <em>External Event Monitors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalEventMonitors()
	 * @generated
	 * @ordered
	 */
	protected EList<ExternalEventMonitor> externalEventMonitors;

	/**
	 * The cached value of the '{@link #getExternalEventFilters() <em>External Event Filters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalEventFilters()
	 * @generated
	 * @ordered
	 */
	protected EList<ExternalEventFilter> externalEventFilters;

	/**
	 * The cached value of the '{@link #getAverages() <em>Averages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverages()
	 * @generated
	 * @ordered
	 */
	protected EList<Average> averages;

	/**
	 * The cached value of the '{@link #getMovingAverages() <em>Moving Averages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMovingAverages()
	 * @generated
	 * @ordered
	 */
	protected EList<MovingAverage> movingAverages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MasterServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.MASTER_SERVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortDescription(String newShortDescription) {
		String oldShortDescription = shortDescription;
		shortDescription = newShortDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.MASTER_SERVER__SHORT_DESCRIPTION,
					oldShortDescription, shortDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.MASTER_SERVER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connection> getConnections() {
		if (connections == null) {
			connections = new EObjectContainmentEList.Resolving<Connection>(
					Connection.class, this,
					OsgiPackage.MASTER_SERVER__CONNECTIONS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Exporter> getExporter() {
		if (exporter == null) {
			exporter = new EObjectContainmentEList.Resolving<Exporter>(
					Exporter.class, this, OsgiPackage.MASTER_SERVER__EXPORTER);
		}
		return exporter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Profile getCustomizationProfile() {
		if (customizationProfile != null && customizationProfile.eIsProxy()) {
			InternalEObject oldCustomizationProfile = (InternalEObject) customizationProfile;
			customizationProfile = (Profile) eResolveProxy(oldCustomizationProfile);
			if (customizationProfile != oldCustomizationProfile) {
				InternalEObject newCustomizationProfile = (InternalEObject) customizationProfile;
				NotificationChain msgs = oldCustomizationProfile
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE,
								null, null);
				if (newCustomizationProfile.eInternalContainer() == null) {
					msgs = newCustomizationProfile
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE,
							oldCustomizationProfile, customizationProfile));
			}
		}
		return customizationProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Profile basicGetCustomizationProfile() {
		return customizationProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCustomizationProfile(
			Profile newCustomizationProfile, NotificationChain msgs) {
		Profile oldCustomizationProfile = customizationProfile;
		customizationProfile = newCustomizationProfile;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE,
					oldCustomizationProfile, newCustomizationProfile);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomizationProfile(Profile newCustomizationProfile) {
		if (newCustomizationProfile != customizationProfile) {
			NotificationChain msgs = null;
			if (customizationProfile != null)
				msgs = ((InternalEObject) customizationProfile)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE,
								null, msgs);
			if (newCustomizationProfile != null)
				msgs = ((InternalEObject) newCustomizationProfile)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE,
								null, msgs);
			msgs = basicSetCustomizationProfile(newCustomizationProfile, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE,
					newCustomizationProfile, newCustomizationProfile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getSecurityConfiguration() {
		if (securityConfiguration != null && securityConfiguration.eIsProxy()) {
			InternalEObject oldSecurityConfiguration = (InternalEObject) securityConfiguration;
			securityConfiguration = (Configuration) eResolveProxy(oldSecurityConfiguration);
			if (securityConfiguration != oldSecurityConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OsgiPackage.MASTER_SERVER__SECURITY_CONFIGURATION,
							oldSecurityConfiguration, securityConfiguration));
			}
		}
		return securityConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration basicGetSecurityConfiguration() {
		return securityConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecurityConfiguration(Configuration newSecurityConfiguration) {
		Configuration oldSecurityConfiguration = securityConfiguration;
		securityConfiguration = newSecurityConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.MASTER_SERVER__SECURITY_CONFIGURATION,
					oldSecurityConfiguration, securityConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationModule> getModules() {
		if (modules == null) {
			modules = new EObjectContainmentEList.Resolving<ApplicationModule>(
					ApplicationModule.class, this,
					OsgiPackage.MASTER_SERVER__MODULES);
		}
		return modules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SummaryGroup> getSummaryGroups() {
		if (summaryGroups == null) {
			summaryGroups = new EObjectContainmentEList.Resolving<SummaryGroup>(
					SummaryGroup.class, this,
					OsgiPackage.MASTER_SERVER__SUMMARY_GROUPS);
		}
		return summaryGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Item> getItems() {
		if (items == null) {
			items = new EObjectContainmentEList.Resolving<Item>(Item.class,
					this, OsgiPackage.MASTER_SERVER__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Markers getMarkers() {
		if (markers != null && markers.eIsProxy()) {
			InternalEObject oldMarkers = (InternalEObject) markers;
			markers = (Markers) eResolveProxy(oldMarkers);
			if (markers != oldMarkers) {
				InternalEObject newMarkers = (InternalEObject) markers;
				NotificationChain msgs = oldMarkers.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- OsgiPackage.MASTER_SERVER__MARKERS, null,
						null);
				if (newMarkers.eInternalContainer() == null) {
					msgs = newMarkers.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
							- OsgiPackage.MASTER_SERVER__MARKERS, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OsgiPackage.MASTER_SERVER__MARKERS, oldMarkers,
							markers));
			}
		}
		return markers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Markers basicGetMarkers() {
		return markers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMarkers(Markers newMarkers,
			NotificationChain msgs) {
		Markers oldMarkers = markers;
		markers = newMarkers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, OsgiPackage.MASTER_SERVER__MARKERS,
					oldMarkers, newMarkers);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarkers(Markers newMarkers) {
		if (newMarkers != markers) {
			NotificationChain msgs = null;
			if (markers != null)
				msgs = ((InternalEObject) markers).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- OsgiPackage.MASTER_SERVER__MARKERS, null,
						msgs);
			if (newMarkers != null)
				msgs = ((InternalEObject) newMarkers).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- OsgiPackage.MASTER_SERVER__MARKERS, null,
						msgs);
			msgs = basicSetMarkers(newMarkers, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.MASTER_SERVER__MARKERS, newMarkers, newMarkers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAeServerInformationPrefix() {
		return aeServerInformationPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAeServerInformationPrefix(String newAeServerInformationPrefix) {
		String oldAeServerInformationPrefix = aeServerInformationPrefix;
		aeServerInformationPrefix = newAeServerInformationPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX,
					oldAeServerInformationPrefix, aeServerInformationPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MonitorPool> getMonitorPools() {
		if (monitorPools == null) {
			monitorPools = new EObjectContainmentEList.Resolving<MonitorPool>(
					MonitorPool.class, this,
					OsgiPackage.MASTER_SERVER__MONITOR_POOLS);
		}
		return monitorPools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventPool> getEventPools() {
		if (eventPools == null) {
			eventPools = new EObjectContainmentEList.Resolving<EventPool>(
					EventPool.class, this,
					OsgiPackage.MASTER_SERVER__EVENT_POOLS);
		}
		return eventPools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataMapper> getDataMapper() {
		if (dataMapper == null) {
			dataMapper = new EObjectContainmentEList.Resolving<DataMapper>(
					DataMapper.class, this,
					OsgiPackage.MASTER_SERVER__DATA_MAPPER);
		}
		return dataMapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExternalEventMonitor> getExternalEventMonitors() {
		if (externalEventMonitors == null) {
			externalEventMonitors = new EObjectContainmentEList.Resolving<ExternalEventMonitor>(
					ExternalEventMonitor.class, this,
					OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_MONITORS);
		}
		return externalEventMonitors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExternalEventFilter> getExternalEventFilters() {
		if (externalEventFilters == null) {
			externalEventFilters = new EObjectContainmentEList.Resolving<ExternalEventFilter>(
					ExternalEventFilter.class, this,
					OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_FILTERS);
		}
		return externalEventFilters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Average> getAverages() {
		if (averages == null) {
			averages = new EObjectContainmentEList.Resolving<Average>(
					Average.class, this, OsgiPackage.MASTER_SERVER__AVERAGES);
		}
		return averages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MovingAverage> getMovingAverages() {
		if (movingAverages == null) {
			movingAverages = new EObjectContainmentEList.Resolving<MovingAverage>(
					MovingAverage.class, this,
					OsgiPackage.MASTER_SERVER__MOVING_AVERAGES);
		}
		return movingAverages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Profile getProfile() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
		case OsgiPackage.MASTER_SERVER__CONNECTIONS:
			return ((InternalEList<?>) getConnections()).basicRemove(otherEnd,
					msgs);
		case OsgiPackage.MASTER_SERVER__EXPORTER:
			return ((InternalEList<?>) getExporter()).basicRemove(otherEnd,
					msgs);
		case OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE:
			return basicSetCustomizationProfile(null, msgs);
		case OsgiPackage.MASTER_SERVER__MODULES:
			return ((InternalEList<?>) getModules())
					.basicRemove(otherEnd, msgs);
		case OsgiPackage.MASTER_SERVER__SUMMARY_GROUPS:
			return ((InternalEList<?>) getSummaryGroups()).basicRemove(
					otherEnd, msgs);
		case OsgiPackage.MASTER_SERVER__ITEMS:
			return ((InternalEList<?>) getItems()).basicRemove(otherEnd, msgs);
		case OsgiPackage.MASTER_SERVER__MARKERS:
			return basicSetMarkers(null, msgs);
		case OsgiPackage.MASTER_SERVER__MONITOR_POOLS:
			return ((InternalEList<?>) getMonitorPools()).basicRemove(otherEnd,
					msgs);
		case OsgiPackage.MASTER_SERVER__EVENT_POOLS:
			return ((InternalEList<?>) getEventPools()).basicRemove(otherEnd,
					msgs);
		case OsgiPackage.MASTER_SERVER__DATA_MAPPER:
			return ((InternalEList<?>) getDataMapper()).basicRemove(otherEnd,
					msgs);
		case OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_MONITORS:
			return ((InternalEList<?>) getExternalEventMonitors()).basicRemove(
					otherEnd, msgs);
		case OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_FILTERS:
			return ((InternalEList<?>) getExternalEventFilters()).basicRemove(
					otherEnd, msgs);
		case OsgiPackage.MASTER_SERVER__AVERAGES:
			return ((InternalEList<?>) getAverages()).basicRemove(otherEnd,
					msgs);
		case OsgiPackage.MASTER_SERVER__MOVING_AVERAGES:
			return ((InternalEList<?>) getMovingAverages()).basicRemove(
					otherEnd, msgs);
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
		case OsgiPackage.MASTER_SERVER__SHORT_DESCRIPTION:
			return getShortDescription();
		case OsgiPackage.MASTER_SERVER__NAME:
			return getName();
		case OsgiPackage.MASTER_SERVER__CONNECTIONS:
			return getConnections();
		case OsgiPackage.MASTER_SERVER__EXPORTER:
			return getExporter();
		case OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE:
			if (resolve)
				return getCustomizationProfile();
			return basicGetCustomizationProfile();
		case OsgiPackage.MASTER_SERVER__SECURITY_CONFIGURATION:
			if (resolve)
				return getSecurityConfiguration();
			return basicGetSecurityConfiguration();
		case OsgiPackage.MASTER_SERVER__MODULES:
			return getModules();
		case OsgiPackage.MASTER_SERVER__SUMMARY_GROUPS:
			return getSummaryGroups();
		case OsgiPackage.MASTER_SERVER__ITEMS:
			return getItems();
		case OsgiPackage.MASTER_SERVER__MARKERS:
			if (resolve)
				return getMarkers();
			return basicGetMarkers();
		case OsgiPackage.MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX:
			return getAeServerInformationPrefix();
		case OsgiPackage.MASTER_SERVER__MONITOR_POOLS:
			return getMonitorPools();
		case OsgiPackage.MASTER_SERVER__EVENT_POOLS:
			return getEventPools();
		case OsgiPackage.MASTER_SERVER__DATA_MAPPER:
			return getDataMapper();
		case OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_MONITORS:
			return getExternalEventMonitors();
		case OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_FILTERS:
			return getExternalEventFilters();
		case OsgiPackage.MASTER_SERVER__AVERAGES:
			return getAverages();
		case OsgiPackage.MASTER_SERVER__MOVING_AVERAGES:
			return getMovingAverages();
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
		case OsgiPackage.MASTER_SERVER__SHORT_DESCRIPTION:
			setShortDescription((String) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__NAME:
			setName((String) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__CONNECTIONS:
			getConnections().clear();
			getConnections()
					.addAll((Collection<? extends Connection>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__EXPORTER:
			getExporter().clear();
			getExporter().addAll((Collection<? extends Exporter>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE:
			setCustomizationProfile((Profile) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__SECURITY_CONFIGURATION:
			setSecurityConfiguration((Configuration) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__MODULES:
			getModules().clear();
			getModules().addAll(
					(Collection<? extends ApplicationModule>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__SUMMARY_GROUPS:
			getSummaryGroups().clear();
			getSummaryGroups().addAll(
					(Collection<? extends SummaryGroup>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__ITEMS:
			getItems().clear();
			getItems().addAll((Collection<? extends Item>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__MARKERS:
			setMarkers((Markers) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX:
			setAeServerInformationPrefix((String) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__MONITOR_POOLS:
			getMonitorPools().clear();
			getMonitorPools().addAll(
					(Collection<? extends MonitorPool>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__EVENT_POOLS:
			getEventPools().clear();
			getEventPools().addAll((Collection<? extends EventPool>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__DATA_MAPPER:
			getDataMapper().clear();
			getDataMapper().addAll((Collection<? extends DataMapper>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_MONITORS:
			getExternalEventMonitors().clear();
			getExternalEventMonitors().addAll(
					(Collection<? extends ExternalEventMonitor>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_FILTERS:
			getExternalEventFilters().clear();
			getExternalEventFilters().addAll(
					(Collection<? extends ExternalEventFilter>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__AVERAGES:
			getAverages().clear();
			getAverages().addAll((Collection<? extends Average>) newValue);
			return;
		case OsgiPackage.MASTER_SERVER__MOVING_AVERAGES:
			getMovingAverages().clear();
			getMovingAverages().addAll(
					(Collection<? extends MovingAverage>) newValue);
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
		case OsgiPackage.MASTER_SERVER__SHORT_DESCRIPTION:
			setShortDescription(SHORT_DESCRIPTION_EDEFAULT);
			return;
		case OsgiPackage.MASTER_SERVER__NAME:
			setName(NAME_EDEFAULT);
			return;
		case OsgiPackage.MASTER_SERVER__CONNECTIONS:
			getConnections().clear();
			return;
		case OsgiPackage.MASTER_SERVER__EXPORTER:
			getExporter().clear();
			return;
		case OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE:
			setCustomizationProfile((Profile) null);
			return;
		case OsgiPackage.MASTER_SERVER__SECURITY_CONFIGURATION:
			setSecurityConfiguration((Configuration) null);
			return;
		case OsgiPackage.MASTER_SERVER__MODULES:
			getModules().clear();
			return;
		case OsgiPackage.MASTER_SERVER__SUMMARY_GROUPS:
			getSummaryGroups().clear();
			return;
		case OsgiPackage.MASTER_SERVER__ITEMS:
			getItems().clear();
			return;
		case OsgiPackage.MASTER_SERVER__MARKERS:
			setMarkers((Markers) null);
			return;
		case OsgiPackage.MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX:
			setAeServerInformationPrefix(AE_SERVER_INFORMATION_PREFIX_EDEFAULT);
			return;
		case OsgiPackage.MASTER_SERVER__MONITOR_POOLS:
			getMonitorPools().clear();
			return;
		case OsgiPackage.MASTER_SERVER__EVENT_POOLS:
			getEventPools().clear();
			return;
		case OsgiPackage.MASTER_SERVER__DATA_MAPPER:
			getDataMapper().clear();
			return;
		case OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_MONITORS:
			getExternalEventMonitors().clear();
			return;
		case OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_FILTERS:
			getExternalEventFilters().clear();
			return;
		case OsgiPackage.MASTER_SERVER__AVERAGES:
			getAverages().clear();
			return;
		case OsgiPackage.MASTER_SERVER__MOVING_AVERAGES:
			getMovingAverages().clear();
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
		case OsgiPackage.MASTER_SERVER__SHORT_DESCRIPTION:
			return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null
					: !SHORT_DESCRIPTION_EDEFAULT.equals(shortDescription);
		case OsgiPackage.MASTER_SERVER__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case OsgiPackage.MASTER_SERVER__CONNECTIONS:
			return connections != null && !connections.isEmpty();
		case OsgiPackage.MASTER_SERVER__EXPORTER:
			return exporter != null && !exporter.isEmpty();
		case OsgiPackage.MASTER_SERVER__CUSTOMIZATION_PROFILE:
			return customizationProfile != null;
		case OsgiPackage.MASTER_SERVER__SECURITY_CONFIGURATION:
			return securityConfiguration != null;
		case OsgiPackage.MASTER_SERVER__MODULES:
			return modules != null && !modules.isEmpty();
		case OsgiPackage.MASTER_SERVER__SUMMARY_GROUPS:
			return summaryGroups != null && !summaryGroups.isEmpty();
		case OsgiPackage.MASTER_SERVER__ITEMS:
			return items != null && !items.isEmpty();
		case OsgiPackage.MASTER_SERVER__MARKERS:
			return markers != null;
		case OsgiPackage.MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX:
			return AE_SERVER_INFORMATION_PREFIX_EDEFAULT == null ? aeServerInformationPrefix != null
					: !AE_SERVER_INFORMATION_PREFIX_EDEFAULT
							.equals(aeServerInformationPrefix);
		case OsgiPackage.MASTER_SERVER__MONITOR_POOLS:
			return monitorPools != null && !monitorPools.isEmpty();
		case OsgiPackage.MASTER_SERVER__EVENT_POOLS:
			return eventPools != null && !eventPools.isEmpty();
		case OsgiPackage.MASTER_SERVER__DATA_MAPPER:
			return dataMapper != null && !dataMapper.isEmpty();
		case OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_MONITORS:
			return externalEventMonitors != null
					&& !externalEventMonitors.isEmpty();
		case OsgiPackage.MASTER_SERVER__EXTERNAL_EVENT_FILTERS:
			return externalEventFilters != null
					&& !externalEventFilters.isEmpty();
		case OsgiPackage.MASTER_SERVER__AVERAGES:
			return averages != null && !averages.isEmpty();
		case OsgiPackage.MASTER_SERVER__MOVING_AVERAGES:
			return movingAverages != null && !movingAverages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
		case OsgiPackage.MASTER_SERVER___GET_PROFILE:
			return getProfile();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (shortDescription: "); //$NON-NLS-1$
		result.append(shortDescription);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", aeServerInformationPrefix: "); //$NON-NLS-1$
		result.append(aeServerInformationPrefix);
		result.append(')');
		return result.toString();
	}

} //MasterServerImpl
