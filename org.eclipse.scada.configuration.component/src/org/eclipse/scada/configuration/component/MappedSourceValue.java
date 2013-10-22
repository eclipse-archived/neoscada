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

import org.eclipse.scada.configuration.world.Documentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapped Source Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.MappedSourceValue#getMapper <em>Mapper</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.MappedSourceValue#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getMappedSourceValue()
 * @model
 * @generated
 */
public interface MappedSourceValue extends DataComponent, Documentable
{
    /**
     * Returns the value of the '<em><b>Mapper</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapper</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapper</em>' reference.
     * @see #setMapper(DataMapperService)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getMappedSourceValue_Mapper()
     * @model required="true"
     * @generated
     */
    DataMapperService getMapper ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.MappedSourceValue#getMapper <em>Mapper</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mapper</em>' reference.
     * @see #getMapper()
     * @generated
     */
    void setMapper ( DataMapperService value );

    /**
     * Returns the value of the '<em><b>Input</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input</em>' containment reference.
     * @see #setInput(InputDefinition)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getMappedSourceValue_Input()
     * @model containment="true" required="true"
     * @generated
     */
    InputDefinition getInput ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.MappedSourceValue#getInput <em>Input</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input</em>' containment reference.
     * @see #getInput()
     * @generated
     */
    void setInput ( InputDefinition value );

} // MappedSourceValue
