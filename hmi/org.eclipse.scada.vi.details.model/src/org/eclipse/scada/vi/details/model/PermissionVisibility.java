/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permission Visibility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.PermissionVisibility#getRequiredPermission <em>Required Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getPermissionVisibility()
 * @model
 * @generated
 */
public interface PermissionVisibility extends Visibility
{
    /**
     * Returns the value of the '<em><b>Required Permission</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Permission</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Required Permission</em>' attribute.
     * @see #setRequiredPermission(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getPermissionVisibility_RequiredPermission()
     * @model required="true"
     * @generated
     */
    String getRequiredPermission ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.PermissionVisibility#getRequiredPermission <em>Required Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Required Permission</em>' attribute.
     * @see #getRequiredPermission()
     * @generated
     */
    void setRequiredPermission ( String value );

} // PermissionVisibility
