/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage
 * @generated
 */
public interface OsgiFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    OsgiFactory eINSTANCE = org.eclipse.scada.configuration.world.osgi.impl.OsgiFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Data Access Connection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Access Connection</em>'.
     * @generated
     */
    DataAccessConnection createDataAccessConnection ();

    /**
     * Returns a new object of class '<em>Data Access Exporter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Access Exporter</em>'.
     * @generated
     */
    DataAccessExporter createDataAccessExporter ();

    /**
     * Returns a new object of class '<em>Source Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Source Item</em>'.
     * @generated
     */
    SourceItem createSourceItem ();

    /**
     * Returns a new object of class '<em>Item Export</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Item Export</em>'.
     * @generated
     */
    ItemExport createItemExport ();

    /**
     * Returns a new object of class '<em>Item Information</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Item Information</em>'.
     * @generated
     */
    ItemInformation createItemInformation ();

    /**
     * Returns a new object of class '<em>Level Monitor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Level Monitor</em>'.
     * @generated
     */
    LevelMonitor createLevelMonitor ();

    /**
     * Returns a new object of class '<em>Script Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Script Item</em>'.
     * @generated
     */
    ScriptItem createScriptItem ();

    /**
     * Returns a new object of class '<em>Import Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Import Item</em>'.
     * @generated
     */
    ImportItem createImportItem ();

    /**
     * Returns a new object of class '<em>Summary Group</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Summary Group</em>'.
     * @generated
     */
    SummaryGroup createSummaryGroup ();

    /**
     * Returns a new object of class '<em>Marker Group</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Marker Group</em>'.
     * @generated
     */
    MarkerGroup createMarkerGroup ();

    /**
     * Returns a new object of class '<em>Markers</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Markers</em>'.
     * @generated
     */
    Markers createMarkers ();

    /**
     * Returns a new object of class '<em>Constant Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Constant Item</em>'.
     * @generated
     */
    ConstantItem createConstantItem ();

    /**
     * Returns a new object of class '<em>Summary Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Summary Item</em>'.
     * @generated
     */
    SummaryItem createSummaryItem ();

    /**
     * Returns a new object of class '<em>Marker Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Marker Entry</em>'.
     * @generated
     */
    MarkerEntry createMarkerEntry ();

    /**
     * Returns a new object of class '<em>Manual Override</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Manual Override</em>'.
     * @generated
     */
    ManualOverride createManualOverride ();

    /**
     * Returns a new object of class '<em>Default Master Server</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Default Master Server</em>'.
     * @generated
     */
    DefaultMasterServer createDefaultMasterServer ();

    /**
     * Returns a new object of class '<em>Custom Master Server</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Custom Master Server</em>'.
     * @generated
     */
    CustomMasterServer createCustomMasterServer ();

    /**
     * Returns a new object of class '<em>Attributes Summary</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attributes Summary</em>'.
     * @generated
     */
    AttributesSummary createAttributesSummary ();

    /**
     * Returns a new object of class '<em>Event Logger</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Logger</em>'.
     * @generated
     */
    EventLogger createEventLogger ();

    /**
     * Returns a new object of class '<em>Monitor Pool</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Monitor Pool</em>'.
     * @generated
     */
    MonitorPool createMonitorPool ();

    /**
     * Returns a new object of class '<em>Event Pool</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Pool</em>'.
     * @generated
     */
    EventPool createEventPool ();

    /**
     * Returns a new object of class '<em>Simple Data Mapper</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Simple Data Mapper</em>'.
     * @generated
     */
    SimpleDataMapper createSimpleDataMapper ();

    /**
     * Returns a new object of class '<em>Jdbc Data Mapper</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Jdbc Data Mapper</em>'.
     * @generated
     */
    JdbcDataMapper createJdbcDataMapper ();

    /**
     * Returns a new object of class '<em>Data Mapper Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Mapper Entry</em>'.
     * @generated
     */
    DataMapperEntry createDataMapperEntry ();

    /**
     * Returns a new object of class '<em>Value Mapper</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Mapper</em>'.
     * @generated
     */
    ValueMapper createValueMapper ();

    /**
     * Returns a new object of class '<em>Persistent Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Persistent Item</em>'.
     * @generated
     */
    PersistentItem createPersistentItem ();

    /**
     * Returns a new object of class '<em>Proxy Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Proxy Item</em>'.
     * @generated
     */
    ProxyItem createProxyItem ();

    /**
     * Returns a new object of class '<em>Scale</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Scale</em>'.
     * @generated
     */
    Scale createScale ();

    /**
     * Returns a new object of class '<em>Negate</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Negate</em>'.
     * @generated
     */
    Negate createNegate ();

    /**
     * Returns a new object of class '<em>Rounding</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Rounding</em>'.
     * @generated
     */
    Rounding createRounding ();

    /**
     * Returns a new object of class '<em>External Event Monitor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>External Event Monitor</em>'.
     * @generated
     */
    ExternalEventMonitor createExternalEventMonitor ();

    /**
     * Returns a new object of class '<em>Static External Event Filter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Static External Event Filter</em>'.
     * @generated
     */
    StaticExternalEventFilter createStaticExternalEventFilter ();

    /**
     * Returns a new object of class '<em>Simple External Event Filter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Simple External Event Filter</em>'.
     * @generated
     */
    SimpleExternalEventFilter createSimpleExternalEventFilter ();

    /**
     * Returns a new object of class '<em>Typed Item Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Typed Item Reference</em>'.
     * @generated
     */
    TypedItemReference createTypedItemReference ();

    /**
     * Returns a new object of class '<em>Code Fragment</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Code Fragment</em>'.
     * @generated
     */
    CodeFragment createCodeFragment ();

    /**
     * Returns a new object of class '<em>Script Timer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Script Timer</em>'.
     * @generated
     */
    ScriptTimer createScriptTimer ();

    /**
     * Returns a new object of class '<em>Item Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Item Reference</em>'.
     * @generated
     */
    ItemReference createItemReference ();

    /**
     * Returns a new object of class '<em>Formula Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Formula Item</em>'.
     * @generated
     */
    FormulaItem createFormulaItem ();

    /**
     * Returns a new object of class '<em>Formula Item Outbound</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Formula Item Outbound</em>'.
     * @generated
     */
    FormulaItemOutbound createFormulaItemOutbound ();

    /**
     * Returns a new object of class '<em>Formula Item Inbound</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Formula Item Inbound</em>'.
     * @generated
     */
    FormulaItemInbound createFormulaItemInbound ();

    /**
     * Returns a new object of class '<em>Boolean Monitor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Boolean Monitor</em>'.
     * @generated
     */
    BooleanMonitor createBooleanMonitor ();

    /**
     * Returns a new object of class '<em>List Monitor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>List Monitor</em>'.
     * @generated
     */
    ListMonitor createListMonitor ();

    /**
     * Returns a new object of class '<em>List Monitor Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>List Monitor Entry</em>'.
     * @generated
     */
    ListMonitorEntry createListMonitorEntry ();

    /**
     * Returns a new object of class '<em>Average</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Average</em>'.
     * @generated
     */
    Average createAverage ();

    /**
     * Returns a new object of class '<em>Moving Average</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Moving Average</em>'.
     * @generated
     */
    MovingAverage createMovingAverage ();

    /**
     * Returns a new object of class '<em>Average Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Average Item</em>'.
     * @generated
     */
    AverageItem createAverageItem ();

    /**
     * Returns a new object of class '<em>Moving Average Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Moving Average Item</em>'.
     * @generated
     */
    MovingAverageItem createMovingAverageItem ();

    /**
     * Returns a new object of class '<em>Blockings</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Blockings</em>'.
     * @generated
     */
    Blockings createBlockings ();

    /**
     * Returns a new object of class '<em>Block Group</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Block Group</em>'.
     * @generated
     */
    BlockGroup createBlockGroup ();

    /**
     * Returns a new object of class '<em>Block Handler</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Block Handler</em>'.
     * @generated
     */
    BlockHandler createBlockHandler ();

    /**
     * Returns a new object of class '<em>Block</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Block</em>'.
     * @generated
     */
    Block createBlock ();

    /**
     * Returns a new object of class '<em>Global Summary Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Global Summary Item</em>'.
     * @generated
     */
    GlobalSummaryItem createGlobalSummaryItem ();

    /**
     * Returns a new object of class '<em>Weak Reference Data Source Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Weak Reference Data Source Item</em>'.
     * @generated
     */
    WeakReferenceDataSourceItem createWeakReferenceDataSourceItem ();

    /**
     * Returns a new object of class '<em>Alarms Events Exporter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Alarms Events Exporter</em>'.
     * @generated
     */
    AlarmsEventsExporter createAlarmsEventsExporter ();

    /**
     * Returns a new object of class '<em>Alarms Events Connection</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Alarms Events Connection</em>'.
     * @generated
     */
    AlarmsEventsConnection createAlarmsEventsConnection ();

    /**
     * Returns a new object of class '<em>Monitor Pool Proxy</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Monitor Pool Proxy</em>'.
     * @generated
     */
    MonitorPoolProxy createMonitorPoolProxy ();

    /**
     * Returns a new object of class '<em>Event Pool Proxy</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Pool Proxy</em>'.
     * @generated
     */
    EventPoolProxy createEventPoolProxy ();

    /**
     * Returns a new object of class '<em>Alarms Events Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Alarms Events Module</em>'.
     * @generated
     */
    AlarmsEventsModule createAlarmsEventsModule ();

    /**
     * Returns a new object of class '<em>Akn Proxy</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Akn Proxy</em>'.
     * @generated
     */
    AknProxy createAknProxy ();

    /**
     * Returns a new object of class '<em>Pull Events</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Pull Events</em>'.
     * @generated
     */
    PullEvents createPullEvents ();

    /**
     * Returns a new object of class '<em>Jdbc User Service Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Jdbc User Service Module</em>'.
     * @generated
     */
    JdbcUserServiceModule createJdbcUserServiceModule ();

    /**
     * Returns a new object of class '<em>Jdbc User Service</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Jdbc User Service</em>'.
     * @generated
     */
    JdbcUserService createJdbcUserService ();

    /**
     * Returns a new object of class '<em>Default Value Archive Server</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Default Value Archive Server</em>'.
     * @generated
     */
    DefaultValueArchiveServer createDefaultValueArchiveServer ();

    /**
     * Returns a new object of class '<em>Historical Data Exporter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Historical Data Exporter</em>'.
     * @generated
     */
    HistoricalDataExporter createHistoricalDataExporter ();

    /**
     * Returns a new object of class '<em>Value Archive</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Archive</em>'.
     * @generated
     */
    ValueArchive createValueArchive ();

    /**
     * Returns a new object of class '<em>Configuration Administrator Exporter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Configuration Administrator Exporter</em>'.
     * @generated
     */
    ConfigurationAdministratorExporter createConfigurationAdministratorExporter ();

    /**
     * Returns a new object of class '<em>Reference Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Reference Item</em>'.
     * @generated
     */
    ReferenceItem createReferenceItem ();

    /**
     * Returns a new object of class '<em>Event Storage Jdbc</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Storage Jdbc</em>'.
     * @generated
     */
    EventStorageJdbc createEventStorageJdbc ();

    /**
     * Returns a new object of class '<em>Event Storage Postgres</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Storage Postgres</em>'.
     * @generated
     */
    EventStoragePostgres createEventStoragePostgres ();

    /**
     * Returns a new object of class '<em>Rest Exporter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Rest Exporter</em>'.
     * @generated
     */
    RestExporter createRestExporter ();

    /**
     * Returns a new object of class '<em>Http Service</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Http Service</em>'.
     * @generated
     */
    HttpService createHttpService ();

    /**
     * Returns a new object of class '<em>Transient Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Transient Item</em>'.
     * @generated
     */
    TransientItem createTransientItem ();

    /**
     * Returns a new object of class '<em>Default Equinox Application</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Default Equinox Application</em>'.
     * @generated
     */
    DefaultEquinoxApplication createDefaultEquinoxApplication ();

    /**
     * Returns a new object of class '<em>Change Counter Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Change Counter Item</em>'.
     * @generated
     */
    ChangeCounterItem createChangeCounterItem ();

    /**
     * Returns a new object of class '<em>Buffered Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Buffered Value</em>'.
     * @generated
     */
    BufferedValue createBufferedValue ();

    /**
     * Returns a new object of class '<em>Telnet Console</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Telnet Console</em>'.
     * @generated
     */
    TelnetConsole createTelnetConsole ();

    /**
     * Returns a new object of class '<em>Event Injector Postgres</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Injector Postgres</em>'.
     * @generated
     */
    EventInjectorPostgres createEventInjectorPostgres ();

    /**
     * Returns a new object of class '<em>Event Injector Jdbc</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Injector Jdbc</em>'.
     * @generated
     */
    EventInjectorJdbc createEventInjectorJdbc ();

    /**
     * Returns a new object of class '<em>Profile Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Profile Configuration</em>'.
     * @generated
     */
    ProfileConfiguration createProfileConfiguration ();

    /**
     * Returns a new object of class '<em>Event Injector Syslog</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Injector Syslog</em>'.
     * @generated
     */
    EventInjectorSyslog createEventInjectorSyslog ();

    /**
     * Returns a new object of class '<em>Event Injector Manager</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Injector Manager</em>'.
     * @generated
     */
    EventInjectorManager createEventInjectorManager ();

    /**
     * Returns a new object of class '<em>Default Storage Handler</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Default Storage Handler</em>'.
     * @generated
     */
    DefaultStorageHandler createDefaultStorageHandler ();

    /**
     * Returns a new object of class '<em>Include Event Filter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Include Event Filter</em>'.
     * @generated
     */
    IncludeEventFilter createIncludeEventFilter ();

    /**
     * Returns a new object of class '<em>Exclude Event Filter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exclude Event Filter</em>'.
     * @generated
     */
    ExcludeEventFilter createExcludeEventFilter ();

    /**
     * Returns a new object of class '<em>Script Event Handler</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Script Event Handler</em>'.
     * @generated
     */
    ScriptEventHandler createScriptEventHandler ();

    /**
     * Returns a new object of class '<em>Mail Event Handler</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Mail Event Handler</em>'.
     * @generated
     */
    MailEventHandler createMailEventHandler ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    OsgiPackage getOsgiPackage ();

} //OsgiFactory
