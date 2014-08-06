/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.setup.common.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.scada.configuration.setup.common.CommonFactory;
import org.eclipse.scada.configuration.setup.common.CommonPackage;
import org.eclipse.scada.configuration.setup.common.PostgresSetupModule;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.setup.SetupPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonPackageImpl extends EPackageImpl implements CommonPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass postgresSetupModuleEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CommonPackageImpl ()
    {
        super ( eNS_URI, CommonFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link CommonPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CommonPackage init ()
    {
        if ( isInited )
            return (CommonPackage)EPackage.Registry.INSTANCE.getEPackage ( CommonPackage.eNS_URI );

        // Obtain or create and register package
        CommonPackageImpl theCommonPackage = (CommonPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new CommonPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        WorldPackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theCommonPackage.createPackageContents ();

        // Initialize created meta-data
        theCommonPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theCommonPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( CommonPackage.eNS_URI, theCommonPackage );
        return theCommonPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPostgresSetupModule ()
    {
        return postgresSetupModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPostgresSetupModule_Database ()
    {
        return (EReference)postgresSetupModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPostgresSetupModule_PostgresUser ()
    {
        return (EAttribute)postgresSetupModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPostgresSetupModule_HostBasedAccessFile ()
    {
        return (EAttribute)postgresSetupModuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPostgresSetupModule_ConfigurationFile ()
    {
        return (EAttribute)postgresSetupModuleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public CommonFactory getCommonFactory ()
    {
        return (CommonFactory)getEFactoryInstance ();
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
        postgresSetupModuleEClass = createEClass ( POSTGRES_SETUP_MODULE );
        createEReference ( postgresSetupModuleEClass, POSTGRES_SETUP_MODULE__DATABASE );
        createEAttribute ( postgresSetupModuleEClass, POSTGRES_SETUP_MODULE__POSTGRES_USER );
        createEAttribute ( postgresSetupModuleEClass, POSTGRES_SETUP_MODULE__HOST_BASED_ACCESS_FILE );
        createEAttribute ( postgresSetupModuleEClass, POSTGRES_SETUP_MODULE__CONFIGURATION_FILE );
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
        SetupPackage theSetupPackage = (SetupPackage)EPackage.Registry.INSTANCE.getEPackage ( SetupPackage.eNS_URI );
        WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage ( EcorePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        postgresSetupModuleEClass.getESuperTypes ().add ( theSetupPackage.getSetupModule () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( postgresSetupModuleEClass, PostgresSetupModule.class, "PostgresSetupModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getPostgresSetupModule_Database (), theWorldPackage.getPostgresDatabaseSettings (), null, "database", null, 1, 1, PostgresSetupModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPostgresSetupModule_PostgresUser (), theEcorePackage.getEString (), "postgresUser", null, 1, 1, PostgresSetupModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPostgresSetupModule_HostBasedAccessFile (), ecorePackage.getEString (), "hostBasedAccessFile", null, 0, 1, PostgresSetupModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPostgresSetupModule_ConfigurationFile (), ecorePackage.getEString (), "configurationFile", null, 0, 1, PostgresSetupModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //CommonPackageImpl
