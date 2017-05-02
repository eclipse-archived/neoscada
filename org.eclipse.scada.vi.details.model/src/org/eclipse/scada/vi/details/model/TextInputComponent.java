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
 * A representation of the model object '<em><b>Text Input Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.TextInputComponent#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.TextInputComponent#getReadDescriptor <em>Read Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.TextInputComponent#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextInputComponent()
 * @model
 * @generated
 */
public interface TextInputComponent extends WriteableComponent
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
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextInputComponent_Descriptor()
     * @model required="true"
     * @generated
     */
    String getDescriptor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.TextInputComponent#getDescriptor <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descriptor</em>' attribute.
     * @see #getDescriptor()
     * @generated
     */
    void setDescriptor ( String value );

    /**
     * Returns the value of the '<em><b>Read Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Read Descriptor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Read Descriptor</em>' attribute.
     * @see #setReadDescriptor(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextInputComponent_ReadDescriptor()
     * @model
     * @generated
     */
    String getReadDescriptor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.TextInputComponent#getReadDescriptor <em>Read Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Read Descriptor</em>' attribute.
     * @see #getReadDescriptor()
     * @generated
     */
    void setReadDescriptor ( String value );

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
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getTextInputComponent_Width()
     * @model
     * @generated
     */
    int getWidth ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.TextInputComponent#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth ( int value );

} // TextInputComponent
