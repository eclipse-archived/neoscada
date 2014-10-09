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
package org.eclipse.scada.configuration.memory;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.memory.MemoryPackage
 * @generated
 */
public interface MemoryFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MemoryFactory eINSTANCE = org.eclipse.scada.configuration.memory.impl.MemoryFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Type Definition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Definition</em>'.
     * @generated
     */
    TypeDefinition createTypeDefinition ();

    /**
     * Returns a new object of class '<em>User Defined Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>User Defined Type</em>'.
     * @generated
     */
    UserDefinedType createUserDefinedType ();

    /**
     * Returns a new object of class '<em>Unsigned Integer16 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Unsigned Integer16 Type</em>'.
     * @generated
     */
    UnsignedInteger16Type createUnsignedInteger16Type ();

    /**
     * Returns a new object of class '<em>Unsigned Integer32 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Unsigned Integer32 Type</em>'.
     * @generated
     */
    UnsignedInteger32Type createUnsignedInteger32Type ();

    /**
     * Returns a new object of class '<em>Unsigned Integer8 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Unsigned Integer8 Type</em>'.
     * @generated
     */
    UnsignedInteger8Type createUnsignedInteger8Type ();

    /**
     * Returns a new object of class '<em>Type System</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type System</em>'.
     * @generated
     */
    TypeSystem createTypeSystem ();

    /**
     * Returns a new object of class '<em>Float64 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Float64 Type</em>'.
     * @generated
     */
    Float64Type createFloat64Type ();

    /**
     * Returns a new object of class '<em>Signed Integer8 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Signed Integer8 Type</em>'.
     * @generated
     */
    SignedInteger8Type createSignedInteger8Type ();

    /**
     * Returns a new object of class '<em>Signed Integer16 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Signed Integer16 Type</em>'.
     * @generated
     */
    SignedInteger16Type createSignedInteger16Type ();

    /**
     * Returns a new object of class '<em>Signed Integer32 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Signed Integer32 Type</em>'.
     * @generated
     */
    SignedInteger32Type createSignedInteger32Type ();

    /**
     * Returns a new object of class '<em>Signed Integer64 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Signed Integer64 Type</em>'.
     * @generated
     */
    SignedInteger64Type createSignedInteger64Type ();

    /**
     * Returns a new object of class '<em>Bit Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Bit Type</em>'.
     * @generated
     */
    BitType createBitType ();

    /**
     * Returns a new object of class '<em>Variable</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Variable</em>'.
     * @generated
     */
    Variable createVariable ();

    /**
     * Returns a new object of class '<em>Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute</em>'.
     * @generated
     */
    Attribute createAttribute ();

    /**
     * Returns a new object of class '<em>Float32 Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Float32 Type</em>'.
     * @generated
     */
    Float32Type createFloat32Type ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    MemoryPackage getMemoryPackage ();

} //MemoryFactory
