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

import org.eclipse.scada.configuration.infrastructure.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ping Check</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.PingCheck#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#getPingCheck()
 * @model
 * @generated
 */
public interface PingCheck extends ExecJob
{
    /**
     * Returns the value of the '<em><b>Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Node</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Node</em>' reference.
     * @see #setNode(Node)
     * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#getPingCheck_Node()
     * @model required="true"
     * @generated
     */
    Node getNode ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.exec.PingCheck#getNode <em>Node</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Node</em>' reference.
     * @see #getNode()
     * @generated
     */
    void setNode ( Node value );

} // PingCheck
