/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Summaries Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.SummariesConfiguration#getItemThreshold <em>Item Threshold</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getSummariesConfiguration()
 * @model
 * @generated
 */
public interface SummariesConfiguration extends Configuration
{
    /**
     * Returns the value of the '<em><b>Item Threshold</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item Threshold</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item Threshold</em>' attribute.
     * @see #setItemThreshold(Integer)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getSummariesConfiguration_ItemThreshold()
     * @model
     * @generated
     */
    Integer getItemThreshold ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.SummariesConfiguration#getItemThreshold <em>Item Threshold</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item Threshold</em>' attribute.
     * @see #getItemThreshold()
     * @generated
     */
    void setItemThreshold ( Integer value );

} // SummariesConfiguration
