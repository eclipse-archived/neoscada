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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slave</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusSlave#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusSlave#getUnitAddress <em>Unit Address</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusSlave#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusSlave#getDataOrder <em>Data Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusSlave()
 * @model
 * @generated
 */
public interface ModbusSlave extends EObject
{
    /**
     * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.modbus.ModbusBlock}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Blocks</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Blocks</em>' containment reference list.
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusSlave_Blocks()
     * @model containment="true"
     * @generated
     */
    EList<ModbusBlock> getBlocks ();

    /**
     * Returns the value of the '<em><b>Unit Address</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Unit Address</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Unit Address</em>' attribute.
     * @see #setUnitAddress(byte)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusSlave_UnitAddress()
     * @model dataType="org.eclipse.emf.ecore.xml.type.Byte" required="true"
     * @generated
     */
    byte getUnitAddress ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusSlave#getUnitAddress <em>Unit Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Unit Address</em>' attribute.
     * @see #getUnitAddress()
     * @generated
     */
    void setUnitAddress ( byte value );

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusSlave_Id()
     * @model required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusSlave#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Data Order</b></em>' attribute.
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
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusSlave_DataOrder()
     * @model required="true"
     * @generated
     */
    ByteOrder getDataOrder ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusSlave#getDataOrder <em>Data Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Order</em>' attribute.
     * @see org.eclipse.scada.configuration.modbus.ByteOrder
     * @see #getDataOrder()
     * @generated
     */
    void setDataOrder ( ByteOrder value );

} // ModbusSlave
