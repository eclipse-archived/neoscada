/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.globalization.GlobalizePackage;
import org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver;
import org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration;
import org.eclipse.scada.configuration.infrastructure.CommonDriver;
import org.eclipse.scada.configuration.infrastructure.ConfigurationAdminFileBackend;
import org.eclipse.scada.configuration.infrastructure.Configurations;
import org.eclipse.scada.configuration.infrastructure.DSFileBackend;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.EquinoxApplication;
import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.EquinoxModule;
import org.eclipse.scada.configuration.infrastructure.EventInjectorHttp;
import org.eclipse.scada.configuration.infrastructure.EventInjectorSyslog;
import org.eclipse.scada.configuration.infrastructure.ExternalDriver;
import org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder;
import org.eclipse.scada.configuration.infrastructure.ExternalNode;
import org.eclipse.scada.configuration.infrastructure.GenericVMSettings;
import org.eclipse.scada.configuration.infrastructure.HttpServiceModule;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.JMXSettings;
import org.eclipse.scada.configuration.infrastructure.JavaModule;
import org.eclipse.scada.configuration.infrastructure.JdbcUserService;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.Module;
import org.eclipse.scada.configuration.infrastructure.NamedApplication;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.configuration.infrastructure.OracleVMSettings;
import org.eclipse.scada.configuration.infrastructure.RestExporterModule;
import org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout;
import org.eclipse.scada.configuration.infrastructure.SystemNode;
import org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService;
import org.eclipse.scada.configuration.infrastructure.UserEntry;
import org.eclipse.scada.configuration.infrastructure.UserService;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveServer;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave;
import org.eclipse.scada.configuration.infrastructure.WebAdminConsole;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.utils.ecore.validation.ExtensibleValidationDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class InfrastructurePackageImpl extends EPackageImpl implements InfrastructurePackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass worldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass nodeEClass = null;

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
    private EClass masterImportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass optionsEClass = null;

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
    private EClass commonDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass externalNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass systemNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass systemPropertyUserServiceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass userEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass userServiceEClass = null;

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
    private EClass valueArchiveServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass abstractFactoryDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass deviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass equinoxDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass externalDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass driverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass externalDriverPlaceholderEClass = null;

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
    private EClass configurationsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass moduleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass httpServiceModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass restExporterModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass valueArchiveSlaveEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass webAdminConsoleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass oracleVMSettingsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass genericVMSettingsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass abstractEquinoxDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass equinoxBaseEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass abstractCommonDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass eventInjectorHttpEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass eventInjectorSyslogEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass jmxSettingsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass namedApplicationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass configurationAdminFileBackendEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass equinoxModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass javaModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dsFileBackendEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum slaveStorageLayoutEEnum = null;

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
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private InfrastructurePackageImpl ()
    {
        super ( eNS_URI, InfrastructureFactory.eINSTANCE );
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
     * This method is used to initialize {@link InfrastructurePackage#eINSTANCE}
     * when that field is accessed. Clients should not invoke it directly.
     * Instead, they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated NOT
     */
    public static InfrastructurePackage init ()
    {
        if ( isInited )
        {
            return (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );
        }

        // Obtain or create and register package
        final InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof InfrastructurePackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new InfrastructurePackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        GlobalizePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theInfrastructurePackage.createPackageContents ();

        // Initialize created meta-data
        theInfrastructurePackage.initializePackageContents ();

        // Register package validator
        registerPackageValidator ( theInfrastructurePackage );

        // Mark meta-data to indicate it can't be changed
        theInfrastructurePackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( InfrastructurePackage.eNS_URI, theInfrastructurePackage );
        return theInfrastructurePackage;
    }

    protected static void registerPackageValidator ( final InfrastructurePackageImpl theInfrastructurePackage )
    {
        EValidator.Registry.INSTANCE.put ( theInfrastructurePackage, new ExtensibleValidationDescriptor () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getWorld ()
    {
        return this.worldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_Nodes ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_Options ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_DefaultSecurityConfiguration ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_DefaultMasterHandlerPriorities ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_DefaultCredentials ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_DefaultMasterCustomizationProfile ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_DefaultValueArchiveCustomizationProfile ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_DefaultDriverPassword ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_ApplicationConfigurations ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_DefaultDriverAccessCredentials ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorld_Configurations ()
    {
        return (EReference)this.worldEClass.getEStructuralFeatures ().get ( 10 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getNode ()
    {
        return this.nodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getNode_HostName ()
    {
        return (EAttribute)this.nodeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getNode_Devices ()
    {
        return (EReference)this.nodeEClass.getEStructuralFeatures ().get ( 1 );
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
    public EReference getMasterServer_Authoratives ()
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
    public EReference getMasterServer_ImportMaster ()
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
    public EReference getMasterServer_Driver ()
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
    public EReference getMasterServer_ArchiveTo ()
    {
        return (EReference)this.masterServerEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMasterImport ()
    {
        return this.masterImportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterImport_ImportedMaster ()
    {
        return (EReference)this.masterImportEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMasterImport_Id ()
    {
        return (EAttribute)this.masterImportEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterImport_Credentials ()
    {
        return (EReference)this.masterImportEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterImport_Master ()
    {
        return (EReference)this.masterImportEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getOptions ()
    {
        return this.optionsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getOptions_BaseDaNgpPort ()
    {
        return (EAttribute)this.optionsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getOptions_BaseAeNgpPort ()
    {
        return (EAttribute)this.optionsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getOptions_BaseCaNgpPort ()
    {
        return (EAttribute)this.optionsEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getOptions_BaseHdNgpPort ()
    {
        return (EAttribute)this.optionsEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getOptions_MonitorPools ()
    {
        return (EReference)this.optionsEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getOptions_EventPools ()
    {
        return (EReference)this.optionsEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getOptions_DefaultUserService ()
    {
        return (EReference)this.optionsEClass.getEStructuralFeatures ().get ( 6 );
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
    public EReference getEquinoxApplication_LocalCredentials ()
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
    public EClass getCommonDriver ()
    {
        return this.commonDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCommonDriver_Password ()
    {
        return (EReference)this.commonDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getCommonDriver_PortNumber ()
    {
        return (EAttribute)this.commonDriverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExternalNode ()
    {
        return this.externalNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSystemNode ()
    {
        return this.systemNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSystemNode_Deployment ()
    {
        return (EReference)this.systemNodeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSystemNode_Drivers ()
    {
        return (EReference)this.systemNodeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSystemNode_Masters ()
    {
        return (EReference)this.systemNodeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSystemNode_ValueArchives ()
    {
        return (EReference)this.systemNodeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSystemNode_Applications ()
    {
        return (EAttribute)this.systemNodeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSystemNode_Services ()
    {
        return (EReference)this.systemNodeEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSystemNode_ValueSlaves ()
    {
        return (EReference)this.systemNodeEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSystemPropertyUserService ()
    {
        return this.systemPropertyUserServiceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSystemPropertyUserService_Users ()
    {
        return (EReference)this.systemPropertyUserServiceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getUserEntry ()
    {
        return this.userEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getUserEntry_Name ()
    {
        return (EAttribute)this.userEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getUserEntry_Password ()
    {
        return (EAttribute)this.userEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getUserEntry_Roles ()
    {
        return (EAttribute)this.userEntryEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getUserService ()
    {
        return this.userServiceEClass;
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
    public EReference getJdbcUserService_Implementation ()
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
    public EClass getAbstractFactoryDriver ()
    {
        return this.abstractFactoryDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractFactoryDriver_DriverTypeId ()
    {
        return (EAttribute)this.abstractFactoryDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractFactoryDriver_Devices ()
    {
        return (EReference)this.abstractFactoryDriverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDevice ()
    {
        return this.deviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDevice_Node ()
    {
        return (EReference)this.deviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEquinoxDriver ()
    {
        return this.equinoxDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxDriver_AccessCredentials ()
    {
        return (EReference)this.equinoxDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExternalDriver ()
    {
        return this.externalDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExternalDriver_PortNumber ()
    {
        return (EAttribute)this.externalDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExternalDriver_AccessCredentials ()
    {
        return (EReference)this.externalDriverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExternalDriver_Binding ()
    {
        return (EAttribute)this.externalDriverEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDriver ()
    {
        return this.driverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDriver_Node ()
    {
        return (EReference)this.driverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDriver_ProtocolTypeTag ()
    {
        return (EAttribute)this.driverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExternalDriverPlaceholder ()
    {
        return this.externalDriverPlaceholderEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExternalDriverPlaceholder_Endpoints ()
    {
        return (EReference)this.externalDriverPlaceholderEClass.getEStructuralFeatures ().get ( 0 );
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
    public EReference getApplicationConfiguration_Modules ()
    {
        return (EReference)this.applicationConfigurationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getApplicationConfiguration_Configurations ()
    {
        return (EReference)this.applicationConfigurationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConfigurations ()
    {
        return this.configurationsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConfigurations_Configurations ()
    {
        return (EReference)this.configurationsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConfigurations_Settings ()
    {
        return (EReference)this.configurationsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModule ()
    {
        return this.moduleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getHttpServiceModule ()
    {
        return this.httpServiceModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHttpServiceModule_Port ()
    {
        return (EAttribute)this.httpServiceModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getRestExporterModule ()
    {
        return this.restExporterModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRestExporterModule_ContextId ()
    {
        return (EAttribute)this.restExporterModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getValueArchiveSlave ()
    {
        return this.valueArchiveSlaveEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getValueArchiveSlave_StoragePath ()
    {
        return (EAttribute)this.valueArchiveSlaveEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getValueArchiveSlave_StorageLayout ()
    {
        return (EAttribute)this.valueArchiveSlaveEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getWebAdminConsole ()
    {
        return this.webAdminConsoleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWebAdminConsole_HttpService ()
    {
        return (EReference)this.webAdminConsoleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getOracleVMSettings ()
    {
        return this.oracleVMSettingsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getOracleVMSettings_InitialHeapSize ()
    {
        return (EAttribute)this.oracleVMSettingsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getOracleVMSettings_MaximumHeapSize ()
    {
        return (EAttribute)this.oracleVMSettingsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getGenericVMSettings ()
    {
        return this.genericVMSettingsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGenericVMSettings_Arguments ()
    {
        return (EAttribute)this.genericVMSettingsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAbstractEquinoxDriver ()
    {
        return this.abstractEquinoxDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractEquinoxDriver_AccessCredentials ()
    {
        return (EReference)this.abstractEquinoxDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEquinoxBase ()
    {
        return this.equinoxBaseEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEquinoxBase_InstanceNumber ()
    {
        return (EAttribute)this.equinoxBaseEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxBase_UserService ()
    {
        return (EReference)this.equinoxBaseEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxBase_SecurityConfiguration ()
    {
        return (EReference)this.equinoxBaseEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxBase_Modules ()
    {
        return (EReference)this.equinoxBaseEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxBase_Configuration ()
    {
        return (EReference)this.equinoxBaseEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEquinoxBase_Configurations ()
    {
        return (EReference)this.equinoxBaseEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAbstractCommonDriver ()
    {
        return this.abstractCommonDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractCommonDriver_PortNumber ()
    {
        return (EAttribute)this.abstractCommonDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractCommonDriver_Password ()
    {
        return (EReference)this.abstractCommonDriverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEventInjectorHttp ()
    {
        return this.eventInjectorHttpEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEventInjectorHttp_HttpService ()
    {
        return (EReference)this.eventInjectorHttpEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEventInjectorSyslog ()
    {
        return this.eventInjectorSyslogEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventInjectorSyslog_BindAddress ()
    {
        return (EAttribute)this.eventInjectorSyslogEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventInjectorSyslog_Port ()
    {
        return (EAttribute)this.eventInjectorSyslogEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getJMXSettings ()
    {
        return this.jmxSettingsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJMXSettings_Port ()
    {
        return (EAttribute)this.jmxSettingsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJMXSettings_InstancePortOffset ()
    {
        return (EAttribute)this.jmxSettingsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJMXSettings_LocalOnly ()
    {
        return (EAttribute)this.jmxSettingsEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJMXSettings_Authenticated ()
    {
        return (EAttribute)this.jmxSettingsEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJMXSettings_Ssl ()
    {
        return (EAttribute)this.jmxSettingsEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJMXSettings_AssignNodeHostname ()
    {
        return (EAttribute)this.jmxSettingsEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getNamedApplication ()
    {
        return this.namedApplicationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getNamedApplication_Name ()
    {
        return (EAttribute)this.namedApplicationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConfigurationAdminFileBackend ()
    {
        return this.configurationAdminFileBackendEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getConfigurationAdminFileBackend_Path ()
    {
        return (EAttribute)this.configurationAdminFileBackendEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEquinoxModule ()
    {
        return this.equinoxModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getJavaModule ()
    {
        return this.javaModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDSFileBackend ()
    {
        return this.dsFileBackendEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDSFileBackend_Path ()
    {
        return (EAttribute)this.dsFileBackendEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getSlaveStorageLayout ()
    {
        return this.slaveStorageLayoutEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureFactory getInfrastructureFactory ()
    {
        return (InfrastructureFactory)getEFactoryInstance ();
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
        this.worldEClass = createEClass ( WORLD );
        createEReference ( this.worldEClass, WORLD__NODES );
        createEReference ( this.worldEClass, WORLD__OPTIONS );
        createEReference ( this.worldEClass, WORLD__DEFAULT_SECURITY_CONFIGURATION );
        createEReference ( this.worldEClass, WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES );
        createEReference ( this.worldEClass, WORLD__DEFAULT_CREDENTIALS );
        createEReference ( this.worldEClass, WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE );
        createEReference ( this.worldEClass, WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE );
        createEReference ( this.worldEClass, WORLD__DEFAULT_DRIVER_PASSWORD );
        createEReference ( this.worldEClass, WORLD__APPLICATION_CONFIGURATIONS );
        createEReference ( this.worldEClass, WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS );
        createEReference ( this.worldEClass, WORLD__CONFIGURATIONS );

        this.nodeEClass = createEClass ( NODE );
        createEAttribute ( this.nodeEClass, NODE__HOST_NAME );
        createEReference ( this.nodeEClass, NODE__DEVICES );

        this.masterServerEClass = createEClass ( MASTER_SERVER );
        createEReference ( this.masterServerEClass, MASTER_SERVER__AUTHORATIVES );
        createEReference ( this.masterServerEClass, MASTER_SERVER__IMPORT_MASTER );
        createEReference ( this.masterServerEClass, MASTER_SERVER__DRIVER );
        createEReference ( this.masterServerEClass, MASTER_SERVER__ARCHIVE_TO );

        this.masterImportEClass = createEClass ( MASTER_IMPORT );
        createEReference ( this.masterImportEClass, MASTER_IMPORT__IMPORTED_MASTER );
        createEAttribute ( this.masterImportEClass, MASTER_IMPORT__ID );
        createEReference ( this.masterImportEClass, MASTER_IMPORT__CREDENTIALS );
        createEReference ( this.masterImportEClass, MASTER_IMPORT__MASTER );

        this.optionsEClass = createEClass ( OPTIONS );
        createEAttribute ( this.optionsEClass, OPTIONS__BASE_DA_NGP_PORT );
        createEAttribute ( this.optionsEClass, OPTIONS__BASE_AE_NGP_PORT );
        createEAttribute ( this.optionsEClass, OPTIONS__BASE_CA_NGP_PORT );
        createEAttribute ( this.optionsEClass, OPTIONS__BASE_HD_NGP_PORT );
        createEReference ( this.optionsEClass, OPTIONS__MONITOR_POOLS );
        createEReference ( this.optionsEClass, OPTIONS__EVENT_POOLS );
        createEReference ( this.optionsEClass, OPTIONS__DEFAULT_USER_SERVICE );

        this.equinoxApplicationEClass = createEClass ( EQUINOX_APPLICATION );
        createEReference ( this.equinoxApplicationEClass, EQUINOX_APPLICATION__LOCAL_CREDENTIALS );

        this.commonDriverEClass = createEClass ( COMMON_DRIVER );
        createEReference ( this.commonDriverEClass, COMMON_DRIVER__PASSWORD );
        createEAttribute ( this.commonDriverEClass, COMMON_DRIVER__PORT_NUMBER );

        this.externalNodeEClass = createEClass ( EXTERNAL_NODE );

        this.systemNodeEClass = createEClass ( SYSTEM_NODE );
        createEReference ( this.systemNodeEClass, SYSTEM_NODE__DEPLOYMENT );
        createEReference ( this.systemNodeEClass, SYSTEM_NODE__DRIVERS );
        createEReference ( this.systemNodeEClass, SYSTEM_NODE__MASTERS );
        createEReference ( this.systemNodeEClass, SYSTEM_NODE__VALUE_ARCHIVES );
        createEAttribute ( this.systemNodeEClass, SYSTEM_NODE__APPLICATIONS );
        createEReference ( this.systemNodeEClass, SYSTEM_NODE__SERVICES );
        createEReference ( this.systemNodeEClass, SYSTEM_NODE__VALUE_SLAVES );

        this.systemPropertyUserServiceEClass = createEClass ( SYSTEM_PROPERTY_USER_SERVICE );
        createEReference ( this.systemPropertyUserServiceEClass, SYSTEM_PROPERTY_USER_SERVICE__USERS );

        this.userEntryEClass = createEClass ( USER_ENTRY );
        createEAttribute ( this.userEntryEClass, USER_ENTRY__NAME );
        createEAttribute ( this.userEntryEClass, USER_ENTRY__PASSWORD );
        createEAttribute ( this.userEntryEClass, USER_ENTRY__ROLES );

        this.userServiceEClass = createEClass ( USER_SERVICE );

        this.jdbcUserServiceEClass = createEClass ( JDBC_USER_SERVICE );
        createEReference ( this.jdbcUserServiceEClass, JDBC_USER_SERVICE__IMPLEMENTATION );

        this.valueArchiveServerEClass = createEClass ( VALUE_ARCHIVE_SERVER );

        this.abstractFactoryDriverEClass = createEClass ( ABSTRACT_FACTORY_DRIVER );
        createEAttribute ( this.abstractFactoryDriverEClass, ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID );
        createEReference ( this.abstractFactoryDriverEClass, ABSTRACT_FACTORY_DRIVER__DEVICES );

        this.deviceEClass = createEClass ( DEVICE );
        createEReference ( this.deviceEClass, DEVICE__NODE );

        this.equinoxDriverEClass = createEClass ( EQUINOX_DRIVER );
        createEReference ( this.equinoxDriverEClass, EQUINOX_DRIVER__ACCESS_CREDENTIALS );

        this.externalDriverEClass = createEClass ( EXTERNAL_DRIVER );
        createEAttribute ( this.externalDriverEClass, EXTERNAL_DRIVER__PORT_NUMBER );
        createEReference ( this.externalDriverEClass, EXTERNAL_DRIVER__ACCESS_CREDENTIALS );
        createEAttribute ( this.externalDriverEClass, EXTERNAL_DRIVER__BINDING );

        this.driverEClass = createEClass ( DRIVER );
        createEReference ( this.driverEClass, DRIVER__NODE );
        createEAttribute ( this.driverEClass, DRIVER__PROTOCOL_TYPE_TAG );

        this.externalDriverPlaceholderEClass = createEClass ( EXTERNAL_DRIVER_PLACEHOLDER );
        createEReference ( this.externalDriverPlaceholderEClass, EXTERNAL_DRIVER_PLACEHOLDER__ENDPOINTS );

        this.applicationConfigurationEClass = createEClass ( APPLICATION_CONFIGURATION );
        createEReference ( this.applicationConfigurationEClass, APPLICATION_CONFIGURATION__MODULES );
        createEReference ( this.applicationConfigurationEClass, APPLICATION_CONFIGURATION__CONFIGURATIONS );

        this.configurationsEClass = createEClass ( CONFIGURATIONS );
        createEReference ( this.configurationsEClass, CONFIGURATIONS__CONFIGURATIONS );
        createEReference ( this.configurationsEClass, CONFIGURATIONS__SETTINGS );

        this.moduleEClass = createEClass ( MODULE );

        this.httpServiceModuleEClass = createEClass ( HTTP_SERVICE_MODULE );
        createEAttribute ( this.httpServiceModuleEClass, HTTP_SERVICE_MODULE__PORT );

        this.restExporterModuleEClass = createEClass ( REST_EXPORTER_MODULE );
        createEAttribute ( this.restExporterModuleEClass, REST_EXPORTER_MODULE__CONTEXT_ID );

        this.valueArchiveSlaveEClass = createEClass ( VALUE_ARCHIVE_SLAVE );
        createEAttribute ( this.valueArchiveSlaveEClass, VALUE_ARCHIVE_SLAVE__STORAGE_PATH );
        createEAttribute ( this.valueArchiveSlaveEClass, VALUE_ARCHIVE_SLAVE__STORAGE_LAYOUT );

        this.webAdminConsoleEClass = createEClass ( WEB_ADMIN_CONSOLE );
        createEReference ( this.webAdminConsoleEClass, WEB_ADMIN_CONSOLE__HTTP_SERVICE );

        this.oracleVMSettingsEClass = createEClass ( ORACLE_VM_SETTINGS );
        createEAttribute ( this.oracleVMSettingsEClass, ORACLE_VM_SETTINGS__INITIAL_HEAP_SIZE );
        createEAttribute ( this.oracleVMSettingsEClass, ORACLE_VM_SETTINGS__MAXIMUM_HEAP_SIZE );

        this.genericVMSettingsEClass = createEClass ( GENERIC_VM_SETTINGS );
        createEAttribute ( this.genericVMSettingsEClass, GENERIC_VM_SETTINGS__ARGUMENTS );

        this.abstractEquinoxDriverEClass = createEClass ( ABSTRACT_EQUINOX_DRIVER );
        createEReference ( this.abstractEquinoxDriverEClass, ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS );

        this.equinoxBaseEClass = createEClass ( EQUINOX_BASE );
        createEAttribute ( this.equinoxBaseEClass, EQUINOX_BASE__INSTANCE_NUMBER );
        createEReference ( this.equinoxBaseEClass, EQUINOX_BASE__USER_SERVICE );
        createEReference ( this.equinoxBaseEClass, EQUINOX_BASE__SECURITY_CONFIGURATION );
        createEReference ( this.equinoxBaseEClass, EQUINOX_BASE__MODULES );
        createEReference ( this.equinoxBaseEClass, EQUINOX_BASE__CONFIGURATION );
        createEReference ( this.equinoxBaseEClass, EQUINOX_BASE__CONFIGURATIONS );

        this.abstractCommonDriverEClass = createEClass ( ABSTRACT_COMMON_DRIVER );
        createEAttribute ( this.abstractCommonDriverEClass, ABSTRACT_COMMON_DRIVER__PORT_NUMBER );
        createEReference ( this.abstractCommonDriverEClass, ABSTRACT_COMMON_DRIVER__PASSWORD );

        this.eventInjectorHttpEClass = createEClass ( EVENT_INJECTOR_HTTP );
        createEReference ( this.eventInjectorHttpEClass, EVENT_INJECTOR_HTTP__HTTP_SERVICE );

        this.eventInjectorSyslogEClass = createEClass ( EVENT_INJECTOR_SYSLOG );
        createEAttribute ( this.eventInjectorSyslogEClass, EVENT_INJECTOR_SYSLOG__BIND_ADDRESS );
        createEAttribute ( this.eventInjectorSyslogEClass, EVENT_INJECTOR_SYSLOG__PORT );

        this.jmxSettingsEClass = createEClass ( JMX_SETTINGS );
        createEAttribute ( this.jmxSettingsEClass, JMX_SETTINGS__PORT );
        createEAttribute ( this.jmxSettingsEClass, JMX_SETTINGS__INSTANCE_PORT_OFFSET );
        createEAttribute ( this.jmxSettingsEClass, JMX_SETTINGS__LOCAL_ONLY );
        createEAttribute ( this.jmxSettingsEClass, JMX_SETTINGS__AUTHENTICATED );
        createEAttribute ( this.jmxSettingsEClass, JMX_SETTINGS__SSL );
        createEAttribute ( this.jmxSettingsEClass, JMX_SETTINGS__ASSIGN_NODE_HOSTNAME );

        this.namedApplicationEClass = createEClass ( NAMED_APPLICATION );
        createEAttribute ( this.namedApplicationEClass, NAMED_APPLICATION__NAME );

        this.configurationAdminFileBackendEClass = createEClass ( CONFIGURATION_ADMIN_FILE_BACKEND );
        createEAttribute ( this.configurationAdminFileBackendEClass, CONFIGURATION_ADMIN_FILE_BACKEND__PATH );

        this.equinoxModuleEClass = createEClass ( EQUINOX_MODULE );

        this.javaModuleEClass = createEClass ( JAVA_MODULE );

        this.dsFileBackendEClass = createEClass ( DS_FILE_BACKEND );
        createEAttribute ( this.dsFileBackendEClass, DS_FILE_BACKEND__PATH );

        // Create enums
        this.slaveStorageLayoutEEnum = createEEnum ( SLAVE_STORAGE_LAYOUT );
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
        final SecurityPackage theSecurityPackage = (SecurityPackage)EPackage.Registry.INSTANCE.getEPackage ( SecurityPackage.eNS_URI );
        final WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        final ProfilePackage theProfilePackage = (ProfilePackage)EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI );
        final OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        final GlobalizePackage theGlobalizePackage = (GlobalizePackage)EPackage.Registry.INSTANCE.getEPackage ( GlobalizePackage.eNS_URI );
        final EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage ( EcorePackage.eNS_URI );
        final DeploymentPackage theDeploymentPackage = (DeploymentPackage)EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.nodeEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        this.masterServerEClass.getESuperTypes ().add ( getEquinoxApplication () );
        this.equinoxApplicationEClass.getESuperTypes ().add ( getEquinoxBase () );
        this.commonDriverEClass.getESuperTypes ().add ( getAbstractFactoryDriver () );
        this.externalNodeEClass.getESuperTypes ().add ( getNode () );
        this.systemNodeEClass.getESuperTypes ().add ( getNode () );
        this.systemPropertyUserServiceEClass.getESuperTypes ().add ( getUserService () );
        this.jdbcUserServiceEClass.getESuperTypes ().add ( getUserService () );
        this.valueArchiveServerEClass.getESuperTypes ().add ( getEquinoxApplication () );
        this.abstractFactoryDriverEClass.getESuperTypes ().add ( getDriver () );
        this.deviceEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        this.equinoxDriverEClass.getESuperTypes ().add ( getAbstractFactoryDriver () );
        this.equinoxDriverEClass.getESuperTypes ().add ( getEquinoxBase () );
        this.externalDriverEClass.getESuperTypes ().add ( getDriver () );
        this.driverEClass.getESuperTypes ().add ( getNamedApplication () );
        this.externalDriverPlaceholderEClass.getESuperTypes ().add ( theWorldPackage.getDriver () );
        this.applicationConfigurationEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        this.httpServiceModuleEClass.getESuperTypes ().add ( getEquinoxModule () );
        this.restExporterModuleEClass.getESuperTypes ().add ( getModule () );
        this.valueArchiveSlaveEClass.getESuperTypes ().add ( getEquinoxApplication () );
        this.webAdminConsoleEClass.getESuperTypes ().add ( getEquinoxModule () );
        this.oracleVMSettingsEClass.getESuperTypes ().add ( getJavaModule () );
        this.genericVMSettingsEClass.getESuperTypes ().add ( getJavaModule () );
        this.abstractEquinoxDriverEClass.getESuperTypes ().add ( getDriver () );
        this.abstractEquinoxDriverEClass.getESuperTypes ().add ( getEquinoxBase () );
        this.equinoxBaseEClass.getESuperTypes ().add ( getNamedApplication () );
        this.abstractCommonDriverEClass.getESuperTypes ().add ( getDriver () );
        this.eventInjectorHttpEClass.getESuperTypes ().add ( getModule () );
        this.eventInjectorSyslogEClass.getESuperTypes ().add ( getModule () );
        this.jmxSettingsEClass.getESuperTypes ().add ( getJavaModule () );
        this.configurationAdminFileBackendEClass.getESuperTypes ().add ( getEquinoxModule () );
        this.equinoxModuleEClass.getESuperTypes ().add ( getModule () );
        this.javaModuleEClass.getESuperTypes ().add ( getModule () );
        this.dsFileBackendEClass.getESuperTypes ().add ( getEquinoxModule () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( this.worldEClass, World.class, "World", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getWorld_Nodes (), getNode (), null, "nodes", null, 0, -1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_Options (), getOptions (), null, "options", null, 1, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultSecurityConfiguration (), theSecurityPackage.getConfiguration (), null, "defaultSecurityConfiguration", null, 1, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultMasterHandlerPriorities (), theWorldPackage.getMasterHandlerPriorities (), null, "defaultMasterHandlerPriorities", null, 1, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultCredentials (), theWorldPackage.getCredentials (), null, "defaultCredentials", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultMasterCustomizationProfile (), theProfilePackage.getProfile (), null, "defaultMasterCustomizationProfile", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultValueArchiveCustomizationProfile (), theProfilePackage.getProfile (), null, "defaultValueArchiveCustomizationProfile", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultDriverPassword (), theWorldPackage.getPasswordCredentials (), null, "defaultDriverPassword", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_ApplicationConfigurations (), theOsgiPackage.getIndependentConfiguration (), null, "applicationConfigurations", null, 0, -1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultDriverAccessCredentials (), theWorldPackage.getCredentials (), null, "defaultDriverAccessCredentials", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_Configurations (), getConfigurations (), null, "configurations", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getNode_HostName (), this.ecorePackage.getEString (), "hostName", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getNode_Devices (), getDevice (), getDevice_Node (), "devices", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.masterServerEClass, MasterServer.class, "MasterServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMasterServer_Authoratives (), theGlobalizePackage.getAuthorative (), null, "authoratives", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_ImportMaster (), getMasterImport (), getMasterImport_Master (), "importMaster", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_Driver (), getDriver (), null, "driver", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_ArchiveTo (), getValueArchiveServer (), null, "archiveTo", null, 0, 1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.masterImportEClass, MasterImport.class, "MasterImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMasterImport_ImportedMaster (), getMasterServer (), null, "importedMaster", null, 0, 1, MasterImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMasterImport_Id (), this.ecorePackage.getEString (), "id", null, 1, 1, MasterImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterImport_Credentials (), theWorldPackage.getCredentials (), null, "credentials", null, 0, 1, MasterImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterImport_Master (), getMasterServer (), getMasterServer_ImportMaster (), "master", null, 1, 1, MasterImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.optionsEClass, Options.class, "Options", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getOptions_BaseDaNgpPort (), this.ecorePackage.getEShort (), "baseDaNgpPort", "2100", 1, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getOptions_BaseAeNgpPort (), this.ecorePackage.getEShort (), "baseAeNgpPort", "2200", 1, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getOptions_BaseCaNgpPort (), this.ecorePackage.getEShort (), "baseCaNgpPort", "2400", 1, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getOptions_BaseHdNgpPort (), this.ecorePackage.getEShort (), "baseHdNgpPort", "2300", 1, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getOptions_MonitorPools (), theOsgiPackage.getMonitorPool (), null, "monitorPools", null, 0, -1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getOptions_EventPools (), theOsgiPackage.getEventPool (), null, "eventPools", null, 0, -1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getOptions_DefaultUserService (), getUserService (), null, "defaultUserService", null, 0, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.equinoxApplicationEClass, EquinoxApplication.class, "EquinoxApplication", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_LocalCredentials (), theWorldPackage.getCredentials (), null, "localCredentials", null, 0, 1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.commonDriverEClass, CommonDriver.class, "CommonDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCommonDriver_Password (), theWorldPackage.getPasswordCredentials (), null, "password", null, 0, 1, CommonDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCommonDriver_PortNumber (), theEcorePackage.getEInt (), "portNumber", null, 1, 1, CommonDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.externalNodeEClass, ExternalNode.class, "ExternalNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.systemNodeEClass, SystemNode.class, "SystemNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSystemNode_Deployment (), theDeploymentPackage.getDeploymentMechanism (), null, "deployment", null, 0, -1, SystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSystemNode_Drivers (), getDriver (), getDriver_Node (), "drivers", null, 0, -1, SystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSystemNode_Masters (), getMasterServer (), null, "masters", null, 0, -1, SystemNode.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSystemNode_ValueArchives (), getValueArchiveServer (), null, "valueArchives", null, 0, -1, SystemNode.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSystemNode_Applications (), this.ecorePackage.getEFeatureMapEntry (), "applications", null, 0, -1, SystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSystemNode_Services (), theWorldPackage.getService (), null, "services", null, 0, -1, SystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSystemNode_ValueSlaves (), getValueArchiveSlave (), null, "valueSlaves", null, 0, -1, SystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.systemPropertyUserServiceEClass, SystemPropertyUserService.class, "SystemPropertyUserService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSystemPropertyUserService_Users (), getUserEntry (), null, "users", null, 0, -1, SystemPropertyUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.userEntryEClass, UserEntry.class, "UserEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getUserEntry_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, UserEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getUserEntry_Password (), this.ecorePackage.getEString (), "password", null, 1, 1, UserEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getUserEntry_Roles (), this.ecorePackage.getEString (), "roles", null, 0, -1, UserEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.userServiceEClass, UserService.class, "UserService", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.jdbcUserServiceEClass, JdbcUserService.class, "JdbcUserService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getJdbcUserService_Implementation (), theOsgiPackage.getJdbcUserService (), null, "implementation", null, 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.valueArchiveServerEClass, ValueArchiveServer.class, "ValueArchiveServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.abstractFactoryDriverEClass, AbstractFactoryDriver.class, "AbstractFactoryDriver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAbstractFactoryDriver_DriverTypeId (), this.ecorePackage.getEString (), "driverTypeId", null, 1, 1, AbstractFactoryDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAbstractFactoryDriver_Devices (), getDevice (), null, "devices", null, 0, -1, AbstractFactoryDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.deviceEClass, Device.class, "Device", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDevice_Node (), getNode (), getNode_Devices (), "node", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.equinoxDriverEClass, EquinoxDriver.class, "EquinoxDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEquinoxDriver_AccessCredentials (), theWorldPackage.getCredentials (), null, "accessCredentials", null, 0, 1, EquinoxDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.externalDriverEClass, ExternalDriver.class, "ExternalDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getExternalDriver_PortNumber (), theEcorePackage.getEInt (), "portNumber", null, 1, 1, ExternalDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExternalDriver_AccessCredentials (), theWorldPackage.getCredentials (), null, "accessCredentials", null, 0, 1, ExternalDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getExternalDriver_Binding (), theEcorePackage.getEBoolean (), "binding", "true", 1, 1, ExternalDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.driverEClass, Driver.class, "Driver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDriver_Node (), getSystemNode (), getSystemNode_Drivers (), "node", null, 1, 1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDriver_ProtocolTypeTag (), this.ecorePackage.getEString (), "protocolTypeTag", "ngp", 0, 1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.externalDriverPlaceholderEClass, ExternalDriverPlaceholder.class, "ExternalDriverPlaceholder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getExternalDriverPlaceholder_Endpoints (), theWorldPackage.getEndpoint (), null, "endpoints", null, 0, -1, ExternalDriverPlaceholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.applicationConfigurationEClass, ApplicationConfiguration.class, "ApplicationConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getApplicationConfiguration_Modules (), getModule (), null, "modules", null, 0, -1, ApplicationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getApplicationConfiguration_Configurations (), theOsgiPackage.getIndependentConfiguration (), null, "configurations", null, 0, -1, ApplicationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.configurationsEClass, Configurations.class, "Configurations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getConfigurations_Configurations (), getApplicationConfiguration (), null, "configurations", null, 0, -1, Configurations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getConfigurations_Settings (), theWorldPackage.getSettings (), null, "settings", null, 0, -1, Configurations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.moduleEClass, Module.class, "Module", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.httpServiceModuleEClass, HttpServiceModule.class, "HttpServiceModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getHttpServiceModule_Port (), this.ecorePackage.getEShort (), "port", "8080", 1, 1, HttpServiceModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.restExporterModuleEClass, RestExporterModule.class, "RestExporterModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getRestExporterModule_ContextId (), this.ecorePackage.getEString (), "contextId", null, 1, 1, RestExporterModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.valueArchiveSlaveEClass, ValueArchiveSlave.class, "ValueArchiveSlave", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getValueArchiveSlave_StoragePath (), this.ecorePackage.getEString (), "storagePath", "/var/lib/eclipsescada/hds.slave", 1, 1, ValueArchiveSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getValueArchiveSlave_StorageLayout (), getSlaveStorageLayout (), "storageLayout", "MULTI", 1, 1, ValueArchiveSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.webAdminConsoleEClass, WebAdminConsole.class, "WebAdminConsole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getWebAdminConsole_HttpService (), getHttpServiceModule (), null, "httpService", null, 1, 1, WebAdminConsole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.oracleVMSettingsEClass, OracleVMSettings.class, "OracleVMSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getOracleVMSettings_InitialHeapSize (), this.ecorePackage.getEString (), "initialHeapSize", null, 0, 1, OracleVMSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getOracleVMSettings_MaximumHeapSize (), this.ecorePackage.getEString (), "maximumHeapSize", null, 0, 1, OracleVMSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.genericVMSettingsEClass, GenericVMSettings.class, "GenericVMSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getGenericVMSettings_Arguments (), this.ecorePackage.getEString (), "arguments", null, 0, -1, GenericVMSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.abstractEquinoxDriverEClass, AbstractEquinoxDriver.class, "AbstractEquinoxDriver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAbstractEquinoxDriver_AccessCredentials (), theWorldPackage.getCredentials (), null, "accessCredentials", null, 0, 1, AbstractEquinoxDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.equinoxBaseEClass, EquinoxBase.class, "EquinoxBase", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEquinoxBase_InstanceNumber (), this.ecorePackage.getEInt (), "instanceNumber", "-1", 1, 1, EquinoxBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getEquinoxBase_UserService (), getUserService (), null, "userService", null, 0, 1, EquinoxBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxBase_SecurityConfiguration (), theSecurityPackage.getConfiguration (), null, "securityConfiguration", null, 0, 1, EquinoxBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxBase_Modules (), getModule (), null, "modules", null, 0, -1, EquinoxBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxBase_Configuration (), getApplicationConfiguration (), null, "configuration", null, 0, 1, EquinoxBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxBase_Configurations (), theOsgiPackage.getIndependentConfiguration (), null, "configurations", null, 0, -1, EquinoxBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.abstractCommonDriverEClass, AbstractCommonDriver.class, "AbstractCommonDriver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAbstractCommonDriver_PortNumber (), this.ecorePackage.getEShort (), "portNumber", null, 1, 1, AbstractCommonDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAbstractCommonDriver_Password (), theWorldPackage.getPasswordCredentials (), null, "password", null, 0, 1, AbstractCommonDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.eventInjectorHttpEClass, EventInjectorHttp.class, "EventInjectorHttp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEventInjectorHttp_HttpService (), getHttpServiceModule (), null, "httpService", null, 1, 1, EventInjectorHttp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.eventInjectorSyslogEClass, EventInjectorSyslog.class, "EventInjectorSyslog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventInjectorSyslog_BindAddress (), this.ecorePackage.getEString (), "bindAddress", null, 0, 1, EventInjectorSyslog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventInjectorSyslog_Port (), this.ecorePackage.getEInt (), "port", "20514", 1, 1, EventInjectorSyslog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.jmxSettingsEClass, JMXSettings.class, "JMXSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getJMXSettings_Port (), theEcorePackage.getEIntegerObject (), "port", null, 0, 1, JMXSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJMXSettings_InstancePortOffset (), theEcorePackage.getEIntegerObject (), "instancePortOffset", null, 0, 1, JMXSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJMXSettings_LocalOnly (), theEcorePackage.getEBooleanObject (), "localOnly", null, 0, 1, JMXSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJMXSettings_Authenticated (), theEcorePackage.getEBooleanObject (), "authenticated", null, 0, 1, JMXSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJMXSettings_Ssl (), theEcorePackage.getEBooleanObject (), "ssl", null, 0, 1, JMXSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getJMXSettings_AssignNodeHostname (), theEcorePackage.getEBoolean (), "assignNodeHostname", "false", 0, 1, JMXSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.namedApplicationEClass, NamedApplication.class, "NamedApplication", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getNamedApplication_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, NamedApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.configurationAdminFileBackendEClass, ConfigurationAdminFileBackend.class, "ConfigurationAdminFileBackend", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getConfigurationAdminFileBackend_Path (), theEcorePackage.getEString (), "path", "${user.home}/.eclipse.scada/ca.#{name}", 1, 1, ConfigurationAdminFileBackend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.equinoxModuleEClass, EquinoxModule.class, "EquinoxModule", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.javaModuleEClass, JavaModule.class, "JavaModule", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.dsFileBackendEClass, DSFileBackend.class, "DSFileBackend", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDSFileBackend_Path (), theEcorePackage.getEString (), "path", "${user.home}/.eclipse.scada/ds.#{name}", 1, 1, DSFileBackend.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        // Initialize enums and add enum literals
        initEEnum ( this.slaveStorageLayoutEEnum, SlaveStorageLayout.class, "SlaveStorageLayout" ); //$NON-NLS-1$
        addEEnumLiteral ( this.slaveStorageLayoutEEnum, SlaveStorageLayout.SINGLE );
        addEEnumLiteral ( this.slaveStorageLayoutEEnum, SlaveStorageLayout.MULTI );

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations ();
        // http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup
        createExclusiveGroupAnnotations ();
    }

    /**
     * Initializes the annotations for
     * <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void createExtendedMetaDataAnnotations ()
    {
        final String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$
        addAnnotation ( getSystemNode_Masters (), source, new String[] { "group", "#applications" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getSystemNode_ValueArchives (), source, new String[] { "group", "#applications" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getSystemNode_Applications (), source, new String[] { "kind", "group" //$NON-NLS-1$ //$NON-NLS-2$
        } );
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
        addAnnotation ( this.oracleVMSettingsEClass, source, new String[] { "groupId", "oracle.vm.settings" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( this.jmxSettingsEClass, source, new String[] { "groupId", "jmx.settings" //$NON-NLS-1$ //$NON-NLS-2$
        } );
    }

} //InfrastructurePackageImpl
