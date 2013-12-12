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
package org.eclipse.scada.configuration.world.deployment.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Debian Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.DebianDeploymentMechanismImpl#getAdditionalDependencies <em>Additional Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DebianDeploymentMechanismImpl extends
		CommonDeploymentMechanismImpl implements DebianDeploymentMechanism {
	/**
	 * The cached value of the '{@link #getAdditionalDependencies() <em>Additional Dependencies</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<String> additionalDependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DebianDeploymentMechanismImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeploymentPackage.Literals.DEBIAN_DEPLOYMENT_MECHANISM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAdditionalDependencies() {
		if (additionalDependencies == null) {
			additionalDependencies = new EDataTypeUniqueEList<String>(
					String.class,
					this,
					DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES);
		}
		return additionalDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES:
			return getAdditionalDependencies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES:
			getAdditionalDependencies().clear();
			getAdditionalDependencies().addAll(
					(Collection<? extends String>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES:
			getAdditionalDependencies().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES:
			return additionalDependencies != null
					&& !additionalDependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (additionalDependencies: "); //$NON-NLS-1$
		result.append(additionalDependencies);
		result.append(')');
		return result.toString();
	}

} //DebianDeploymentMechanismImpl
