/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.exec.configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Command Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.SingleCommandType#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getSingleCommandType()
 * @model extendedMetaData="name='SingleCommandType' kind='elementOnly'"
 * @generated
 */
public interface SingleCommandType extends CommandType
{

    /**
     * Returns the value of the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Period</em>' attribute.
     * @see #isSetPeriod()
     * @see #unsetPeriod()
     * @see #setPeriod(int)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getSingleCommandType_Period()
     * @model unsettable="true" dataType="org.eclipse.scada.da.exec.configuration.PeriodType"
     *        extendedMetaData="kind='attribute' name='period'"
     * @generated
     */
    int getPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.SingleCommandType#getPeriod <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Period</em>' attribute.
     * @see #isSetPeriod()
     * @see #unsetPeriod()
     * @see #getPeriod()
     * @generated
     */
    void setPeriod ( int value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.da.exec.configuration.SingleCommandType#getPeriod <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetPeriod()
     * @see #getPeriod()
     * @see #setPeriod(int)
     * @generated
     */
    void unsetPeriod ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.da.exec.configuration.SingleCommandType#getPeriod <em>Period</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Period</em>' attribute is set.
     * @see #unsetPeriod()
     * @see #getPeriod()
     * @see #setPeriod(int)
     * @generated
     */
    boolean isSetPeriod ();

} // SingleCommandType
