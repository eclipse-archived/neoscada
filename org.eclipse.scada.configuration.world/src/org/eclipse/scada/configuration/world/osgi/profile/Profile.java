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
package org.eclipse.scada.configuration.world.osgi.profile;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getInstallationUnits <em>Installation Units</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getJvmArgument <em>Jvm Argument</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getSetbsl <em>Setbsl</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getNotes <em>Notes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile()
 * @model extendedMetaData="name='profile'"
 * @generated
 */
public interface Profile extends EObject
{
    /**
     * Returns the value of the '<em><b>Profile</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.profile.SubProfile}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Profile</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Profile</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile_Profile()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<SubProfile> getProfile ();

    /**
     * Returns the value of the '<em><b>Includes</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.profile.Profile}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Includes</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Includes</em>' reference list.
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile_Includes()
     * @model
     * @generated
     */
    EList<Profile> getIncludes ();

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile_Name()
     * @model extendedMetaData="kind='attribute'"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile_Description()
     * @model
     * @generated
     */
    String getDescription ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription ( String value );

    /**
     * Returns the value of the '<em><b>Start</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.profile.StartBundle}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile_Start()
     * @model containment="true" resolveProxies="true" keys="name"
     * @generated
     */
    EList<StartBundle> getStart ();

    /**
     * Returns the value of the '<em><b>Property</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.profile.SystemProperty}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Property</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile_Property()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<SystemProperty> getProperty ();

    /**
     * Returns the value of the '<em><b>Setbsl</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Setbsl</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Setbsl</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile_Setbsl()
     * @model containment="true" resolveProxies="true"
     *        extendedMetaData="kind='element'"
     * @generated
     */
    EList<BundleStartLevel> getSetbsl ();

    /**
     * Returns the value of the '<em><b>Notes</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Notes</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Notes</em>' attribute list.
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile_Notes()
     * @model extendedMetaData="name='note' kind='element'"
     * @generated
     */
    EList<String> getNotes ();

    /**
     * Returns the value of the '<em><b>Installation Units</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Installation Units</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Installation Units</em>' attribute list.
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile_InstallationUnits()
     * @model extendedMetaData="kind='element' name='feature'"
     * @generated
     */
    EList<String> getInstallationUnits ();

    /**
     * Returns the value of the '<em><b>Jvm Argument</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Jvm Argument</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Jvm Argument</em>' attribute list.
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#getProfile_JvmArgument()
     * @model extendedMetaData="name='argument' kind='element'"
     * @generated
     */
    EList<String> getJvmArgument ();

} // Profile
