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
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.scada.configuration.world.Service;
import org.eclipse.scada.configuration.world.deployment.DeploymentMechanism;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A node managed by the system.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getDeployment <em>Deployment</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getDrivers <em>Drivers</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getMasters <em>Masters</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getValueArchives <em>Value Archives</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getApplications <em>Applications</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getValueSlaves <em>Value Slaves</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getSystemNode()
 * @model
 * @generated
 */
public interface SystemNode extends Node
{
    /**
     * Returns the value of the '<em><b>Deployment</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.deployment.DeploymentMechanism}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deployment</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deployment</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getSystemNode_Deployment()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<DeploymentMechanism> getDeployment ();

    /**
     * Returns the value of the '<em><b>Drivers</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.Driver}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.infrastructure.Driver#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Drivers</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Drivers</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getSystemNode_Drivers()
     * @see org.eclipse.scada.configuration.infrastructure.Driver#getNode
     * @model opposite="node" containment="true" resolveProxies="true"
     * @generated
     */
    EList<Driver> getDrivers ();

    /**
     * Returns the value of the '<em><b>Masters</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.MasterServer}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Masters</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Masters</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getSystemNode_Masters()
     * @model containment="true" resolveProxies="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="group='#applications'"
     * @generated
     */
    EList<MasterServer> getMasters ();

    /**
     * Returns the value of the '<em><b>Value Archives</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.ValueArchiveServer}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value Archives</em>' containment reference
     * list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value Archives</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getSystemNode_ValueArchives()
     * @model containment="true" resolveProxies="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="group='#applications'"
     * @generated
     */
    EList<ValueArchiveServer> getValueArchives ();

    /**
     * Returns the value of the '<em><b>Applications</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Applications</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Applications</em>' attribute list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getSystemNode_Applications()
     * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='group'"
     * @generated
     */
    FeatureMap getApplications ();

    /**
     * Returns the value of the '<em><b>Services</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.Service}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Services</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Services</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getSystemNode_Services()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Service> getServices ();

    /**
     * Returns the value of the '<em><b>Value Slaves</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value Slaves</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value Slaves</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getSystemNode_ValueSlaves()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ValueArchiveSlave> getValueSlaves ();

} // SystemNode
