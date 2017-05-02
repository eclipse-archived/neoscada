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
package org.eclipse.scada.configuration.driver.jdbc;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.UpdateMapping#getNamedParameter <em>Named Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getUpdateMapping()
 * @model
 * @generated
 */
public interface UpdateMapping extends EObject
{
    /**
     * Returns the value of the '<em><b>Named Parameter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Named Parameter</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Named Parameter</em>' attribute.
     * @see #setNamedParameter(String)
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getUpdateMapping_NamedParameter()
     * @model required="true"
     * @generated
     */
    String getNamedParameter ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.UpdateMapping#getNamedParameter <em>Named Parameter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Named Parameter</em>' attribute.
     * @see #getNamedParameter()
     * @generated
     */
    void setNamedParameter ( String value );

} // UpdateMapping
