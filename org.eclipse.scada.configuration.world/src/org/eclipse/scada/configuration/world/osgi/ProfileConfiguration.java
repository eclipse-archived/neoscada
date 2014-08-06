/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Profile Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ProfileConfiguration#getStartBundles <em>Start Bundles</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ProfileConfiguration#getInstallBundles <em>Install Bundles</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ProfileConfiguration#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getProfileConfiguration()
 * @model
 * @generated
 */
public interface ProfileConfiguration extends IndependentConfiguration
{
    /**
     * Returns the value of the '<em><b>Start Bundles</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start Bundles</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start Bundles</em>' attribute list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getProfileConfiguration_StartBundles()
     * @model
     * @generated
     */
    EList<String> getStartBundles ();

    /**
     * Returns the value of the '<em><b>Install Bundles</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Install Bundles</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Install Bundles</em>' attribute list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getProfileConfiguration_InstallBundles()
     * @model
     * @generated
     */
    EList<String> getInstallBundles ();

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getProfileConfiguration_Properties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getProperties ();

} // ProfileConfiguration
