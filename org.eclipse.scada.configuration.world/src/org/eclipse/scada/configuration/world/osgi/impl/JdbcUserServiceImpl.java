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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.osgi.JdbcUserService;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.PasswordType;
import org.eclipse.scada.configuration.world.osgi.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jdbc User Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#getJdbcPropeties <em>Jdbc Propeties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#getJdbcDriver <em>Jdbc Driver</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#isAuthorative <em>Authorative</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#getFindUserSql <em>Find User Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#getFindRolesForUserSql <em>Find Roles For User Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#getUpdatePasswordSql <em>Update Password Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#getUserIdColumnName <em>User Id Column Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#getPasswordColumnName <em>Password Column Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl#getPasswordType <em>Password Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JdbcUserServiceImpl extends MinimalEObjectImpl.Container implements
		JdbcUserService {
	/**
	 * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortDescription()
	 * @generated
	 * @ordered
	 */
	protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

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
	 * The cached value of the '{@link #getJdbcPropeties() <em>Jdbc Propeties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcPropeties()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyEntry> jdbcPropeties;

	/**
	 * The default value of the '{@link #getJdbcDriver() <em>Jdbc Driver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcDriver()
	 * @generated
	 * @ordered
	 */
	protected static final String JDBC_DRIVER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJdbcDriver() <em>Jdbc Driver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJdbcDriver()
	 * @generated
	 * @ordered
	 */
	protected String jdbcDriver = JDBC_DRIVER_EDEFAULT;

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
	 * The default value of the '{@link #getFindUserSql() <em>Find User Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFindUserSql()
	 * @generated
	 * @ordered
	 */
	protected static final String FIND_USER_SQL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFindUserSql() <em>Find User Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFindUserSql()
	 * @generated
	 * @ordered
	 */
	protected String findUserSql = FIND_USER_SQL_EDEFAULT;

	/**
	 * The default value of the '{@link #getFindRolesForUserSql() <em>Find Roles For User Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFindRolesForUserSql()
	 * @generated
	 * @ordered
	 */
	protected static final String FIND_ROLES_FOR_USER_SQL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFindRolesForUserSql() <em>Find Roles For User Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFindRolesForUserSql()
	 * @generated
	 * @ordered
	 */
	protected String findRolesForUserSql = FIND_ROLES_FOR_USER_SQL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpdatePasswordSql() <em>Update Password Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdatePasswordSql()
	 * @generated
	 * @ordered
	 */
	protected static final String UPDATE_PASSWORD_SQL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUpdatePasswordSql() <em>Update Password Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdatePasswordSql()
	 * @generated
	 * @ordered
	 */
	protected String updatePasswordSql = UPDATE_PASSWORD_SQL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserIdColumnName() <em>User Id Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserIdColumnName()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_COLUMN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserIdColumnName() <em>User Id Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserIdColumnName()
	 * @generated
	 * @ordered
	 */
	protected String userIdColumnName = USER_ID_COLUMN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPasswordColumnName() <em>Password Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswordColumnName()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_COLUMN_NAME_EDEFAULT = "password"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getPasswordColumnName() <em>Password Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswordColumnName()
	 * @generated
	 * @ordered
	 */
	protected String passwordColumnName = PASSWORD_COLUMN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPasswordType() <em>Password Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswordType()
	 * @generated
	 * @ordered
	 */
	protected static final PasswordType PASSWORD_TYPE_EDEFAULT = PasswordType.PLAIN;

	/**
	 * The cached value of the '{@link #getPasswordType() <em>Password Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPasswordType()
	 * @generated
	 * @ordered
	 */
	protected PasswordType passwordType = PASSWORD_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JdbcUserServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.JDBC_USER_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortDescription() {
		return shortDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortDescription(String newShortDescription) {
		String oldShortDescription = shortDescription;
		shortDescription = newShortDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.JDBC_USER_SERVICE__SHORT_DESCRIPTION,
					oldShortDescription, shortDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.JDBC_USER_SERVICE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyEntry> getJdbcPropeties() {
		if (jdbcPropeties == null) {
			jdbcPropeties = new EObjectContainmentEList.Resolving<PropertyEntry>(
					PropertyEntry.class, this,
					OsgiPackage.JDBC_USER_SERVICE__JDBC_PROPETIES);
		}
		return jdbcPropeties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJdbcDriver() {
		return jdbcDriver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJdbcDriver(String newJdbcDriver) {
		String oldJdbcDriver = jdbcDriver;
		jdbcDriver = newJdbcDriver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.JDBC_USER_SERVICE__JDBC_DRIVER, oldJdbcDriver,
					jdbcDriver));
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
					OsgiPackage.JDBC_USER_SERVICE__AUTHORATIVE, oldAuthorative,
					authorative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFindUserSql() {
		return findUserSql;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFindUserSql(String newFindUserSql) {
		String oldFindUserSql = findUserSql;
		findUserSql = newFindUserSql;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.JDBC_USER_SERVICE__FIND_USER_SQL,
					oldFindUserSql, findUserSql));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFindRolesForUserSql() {
		return findRolesForUserSql;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFindRolesForUserSql(String newFindRolesForUserSql) {
		String oldFindRolesForUserSql = findRolesForUserSql;
		findRolesForUserSql = newFindRolesForUserSql;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL,
					oldFindRolesForUserSql, findRolesForUserSql));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUpdatePasswordSql() {
		return updatePasswordSql;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdatePasswordSql(String newUpdatePasswordSql) {
		String oldUpdatePasswordSql = updatePasswordSql;
		updatePasswordSql = newUpdatePasswordSql;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL,
					oldUpdatePasswordSql, updatePasswordSql));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserIdColumnName() {
		return userIdColumnName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserIdColumnName(String newUserIdColumnName) {
		String oldUserIdColumnName = userIdColumnName;
		userIdColumnName = newUserIdColumnName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.JDBC_USER_SERVICE__USER_ID_COLUMN_NAME,
					oldUserIdColumnName, userIdColumnName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPasswordColumnName() {
		return passwordColumnName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordColumnName(String newPasswordColumnName) {
		String oldPasswordColumnName = passwordColumnName;
		passwordColumnName = newPasswordColumnName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME,
					oldPasswordColumnName, passwordColumnName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PasswordType getPasswordType() {
		return passwordType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPasswordType(PasswordType newPasswordType) {
		PasswordType oldPasswordType = passwordType;
		passwordType = newPasswordType == null ? PASSWORD_TYPE_EDEFAULT
				: newPasswordType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.JDBC_USER_SERVICE__PASSWORD_TYPE,
					oldPasswordType, passwordType));
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
		case OsgiPackage.JDBC_USER_SERVICE__JDBC_PROPETIES:
			return ((InternalEList<?>) getJdbcPropeties()).basicRemove(
					otherEnd, msgs);
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
		case OsgiPackage.JDBC_USER_SERVICE__SHORT_DESCRIPTION:
			return getShortDescription();
		case OsgiPackage.JDBC_USER_SERVICE__NAME:
			return getName();
		case OsgiPackage.JDBC_USER_SERVICE__JDBC_PROPETIES:
			return getJdbcPropeties();
		case OsgiPackage.JDBC_USER_SERVICE__JDBC_DRIVER:
			return getJdbcDriver();
		case OsgiPackage.JDBC_USER_SERVICE__AUTHORATIVE:
			return isAuthorative();
		case OsgiPackage.JDBC_USER_SERVICE__FIND_USER_SQL:
			return getFindUserSql();
		case OsgiPackage.JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL:
			return getFindRolesForUserSql();
		case OsgiPackage.JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL:
			return getUpdatePasswordSql();
		case OsgiPackage.JDBC_USER_SERVICE__USER_ID_COLUMN_NAME:
			return getUserIdColumnName();
		case OsgiPackage.JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME:
			return getPasswordColumnName();
		case OsgiPackage.JDBC_USER_SERVICE__PASSWORD_TYPE:
			return getPasswordType();
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
		case OsgiPackage.JDBC_USER_SERVICE__SHORT_DESCRIPTION:
			setShortDescription((String) newValue);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__NAME:
			setName((String) newValue);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__JDBC_PROPETIES:
			getJdbcPropeties().clear();
			getJdbcPropeties().addAll(
					(Collection<? extends PropertyEntry>) newValue);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__JDBC_DRIVER:
			setJdbcDriver((String) newValue);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__AUTHORATIVE:
			setAuthorative((Boolean) newValue);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__FIND_USER_SQL:
			setFindUserSql((String) newValue);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL:
			setFindRolesForUserSql((String) newValue);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL:
			setUpdatePasswordSql((String) newValue);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__USER_ID_COLUMN_NAME:
			setUserIdColumnName((String) newValue);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME:
			setPasswordColumnName((String) newValue);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__PASSWORD_TYPE:
			setPasswordType((PasswordType) newValue);
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
		case OsgiPackage.JDBC_USER_SERVICE__SHORT_DESCRIPTION:
			setShortDescription(SHORT_DESCRIPTION_EDEFAULT);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__JDBC_PROPETIES:
			getJdbcPropeties().clear();
			return;
		case OsgiPackage.JDBC_USER_SERVICE__JDBC_DRIVER:
			setJdbcDriver(JDBC_DRIVER_EDEFAULT);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__AUTHORATIVE:
			setAuthorative(AUTHORATIVE_EDEFAULT);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__FIND_USER_SQL:
			setFindUserSql(FIND_USER_SQL_EDEFAULT);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL:
			setFindRolesForUserSql(FIND_ROLES_FOR_USER_SQL_EDEFAULT);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL:
			setUpdatePasswordSql(UPDATE_PASSWORD_SQL_EDEFAULT);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__USER_ID_COLUMN_NAME:
			setUserIdColumnName(USER_ID_COLUMN_NAME_EDEFAULT);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME:
			setPasswordColumnName(PASSWORD_COLUMN_NAME_EDEFAULT);
			return;
		case OsgiPackage.JDBC_USER_SERVICE__PASSWORD_TYPE:
			setPasswordType(PASSWORD_TYPE_EDEFAULT);
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
		case OsgiPackage.JDBC_USER_SERVICE__SHORT_DESCRIPTION:
			return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null
					: !SHORT_DESCRIPTION_EDEFAULT.equals(shortDescription);
		case OsgiPackage.JDBC_USER_SERVICE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case OsgiPackage.JDBC_USER_SERVICE__JDBC_PROPETIES:
			return jdbcPropeties != null && !jdbcPropeties.isEmpty();
		case OsgiPackage.JDBC_USER_SERVICE__JDBC_DRIVER:
			return JDBC_DRIVER_EDEFAULT == null ? jdbcDriver != null
					: !JDBC_DRIVER_EDEFAULT.equals(jdbcDriver);
		case OsgiPackage.JDBC_USER_SERVICE__AUTHORATIVE:
			return authorative != AUTHORATIVE_EDEFAULT;
		case OsgiPackage.JDBC_USER_SERVICE__FIND_USER_SQL:
			return FIND_USER_SQL_EDEFAULT == null ? findUserSql != null
					: !FIND_USER_SQL_EDEFAULT.equals(findUserSql);
		case OsgiPackage.JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL:
			return FIND_ROLES_FOR_USER_SQL_EDEFAULT == null ? findRolesForUserSql != null
					: !FIND_ROLES_FOR_USER_SQL_EDEFAULT
							.equals(findRolesForUserSql);
		case OsgiPackage.JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL:
			return UPDATE_PASSWORD_SQL_EDEFAULT == null ? updatePasswordSql != null
					: !UPDATE_PASSWORD_SQL_EDEFAULT.equals(updatePasswordSql);
		case OsgiPackage.JDBC_USER_SERVICE__USER_ID_COLUMN_NAME:
			return USER_ID_COLUMN_NAME_EDEFAULT == null ? userIdColumnName != null
					: !USER_ID_COLUMN_NAME_EDEFAULT.equals(userIdColumnName);
		case OsgiPackage.JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME:
			return PASSWORD_COLUMN_NAME_EDEFAULT == null ? passwordColumnName != null
					: !PASSWORD_COLUMN_NAME_EDEFAULT.equals(passwordColumnName);
		case OsgiPackage.JDBC_USER_SERVICE__PASSWORD_TYPE:
			return passwordType != PASSWORD_TYPE_EDEFAULT;
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
		result.append(" (shortDescription: "); //$NON-NLS-1$
		result.append(shortDescription);
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", jdbcDriver: "); //$NON-NLS-1$
		result.append(jdbcDriver);
		result.append(", authorative: "); //$NON-NLS-1$
		result.append(authorative);
		result.append(", findUserSql: "); //$NON-NLS-1$
		result.append(findUserSql);
		result.append(", findRolesForUserSql: "); //$NON-NLS-1$
		result.append(findRolesForUserSql);
		result.append(", updatePasswordSql: "); //$NON-NLS-1$
		result.append(updatePasswordSql);
		result.append(", userIdColumnName: "); //$NON-NLS-1$
		result.append(userIdColumnName);
		result.append(", passwordColumnName: "); //$NON-NLS-1$
		result.append(passwordColumnName);
		result.append(", passwordType: "); //$NON-NLS-1$
		result.append(passwordType);
		result.append(')');
		return result.toString();
	}

} //JdbcUserServiceImpl
