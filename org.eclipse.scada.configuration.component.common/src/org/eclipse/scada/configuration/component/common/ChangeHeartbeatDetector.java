/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Heartbeat Detector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getCheckPeriod <em>Check Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getSourceItem <em>Source Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.common.CommonPackage#getChangeHeartbeatDetector()
 * @model
 * @generated
 */
public interface ChangeHeartbeatDetector extends HeartbeatDetector
{
    /**
     * Returns the value of the '<em><b>Timeout</b></em>' attribute.
     * The default value is <code>"10000"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The timeout of the detector in milliseconds.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Timeout</em>' attribute.
     * @see #setTimeout(long)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getChangeHeartbeatDetector_Timeout()
     * @model default="10000" required="true"
     * @generated
     */
    long getTimeout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getTimeout <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timeout</em>' attribute.
     * @see #getTimeout()
     * @generated
     */
    void setTimeout ( long value );

    /**
     * Returns the value of the '<em><b>Check Period</b></em>' attribute.
     * The default value is <code>"1000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Check Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Check Period</em>' attribute.
     * @see #setCheckPeriod(long)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getChangeHeartbeatDetector_CheckPeriod()
     * @model default="1000" required="true"
     * @generated
     */
    long getCheckPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getCheckPeriod <em>Check Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Check Period</em>' attribute.
     * @see #getCheckPeriod()
     * @generated
     */
    void setCheckPeriod ( long value );

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
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getChangeHeartbeatDetector_SourceItem()
     * @model containment="true" required="true"
     * @generated
     */
    InputDefinition getSourceItem ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getSourceItem <em>Source Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Item</em>' containment reference.
     * @see #getSourceItem()
     * @generated
     */
    void setSourceItem ( InputDefinition value );

} // ChangeHeartbeatDetector
