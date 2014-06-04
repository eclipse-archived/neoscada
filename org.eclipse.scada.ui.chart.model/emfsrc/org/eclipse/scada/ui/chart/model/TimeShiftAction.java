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
 * A representation of the model object '<em><b>Time Shift Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.TimeShiftAction#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.TimeShiftAction#getDiff <em>Diff</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.TimeShiftAction#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getTimeShiftAction()
 * @model
 * @generated
 */
public interface TimeShiftAction extends XAxisController
{
    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getTimeShiftAction_Label()
     * @model required="true"
     * @generated
     */
    String getLabel ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.TimeShiftAction#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel ( String value );

    /**
     * Returns the value of the '<em><b>Diff</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Diff</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Diff</em>' attribute.
     * @see #setDiff(long)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getTimeShiftAction_Diff()
     * @model required="true"
     * @generated
     */
    long getDiff ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.TimeShiftAction#getDiff <em>Diff</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Diff</em>' attribute.
     * @see #getDiff()
     * @generated
     */
    void setDiff ( long value );

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getTimeShiftAction_Description()
     * @model
     * @generated
     */
    String getDescription ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.TimeShiftAction#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription ( String value );

} // TimeShiftAction
