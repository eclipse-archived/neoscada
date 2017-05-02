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
package org.eclipse.scada.configuration.component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Output Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.ComponentReferenceOutputDefinition#getComponent <em>Component</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getComponentReferenceOutputDefinition()
 * @model
 * @generated
 */
public interface ComponentReferenceOutputDefinition extends OutputDefinition
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
     * @see #setComponent(Component)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getComponentReferenceOutputDefinition_Component()
     * @model required="true"
     * @generated
     */
    Component getComponent ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.ComponentReferenceOutputDefinition#getComponent <em>Component</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Component</em>' reference.
     * @see #getComponent()
     * @generated
     */
    void setComponent ( Component value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='        final org.eclipse.scada.configuration.component.ComponentDanglingReference danglingRef = org.eclipse.scada.configuration.component.ComponentFactory.eINSTANCE.createComponentDanglingReference ();\n        danglingRef.getLocalTag ().addAll ( getLocalTag () );\n        danglingRef.setComponent ( getComponent () );\n        return danglingRef;'"
     * @generated
     */
    DanglingItemReference createReference ();

} // ComponentReferenceOutputDefinition
