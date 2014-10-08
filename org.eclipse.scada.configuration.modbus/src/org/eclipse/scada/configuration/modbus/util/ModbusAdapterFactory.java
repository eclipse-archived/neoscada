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
package org.eclipse.scada.configuration.modbus.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.infrastructure.Device;
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
import org.eclipse.scada.configuration.modbus.ModbusMaster;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.modbus.ModbusSInt16;
import org.eclipse.scada.configuration.modbus.ModbusSInt32;
import org.eclipse.scada.configuration.modbus.ModbusSlave;
import org.eclipse.scada.configuration.modbus.ModbusUInt16;
import org.eclipse.scada.configuration.modbus.ModbusUInt32;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.Settings;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage
 * @generated
 */
public class ModbusAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ModbusPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ModbusPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the
     * model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModbusSwitch<Adapter> modelSwitch = new ModbusSwitch<Adapter> () {
        @Override
        public Adapter caseModbusDevice ( ModbusDevice object )
        {
            return createModbusDeviceAdapter ();
        }

        @Override
        public Adapter caseModbusDriver ( ModbusDriver object )
        {
            return createModbusDriverAdapter ();
        }

        @Override
        public Adapter caseModbusSlave ( ModbusSlave object )
        {
            return createModbusSlaveAdapter ();
        }

        @Override
        public Adapter caseModbusMaster ( ModbusMaster object )
        {
            return createModbusMasterAdapter ();
        }

        @Override
        public Adapter caseModbusBlock ( ModbusBlock object )
        {
            return createModbusBlockAdapter ();
        }

        @Override
        public Adapter caseModbusExporter ( ModbusExporter object )
        {
            return createModbusExporterAdapter ();
        }

        @Override
        public Adapter caseModbusExporterDevice ( ModbusExporterDevice object )
        {
            return createModbusExporterDeviceAdapter ();
        }

        @Override
        public Adapter caseModbusExporterItem ( ModbusExporterItem object )
        {
            return createModbusExporterItemAdapter ();
        }

        @Override
        public Adapter caseModbusDataType ( ModbusDataType object )
        {
            return createModbusDataTypeAdapter ();
        }

        @Override
        public Adapter caseModbusDouble ( ModbusDouble object )
        {
            return createModbusDoubleAdapter ();
        }

        @Override
        public Adapter caseModbusSInt16 ( ModbusSInt16 object )
        {
            return createModbusSInt16Adapter ();
        }

        @Override
        public Adapter caseModbusSInt32 ( ModbusSInt32 object )
        {
            return createModbusSInt32Adapter ();
        }

        @Override
        public Adapter caseModbusUInt16 ( ModbusUInt16 object )
        {
            return createModbusUInt16Adapter ();
        }

        @Override
        public Adapter caseModbusUInt32 ( ModbusUInt32 object )
        {
            return createModbusUInt32Adapter ();
        }

        @Override
        public Adapter caseModbusExporterModule ( ModbusExporterModule object )
        {
            return createModbusExporterModuleAdapter ();
        }

        @Override
        public Adapter caseModbusExporterInterceptor ( ModbusExporterInterceptor object )
        {
            return createModbusExporterInterceptorAdapter ();
        }

        @Override
        public Adapter caseDocumentable ( Documentable object )
        {
            return createDocumentableAdapter ();
        }

        @Override
        public Adapter caseNamedDocumentable ( NamedDocumentable object )
        {
            return createNamedDocumentableAdapter ();
        }

        @Override
        public Adapter caseDevice ( Device object )
        {
            return createDeviceAdapter ();
        }

        @Override
        public Adapter caseApplication ( Application object )
        {
            return createApplicationAdapter ();
        }

        @Override
        public Adapter caseDriver ( Driver object )
        {
            return createDriverAdapter ();
        }

        @Override
        public Adapter caseEquinoxApplication ( EquinoxApplication object )
        {
            return createEquinoxApplicationAdapter ();
        }

        @Override
        public Adapter caseApplicationModule ( ApplicationModule object )
        {
            return createApplicationModuleAdapter ();
        }

        @Override
        public Adapter caseSettings ( Settings object )
        {
            return createSettingsAdapter ();
        }

        @Override
        public Adapter caseItemInterceptor ( ItemInterceptor object )
        {
            return createItemInterceptorAdapter ();
        }

        @Override
        public Adapter defaultCase ( EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusDevice <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusDevice
     * @generated
     */
    public Adapter createModbusDeviceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusDriver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusDriver
     * @generated
     */
    public Adapter createModbusDriverAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusSlave <em>Slave</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusSlave
     * @generated
     */
    public Adapter createModbusSlaveAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusMaster <em>Master</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusMaster
     * @generated
     */
    public Adapter createModbusMasterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusBlock <em>Block</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusBlock
     * @generated
     */
    public Adapter createModbusBlockAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusExporter <em>Exporter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporter
     * @generated
     */
    public Adapter createModbusExporterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice <em>Exporter Device</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterDevice
     * @generated
     */
    public Adapter createModbusExporterDeviceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem <em>Exporter Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterItem
     * @generated
     */
    public Adapter createModbusExporterItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusDataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusDataType
     * @generated
     */
    public Adapter createModbusDataTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusDouble <em>Double</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusDouble
     * @generated
     */
    public Adapter createModbusDoubleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusSInt16 <em>SInt16</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusSInt16
     * @generated
     */
    public Adapter createModbusSInt16Adapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusSInt32 <em>SInt32</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusSInt32
     * @generated
     */
    public Adapter createModbusSInt32Adapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusUInt16 <em>UInt16</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusUInt16
     * @generated
     */
    public Adapter createModbusUInt16Adapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusUInt32 <em>UInt32</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusUInt32
     * @generated
     */
    public Adapter createModbusUInt32Adapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusExporterModule <em>Exporter Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterModule
     * @generated
     */
    public Adapter createModbusExporterModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.modbus.ModbusExporterInterceptor <em>Exporter Interceptor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterInterceptor
     * @generated
     */
    public Adapter createModbusExporterInterceptorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Documentable <em>Documentable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Documentable
     * @generated
     */
    public Adapter createDocumentableAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.infrastructure.Device <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.infrastructure.Device
     * @generated
     */
    public Adapter createDeviceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.NamedDocumentable <em>Named Documentable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.NamedDocumentable
     * @generated
     */
    public Adapter createNamedDocumentableAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Application <em>Application</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Application
     * @generated
     */
    public Adapter createApplicationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Driver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Driver
     * @generated
     */
    public Adapter createDriverAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication <em>Equinox Application</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication
     * @generated
     */
    public Adapter createEquinoxApplicationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ApplicationModule <em>Application Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ApplicationModule
     * @generated
     */
    public Adapter createApplicationModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Settings <em>Settings</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Settings
     * @generated
     */
    public Adapter createSettingsAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.component.ItemInterceptor <em>Item Interceptor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ItemInterceptor
     * @generated
     */
    public Adapter createItemInterceptorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //ModbusAdapterFactory
