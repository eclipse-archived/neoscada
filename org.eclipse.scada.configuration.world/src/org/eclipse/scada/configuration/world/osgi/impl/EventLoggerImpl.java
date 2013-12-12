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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.world.osgi.EventLogger;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Logger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventLoggerImpl#isLogAttributesChange <em>Log Attributes Change</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventLoggerImpl#isLogValueChange <em>Log Value Change</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventLoggerImpl#isLogSubscriptionChange <em>Log Subscription Change</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventLoggerImpl#isLogWrites <em>Log Writes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventLoggerImpl extends ItemFeatureEntryImpl implements
		EventLogger {
	/**
	 * The default value of the '{@link #isLogAttributesChange() <em>Log Attributes Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogAttributesChange()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOG_ATTRIBUTES_CHANGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLogAttributesChange() <em>Log Attributes Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogAttributesChange()
	 * @generated
	 * @ordered
	 */
	protected boolean logAttributesChange = LOG_ATTRIBUTES_CHANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isLogValueChange() <em>Log Value Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogValueChange()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOG_VALUE_CHANGE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isLogValueChange() <em>Log Value Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogValueChange()
	 * @generated
	 * @ordered
	 */
	protected boolean logValueChange = LOG_VALUE_CHANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isLogSubscriptionChange() <em>Log Subscription Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogSubscriptionChange()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOG_SUBSCRIPTION_CHANGE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isLogSubscriptionChange() <em>Log Subscription Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogSubscriptionChange()
	 * @generated
	 * @ordered
	 */
	protected boolean logSubscriptionChange = LOG_SUBSCRIPTION_CHANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isLogWrites() <em>Log Writes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogWrites()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOG_WRITES_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isLogWrites() <em>Log Writes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogWrites()
	 * @generated
	 * @ordered
	 */
	protected boolean logWrites = LOG_WRITES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventLoggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.EVENT_LOGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLogAttributesChange() {
		return logAttributesChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogAttributesChange(boolean newLogAttributesChange) {
		boolean oldLogAttributesChange = logAttributesChange;
		logAttributesChange = newLogAttributesChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.EVENT_LOGGER__LOG_ATTRIBUTES_CHANGE,
					oldLogAttributesChange, logAttributesChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLogValueChange() {
		return logValueChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogValueChange(boolean newLogValueChange) {
		boolean oldLogValueChange = logValueChange;
		logValueChange = newLogValueChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.EVENT_LOGGER__LOG_VALUE_CHANGE,
					oldLogValueChange, logValueChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLogSubscriptionChange() {
		return logSubscriptionChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogSubscriptionChange(boolean newLogSubscriptionChange) {
		boolean oldLogSubscriptionChange = logSubscriptionChange;
		logSubscriptionChange = newLogSubscriptionChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.EVENT_LOGGER__LOG_SUBSCRIPTION_CHANGE,
					oldLogSubscriptionChange, logSubscriptionChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLogWrites() {
		return logWrites;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogWrites(boolean newLogWrites) {
		boolean oldLogWrites = logWrites;
		logWrites = newLogWrites;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.EVENT_LOGGER__LOG_WRITES, oldLogWrites,
					logWrites));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OsgiPackage.EVENT_LOGGER__LOG_ATTRIBUTES_CHANGE:
			return isLogAttributesChange();
		case OsgiPackage.EVENT_LOGGER__LOG_VALUE_CHANGE:
			return isLogValueChange();
		case OsgiPackage.EVENT_LOGGER__LOG_SUBSCRIPTION_CHANGE:
			return isLogSubscriptionChange();
		case OsgiPackage.EVENT_LOGGER__LOG_WRITES:
			return isLogWrites();
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
		case OsgiPackage.EVENT_LOGGER__LOG_ATTRIBUTES_CHANGE:
			setLogAttributesChange((Boolean) newValue);
			return;
		case OsgiPackage.EVENT_LOGGER__LOG_VALUE_CHANGE:
			setLogValueChange((Boolean) newValue);
			return;
		case OsgiPackage.EVENT_LOGGER__LOG_SUBSCRIPTION_CHANGE:
			setLogSubscriptionChange((Boolean) newValue);
			return;
		case OsgiPackage.EVENT_LOGGER__LOG_WRITES:
			setLogWrites((Boolean) newValue);
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
		case OsgiPackage.EVENT_LOGGER__LOG_ATTRIBUTES_CHANGE:
			setLogAttributesChange(LOG_ATTRIBUTES_CHANGE_EDEFAULT);
			return;
		case OsgiPackage.EVENT_LOGGER__LOG_VALUE_CHANGE:
			setLogValueChange(LOG_VALUE_CHANGE_EDEFAULT);
			return;
		case OsgiPackage.EVENT_LOGGER__LOG_SUBSCRIPTION_CHANGE:
			setLogSubscriptionChange(LOG_SUBSCRIPTION_CHANGE_EDEFAULT);
			return;
		case OsgiPackage.EVENT_LOGGER__LOG_WRITES:
			setLogWrites(LOG_WRITES_EDEFAULT);
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
		case OsgiPackage.EVENT_LOGGER__LOG_ATTRIBUTES_CHANGE:
			return logAttributesChange != LOG_ATTRIBUTES_CHANGE_EDEFAULT;
		case OsgiPackage.EVENT_LOGGER__LOG_VALUE_CHANGE:
			return logValueChange != LOG_VALUE_CHANGE_EDEFAULT;
		case OsgiPackage.EVENT_LOGGER__LOG_SUBSCRIPTION_CHANGE:
			return logSubscriptionChange != LOG_SUBSCRIPTION_CHANGE_EDEFAULT;
		case OsgiPackage.EVENT_LOGGER__LOG_WRITES:
			return logWrites != LOG_WRITES_EDEFAULT;
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
		result.append(" (logAttributesChange: "); //$NON-NLS-1$
		result.append(logAttributesChange);
		result.append(", logValueChange: "); //$NON-NLS-1$
		result.append(logValueChange);
		result.append(", logSubscriptionChange: "); //$NON-NLS-1$
		result.append(logSubscriptionChange);
		result.append(", logWrites: "); //$NON-NLS-1$
		result.append(logWrites);
		result.append(')');
		return result.toString();
	}

} //EventLoggerImpl
