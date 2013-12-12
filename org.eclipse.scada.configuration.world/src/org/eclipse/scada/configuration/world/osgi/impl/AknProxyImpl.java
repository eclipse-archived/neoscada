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

import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.osgi.AknProxy;
import org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Akn Proxy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AknProxyImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AknProxyImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AknProxyImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AknProxyImpl#isAuthorative <em>Authorative</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AknProxyImpl extends MinimalEObjectImpl.Container implements
		AknProxy {
	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final Pattern PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern pattern = PATTERN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnection() <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnection()
	 * @generated
	 * @ordered
	 */
	protected AlarmsEventsConnection connection;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isAuthorative() <em>Authorative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAuthorative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTHORATIVE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAuthorative() <em>Authorative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAuthorative()
	 * @generated
	 * @ordered
	 */
	protected boolean authorative = AUTHORATIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AknProxyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.AKN_PROXY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(Pattern newPattern) {
		Pattern oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.AKN_PROXY__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlarmsEventsConnection getConnection() {
		if (connection != null && connection.eIsProxy()) {
			InternalEObject oldConnection = (InternalEObject) connection;
			connection = (AlarmsEventsConnection) eResolveProxy(oldConnection);
			if (connection != oldConnection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							OsgiPackage.AKN_PROXY__CONNECTION, oldConnection,
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
	public AlarmsEventsConnection basicGetConnection() {
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnection(AlarmsEventsConnection newConnection) {
		AlarmsEventsConnection oldConnection = connection;
		connection = newConnection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.AKN_PROXY__CONNECTION, oldConnection,
					connection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.AKN_PROXY__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAuthorative() {
		return authorative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthorative(boolean newAuthorative) {
		boolean oldAuthorative = authorative;
		authorative = newAuthorative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.AKN_PROXY__AUTHORATIVE, oldAuthorative,
					authorative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OsgiPackage.AKN_PROXY__PATTERN:
			return getPattern();
		case OsgiPackage.AKN_PROXY__CONNECTION:
			if (resolve)
				return getConnection();
			return basicGetConnection();
		case OsgiPackage.AKN_PROXY__PRIORITY:
			return getPriority();
		case OsgiPackage.AKN_PROXY__AUTHORATIVE:
			return isAuthorative();
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
		case OsgiPackage.AKN_PROXY__PATTERN:
			setPattern((Pattern) newValue);
			return;
		case OsgiPackage.AKN_PROXY__CONNECTION:
			setConnection((AlarmsEventsConnection) newValue);
			return;
		case OsgiPackage.AKN_PROXY__PRIORITY:
			setPriority((Integer) newValue);
			return;
		case OsgiPackage.AKN_PROXY__AUTHORATIVE:
			setAuthorative((Boolean) newValue);
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
		case OsgiPackage.AKN_PROXY__PATTERN:
			setPattern(PATTERN_EDEFAULT);
			return;
		case OsgiPackage.AKN_PROXY__CONNECTION:
			setConnection((AlarmsEventsConnection) null);
			return;
		case OsgiPackage.AKN_PROXY__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
			return;
		case OsgiPackage.AKN_PROXY__AUTHORATIVE:
			setAuthorative(AUTHORATIVE_EDEFAULT);
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
		case OsgiPackage.AKN_PROXY__PATTERN:
			return PATTERN_EDEFAULT == null ? pattern != null
					: !PATTERN_EDEFAULT.equals(pattern);
		case OsgiPackage.AKN_PROXY__CONNECTION:
			return connection != null;
		case OsgiPackage.AKN_PROXY__PRIORITY:
			return priority != PRIORITY_EDEFAULT;
		case OsgiPackage.AKN_PROXY__AUTHORATIVE:
			return authorative != AUTHORATIVE_EDEFAULT;
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
		result.append(" (pattern: "); //$NON-NLS-1$
		result.append(pattern);
		result.append(", priority: "); //$NON-NLS-1$
		result.append(priority);
		result.append(", authorative: "); //$NON-NLS-1$
		result.append(authorative);
		result.append(')');
		return result.toString();
	}

} //AknProxyImpl
