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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.DataSeries#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.DataSeries#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.DataSeries#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.DataSeries#isVisible <em>Visible</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getDataSeries()
 * @model abstract="true"
 * @generated
 */
public interface DataSeries extends EObject
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
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getDataSeries_Label()
     * @model
     * @generated
     */
    String getLabel ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.DataSeries#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel ( String value );

    /**
     * Returns the value of the '<em><b>X</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>X</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>X</em>' reference.
     * @see #setX(XAxis)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getDataSeries_X()
     * @model required="true"
     * @generated
     */
    XAxis getX ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.DataSeries#getX <em>X</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>X</em>' reference.
     * @see #getX()
     * @generated
     */
    void setX ( XAxis value );

    /**
     * Returns the value of the '<em><b>Y</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Y</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Y</em>' reference.
     * @see #setY(YAxis)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getDataSeries_Y()
     * @model required="true"
     * @generated
     */
    YAxis getY ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.DataSeries#getY <em>Y</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Y</em>' reference.
     * @see #getY()
     * @generated
     */
    void setY ( YAxis value );

    /**
     * Returns the value of the '<em><b>Visible</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visible</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visible</em>' attribute.
     * @see #setVisible(boolean)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getDataSeries_Visible()
     * @model default="true" required="true"
     * @generated
     */
    boolean isVisible ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.DataSeries#isVisible <em>Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visible</em>' attribute.
     * @see #isVisible()
     * @generated
     */
    void setVisible ( boolean value );

} // DataSeries
