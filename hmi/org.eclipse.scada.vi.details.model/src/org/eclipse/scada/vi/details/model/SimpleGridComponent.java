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
 * A representation of the model object '<em><b>Simple Grid Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.SimpleGridComponent#isEqually <em>Equally</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.SimpleGridComponent#getCols <em>Cols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getSimpleGridComponent()
 * @model
 * @generated
 */
public interface SimpleGridComponent extends CompositeComponent
{
    /**
     * Returns the value of the '<em><b>Equally</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Equally</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Equally</em>' attribute.
     * @see #setEqually(boolean)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getSimpleGridComponent_Equally()
     * @model default="true"
     * @generated
     */
    boolean isEqually ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.SimpleGridComponent#isEqually <em>Equally</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Equally</em>' attribute.
     * @see #isEqually()
     * @generated
     */
    void setEqually ( boolean value );

    /**
     * Returns the value of the '<em><b>Cols</b></em>' attribute.
     * The default value is <code>"2"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cols</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cols</em>' attribute.
     * @see #setCols(int)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getSimpleGridComponent_Cols()
     * @model default="2"
     * @generated
     */
    int getCols ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.SimpleGridComponent#getCols <em>Cols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cols</em>' attribute.
     * @see #getCols()
     * @generated
     */
    void setCols ( int value );

} // SimpleGridComponent
