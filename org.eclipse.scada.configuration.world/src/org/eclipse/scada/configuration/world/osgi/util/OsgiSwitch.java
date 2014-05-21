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
package org.eclipse.scada.configuration.world.osgi.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.osgi.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage
 * @generated
 */
public class OsgiSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static OsgiPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OsgiSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = OsgiPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch ( int classifierID, EObject theEObject )
    {
        switch ( classifierID )
        {
            case OsgiPackage.EQUINOX_APPLICATION:
            {
                EquinoxApplication equinoxApplication = (EquinoxApplication)theEObject;
                T result = caseEquinoxApplication ( equinoxApplication );
                if ( result == null )
                    result = caseApplication ( equinoxApplication );
                if ( result == null )
                    result = caseNamedDocumentable ( equinoxApplication );
                if ( result == null )
                    result = caseDocumentable ( equinoxApplication );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.CONNECTION:
            {
                Connection connection = (Connection)theEObject;
                T result = caseConnection ( connection );
                if ( result == null )
                    result = caseNamedDocumentable ( connection );
                if ( result == null )
                    result = caseDocumentable ( connection );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.EXPORTER:
            {
                Exporter exporter = (Exporter)theEObject;
                T result = caseExporter ( exporter );
                if ( result == null )
                    result = caseNamedDocumentable ( exporter );
                if ( result == null )
                    result = caseDocumentable ( exporter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.DATA_ACCESS_CONNECTION:
            {
                DataAccessConnection dataAccessConnection = (DataAccessConnection)theEObject;
                T result = caseDataAccessConnection ( dataAccessConnection );
                if ( result == null )
                    result = caseConnection ( dataAccessConnection );
                if ( result == null )
                    result = caseNamedDocumentable ( dataAccessConnection );
                if ( result == null )
                    result = caseDocumentable ( dataAccessConnection );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.DATA_ACCESS_EXPORTER:
            {
                DataAccessExporter dataAccessExporter = (DataAccessExporter)theEObject;
                T result = caseDataAccessExporter ( dataAccessExporter );
                if ( result == null )
                    result = caseExporter ( dataAccessExporter );
                if ( result == null )
                    result = caseNamedDocumentable ( dataAccessExporter );
                if ( result == null )
                    result = caseDocumentable ( dataAccessExporter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ITEM:
            {
                Item item = (Item)theEObject;
                T result = caseItem ( item );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.SOURCE_ITEM:
            {
                SourceItem sourceItem = (SourceItem)theEObject;
                T result = caseSourceItem ( sourceItem );
                if ( result == null )
                    result = caseItem ( sourceItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ITEM_EXPORT:
            {
                ItemExport itemExport = (ItemExport)theEObject;
                T result = caseItemExport ( itemExport );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ITEM_INFORMATION:
            {
                ItemInformation itemInformation = (ItemInformation)theEObject;
                T result = caseItemInformation ( itemInformation );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.LEVEL_MONITOR:
            {
                LevelMonitor levelMonitor = (LevelMonitor)theEObject;
                T result = caseLevelMonitor ( levelMonitor );
                if ( result == null )
                    result = caseItemFeatureEntry ( levelMonitor );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ITEM_FEATURE_ENTRY:
            {
                ItemFeatureEntry itemFeatureEntry = (ItemFeatureEntry)theEObject;
                T result = caseItemFeatureEntry ( itemFeatureEntry );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.SCRIPT_ITEM:
            {
                ScriptItem scriptItem = (ScriptItem)theEObject;
                T result = caseScriptItem ( scriptItem );
                if ( result == null )
                    result = caseItem ( scriptItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.IMPORT_ITEM:
            {
                ImportItem importItem = (ImportItem)theEObject;
                T result = caseImportItem ( importItem );
                if ( result == null )
                    result = caseItem ( importItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.SUMMARY_GROUP:
            {
                SummaryGroup summaryGroup = (SummaryGroup)theEObject;
                T result = caseSummaryGroup ( summaryGroup );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.MARKER_GROUP:
            {
                MarkerGroup markerGroup = (MarkerGroup)theEObject;
                T result = caseMarkerGroup ( markerGroup );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.MARKERS:
            {
                Markers markers = (Markers)theEObject;
                T result = caseMarkers ( markers );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.CONSTANT_ITEM:
            {
                ConstantItem constantItem = (ConstantItem)theEObject;
                T result = caseConstantItem ( constantItem );
                if ( result == null )
                    result = caseItem ( constantItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.SUMMARY_ITEM:
            {
                SummaryItem summaryItem = (SummaryItem)theEObject;
                T result = caseSummaryItem ( summaryItem );
                if ( result == null )
                    result = caseItem ( summaryItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.MARKER_ENTRY:
            {
                MarkerEntry markerEntry = (MarkerEntry)theEObject;
                T result = caseMarkerEntry ( markerEntry );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.MANUAL_OVERRIDE:
            {
                ManualOverride manualOverride = (ManualOverride)theEObject;
                T result = caseManualOverride ( manualOverride );
                if ( result == null )
                    result = caseItemFeatureEntry ( manualOverride );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.MASTER_SERVER:
            {
                MasterServer masterServer = (MasterServer)theEObject;
                T result = caseMasterServer ( masterServer );
                if ( result == null )
                    result = caseEquinoxApplication ( masterServer );
                if ( result == null )
                    result = caseApplication ( masterServer );
                if ( result == null )
                    result = caseNamedDocumentable ( masterServer );
                if ( result == null )
                    result = caseDocumentable ( masterServer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.VALUE_ARCHIVE_SERVER:
            {
                ValueArchiveServer valueArchiveServer = (ValueArchiveServer)theEObject;
                T result = caseValueArchiveServer ( valueArchiveServer );
                if ( result == null )
                    result = caseEquinoxApplication ( valueArchiveServer );
                if ( result == null )
                    result = caseApplication ( valueArchiveServer );
                if ( result == null )
                    result = caseNamedDocumentable ( valueArchiveServer );
                if ( result == null )
                    result = caseDocumentable ( valueArchiveServer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.DEFAULT_MASTER_SERVER:
            {
                DefaultMasterServer defaultMasterServer = (DefaultMasterServer)theEObject;
                T result = caseDefaultMasterServer ( defaultMasterServer );
                if ( result == null )
                    result = caseMasterServer ( defaultMasterServer );
                if ( result == null )
                    result = caseEquinoxApplication ( defaultMasterServer );
                if ( result == null )
                    result = caseApplication ( defaultMasterServer );
                if ( result == null )
                    result = caseNamedDocumentable ( defaultMasterServer );
                if ( result == null )
                    result = caseDocumentable ( defaultMasterServer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.CUSTOM_MASTER_SERVER:
            {
                CustomMasterServer customMasterServer = (CustomMasterServer)theEObject;
                T result = caseCustomMasterServer ( customMasterServer );
                if ( result == null )
                    result = caseMasterServer ( customMasterServer );
                if ( result == null )
                    result = caseEquinoxApplication ( customMasterServer );
                if ( result == null )
                    result = caseApplication ( customMasterServer );
                if ( result == null )
                    result = caseNamedDocumentable ( customMasterServer );
                if ( result == null )
                    result = caseDocumentable ( customMasterServer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.APPLICATION_MODULE:
            {
                ApplicationModule applicationModule = (ApplicationModule)theEObject;
                T result = caseApplicationModule ( applicationModule );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ATTRIBUTES_SUMMARY:
            {
                AttributesSummary attributesSummary = (AttributesSummary)theEObject;
                T result = caseAttributesSummary ( attributesSummary );
                if ( result == null )
                    result = caseItemFeatureEntry ( attributesSummary );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.EVENT_LOGGER:
            {
                EventLogger eventLogger = (EventLogger)theEObject;
                T result = caseEventLogger ( eventLogger );
                if ( result == null )
                    result = caseItemFeatureEntry ( eventLogger );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.MONITOR_POOL:
            {
                MonitorPool monitorPool = (MonitorPool)theEObject;
                T result = caseMonitorPool ( monitorPool );
                if ( result == null )
                    result = caseNamedDocumentable ( monitorPool );
                if ( result == null )
                    result = caseDocumentable ( monitorPool );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.EVENT_POOL:
            {
                EventPool eventPool = (EventPool)theEObject;
                T result = caseEventPool ( eventPool );
                if ( result == null )
                    result = caseNamedDocumentable ( eventPool );
                if ( result == null )
                    result = caseDocumentable ( eventPool );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.DATA_MAPPER:
            {
                DataMapper dataMapper = (DataMapper)theEObject;
                T result = caseDataMapper ( dataMapper );
                if ( result == null )
                    result = caseNamedDocumentable ( dataMapper );
                if ( result == null )
                    result = caseDocumentable ( dataMapper );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.SIMPLE_DATA_MAPPER:
            {
                SimpleDataMapper simpleDataMapper = (SimpleDataMapper)theEObject;
                T result = caseSimpleDataMapper ( simpleDataMapper );
                if ( result == null )
                    result = caseDataMapper ( simpleDataMapper );
                if ( result == null )
                    result = caseNamedDocumentable ( simpleDataMapper );
                if ( result == null )
                    result = caseDocumentable ( simpleDataMapper );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.JDBC_DATA_MAPPER:
            {
                JdbcDataMapper jdbcDataMapper = (JdbcDataMapper)theEObject;
                T result = caseJdbcDataMapper ( jdbcDataMapper );
                if ( result == null )
                    result = caseDataMapper ( jdbcDataMapper );
                if ( result == null )
                    result = caseNamedDocumentable ( jdbcDataMapper );
                if ( result == null )
                    result = caseDocumentable ( jdbcDataMapper );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.DATA_MAPPER_ENTRY:
            {
                DataMapperEntry dataMapperEntry = (DataMapperEntry)theEObject;
                T result = caseDataMapperEntry ( dataMapperEntry );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.VALUE_MAPPER:
            {
                ValueMapper valueMapper = (ValueMapper)theEObject;
                T result = caseValueMapper ( valueMapper );
                if ( result == null )
                    result = caseItemFeatureEntry ( valueMapper );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.PERSISTENT_ITEM:
            {
                PersistentItem persistentItem = (PersistentItem)theEObject;
                T result = casePersistentItem ( persistentItem );
                if ( result == null )
                    result = caseItem ( persistentItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.PROXY_ITEM:
            {
                ProxyItem proxyItem = (ProxyItem)theEObject;
                T result = caseProxyItem ( proxyItem );
                if ( result == null )
                    result = caseItem ( proxyItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.SCALE:
            {
                Scale scale = (Scale)theEObject;
                T result = caseScale ( scale );
                if ( result == null )
                    result = caseItemFeatureEntry ( scale );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.NEGATE:
            {
                Negate negate = (Negate)theEObject;
                T result = caseNegate ( negate );
                if ( result == null )
                    result = caseItemFeatureEntry ( negate );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ROUNDING:
            {
                Rounding rounding = (Rounding)theEObject;
                T result = caseRounding ( rounding );
                if ( result == null )
                    result = caseItemFeatureEntry ( rounding );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.EXTERNAL_EVENT_MONITOR:
            {
                ExternalEventMonitor externalEventMonitor = (ExternalEventMonitor)theEObject;
                T result = caseExternalEventMonitor ( externalEventMonitor );
                if ( result == null )
                    result = caseNamedDocumentable ( externalEventMonitor );
                if ( result == null )
                    result = caseDocumentable ( externalEventMonitor );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.EXTERNAL_EVENT_FILTER:
            {
                ExternalEventFilter externalEventFilter = (ExternalEventFilter)theEObject;
                T result = caseExternalEventFilter ( externalEventFilter );
                if ( result == null )
                    result = caseNamedDocumentable ( externalEventFilter );
                if ( result == null )
                    result = caseDocumentable ( externalEventFilter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.STATIC_EXTERNAL_EVENT_FILTER:
            {
                StaticExternalEventFilter staticExternalEventFilter = (StaticExternalEventFilter)theEObject;
                T result = caseStaticExternalEventFilter ( staticExternalEventFilter );
                if ( result == null )
                    result = caseExternalEventFilter ( staticExternalEventFilter );
                if ( result == null )
                    result = caseNamedDocumentable ( staticExternalEventFilter );
                if ( result == null )
                    result = caseDocumentable ( staticExternalEventFilter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.SIMPLE_EXTERNAL_EVENT_FILTER:
            {
                SimpleExternalEventFilter simpleExternalEventFilter = (SimpleExternalEventFilter)theEObject;
                T result = caseSimpleExternalEventFilter ( simpleExternalEventFilter );
                if ( result == null )
                    result = caseExternalEventFilter ( simpleExternalEventFilter );
                if ( result == null )
                    result = caseNamedDocumentable ( simpleExternalEventFilter );
                if ( result == null )
                    result = caseDocumentable ( simpleExternalEventFilter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.TYPED_ITEM_REFERENCE:
            {
                TypedItemReference typedItemReference = (TypedItemReference)theEObject;
                T result = caseTypedItemReference ( typedItemReference );
                if ( result == null )
                    result = caseItemReference ( typedItemReference );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.CODE_FRAGMENT:
            {
                CodeFragment codeFragment = (CodeFragment)theEObject;
                T result = caseCodeFragment ( codeFragment );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.SCRIPT_TIMER:
            {
                ScriptTimer scriptTimer = (ScriptTimer)theEObject;
                T result = caseScriptTimer ( scriptTimer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ITEM_REFERENCE:
            {
                ItemReference itemReference = (ItemReference)theEObject;
                T result = caseItemReference ( itemReference );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.FORMULA_ITEM:
            {
                FormulaItem formulaItem = (FormulaItem)theEObject;
                T result = caseFormulaItem ( formulaItem );
                if ( result == null )
                    result = caseItem ( formulaItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.FORMULA_ITEM_OUTBOUND:
            {
                FormulaItemOutbound formulaItemOutbound = (FormulaItemOutbound)theEObject;
                T result = caseFormulaItemOutbound ( formulaItemOutbound );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.FORMULA_ITEM_INBOUND:
            {
                FormulaItemInbound formulaItemInbound = (FormulaItemInbound)theEObject;
                T result = caseFormulaItemInbound ( formulaItemInbound );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.BOOLEAN_MONITOR:
            {
                BooleanMonitor booleanMonitor = (BooleanMonitor)theEObject;
                T result = caseBooleanMonitor ( booleanMonitor );
                if ( result == null )
                    result = caseItemFeatureEntry ( booleanMonitor );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.LIST_MONITOR:
            {
                ListMonitor listMonitor = (ListMonitor)theEObject;
                T result = caseListMonitor ( listMonitor );
                if ( result == null )
                    result = caseItemFeatureEntry ( listMonitor );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.LIST_MONITOR_ENTRY:
            {
                ListMonitorEntry listMonitorEntry = (ListMonitorEntry)theEObject;
                T result = caseListMonitorEntry ( listMonitorEntry );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.AVERAGE:
            {
                Average average = (Average)theEObject;
                T result = caseAverage ( average );
                if ( result == null )
                    result = caseNamedDocumentable ( average );
                if ( result == null )
                    result = caseDocumentable ( average );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.MOVING_AVERAGE:
            {
                MovingAverage movingAverage = (MovingAverage)theEObject;
                T result = caseMovingAverage ( movingAverage );
                if ( result == null )
                    result = caseNamedDocumentable ( movingAverage );
                if ( result == null )
                    result = caseDocumentable ( movingAverage );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.AVERAGE_ITEM:
            {
                AverageItem averageItem = (AverageItem)theEObject;
                T result = caseAverageItem ( averageItem );
                if ( result == null )
                    result = caseItem ( averageItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.MOVING_AVERAGE_ITEM:
            {
                MovingAverageItem movingAverageItem = (MovingAverageItem)theEObject;
                T result = caseMovingAverageItem ( movingAverageItem );
                if ( result == null )
                    result = caseItem ( movingAverageItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.BLOCKINGS:
            {
                Blockings blockings = (Blockings)theEObject;
                T result = caseBlockings ( blockings );
                if ( result == null )
                    result = caseNamedDocumentable ( blockings );
                if ( result == null )
                    result = caseApplicationModule ( blockings );
                if ( result == null )
                    result = caseDocumentable ( blockings );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.BLOCK_GROUP:
            {
                BlockGroup blockGroup = (BlockGroup)theEObject;
                T result = caseBlockGroup ( blockGroup );
                if ( result == null )
                    result = caseNamedDocumentable ( blockGroup );
                if ( result == null )
                    result = caseDocumentable ( blockGroup );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.BLOCK_HANDLER:
            {
                BlockHandler blockHandler = (BlockHandler)theEObject;
                T result = caseBlockHandler ( blockHandler );
                if ( result == null )
                    result = caseItemFeatureEntry ( blockHandler );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.BLOCK:
            {
                Block block = (Block)theEObject;
                T result = caseBlock ( block );
                if ( result == null )
                    result = caseItemFeatureEntry ( block );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.GLOBAL_SUMMARY_ITEM:
            {
                GlobalSummaryItem globalSummaryItem = (GlobalSummaryItem)theEObject;
                T result = caseGlobalSummaryItem ( globalSummaryItem );
                if ( result == null )
                    result = caseItem ( globalSummaryItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.WEAK_REFERENCE_DATA_SOURCE_ITEM:
            {
                WeakReferenceDataSourceItem weakReferenceDataSourceItem = (WeakReferenceDataSourceItem)theEObject;
                T result = caseWeakReferenceDataSourceItem ( weakReferenceDataSourceItem );
                if ( result == null )
                    result = caseItem ( weakReferenceDataSourceItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ALARMS_EVENTS_EXPORTER:
            {
                AlarmsEventsExporter alarmsEventsExporter = (AlarmsEventsExporter)theEObject;
                T result = caseAlarmsEventsExporter ( alarmsEventsExporter );
                if ( result == null )
                    result = caseExporter ( alarmsEventsExporter );
                if ( result == null )
                    result = caseNamedDocumentable ( alarmsEventsExporter );
                if ( result == null )
                    result = caseDocumentable ( alarmsEventsExporter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ALARMS_EVENTS_CONNECTION:
            {
                AlarmsEventsConnection alarmsEventsConnection = (AlarmsEventsConnection)theEObject;
                T result = caseAlarmsEventsConnection ( alarmsEventsConnection );
                if ( result == null )
                    result = caseConnection ( alarmsEventsConnection );
                if ( result == null )
                    result = caseNamedDocumentable ( alarmsEventsConnection );
                if ( result == null )
                    result = caseDocumentable ( alarmsEventsConnection );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.MONITOR_POOL_PROXY:
            {
                MonitorPoolProxy monitorPoolProxy = (MonitorPoolProxy)theEObject;
                T result = caseMonitorPoolProxy ( monitorPoolProxy );
                if ( result == null )
                    result = caseNamedDocumentable ( monitorPoolProxy );
                if ( result == null )
                    result = caseDocumentable ( monitorPoolProxy );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.EVENT_POOL_PROXY:
            {
                EventPoolProxy eventPoolProxy = (EventPoolProxy)theEObject;
                T result = caseEventPoolProxy ( eventPoolProxy );
                if ( result == null )
                    result = caseNamedDocumentable ( eventPoolProxy );
                if ( result == null )
                    result = caseDocumentable ( eventPoolProxy );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ALARMS_EVENTS_MODULE:
            {
                AlarmsEventsModule alarmsEventsModule = (AlarmsEventsModule)theEObject;
                T result = caseAlarmsEventsModule ( alarmsEventsModule );
                if ( result == null )
                    result = caseApplicationModule ( alarmsEventsModule );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.AKN_PROXY:
            {
                AknProxy aknProxy = (AknProxy)theEObject;
                T result = caseAknProxy ( aknProxy );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.PULL_EVENTS:
            {
                PullEvents pullEvents = (PullEvents)theEObject;
                T result = casePullEvents ( pullEvents );
                if ( result == null )
                    result = caseNamedDocumentable ( pullEvents );
                if ( result == null )
                    result = caseDocumentable ( pullEvents );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.JDBC_USER_SERVICE_MODULE:
            {
                JdbcUserServiceModule jdbcUserServiceModule = (JdbcUserServiceModule)theEObject;
                T result = caseJdbcUserServiceModule ( jdbcUserServiceModule );
                if ( result == null )
                    result = caseApplicationModule ( jdbcUserServiceModule );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.JDBC_USER_SERVICE:
            {
                JdbcUserService jdbcUserService = (JdbcUserService)theEObject;
                T result = caseJdbcUserService ( jdbcUserService );
                if ( result == null )
                    result = caseNamedDocumentable ( jdbcUserService );
                if ( result == null )
                    result = caseDocumentable ( jdbcUserService );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.DEFAULT_VALUE_ARCHIVE_SERVER:
            {
                DefaultValueArchiveServer defaultValueArchiveServer = (DefaultValueArchiveServer)theEObject;
                T result = caseDefaultValueArchiveServer ( defaultValueArchiveServer );
                if ( result == null )
                    result = caseValueArchiveServer ( defaultValueArchiveServer );
                if ( result == null )
                    result = caseEquinoxApplication ( defaultValueArchiveServer );
                if ( result == null )
                    result = caseApplication ( defaultValueArchiveServer );
                if ( result == null )
                    result = caseNamedDocumentable ( defaultValueArchiveServer );
                if ( result == null )
                    result = caseDocumentable ( defaultValueArchiveServer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.HISTORICAL_DATA_EXPORTER:
            {
                HistoricalDataExporter historicalDataExporter = (HistoricalDataExporter)theEObject;
                T result = caseHistoricalDataExporter ( historicalDataExporter );
                if ( result == null )
                    result = caseExporter ( historicalDataExporter );
                if ( result == null )
                    result = caseNamedDocumentable ( historicalDataExporter );
                if ( result == null )
                    result = caseDocumentable ( historicalDataExporter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.VALUE_ARCHIVE:
            {
                ValueArchive valueArchive = (ValueArchive)theEObject;
                T result = caseValueArchive ( valueArchive );
                if ( result == null )
                    result = caseNamedDocumentable ( valueArchive );
                if ( result == null )
                    result = caseDocumentable ( valueArchive );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.CONFIGURATION_ADMINISTRATOR_EXPORTER:
            {
                ConfigurationAdministratorExporter configurationAdministratorExporter = (ConfigurationAdministratorExporter)theEObject;
                T result = caseConfigurationAdministratorExporter ( configurationAdministratorExporter );
                if ( result == null )
                    result = caseExporter ( configurationAdministratorExporter );
                if ( result == null )
                    result = caseNamedDocumentable ( configurationAdministratorExporter );
                if ( result == null )
                    result = caseDocumentable ( configurationAdministratorExporter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.REFERENCE_ITEM:
            {
                ReferenceItem referenceItem = (ReferenceItem)theEObject;
                T result = caseReferenceItem ( referenceItem );
                if ( result == null )
                    result = caseItem ( referenceItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.EVENT_STORAGE:
            {
                EventStorage eventStorage = (EventStorage)theEObject;
                T result = caseEventStorage ( eventStorage );
                if ( result == null )
                    result = caseIndependentConfiguration ( eventStorage );
                if ( result == null )
                    result = caseApplicationConfiguration ( eventStorage );
                if ( result == null )
                    result = caseApplicationModule ( eventStorage );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.EVENT_STORAGE_JDBC:
            {
                EventStorageJdbc eventStorageJdbc = (EventStorageJdbc)theEObject;
                T result = caseEventStorageJdbc ( eventStorageJdbc );
                if ( result == null )
                    result = caseAbstractEventStorageJdbc ( eventStorageJdbc );
                if ( result == null )
                    result = caseEventStorage ( eventStorageJdbc );
                if ( result == null )
                    result = caseIndependentConfiguration ( eventStorageJdbc );
                if ( result == null )
                    result = caseApplicationConfiguration ( eventStorageJdbc );
                if ( result == null )
                    result = caseApplicationModule ( eventStorageJdbc );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.EVENT_STORAGE_POSTGRES:
            {
                EventStoragePostgres eventStoragePostgres = (EventStoragePostgres)theEObject;
                T result = caseEventStoragePostgres ( eventStoragePostgres );
                if ( result == null )
                    result = caseAbstractEventStorageJdbc ( eventStoragePostgres );
                if ( result == null )
                    result = caseEventStorage ( eventStoragePostgres );
                if ( result == null )
                    result = caseIndependentConfiguration ( eventStoragePostgres );
                if ( result == null )
                    result = caseApplicationConfiguration ( eventStoragePostgres );
                if ( result == null )
                    result = caseApplicationModule ( eventStoragePostgres );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC:
            {
                AbstractEventStorageJdbc abstractEventStorageJdbc = (AbstractEventStorageJdbc)theEObject;
                T result = caseAbstractEventStorageJdbc ( abstractEventStorageJdbc );
                if ( result == null )
                    result = caseEventStorage ( abstractEventStorageJdbc );
                if ( result == null )
                    result = caseIndependentConfiguration ( abstractEventStorageJdbc );
                if ( result == null )
                    result = caseApplicationConfiguration ( abstractEventStorageJdbc );
                if ( result == null )
                    result = caseApplicationModule ( abstractEventStorageJdbc );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.APPLICATION_CONFIGURATION:
            {
                ApplicationConfiguration applicationConfiguration = (ApplicationConfiguration)theEObject;
                T result = caseApplicationConfiguration ( applicationConfiguration );
                if ( result == null )
                    result = caseApplicationModule ( applicationConfiguration );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.REST_EXPORTER:
            {
                RestExporter restExporter = (RestExporter)theEObject;
                T result = caseRestExporter ( restExporter );
                if ( result == null )
                    result = caseApplicationModule ( restExporter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.HTTP_SERVICE:
            {
                HttpService httpService = (HttpService)theEObject;
                T result = caseHttpService ( httpService );
                if ( result == null )
                    result = caseApplicationConfiguration ( httpService );
                if ( result == null )
                    result = caseApplicationModule ( httpService );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.INDEPENDENT_CONFIGURATION:
            {
                IndependentConfiguration independentConfiguration = (IndependentConfiguration)theEObject;
                T result = caseIndependentConfiguration ( independentConfiguration );
                if ( result == null )
                    result = caseApplicationConfiguration ( independentConfiguration );
                if ( result == null )
                    result = caseApplicationModule ( independentConfiguration );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.TRANSIENT_ITEM:
            {
                TransientItem transientItem = (TransientItem)theEObject;
                T result = caseTransientItem ( transientItem );
                if ( result == null )
                    result = caseItem ( transientItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.DEFAULT_EQUINOX_APPLICATION:
            {
                DefaultEquinoxApplication defaultEquinoxApplication = (DefaultEquinoxApplication)theEObject;
                T result = caseDefaultEquinoxApplication ( defaultEquinoxApplication );
                if ( result == null )
                    result = caseEquinoxApplication ( defaultEquinoxApplication );
                if ( result == null )
                    result = caseApplication ( defaultEquinoxApplication );
                if ( result == null )
                    result = caseNamedDocumentable ( defaultEquinoxApplication );
                if ( result == null )
                    result = caseDocumentable ( defaultEquinoxApplication );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.CHANGE_COUNTER_ITEM:
            {
                ChangeCounterItem changeCounterItem = (ChangeCounterItem)theEObject;
                T result = caseChangeCounterItem ( changeCounterItem );
                if ( result == null )
                    result = caseItem ( changeCounterItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.BUFFERED_VALUE:
            {
                BufferedValue bufferedValue = (BufferedValue)theEObject;
                T result = caseBufferedValue ( bufferedValue );
                if ( result == null )
                    result = caseNamedDocumentable ( bufferedValue );
                if ( result == null )
                    result = caseDocumentable ( bufferedValue );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case OsgiPackage.TELNET_CONSOLE:
            {
                TelnetConsole telnetConsole = (TelnetConsole)theEObject;
                T result = caseTelnetConsole ( telnetConsole );
                if ( result == null )
                    result = caseIndependentConfiguration ( telnetConsole );
                if ( result == null )
                    result = caseApplicationConfiguration ( telnetConsole );
                if ( result == null )
                    result = caseApplicationModule ( telnetConsole );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Equinox Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Equinox Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEquinoxApplication ( EquinoxApplication object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnection ( Connection object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exporter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exporter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExporter ( Exporter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Access Connection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Access Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataAccessConnection ( DataAccessConnection object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Access Exporter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Access Exporter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataAccessExporter ( DataAccessExporter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItem ( Item object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Source Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Source Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSourceItem ( SourceItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Export</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Export</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemExport ( ItemExport object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Information</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Information</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemInformation ( ItemInformation object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Level Monitor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Level Monitor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLevelMonitor ( LevelMonitor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Feature Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Feature Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemFeatureEntry ( ItemFeatureEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Script Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Script Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScriptItem ( ScriptItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Import Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Import Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseImportItem ( ImportItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Summary Group</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Summary Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSummaryGroup ( SummaryGroup object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Marker Group</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Marker Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMarkerGroup ( MarkerGroup object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Markers</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Markers</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMarkers ( Markers object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Constant Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Constant Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConstantItem ( ConstantItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Summary Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Summary Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSummaryItem ( SummaryItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Marker Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Marker Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMarkerEntry ( MarkerEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Manual Override</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Manual Override</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseManualOverride ( ManualOverride object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Master Server</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Master Server</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMasterServer ( MasterServer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Value Archive Server</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Archive Server</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueArchiveServer ( ValueArchiveServer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Default Master Server</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Default Master Server</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDefaultMasterServer ( DefaultMasterServer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Custom Master Server</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Custom Master Server</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCustomMasterServer ( CustomMasterServer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Application Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Application Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplicationModule ( ApplicationModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attributes Summary</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attributes Summary</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttributesSummary ( AttributesSummary object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Logger</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Logger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventLogger ( EventLogger object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Monitor Pool</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Monitor Pool</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMonitorPool ( MonitorPool object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Pool</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Pool</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventPool ( EventPool object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Mapper</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Mapper</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataMapper ( DataMapper object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simple Data Mapper</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple Data Mapper</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimpleDataMapper ( SimpleDataMapper object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Jdbc Data Mapper</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Jdbc Data Mapper</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJdbcDataMapper ( JdbcDataMapper object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Mapper Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Mapper Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataMapperEntry ( DataMapperEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Value Mapper</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Mapper</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueMapper ( ValueMapper object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Persistent Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Persistent Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePersistentItem ( PersistentItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Proxy Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Proxy Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProxyItem ( ProxyItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Scale</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Scale</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScale ( Scale object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Negate</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Negate</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNegate ( Negate object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Rounding</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Rounding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRounding ( Rounding object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>External Event Monitor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>External Event Monitor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalEventMonitor ( ExternalEventMonitor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>External Event Filter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>External Event Filter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalEventFilter ( ExternalEventFilter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Static External Event Filter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Static External Event Filter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStaticExternalEventFilter ( StaticExternalEventFilter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simple External Event Filter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple External Event Filter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimpleExternalEventFilter ( SimpleExternalEventFilter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Typed Item Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed Item Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypedItemReference ( TypedItemReference object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Code Fragment</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Code Fragment</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCodeFragment ( CodeFragment object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Script Timer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Script Timer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScriptTimer ( ScriptTimer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemReference ( ItemReference object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Formula Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Formula Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFormulaItem ( FormulaItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Formula Item Outbound</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Formula Item Outbound</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFormulaItemOutbound ( FormulaItemOutbound object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Formula Item Inbound</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Formula Item Inbound</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFormulaItemInbound ( FormulaItemInbound object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Boolean Monitor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Boolean Monitor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBooleanMonitor ( BooleanMonitor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>List Monitor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>List Monitor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseListMonitor ( ListMonitor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>List Monitor Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>List Monitor Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseListMonitorEntry ( ListMonitorEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Average</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Average</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAverage ( Average object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Moving Average</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Moving Average</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMovingAverage ( MovingAverage object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Average Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Average Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAverageItem ( AverageItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Moving Average Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Moving Average Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMovingAverageItem ( MovingAverageItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Blockings</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Blockings</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBlockings ( Blockings object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Block Group</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Block Group</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBlockGroup ( BlockGroup object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Block Handler</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Block Handler</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBlockHandler ( BlockHandler object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBlock ( Block object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Global Summary Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Global Summary Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGlobalSummaryItem ( GlobalSummaryItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Weak Reference Data Source Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Weak Reference Data Source Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWeakReferenceDataSourceItem ( WeakReferenceDataSourceItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Alarms Events Exporter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Alarms Events Exporter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAlarmsEventsExporter ( AlarmsEventsExporter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Alarms Events Connection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Alarms Events Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAlarmsEventsConnection ( AlarmsEventsConnection object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Monitor Pool Proxy</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Monitor Pool Proxy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMonitorPoolProxy ( MonitorPoolProxy object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Pool Proxy</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Pool Proxy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventPoolProxy ( EventPoolProxy object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Alarms Events Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Alarms Events Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAlarmsEventsModule ( AlarmsEventsModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Akn Proxy</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Akn Proxy</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAknProxy ( AknProxy object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Pull Events</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Pull Events</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePullEvents ( PullEvents object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Jdbc User Service Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Jdbc User Service Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJdbcUserServiceModule ( JdbcUserServiceModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Jdbc User Service</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Jdbc User Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJdbcUserService ( JdbcUserService object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Default Value Archive Server</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Default Value Archive Server</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDefaultValueArchiveServer ( DefaultValueArchiveServer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Historical Data Exporter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Historical Data Exporter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHistoricalDataExporter ( HistoricalDataExporter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Value Archive</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Archive</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueArchive ( ValueArchive object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Configuration Administrator Exporter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Configuration Administrator Exporter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConfigurationAdministratorExporter (
            ConfigurationAdministratorExporter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Reference Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Reference Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReferenceItem ( ReferenceItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Storage</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Storage</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventStorage ( EventStorage object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Storage Jdbc</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Storage Jdbc</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventStorageJdbc ( EventStorageJdbc object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Storage Postgres</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Storage Postgres</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventStoragePostgres ( EventStoragePostgres object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Event Storage Jdbc</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Event Storage Jdbc</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractEventStorageJdbc ( AbstractEventStorageJdbc object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Application Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Application Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplicationConfiguration ( ApplicationConfiguration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Rest Exporter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Rest Exporter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRestExporter ( RestExporter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Http Service</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Http Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHttpService ( HttpService object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Independent Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Independent Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIndependentConfiguration ( IndependentConfiguration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Transient Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Transient Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTransientItem ( TransientItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Default Equinox Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Default Equinox Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDefaultEquinoxApplication ( DefaultEquinoxApplication object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Change Counter Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Change Counter Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseChangeCounterItem ( ChangeCounterItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Buffered Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Buffered Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBufferedValue ( BufferedValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Telnet Console</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Telnet Console</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTelnetConsole ( TelnetConsole object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentable ( Documentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedDocumentable ( NamedDocumentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplication ( Application object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( EObject object )
    {
        return null;
    }

} //OsgiSwitch
