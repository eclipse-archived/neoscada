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
 * A representation of the model object '<em><b>Uri Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.UriItem#getConnectionUri <em>Connection Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getUriItem()
 * @model
 * @generated
 */
public interface UriItem extends Item
{
    /**
     * Returns the value of the '<em><b>Connection Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection Uri</em>' attribute.
     * @see #setConnectionUri(String)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getUriItem_ConnectionUri()
     * @model required="true"
     * @generated
     */
    String getConnectionUri ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.UriItem#getConnectionUri <em>Connection Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection Uri</em>' attribute.
     * @see #getConnectionUri()
     * @generated
     */
    void setConnectionUri ( String value );

} // UriItem
