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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Web Admin Console</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.WebAdminConsole#getHttpService <em>Http Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWebAdminConsole()
 * @model
 * @generated
 */
public interface WebAdminConsole extends Module
{

    /**
     * Returns the value of the '<em><b>Http Service</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Http Service</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Http Service</em>' reference.
     * @see #setHttpService(HttpServiceModule)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWebAdminConsole_HttpService()
     * @model required="true"
     * @generated
     */
    HttpServiceModule getHttpService ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.WebAdminConsole#getHttpService <em>Http Service</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Http Service</em>' reference.
     * @see #getHttpService()
     * @generated
     */
    void setHttpService ( HttpServiceModule value );
} // WebAdminConsole
