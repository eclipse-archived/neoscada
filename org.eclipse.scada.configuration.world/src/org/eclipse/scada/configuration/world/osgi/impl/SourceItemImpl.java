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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.SourceItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.SourceItemImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.SourceItemImpl#getSourceName <em>Source Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceItemImpl extends ItemImpl implements SourceItem {
	/**
	 * The cached value of the '{@link #getConnection() <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnection()
	 * @generated
	 * @ordered
	 */
	protected DataAccessConnection connection;

	/**
	 * The default value of the '{@link #getSourceName() <em>Source Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceName() <em>Source Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceName()
	 * @generated
	 * @ordered
	 */
	protected String sourceName = SOURCE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.SOURCE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataAccessConnection getConnection() {
		if (connection != null && connection.eIsProxy()) {
			InternalEObject oldConnection = (InternalEObject) connection;
			connection = (DataAccessConnection) eResolveProxy(oldConnection);
			if (connection != oldConnection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OsgiPackage.SOURCE_ITEM__CONNECTION, oldConnection,
							connection));
			}
		}
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataAccessConnection basicGetConnection() {
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnection(DataAccessConnection newConnection) {
		DataAccessConnection oldConnection = connection;
		connection = newConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.SOURCE_ITEM__CONNECTION, oldConnection,
					connection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceName() {
		return sourceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceName(String newSourceName) {
		String oldSourceName = sourceName;
		sourceName = newSourceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.SOURCE_ITEM__SOURCE_NAME, oldSourceName,
					sourceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OsgiPackage.SOURCE_ITEM__CONNECTION:
			if (resolve)
				return getConnection();
			return basicGetConnection();
		case OsgiPackage.SOURCE_ITEM__SOURCE_NAME:
			return getSourceName();
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
		case OsgiPackage.SOURCE_ITEM__CONNECTION:
			setConnection((DataAccessConnection) newValue);
			return;
		case OsgiPackage.SOURCE_ITEM__SOURCE_NAME:
			setSourceName((String) newValue);
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
		case OsgiPackage.SOURCE_ITEM__CONNECTION:
			setConnection((DataAccessConnection) null);
			return;
		case OsgiPackage.SOURCE_ITEM__SOURCE_NAME:
			setSourceName(SOURCE_NAME_EDEFAULT);
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
		case OsgiPackage.SOURCE_ITEM__CONNECTION:
			return connection != null;
		case OsgiPackage.SOURCE_ITEM__SOURCE_NAME:
			return SOURCE_NAME_EDEFAULT == null ? sourceName != null
					: !SOURCE_NAME_EDEFAULT.equals(sourceName);
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
		result.append(" (sourceName: "); //$NON-NLS-1$
		result.append(sourceName);
		result.append(')');
		return result.toString();
	}

} //SourceItemImpl
