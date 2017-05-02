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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.osgi.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.OutputSpecification#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.OutputSpecification#getDataType <em>Data Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getOutputSpecification()
 * @model
 * @generated
 */
public interface OutputSpecification extends EObject
{
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
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getOutputSpecification_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.OutputSpecification#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Data Type</b></em>' attribute.
     * The default value is <code>"VARIANT"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.osgi.DataType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.DataType
     * @see #setDataType(DataType)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getOutputSpecification_DataType()
     * @model default="VARIANT" required="true"
     * @generated
     */
    DataType getDataType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.OutputSpecification#getDataType <em>Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.DataType
     * @see #getDataType()
     * @generated
     */
    void setDataType ( DataType value );

} // OutputSpecification
