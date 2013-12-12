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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.ItemInformation;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ItemInformationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ItemInformationImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ItemInformationImpl#getHierarchy <em>Hierarchy</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ItemInformationImpl#getSystem <em>System</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ItemInformationImpl#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ItemInformationImpl extends MinimalEObjectImpl.Container implements
		ItemInformation {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected String unit = UNIT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHierarchy() <em>Hierarchy</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHierarchy()
	 * @generated
	 * @ordered
	 */
	protected EList<String> hierarchy;

	/**
	 * The default value of the '{@link #getSystem() <em>System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystem()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystem() <em>System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystem()
	 * @generated
	 * @ordered
	 */
	protected String system = SYSTEM_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected static final DataType DATA_TYPE_EDEFAULT = DataType.VARIANT;

	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected DataType dataType = DATA_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItemInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.ITEM_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.ITEM_INFORMATION__DESCRIPTION, oldDescription,
					description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(String newUnit) {
		String oldUnit = unit;
		unit = newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.ITEM_INFORMATION__UNIT, oldUnit, unit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getHierarchy() {
		if (hierarchy == null) {
			hierarchy = new EDataTypeEList<String>(String.class, this,
					OsgiPackage.ITEM_INFORMATION__HIERARCHY);
		}
		return hierarchy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystem() {
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(String newSystem) {
		String oldSystem = system;
		system = newSystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.ITEM_INFORMATION__SYSTEM, oldSystem, system));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataType newDataType) {
		DataType oldDataType = dataType;
		dataType = newDataType == null ? DATA_TYPE_EDEFAULT : newDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsgiPackage.ITEM_INFORMATION__DATA_TYPE, oldDataType,
					dataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OsgiPackage.ITEM_INFORMATION__DESCRIPTION:
			return getDescription();
		case OsgiPackage.ITEM_INFORMATION__UNIT:
			return getUnit();
		case OsgiPackage.ITEM_INFORMATION__HIERARCHY:
			return getHierarchy();
		case OsgiPackage.ITEM_INFORMATION__SYSTEM:
			return getSystem();
		case OsgiPackage.ITEM_INFORMATION__DATA_TYPE:
			return getDataType();
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
		case OsgiPackage.ITEM_INFORMATION__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case OsgiPackage.ITEM_INFORMATION__UNIT:
			setUnit((String) newValue);
			return;
		case OsgiPackage.ITEM_INFORMATION__HIERARCHY:
			getHierarchy().clear();
			getHierarchy().addAll((Collection<? extends String>) newValue);
			return;
		case OsgiPackage.ITEM_INFORMATION__SYSTEM:
			setSystem((String) newValue);
			return;
		case OsgiPackage.ITEM_INFORMATION__DATA_TYPE:
			setDataType((DataType) newValue);
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
		case OsgiPackage.ITEM_INFORMATION__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case OsgiPackage.ITEM_INFORMATION__UNIT:
			setUnit(UNIT_EDEFAULT);
			return;
		case OsgiPackage.ITEM_INFORMATION__HIERARCHY:
			getHierarchy().clear();
			return;
		case OsgiPackage.ITEM_INFORMATION__SYSTEM:
			setSystem(SYSTEM_EDEFAULT);
			return;
		case OsgiPackage.ITEM_INFORMATION__DATA_TYPE:
			setDataType(DATA_TYPE_EDEFAULT);
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
		case OsgiPackage.ITEM_INFORMATION__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null
					: !DESCRIPTION_EDEFAULT.equals(description);
		case OsgiPackage.ITEM_INFORMATION__UNIT:
			return UNIT_EDEFAULT == null ? unit != null : !UNIT_EDEFAULT
					.equals(unit);
		case OsgiPackage.ITEM_INFORMATION__HIERARCHY:
			return hierarchy != null && !hierarchy.isEmpty();
		case OsgiPackage.ITEM_INFORMATION__SYSTEM:
			return SYSTEM_EDEFAULT == null ? system != null : !SYSTEM_EDEFAULT
					.equals(system);
		case OsgiPackage.ITEM_INFORMATION__DATA_TYPE:
			return dataType != DATA_TYPE_EDEFAULT;
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
		result.append(" (description: "); //$NON-NLS-1$
		result.append(description);
		result.append(", unit: "); //$NON-NLS-1$
		result.append(unit);
		result.append(", hierarchy: "); //$NON-NLS-1$
		result.append(hierarchy);
		result.append(", system: "); //$NON-NLS-1$
		result.append(system);
		result.append(", dataType: "); //$NON-NLS-1$
		result.append(dataType);
		result.append(')');
		return result.toString();
	}

} //ItemInformationImpl
