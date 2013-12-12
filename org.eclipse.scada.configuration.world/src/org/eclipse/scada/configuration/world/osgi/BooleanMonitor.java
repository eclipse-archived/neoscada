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
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.scada.ae.data.Severity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Monitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isReferenceValue <em>Reference Value</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isActive <em>Active</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getDemotePrefix <em>Demote Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isSuppressEvents <em>Suppress Events</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isRequireAck <em>Require Ack</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBooleanMonitor()
 * @model
 * @generated
 */
public interface BooleanMonitor extends ItemFeatureEntry {
	/**
	 * Returns the value of the '<em><b>Reference Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Value</em>' attribute.
	 * @see #setReferenceValue(boolean)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBooleanMonitor_ReferenceValue()
	 * @model required="true"
	 * @generated
	 */
	boolean isReferenceValue();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isReferenceValue <em>Reference Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Value</em>' attribute.
	 * @see #isReferenceValue()
	 * @generated
	 */
	void setReferenceValue(boolean value);

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBooleanMonitor_Active()
	 * @model required="true"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Demote Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demote Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demote Prefix</em>' attribute.
	 * @see #setDemotePrefix(String)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBooleanMonitor_DemotePrefix()
	 * @model
	 * @generated
	 */
	String getDemotePrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getDemotePrefix <em>Demote Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Demote Prefix</em>' attribute.
	 * @see #getDemotePrefix()
	 * @generated
	 */
	void setDemotePrefix(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see #setSeverity(Severity)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBooleanMonitor_Severity()
	 * @model dataType="org.eclipse.scada.configuration.world.osgi.Severity" required="true"
	 * @generated
	 */
	Severity getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(Severity value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBooleanMonitor_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Suppress Events</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suppress Events</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suppress Events</em>' attribute.
	 * @see #setSuppressEvents(boolean)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBooleanMonitor_SuppressEvents()
	 * @model required="true"
	 * @generated
	 */
	boolean isSuppressEvents();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isSuppressEvents <em>Suppress Events</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suppress Events</em>' attribute.
	 * @see #isSuppressEvents()
	 * @generated
	 */
	void setSuppressEvents(boolean value);

	/**
	 * Returns the value of the '<em><b>Require Ack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Require Ack</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Require Ack</em>' attribute.
	 * @see #setRequireAck(boolean)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBooleanMonitor_RequireAck()
	 * @model required="true"
	 * @generated
	 */
	boolean isRequireAck();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isRequireAck <em>Require Ack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Require Ack</em>' attribute.
	 * @see #isRequireAck()
	 * @generated
	 */
	void setRequireAck(boolean value);

} // BooleanMonitor
