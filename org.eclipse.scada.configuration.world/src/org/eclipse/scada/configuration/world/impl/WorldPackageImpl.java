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
package org.eclipse.scada.configuration.world.impl;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.CommonDriver;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.ExecDriver;
import org.eclipse.scada.configuration.world.ExternalNode;
import org.eclipse.scada.configuration.world.HandlerPriorityRule;
import org.eclipse.scada.configuration.world.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.Options;
import org.eclipse.scada.configuration.world.PasswordCredentials;
import org.eclipse.scada.configuration.world.Service;
import org.eclipse.scada.configuration.world.UsernamePasswordCredentials;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.WorldFactory;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl;
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
public class WorldPackageImpl extends EPackageImpl implements WorldPackage
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
    private EClass applicationNodeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass documentableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass applicationEClass = null;

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
    private EClass endpointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass execDriverEClass = null;

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
    private EClass handlerPriorityRuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass masterHandlerPrioritiesEClass = null;

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
    private EClass usernamePasswordCredentialsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass passwordCredentialsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass credentialsEClass = null;

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
    private EClass serviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass namedDocumentableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType patternEDataType = null;

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
     * @see org.eclipse.scada.configuration.world.WorldPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private WorldPackageImpl ()
    {
        super ( eNS_URI, WorldFactory.eINSTANCE );
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
     * This method is used to initialize {@link WorldPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static WorldPackage init ()
    {
        if ( isInited )
        {
            return (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        }

        // Obtain or create and register package
        final WorldPackageImpl theWorldPackage = (WorldPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof WorldPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new WorldPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        ConfigurationPackage.eINSTANCE.eClass ();
        SecurityPackage.eINSTANCE.eClass ();

        // Obtain or create and register interdependencies
        final OsgiPackageImpl theOsgiPackage = (OsgiPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI ) instanceof OsgiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI ) : OsgiPackage.eINSTANCE );
        final ProfilePackageImpl theProfilePackage = (ProfilePackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) instanceof ProfilePackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) : ProfilePackage.eINSTANCE );
        final DeploymentPackageImpl theDeploymentPackage = (DeploymentPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI ) instanceof DeploymentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI ) : DeploymentPackage.eINSTANCE );

        // Create package meta-data objects
        theWorldPackage.createPackageContents ();
        theOsgiPackage.createPackageContents ();
        theProfilePackage.createPackageContents ();
        theDeploymentPackage.createPackageContents ();

        // Initialize created meta-data
        theWorldPackage.initializePackageContents ();
        theOsgiPackage.initializePackageContents ();
        theProfilePackage.initializePackageContents ();
        theDeploymentPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theWorldPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( WorldPackage.eNS_URI, theWorldPackage );
        return theWorldPackage;
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
    public EReference getNode_Endpoints ()
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
    public EReference getNode_Deployments ()
    {
        return (EReference)this.nodeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getApplicationNode ()
    {
        return this.applicationNodeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getApplicationNode_Applications ()
    {
        return (EReference)this.applicationNodeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getApplicationNode_Services ()
    {
        return (EReference)this.applicationNodeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDocumentable ()
    {
        return this.documentableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentable_ShortDescription ()
    {
        return (EAttribute)this.documentableEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getApplication ()
    {
        return this.applicationEClass;
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
    public EOperation getDriver__GetEndpoints ()
    {
        return this.driverEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEndpoint ()
    {
        return this.endpointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEndpoint_Node ()
    {
        return (EReference)this.endpointEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEndpoint_PortNumber ()
    {
        return (EAttribute)this.endpointEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExecDriver ()
    {
        return this.execDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getExecDriver_Root ()
    {
        return (EReference)this.execDriverEClass.getEStructuralFeatures ().get ( 0 );
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
    public EReference getCommonDriver_Endpoints ()
    {
        return (EReference)this.commonDriverEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getHandlerPriorityRule ()
    {
        return this.handlerPriorityRuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHandlerPriorityRule_Order ()
    {
        return (EAttribute)this.handlerPriorityRuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHandlerPriorityRule_FactoryId ()
    {
        return (EAttribute)this.handlerPriorityRuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHandlerPriorityRule_ConfigurationFilter ()
    {
        return (EAttribute)this.handlerPriorityRuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHandlerPriorityRule_Priority ()
    {
        return (EAttribute)this.handlerPriorityRuleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getHandlerPriorityRule_Description ()
    {
        return (EAttribute)this.handlerPriorityRuleEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMasterHandlerPriorities ()
    {
        return this.masterHandlerPrioritiesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMasterHandlerPriorities_Rules ()
    {
        return (EReference)this.masterHandlerPrioritiesEClass.getEStructuralFeatures ().get ( 0 );
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
    public EReference getOptions_MasterHandlerPriorities ()
    {
        return (EReference)this.optionsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getUsernamePasswordCredentials ()
    {
        return this.usernamePasswordCredentialsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getUsernamePasswordCredentials_Username ()
    {
        return (EAttribute)this.usernamePasswordCredentialsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getUsernamePasswordCredentials_Password ()
    {
        return (EAttribute)this.usernamePasswordCredentialsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPasswordCredentials ()
    {
        return this.passwordCredentialsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPasswordCredentials_Password ()
    {
        return (EAttribute)this.passwordCredentialsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getCredentials ()
    {
        return this.credentialsEClass;
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
    public EClass getService ()
    {
        return this.serviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getNamedDocumentable ()
    {
        return this.namedDocumentableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getNamedDocumentable_Name ()
    {
        return (EAttribute)this.namedDocumentableEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getPattern ()
    {
        return this.patternEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public WorldFactory getWorldFactory ()
    {
        return (WorldFactory)getEFactoryInstance ();
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

        this.nodeEClass = createEClass ( NODE );
        createEAttribute ( this.nodeEClass, NODE__HOST_NAME );
        createEReference ( this.nodeEClass, NODE__ENDPOINTS );
        createEReference ( this.nodeEClass, NODE__DEPLOYMENTS );

        this.applicationNodeEClass = createEClass ( APPLICATION_NODE );
        createEReference ( this.applicationNodeEClass, APPLICATION_NODE__APPLICATIONS );
        createEReference ( this.applicationNodeEClass, APPLICATION_NODE__SERVICES );

        this.documentableEClass = createEClass ( DOCUMENTABLE );
        createEAttribute ( this.documentableEClass, DOCUMENTABLE__SHORT_DESCRIPTION );

        this.applicationEClass = createEClass ( APPLICATION );

        this.driverEClass = createEClass ( DRIVER );
        createEOperation ( this.driverEClass, DRIVER___GET_ENDPOINTS );

        this.endpointEClass = createEClass ( ENDPOINT );
        createEReference ( this.endpointEClass, ENDPOINT__NODE );
        createEAttribute ( this.endpointEClass, ENDPOINT__PORT_NUMBER );

        this.execDriverEClass = createEClass ( EXEC_DRIVER );
        createEReference ( this.execDriverEClass, EXEC_DRIVER__ROOT );

        this.commonDriverEClass = createEClass ( COMMON_DRIVER );
        createEReference ( this.commonDriverEClass, COMMON_DRIVER__PASSWORD );
        createEReference ( this.commonDriverEClass, COMMON_DRIVER__ENDPOINTS );

        this.handlerPriorityRuleEClass = createEClass ( HANDLER_PRIORITY_RULE );
        createEAttribute ( this.handlerPriorityRuleEClass, HANDLER_PRIORITY_RULE__ORDER );
        createEAttribute ( this.handlerPriorityRuleEClass, HANDLER_PRIORITY_RULE__FACTORY_ID );
        createEAttribute ( this.handlerPriorityRuleEClass, HANDLER_PRIORITY_RULE__CONFIGURATION_FILTER );
        createEAttribute ( this.handlerPriorityRuleEClass, HANDLER_PRIORITY_RULE__PRIORITY );
        createEAttribute ( this.handlerPriorityRuleEClass, HANDLER_PRIORITY_RULE__DESCRIPTION );

        this.masterHandlerPrioritiesEClass = createEClass ( MASTER_HANDLER_PRIORITIES );
        createEReference ( this.masterHandlerPrioritiesEClass, MASTER_HANDLER_PRIORITIES__RULES );

        this.optionsEClass = createEClass ( OPTIONS );
        createEReference ( this.optionsEClass, OPTIONS__MASTER_HANDLER_PRIORITIES );

        this.usernamePasswordCredentialsEClass = createEClass ( USERNAME_PASSWORD_CREDENTIALS );
        createEAttribute ( this.usernamePasswordCredentialsEClass, USERNAME_PASSWORD_CREDENTIALS__USERNAME );
        createEAttribute ( this.usernamePasswordCredentialsEClass, USERNAME_PASSWORD_CREDENTIALS__PASSWORD );

        this.passwordCredentialsEClass = createEClass ( PASSWORD_CREDENTIALS );
        createEAttribute ( this.passwordCredentialsEClass, PASSWORD_CREDENTIALS__PASSWORD );

        this.credentialsEClass = createEClass ( CREDENTIALS );

        this.externalNodeEClass = createEClass ( EXTERNAL_NODE );

        this.serviceEClass = createEClass ( SERVICE );

        this.namedDocumentableEClass = createEClass ( NAMED_DOCUMENTABLE );
        createEAttribute ( this.namedDocumentableEClass, NAMED_DOCUMENTABLE__NAME );

        // Create data types
        this.patternEDataType = createEDataType ( PATTERN );
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
        final OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        final DeploymentPackage theDeploymentPackage = (DeploymentPackage)EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI );
        final ConfigurationPackage theConfigurationPackage = (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage ( ConfigurationPackage.eNS_URI );

        // Add subpackages
        getESubpackages ().add ( theOsgiPackage );
        getESubpackages ().add ( theDeploymentPackage );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.nodeEClass.getESuperTypes ().add ( getNamedDocumentable () );
        this.applicationNodeEClass.getESuperTypes ().add ( getNode () );
        this.applicationEClass.getESuperTypes ().add ( getNamedDocumentable () );
        this.driverEClass.getESuperTypes ().add ( getApplication () );
        this.endpointEClass.getESuperTypes ().add ( getNamedDocumentable () );
        this.execDriverEClass.getESuperTypes ().add ( getCommonDriver () );
        this.commonDriverEClass.getESuperTypes ().add ( getDriver () );
        this.masterHandlerPrioritiesEClass.getESuperTypes ().add ( getNamedDocumentable () );
        this.usernamePasswordCredentialsEClass.getESuperTypes ().add ( getCredentials () );
        this.passwordCredentialsEClass.getESuperTypes ().add ( getCredentials () );
        this.externalNodeEClass.getESuperTypes ().add ( getNode () );
        this.serviceEClass.getESuperTypes ().add ( getNamedDocumentable () );
        this.namedDocumentableEClass.getESuperTypes ().add ( getDocumentable () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( this.worldEClass, World.class, "World", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getWorld_Nodes (), getNode (), null, "nodes", null, 0, -1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getWorld_Options (), getOptions (), null, "options", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getNode_HostName (), this.ecorePackage.getEString (), "hostName", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getNode_Endpoints (), getEndpoint (), getEndpoint_Node (), "endpoints", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getNode_Deployments (), theDeploymentPackage.getDeploymentMechanism (), null, "deployments", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.applicationNodeEClass, ApplicationNode.class, "ApplicationNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getApplicationNode_Applications (), getApplication (), null, "applications", null, 0, -1, ApplicationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getApplicationNode_Services (), getService (), null, "services", null, 0, -1, ApplicationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.documentableEClass, Documentable.class, "Documentable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDocumentable_ShortDescription (), this.ecorePackage.getEString (), "shortDescription", null, 0, 1, Documentable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.applicationEClass, Application.class, "Application", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.driverEClass, Driver.class, "Driver", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getDriver__GetEndpoints (), getEndpoint (), "getEndpoints", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.endpointEClass, Endpoint.class, "Endpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEndpoint_Node (), getNode (), getNode_Endpoints (), "node", null, 1, 1, Endpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getEndpoint_Node ().getEKeys ().add ( getNode_HostName () );
        initEAttribute ( getEndpoint_PortNumber (), this.ecorePackage.getEShort (), "portNumber", null, 1, 1, Endpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.execDriverEClass, ExecDriver.class, "ExecDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getExecDriver_Root (), theConfigurationPackage.getRootType (), null, "root", null, 0, 1, ExecDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.commonDriverEClass, CommonDriver.class, "CommonDriver", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCommonDriver_Password (), getPasswordCredentials (), null, "password", null, 0, 1, CommonDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCommonDriver_Endpoints (), getEndpoint (), null, "endpoints", null, 0, -1, CommonDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getCommonDriver_Endpoints ().getEKeys ().add ( getEndpoint_PortNumber () );

        initEClass ( this.handlerPriorityRuleEClass, HandlerPriorityRule.class, "HandlerPriorityRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getHandlerPriorityRule_Order (), this.ecorePackage.getEInt (), "order", null, 1, 1, HandlerPriorityRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getHandlerPriorityRule_FactoryId (), this.ecorePackage.getEString (), "factoryId", null, 0, 1, HandlerPriorityRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getHandlerPriorityRule_ConfigurationFilter (), getPattern (), "configurationFilter", null, 0, 1, HandlerPriorityRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getHandlerPriorityRule_Priority (), this.ecorePackage.getEInt (), "priority", null, 1, 1, HandlerPriorityRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getHandlerPriorityRule_Description (), this.ecorePackage.getEString (), "description", null, 0, 1, HandlerPriorityRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.masterHandlerPrioritiesEClass, MasterHandlerPriorities.class, "MasterHandlerPriorities", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMasterHandlerPriorities_Rules (), getHandlerPriorityRule (), null, "rules", null, 0, -1, MasterHandlerPriorities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.optionsEClass, Options.class, "Options", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getOptions_MasterHandlerPriorities (), getMasterHandlerPriorities (), null, "masterHandlerPriorities", null, 0, 1, Options.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.usernamePasswordCredentialsEClass, UsernamePasswordCredentials.class, "UsernamePasswordCredentials", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getUsernamePasswordCredentials_Username (), this.ecorePackage.getEString (), "username", null, 1, 1, UsernamePasswordCredentials.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getUsernamePasswordCredentials_Password (), this.ecorePackage.getEString (), "password", null, 1, 1, UsernamePasswordCredentials.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.passwordCredentialsEClass, PasswordCredentials.class, "PasswordCredentials", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPasswordCredentials_Password (), this.ecorePackage.getEString (), "password", null, 1, 1, PasswordCredentials.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.credentialsEClass, Credentials.class, "Credentials", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.externalNodeEClass, ExternalNode.class, "ExternalNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.serviceEClass, Service.class, "Service", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.namedDocumentableEClass, NamedDocumentable.class, "NamedDocumentable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getNamedDocumentable_Name (), this.ecorePackage.getEString (), "name", null, 0, 1, NamedDocumentable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize data types
        initEDataType ( this.patternEDataType, Pattern.class, "Pattern", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ConfigurationPackageImpl
