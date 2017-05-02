/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Admin File Backend</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.ConfigurationAdminFileBackend#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getConfigurationAdminFileBackend()
 * @model annotation="http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup scada.ca.backend=''"
 * @generated
 */
public interface ConfigurationAdminFileBackend extends EquinoxModule
{
    /**
     * Returns the value of the '<em><b>Path</b></em>' attribute.
     * The default value is <code>"${user.home}/.eclipse.scada/ca.#{name}"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Path</em>' attribute.
     * @see #setPath(String)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getConfigurationAdminFileBackend_Path()
     * @model default="${user.home}/.eclipse.scada/ca.#{name}" required="true"
     * @generated
     */
    String getPath ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.ConfigurationAdminFileBackend#getPath <em>Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Path</em>' attribute.
     * @see #getPath()
     * @generated
     */
    void setPath ( String value );

} // ConfigurationAdminFileBackend
