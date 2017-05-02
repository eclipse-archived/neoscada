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
import org.eclipse.scada.configuration.world.Endpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Master</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getSlaves <em>Slaves</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getProtocolType <em>Protocol Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getInterFrameDelay <em>Inter Frame Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusMaster()
 * @model
 * @generated
 */
public interface ModbusMaster extends EObject
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
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusMaster_Slaves()
     * @model containment="true"
     * @generated
     */
    EList<ModbusSlave> getSlaves ();

    /**
     * Returns the value of the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint</em>' reference.
     * @see #setEndpoint(Endpoint)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusMaster_Endpoint()
     * @model required="true"
     * @generated
     */
    Endpoint getEndpoint ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getEndpoint <em>Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint</em>' reference.
     * @see #getEndpoint()
     * @generated
     */
    void setEndpoint ( Endpoint value );

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
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusMaster_Id()
     * @model required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Protocol Type</b></em>' attribute.
     * The default value is <code>"TCP"</code>.
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
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusMaster_ProtocolType()
     * @model default="TCP" required="true"
     * @generated
     */
    ProtocolType getProtocolType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getProtocolType <em>Protocol Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol Type</em>' attribute.
     * @see org.eclipse.scada.configuration.modbus.ProtocolType
     * @see #getProtocolType()
     * @generated
     */
    void setProtocolType ( ProtocolType value );

    /**
     * Returns the value of the '<em><b>Inter Frame Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inter Frame Delay</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inter Frame Delay</em>' attribute.
     * @see #setInterFrameDelay(Double)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusMaster_InterFrameDelay()
     * @model dataType="org.eclipse.emf.ecore.xml.type.DoubleObject"
     * @generated
     */
    Double getInterFrameDelay ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getInterFrameDelay <em>Inter Frame Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inter Frame Delay</em>' attribute.
     * @see #getInterFrameDelay()
     * @generated
     */
    void setInterFrameDelay ( Double value );

} // ModbusMaster
