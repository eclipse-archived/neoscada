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

import org.eclipse.scada.configuration.world.Credentials;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Equinox Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver#getAccessCredentials <em>Access Credentials</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getAbstractEquinoxDriver()
 * @model abstract="true"
 * @generated
 */
public interface AbstractEquinoxDriver extends Driver, EquinoxBase
{

    /**
     * Returns the value of the '<em><b>Access Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Access Credentials</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Access Credentials</em>' containment reference.
     * @see #setAccessCredentials(Credentials)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getAbstractEquinoxDriver_AccessCredentials()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Credentials getAccessCredentials ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver#getAccessCredentials <em>Access Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Access Credentials</em>' containment reference.
     * @see #getAccessCredentials()
     * @generated
     */
    void setAccessCredentials ( Credentials value );

} // AbstractEquinoxDriver
