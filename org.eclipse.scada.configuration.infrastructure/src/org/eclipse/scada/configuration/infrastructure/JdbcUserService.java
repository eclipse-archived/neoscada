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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jdbc User Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.JdbcUserService#getImplementation <em>Implementation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getJdbcUserService()
 * @model
 * @generated
 */
public interface JdbcUserService extends UserService
{
    /**
     * Returns the value of the '<em><b>Implementation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Implementation</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Implementation</em>' containment reference.
     * @see #setImplementation(org.eclipse.scada.configuration.world.osgi.JdbcUserService)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getJdbcUserService_Implementation()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    org.eclipse.scada.configuration.world.osgi.JdbcUserService getImplementation ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.JdbcUserService#getImplementation <em>Implementation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Implementation</em>' containment reference.
     * @see #getImplementation()
     * @generated
     */
    void setImplementation ( org.eclipse.scada.configuration.world.osgi.JdbcUserService value );

} // JdbcUserService
