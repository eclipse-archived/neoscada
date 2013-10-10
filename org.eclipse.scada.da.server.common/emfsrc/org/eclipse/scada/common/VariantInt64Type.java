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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variant Int64 Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.common.VariantInt64Type#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.common.CommonPackage#getVariantInt64Type()
 * @model extendedMetaData="name='VariantInt64Type' kind='simple'"
 * @generated
 */
public interface VariantInt64Type extends EObject
{
    
    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #isSetValue()
     * @see #unsetValue()
     * @see #setValue(long)
     * @see org.eclipse.scada.common.CommonPackage#getVariantInt64Type_Value()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
     *        extendedMetaData="name=':0' kind='simple'"
     * @generated
     */
    long getValue ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.common.VariantInt64Type#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #isSetValue()
     * @see #unsetValue()
     * @see #getValue()
     * @generated
     */
    void setValue ( long value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.common.VariantInt64Type#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetValue()
     * @see #getValue()
     * @see #setValue(long)
     * @generated
     */
    void unsetValue ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.common.VariantInt64Type#getValue <em>Value</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Value</em>' attribute is set.
     * @see #unsetValue()
     * @see #getValue()
     * @see #setValue(long)
     * @generated
     */
    boolean isSetValue ();

} // VariantInt64Type
