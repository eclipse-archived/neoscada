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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Input Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition#getLocalTag <em>Local Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getComponentReferenceInputDefinition()
 * @model
 * @generated
 */
public interface ComponentReferenceInputDefinition extends InputDefinition
{
    /**
     * Returns the value of the '<em><b>Component</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Component</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Component</em>' reference.
     * @see #setComponent(DataComponent)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getComponentReferenceInputDefinition_Component()
     * @model required="true"
     * @generated
     */
    DataComponent getComponent ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition#getComponent <em>Component</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Component</em>' reference.
     * @see #getComponent()
     * @generated
     */
    void setComponent ( DataComponent value );

    /**
     * Returns the value of the '<em><b>Local Tag</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Tag</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Tag</em>' attribute list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getComponentReferenceInputDefinition_LocalTag()
     * @model required="true"
     * @generated
     */
    EList<String> getLocalTag ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final org.eclipse.scada.configuration.component.ComponentDanglingReference danglingRef = org.eclipse.scada.configuration.component.ComponentFactory.eINSTANCE.createComponentDanglingReference ();\ndanglingRef.getLocalTag ().addAll ( getLocalTag () );\ndanglingRef.setComponent ( getComponent () );\nreturn danglingRef;'"
     * @generated
     */
    DanglingItemReference createReference ();

} // ComponentReferenceInputDefinition
