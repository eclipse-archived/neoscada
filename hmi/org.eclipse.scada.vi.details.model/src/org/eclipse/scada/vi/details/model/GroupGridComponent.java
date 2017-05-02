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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Grid Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.GroupGridComponent#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.GroupGridComponent#isEqually <em>Equally</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.GroupGridComponent#getCols <em>Cols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGroupGridComponent()
 * @model
 * @generated
 */
public interface GroupGridComponent extends Component
{
    /**
     * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.vi.details.model.GroupGridEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Groups</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Groups</em>' containment reference list.
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGroupGridComponent_Groups()
     * @model containment="true"
     * @generated
     */
    EList<GroupGridEntry> getGroups ();

    /**
     * Returns the value of the '<em><b>Equally</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Equally</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Equally</em>' attribute.
     * @see #setEqually(boolean)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGroupGridComponent_Equally()
     * @model default="false" required="true"
     * @generated
     */
    boolean isEqually ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.GroupGridComponent#isEqually <em>Equally</em>}' attribute.
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
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGroupGridComponent_Cols()
     * @model default="2" required="true"
     * @generated
     */
    int getCols ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.GroupGridComponent#getCols <em>Cols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cols</em>' attribute.
     * @see #getCols()
     * @generated
     */
    void setCols ( int value );

} // GroupGridComponent
