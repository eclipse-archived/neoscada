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

import org.eclipse.scada.configuration.world.PasswordCredentials;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Common Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A driver definition which creates a driver instance by using driver factories and a type id.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.CommonDriver#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.CommonDriver#getPortNumber <em>Port Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getCommonDriver()
 * @model
 * @generated
 */
public interface CommonDriver extends AbstractFactoryDriver
{
    /**
     * Returns the value of the '<em><b>Password</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Password</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Password</em>' containment reference.
     * @see #setPassword(PasswordCredentials)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getCommonDriver_Password()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    PasswordCredentials getPassword ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.CommonDriver#getPassword <em>Password</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password</em>' containment reference.
     * @see #getPassword()
     * @generated
     */
    void setPassword ( PasswordCredentials value );

    /**
     * Returns the value of the '<em><b>Port Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Port Number</em>' attribute.
     * @see #setPortNumber(short)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getCommonDriver_PortNumber()
     * @model required="true"
     * @generated
     */
    short getPortNumber ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.CommonDriver#getPortNumber <em>Port Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port Number</em>' attribute.
     * @see #getPortNumber()
     * @generated
     */
    void setPortNumber ( short value );

} // CommonDriver
