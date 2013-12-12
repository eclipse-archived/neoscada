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
package org.eclipse.scada.configuration.world.osgi.profile.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.StartBundle;
import org.eclipse.scada.configuration.world.osgi.profile.SubProfile;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfileFactoryImpl extends EFactoryImpl implements ProfileFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProfileFactory init() {
		try {
			ProfileFactory theProfileFactory = (ProfileFactory) EPackage.Registry.INSTANCE
					.getEFactory(ProfilePackage.eNS_URI);
			if (theProfileFactory != null) {
				return theProfileFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProfileFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ProfilePackage.PROFILE:
			return createProfile();
		case ProfilePackage.START_BUNDLE:
			return createStartBundle();
		case ProfilePackage.SYSTEM_PROPERTY:
			return createSystemProperty();
		case ProfilePackage.SUB_PROFILE:
			return createSubProfile();
		case ProfilePackage.BUNDLE_START_LEVEL:
			return createBundleStartLevel();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Profile createProfile() {
		ProfileImpl profile = new ProfileImpl();
		return profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartBundle createStartBundle() {
		StartBundleImpl startBundle = new StartBundleImpl();
		return startBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemProperty createSystemProperty() {
		SystemPropertyImpl systemProperty = new SystemPropertyImpl();
		return systemProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubProfile createSubProfile() {
		SubProfileImpl subProfile = new SubProfileImpl();
		return subProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundleStartLevel createBundleStartLevel() {
		BundleStartLevelImpl bundleStartLevel = new BundleStartLevelImpl();
		return bundleStartLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilePackage getProfilePackage() {
		return (ProfilePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProfilePackage getPackage() {
		return ProfilePackage.eINSTANCE;
	}

} //ProfileFactoryImpl
