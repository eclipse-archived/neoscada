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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '
 * <em><b>Common Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism#getChanges <em>Changes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism#getMaintainer <em>Maintainer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getCommonDeploymentMechanism()
 * @model abstract="true"
 * @generated
 */
public interface CommonDeploymentMechanism extends DeploymentMechanism
{
    /**
     * Returns the value of the '<em><b>Changes</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.deployment.ChangeEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Changes</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Changes</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getCommonDeploymentMechanism_Changes()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    EList<ChangeEntry> getChanges ();

    /**
     * Returns the value of the '<em><b>Maintainer</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maintainer</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Maintainer</em>' reference.
     * @see #setMaintainer(Author)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getCommonDeploymentMechanism_Maintainer()
     * @model keys="email" required="true"
     * @generated
     */
    Author getMaintainer ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism#getMaintainer <em>Maintainer</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Maintainer</em>' reference.
     * @see #getMaintainer()
     * @generated
     */
    void setMaintainer ( Author value );

} // CommonDeploymentMechanism
