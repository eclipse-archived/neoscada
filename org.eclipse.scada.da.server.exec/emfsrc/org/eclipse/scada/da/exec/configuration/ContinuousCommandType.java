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
 * A representation of the model object '<em><b>Continuous Command Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getMaxInputBuffer <em>Max Input Buffer</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getRestartDelay <em>Restart Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getContinuousCommandType()
 * @model extendedMetaData="name='ContinuousCommandType' kind='elementOnly'"
 * @generated
 */
public interface ContinuousCommandType extends CommandType
{

    /**
     * Returns the value of the '<em><b>Max Input Buffer</b></em>' attribute.
     * The default value is <code>"4000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max Input Buffer</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Max Input Buffer</em>' attribute.
     * @see #isSetMaxInputBuffer()
     * @see #unsetMaxInputBuffer()
     * @see #setMaxInputBuffer(int)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getContinuousCommandType_MaxInputBuffer()
     * @model default="4000" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='maxInputBuffer'"
     * @generated
     */
    int getMaxInputBuffer ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getMaxInputBuffer <em>Max Input Buffer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Input Buffer</em>' attribute.
     * @see #isSetMaxInputBuffer()
     * @see #unsetMaxInputBuffer()
     * @see #getMaxInputBuffer()
     * @generated
     */
    void setMaxInputBuffer ( int value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getMaxInputBuffer <em>Max Input Buffer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetMaxInputBuffer()
     * @see #getMaxInputBuffer()
     * @see #setMaxInputBuffer(int)
     * @generated
     */
    void unsetMaxInputBuffer ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getMaxInputBuffer <em>Max Input Buffer</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Max Input Buffer</em>' attribute is set.
     * @see #unsetMaxInputBuffer()
     * @see #getMaxInputBuffer()
     * @see #setMaxInputBuffer(int)
     * @generated
     */
    boolean isSetMaxInputBuffer ();

    /**
     * Returns the value of the '<em><b>Restart Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Restart Delay</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Restart Delay</em>' attribute.
     * @see #isSetRestartDelay()
     * @see #unsetRestartDelay()
     * @see #setRestartDelay(int)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getContinuousCommandType_RestartDelay()
     * @model unsettable="true" dataType="org.eclipse.scada.da.exec.configuration.RestartDelayType" required="true"
     *        extendedMetaData="kind='attribute' name='restartDelay'"
     * @generated
     */
    int getRestartDelay ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getRestartDelay <em>Restart Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Restart Delay</em>' attribute.
     * @see #isSetRestartDelay()
     * @see #unsetRestartDelay()
     * @see #getRestartDelay()
     * @generated
     */
    void setRestartDelay ( int value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getRestartDelay <em>Restart Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetRestartDelay()
     * @see #getRestartDelay()
     * @see #setRestartDelay(int)
     * @generated
     */
    void unsetRestartDelay ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getRestartDelay <em>Restart Delay</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Restart Delay</em>' attribute is set.
     * @see #unsetRestartDelay()
     * @see #getRestartDelay()
     * @see #setRestartDelay(int)
     * @generated
     */
    boolean isSetRestartDelay ();

} // ContinuousCommandType
