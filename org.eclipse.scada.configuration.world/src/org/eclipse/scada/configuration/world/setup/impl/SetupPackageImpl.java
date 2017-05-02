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
package org.eclipse.scada.configuration.world.setup.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.script.ScriptPackage;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl;
import org.eclipse.scada.configuration.world.impl.WorldPackageImpl;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.configuration.world.setup.SetupDefinitions;
import org.eclipse.scada.configuration.world.setup.SetupFactory;
import org.eclipse.scada.configuration.world.setup.SetupModule;
import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;
import org.eclipse.scada.configuration.world.setup.SetupPackage;
import org.eclipse.scada.configuration.world.setup.SubContainerModule;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SetupPackageImpl extends EPackageImpl implements SetupPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operatingSystemDescriptorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass setupModuleContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass setupModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass subContainerModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass setupDefinitionsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType statusEDataType = null;

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
     * @see org.eclipse.scada.configuration.world.setup.SetupPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SetupPackageImpl ()
    {
        super ( eNS_URI, SetupFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link SetupPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SetupPackage init ()
    {
        if ( isInited )
            return (SetupPackage)EPackage.Registry.INSTANCE.getEPackage ( SetupPackage.eNS_URI );

        // Obtain or create and register package
        SetupPackageImpl theSetupPackage = (SetupPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof SetupPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new SetupPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass ();
        ConfigurationPackage.eINSTANCE.eClass ();
        ScriptPackage.eINSTANCE.eClass ();
        SecurityPackage.eINSTANCE.eClass ();

        // Obtain or create and register interdependencies
        WorldPackageImpl theWorldPackage = (WorldPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) instanceof WorldPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) : WorldPackage.eINSTANCE );
        OsgiPackageImpl theOsgiPackage = (OsgiPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI ) instanceof OsgiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI ) : OsgiPackage.eINSTANCE );
        ProfilePackageImpl theProfilePackage = (ProfilePackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) instanceof ProfilePackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI ) : ProfilePackage.eINSTANCE );
        DeploymentPackageImpl theDeploymentPackage = (DeploymentPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI ) instanceof DeploymentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI ) : DeploymentPackage.eINSTANCE );

        // Create package meta-data objects
        theSetupPackage.createPackageContents ();
        theWorldPackage.createPackageContents ();
        theOsgiPackage.createPackageContents ();
        theProfilePackage.createPackageContents ();
        theDeploymentPackage.createPackageContents ();

        // Initialize created meta-data
        theSetupPackage.initializePackageContents ();
        theWorldPackage.initializePackageContents ();
        theOsgiPackage.initializePackageContents ();
        theProfilePackage.initializePackageContents ();
        theDeploymentPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theSetupPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( SetupPackage.eNS_URI, theSetupPackage );
        return theSetupPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperatingSystemDescriptor ()
    {
        return operatingSystemDescriptorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperatingSystemDescriptor_Parent ()
    {
        return (EReference)operatingSystemDescriptorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperatingSystemDescriptor_Properties ()
    {
        return (EReference)operatingSystemDescriptorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperatingSystemDescriptor_Id ()
    {
        return (EAttribute)operatingSystemDescriptorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperatingSystemDescriptor_Label ()
    {
        return (EAttribute)operatingSystemDescriptorEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSetupModuleContainer ()
    {
        return setupModuleContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSetupModuleContainer_Modules ()
    {
        return (EReference)setupModuleContainerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSetupModuleContainer_Id ()
    {
        return (EAttribute)setupModuleContainerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getSetupModuleContainer__ValidateOperatingSystem__OperatingSystemDescriptor_ValidationContext ()
    {
        return setupModuleContainerEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSetupModule ()
    {
        return setupModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getSetupModule__ValidateOperatingSystem__OperatingSystemDescriptor_ValidationContext ()
    {
        return setupModuleEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSubContainerModule ()
    {
        return subContainerModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSubContainerModule_Container ()
    {
        return (EReference)subContainerModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSetupDefinitions ()
    {
        return setupDefinitionsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSetupDefinitions_Containers ()
    {
        return (EReference)setupDefinitionsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSetupDefinitions_OperationSystemDefinitions ()
    {
        return (EReference)setupDefinitionsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getStatus ()
    {
        return statusEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SetupFactory getSetupFactory ()
    {
        return (SetupFactory)getEFactoryInstance ();
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
        operatingSystemDescriptorEClass = createEClass ( OPERATING_SYSTEM_DESCRIPTOR );
        createEReference ( operatingSystemDescriptorEClass, OPERATING_SYSTEM_DESCRIPTOR__PARENT );
        createEReference ( operatingSystemDescriptorEClass, OPERATING_SYSTEM_DESCRIPTOR__PROPERTIES );
        createEAttribute ( operatingSystemDescriptorEClass, OPERATING_SYSTEM_DESCRIPTOR__ID );
        createEAttribute ( operatingSystemDescriptorEClass, OPERATING_SYSTEM_DESCRIPTOR__LABEL );

        setupModuleContainerEClass = createEClass ( SETUP_MODULE_CONTAINER );
        createEReference ( setupModuleContainerEClass, SETUP_MODULE_CONTAINER__MODULES );
        createEAttribute ( setupModuleContainerEClass, SETUP_MODULE_CONTAINER__ID );
        createEOperation ( setupModuleContainerEClass, SETUP_MODULE_CONTAINER___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT );

        setupModuleEClass = createEClass ( SETUP_MODULE );
        createEOperation ( setupModuleEClass, SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT );

        subContainerModuleEClass = createEClass ( SUB_CONTAINER_MODULE );
        createEReference ( subContainerModuleEClass, SUB_CONTAINER_MODULE__CONTAINER );

        setupDefinitionsEClass = createEClass ( SETUP_DEFINITIONS );
        createEReference ( setupDefinitionsEClass, SETUP_DEFINITIONS__CONTAINERS );
        createEReference ( setupDefinitionsEClass, SETUP_DEFINITIONS__OPERATION_SYSTEM_DEFINITIONS );

        // Create data types
        statusEDataType = createEDataType ( STATUS );
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
        subContainerModuleEClass.getESuperTypes ().add ( this.getSetupModule () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( operatingSystemDescriptorEClass, OperatingSystemDescriptor.class, "OperatingSystemDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getOperatingSystemDescriptor_Parent (), this.getOperatingSystemDescriptor (), null, "parent", null, 0, 1, OperatingSystemDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getOperatingSystemDescriptor_Properties (), theWorldPackage.getPropertyEntry (), null, "properties", null, 0, -1, OperatingSystemDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getOperatingSystemDescriptor_Id (), ecorePackage.getEString (), "id", null, 1, 1, OperatingSystemDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getOperatingSystemDescriptor_Label (), ecorePackage.getEString (), "label", null, 0, 1, OperatingSystemDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( setupModuleContainerEClass, SetupModuleContainer.class, "SetupModuleContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSetupModuleContainer_Modules (), this.getSetupModule (), null, "modules", null, 0, -1, SetupModuleContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSetupModuleContainer_Id (), ecorePackage.getEString (), "id", null, 1, 1, SetupModuleContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        EOperation op = initEOperation ( getSetupModuleContainer__ValidateOperatingSystem__OperatingSystemDescriptor_ValidationContext (), null, "validateOperatingSystem", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getOperatingSystemDescriptor (), "descriptor", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, theWorldPackage.getValidationContext (), "context", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( setupModuleEClass, SetupModule.class, "SetupModule", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        op = initEOperation ( getSetupModule__ValidateOperatingSystem__OperatingSystemDescriptor_ValidationContext (), null, "validateOperatingSystem", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getOperatingSystemDescriptor (), "descriptor", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, theWorldPackage.getValidationContext (), "context", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( subContainerModuleEClass, SubContainerModule.class, "SubContainerModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSubContainerModule_Container (), this.getSetupModuleContainer (), null, "container", null, 0, 1, SubContainerModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( setupDefinitionsEClass, SetupDefinitions.class, "SetupDefinitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSetupDefinitions_Containers (), this.getSetupModuleContainer (), null, "containers", null, 0, -1, SetupDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSetupDefinitions_OperationSystemDefinitions (), this.getOperatingSystemDescriptor (), null, "operationSystemDefinitions", null, 0, -1, SetupDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize data types
        initEDataType ( statusEDataType, IStatus.class, "Status", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
    }

} //SetupPackageImpl
