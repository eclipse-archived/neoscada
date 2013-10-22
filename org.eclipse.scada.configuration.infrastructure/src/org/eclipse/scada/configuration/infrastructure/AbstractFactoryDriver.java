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
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Factory Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver#getDriverTypeId <em>Driver Type Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver#getDevices <em>Devices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getAbstractFactoryDriver()
 * @model abstract="true"
 * @generated
 */
public interface AbstractFactoryDriver extends Driver
{
    /**
     * Returns the value of the '<em><b>Driver Type Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Driver Type Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Driver Type Id</em>' attribute.
     * @see #setDriverTypeId(String)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getAbstractFactoryDriver_DriverTypeId()
     * @model required="true"
     * @generated
     */
    String getDriverTypeId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver#getDriverTypeId <em>Driver Type Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Driver Type Id</em>' attribute.
     * @see #getDriverTypeId()
     * @generated
     */
    void setDriverTypeId ( String value );

    /**
     * Returns the value of the '<em><b>Devices</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.Device}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Devices</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Devices</em>' reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getAbstractFactoryDriver_Devices()
     * @model
     * @generated
     */
    EList<Device> getDevices ();

} // AbstractFactoryDriver
