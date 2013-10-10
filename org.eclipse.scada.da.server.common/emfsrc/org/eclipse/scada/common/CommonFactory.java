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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.common.CommonPackage
 * @generated
 */
public interface CommonFactory extends EFactory
{
    
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CommonFactory eINSTANCE = org.eclipse.scada.common.impl.CommonFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Attributes Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attributes Type</em>'.
     * @generated
     */
    AttributesType createAttributesType ();

    /**
     * Returns a new object of class '<em>Attribute Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute Type</em>'.
     * @generated
     */
    AttributeType createAttributeType ();

    /**
     * Returns a new object of class '<em>Variant Boolean Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Variant Boolean Type</em>'.
     * @generated
     */
    VariantBooleanType createVariantBooleanType ();

    /**
     * Returns a new object of class '<em>Variant Double Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Variant Double Type</em>'.
     * @generated
     */
    VariantDoubleType createVariantDoubleType ();

    /**
     * Returns a new object of class '<em>Variant Int32 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Variant Int32 Type</em>'.
     * @generated
     */
    VariantInt32Type createVariantInt32Type ();

    /**
     * Returns a new object of class '<em>Variant Int64 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Variant Int64 Type</em>'.
     * @generated
     */
    VariantInt64Type createVariantInt64Type ();

    /**
     * Returns a new object of class '<em>Variant Null Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Variant Null Type</em>'.
     * @generated
     */
    VariantNullType createVariantNullType ();

    /**
     * Returns a new object of class '<em>Variant Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Variant Type</em>'.
     * @generated
     */
    VariantType createVariantType ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    CommonPackage getCommonPackage ();

} //CommonFactory
