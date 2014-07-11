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
 * A representation of the model object '<em><b>Line Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.LineProperties#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.LineProperties#getColor <em>Color</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getLineProperties()
 * @model
 * @generated
 */
public interface LineProperties extends EObject
{
    /**
     * Returns the value of the '<em><b>Width</b></em>' attribute.
     * The default value is <code>"1.0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Width</em>' attribute.
     * @see #setWidth(float)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getLineProperties_Width()
     * @model default="1.0" required="true"
     * @generated
     */
    float getWidth ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.LineProperties#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth ( float value );

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
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getLineProperties_Color()
     * @model default="#000000" dataType="org.eclipse.scada.ui.chart.model.RGB" required="true"
     * @generated
     */
    RGB getColor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.LineProperties#getColor <em>Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Color</em>' attribute.
     * @see #getColor()
     * @generated
     */
    void setColor ( RGB value );

} // LineProperties
