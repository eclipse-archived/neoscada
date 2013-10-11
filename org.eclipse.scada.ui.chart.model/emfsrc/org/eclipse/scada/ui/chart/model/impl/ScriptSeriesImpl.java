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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.LineProperties;
import org.eclipse.scada.ui.chart.model.ScriptSeries;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ScriptSeriesImpl#getLineProperties <em>Line Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ScriptSeriesImpl#getScript <em>Script</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptSeriesImpl extends DataSeriesImpl implements ScriptSeries {
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
	 * The default value of the '{@link #getScript() <em>Script</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScript() <em>Script</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected String script = SCRIPT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScriptSeriesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChartPackage.Literals.SCRIPT_SERIES;
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
								- ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
						null, null);
				if (newLineProperties.eInternalContainer() == null) {
					msgs = newLineProperties
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
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
					ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
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
								- ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
						null, msgs);
			if (newLineProperties != null)
				msgs = ((InternalEObject) newLineProperties).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
						null, msgs);
			msgs = basicSetLineProperties(newLineProperties, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
					newLineProperties, newLineProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScript() {
		return script;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScript(String newScript) {
		String oldScript = script;
		script = newScript;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChartPackage.SCRIPT_SERIES__SCRIPT, oldScript, script));
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
		case ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES:
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
		case ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES:
			if (resolve)
				return getLineProperties();
			return basicGetLineProperties();
		case ChartPackage.SCRIPT_SERIES__SCRIPT:
			return getScript();
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
		case ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES:
			setLineProperties((LineProperties) newValue);
			return;
		case ChartPackage.SCRIPT_SERIES__SCRIPT:
			setScript((String) newValue);
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
		case ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES:
			setLineProperties((LineProperties) null);
			return;
		case ChartPackage.SCRIPT_SERIES__SCRIPT:
			setScript(SCRIPT_EDEFAULT);
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
		case ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES:
			return lineProperties != null;
		case ChartPackage.SCRIPT_SERIES__SCRIPT:
			return SCRIPT_EDEFAULT == null ? script != null : !SCRIPT_EDEFAULT
					.equals(script);
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
		result.append(" (script: "); //$NON-NLS-1$
		result.append(script);
		result.append(')');
		return result.toString();
	}

} //ScriptSeriesImpl
