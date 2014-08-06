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
package org.eclipse.scada.configuration.world.deployment;

import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '
 * <em><b>Debian Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism#getSetup <em>Setup</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getDebianDeploymentMechanism()
 * @model
 * @generated
 */
public interface DebianDeploymentMechanism extends CommonDeploymentMechanism
{

    /**
     * Returns the value of the '<em><b>Setup</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Setup</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Setup</em>' reference.
     * @see #setSetup(SetupModuleContainer)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getDebianDeploymentMechanism_Setup()
     * @model
     * @generated
     */
    SetupModuleContainer getSetup ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism#getSetup <em>Setup</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Setup</em>' reference.
     * @see #getSetup()
     * @generated
     */
    void setSetup ( SetupModuleContainer value );

} // DebianDeploymentMechanism
