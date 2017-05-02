/**
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse contribution
 */
package org.eclipse.scada.ui.chart.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Id Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.IdItem#getConnectionId <em>Connection Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getIdItem()
 * @model
 * @generated
 */
public interface IdItem extends Item
{
    /**
     * Returns the value of the '<em><b>Connection Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection Id</em>' attribute.
     * @see #setConnectionId(String)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getIdItem_ConnectionId()
     * @model required="true"
     * @generated
     */
    String getConnectionId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.IdItem#getConnectionId <em>Connection Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection Id</em>' attribute.
     * @see #getConnectionId()
     * @generated
     */
    void setConnectionId ( String value );

} // IdItem
