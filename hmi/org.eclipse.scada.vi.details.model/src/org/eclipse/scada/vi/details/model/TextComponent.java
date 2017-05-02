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
 * A representation of the model object '<em><b>Text Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.TextComponent#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.TextComponent#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.TextComponent#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.TextComponent#isDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.TextComponent#getTextHeight <em>Text Height</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.TextComponent#getTextMap <em>Text Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextComponent()
 * @model
 * @generated
 */
public interface TextComponent extends ReadableComponent
{
    /**
     * Returns the value of the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Descriptor</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Descriptor</em>' attribute.
     * @see #setDescriptor(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextComponent_Descriptor()
     * @model required="true"
     * @generated
     */
    String getDescriptor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.TextComponent#getDescriptor <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descriptor</em>' attribute.
     * @see #getDescriptor()
     * @generated
     */
    void setDescriptor ( String value );

    /**
     * Returns the value of the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Width</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Width</em>' attribute.
     * @see #setWidth(int)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextComponent_Width()
     * @model
     * @generated
     */
    int getWidth ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.TextComponent#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth ( int value );

    /**
     * Returns the value of the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Height</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Height</em>' attribute.
     * @see #setHeight(int)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextComponent_Height()
     * @model
     * @generated
     */
    int getHeight ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.TextComponent#getHeight <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Height</em>' attribute.
     * @see #getHeight()
     * @generated
     */
    void setHeight ( int value );

    /**
     * Returns the value of the '<em><b>Date</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Date</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Date</em>' attribute.
     * @see #setDate(boolean)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextComponent_Date()
     * @model
     * @generated
     */
    boolean isDate ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.TextComponent#isDate <em>Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Date</em>' attribute.
     * @see #isDate()
     * @generated
     */
    void setDate ( boolean value );

    /**
     * Returns the value of the '<em><b>Text Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text Height</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Text Height</em>' attribute.
     * @see #setTextHeight(int)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextComponent_TextHeight()
     * @model
     * @generated
     */
    int getTextHeight ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.TextComponent#getTextHeight <em>Text Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Text Height</em>' attribute.
     * @see #getTextHeight()
     * @generated
     */
    void setTextHeight ( int value );

    /**
     * Returns the value of the '<em><b>Text Map</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text Map</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Text Map</em>' attribute.
     * @see #setTextMap(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextComponent_TextMap()
     * @model
     * @generated
     */
    String getTextMap ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.TextComponent#getTextMap <em>Text Map</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Text Map</em>' attribute.
     * @see #getTextMap()
     * @generated
     */
    void setTextMap ( String value );

} // TextComponent
