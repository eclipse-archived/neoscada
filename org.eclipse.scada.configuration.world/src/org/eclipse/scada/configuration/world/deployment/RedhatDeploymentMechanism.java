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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '
 * <em><b>Redhat Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism#getLicense <em>License</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getRedhatDeploymentMechanism()
 * @model
 * @generated
 */
public interface RedhatDeploymentMechanism extends CommonDeploymentMechanism
{

    /**
     * Returns the value of the '<em><b>License</b></em>' attribute.
     * The default value is <code>"other"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The value of the license field that will be inserted into the template "spec" file.
     * <!-- end-model-doc -->
     * @return the value of the '<em>License</em>' attribute.
     * @see #setLicense(String)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getRedhatDeploymentMechanism_License()
     * @model default="other" required="true"
     * @generated
     */
    String getLicense ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism#getLicense <em>License</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>License</em>' attribute.
     * @see #getLicense()
     * @generated
     */
    void setLicense ( String value );
} // RedhatDeploymentMechanism
