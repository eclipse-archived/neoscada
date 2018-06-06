/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.Child#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Child#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getChild()
 * @model
 * @generated
 */
public interface Child extends EObject
{
    /**
     * Returns the value of the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Element</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Element</em>' containment reference.
     * @see #setElement(Primitive)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getChild_Element()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='element'"
     * @generated
     */
    Primitive getElement ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Child#getElement <em>Element</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Element</em>' containment reference.
     * @see #getElement()
     * @generated
     */
    void setElement ( Primitive value );

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getChild_Name()
     * @model
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Child#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

} // Child
