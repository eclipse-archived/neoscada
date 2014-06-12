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
package org.eclipse.scada.configuration.iec60870;

import org.eclipse.emf.common.util.EList;

import org.eclipse.scada.configuration.world.osgi.ApplicationModule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exporter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.Exporter#getDevices <em>Devices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getExporter()
 * @model
 * @generated
 */
public interface Exporter extends ApplicationModule
{
    /**
     * Returns the value of the '<em><b>Devices</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.iec60870.Device}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Devices</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Devices</em>' containment reference list.
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getExporter_Devices()
     * @model containment="true"
     * @generated
     */
    EList<Device> getDevices ();

} // Exporter
