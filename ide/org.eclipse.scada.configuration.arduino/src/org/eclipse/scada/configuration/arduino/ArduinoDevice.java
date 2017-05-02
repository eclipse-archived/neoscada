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
package org.eclipse.scada.configuration.arduino;

import org.eclipse.scada.configuration.infrastructure.Device;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.arduino.ArduinoDevice#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.arduino.ArduinoPackage#getArduinoDevice()
 * @model
 * @generated
 */
public interface ArduinoDevice extends Device
{
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
     * @see org.eclipse.scada.configuration.arduino.ArduinoPackage#getArduinoDevice_Port()
     * @model required="true"
     * @generated
     */
    short getPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.arduino.ArduinoDevice#getPort <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port</em>' attribute.
     * @see #getPort()
     * @generated
     */
    void setPort ( short value );

} // ArduinoDevice
