/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.modbus.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.modbus.ModbusBlock;
import org.eclipse.scada.configuration.modbus.ModbusDataType;
import org.eclipse.scada.configuration.modbus.ModbusDevice;
import org.eclipse.scada.configuration.modbus.ModbusDouble;
import org.eclipse.scada.configuration.modbus.ModbusDriver;
import org.eclipse.scada.configuration.modbus.ModbusExporter;
import org.eclipse.scada.configuration.modbus.ModbusExporterDevice;
import org.eclipse.scada.configuration.modbus.ModbusExporterItem;
import org.eclipse.scada.configuration.modbus.ModbusFactory;
import org.eclipse.scada.configuration.modbus.ModbusMaster;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.modbus.ModbusSInt16;
import org.eclipse.scada.configuration.modbus.ModbusSInt32;
import org.eclipse.scada.configuration.modbus.ModbusSlave;
import org.eclipse.scada.configuration.modbus.ModbusUInt16;
import org.eclipse.scada.configuration.modbus.ModbusUInt32;
import org.eclipse.scada.configuration.modbus.ProtocolType;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.da.server.osgi.modbus.RequestType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModbusPackageImpl extends EPackageImpl implements ModbusPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusDeviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusSlaveEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusMasterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusBlockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusExporterDeviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusExporterItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusDataTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusDoubleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusSInt16EClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusSInt32EClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusUInt16EClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass modbusUInt32EClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum protocolTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType requestTypeEDataType = null;

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
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ModbusPackageImpl ()
    {
        super ( eNS_URI, ModbusFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link ModbusPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ModbusPackage init ()
    {
        if ( isInited )
            return (ModbusPackage)EPackage.Registry.INSTANCE.getEPackage ( ModbusPackage.eNS_URI );

        // Obtain or create and register package
        ModbusPackageImpl theModbusPackage = (ModbusPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ModbusPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ModbusPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        InfrastructurePackage.eINSTANCE.eClass ();
        MemoryPackage.eINSTANCE.eClass ();
        XMLTypePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theModbusPackage.createPackageContents ();

        // Initialize created meta-data
        theModbusPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theModbusPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ModbusPackage.eNS_URI, theModbusPackage );
        return theModbusPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusDevice ()
    {
        return modbusDeviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusDevice_Slaves ()
    {
        return (EReference)modbusDeviceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusDevice_TypeSystem ()
    {
        return (EReference)modbusDeviceEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusDevice_Port ()
    {
        return (EAttribute)modbusDeviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusDevice_ProtocolType ()
    {
        return (EAttribute)modbusDeviceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusDevice_InterFrameDelay ()
    {
        return (EAttribute)modbusDeviceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusDriver ()
    {
        return modbusDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusDriver_Masters ()
    {
        return (EReference)modbusDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusSlave ()
    {
        return modbusSlaveEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusSlave_Blocks ()
    {
        return (EReference)modbusSlaveEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusSlave_UnitAddress ()
    {
        return (EAttribute)modbusSlaveEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusSlave_Id ()
    {
        return (EAttribute)modbusSlaveEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusMaster ()
    {
        return modbusMasterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusMaster_Slaves ()
    {
        return (EReference)modbusMasterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusMaster_Endpoint ()
    {
        return (EReference)modbusMasterEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusMaster_Id ()
    {
        return (EAttribute)modbusMasterEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusMaster_ProtocolType ()
    {
        return (EAttribute)modbusMasterEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusMaster_InterFrameDelay ()
    {
        return (EAttribute)modbusMasterEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusBlock ()
    {
        return modbusBlockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusBlock_Type ()
    {
        return (EReference)modbusBlockEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusExporter ()
    {
        return modbusExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusExporter_Devices ()
    {
        return (EReference)modbusExporterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusExporterDevice ()
    {
        return modbusExporterDeviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusExporterDevice_Items ()
    {
        return (EReference)modbusExporterDeviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusExporterDevice_Port ()
    {
        return (EReference)modbusExporterDeviceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusExporterDevice_SlaveId ()
    {
        return (EAttribute)modbusExporterDeviceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusExporterDevice_Properties ()
    {
        return (EReference)modbusExporterDeviceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusExporterItem ()
    {
        return modbusExporterItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusExporterItem_Source ()
    {
        return (EReference)modbusExporterItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusExporterItem_Offset ()
    {
        return (EAttribute)modbusExporterItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getModbusExporterItem_Type ()
    {
        return (EReference)modbusExporterItemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusDataType ()
    {
        return modbusDataTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusDataType_Name ()
    {
        return (EAttribute)modbusDataTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusDataType_Scale ()
    {
        return (EAttribute)modbusDataTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusDouble ()
    {
        return modbusDoubleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusSInt16 ()
    {
        return modbusSInt16EClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusSInt32 ()
    {
        return modbusSInt32EClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusUInt16 ()
    {
        return modbusUInt16EClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getModbusUInt32 ()
    {
        return modbusUInt32EClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusBlock_BlockType ()
    {
        return (EAttribute)modbusBlockEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusBlock_StartAddress ()
    {
        return (EAttribute)modbusBlockEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusBlock_Count ()
    {
        return (EAttribute)modbusBlockEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusBlock_Period ()
    {
        return (EAttribute)modbusBlockEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusBlock_Timeout ()
    {
        return (EAttribute)modbusBlockEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getModbusBlock_Id ()
    {
        return (EAttribute)modbusBlockEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getProtocolType ()
    {
        return protocolTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getRequestType ()
    {
        return requestTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusFactory getModbusFactory ()
    {
        return (ModbusFactory)getEFactoryInstance ();
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
        modbusDeviceEClass = createEClass ( MODBUS_DEVICE );
        createEAttribute ( modbusDeviceEClass, MODBUS_DEVICE__PORT );
        createEAttribute ( modbusDeviceEClass, MODBUS_DEVICE__PROTOCOL_TYPE );
        createEAttribute ( modbusDeviceEClass, MODBUS_DEVICE__INTER_FRAME_DELAY );
        createEReference ( modbusDeviceEClass, MODBUS_DEVICE__SLAVES );
        createEReference ( modbusDeviceEClass, MODBUS_DEVICE__TYPE_SYSTEM );

        modbusDriverEClass = createEClass ( MODBUS_DRIVER );
        createEReference ( modbusDriverEClass, MODBUS_DRIVER__MASTERS );

        modbusSlaveEClass = createEClass ( MODBUS_SLAVE );
        createEReference ( modbusSlaveEClass, MODBUS_SLAVE__BLOCKS );
        createEAttribute ( modbusSlaveEClass, MODBUS_SLAVE__UNIT_ADDRESS );
        createEAttribute ( modbusSlaveEClass, MODBUS_SLAVE__ID );

        modbusMasterEClass = createEClass ( MODBUS_MASTER );
        createEReference ( modbusMasterEClass, MODBUS_MASTER__SLAVES );
        createEReference ( modbusMasterEClass, MODBUS_MASTER__ENDPOINT );
        createEAttribute ( modbusMasterEClass, MODBUS_MASTER__ID );
        createEAttribute ( modbusMasterEClass, MODBUS_MASTER__PROTOCOL_TYPE );
        createEAttribute ( modbusMasterEClass, MODBUS_MASTER__INTER_FRAME_DELAY );

        modbusBlockEClass = createEClass ( MODBUS_BLOCK );
        createEAttribute ( modbusBlockEClass, MODBUS_BLOCK__ID );
        createEAttribute ( modbusBlockEClass, MODBUS_BLOCK__BLOCK_TYPE );
        createEAttribute ( modbusBlockEClass, MODBUS_BLOCK__START_ADDRESS );
        createEAttribute ( modbusBlockEClass, MODBUS_BLOCK__COUNT );
        createEAttribute ( modbusBlockEClass, MODBUS_BLOCK__PERIOD );
        createEAttribute ( modbusBlockEClass, MODBUS_BLOCK__TIMEOUT );
        createEReference ( modbusBlockEClass, MODBUS_BLOCK__TYPE );

        modbusExporterEClass = createEClass ( MODBUS_EXPORTER );
        createEReference ( modbusExporterEClass, MODBUS_EXPORTER__DEVICES );

        modbusExporterDeviceEClass = createEClass ( MODBUS_EXPORTER_DEVICE );
        createEReference ( modbusExporterDeviceEClass, MODBUS_EXPORTER_DEVICE__ITEMS );
        createEReference ( modbusExporterDeviceEClass, MODBUS_EXPORTER_DEVICE__PORT );
        createEAttribute ( modbusExporterDeviceEClass, MODBUS_EXPORTER_DEVICE__SLAVE_ID );
        createEReference ( modbusExporterDeviceEClass, MODBUS_EXPORTER_DEVICE__PROPERTIES );

        modbusExporterItemEClass = createEClass ( MODBUS_EXPORTER_ITEM );
        createEReference ( modbusExporterItemEClass, MODBUS_EXPORTER_ITEM__SOURCE );
        createEAttribute ( modbusExporterItemEClass, MODBUS_EXPORTER_ITEM__OFFSET );
        createEReference ( modbusExporterItemEClass, MODBUS_EXPORTER_ITEM__TYPE );

        modbusDataTypeEClass = createEClass ( MODBUS_DATA_TYPE );
        createEAttribute ( modbusDataTypeEClass, MODBUS_DATA_TYPE__NAME );
        createEAttribute ( modbusDataTypeEClass, MODBUS_DATA_TYPE__SCALE );

        modbusDoubleEClass = createEClass ( MODBUS_DOUBLE );

        modbusSInt16EClass = createEClass ( MODBUS_SINT16 );

        modbusSInt32EClass = createEClass ( MODBUS_SINT32 );

        modbusUInt16EClass = createEClass ( MODBUS_UINT16 );

        modbusUInt32EClass = createEClass ( MODBUS_UINT32 );

        // Create enums
        protocolTypeEEnum = createEEnum ( PROTOCOL_TYPE );

        // Create data types
        requestTypeEDataType = createEDataType ( REQUEST_TYPE );
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
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage ( XMLTypePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        modbusDeviceEClass.getESuperTypes ().add ( theInfrastructurePackage.getDevice () );
        modbusDriverEClass.getESuperTypes ().add ( theWorldPackage.getDriver () );
        modbusDriverEClass.getESuperTypes ().add ( theOsgiPackage.getEquinoxApplication () );
        modbusExporterEClass.getESuperTypes ().add ( theOsgiPackage.getApplicationModule () );
        modbusDoubleEClass.getESuperTypes ().add ( this.getModbusDataType () );
        modbusSInt16EClass.getESuperTypes ().add ( this.getModbusDataType () );
        modbusSInt32EClass.getESuperTypes ().add ( this.getModbusDataType () );
        modbusUInt16EClass.getESuperTypes ().add ( this.getModbusDataType () );
        modbusUInt32EClass.getESuperTypes ().add ( this.getModbusDataType () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( modbusDeviceEClass, ModbusDevice.class, "ModbusDevice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getModbusDevice_Port (), ecorePackage.getEShort (), "port", null, 1, 1, ModbusDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusDevice_ProtocolType (), this.getProtocolType (), "protocolType", "TCP", 1, 1, ModbusDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getModbusDevice_InterFrameDelay (), ecorePackage.getEDoubleObject (), "interFrameDelay", null, 0, 1, ModbusDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusDevice_Slaves (), this.getModbusSlave (), null, "slaves", null, 0, -1, ModbusDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusDevice_TypeSystem (), theMemoryPackage.getTypeSystem (), null, "typeSystem", null, 1, 1, ModbusDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( modbusDriverEClass, ModbusDriver.class, "ModbusDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusDriver_Masters (), this.getModbusMaster (), null, "masters", null, 0, -1, ModbusDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( modbusSlaveEClass, ModbusSlave.class, "ModbusSlave", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusSlave_Blocks (), this.getModbusBlock (), null, "blocks", null, 0, -1, ModbusSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusSlave_UnitAddress (), theXMLTypePackage.getByte (), "unitAddress", null, 1, 1, ModbusSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusSlave_Id (), ecorePackage.getEString (), "id", null, 1, 1, ModbusSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( modbusMasterEClass, ModbusMaster.class, "ModbusMaster", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusMaster_Slaves (), this.getModbusSlave (), null, "slaves", null, 0, -1, ModbusMaster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusMaster_Endpoint (), theWorldPackage.getEndpoint (), null, "endpoint", null, 1, 1, ModbusMaster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusMaster_Id (), ecorePackage.getEString (), "id", null, 1, 1, ModbusMaster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusMaster_ProtocolType (), this.getProtocolType (), "protocolType", "TCP", 1, 1, ModbusMaster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getModbusMaster_InterFrameDelay (), theXMLTypePackage.getDoubleObject (), "interFrameDelay", null, 0, 1, ModbusMaster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( modbusBlockEClass, ModbusBlock.class, "ModbusBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_Id (), ecorePackage.getEString (), "id", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_BlockType (), this.getRequestType (), "blockType", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_StartAddress (), ecorePackage.getEInt (), "startAddress", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_Count (), ecorePackage.getEInt (), "count", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_Period (), ecorePackage.getELong (), "period", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_Timeout (), ecorePackage.getELong (), "timeout", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusBlock_Type (), theMemoryPackage.getTypeDefinition (), null, "type", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( modbusExporterEClass, ModbusExporter.class, "ModbusExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusExporter_Devices (), this.getModbusExporterDevice (), null, "devices", null, 0, -1, ModbusExporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( modbusExporterDeviceEClass, ModbusExporterDevice.class, "ModbusExporterDevice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusExporterDevice_Items (), this.getModbusExporterItem (), null, "items", null, 0, -1, ModbusExporterDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusExporterDevice_Port (), theWorldPackage.getEndpoint (), null, "port", null, 1, 1, ModbusExporterDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusExporterDevice_SlaveId (), ecorePackage.getEInt (), "slaveId", null, 1, 1, ModbusExporterDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusExporterDevice_Properties (), theOsgiPackage.getPropertyEntry (), null, "properties", null, 0, -1, ModbusExporterDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( modbusExporterItemEClass, ModbusExporterItem.class, "ModbusExporterItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusExporterItem_Source (), theOsgiPackage.getItem (), null, "source", null, 1, 1, ModbusExporterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusExporterItem_Offset (), ecorePackage.getEInt (), "offset", null, 1, 1, ModbusExporterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusExporterItem_Type (), this.getModbusDataType (), null, "type", null, 1, 1, ModbusExporterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( modbusDataTypeEClass, ModbusDataType.class, "ModbusDataType", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getModbusDataType_Name (), ecorePackage.getEString (), "name", null, 1, 1, ModbusDataType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusDataType_Scale (), ecorePackage.getEDoubleObject (), "scale", null, 0, 1, ModbusDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( modbusDoubleEClass, ModbusDouble.class, "ModbusDouble", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( modbusSInt16EClass, ModbusSInt16.class, "ModbusSInt16", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( modbusSInt32EClass, ModbusSInt32.class, "ModbusSInt32", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( modbusUInt16EClass, ModbusUInt16.class, "ModbusUInt16", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( modbusUInt32EClass, ModbusUInt32.class, "ModbusUInt32", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( protocolTypeEEnum, ProtocolType.class, "ProtocolType" ); //$NON-NLS-1$
        addEEnumLiteral ( protocolTypeEEnum, ProtocolType.TCP );
        addEEnumLiteral ( protocolTypeEEnum, ProtocolType.RTU );

        // Initialize data types
        initEDataType ( requestTypeEDataType, RequestType.class, "RequestType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ModbusPackageImpl
