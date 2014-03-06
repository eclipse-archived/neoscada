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
package org.eclipse.scada.configuration.world.deployment.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.deployment.Architecture;
import org.eclipse.scada.configuration.world.deployment.Author;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentFactory;
import org.eclipse.scada.configuration.world.deployment.DeploymentInformation;
import org.eclipse.scada.configuration.world.deployment.DeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry;
import org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode;
import org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.NodeMappingEntry;
import org.eclipse.scada.configuration.world.deployment.NodeMappings;
import org.eclipse.scada.configuration.world.deployment.P2Platform;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry;
import org.eclipse.scada.configuration.world.impl.WorldPackageImpl;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeploymentPackageImpl extends EPackageImpl implements
        DeploymentPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass deploymentMechanismEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass debianDeploymentMechanismEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass authorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass redhatDeploymentMechanismEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass deploymentInformationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass commonDeploymentMechanismEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass changeEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nodeMappingsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass expressionNodeMappingEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nodeMappingEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleNodeMappingEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass msiDeploymentMechanismEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass p2PlatformEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum fallbackNodeMappingModeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum architectureEEnum = null;

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
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private DeploymentPackageImpl ()
    {
        super ( eNS_URI, DeploymentFactory.eINSTANCE );
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
     * This method is used to initialize {@link DeploymentPackage#eINSTANCE}
     * when that field is accessed. Clients should not invoke it directly.
     * Instead, they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static DeploymentPackage init ()
    {
        if ( isInited )
            return (DeploymentPackage)EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI );

        // Obtain or create and register package
        DeploymentPackageImpl theDeploymentPackage = (DeploymentPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof DeploymentPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new DeploymentPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        ConfigurationPackage.eINSTANCE.eClass ();
        SecurityPackage.eINSTANCE.eClass ();

        // Obtain or create and register interdependencies
        WorldPackageImpl theWorldPackage = (WorldPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) instanceof WorldPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) : WorldPackage.eINSTANCE );
        OsgiPackageImpl theOsgiPackage = (OsgiPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI ) instanceof OsgiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI ) : OsgiPackage.eINSTANCE );
        ProfilePackageImpl theProfilePackage = (ProfilePackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) instanceof ProfilePackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) : ProfilePackage.eINSTANCE );

        // Create package meta-data objects
        theDeploymentPackage.createPackageContents ();
        theWorldPackage.createPackageContents ();
        theOsgiPackage.createPackageContents ();
        theProfilePackage.createPackageContents ();

        // Initialize created meta-data
        theDeploymentPackage.initializePackageContents ();
        theWorldPackage.initializePackageContents ();
        theOsgiPackage.initializePackageContents ();
        theProfilePackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theDeploymentPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( DeploymentPackage.eNS_URI, theDeploymentPackage );
        return theDeploymentPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDeploymentMechanism ()
    {
        return deploymentMechanismEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDebianDeploymentMechanism ()
    {
        return debianDeploymentMechanismEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAuthor ()
    {
        return authorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAuthor_Name ()
    {
        return (EAttribute)authorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAuthor_Email ()
    {
        return (EAttribute)authorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getRedhatDeploymentMechanism ()
    {
        return redhatDeploymentMechanismEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRedhatDeploymentMechanism_License ()
    {
        return (EAttribute)redhatDeploymentMechanismEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDeploymentInformation ()
    {
        return deploymentInformationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDeploymentInformation_Authors ()
    {
        return (EReference)deploymentInformationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getCommonDeploymentMechanism ()
    {
        return commonDeploymentMechanismEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getCommonDeploymentMechanism_Changes ()
    {
        return (EReference)commonDeploymentMechanismEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getCommonDeploymentMechanism_Maintainer ()
    {
        return (EReference)commonDeploymentMechanismEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCommonDeploymentMechanism_AdditionalDependencies ()
    {
        return (EAttribute)commonDeploymentMechanismEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getChangeEntry ()
    {
        return changeEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getChangeEntry_Author ()
    {
        return (EReference)changeEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getChangeEntry_Date ()
    {
        return (EAttribute)changeEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getChangeEntry_Description ()
    {
        return (EAttribute)changeEntryEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getChangeEntry_Version ()
    {
        return (EAttribute)changeEntryEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getNodeMappings ()
    {
        return nodeMappingsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getNodeMappings_Entries ()
    {
        return (EReference)nodeMappingsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getNodeMappings_FallbackMode ()
    {
        return (EAttribute)nodeMappingsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getExpressionNodeMappingEntry ()
    {
        return expressionNodeMappingEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getExpressionNodeMappingEntry_Pattern ()
    {
        return (EAttribute)expressionNodeMappingEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getExpressionNodeMappingEntry_Replacement ()
    {
        return (EAttribute)expressionNodeMappingEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getNodeMappingEntry ()
    {
        return nodeMappingEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getNodeMappingEntry__MapNode__Node ()
    {
        return nodeMappingEntryEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getSimpleNodeMappingEntry ()
    {
        return simpleNodeMappingEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getSimpleNodeMappingEntry_FromHostName ()
    {
        return (EAttribute)simpleNodeMappingEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getSimpleNodeMappingEntry_ToHostName ()
    {
        return (EAttribute)simpleNodeMappingEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMsiDeploymentMechanism ()
    {
        return msiDeploymentMechanismEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMsiDeploymentMechanism_Version ()
    {
        return (EAttribute)msiDeploymentMechanismEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMsiDeploymentMechanism_UpgradeCode ()
    {
        return (EAttribute)msiDeploymentMechanismEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMsiDeploymentMechanism_Manufacturer ()
    {
        return (EAttribute)msiDeploymentMechanismEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMsiDeploymentMechanism_SharedPlatform ()
    {
        return (EReference)msiDeploymentMechanismEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMsiDeploymentMechanism_LocalPlatform ()
    {
        return (EReference)msiDeploymentMechanismEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMsiDeploymentMechanism_Architecture ()
    {
        return (EAttribute)msiDeploymentMechanismEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMsiDeploymentMechanism_EnableFirewall ()
    {
        return (EAttribute)msiDeploymentMechanismEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMsiDeploymentMechanism_EnableUserInterface ()
    {
        return (EAttribute)msiDeploymentMechanismEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMsiDeploymentMechanism_LicenseFile ()
    {
        return (EAttribute)msiDeploymentMechanismEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getP2Platform ()
    {
        return p2PlatformEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getP2Platform_Repositories ()
    {
        return (EAttribute)p2PlatformEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getP2Platform_Name ()
    {
        return (EAttribute)p2PlatformEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getFallbackNodeMappingMode ()
    {
        return fallbackNodeMappingModeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getArchitecture ()
    {
        return architectureEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DeploymentFactory getDeploymentFactory ()
    {
        return (DeploymentFactory)getEFactoryInstance ();
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
        deploymentMechanismEClass = createEClass ( DEPLOYMENT_MECHANISM );

        debianDeploymentMechanismEClass = createEClass ( DEBIAN_DEPLOYMENT_MECHANISM );

        authorEClass = createEClass ( AUTHOR );
        createEAttribute ( authorEClass, AUTHOR__NAME );
        createEAttribute ( authorEClass, AUTHOR__EMAIL );

        redhatDeploymentMechanismEClass = createEClass ( REDHAT_DEPLOYMENT_MECHANISM );
        createEAttribute ( redhatDeploymentMechanismEClass, REDHAT_DEPLOYMENT_MECHANISM__LICENSE );

        deploymentInformationEClass = createEClass ( DEPLOYMENT_INFORMATION );
        createEReference ( deploymentInformationEClass, DEPLOYMENT_INFORMATION__AUTHORS );

        commonDeploymentMechanismEClass = createEClass ( COMMON_DEPLOYMENT_MECHANISM );
        createEReference ( commonDeploymentMechanismEClass, COMMON_DEPLOYMENT_MECHANISM__CHANGES );
        createEReference ( commonDeploymentMechanismEClass, COMMON_DEPLOYMENT_MECHANISM__MAINTAINER );
        createEAttribute ( commonDeploymentMechanismEClass, COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES );

        changeEntryEClass = createEClass ( CHANGE_ENTRY );
        createEReference ( changeEntryEClass, CHANGE_ENTRY__AUTHOR );
        createEAttribute ( changeEntryEClass, CHANGE_ENTRY__DATE );
        createEAttribute ( changeEntryEClass, CHANGE_ENTRY__DESCRIPTION );
        createEAttribute ( changeEntryEClass, CHANGE_ENTRY__VERSION );

        nodeMappingsEClass = createEClass ( NODE_MAPPINGS );
        createEReference ( nodeMappingsEClass, NODE_MAPPINGS__ENTRIES );
        createEAttribute ( nodeMappingsEClass, NODE_MAPPINGS__FALLBACK_MODE );

        expressionNodeMappingEntryEClass = createEClass ( EXPRESSION_NODE_MAPPING_ENTRY );
        createEAttribute ( expressionNodeMappingEntryEClass, EXPRESSION_NODE_MAPPING_ENTRY__PATTERN );
        createEAttribute ( expressionNodeMappingEntryEClass, EXPRESSION_NODE_MAPPING_ENTRY__REPLACEMENT );

        nodeMappingEntryEClass = createEClass ( NODE_MAPPING_ENTRY );
        createEOperation ( nodeMappingEntryEClass, NODE_MAPPING_ENTRY___MAP_NODE__NODE );

        simpleNodeMappingEntryEClass = createEClass ( SIMPLE_NODE_MAPPING_ENTRY );
        createEAttribute ( simpleNodeMappingEntryEClass, SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME );
        createEAttribute ( simpleNodeMappingEntryEClass, SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME );

        msiDeploymentMechanismEClass = createEClass ( MSI_DEPLOYMENT_MECHANISM );
        createEAttribute ( msiDeploymentMechanismEClass, MSI_DEPLOYMENT_MECHANISM__VERSION );
        createEAttribute ( msiDeploymentMechanismEClass, MSI_DEPLOYMENT_MECHANISM__UPGRADE_CODE );
        createEAttribute ( msiDeploymentMechanismEClass, MSI_DEPLOYMENT_MECHANISM__MANUFACTURER );
        createEReference ( msiDeploymentMechanismEClass, MSI_DEPLOYMENT_MECHANISM__SHARED_PLATFORM );
        createEReference ( msiDeploymentMechanismEClass, MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM );
        createEAttribute ( msiDeploymentMechanismEClass, MSI_DEPLOYMENT_MECHANISM__ARCHITECTURE );
        createEAttribute ( msiDeploymentMechanismEClass, MSI_DEPLOYMENT_MECHANISM__ENABLE_FIREWALL );
        createEAttribute ( msiDeploymentMechanismEClass, MSI_DEPLOYMENT_MECHANISM__ENABLE_USER_INTERFACE );
        createEAttribute ( msiDeploymentMechanismEClass, MSI_DEPLOYMENT_MECHANISM__LICENSE_FILE );

        p2PlatformEClass = createEClass ( P2_PLATFORM );
        createEAttribute ( p2PlatformEClass, P2_PLATFORM__REPOSITORIES );
        createEAttribute ( p2PlatformEClass, P2_PLATFORM__NAME );

        // Create enums
        fallbackNodeMappingModeEEnum = createEEnum ( FALLBACK_NODE_MAPPING_MODE );
        architectureEEnum = createEEnum ( ARCHITECTURE );
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
        WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        debianDeploymentMechanismEClass.getESuperTypes ().add ( this.getCommonDeploymentMechanism () );
        redhatDeploymentMechanismEClass.getESuperTypes ().add ( this.getCommonDeploymentMechanism () );
        commonDeploymentMechanismEClass.getESuperTypes ().add ( this.getDeploymentMechanism () );
        expressionNodeMappingEntryEClass.getESuperTypes ().add ( this.getNodeMappingEntry () );
        simpleNodeMappingEntryEClass.getESuperTypes ().add ( this.getNodeMappingEntry () );
        msiDeploymentMechanismEClass.getESuperTypes ().add ( this.getDeploymentMechanism () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( deploymentMechanismEClass, DeploymentMechanism.class, "DeploymentMechanism", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( debianDeploymentMechanismEClass, DebianDeploymentMechanism.class, "DebianDeploymentMechanism", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( authorEClass, Author.class, "Author", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAuthor_Name (), ecorePackage.getEString (), "name", null, 1, 1, Author.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAuthor_Email (), ecorePackage.getEString (), "email", null, 1, 1, Author.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( redhatDeploymentMechanismEClass, RedhatDeploymentMechanism.class, "RedhatDeploymentMechanism", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getRedhatDeploymentMechanism_License (), ecorePackage.getEString (), "license", "other", 1, 1, RedhatDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( deploymentInformationEClass, DeploymentInformation.class, "DeploymentInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDeploymentInformation_Authors (), this.getAuthor (), null, "authors", null, 0, -1, DeploymentInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( commonDeploymentMechanismEClass, CommonDeploymentMechanism.class, "CommonDeploymentMechanism", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCommonDeploymentMechanism_Changes (), this.getChangeEntry (), null, "changes", null, 1, -1, CommonDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCommonDeploymentMechanism_Maintainer (), this.getAuthor (), null, "maintainer", null, 1, 1, CommonDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getCommonDeploymentMechanism_Maintainer ().getEKeys ().add ( this.getAuthor_Email () );
        initEAttribute ( getCommonDeploymentMechanism_AdditionalDependencies (), ecorePackage.getEString (), "additionalDependencies", null, 0, -1, CommonDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED ); //$NON-NLS-1$

        initEClass ( changeEntryEClass, ChangeEntry.class, "ChangeEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getChangeEntry_Author (), this.getAuthor (), null, "author", null, 1, 1, ChangeEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getChangeEntry_Author ().getEKeys ().add ( this.getAuthor_Email () );
        initEAttribute ( getChangeEntry_Date (), ecorePackage.getEDate (), "date", null, 1, 1, ChangeEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChangeEntry_Description (), ecorePackage.getEString (), "description", null, 1, 1, ChangeEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChangeEntry_Version (), ecorePackage.getEString (), "version", null, 1, 1, ChangeEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( nodeMappingsEClass, NodeMappings.class, "NodeMappings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getNodeMappings_Entries (), this.getNodeMappingEntry (), null, "entries", null, 0, -1, NodeMappings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getNodeMappings_FallbackMode (), this.getFallbackNodeMappingMode (), "fallbackMode", "FAIL", 1, 1, NodeMappings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( expressionNodeMappingEntryEClass, ExpressionNodeMappingEntry.class, "ExpressionNodeMappingEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getExpressionNodeMappingEntry_Pattern (), theWorldPackage.getPattern (), "pattern", null, 1, 1, ExpressionNodeMappingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getExpressionNodeMappingEntry_Replacement (), ecorePackage.getEString (), "replacement", null, 1, 1, ExpressionNodeMappingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( nodeMappingEntryEClass, NodeMappingEntry.class, "NodeMappingEntry", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        EOperation op = initEOperation ( getNodeMappingEntry__MapNode__Node (), ecorePackage.getEBoolean (), "mapNode", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, theWorldPackage.getNode (), "node", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( simpleNodeMappingEntryEClass, SimpleNodeMappingEntry.class, "SimpleNodeMappingEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSimpleNodeMappingEntry_FromHostName (), ecorePackage.getEString (), "fromHostName", null, 1, 1, SimpleNodeMappingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSimpleNodeMappingEntry_ToHostName (), ecorePackage.getEString (), "toHostName", null, 1, 1, SimpleNodeMappingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( msiDeploymentMechanismEClass, MsiDeploymentMechanism.class, "MsiDeploymentMechanism", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMsiDeploymentMechanism_Version (), ecorePackage.getEString (), "version", null, 1, 1, MsiDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMsiDeploymentMechanism_UpgradeCode (), ecorePackage.getEString (), "upgradeCode", null, 1, 1, MsiDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMsiDeploymentMechanism_Manufacturer (), ecorePackage.getEString (), "manufacturer", "Eclipse SCADA", 1, 1, MsiDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getMsiDeploymentMechanism_SharedPlatform (), this.getP2Platform (), null, "sharedPlatform", null, 0, 1, MsiDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMsiDeploymentMechanism_LocalPlatform (), this.getP2Platform (), null, "localPlatform", null, 0, 1, MsiDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMsiDeploymentMechanism_Architecture (), this.getArchitecture (), "architecture", "i386", 1, 1, MsiDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getMsiDeploymentMechanism_EnableFirewall (), ecorePackage.getEBoolean (), "enableFirewall", "true", 1, 1, MsiDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getMsiDeploymentMechanism_EnableUserInterface (), ecorePackage.getEBoolean (), "enableUserInterface", "true", 1, 1, MsiDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getMsiDeploymentMechanism_LicenseFile (), ecorePackage.getEString (), "licenseFile", null, 0, 1, MsiDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( p2PlatformEClass, P2Platform.class, "P2Platform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getP2Platform_Repositories (), ecorePackage.getEString (), "repositories", null, 0, -1, P2Platform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getP2Platform_Name (), ecorePackage.getEString (), "name", null, 0, 1, P2Platform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( fallbackNodeMappingModeEEnum, FallbackNodeMappingMode.class, "FallbackNodeMappingMode" ); //$NON-NLS-1$
        addEEnumLiteral ( fallbackNodeMappingModeEEnum, FallbackNodeMappingMode.FAIL );
        addEEnumLiteral ( fallbackNodeMappingModeEEnum, FallbackNodeMappingMode.IGNORE );

        initEEnum ( architectureEEnum, Architecture.class, "Architecture" ); //$NON-NLS-1$
        addEEnumLiteral ( architectureEEnum, Architecture.I386 );
        addEEnumLiteral ( architectureEEnum, Architecture.AMD64 );
    }

} //DeploymentPackageImpl
