/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.Image#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Image#getImageAlignment <em>Image Alignment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getImage()
 * @model
 * @generated
 */
public interface Image extends Figure
{
    /**
     * Returns the value of the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Uri</em>' attribute.
     * @see #setUri(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getImage_Uri()
     * @model
     * @generated
     */
    String getUri ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Image#getUri <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uri</em>' attribute.
     * @see #getUri()
     * @generated
     */
    void setUri ( String value );

    /**
     * Returns the value of the '<em><b>Image Alignment</b></em>' attribute.
     * The default value is <code>"CENTER"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.vi.model.Alignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Image Alignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Image Alignment</em>' attribute.
     * @see org.eclipse.scada.vi.model.Alignment
     * @see #setImageAlignment(Alignment)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getImage_ImageAlignment()
     * @model default="CENTER"
     * @generated
     */
    Alignment getImageAlignment ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Image#getImageAlignment <em>Image Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Image Alignment</em>' attribute.
     * @see org.eclipse.scada.vi.model.Alignment
     * @see #getImageAlignment()
     * @generated
     */
    void setImageAlignment ( Alignment value );

} // Image
