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
 * A representation of the model object '<em><b>Master Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getSummaryGroups <em>Summary Groups</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getMarkers <em>Markers</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getAeServerInformationPrefix <em>Ae Server Information Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getMonitorPools <em>Monitor Pools</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getEventPools <em>Event Pools</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getDataMapper <em>Data Mapper</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getExternalEventMonitors <em>External Event Monitors</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getExternalEventFilters <em>External Event Filters</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getAverages <em>Averages</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getMovingAverages <em>Moving Averages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer()
 * @model abstract="true"
 * @generated
 */
public interface MasterServer extends EquinoxApplication
{
    /**
     * Returns the value of the '<em><b>Summary Groups</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.SummaryGroup}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Summary Groups</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Summary Groups</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_SummaryGroups()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<SummaryGroup> getSummaryGroups ();

    /**
     * Returns the value of the '<em><b>Items</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.Item}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Items</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_Items()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Item> getItems ();

    /**
     * Returns the value of the '<em><b>Markers</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Markers</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Markers</em>' containment reference.
     * @see #setMarkers(Markers)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_Markers()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Markers getMarkers ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getMarkers <em>Markers</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Markers</em>' containment reference.
     * @see #getMarkers()
     * @generated
     */
    void setMarkers ( Markers value );

    /**
     * Returns the value of the '<em><b>Ae Server Information Prefix</b></em>' attribute.
     * The default value is <code>"ae.server.info"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ae Server Information Prefix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ae Server Information Prefix</em>' attribute.
     * @see #setAeServerInformationPrefix(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_AeServerInformationPrefix()
     * @model default="ae.server.info"
     * @generated
     */
    String getAeServerInformationPrefix ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getAeServerInformationPrefix <em>Ae Server Information Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ae Server Information Prefix</em>' attribute.
     * @see #getAeServerInformationPrefix()
     * @generated
     */
    void setAeServerInformationPrefix ( String value );

    /**
     * Returns the value of the '<em><b>Monitor Pools</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.MonitorPool}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Monitor Pools</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Monitor Pools</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_MonitorPools()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<MonitorPool> getMonitorPools ();

    /**
     * Returns the value of the '<em><b>Event Pools</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.EventPool}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Pools</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event Pools</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_EventPools()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<EventPool> getEventPools ();

    /**
     * Returns the value of the '<em><b>Data Mapper</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.DataMapper}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Mapper</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Mapper</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_DataMapper()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<DataMapper> getDataMapper ();

    /**
     * Returns the value of the '<em><b>External Event Monitors</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>External Event Monitors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>External Event Monitors</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_ExternalEventMonitors()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ExternalEventMonitor> getExternalEventMonitors ();

    /**
     * Returns the value of the '<em><b>External Event Filters</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.ExternalEventFilter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>External Event Filters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>External Event Filters</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_ExternalEventFilters()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ExternalEventFilter> getExternalEventFilters ();

    /**
     * Returns the value of the '<em><b>Averages</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.Average}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Averages</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Averages</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_Averages()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Average> getAverages ();

    /**
     * Returns the value of the '<em><b>Moving Averages</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.MovingAverage}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Moving Averages</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Moving Averages</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMasterServer_MovingAverages()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<MovingAverage> getMovingAverages ();

} // MasterServer
