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
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusDriver#getMasters <em>Masters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusDriver()
 * @model
 * @generated
 */
public interface ModbusDriver extends Driver, EquinoxApplication
{
    /**
     * Returns the value of the '<em><b>Masters</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.modbus.ModbusMaster}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Masters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Masters</em>' containment reference list.
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusDriver_Masters()
     * @model containment="true"
     * @generated
     */
    EList<ModbusMaster> getMasters ();

} // ModbusDriver
