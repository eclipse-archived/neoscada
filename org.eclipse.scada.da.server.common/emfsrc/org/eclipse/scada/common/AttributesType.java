/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.common;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attributes Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.common.AttributesType#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.common.CommonPackage#getAttributesType()
 * @model extendedMetaData="name='AttributesType' kind='elementOnly'"
 * @generated
 */
public interface AttributesType extends EObject
{
    
    /**
     * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.common.AttributeType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attribute</em>' containment reference list.
     * @see org.eclipse.scada.common.CommonPackage#getAttributesType_Attribute()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='attribute'"
     * @generated
     */
    EList<AttributeType> getAttribute ();

} // AttributesType
