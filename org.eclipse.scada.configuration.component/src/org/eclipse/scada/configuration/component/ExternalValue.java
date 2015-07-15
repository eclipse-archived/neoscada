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
package org.eclipse.scada.configuration.component;

import org.eclipse.scada.configuration.infrastructure.Driver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.ExternalValue#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.ExternalValue#getSourceName <em>Source Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getExternalValue()
 * @model
 * @generated
 */
public interface ExternalValue extends SingleValue
{
    /**
     * Returns the value of the '<em><b>Connection</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection</em>' reference.
     * @see #setConnection(Driver)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getExternalValue_Connection()
     * @model required="true"
     * @generated
     */
    Driver getConnection ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.ExternalValue#getConnection <em>Connection</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection</em>' reference.
     * @see #getConnection()
     * @generated
     */
    void setConnection ( Driver value );

    /**
     * Returns the value of the '<em><b>Source Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Name</em>' attribute.
     * @see #setSourceName(String)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getExternalValue_SourceName()
     * @model required="true"
     * @generated
     */
    String getSourceName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.ExternalValue#getSourceName <em>Source Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Name</em>' attribute.
     * @see #getSourceName()
     * @generated
     */
    void setSourceName ( String value );

} // ExternalValue
