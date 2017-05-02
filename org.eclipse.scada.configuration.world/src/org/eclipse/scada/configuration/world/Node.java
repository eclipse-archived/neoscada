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
package org.eclipse.scada.configuration.world;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.deployment.DeploymentMechanism;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.Node#getHostName <em>Host Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.Node#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.Node#getDeployments <em>Deployments</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.WorldPackage#getNode()
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
     * @see org.eclipse.scada.configuration.world.WorldPackage#getNode_HostName()
     * @model required="true"
     * @generated
     */
    String getHostName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.Node#getHostName <em>Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Host Name</em>' attribute.
     * @see #getHostName()
     * @generated
     */
    void setHostName ( String value );

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.Endpoint}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.world.Endpoint#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.WorldPackage#getNode_Endpoints()
     * @see org.eclipse.scada.configuration.world.Endpoint#getNode
     * @model opposite="node" containment="true" resolveProxies="true"
     * @generated
     */
    EList<Endpoint> getEndpoints ();

    /**
     * Returns the value of the '<em><b>Deployments</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.deployment.DeploymentMechanism}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deployments</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deployments</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.WorldPackage#getNode_Deployments()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<DeploymentMechanism> getDeployments ();

} // Node
