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
 * A representation of the model object '<em><b>Item Value Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.ItemValueSource#getValueKey <em>Value Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getItemValueSource()
 * @model
 * @generated
 */
public interface ItemValueSource extends ValueSource
{
    /**
     * Returns the value of the '<em><b>Value Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value Key</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value Key</em>' attribute.
     * @see #setValueKey(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getItemValueSource_ValueKey()
     * @model required="true"
     * @generated
     */
    String getValueKey ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ItemValueSource#getValueKey <em>Value Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Key</em>' attribute.
     * @see #getValueKey()
     * @generated
     */
    void setValueKey ( String value );

} // ItemValueSource
