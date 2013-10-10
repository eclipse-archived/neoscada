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
 * A representation of the model object '<em><b>Split Continuous Command Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType#getSplitter <em>Splitter</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType#getIgnoreStartLines <em>Ignore Start Lines</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getSplitContinuousCommandType()
 * @model extendedMetaData="name='SplitContinuousCommandType' kind='elementOnly'"
 * @generated
 */
public interface SplitContinuousCommandType extends ContinuousCommandType
{

    /**
     * Returns the value of the '<em><b>Splitter</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Splitter</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Splitter</em>' containment reference.
     * @see #setSplitter(SplitterType)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getSplitContinuousCommandType_Splitter()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='splitter' namespace='##targetNamespace'"
     * @generated
     */
    SplitterType getSplitter ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType#getSplitter <em>Splitter</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Splitter</em>' containment reference.
     * @see #getSplitter()
     * @generated
     */
    void setSplitter ( SplitterType value );

    /**
     * Returns the value of the '<em><b>Ignore Start Lines</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ignore Start Lines</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ignore Start Lines</em>' attribute.
     * @see #isSetIgnoreStartLines()
     * @see #unsetIgnoreStartLines()
     * @see #setIgnoreStartLines(int)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getSplitContinuousCommandType_IgnoreStartLines()
     * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='ignoreStartLines'"
     * @generated
     */
    int getIgnoreStartLines ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType#getIgnoreStartLines <em>Ignore Start Lines</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ignore Start Lines</em>' attribute.
     * @see #isSetIgnoreStartLines()
     * @see #unsetIgnoreStartLines()
     * @see #getIgnoreStartLines()
     * @generated
     */
    void setIgnoreStartLines ( int value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType#getIgnoreStartLines <em>Ignore Start Lines</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetIgnoreStartLines()
     * @see #getIgnoreStartLines()
     * @see #setIgnoreStartLines(int)
     * @generated
     */
    void unsetIgnoreStartLines ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType#getIgnoreStartLines <em>Ignore Start Lines</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Ignore Start Lines</em>' attribute is set.
     * @see #unsetIgnoreStartLines()
     * @see #getIgnoreStartLines()
     * @see #setIgnoreStartLines(int)
     * @generated
     */
    boolean isSetIgnoreStartLines ();

} // SplitContinuousCommandType
