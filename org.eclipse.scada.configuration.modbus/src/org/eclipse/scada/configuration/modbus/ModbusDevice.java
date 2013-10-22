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
package org.eclipse.scada.configuration.modbus;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.memory.TypeSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getProtocolType <em>Protocol Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getSlaves <em>Slaves</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getTypeSystem <em>Type System</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusDevice()
 * @model
 * @generated
 */
public interface ModbusDevice extends Device
{

    /**
     * Returns the value of the '<em><b>Slaves</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.modbus.ModbusSlave}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Slaves</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Slaves</em>' containment reference list.
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusDevice_Slaves()
     * @model containment="true"
     * @generated
     */
    EList<ModbusSlave> getSlaves ();

    /**
     * Returns the value of the '<em><b>Type System</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type System</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type System</em>' reference.
     * @see #setTypeSystem(TypeSystem)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusDevice_TypeSystem()
     * @model required="true"
     * @generated
     */
    TypeSystem getTypeSystem ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getTypeSystem <em>Type System</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type System</em>' reference.
     * @see #getTypeSystem()
     * @generated
     */
    void setTypeSystem ( TypeSystem value );

    /**
     * Returns the value of the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Port</em>' attribute.
     * @see #setPort(short)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusDevice_Port()
     * @model required="true"
     * @generated
     */
    short getPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getPort <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port</em>' attribute.
     * @see #getPort()
     * @generated
     */
    void setPort ( short value );

    /**
     * Returns the value of the '<em><b>Protocol Type</b></em>' attribute.
     * The default value is <code>"RTU"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.modbus.ProtocolType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol Type</em>' attribute.
     * @see org.eclipse.scada.configuration.modbus.ProtocolType
     * @see #setProtocolType(ProtocolType)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusDevice_ProtocolType()
     * @model default="RTU" required="true"
     * @generated
     */
    ProtocolType getProtocolType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getProtocolType <em>Protocol Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol Type</em>' attribute.
     * @see org.eclipse.scada.configuration.modbus.ProtocolType
     * @see #getProtocolType()
     * @generated
     */
    void setProtocolType ( ProtocolType value );
} // ModbusDevice
