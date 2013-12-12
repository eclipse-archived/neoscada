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
package org.eclipse.scada.configuration.world.deployment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Debian Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism#getAdditionalDependencies <em>Additional Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getDebianDeploymentMechanism()
 * @model
 * @generated
 */
public interface DebianDeploymentMechanism extends CommonDeploymentMechanism {
	/**
	 * Returns the value of the '<em><b>Additional Dependencies</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Additional Dependencies</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Additional Dependencies</em>' attribute list.
	 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getDebianDeploymentMechanism_AdditionalDependencies()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getAdditionalDependencies();

} // DebianDeploymentMechanism
