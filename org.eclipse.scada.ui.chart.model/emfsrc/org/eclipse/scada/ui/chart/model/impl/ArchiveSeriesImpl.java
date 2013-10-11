/**
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse contribution
 */
package org.eclipse.scada.ui.chart.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.ui.chart.model.ArchiveChannel;
import org.eclipse.scada.ui.chart.model.ArchiveSeries;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.LineProperties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Archive Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ArchiveSeriesImpl#getChannels <em>Channels</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ArchiveSeriesImpl#getLineProperties <em>Line Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArchiveSeriesImpl extends ItemDataSeriesImpl implements
		ArchiveSeries {
	/**
	 * The cached value of the '{@link #getChannels() <em>Channels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannels()
	 * @generated
	 * @ordered
	 */
	protected EList<ArchiveChannel> channels;

	/**
	 * The cached value of the '{@link #getLineProperties() <em>Line Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineProperties()
	 * @generated
	 * @ordered
	 */
	protected LineProperties lineProperties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchiveSeriesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChartPackage.Literals.ARCHIVE_SERIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ArchiveChannel> getChannels() {
		if (channels == null) {
			channels = new EObjectContainmentEList.Resolving<ArchiveChannel>(
					ArchiveChannel.class, this,
					ChartPackage.ARCHIVE_SERIES__CHANNELS);
		}
		return channels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineProperties getLineProperties() {
		if (lineProperties != null && lineProperties.eIsProxy()) {
			InternalEObject oldLineProperties = (InternalEObject) lineProperties;
			lineProperties = (LineProperties) eResolveProxy(oldLineProperties);
			if (lineProperties != oldLineProperties) {
				InternalEObject newLineProperties = (InternalEObject) lineProperties;
				NotificationChain msgs = oldLineProperties.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES,
						null, null);
				if (newLineProperties.eInternalContainer() == null) {
					msgs = newLineProperties
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES,
							oldLineProperties, lineProperties));
			}
		}
		return lineProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineProperties basicGetLineProperties() {
		return lineProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLineProperties(
			LineProperties newLineProperties, NotificationChain msgs) {
		LineProperties oldLineProperties = lineProperties;
		lineProperties = newLineProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES,
					oldLineProperties, newLineProperties);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineProperties(LineProperties newLineProperties) {
		if (newLineProperties != lineProperties) {
			NotificationChain msgs = null;
			if (lineProperties != null)
				msgs = ((InternalEObject) lineProperties).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES,
						null, msgs);
			if (newLineProperties != null)
				msgs = ((InternalEObject) newLineProperties).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES,
						null, msgs);
			msgs = basicSetLineProperties(newLineProperties, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES,
					newLineProperties, newLineProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChartPackage.ARCHIVE_SERIES__CHANNELS:
			return ((InternalEList<?>) getChannels()).basicRemove(otherEnd,
					msgs);
		case ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES:
			return basicSetLineProperties(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChartPackage.ARCHIVE_SERIES__CHANNELS:
			return getChannels();
		case ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES:
			if (resolve)
				return getLineProperties();
			return basicGetLineProperties();
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
		case ChartPackage.ARCHIVE_SERIES__CHANNELS:
			getChannels().clear();
			getChannels().addAll(
					(Collection<? extends ArchiveChannel>) newValue);
			return;
		case ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES:
			setLineProperties((LineProperties) newValue);
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
		case ChartPackage.ARCHIVE_SERIES__CHANNELS:
			getChannels().clear();
			return;
		case ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES:
			setLineProperties((LineProperties) null);
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
		case ChartPackage.ARCHIVE_SERIES__CHANNELS:
			return channels != null && !channels.isEmpty();
		case ChartPackage.ARCHIVE_SERIES__LINE_PROPERTIES:
			return lineProperties != null;
		}
		return super.eIsSet(featureID);
	}

} //ArchiveSeriesImpl
