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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage
{
    
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "common";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://openscada.org/Common";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "common";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CommonPackage eINSTANCE = org.eclipse.scada.common.impl.CommonPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.common.impl.AttributesTypeImpl <em>Attributes Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.common.impl.AttributesTypeImpl
     * @see org.eclipse.scada.common.impl.CommonPackageImpl#getAttributesType()
     * @generated
     */
    int ATTRIBUTES_TYPE = 0;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTES_TYPE__ATTRIBUTE = 0;

    /**
     * The number of structural features of the '<em>Attributes Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTES_TYPE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Attributes Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTES_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.common.impl.VariantTypeImpl <em>Variant Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.common.impl.VariantTypeImpl
     * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantType()
     * @generated
     */
    int VARIANT_TYPE = 7;

    /**
     * The feature id for the '<em><b>Null</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_TYPE__NULL = 0;

    /**
     * The feature id for the '<em><b>String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_TYPE__STRING = 1;

    /**
     * The feature id for the '<em><b>Int32</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_TYPE__INT32 = 2;

    /**
     * The feature id for the '<em><b>Double</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_TYPE__DOUBLE = 3;

    /**
     * The feature id for the '<em><b>Boolean</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_TYPE__BOOLEAN = 4;

    /**
     * The feature id for the '<em><b>Int64</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_TYPE__INT64 = 5;

    /**
     * The number of structural features of the '<em>Variant Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_TYPE_FEATURE_COUNT = 6;

    /**
     * The number of operations of the '<em>Variant Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.common.impl.AttributeTypeImpl <em>Attribute Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.common.impl.AttributeTypeImpl
     * @see org.eclipse.scada.common.impl.CommonPackageImpl#getAttributeType()
     * @generated
     */
    int ATTRIBUTE_TYPE = 1;

    /**
     * The feature id for the '<em><b>Null</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TYPE__NULL = VARIANT_TYPE__NULL;

    /**
     * The feature id for the '<em><b>String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TYPE__STRING = VARIANT_TYPE__STRING;

    /**
     * The feature id for the '<em><b>Int32</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TYPE__INT32 = VARIANT_TYPE__INT32;

    /**
     * The feature id for the '<em><b>Double</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TYPE__DOUBLE = VARIANT_TYPE__DOUBLE;

    /**
     * The feature id for the '<em><b>Boolean</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TYPE__BOOLEAN = VARIANT_TYPE__BOOLEAN;

    /**
     * The feature id for the '<em><b>Int64</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TYPE__INT64 = VARIANT_TYPE__INT64;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TYPE__NAME = VARIANT_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attribute Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TYPE_FEATURE_COUNT = VARIANT_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Attribute Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_TYPE_OPERATION_COUNT = VARIANT_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.common.impl.VariantBooleanTypeImpl <em>Variant Boolean Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.common.impl.VariantBooleanTypeImpl
     * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantBooleanType()
     * @generated
     */
    int VARIANT_BOOLEAN_TYPE = 2;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_BOOLEAN_TYPE__VALUE = 0;

    /**
     * The number of structural features of the '<em>Variant Boolean Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_BOOLEAN_TYPE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Variant Boolean Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_BOOLEAN_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.common.impl.VariantDoubleTypeImpl <em>Variant Double Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.common.impl.VariantDoubleTypeImpl
     * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantDoubleType()
     * @generated
     */
    int VARIANT_DOUBLE_TYPE = 3;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_DOUBLE_TYPE__VALUE = 0;

    /**
     * The number of structural features of the '<em>Variant Double Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_DOUBLE_TYPE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Variant Double Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_DOUBLE_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.common.impl.VariantInt32TypeImpl <em>Variant Int32 Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.common.impl.VariantInt32TypeImpl
     * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantInt32Type()
     * @generated
     */
    int VARIANT_INT32_TYPE = 4;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_INT32_TYPE__VALUE = 0;

    /**
     * The number of structural features of the '<em>Variant Int32 Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_INT32_TYPE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Variant Int32 Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_INT32_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.common.impl.VariantInt64TypeImpl <em>Variant Int64 Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.common.impl.VariantInt64TypeImpl
     * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantInt64Type()
     * @generated
     */
    int VARIANT_INT64_TYPE = 5;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_INT64_TYPE__VALUE = 0;

    /**
     * The number of structural features of the '<em>Variant Int64 Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_INT64_TYPE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Variant Int64 Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_INT64_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.common.impl.VariantNullTypeImpl <em>Variant Null Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.common.impl.VariantNullTypeImpl
     * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantNullType()
     * @generated
     */
    int VARIANT_NULL_TYPE = 6;

    /**
     * The number of structural features of the '<em>Variant Null Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_NULL_TYPE_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Variant Null Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VARIANT_NULL_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '<em>Class Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.eclipse.scada.common.impl.CommonPackageImpl#getClassType()
     * @generated
     */
    int CLASS_TYPE = 8;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.common.AttributesType <em>Attributes Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attributes Type</em>'.
     * @see org.eclipse.scada.common.AttributesType
     * @generated
     */
    EClass getAttributesType ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.common.AttributesType#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Attribute</em>'.
     * @see org.eclipse.scada.common.AttributesType#getAttribute()
     * @see #getAttributesType()
     * @generated
     */
    EReference getAttributesType_Attribute ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.common.AttributeType <em>Attribute Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Type</em>'.
     * @see org.eclipse.scada.common.AttributeType
     * @generated
     */
    EClass getAttributeType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.common.AttributeType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.common.AttributeType#getName()
     * @see #getAttributeType()
     * @generated
     */
    EAttribute getAttributeType_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.common.VariantBooleanType <em>Variant Boolean Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variant Boolean Type</em>'.
     * @see org.eclipse.scada.common.VariantBooleanType
     * @generated
     */
    EClass getVariantBooleanType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.common.VariantBooleanType#isValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.common.VariantBooleanType#isValue()
     * @see #getVariantBooleanType()
     * @generated
     */
    EAttribute getVariantBooleanType_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.common.VariantDoubleType <em>Variant Double Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variant Double Type</em>'.
     * @see org.eclipse.scada.common.VariantDoubleType
     * @generated
     */
    EClass getVariantDoubleType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.common.VariantDoubleType#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.common.VariantDoubleType#getValue()
     * @see #getVariantDoubleType()
     * @generated
     */
    EAttribute getVariantDoubleType_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.common.VariantInt32Type <em>Variant Int32 Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variant Int32 Type</em>'.
     * @see org.eclipse.scada.common.VariantInt32Type
     * @generated
     */
    EClass getVariantInt32Type ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.common.VariantInt32Type#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.common.VariantInt32Type#getValue()
     * @see #getVariantInt32Type()
     * @generated
     */
    EAttribute getVariantInt32Type_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.common.VariantInt64Type <em>Variant Int64 Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variant Int64 Type</em>'.
     * @see org.eclipse.scada.common.VariantInt64Type
     * @generated
     */
    EClass getVariantInt64Type ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.common.VariantInt64Type#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.common.VariantInt64Type#getValue()
     * @see #getVariantInt64Type()
     * @generated
     */
    EAttribute getVariantInt64Type_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.common.VariantNullType <em>Variant Null Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variant Null Type</em>'.
     * @see org.eclipse.scada.common.VariantNullType
     * @generated
     */
    EClass getVariantNullType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.common.VariantType <em>Variant Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variant Type</em>'.
     * @see org.eclipse.scada.common.VariantType
     * @generated
     */
    EClass getVariantType ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.common.VariantType#getNull <em>Null</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Null</em>'.
     * @see org.eclipse.scada.common.VariantType#getNull()
     * @see #getVariantType()
     * @generated
     */
    EReference getVariantType_Null ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.common.VariantType#getString <em>String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>String</em>'.
     * @see org.eclipse.scada.common.VariantType#getString()
     * @see #getVariantType()
     * @generated
     */
    EAttribute getVariantType_String ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.common.VariantType#getInt32 <em>Int32</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Int32</em>'.
     * @see org.eclipse.scada.common.VariantType#getInt32()
     * @see #getVariantType()
     * @generated
     */
    EReference getVariantType_Int32 ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.common.VariantType#getDouble <em>Double</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Double</em>'.
     * @see org.eclipse.scada.common.VariantType#getDouble()
     * @see #getVariantType()
     * @generated
     */
    EReference getVariantType_Double ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.common.VariantType#getBoolean <em>Boolean</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Boolean</em>'.
     * @see org.eclipse.scada.common.VariantType#getBoolean()
     * @see #getVariantType()
     * @generated
     */
    EReference getVariantType_Boolean ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.common.VariantType#getInt64 <em>Int64</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Int64</em>'.
     * @see org.eclipse.scada.common.VariantType#getInt64()
     * @see #getVariantType()
     * @generated
     */
    EReference getVariantType_Int64 ();

    /**
     * Returns the meta object for data type '{@link java.lang.String <em>Class Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Class Type</em>'.
     * @see java.lang.String
     * @model instanceClass="java.lang.String"
     *        extendedMetaData="name='ClassType' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='[a-zA-Z]+(\\.[a-zA-Z0-9]+)*'"
     * @generated
     */
    EDataType getClassType ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CommonFactory getCommonFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.common.impl.AttributesTypeImpl <em>Attributes Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.common.impl.AttributesTypeImpl
         * @see org.eclipse.scada.common.impl.CommonPackageImpl#getAttributesType()
         * @generated
         */
        EClass ATTRIBUTES_TYPE = eINSTANCE.getAttributesType ();

        /**
         * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ATTRIBUTES_TYPE__ATTRIBUTE = eINSTANCE.getAttributesType_Attribute ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.common.impl.AttributeTypeImpl <em>Attribute Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.common.impl.AttributeTypeImpl
         * @see org.eclipse.scada.common.impl.CommonPackageImpl#getAttributeType()
         * @generated
         */
        EClass ATTRIBUTE_TYPE = eINSTANCE.getAttributeType ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE_TYPE__NAME = eINSTANCE.getAttributeType_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.common.impl.VariantBooleanTypeImpl <em>Variant Boolean Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.common.impl.VariantBooleanTypeImpl
         * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantBooleanType()
         * @generated
         */
        EClass VARIANT_BOOLEAN_TYPE = eINSTANCE.getVariantBooleanType ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VARIANT_BOOLEAN_TYPE__VALUE = eINSTANCE.getVariantBooleanType_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.common.impl.VariantDoubleTypeImpl <em>Variant Double Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.common.impl.VariantDoubleTypeImpl
         * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantDoubleType()
         * @generated
         */
        EClass VARIANT_DOUBLE_TYPE = eINSTANCE.getVariantDoubleType ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VARIANT_DOUBLE_TYPE__VALUE = eINSTANCE.getVariantDoubleType_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.common.impl.VariantInt32TypeImpl <em>Variant Int32 Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.common.impl.VariantInt32TypeImpl
         * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantInt32Type()
         * @generated
         */
        EClass VARIANT_INT32_TYPE = eINSTANCE.getVariantInt32Type ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VARIANT_INT32_TYPE__VALUE = eINSTANCE.getVariantInt32Type_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.common.impl.VariantInt64TypeImpl <em>Variant Int64 Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.common.impl.VariantInt64TypeImpl
         * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantInt64Type()
         * @generated
         */
        EClass VARIANT_INT64_TYPE = eINSTANCE.getVariantInt64Type ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VARIANT_INT64_TYPE__VALUE = eINSTANCE.getVariantInt64Type_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.common.impl.VariantNullTypeImpl <em>Variant Null Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.common.impl.VariantNullTypeImpl
         * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantNullType()
         * @generated
         */
        EClass VARIANT_NULL_TYPE = eINSTANCE.getVariantNullType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.common.impl.VariantTypeImpl <em>Variant Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.common.impl.VariantTypeImpl
         * @see org.eclipse.scada.common.impl.CommonPackageImpl#getVariantType()
         * @generated
         */
        EClass VARIANT_TYPE = eINSTANCE.getVariantType ();

        /**
         * The meta object literal for the '<em><b>Null</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VARIANT_TYPE__NULL = eINSTANCE.getVariantType_Null ();

        /**
         * The meta object literal for the '<em><b>String</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VARIANT_TYPE__STRING = eINSTANCE.getVariantType_String ();

        /**
         * The meta object literal for the '<em><b>Int32</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VARIANT_TYPE__INT32 = eINSTANCE.getVariantType_Int32 ();

        /**
         * The meta object literal for the '<em><b>Double</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VARIANT_TYPE__DOUBLE = eINSTANCE.getVariantType_Double ();

        /**
         * The meta object literal for the '<em><b>Boolean</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VARIANT_TYPE__BOOLEAN = eINSTANCE.getVariantType_Boolean ();

        /**
         * The meta object literal for the '<em><b>Int64</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VARIANT_TYPE__INT64 = eINSTANCE.getVariantType_Int64 ();

        /**
         * The meta object literal for the '<em>Class Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.String
         * @see org.eclipse.scada.common.impl.CommonPackageImpl#getClassType()
         * @generated
         */
        EDataType CLASS_TYPE = eINSTANCE.getClassType ();

    }

} //CommonPackage
