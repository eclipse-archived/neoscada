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
import org.eclipse.scada.configuration.infrastructure.Settings;
import org.eclipse.scada.configuration.world.osgi.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exporter Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterModule#getDataOrder <em>Data Order</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterModule#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterModule()
 * @model
 * @generated
 */
public interface ModbusExporterModule extends Settings
{
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
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterModule_DataOrder()
     * @model required="true"
     * @generated
     */
    ByteOrder getDataOrder ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusExporterModule#getDataOrder <em>Data Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Order</em>' attribute.
     * @see org.eclipse.scada.configuration.modbus.ByteOrder
     * @see #getDataOrder()
     * @generated
     */
    void setDataOrder ( ByteOrder value );

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
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterModule_Properties()
     * @model containment="true"
     * @generated
     */
    EList<PropertyEntry> getProperties ();

} // ModbusExporterModule
