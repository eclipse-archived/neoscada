/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.model.Protocol;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage
 * @generated
 */
public interface ProtocolFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    ProtocolFactory eINSTANCE = org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Message</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Message</em>'.
     * @generated
     */
    Message createMessage ();

    /**
     * Returns a new object of class '<em>Protocol</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Protocol</em>'.
     * @generated
     */
    Protocol createProtocol ();

    /**
     * Returns a new object of class '<em>Structure</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Structure</em>'.
     * @generated
     */
    Structure createStructure ();

    /**
     * Returns a new object of class '<em>String Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>String Attribute</em>'.
     * @generated
     */
    StringAttribute createStringAttribute ();

    /**
     * Returns a new object of class '<em>Boolean Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Boolean Attribute</em>'.
     * @generated
     */
    BooleanAttribute createBooleanAttribute ();

    /**
     * Returns a new object of class '<em>Structure Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Structure Attribute</em>'.
     * @generated
     */
    StructureAttribute createStructureAttribute ();

    /**
     * Returns a new object of class '<em>Variant Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Variant Attribute</em>'.
     * @generated
     */
    VariantAttribute createVariantAttribute ();

    /**
     * Returns a new object of class '<em>Integer Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Integer Attribute</em>'.
     * @generated
     */
    IntegerAttribute createIntegerAttribute ();

    /**
     * Returns a new object of class '<em>Long Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Long Attribute</em>'.
     * @generated
     */
    LongAttribute createLongAttribute ();

    /**
     * Returns a new object of class '<em>Float Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Float Attribute</em>'.
     * @generated
     */
    FloatAttribute createFloatAttribute ();

    /**
     * Returns a new object of class '<em>Variant Map Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Variant Map Attribute</em>'.
     * @generated
     */
    VariantMapAttribute createVariantMapAttribute ();

    /**
     * Returns a new object of class '<em>Properties Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Properties Attribute</em>'.
     * @generated
     */
    PropertiesAttribute createPropertiesAttribute ();

    /**
     * Returns a new object of class '<em>Enum</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Enum</em>'.
     * @generated
     */
    Enum createEnum ();

    /**
     * Returns a new object of class '<em>Enum Attribute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Enum Attribute</em>'.
     * @generated
     */
    EnumAttribute createEnumAttribute ();

    /**
     * Returns a new object of class '<em>Interface</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Interface</em>'.
     * @generated
     */
    Interface createInterface ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    ProtocolPackage getProtocolPackage ();

} //ProtocolFactory
