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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.osgi.*;
import org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc;
import org.eclipse.scada.configuration.world.osgi.AknProxy;
import org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection;
import org.eclipse.scada.configuration.world.osgi.AlarmsEventsExporter;
import org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule;
import org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.AttributesSummary;
import org.eclipse.scada.configuration.world.osgi.Average;
import org.eclipse.scada.configuration.world.osgi.AverageItem;
import org.eclipse.scada.configuration.world.osgi.Block;
import org.eclipse.scada.configuration.world.osgi.BlockGroup;
import org.eclipse.scada.configuration.world.osgi.BlockHandler;
import org.eclipse.scada.configuration.world.osgi.Blockings;
import org.eclipse.scada.configuration.world.osgi.BooleanMonitor;
import org.eclipse.scada.configuration.world.osgi.BufferedValue;
import org.eclipse.scada.configuration.world.osgi.ChangeCounterItem;
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.ConstantItem;
import org.eclipse.scada.configuration.world.osgi.CustomMasterServer;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.DataMapper;
import org.eclipse.scada.configuration.world.osgi.DataMapperEntry;
import org.eclipse.scada.configuration.world.osgi.DefaultEquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.DefaultMasterServer;
import org.eclipse.scada.configuration.world.osgi.DefaultValueArchiveServer;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.EventLogger;
import org.eclipse.scada.configuration.world.osgi.EventPool;
import org.eclipse.scada.configuration.world.osgi.EventPoolProxy;
import org.eclipse.scada.configuration.world.osgi.EventStorage;
import org.eclipse.scada.configuration.world.osgi.EventStorageJdbc;
import org.eclipse.scada.configuration.world.osgi.EventStoragePostgres;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.ExternalEventFilter;
import org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor;
import org.eclipse.scada.configuration.world.osgi.FormulaItem;
import org.eclipse.scada.configuration.world.osgi.FormulaItemInbound;
import org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound;
import org.eclipse.scada.configuration.world.osgi.GlobalSummaryItem;
import org.eclipse.scada.configuration.world.osgi.HistoricalDataExporter;
import org.eclipse.scada.configuration.world.osgi.HttpService;
import org.eclipse.scada.configuration.world.osgi.ImportItem;
import org.eclipse.scada.configuration.world.osgi.IndependentConfiguration;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.ItemExport;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;
import org.eclipse.scada.configuration.world.osgi.ItemInformation;
import org.eclipse.scada.configuration.world.osgi.ItemReference;
import org.eclipse.scada.configuration.world.osgi.JdbcDataMapper;
import org.eclipse.scada.configuration.world.osgi.JdbcUserService;
import org.eclipse.scada.configuration.world.osgi.JdbcUserServiceModule;
import org.eclipse.scada.configuration.world.osgi.LevelMonitor;
import org.eclipse.scada.configuration.world.osgi.ListMonitor;
import org.eclipse.scada.configuration.world.osgi.ListMonitorEntry;
import org.eclipse.scada.configuration.world.osgi.ManualOverride;
import org.eclipse.scada.configuration.world.osgi.MarkerEntry;
import org.eclipse.scada.configuration.world.osgi.MarkerGroup;
import org.eclipse.scada.configuration.world.osgi.Markers;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.MonitorPool;
import org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy;
import org.eclipse.scada.configuration.world.osgi.MovingAverage;
import org.eclipse.scada.configuration.world.osgi.MovingAverageItem;
import org.eclipse.scada.configuration.world.osgi.Negate;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.PersistentItem;
import org.eclipse.scada.configuration.world.osgi.PropertyEntry;
import org.eclipse.scada.configuration.world.osgi.ProxyItem;
import org.eclipse.scada.configuration.world.osgi.PullEvents;
import org.eclipse.scada.configuration.world.osgi.ReferenceItem;
import org.eclipse.scada.configuration.world.osgi.RestExporter;
import org.eclipse.scada.configuration.world.osgi.Rounding;
import org.eclipse.scada.configuration.world.osgi.Scale;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;
import org.eclipse.scada.configuration.world.osgi.ScriptTimer;
import org.eclipse.scada.configuration.world.osgi.SimpleDataMapper;
import org.eclipse.scada.configuration.world.osgi.SimpleExternalEventFilter;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.configuration.world.osgi.StaticExternalEventFilter;
import org.eclipse.scada.configuration.world.osgi.SummaryGroup;
import org.eclipse.scada.configuration.world.osgi.SummaryItem;
import org.eclipse.scada.configuration.world.osgi.TransientItem;
import org.eclipse.scada.configuration.world.osgi.TypedItemReference;
import org.eclipse.scada.configuration.world.osgi.ValueArchive;
import org.eclipse.scada.configuration.world.osgi.ValueArchiveServer;
import org.eclipse.scada.configuration.world.osgi.ValueMapper;
import org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage
 * @generated
 */
public class OsgiAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static OsgiPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OsgiAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = OsgiPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the
     * model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OsgiSwitch<Adapter> modelSwitch = new OsgiSwitch<Adapter> ()
    {
        @Override
        public Adapter caseEquinoxApplication ( EquinoxApplication object )
        {
            return createEquinoxApplicationAdapter ();
        }

        @Override
        public Adapter caseConnection ( Connection object )
        {
            return createConnectionAdapter ();
        }

        @Override
        public Adapter caseExporter ( Exporter object )
        {
            return createExporterAdapter ();
        }

        @Override
        public Adapter caseDataAccessConnection ( DataAccessConnection object )
        {
            return createDataAccessConnectionAdapter ();
        }

        @Override
        public Adapter caseDataAccessExporter ( DataAccessExporter object )
        {
            return createDataAccessExporterAdapter ();
        }

        @Override
        public Adapter caseItem ( Item object )
        {
            return createItemAdapter ();
        }

        @Override
        public Adapter caseSourceItem ( SourceItem object )
        {
            return createSourceItemAdapter ();
        }

        @Override
        public Adapter caseItemExport ( ItemExport object )
        {
            return createItemExportAdapter ();
        }

        @Override
        public Adapter caseItemInformation ( ItemInformation object )
        {
            return createItemInformationAdapter ();
        }

        @Override
        public Adapter caseLevelMonitor ( LevelMonitor object )
        {
            return createLevelMonitorAdapter ();
        }

        @Override
        public Adapter caseItemFeatureEntry ( ItemFeatureEntry object )
        {
            return createItemFeatureEntryAdapter ();
        }

        @Override
        public Adapter caseScriptItem ( ScriptItem object )
        {
            return createScriptItemAdapter ();
        }

        @Override
        public Adapter caseImportItem ( ImportItem object )
        {
            return createImportItemAdapter ();
        }

        @Override
        public Adapter caseSummaryGroup ( SummaryGroup object )
        {
            return createSummaryGroupAdapter ();
        }

        @Override
        public Adapter caseMarkerGroup ( MarkerGroup object )
        {
            return createMarkerGroupAdapter ();
        }

        @Override
        public Adapter caseMarkers ( Markers object )
        {
            return createMarkersAdapter ();
        }

        @Override
        public Adapter caseConstantItem ( ConstantItem object )
        {
            return createConstantItemAdapter ();
        }

        @Override
        public Adapter caseSummaryItem ( SummaryItem object )
        {
            return createSummaryItemAdapter ();
        }

        @Override
        public Adapter caseMarkerEntry ( MarkerEntry object )
        {
            return createMarkerEntryAdapter ();
        }

        @Override
        public Adapter caseManualOverride ( ManualOverride object )
        {
            return createManualOverrideAdapter ();
        }

        @Override
        public Adapter caseMasterServer ( MasterServer object )
        {
            return createMasterServerAdapter ();
        }

        @Override
        public Adapter caseValueArchiveServer ( ValueArchiveServer object )
        {
            return createValueArchiveServerAdapter ();
        }

        @Override
        public Adapter caseDefaultMasterServer ( DefaultMasterServer object )
        {
            return createDefaultMasterServerAdapter ();
        }

        @Override
        public Adapter caseCustomMasterServer ( CustomMasterServer object )
        {
            return createCustomMasterServerAdapter ();
        }

        @Override
        public Adapter caseApplicationModule ( ApplicationModule object )
        {
            return createApplicationModuleAdapter ();
        }

        @Override
        public Adapter caseAttributesSummary ( AttributesSummary object )
        {
            return createAttributesSummaryAdapter ();
        }

        @Override
        public Adapter caseEventLogger ( EventLogger object )
        {
            return createEventLoggerAdapter ();
        }

        @Override
        public Adapter caseMonitorPool ( MonitorPool object )
        {
            return createMonitorPoolAdapter ();
        }

        @Override
        public Adapter caseEventPool ( EventPool object )
        {
            return createEventPoolAdapter ();
        }

        @Override
        public Adapter caseDataMapper ( DataMapper object )
        {
            return createDataMapperAdapter ();
        }

        @Override
        public Adapter caseSimpleDataMapper ( SimpleDataMapper object )
        {
            return createSimpleDataMapperAdapter ();
        }

        @Override
        public Adapter caseJdbcDataMapper ( JdbcDataMapper object )
        {
            return createJdbcDataMapperAdapter ();
        }

        @Override
        public Adapter caseDataMapperEntry ( DataMapperEntry object )
        {
            return createDataMapperEntryAdapter ();
        }

        @Override
        public Adapter caseValueMapper ( ValueMapper object )
        {
            return createValueMapperAdapter ();
        }

        @Override
        public Adapter casePersistentItem ( PersistentItem object )
        {
            return createPersistentItemAdapter ();
        }

        @Override
        public Adapter caseProxyItem ( ProxyItem object )
        {
            return createProxyItemAdapter ();
        }

        @Override
        public Adapter caseScale ( Scale object )
        {
            return createScaleAdapter ();
        }

        @Override
        public Adapter caseNegate ( Negate object )
        {
            return createNegateAdapter ();
        }

        @Override
        public Adapter caseRounding ( Rounding object )
        {
            return createRoundingAdapter ();
        }

        @Override
        public Adapter caseExternalEventMonitor ( ExternalEventMonitor object )
        {
            return createExternalEventMonitorAdapter ();
        }

        @Override
        public Adapter casePropertyEntry ( PropertyEntry object )
        {
            return createPropertyEntryAdapter ();
        }

        @Override
        public Adapter caseExternalEventFilter ( ExternalEventFilter object )
        {
            return createExternalEventFilterAdapter ();
        }

        @Override
        public Adapter caseStaticExternalEventFilter ( StaticExternalEventFilter object )
        {
            return createStaticExternalEventFilterAdapter ();
        }

        @Override
        public Adapter caseSimpleExternalEventFilter ( SimpleExternalEventFilter object )
        {
            return createSimpleExternalEventFilterAdapter ();
        }

        @Override
        public Adapter caseTypedItemReference ( TypedItemReference object )
        {
            return createTypedItemReferenceAdapter ();
        }

        @Override
        public Adapter caseCodeFragment ( CodeFragment object )
        {
            return createCodeFragmentAdapter ();
        }

        @Override
        public Adapter caseScriptTimer ( ScriptTimer object )
        {
            return createScriptTimerAdapter ();
        }

        @Override
        public Adapter caseItemReference ( ItemReference object )
        {
            return createItemReferenceAdapter ();
        }

        @Override
        public Adapter caseFormulaItem ( FormulaItem object )
        {
            return createFormulaItemAdapter ();
        }

        @Override
        public Adapter caseFormulaItemOutbound ( FormulaItemOutbound object )
        {
            return createFormulaItemOutboundAdapter ();
        }

        @Override
        public Adapter caseFormulaItemInbound ( FormulaItemInbound object )
        {
            return createFormulaItemInboundAdapter ();
        }

        @Override
        public Adapter caseBooleanMonitor ( BooleanMonitor object )
        {
            return createBooleanMonitorAdapter ();
        }

        @Override
        public Adapter caseListMonitor ( ListMonitor object )
        {
            return createListMonitorAdapter ();
        }

        @Override
        public Adapter caseListMonitorEntry ( ListMonitorEntry object )
        {
            return createListMonitorEntryAdapter ();
        }

        @Override
        public Adapter caseAverage ( Average object )
        {
            return createAverageAdapter ();
        }

        @Override
        public Adapter caseMovingAverage ( MovingAverage object )
        {
            return createMovingAverageAdapter ();
        }

        @Override
        public Adapter caseAverageItem ( AverageItem object )
        {
            return createAverageItemAdapter ();
        }

        @Override
        public Adapter caseMovingAverageItem ( MovingAverageItem object )
        {
            return createMovingAverageItemAdapter ();
        }

        @Override
        public Adapter caseBlockings ( Blockings object )
        {
            return createBlockingsAdapter ();
        }

        @Override
        public Adapter caseBlockGroup ( BlockGroup object )
        {
            return createBlockGroupAdapter ();
        }

        @Override
        public Adapter caseBlockHandler ( BlockHandler object )
        {
            return createBlockHandlerAdapter ();
        }

        @Override
        public Adapter caseBlock ( Block object )
        {
            return createBlockAdapter ();
        }

        @Override
        public Adapter caseGlobalSummaryItem ( GlobalSummaryItem object )
        {
            return createGlobalSummaryItemAdapter ();
        }

        @Override
        public Adapter caseWeakReferenceDataSourceItem ( WeakReferenceDataSourceItem object )
        {
            return createWeakReferenceDataSourceItemAdapter ();
        }

        @Override
        public Adapter caseAlarmsEventsExporter ( AlarmsEventsExporter object )
        {
            return createAlarmsEventsExporterAdapter ();
        }

        @Override
        public Adapter caseAlarmsEventsConnection ( AlarmsEventsConnection object )
        {
            return createAlarmsEventsConnectionAdapter ();
        }

        @Override
        public Adapter caseMonitorPoolProxy ( MonitorPoolProxy object )
        {
            return createMonitorPoolProxyAdapter ();
        }

        @Override
        public Adapter caseEventPoolProxy ( EventPoolProxy object )
        {
            return createEventPoolProxyAdapter ();
        }

        @Override
        public Adapter caseAlarmsEventsModule ( AlarmsEventsModule object )
        {
            return createAlarmsEventsModuleAdapter ();
        }

        @Override
        public Adapter caseAknProxy ( AknProxy object )
        {
            return createAknProxyAdapter ();
        }

        @Override
        public Adapter casePullEvents ( PullEvents object )
        {
            return createPullEventsAdapter ();
        }

        @Override
        public Adapter caseJdbcUserServiceModule ( JdbcUserServiceModule object )
        {
            return createJdbcUserServiceModuleAdapter ();
        }

        @Override
        public Adapter caseJdbcUserService ( JdbcUserService object )
        {
            return createJdbcUserServiceAdapter ();
        }

        @Override
        public Adapter caseDefaultValueArchiveServer ( DefaultValueArchiveServer object )
        {
            return createDefaultValueArchiveServerAdapter ();
        }

        @Override
        public Adapter caseHistoricalDataExporter ( HistoricalDataExporter object )
        {
            return createHistoricalDataExporterAdapter ();
        }

        @Override
        public Adapter caseValueArchive ( ValueArchive object )
        {
            return createValueArchiveAdapter ();
        }

        @Override
        public Adapter caseConfigurationAdministratorExporter ( ConfigurationAdministratorExporter object )
        {
            return createConfigurationAdministratorExporterAdapter ();
        }

        @Override
        public Adapter caseReferenceItem ( ReferenceItem object )
        {
            return createReferenceItemAdapter ();
        }

        @Override
        public Adapter caseEventStorage ( EventStorage object )
        {
            return createEventStorageAdapter ();
        }

        @Override
        public Adapter caseEventStorageJdbc ( EventStorageJdbc object )
        {
            return createEventStorageJdbcAdapter ();
        }

        @Override
        public Adapter caseEventStoragePostgres ( EventStoragePostgres object )
        {
            return createEventStoragePostgresAdapter ();
        }

        @Override
        public Adapter caseAbstractEventStorageJdbc ( AbstractEventStorageJdbc object )
        {
            return createAbstractEventStorageJdbcAdapter ();
        }

        @Override
        public Adapter caseApplicationConfiguration ( ApplicationConfiguration object )
        {
            return createApplicationConfigurationAdapter ();
        }

        @Override
        public Adapter caseRestExporter ( RestExporter object )
        {
            return createRestExporterAdapter ();
        }

        @Override
        public Adapter caseHttpService ( HttpService object )
        {
            return createHttpServiceAdapter ();
        }

        @Override
        public Adapter caseIndependentConfiguration ( IndependentConfiguration object )
        {
            return createIndependentConfigurationAdapter ();
        }

        @Override
        public Adapter caseTransientItem ( TransientItem object )
        {
            return createTransientItemAdapter ();
        }

        @Override
        public Adapter caseDefaultEquinoxApplication ( DefaultEquinoxApplication object )
        {
            return createDefaultEquinoxApplicationAdapter ();
        }

        @Override
        public Adapter caseChangeCounterItem ( ChangeCounterItem object )
        {
            return createChangeCounterItemAdapter ();
        }

        @Override
        public Adapter caseBufferedValue ( BufferedValue object )
        {
            return createBufferedValueAdapter ();
        }

        @Override
        public Adapter caseTelnetConsole ( TelnetConsole object )
        {
            return createTelnetConsoleAdapter ();
        }

        @Override
        public Adapter caseDocumentable ( Documentable object )
        {
            return createDocumentableAdapter ();
        }

        @Override
        public Adapter caseNamedDocumentable ( NamedDocumentable object )
        {
            return createNamedDocumentableAdapter ();
        }

        @Override
        public Adapter caseApplication ( Application object )
        {
            return createApplicationAdapter ();
        }

        @Override
        public Adapter defaultCase ( EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication <em>Equinox Application</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication
     * @generated
     */
    public Adapter createEquinoxApplicationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Connection
     * @generated
     */
    public Adapter createConnectionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.Exporter <em>Exporter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Exporter
     * @generated
     */
    public Adapter createExporterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.DataAccessConnection <em>Data Access Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.DataAccessConnection
     * @generated
     */
    public Adapter createDataAccessConnectionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.DataAccessExporter <em>Data Access Exporter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.DataAccessExporter
     * @generated
     */
    public Adapter createDataAccessExporterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Item
     * @generated
     */
    public Adapter createItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.SourceItem <em>Source Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.SourceItem
     * @generated
     */
    public Adapter createSourceItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ItemExport <em>Item Export</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ItemExport
     * @generated
     */
    public Adapter createItemExportAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ItemInformation <em>Item Information</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ItemInformation
     * @generated
     */
    public Adapter createItemInformationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor <em>Level Monitor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor
     * @generated
     */
    public Adapter createLevelMonitorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry <em>Item Feature Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry
     * @generated
     */
    public Adapter createItemFeatureEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem <em>Script Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptItem
     * @generated
     */
    public Adapter createScriptItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ImportItem <em>Import Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ImportItem
     * @generated
     */
    public Adapter createImportItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.SummaryGroup <em>Summary Group</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.SummaryGroup
     * @generated
     */
    public Adapter createSummaryGroupAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.MarkerGroup <em>Marker Group</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.MarkerGroup
     * @generated
     */
    public Adapter createMarkerGroupAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.Markers <em>Markers</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Markers
     * @generated
     */
    public Adapter createMarkersAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ConstantItem <em>Constant Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ConstantItem
     * @generated
     */
    public Adapter createConstantItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.SummaryItem <em>Summary Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.SummaryItem
     * @generated
     */
    public Adapter createSummaryItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.MarkerEntry <em>Marker Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.MarkerEntry
     * @generated
     */
    public Adapter createMarkerEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ManualOverride <em>Manual Override</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ManualOverride
     * @generated
     */
    public Adapter createManualOverrideAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.MasterServer <em>Master Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer
     * @generated
     */
    public Adapter createMasterServerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ValueArchiveServer <em>Value Archive Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ValueArchiveServer
     * @generated
     */
    public Adapter createValueArchiveServerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.DefaultMasterServer <em>Default Master Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.DefaultMasterServer
     * @generated
     */
    public Adapter createDefaultMasterServerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.CustomMasterServer <em>Custom Master Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.CustomMasterServer
     * @generated
     */
    public Adapter createCustomMasterServerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ApplicationModule <em>Application Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ApplicationModule
     * @generated
     */
    public Adapter createApplicationModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.AttributesSummary <em>Attributes Summary</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.AttributesSummary
     * @generated
     */
    public Adapter createAttributesSummaryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.EventLogger <em>Event Logger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.EventLogger
     * @generated
     */
    public Adapter createEventLoggerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.MonitorPool <em>Monitor Pool</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.MonitorPool
     * @generated
     */
    public Adapter createMonitorPoolAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.EventPool <em>Event Pool</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.EventPool
     * @generated
     */
    public Adapter createEventPoolAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.DataMapper <em>Data Mapper</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.DataMapper
     * @generated
     */
    public Adapter createDataMapperAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.SimpleDataMapper <em>Simple Data Mapper</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.SimpleDataMapper
     * @generated
     */
    public Adapter createSimpleDataMapperAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.JdbcDataMapper <em>Jdbc Data Mapper</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcDataMapper
     * @generated
     */
    public Adapter createJdbcDataMapperAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.DataMapperEntry <em>Data Mapper Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.DataMapperEntry
     * @generated
     */
    public Adapter createDataMapperEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ValueMapper <em>Value Mapper</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ValueMapper
     * @generated
     */
    public Adapter createValueMapperAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.PersistentItem <em>Persistent Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.PersistentItem
     * @generated
     */
    public Adapter createPersistentItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ProxyItem <em>Proxy Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ProxyItem
     * @generated
     */
    public Adapter createProxyItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.Scale <em>Scale</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Scale
     * @generated
     */
    public Adapter createScaleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.Negate <em>Negate</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Negate
     * @generated
     */
    public Adapter createNegateAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.Rounding <em>Rounding</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Rounding
     * @generated
     */
    public Adapter createRoundingAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor <em>External Event Monitor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor
     * @generated
     */
    public Adapter createExternalEventMonitorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.PropertyEntry <em>Property Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.PropertyEntry
     * @generated
     */
    public Adapter createPropertyEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ExternalEventFilter <em>External Event Filter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ExternalEventFilter
     * @generated
     */
    public Adapter createExternalEventFilterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.StaticExternalEventFilter <em>Static External Event Filter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.StaticExternalEventFilter
     * @generated
     */
    public Adapter createStaticExternalEventFilterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.SimpleExternalEventFilter <em>Simple External Event Filter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.SimpleExternalEventFilter
     * @generated
     */
    public Adapter createSimpleExternalEventFilterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.TypedItemReference <em>Typed Item Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.TypedItemReference
     * @generated
     */
    public Adapter createTypedItemReferenceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.CodeFragment <em>Code Fragment</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.CodeFragment
     * @generated
     */
    public Adapter createCodeFragmentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ScriptTimer <em>Script Timer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptTimer
     * @generated
     */
    public Adapter createScriptTimerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ItemReference <em>Item Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ItemReference
     * @generated
     */
    public Adapter createItemReferenceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.FormulaItem <em>Formula Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItem
     * @generated
     */
    public Adapter createFormulaItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound <em>Formula Item Outbound</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound
     * @generated
     */
    public Adapter createFormulaItemOutboundAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemInbound <em>Formula Item Inbound</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItemInbound
     * @generated
     */
    public Adapter createFormulaItemInboundAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor <em>Boolean Monitor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.BooleanMonitor
     * @generated
     */
    public Adapter createBooleanMonitorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor <em>List Monitor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitor
     * @generated
     */
    public Adapter createListMonitorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry <em>List Monitor Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitorEntry
     * @generated
     */
    public Adapter createListMonitorEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.Average <em>Average</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Average
     * @generated
     */
    public Adapter createAverageAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.MovingAverage <em>Moving Average</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverage
     * @generated
     */
    public Adapter createMovingAverageAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.AverageItem <em>Average Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.AverageItem
     * @generated
     */
    public Adapter createAverageItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.MovingAverageItem <em>Moving Average Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverageItem
     * @generated
     */
    public Adapter createMovingAverageItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.Blockings <em>Blockings</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Blockings
     * @generated
     */
    public Adapter createBlockingsAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.BlockGroup <em>Block Group</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.BlockGroup
     * @generated
     */
    public Adapter createBlockGroupAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.BlockHandler <em>Block Handler</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.BlockHandler
     * @generated
     */
    public Adapter createBlockHandlerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.Block <em>Block</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Block
     * @generated
     */
    public Adapter createBlockAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.GlobalSummaryItem <em>Global Summary Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.GlobalSummaryItem
     * @generated
     */
    public Adapter createGlobalSummaryItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem <em>Weak Reference Data Source Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem
     * @generated
     */
    public Adapter createWeakReferenceDataSourceItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsExporter <em>Alarms Events Exporter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsExporter
     * @generated
     */
    public Adapter createAlarmsEventsExporterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection <em>Alarms Events Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection
     * @generated
     */
    public Adapter createAlarmsEventsConnectionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy <em>Monitor Pool Proxy</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy
     * @generated
     */
    public Adapter createMonitorPoolProxyAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.EventPoolProxy <em>Event Pool Proxy</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.EventPoolProxy
     * @generated
     */
    public Adapter createEventPoolProxyAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule <em>Alarms Events Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule
     * @generated
     */
    public Adapter createAlarmsEventsModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.AknProxy <em>Akn Proxy</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.AknProxy
     * @generated
     */
    public Adapter createAknProxyAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.PullEvents <em>Pull Events</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.PullEvents
     * @generated
     */
    public Adapter createPullEventsAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserServiceModule <em>Jdbc User Service Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserServiceModule
     * @generated
     */
    public Adapter createJdbcUserServiceModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService <em>Jdbc User Service</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService
     * @generated
     */
    public Adapter createJdbcUserServiceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.DefaultValueArchiveServer <em>Default Value Archive Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.DefaultValueArchiveServer
     * @generated
     */
    public Adapter createDefaultValueArchiveServerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.HistoricalDataExporter <em>Historical Data Exporter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.HistoricalDataExporter
     * @generated
     */
    public Adapter createHistoricalDataExporterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ValueArchive <em>Value Archive</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ValueArchive
     * @generated
     */
    public Adapter createValueArchiveAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter <em>Configuration Administrator Exporter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter
     * @generated
     */
    public Adapter createConfigurationAdministratorExporterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ReferenceItem <em>Reference Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ReferenceItem
     * @generated
     */
    public Adapter createReferenceItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.EventStorage <em>Event Storage</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.EventStorage
     * @generated
     */
    public Adapter createEventStorageAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc <em>Event Storage Jdbc</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.EventStorageJdbc
     * @generated
     */
    public Adapter createEventStorageJdbcAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres <em>Event Storage Postgres</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.EventStoragePostgres
     * @generated
     */
    public Adapter createEventStoragePostgresAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc <em>Abstract Event Storage Jdbc</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc
     * @generated
     */
    public Adapter createAbstractEventStorageJdbcAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration <em>Application Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration
     * @generated
     */
    public Adapter createApplicationConfigurationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.RestExporter <em>Rest Exporter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.RestExporter
     * @generated
     */
    public Adapter createRestExporterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.HttpService <em>Http Service</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.HttpService
     * @generated
     */
    public Adapter createHttpServiceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.IndependentConfiguration <em>Independent Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.IndependentConfiguration
     * @generated
     */
    public Adapter createIndependentConfigurationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.TransientItem <em>Transient Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.TransientItem
     * @generated
     */
    public Adapter createTransientItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.DefaultEquinoxApplication <em>Default Equinox Application</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.DefaultEquinoxApplication
     * @generated
     */
    public Adapter createDefaultEquinoxApplicationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ChangeCounterItem <em>Change Counter Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ChangeCounterItem
     * @generated
     */
    public Adapter createChangeCounterItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.BufferedValue <em>Buffered Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.BufferedValue
     * @generated
     */
    public Adapter createBufferedValueAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.TelnetConsole <em>Telnet Console</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.TelnetConsole
     * @generated
     */
    public Adapter createTelnetConsoleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Documentable <em>Documentable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Documentable
     * @generated
     */
    public Adapter createDocumentableAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.NamedDocumentable <em>Named Documentable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.NamedDocumentable
     * @generated
     */
    public Adapter createNamedDocumentableAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Application <em>Application</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Application
     * @generated
     */
    public Adapter createApplicationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //OsgiAdapterFactory
