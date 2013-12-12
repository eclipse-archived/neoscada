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

import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.InputDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Heartbeat Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.common.HeartbeatGenerator#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.HeartbeatGenerator#getTargetItem <em>Target Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.common.CommonPackage#getHeartbeatGenerator()
 * @model abstract="true"
 * @generated
 */
public interface HeartbeatGenerator extends DataComponent
{
    /**
     * Returns the value of the '<em><b>Period</b></em>' attribute.
     * The default value is <code>"1000"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The generator period in milliseconds
     * <!-- end-model-doc -->
     * @return the value of the '<em>Period</em>' attribute.
     * @see #setPeriod(long)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getHeartbeatGenerator_Period()
     * @model default="1000" required="true"
     * @generated
     */
    long getPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.HeartbeatGenerator#getPeriod <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Period</em>' attribute.
     * @see #getPeriod()
     * @generated
     */
    void setPeriod ( long value );

    /**
     * Returns the value of the '<em><b>Target Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Item</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Item</em>' containment reference.
     * @see #setTargetItem(InputDefinition)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getHeartbeatGenerator_TargetItem()
     * @model containment="true" required="true"
     * @generated
     */
    InputDefinition getTargetItem ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.HeartbeatGenerator#getTargetItem <em>Target Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Item</em>' containment reference.
     * @see #getTargetItem()
     * @generated
     */
    void setTargetItem ( InputDefinition value );

} // HeartbeatGenerator
