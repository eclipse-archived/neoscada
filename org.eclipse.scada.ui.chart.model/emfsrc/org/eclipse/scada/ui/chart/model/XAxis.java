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
 * A representation of the model object '<em><b>XAxis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.XAxis#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.XAxis#getMaximum <em>Maximum</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getXAxis()
 * @model
 * @generated
 */
public interface XAxis extends Axis
{
    /**
     * Returns the value of the '<em><b>Minimum</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Minimum</em>' attribute.
     * @see #setMinimum(long)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getXAxis_Minimum()
     * @model default="0" required="true"
     * @generated
     */
    long getMinimum ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.XAxis#getMinimum <em>Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Minimum</em>' attribute.
     * @see #getMinimum()
     * @generated
     */
    void setMinimum ( long value );

    /**
     * Returns the value of the '<em><b>Maximum</b></em>' attribute.
     * The default value is <code>"1000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Maximum</em>' attribute.
     * @see #setMaximum(long)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getXAxis_Maximum()
     * @model default="1000" required="true"
     * @generated
     */
    long getMaximum ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.XAxis#getMaximum <em>Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Maximum</em>' attribute.
     * @see #getMaximum()
     * @generated
     */
    void setMaximum ( long value );

} // XAxis
