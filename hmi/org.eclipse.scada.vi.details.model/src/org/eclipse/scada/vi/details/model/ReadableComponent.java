/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Readable Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.ReadableComponent#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ReadableComponent#getDecimal <em>Decimal</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ReadableComponent#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ReadableComponent#getHdConnectionId <em>Hd Connection Id</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ReadableComponent#getHdItemId <em>Hd Item Id</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ReadableComponent#getHdQueryString <em>Hd Query String</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ReadableComponent#isIsText <em>Is Text</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ReadableComponent#getNullReplacementValue <em>Null Replacement Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getReadableComponent()
 * @model abstract="true"
 * @generated
 */
public interface ReadableComponent extends Component
{
    /**
     * Returns the value of the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Format</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Format</em>' attribute.
     * @see #setFormat(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getReadableComponent_Format()
     * @model
     * @generated
     */
    String getFormat ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ReadableComponent#getFormat <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Format</em>' attribute.
     * @see #getFormat()
     * @generated
     */
    void setFormat ( String value );

    /**
     * Returns the value of the '<em><b>Decimal</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Decimal</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Decimal</em>' attribute.
     * @see #setDecimal(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getReadableComponent_Decimal()
     * @model
     * @generated
     */
    String getDecimal ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ReadableComponent#getDecimal <em>Decimal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Decimal</em>' attribute.
     * @see #getDecimal()
     * @generated
     */
    void setDecimal ( String value );

    /**
     * Returns the value of the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attribute</em>' attribute.
     * @see #setAttribute(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getReadableComponent_Attribute()
     * @model
     * @generated
     */
    String getAttribute ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ReadableComponent#getAttribute <em>Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attribute</em>' attribute.
     * @see #getAttribute()
     * @generated
     */
    void setAttribute ( String value );

    /**
     * Returns the value of the '<em><b>Hd Connection Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hd Connection Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hd Connection Id</em>' attribute.
     * @see #setHdConnectionId(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getReadableComponent_HdConnectionId()
     * @model
     * @generated
     */
    String getHdConnectionId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ReadableComponent#getHdConnectionId <em>Hd Connection Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hd Connection Id</em>' attribute.
     * @see #getHdConnectionId()
     * @generated
     */
    void setHdConnectionId ( String value );

    /**
     * Returns the value of the '<em><b>Hd Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hd Item Id</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hd Item Id</em>' attribute.
     * @see #setHdItemId(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getReadableComponent_HdItemId()
     * @model
     * @generated
     */
    String getHdItemId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ReadableComponent#getHdItemId <em>Hd Item Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hd Item Id</em>' attribute.
     * @see #getHdItemId()
     * @generated
     */
    void setHdItemId ( String value );

    /**
     * Returns the value of the '<em><b>Hd Query String</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hd Query String</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The query string in the format: START:END[:MIN:MAX]. Where START, END is the relative start and end time in milliseconds based on now. And MIN, MAX is the range for the Y-axis.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Hd Query String</em>' attribute.
     * @see #setHdQueryString(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getReadableComponent_HdQueryString()
     * @model
     * @generated
     */
    String getHdQueryString ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ReadableComponent#getHdQueryString <em>Hd Query String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hd Query String</em>' attribute.
     * @see #getHdQueryString()
     * @generated
     */
    void setHdQueryString ( String value );

    /**
     * Returns the value of the '<em><b>Is Text</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Text</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Is Text</em>' attribute.
     * @see #setIsText(boolean)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getReadableComponent_IsText()
     * @model
     * @generated
     */
    boolean isIsText ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ReadableComponent#isIsText <em>Is Text</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Text</em>' attribute.
     * @see #isIsText()
     * @generated
     */
    void setIsText ( boolean value );

    /**
     * Returns the value of the '<em><b>Null Replacement Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Null Replacement Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Null Replacement Value</em>' attribute.
     * @see #setNullReplacementValue(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getReadableComponent_NullReplacementValue()
     * @model
     * @generated
     */
    String getNullReplacementValue ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ReadableComponent#getNullReplacementValue <em>Null Replacement Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Null Replacement Value</em>' attribute.
     * @see #getNullReplacementValue()
     * @generated
     */
    void setNullReplacementValue ( String value );

} // ReadableComponent
