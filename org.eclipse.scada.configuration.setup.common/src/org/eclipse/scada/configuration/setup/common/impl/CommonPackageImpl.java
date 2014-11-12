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
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.setup.common.CommonFactory;
import org.eclipse.scada.configuration.setup.common.CommonPackage;
import org.eclipse.scada.configuration.setup.common.Parity;
import org.eclipse.scada.configuration.setup.common.PostgresSetupModule;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.setup.SetupPackage;
import org.eclipse.scada.utils.ecore.validation.ExtensibleValidationDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class CommonPackageImpl extends EPackageImpl implements CommonPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass postgresSetupModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass serialToNetworkSetupModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass serialToNetworkMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum parityEEnum = null;

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
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link CommonPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CommonPackage initGen ()
    {
        if ( isInited )
        {
            return (CommonPackage)EPackage.Registry.INSTANCE.getEPackage ( CommonPackage.eNS_URI );
        }

        // Obtain or create and register package
        final CommonPackageImpl theCommonPackage = (CommonPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new CommonPackageImpl () );

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

    public static CommonPackage init ()
    {
        final CommonPackage result = initGen ();

        EValidator.Registry.INSTANCE.put ( result, new ExtensibleValidationDescriptor () );

        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPostgresSetupModule ()
    {
        return this.postgresSetupModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getPostgresSetupModule_Database ()
    {
        return (EReference)this.postgresSetupModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPostgresSetupModule_PostgresUser ()
    {
        return (EAttribute)this.postgresSetupModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPostgresSetupModule_HostBasedAccessFile ()
    {
        return (EAttribute)this.postgresSetupModuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPostgresSetupModule_ConfigurationFile ()
    {
        return (EAttribute)this.postgresSetupModuleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSerialToNetworkSetupModule ()
    {
        return this.serialToNetworkSetupModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSerialToNetworkSetupModule_Mappings ()
    {
        return (EReference)this.serialToNetworkSetupModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSerialToNetworkMapping ()
    {
        return this.serialToNetworkMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_Device ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_TcpPort ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_Timeout ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_BaudRate ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_Parity ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_Xonxoff ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_Rtscts ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_DataBits ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_StopBits ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_ModemControl ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSerialToNetworkMapping_Break ()
    {
        return (EAttribute)this.serialToNetworkMappingEClass.getEStructuralFeatures ().get ( 10 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getParity ()
    {
        return this.parityEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
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
        this.postgresSetupModuleEClass = createEClass ( POSTGRES_SETUP_MODULE );
        createEReference ( this.postgresSetupModuleEClass, POSTGRES_SETUP_MODULE__DATABASE );
        createEAttribute ( this.postgresSetupModuleEClass, POSTGRES_SETUP_MODULE__POSTGRES_USER );
        createEAttribute ( this.postgresSetupModuleEClass, POSTGRES_SETUP_MODULE__HOST_BASED_ACCESS_FILE );
        createEAttribute ( this.postgresSetupModuleEClass, POSTGRES_SETUP_MODULE__CONFIGURATION_FILE );

        this.serialToNetworkSetupModuleEClass = createEClass ( SERIAL_TO_NETWORK_SETUP_MODULE );
        createEReference ( this.serialToNetworkSetupModuleEClass, SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS );

        this.serialToNetworkMappingEClass = createEClass ( SERIAL_TO_NETWORK_MAPPING );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__DEVICE );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__TCP_PORT );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__TIMEOUT );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__BAUD_RATE );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__PARITY );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__XONXOFF );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__RTSCTS );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__DATA_BITS );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__STOP_BITS );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__MODEM_CONTROL );
        createEAttribute ( this.serialToNetworkMappingEClass, SERIAL_TO_NETWORK_MAPPING__BREAK );

        // Create enums
        this.parityEEnum = createEEnum ( PARITY );
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
        final SetupPackage theSetupPackage = (SetupPackage)EPackage.Registry.INSTANCE.getEPackage ( SetupPackage.eNS_URI );
        final WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        final EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage ( EcorePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.postgresSetupModuleEClass.getESuperTypes ().add ( theSetupPackage.getSetupModule () );
        this.serialToNetworkSetupModuleEClass.getESuperTypes ().add ( theSetupPackage.getSetupModule () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( this.postgresSetupModuleEClass, PostgresSetupModule.class, "PostgresSetupModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getPostgresSetupModule_Database (), theWorldPackage.getPostgresDatabaseSettings (), null, "database", null, 1, 1, PostgresSetupModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPostgresSetupModule_PostgresUser (), theEcorePackage.getEString (), "postgresUser", null, 1, 1, PostgresSetupModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPostgresSetupModule_HostBasedAccessFile (), this.ecorePackage.getEString (), "hostBasedAccessFile", null, 0, 1, PostgresSetupModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPostgresSetupModule_ConfigurationFile (), this.ecorePackage.getEString (), "configurationFile", null, 0, 1, PostgresSetupModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.serialToNetworkSetupModuleEClass, SerialToNetworkSetupModule.class, "SerialToNetworkSetupModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSerialToNetworkSetupModule_Mappings (), getSerialToNetworkMapping (), null, "mappings", null, 0, -1, SerialToNetworkSetupModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.serialToNetworkMappingEClass, SerialToNetworkMapping.class, "SerialToNetworkMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSerialToNetworkMapping_Device (), this.ecorePackage.getEString (), "device", null, 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSerialToNetworkMapping_TcpPort (), this.ecorePackage.getEInt (), "tcpPort", "2000", 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getSerialToNetworkMapping_Timeout (), this.ecorePackage.getEInt (), "timeout", "30", 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getSerialToNetworkMapping_BaudRate (), this.ecorePackage.getEInt (), "baudRate", "9600", 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getSerialToNetworkMapping_Parity (), getParity (), "parity", null, 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSerialToNetworkMapping_Xonxoff (), this.ecorePackage.getEBoolean (), "xonxoff", "false", 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getSerialToNetworkMapping_Rtscts (), this.ecorePackage.getEBoolean (), "rtscts", "false", 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getSerialToNetworkMapping_DataBits (), this.ecorePackage.getEShort (), "dataBits", "8", 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getSerialToNetworkMapping_StopBits (), this.ecorePackage.getEShort (), "stopBits", "1", 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getSerialToNetworkMapping_ModemControl (), this.ecorePackage.getEBoolean (), "modemControl", null, 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSerialToNetworkMapping_Break (), this.ecorePackage.getEBoolean (), "break", null, 1, 1, SerialToNetworkMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( this.parityEEnum, Parity.class, "Parity" ); //$NON-NLS-1$
        addEEnumLiteral ( this.parityEEnum, Parity.NONE );
        addEEnumLiteral ( this.parityEEnum, Parity.EVEN );
        addEEnumLiteral ( this.parityEEnum, Parity.ODD );

        // Create resource
        createResource ( eNS_URI );
    }

} //CommonPackageImpl
