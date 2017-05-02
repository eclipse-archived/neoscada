/**
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.neoscada.configuration.iec60870;

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
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.IEC60870Driver#getDevices <em>Devices</em>}</li>
 * </ul>
 *
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getIEC60870Driver()
 * @model
 * @generated
 */
public interface IEC60870Driver extends AbstractEquinoxDriver
{
    /**
     * Returns the value of the '<em><b>Devices</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.neoscada.configuration.iec60870.IEC60870Device}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Devices</em>' containment reference list isn't
     * clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Devices</em>' reference list.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getIEC60870Driver_Devices()
     * @model
     * @generated
     */
    EList<IEC60870Device> getDevices ();

} // IEC60870Driver
