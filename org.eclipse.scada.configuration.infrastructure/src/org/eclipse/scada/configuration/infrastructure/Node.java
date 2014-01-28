/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.NamedDocumentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.Node#getHostName <em>Host Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.Node#getDevices <em>Devices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends NamedDocumentable
{
    /**
     * Returns the value of the '<em><b>Host Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Host Name</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Host Name</em>' attribute.
     * @see #setHostName(String)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getNode_HostName()
     * @model required="true"
     * @generated
     */
    String getHostName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.Node#getHostName <em>Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Host Name</em>' attribute.
     * @see #getHostName()
     * @generated
     */
    void setHostName ( String value );

    /**
     * Returns the value of the '<em><b>Devices</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.Device}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.infrastructure.Device#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Devices</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Devices</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getNode_Devices()
     * @see org.eclipse.scada.configuration.infrastructure.Device#getNode
     * @model opposite="node" containment="true" resolveProxies="true"
     * @generated
     */
    EList<Device> getDevices ();

} // Node
