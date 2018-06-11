/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.neoscada.configuration.iec62541;

import org.eclipse.emf.common.util.EList;

import org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec62541.IEC62541Driver#getDevices <em>Devices</em>}</li>
 * </ul>
 *
 * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Package#getIEC62541Driver()
 * @model
 * @generated
 */
public interface IEC62541Driver extends AbstractEquinoxDriver
{
    /**
     * Returns the value of the '<em><b>Devices</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.neoscada.configuration.iec62541.IEC62541Device}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Devices</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Devices</em>' reference list.
     * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Package#getIEC62541Driver_Devices()
     * @model
     * @generated
     */
    EList<IEC62541Device> getDevices ();

} // IEC62541Driver
