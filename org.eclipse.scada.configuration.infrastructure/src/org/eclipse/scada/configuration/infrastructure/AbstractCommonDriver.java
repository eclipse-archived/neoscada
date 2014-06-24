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
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.scada.configuration.world.PasswordCredentials;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Common Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver#getPortNumber <em>Port Number</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getAbstractCommonDriver()
 * @model abstract="true"
 * @generated
 */
public interface AbstractCommonDriver extends Driver
{
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
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getAbstractCommonDriver_PortNumber()
     * @model required="true"
     * @generated
     */
    short getPortNumber ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver#getPortNumber <em>Port Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port Number</em>' attribute.
     * @see #getPortNumber()
     * @generated
     */
    void setPortNumber ( short value );

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
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getAbstractCommonDriver_Password()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    PasswordCredentials getPassword ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver#getPassword <em>Password</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password</em>' containment reference.
     * @see #getPassword()
     * @generated
     */
    void setPassword ( PasswordCredentials value );

} // AbstractCommonDriver
