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
 * A representation of the model object '<em><b>Script Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.ScriptSeries#getLineProperties <em>Line Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.ScriptSeries#getScript <em>Script</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getScriptSeries()
 * @model
 * @generated
 */
public interface ScriptSeries extends DataSeries
{
    /**
     * Returns the value of the '<em><b>Line Properties</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line Properties</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Line Properties</em>' containment reference.
     * @see #setLineProperties(LineProperties)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getScriptSeries_LineProperties()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    LineProperties getLineProperties ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.ScriptSeries#getLineProperties <em>Line Properties</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Line Properties</em>' containment reference.
     * @see #getLineProperties()
     * @generated
     */
    void setLineProperties ( LineProperties value );

    /**
     * Returns the value of the '<em><b>Script</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script</em>' attribute.
     * @see #setScript(String)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getScriptSeries_Script()
     * @model
     * @generated
     */
    String getScript ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.ScriptSeries#getScript <em>Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script</em>' attribute.
     * @see #getScript()
     * @generated
     */
    void setScript ( String value );

} // ScriptSeries
