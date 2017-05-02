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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusDataType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusDataType#getScale <em>Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusDataType()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ModbusDataType extends EObject
{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusDataType_Name()
     * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getName ();

    /**
     * Returns the value of the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Scale</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Scale</em>' attribute.
     * @see #setScale(Double)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusDataType_Scale()
     * @model
     * @generated
     */
    Double getScale ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusDataType#getScale <em>Scale</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Scale</em>' attribute.
     * @see #getScale()
     * @generated
     */
    void setScale ( Double value );

} // ModbusDataType
