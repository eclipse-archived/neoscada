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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.memory.TypeDefinition;
import org.eclipse.scada.da.server.osgi.modbus.RequestType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getBlockType <em>Block Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getStartAddress <em>Start Address</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusBlock()
 * @model
 * @generated
 */
public interface ModbusBlock extends EObject
{
    /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(TypeDefinition)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusBlock_Type()
     * @model required="true"
     * @generated
     */
    TypeDefinition getType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType ( TypeDefinition value );

    /**
     * Returns the value of the '<em><b>Block Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Block Type</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Block Type</em>' attribute.
     * @see #setBlockType(RequestType)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusBlock_BlockType()
     * @model dataType="org.eclipse.scada.configuration.modbus.RequestType" required="true"
     * @generated
     */
    RequestType getBlockType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getBlockType <em>Block Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Block Type</em>' attribute.
     * @see #getBlockType()
     * @generated
     */
    void setBlockType ( RequestType value );

    /**
     * Returns the value of the '<em><b>Start Address</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start Address</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start Address</em>' attribute.
     * @see #setStartAddress(int)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusBlock_StartAddress()
     * @model required="true"
     * @generated
     */
    int getStartAddress ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getStartAddress <em>Start Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start Address</em>' attribute.
     * @see #getStartAddress()
     * @generated
     */
    void setStartAddress ( int value );

    /**
     * Returns the value of the '<em><b>Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Count</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The number of registers to read.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Count</em>' attribute.
     * @see #setCount(int)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusBlock_Count()
     * @model required="true"
     * @generated
     */
    int getCount ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getCount <em>Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Count</em>' attribute.
     * @see #getCount()
     * @generated
     */
    void setCount ( int value );

    /**
     * Returns the value of the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Period</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Period</em>' attribute.
     * @see #setPeriod(long)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusBlock_Period()
     * @model required="true"
     * @generated
     */
    long getPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getPeriod <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Period</em>' attribute.
     * @see #getPeriod()
     * @generated
     */
    void setPeriod ( long value );

    /**
     * Returns the value of the '<em><b>Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timeout</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timeout</em>' attribute.
     * @see #setTimeout(long)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusBlock_Timeout()
     * @model required="true"
     * @generated
     */
    long getTimeout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getTimeout <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timeout</em>' attribute.
     * @see #getTimeout()
     * @generated
     */
    void setTimeout ( long value );

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
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusBlock_Id()
     * @model required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

} // ModbusBlock
