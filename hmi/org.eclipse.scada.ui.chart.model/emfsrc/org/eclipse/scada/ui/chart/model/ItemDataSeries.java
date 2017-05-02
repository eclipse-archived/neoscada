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
 * A representation of the model object '<em><b>Item Data Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.ItemDataSeries#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getItemDataSeries()
 * @model abstract="true"
 * @generated
 */
public interface ItemDataSeries extends DataSeries
{
    /**
     * Returns the value of the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item</em>' containment reference.
     * @see #setItem(Item)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getItemDataSeries_Item()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    Item getItem ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.ItemDataSeries#getItem <em>Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item</em>' containment reference.
     * @see #getItem()
     * @generated
     */
    void setItem ( Item value );

} // ItemDataSeries
