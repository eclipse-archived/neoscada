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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.osgi.JdbcDataMapper;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jdbc Data Mapper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcDataMapperImpl#getJdbcDriver <em>Jdbc Driver</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcDataMapperImpl#getSql <em>Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcDataMapperImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JdbcDataMapperImpl extends DataMapperImpl implements
		JdbcDataMapper {
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
	 * The default value of the '{@link #getSql() <em>Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSql()
	 * @generated
	 * @ordered
	 */
	protected static final String SQL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSql() <em>Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSql()
	 * @generated
	 * @ordered
	 */
	protected String sql = SQL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyEntry> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JdbcDataMapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.JDBC_DATA_MAPPER;
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
					OsgiPackage.JDBC_DATA_MAPPER__JDBC_DRIVER, oldJdbcDriver,
					jdbcDriver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSql() {
		return sql;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSql(String newSql) {
		String oldSql = sql;
		sql = newSql;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.JDBC_DATA_MAPPER__SQL, oldSql, sql));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyEntry> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList.Resolving<PropertyEntry>(
					PropertyEntry.class, this,
					OsgiPackage.JDBC_DATA_MAPPER__PROPERTIES);
		}
		return properties;
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
		case OsgiPackage.JDBC_DATA_MAPPER__PROPERTIES:
			return ((InternalEList<?>) getProperties()).basicRemove(otherEnd,
					msgs);
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
		case OsgiPackage.JDBC_DATA_MAPPER__JDBC_DRIVER:
			return getJdbcDriver();
		case OsgiPackage.JDBC_DATA_MAPPER__SQL:
			return getSql();
		case OsgiPackage.JDBC_DATA_MAPPER__PROPERTIES:
			return getProperties();
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
		case OsgiPackage.JDBC_DATA_MAPPER__JDBC_DRIVER:
			setJdbcDriver((String) newValue);
			return;
		case OsgiPackage.JDBC_DATA_MAPPER__SQL:
			setSql((String) newValue);
			return;
		case OsgiPackage.JDBC_DATA_MAPPER__PROPERTIES:
			getProperties().clear();
			getProperties().addAll(
					(Collection<? extends PropertyEntry>) newValue);
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
		case OsgiPackage.JDBC_DATA_MAPPER__JDBC_DRIVER:
			setJdbcDriver(JDBC_DRIVER_EDEFAULT);
			return;
		case OsgiPackage.JDBC_DATA_MAPPER__SQL:
			setSql(SQL_EDEFAULT);
			return;
		case OsgiPackage.JDBC_DATA_MAPPER__PROPERTIES:
			getProperties().clear();
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
		case OsgiPackage.JDBC_DATA_MAPPER__JDBC_DRIVER:
			return JDBC_DRIVER_EDEFAULT == null ? jdbcDriver != null
					: !JDBC_DRIVER_EDEFAULT.equals(jdbcDriver);
		case OsgiPackage.JDBC_DATA_MAPPER__SQL:
			return SQL_EDEFAULT == null ? sql != null : !SQL_EDEFAULT
					.equals(sql);
		case OsgiPackage.JDBC_DATA_MAPPER__PROPERTIES:
			return properties != null && !properties.isEmpty();
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
		result.append(" (jdbcDriver: "); //$NON-NLS-1$
		result.append(jdbcDriver);
		result.append(", sql: "); //$NON-NLS-1$
		result.append(sql);
		result.append(')');
		return result.toString();
	}

} //JdbcDataMapperImpl
