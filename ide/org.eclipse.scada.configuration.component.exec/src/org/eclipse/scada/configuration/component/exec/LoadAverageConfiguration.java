/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.exec;

import java.util.regex.Pattern;

import org.eclipse.scada.configuration.component.Configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load Average Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#getLoadAverageConfiguration()
 * @model
 * @generated
 */
public interface LoadAverageConfiguration extends Configuration
{
    /**
     * Returns the value of the '<em><b>Period</b></em>' attribute.
     * The default value is <code>"1000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Period</em>' attribute.
     * @see #setPeriod(int)
     * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#getLoadAverageConfiguration_Period()
     * @model default="1000" required="true"
     * @generated
     */
    int getPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration#getPeriod <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Period</em>' attribute.
     * @see #getPeriod()
     * @generated
     */
    void setPeriod ( int value );

    /**
     * Returns the value of the '<em><b>Pattern</b></em>' attribute.
     * The default value is <code>"([0-9]+) users?.*averages?: +([0-9]+[,\\\\.][0-9]*),? +([0-9]+[,\\\\.][0-9]*),? +([0-9]+[,\\\\.][0-9]*)"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pattern</em>' attribute.
     * @see #setPattern(Pattern)
     * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#getLoadAverageConfiguration_Pattern()
     * @model default="([0-9]+) users?.*averages?: +([0-9]+[,\\\\.][0-9]*),? +([0-9]+[,\\\\.][0-9]*),? +([0-9]+[,\\\\.][0-9]*)" dataType="org.eclipse.scada.configuration.security.Pattern" required="true"
     * @generated
     */
    Pattern getPattern ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration#getPattern <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pattern</em>' attribute.
     * @see #getPattern()
     * @generated
     */
    void setPattern ( Pattern value );

} // LoadAverageConfiguration
