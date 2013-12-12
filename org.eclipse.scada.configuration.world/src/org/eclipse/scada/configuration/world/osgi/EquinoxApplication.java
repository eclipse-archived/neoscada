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
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equinox Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getExporter <em>Exporter</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getCustomizationProfile <em>Customization Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getSecurityConfiguration <em>Security Configuration</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getModules <em>Modules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEquinoxApplication()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EquinoxApplication extends Application {
	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.Connection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEquinoxApplication_Connections()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Connection> getConnections();

	/**
	 * Returns the value of the '<em><b>Exporter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.Exporter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exporter</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exporter</em>' containment reference list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEquinoxApplication_Exporter()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Exporter> getExporter();

	/**
	 * Returns the value of the '<em><b>Customization Profile</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customization Profile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customization Profile</em>' containment reference.
	 * @see #setCustomizationProfile(Profile)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEquinoxApplication_CustomizationProfile()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Profile getCustomizationProfile();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getCustomizationProfile <em>Customization Profile</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Customization Profile</em>' containment reference.
	 * @see #getCustomizationProfile()
	 * @generated
	 */
	void setCustomizationProfile(Profile value);

	/**
	 * Returns the value of the '<em><b>Security Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Security Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Security Configuration</em>' reference.
	 * @see #setSecurityConfiguration(Configuration)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEquinoxApplication_SecurityConfiguration()
	 * @model required="true"
	 * @generated
	 */
	Configuration getSecurityConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getSecurityConfiguration <em>Security Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Security Configuration</em>' reference.
	 * @see #getSecurityConfiguration()
	 * @generated
	 */
	void setSecurityConfiguration(Configuration value);

	/**
	 * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.ApplicationModule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modules</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modules</em>' containment reference list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEquinoxApplication_Modules()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ApplicationModule> getModules();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Profile getProfile();

} // EquinoxApplication
