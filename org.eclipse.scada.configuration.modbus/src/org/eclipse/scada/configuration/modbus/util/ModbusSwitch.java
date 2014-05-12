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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.Settings;
import org.eclipse.scada.configuration.modbus.*;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage
 * @generated
 */
public class ModbusSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ModbusPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ModbusPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch ( int classifierID, EObject theEObject )
    {
        switch ( classifierID )
        {
            case ModbusPackage.MODBUS_DEVICE:
            {
                ModbusDevice modbusDevice = (ModbusDevice)theEObject;
                T result = caseModbusDevice ( modbusDevice );
                if ( result == null )
                    result = caseDevice ( modbusDevice );
                if ( result == null )
                    result = caseNamedDocumentable ( modbusDevice );
                if ( result == null )
                    result = caseDocumentable ( modbusDevice );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_DRIVER:
            {
                ModbusDriver modbusDriver = (ModbusDriver)theEObject;
                T result = caseModbusDriver ( modbusDriver );
                if ( result == null )
                    result = caseDriver ( modbusDriver );
                if ( result == null )
                    result = caseEquinoxApplication ( modbusDriver );
                if ( result == null )
                    result = caseApplication ( modbusDriver );
                if ( result == null )
                    result = caseNamedDocumentable ( modbusDriver );
                if ( result == null )
                    result = caseDocumentable ( modbusDriver );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_SLAVE:
            {
                ModbusSlave modbusSlave = (ModbusSlave)theEObject;
                T result = caseModbusSlave ( modbusSlave );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_MASTER:
            {
                ModbusMaster modbusMaster = (ModbusMaster)theEObject;
                T result = caseModbusMaster ( modbusMaster );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_BLOCK:
            {
                ModbusBlock modbusBlock = (ModbusBlock)theEObject;
                T result = caseModbusBlock ( modbusBlock );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_EXPORTER:
            {
                ModbusExporter modbusExporter = (ModbusExporter)theEObject;
                T result = caseModbusExporter ( modbusExporter );
                if ( result == null )
                    result = caseApplicationModule ( modbusExporter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_EXPORTER_DEVICE:
            {
                ModbusExporterDevice modbusExporterDevice = (ModbusExporterDevice)theEObject;
                T result = caseModbusExporterDevice ( modbusExporterDevice );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_EXPORTER_ITEM:
            {
                ModbusExporterItem modbusExporterItem = (ModbusExporterItem)theEObject;
                T result = caseModbusExporterItem ( modbusExporterItem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_DATA_TYPE:
            {
                ModbusDataType modbusDataType = (ModbusDataType)theEObject;
                T result = caseModbusDataType ( modbusDataType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_DOUBLE:
            {
                ModbusDouble modbusDouble = (ModbusDouble)theEObject;
                T result = caseModbusDouble ( modbusDouble );
                if ( result == null )
                    result = caseModbusDataType ( modbusDouble );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_SINT16:
            {
                ModbusSInt16 modbusSInt16 = (ModbusSInt16)theEObject;
                T result = caseModbusSInt16 ( modbusSInt16 );
                if ( result == null )
                    result = caseModbusDataType ( modbusSInt16 );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_SINT32:
            {
                ModbusSInt32 modbusSInt32 = (ModbusSInt32)theEObject;
                T result = caseModbusSInt32 ( modbusSInt32 );
                if ( result == null )
                    result = caseModbusDataType ( modbusSInt32 );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_UINT16:
            {
                ModbusUInt16 modbusUInt16 = (ModbusUInt16)theEObject;
                T result = caseModbusUInt16 ( modbusUInt16 );
                if ( result == null )
                    result = caseModbusDataType ( modbusUInt16 );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_UINT32:
            {
                ModbusUInt32 modbusUInt32 = (ModbusUInt32)theEObject;
                T result = caseModbusUInt32 ( modbusUInt32 );
                if ( result == null )
                    result = caseModbusDataType ( modbusUInt32 );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_EXPORTER_MODULE:
            {
                ModbusExporterModule modbusExporterModule = (ModbusExporterModule)theEObject;
                T result = caseModbusExporterModule ( modbusExporterModule );
                if ( result == null )
                    result = caseSettings ( modbusExporterModule );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR:
            {
                ModbusExporterInterceptor modbusExporterInterceptor = (ModbusExporterInterceptor)theEObject;
                T result = caseModbusExporterInterceptor ( modbusExporterInterceptor );
                if ( result == null )
                    result = caseItemInterceptor ( modbusExporterInterceptor );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Device</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusDevice ( ModbusDevice object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusDriver ( ModbusDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Slave</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Slave</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusSlave ( ModbusSlave object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Master</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Master</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusMaster ( ModbusMaster object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Block</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusBlock ( ModbusBlock object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exporter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exporter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusExporter ( ModbusExporter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exporter Device</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exporter Device</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusExporterDevice ( ModbusExporterDevice object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exporter Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exporter Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusExporterItem ( ModbusExporterItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusDataType ( ModbusDataType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Double</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Double</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusDouble ( ModbusDouble object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>SInt16</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SInt16</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusSInt16 ( ModbusSInt16 object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>SInt32</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>SInt32</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusSInt32 ( ModbusSInt32 object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>UInt16</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>UInt16</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusUInt16 ( ModbusUInt16 object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>UInt32</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>UInt32</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusUInt32 ( ModbusUInt32 object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exporter Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exporter Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusExporterModule ( ModbusExporterModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exporter Interceptor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exporter Interceptor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModbusExporterInterceptor ( ModbusExporterInterceptor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentable ( Documentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Device</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDevice ( Device object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedDocumentable ( NamedDocumentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplication ( Application object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDriver ( Driver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Equinox Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Equinox Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEquinoxApplication ( EquinoxApplication object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Application Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Application Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplicationModule ( ApplicationModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Settings</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Settings</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSettings ( Settings object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Interceptor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Interceptor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemInterceptor ( ItemInterceptor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( EObject object )
    {
        return null;
    }

} //ModbusSwitch
