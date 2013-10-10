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
package org.eclipse.scada.da.exec.configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.FieldType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.FieldType#getVariantType <em>Variant Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getFieldType()
 * @model extendedMetaData="name='FieldType' kind='empty'"
 * @generated
 */
public interface FieldType extends EObject
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
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getFieldType_Name()
     * @model dataType="org.eclipse.scada.da.exec.configuration.NameType"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.FieldType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Variant Type</b></em>' attribute.
     * The default value is <code>"STRING"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.da.exec.configuration.VariantTypeType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Variant Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Variant Type</em>' attribute.
     * @see org.eclipse.scada.da.exec.configuration.VariantTypeType
     * @see #isSetVariantType()
     * @see #unsetVariantType()
     * @see #setVariantType(VariantTypeType)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getFieldType_VariantType()
     * @model default="STRING" unsettable="true"
     *        extendedMetaData="kind='attribute' name='variantType'"
     * @generated
     */
    VariantTypeType getVariantType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.FieldType#getVariantType <em>Variant Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Variant Type</em>' attribute.
     * @see org.eclipse.scada.da.exec.configuration.VariantTypeType
     * @see #isSetVariantType()
     * @see #unsetVariantType()
     * @see #getVariantType()
     * @generated
     */
    void setVariantType ( VariantTypeType value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.da.exec.configuration.FieldType#getVariantType <em>Variant Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetVariantType()
     * @see #getVariantType()
     * @see #setVariantType(VariantTypeType)
     * @generated
     */
    void unsetVariantType ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.da.exec.configuration.FieldType#getVariantType <em>Variant Type</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Variant Type</em>' attribute is set.
     * @see #unsetVariantType()
     * @see #getVariantType()
     * @see #setVariantType(VariantTypeType)
     * @generated
     */
    boolean isSetVariantType ();

} // FieldType
