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
 * A representation of the model object '<em><b>Variant Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.common.VariantType#getNull <em>Null</em>}</li>
 *   <li>{@link org.eclipse.scada.common.VariantType#getString <em>String</em>}</li>
 *   <li>{@link org.eclipse.scada.common.VariantType#getInt32 <em>Int32</em>}</li>
 *   <li>{@link org.eclipse.scada.common.VariantType#getDouble <em>Double</em>}</li>
 *   <li>{@link org.eclipse.scada.common.VariantType#getBoolean <em>Boolean</em>}</li>
 *   <li>{@link org.eclipse.scada.common.VariantType#getInt64 <em>Int64</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.common.CommonPackage#getVariantType()
 * @model extendedMetaData="name='VariantType' kind='elementOnly'"
 * @generated
 */
public interface VariantType extends EObject
{
    
    /**
     * Returns the value of the '<em><b>Null</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Null</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Null</em>' containment reference.
     * @see #setNull(VariantNullType)
     * @see org.eclipse.scada.common.CommonPackage#getVariantType_Null()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='null'"
     * @generated
     */
    VariantNullType getNull ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.common.VariantType#getNull <em>Null</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Null</em>' containment reference.
     * @see #getNull()
     * @generated
     */
    void setNull ( VariantNullType value );

    /**
     * Returns the value of the '<em><b>String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>String</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>String</em>' attribute.
     * @see #setString(String)
     * @see org.eclipse.scada.common.CommonPackage#getVariantType_String()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='element' name='string'"
     * @generated
     */
    String getString ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.common.VariantType#getString <em>String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>String</em>' attribute.
     * @see #getString()
     * @generated
     */
    void setString ( String value );

    /**
     * Returns the value of the '<em><b>Int32</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Int32</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Int32</em>' containment reference.
     * @see #setInt32(VariantInt32Type)
     * @see org.eclipse.scada.common.CommonPackage#getVariantType_Int32()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='int32'"
     * @generated
     */
    VariantInt32Type getInt32 ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.common.VariantType#getInt32 <em>Int32</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Int32</em>' containment reference.
     * @see #getInt32()
     * @generated
     */
    void setInt32 ( VariantInt32Type value );

    /**
     * Returns the value of the '<em><b>Double</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Double</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Double</em>' containment reference.
     * @see #setDouble(VariantDoubleType)
     * @see org.eclipse.scada.common.CommonPackage#getVariantType_Double()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='double'"
     * @generated
     */
    VariantDoubleType getDouble ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.common.VariantType#getDouble <em>Double</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Double</em>' containment reference.
     * @see #getDouble()
     * @generated
     */
    void setDouble ( VariantDoubleType value );

    /**
     * Returns the value of the '<em><b>Boolean</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Boolean</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Boolean</em>' containment reference.
     * @see #setBoolean(VariantBooleanType)
     * @see org.eclipse.scada.common.CommonPackage#getVariantType_Boolean()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='boolean'"
     * @generated
     */
    VariantBooleanType getBoolean ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.common.VariantType#getBoolean <em>Boolean</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Boolean</em>' containment reference.
     * @see #getBoolean()
     * @generated
     */
    void setBoolean ( VariantBooleanType value );

    /**
     * Returns the value of the '<em><b>Int64</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Int64</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Int64</em>' containment reference.
     * @see #setInt64(VariantInt64Type)
     * @see org.eclipse.scada.common.CommonPackage#getVariantType_Int64()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='int64'"
     * @generated
     */
    VariantInt64Type getInt64 ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.common.VariantType#getInt64 <em>Int64</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Int64</em>' containment reference.
     * @see #getInt64()
     * @generated
     */
    void setInt64 ( VariantInt64Type value );

} // VariantType
