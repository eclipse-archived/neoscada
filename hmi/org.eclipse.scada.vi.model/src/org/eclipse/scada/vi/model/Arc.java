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
 * A representation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.Arc#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Arc#getLength <em>Length</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getArc()
 * @model
 * @generated
 */
public interface Arc extends Shape
{
    /**
     * Returns the value of the '<em><b>Start</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start</em>' attribute.
     * @see #setStart(int)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getArc_Start()
     * @model required="true"
     * @generated
     */
    int getStart ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Arc#getStart <em>Start</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start</em>' attribute.
     * @see #getStart()
     * @generated
     */
    void setStart ( int value );

    /**
     * Returns the value of the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Length</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Length</em>' attribute.
     * @see #setLength(int)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getArc_Length()
     * @model required="true"
     * @generated
     */
    int getLength ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Arc#getLength <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Length</em>' attribute.
     * @see #getLength()
     * @generated
     */
    void setLength ( int value );

} // Arc
