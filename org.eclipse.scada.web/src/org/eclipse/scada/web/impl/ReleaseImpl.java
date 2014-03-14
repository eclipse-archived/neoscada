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
package org.eclipse.scada.web.impl;

import java.util.Date;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.web.Release;
import org.eclipse.scada.web.ReleaseType;
import org.eclipse.scada.web.Version;
import org.eclipse.scada.web.WebPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Release</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.impl.ReleaseImpl#getBuildId <em>Build Id</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.ReleaseImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.ReleaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.ReleaseImpl#getReleaseNotesLink <em>Release Notes Link</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.ReleaseImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.ReleaseImpl#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReleaseImpl extends MinimalEObjectImpl.Container implements Release {
	/**
	 * The default value of the '{@link #getBuildId() <em>Build Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildId()
	 * @generated
	 * @ordered
	 */
	protected static final String BUILD_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBuildId() <em>Build Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildId()
	 * @generated
	 * @ordered
	 */
	protected String buildId = BUILD_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ReleaseType TYPE_EDEFAULT = ReleaseType.NIGHTLY;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ReleaseType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getReleaseNotesLink() <em>Release Notes Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseNotesLink()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEASE_NOTES_LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReleaseNotesLink() <em>Release Notes Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseNotesLink()
	 * @generated
	 * @ordered
	 */
	protected String releaseNotesLink = RELEASE_NOTES_LINK_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReleaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WebPackage.Literals.RELEASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBuildId() {
		return buildId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuildId(String newBuildId) {
		String oldBuildId = buildId;
		buildId = newBuildId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.RELEASE__BUILD_ID, oldBuildId, buildId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ReleaseType newType) {
		ReleaseType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.RELEASE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.RELEASE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReleaseNotesLink() {
		return releaseNotesLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReleaseNotesLink(String newReleaseNotesLink) {
		String oldReleaseNotesLink = releaseNotesLink;
		releaseNotesLink = newReleaseNotesLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.RELEASE__RELEASE_NOTES_LINK, oldReleaseNotesLink, releaseNotesLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version getVersion() {
		if (eContainerFeatureID() != WebPackage.RELEASE__VERSION) return null;
		return (Version)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersion(Version newVersion, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newVersion, WebPackage.RELEASE__VERSION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(Version newVersion) {
		if (newVersion != eInternalContainer() || (eContainerFeatureID() != WebPackage.RELEASE__VERSION && newVersion != null)) {
			if (EcoreUtil.isAncestor(this, newVersion))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newVersion != null)
				msgs = ((InternalEObject)newVersion).eInverseAdd(this, WebPackage.VERSION__RELEASES, Version.class, msgs);
			msgs = basicSetVersion(newVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.RELEASE__VERSION, newVersion, newVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.RELEASE__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WebPackage.RELEASE__VERSION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetVersion((Version)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WebPackage.RELEASE__VERSION:
				return basicSetVersion(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case WebPackage.RELEASE__VERSION:
				return eInternalContainer().eInverseRemove(this, WebPackage.VERSION__RELEASES, Version.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WebPackage.RELEASE__BUILD_ID:
				return getBuildId();
			case WebPackage.RELEASE__TYPE:
				return getType();
			case WebPackage.RELEASE__NAME:
				return getName();
			case WebPackage.RELEASE__RELEASE_NOTES_LINK:
				return getReleaseNotesLink();
			case WebPackage.RELEASE__VERSION:
				return getVersion();
			case WebPackage.RELEASE__DATE:
				return getDate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WebPackage.RELEASE__BUILD_ID:
				setBuildId((String)newValue);
				return;
			case WebPackage.RELEASE__TYPE:
				setType((ReleaseType)newValue);
				return;
			case WebPackage.RELEASE__NAME:
				setName((String)newValue);
				return;
			case WebPackage.RELEASE__RELEASE_NOTES_LINK:
				setReleaseNotesLink((String)newValue);
				return;
			case WebPackage.RELEASE__VERSION:
				setVersion((Version)newValue);
				return;
			case WebPackage.RELEASE__DATE:
				setDate((Date)newValue);
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
			case WebPackage.RELEASE__BUILD_ID:
				setBuildId(BUILD_ID_EDEFAULT);
				return;
			case WebPackage.RELEASE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case WebPackage.RELEASE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WebPackage.RELEASE__RELEASE_NOTES_LINK:
				setReleaseNotesLink(RELEASE_NOTES_LINK_EDEFAULT);
				return;
			case WebPackage.RELEASE__VERSION:
				setVersion((Version)null);
				return;
			case WebPackage.RELEASE__DATE:
				setDate(DATE_EDEFAULT);
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
			case WebPackage.RELEASE__BUILD_ID:
				return BUILD_ID_EDEFAULT == null ? buildId != null : !BUILD_ID_EDEFAULT.equals(buildId);
			case WebPackage.RELEASE__TYPE:
				return type != TYPE_EDEFAULT;
			case WebPackage.RELEASE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WebPackage.RELEASE__RELEASE_NOTES_LINK:
				return RELEASE_NOTES_LINK_EDEFAULT == null ? releaseNotesLink != null : !RELEASE_NOTES_LINK_EDEFAULT.equals(releaseNotesLink);
			case WebPackage.RELEASE__VERSION:
				return getVersion() != null;
			case WebPackage.RELEASE__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (buildId: ");
		result.append(buildId);
		result.append(", type: ");
		result.append(type);
		result.append(", name: ");
		result.append(name);
		result.append(", releaseNotesLink: ");
		result.append(releaseNotesLink);
		result.append(", date: ");
		result.append(date);
		result.append(')');
		return result.toString();
	}

} //ReleaseImpl
