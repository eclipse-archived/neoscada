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

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.ae.data.Severity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Monitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getMessageAttribute <em>Message Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#isDefaultAck <em>Default Ack</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getDefaultSeverity <em>Default Severity</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getMonitorType <em>Monitor Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getDemotePrefix <em>Demote Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitor()
 * @model
 * @generated
 */
public interface ListMonitor extends ItemFeatureEntry
{
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
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitor_Message()
     * @model
     * @generated
     */
    String getMessage ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getMessage <em>Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Message</em>' attribute.
     * @see #getMessage()
     * @generated
     */
    void setMessage ( String value );

    /**
     * Returns the value of the '<em><b>Message Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Message Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Message Attribute</em>' attribute.
     * @see #setMessageAttribute(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitor_MessageAttribute()
     * @model
     * @generated
     */
    String getMessageAttribute ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getMessageAttribute <em>Message Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Message Attribute</em>' attribute.
     * @see #getMessageAttribute()
     * @generated
     */
    void setMessageAttribute ( String value );

    /**
     * Returns the value of the '<em><b>Default Ack</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Ack</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Ack</em>' attribute.
     * @see #setDefaultAck(boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitor_DefaultAck()
     * @model default="false" required="true"
     * @generated
     */
    boolean isDefaultAck ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#isDefaultAck <em>Default Ack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Ack</em>' attribute.
     * @see #isDefaultAck()
     * @generated
     */
    void setDefaultAck ( boolean value );

    /**
     * Returns the value of the '<em><b>Default Severity</b></em>' attribute.
     * The default value is <code>"ALARM"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Severity</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Severity</em>' attribute.
     * @see #setDefaultSeverity(Severity)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitor_DefaultSeverity()
     * @model default="ALARM" dataType="org.eclipse.scada.configuration.world.osgi.Severity" required="true"
     * @generated
     */
    Severity getDefaultSeverity ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getDefaultSeverity <em>Default Severity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Severity</em>' attribute.
     * @see #getDefaultSeverity()
     * @generated
     */
    void setDefaultSeverity ( Severity value );

    /**
     * Returns the value of the '<em><b>Monitor Type</b></em>' attribute.
     * The default value is <code>"LIST"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Monitor Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Monitor Type</em>' attribute.
     * @see #setMonitorType(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitor_MonitorType()
     * @model default="LIST" required="true"
     * @generated
     */
    String getMonitorType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getMonitorType <em>Monitor Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Monitor Type</em>' attribute.
     * @see #getMonitorType()
     * @generated
     */
    void setMonitorType ( String value );

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
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitor_DemotePrefix()
     * @model
     * @generated
     */
    String getDemotePrefix ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getDemotePrefix <em>Demote Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Demote Prefix</em>' attribute.
     * @see #getDemotePrefix()
     * @generated
     */
    void setDemotePrefix ( String value );

    /**
     * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entries</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getListMonitor_Entries()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ListMonitorEntry> getEntries ();

} // ListMonitor
