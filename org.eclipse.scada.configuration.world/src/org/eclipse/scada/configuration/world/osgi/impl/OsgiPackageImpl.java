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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl;
import org.eclipse.scada.configuration.world.impl.WorldPackageImpl;
import org.eclipse.scada.configuration.world.osgi.*;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OsgiPackageImpl extends EPackageImpl implements OsgiPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass equinoxApplicationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass connectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass exporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataAccessConnectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataAccessExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass sourceItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemExportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemInformationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass levelMonitorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemFeatureEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass importItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass summaryGroupEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass markerGroupEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass markersEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass constantItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass summaryItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass markerEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass manualOverrideEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass masterServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueArchiveServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass defaultMasterServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass customMasterServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass applicationModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributesSummaryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventLoggerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass monitorPoolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventPoolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataMapperEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleDataMapperEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass jdbcDataMapperEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataMapperEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueMapperEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass persistentItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass proxyItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scaleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass negateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass roundingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass externalEventMonitorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass externalEventFilterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass staticExternalEventFilterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleExternalEventFilterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typedItemReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass codeFragmentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptTimerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass formulaItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass formulaItemOutboundEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass formulaItemInboundEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass booleanMonitorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass listMonitorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass listMonitorEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass averageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass movingAverageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass averageItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass movingAverageItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass blockingsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass blockGroupEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass blockHandlerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass blockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass globalSummaryItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass weakReferenceDataSourceItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass alarmsEventsExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass alarmsEventsConnectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass monitorPoolProxyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventPoolProxyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass alarmsEventsModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass aknProxyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass pullEventsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass jdbcUserServiceModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass jdbcUserServiceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass defaultValueArchiveServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass historicalDataExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueArchiveEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass configurationAdministratorExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass referenceItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventStorageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventStorageJdbcEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventStoragePostgresEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractEventStorageJdbcEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass applicationConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass restExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass httpServiceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass independentConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass transientItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass defaultEquinoxApplicationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass changeCounterItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass bufferedValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass telnetConsoleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum averageReferenceTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum movingAverageReferenceTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum roundingTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum dataTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum passwordTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum persistenceEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum errorHandlingEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum changeTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType severityEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
            return (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );

        // Obtain or create and register package
        OsgiPackageImpl theOsgiPackage = (OsgiPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof OsgiPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new OsgiPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass ();
        ConfigurationPackage.eINSTANCE.eClass ();
        SecurityPackage.eINSTANCE.eClass ();

        // Obtain or create and register interdependencies
        WorldPackageImpl theWorldPackage = (WorldPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) instanceof WorldPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) : WorldPackage.eINSTANCE );
        ProfilePackageImpl theProfilePackage = (ProfilePackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) instanceof ProfilePackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) : ProfilePackage.eINSTANCE );
        DeploymentPackageImpl theDeploymentPackage = (DeploymentPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI ) instanceof DeploymentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI ) : DeploymentPackage.eINSTANCE );

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
     * @generated
     */
    @Override
    public EClass getEquinoxApplication ()
    {
        return equinoxApplicationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_Connections ()
    {
        return (EReference)equinoxApplicationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_Exporter ()
    {
        return (EReference)equinoxApplicationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_CustomizationProfile ()
    {
        return (EReference)equinoxApplicationEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_SecurityConfiguration ()
    {
        return (EReference)equinoxApplicationEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_Modules ()
    {
        return (EReference)equinoxApplicationEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getEquinoxApplication__GetProfile ()
    {
        return equinoxApplicationEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getConnection ()
    {
        return connectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getConnection_Endpoint ()
    {
        return (EReference)connectionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getConnection_EndpointLabel ()
    {
        return (EAttribute)connectionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getConnection_Credentials ()
    {
        return (EReference)connectionEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getConnection_Timeout ()
    {
        return (EAttribute)connectionEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getConnection__GetTypeTag ()
    {
        return connectionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getConnection__GetPossibleEndpoints__Exporter ()
    {
        return connectionEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getConnection__MakeUri__boolean ()
    {
        return connectionEClass.getEOperations ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getConnection__GetMatchingEndpoint__Exporter ()
    {
        return connectionEClass.getEOperations ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getExporter ()
    {
        return exporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getExporter_Endpoints ()
    {
        return (EReference)exporterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getExporter__GetTypeTag ()
    {
        return exporterEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDataAccessConnection ()
    {
        return dataAccessConnectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataAccessConnection__GetTypeTag ()
    {
        return dataAccessConnectionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataAccessConnection__MakeUri__boolean ()
    {
        return dataAccessConnectionEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDataAccessExporter ()
    {
        return dataAccessExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDataAccessExporter_Exports ()
    {
        return (EReference)dataAccessExporterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDataAccessExporter__GetTypeTag ()
    {
        return dataAccessExporterEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getItem ()
    {
        return itemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItem_Name ()
    {
        return (EAttribute)itemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getItem_Information ()
    {
        return (EReference)itemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getItem_ItemFeatures ()
    {
        return (EReference)itemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getSourceItem ()
    {
        return sourceItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSourceItem_Connection ()
    {
        return (EReference)sourceItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getSourceItem_SourceName ()
    {
        return (EAttribute)sourceItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getItemExport ()
    {
        return itemExportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getItemExport_Item ()
    {
        return (EReference)itemExportEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItemExport_ExportName ()
    {
        return (EAttribute)itemExportEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getItemInformation ()
    {
        return itemInformationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItemInformation_Description ()
    {
        return (EAttribute)itemInformationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItemInformation_Unit ()
    {
        return (EAttribute)itemInformationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItemInformation_Hierarchy ()
    {
        return (EAttribute)itemInformationEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItemInformation_System ()
    {
        return (EAttribute)itemInformationEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItemInformation_DataType ()
    {
        return (EAttribute)itemInformationEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getLevelMonitor ()
    {
        return levelMonitorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_Preset ()
    {
        return (EAttribute)levelMonitorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_Cap ()
    {
        return (EAttribute)levelMonitorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_Severity ()
    {
        return (EAttribute)levelMonitorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_LowerOk ()
    {
        return (EAttribute)levelMonitorEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_IncludedOk ()
    {
        return (EAttribute)levelMonitorEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_Prefix ()
    {
        return (EAttribute)levelMonitorEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_DemotePrefix ()
    {
        return (EAttribute)levelMonitorEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_SuppressEvents ()
    {
        return (EAttribute)levelMonitorEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_RequireAck ()
    {
        return (EAttribute)levelMonitorEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLevelMonitor_MonitorType ()
    {
        return (EAttribute)levelMonitorEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getItemFeatureEntry ()
    {
        return itemFeatureEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItemFeatureEntry_Name ()
    {
        return (EAttribute)itemFeatureEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getItemFeatureEntry_Item ()
    {
        return (EReference)itemFeatureEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getScriptItem ()
    {
        return scriptItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getScriptItem_Inputs ()
    {
        return (EReference)scriptItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getScriptItem_InitScript ()
    {
        return (EReference)scriptItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getScriptItem_UpdateScript ()
    {
        return (EReference)scriptItemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getScriptItem_Timer ()
    {
        return (EReference)scriptItemEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getScriptItem_ScriptEngine ()
    {
        return (EAttribute)scriptItemEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getScriptItem_Commands ()
    {
        return (EReference)scriptItemEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getScriptItem_WriteCommandScript ()
    {
        return (EReference)scriptItemEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getImportItem ()
    {
        return importItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getImportItem_Export ()
    {
        return (EReference)importItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getSummaryGroup ()
    {
        return summaryGroupEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getSummaryGroup_Name ()
    {
        return (EAttribute)summaryGroupEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSummaryGroup_SubGroups ()
    {
        return (EReference)summaryGroupEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSummaryGroup_Items ()
    {
        return (EReference)summaryGroupEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getMarkerGroup ()
    {
        return markerGroupEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMarkerGroup_Name ()
    {
        return (EAttribute)markerGroupEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMarkerGroup_Markers ()
    {
        return (EReference)markerGroupEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getMarkers ()
    {
        return markersEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMarkers_MarkerGroups ()
    {
        return (EReference)markersEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getConstantItem ()
    {
        return constantItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getConstantItem_Value ()
    {
        return (EAttribute)constantItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getSummaryItem ()
    {
        return summaryItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSummaryItem_Group ()
    {
        return (EReference)summaryItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getMarkerEntry ()
    {
        return markerEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMarkerEntry_Name ()
    {
        return (EAttribute)markerEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMarkerEntry_Value ()
    {
        return (EAttribute)markerEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getManualOverride ()
    {
        return manualOverrideEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getManualOverride_InitialValue ()
    {
        return (EAttribute)manualOverrideEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getMasterServer ()
    {
        return masterServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_SummaryGroups ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_Items ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_Markers ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMasterServer_AeServerInformationPrefix ()
    {
        return (EAttribute)masterServerEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_MonitorPools ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_EventPools ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_DataMapper ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_ExternalEventMonitors ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_ExternalEventFilters ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_Averages ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_MovingAverages ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 10 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMasterServer_BufferedValues ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 11 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getValueArchiveServer ()
    {
        return valueArchiveServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getValueArchiveServer_Archives ()
    {
        return (EReference)valueArchiveServerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDefaultMasterServer ()
    {
        return defaultMasterServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getCustomMasterServer ()
    {
        return customMasterServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getCustomMasterServer_Profile ()
    {
        return (EReference)customMasterServerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getApplicationModule ()
    {
        return applicationModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAttributesSummary ()
    {
        return attributesSummaryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAttributesSummary_Attributes ()
    {
        return (EAttribute)attributesSummaryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAttributesSummary_OutputPrefix ()
    {
        return (EAttribute)attributesSummaryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEventLogger ()
    {
        return eventLoggerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventLogger_LogAttributesChange ()
    {
        return (EAttribute)eventLoggerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventLogger_LogValueChange ()
    {
        return (EAttribute)eventLoggerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventLogger_LogSubscriptionChange ()
    {
        return (EAttribute)eventLoggerEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventLogger_LogWrites ()
    {
        return (EAttribute)eventLoggerEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getMonitorPool ()
    {
        return monitorPoolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMonitorPool_Filter ()
    {
        return (EAttribute)monitorPoolEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEventPool ()
    {
        return eventPoolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventPool_Filter ()
    {
        return (EAttribute)eventPoolEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventPool_Size ()
    {
        return (EAttribute)eventPoolEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDataMapper ()
    {
        return dataMapperEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getSimpleDataMapper ()
    {
        return simpleDataMapperEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSimpleDataMapper_Entries ()
    {
        return (EReference)simpleDataMapperEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getJdbcDataMapper ()
    {
        return jdbcDataMapperEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getJdbcDataMapper_JdbcDriver ()
    {
        return (EAttribute)jdbcDataMapperEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getJdbcDataMapper_Sql ()
    {
        return (EAttribute)jdbcDataMapperEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getJdbcDataMapper_Properties ()
    {
        return (EReference)jdbcDataMapperEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDataMapperEntry ()
    {
        return dataMapperEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDataMapperEntry_Key ()
    {
        return (EAttribute)dataMapperEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDataMapperEntry_Value ()
    {
        return (EAttribute)dataMapperEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getValueMapper ()
    {
        return valueMapperEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getValueMapper_SourceAttribute ()
    {
        return (EAttribute)valueMapperEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getValueMapper_TargetAttribute ()
    {
        return (EAttribute)valueMapperEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getValueMapper_DataMapper ()
    {
        return (EReference)valueMapperEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPersistentItem ()
    {
        return persistentItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getProxyItem ()
    {
        return proxyItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getProxyItem_Items ()
    {
        return (EReference)proxyItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getScale ()
    {
        return scaleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getScale_Active ()
    {
        return (EAttribute)scaleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getScale_Factor ()
    {
        return (EAttribute)scaleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getScale_Offset ()
    {
        return (EAttribute)scaleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getNegate ()
    {
        return negateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getNegate_Active ()
    {
        return (EAttribute)negateEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getRounding ()
    {
        return roundingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getRounding_Type ()
    {
        return (EAttribute)roundingEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getExternalEventMonitor ()
    {
        return externalEventMonitorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getExternalEventMonitor_Filter ()
    {
        return (EAttribute)externalEventMonitorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getExternalEventMonitor_Properties ()
    {
        return (EReference)externalEventMonitorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getExternalEventFilter ()
    {
        return externalEventFilterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getStaticExternalEventFilter ()
    {
        return staticExternalEventFilterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getStaticExternalEventFilter_Value ()
    {
        return (EAttribute)staticExternalEventFilterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getSimpleExternalEventFilter ()
    {
        return simpleExternalEventFilterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getSimpleExternalEventFilter_Filter ()
    {
        return (EAttribute)simpleExternalEventFilterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getTypedItemReference ()
    {
        return typedItemReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getTypedItemReference_Type ()
    {
        return (EAttribute)typedItemReferenceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getCodeFragment ()
    {
        return codeFragmentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getCodeFragment_Code ()
    {
        return (EAttribute)codeFragmentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getScriptTimer ()
    {
        return scriptTimerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getScriptTimer_Script ()
    {
        return (EReference)scriptTimerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getScriptTimer_Period ()
    {
        return (EAttribute)scriptTimerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getItemReference ()
    {
        return itemReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getItemReference_Item ()
    {
        return (EReference)itemReferenceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItemReference_Name ()
    {
        return (EAttribute)itemReferenceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getFormulaItem ()
    {
        return formulaItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getFormulaItem_ScriptEngine ()
    {
        return (EAttribute)formulaItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getFormulaItem_InitScripts ()
    {
        return (EReference)formulaItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getFormulaItem_Outbound ()
    {
        return (EReference)formulaItemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getFormulaItem_Inbound ()
    {
        return (EReference)formulaItemEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getFormulaItemOutbound ()
    {
        return formulaItemOutboundEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getFormulaItemOutbound_Output ()
    {
        return (EReference)formulaItemOutboundEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getFormulaItemOutbound_OutputFormula ()
    {
        return (EAttribute)formulaItemOutboundEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getFormulaItemOutbound_WriteValueVariableName ()
    {
        return (EAttribute)formulaItemOutboundEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getFormulaItemInbound ()
    {
        return formulaItemInboundEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getFormulaItemInbound_Inputs ()
    {
        return (EReference)formulaItemInboundEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getFormulaItemInbound_InputFormula ()
    {
        return (EAttribute)formulaItemInboundEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getBooleanMonitor ()
    {
        return booleanMonitorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_ReferenceValue ()
    {
        return (EAttribute)booleanMonitorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_Active ()
    {
        return (EAttribute)booleanMonitorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_DemotePrefix ()
    {
        return (EAttribute)booleanMonitorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_Severity ()
    {
        return (EAttribute)booleanMonitorEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_Message ()
    {
        return (EAttribute)booleanMonitorEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_SuppressEvents ()
    {
        return (EAttribute)booleanMonitorEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getBooleanMonitor_RequireAck ()
    {
        return (EAttribute)booleanMonitorEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getListMonitor ()
    {
        return listMonitorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getListMonitor_Message ()
    {
        return (EAttribute)listMonitorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getListMonitor_MessageAttribute ()
    {
        return (EAttribute)listMonitorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getListMonitor_DefaultAck ()
    {
        return (EAttribute)listMonitorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getListMonitor_DefaultSeverity ()
    {
        return (EAttribute)listMonitorEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getListMonitor_MonitorType ()
    {
        return (EAttribute)listMonitorEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getListMonitor_DemotePrefix ()
    {
        return (EAttribute)listMonitorEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getListMonitor_Entries ()
    {
        return (EReference)listMonitorEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getListMonitorEntry ()
    {
        return listMonitorEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getListMonitorEntry_Value ()
    {
        return (EAttribute)listMonitorEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getListMonitorEntry_RequireAck ()
    {
        return (EAttribute)listMonitorEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getListMonitorEntry_Severity ()
    {
        return (EAttribute)listMonitorEntryEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAverage ()
    {
        return averageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAverage_Items ()
    {
        return (EReference)averageEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAverage_SourcesRequired ()
    {
        return (EAttribute)averageEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getMovingAverage ()
    {
        return movingAverageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMovingAverage_Item ()
    {
        return (EReference)movingAverageEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMovingAverage_Range ()
    {
        return (EAttribute)movingAverageEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMovingAverage_NullRange ()
    {
        return (EAttribute)movingAverageEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMovingAverage_Trigger ()
    {
        return (EAttribute)movingAverageEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMovingAverage_TriggerOnly ()
    {
        return (EAttribute)movingAverageEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAverageItem ()
    {
        return averageItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAverageItem_Source ()
    {
        return (EReference)averageItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAverageItem_Type ()
    {
        return (EAttribute)averageItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getMovingAverageItem ()
    {
        return movingAverageItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMovingAverageItem_Source ()
    {
        return (EReference)movingAverageItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMovingAverageItem_Type ()
    {
        return (EAttribute)movingAverageItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getBlockings ()
    {
        return blockingsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getBlockings_Groups ()
    {
        return (EReference)blockingsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getBlockGroup ()
    {
        return blockGroupEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getBlockGroup_Handlers ()
    {
        return (EReference)blockGroupEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getBlockGroup_Hierarchy ()
    {
        return (EAttribute)blockGroupEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getBlockHandler ()
    {
        return blockHandlerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getBlockHandler_Group ()
    {
        return (EReference)blockHandlerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getBlock ()
    {
        return blockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getGlobalSummaryItem ()
    {
        return globalSummaryItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getGlobalSummaryItem_Attribute ()
    {
        return (EAttribute)globalSummaryItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getWeakReferenceDataSourceItem ()
    {
        return weakReferenceDataSourceItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getWeakReferenceDataSourceItem_DataSourceId ()
    {
        return (EAttribute)weakReferenceDataSourceItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAlarmsEventsExporter ()
    {
        return alarmsEventsExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAlarmsEventsExporter__GetTypeTag ()
    {
        return alarmsEventsExporterEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAlarmsEventsConnection ()
    {
        return alarmsEventsConnectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAlarmsEventsConnection__GetTypeTag ()
    {
        return alarmsEventsConnectionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAlarmsEventsConnection__MakeUri__boolean ()
    {
        return alarmsEventsConnectionEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getMonitorPoolProxy ()
    {
        return monitorPoolProxyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMonitorPoolProxy_Local ()
    {
        return (EReference)monitorPoolProxyEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMonitorPoolProxy_Remote ()
    {
        return (EReference)monitorPoolProxyEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEventPoolProxy ()
    {
        return eventPoolProxyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEventPoolProxy_Local ()
    {
        return (EReference)eventPoolProxyEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEventPoolProxy_Remote ()
    {
        return (EReference)eventPoolProxyEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventPoolProxy_Size ()
    {
        return (EAttribute)eventPoolProxyEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAlarmsEventsModule ()
    {
        return alarmsEventsModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAlarmsEventsModule_MonitorPoolProxies ()
    {
        return (EReference)alarmsEventsModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAlarmsEventsModule_EventPoolProxies ()
    {
        return (EReference)alarmsEventsModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAlarmsEventsModule_AknProxies ()
    {
        return (EReference)alarmsEventsModuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAlarmsEventsModule_PullEvents ()
    {
        return (EReference)alarmsEventsModuleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAknProxy ()
    {
        return aknProxyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAknProxy_Pattern ()
    {
        return (EAttribute)aknProxyEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAknProxy_Connection ()
    {
        return (EReference)aknProxyEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAknProxy_Priority ()
    {
        return (EAttribute)aknProxyEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAknProxy_Authorative ()
    {
        return (EAttribute)aknProxyEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPullEvents ()
    {
        return pullEventsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPullEvents_JdbcDriverName ()
    {
        return (EAttribute)pullEventsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPullEvents_JdbcProperties ()
    {
        return (EReference)pullEventsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPullEvents_JobInterval ()
    {
        return (EAttribute)pullEventsEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPullEvents_CustomSelectSql ()
    {
        return (EAttribute)pullEventsEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPullEvents_CustomDeleteSql ()
    {
        return (EAttribute)pullEventsEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getJdbcUserServiceModule ()
    {
        return jdbcUserServiceModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getJdbcUserServiceModule_UserServices ()
    {
        return (EReference)jdbcUserServiceModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getJdbcUserService ()
    {
        return jdbcUserServiceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getJdbcUserService_JdbcPropeties ()
    {
        return (EReference)jdbcUserServiceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_JdbcDriver ()
    {
        return (EAttribute)jdbcUserServiceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_Authorative ()
    {
        return (EAttribute)jdbcUserServiceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_FindUserSql ()
    {
        return (EAttribute)jdbcUserServiceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_FindRolesForUserSql ()
    {
        return (EAttribute)jdbcUserServiceEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_UpdatePasswordSql ()
    {
        return (EAttribute)jdbcUserServiceEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_UserIdColumnName ()
    {
        return (EAttribute)jdbcUserServiceEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_PasswordColumnName ()
    {
        return (EAttribute)jdbcUserServiceEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getJdbcUserService_PasswordType ()
    {
        return (EAttribute)jdbcUserServiceEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDefaultValueArchiveServer ()
    {
        return defaultValueArchiveServerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getHistoricalDataExporter ()
    {
        return historicalDataExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getHistoricalDataExporter__GetTypeTag ()
    {
        return historicalDataExporterEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getValueArchive ()
    {
        return valueArchiveEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getValueArchive_Items ()
    {
        return (EReference)valueArchiveEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getConfigurationAdministratorExporter ()
    {
        return configurationAdministratorExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getConfigurationAdministratorExporter__GetTypeTag ()
    {
        return configurationAdministratorExporterEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getReferenceItem ()
    {
        return referenceItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getReferenceItem_Source ()
    {
        return (EReference)referenceItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEventStorage ()
    {
        return eventStorageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEventStorageJdbc ()
    {
        return eventStorageJdbcEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventStorageJdbc_JdbcDriverName ()
    {
        return (EAttribute)eventStorageJdbcEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventStorageJdbc_DriverBundles ()
    {
        return (EAttribute)eventStorageJdbcEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventStorageJdbc_MaxFieldLength ()
    {
        return (EAttribute)eventStorageJdbcEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventStorageJdbc_QueryFetchSize ()
    {
        return (EAttribute)eventStorageJdbcEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEventStoragePostgres ()
    {
        return eventStoragePostgresEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventStoragePostgres_BatchSize ()
    {
        return (EAttribute)eventStoragePostgresEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEventStoragePostgres_PostgresDriverBundles ()
    {
        return (EAttribute)eventStoragePostgresEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getEventStoragePostgres__GetJdbcDriverName ()
    {
        return eventStoragePostgresEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getEventStoragePostgres__GetDriverBundles ()
    {
        return eventStoragePostgresEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAbstractEventStorageJdbc ()
    {
        return abstractEventStorageJdbcEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAbstractEventStorageJdbc_JdbcProperties ()
    {
        return (EReference)abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEventStorageJdbc_Schema ()
    {
        return (EAttribute)abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEventStorageJdbc_InstanceName ()
    {
        return (EAttribute)abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEventStorageJdbc_EnableReplication ()
    {
        return (EAttribute)abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEventStorageJdbc_ArchiveDays ()
    {
        return (EAttribute)abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEventStorageJdbc_CleanupPeriodSeconds ()
    {
        return (EAttribute)abstractEventStorageJdbcEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAbstractEventStorageJdbc__GetJdbcDriverName ()
    {
        return abstractEventStorageJdbcEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAbstractEventStorageJdbc__GetDriverBundles ()
    {
        return abstractEventStorageJdbcEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getApplicationConfiguration ()
    {
        return applicationConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getRestExporter ()
    {
        return restExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getRestExporter_Items ()
    {
        return (EReference)restExporterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getRestExporter_HiveProperties ()
    {
        return (EReference)restExporterEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getRestExporter_ContextId ()
    {
        return (EAttribute)restExporterEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getHttpService ()
    {
        return httpServiceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getHttpService_Endpoint ()
    {
        return (EReference)httpServiceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIndependentConfiguration ()
    {
        return independentConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getTransientItem ()
    {
        return transientItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDefaultEquinoxApplication ()
    {
        return defaultEquinoxApplicationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDefaultEquinoxApplication_Profile ()
    {
        return (EReference)defaultEquinoxApplicationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getChangeCounterItem ()
    {
        return changeCounterItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChangeCounterItem_Buffer ()
    {
        return (EReference)changeCounterItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChangeCounterItem_Type ()
    {
        return (EAttribute)changeCounterItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChangeCounterItem_OnError ()
    {
        return (EAttribute)changeCounterItemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChangeCounterItem_Values ()
    {
        return (EAttribute)changeCounterItemEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBufferedValue ()
    {
        return bufferedValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getBufferedValue_Item ()
    {
        return (EReference)bufferedValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBufferedValue_InitialValue ()
    {
        return (EAttribute)bufferedValueEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBufferedValue_Range ()
    {
        return (EAttribute)bufferedValueEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBufferedValue_Trigger ()
    {
        return (EAttribute)bufferedValueEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBufferedValue_TriggerOnly ()
    {
        return (EAttribute)bufferedValueEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBufferedValue_Persistence ()
    {
        return (EAttribute)bufferedValueEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTelnetConsole ()
    {
        return telnetConsoleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTelnetConsole_Host ()
    {
        return (EAttribute)telnetConsoleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTelnetConsole_Port ()
    {
        return (EAttribute)telnetConsoleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getAverageReferenceType ()
    {
        return averageReferenceTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getMovingAverageReferenceType ()
    {
        return movingAverageReferenceTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getRoundingType ()
    {
        return roundingTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getDataType ()
    {
        return dataTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getPasswordType ()
    {
        return passwordTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getPersistence ()
    {
        return persistenceEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getErrorHandling ()
    {
        return errorHandlingEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getChangeType ()
    {
        return changeTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getSeverity ()
    {
        return severityEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getVariant ()
    {
        return variantEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMarkerGroup_Items ()
    {
        return (EReference)markerGroupEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents ()
    {
        if ( isCreated )
            return;
        isCreated = true;

        // Create classes and their features
        equinoxApplicationEClass = createEClass ( EQUINOX_APPLICATION );
        createEReference ( equinoxApplicationEClass, EQUINOX_APPLICATION__CONNECTIONS );
        createEReference ( equinoxApplicationEClass, EQUINOX_APPLICATION__EXPORTER );
        createEReference ( equinoxApplicationEClass, EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE );
        createEReference ( equinoxApplicationEClass, EQUINOX_APPLICATION__SECURITY_CONFIGURATION );
        createEReference ( equinoxApplicationEClass, EQUINOX_APPLICATION__MODULES );
        createEOperation ( equinoxApplicationEClass, EQUINOX_APPLICATION___GET_PROFILE );

        connectionEClass = createEClass ( CONNECTION );
        createEReference ( connectionEClass, CONNECTION__ENDPOINT );
        createEAttribute ( connectionEClass, CONNECTION__ENDPOINT_LABEL );
        createEReference ( connectionEClass, CONNECTION__CREDENTIALS );
        createEAttribute ( connectionEClass, CONNECTION__TIMEOUT );
        createEOperation ( connectionEClass, CONNECTION___GET_TYPE_TAG );
        createEOperation ( connectionEClass, CONNECTION___GET_POSSIBLE_ENDPOINTS__EXPORTER );
        createEOperation ( connectionEClass, CONNECTION___MAKE_URI__BOOLEAN );
        createEOperation ( connectionEClass, CONNECTION___GET_MATCHING_ENDPOINT__EXPORTER );

        exporterEClass = createEClass ( EXPORTER );
        createEReference ( exporterEClass, EXPORTER__ENDPOINTS );
        createEOperation ( exporterEClass, EXPORTER___GET_TYPE_TAG );

        dataAccessConnectionEClass = createEClass ( DATA_ACCESS_CONNECTION );
        createEOperation ( dataAccessConnectionEClass, DATA_ACCESS_CONNECTION___GET_TYPE_TAG );
        createEOperation ( dataAccessConnectionEClass, DATA_ACCESS_CONNECTION___MAKE_URI__BOOLEAN );

        dataAccessExporterEClass = createEClass ( DATA_ACCESS_EXPORTER );
        createEReference ( dataAccessExporterEClass, DATA_ACCESS_EXPORTER__EXPORTS );
        createEOperation ( dataAccessExporterEClass, DATA_ACCESS_EXPORTER___GET_TYPE_TAG );

        itemEClass = createEClass ( ITEM );
        createEAttribute ( itemEClass, ITEM__NAME );
        createEReference ( itemEClass, ITEM__INFORMATION );
        createEReference ( itemEClass, ITEM__ITEM_FEATURES );

        sourceItemEClass = createEClass ( SOURCE_ITEM );
        createEReference ( sourceItemEClass, SOURCE_ITEM__CONNECTION );
        createEAttribute ( sourceItemEClass, SOURCE_ITEM__SOURCE_NAME );

        itemExportEClass = createEClass ( ITEM_EXPORT );
        createEReference ( itemExportEClass, ITEM_EXPORT__ITEM );
        createEAttribute ( itemExportEClass, ITEM_EXPORT__EXPORT_NAME );

        itemInformationEClass = createEClass ( ITEM_INFORMATION );
        createEAttribute ( itemInformationEClass, ITEM_INFORMATION__DESCRIPTION );
        createEAttribute ( itemInformationEClass, ITEM_INFORMATION__UNIT );
        createEAttribute ( itemInformationEClass, ITEM_INFORMATION__HIERARCHY );
        createEAttribute ( itemInformationEClass, ITEM_INFORMATION__SYSTEM );
        createEAttribute ( itemInformationEClass, ITEM_INFORMATION__DATA_TYPE );

        levelMonitorEClass = createEClass ( LEVEL_MONITOR );
        createEAttribute ( levelMonitorEClass, LEVEL_MONITOR__PRESET );
        createEAttribute ( levelMonitorEClass, LEVEL_MONITOR__CAP );
        createEAttribute ( levelMonitorEClass, LEVEL_MONITOR__SEVERITY );
        createEAttribute ( levelMonitorEClass, LEVEL_MONITOR__LOWER_OK );
        createEAttribute ( levelMonitorEClass, LEVEL_MONITOR__INCLUDED_OK );
        createEAttribute ( levelMonitorEClass, LEVEL_MONITOR__PREFIX );
        createEAttribute ( levelMonitorEClass, LEVEL_MONITOR__DEMOTE_PREFIX );
        createEAttribute ( levelMonitorEClass, LEVEL_MONITOR__SUPPRESS_EVENTS );
        createEAttribute ( levelMonitorEClass, LEVEL_MONITOR__REQUIRE_ACK );
        createEAttribute ( levelMonitorEClass, LEVEL_MONITOR__MONITOR_TYPE );

        itemFeatureEntryEClass = createEClass ( ITEM_FEATURE_ENTRY );
        createEAttribute ( itemFeatureEntryEClass, ITEM_FEATURE_ENTRY__NAME );
        createEReference ( itemFeatureEntryEClass, ITEM_FEATURE_ENTRY__ITEM );

        scriptItemEClass = createEClass ( SCRIPT_ITEM );
        createEReference ( scriptItemEClass, SCRIPT_ITEM__INPUTS );
        createEReference ( scriptItemEClass, SCRIPT_ITEM__INIT_SCRIPT );
        createEReference ( scriptItemEClass, SCRIPT_ITEM__UPDATE_SCRIPT );
        createEReference ( scriptItemEClass, SCRIPT_ITEM__TIMER );
        createEAttribute ( scriptItemEClass, SCRIPT_ITEM__SCRIPT_ENGINE );
        createEReference ( scriptItemEClass, SCRIPT_ITEM__COMMANDS );
        createEReference ( scriptItemEClass, SCRIPT_ITEM__WRITE_COMMAND_SCRIPT );

        importItemEClass = createEClass ( IMPORT_ITEM );
        createEReference ( importItemEClass, IMPORT_ITEM__EXPORT );

        summaryGroupEClass = createEClass ( SUMMARY_GROUP );
        createEAttribute ( summaryGroupEClass, SUMMARY_GROUP__NAME );
        createEReference ( summaryGroupEClass, SUMMARY_GROUP__SUB_GROUPS );
        createEReference ( summaryGroupEClass, SUMMARY_GROUP__ITEMS );

        markerGroupEClass = createEClass ( MARKER_GROUP );
        createEReference ( markerGroupEClass, MARKER_GROUP__ITEMS );
        createEAttribute ( markerGroupEClass, MARKER_GROUP__NAME );
        createEReference ( markerGroupEClass, MARKER_GROUP__MARKERS );

        markersEClass = createEClass ( MARKERS );
        createEReference ( markersEClass, MARKERS__MARKER_GROUPS );

        constantItemEClass = createEClass ( CONSTANT_ITEM );
        createEAttribute ( constantItemEClass, CONSTANT_ITEM__VALUE );

        summaryItemEClass = createEClass ( SUMMARY_ITEM );
        createEReference ( summaryItemEClass, SUMMARY_ITEM__GROUP );

        markerEntryEClass = createEClass ( MARKER_ENTRY );
        createEAttribute ( markerEntryEClass, MARKER_ENTRY__NAME );
        createEAttribute ( markerEntryEClass, MARKER_ENTRY__VALUE );

        manualOverrideEClass = createEClass ( MANUAL_OVERRIDE );
        createEAttribute ( manualOverrideEClass, MANUAL_OVERRIDE__INITIAL_VALUE );

        masterServerEClass = createEClass ( MASTER_SERVER );
        createEReference ( masterServerEClass, MASTER_SERVER__SUMMARY_GROUPS );
        createEReference ( masterServerEClass, MASTER_SERVER__ITEMS );
        createEReference ( masterServerEClass, MASTER_SERVER__MARKERS );
        createEAttribute ( masterServerEClass, MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX );
        createEReference ( masterServerEClass, MASTER_SERVER__MONITOR_POOLS );
        createEReference ( masterServerEClass, MASTER_SERVER__EVENT_POOLS );
        createEReference ( masterServerEClass, MASTER_SERVER__DATA_MAPPER );
        createEReference ( masterServerEClass, MASTER_SERVER__EXTERNAL_EVENT_MONITORS );
        createEReference ( masterServerEClass, MASTER_SERVER__EXTERNAL_EVENT_FILTERS );
        createEReference ( masterServerEClass, MASTER_SERVER__AVERAGES );
        createEReference ( masterServerEClass, MASTER_SERVER__MOVING_AVERAGES );
        createEReference ( masterServerEClass, MASTER_SERVER__BUFFERED_VALUES );

        valueArchiveServerEClass = createEClass ( VALUE_ARCHIVE_SERVER );
        createEReference ( valueArchiveServerEClass, VALUE_ARCHIVE_SERVER__ARCHIVES );

        defaultMasterServerEClass = createEClass ( DEFAULT_MASTER_SERVER );

        customMasterServerEClass = createEClass ( CUSTOM_MASTER_SERVER );
        createEReference ( customMasterServerEClass, CUSTOM_MASTER_SERVER__PROFILE );

        applicationModuleEClass = createEClass ( APPLICATION_MODULE );

        attributesSummaryEClass = createEClass ( ATTRIBUTES_SUMMARY );
        createEAttribute ( attributesSummaryEClass, ATTRIBUTES_SUMMARY__ATTRIBUTES );
        createEAttribute ( attributesSummaryEClass, ATTRIBUTES_SUMMARY__OUTPUT_PREFIX );

        eventLoggerEClass = createEClass ( EVENT_LOGGER );
        createEAttribute ( eventLoggerEClass, EVENT_LOGGER__LOG_ATTRIBUTES_CHANGE );
        createEAttribute ( eventLoggerEClass, EVENT_LOGGER__LOG_VALUE_CHANGE );
        createEAttribute ( eventLoggerEClass, EVENT_LOGGER__LOG_SUBSCRIPTION_CHANGE );
        createEAttribute ( eventLoggerEClass, EVENT_LOGGER__LOG_WRITES );

        monitorPoolEClass = createEClass ( MONITOR_POOL );
        createEAttribute ( monitorPoolEClass, MONITOR_POOL__FILTER );

        eventPoolEClass = createEClass ( EVENT_POOL );
        createEAttribute ( eventPoolEClass, EVENT_POOL__FILTER );
        createEAttribute ( eventPoolEClass, EVENT_POOL__SIZE );

        dataMapperEClass = createEClass ( DATA_MAPPER );

        simpleDataMapperEClass = createEClass ( SIMPLE_DATA_MAPPER );
        createEReference ( simpleDataMapperEClass, SIMPLE_DATA_MAPPER__ENTRIES );

        jdbcDataMapperEClass = createEClass ( JDBC_DATA_MAPPER );
        createEAttribute ( jdbcDataMapperEClass, JDBC_DATA_MAPPER__JDBC_DRIVER );
        createEAttribute ( jdbcDataMapperEClass, JDBC_DATA_MAPPER__SQL );
        createEReference ( jdbcDataMapperEClass, JDBC_DATA_MAPPER__PROPERTIES );

        dataMapperEntryEClass = createEClass ( DATA_MAPPER_ENTRY );
        createEAttribute ( dataMapperEntryEClass, DATA_MAPPER_ENTRY__KEY );
        createEAttribute ( dataMapperEntryEClass, DATA_MAPPER_ENTRY__VALUE );

        valueMapperEClass = createEClass ( VALUE_MAPPER );
        createEAttribute ( valueMapperEClass, VALUE_MAPPER__SOURCE_ATTRIBUTE );
        createEAttribute ( valueMapperEClass, VALUE_MAPPER__TARGET_ATTRIBUTE );
        createEReference ( valueMapperEClass, VALUE_MAPPER__DATA_MAPPER );

        persistentItemEClass = createEClass ( PERSISTENT_ITEM );

        proxyItemEClass = createEClass ( PROXY_ITEM );
        createEReference ( proxyItemEClass, PROXY_ITEM__ITEMS );

        scaleEClass = createEClass ( SCALE );
        createEAttribute ( scaleEClass, SCALE__ACTIVE );
        createEAttribute ( scaleEClass, SCALE__FACTOR );
        createEAttribute ( scaleEClass, SCALE__OFFSET );

        negateEClass = createEClass ( NEGATE );
        createEAttribute ( negateEClass, NEGATE__ACTIVE );

        roundingEClass = createEClass ( ROUNDING );
        createEAttribute ( roundingEClass, ROUNDING__TYPE );

        externalEventMonitorEClass = createEClass ( EXTERNAL_EVENT_MONITOR );
        createEAttribute ( externalEventMonitorEClass, EXTERNAL_EVENT_MONITOR__FILTER );
        createEReference ( externalEventMonitorEClass, EXTERNAL_EVENT_MONITOR__PROPERTIES );

        externalEventFilterEClass = createEClass ( EXTERNAL_EVENT_FILTER );

        staticExternalEventFilterEClass = createEClass ( STATIC_EXTERNAL_EVENT_FILTER );
        createEAttribute ( staticExternalEventFilterEClass, STATIC_EXTERNAL_EVENT_FILTER__VALUE );

        simpleExternalEventFilterEClass = createEClass ( SIMPLE_EXTERNAL_EVENT_FILTER );
        createEAttribute ( simpleExternalEventFilterEClass, SIMPLE_EXTERNAL_EVENT_FILTER__FILTER );

        typedItemReferenceEClass = createEClass ( TYPED_ITEM_REFERENCE );
        createEAttribute ( typedItemReferenceEClass, TYPED_ITEM_REFERENCE__TYPE );

        codeFragmentEClass = createEClass ( CODE_FRAGMENT );
        createEAttribute ( codeFragmentEClass, CODE_FRAGMENT__CODE );

        scriptTimerEClass = createEClass ( SCRIPT_TIMER );
        createEReference ( scriptTimerEClass, SCRIPT_TIMER__SCRIPT );
        createEAttribute ( scriptTimerEClass, SCRIPT_TIMER__PERIOD );

        itemReferenceEClass = createEClass ( ITEM_REFERENCE );
        createEReference ( itemReferenceEClass, ITEM_REFERENCE__ITEM );
        createEAttribute ( itemReferenceEClass, ITEM_REFERENCE__NAME );

        formulaItemEClass = createEClass ( FORMULA_ITEM );
        createEAttribute ( formulaItemEClass, FORMULA_ITEM__SCRIPT_ENGINE );
        createEReference ( formulaItemEClass, FORMULA_ITEM__INIT_SCRIPTS );
        createEReference ( formulaItemEClass, FORMULA_ITEM__OUTBOUND );
        createEReference ( formulaItemEClass, FORMULA_ITEM__INBOUND );

        formulaItemOutboundEClass = createEClass ( FORMULA_ITEM_OUTBOUND );
        createEReference ( formulaItemOutboundEClass, FORMULA_ITEM_OUTBOUND__OUTPUT );
        createEAttribute ( formulaItemOutboundEClass, FORMULA_ITEM_OUTBOUND__OUTPUT_FORMULA );
        createEAttribute ( formulaItemOutboundEClass, FORMULA_ITEM_OUTBOUND__WRITE_VALUE_VARIABLE_NAME );

        formulaItemInboundEClass = createEClass ( FORMULA_ITEM_INBOUND );
        createEReference ( formulaItemInboundEClass, FORMULA_ITEM_INBOUND__INPUTS );
        createEAttribute ( formulaItemInboundEClass, FORMULA_ITEM_INBOUND__INPUT_FORMULA );

        booleanMonitorEClass = createEClass ( BOOLEAN_MONITOR );
        createEAttribute ( booleanMonitorEClass, BOOLEAN_MONITOR__REFERENCE_VALUE );
        createEAttribute ( booleanMonitorEClass, BOOLEAN_MONITOR__ACTIVE );
        createEAttribute ( booleanMonitorEClass, BOOLEAN_MONITOR__DEMOTE_PREFIX );
        createEAttribute ( booleanMonitorEClass, BOOLEAN_MONITOR__SEVERITY );
        createEAttribute ( booleanMonitorEClass, BOOLEAN_MONITOR__MESSAGE );
        createEAttribute ( booleanMonitorEClass, BOOLEAN_MONITOR__SUPPRESS_EVENTS );
        createEAttribute ( booleanMonitorEClass, BOOLEAN_MONITOR__REQUIRE_ACK );

        listMonitorEClass = createEClass ( LIST_MONITOR );
        createEAttribute ( listMonitorEClass, LIST_MONITOR__MESSAGE );
        createEAttribute ( listMonitorEClass, LIST_MONITOR__MESSAGE_ATTRIBUTE );
        createEAttribute ( listMonitorEClass, LIST_MONITOR__DEFAULT_ACK );
        createEAttribute ( listMonitorEClass, LIST_MONITOR__DEFAULT_SEVERITY );
        createEAttribute ( listMonitorEClass, LIST_MONITOR__MONITOR_TYPE );
        createEAttribute ( listMonitorEClass, LIST_MONITOR__DEMOTE_PREFIX );
        createEReference ( listMonitorEClass, LIST_MONITOR__ENTRIES );

        listMonitorEntryEClass = createEClass ( LIST_MONITOR_ENTRY );
        createEAttribute ( listMonitorEntryEClass, LIST_MONITOR_ENTRY__VALUE );
        createEAttribute ( listMonitorEntryEClass, LIST_MONITOR_ENTRY__REQUIRE_ACK );
        createEAttribute ( listMonitorEntryEClass, LIST_MONITOR_ENTRY__SEVERITY );

        averageEClass = createEClass ( AVERAGE );
        createEReference ( averageEClass, AVERAGE__ITEMS );
        createEAttribute ( averageEClass, AVERAGE__SOURCES_REQUIRED );

        movingAverageEClass = createEClass ( MOVING_AVERAGE );
        createEReference ( movingAverageEClass, MOVING_AVERAGE__ITEM );
        createEAttribute ( movingAverageEClass, MOVING_AVERAGE__RANGE );
        createEAttribute ( movingAverageEClass, MOVING_AVERAGE__NULL_RANGE );
        createEAttribute ( movingAverageEClass, MOVING_AVERAGE__TRIGGER );
        createEAttribute ( movingAverageEClass, MOVING_AVERAGE__TRIGGER_ONLY );

        averageItemEClass = createEClass ( AVERAGE_ITEM );
        createEReference ( averageItemEClass, AVERAGE_ITEM__SOURCE );
        createEAttribute ( averageItemEClass, AVERAGE_ITEM__TYPE );

        movingAverageItemEClass = createEClass ( MOVING_AVERAGE_ITEM );
        createEReference ( movingAverageItemEClass, MOVING_AVERAGE_ITEM__SOURCE );
        createEAttribute ( movingAverageItemEClass, MOVING_AVERAGE_ITEM__TYPE );

        blockingsEClass = createEClass ( BLOCKINGS );
        createEReference ( blockingsEClass, BLOCKINGS__GROUPS );

        blockGroupEClass = createEClass ( BLOCK_GROUP );
        createEReference ( blockGroupEClass, BLOCK_GROUP__HANDLERS );
        createEAttribute ( blockGroupEClass, BLOCK_GROUP__HIERARCHY );

        blockHandlerEClass = createEClass ( BLOCK_HANDLER );
        createEReference ( blockHandlerEClass, BLOCK_HANDLER__GROUP );

        blockEClass = createEClass ( BLOCK );

        globalSummaryItemEClass = createEClass ( GLOBAL_SUMMARY_ITEM );
        createEAttribute ( globalSummaryItemEClass, GLOBAL_SUMMARY_ITEM__ATTRIBUTE );

        weakReferenceDataSourceItemEClass = createEClass ( WEAK_REFERENCE_DATA_SOURCE_ITEM );
        createEAttribute ( weakReferenceDataSourceItemEClass, WEAK_REFERENCE_DATA_SOURCE_ITEM__DATA_SOURCE_ID );

        alarmsEventsExporterEClass = createEClass ( ALARMS_EVENTS_EXPORTER );
        createEOperation ( alarmsEventsExporterEClass, ALARMS_EVENTS_EXPORTER___GET_TYPE_TAG );

        alarmsEventsConnectionEClass = createEClass ( ALARMS_EVENTS_CONNECTION );
        createEOperation ( alarmsEventsConnectionEClass, ALARMS_EVENTS_CONNECTION___GET_TYPE_TAG );
        createEOperation ( alarmsEventsConnectionEClass, ALARMS_EVENTS_CONNECTION___MAKE_URI__BOOLEAN );

        monitorPoolProxyEClass = createEClass ( MONITOR_POOL_PROXY );
        createEReference ( monitorPoolProxyEClass, MONITOR_POOL_PROXY__LOCAL );
        createEReference ( monitorPoolProxyEClass, MONITOR_POOL_PROXY__REMOTE );

        eventPoolProxyEClass = createEClass ( EVENT_POOL_PROXY );
        createEReference ( eventPoolProxyEClass, EVENT_POOL_PROXY__LOCAL );
        createEReference ( eventPoolProxyEClass, EVENT_POOL_PROXY__REMOTE );
        createEAttribute ( eventPoolProxyEClass, EVENT_POOL_PROXY__SIZE );

        alarmsEventsModuleEClass = createEClass ( ALARMS_EVENTS_MODULE );
        createEReference ( alarmsEventsModuleEClass, ALARMS_EVENTS_MODULE__MONITOR_POOL_PROXIES );
        createEReference ( alarmsEventsModuleEClass, ALARMS_EVENTS_MODULE__EVENT_POOL_PROXIES );
        createEReference ( alarmsEventsModuleEClass, ALARMS_EVENTS_MODULE__AKN_PROXIES );
        createEReference ( alarmsEventsModuleEClass, ALARMS_EVENTS_MODULE__PULL_EVENTS );

        aknProxyEClass = createEClass ( AKN_PROXY );
        createEAttribute ( aknProxyEClass, AKN_PROXY__PATTERN );
        createEReference ( aknProxyEClass, AKN_PROXY__CONNECTION );
        createEAttribute ( aknProxyEClass, AKN_PROXY__PRIORITY );
        createEAttribute ( aknProxyEClass, AKN_PROXY__AUTHORATIVE );

        pullEventsEClass = createEClass ( PULL_EVENTS );
        createEAttribute ( pullEventsEClass, PULL_EVENTS__JDBC_DRIVER_NAME );
        createEReference ( pullEventsEClass, PULL_EVENTS__JDBC_PROPERTIES );
        createEAttribute ( pullEventsEClass, PULL_EVENTS__JOB_INTERVAL );
        createEAttribute ( pullEventsEClass, PULL_EVENTS__CUSTOM_SELECT_SQL );
        createEAttribute ( pullEventsEClass, PULL_EVENTS__CUSTOM_DELETE_SQL );

        jdbcUserServiceModuleEClass = createEClass ( JDBC_USER_SERVICE_MODULE );
        createEReference ( jdbcUserServiceModuleEClass, JDBC_USER_SERVICE_MODULE__USER_SERVICES );

        jdbcUserServiceEClass = createEClass ( JDBC_USER_SERVICE );
        createEReference ( jdbcUserServiceEClass, JDBC_USER_SERVICE__JDBC_PROPETIES );
        createEAttribute ( jdbcUserServiceEClass, JDBC_USER_SERVICE__JDBC_DRIVER );
        createEAttribute ( jdbcUserServiceEClass, JDBC_USER_SERVICE__AUTHORATIVE );
        createEAttribute ( jdbcUserServiceEClass, JDBC_USER_SERVICE__FIND_USER_SQL );
        createEAttribute ( jdbcUserServiceEClass, JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL );
        createEAttribute ( jdbcUserServiceEClass, JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL );
        createEAttribute ( jdbcUserServiceEClass, JDBC_USER_SERVICE__USER_ID_COLUMN_NAME );
        createEAttribute ( jdbcUserServiceEClass, JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME );
        createEAttribute ( jdbcUserServiceEClass, JDBC_USER_SERVICE__PASSWORD_TYPE );

        defaultValueArchiveServerEClass = createEClass ( DEFAULT_VALUE_ARCHIVE_SERVER );

        historicalDataExporterEClass = createEClass ( HISTORICAL_DATA_EXPORTER );
        createEOperation ( historicalDataExporterEClass, HISTORICAL_DATA_EXPORTER___GET_TYPE_TAG );

        valueArchiveEClass = createEClass ( VALUE_ARCHIVE );
        createEReference ( valueArchiveEClass, VALUE_ARCHIVE__ITEMS );

        configurationAdministratorExporterEClass = createEClass ( CONFIGURATION_ADMINISTRATOR_EXPORTER );
        createEOperation ( configurationAdministratorExporterEClass, CONFIGURATION_ADMINISTRATOR_EXPORTER___GET_TYPE_TAG );

        referenceItemEClass = createEClass ( REFERENCE_ITEM );
        createEReference ( referenceItemEClass, REFERENCE_ITEM__SOURCE );

        eventStorageEClass = createEClass ( EVENT_STORAGE );

        eventStorageJdbcEClass = createEClass ( EVENT_STORAGE_JDBC );
        createEAttribute ( eventStorageJdbcEClass, EVENT_STORAGE_JDBC__JDBC_DRIVER_NAME );
        createEAttribute ( eventStorageJdbcEClass, EVENT_STORAGE_JDBC__DRIVER_BUNDLES );
        createEAttribute ( eventStorageJdbcEClass, EVENT_STORAGE_JDBC__MAX_FIELD_LENGTH );
        createEAttribute ( eventStorageJdbcEClass, EVENT_STORAGE_JDBC__QUERY_FETCH_SIZE );

        eventStoragePostgresEClass = createEClass ( EVENT_STORAGE_POSTGRES );
        createEAttribute ( eventStoragePostgresEClass, EVENT_STORAGE_POSTGRES__BATCH_SIZE );
        createEAttribute ( eventStoragePostgresEClass, EVENT_STORAGE_POSTGRES__POSTGRES_DRIVER_BUNDLES );
        createEOperation ( eventStoragePostgresEClass, EVENT_STORAGE_POSTGRES___GET_JDBC_DRIVER_NAME );
        createEOperation ( eventStoragePostgresEClass, EVENT_STORAGE_POSTGRES___GET_DRIVER_BUNDLES );

        abstractEventStorageJdbcEClass = createEClass ( ABSTRACT_EVENT_STORAGE_JDBC );
        createEReference ( abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES );
        createEAttribute ( abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA );
        createEAttribute ( abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME );
        createEAttribute ( abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION );
        createEAttribute ( abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS );
        createEAttribute ( abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS );
        createEOperation ( abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC___GET_JDBC_DRIVER_NAME );
        createEOperation ( abstractEventStorageJdbcEClass, ABSTRACT_EVENT_STORAGE_JDBC___GET_DRIVER_BUNDLES );

        applicationConfigurationEClass = createEClass ( APPLICATION_CONFIGURATION );

        restExporterEClass = createEClass ( REST_EXPORTER );
        createEReference ( restExporterEClass, REST_EXPORTER__ITEMS );
        createEReference ( restExporterEClass, REST_EXPORTER__HIVE_PROPERTIES );
        createEAttribute ( restExporterEClass, REST_EXPORTER__CONTEXT_ID );

        httpServiceEClass = createEClass ( HTTP_SERVICE );
        createEReference ( httpServiceEClass, HTTP_SERVICE__ENDPOINT );

        independentConfigurationEClass = createEClass ( INDEPENDENT_CONFIGURATION );

        transientItemEClass = createEClass ( TRANSIENT_ITEM );

        defaultEquinoxApplicationEClass = createEClass ( DEFAULT_EQUINOX_APPLICATION );
        createEReference ( defaultEquinoxApplicationEClass, DEFAULT_EQUINOX_APPLICATION__PROFILE );

        changeCounterItemEClass = createEClass ( CHANGE_COUNTER_ITEM );
        createEReference ( changeCounterItemEClass, CHANGE_COUNTER_ITEM__BUFFER );
        createEAttribute ( changeCounterItemEClass, CHANGE_COUNTER_ITEM__TYPE );
        createEAttribute ( changeCounterItemEClass, CHANGE_COUNTER_ITEM__ON_ERROR );
        createEAttribute ( changeCounterItemEClass, CHANGE_COUNTER_ITEM__VALUES );

        bufferedValueEClass = createEClass ( BUFFERED_VALUE );
        createEReference ( bufferedValueEClass, BUFFERED_VALUE__ITEM );
        createEAttribute ( bufferedValueEClass, BUFFERED_VALUE__INITIAL_VALUE );
        createEAttribute ( bufferedValueEClass, BUFFERED_VALUE__RANGE );
        createEAttribute ( bufferedValueEClass, BUFFERED_VALUE__TRIGGER );
        createEAttribute ( bufferedValueEClass, BUFFERED_VALUE__TRIGGER_ONLY );
        createEAttribute ( bufferedValueEClass, BUFFERED_VALUE__PERSISTENCE );

        telnetConsoleEClass = createEClass ( TELNET_CONSOLE );
        createEAttribute ( telnetConsoleEClass, TELNET_CONSOLE__HOST );
        createEAttribute ( telnetConsoleEClass, TELNET_CONSOLE__PORT );

        // Create enums
        averageReferenceTypeEEnum = createEEnum ( AVERAGE_REFERENCE_TYPE );
        movingAverageReferenceTypeEEnum = createEEnum ( MOVING_AVERAGE_REFERENCE_TYPE );
        roundingTypeEEnum = createEEnum ( ROUNDING_TYPE );
        dataTypeEEnum = createEEnum ( DATA_TYPE );
        passwordTypeEEnum = createEEnum ( PASSWORD_TYPE );
        persistenceEEnum = createEEnum ( PERSISTENCE );
        errorHandlingEEnum = createEEnum ( ERROR_HANDLING );
        changeTypeEEnum = createEEnum ( CHANGE_TYPE );

        // Create data types
        severityEDataType = createEDataType ( SEVERITY );
        variantEDataType = createEDataType ( VARIANT );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( isInitialized )
            return;
        isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Obtain other dependent packages
        ProfilePackage theProfilePackage = (ProfilePackage)EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI );
        WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        SecurityPackage theSecurityPackage = (SecurityPackage)EPackage.Registry.INSTANCE.getEPackage ( SecurityPackage.eNS_URI );

        // Add subpackages
        getESubpackages ().add ( theProfilePackage );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        equinoxApplicationEClass.getESuperTypes ().add ( theWorldPackage.getApplication () );
        connectionEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        exporterEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        dataAccessConnectionEClass.getESuperTypes ().add ( this.getConnection () );
        dataAccessExporterEClass.getESuperTypes ().add ( this.getExporter () );
        sourceItemEClass.getESuperTypes ().add ( this.getItem () );
        levelMonitorEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        scriptItemEClass.getESuperTypes ().add ( this.getItem () );
        importItemEClass.getESuperTypes ().add ( this.getItem () );
        constantItemEClass.getESuperTypes ().add ( this.getItem () );
        summaryItemEClass.getESuperTypes ().add ( this.getItem () );
        manualOverrideEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        masterServerEClass.getESuperTypes ().add ( this.getEquinoxApplication () );
        valueArchiveServerEClass.getESuperTypes ().add ( this.getEquinoxApplication () );
        defaultMasterServerEClass.getESuperTypes ().add ( this.getMasterServer () );
        customMasterServerEClass.getESuperTypes ().add ( this.getMasterServer () );
        attributesSummaryEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        eventLoggerEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        monitorPoolEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        eventPoolEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        dataMapperEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        simpleDataMapperEClass.getESuperTypes ().add ( this.getDataMapper () );
        jdbcDataMapperEClass.getESuperTypes ().add ( this.getDataMapper () );
        valueMapperEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        persistentItemEClass.getESuperTypes ().add ( this.getItem () );
        proxyItemEClass.getESuperTypes ().add ( this.getItem () );
        scaleEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        negateEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        roundingEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        externalEventMonitorEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        externalEventFilterEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        staticExternalEventFilterEClass.getESuperTypes ().add ( this.getExternalEventFilter () );
        simpleExternalEventFilterEClass.getESuperTypes ().add ( this.getExternalEventFilter () );
        typedItemReferenceEClass.getESuperTypes ().add ( this.getItemReference () );
        formulaItemEClass.getESuperTypes ().add ( this.getItem () );
        booleanMonitorEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        listMonitorEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        averageEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        movingAverageEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        averageItemEClass.getESuperTypes ().add ( this.getItem () );
        movingAverageItemEClass.getESuperTypes ().add ( this.getItem () );
        blockingsEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        blockingsEClass.getESuperTypes ().add ( this.getApplicationModule () );
        blockGroupEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        blockHandlerEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        blockEClass.getESuperTypes ().add ( this.getItemFeatureEntry () );
        globalSummaryItemEClass.getESuperTypes ().add ( this.getItem () );
        weakReferenceDataSourceItemEClass.getESuperTypes ().add ( this.getItem () );
        alarmsEventsExporterEClass.getESuperTypes ().add ( this.getExporter () );
        alarmsEventsConnectionEClass.getESuperTypes ().add ( this.getConnection () );
        monitorPoolProxyEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        eventPoolProxyEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        alarmsEventsModuleEClass.getESuperTypes ().add ( this.getApplicationModule () );
        pullEventsEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        jdbcUserServiceModuleEClass.getESuperTypes ().add ( this.getApplicationModule () );
        jdbcUserServiceEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        defaultValueArchiveServerEClass.getESuperTypes ().add ( this.getValueArchiveServer () );
        historicalDataExporterEClass.getESuperTypes ().add ( this.getExporter () );
        valueArchiveEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        configurationAdministratorExporterEClass.getESuperTypes ().add ( this.getExporter () );
        referenceItemEClass.getESuperTypes ().add ( this.getItem () );
        eventStorageEClass.getESuperTypes ().add ( this.getIndependentConfiguration () );
        eventStorageJdbcEClass.getESuperTypes ().add ( this.getAbstractEventStorageJdbc () );
        eventStoragePostgresEClass.getESuperTypes ().add ( this.getAbstractEventStorageJdbc () );
        abstractEventStorageJdbcEClass.getESuperTypes ().add ( this.getEventStorage () );
        applicationConfigurationEClass.getESuperTypes ().add ( this.getApplicationModule () );
        restExporterEClass.getESuperTypes ().add ( this.getApplicationModule () );
        httpServiceEClass.getESuperTypes ().add ( this.getApplicationConfiguration () );
        independentConfigurationEClass.getESuperTypes ().add ( this.getApplicationConfiguration () );
        transientItemEClass.getESuperTypes ().add ( this.getItem () );
        defaultEquinoxApplicationEClass.getESuperTypes ().add ( this.getEquinoxApplication () );
        changeCounterItemEClass.getESuperTypes ().add ( this.getItem () );
        bufferedValueEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        telnetConsoleEClass.getESuperTypes ().add ( this.getIndependentConfiguration () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( equinoxApplicationEClass, EquinoxApplication.class, "EquinoxApplication", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_Connections (), this.getConnection (), null, "connections", null, 0, -1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_Exporter (), this.getExporter (), null, "exporter", null, 0, -1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_CustomizationProfile (), theProfilePackage.getProfile (), null, "customizationProfile", null, 0, 1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_SecurityConfiguration (), theSecurityPackage.getConfiguration (), null, "securityConfiguration", null, 1, 1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_Modules (), this.getApplicationModule (), null, "modules", null, 0, -1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getEquinoxApplication__GetProfile (), theProfilePackage.getProfile (), "getProfile", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( connectionEClass, Connection.class, "Connection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getConnection_Endpoint (), theWorldPackage.getEndpoint (), null, "endpoint", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getConnection_Endpoint ().getEKeys ().add ( theWorldPackage.getEndpoint_PortNumber () );
        initEAttribute ( getConnection_EndpointLabel (), ecorePackage.getEString (), "endpointLabel", null, 0, 1, Connection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getConnection_Credentials (), theWorldPackage.getCredentials (), null, "credentials", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnection_Timeout (), ecorePackage.getEIntegerObject (), "timeout", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getConnection__GetTypeTag (), ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        EOperation op = initEOperation ( getConnection__GetPossibleEndpoints__Exporter (), theWorldPackage.getEndpoint (), "getPossibleEndpoints", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getExporter (), "exporter", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getConnection__MakeUri__boolean (), ecorePackage.getEString (), "makeUri", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, ecorePackage.getEBoolean (), "localhost", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getConnection__GetMatchingEndpoint__Exporter (), theWorldPackage.getEndpoint (), "getMatchingEndpoint", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getExporter (), "exporter", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( exporterEClass, Exporter.class, "Exporter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getExporter_Endpoints (), theWorldPackage.getEndpoint (), null, "endpoints", null, 0, -1, Exporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getExporter_Endpoints ().getEKeys ().add ( theWorldPackage.getEndpoint_PortNumber () );

        initEOperation ( getExporter__GetTypeTag (), ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( dataAccessConnectionEClass, DataAccessConnection.class, "DataAccessConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getDataAccessConnection__GetTypeTag (), ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getDataAccessConnection__MakeUri__boolean (), ecorePackage.getEString (), "makeUri", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, ecorePackage.getEBoolean (), "localhost", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( dataAccessExporterEClass, DataAccessExporter.class, "DataAccessExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDataAccessExporter_Exports (), this.getItemExport (), null, "exports", null, 0, -1, DataAccessExporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getDataAccessExporter__GetTypeTag (), ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemEClass, Item.class, "Item", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItem_Name (), ecorePackage.getEString (), "name", null, 1, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getItem_Information (), this.getItemInformation (), null, "information", null, 0, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getItem_ItemFeatures (), this.getItemFeatureEntry (), this.getItemFeatureEntry_Item (), "itemFeatures", null, 0, -1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getItem_ItemFeatures ().getEKeys ().add ( this.getItemFeatureEntry_Name () );

        initEClass ( sourceItemEClass, SourceItem.class, "SourceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSourceItem_Connection (), this.getDataAccessConnection (), null, "connection", null, 1, 1, SourceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSourceItem_SourceName (), ecorePackage.getEString (), "sourceName", null, 1, 1, SourceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemExportEClass, ItemExport.class, "ItemExport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getItemExport_Item (), this.getItem (), null, "item", null, 1, 1, ItemExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemExport_ExportName (), ecorePackage.getEString (), "exportName", null, 0, 1, ItemExport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemInformationEClass, ItemInformation.class, "ItemInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemInformation_Description (), ecorePackage.getEString (), "description", null, 0, 1, ItemInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemInformation_Unit (), ecorePackage.getEString (), "unit", null, 0, 1, ItemInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemInformation_Hierarchy (), ecorePackage.getEString (), "hierarchy", null, 0, -1, ItemInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemInformation_System (), ecorePackage.getEString (), "system", null, 0, 1, ItemInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemInformation_DataType (), this.getDataType (), "dataType", "VARIANT", 1, 1, ItemInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( levelMonitorEClass, LevelMonitor.class, "LevelMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_Preset (), ecorePackage.getEDoubleObject (), "preset", null, 0, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_Cap (), ecorePackage.getEBoolean (), "cap", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_Severity (), this.getSeverity (), "severity", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_LowerOk (), ecorePackage.getEBoolean (), "lowerOk", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_IncludedOk (), ecorePackage.getEBoolean (), "includedOk", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_Prefix (), ecorePackage.getEString (), "prefix", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_DemotePrefix (), ecorePackage.getEString (), "demotePrefix", null, 0, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_SuppressEvents (), ecorePackage.getEBoolean (), "suppressEvents", "false", 0, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getLevelMonitor_RequireAck (), ecorePackage.getEBoolean (), "requireAck", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevelMonitor_MonitorType (), ecorePackage.getEString (), "monitorType", null, 1, 1, LevelMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemFeatureEntryEClass, ItemFeatureEntry.class, "ItemFeatureEntry", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemFeatureEntry_Name (), ecorePackage.getEString (), "name", null, 1, 1, ItemFeatureEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getItemFeatureEntry_Item (), this.getItem (), this.getItem_ItemFeatures (), "item", null, 1, 1, ItemFeatureEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( scriptItemEClass, ScriptItem.class, "ScriptItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getScriptItem_Inputs (), this.getItemReference (), null, "inputs", null, 0, -1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptItem_InitScript (), this.getCodeFragment (), null, "initScript", null, 0, 1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptItem_UpdateScript (), this.getCodeFragment (), null, "updateScript", null, 0, 1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptItem_Timer (), this.getScriptTimer (), null, "timer", null, 0, 1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScriptItem_ScriptEngine (), ecorePackage.getEString (), "scriptEngine", "JavaScript", 1, 1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getScriptItem_Commands (), this.getItemReference (), null, "commands", null, 0, -1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptItem_WriteCommandScript (), this.getCodeFragment (), null, "writeCommandScript", null, 0, 1, ScriptItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( importItemEClass, ImportItem.class, "ImportItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getImportItem_Export (), this.getItemExport (), null, "export", null, 1, 1, ImportItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( summaryGroupEClass, SummaryGroup.class, "SummaryGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSummaryGroup_Name (), ecorePackage.getEString (), "name", null, 1, 1, SummaryGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSummaryGroup_SubGroups (), this.getSummaryGroup (), null, "subGroups", null, 0, -1, SummaryGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSummaryGroup_Items (), this.getItem (), null, "items", null, 0, -1, SummaryGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( markerGroupEClass, MarkerGroup.class, "MarkerGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMarkerGroup_Items (), this.getItem (), null, "items", null, 0, -1, MarkerGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMarkerGroup_Name (), ecorePackage.getEString (), "name", null, 1, 1, MarkerGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMarkerGroup_Markers (), this.getMarkerEntry (), null, "markers", null, 0, -1, MarkerGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( markersEClass, Markers.class, "Markers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMarkers_MarkerGroups (), this.getMarkerGroup (), null, "markerGroups", null, 0, -1, Markers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( constantItemEClass, ConstantItem.class, "ConstantItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getConstantItem_Value (), ecorePackage.getEString (), "value", null, 0, 1, ConstantItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( summaryItemEClass, SummaryItem.class, "SummaryItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSummaryItem_Group (), this.getSummaryGroup (), null, "group", null, 1, 1, SummaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( markerEntryEClass, MarkerEntry.class, "MarkerEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMarkerEntry_Name (), ecorePackage.getEString (), "name", null, 1, 1, MarkerEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMarkerEntry_Value (), ecorePackage.getEString (), "value", null, 0, 1, MarkerEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( manualOverrideEClass, ManualOverride.class, "ManualOverride", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getManualOverride_InitialValue (), ecorePackage.getEString (), "initialValue", null, 0, 1, ManualOverride.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( masterServerEClass, MasterServer.class, "MasterServer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMasterServer_SummaryGroups (), this.getSummaryGroup (), null, "summaryGroups", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_Items (), this.getItem (), null, "items", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_Markers (), this.getMarkers (), null, "markers", null, 0, 1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMasterServer_AeServerInformationPrefix (), ecorePackage.getEString (), "aeServerInformationPrefix", "ae.server.info", 0, 1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getMasterServer_MonitorPools (), this.getMonitorPool (), null, "monitorPools", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_EventPools (), this.getEventPool (), null, "eventPools", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_DataMapper (), this.getDataMapper (), null, "dataMapper", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_ExternalEventMonitors (), this.getExternalEventMonitor (), null, "externalEventMonitors", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_ExternalEventFilters (), this.getExternalEventFilter (), null, "externalEventFilters", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_Averages (), this.getAverage (), null, "averages", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_MovingAverages (), this.getMovingAverage (), null, "movingAverages", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_BufferedValues (), this.getBufferedValue (), null, "bufferedValues", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( valueArchiveServerEClass, ValueArchiveServer.class, "ValueArchiveServer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getValueArchiveServer_Archives (), this.getValueArchive (), null, "archives", null, 0, -1, ValueArchiveServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( defaultMasterServerEClass, DefaultMasterServer.class, "DefaultMasterServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( customMasterServerEClass, CustomMasterServer.class, "CustomMasterServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCustomMasterServer_Profile (), theProfilePackage.getProfile (), null, "profile", null, 1, 1, CustomMasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( applicationModuleEClass, ApplicationModule.class, "ApplicationModule", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( attributesSummaryEClass, AttributesSummary.class, "AttributesSummary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAttributesSummary_Attributes (), ecorePackage.getEString (), "attributes", null, 0, -1, AttributesSummary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAttributesSummary_OutputPrefix (), ecorePackage.getEString (), "outputPrefix", null, 1, 1, AttributesSummary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( eventLoggerEClass, EventLogger.class, "EventLogger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventLogger_LogAttributesChange (), ecorePackage.getEBoolean (), "logAttributesChange", "false", 1, 1, EventLogger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getEventLogger_LogValueChange (), ecorePackage.getEBoolean (), "logValueChange", "true", 1, 1, EventLogger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getEventLogger_LogSubscriptionChange (), ecorePackage.getEBoolean (), "logSubscriptionChange", "true", 1, 1, EventLogger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getEventLogger_LogWrites (), ecorePackage.getEBoolean (), "logWrites", "true", 1, 1, EventLogger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( monitorPoolEClass, MonitorPool.class, "MonitorPool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMonitorPool_Filter (), ecorePackage.getEString (), "filter", null, 1, 1, MonitorPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( eventPoolEClass, EventPool.class, "EventPool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventPool_Filter (), ecorePackage.getEString (), "filter", null, 1, 1, EventPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventPool_Size (), ecorePackage.getEInt (), "size", null, 1, 1, EventPool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( dataMapperEClass, DataMapper.class, "DataMapper", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( simpleDataMapperEClass, SimpleDataMapper.class, "SimpleDataMapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSimpleDataMapper_Entries (), this.getDataMapperEntry (), null, "entries", null, 0, -1, SimpleDataMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( jdbcDataMapperEClass, JdbcDataMapper.class, "JdbcDataMapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getJdbcDataMapper_JdbcDriver (), ecorePackage.getEString (), "jdbcDriver", null, 1, 1, JdbcDataMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcDataMapper_Sql (), ecorePackage.getEString (), "sql", null, 1, 1, JdbcDataMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getJdbcDataMapper_Properties (), theWorldPackage.getPropertyEntry (), null, "properties", null, 0, -1, JdbcDataMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( dataMapperEntryEClass, DataMapperEntry.class, "DataMapperEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDataMapperEntry_Key (), ecorePackage.getEString (), "key", null, 1, 1, DataMapperEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDataMapperEntry_Value (), ecorePackage.getEString (), "value", null, 1, 1, DataMapperEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( valueMapperEClass, ValueMapper.class, "ValueMapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getValueMapper_SourceAttribute (), ecorePackage.getEString (), "sourceAttribute", null, 0, 1, ValueMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getValueMapper_TargetAttribute (), ecorePackage.getEString (), "targetAttribute", null, 0, 1, ValueMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getValueMapper_DataMapper (), this.getDataMapper (), null, "dataMapper", null, 1, 1, ValueMapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( persistentItemEClass, PersistentItem.class, "PersistentItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( proxyItemEClass, ProxyItem.class, "ProxyItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getProxyItem_Items (), this.getItem (), null, "items", null, 0, -1, ProxyItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( scaleEClass, Scale.class, "Scale", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getScale_Active (), ecorePackage.getEBoolean (), "active", null, 1, 1, Scale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScale_Factor (), ecorePackage.getEDoubleObject (), "factor", "1.0", 1, 1, Scale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getScale_Offset (), ecorePackage.getEDoubleObject (), "offset", "0.0", 1, 1, Scale.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( negateEClass, Negate.class, "Negate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getNegate_Active (), ecorePackage.getEBoolean (), "active", null, 1, 1, Negate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( roundingEClass, Rounding.class, "Rounding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getRounding_Type (), this.getRoundingType (), "type", null, 1, 1, Rounding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( externalEventMonitorEClass, ExternalEventMonitor.class, "ExternalEventMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getExternalEventMonitor_Filter (), ecorePackage.getEString (), "filter", null, 1, 1, ExternalEventMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExternalEventMonitor_Properties (), theWorldPackage.getPropertyEntry (), null, "properties", null, 0, -1, ExternalEventMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( externalEventFilterEClass, ExternalEventFilter.class, "ExternalEventFilter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( staticExternalEventFilterEClass, StaticExternalEventFilter.class, "StaticExternalEventFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getStaticExternalEventFilter_Value (), ecorePackage.getEString (), "value", null, 1, 1, StaticExternalEventFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( simpleExternalEventFilterEClass, SimpleExternalEventFilter.class, "SimpleExternalEventFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSimpleExternalEventFilter_Filter (), ecorePackage.getEString (), "filter", null, 1, 1, SimpleExternalEventFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( typedItemReferenceEClass, TypedItemReference.class, "TypedItemReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTypedItemReference_Type (), this.getDataType (), "type", null, 1, 1, TypedItemReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( codeFragmentEClass, CodeFragment.class, "CodeFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCodeFragment_Code (), ecorePackage.getEString (), "code", null, 0, 1, CodeFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( scriptTimerEClass, ScriptTimer.class, "ScriptTimer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getScriptTimer_Script (), this.getCodeFragment (), null, "script", null, 1, 1, ScriptTimer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScriptTimer_Period (), ecorePackage.getELong (), "period", null, 1, 1, ScriptTimer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemReferenceEClass, ItemReference.class, "ItemReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getItemReference_Item (), this.getItem (), null, "item", null, 1, 1, ItemReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemReference_Name (), ecorePackage.getEString (), "name", null, 1, 1, ItemReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( formulaItemEClass, FormulaItem.class, "FormulaItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getFormulaItem_ScriptEngine (), ecorePackage.getEString (), "scriptEngine", null, 0, 1, FormulaItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getFormulaItem_InitScripts (), this.getCodeFragment (), null, "initScripts", null, 0, -1, FormulaItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getFormulaItem_Outbound (), this.getFormulaItemOutbound (), null, "outbound", null, 0, 1, FormulaItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getFormulaItem_Inbound (), this.getFormulaItemInbound (), null, "inbound", null, 0, 1, FormulaItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( formulaItemOutboundEClass, FormulaItemOutbound.class, "FormulaItemOutbound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getFormulaItemOutbound_Output (), this.getTypedItemReference (), null, "output", null, 1, 1, FormulaItemOutbound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFormulaItemOutbound_OutputFormula (), ecorePackage.getEString (), "outputFormula", null, 0, 1, FormulaItemOutbound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFormulaItemOutbound_WriteValueVariableName (), ecorePackage.getEString (), "writeValueVariableName", null, 0, 1, FormulaItemOutbound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( formulaItemInboundEClass, FormulaItemInbound.class, "FormulaItemInbound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getFormulaItemInbound_Inputs (), this.getTypedItemReference (), null, "inputs", null, 1, -1, FormulaItemInbound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFormulaItemInbound_InputFormula (), ecorePackage.getEString (), "inputFormula", null, 0, 1, FormulaItemInbound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( booleanMonitorEClass, BooleanMonitor.class, "BooleanMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_ReferenceValue (), ecorePackage.getEBoolean (), "referenceValue", null, 1, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_Active (), ecorePackage.getEBoolean (), "active", null, 1, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_DemotePrefix (), ecorePackage.getEString (), "demotePrefix", null, 0, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_Severity (), this.getSeverity (), "severity", null, 1, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_Message (), ecorePackage.getEString (), "message", null, 0, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_SuppressEvents (), ecorePackage.getEBoolean (), "suppressEvents", null, 1, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanMonitor_RequireAck (), ecorePackage.getEBoolean (), "requireAck", null, 1, 1, BooleanMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( listMonitorEClass, ListMonitor.class, "ListMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getListMonitor_Message (), ecorePackage.getEString (), "message", null, 0, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getListMonitor_MessageAttribute (), ecorePackage.getEString (), "messageAttribute", null, 0, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getListMonitor_DefaultAck (), ecorePackage.getEBoolean (), "defaultAck", "false", 1, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getListMonitor_DefaultSeverity (), this.getSeverity (), "defaultSeverity", "ALARM", 1, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getListMonitor_MonitorType (), ecorePackage.getEString (), "monitorType", "LIST", 1, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getListMonitor_DemotePrefix (), ecorePackage.getEString (), "demotePrefix", null, 0, 1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getListMonitor_Entries (), this.getListMonitorEntry (), null, "entries", null, 0, -1, ListMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( listMonitorEntryEClass, ListMonitorEntry.class, "ListMonitorEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getListMonitorEntry_Value (), this.getVariant (), "value", null, 1, 1, ListMonitorEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getListMonitorEntry_RequireAck (), ecorePackage.getEBooleanObject (), "requireAck", null, 0, 1, ListMonitorEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getListMonitorEntry_Severity (), this.getSeverity (), "severity", null, 0, 1, ListMonitorEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( averageEClass, Average.class, "Average", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAverage_Items (), this.getItem (), null, "items", null, 0, -1, Average.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAverage_SourcesRequired (), ecorePackage.getEString (), "sourcesRequired", null, 0, 1, Average.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( movingAverageEClass, MovingAverage.class, "MovingAverage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMovingAverage_Item (), this.getItem (), null, "item", null, 1, 1, MovingAverage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMovingAverage_Range (), ecorePackage.getELong (), "range", null, 1, 1, MovingAverage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMovingAverage_NullRange (), ecorePackage.getELong (), "nullRange", null, 1, 1, MovingAverage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMovingAverage_Trigger (), ecorePackage.getELong (), "trigger", "1", 1, 1, MovingAverage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getMovingAverage_TriggerOnly (), ecorePackage.getEBooleanObject (), "triggerOnly", "false", 0, 1, MovingAverage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( averageItemEClass, AverageItem.class, "AverageItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAverageItem_Source (), this.getAverage (), null, "source", null, 1, 1, AverageItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAverageItem_Type (), this.getAverageReferenceType (), "type", null, 1, 1, AverageItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( movingAverageItemEClass, MovingAverageItem.class, "MovingAverageItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMovingAverageItem_Source (), this.getMovingAverage (), null, "source", null, 1, 1, MovingAverageItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMovingAverageItem_Type (), this.getMovingAverageReferenceType (), "type", null, 1, 1, MovingAverageItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( blockingsEClass, Blockings.class, "Blockings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getBlockings_Groups (), this.getBlockGroup (), null, "groups", null, 0, -1, Blockings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( blockGroupEClass, BlockGroup.class, "BlockGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getBlockGroup_Handlers (), this.getBlockHandler (), this.getBlockHandler_Group (), "handlers", null, 0, -1, BlockGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBlockGroup_Hierarchy (), ecorePackage.getEString (), "hierarchy", null, 0, -1, BlockGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( blockHandlerEClass, BlockHandler.class, "BlockHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getBlockHandler_Group (), this.getBlockGroup (), this.getBlockGroup_Handlers (), "group", null, 1, 1, BlockHandler.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( globalSummaryItemEClass, GlobalSummaryItem.class, "GlobalSummaryItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getGlobalSummaryItem_Attribute (), ecorePackage.getEString (), "attribute", null, 1, 1, GlobalSummaryItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( weakReferenceDataSourceItemEClass, WeakReferenceDataSourceItem.class, "WeakReferenceDataSourceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getWeakReferenceDataSourceItem_DataSourceId (), ecorePackage.getEString (), "dataSourceId", null, 1, 1, WeakReferenceDataSourceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( alarmsEventsExporterEClass, AlarmsEventsExporter.class, "AlarmsEventsExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getAlarmsEventsExporter__GetTypeTag (), ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( alarmsEventsConnectionEClass, AlarmsEventsConnection.class, "AlarmsEventsConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getAlarmsEventsConnection__GetTypeTag (), ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getAlarmsEventsConnection__MakeUri__boolean (), ecorePackage.getEString (), "makeUri", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, ecorePackage.getEBoolean (), "localhost", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( monitorPoolProxyEClass, MonitorPoolProxy.class, "MonitorPoolProxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMonitorPoolProxy_Local (), this.getMonitorPool (), null, "local", null, 0, -1, MonitorPoolProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMonitorPoolProxy_Remote (), this.getMonitorPool (), null, "remote", null, 0, -1, MonitorPoolProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( eventPoolProxyEClass, EventPoolProxy.class, "EventPoolProxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEventPoolProxy_Local (), this.getEventPool (), null, "local", null, 0, -1, EventPoolProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEventPoolProxy_Remote (), this.getEventPool (), null, "remote", null, 0, -1, EventPoolProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventPoolProxy_Size (), ecorePackage.getEInt (), "size", null, 1, 1, EventPoolProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( alarmsEventsModuleEClass, AlarmsEventsModule.class, "AlarmsEventsModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAlarmsEventsModule_MonitorPoolProxies (), this.getMonitorPoolProxy (), null, "monitorPoolProxies", null, 0, -1, AlarmsEventsModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAlarmsEventsModule_EventPoolProxies (), this.getEventPoolProxy (), null, "eventPoolProxies", null, 0, -1, AlarmsEventsModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAlarmsEventsModule_AknProxies (), this.getAknProxy (), null, "aknProxies", null, 0, -1, AlarmsEventsModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAlarmsEventsModule_PullEvents (), this.getPullEvents (), null, "pullEvents", null, 0, -1, AlarmsEventsModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( aknProxyEClass, AknProxy.class, "AknProxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAknProxy_Pattern (), theWorldPackage.getPattern (), "pattern", null, 1, 1, AknProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAknProxy_Connection (), this.getAlarmsEventsConnection (), null, "connection", null, 1, 1, AknProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAknProxy_Priority (), ecorePackage.getEInt (), "priority", null, 1, 1, AknProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAknProxy_Authorative (), ecorePackage.getEBoolean (), "authorative", "true", 1, 1, AknProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( pullEventsEClass, PullEvents.class, "PullEvents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPullEvents_JdbcDriverName (), ecorePackage.getEString (), "jdbcDriverName", null, 1, 1, PullEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getPullEvents_JdbcProperties (), theWorldPackage.getPropertyEntry (), null, "jdbcProperties", null, 0, -1, PullEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPullEvents_JobInterval (), ecorePackage.getEIntegerObject (), "jobInterval", null, 0, 1, PullEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPullEvents_CustomSelectSql (), ecorePackage.getEString (), "customSelectSql", null, 0, 1, PullEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPullEvents_CustomDeleteSql (), ecorePackage.getEString (), "customDeleteSql", null, 0, 1, PullEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( jdbcUserServiceModuleEClass, JdbcUserServiceModule.class, "JdbcUserServiceModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getJdbcUserServiceModule_UserServices (), this.getJdbcUserService (), null, "userServices", null, 0, -1, JdbcUserServiceModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( jdbcUserServiceEClass, JdbcUserService.class, "JdbcUserService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getJdbcUserService_JdbcPropeties (), theWorldPackage.getPropertyEntry (), null, "jdbcPropeties", null, 0, -1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_JdbcDriver (), ecorePackage.getEString (), "jdbcDriver", null, 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_Authorative (), ecorePackage.getEBoolean (), "authorative", "true", 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getJdbcUserService_FindUserSql (), ecorePackage.getEString (), "findUserSql", null, 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_FindRolesForUserSql (), ecorePackage.getEString (), "findRolesForUserSql", null, 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_UpdatePasswordSql (), ecorePackage.getEString (), "updatePasswordSql", null, 0, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_UserIdColumnName (), ecorePackage.getEString (), "userIdColumnName", null, 0, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJdbcUserService_PasswordColumnName (), ecorePackage.getEString (), "passwordColumnName", "password", 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getJdbcUserService_PasswordType (), this.getPasswordType (), "passwordType", null, 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( defaultValueArchiveServerEClass, DefaultValueArchiveServer.class, "DefaultValueArchiveServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( historicalDataExporterEClass, HistoricalDataExporter.class, "HistoricalDataExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getHistoricalDataExporter__GetTypeTag (), ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( valueArchiveEClass, ValueArchive.class, "ValueArchive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getValueArchive_Items (), this.getItem (), null, "items", null, 0, -1, ValueArchive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( configurationAdministratorExporterEClass, ConfigurationAdministratorExporter.class, "ConfigurationAdministratorExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getConfigurationAdministratorExporter__GetTypeTag (), ecorePackage.getEString (), "getTypeTag", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( referenceItemEClass, ReferenceItem.class, "ReferenceItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getReferenceItem_Source (), this.getItem (), null, "source", null, 1, 1, ReferenceItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( eventStorageEClass, EventStorage.class, "EventStorage", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( eventStorageJdbcEClass, EventStorageJdbc.class, "EventStorageJdbc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventStorageJdbc_JdbcDriverName (), ecorePackage.getEString (), "jdbcDriverName", null, 1, 1, EventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventStorageJdbc_DriverBundles (), ecorePackage.getEString (), "driverBundles", null, 0, -1, EventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventStorageJdbc_MaxFieldLength (), ecorePackage.getEIntegerObject (), "maxFieldLength", null, 0, 1, EventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventStorageJdbc_QueryFetchSize (), ecorePackage.getEIntegerObject (), "queryFetchSize", null, 0, 1, EventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( eventStoragePostgresEClass, EventStoragePostgres.class, "EventStoragePostgres", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventStoragePostgres_BatchSize (), ecorePackage.getEIntegerObject (), "batchSize", null, 0, 1, EventStoragePostgres.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventStoragePostgres_PostgresDriverBundles (), ecorePackage.getEString (), "postgresDriverBundles", null, 0, -1, EventStoragePostgres.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getEventStoragePostgres__GetJdbcDriverName (), ecorePackage.getEString (), "getJdbcDriverName", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getEventStoragePostgres__GetDriverBundles (), ecorePackage.getEString (), "getDriverBundles", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( abstractEventStorageJdbcEClass, AbstractEventStorageJdbc.class, "AbstractEventStorageJdbc", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAbstractEventStorageJdbc_JdbcProperties (), theWorldPackage.getPropertyEntry (), null, "jdbcProperties", null, 0, -1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAbstractEventStorageJdbc_Schema (), ecorePackage.getEString (), "schema", null, 0, 1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAbstractEventStorageJdbc_InstanceName (), ecorePackage.getEString (), "instanceName", "default", 1, 1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getAbstractEventStorageJdbc_EnableReplication (), ecorePackage.getEBoolean (), "enableReplication", "false", 1, 1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getAbstractEventStorageJdbc_ArchiveDays (), ecorePackage.getEIntegerObject (), "archiveDays", null, 0, 1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAbstractEventStorageJdbc_CleanupPeriodSeconds (), ecorePackage.getEIntegerObject (), "cleanupPeriodSeconds", null, 0, 1, AbstractEventStorageJdbc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getAbstractEventStorageJdbc__GetJdbcDriverName (), ecorePackage.getEString (), "getJdbcDriverName", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getAbstractEventStorageJdbc__GetDriverBundles (), ecorePackage.getEString (), "getDriverBundles", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( applicationConfigurationEClass, ApplicationConfiguration.class, "ApplicationConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( restExporterEClass, RestExporter.class, "RestExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getRestExporter_Items (), this.getItem (), null, "items", null, 0, -1, RestExporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getRestExporter_HiveProperties (), theWorldPackage.getPropertyEntry (), null, "hiveProperties", null, 0, -1, RestExporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRestExporter_ContextId (), ecorePackage.getEString (), "contextId", null, 1, 1, RestExporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( httpServiceEClass, HttpService.class, "HttpService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getHttpService_Endpoint (), theWorldPackage.getEndpoint (), null, "endpoint", null, 1, 1, HttpService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( independentConfigurationEClass, IndependentConfiguration.class, "IndependentConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( transientItemEClass, TransientItem.class, "TransientItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( defaultEquinoxApplicationEClass, DefaultEquinoxApplication.class, "DefaultEquinoxApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDefaultEquinoxApplication_Profile (), theProfilePackage.getProfile (), null, "profile", null, 1, 1, DefaultEquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( changeCounterItemEClass, ChangeCounterItem.class, "ChangeCounterItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getChangeCounterItem_Buffer (), this.getBufferedValue (), null, "buffer", null, 0, 1, ChangeCounterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChangeCounterItem_Type (), this.getChangeType (), "type", "DELTA", 0, 1, ChangeCounterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getChangeCounterItem_OnError (), this.getErrorHandling (), "onError", "ERROR", 0, 1, ChangeCounterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getChangeCounterItem_Values (), this.getVariant (), "values", null, 1, -1, ChangeCounterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( bufferedValueEClass, BufferedValue.class, "BufferedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getBufferedValue_Item (), this.getItemReference (), null, "item", null, 1, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBufferedValue_InitialValue (), this.getVariant (), "initialValue", "", 0, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getBufferedValue_Range (), ecorePackage.getELong (), "range", null, 1, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBufferedValue_Trigger (), ecorePackage.getELong (), "trigger", "1", 1, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getBufferedValue_TriggerOnly (), ecorePackage.getEBooleanObject (), "triggerOnly", "false", 0, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getBufferedValue_Persistence (), this.getPersistence (), "persistence", "NONE", 0, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( telnetConsoleEClass, TelnetConsole.class, "TelnetConsole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTelnetConsole_Host (), ecorePackage.getEString (), "host", "localhost", 0, 1, TelnetConsole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getTelnetConsole_Port (), ecorePackage.getEShort (), "port", null, 1, 1, TelnetConsole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( averageReferenceTypeEEnum, AverageReferenceType.class, "AverageReferenceType" ); //$NON-NLS-1$
        addEEnumLiteral ( averageReferenceTypeEEnum, AverageReferenceType.MIN );
        addEEnumLiteral ( averageReferenceTypeEEnum, AverageReferenceType.MAX );
        addEEnumLiteral ( averageReferenceTypeEEnum, AverageReferenceType.MEAN );
        addEEnumLiteral ( averageReferenceTypeEEnum, AverageReferenceType.MEDIAN );
        addEEnumLiteral ( averageReferenceTypeEEnum, AverageReferenceType.DEVIATION );
        addEEnumLiteral ( averageReferenceTypeEEnum, AverageReferenceType.SUM );

        initEEnum ( movingAverageReferenceTypeEEnum, MovingAverageReferenceType.class, "MovingAverageReferenceType" ); //$NON-NLS-1$
        addEEnumLiteral ( movingAverageReferenceTypeEEnum, MovingAverageReferenceType.MIN );
        addEEnumLiteral ( movingAverageReferenceTypeEEnum, MovingAverageReferenceType.MAX );
        addEEnumLiteral ( movingAverageReferenceTypeEEnum, MovingAverageReferenceType.MEDIAN );
        addEEnumLiteral ( movingAverageReferenceTypeEEnum, MovingAverageReferenceType.ARITHMETIC );
        addEEnumLiteral ( movingAverageReferenceTypeEEnum, MovingAverageReferenceType.WEIGHTED );
        addEEnumLiteral ( movingAverageReferenceTypeEEnum, MovingAverageReferenceType.DEVIATION_ARITHMETIC );
        addEEnumLiteral ( movingAverageReferenceTypeEEnum, MovingAverageReferenceType.DEVIATION_WEIGHTED );

        initEEnum ( roundingTypeEEnum, RoundingType.class, "RoundingType" ); //$NON-NLS-1$
        addEEnumLiteral ( roundingTypeEEnum, RoundingType.NONE );
        addEEnumLiteral ( roundingTypeEEnum, RoundingType.ROUND );
        addEEnumLiteral ( roundingTypeEEnum, RoundingType.CEIL );
        addEEnumLiteral ( roundingTypeEEnum, RoundingType.FLOOR );

        initEEnum ( dataTypeEEnum, DataType.class, "DataType" ); //$NON-NLS-1$
        addEEnumLiteral ( dataTypeEEnum, DataType.VARIANT );
        addEEnumLiteral ( dataTypeEEnum, DataType.NULL );
        addEEnumLiteral ( dataTypeEEnum, DataType.INT32 );
        addEEnumLiteral ( dataTypeEEnum, DataType.INT64 );
        addEEnumLiteral ( dataTypeEEnum, DataType.FLOAT );
        addEEnumLiteral ( dataTypeEEnum, DataType.STRING );
        addEEnumLiteral ( dataTypeEEnum, DataType.BOOLEAN );

        initEEnum ( passwordTypeEEnum, PasswordType.class, "PasswordType" ); //$NON-NLS-1$
        addEEnumLiteral ( passwordTypeEEnum, PasswordType.PLAIN );
        addEEnumLiteral ( passwordTypeEEnum, PasswordType.PLAIN_IGNORE_CASE );
        addEEnumLiteral ( passwordTypeEEnum, PasswordType.MD5_HEX );
        addEEnumLiteral ( passwordTypeEEnum, PasswordType.SHA1_HEX );

        initEEnum ( persistenceEEnum, Persistence.class, "Persistence" ); //$NON-NLS-1$
        addEEnumLiteral ( persistenceEEnum, Persistence.NONE );
        addEEnumLiteral ( persistenceEEnum, Persistence.LAZY );
        addEEnumLiteral ( persistenceEEnum, Persistence.REQUIRED );

        initEEnum ( errorHandlingEEnum, ErrorHandling.class, "ErrorHandling" ); //$NON-NLS-1$
        addEEnumLiteral ( errorHandlingEEnum, ErrorHandling.IGNORE );
        addEEnumLiteral ( errorHandlingEEnum, ErrorHandling.COUNT );
        addEEnumLiteral ( errorHandlingEEnum, ErrorHandling.ERROR );

        initEEnum ( changeTypeEEnum, ChangeType.class, "ChangeType" ); //$NON-NLS-1$
        addEEnumLiteral ( changeTypeEEnum, ChangeType.DELTA );
        addEEnumLiteral ( changeTypeEEnum, ChangeType.SET );
        addEEnumLiteral ( changeTypeEEnum, ChangeType.DIRECTION );

        // Initialize data types
        initEDataType ( severityEDataType, Severity.class, "Severity", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( variantEDataType, Variant.class, "Variant", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create annotations
        // http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup
        createExclusiveGroupAnnotations ();
    }

    /**
     * Initializes the annotations for <b>http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExclusiveGroupAnnotations ()
    {
        String source = "http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup"; //$NON-NLS-1$																				
        addAnnotation ( eventStorageEClass,
                source,
                new String[]
                {       "groupId", "ae.storage" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( httpServiceEClass,
                source,
                new String[]
                {       "groupId", "http.service" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( telnetConsoleEClass,
                source,
                new String[]
                {       "groupId", "telnet.console" //$NON-NLS-1$ //$NON-NLS-2$
                } );
    }

} //OsgiPackageImpl
