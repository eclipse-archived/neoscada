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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.UriItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Uri Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.UriItemImpl#getConnectionUri <em>Connection Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UriItemImpl extends ItemImpl implements UriItem {
	/**
	 * The default value of the '{@link #getConnectionUri() <em>Connection Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionUri()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectionUri() <em>Connection Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionUri()
	 * @generated
	 * @ordered
	 */
	protected String connectionUri = CONNECTION_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UriItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChartPackage.Literals.URI_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionUri() {
		return connectionUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionUri(String newConnectionUri) {
		String oldConnectionUri = connectionUri;
		connectionUri = newConnectionUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChartPackage.URI_ITEM__CONNECTION_URI, oldConnectionUri,
					connectionUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChartPackage.URI_ITEM__CONNECTION_URI:
			return getConnectionUri();
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
		case ChartPackage.URI_ITEM__CONNECTION_URI:
			setConnectionUri((String) newValue);
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
		case ChartPackage.URI_ITEM__CONNECTION_URI:
			setConnectionUri(CONNECTION_URI_EDEFAULT);
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
		case ChartPackage.URI_ITEM__CONNECTION_URI:
			return CONNECTION_URI_EDEFAULT == null ? connectionUri != null
					: !CONNECTION_URI_EDEFAULT.equals(connectionUri);
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
		result.append(" (connectionUri: "); //$NON-NLS-1$
		result.append(connectionUri);
		result.append(')');
		return result.toString();
	}

} //UriItemImpl
