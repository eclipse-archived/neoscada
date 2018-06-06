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
 * A representation of the model object '<em><b>XY Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.XYChild#getPosition <em>Position</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.XYChild#getDimension <em>Dimension</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getXYChild()
 * @model
 * @generated
 */
public interface XYChild extends Child
{
    /**
     * Returns the value of the '<em><b>Position</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Position</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Position</em>' containment reference.
     * @see #setPosition(Position)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getXYChild_Position()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element'"
     * @generated
     */
    Position getPosition ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.XYChild#getPosition <em>Position</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Position</em>' containment reference.
     * @see #getPosition()
     * @generated
     */
    void setPosition ( Position value );

    /**
     * Returns the value of the '<em><b>Dimension</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * An optional dimension for the XYLayout. If not set the preferred dimension of the child will be used.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Dimension</em>' containment reference.
     * @see #setDimension(Dimension)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getXYChild_Dimension()
     * @model containment="true"
     * @generated
     */
    Dimension getDimension ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.XYChild#getDimension <em>Dimension</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dimension</em>' containment reference.
     * @see #getDimension()
     * @generated
     */
    void setDimension ( Dimension value );

} // XYChild
