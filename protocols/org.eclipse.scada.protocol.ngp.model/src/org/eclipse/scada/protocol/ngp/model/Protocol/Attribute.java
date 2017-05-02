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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getFieldNumber <em>Field Number</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isEquality <em>Equality</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isDeleted <em>Deleted</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getAttribute()
 * @model abstract="true"
 * @generated
 */
public interface Attribute extends DocumentedElement
{

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getAttribute_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Field Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Field Number</em>' attribute.
     * @see #setFieldNumber(byte)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getAttribute_FieldNumber()
     * @model
     * @generated
     */
    byte getFieldNumber ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getFieldNumber <em>Field Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Field Number</em>' attribute.
     * @see #getFieldNumber()
     * @generated
     */
    void setFieldNumber ( byte value );

    /**
     * Returns the value of the '<em><b>Equality</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Equality</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Equality</em>' attribute.
     * @see #setEquality(boolean)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getAttribute_Equality()
     * @model default="false" required="true"
     * @generated
     */
    boolean isEquality ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isEquality <em>Equality</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Equality</em>' attribute.
     * @see #isEquality()
     * @generated
     */
    void setEquality ( boolean value );

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The default value is <code>"SCALAR"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.protocol.ngp.model.Protocol.Type}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Type
     * @see #setType(Type)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getAttribute_Type()
     * @model default="SCALAR" required="true"
     * @generated
     */
    Type getType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Type
     * @see #getType()
     * @generated
     */
    void setType ( Type value );

    /**
     * Returns the value of the '<em><b>Transient</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transient</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transient</em>' attribute.
     * @see #setTransient(boolean)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getAttribute_Transient()
     * @model default="false" required="true"
     * @generated
     */
    boolean isTransient ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isTransient <em>Transient</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Transient</em>' attribute.
     * @see #isTransient()
     * @generated
     */
    void setTransient ( boolean value );

    /**
     * Returns the value of the '<em><b>Deleted</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deleted</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deleted</em>' attribute.
     * @see #setDeleted(boolean)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getAttribute_Deleted()
     * @model default="false" required="true"
     * @generated
     */
    boolean isDeleted ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isDeleted <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Deleted</em>' attribute.
     * @see #isDeleted()
     * @generated
     */
    void setDeleted ( boolean value );
} // Attribute
