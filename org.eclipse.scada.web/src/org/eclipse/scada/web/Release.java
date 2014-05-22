/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.web;

import java.util.Date;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Release</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.Release#getBuildId <em>Build Id</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Release#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Release#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Release#getReleaseNotesLink <em>Release Notes Link</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Release#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Release#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Release#getUnqualifiedName <em>Unqualified Name</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Release#getAlternateMsiName <em>Alternate Msi Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.web.WebPackage#getRelease()
 * @model
 * @generated
 */
public interface Release extends EObject {
	/**
	 * Returns the value of the '<em><b>Build Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Build Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Build Id</em>' attribute.
	 * @see #setBuildId(String)
	 * @see org.eclipse.scada.web.WebPackage#getRelease_BuildId()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getBuildId();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Release#getBuildId <em>Build Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Id</em>' attribute.
	 * @see #getBuildId()
	 * @generated
	 */
	void setBuildId(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.scada.web.ReleaseType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.scada.web.ReleaseType
	 * @see #setType(ReleaseType)
	 * @see org.eclipse.scada.web.WebPackage#getRelease_Type()
	 * @model required="true"
	 * @generated
	 */
	ReleaseType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Release#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.scada.web.ReleaseType
	 * @see #getType()
	 * @generated
	 */
	void setType(ReleaseType value);

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
	 * @see org.eclipse.scada.web.WebPackage#getRelease_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Release#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Release Notes Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release Notes Link</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release Notes Link</em>' attribute.
	 * @see #setReleaseNotesLink(String)
	 * @see org.eclipse.scada.web.WebPackage#getRelease_ReleaseNotesLink()
	 * @model required="true"
	 * @generated
	 */
	String getReleaseNotesLink();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Release#getReleaseNotesLink <em>Release Notes Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release Notes Link</em>' attribute.
	 * @see #getReleaseNotesLink()
	 * @generated
	 */
	void setReleaseNotesLink(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.scada.web.Version#getReleases <em>Releases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' container reference.
	 * @see #setVersion(Version)
	 * @see org.eclipse.scada.web.WebPackage#getRelease_Version()
	 * @see org.eclipse.scada.web.Version#getReleases
	 * @model opposite="releases" transient="false"
	 * @generated
	 */
	Version getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Release#getVersion <em>Version</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' container reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Version value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.eclipse.scada.web.WebPackage#getRelease_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Release#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Unqualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unqualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unqualified Name</em>' attribute.
	 * @see #setUnqualifiedName(String)
	 * @see org.eclipse.scada.web.WebPackage#getRelease_UnqualifiedName()
	 * @model required="true"
	 * @generated
	 */
	String getUnqualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Release#getUnqualifiedName <em>Unqualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unqualified Name</em>' attribute.
	 * @see #getUnqualifiedName()
	 * @generated
	 */
	void setUnqualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Alternate Msi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternate Msi Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternate Msi Name</em>' attribute.
	 * @see #setAlternateMsiName(String)
	 * @see org.eclipse.scada.web.WebPackage#getRelease_AlternateMsiName()
	 * @model
	 * @generated
	 */
	String getAlternateMsiName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Release#getAlternateMsiName <em>Alternate Msi Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alternate Msi Name</em>' attribute.
	 * @see #getAlternateMsiName()
	 * @generated
	 */
	void setAlternateMsiName(String value);

} // Release
