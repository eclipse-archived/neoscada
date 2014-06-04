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

import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Axis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Axis#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Axis#getTextPadding <em>Text Padding</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Axis#getColor <em>Color</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Axis#isLabelVisible <em>Label Visible</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Axis#getFormat <em>Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getAxis()
 * @model abstract="true"
 * @generated
 */
public interface Axis extends EObject
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
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getAxis_Label()
     * @model extendedMetaData="name='label'"
     * @generated
     */
    String getLabel ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Axis#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel ( String value );

    /**
     * Returns the value of the '<em><b>Text Padding</b></em>' attribute.
     * The default value is <code>"10"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Text Padding</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Text Padding</em>' attribute.
     * @see #setTextPadding(int)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getAxis_TextPadding()
     * @model default="10" required="true"
     * @generated
     */
    int getTextPadding ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Axis#getTextPadding <em>Text Padding</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Text Padding</em>' attribute.
     * @see #getTextPadding()
     * @generated
     */
    void setTextPadding ( int value );

    /**
     * Returns the value of the '<em><b>Color</b></em>' attribute.
     * The default value is <code>"#000000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Color</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Color</em>' attribute.
     * @see #setColor(RGB)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getAxis_Color()
     * @model default="#000000" dataType="org.eclipse.scada.ui.chart.model.RGB"
     * @generated
     */
    RGB getColor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Axis#getColor <em>Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Color</em>' attribute.
     * @see #getColor()
     * @generated
     */
    void setColor ( RGB value );

    /**
     * Returns the value of the '<em><b>Label Visible</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label Visible</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label Visible</em>' attribute.
     * @see #setLabelVisible(boolean)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getAxis_LabelVisible()
     * @model default="true" required="true"
     * @generated
     */
    boolean isLabelVisible ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Axis#isLabelVisible <em>Label Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label Visible</em>' attribute.
     * @see #isLabelVisible()
     * @generated
     */
    void setLabelVisible ( boolean value );

    /**
     * Returns the value of the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Format</em>' attribute.
     * @see #setFormat(String)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getAxis_Format()
     * @model
     * @generated
     */
    String getFormat ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Axis#getFormat <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Format</em>' attribute.
     * @see #getFormat()
     * @generated
     */
    void setFormat ( String value );

} // Axis
