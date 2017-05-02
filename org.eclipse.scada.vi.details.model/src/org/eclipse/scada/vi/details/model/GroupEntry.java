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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.GroupEntry#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.GroupEntry#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.GroupEntry#getPermission <em>Permission</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.GroupEntry#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGroupEntry()
 * @model
 * @generated
 */
public interface GroupEntry extends EObject
{
    /**
     * Returns the value of the '<em><b>Component</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Component</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Component</em>' containment reference.
     * @see #setComponent(Component)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGroupEntry_Component()
     * @model containment="true" required="true"
     * @generated
     */
    Component getComponent ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.GroupEntry#getComponent <em>Component</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Component</em>' containment reference.
     * @see #getComponent()
     * @generated
     */
    void setComponent ( Component value );

    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGroupEntry_Label()
     * @model
     * @generated
     */
    String getLabel ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.GroupEntry#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel ( String value );

    /**
     * Returns the value of the '<em><b>Permission</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Permission</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Permission</em>' attribute.
     * @see #setPermission(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGroupEntry_Permission()
     * @model
     * @generated
     */
    String getPermission ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.GroupEntry#getPermission <em>Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Permission</em>' attribute.
     * @see #getPermission()
     * @generated
     */
    void setPermission ( String value );

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visibility</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visibility</em>' containment reference.
     * @see #setVisibility(Visibility)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGroupEntry_Visibility()
     * @model containment="true"
     * @generated
     */
    Visibility getVisibility ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.GroupEntry#getVisibility <em>Visibility</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' containment reference.
     * @see #getVisibility()
     * @generated
     */
    void setVisibility ( Visibility value );

} // GroupEntry
