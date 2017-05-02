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
 *   <li>{@link org.eclipse.scada.configuration.arduino.ArduinoDriver#getArduinoConnections <em>Arduino Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.arduino.ArduinoPackage#getArduinoDriver()
 * @model
 * @generated
 */
public interface ArduinoDriver extends Driver, EquinoxApplication
{
    /**
     * Returns the value of the '<em><b>Arduino Connections</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.arduino.ArduinoConnection}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Arduino Connections</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Arduino Connections</em>' containment reference list.
     * @see org.eclipse.scada.configuration.arduino.ArduinoPackage#getArduinoDriver_ArduinoConnections()
     * @model containment="true"
     * @generated
     */
    EList<ArduinoConnection> getArduinoConnections ();

} // ArduinoDriver
