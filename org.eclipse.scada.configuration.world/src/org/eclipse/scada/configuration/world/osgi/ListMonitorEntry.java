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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.core.Variant;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Monitor Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getRequireAck <em>Require Ack</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitorEntry()
 * @model
 * @generated
 */
public interface ListMonitorEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Variant)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitorEntry_Value()
	 * @model dataType="org.eclipse.scada.configuration.world.osgi.Variant" required="true"
	 * @generated
	 */
	Variant getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Variant value);

	/**
	 * Returns the value of the '<em><b>Require Ack</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Require Ack</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Require Ack</em>' attribute.
	 * @see #setRequireAck(Boolean)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitorEntry_RequireAck()
	 * @model
	 * @generated
	 */
	Boolean getRequireAck();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getRequireAck <em>Require Ack</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Require Ack</em>' attribute.
	 * @see #getRequireAck()
	 * @generated
	 */
	void setRequireAck(Boolean value);

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
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitorEntry_Severity()
	 * @model dataType="org.eclipse.scada.configuration.world.osgi.Severity"
	 * @generated
	 */
	Severity getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(Severity value);

} // ListMonitorEntry
