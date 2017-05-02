/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.chart.model;

import org.eclipse.scada.vi.model.Figure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.chart.model.ChartView#getConfigurationUri <em>Configuration Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.chart.model.ChartPackage#getChartView()
 * @model
 * @generated
 */
public interface ChartView extends Figure
{

    /**
     * Returns the value of the '<em><b>Configuration Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configuration Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configuration Uri</em>' attribute.
     * @see #setConfigurationUri(String)
     * @see org.eclipse.scada.vi.chart.model.ChartPackage#getChartView_ConfigurationUri()
     * @model required="true"
     * @generated
     */
    String getConfigurationUri ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.chart.model.ChartView#getConfigurationUri <em>Configuration Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration Uri</em>' attribute.
     * @see #getConfigurationUri()
     * @generated
     */
    void setConfigurationUri ( String value );
} // ChartView
