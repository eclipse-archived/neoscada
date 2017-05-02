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
package org.eclipse.scada.configuration.dave;

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
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveDriver#getDevices <em>Devices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveDriver()
 * @model
 * @generated
 */
public interface DaveDriver extends Driver, EquinoxApplication
{

    /**
     * Returns the value of the '<em><b>Devices</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Devices</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Devices</em>' reference list.
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveDriver_Devices()
     * @model
     * @generated
     */
    EList<DaveCommunicationProcessor> getDevices ();
} // DaveDriver
