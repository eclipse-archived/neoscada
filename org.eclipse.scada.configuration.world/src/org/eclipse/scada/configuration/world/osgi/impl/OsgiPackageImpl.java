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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl;
import org.eclipse.scada.configuration.world.impl.WorldPackageImpl;
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
import org.eclipse.scada.configuration.world.osgi.AverageReferenceType;
import org.eclipse.scada.configuration.world.osgi.Block;
import org.eclipse.scada.configuration.world.osgi.BlockGroup;
import org.eclipse.scada.configuration.world.osgi.BlockHandler;
import org.eclipse.scada.configuration.world.osgi.Blockings;
import org.eclipse.scada.configuration.world.osgi.BooleanMonitor;
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.ConstantItem;
import org.eclipse.scada.configuration.world.osgi.CustomMasterServer;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.DataMapper;
import org.eclipse.scada.configuration.world.osgi.DataMapperEntry;
import org.eclipse.scada.configuration.world.osgi.DataType;
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
import org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType;
import org.eclipse.scada.configuration.world.osgi.Negate;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.PasswordType;
import org.eclipse.scada.configuration.world.osgi.PersistentItem;
import org.eclipse.scada.configuration.world.osgi.PropertyEntry;
import org.eclipse.scada.configuration.world.osgi.ProxyItem;
import org.eclipse.scada.configuration.world.osgi.PullEvents;
import org.eclipse.scada.configuration.world.osgi.ReferenceItem;
import org.eclipse.scada.configuration.world.osgi.RestExporter;
import org.eclipse.scada.configuration.world.osgi.Rounding;
import org.eclipse.scada.configuration.world.osgi.RoundingType;
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
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class OsgiPackageImpl extends EPackageImpl implements OsgiPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass equinoxApplicationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass connectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass exporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dataAccessConnectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dataAccessExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass itemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass sourceItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass itemExportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass itemInformationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass levelMonitorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass itemFeatureEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass scriptItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass importItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass summaryGroupEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass markerGroupEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass markersEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass constantItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass summaryItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass markerEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass manualOverrideEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass masterServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass valueArchiveServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass defaultMasterServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass customMasterServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass applicationModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass attributesSummaryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass eventLoggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass monitorPoolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass eventPoolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dataMapperEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass simpleDataMapperEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass jdbcDataMapperEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dataMapperEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass valueMapperEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass persistentItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass proxyItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass scaleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass negateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass roundingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass externalEventMonitorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass propertyEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass externalEventFilterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass staticExternalEventFilterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass simpleExternalEventFilterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass typedItemReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass codeFragmentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass scriptTimerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass itemReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass formulaItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass formulaItemOutboundEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass formulaItemInboundEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass booleanMonitorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass listMonitorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass listMonitorEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass averageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass movingAverageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass averageItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass movingAverageItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass blockingsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass blockGroupEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass blockHandlerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass blockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass globalSummaryItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass weakReferenceDataSourceItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass alarmsEventsExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass alarmsEventsConnectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass monitorPoolProxyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass eventPoolProxyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass alarmsEventsModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass aknProxyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass pullEventsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass jdbcUserServiceModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass jdbcUserServiceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass defaultValueArchiveServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass historicalDataExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass valueArchiveEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass configurationAdministratorExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass referenceItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass eventStorageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass eventStorageJdbcEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass eventStoragePostgresEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass abstractEventStorageJdbcEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass applicationConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass restExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass httpServiceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass independentConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass transientItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass defaultEquinoxApplicationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum averageReferenceTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum movingAverageReferenceTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum roundingTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum dataTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum passwordTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType severityEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType variantEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package
     * package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private OsgiPackageImpl ()
    {
        super ( eNS_URI, OsgiFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link OsgiPackage#eINSTANCE} when that
     * field is accessed. Clients should not invoke it directly. Instead, they
     * should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static OsgiPackage init ()
    {
        if ( isInited )
        {
            return (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        }

        // Obtain or create and register package
        final OsgiPackageImpl theOsgiPackage = (OsgiPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof OsgiPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new OsgiPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        ConfigurationPackage.eINSTANCE.eClass ();
        SecurityPackage.eINSTANCE.eClass ();

        // Obtain or create and register interdependencies
        final WorldPackageImpl theWorldPackage = (WorldPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) instanceof WorldPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) : WorldPackage.eINSTANCE );
        final ProfilePackageImpl theProfilePackage = (ProfilePackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) instanceof ProfilePackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) : ProfilePackage.eINSTANCE );
        final DeploymentPackageImpl theDeploymentPackage = (DeploymentPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI ) instanceof DeploymentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI ) : DeploymentPackage.eINSTANCE );

        // Create package meta-data objects
        theOsgiPackage.createPackageContents ();
        theWorldPackage.createPackageContents ();
        theProfilePackage.createPackageContents ();
        theDeploymentPackage.createPackageContents ();

        // Initialize created meta-data
        theOsgiPackage.initializePackageContents ();
        theWorldPackage.initializePackageContents ();
        theProfilePackage.initializePackageContents ();
        theDeploymentPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theOsgiPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( OsgiPackage.eNS_URI, theOsgiPackage );
        return theOsgiPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEquinoxApplication ()
    {
        return this.equinoxApplicationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_Connections ()
    {
        return (EReference)this.equinoxApplicationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_Exporter ()
    {
        return (EReference)this.equinoxApplicationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_CustomizationProfile ()
    {
        return (EReference)this.equinoxApplicationEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_SecurityConfiguration ()
    {
        return (EReference)this.equinoxApplicationEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_Modules ()
    {
        return (EReference)this.equinoxApplicationEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getEquinoxApplication__GetProfile ()
    {
        return this.equinoxApplicationEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConnection ()
    {
        return this.connectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConnection_Endpoint ()
    {
        return (EReference)this.connectionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConnection_EndpointLabel ()
    {
        return (EAttribute)this.connectionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConnection_Credentials ()
    {
        return (EReference)this.connectionEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConnection_Timeout ()
    {
        return (EAttribute)this.connectionEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getConnection__GetTypeTag ()
    {
        return this.connectionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getConnection__GetPossibleEndpoints__Exporter ()
    {
        return this.connectionEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getConnection__MakeUri__boolean ()
    {
        return this.connectionEClass.getEOperations ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getConnection__GetMatchingEndpoint__Exporter ()
    {
        return this.connectionEClass.getEOperations ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExporter ()
    {
        return this.exporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExporter_Endpoints ()
    {
        return (EReference)this.exporterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getExporter__GetTypeTag ()
    {
        return this.exporterEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDataAccessConnection ()
    {
        return this.dataAccessConnectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getDataAccessConnection__GetTypeTag ()
    {
        return this.dataAccessConnectionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getDataAccessConnection__MakeUri__boolean ()
    {
        return this.dataAccessConnectionEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDataAccessExporter ()
    {
        return this.dataAccessExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDataAccessExporter_Exports ()
    {
        return (EReference)this.dataAccessExporterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getDataAccessExporter__GetTypeTag ()
    {
        return this.dataAccessExporterEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getItem ()
    {
        return this.itemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItem_Name ()
    {
        return (EAttribute)this.itemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getItem_Information ()
    {
        return (EReference)this.itemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getItem_ItemFeatures ()
    {
        return (EReference)this.itemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSourceItem ()
    {
        return this.sourceItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSourceItem_Connection ()
    {
        return (EReference)this.sourceItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSourceItem_SourceName ()
    {
        return (EAttribute)this.sourceItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getItemExport ()
    {
        return this.itemExportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getItemExport_Item ()
    {
        return (EReference)this.itemExportEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItemExport_ExportName ()
    {
        return (EAttribute)this.itemExportEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getItemInformation ()
    {
        return this.itemInformationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItemInformation_Description ()
    {
        return (EAttribute)this.itemInformationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItemInformation_Unit ()
    {
        return (EAttribute)this.itemInformationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItemInformation_Hierarchy ()
    {
        return (EAttribute)this.itemInformationEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItemInformation_System ()
    {
        return (EAttribute)this.itemInformationEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItemInformation_DataType ()
    {
        return (EAttribute)this.itemInformationEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getLevelMonitor ()
    {
        return this.levelMonitorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_Preset ()
    {
        return (EAttribute)this.levelMonitorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_Cap ()
    {
        return (EAttribute)this.levelMonitorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_Severity ()
    {
        return (EAttribute)this.levelMonitorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_LowerOk ()
    {
        return (EAttribute)this.levelMonitorEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_IncludedOk ()
    {
        return (EAttribute)this.levelMonitorEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_Prefix ()
    {
        return (EAttribute)this.levelMonitorEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_DemotePrefix ()
    {
        return (EAttribute)this.levelMonitorEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_SuppressEvents ()
    {
        return (EAttribute)this.levelMonitorEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_RequireAck ()
    {
        return (EAttribute)this.levelMonitorEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_MonitorType ()
    {
        return (EAttribute)this.levelMonitorEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getItemFeatureEntry ()
    {
        return this.itemFeatureEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItemFeatureEntry_Name ()
    {
        return (EAttribute)this.itemFeatureEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getItemFeatureEntry_Item ()
    {
        return (EReference)this.itemFeatureEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getScriptItem ()
    {
        return this.scriptItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getScriptItem_Inputs ()
    {
        return (EReference)this.scriptItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getScriptItem_InitScript ()
    {
        return (EReference)this.scriptItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getScriptItem_UpdateScript ()
    {
        return (EReference)this.scriptItemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getScriptItem_Timer ()
    {
        return (EReference)this.scriptItemEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getScriptItem_ScriptEngine ()
    {
        return (EAttribute)this.scriptItemEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getScriptItem_Commands ()
    {
        return (EReference)this.scriptItemEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getScriptItem_WriteCommandScript ()
    {
        return (EReference)this.scriptItemEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getImportItem ()
    {
        return this.importItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getImportItem_Export ()
    {
        return (EReference)this.importItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSummaryGroup ()
    {
        return this.summaryGroupEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSummaryGroup_Name ()
    {
        return (EAttribute)this.summaryGroupEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSummaryGroup_SubGroups ()
    {
        return (EReference)this.summaryGroupEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSummaryGroup_Items ()
    {
        return (EReference)this.summaryGroupEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMarkerGroup ()
    {
        return this.markerGroupEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMarkerGroup_Name ()
    {
        return (EAttribute)this.markerGroupEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMarkerGroup_Markers ()
    {
        return (EReference)this.markerGroupEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMarkers ()
    {
        return this.markersEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMarkers_MarkerGroups ()
    {
        return (EReference)this.markersEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConstantItem ()
    {
        return this.constantItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConstantItem_Value ()
    {
        return (EAttribute)this.constantItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSummaryItem ()
    {
        return this.summaryItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSummaryItem_Group ()
    {
        return (EReference)this.summaryItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMarkerEntry ()
    {
        return this.markerEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMarkerEntry_Name ()
    {
        return (EAttribute)this.markerEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMarkerEntry_Value ()
    {
        return (EAttribute)this.markerEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getManualOverride ()
    {
        return this.manualOverrideEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getManualOverride_InitialValue ()
    {
        return (EAttribute)this.manualOverrideEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMasterServer ()
    {
        return this.masterServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterServer_SummaryGroups ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterServer_Items ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterServer_Markers ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMasterServer_AeServerInformationPrefix ()
    {
        return (EAttribute)this.masterServerEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterServer_MonitorPools ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterServer_EventPools ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterServer_DataMapper ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterServer_ExternalEventMonitors ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterServer_ExternalEventFilters ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterServer_Averages ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterServer_MovingAverages ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 10 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getValueArchiveServer ()
    {
        return this.valueArchiveServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getValueArchiveServer_Archives ()
    {
        return (EReference)this.valueArchiveServerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDefaultMasterServer ()
    {
        return this.defaultMasterServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getCustomMasterServer ()
    {
        return this.customMasterServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCustomMasterServer_Profile ()
    {
        return (EReference)this.customMasterServerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getApplicationModule ()
    {
        return this.applicationModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAttributesSummary ()
    {
        return this.attributesSummaryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAttributesSummary_Attributes ()
    {
        return (EAttribute)this.attributesSummaryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAttributesSummary_OutputPrefix ()
    {
        return (EAttribute)this.attributesSummaryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEventLogger ()
    {
        return this.eventLoggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventLogger_LogAttributesChange ()
    {
        return (EAttribute)this.eventLoggerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventLogger_LogValueChange ()
    {
        return (EAttribute)this.eventLoggerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventLogger_LogSubscriptionChange ()
    {
        return (EAttribute)this.eventLoggerEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventLogger_LogWrites ()
    {
        return (EAttribute)this.eventLoggerEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMonitorPool ()
    {
        return this.monitorPoolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitorPool_Filter ()
    {
        return (EAttribute)this.monitorPoolEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEventPool ()
    {
        return this.eventPoolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventPool_Filter ()
    {
        return (EAttribute)this.eventPoolEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventPool_Size ()
    {
        return (EAttribute)this.eventPoolEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDataMapper ()
    {
        return this.dataMapperEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSimpleDataMapper ()
    {
        return this.simpleDataMapperEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSimpleDataMapper_Entries ()
    {
        return (EReference)this.simpleDataMapperEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getJdbcDataMapper ()
    {
        return this.jdbcDataMapperEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJdbcDataMapper_JdbcDriver ()
    {
        return (EAttribute)this.jdbcDataMapperEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJdbcDataMapper_Sql ()
    {
        return (EAttribute)this.jdbcDataMapperEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getJdbcDataMapper_Properties ()
    {
        return (EReference)this.jdbcDataMapperEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDataMapperEntry ()
    {
        return this.dataMapperEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDataMapperEntry_Key ()
    {
        return (EAttribute)this.dataMapperEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDataMapperEntry_Value ()
    {
        return (EAttribute)this.dataMapperEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getValueMapper ()
    {
        return this.valueMapperEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getValueMapper_SourceAttribute ()
    {
        return (EAttribute)this.valueMapperEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getValueMapper_TargetAttribute ()
    {
        return (EAttribute)this.valueMapperEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getValueMapper_DataMapper ()
    {
        return (EReference)this.valueMapperEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPersistentItem ()
    {
        return this.persistentItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getProxyItem ()
    {
        return this.proxyItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProxyItem_Items ()
    {
        return (EReference)this.proxyItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getScale ()
    {
        return this.scaleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getScale_Active ()
    {
        return (EAttribute)this.scaleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getScale_Factor ()
    {
        return (EAttribute)this.scaleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getScale_Offset ()
    {
        return (EAttribute)this.scaleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getNegate ()
    {
        return this.negateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getNegate_Active ()
    {
        return (EAttribute)this.negateEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getRounding ()
    {
        return this.roundingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRounding_Type ()
    {
        return (EAttribute)this.roundingEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExternalEventMonitor ()
    {
        return this.externalEventMonitorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExternalEventMonitor_Filter ()
    {
        return (EAttribute)this.externalEventMonitorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExternalEventMonitor_Properties ()
    {
        return (EReference)this.externalEventMonitorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPropertyEntry ()
    {
        return this.propertyEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPropertyEntry_Key ()
    {
        return (EAttribute)this.propertyEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPropertyEntry_Value ()
    {
        return (EAttribute)this.propertyEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExternalEventFilter ()
    {
        return this.externalEventFilterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getStaticExternalEventFilter ()
    {
        return this.staticExternalEventFilterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getStaticExternalEventFilter_Value ()
    {
        return (EAttribute)this.staticExternalEventFilterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSimpleExternalEventFilter ()
    {
        return this.simpleExternalEventFilterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSimpleExternalEventFilter_Filter ()
    {
        return (EAttribute)this.simpleExternalEventFilterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getTypedItemReference ()
    {
        return this.typedItemReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTypedItemReference_Type ()
    {
        return (EAttribute)this.typedItemReferenceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getCodeFragment ()
    {
        return this.codeFragmentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getCodeFragment_Code ()
    {
        return (EAttribute)this.codeFragmentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getScriptTimer ()
    {
        return this.scriptTimerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getScriptTimer_Script ()
    {
        return (EReference)this.scriptTimerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getScriptTimer_Period ()
    {
        return (EAttribute)this.scriptTimerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getItemReference ()
    {
        return this.itemReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getItemReference_Item ()
    {
        return (EReference)this.itemReferenceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItemReference_Name ()
    {
        return (EAttribute)this.itemReferenceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFormulaItem ()
    {
        return this.formulaItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFormulaItem_ScriptEngine ()
    {
        return (EAttribute)this.formulaItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFormulaItem_InitScripts ()
    {
        return (EReference)this.formulaItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFormulaItem_Outbound ()
    {
        return (EReference)this.formulaItemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFormulaItem_Inbound ()
    {
        return (EReference)this.formulaItemEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFormulaItemOutbound ()
    {
        return this.formulaItemOutboundEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFormulaItemOutbound_Output ()
    {
        return (EReference)this.formulaItemOutboundEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFormulaItemOutbound_OutputFormula ()
    {
        return (EAttribute)this.formulaItemOutboundEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFormulaItemOutbound_WriteValueVariableName ()
    {
        return (EAttribute)this.formulaItemOutboundEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFormulaItemInbound ()
    {
        return this.formulaItemInboundEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFormulaItemInbound_Inputs ()
    {
        return (EReference)this.formulaItemInboundEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFormulaItemInbound_InputFormula ()
    {
        return (EAttribute)this.formulaItemInboundEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getBooleanMonitor ()
    {
        return this.booleanMonitorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_ReferenceValue ()
    {
        return (EAttribute)this.booleanMonitorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_Active ()
    {
        return (EAttribute)this.booleanMonitorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_DemotePrefix ()
    {
        return (EAttribute)this.booleanMonitorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_Severity ()
    {
        return (EAttribute)this.booleanMonitorEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_Message ()
    {
        return (EAttribute)this.booleanMonitorEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_SuppressEvents ()
    {
        return (EAttribute)this.booleanMonitorEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_RequireAck ()
    {
        return (EAttribute)this.booleanMonitorEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getListMonitor ()
    {
        return this.listMonitorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getListMonitor_Message ()
    {
        return (EAttribute)this.listMonitorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getListMonitor_MessageAttribute ()
    {
        return (EAttribute)this.listMonitorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getListMonitor_DefaultAck ()
    {
        return (EAttribute)this.listMonitorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getListMonitor_DefaultSeverity ()
    {
        return (EAttribute)this.listMonitorEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getListMonitor_MonitorType ()
    {
        return (EAttribute)this.listMonitorEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getListMonitor_DemotePrefix ()
    {
        return (EAttribute)this.listMonitorEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getListMonitor_Entries ()
    {
        return (EReference)this.listMonitorEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getListMonitorEntry ()
    {
        return this.listMonitorEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getListMonitorEntry_Value ()
    {
        return (EAttribute)this.listMonitorEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getListMonitorEntry_RequireAck ()
    {
        return (EAttribute)this.listMonitorEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getListMonitorEntry_Severity ()
    {
        return (EAttribute)this.listMonitorEntryEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAverage ()
    {
        return this.averageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAverage_Items ()
    {
        return (EReference)this.averageEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAverage_SourcesRequired ()
    {
        return (EAttribute)this.averageEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMovingAverage ()
    {
        return this.movingAverageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMovingAverage_Item ()
    {
        return (EReference)this.movingAverageEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMovingAverage_Range ()
    {
        return (EAttribute)this.movingAverageEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMovingAverage_NullRange ()
    {
        return (EAttribute)this.movingAverageEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMovingAverage_Trigger ()
    {
        return (EAttribute)this.movingAverageEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMovingAverage_TriggerOnly ()
    {
        return (EAttribute)this.movingAverageEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAverageItem ()
    {
        return this.averageItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAverageItem_Source ()
    {
        return (EReference)this.averageItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAverageItem_Type ()
    {
        return (EAttribute)this.averageItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMovingAverageItem ()
    {
        return this.movingAverageItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMovingAverageItem_Source ()
    {
        return (EReference)this.movingAverageItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMovingAverageItem_Type ()
    {
        return (EAttribute)this.movingAverageItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getBlockings ()
    {
        return this.blockingsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getBlockings_Groups ()
    {
        return (EReference)this.blockingsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getBlockGroup ()
    {
        return this.blockGroupEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getBlockGroup_Handlers ()
    {
        return (EReference)this.blockGroupEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBlockGroup_Hierarchy ()
    {
        return (EAttribute)this.blockGroupEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getBlockHandler ()
    {
        return this.blockHandlerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getBlockHandler_Group ()
    {
        return (EReference)this.blockHandlerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getBlock ()
    {
        return this.blockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getGlobalSummaryItem ()
    {
        return this.globalSummaryItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGlobalSummaryItem_Attribute ()
    {
        return (EAttribute)this.globalSummaryItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getWeakReferenceDataSourceItem ()
    {
        return this.weakReferenceDataSourceItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWeakReferenceDataSourceItem_DataSourceId ()
    {
        return (EAttribute)this.weakReferenceDataSourceItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAlarmsEventsExporter ()
    {
        return this.alarmsEventsExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getAlarmsEventsExporter__GetTypeTag ()
    {
        return this.alarmsEventsExporterEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAlarmsEventsConnection ()
    {
        return this.alarmsEventsConnectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getAlarmsEventsConnection__GetTypeTag ()
    {
        return this.alarmsEventsConnectionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getAlarmsEventsConnection__MakeUri__boolean ()
    {
        return this.alarmsEventsConnectionEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMonitorPoolProxy ()
    {
        return this.monitorPoolProxyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMonitorPoolProxy_Local ()
    {
        return (EReference)this.monitorPoolProxyEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMonitorPoolProxy_Remote ()
    {
        return (EReference)this.monitorPoolProxyEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEventPoolProxy ()
    {
        return this.eventPoolProxyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEventPoolProxy_Local ()
    {
        return (EReference)this.eventPoolProxyEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEventPoolProxy_Remote ()
    {
        return (EReference)this.eventPoolProxyEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventPoolProxy_Size ()
    {
        return (EAttribute)this.eventPoolProxyEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAlarmsEventsModule ()
    {
        return this.alarmsEventsModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAlarmsEventsModule_MonitorPoolProxies ()
    {
        return (EReference)this.alarmsEventsModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAlarmsEventsModule_EventPoolProxies ()
    {
        return (EReference)this.alarmsEventsModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAlarmsEventsModule_AknProxies ()
    {
        return (EReference)this.alarmsEventsModuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAlarmsEventsModule_PullEvents ()
    {
        return (EReference)this.alarmsEventsModuleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAknProxy ()
    {
        return this.aknProxyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAknProxy_Pattern ()
    {
        return (EAttribute)this.aknProxyEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAknProxy_Connection ()
    {
        return (EReference)this.aknProxyEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAknProxy_Priority ()
    {
        return (EAttribute)this.aknProxyEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAknProxy_Authorative ()
    {
        return (EAttribute)this.aknProxyEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPullEvents ()
    {
        return this.pullEventsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPullEvents_JdbcDriverName ()
    {
        return (EAttribute)this.pullEventsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getPullEvents_JdbcProperties ()
    {
        return (EReference)this.pullEventsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPullEvents_JobInterval ()
    {
        return (EAttribute)this.pullEventsEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPullEvents_CustomSelectSql ()
    {
        return (EAttribute)this.pullEventsEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPullEvents_CustomDeleteSql ()
    {
        return (EAttribute)this.pullEventsEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getJdbcUserServiceModule ()
    {
        return this.jdbcUserServiceModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getJdbcUserServiceModule_UserServices ()
    {
        return (EReference)this.jdbcUserServiceModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getJdbcUserService ()
    {
        return this.jdbcUserServiceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getJdbcUserService_JdbcPropeties ()
    {
        return (EReference)this.jdbcUserServiceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_JdbcDriver ()
    {
        return (EAttribute)this.jdbcUserServiceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_Authorative ()
    {
        return (EAttribute)this.jdbcUserServiceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_FindUserSql ()
    {
        return (EAttribute)this.jdbcUserServiceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_FindRolesForUserSql ()
    {
        return (EAttribute)this.jdbcUserServiceEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_UpdatePasswordSql ()
    {
        return (EAttribute)this.jdbcUserServiceEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_UserIdColumnName ()
    {
        return (EAttribute)this.jdbcUserServiceEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_PasswordColumnName ()
    {
        return (EAttribute)this.jdbcUserServiceEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_PasswordType ()
    {
        return (EAttribute)this.jdbcUserServiceEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDefaultValueArchiveServer ()
    {
        return this.defaultValueArchiveServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getHistoricalDataExporter ()
    {
        return this.historicalDataExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getHistoricalDataExporter__GetTypeTag ()
    {
        return this.historicalDataExporterEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getValueArchive ()
    {
        return this.valueArchiveEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getValueArchive_Items ()
    {
        return (EReference)this.valueArchiveEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConfigurationAdministratorExporter ()
    {
        return this.configurationAdministratorExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getConfigurationAdministratorExporter__GetTypeTag ()
    {
        return this.configurationAdministratorExporterEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getReferenceItem ()
    {
        return this.referenceItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getReferenceItem_Source ()
    {
        return (EReference)this.referenceItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEventStorage ()
    {
        return this.eventStorageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEventStorageJdbc ()
    {
        return this.eventStorageJdbcEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventStorageJdbc_JdbcDriverName ()
    {
        return (EAttribute)this.eventStorageJdbcEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventStorageJdbc_DriverBundles ()
    {
        return (EAttribute)this.eventStorageJdbcEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventStorageJdbc_MaxFieldLength ()
    {
        return (EAttribute)this.eventStorageJdbcEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventStorageJdbc_QueryFetchSize ()
    {
        return (EAttribute)this.eventStorageJdbcEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEventStoragePostgres ()
    {
        return this.eventStoragePostgresEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventStoragePostgres_BatchSize ()
    {
        return (EAttribute)this.eventStoragePostgresEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventStoragePostgres_PostgresDriverBundles ()
    {
        return (EAttribute)this.eventStoragePostgresEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getEventStoragePostgres__GetJdbcDriverName ()
    {
        return this.eventStoragePostgresEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getEventStoragePostgres__GetDriverBundles ()
    {
        return this.eventStoragePostgresEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAbstractEventStorageJdbc ()
    {
        return this.abstractEventStorageJdbcEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractEventStorageJdbc_JdbcProperties ()
    {
        return (EReference)this.abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractEventStorageJdbc_Schema ()
    {
        return (EAttribute)this.abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractEventStorageJdbc_InstanceName ()
    {
        return (EAttribute)this.abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractEventStorageJdbc_EnableReplication ()
    {
        return (EAttribute)this.abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractEventStorageJdbc_ArchiveDays ()
    {
        return (EAttribute)this.abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractEventStorageJdbc_CleanupPeriodSeconds ()
    {
        return (EAttribute)this.abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getAbstractEventStorageJdbc__GetJdbcDriverName ()
    {
        return this.abstractEventStorageJdbcEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getAbstractEventStorageJdbc__GetDriverBundles ()
    {
        return this.abstractEventStorageJdbcEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getApplicationConfiguration ()
    {
        return this.applicationConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getRestExporter ()
    {
        return this.restExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getRestExporter_Items ()
    {
        return (EReference)this.restExporterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getRestExporter_HiveProperties ()
    {
        return (EReference)this.restExporterEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRestExporter_ContextId ()
    {
        return (EAttribute)this.restExporterEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getHttpService ()
    {
        return this.httpServiceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getHttpService_Endpoint ()
    {
        return (EReference)this.httpServiceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getIndependentConfiguration ()
    {
        return this.independentConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getTransientItem ()
    {
        return this.transientItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDefaultEquinoxApplication ()
    {
        return this.defaultEquinoxApplicationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDefaultEquinoxApplication_Profile ()
    {
        return (EReference)this.defaultEquinoxApplicationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getAverageReferenceType ()
    {
        return this.averageReferenceTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getMovingAverageReferenceType ()
    {
        return this.movingAverageReferenceTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getRoundingType ()
    {
        return this.roundingTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getDataType ()
    {
        return this.dataTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getPasswordType ()
    {
        return this.passwordTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getSeverity ()
    {
        return this.severityEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getVariant ()
    {
        return this.variantEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMarkerGroup_Items ()
    {
        return (EReference)this.markerGroupEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OsgiFactory getOsgiFactory ()
    {
        return (OsgiFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents ()
    {
        if ( this.isCreated )
        {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.equinoxApplicationEClass = createEClass ( EQUINOX_APPLICATION );
        createEReference ( this.equinoxApplicationEClass, EQUINOX_APPLICATION__CONNECTIONS );
        createEReference ( this.equinoxApplicationEClass, EQUINOX_APPLICATION__EXPORTER );
        createEReference ( this.equinoxApplicationEClass, EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE );
        createEReference ( this.equinoxApplicationEClass, EQUINOX_APPLICATION__SECURITY_CONFIGURATION );
        createEReference ( this.equinoxApplicationEClass, EQUINOX_APPLICATION__MODULES );
        createEOperation ( this.equinoxApplicationEClass, EQUINOX_APPLICATION___GET_PROFILE );

        this.connectionEClass = createEClass ( CONNECTION );
        createEReference ( this.connectionEClass, CONNECTION__ENDPOINT );
        createEAttribute ( this.connectionEClass, CONNECTION__ENDPOINT_LABEL );
        createEReference ( this.connectionEClass, CONNECTION__CREDENTIALS );
        createEAttribute ( this.connectionEClass, CONNECTION__TIMEOUT );
        createEOperation ( this.connectionEClass, CONNECTION___GET_TYPE_TAG );
        createEOperation ( this.connectionEClass, CONNECTION___GET_POSSIBLE_ENDPOINTS__EXPORTER );
        createEOperation ( this.connectionEClass, CONNECTION___MAKE_URI__BOOLEAN );
        createEOperation ( this.connectionEClass, CONNECTION___GET_MATCHING_ENDPOINT__EXPORTER );

        this.exporterEClass = createEClass ( EXPORTER );
        createEReference ( this.exporterEClass, EXPORTER__ENDPOINTS );
        createEOperation ( this.exporterEClass, EXPORTER___GET_TYPE_TAG );

        this.dataAccessConnectionEClass = createEClass ( DATA_ACCESS_CONNECTION );
        createEOperation ( this.dataAccessConnectionEClass, DATA_ACCESS_CONNECTION___GET_TYPE_TAG );
        createEOperation ( this.dataAccessConnectionEClass, DATA_ACCESS_CONNECTION___MAKE_URI__BOOLEAN );

        this.dataAccessExporterEClass = createEClass ( DATA_ACCESS_EXPORTER );
        createEReference ( this.dataAccessExporterEClass, DATA_ACCESS_EXPORTER__EXPORTS );
        createEOperation ( this.dataAccessExporterEClass, DATA_ACCESS_EXPORTER___GET_TYPE_TAG );

        this.itemEClass = createEClass ( ITEM );
        createEAttribute ( this.itemEClass, ITEM__NAME );
        createEReference ( this.itemEClass, ITEM__INFORMATION );
        createEReference ( this.itemEClass, ITEM__ITEM_FEATURES );

        this.sourceItemEClass = createEClass ( SOURCE_ITEM );
        createEReference ( this.sourceItemEClass, SOURCE_ITEM__CONNECTION );
        createEAttribute ( this.sourceItemEClass, SOURCE_ITEM__SOURCE_NAME );

        this.itemExportEClass = createEClass ( ITEM_EXPORT );
        createEReference ( this.itemExportEClass, ITEM_EXPORT__ITEM );
        createEAttribute ( this.itemExportEClass, ITEM_EXPORT__EXPORT_NAME );

        this.itemInformationEClass = createEClass ( ITEM_INFORMATION );
        createEAttribute ( this.itemInformationEClass, ITEM_INFORMATION__DESCRIPTION );
        createEAttribute ( this.itemInformationEClass, ITEM_INFORMATION__UNIT );
        createEAttribute ( this.itemInformationEClass, ITEM_INFORMATION__HIERARCHY );
        createEAttribute ( this.itemInformationEClass, ITEM_INFORMATION__SYSTEM );
        createEAttribute ( this.itemInformationEClass, ITEM_INFORMATION__DATA_TYPE );

        this.levelMonitorEClass = createEClass ( LEVEL_MONITOR );
        createEAttribute ( this.levelMonitorEClass, LEVEL_MONITOR__PRESET );
        createEAttribute ( this.levelMonitorEClass, LEVEL_MONITOR__CAP );
        createEAttribute ( this.levelMonitorEClass, LEVEL_MONITOR__SEVERITY );
        createEAttribute ( this.levelMonitorEClass, LEVEL_MONITOR__LOWER_OK );
        createEAttribute ( this.levelMonitorEClass, LEVEL_MONITOR__INCLUDED_OK );
        createEAttribute ( this.levelMonitorEClass, LEVEL_MONITOR__PREFIX );
        createEAttribute ( this.levelMonitorEClass, LEVEL_MONITOR__DEMOTE_PREFIX );
        createEAttribute ( this.levelMonitorEClass, LEVEL_MONITOR__SUPPRESS_EVENTS );
        createEAttribute ( this.levelMonitorEClass, LEVEL_MONITOR__REQUIRE_ACK );
        createEAttribute ( this.levelMonitorEClass, LEVEL_MONITOR__MONITOR_TYPE );

        this.itemFeatureEntryEClass = createEClass ( ITEM_FEATURE_ENTRY );
        createEAttribute ( this.itemFeatureEntryEClass, ITEM_FEATURE_ENTRY__NAME );
        createEReference ( this.itemFeatureEntryEClass, ITEM_FEATURE_ENTRY__ITEM );

        this.scriptItemEClass = createEClass ( SCRIPT_ITEM );
        createEReference ( this.scriptItemEClass, SCRIPT_ITEM__INPUTS );
        createEReference ( this.scriptItemEClass, SCRIPT_ITEM__INIT_SCRIPT );
        createEReference ( this.scriptItemEClass, SCRIPT_ITEM__UPDATE_SCRIPT );
        createEReference ( this.scriptItemEClass, SCRIPT_ITEM__TIMER );
        createEAttribute ( this.scriptItemEClass, SCRIPT_ITEM__SCRIPT_ENGINE );
        createEReference ( this.scriptItemEClass, SCRIPT_ITEM__COMMANDS );
        createEReference ( this.scriptItemEClass, SCRIPT_ITEM__WRITE_COMMAND_SCRIPT );

        this.importItemEClass = createEClass ( IMPORT_ITEM );
        createEReference ( this.importItemEClass, IMPORT_ITEM__EXPORT );

        this.summaryGroupEClass = createEClass ( SUMMARY_GROUP );
        createEAttribute ( this.summaryGroupEClass, SUMMARY_GROUP__NAME );
        createEReference ( this.summaryGroupEClass, SUMMARY_GROUP__SUB_GROUPS );
        createEReference ( this.summaryGroupEClass, SUMMARY_GROUP__ITEMS );

        this.markerGroupEClass = createEClass ( MARKER_GROUP );
        createEReference ( this.markerGroupEClass, MARKER_GROUP__ITEMS );
        createEAttribute ( this.markerGroupEClass, MARKER_GROUP__NAME );
        createEReference ( this.markerGroupEClass, MARKER_GROUP__MARKERS );

        this.markersEClass = createEClass ( MARKERS );
        createEReference ( this.markersEClass, MARKERS__MARKER_GROUPS );

        this.constantItemEClass = createEClass ( CONSTANT_ITEM );
        createEAttribute ( this.constantItemEClass, CONSTANT_ITEM__VALUE );

        this.summaryItemEClass = createEClass ( SUMMARY_ITEM );
        createEReference ( this.summaryItemEClass, SUMMARY_ITEM__GROUP );

        this.markerEntryEClass = createEClass ( MARKER_ENTRY );
        createEAttribute ( this.markerEntryEClass, MARKER_ENTRY__NAME );
        createEAttribute ( this.markerEntryEClass, MARKER_ENTRY__VALUE );

        this.manualOverrideEClass = createEClass ( MANUAL_OVERRIDE );
        createEAttribute ( this.manualOverrideEClass, MANUAL_OVERRIDE__INITIAL_VALUE );

        this.masterServerEClass = createEClass ( MASTER_SERVER );
        createEReference ( this.masterServerEClass, MASTER_SERVER__SUMMARY_GROUPS );
        createEReference ( this.masterServerEClass, MASTER_SERVER__ITEMS );
        createEReference ( this.masterServerEClass, MASTER_SERVER__MARKERS );
        createEAttribute ( this.masterServerEClass, MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX );
        createEReference ( this.masterServerEClass, MASTER_SERVER__MONITOR_POOLS );
        createEReference ( this.masterServerEClass, MASTER_SERVER__EVENT_POOLS );
        createEReference ( this.masterServerEClass, MASTER_SERVER__DATA_MAPPER );
        createEReference ( this.masterServerEClass, MASTER_SERVER__EXTERNAL_EVENT_MONITORS );
        createEReference ( this.masterServerEClass, MASTER_SERVER__EXTERNAL_EVENT_FILTERS );
        createEReference ( this.masterServerEClass, MASTER_SERVER__AVERAGES );
        createEReference ( this.masterServerEClass, MASTER_SERVER__MOVING_AVERAGES );

        this.valueArchiveServerEClass = createEClass ( VALUE_ARCHIVE_SERVER );
        createEReference ( this.valueArchiveServerEClass, VALUE_ARCHIVE_SERVER__ARCHIVES );

        this.defaultMasterServerEClass = createEClass ( DEFAULT_MASTER_SERVER );

        this.customMasterServerEClass = createEClass ( CUSTOM_MASTER_SERVER );
        createEReference ( this.customMasterServerEClass, CUSTOM_MASTER_SERVER__PROFILE );

        this.applicationModuleEClass = createEClass ( APPLICATION_MODULE );

        this.attributesSummaryEClass = createEClass ( ATTRIBUTES_SUMMARY );
        createEAttribute ( this.attributesSummaryEClass, ATTRIBUTES_SUMMARY__ATTRIBUTES );
        createEAttribute ( this.attributesSummaryEClass, ATTRIBUTES_SUMMARY__OUTPUT_PREFIX );

        this.eventLoggerEClass = createEClass ( EVENT_LOGGER );
        createEAttribute ( this.eventLoggerEClass, EVENT_LOGGER__LOG_ATTRIBUTES_CHANGE );
        createEAttribute ( this.eventLoggerEClass, EVENT_LOGGER__LOG_VALUE_CHANGE );
        createEAttribute ( this.eventLoggerEClass, EVENT_LOGGER__LOG_SUBSCRIPTION_CHANGE );
        createEAttribute ( this.eventLoggerEClass, EVENT_LOGGER__LOG_WRITES );

        this.monitorPoolEClass = createEClass ( MONITOR_POOL );
        createEAttribute ( this.monitorPoolEClass, MONITOR_POOL__FILTER );

        this.eventPoolEClass = createEClass ( EVENT_POOL );
        createEAttribute ( this.eventPoolEClass, EVENT_POOL__FILTER );
        createEAttribute ( this.eventPoolEClass, EVENT_POOL__SIZE );

        this.dataMapperEClass = createEClass ( DATA_MAPPER );

        this.simpleDataMapperEClass = createEClass ( SIMPLE_DATA_MAPPER );
        createEReference ( this.simpleDataMapperEClass, SIMPLE_DATA_MAPPER__ENTRIES );

        this.jdbcDataMapperEClass = createEClass ( JDBC_DATA_MAPPER );
        createEAttribute ( this.jdbcDataMapperEClass, JDBC_DATA_MAPPER__JDBC_DRIVER );
        createEAttribute ( this.jdbcDataMapperEClass, JDBC_DATA_MAPPER__SQL );
        createEReference ( this.jdbcDataMapperEClass, JDBC_DATA_MAPPER__PROPERTIES );

        this.dataMapperEntryEClass = createEClass ( DATA_MAPPER_ENTRY );
        createEAttribute ( this.dataMapperEntryEClass, DATA_MAPPER_ENTRY__KEY );
        createEAttribute ( this.dataMapperEntryEClass, DATA_MAPPER_ENTRY__VALUE );

        this.valueMapperEClass = createEClass ( VALUE_MAPPER );
        createEAttribute ( this.valueMapperEClass, VALUE_MAPPER__SOURCE_ATTRIBUTE );
        createEAttribute ( this.valueMapperEClass, VALUE_MAPPER__TARGET_ATTRIBUTE );
        createEReference ( this.valueMapperEClass, VALUE_MAPPER__DATA_MAPPER );

        this.persistentItemEClass = createEClass ( PERSISTENT_ITEM );

        this.proxyItemEClass = createEClass ( PROXY_ITEM );
        createEReference ( this.proxyItemEClass, PROXY_ITEM__ITEMS );

        this.scaleEClass = createEClass ( SCALE );
        createEAttribute ( this.scaleEClass, SCALE__ACTIVE );
        createEAttribute ( this.scaleEClass, SCALE__FACTOR );
        createEAttribute ( this.scaleEClass, SCALE__OFFSET );

        this.negateEClass = createEClass ( NEGATE );
        createEAttribute ( this.negateEClass, NEGATE__ACTIVE );

        this.roundingEClass = createEClass ( ROUNDING );
        createEAttribute ( this.roundingEClass, ROUNDING__TYPE );

        this.externalEventMonitorEClass = createEClass ( EXTERNAL_EVENT_MONITOR );
        createEAttribute ( this.externalEventMonitorEClass, EXTERNAL_EVENT_MONITOR__FILTER );
        createEReference ( this.externalEventMonitorEClass, EXTERNAL_EVENT_MONITOR__PROPERTIES );

        this.propertyEntryEClass = createEClass ( PROPERTY_ENTRY );
        createEAttribute ( this.propertyEntryEClass, PROPERTY_ENTRY__KEY );
        createEAttribute ( this.propertyEntryEClass, PROPERTY_ENTRY__VALUE );

        this.externalEventFilterEClass = createEClass ( EXTERNAL_EVENT_FILTER );

        this.staticExternalEventFilterEClass = createEClass ( STATIC_EXTERNAL_EVENT_FILTER );
        createEAttribute ( this.staticExternalEventFilterEClass, STATIC_EXTERNAL_EVENT_FILTER__VALUE );

        this.simpleExternalEventFilterEClass = createEClass ( SIMPLE_EXTERNAL_EVENT_FILTER );
        createEAttribute ( this.simpleExternalEventFilterEClass, SIMPLE_EXTERNAL_EVENT_FILTER__FILTER );

        this.typedItemReferenceEClass = createEClass ( TYPED_ITEM_REFERENCE );
        createEAttribute ( this.typedItemReferenceEClass, TYPED_ITEM_REFERENCE__TYPE );

        this.codeFragmentEClass = createEClass ( CODE_FRAGMENT );
        createEAttribute ( this.codeFragmentEClass, CODE_FRAGMENT__CODE );

        this.scriptTimerEClass = createEClass ( SCRIPT_TIMER );
        createEReference ( this.scriptTimerEClass, SCRIPT_TIMER__SCRIPT );
        createEAttribute ( this.scriptTimerEClass, SCRIPT_TIMER__PERIOD );

        this.itemReferenceEClass = createEClass ( ITEM_REFERENCE );
        createEReference ( this.itemReferenceEClass, ITEM_REFERENCE__ITEM );
        createEAttribute ( this.itemReferenceEClass, ITEM_REFERENCE__NAME );

        this.formulaItemEClass = createEClass ( FORMULA_ITEM );
        createEAttribute ( this.formulaItemEClass, FORMULA_ITEM__SCRIPT_ENGINE );
        createEReference ( this.formulaItemEClass, FORMULA_ITEM__INIT_SCRIPTS );
        createEReference ( this.formulaItemEClass, FORMULA_ITEM__OUTBOUND );
        createEReference ( this.formulaItemEClass, FORMULA_ITEM__INBOUND );

        this.formulaItemOutboundEClass = createEClass ( FORMULA_ITEM_OUTBOUND );
        createEReference ( this.formulaItemOutboundEClass, FORMULA_ITEM_OUTBOUND__OUTPUT );
        createEAttribute ( this.formulaItemOutboundEClass, FORMULA_ITEM_OUTBOUND__OUTPUT_FORMULA );
        createEAttribute ( this.formulaItemOutboundEClass, FORMULA_ITEM_OUTBOUND__WRITE_VALUE_VARIABLE_NAME );

        this.formulaItemInboundEClass = createEClass ( FORMULA_ITEM_INBOUND );
        createEReference ( this.formulaItemInboundEClass, FORMULA_ITEM_INBOUND__INPUTS );
        createEAttribute ( this.formulaItemInboundEClass, FORMULA_ITEM_INBOUND__INPUT_FORMULA );

        this.booleanMonitorEClass = createEClass ( BOOLEAN_MONITOR );
        createEAttribute ( this.booleanMonitorEClass, BOOLEAN_MONITOR__REFERENCE_VALUE );
        createEAttribute ( this.booleanMonitorEClass, BOOLEAN_MONITOR__ACTIVE );
        createEAttribute ( this.booleanMonitorEClass, BOOLEAN_MONITOR__DEMOTE_PREFIX );
        createEAttribute ( this.booleanMonitorEClass, BOOLEAN_MONITOR__SEVERITY );
        createEAttribute ( this.booleanMonitorEClass, BOOLEAN_MONITOR__MESSAGE );
        createEAttribute ( this.booleanMonitorEClass, BOOLEAN_MONITOR__SUPPRESS_EVENTS );
        createEAttribute ( this.booleanMonitorEClass, BOOLEAN_MONITOR__REQUIRE_ACK );

        this.listMonitorEClass = createEClass ( LIST_MONITOR );
        createEAttribute ( this.listMonitorEClass, LIST_MONITOR__MESSAGE );
        createEAttribute ( this.listMonitorEClass, LIST_MONITOR__MESSAGE_ATTRIBUTE );
        createEAttribute ( this.listMonitorEClass, LIST_MONITOR__DEFAULT_ACK );
        createEAttribute ( this.listMonitorEClass, LIST_MONITOR__DEFAULT_SEVERITY );
        createEAttribute ( this.listMonitorEClass, LIST_MONITOR__MONITOR_TYPE );
        createEAttribute ( this.listMonitorEClass, LIST_MONITOR__DEMOTE_PREFIX );
        createEReference ( this.listMonitorEClass, LIST_MONITOR__ENTRIES );

        this.listMonitorEntryEClass = createEClass ( LIST_MONITOR_ENTRY );
        createEAttribute ( this.listMonitorEntryEClass, LIST_MONITOR_ENTRY__VALUE );
        createEAttribute ( this.listMonitorEntryEClass, LIST_MONITOR_ENTRY__REQUIRE_ACK );
        createEAttribute ( this.listMonitorEntryEClass, LIST_MONITOR_ENTRY__SEVERITY );

        this.averageEClass = createEClass ( AVERAGE );
        createEReference ( this.averageEClass, AVERAGE__ITEMS );
        createEAttribute ( this.averageEClass, AVERAGE__SOURCES_REQUIRED );

        this.movingAverageEClass = createEClass ( MOVING_AVERAGE );
        createEReference ( this.movingAverageEClass, MOVING_AVERAGE__ITEM );
        createEAttribute ( this.movingAverageEClass, MOVING_AVERAGE__RANGE );
        createEAttribute ( this.movingAverageEClass, MOVING_AVERAGE__NULL_RANGE );
        createEAttribute ( this.movingAverageEClass, MOVING_AVERAGE__TRIGGER );
        createEAttribute ( this.movingAverageEClass, MOVING_AVERAGE__TRIGGER_ONLY );

        this.averageItemEClass = createEClass ( AVERAGE_ITEM );
        createEReference ( this.averageItemEClass, AVERAGE_ITEM__SOURCE );
        createEAttribute ( this.averageItemEClass, AVERAGE_ITEM__TYPE );

        this.movingAverageItemEClass = createEClass ( MOVING_AVERAGE_ITEM );
        createEReference ( this.movingAverageItemEClass, MOVING_AVERAGE_ITEM__SOURCE );
        createEAttribute ( this.movingAverageItemEClass, MOVING_AVERAGE_ITEM__TYPE );

        this.blockingsEClass = createEClass ( BLOCKINGS );
        createEReference ( this.blockingsEClass, BLOCKINGS__GROUPS );

        this.blockGroupEClass = createEClass ( BLOCK_GROUP );
        createEReference ( this.blockGroupEClass, BLOCK_GROUP__HANDLERS );
        createEAttribute ( this.blockGroupEClass, BLOCK_GROUP__HIERARCHY );

        this.blockHandlerEClass = createEClass ( BLOCK_HANDLER );
        createEReference ( this.blockHandlerEClass, BLOCK_HANDLER__GROUP );

        this.blockEClass = createEClass ( BLOCK );

        this.globalSummaryItemEClass = createEClass ( GLOBAL_SUMMARY_ITEM );
        createEAttribute ( this.globalSummaryItemEClass, GLOBAL_SUMMARY_ITEM__ATTRIBUTE );

        this.weakReferenceDataSourceItemEClass = createEClass ( WEAK_REFERENCE_DATA_SOURCE_ITEM );
        createEAttribute ( this.weakReferenceDataSourceItemEClass, WEAK_REFERENCE_DATA_SOURCE_ITEM__DATA_SOURCE_ID );

        this.alarmsEventsExporterEClass = createEClass ( ALARMS_EVENTS_EXPORTER );
        createEOperation ( this.alarmsEventsExporterEClass, ALARMS_EVENTS_EXPORTER___GET_TYPE_TAG );

        this.alarmsEventsConnectionEClass = createEClass ( ALARMS_EVENTS_CONNECTION );
        createEOperation ( this.alarmsEventsConnectionEClass, ALARMS_EVENTS_CONNECTION___GET_TYPE_TAG );
        createEOperation ( this.alarmsEventsConnectionEClass, ALARMS_EVENTS_CONNECTION___MAKE_URI__BOOLEAN );

        this.monitorPoolProxyEClass = createEClass ( MONITOR_POOL_PROXY );
        createEReference ( this.monitorPoolProxyEClass, MONITOR_POOL_PROXY__LOCAL );
        createEReference ( this.monitorPoolProxyEClass, MONITOR_POOL_PROXY__REMOTE );

        this.eventPoolProxyEClass = createEClass ( EVENT_POOL_PROXY );
        createEReference ( this.eventPoolProxyEClass, EVENT_POOL_PROXY__LOCAL );
        createEReference ( this.eventPoolProxyEClass, EVENT_POOL_PROXY__REMOTE );
        createEAttribute ( this.eventPoolProxyEClass, EVENT_POOL_PROXY__SIZE );

        this.alarmsEventsModuleEClass = createEClass ( ALARMS_EVENTS_MODULE );
        createEReference ( this.alarmsEventsModuleEClass, ALARMS_EVENTS_MODULE__MONITOR_POOL_PROXIES );
        createEReference ( this.alarmsEventsModuleEClass, ALARMS_EVENTS_MODULE__EVENT_POOL_PROXIES );
        createEReference ( this.alarmsEventsModuleEClass, ALARMS_EVENTS_MODULE__AKN_PROXIES );
        createEReference ( this.alarmsEventsModuleEClass, ALARMS_EVENTS_MODULE__PULL_EVENTS );

        this.aknProxyEClass = createEClass ( AKN_PROXY );
        createEAttribute ( this.aknProxyEClass, AKN_PROXY__PATTERN );
        createEReference ( this.aknProxyEClass, AKN_PROXY__CONNECTION );
        createEAttribute ( this.aknProxyEClass, AKN_PROXY__PRIORITY );
        createEAttribute ( this.aknProxyEClass, AKN_PROXY__AUTHORATIVE );

        this.pullEventsEClass = createEClass ( PULL_EVENTS );
        createEAttribute ( this.pullEventsEClass, PULL_EVENTS__JDBC_DRIVER_NAME );
        createEReference ( this.pullEventsEClass, PULL_EVENTS__JDBC_PROPERTIES );
        createEAttribute ( this.pullEventsEClass, PULL_EVENTS__JOB_INTERVAL );
        createEAttribute ( this.pullEventsEClass, PULL_EVENTS__CUSTOM_SELECT_SQL );
        createEAttribute ( this.pullEventsEClass, PULL_EVENTS__CUSTOM_DELETE_SQL );

        this.jdbcUserServiceModuleEClass = createEClass ( JDBC_USER_SERVICE_MODULE );
        createEReference ( this.jdbcUserServiceModuleEClass, JDBC_USER_SERVICE_MODULE__USER_SERVICES );

        this.jdbcUserServiceEClass = createEClass ( JDBC_USER_SERVICE );
        createEReference ( this.jdbcUserServiceEClass, JDBC_USER_SERVICE__JDBC_PROPETIES );
        createEAttribute ( this.jdbcUserServiceEClass, JDBC_USER_SERVICE__JDBC_DRIVER );
        createEAttribute ( this.jdbcUserServiceEClass, JDBC_USER_SERVICE__AUTHORATIVE );
        createEAttribute ( this.jdbcUserServiceEClass, JDBC_USER_SERVICE__FIND_USER_SQL );
        createEAttribute ( this.jdbcUserServiceEClass, JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL );
        createEAttribute ( this.jdbcUserServiceEClass, JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL );
        createEAttribute ( this.jdbcUserServiceEClass, JDBC_USER_SERVICE__USER_ID_COLUMN_NAME );
        createEAttribute ( this.jdbcUserServiceEClass, JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME );
        createEAttribute ( this.jdbcUserServiceEClass, JDBC_USER_SERVICE__PASSWORD_TYPE );

        this.defaultValueArchiveServerEClass = createEClass ( DEFAULT_VALUE_ARCHIVE_SERVER );

        this.historicalDataExporterEClass = createEClass ( HISTORICAL_DATA_EXPORTER );
        createEOperation ( this.historicalDataExporterEClass, HISTORICAL_DATA_EXPORTER___GET_TYPE_TAG );

        this.valueArchiveEClass = createEClass ( VALUE_ARCHIVE );
        createEReference ( this.valueArchiveEClass, VALUE_ARCHIVE__ITEMS );

        this.configurationAdministratorExporterEClass = createEClass ( CONFIGURATION_ADMINISTRATOR_EXPORTER );
        createEOperation ( this.configurationAdministratorExporterEClass, CONFIGURATION_ADMINISTRATOR_EXPORTER___GET_TYPE_TAG );

        this.referenceItemEClass = createEClass ( REFERENCE_ITEM );
        createEReference ( this.referenceItemEClass, REFERENCE_ITEM__SOURCE );

        this.eventStorageEClass = createEClass ( EVENT_STORAGE );

        this.eventStorageJdbcEClass = createEClass ( EVENT_STORAGE_JDBC );
        createEAttribute ( this.eventStorageJdbcEClass, EVENT_STORAGE_JDBC__JDBC_DRIVER_NAME );
        createEAttribute ( this.eventStorageJdbcEClass, EVENT_STORAGE_JDBC__DRIVER_BUNDLES );
        createEAttribute ( this.eventStorageJdbcEClass, EVENT_STORAGE_JDBC__MAX_FIELD_LENGTH );
        createEAttribute ( this.eventStorageJdbcEClass, EVENT_STORAGE_JDBC__QUERY_FETCH_SIZE );

        this.eventStoragePostgresEClass = createEClass ( EVENT_STORAGE_POSTGRES );
        createEAttribute ( this.eventStoragePostgresEClass, EVENT_STORAGE_POSTGRES__BATCH_SIZE );
        createEAttribute ( this.eventStoragePostgresEClass, EVENT_STORAGE_POSTGRES__POSTGRES_DRIVER_BUNDLES );
        createEOperation ( this.eventStoragePostgresEClass, EVENT_STORAGE_POSTGRES___GET_JDBC_DRIVER_NAME );
        createEOperation ( this.eventStoragePostgresEClass, EVENT_STORAGE_POSTGRES___GET_DRIVER_BUNDLES );

        this.abstractEventStorageJdbcEClass = createEClass ( ABSTRACT_EVENT_STORAGE_JDBC );
        createEReference ( this.abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES );
        createEAttribute ( this.abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA );
        createEAttribute ( this.abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME );
        createEAttribute ( this.abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION );
        createEAttribute ( this.abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS );
        createEAttribute ( this.abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS );
        createEOperation ( this.abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC___GET_JDBC_DRIVER_NAME );
        createEOperation ( this.abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC___GET_DRIVER_BUNDLES );

        this.applicationConfigurationEClass = createEClass ( APPLICATION_CONFIGURATION );

        this.restExporterEClass = createEClass ( REST_EXPORTER );
        createEReference ( this.restExporterEClass, REST_EXPORTER__ITEMS );
        createEReference ( this.restExporterEClass, REST_EXPORTER__HIVE_PROPERTIES );
        createEAttribute ( this.restExporterEClass, REST_EXPORTER__CONTEXT_ID );

        this.httpServiceEClass = createEClass ( HTTP_SERVICE );
        createEReference ( this.httpServiceEClass, HTTP_SERVICE__ENDPOINT );

        this.independentConfigurationEClass = createEClass ( INDEPENDENT_CONFIGURATION );

        this.transientItemEClass = createEClass ( TRANSIENT_ITEM );

        this.defaultEquinoxApplicationEClass = createEClass ( DEFAULT_EQUINOX_APPLICATION );
        createEReference ( this.defaultEquinoxApplicationEClass, DEFAULT_EQUINOX_APPLICATION__PROFILE );

        // Create enums
        this.averageReferenceTypeEEnum = createEEnum ( AVERAGE_REFERENCE_TYPE );
        this.movingAverageReferenceTypeEEnum = createEEnum ( MOVING_AVERAGE_REFERENCE_TYPE );
        this.roundingTypeEEnum = createEEnum ( ROUNDING_TYPE );
        this.dataTypeEEnum = createEEnum ( DATA_TYPE );
        this.passwordTypeEEnum = createEEnum ( PASSWORD_TYPE );

        // Create data types
        this.severityEDataType = createEDataType ( SEVERITY );
        this.variantEDataType = createEDataType ( VARIANT );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( this.isInitialized )
        {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Obtain other dependent packages
        final ProfilePackage theProfilePackage = (ProfilePackage)EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI );
        final WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        final SecurityPackage theSecurityPackage = (SecurityPackage)EPackage.Registry.INSTANCE.getEPackage ( SecurityPackage.eNS_URI );

        // Add subpackages
        getESubpackages ().add ( theProfilePackage );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.equinoxApplicationEClass.getESuperTypes ().add ( theWorldPackage.getApplication () );
        this.connectionEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.exporterEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.dataAccessConnectionEClass.getESuperTypes ().add ( getConnection () );
        this.dataAccessExporterEClass.getESuperTypes ().add ( getExporter () );
        this.sourceItemEClass.getESuperTypes ().add ( getItem () );
        this.levelMonitorEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.scriptItemEClass.getESuperTypes ().add ( getItem () );
        this.importItemEClass.getESuperTypes ().add ( getItem () );
        this.constantItemEClass.getESuperTypes ().add ( getItem () );
        this.summaryItemEClass.getESuperTypes ().add ( getItem () );
        this.manualOverrideEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.masterServerEClass.getESuperTypes ().add ( getEquinoxApplication () );
        this.valueArchiveServerEClass.getESuperTypes ().add ( getEquinoxApplication () );
        this.defaultMasterServerEClass.getESuperTypes ().add ( getMasterServer () );
        this.customMasterServerEClass.getESuperTypes ().add ( getMasterServer () );
        this.attributesSummaryEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.eventLoggerEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.monitorPoolEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.eventPoolEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.dataMapperEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.simpleDataMapperEClass.getESuperTypes ().add ( getDataMapper () );
        this.jdbcDataMapperEClass.getESuperTypes ().add ( getDataMapper () );
        this.valueMapperEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.persistentItemEClass.getESuperTypes ().add ( getItem () );
        this.proxyItemEClass.getESuperTypes ().add ( getItem () );
        this.scaleEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.negateEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.roundingEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.externalEventMonitorEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.externalEventFilterEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.staticExternalEventFilterEClass.getESuperTypes ().add ( getExternalEventFilter () );
        this.simpleExternalEventFilterEClass.getESuperTypes ().add ( getExternalEventFilter () );
        this.typedItemReferenceEClass.getESuperTypes ().add ( getItemReference () );
        this.formulaItemEClass.getESuperTypes ().add ( getItem () );
        this.booleanMonitorEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.listMonitorEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.averageEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.movingAverageEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.averageItemEClass.getESuperTypes ().add ( getItem () );
        this.movingAverageItemEClass.getESuperTypes ().add ( getItem () );
        this.blockingsEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.blockingsEClass.getESuperTypes ().add ( getApplicationModule () );
        this.blockGroupEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.blockHandlerEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.blockEClass.getESuperTypes ().add ( getItemFeatureEntry () );
        this.globalSummaryItemEClass.getESuperTypes ().add ( getItem () );
        this.weakReferenceDataSourceItemEClass.getESuperTypes ().add ( getItem () );
        this.alarmsEventsExporterEClass.getESuperTypes ().add ( getExporter () );
        this.alarmsEventsConnectionEClass.getESuperTypes ().add ( getConnection () );
        this.monitorPoolProxyEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.eventPoolProxyEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.alarmsEventsModuleEClass.getESuperTypes ().add ( getApplicationModule () );
        this.pullEventsEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.jdbcUserServiceModuleEClass.getESuperTypes ().add ( getApplicationModule () );
        this.jdbcUserServiceEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.defaultValueArchiveServerEClass.getESuperTypes ().add ( getValueArchiveServer () );
        this.historicalDataExporterEClass.getESuperTypes ().add ( getExporter () );
        this.valueArchiveEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.configurationAdministratorExporterEClass.getESuperTypes ().add ( getExporter () );
        this.referenceItemEClass.getESuperTypes ().add ( getItem () );
        this.eventStorageEClass.getESuperTypes ().add ( getIndependentConfiguration () );
        this.eventStorageJdbcEClass.getESuperTypes ().add ( getAbstractEventStorageJdbc () );
        this.eventStoragePostgresEClass.getESuperTypes ().add ( getAbstractEventStorageJdbc () );
        this.abstractEventStorageJdbcEClass.getESuperTypes ().add ( getEventStorage () );
        this.applicationConfigurationEClass.getESuperTypes ().add ( getApplicationModule () );
        this.restExporterEClass.getESuperTypes ().add ( getApplicationModule () );
        this.httpServiceEClass.getESuperTypes ().add ( getApplicationConfiguration () );
        this.independentConfigurationEClass.getESuperTypes ().add ( getApplicationConfiguration () );
        this.transientItemEClass.getESuperTypes ().add ( getItem () );
        this.defaultEquinoxApplicationEClass.getESuperTypes ().add ( getEquinoxApplication () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( this.equinoxApplicationEClass, EquinoxApplication.class, "EquinoxApplication", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_Connections (), getConnection (), null, "connections", null, 0, -1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_Exporter (), getExporter (), null, "exporter", null, 0, -1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_CustomizationProfile (), theProfilePackage.getProfile (), null, "customizationProfile", null, 0, 1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_SecurityConfiguration (), theSecurityPackage.getConfiguration (), null, "securityConfiguration", null, 1, 1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_Modules (), getApplicationModule (), null, "modules", null, 0, -1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getEquinoxApplication__GetProfile (), theProfilePackage.getProfile (), "getProfile", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.connectionEClass, Connection.class, "Connection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getConnection_Endpoint (), theWorldPackage.getEndpoint (), null, "endpoint", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getConnection_Endpoint ().getEKeys ().add ( theWorldPackage.getEndpoint_PortNumber () );
        initEAttribute ( getConnection_EndpointLabel (), this.ecorePackage.getEString (), "endpointLabel", null, 0, 1, Connection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getConnection_Credentials (), theWorldPackage.getCredentials (), null, "credentials", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnection_Timeout (), this.ecorePackage.getEIntegerObject (), "timeout", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getConnection__GetTypeTag (), this.ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        EOperation op = initEOperation ( getConnection__GetPossibleEndpoints__Exporter (), theWorldPackage.getEndpoint (), "getPossibleEndpoints", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, getExporter (), "exporter", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getConnection__MakeUri__boolean (), this.ecorePackage.getEString (), "makeUri", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.ecorePackage.getEBoolean (), "localhost", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getConnection__GetMatchingEndpoint__Exporter (), theWorldPackage.getEndpoint (), "getMatchingEndpoint", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, getExporter (), "exporter", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.exporterEClass, Exporter.class, "Exporter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getExporter_Endpoints (), theWorldPackage.getEndpoint (), null, "endpoints", null, 0, -1, Exporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getExporter_Endpoints ().getEKeys ().add ( theWorldPackage.getEndpoint_PortNumber () );

        initEOperation ( getExporter__GetTypeTag (), this.ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.dataAccessConnectionEClass, DataAccessConnection.class, "DataAccessConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getDataAccessConnection__GetTypeTag (), this.ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getDataAccessConnection__MakeUri__boolean (), this.ecorePackage.getEString (), "makeUri", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.ecorePackage.getEBoolean (), "localhost", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.dataAccessExporterEClass, DataAccessExporter.class, "DataAccessExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDataAccessExporter_Exports (), getItemExport (), null, "exports", null, 0, -1, DataAccessExporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getDataAccessExporter__GetTypeTag (), this.ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.itemEClass, Item.class, "Item", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItem_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getItem_Information (), getItemInformation (), null, "information", null, 0, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getItem_ItemFeatures (), getItemFeatureEntry (), getItemFeatureEntry_Item (), "itemFeatures", null, 0, -1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getItem_ItemFeatures ().getEKeys ().add ( getItemFeatureEntry_Name () );

        initEClass ( this.sourceItemEClass, SourceItem.class, "SourceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSourceItem_Connection (), getDataAccessConnection (), null, "connection", null, 1, 1, SourceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSourceItem_SourceName (), this.ecorePackage.getEString (), "sourceName", null, 1, 1, SourceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.itemExportEClass, ItemExport.class, "ItemExport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getItemExport_Item (), getItem (), null, "item", null, 1, 1, ItemExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemExport_ExportName (), this.ecorePackage.getEString (), "exportName", null, 0, 1, ItemExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.itemInformationEClass, ItemInformation.class, "ItemInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemInformation_Description (), this.ecorePackage.getEString (), "description", null, 0, 1, ItemInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemInformation_Unit (), this.ecorePackage.getEString (), "unit", null, 0, 1, ItemInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemInformation_Hierarchy (), this.ecorePackage.getEString (), "hierarchy", null, 0, -1, ItemInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemInformation_System (), this.ecorePackage.getEString (), "system", null, 0, 1, ItemInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemInformation_DataType (), getDataType (), "dataType", "VARIANT", 1, 1, ItemInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.levelMonitorEClass, LevelMonitor.class, "LevelMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_Preset (), this.ecorePackage.getEDoubleObject (), "preset", null, 0, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_Cap (), this.ecorePackage.getEBoolean (), "cap", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_Severity (), getSeverity (), "severity", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_LowerOk (), this.ecorePackage.getEBoolean (), "lowerOk", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_IncludedOk (), this.ecorePackage.getEBoolean (), "includedOk", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_Prefix (), this.ecorePackage.getEString (), "prefix", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_DemotePrefix (), this.ecorePackage.getEString (), "demotePrefix", null, 0, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_SuppressEvents (), this.ecorePackage.getEBoolean (), "suppressEvents", "false", 0, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getLevelMonitor_RequireAck (), this.ecorePackage.getEBoolean (), "requireAck", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_MonitorType (), this.ecorePackage.getEString (), "monitorType", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.itemFeatureEntryEClass, ItemFeatureEntry.class, "ItemFeatureEntry", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemFeatureEntry_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, ItemFeatureEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getItemFeatureEntry_Item (), getItem (), getItem_ItemFeatures (), "item", null, 1, 1, ItemFeatureEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.scriptItemEClass, ScriptItem.class, "ScriptItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getScriptItem_Inputs (), getItemReference (), null, "inputs", null, 0, -1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptItem_InitScript (), getCodeFragment (), null, "initScript", null, 0, 1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptItem_UpdateScript (), getCodeFragment (), null, "updateScript", null, 0, 1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptItem_Timer (), getScriptTimer (), null, "timer", null, 0, 1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScriptItem_ScriptEngine (), this.ecorePackage.getEString (), "scriptEngine", "JavaScript", 1, 1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getScriptItem_Commands (), getItemReference (), null, "commands", null, 0, -1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptItem_WriteCommandScript (), getCodeFragment (), null, "writeCommandScript", null, 0, 1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.importItemEClass, ImportItem.class, "ImportItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getImportItem_Export (), getItemExport (), null, "export", null, 1, 1, ImportItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.summaryGroupEClass, SummaryGroup.class, "SummaryGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSummaryGroup_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, SummaryGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSummaryGroup_SubGroups (), getSummaryGroup (), null, "subGroups", null, 0, -1, SummaryGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSummaryGroup_Items (), getItem (), null, "items", null, 0, -1, SummaryGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.markerGroupEClass, MarkerGroup.class, "MarkerGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMarkerGroup_Items (), getItem (), null, "items", null, 0, -1, MarkerGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMarkerGroup_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, MarkerGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMarkerGroup_Markers (), getMarkerEntry (), null, "markers", null, 0, -1, MarkerGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.markersEClass, Markers.class, "Markers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMarkers_MarkerGroups (), getMarkerGroup (), null, "markerGroups", null, 0, -1, Markers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.constantItemEClass, ConstantItem.class, "ConstantItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getConstantItem_Value (), this.ecorePackage.getEString (), "value", null, 0, 1, ConstantItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.summaryItemEClass, SummaryItem.class, "SummaryItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSummaryItem_Group (), getSummaryGroup (), null, "group", null, 1, 1, SummaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.markerEntryEClass, MarkerEntry.class, "MarkerEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMarkerEntry_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, MarkerEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMarkerEntry_Value (), this.ecorePackage.getEString (), "value", null, 0, 1, MarkerEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.manualOverrideEClass, ManualOverride.class, "ManualOverride", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getManualOverride_InitialValue (), this.ecorePackage.getEString (), "initialValue", null, 0, 1, ManualOverride.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.masterServerEClass, MasterServer.class, "MasterServer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMasterServer_SummaryGroups (), getSummaryGroup (), null, "summaryGroups", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_Items (), getItem (), null, "items", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_Markers (), getMarkers (), null, "markers", null, 0, 1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMasterServer_AeServerInformationPrefix (), this.ecorePackage.getEString (), "aeServerInformationPrefix", "ae.server.info", 0, 1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getMasterServer_MonitorPools (), getMonitorPool (), null, "monitorPools", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_EventPools (), getEventPool (), null, "eventPools", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_DataMapper (), getDataMapper (), null, "dataMapper", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_ExternalEventMonitors (), getExternalEventMonitor (), null, "externalEventMonitors", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_ExternalEventFilters (), getExternalEventFilter (), null, "externalEventFilters", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_Averages (), getAverage (), null, "averages", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_MovingAverages (), getMovingAverage (), null, "movingAverages", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.valueArchiveServerEClass, ValueArchiveServer.class, "ValueArchiveServer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getValueArchiveServer_Archives (), getValueArchive (), null, "archives", null, 0, -1, ValueArchiveServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.defaultMasterServerEClass, DefaultMasterServer.class, "DefaultMasterServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.customMasterServerEClass, CustomMasterServer.class, "CustomMasterServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCustomMasterServer_Profile (), theProfilePackage.getProfile (), null, "profile", null, 1, 1, CustomMasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.applicationModuleEClass, ApplicationModule.class, "ApplicationModule", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.attributesSummaryEClass, AttributesSummary.class, "AttributesSummary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAttributesSummary_Attributes (), this.ecorePackage.getEString (), "attributes", null, 0, -1, AttributesSummary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAttributesSummary_OutputPrefix (), this.ecorePackage.getEString (), "outputPrefix", null, 1, 1, AttributesSummary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.eventLoggerEClass, EventLogger.class, "EventLogger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventLogger_LogAttributesChange (), this.ecorePackage.getEBoolean (), "logAttributesChange", "false", 1, 1, EventLogger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getEventLogger_LogValueChange (), this.ecorePackage.getEBoolean (), "logValueChange", "true", 1, 1, EventLogger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getEventLogger_LogSubscriptionChange (), this.ecorePackage.getEBoolean (), "logSubscriptionChange", "true", 1, 1, EventLogger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getEventLogger_LogWrites (), this.ecorePackage.getEBoolean (), "logWrites", "true", 1, 1, EventLogger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.monitorPoolEClass, MonitorPool.class, "MonitorPool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMonitorPool_Filter (), this.ecorePackage.getEString (), "filter", null, 1, 1, MonitorPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.eventPoolEClass, EventPool.class, "EventPool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventPool_Filter (), this.ecorePackage.getEString (), "filter", null, 1, 1, EventPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventPool_Size (), this.ecorePackage.getEInt (), "size", null, 1, 1, EventPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.dataMapperEClass, DataMapper.class, "DataMapper", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.simpleDataMapperEClass, SimpleDataMapper.class, "SimpleDataMapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSimpleDataMapper_Entries (), getDataMapperEntry (), null, "entries", null, 0, -1, SimpleDataMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.jdbcDataMapperEClass, JdbcDataMapper.class, "JdbcDataMapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getJdbcDataMapper_JdbcDriver (), this.ecorePackage.getEString (), "jdbcDriver", null, 1, 1, JdbcDataMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcDataMapper_Sql (), this.ecorePackage.getEString (), "sql", null, 1, 1, JdbcDataMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getJdbcDataMapper_Properties (), getPropertyEntry (), null, "properties", null, 0, -1, JdbcDataMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.dataMapperEntryEClass, DataMapperEntry.class, "DataMapperEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDataMapperEntry_Key (), this.ecorePackage.getEString (), "key", null, 1, 1, DataMapperEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDataMapperEntry_Value (), this.ecorePackage.getEString (), "value", null, 1, 1, DataMapperEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.valueMapperEClass, ValueMapper.class, "ValueMapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getValueMapper_SourceAttribute (), this.ecorePackage.getEString (), "sourceAttribute", null, 0, 1, ValueMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getValueMapper_TargetAttribute (), this.ecorePackage.getEString (), "targetAttribute", null, 0, 1, ValueMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getValueMapper_DataMapper (), getDataMapper (), null, "dataMapper", null, 1, 1, ValueMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.persistentItemEClass, PersistentItem.class, "PersistentItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.proxyItemEClass, ProxyItem.class, "ProxyItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getProxyItem_Items (), getItem (), null, "items", null, 0, -1, ProxyItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.scaleEClass, Scale.class, "Scale", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getScale_Active (), this.ecorePackage.getEBoolean (), "active", null, 1, 1, Scale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScale_Factor (), this.ecorePackage.getEDoubleObject (), "factor", "1.0", 1, 1, Scale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getScale_Offset (), this.ecorePackage.getEDoubleObject (), "offset", "0.0", 1, 1, Scale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.negateEClass, Negate.class, "Negate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getNegate_Active (), this.ecorePackage.getEBoolean (), "active", null, 1, 1, Negate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.roundingEClass, Rounding.class, "Rounding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getRounding_Type (), getRoundingType (), "type", null, 1, 1, Rounding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.externalEventMonitorEClass, ExternalEventMonitor.class, "ExternalEventMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getExternalEventMonitor_Filter (), this.ecorePackage.getEString (), "filter", null, 1, 1, ExternalEventMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExternalEventMonitor_Properties (), getPropertyEntry (), null, "properties", null, 0, -1, ExternalEventMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.propertyEntryEClass, PropertyEntry.class, "PropertyEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPropertyEntry_Key (), this.ecorePackage.getEString (), "key", null, 1, 1, PropertyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPropertyEntry_Value (), this.ecorePackage.getEString (), "value", null, 1, 1, PropertyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.externalEventFilterEClass, ExternalEventFilter.class, "ExternalEventFilter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.staticExternalEventFilterEClass, StaticExternalEventFilter.class, "StaticExternalEventFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getStaticExternalEventFilter_Value (), this.ecorePackage.getEString (), "value", null, 1, 1, StaticExternalEventFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.simpleExternalEventFilterEClass, SimpleExternalEventFilter.class, "SimpleExternalEventFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSimpleExternalEventFilter_Filter (), this.ecorePackage.getEString (), "filter", null, 1, 1, SimpleExternalEventFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.typedItemReferenceEClass, TypedItemReference.class, "TypedItemReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTypedItemReference_Type (), getDataType (), "type", null, 1, 1, TypedItemReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.codeFragmentEClass, CodeFragment.class, "CodeFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCodeFragment_Code (), this.ecorePackage.getEString (), "code", null, 0, 1, CodeFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.scriptTimerEClass, ScriptTimer.class, "ScriptTimer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getScriptTimer_Script (), getCodeFragment (), null, "script", null, 1, 1, ScriptTimer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScriptTimer_Period (), this.ecorePackage.getELong (), "period", null, 1, 1, ScriptTimer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.itemReferenceEClass, ItemReference.class, "ItemReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getItemReference_Item (), getItem (), null, "item", null, 1, 1, ItemReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemReference_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, ItemReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.formulaItemEClass, FormulaItem.class, "FormulaItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getFormulaItem_ScriptEngine (), this.ecorePackage.getEString (), "scriptEngine", null, 0, 1, FormulaItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getFormulaItem_InitScripts (), getCodeFragment (), null, "initScripts", null, 0, -1, FormulaItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getFormulaItem_Outbound (), getFormulaItemOutbound (), null, "outbound", null, 0, 1, FormulaItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getFormulaItem_Inbound (), getFormulaItemInbound (), null, "inbound", null, 0, 1, FormulaItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.formulaItemOutboundEClass, FormulaItemOutbound.class, "FormulaItemOutbound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getFormulaItemOutbound_Output (), getTypedItemReference (), null, "output", null, 1, 1, FormulaItemOutbound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFormulaItemOutbound_OutputFormula (), this.ecorePackage.getEString (), "outputFormula", null, 0, 1, FormulaItemOutbound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFormulaItemOutbound_WriteValueVariableName (), this.ecorePackage.getEString (), "writeValueVariableName", null, 0, 1, FormulaItemOutbound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.formulaItemInboundEClass, FormulaItemInbound.class, "FormulaItemInbound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getFormulaItemInbound_Inputs (), getTypedItemReference (), null, "inputs", null, 1, -1, FormulaItemInbound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFormulaItemInbound_InputFormula (), this.ecorePackage.getEString (), "inputFormula", null, 0, 1, FormulaItemInbound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.booleanMonitorEClass, BooleanMonitor.class, "BooleanMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_ReferenceValue (), this.ecorePackage.getEBoolean (), "referenceValue", null, 1, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_Active (), this.ecorePackage.getEBoolean (), "active", null, 1, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_DemotePrefix (), this.ecorePackage.getEString (), "demotePrefix", null, 0, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_Severity (), getSeverity (), "severity", null, 1, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_Message (), this.ecorePackage.getEString (), "message", null, 0, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_SuppressEvents (), this.ecorePackage.getEBoolean (), "suppressEvents", null, 1, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_RequireAck (), this.ecorePackage.getEBoolean (), "requireAck", null, 1, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.listMonitorEClass, ListMonitor.class, "ListMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getListMonitor_Message (), this.ecorePackage.getEString (), "message", null, 0, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getListMonitor_MessageAttribute (), this.ecorePackage.getEString (), "messageAttribute", null, 0, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getListMonitor_DefaultAck (), this.ecorePackage.getEBoolean (), "defaultAck", "false", 1, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getListMonitor_DefaultSeverity (), getSeverity (), "defaultSeverity", "ALARM", 1, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getListMonitor_MonitorType (), this.ecorePackage.getEString (), "monitorType", "LIST", 1, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getListMonitor_DemotePrefix (), this.ecorePackage.getEString (), "demotePrefix", null, 0, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getListMonitor_Entries (), getListMonitorEntry (), null, "entries", null, 0, -1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.listMonitorEntryEClass, ListMonitorEntry.class, "ListMonitorEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getListMonitorEntry_Value (), getVariant (), "value", null, 1, 1, ListMonitorEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getListMonitorEntry_RequireAck (), this.ecorePackage.getEBooleanObject (), "requireAck", null, 0, 1, ListMonitorEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getListMonitorEntry_Severity (), getSeverity (), "severity", null, 0, 1, ListMonitorEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.averageEClass, Average.class, "Average", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAverage_Items (), getItem (), null, "items", null, 0, -1, Average.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAverage_SourcesRequired (), this.ecorePackage.getEString (), "sourcesRequired", null, 0, 1, Average.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.movingAverageEClass, MovingAverage.class, "MovingAverage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMovingAverage_Item (), getItem (), null, "item", null, 1, 1, MovingAverage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMovingAverage_Range (), this.ecorePackage.getELong (), "range", null, 1, 1, MovingAverage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMovingAverage_NullRange (), this.ecorePackage.getELong (), "nullRange", null, 1, 1, MovingAverage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMovingAverage_Trigger (), this.ecorePackage.getELong (), "trigger", "1", 1, 1, MovingAverage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getMovingAverage_TriggerOnly (), this.ecorePackage.getEBooleanObject (), "triggerOnly", "false", 0, 1, MovingAverage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.averageItemEClass, AverageItem.class, "AverageItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAverageItem_Source (), getAverage (), null, "source", null, 1, 1, AverageItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAverageItem_Type (), getAverageReferenceType (), "type", null, 1, 1, AverageItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.movingAverageItemEClass, MovingAverageItem.class, "MovingAverageItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMovingAverageItem_Source (), getMovingAverage (), null, "source", null, 1, 1, MovingAverageItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMovingAverageItem_Type (), getMovingAverageReferenceType (), "type", null, 1, 1, MovingAverageItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.blockingsEClass, Blockings.class, "Blockings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getBlockings_Groups (), getBlockGroup (), null, "groups", null, 0, -1, Blockings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.blockGroupEClass, BlockGroup.class, "BlockGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getBlockGroup_Handlers (), getBlockHandler (), getBlockHandler_Group (), "handlers", null, 0, -1, BlockGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBlockGroup_Hierarchy (), this.ecorePackage.getEString (), "hierarchy", null, 0, -1, BlockGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.blockHandlerEClass, BlockHandler.class, "BlockHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getBlockHandler_Group (), getBlockGroup (), getBlockGroup_Handlers (), "group", null, 1, 1, BlockHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.globalSummaryItemEClass, GlobalSummaryItem.class, "GlobalSummaryItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getGlobalSummaryItem_Attribute (), this.ecorePackage.getEString (), "attribute", null, 1, 1, GlobalSummaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.weakReferenceDataSourceItemEClass, WeakReferenceDataSourceItem.class, "WeakReferenceDataSourceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getWeakReferenceDataSourceItem_DataSourceId (), this.ecorePackage.getEString (), "dataSourceId", null, 1, 1, WeakReferenceDataSourceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.alarmsEventsExporterEClass, AlarmsEventsExporter.class, "AlarmsEventsExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getAlarmsEventsExporter__GetTypeTag (), this.ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.alarmsEventsConnectionEClass, AlarmsEventsConnection.class, "AlarmsEventsConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getAlarmsEventsConnection__GetTypeTag (), this.ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getAlarmsEventsConnection__MakeUri__boolean (), this.ecorePackage.getEString (), "makeUri", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.ecorePackage.getEBoolean (), "localhost", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.monitorPoolProxyEClass, MonitorPoolProxy.class, "MonitorPoolProxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMonitorPoolProxy_Local (), getMonitorPool (), null, "local", null, 0, -1, MonitorPoolProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMonitorPoolProxy_Remote (), getMonitorPool (), null, "remote", null, 0, -1, MonitorPoolProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.eventPoolProxyEClass, EventPoolProxy.class, "EventPoolProxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEventPoolProxy_Local (), getEventPool (), null, "local", null, 0, -1, EventPoolProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEventPoolProxy_Remote (), getEventPool (), null, "remote", null, 0, -1, EventPoolProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventPoolProxy_Size (), this.ecorePackage.getEInt (), "size", null, 1, 1, EventPoolProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.alarmsEventsModuleEClass, AlarmsEventsModule.class, "AlarmsEventsModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAlarmsEventsModule_MonitorPoolProxies (), getMonitorPoolProxy (), null, "monitorPoolProxies", null, 0, -1, AlarmsEventsModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAlarmsEventsModule_EventPoolProxies (), getEventPoolProxy (), null, "eventPoolProxies", null, 0, -1, AlarmsEventsModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAlarmsEventsModule_AknProxies (), getAknProxy (), null, "aknProxies", null, 0, -1, AlarmsEventsModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAlarmsEventsModule_PullEvents (), getPullEvents (), null, "pullEvents", null, 0, -1, AlarmsEventsModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.aknProxyEClass, AknProxy.class, "AknProxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAknProxy_Pattern (), theWorldPackage.getPattern (), "pattern", null, 1, 1, AknProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAknProxy_Connection (), getAlarmsEventsConnection (), null, "connection", null, 1, 1, AknProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAknProxy_Priority (), this.ecorePackage.getEInt (), "priority", null, 1, 1, AknProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAknProxy_Authorative (), this.ecorePackage.getEBoolean (), "authorative", "true", 1, 1, AknProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.pullEventsEClass, PullEvents.class, "PullEvents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPullEvents_JdbcDriverName (), this.ecorePackage.getEString (), "jdbcDriverName", null, 1, 1, PullEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getPullEvents_JdbcProperties (), getPropertyEntry (), null, "jdbcProperties", null, 0, -1, PullEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPullEvents_JobInterval (), this.ecorePackage.getEIntegerObject (), "jobInterval", null, 0, 1, PullEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPullEvents_CustomSelectSql (), this.ecorePackage.getEString (), "customSelectSql", null, 0, 1, PullEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPullEvents_CustomDeleteSql (), this.ecorePackage.getEString (), "customDeleteSql", null, 0, 1, PullEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.jdbcUserServiceModuleEClass, JdbcUserServiceModule.class, "JdbcUserServiceModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getJdbcUserServiceModule_UserServices (), getJdbcUserService (), null, "userServices", null, 0, -1, JdbcUserServiceModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.jdbcUserServiceEClass, JdbcUserService.class, "JdbcUserService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getJdbcUserService_JdbcPropeties (), getPropertyEntry (), null, "jdbcPropeties", null, 0, -1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_JdbcDriver (), this.ecorePackage.getEString (), "jdbcDriver", null, 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_Authorative (), this.ecorePackage.getEBoolean (), "authorative", "true", 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getJdbcUserService_FindUserSql (), this.ecorePackage.getEString (), "findUserSql", null, 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_FindRolesForUserSql (), this.ecorePackage.getEString (), "findRolesForUserSql", null, 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_UpdatePasswordSql (), this.ecorePackage.getEString (), "updatePasswordSql", null, 0, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_UserIdColumnName (), this.ecorePackage.getEString (), "userIdColumnName", null, 0, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_PasswordColumnName (), this.ecorePackage.getEString (), "passwordColumnName", "password", 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getJdbcUserService_PasswordType (), getPasswordType (), "passwordType", null, 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.defaultValueArchiveServerEClass, DefaultValueArchiveServer.class, "DefaultValueArchiveServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.historicalDataExporterEClass, HistoricalDataExporter.class, "HistoricalDataExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getHistoricalDataExporter__GetTypeTag (), this.ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.valueArchiveEClass, ValueArchive.class, "ValueArchive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getValueArchive_Items (), getItem (), null, "items", null, 0, -1, ValueArchive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.configurationAdministratorExporterEClass, ConfigurationAdministratorExporter.class, "ConfigurationAdministratorExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getConfigurationAdministratorExporter__GetTypeTag (), this.ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.referenceItemEClass, ReferenceItem.class, "ReferenceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getReferenceItem_Source (), getItem (), null, "source", null, 1, 1, ReferenceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.eventStorageEClass, EventStorage.class, "EventStorage", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.eventStorageJdbcEClass, EventStorageJdbc.class, "EventStorageJdbc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventStorageJdbc_JdbcDriverName (), this.ecorePackage.getEString (), "jdbcDriverName", null, 1, 1, EventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventStorageJdbc_DriverBundles (), this.ecorePackage.getEString (), "driverBundles", null, 0, -1, EventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventStorageJdbc_MaxFieldLength (), this.ecorePackage.getEIntegerObject (), "maxFieldLength", null, 0, 1, EventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventStorageJdbc_QueryFetchSize (), this.ecorePackage.getEIntegerObject (), "queryFetchSize", null, 0, 1, EventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.eventStoragePostgresEClass, EventStoragePostgres.class, "EventStoragePostgres", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventStoragePostgres_BatchSize (), this.ecorePackage.getEIntegerObject (), "batchSize", null, 0, 1, EventStoragePostgres.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventStoragePostgres_PostgresDriverBundles (), this.ecorePackage.getEString (), "postgresDriverBundles", null, 0, -1, EventStoragePostgres.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getEventStoragePostgres__GetJdbcDriverName (), this.ecorePackage.getEString (), "getJdbcDriverName", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getEventStoragePostgres__GetDriverBundles (), this.ecorePackage.getEString (), "getDriverBundles", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.abstractEventStorageJdbcEClass, AbstractEventStorageJdbc.class, "AbstractEventStorageJdbc", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAbstractEventStorageJdbc_JdbcProperties (), getPropertyEntry (), null, "jdbcProperties", null, 0, -1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAbstractEventStorageJdbc_Schema (), this.ecorePackage.getEString (), "schema", null, 0, 1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAbstractEventStorageJdbc_InstanceName (), this.ecorePackage.getEString (), "instanceName", "default", 1, 1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getAbstractEventStorageJdbc_EnableReplication (), this.ecorePackage.getEBoolean (), "enableReplication", "false", 1, 1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getAbstractEventStorageJdbc_ArchiveDays (), this.ecorePackage.getEIntegerObject (), "archiveDays", null, 0, 1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAbstractEventStorageJdbc_CleanupPeriodSeconds (), this.ecorePackage.getEIntegerObject (), "cleanupPeriodSeconds", null, 0, 1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getAbstractEventStorageJdbc__GetJdbcDriverName (), this.ecorePackage.getEString (), "getJdbcDriverName", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getAbstractEventStorageJdbc__GetDriverBundles (), this.ecorePackage.getEString (), "getDriverBundles", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.applicationConfigurationEClass, ApplicationConfiguration.class, "ApplicationConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.restExporterEClass, RestExporter.class, "RestExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getRestExporter_Items (), getItem (), null, "items", null, 0, -1, RestExporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getRestExporter_HiveProperties (), getPropertyEntry (), null, "hiveProperties", null, 0, -1, RestExporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRestExporter_ContextId (), this.ecorePackage.getEString (), "contextId", null, 1, 1, RestExporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.httpServiceEClass, HttpService.class, "HttpService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getHttpService_Endpoint (), theWorldPackage.getEndpoint (), null, "endpoint", null, 1, 1, HttpService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.independentConfigurationEClass, IndependentConfiguration.class, "IndependentConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.transientItemEClass, TransientItem.class, "TransientItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.defaultEquinoxApplicationEClass, DefaultEquinoxApplication.class, "DefaultEquinoxApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDefaultEquinoxApplication_Profile (), theProfilePackage.getProfile (), null, "profile", null, 1, 1, DefaultEquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( this.averageReferenceTypeEEnum, AverageReferenceType.class, "AverageReferenceType" ); //$NON-NLS-1$
        addEEnumLiteral ( this.averageReferenceTypeEEnum, AverageReferenceType.MIN );
        addEEnumLiteral ( this.averageReferenceTypeEEnum, AverageReferenceType.MAX );
        addEEnumLiteral ( this.averageReferenceTypeEEnum, AverageReferenceType.MEAN );
        addEEnumLiteral ( this.averageReferenceTypeEEnum, AverageReferenceType.MEDIAN );
        addEEnumLiteral ( this.averageReferenceTypeEEnum, AverageReferenceType.DEVIATION );
        addEEnumLiteral ( this.averageReferenceTypeEEnum, AverageReferenceType.SUM );

        initEEnum ( this.movingAverageReferenceTypeEEnum, MovingAverageReferenceType.class, "MovingAverageReferenceType" ); //$NON-NLS-1$
        addEEnumLiteral ( this.movingAverageReferenceTypeEEnum, MovingAverageReferenceType.MIN );
        addEEnumLiteral ( this.movingAverageReferenceTypeEEnum, MovingAverageReferenceType.MAX );
        addEEnumLiteral ( this.movingAverageReferenceTypeEEnum, MovingAverageReferenceType.MEDIAN );
        addEEnumLiteral ( this.movingAverageReferenceTypeEEnum, MovingAverageReferenceType.ARITHMETIC );
        addEEnumLiteral ( this.movingAverageReferenceTypeEEnum, MovingAverageReferenceType.WEIGHTED );
        addEEnumLiteral ( this.movingAverageReferenceTypeEEnum, MovingAverageReferenceType.DEVIATION_ARITHMETIC );
        addEEnumLiteral ( this.movingAverageReferenceTypeEEnum, MovingAverageReferenceType.DEVIATION_WEIGHTED );

        initEEnum ( this.roundingTypeEEnum, RoundingType.class, "RoundingType" ); //$NON-NLS-1$
        addEEnumLiteral ( this.roundingTypeEEnum, RoundingType.NONE );
        addEEnumLiteral ( this.roundingTypeEEnum, RoundingType.ROUND );
        addEEnumLiteral ( this.roundingTypeEEnum, RoundingType.CEIL );
        addEEnumLiteral ( this.roundingTypeEEnum, RoundingType.FLOOR );

        initEEnum ( this.dataTypeEEnum, DataType.class, "DataType" ); //$NON-NLS-1$
        addEEnumLiteral ( this.dataTypeEEnum, DataType.VARIANT );
        addEEnumLiteral ( this.dataTypeEEnum, DataType.NULL );
        addEEnumLiteral ( this.dataTypeEEnum, DataType.INT32 );
        addEEnumLiteral ( this.dataTypeEEnum, DataType.INT64 );
        addEEnumLiteral ( this.dataTypeEEnum, DataType.FLOAT );
        addEEnumLiteral ( this.dataTypeEEnum, DataType.STRING );
        addEEnumLiteral ( this.dataTypeEEnum, DataType.BOOLEAN );

        initEEnum ( this.passwordTypeEEnum, PasswordType.class, "PasswordType" ); //$NON-NLS-1$
        addEEnumLiteral ( this.passwordTypeEEnum, PasswordType.PLAIN );
        addEEnumLiteral ( this.passwordTypeEEnum, PasswordType.PLAIN_IGNORE_CASE );
        addEEnumLiteral ( this.passwordTypeEEnum, PasswordType.MD5_HEX );
        addEEnumLiteral ( this.passwordTypeEEnum, PasswordType.SHA1_HEX );

        // Initialize data types
        initEDataType ( this.severityEDataType, Severity.class, "Severity", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( this.variantEDataType, Variant.class, "Variant", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create annotations
        // http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup
        createExclusiveGroupAnnotations ();
    }

    /**
     * Initializes the annotations for
     * <b>http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void createExclusiveGroupAnnotations ()
    {
        final String source = "http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup"; //$NON-NLS-1$																				
        addAnnotation ( this.eventStorageEClass,
                source,
                new String[]
                { "groupId", "ae.storage" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( this.httpServiceEClass,
                source,
                new String[]
                { "groupId", "http.service" //$NON-NLS-1$ //$NON-NLS-2$
                } );
    }

} //OsgiPackageImpl
