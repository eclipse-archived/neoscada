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
package org.eclipse.neoscada.configuration.iec60870.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.neoscada.configuration.iec60870.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IEC60870FactoryImpl extends EFactoryImpl implements IEC60870Factory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static IEC60870Factory init ()
    {
        try
        {
            IEC60870Factory theIEC60870Factory = (IEC60870Factory)EPackage.Registry.INSTANCE.getEFactory ( IEC60870Package.eNS_URI );
            if ( theIEC60870Factory != null )
            {
                return theIEC60870Factory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new IEC60870FactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC60870FactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case IEC60870Package.EXPORTER:
                return createExporter ();
            case IEC60870Package.DEVICE:
                return createDevice ();
            case IEC60870Package.ITEM:
                return createItem ();
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR:
                return createExporterItemInterceptor ();
            case IEC60870Package.PROTOCOL_OPTIONS:
                return createProtocolOptions ();
            case IEC60870Package.DATA_MODULE_OPTIONS:
                return createDataModuleOptions ();
            case IEC60870Package.CLIENT_DEVICE:
                return createClientDevice ();
            case IEC60870Package.DRIVER_APPLICATION:
                return createDriverApplication ();
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS:
                return createClientDataModuleOptions ();
            case IEC60870Package.IEC60870_DRIVER:
                return createIEC60870Driver ();
            case IEC60870Package.IEC60870_DEVICE:
                return createIEC60870Device ();
            case IEC60870Package.ITEM_TYPE:
                return createItemType ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case IEC60870Package.DATA_TYPE:
                return createDataTypeFromString ( eDataType, initialValue );
            case IEC60870Package.IEC_TYPE:
                return createIECTypeFromString ( eDataType, initialValue );
            case IEC60870Package.ADDRESS:
                return createAddressFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case IEC60870Package.DATA_TYPE:
                return convertDataTypeToString ( eDataType, instanceValue );
            case IEC60870Package.IEC_TYPE:
                return convertIECTypeToString ( eDataType, instanceValue );
            case IEC60870Package.ADDRESS:
                return convertAddressToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Exporter createExporter ()
    {
        ExporterImpl exporter = new ExporterImpl ();
        return exporter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Device createDevice ()
    {
        DeviceImpl device = new DeviceImpl ();
        return device;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Item createItem ()
    {
        ItemImpl item = new ItemImpl ();
        return item;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExporterItemInterceptor createExporterItemInterceptor ()
    {
        ExporterItemInterceptorImpl exporterItemInterceptor = new ExporterItemInterceptorImpl ();
        return exporterItemInterceptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProtocolOptions createProtocolOptions ()
    {
        ProtocolOptionsImpl protocolOptions = new ProtocolOptionsImpl ();
        return protocolOptions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataModuleOptions createDataModuleOptions ()
    {
        DataModuleOptionsImpl dataModuleOptions = new DataModuleOptionsImpl ();
        return dataModuleOptions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ClientDevice createClientDevice ()
    {
        ClientDeviceImpl clientDevice = new ClientDeviceImpl ();
        return clientDevice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DriverApplication createDriverApplication ()
    {
        DriverApplicationImpl driverApplication = new DriverApplicationImpl ();
        return driverApplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ClientDataModuleOptions createClientDataModuleOptions ()
    {
        ClientDataModuleOptionsImpl clientDataModuleOptions = new ClientDataModuleOptionsImpl ();
        return clientDataModuleOptions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC60870Driver createIEC60870Driver ()
    {
        IEC60870DriverImpl iec60870Driver = new IEC60870DriverImpl ();
        return iec60870Driver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC60870Device createIEC60870Device ()
    {
        IEC60870DeviceImpl iec60870Device = new IEC60870DeviceImpl ();
        return iec60870Device;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemType createItemType ()
    {
        ItemTypeImpl itemType = new ItemTypeImpl ();
        return itemType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataType createDataTypeFromString ( EDataType eDataType, String initialValue )
    {
        DataType result = DataType.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDataTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IECType createIECTypeFromString ( EDataType eDataType, String initialValue )
    {
        IECType result = IECType.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertIECTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AddressInformation createAddressFromString ( EDataType eDataType, String initialValue )
    {
        return (AddressInformation)super.createFromString ( eDataType, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertAddressToString ( EDataType eDataType, Object instanceValue )
    {
        return super.convertToString ( eDataType, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC60870Package getIEC60870Package ()
    {
        return (IEC60870Package)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static IEC60870Package getPackage ()
    {
        return IEC60870Package.eINSTANCE;
    }

} //IEC60870FactoryImpl
