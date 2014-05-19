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
package org.eclipse.scada.configuration.dave.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.dave.DaveBlockDefinition;
import org.eclipse.scada.configuration.dave.DaveCommunicationProcessor;
import org.eclipse.scada.configuration.dave.DaveDevice;
import org.eclipse.scada.configuration.dave.DaveDriver;
import org.eclipse.scada.configuration.dave.DaveFactory;
import org.eclipse.scada.configuration.dave.DavePackage;
import org.eclipse.scada.configuration.dave.DaveRequestBlock;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DavePackageImpl extends EPackageImpl implements DavePackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass daveDeviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass daveDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass daveCommunicationProcessorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass daveRequestBlockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass daveBlockDefinitionEClass = null;

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
     * @see org.eclipse.scada.configuration.dave.DavePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private DavePackageImpl ()
    {
        super ( eNS_URI, DaveFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link DavePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static DavePackage init ()
    {
        if ( isInited )
            return (DavePackage)EPackage.Registry.INSTANCE.getEPackage ( DavePackage.eNS_URI );

        // Obtain or create and register package
        DavePackageImpl theDavePackage = (DavePackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof DavePackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new DavePackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        InfrastructurePackage.eINSTANCE.eClass ();
        MemoryPackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theDavePackage.createPackageContents ();

        // Initialize created meta-data
        theDavePackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theDavePackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( DavePackage.eNS_URI, theDavePackage );
        return theDavePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDaveDevice ()
    {
        return daveDeviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveDevice_Port ()
    {
        return (EAttribute)daveDeviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveDevice_Rack ()
    {
        return (EAttribute)daveDeviceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveDevice_Slot ()
    {
        return (EAttribute)daveDeviceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDaveDevice_Blocks ()
    {
        return (EReference)daveDeviceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDaveDevice_TypeSystem ()
    {
        return (EReference)daveDeviceEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveDevice_ReadTimeout ()
    {
        return (EAttribute)daveDeviceEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDaveDriver ()
    {
        return daveDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDaveDriver_Devices ()
    {
        return (EReference)daveDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDaveCommunicationProcessor ()
    {
        return daveCommunicationProcessorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDaveCommunicationProcessor_Endpoint ()
    {
        return (EReference)daveCommunicationProcessorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDaveCommunicationProcessor_Blocks ()
    {
        return (EReference)daveCommunicationProcessorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveCommunicationProcessor_Id ()
    {
        return (EAttribute)daveCommunicationProcessorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveCommunicationProcessor_Rack ()
    {
        return (EAttribute)daveCommunicationProcessorEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveCommunicationProcessor_Slot ()
    {
        return (EAttribute)daveCommunicationProcessorEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveCommunicationProcessor_ReadTimeout ()
    {
        return (EAttribute)daveCommunicationProcessorEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDaveRequestBlock ()
    {
        return daveRequestBlockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDaveRequestBlock_Type ()
    {
        return (EReference)daveRequestBlockEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveRequestBlock_Id ()
    {
        return (EAttribute)daveRequestBlockEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveRequestBlock_Name ()
    {
        return (EAttribute)daveRequestBlockEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveRequestBlock_Area ()
    {
        return (EAttribute)daveRequestBlockEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveRequestBlock_Block ()
    {
        return (EAttribute)daveRequestBlockEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveRequestBlock_Offset ()
    {
        return (EAttribute)daveRequestBlockEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveRequestBlock_Length ()
    {
        return (EAttribute)daveRequestBlockEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveRequestBlock_Period ()
    {
        return (EAttribute)daveRequestBlockEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveRequestBlock_EnableStatistics ()
    {
        return (EAttribute)daveRequestBlockEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDaveRequestBlock_Device ()
    {
        return (EReference)daveRequestBlockEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDaveBlockDefinition ()
    {
        return daveBlockDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveBlockDefinition_Block ()
    {
        return (EAttribute)daveBlockDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDaveBlockDefinition_Device ()
    {
        return (EReference)daveBlockDefinitionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveBlockDefinition_Offset ()
    {
        return (EAttribute)daveBlockDefinitionEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveBlockDefinition_Period ()
    {
        return (EAttribute)daveBlockDefinitionEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveBlockDefinition_EnableStatistics ()
    {
        return (EAttribute)daveBlockDefinitionEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDaveBlockDefinition_Type ()
    {
        return (EReference)daveBlockDefinitionEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveBlockDefinition_Area ()
    {
        return (EAttribute)daveBlockDefinitionEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDaveBlockDefinition_Name ()
    {
        return (EAttribute)daveBlockDefinitionEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DaveFactory getDaveFactory ()
    {
        return (DaveFactory)getEFactoryInstance ();
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
        daveDeviceEClass = createEClass ( DAVE_DEVICE );
        createEAttribute ( daveDeviceEClass, DAVE_DEVICE__PORT );
        createEAttribute ( daveDeviceEClass, DAVE_DEVICE__RACK );
        createEAttribute ( daveDeviceEClass, DAVE_DEVICE__SLOT );
        createEReference ( daveDeviceEClass, DAVE_DEVICE__BLOCKS );
        createEReference ( daveDeviceEClass, DAVE_DEVICE__TYPE_SYSTEM );
        createEAttribute ( daveDeviceEClass, DAVE_DEVICE__READ_TIMEOUT );

        daveDriverEClass = createEClass ( DAVE_DRIVER );
        createEReference ( daveDriverEClass, DAVE_DRIVER__DEVICES );

        daveCommunicationProcessorEClass = createEClass ( DAVE_COMMUNICATION_PROCESSOR );
        createEReference ( daveCommunicationProcessorEClass, DAVE_COMMUNICATION_PROCESSOR__ENDPOINT );
        createEReference ( daveCommunicationProcessorEClass, DAVE_COMMUNICATION_PROCESSOR__BLOCKS );
        createEAttribute ( daveCommunicationProcessorEClass, DAVE_COMMUNICATION_PROCESSOR__ID );
        createEAttribute ( daveCommunicationProcessorEClass, DAVE_COMMUNICATION_PROCESSOR__RACK );
        createEAttribute ( daveCommunicationProcessorEClass, DAVE_COMMUNICATION_PROCESSOR__SLOT );
        createEAttribute ( daveCommunicationProcessorEClass, DAVE_COMMUNICATION_PROCESSOR__READ_TIMEOUT );

        daveRequestBlockEClass = createEClass ( DAVE_REQUEST_BLOCK );
        createEReference ( daveRequestBlockEClass, DAVE_REQUEST_BLOCK__TYPE );
        createEAttribute ( daveRequestBlockEClass, DAVE_REQUEST_BLOCK__ID );
        createEAttribute ( daveRequestBlockEClass, DAVE_REQUEST_BLOCK__NAME );
        createEAttribute ( daveRequestBlockEClass, DAVE_REQUEST_BLOCK__AREA );
        createEAttribute ( daveRequestBlockEClass, DAVE_REQUEST_BLOCK__BLOCK );
        createEAttribute ( daveRequestBlockEClass, DAVE_REQUEST_BLOCK__OFFSET );
        createEAttribute ( daveRequestBlockEClass, DAVE_REQUEST_BLOCK__LENGTH );
        createEAttribute ( daveRequestBlockEClass, DAVE_REQUEST_BLOCK__PERIOD );
        createEAttribute ( daveRequestBlockEClass, DAVE_REQUEST_BLOCK__ENABLE_STATISTICS );
        createEReference ( daveRequestBlockEClass, DAVE_REQUEST_BLOCK__DEVICE );

        daveBlockDefinitionEClass = createEClass ( DAVE_BLOCK_DEFINITION );
        createEAttribute ( daveBlockDefinitionEClass, DAVE_BLOCK_DEFINITION__BLOCK );
        createEReference ( daveBlockDefinitionEClass, DAVE_BLOCK_DEFINITION__DEVICE );
        createEAttribute ( daveBlockDefinitionEClass, DAVE_BLOCK_DEFINITION__OFFSET );
        createEAttribute ( daveBlockDefinitionEClass, DAVE_BLOCK_DEFINITION__PERIOD );
        createEAttribute ( daveBlockDefinitionEClass, DAVE_BLOCK_DEFINITION__ENABLE_STATISTICS );
        createEReference ( daveBlockDefinitionEClass, DAVE_BLOCK_DEFINITION__TYPE );
        createEAttribute ( daveBlockDefinitionEClass, DAVE_BLOCK_DEFINITION__AREA );
        createEAttribute ( daveBlockDefinitionEClass, DAVE_BLOCK_DEFINITION__NAME );
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
        InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );
        MemoryPackage theMemoryPackage = (MemoryPackage)EPackage.Registry.INSTANCE.getEPackage ( MemoryPackage.eNS_URI );
        WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        daveDeviceEClass.getESuperTypes ().add ( theInfrastructurePackage.getDevice () );
        daveDriverEClass.getESuperTypes ().add ( theWorldPackage.getDriver () );
        daveDriverEClass.getESuperTypes ().add ( theOsgiPackage.getEquinoxApplication () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( daveDeviceEClass, DaveDevice.class, "DaveDevice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDaveDevice_Port (), ecorePackage.getEInt (), "port", null, 1, 1, DaveDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveDevice_Rack (), ecorePackage.getEShort (), "rack", null, 1, 1, DaveDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveDevice_Slot (), ecorePackage.getEShort (), "slot", null, 1, 1, DaveDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDaveDevice_Blocks (), this.getDaveBlockDefinition (), this.getDaveBlockDefinition_Device (), "blocks", null, 0, -1, DaveDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDaveDevice_TypeSystem (), theMemoryPackage.getTypeSystem (), null, "typeSystem", null, 1, 1, DaveDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveDevice_ReadTimeout (), ecorePackage.getEInt (), "readTimeout", "5000", 1, 1, DaveDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( daveDriverEClass, DaveDriver.class, "DaveDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDaveDriver_Devices (), this.getDaveCommunicationProcessor (), null, "devices", null, 0, -1, DaveDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( daveCommunicationProcessorEClass, DaveCommunicationProcessor.class, "DaveCommunicationProcessor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDaveCommunicationProcessor_Endpoint (), theWorldPackage.getEndpoint (), null, "endpoint", null, 1, 1, DaveCommunicationProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDaveCommunicationProcessor_Blocks (), this.getDaveRequestBlock (), this.getDaveRequestBlock_Device (), "blocks", null, 0, -1, DaveCommunicationProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveCommunicationProcessor_Id (), ecorePackage.getEString (), "id", null, 1, 1, DaveCommunicationProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveCommunicationProcessor_Rack (), ecorePackage.getEInt (), "rack", null, 1, 1, DaveCommunicationProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveCommunicationProcessor_Slot (), ecorePackage.getEInt (), "slot", null, 1, 1, DaveCommunicationProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveCommunicationProcessor_ReadTimeout (), ecorePackage.getEInt (), "readTimeout", "5000", 1, 1, DaveCommunicationProcessor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( daveRequestBlockEClass, DaveRequestBlock.class, "DaveRequestBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDaveRequestBlock_Type (), theMemoryPackage.getTypeDefinition (), null, "type", null, 1, 1, DaveRequestBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveRequestBlock_Id (), ecorePackage.getEString (), "id", null, 1, 1, DaveRequestBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveRequestBlock_Name (), ecorePackage.getEString (), "name", null, 0, 1, DaveRequestBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveRequestBlock_Area (), ecorePackage.getEInt (), "area", null, 1, 1, DaveRequestBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveRequestBlock_Block (), ecorePackage.getEInt (), "block", null, 1, 1, DaveRequestBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveRequestBlock_Offset (), ecorePackage.getEInt (), "offset", null, 1, 1, DaveRequestBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveRequestBlock_Length (), ecorePackage.getEInt (), "length", null, 1, 1, DaveRequestBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveRequestBlock_Period (), ecorePackage.getEInt (), "period", null, 1, 1, DaveRequestBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveRequestBlock_EnableStatistics (), ecorePackage.getEBoolean (), "enableStatistics", "true", 1, 1, DaveRequestBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getDaveRequestBlock_Device (), this.getDaveCommunicationProcessor (), this.getDaveCommunicationProcessor_Blocks (), "device", null, 0, 1, DaveRequestBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( daveBlockDefinitionEClass, DaveBlockDefinition.class, "DaveBlockDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDaveBlockDefinition_Block (), ecorePackage.getEInt (), "block", null, 1, 1, DaveBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDaveBlockDefinition_Device (), this.getDaveDevice (), this.getDaveDevice_Blocks (), "device", null, 0, 1, DaveBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveBlockDefinition_Offset (), ecorePackage.getEInt (), "offset", null, 1, 1, DaveBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveBlockDefinition_Period (), ecorePackage.getEInt (), "period", null, 1, 1, DaveBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveBlockDefinition_EnableStatistics (), ecorePackage.getEBoolean (), "enableStatistics", "true", 1, 1, DaveBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getDaveBlockDefinition_Type (), theMemoryPackage.getTypeDefinition (), null, "type", null, 1, 1, DaveBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveBlockDefinition_Area (), ecorePackage.getEInt (), "area", null, 1, 1, DaveBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDaveBlockDefinition_Name (), ecorePackage.getEString (), "name", null, 0, 1, DaveBlockDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //DavePackageImpl
