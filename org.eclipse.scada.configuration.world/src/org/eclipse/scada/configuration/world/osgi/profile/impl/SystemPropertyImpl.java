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
package org.eclipse.scada.configuration.world.osgi.profile.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.SystemPropertyImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.SystemPropertyImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.SystemPropertyImpl#isEval <em>Eval</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemPropertyImpl extends MinimalEObjectImpl.Container implements
		SystemProperty {
	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEval() <em>Eval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEval()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EVAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEval() <em>Eval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEval()
	 * @generated
	 * @ordered
	 */
	protected boolean eval = EVAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProfilePackage.Literals.SYSTEM_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ProfilePackage.SYSTEM_PROPERTY__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ProfilePackage.SYSTEM_PROPERTY__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEval() {
		return eval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEval(boolean newEval) {
		boolean oldEval = eval;
		eval = newEval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ProfilePackage.SYSTEM_PROPERTY__EVAL, oldEval, eval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ProfilePackage.SYSTEM_PROPERTY__KEY:
			return getKey();
		case ProfilePackage.SYSTEM_PROPERTY__VALUE:
			return getValue();
		case ProfilePackage.SYSTEM_PROPERTY__EVAL:
			return isEval();
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
		case ProfilePackage.SYSTEM_PROPERTY__KEY:
			setKey((String) newValue);
			return;
		case ProfilePackage.SYSTEM_PROPERTY__VALUE:
			setValue((String) newValue);
			return;
		case ProfilePackage.SYSTEM_PROPERTY__EVAL:
			setEval((Boolean) newValue);
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
		case ProfilePackage.SYSTEM_PROPERTY__KEY:
			setKey(KEY_EDEFAULT);
			return;
		case ProfilePackage.SYSTEM_PROPERTY__VALUE:
			setValue(VALUE_EDEFAULT);
			return;
		case ProfilePackage.SYSTEM_PROPERTY__EVAL:
			setEval(EVAL_EDEFAULT);
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
		case ProfilePackage.SYSTEM_PROPERTY__KEY:
			return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT
					.equals(key);
		case ProfilePackage.SYSTEM_PROPERTY__VALUE:
			return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT
					.equals(value);
		case ProfilePackage.SYSTEM_PROPERTY__EVAL:
			return eval != EVAL_EDEFAULT;
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
		result.append(" (key: "); //$NON-NLS-1$
		result.append(key);
		result.append(", value: "); //$NON-NLS-1$
		result.append(value);
		result.append(", eval: "); //$NON-NLS-1$
		result.append(eval);
		result.append(')');
		return result.toString();
	}

} //SystemPropertyImpl
