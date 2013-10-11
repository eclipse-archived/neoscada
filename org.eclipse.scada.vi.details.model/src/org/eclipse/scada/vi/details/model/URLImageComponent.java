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
 * A representation of the model object '<em><b>URL Image Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.URLImageComponent#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.URLImageComponent#getImageUrl <em>Image Url</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.URLImageComponent#getFallbackImageUrl <em>Fallback Image Url</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.URLImageComponent#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.URLImageComponent#getHeight <em>Height</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getURLImageComponent()
 * @model
 * @generated
 */
public interface URLImageComponent extends Component
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
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getURLImageComponent_Descriptor()
     * @model
     * @generated
     */
    String getDescriptor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.URLImageComponent#getDescriptor <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descriptor</em>' attribute.
     * @see #getDescriptor()
     * @generated
     */
    void setDescriptor ( String value );

    /**
     * Returns the value of the '<em><b>Image Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Image Url</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Image Url</em>' attribute.
     * @see #setImageUrl(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getURLImageComponent_ImageUrl()
     * @model
     * @generated
     */
    String getImageUrl ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.URLImageComponent#getImageUrl <em>Image Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Image Url</em>' attribute.
     * @see #getImageUrl()
     * @generated
     */
    void setImageUrl ( String value );

    /**
     * Returns the value of the '<em><b>Fallback Image Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fallback Image Url</em>' attribute isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fallback Image Url</em>' attribute.
     * @see #setFallbackImageUrl(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getURLImageComponent_FallbackImageUrl()
     * @model
     * @generated
     */
    String getFallbackImageUrl ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.URLImageComponent#getFallbackImageUrl <em>Fallback Image Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fallback Image Url</em>' attribute.
     * @see #getFallbackImageUrl()
     * @generated
     */
    void setFallbackImageUrl ( String value );

    /**
     * Returns the value of the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Width</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Width</em>' attribute.
     * @see #setWidth(Integer)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getURLImageComponent_Width()
     * @model
     * @generated
     */
    Integer getWidth ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.URLImageComponent#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth ( Integer value );

    /**
     * Returns the value of the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Height</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Height</em>' attribute.
     * @see #setHeight(Integer)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getURLImageComponent_Height()
     * @model
     * @generated
     */
    Integer getHeight ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.URLImageComponent#getHeight <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Height</em>' attribute.
     * @see #getHeight()
     * @generated
     */
    void setHeight ( Integer value );

} // URLImageComponent
