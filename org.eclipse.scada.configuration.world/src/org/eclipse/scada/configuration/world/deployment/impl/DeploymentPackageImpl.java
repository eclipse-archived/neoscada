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
import org.eclipse.scada.configuration.world.deployment.NodeMappingEntry;
import org.eclipse.scada.configuration.world.deployment.NodeMappings;
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
 * 
 * @generated
 */
public class DeploymentPackageImpl extends EPackageImpl implements
        DeploymentPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass deploymentMechanismEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass debianDeploymentMechanismEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass authorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass redhatDeploymentMechanismEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass deploymentInformationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass commonDeploymentMechanismEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass changeEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass nodeMappingsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass expressionNodeMappingEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass nodeMappingEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass simpleNodeMappingEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum fallbackNodeMappingModeEEnum = null;

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
     * 
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
        {
            return (DeploymentPackage)EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI );
        }

        // Obtain or create and register package
        final DeploymentPackageImpl theDeploymentPackage = (DeploymentPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof DeploymentPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new DeploymentPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        ConfigurationPackage.eINSTANCE.eClass ();
        SecurityPackage.eINSTANCE.eClass ();

        // Obtain or create and register interdependencies
        final WorldPackageImpl theWorldPackage = (WorldPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) instanceof WorldPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) : WorldPackage.eINSTANCE );
        final OsgiPackageImpl theOsgiPackage = (OsgiPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI ) instanceof OsgiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI ) : OsgiPackage.eINSTANCE );
        final ProfilePackageImpl theProfilePackage = (ProfilePackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) instanceof ProfilePackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) : ProfilePackage.eINSTANCE );

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
     * 
     * @generated
     */
    @Override
    public EClass getDeploymentMechanism ()
    {
        return this.deploymentMechanismEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDebianDeploymentMechanism ()
    {
        return this.debianDeploymentMechanismEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDebianDeploymentMechanism_AdditionalDependencies ()
    {
        return (EAttribute)this.debianDeploymentMechanismEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAuthor ()
    {
        return this.authorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAuthor_Name ()
    {
        return (EAttribute)this.authorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAuthor_Email ()
    {
        return (EAttribute)this.authorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getRedhatDeploymentMechanism ()
    {
        return this.redhatDeploymentMechanismEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDeploymentInformation ()
    {
        return this.deploymentInformationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getDeploymentInformation_Authors ()
    {
        return (EReference)this.deploymentInformationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getCommonDeploymentMechanism ()
    {
        return this.commonDeploymentMechanismEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCommonDeploymentMechanism_Changes ()
    {
        return (EReference)this.commonDeploymentMechanismEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCommonDeploymentMechanism_Maintainer ()
    {
        return (EReference)this.commonDeploymentMechanismEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getChangeEntry ()
    {
        return this.changeEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getChangeEntry_Author ()
    {
        return (EReference)this.changeEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getChangeEntry_Date ()
    {
        return (EAttribute)this.changeEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getChangeEntry_Description ()
    {
        return (EAttribute)this.changeEntryEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getChangeEntry_Version ()
    {
        return (EAttribute)this.changeEntryEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getNodeMappings ()
    {
        return this.nodeMappingsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getNodeMappings_Entries ()
    {
        return (EReference)this.nodeMappingsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getNodeMappings_FallbackMode ()
    {
        return (EAttribute)this.nodeMappingsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExpressionNodeMappingEntry ()
    {
        return this.expressionNodeMappingEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExpressionNodeMappingEntry_Pattern ()
    {
        return (EAttribute)this.expressionNodeMappingEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExpressionNodeMappingEntry_Replacement ()
    {
        return (EAttribute)this.expressionNodeMappingEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getNodeMappingEntry ()
    {
        return this.nodeMappingEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getNodeMappingEntry__MapNode__Node ()
    {
        return this.nodeMappingEntryEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSimpleNodeMappingEntry ()
    {
        return this.simpleNodeMappingEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSimpleNodeMappingEntry_FromHostName ()
    {
        return (EAttribute)this.simpleNodeMappingEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSimpleNodeMappingEntry_ToHostName ()
    {
        return (EAttribute)this.simpleNodeMappingEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getFallbackNodeMappingMode ()
    {
        return this.fallbackNodeMappingModeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
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
        this.deploymentMechanismEClass = createEClass ( DEPLOYMENT_MECHANISM );

        this.debianDeploymentMechanismEClass = createEClass ( DEBIAN_DEPLOYMENT_MECHANISM );
        createEAttribute ( this.debianDeploymentMechanismEClass, DEBIAN_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES );

        this.authorEClass = createEClass ( AUTHOR );
        createEAttribute ( this.authorEClass, AUTHOR__NAME );
        createEAttribute ( this.authorEClass, AUTHOR__EMAIL );

        this.redhatDeploymentMechanismEClass = createEClass ( REDHAT_DEPLOYMENT_MECHANISM );

        this.deploymentInformationEClass = createEClass ( DEPLOYMENT_INFORMATION );
        createEReference ( this.deploymentInformationEClass, DEPLOYMENT_INFORMATION__AUTHORS );

        this.commonDeploymentMechanismEClass = createEClass ( COMMON_DEPLOYMENT_MECHANISM );
        createEReference ( this.commonDeploymentMechanismEClass, COMMON_DEPLOYMENT_MECHANISM__CHANGES );
        createEReference ( this.commonDeploymentMechanismEClass, COMMON_DEPLOYMENT_MECHANISM__MAINTAINER );

        this.changeEntryEClass = createEClass ( CHANGE_ENTRY );
        createEReference ( this.changeEntryEClass, CHANGE_ENTRY__AUTHOR );
        createEAttribute ( this.changeEntryEClass, CHANGE_ENTRY__DATE );
        createEAttribute ( this.changeEntryEClass, CHANGE_ENTRY__DESCRIPTION );
        createEAttribute ( this.changeEntryEClass, CHANGE_ENTRY__VERSION );

        this.nodeMappingsEClass = createEClass ( NODE_MAPPINGS );
        createEReference ( this.nodeMappingsEClass, NODE_MAPPINGS__ENTRIES );
        createEAttribute ( this.nodeMappingsEClass, NODE_MAPPINGS__FALLBACK_MODE );

        this.expressionNodeMappingEntryEClass = createEClass ( EXPRESSION_NODE_MAPPING_ENTRY );
        createEAttribute ( this.expressionNodeMappingEntryEClass, EXPRESSION_NODE_MAPPING_ENTRY__PATTERN );
        createEAttribute ( this.expressionNodeMappingEntryEClass, EXPRESSION_NODE_MAPPING_ENTRY__REPLACEMENT );

        this.nodeMappingEntryEClass = createEClass ( NODE_MAPPING_ENTRY );
        createEOperation ( this.nodeMappingEntryEClass, NODE_MAPPING_ENTRY___MAP_NODE__NODE );

        this.simpleNodeMappingEntryEClass = createEClass ( SIMPLE_NODE_MAPPING_ENTRY );
        createEAttribute ( this.simpleNodeMappingEntryEClass, SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME );
        createEAttribute ( this.simpleNodeMappingEntryEClass, SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME );

        // Create enums
        this.fallbackNodeMappingModeEEnum = createEEnum ( FALLBACK_NODE_MAPPING_MODE );
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
        final WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.debianDeploymentMechanismEClass.getESuperTypes ().add ( getCommonDeploymentMechanism () );
        this.redhatDeploymentMechanismEClass.getESuperTypes ().add ( getCommonDeploymentMechanism () );
        this.commonDeploymentMechanismEClass.getESuperTypes ().add ( getDeploymentMechanism () );
        this.expressionNodeMappingEntryEClass.getESuperTypes ().add ( getNodeMappingEntry () );
        this.simpleNodeMappingEntryEClass.getESuperTypes ().add ( getNodeMappingEntry () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( this.deploymentMechanismEClass, DeploymentMechanism.class, "DeploymentMechanism", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.debianDeploymentMechanismEClass, DebianDeploymentMechanism.class, "DebianDeploymentMechanism", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDebianDeploymentMechanism_AdditionalDependencies (), this.ecorePackage.getEString (), "additionalDependencies", null, 0, -1, DebianDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.authorEClass, Author.class, "Author", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAuthor_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, Author.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAuthor_Email (), this.ecorePackage.getEString (), "email", null, 1, 1, Author.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.redhatDeploymentMechanismEClass, RedhatDeploymentMechanism.class, "RedhatDeploymentMechanism", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.deploymentInformationEClass, DeploymentInformation.class, "DeploymentInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDeploymentInformation_Authors (), getAuthor (), null, "authors", null, 0, -1, DeploymentInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.commonDeploymentMechanismEClass, CommonDeploymentMechanism.class, "CommonDeploymentMechanism", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCommonDeploymentMechanism_Changes (), getChangeEntry (), null, "changes", null, 1, -1, CommonDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCommonDeploymentMechanism_Maintainer (), getAuthor (), null, "maintainer", null, 1, 1, CommonDeploymentMechanism.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getCommonDeploymentMechanism_Maintainer ().getEKeys ().add ( getAuthor_Email () );

        initEClass ( this.changeEntryEClass, ChangeEntry.class, "ChangeEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getChangeEntry_Author (), getAuthor (), null, "author", null, 1, 1, ChangeEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getChangeEntry_Author ().getEKeys ().add ( getAuthor_Email () );
        initEAttribute ( getChangeEntry_Date (), this.ecorePackage.getEDate (), "date", null, 1, 1, ChangeEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChangeEntry_Description (), this.ecorePackage.getEString (), "description", null, 1, 1, ChangeEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChangeEntry_Version (), this.ecorePackage.getEString (), "version", null, 1, 1, ChangeEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.nodeMappingsEClass, NodeMappings.class, "NodeMappings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getNodeMappings_Entries (), getNodeMappingEntry (), null, "entries", null, 0, -1, NodeMappings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getNodeMappings_FallbackMode (), getFallbackNodeMappingMode (), "fallbackMode", "FAIL", 1, 1, NodeMappings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.expressionNodeMappingEntryEClass, ExpressionNodeMappingEntry.class, "ExpressionNodeMappingEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getExpressionNodeMappingEntry_Pattern (), theWorldPackage.getPattern (), "pattern", null, 1, 1, ExpressionNodeMappingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getExpressionNodeMappingEntry_Replacement (), this.ecorePackage.getEString (), "replacement", null, 1, 1, ExpressionNodeMappingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.nodeMappingEntryEClass, NodeMappingEntry.class, "NodeMappingEntry", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        final EOperation op = initEOperation ( getNodeMappingEntry__MapNode__Node (), this.ecorePackage.getEBoolean (), "mapNode", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, theWorldPackage.getNode (), "node", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.simpleNodeMappingEntryEClass, SimpleNodeMappingEntry.class, "SimpleNodeMappingEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSimpleNodeMappingEntry_FromHostName (), this.ecorePackage.getEString (), "fromHostName", null, 1, 1, SimpleNodeMappingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSimpleNodeMappingEntry_ToHostName (), this.ecorePackage.getEString (), "toHostName", null, 1, 1, SimpleNodeMappingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( this.fallbackNodeMappingModeEEnum, FallbackNodeMappingMode.class, "FallbackNodeMappingMode" ); //$NON-NLS-1$
        addEEnumLiteral ( this.fallbackNodeMappingModeEEnum, FallbackNodeMappingMode.FAIL );
        addEEnumLiteral ( this.fallbackNodeMappingModeEEnum, FallbackNodeMappingMode.IGNORE );
    }

} //DeploymentPackageImpl
