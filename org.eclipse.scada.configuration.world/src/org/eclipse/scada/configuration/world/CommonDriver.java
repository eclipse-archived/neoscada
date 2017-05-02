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
package org.eclipse.scada.configuration.world;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Common Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.CommonDriver#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.CommonDriver#getEndpoints <em>Endpoints</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.WorldPackage#getCommonDriver()
 * @model abstract="true"
 * @generated
 */
public interface CommonDriver extends Driver
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
     * @see org.eclipse.scada.configuration.world.WorldPackage#getCommonDriver_Password()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    PasswordCredentials getPassword ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.CommonDriver#getPassword <em>Password</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password</em>' containment reference.
     * @see #getPassword()
     * @generated
     */
    void setPassword ( PasswordCredentials value );

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.Endpoint}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' reference list.
     * @see org.eclipse.scada.configuration.world.WorldPackage#getCommonDriver_Endpoints()
     * @model keys="portNumber"
     * @generated
     */
    EList<Endpoint> getEndpoints ();

} // CommonDriver
