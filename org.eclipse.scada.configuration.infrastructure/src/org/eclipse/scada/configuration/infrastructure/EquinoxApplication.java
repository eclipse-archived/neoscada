/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.scada.configuration.world.Credentials;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equinox Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getLocalCredentials
 * <em>Local Credentials</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxApplication()
 * @model abstract="true"
 * @generated
 */
public interface EquinoxApplication extends EquinoxBase
{
    /**
     * Returns the value of the '<em><b>Local Credentials</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Credentials</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Local Credentials</em>' reference.
     * @see #setLocalCredentials(Credentials)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxApplication_LocalCredentials()
     * @model
     * @generated
     */
    Credentials getLocalCredentials ();

    /**
     * Sets the value of the '
     * {@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getLocalCredentials
     * <em>Local Credentials</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Local Credentials</em>' reference.
     * @see #getLocalCredentials()
     * @generated
     */
    void setLocalCredentials ( Credentials value );

} // EquinoxApplication
