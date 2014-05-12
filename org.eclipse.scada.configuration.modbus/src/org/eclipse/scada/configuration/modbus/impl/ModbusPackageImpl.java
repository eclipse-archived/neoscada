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
package org.eclipse.scada.configuration.modbus.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.modbus.ByteOrder;
import org.eclipse.scada.configuration.modbus.ModbusBlock;
import org.eclipse.scada.configuration.modbus.ModbusDataType;
import org.eclipse.scada.configuration.modbus.ModbusDevice;
import org.eclipse.scada.configuration.modbus.ModbusDouble;
import org.eclipse.scada.configuration.modbus.ModbusDriver;
import org.eclipse.scada.configuration.modbus.ModbusExporter;
import org.eclipse.scada.configuration.modbus.ModbusExporterDevice;
import org.eclipse.scada.configuration.modbus.ModbusExporterInterceptor;
import org.eclipse.scada.configuration.modbus.ModbusExporterItem;
import org.eclipse.scada.configuration.modbus.ModbusExporterModule;
import org.eclipse.scada.configuration.modbus.ModbusFactory;
import org.eclipse.scada.configuration.modbus.ModbusMaster;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.modbus.ModbusSInt16;
import org.eclipse.scada.configuration.modbus.ModbusSInt32;
import org.eclipse.scada.configuration.modbus.ModbusSlave;
import org.eclipse.scada.configuration.modbus.ModbusUInt16;
import org.eclipse.scada.configuration.modbus.ModbusUInt32;
import org.eclipse.scada.configuration.modbus.ProtocolType;
import org.eclipse.scada.configuration.script.ScriptPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.da.server.osgi.modbus.RequestType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ModbusPackageImpl extends EPackageImpl implements ModbusPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusDeviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusSlaveEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusMasterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusBlockEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusExporterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusExporterDeviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusExporterItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusDataTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusDoubleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusSInt16EClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusSInt32EClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusUInt16EClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusUInt32EClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusExporterModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass modbusExporterInterceptorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum protocolTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum byteOrderEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType requestTypeEDataType = null;

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
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link ModbusPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ModbusPackage init ()
    {
        if ( isInited )
        {
            return (ModbusPackage)EPackage.Registry.INSTANCE.getEPackage ( ModbusPackage.eNS_URI );
        }

        // Obtain or create and register package
        final ModbusPackageImpl theModbusPackage = (ModbusPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ModbusPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ModbusPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        ComponentPackage.eINSTANCE.eClass ();
        MemoryPackage.eINSTANCE.eClass ();
        ScriptPackage.eINSTANCE.eClass ();
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
     * 
     * @generated
     */
    @Override
    public EClass getModbusDevice ()
    {
        return this.modbusDeviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusDevice_Slaves ()
    {
        return (EReference)this.modbusDeviceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusDevice_TypeSystem ()
    {
        return (EReference)this.modbusDeviceEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusDevice_Port ()
    {
        return (EAttribute)this.modbusDeviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusDevice_ProtocolType ()
    {
        return (EAttribute)this.modbusDeviceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusDevice_InterFrameDelay ()
    {
        return (EAttribute)this.modbusDeviceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusDriver ()
    {
        return this.modbusDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusDriver_Masters ()
    {
        return (EReference)this.modbusDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusSlave ()
    {
        return this.modbusSlaveEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusSlave_Blocks ()
    {
        return (EReference)this.modbusSlaveEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusSlave_UnitAddress ()
    {
        return (EAttribute)this.modbusSlaveEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusSlave_Id ()
    {
        return (EAttribute)this.modbusSlaveEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusSlave_DataOrder ()
    {
        return (EAttribute)this.modbusSlaveEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusMaster ()
    {
        return this.modbusMasterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusMaster_Slaves ()
    {
        return (EReference)this.modbusMasterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusMaster_Endpoint ()
    {
        return (EReference)this.modbusMasterEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusMaster_Id ()
    {
        return (EAttribute)this.modbusMasterEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusMaster_ProtocolType ()
    {
        return (EAttribute)this.modbusMasterEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusMaster_InterFrameDelay ()
    {
        return (EAttribute)this.modbusMasterEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusBlock ()
    {
        return this.modbusBlockEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusBlock_Type ()
    {
        return (EReference)this.modbusBlockEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusExporter ()
    {
        return this.modbusExporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusExporter_Devices ()
    {
        return (EReference)this.modbusExporterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusExporterDevice ()
    {
        return this.modbusExporterDeviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusExporterDevice_Items ()
    {
        return (EReference)this.modbusExporterDeviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusExporterDevice_Port ()
    {
        return (EReference)this.modbusExporterDeviceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusExporterDevice_SlaveId ()
    {
        return (EAttribute)this.modbusExporterDeviceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusExporterDevice_Properties ()
    {
        return (EReference)this.modbusExporterDeviceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusExporterDevice_DataOrder ()
    {
        return (EAttribute)this.modbusExporterDeviceEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusExporterItem ()
    {
        return this.modbusExporterItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusExporterItem_Source ()
    {
        return (EReference)this.modbusExporterItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusExporterItem_Offset ()
    {
        return (EAttribute)this.modbusExporterItemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusExporterItem_Type ()
    {
        return (EReference)this.modbusExporterItemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusDataType ()
    {
        return this.modbusDataTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusDataType_Name ()
    {
        return (EAttribute)this.modbusDataTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusDataType_Scale ()
    {
        return (EAttribute)this.modbusDataTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusDouble ()
    {
        return this.modbusDoubleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusSInt16 ()
    {
        return this.modbusSInt16EClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusSInt32 ()
    {
        return this.modbusSInt32EClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusUInt16 ()
    {
        return this.modbusUInt16EClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusUInt32 ()
    {
        return this.modbusUInt32EClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusExporterModule ()
    {
        return this.modbusExporterModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusExporterModule_DataOrder ()
    {
        return (EAttribute)this.modbusExporterModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusExporterModule_Properties ()
    {
        return (EReference)this.modbusExporterModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getModbusExporterInterceptor ()
    {
        return this.modbusExporterInterceptorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusExporterInterceptor_Settings ()
    {
        return (EReference)this.modbusExporterInterceptorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getModbusExporterInterceptor_Script ()
    {
        return (EReference)this.modbusExporterInterceptorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusBlock_BlockType ()
    {
        return (EAttribute)this.modbusBlockEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusBlock_StartAddress ()
    {
        return (EAttribute)this.modbusBlockEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusBlock_Count ()
    {
        return (EAttribute)this.modbusBlockEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusBlock_Period ()
    {
        return (EAttribute)this.modbusBlockEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusBlock_Timeout ()
    {
        return (EAttribute)this.modbusBlockEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getModbusBlock_Id ()
    {
        return (EAttribute)this.modbusBlockEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getProtocolType ()
    {
        return this.protocolTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getByteOrder ()
    {
        return this.byteOrderEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getRequestType ()
    {
        return this.requestTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ModbusFactory getModbusFactory ()
    {
        return (ModbusFactory)getEFactoryInstance ();
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
        this.modbusDeviceEClass = createEClass ( MODBUS_DEVICE );
        createEAttribute ( this.modbusDeviceEClass, MODBUS_DEVICE__PORT );
        createEAttribute ( this.modbusDeviceEClass, MODBUS_DEVICE__PROTOCOL_TYPE );
        createEAttribute ( this.modbusDeviceEClass, MODBUS_DEVICE__INTER_FRAME_DELAY );
        createEReference ( this.modbusDeviceEClass, MODBUS_DEVICE__SLAVES );
        createEReference ( this.modbusDeviceEClass, MODBUS_DEVICE__TYPE_SYSTEM );

        this.modbusDriverEClass = createEClass ( MODBUS_DRIVER );
        createEReference ( this.modbusDriverEClass, MODBUS_DRIVER__MASTERS );

        this.modbusSlaveEClass = createEClass ( MODBUS_SLAVE );
        createEReference ( this.modbusSlaveEClass, MODBUS_SLAVE__BLOCKS );
        createEAttribute ( this.modbusSlaveEClass, MODBUS_SLAVE__UNIT_ADDRESS );
        createEAttribute ( this.modbusSlaveEClass, MODBUS_SLAVE__ID );
        createEAttribute ( this.modbusSlaveEClass, MODBUS_SLAVE__DATA_ORDER );

        this.modbusMasterEClass = createEClass ( MODBUS_MASTER );
        createEReference ( this.modbusMasterEClass, MODBUS_MASTER__SLAVES );
        createEReference ( this.modbusMasterEClass, MODBUS_MASTER__ENDPOINT );
        createEAttribute ( this.modbusMasterEClass, MODBUS_MASTER__ID );
        createEAttribute ( this.modbusMasterEClass, MODBUS_MASTER__PROTOCOL_TYPE );
        createEAttribute ( this.modbusMasterEClass, MODBUS_MASTER__INTER_FRAME_DELAY );

        this.modbusBlockEClass = createEClass ( MODBUS_BLOCK );
        createEAttribute ( this.modbusBlockEClass, MODBUS_BLOCK__ID );
        createEAttribute ( this.modbusBlockEClass, MODBUS_BLOCK__BLOCK_TYPE );
        createEAttribute ( this.modbusBlockEClass, MODBUS_BLOCK__START_ADDRESS );
        createEAttribute ( this.modbusBlockEClass, MODBUS_BLOCK__COUNT );
        createEAttribute ( this.modbusBlockEClass, MODBUS_BLOCK__PERIOD );
        createEAttribute ( this.modbusBlockEClass, MODBUS_BLOCK__TIMEOUT );
        createEReference ( this.modbusBlockEClass, MODBUS_BLOCK__TYPE );

        this.modbusExporterEClass = createEClass ( MODBUS_EXPORTER );
        createEReference ( this.modbusExporterEClass, MODBUS_EXPORTER__DEVICES );

        this.modbusExporterDeviceEClass = createEClass ( MODBUS_EXPORTER_DEVICE );
        createEReference ( this.modbusExporterDeviceEClass, MODBUS_EXPORTER_DEVICE__ITEMS );
        createEReference ( this.modbusExporterDeviceEClass, MODBUS_EXPORTER_DEVICE__PORT );
        createEAttribute ( this.modbusExporterDeviceEClass, MODBUS_EXPORTER_DEVICE__SLAVE_ID );
        createEReference ( this.modbusExporterDeviceEClass, MODBUS_EXPORTER_DEVICE__PROPERTIES );
        createEAttribute ( this.modbusExporterDeviceEClass, MODBUS_EXPORTER_DEVICE__DATA_ORDER );

        this.modbusExporterItemEClass = createEClass ( MODBUS_EXPORTER_ITEM );
        createEReference ( this.modbusExporterItemEClass, MODBUS_EXPORTER_ITEM__SOURCE );
        createEAttribute ( this.modbusExporterItemEClass, MODBUS_EXPORTER_ITEM__OFFSET );
        createEReference ( this.modbusExporterItemEClass, MODBUS_EXPORTER_ITEM__TYPE );

        this.modbusDataTypeEClass = createEClass ( MODBUS_DATA_TYPE );
        createEAttribute ( this.modbusDataTypeEClass, MODBUS_DATA_TYPE__NAME );
        createEAttribute ( this.modbusDataTypeEClass, MODBUS_DATA_TYPE__SCALE );

        this.modbusDoubleEClass = createEClass ( MODBUS_DOUBLE );

        this.modbusSInt16EClass = createEClass ( MODBUS_SINT16 );

        this.modbusSInt32EClass = createEClass ( MODBUS_SINT32 );

        this.modbusUInt16EClass = createEClass ( MODBUS_UINT16 );

        this.modbusUInt32EClass = createEClass ( MODBUS_UINT32 );

        this.modbusExporterModuleEClass = createEClass ( MODBUS_EXPORTER_MODULE );
        createEAttribute ( this.modbusExporterModuleEClass, MODBUS_EXPORTER_MODULE__DATA_ORDER );
        createEReference ( this.modbusExporterModuleEClass, MODBUS_EXPORTER_MODULE__PROPERTIES );

        this.modbusExporterInterceptorEClass = createEClass ( MODBUS_EXPORTER_INTERCEPTOR );
        createEReference ( this.modbusExporterInterceptorEClass, MODBUS_EXPORTER_INTERCEPTOR__SETTINGS );
        createEReference ( this.modbusExporterInterceptorEClass, MODBUS_EXPORTER_INTERCEPTOR__SCRIPT );

        // Create enums
        this.protocolTypeEEnum = createEEnum ( PROTOCOL_TYPE );
        this.byteOrderEEnum = createEEnum ( BYTE_ORDER );

        // Create data types
        this.requestTypeEDataType = createEDataType ( REQUEST_TYPE );
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
        final InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );
        final MemoryPackage theMemoryPackage = (MemoryPackage)EPackage.Registry.INSTANCE.getEPackage ( MemoryPackage.eNS_URI );
        final WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        final OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        final XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage ( XMLTypePackage.eNS_URI );
        final ComponentPackage theComponentPackage = (ComponentPackage)EPackage.Registry.INSTANCE.getEPackage ( ComponentPackage.eNS_URI );
        final ScriptPackage theScriptPackage = (ScriptPackage)EPackage.Registry.INSTANCE.getEPackage ( ScriptPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.modbusDeviceEClass.getESuperTypes ().add ( theInfrastructurePackage.getDevice () );
        this.modbusDriverEClass.getESuperTypes ().add ( theWorldPackage.getDriver () );
        this.modbusDriverEClass.getESuperTypes ().add ( theOsgiPackage.getEquinoxApplication () );
        this.modbusExporterEClass.getESuperTypes ().add ( theOsgiPackage.getApplicationModule () );
        this.modbusDoubleEClass.getESuperTypes ().add ( getModbusDataType () );
        this.modbusSInt16EClass.getESuperTypes ().add ( getModbusDataType () );
        this.modbusSInt32EClass.getESuperTypes ().add ( getModbusDataType () );
        this.modbusUInt16EClass.getESuperTypes ().add ( getModbusDataType () );
        this.modbusUInt32EClass.getESuperTypes ().add ( getModbusDataType () );
        this.modbusExporterModuleEClass.getESuperTypes ().add ( theInfrastructurePackage.getSettings () );
        this.modbusExporterInterceptorEClass.getESuperTypes ().add ( theComponentPackage.getItemInterceptor () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( this.modbusDeviceEClass, ModbusDevice.class, "ModbusDevice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getModbusDevice_Port (), this.ecorePackage.getEShort (), "port", null, 1, 1, ModbusDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusDevice_ProtocolType (), getProtocolType (), "protocolType", "TCP", 1, 1, ModbusDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getModbusDevice_InterFrameDelay (), this.ecorePackage.getEDoubleObject (), "interFrameDelay", null, 0, 1, ModbusDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusDevice_Slaves (), getModbusSlave (), null, "slaves", null, 0, -1, ModbusDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusDevice_TypeSystem (), theMemoryPackage.getTypeSystem (), null, "typeSystem", null, 1, 1, ModbusDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.modbusDriverEClass, ModbusDriver.class, "ModbusDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusDriver_Masters (), getModbusMaster (), null, "masters", null, 0, -1, ModbusDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.modbusSlaveEClass, ModbusSlave.class, "ModbusSlave", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusSlave_Blocks (), getModbusBlock (), null, "blocks", null, 0, -1, ModbusSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusSlave_UnitAddress (), theXMLTypePackage.getByte (), "unitAddress", null, 1, 1, ModbusSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusSlave_Id (), this.ecorePackage.getEString (), "id", null, 1, 1, ModbusSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusSlave_DataOrder (), getByteOrder (), "dataOrder", null, 1, 1, ModbusSlave.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.modbusMasterEClass, ModbusMaster.class, "ModbusMaster", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusMaster_Slaves (), getModbusSlave (), null, "slaves", null, 0, -1, ModbusMaster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusMaster_Endpoint (), theWorldPackage.getEndpoint (), null, "endpoint", null, 1, 1, ModbusMaster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusMaster_Id (), this.ecorePackage.getEString (), "id", null, 1, 1, ModbusMaster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusMaster_ProtocolType (), getProtocolType (), "protocolType", "TCP", 1, 1, ModbusMaster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getModbusMaster_InterFrameDelay (), theXMLTypePackage.getDoubleObject (), "interFrameDelay", null, 0, 1, ModbusMaster.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.modbusBlockEClass, ModbusBlock.class, "ModbusBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_Id (), this.ecorePackage.getEString (), "id", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_BlockType (), getRequestType (), "blockType", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_StartAddress (), this.ecorePackage.getEInt (), "startAddress", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_Count (), this.ecorePackage.getEInt (), "count", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_Period (), this.ecorePackage.getELong (), "period", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusBlock_Timeout (), this.ecorePackage.getELong (), "timeout", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusBlock_Type (), theMemoryPackage.getTypeDefinition (), null, "type", null, 1, 1, ModbusBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.modbusExporterEClass, ModbusExporter.class, "ModbusExporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusExporter_Devices (), getModbusExporterDevice (), null, "devices", null, 0, -1, ModbusExporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.modbusExporterDeviceEClass, ModbusExporterDevice.class, "ModbusExporterDevice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusExporterDevice_Items (), getModbusExporterItem (), null, "items", null, 0, -1, ModbusExporterDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusExporterDevice_Port (), theWorldPackage.getEndpoint (), null, "port", null, 1, 1, ModbusExporterDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusExporterDevice_SlaveId (), this.ecorePackage.getEInt (), "slaveId", null, 1, 1, ModbusExporterDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusExporterDevice_Properties (), theOsgiPackage.getPropertyEntry (), null, "properties", null, 0, -1, ModbusExporterDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusExporterDevice_DataOrder (), getByteOrder (), "dataOrder", "BIG_ENDIAN", 1, 1, ModbusExporterDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.modbusExporterItemEClass, ModbusExporterItem.class, "ModbusExporterItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusExporterItem_Source (), theOsgiPackage.getItem (), null, "source", null, 1, 1, ModbusExporterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusExporterItem_Offset (), this.ecorePackage.getEInt (), "offset", null, 1, 1, ModbusExporterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusExporterItem_Type (), getModbusDataType (), null, "type", null, 1, 1, ModbusExporterItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.modbusDataTypeEClass, ModbusDataType.class, "ModbusDataType", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getModbusDataType_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, ModbusDataType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getModbusDataType_Scale (), this.ecorePackage.getEDoubleObject (), "scale", null, 0, 1, ModbusDataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.modbusDoubleEClass, ModbusDouble.class, "ModbusDouble", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.modbusSInt16EClass, ModbusSInt16.class, "ModbusSInt16", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.modbusSInt32EClass, ModbusSInt32.class, "ModbusSInt32", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.modbusUInt16EClass, ModbusUInt16.class, "ModbusUInt16", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.modbusUInt32EClass, ModbusUInt32.class, "ModbusUInt32", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.modbusExporterModuleEClass, ModbusExporterModule.class, "ModbusExporterModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getModbusExporterModule_DataOrder (), getByteOrder (), "dataOrder", null, 1, 1, ModbusExporterModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusExporterModule_Properties (), theOsgiPackage.getPropertyEntry (), null, "properties", null, 0, -1, ModbusExporterModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.modbusExporterInterceptorEClass, ModbusExporterInterceptor.class, "ModbusExporterInterceptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getModbusExporterInterceptor_Settings (), getModbusExporterModule (), null, "settings", null, 1, 1, ModbusExporterInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getModbusExporterInterceptor_Script (), theScriptPackage.getScript (), null, "script", null, 1, 1, ModbusExporterInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( this.protocolTypeEEnum, ProtocolType.class, "ProtocolType" ); //$NON-NLS-1$
        addEEnumLiteral ( this.protocolTypeEEnum, ProtocolType.TCP );
        addEEnumLiteral ( this.protocolTypeEEnum, ProtocolType.RTU );

        initEEnum ( this.byteOrderEEnum, ByteOrder.class, "ByteOrder" ); //$NON-NLS-1$
        addEEnumLiteral ( this.byteOrderEEnum, ByteOrder.BIG_ENDIAN );
        addEEnumLiteral ( this.byteOrderEEnum, ByteOrder.LITTLE_ENDIAN );

        // Initialize data types
        initEDataType ( this.requestTypeEDataType, RequestType.class, "RequestType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ModbusPackageImpl
