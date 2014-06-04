/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.ui.chart.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Legend Controller</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.LegendController#getTimestampFormat <em>Timestamp Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getLegendController()
 * @model
 * @generated
 */
public interface LegendController extends Controller
{
    /**
     * Returns the value of the '<em><b>Timestamp Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timestamp Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timestamp Format</em>' attribute.
     * @see #setTimestampFormat(String)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getLegendController_TimestampFormat()
     * @model
     * @generated
     */
    String getTimestampFormat ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.LegendController#getTimestampFormat <em>Timestamp Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timestamp Format</em>' attribute.
     * @see #getTimestampFormat()
     * @generated
     */
    void setTimestampFormat ( String value );

} // LegendController
