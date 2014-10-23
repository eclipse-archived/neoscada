/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.common;

import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.SingleValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scaled Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.common.ScaledValue#getSourceItem <em>Source Item</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.ScaledValue#getInputMinimum <em>Input Minimum</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.ScaledValue#getInputMaximum <em>Input Maximum</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.ScaledValue#getOutputMinimum <em>Output Minimum</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.ScaledValue#getOutputMaximum <em>Output Maximum</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.common.CommonPackage#getScaledValue()
 * @model
 * @generated
 */
public interface ScaledValue extends SingleValue
{
    /**
     * Returns the value of the '<em><b>Source Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Item</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Item</em>' containment reference.
     * @see #setSourceItem(InputDefinition)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getScaledValue_SourceItem()
     * @model containment="true" required="true"
     * @generated
     */
    InputDefinition getSourceItem ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.ScaledValue#getSourceItem <em>Source Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Item</em>' containment reference.
     * @see #getSourceItem()
     * @generated
     */
    void setSourceItem ( InputDefinition value );

    /**
     * Returns the value of the '<em><b>Input Minimum</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Minimum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Minimum</em>' attribute.
     * @see #setInputMinimum(double)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getScaledValue_InputMinimum()
     * @model default="0" required="true"
     * @generated
     */
    double getInputMinimum ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.ScaledValue#getInputMinimum <em>Input Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Minimum</em>' attribute.
     * @see #getInputMinimum()
     * @generated
     */
    void setInputMinimum ( double value );

    /**
     * Returns the value of the '<em><b>Input Maximum</b></em>' attribute.
     * The default value is <code>"100"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Maximum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Maximum</em>' attribute.
     * @see #setInputMaximum(double)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getScaledValue_InputMaximum()
     * @model default="100" required="true"
     * @generated
     */
    double getInputMaximum ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.ScaledValue#getInputMaximum <em>Input Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Maximum</em>' attribute.
     * @see #getInputMaximum()
     * @generated
     */
    void setInputMaximum ( double value );

    /**
     * Returns the value of the '<em><b>Output Minimum</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Minimum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Minimum</em>' attribute.
     * @see #setOutputMinimum(double)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getScaledValue_OutputMinimum()
     * @model default="0" required="true"
     * @generated
     */
    double getOutputMinimum ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.ScaledValue#getOutputMinimum <em>Output Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Minimum</em>' attribute.
     * @see #getOutputMinimum()
     * @generated
     */
    void setOutputMinimum ( double value );

    /**
     * Returns the value of the '<em><b>Output Maximum</b></em>' attribute.
     * The default value is <code>"1000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Maximum</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Maximum</em>' attribute.
     * @see #setOutputMaximum(double)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getScaledValue_OutputMaximum()
     * @model default="1000" required="true"
     * @generated
     */
    double getOutputMaximum ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.ScaledValue#getOutputMaximum <em>Output Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Maximum</em>' attribute.
     * @see #getOutputMaximum()
     * @generated
     */
    void setOutputMaximum ( double value );

} // ScaledValue
