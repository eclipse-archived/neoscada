/**
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.neoscada.configuration.iec60870.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.neoscada.configuration.iec60870.AddressInformation;
import org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions;
import org.eclipse.neoscada.configuration.iec60870.ClientDevice;
import org.eclipse.neoscada.configuration.iec60870.DataModuleOptions;
import org.eclipse.neoscada.configuration.iec60870.DataType;
import org.eclipse.neoscada.configuration.iec60870.Device;
import org.eclipse.neoscada.configuration.iec60870.DriverApplication;
import org.eclipse.neoscada.configuration.iec60870.Exporter;
import org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Device;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Driver;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Factory;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.neoscada.configuration.iec60870.IECType;
import org.eclipse.neoscada.configuration.iec60870.Item;
import org.eclipse.neoscada.configuration.iec60870.ItemType;
import org.eclipse.neoscada.configuration.iec60870.ProtocolOptions;
import org.eclipse.neoscada.configuration.iec60870.util.IEC60870Validator;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.globalization.GlobalizePackage;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.item.ItemPackage;
import org.eclipse.scada.configuration.script.ScriptPackage;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IEC60870PackageImpl extends EPackageImpl implements IEC60870Package
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass exporterEClass = null;

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
    private EClass itemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass exporterItemInterceptorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass protocolOptionsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataModuleOptionsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass clientDeviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass driverApplicationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass clientDataModuleOptionsEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iec60870DriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iec60870DeviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum dataTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum iecTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType addressEDataType = null;

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
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#eNS_URI
     * @see #init()
     * @generated
     */
    private IEC60870PackageImpl ()
    {
        super ( eNS_URI, IEC60870Factory.eINSTANCE );
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
     * <p>This method is used to initialize {@link IEC60870Package#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static IEC60870Package init ()
    {
        if ( isInited )
            return (IEC60870Package)EPackage.Registry.INSTANCE.getEPackage ( IEC60870Package.eNS_URI );

        // Obtain or create and register package
        IEC60870PackageImpl theIEC60870Package = (IEC60870PackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof IEC60870PackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new IEC60870PackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        ComponentPackage.eINSTANCE.eClass ();
        ConfigurationPackage.eINSTANCE.eClass ();
        GlobalizePackage.eINSTANCE.eClass ();
        InfrastructurePackage.eINSTANCE.eClass ();
        ItemPackage.eINSTANCE.eClass ();
        ScriptPackage.eINSTANCE.eClass ();
        SecurityPackage.eINSTANCE.eClass ();
        WorldPackage.eINSTANCE.eClass ();
        EcorePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theIEC60870Package.createPackageContents ();

        // Initialize created meta-data
        theIEC60870Package.initializePackageContents ();

        // Register package validator
        EValidator.Registry.INSTANCE.put ( theIEC60870Package, new EValidator.Descriptor () {
            public EValidator getEValidator ()
            {
                return IEC60870Validator.INSTANCE;
            }
        } );

        // Mark meta-data to indicate it can't be changed
        theIEC60870Package.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( IEC60870Package.eNS_URI, theIEC60870Package );
        return theIEC60870Package;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getExporter ()
    {
        return exporterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getExporter_Devices ()
    {
        return (EReference)exporterEClass.getEStructuralFeatures ().get ( 0 );
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
    public EAttribute getDevice_Id ()
    {
        return (EAttribute)deviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDevice_Items ()
    {
        return (EReference)deviceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDevice_Endpoint ()
    {
        return (EReference)deviceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDevice_ProtocolOptions ()
    {
        return (EReference)deviceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDevice_DataModuleOptions ()
    {
        return (EReference)deviceEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDevice_HiveProperties ()
    {
        return (EReference)deviceEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDevice_SpontaneousBufferWindow ()
    {
        return (EAttribute)deviceEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDevice_CyclicPeriod ()
    {
        return (EAttribute)deviceEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getItem ()
    {
        return itemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getItem_Source ()
    {
        return (EReference)itemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItem_Address ()
    {
        return (EAttribute)itemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getItem_Type ()
    {
        return (EAttribute)itemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getExporterItemInterceptor ()
    {
        return exporterItemInterceptorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getExporterItemInterceptor_Script ()
    {
        return (EReference)exporterItemInterceptorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getExporterItemInterceptor_ProtocolOptions ()
    {
        return (EReference)exporterItemInterceptorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getExporterItemInterceptor_DataModuleOptions ()
    {
        return (EReference)exporterItemInterceptorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getExporterItemInterceptor_Port ()
    {
        return (EAttribute)exporterItemInterceptorEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getExporterItemInterceptor_HiveProperties ()
    {
        return (EReference)exporterItemInterceptorEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExporterItemInterceptor_SpontaneousBufferWindow ()
    {
        return (EAttribute)exporterItemInterceptorEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExporterItemInterceptor_CyclicPeriod ()
    {
        return (EAttribute)exporterItemInterceptorEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getProtocolOptions ()
    {
        return protocolOptionsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocolOptions_Timeout1 ()
    {
        return (EAttribute)protocolOptionsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocolOptions_Timeout2 ()
    {
        return (EAttribute)protocolOptionsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocolOptions_Timeout3 ()
    {
        return (EAttribute)protocolOptionsEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocolOptions_AsduAddressSize ()
    {
        return (EAttribute)protocolOptionsEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocolOptions_InformationObjectAddressSize ()
    {
        return (EAttribute)protocolOptionsEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocolOptions_CauseOfTransmissionSize ()
    {
        return (EAttribute)protocolOptionsEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocolOptions_W ()
    {
        return (EAttribute)protocolOptionsEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocolOptions_K ()
    {
        return (EAttribute)protocolOptionsEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocolOptions_TargetTimeZone ()
    {
        return (EAttribute)protocolOptionsEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocolOptions_IgnoreDaylightSavingTime ()
    {
        return (EAttribute)protocolOptionsEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDataModuleOptions ()
    {
        return dataModuleOptionsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDataModuleOptions_BackgroundScanPeriod ()
    {
        return (EAttribute)dataModuleOptionsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDataModuleOptions_SpontaneousItemBuffer ()
    {
        return (EAttribute)dataModuleOptionsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDataModuleOptions_TimestampsForBoolean ()
    {
        return (EAttribute)dataModuleOptionsEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDataModuleOptions_TimestampsForFloat ()
    {
        return (EAttribute)dataModuleOptionsEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getClientDevice ()
    {
        return clientDeviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getClientDevice_Endpoint ()
    {
        return (EReference)clientDeviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getClientDevice_ProtocolOptions ()
    {
        return (EReference)clientDeviceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getClientDevice_DataModuleOptions ()
    {
        return (EReference)clientDeviceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getClientDevice_Id ()
    {
        return (EAttribute)clientDeviceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getClientDevice_ItemTypes ()
    {
        return (EReference)clientDeviceEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDriverApplication ()
    {
        return driverApplicationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDriverApplication_Devices ()
    {
        return (EReference)driverApplicationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getClientDataModuleOptions ()
    {
        return clientDataModuleOptionsEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getClientDataModuleOptions_IgnoreBackgroundScan ()
    {
        return (EAttribute)clientDataModuleOptionsEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getClientDataModuleOptions_DelayStart ()
    {
        return (EAttribute)clientDataModuleOptionsEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIEC60870Driver ()
    {
        return iec60870DriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getIEC60870Driver_Devices ()
    {
        return (EReference)iec60870DriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIEC60870Device ()
    {
        return iec60870DeviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getIEC60870Device_DataModuleOptions ()
    {
        return (EReference)iec60870DeviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getIEC60870Device_ProtocolOptions ()
    {
        return (EReference)iec60870DeviceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEC60870Device_Port ()
    {
        return (EAttribute)iec60870DeviceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIEC60870Device_ItemTypes ()
    {
        return (EReference)iec60870DeviceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItemType ()
    {
        return itemTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItemType_Item ()
    {
        return (EAttribute)itemTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItemType_Type ()
    {
        return (EAttribute)itemTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getDataType ()
    {
        return dataTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getIECType ()
    {
        return iecTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getAddress ()
    {
        return addressEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IEC60870Factory getIEC60870Factory ()
    {
        return (IEC60870Factory)getEFactoryInstance ();
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
        exporterEClass = createEClass ( EXPORTER );
        createEReference ( exporterEClass, EXPORTER__DEVICES );

        deviceEClass = createEClass ( DEVICE );
        createEAttribute ( deviceEClass, DEVICE__ID );
        createEReference ( deviceEClass, DEVICE__ITEMS );
        createEReference ( deviceEClass, DEVICE__ENDPOINT );
        createEReference ( deviceEClass, DEVICE__PROTOCOL_OPTIONS );
        createEReference ( deviceEClass, DEVICE__DATA_MODULE_OPTIONS );
        createEReference ( deviceEClass, DEVICE__HIVE_PROPERTIES );
        createEAttribute ( deviceEClass, DEVICE__SPONTANEOUS_BUFFER_WINDOW );
        createEAttribute ( deviceEClass, DEVICE__CYCLIC_PERIOD );

        itemEClass = createEClass ( ITEM );
        createEReference ( itemEClass, ITEM__SOURCE );
        createEAttribute ( itemEClass, ITEM__ADDRESS );
        createEAttribute ( itemEClass, ITEM__TYPE );

        exporterItemInterceptorEClass = createEClass ( EXPORTER_ITEM_INTERCEPTOR );
        createEReference ( exporterItemInterceptorEClass, EXPORTER_ITEM_INTERCEPTOR__SCRIPT );
        createEReference ( exporterItemInterceptorEClass, EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS );
        createEReference ( exporterItemInterceptorEClass, EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS );
        createEAttribute ( exporterItemInterceptorEClass, EXPORTER_ITEM_INTERCEPTOR__PORT );
        createEReference ( exporterItemInterceptorEClass, EXPORTER_ITEM_INTERCEPTOR__HIVE_PROPERTIES );
        createEAttribute ( exporterItemInterceptorEClass, EXPORTER_ITEM_INTERCEPTOR__SPONTANEOUS_BUFFER_WINDOW );
        createEAttribute ( exporterItemInterceptorEClass, EXPORTER_ITEM_INTERCEPTOR__CYCLIC_PERIOD );

        protocolOptionsEClass = createEClass ( PROTOCOL_OPTIONS );
        createEAttribute ( protocolOptionsEClass, PROTOCOL_OPTIONS__TIMEOUT1 );
        createEAttribute ( protocolOptionsEClass, PROTOCOL_OPTIONS__TIMEOUT2 );
        createEAttribute ( protocolOptionsEClass, PROTOCOL_OPTIONS__TIMEOUT3 );
        createEAttribute ( protocolOptionsEClass, PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE );
        createEAttribute ( protocolOptionsEClass, PROTOCOL_OPTIONS__INFORMATION_OBJECT_ADDRESS_SIZE );
        createEAttribute ( protocolOptionsEClass, PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE );
        createEAttribute ( protocolOptionsEClass, PROTOCOL_OPTIONS__W );
        createEAttribute ( protocolOptionsEClass, PROTOCOL_OPTIONS__K );
        createEAttribute ( protocolOptionsEClass, PROTOCOL_OPTIONS__TARGET_TIME_ZONE );
        createEAttribute ( protocolOptionsEClass, PROTOCOL_OPTIONS__IGNORE_DAYLIGHT_SAVING_TIME );

        dataModuleOptionsEClass = createEClass ( DATA_MODULE_OPTIONS );
        createEAttribute ( dataModuleOptionsEClass, DATA_MODULE_OPTIONS__BACKGROUND_SCAN_PERIOD );
        createEAttribute ( dataModuleOptionsEClass, DATA_MODULE_OPTIONS__SPONTANEOUS_ITEM_BUFFER );
        createEAttribute ( dataModuleOptionsEClass, DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_BOOLEAN );
        createEAttribute ( dataModuleOptionsEClass, DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_FLOAT );

        clientDeviceEClass = createEClass ( CLIENT_DEVICE );
        createEReference ( clientDeviceEClass, CLIENT_DEVICE__ENDPOINT );
        createEReference ( clientDeviceEClass, CLIENT_DEVICE__PROTOCOL_OPTIONS );
        createEReference ( clientDeviceEClass, CLIENT_DEVICE__DATA_MODULE_OPTIONS );
        createEAttribute ( clientDeviceEClass, CLIENT_DEVICE__ID );
        createEReference ( clientDeviceEClass, CLIENT_DEVICE__ITEM_TYPES );

        driverApplicationEClass = createEClass ( DRIVER_APPLICATION );
        createEReference ( driverApplicationEClass, DRIVER_APPLICATION__DEVICES );

        clientDataModuleOptionsEClass = createEClass ( CLIENT_DATA_MODULE_OPTIONS );
        createEAttribute ( clientDataModuleOptionsEClass, CLIENT_DATA_MODULE_OPTIONS__IGNORE_BACKGROUND_SCAN );
        createEAttribute ( clientDataModuleOptionsEClass, CLIENT_DATA_MODULE_OPTIONS__DELAY_START );

        iec60870DriverEClass = createEClass ( IEC60870_DRIVER );
        createEReference ( iec60870DriverEClass, IEC60870_DRIVER__DEVICES );

        iec60870DeviceEClass = createEClass ( IEC60870_DEVICE );
        createEReference ( iec60870DeviceEClass, IEC60870_DEVICE__DATA_MODULE_OPTIONS );
        createEReference ( iec60870DeviceEClass, IEC60870_DEVICE__PROTOCOL_OPTIONS );
        createEAttribute ( iec60870DeviceEClass, IEC60870_DEVICE__PORT );
        createEReference ( iec60870DeviceEClass, IEC60870_DEVICE__ITEM_TYPES );

        itemTypeEClass = createEClass ( ITEM_TYPE );
        createEAttribute ( itemTypeEClass, ITEM_TYPE__ITEM );
        createEAttribute ( itemTypeEClass, ITEM_TYPE__TYPE );

        // Create enums
        dataTypeEEnum = createEEnum ( DATA_TYPE );
        iecTypeEEnum = createEEnum ( IEC_TYPE );

        // Create data types
        addressEDataType = createEDataType ( ADDRESS );
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
        OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage ( EcorePackage.eNS_URI );
        ComponentPackage theComponentPackage = (ComponentPackage)EPackage.Registry.INSTANCE.getEPackage ( ComponentPackage.eNS_URI );
        ScriptPackage theScriptPackage = (ScriptPackage)EPackage.Registry.INSTANCE.getEPackage ( ScriptPackage.eNS_URI );
        InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        exporterEClass.getESuperTypes ().add ( theOsgiPackage.getApplicationModule () );
        exporterItemInterceptorEClass.getESuperTypes ().add ( theComponentPackage.getItemInterceptor () );
        driverApplicationEClass.getESuperTypes ().add ( theWorldPackage.getDriver () );
        driverApplicationEClass.getESuperTypes ().add ( theOsgiPackage.getEquinoxApplication () );
        iec60870DriverEClass.getESuperTypes ().add ( theInfrastructurePackage.getAbstractEquinoxDriver () );
        iec60870DeviceEClass.getESuperTypes ().add ( theInfrastructurePackage.getDevice () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( exporterEClass, Exporter.class, "Exporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getExporter_Devices (), this.getDevice (), null, "devices", null, 0, -1, Exporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( deviceEClass, Device.class, "Device", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDevice_Id (), ecorePackage.getEString (), "id", null, 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDevice_Items (), this.getItem (), null, "items", null, 0, -1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDevice_Endpoint (), theWorldPackage.getEndpoint (), null, "endpoint", null, 1, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDevice_ProtocolOptions (), this.getProtocolOptions (), null, "protocolOptions", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDevice_DataModuleOptions (), this.getDataModuleOptions (), null, "dataModuleOptions", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDevice_HiveProperties (), theWorldPackage.getPropertyEntry (), null, "hiveProperties", null, 0, -1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDevice_SpontaneousBufferWindow (), theEcorePackage.getELongObject (), "spontaneousBufferWindow", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDevice_CyclicPeriod (), theEcorePackage.getELongObject (), "cyclicPeriod", null, 0, 1, Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemEClass, Item.class, "Item", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getItem_Source (), theOsgiPackage.getItem (), null, "source", null, 1, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItem_Address (), this.getAddress (), "address", null, 1, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItem_Type (), this.getDataType (), "type", null, 1, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( exporterItemInterceptorEClass, ExporterItemInterceptor.class, "ExporterItemInterceptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getExporterItemInterceptor_Script (), theScriptPackage.getScript (), null, "script", null, 1, 1, ExporterItemInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExporterItemInterceptor_ProtocolOptions (), this.getProtocolOptions (), null, "protocolOptions", null, 0, 1, ExporterItemInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExporterItemInterceptor_DataModuleOptions (), this.getDataModuleOptions (), null, "dataModuleOptions", null, 0, 1, ExporterItemInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getExporterItemInterceptor_Port (), ecorePackage.getEShort (), "port", "2404", 1, 1, ExporterItemInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getExporterItemInterceptor_HiveProperties (), theWorldPackage.getPropertyEntry (), null, "hiveProperties", null, 0, -1, ExporterItemInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getExporterItemInterceptor_SpontaneousBufferWindow (), theEcorePackage.getELongObject (), "spontaneousBufferWindow", null, 0, 1, ExporterItemInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getExporterItemInterceptor_CyclicPeriod (), theEcorePackage.getELongObject (), "cyclicPeriod", null, 0, 1, ExporterItemInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( protocolOptionsEClass, ProtocolOptions.class, "ProtocolOptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getProtocolOptions_Timeout1 (), ecorePackage.getEInt (), "timeout1", "15000", 1, 1, ProtocolOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getProtocolOptions_Timeout2 (), ecorePackage.getEInt (), "timeout2", "10000", 1, 1, ProtocolOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getProtocolOptions_Timeout3 (), ecorePackage.getEInt (), "timeout3", "20000", 1, 1, ProtocolOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getProtocolOptions_AsduAddressSize (), ecorePackage.getEByte (), "asduAddressSize", "2", 1, 1, ProtocolOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getProtocolOptions_InformationObjectAddressSize (), ecorePackage.getEByte (), "informationObjectAddressSize", "3", 1, 1, ProtocolOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getProtocolOptions_CauseOfTransmissionSize (), ecorePackage.getEByte (), "causeOfTransmissionSize", "2", 1, 1, ProtocolOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getProtocolOptions_W (), ecorePackage.getEInt (), "w", "10", 1, 1, ProtocolOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getProtocolOptions_K (), ecorePackage.getEInt (), "k", "15", 1, 1, ProtocolOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getProtocolOptions_TargetTimeZone (), ecorePackage.getEString (), "targetTimeZone", null, 0, 1, ProtocolOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProtocolOptions_IgnoreDaylightSavingTime (), ecorePackage.getEBoolean (), "ignoreDaylightSavingTime", "false", 1, 1, ProtocolOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( dataModuleOptionsEClass, DataModuleOptions.class, "DataModuleOptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDataModuleOptions_BackgroundScanPeriod (), ecorePackage.getEIntegerObject (), "backgroundScanPeriod", "60000", 0, 1, DataModuleOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getDataModuleOptions_SpontaneousItemBuffer (), ecorePackage.getEIntegerObject (), "spontaneousItemBuffer", "100", 0, 1, DataModuleOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getDataModuleOptions_TimestampsForBoolean (), ecorePackage.getEBoolean (), "timestampsForBoolean", "true", 1, 1, DataModuleOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getDataModuleOptions_TimestampsForFloat (), ecorePackage.getEBoolean (), "timestampsForFloat", "true", 1, 1, DataModuleOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( clientDeviceEClass, ClientDevice.class, "ClientDevice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getClientDevice_Endpoint (), theWorldPackage.getEndpoint (), null, "endpoint", null, 1, 1, ClientDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getClientDevice_ProtocolOptions (), this.getProtocolOptions (), null, "protocolOptions", null, 0, 1, ClientDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getClientDevice_DataModuleOptions (), this.getClientDataModuleOptions (), null, "dataModuleOptions", null, 0, 1, ClientDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getClientDevice_Id (), ecorePackage.getEString (), "id", null, 1, 1, ClientDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getClientDevice_ItemTypes (), this.getItemType (), null, "itemTypes", null, 0, -1, ClientDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( driverApplicationEClass, DriverApplication.class, "DriverApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDriverApplication_Devices (), this.getClientDevice (), null, "devices", null, 0, -1, DriverApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( clientDataModuleOptionsEClass, ClientDataModuleOptions.class, "ClientDataModuleOptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getClientDataModuleOptions_IgnoreBackgroundScan (), ecorePackage.getEBoolean (), "ignoreBackgroundScan", "false", 1, 1, ClientDataModuleOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getClientDataModuleOptions_DelayStart (), ecorePackage.getEBoolean (), "delayStart", "false", 1, 1, ClientDataModuleOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( iec60870DriverEClass, IEC60870Driver.class, "IEC60870Driver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getIEC60870Driver_Devices (), this.getIEC60870Device (), null, "devices", null, 0, -1, IEC60870Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( iec60870DeviceEClass, IEC60870Device.class, "IEC60870Device", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getIEC60870Device_DataModuleOptions (), this.getClientDataModuleOptions (), null, "dataModuleOptions", null, 0, 1, IEC60870Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getIEC60870Device_ProtocolOptions (), this.getProtocolOptions (), null, "protocolOptions", null, 0, 1, IEC60870Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getIEC60870Device_Port (), ecorePackage.getEInt (), "port", "2404", 1, 1, IEC60870Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getIEC60870Device_ItemTypes (), this.getItemType (), null, "itemTypes", null, 0, -1, IEC60870Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemTypeEClass, ItemType.class, "ItemType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemType_Item (), theEcorePackage.getEString (), "item", null, 0, 1, ItemType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getItemType_Type (), this.getIECType (), "type", null, 0, 1, ItemType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( dataTypeEEnum, DataType.class, "DataType" ); //$NON-NLS-1$
        addEEnumLiteral ( dataTypeEEnum, DataType.FLOAT );
        addEEnumLiteral ( dataTypeEEnum, DataType.BOOLEAN );

        initEEnum ( iecTypeEEnum, IECType.class, "IECType" ); //$NON-NLS-1$
        addEEnumLiteral ( iecTypeEEnum, IECType.CSC_NA_1 );
        addEEnumLiteral ( iecTypeEEnum, IECType.CSC_TA_1 );
        addEEnumLiteral ( iecTypeEEnum, IECType.CSE_NA_1 );
        addEEnumLiteral ( iecTypeEEnum, IECType.CSE_TA_1 );
        addEEnumLiteral ( iecTypeEEnum, IECType.CSE_NB_1 );
        addEEnumLiteral ( iecTypeEEnum, IECType.CSE_TB_1 );
        addEEnumLiteral ( iecTypeEEnum, IECType.CSE_NC_1 );
        addEEnumLiteral ( iecTypeEEnum, IECType.CSE_TC_1 );

        // Initialize data types
        initEDataType ( addressEDataType, AddressInformation.class, "Address", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http://www.eclipse.org/OCL/Import
        createImportAnnotations ();
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations ();
        // http://www.eclipse.org/emf/2002/Ecore/OCL
        createOCLAnnotations ();
        // http://eclipse.org/SCADA/CA/Descriptor
        createDescriptorAnnotations ();
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createImportAnnotations ()
    {
        String source = "http://www.eclipse.org/OCL/Import"; //$NON-NLS-1$	
        addAnnotation ( this, source, new String[] { "component", "/resource/org.eclipse.scada.configuration.component/model/component.ecore#/", //$NON-NLS-1$ //$NON-NLS-2$
                "ecore", "http://www.eclipse.org/emf/2002/Ecore#/", //$NON-NLS-1$ //$NON-NLS-2$
                "script_0", "/resource/org.eclipse.scada.configuration.script/model/script.ecore#/" //$NON-NLS-1$ //$NON-NLS-2$
        } );
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createEcoreAnnotations ()
    {
        String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$	
        addAnnotation ( this, source, new String[] { "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$ //$NON-NLS-2$
                "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$ //$NON-NLS-2$
                "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( protocolOptionsEClass, source, new String[] { "constraints", "asduAddressSizeCheck\ncauseOfTransmissionSizeCheck" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( iec60870DeviceEClass, source, new String[] { "constraints", "portCheck" //$NON-NLS-1$ //$NON-NLS-2$
        } );
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createOCLAnnotations ()
    {
        String source = "http://www.eclipse.org/emf/2002/Ecore/OCL"; //$NON-NLS-1$	
        addAnnotation ( protocolOptionsEClass, source, new String[] { "asduAddressSizeCheck", "asduAddressSize>=1 and asduAddressSize <=2", //$NON-NLS-1$ //$NON-NLS-2$
                "causeOfTransmissionSizeCheck", "causeOfTransmissionSize>=1 and causeOfTransmissionSize<=2", //$NON-NLS-1$ //$NON-NLS-2$
                "informationObjectAddressSizeCheck", "informationObjectAddressSize>=1 and informationObjectAddressSize<=3" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( iec60870DeviceEClass, source, new String[] { "portCheck", "port > 0 and port < 65535" //$NON-NLS-1$ //$NON-NLS-2$
        } );
    }

    /**
     * Initializes the annotations for <b>http://eclipse.org/SCADA/CA/Descriptor</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createDescriptorAnnotations ()
    {
        String source = "http://eclipse.org/SCADA/CA/Descriptor"; //$NON-NLS-1$	
        addAnnotation ( getProtocolOptions_Timeout1 (), source, new String[] { "name", "t1" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProtocolOptions_Timeout2 (), source, new String[] { "name", "t2" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProtocolOptions_Timeout3 (), source, new String[] { "name", "t3" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProtocolOptions_AsduAddressSize (), source, new String[] { "name", "asduAddressType", //$NON-NLS-1$ //$NON-NLS-2$
                "format", "SIZE_%d" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProtocolOptions_InformationObjectAddressSize (), source, new String[] { "name", "informationObjectAddressType", //$NON-NLS-1$ //$NON-NLS-2$
                "format", "SIZE_%d" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProtocolOptions_CauseOfTransmissionSize (), source, new String[] { "name", "causeOfTransmissionType", //$NON-NLS-1$ //$NON-NLS-2$
                "format", "SIZE_%d" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProtocolOptions_W (), source, new String[] { "name", "w" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProtocolOptions_K (), source, new String[] { "name", "k" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProtocolOptions_TargetTimeZone (), source, new String[] { "name", "timeZone" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProtocolOptions_IgnoreDaylightSavingTime (), source, new String[] { "name", "ignoreDaylightSavingTime" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDataModuleOptions_BackgroundScanPeriod (), source, new String[] { "name", "backgroundScanPeriod" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDataModuleOptions_SpontaneousItemBuffer (), source, new String[] { "name", "spontaneousItemBuffer" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDataModuleOptions_TimestampsForBoolean (), source, new String[] { "name", "withTimestamp.boolean" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDataModuleOptions_TimestampsForFloat (), source, new String[] { "name", "withTimestamp.float" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getClientDataModuleOptions_IgnoreBackgroundScan (), source, new String[] { "name", "ignoreBackgroundScan" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getClientDataModuleOptions_DelayStart (), source, new String[] { "name", "delayStart" //$NON-NLS-1$ //$NON-NLS-2$
        } );
    }

} //IEC60870PackageImpl
