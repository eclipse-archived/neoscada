/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.modbus;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.osgi.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exporter Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getSlaveId <em>Slave Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getDataOrder <em>Data Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterDevice()
 * @model
 * @generated
 */
public interface ModbusExporterDevice extends EObject
{
    /**
     * Returns the value of the '<em><b>Items</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.modbus.ModbusExporterItem}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Items</em>' containment reference list.
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterDevice_Items()
     * @model containment="true"
     * @generated
     */
    EList<ModbusExporterItem> getItems ();

    /**
     * Returns the value of the '<em><b>Port</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Port</em>' reference.
     * @see #setPort(Endpoint)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterDevice_Port()
     * @model required="true"
     * @generated
     */
    Endpoint getPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getPort <em>Port</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port</em>' reference.
     * @see #getPort()
     * @generated
     */
    void setPort ( Endpoint value );

    /**
     * Returns the value of the '<em><b>Slave Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Slave Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Slave Id</em>' attribute.
     * @see #setSlaveId(int)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterDevice_SlaveId()
     * @model required="true"
     * @generated
     */
    int getSlaveId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getSlaveId <em>Slave Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Slave Id</em>' attribute.
     * @see #getSlaveId()
     * @generated
     */
    void setSlaveId ( int value );

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterDevice_Properties()
     * @model containment="true"
     * @generated
     */
    EList<PropertyEntry> getProperties ();

    /**
     * Returns the value of the '<em><b>Data Order</b></em>' attribute.
     * The default value is <code>"BIG_ENDIAN"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.modbus.ByteOrder}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Order</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Order</em>' attribute.
     * @see org.eclipse.scada.configuration.modbus.ByteOrder
     * @see #setDataOrder(ByteOrder)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterDevice_DataOrder()
     * @model default="BIG_ENDIAN" required="true"
     * @generated
     */
    ByteOrder getDataOrder ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getDataOrder <em>Data Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Order</em>' attribute.
     * @see org.eclipse.scada.configuration.modbus.ByteOrder
     * @see #getDataOrder()
     * @generated
     */
    void setDataOrder ( ByteOrder value );

} // ModbusExporterDevice
