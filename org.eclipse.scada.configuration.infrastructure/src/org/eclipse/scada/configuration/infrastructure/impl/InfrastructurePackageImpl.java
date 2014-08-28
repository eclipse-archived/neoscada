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
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.globalization.GlobalizePackage;
import org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver;
import org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration;
import org.eclipse.scada.configuration.infrastructure.CommonDriver;
import org.eclipse.scada.configuration.infrastructure.Configurations;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.EquinoxApplication;
import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.EventInjectorHttp;
import org.eclipse.scada.configuration.infrastructure.EventInjectorSyslog;
import org.eclipse.scada.configuration.infrastructure.ExternalDriver;
import org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder;
import org.eclipse.scada.configuration.infrastructure.ExternalNode;
import org.eclipse.scada.configuration.infrastructure.GenericVMSettings;
import org.eclipse.scada.configuration.infrastructure.HttpServiceModule;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.JdbcUserService;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.Module;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfrastructurePackageImpl extends EPackageImpl implements InfrastructurePackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass worldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nodeEClass = null;

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
    private EClass masterImportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass optionsEClass = null;

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
    private EClass commonDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass externalNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass systemNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass systemPropertyUserServiceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass userEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass userServiceEClass = null;

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
    private EClass valueArchiveServerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractFactoryDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass deviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass equinoxDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass externalDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass driverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass externalDriverPlaceholderEClass = null;

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
    private EClass configurationsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass moduleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass httpServiceModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass restExporterModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueArchiveSlaveEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass webAdminConsoleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass oracleVMSettingsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genericVMSettingsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractEquinoxDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass equinoxBaseEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractCommonDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventInjectorHttpEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventInjectorSyslogEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * @generated
     */
    public static InfrastructurePackage init ()
    {
        if ( isInited )
            return (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );

        // Obtain or create and register package
        InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof InfrastructurePackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new InfrastructurePackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        GlobalizePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theInfrastructurePackage.createPackageContents ();

        // Initialize created meta-data
        theInfrastructurePackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theInfrastructurePackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( InfrastructurePackage.eNS_URI, theInfrastructurePackage );
        return theInfrastructurePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getWorld ()
    {
        return worldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_Nodes ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_Options ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_DefaultSecurityConfiguration ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_DefaultMasterHandlerPriorities ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_DefaultCredentials ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_DefaultMasterCustomizationProfile ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_DefaultValueArchiveCustomizationProfile ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_DefaultDriverPassword ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_ApplicationConfigurations ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_DefaultDriverAccessCredentials ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getWorld_Configurations ()
    {
        return (EReference)worldEClass.getEStructuralFeatures ().get ( 10 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getNode ()
    {
        return nodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getNode_HostName ()
    {
        return (EAttribute)nodeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getNode_Devices ()
    {
        return (EReference)nodeEClass.getEStructuralFeatures ().get ( 1 );
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
    public EReference getMasterServer_Authoratives ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_ImportMaster ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_Driver ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterServer_ArchiveTo ()
    {
        return (EReference)masterServerEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getMasterImport ()
    {
        return masterImportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterImport_ImportedMaster ()
    {
        return (EReference)masterImportEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMasterImport_Id ()
    {
        return (EAttribute)masterImportEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterImport_Credentials ()
    {
        return (EReference)masterImportEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMasterImport_Master ()
    {
        return (EReference)masterImportEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getOptions ()
    {
        return optionsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getOptions_BaseDaNgpPort ()
    {
        return (EAttribute)optionsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getOptions_BaseAeNgpPort ()
    {
        return (EAttribute)optionsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getOptions_BaseCaNgpPort ()
    {
        return (EAttribute)optionsEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getOptions_BaseHdNgpPort ()
    {
        return (EAttribute)optionsEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getOptions_MonitorPools ()
    {
        return (EReference)optionsEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getOptions_EventPools ()
    {
        return (EReference)optionsEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getOptions_DefaultUserService ()
    {
        return (EReference)optionsEClass.getEStructuralFeatures ().get ( 6 );
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
    public EAttribute getEquinoxApplication_Name ()
    {
        return (EAttribute)equinoxApplicationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEquinoxApplication_InstanceNumber ()
    {
        return (EAttribute)equinoxApplicationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_Configurations ()
    {
        return (EReference)equinoxApplicationEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEquinoxApplication_Configuration ()
    {
        return (EReference)equinoxApplicationEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEquinoxApplication_LocalCredentials ()
    {
        return (EReference)equinoxApplicationEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEquinoxApplication_SecurityConfiguration ()
    {
        return (EReference)equinoxApplicationEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEquinoxApplication_Modules ()
    {
        return (EReference)equinoxApplicationEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getCommonDriver ()
    {
        return commonDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getCommonDriver_Password ()
    {
        return (EReference)commonDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getCommonDriver_PortNumber ()
    {
        return (EAttribute)commonDriverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getExternalNode ()
    {
        return externalNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getSystemNode ()
    {
        return systemNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSystemNode_Deployment ()
    {
        return (EReference)systemNodeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSystemNode_Drivers ()
    {
        return (EReference)systemNodeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSystemNode_Masters ()
    {
        return (EReference)systemNodeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSystemNode_ValueArchives ()
    {
        return (EReference)systemNodeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getSystemNode_Applications ()
    {
        return (EAttribute)systemNodeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSystemNode_Services ()
    {
        return (EReference)systemNodeEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSystemNode_ValueSlaves ()
    {
        return (EReference)systemNodeEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getSystemPropertyUserService ()
    {
        return systemPropertyUserServiceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getSystemPropertyUserService_Users ()
    {
        return (EReference)systemPropertyUserServiceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getUserEntry ()
    {
        return userEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getUserEntry_Name ()
    {
        return (EAttribute)userEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getUserEntry_Password ()
    {
        return (EAttribute)userEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getUserEntry_Roles ()
    {
        return (EAttribute)userEntryEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getUserService ()
    {
        return userServiceEClass;
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
    public EReference getJdbcUserService_Implementation ()
    {
        return (EReference)jdbcUserServiceEClass.getEStructuralFeatures ().get ( 0 );
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
    public EClass getAbstractFactoryDriver ()
    {
        return abstractFactoryDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractFactoryDriver_DriverTypeId ()
    {
        return (EAttribute)abstractFactoryDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAbstractFactoryDriver_Devices ()
    {
        return (EReference)abstractFactoryDriverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDevice ()
    {
        return deviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDevice_Node ()
    {
        return (EReference)deviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEquinoxDriver ()
    {
        return equinoxDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEquinoxDriver_AccessCredentials ()
    {
        return (EReference)equinoxDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getExternalDriver ()
    {
        return externalDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getExternalDriver_PortNumber ()
    {
        return (EAttribute)externalDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getExternalDriver_AccessCredentials ()
    {
        return (EReference)externalDriverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExternalDriver_Binding ()
    {
        return (EAttribute)externalDriverEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDriver ()
    {
        return driverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDriver_Name ()
    {
        return (EAttribute)driverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDriver_Node ()
    {
        return (EReference)driverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getExternalDriverPlaceholder ()
    {
        return externalDriverPlaceholderEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getExternalDriverPlaceholder_Endpoints ()
    {
        return (EReference)externalDriverPlaceholderEClass.getEStructuralFeatures ().get ( 0 );
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
    public EReference getApplicationConfiguration_Modules ()
    {
        return (EReference)applicationConfigurationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getApplicationConfiguration_Configurations ()
    {
        return (EReference)applicationConfigurationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getConfigurations ()
    {
        return configurationsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getConfigurations_Configurations ()
    {
        return (EReference)configurationsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConfigurations_Settings ()
    {
        return (EReference)configurationsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getModule ()
    {
        return moduleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getHttpServiceModule ()
    {
        return httpServiceModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getHttpServiceModule_Port ()
    {
        return (EAttribute)httpServiceModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getRestExporterModule ()
    {
        return restExporterModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getRestExporterModule_ContextId ()
    {
        return (EAttribute)restExporterModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getValueArchiveSlave ()
    {
        return valueArchiveSlaveEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getValueArchiveSlave_StoragePath ()
    {
        return (EAttribute)valueArchiveSlaveEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getValueArchiveSlave_StorageLayout ()
    {
        return (EAttribute)valueArchiveSlaveEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWebAdminConsole ()
    {
        return webAdminConsoleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getWebAdminConsole_HttpService ()
    {
        return (EReference)webAdminConsoleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOracleVMSettings ()
    {
        return oracleVMSettingsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOracleVMSettings_InitialHeapSize ()
    {
        return (EAttribute)oracleVMSettingsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOracleVMSettings_MaximumHeapSize ()
    {
        return (EAttribute)oracleVMSettingsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenericVMSettings ()
    {
        return genericVMSettingsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenericVMSettings_Arguments ()
    {
        return (EAttribute)genericVMSettingsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractEquinoxDriver ()
    {
        return abstractEquinoxDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractEquinoxDriver_AccessCredentials ()
    {
        return (EReference)abstractEquinoxDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEquinoxBase ()
    {
        return equinoxBaseEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEquinoxBase_InstanceNumber ()
    {
        return (EAttribute)equinoxBaseEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEquinoxBase_UserService ()
    {
        return (EReference)equinoxBaseEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEquinoxBase_SecurityConfiguration ()
    {
        return (EReference)equinoxBaseEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractCommonDriver ()
    {
        return abstractCommonDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractCommonDriver_PortNumber ()
    {
        return (EAttribute)abstractCommonDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractCommonDriver_Password ()
    {
        return (EReference)abstractCommonDriverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEventInjectorHttp ()
    {
        return eventInjectorHttpEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getEventInjectorHttp_HttpService ()
    {
        return (EReference)eventInjectorHttpEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEventInjectorSyslog ()
    {
        return eventInjectorSyslogEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEventInjectorSyslog_BindAddress ()
    {
        return (EAttribute)eventInjectorSyslogEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEventInjectorSyslog_Port ()
    {
        return (EAttribute)eventInjectorSyslogEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getSlaveStorageLayout ()
    {
        return slaveStorageLayoutEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
        worldEClass = createEClass ( WORLD );
        createEReference ( worldEClass, WORLD__NODES );
        createEReference ( worldEClass, WORLD__OPTIONS );
        createEReference ( worldEClass, WORLD__DEFAULT_SECURITY_CONFIGURATION );
        createEReference ( worldEClass, WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES );
        createEReference ( worldEClass, WORLD__DEFAULT_CREDENTIALS );
        createEReference ( worldEClass, WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE );
        createEReference ( worldEClass, WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE );
        createEReference ( worldEClass, WORLD__DEFAULT_DRIVER_PASSWORD );
        createEReference ( worldEClass, WORLD__APPLICATION_CONFIGURATIONS );
        createEReference ( worldEClass, WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS );
        createEReference ( worldEClass, WORLD__CONFIGURATIONS );

        nodeEClass = createEClass ( NODE );
        createEAttribute ( nodeEClass, NODE__HOST_NAME );
        createEReference ( nodeEClass, NODE__DEVICES );

        masterServerEClass = createEClass ( MASTER_SERVER );
        createEReference ( masterServerEClass, MASTER_SERVER__AUTHORATIVES );
        createEReference ( masterServerEClass, MASTER_SERVER__IMPORT_MASTER );
        createEReference ( masterServerEClass, MASTER_SERVER__DRIVER );
        createEReference ( masterServerEClass, MASTER_SERVER__ARCHIVE_TO );

        masterImportEClass = createEClass ( MASTER_IMPORT );
        createEReference ( masterImportEClass, MASTER_IMPORT__IMPORTED_MASTER );
        createEAttribute ( masterImportEClass, MASTER_IMPORT__ID );
        createEReference ( masterImportEClass, MASTER_IMPORT__CREDENTIALS );
        createEReference ( masterImportEClass, MASTER_IMPORT__MASTER );

        optionsEClass = createEClass ( OPTIONS );
        createEAttribute ( optionsEClass, OPTIONS__BASE_DA_NGP_PORT );
        createEAttribute ( optionsEClass, OPTIONS__BASE_AE_NGP_PORT );
        createEAttribute ( optionsEClass, OPTIONS__BASE_CA_NGP_PORT );
        createEAttribute ( optionsEClass, OPTIONS__BASE_HD_NGP_PORT );
        createEReference ( optionsEClass, OPTIONS__MONITOR_POOLS );
        createEReference ( optionsEClass, OPTIONS__EVENT_POOLS );
        createEReference ( optionsEClass, OPTIONS__DEFAULT_USER_SERVICE );

        equinoxApplicationEClass = createEClass ( EQUINOX_APPLICATION );
        createEAttribute ( equinoxApplicationEClass, EQUINOX_APPLICATION__NAME );
        createEAttribute ( equinoxApplicationEClass, EQUINOX_APPLICATION__INSTANCE_NUMBER );
        createEReference ( equinoxApplicationEClass, EQUINOX_APPLICATION__CONFIGURATIONS );
        createEReference ( equinoxApplicationEClass, EQUINOX_APPLICATION__CONFIGURATION );
        createEReference ( equinoxApplicationEClass, EQUINOX_APPLICATION__LOCAL_CREDENTIALS );
        createEReference ( equinoxApplicationEClass, EQUINOX_APPLICATION__SECURITY_CONFIGURATION );
        createEReference ( equinoxApplicationEClass, EQUINOX_APPLICATION__MODULES );

        commonDriverEClass = createEClass ( COMMON_DRIVER );
        createEReference ( commonDriverEClass, COMMON_DRIVER__PASSWORD );
        createEAttribute ( commonDriverEClass, COMMON_DRIVER__PORT_NUMBER );

        externalNodeEClass = createEClass ( EXTERNAL_NODE );

        systemNodeEClass = createEClass ( SYSTEM_NODE );
        createEReference ( systemNodeEClass, SYSTEM_NODE__DEPLOYMENT );
        createEReference ( systemNodeEClass, SYSTEM_NODE__DRIVERS );
        createEReference ( systemNodeEClass, SYSTEM_NODE__MASTERS );
        createEReference ( systemNodeEClass, SYSTEM_NODE__VALUE_ARCHIVES );
        createEAttribute ( systemNodeEClass, SYSTEM_NODE__APPLICATIONS );
        createEReference ( systemNodeEClass, SYSTEM_NODE__SERVICES );
        createEReference ( systemNodeEClass, SYSTEM_NODE__VALUE_SLAVES );

        systemPropertyUserServiceEClass = createEClass ( SYSTEM_PROPERTY_USER_SERVICE );
        createEReference ( systemPropertyUserServiceEClass, SYSTEM_PROPERTY_USER_SERVICE__USERS );

        userEntryEClass = createEClass ( USER_ENTRY );
        createEAttribute ( userEntryEClass, USER_ENTRY__NAME );
        createEAttribute ( userEntryEClass, USER_ENTRY__PASSWORD );
        createEAttribute ( userEntryEClass, USER_ENTRY__ROLES );

        userServiceEClass = createEClass ( USER_SERVICE );

        jdbcUserServiceEClass = createEClass ( JDBC_USER_SERVICE );
        createEReference ( jdbcUserServiceEClass, JDBC_USER_SERVICE__IMPLEMENTATION );

        valueArchiveServerEClass = createEClass ( VALUE_ARCHIVE_SERVER );

        abstractFactoryDriverEClass = createEClass ( ABSTRACT_FACTORY_DRIVER );
        createEAttribute ( abstractFactoryDriverEClass, ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID );
        createEReference ( abstractFactoryDriverEClass, ABSTRACT_FACTORY_DRIVER__DEVICES );

        deviceEClass = createEClass ( DEVICE );
        createEReference ( deviceEClass, DEVICE__NODE );

        equinoxDriverEClass = createEClass ( EQUINOX_DRIVER );
        createEReference ( equinoxDriverEClass, EQUINOX_DRIVER__ACCESS_CREDENTIALS );

        externalDriverEClass = createEClass ( EXTERNAL_DRIVER );
        createEAttribute ( externalDriverEClass, EXTERNAL_DRIVER__PORT_NUMBER );
        createEReference ( externalDriverEClass, EXTERNAL_DRIVER__ACCESS_CREDENTIALS );
        createEAttribute ( externalDriverEClass, EXTERNAL_DRIVER__BINDING );

        driverEClass = createEClass ( DRIVER );
        createEAttribute ( driverEClass, DRIVER__NAME );
        createEReference ( driverEClass, DRIVER__NODE );

        externalDriverPlaceholderEClass = createEClass ( EXTERNAL_DRIVER_PLACEHOLDER );
        createEReference ( externalDriverPlaceholderEClass, EXTERNAL_DRIVER_PLACEHOLDER__ENDPOINTS );

        applicationConfigurationEClass = createEClass ( APPLICATION_CONFIGURATION );
        createEReference ( applicationConfigurationEClass, APPLICATION_CONFIGURATION__MODULES );
        createEReference ( applicationConfigurationEClass, APPLICATION_CONFIGURATION__CONFIGURATIONS );

        configurationsEClass = createEClass ( CONFIGURATIONS );
        createEReference ( configurationsEClass, CONFIGURATIONS__CONFIGURATIONS );
        createEReference ( configurationsEClass, CONFIGURATIONS__SETTINGS );

        moduleEClass = createEClass ( MODULE );

        httpServiceModuleEClass = createEClass ( HTTP_SERVICE_MODULE );
        createEAttribute ( httpServiceModuleEClass, HTTP_SERVICE_MODULE__PORT );

        restExporterModuleEClass = createEClass ( REST_EXPORTER_MODULE );
        createEAttribute ( restExporterModuleEClass, REST_EXPORTER_MODULE__CONTEXT_ID );

        valueArchiveSlaveEClass = createEClass ( VALUE_ARCHIVE_SLAVE );
        createEAttribute ( valueArchiveSlaveEClass, VALUE_ARCHIVE_SLAVE__STORAGE_PATH );
        createEAttribute ( valueArchiveSlaveEClass, VALUE_ARCHIVE_SLAVE__STORAGE_LAYOUT );

        webAdminConsoleEClass = createEClass ( WEB_ADMIN_CONSOLE );
        createEReference ( webAdminConsoleEClass, WEB_ADMIN_CONSOLE__HTTP_SERVICE );

        oracleVMSettingsEClass = createEClass ( ORACLE_VM_SETTINGS );
        createEAttribute ( oracleVMSettingsEClass, ORACLE_VM_SETTINGS__INITIAL_HEAP_SIZE );
        createEAttribute ( oracleVMSettingsEClass, ORACLE_VM_SETTINGS__MAXIMUM_HEAP_SIZE );

        genericVMSettingsEClass = createEClass ( GENERIC_VM_SETTINGS );
        createEAttribute ( genericVMSettingsEClass, GENERIC_VM_SETTINGS__ARGUMENTS );

        abstractEquinoxDriverEClass = createEClass ( ABSTRACT_EQUINOX_DRIVER );
        createEReference ( abstractEquinoxDriverEClass, ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS );

        equinoxBaseEClass = createEClass ( EQUINOX_BASE );
        createEAttribute ( equinoxBaseEClass, EQUINOX_BASE__INSTANCE_NUMBER );
        createEReference ( equinoxBaseEClass, EQUINOX_BASE__USER_SERVICE );
        createEReference ( equinoxBaseEClass, EQUINOX_BASE__SECURITY_CONFIGURATION );

        abstractCommonDriverEClass = createEClass ( ABSTRACT_COMMON_DRIVER );
        createEAttribute ( abstractCommonDriverEClass, ABSTRACT_COMMON_DRIVER__PORT_NUMBER );
        createEReference ( abstractCommonDriverEClass, ABSTRACT_COMMON_DRIVER__PASSWORD );

        eventInjectorHttpEClass = createEClass ( EVENT_INJECTOR_HTTP );
        createEReference ( eventInjectorHttpEClass, EVENT_INJECTOR_HTTP__HTTP_SERVICE );

        eventInjectorSyslogEClass = createEClass ( EVENT_INJECTOR_SYSLOG );
        createEAttribute ( eventInjectorSyslogEClass, EVENT_INJECTOR_SYSLOG__BIND_ADDRESS );
        createEAttribute ( eventInjectorSyslogEClass, EVENT_INJECTOR_SYSLOG__PORT );

        // Create enums
        slaveStorageLayoutEEnum = createEEnum ( SLAVE_STORAGE_LAYOUT );
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
        SecurityPackage theSecurityPackage = (SecurityPackage)EPackage.Registry.INSTANCE.getEPackage ( SecurityPackage.eNS_URI );
        WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        ProfilePackage theProfilePackage = (ProfilePackage)EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI );
        OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        GlobalizePackage theGlobalizePackage = (GlobalizePackage)EPackage.Registry.INSTANCE.getEPackage ( GlobalizePackage.eNS_URI );
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage ( EcorePackage.eNS_URI );
        DeploymentPackage theDeploymentPackage = (DeploymentPackage)EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        nodeEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        masterServerEClass.getESuperTypes ().add ( this.getEquinoxApplication () );
        commonDriverEClass.getESuperTypes ().add ( this.getAbstractFactoryDriver () );
        externalNodeEClass.getESuperTypes ().add ( this.getNode () );
        systemNodeEClass.getESuperTypes ().add ( this.getNode () );
        systemPropertyUserServiceEClass.getESuperTypes ().add ( this.getUserService () );
        jdbcUserServiceEClass.getESuperTypes ().add ( this.getUserService () );
        valueArchiveServerEClass.getESuperTypes ().add ( this.getEquinoxApplication () );
        abstractFactoryDriverEClass.getESuperTypes ().add ( this.getDriver () );
        deviceEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        equinoxDriverEClass.getESuperTypes ().add ( this.getAbstractFactoryDriver () );
        equinoxDriverEClass.getESuperTypes ().add ( this.getEquinoxBase () );
        externalDriverEClass.getESuperTypes ().add ( this.getDriver () );
        externalDriverPlaceholderEClass.getESuperTypes ().add ( theWorldPackage.getDriver () );
        applicationConfigurationEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        httpServiceModuleEClass.getESuperTypes ().add ( this.getModule () );
        restExporterModuleEClass.getESuperTypes ().add ( this.getModule () );
        valueArchiveSlaveEClass.getESuperTypes ().add ( this.getEquinoxApplication () );
        webAdminConsoleEClass.getESuperTypes ().add ( this.getModule () );
        oracleVMSettingsEClass.getESuperTypes ().add ( this.getModule () );
        genericVMSettingsEClass.getESuperTypes ().add ( this.getModule () );
        abstractEquinoxDriverEClass.getESuperTypes ().add ( this.getDriver () );
        abstractEquinoxDriverEClass.getESuperTypes ().add ( this.getEquinoxBase () );
        abstractCommonDriverEClass.getESuperTypes ().add ( this.getDriver () );
        eventInjectorHttpEClass.getESuperTypes ().add ( this.getModule () );
        eventInjectorSyslogEClass.getESuperTypes ().add ( this.getModule () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( worldEClass, World.class, "World", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getWorld_Nodes (), this.getNode (), null, "nodes", null, 0, -1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_Options (), this.getOptions (), null, "options", null, 1, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultSecurityConfiguration (), theSecurityPackage.getConfiguration (), null, "defaultSecurityConfiguration", null, 1, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultMasterHandlerPriorities (), theWorldPackage.getMasterHandlerPriorities (), null, "defaultMasterHandlerPriorities", null, 1, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultCredentials (), theWorldPackage.getCredentials (), null, "defaultCredentials", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultMasterCustomizationProfile (), theProfilePackage.getProfile (), null, "defaultMasterCustomizationProfile", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultValueArchiveCustomizationProfile (), theProfilePackage.getProfile (), null, "defaultValueArchiveCustomizationProfile", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultDriverPassword (), theWorldPackage.getPasswordCredentials (), null, "defaultDriverPassword", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_ApplicationConfigurations (), theOsgiPackage.getIndependentConfiguration (), null, "applicationConfigurations", null, 0, -1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_DefaultDriverAccessCredentials (), theWorldPackage.getCredentials (), null, "defaultDriverAccessCredentials", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_Configurations (), this.getConfigurations (), null, "configurations", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getNode_HostName (), ecorePackage.getEString (), "hostName", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getNode_Devices (), this.getDevice (), this.getDevice_Node (), "devices", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( masterServerEClass, MasterServer.class, "MasterServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMasterServer_Authoratives (), theGlobalizePackage.getAuthorative (), null, "authoratives", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_ImportMaster (), this.getMasterImport (), this.getMasterImport_Master (), "importMaster", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_Driver (), this.getDriver (), null, "driver", null, 0, -1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterServer_ArchiveTo (), this.getValueArchiveServer (), null, "archiveTo", null, 0, 1, MasterServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( masterImportEClass, MasterImport.class, "MasterImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMasterImport_ImportedMaster (), this.getMasterServer (), null, "importedMaster", null, 0, 1, MasterImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMasterImport_Id (), ecorePackage.getEString (), "id", null, 1, 1, MasterImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterImport_Credentials (), theWorldPackage.getCredentials (), null, "credentials", null, 0, 1, MasterImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMasterImport_Master (), this.getMasterServer (), this.getMasterServer_ImportMaster (), "master", null, 1, 1, MasterImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( optionsEClass, Options.class, "Options", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getOptions_BaseDaNgpPort (), ecorePackage.getEShort (), "baseDaNgpPort", "2100", 1, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getOptions_BaseAeNgpPort (), ecorePackage.getEShort (), "baseAeNgpPort", "2200", 1, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getOptions_BaseCaNgpPort (), ecorePackage.getEShort (), "baseCaNgpPort", "2400", 1, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getOptions_BaseHdNgpPort (), ecorePackage.getEShort (), "baseHdNgpPort", "2300", 1, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getOptions_MonitorPools (), theOsgiPackage.getMonitorPool (), null, "monitorPools", null, 0, -1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getOptions_EventPools (), theOsgiPackage.getEventPool (), null, "eventPools", null, 0, -1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getOptions_DefaultUserService (), this.getUserService (), null, "defaultUserService", null, 0, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( equinoxApplicationEClass, EquinoxApplication.class, "EquinoxApplication", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEquinoxApplication_Name (), ecorePackage.getEString (), "name", null, 1, 1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEquinoxApplication_InstanceNumber (), ecorePackage.getEInt (), "instanceNumber", "1", 1, 1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getEquinoxApplication_Configurations (), theOsgiPackage.getIndependentConfiguration (), null, "configurations", null, 0, -1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_Configuration (), this.getApplicationConfiguration (), null, "configuration", null, 0, 1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_LocalCredentials (), theWorldPackage.getCredentials (), null, "localCredentials", null, 0, 1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_SecurityConfiguration (), theSecurityPackage.getConfiguration (), null, "securityConfiguration", null, 0, 1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxApplication_Modules (), this.getModule (), null, "modules", null, 0, -1, EquinoxApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( commonDriverEClass, CommonDriver.class, "CommonDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCommonDriver_Password (), theWorldPackage.getPasswordCredentials (), null, "password", null, 0, 1, CommonDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCommonDriver_PortNumber (), theEcorePackage.getEInt (), "portNumber", null, 1, 1, CommonDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( externalNodeEClass, ExternalNode.class, "ExternalNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( systemNodeEClass, SystemNode.class, "SystemNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSystemNode_Deployment (), theDeploymentPackage.getDeploymentMechanism (), null, "deployment", null, 0, -1, SystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSystemNode_Drivers (), this.getDriver (), this.getDriver_Node (), "drivers", null, 0, -1, SystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSystemNode_Masters (), this.getMasterServer (), null, "masters", null, 0, -1, SystemNode.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSystemNode_ValueArchives (), this.getValueArchiveServer (), null, "valueArchives", null, 0, -1, SystemNode.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSystemNode_Applications (), ecorePackage.getEFeatureMapEntry (), "applications", null, 0, -1, SystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSystemNode_Services (), theWorldPackage.getService (), null, "services", null, 0, -1, SystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSystemNode_ValueSlaves (), this.getValueArchiveSlave (), null, "valueSlaves", null, 0, -1, SystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( systemPropertyUserServiceEClass, SystemPropertyUserService.class, "SystemPropertyUserService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSystemPropertyUserService_Users (), this.getUserEntry (), null, "users", null, 0, -1, SystemPropertyUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( userEntryEClass, UserEntry.class, "UserEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getUserEntry_Name (), ecorePackage.getEString (), "name", null, 1, 1, UserEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getUserEntry_Password (), ecorePackage.getEString (), "password", null, 1, 1, UserEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getUserEntry_Roles (), ecorePackage.getEString (), "roles", null, 0, -1, UserEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( userServiceEClass, UserService.class, "UserService", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( jdbcUserServiceEClass, JdbcUserService.class, "JdbcUserService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getJdbcUserService_Implementation (), theOsgiPackage.getJdbcUserService (), null, "implementation", null, 1, 1, JdbcUserService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( valueArchiveServerEClass, ValueArchiveServer.class, "ValueArchiveServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( abstractFactoryDriverEClass, AbstractFactoryDriver.class, "AbstractFactoryDriver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAbstractFactoryDriver_DriverTypeId (), ecorePackage.getEString (), "driverTypeId", null, 1, 1, AbstractFactoryDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAbstractFactoryDriver_Devices (), this.getDevice (), null, "devices", null, 0, -1, AbstractFactoryDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( deviceEClass, Device.class, "Device", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDevice_Node (), this.getNode (), this.getNode_Devices (), "node", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( equinoxDriverEClass, EquinoxDriver.class, "EquinoxDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEquinoxDriver_AccessCredentials (), theWorldPackage.getCredentials (), null, "accessCredentials", null, 0, 1, EquinoxDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( externalDriverEClass, ExternalDriver.class, "ExternalDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getExternalDriver_PortNumber (), theEcorePackage.getEInt (), "portNumber", null, 1, 1, ExternalDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExternalDriver_AccessCredentials (), theWorldPackage.getCredentials (), null, "accessCredentials", null, 0, 1, ExternalDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getExternalDriver_Binding (), theEcorePackage.getEBoolean (), "binding", "true", 1, 1, ExternalDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( driverEClass, Driver.class, "Driver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDriver_Name (), ecorePackage.getEString (), "name", null, 1, 1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDriver_Node (), this.getSystemNode (), this.getSystemNode_Drivers (), "node", null, 1, 1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( externalDriverPlaceholderEClass, ExternalDriverPlaceholder.class, "ExternalDriverPlaceholder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getExternalDriverPlaceholder_Endpoints (), theWorldPackage.getEndpoint (), null, "endpoints", null, 0, -1, ExternalDriverPlaceholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( applicationConfigurationEClass, ApplicationConfiguration.class, "ApplicationConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getApplicationConfiguration_Modules (), this.getModule (), null, "modules", null, 0, -1, ApplicationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getApplicationConfiguration_Configurations (), theOsgiPackage.getIndependentConfiguration (), null, "configurations", null, 0, -1, ApplicationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( configurationsEClass, Configurations.class, "Configurations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getConfigurations_Configurations (), this.getApplicationConfiguration (), null, "configurations", null, 0, -1, Configurations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getConfigurations_Settings (), theWorldPackage.getSettings (), null, "settings", null, 0, -1, Configurations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( moduleEClass, Module.class, "Module", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( httpServiceModuleEClass, HttpServiceModule.class, "HttpServiceModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getHttpServiceModule_Port (), ecorePackage.getEShort (), "port", "8080", 1, 1, HttpServiceModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( restExporterModuleEClass, RestExporterModule.class, "RestExporterModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getRestExporterModule_ContextId (), ecorePackage.getEString (), "contextId", null, 1, 1, RestExporterModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( valueArchiveSlaveEClass, ValueArchiveSlave.class, "ValueArchiveSlave", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getValueArchiveSlave_StoragePath (), ecorePackage.getEString (), "storagePath", "/var/lib/eclipsescada/hds.slave", 1, 1, ValueArchiveSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getValueArchiveSlave_StorageLayout (), this.getSlaveStorageLayout (), "storageLayout", "MULTI", 1, 1, ValueArchiveSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( webAdminConsoleEClass, WebAdminConsole.class, "WebAdminConsole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getWebAdminConsole_HttpService (), this.getHttpServiceModule (), null, "httpService", null, 1, 1, WebAdminConsole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( oracleVMSettingsEClass, OracleVMSettings.class, "OracleVMSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getOracleVMSettings_InitialHeapSize (), ecorePackage.getEString (), "initialHeapSize", null, 0, 1, OracleVMSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getOracleVMSettings_MaximumHeapSize (), ecorePackage.getEString (), "maximumHeapSize", null, 0, 1, OracleVMSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( genericVMSettingsEClass, GenericVMSettings.class, "GenericVMSettings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getGenericVMSettings_Arguments (), ecorePackage.getEString (), "arguments", null, 0, -1, GenericVMSettings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( abstractEquinoxDriverEClass, AbstractEquinoxDriver.class, "AbstractEquinoxDriver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAbstractEquinoxDriver_AccessCredentials (), theWorldPackage.getCredentials (), null, "accessCredentials", null, 0, 1, AbstractEquinoxDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( equinoxBaseEClass, EquinoxBase.class, "EquinoxBase", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEquinoxBase_InstanceNumber (), ecorePackage.getEInt (), "instanceNumber", null, 1, 1, EquinoxBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxBase_UserService (), this.getUserService (), null, "userService", null, 0, 1, EquinoxBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEquinoxBase_SecurityConfiguration (), theSecurityPackage.getConfiguration (), null, "securityConfiguration", null, 0, 1, EquinoxBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( abstractCommonDriverEClass, AbstractCommonDriver.class, "AbstractCommonDriver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAbstractCommonDriver_PortNumber (), ecorePackage.getEShort (), "portNumber", null, 1, 1, AbstractCommonDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAbstractCommonDriver_Password (), theWorldPackage.getPasswordCredentials (), null, "password", null, 0, 1, AbstractCommonDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( eventInjectorHttpEClass, EventInjectorHttp.class, "EventInjectorHttp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEventInjectorHttp_HttpService (), this.getHttpServiceModule (), null, "httpService", null, 1, 1, EventInjectorHttp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( eventInjectorSyslogEClass, EventInjectorSyslog.class, "EventInjectorSyslog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventInjectorSyslog_BindAddress (), ecorePackage.getEString (), "bindAddress", null, 0, 1, EventInjectorSyslog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventInjectorSyslog_Port (), ecorePackage.getEInt (), "port", "20514", 1, 1, EventInjectorSyslog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        // Initialize enums and add enum literals
        initEEnum ( slaveStorageLayoutEEnum, SlaveStorageLayout.class, "SlaveStorageLayout" ); //$NON-NLS-1$
        addEEnumLiteral ( slaveStorageLayoutEEnum, SlaveStorageLayout.SINGLE );
        addEEnumLiteral ( slaveStorageLayoutEEnum, SlaveStorageLayout.MULTI );

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations ();
        // http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup
        createExclusiveGroupAnnotations ();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations ()
    {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$	
        addAnnotation ( getSystemNode_Masters (),
                source,
                new String[]
                {       "group", "#applications" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getSystemNode_ValueArchives (),
                source,
                new String[]
                {       "group", "#applications" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getSystemNode_Applications (),
                source,
                new String[]
                {       "kind", "group" //$NON-NLS-1$ //$NON-NLS-2$
                } );
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
        addAnnotation ( oracleVMSettingsEClass,
                source,
                new String[]
                {       "groupId", "oracle.vm.settings" //$NON-NLS-1$ //$NON-NLS-2$
                } );
    }

} //InfrastructurePackageImpl
