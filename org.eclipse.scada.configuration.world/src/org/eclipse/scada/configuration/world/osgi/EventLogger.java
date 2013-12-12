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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Logger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogAttributesChange <em>Log Attributes Change</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogValueChange <em>Log Value Change</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogSubscriptionChange <em>Log Subscription Change</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogWrites <em>Log Writes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventLogger()
 * @model
 * @generated
 */
public interface EventLogger extends ItemFeatureEntry {
	/**
	 * Returns the value of the '<em><b>Log Attributes Change</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Attributes Change</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Attributes Change</em>' attribute.
	 * @see #setLogAttributesChange(boolean)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventLogger_LogAttributesChange()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isLogAttributesChange();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogAttributesChange <em>Log Attributes Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Attributes Change</em>' attribute.
	 * @see #isLogAttributesChange()
	 * @generated
	 */
	void setLogAttributesChange(boolean value);

	/**
	 * Returns the value of the '<em><b>Log Value Change</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Value Change</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Value Change</em>' attribute.
	 * @see #setLogValueChange(boolean)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventLogger_LogValueChange()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isLogValueChange();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogValueChange <em>Log Value Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Value Change</em>' attribute.
	 * @see #isLogValueChange()
	 * @generated
	 */
	void setLogValueChange(boolean value);

	/**
	 * Returns the value of the '<em><b>Log Subscription Change</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Subscription Change</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Subscription Change</em>' attribute.
	 * @see #setLogSubscriptionChange(boolean)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventLogger_LogSubscriptionChange()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isLogSubscriptionChange();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogSubscriptionChange <em>Log Subscription Change</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Subscription Change</em>' attribute.
	 * @see #isLogSubscriptionChange()
	 * @generated
	 */
	void setLogSubscriptionChange(boolean value);

	/**
	 * Returns the value of the '<em><b>Log Writes</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Writes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Writes</em>' attribute.
	 * @see #setLogWrites(boolean)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventLogger_LogWrites()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isLogWrites();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogWrites <em>Log Writes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Writes</em>' attribute.
	 * @see #isLogWrites()
	 * @generated
	 */
	void setLogWrites(boolean value);

} // EventLogger
