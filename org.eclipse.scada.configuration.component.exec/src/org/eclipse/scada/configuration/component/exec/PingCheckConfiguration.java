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

import org.eclipse.scada.configuration.component.Configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ping Check Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.PingCheckConfiguration#getPingDelay <em>Ping Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#getPingCheckConfiguration()
 * @model
 * @generated
 */
public interface PingCheckConfiguration extends Configuration
{
    /**
     * Returns the value of the '<em><b>Ping Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The delay between pings in milliseconds.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Ping Delay</em>' attribute.
     * @see #setPingDelay(Integer)
     * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#getPingCheckConfiguration_PingDelay()
     * @model
     * @generated
     */
    Integer getPingDelay ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.exec.PingCheckConfiguration#getPingDelay <em>Ping Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ping Delay</em>' attribute.
     * @see #getPingDelay()
     * @generated
     */
    void setPingDelay ( Integer value );

} // PingCheckConfiguration
