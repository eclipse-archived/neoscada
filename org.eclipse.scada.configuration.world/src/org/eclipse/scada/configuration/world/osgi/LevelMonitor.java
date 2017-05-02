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
 * A representation of the model object '<em><b>Level Monitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getPreset <em>Preset</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isCap <em>Cap</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isLowerOk <em>Lower Ok</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isIncludedOk <em>Included Ok</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getDemotePrefix <em>Demote Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isSuppressEvents <em>Suppress Events</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isRequireAck <em>Require Ack</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getMonitorType <em>Monitor Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor()
 * @model
 * @generated
 */
public interface LevelMonitor extends ItemFeatureEntry
{
    /**
     * Returns the value of the '<em><b>Preset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Preset</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Preset</em>' attribute.
     * @see #setPreset(Double)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor_Preset()
     * @model
     * @generated
     */
    Double getPreset ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getPreset <em>Preset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Preset</em>' attribute.
     * @see #getPreset()
     * @generated
     */
    void setPreset ( Double value );

    /**
     * Returns the value of the '<em><b>Cap</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cap</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cap</em>' attribute.
     * @see #setCap(boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor_Cap()
     * @model required="true"
     * @generated
     */
    boolean isCap ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isCap <em>Cap</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cap</em>' attribute.
     * @see #isCap()
     * @generated
     */
    void setCap ( boolean value );

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
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor_Severity()
     * @model dataType="org.eclipse.scada.configuration.world.osgi.Severity" required="true"
     * @generated
     */
    Severity getSeverity ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getSeverity <em>Severity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Severity</em>' attribute.
     * @see #getSeverity()
     * @generated
     */
    void setSeverity ( Severity value );

    /**
     * Returns the value of the '<em><b>Lower Ok</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lower Ok</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Lower Ok</em>' attribute.
     * @see #setLowerOk(boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor_LowerOk()
     * @model required="true"
     * @generated
     */
    boolean isLowerOk ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isLowerOk <em>Lower Ok</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Lower Ok</em>' attribute.
     * @see #isLowerOk()
     * @generated
     */
    void setLowerOk ( boolean value );

    /**
     * Returns the value of the '<em><b>Included Ok</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Included Ok</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Included Ok</em>' attribute.
     * @see #setIncludedOk(boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor_IncludedOk()
     * @model required="true"
     * @generated
     */
    boolean isIncludedOk ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isIncludedOk <em>Included Ok</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Included Ok</em>' attribute.
     * @see #isIncludedOk()
     * @generated
     */
    void setIncludedOk ( boolean value );

    /**
     * Returns the value of the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Prefix</em>' attribute.
     * @see #setPrefix(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor_Prefix()
     * @model required="true"
     * @generated
     */
    String getPrefix ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getPrefix <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Prefix</em>' attribute.
     * @see #getPrefix()
     * @generated
     */
    void setPrefix ( String value );

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
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor_DemotePrefix()
     * @model
     * @generated
     */
    String getDemotePrefix ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getDemotePrefix <em>Demote Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Demote Prefix</em>' attribute.
     * @see #getDemotePrefix()
     * @generated
     */
    void setDemotePrefix ( String value );

    /**
     * Returns the value of the '<em><b>Suppress Events</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Suppress Events</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Suppress Events</em>' attribute.
     * @see #setSuppressEvents(boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor_SuppressEvents()
     * @model default="false"
     * @generated
     */
    boolean isSuppressEvents ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isSuppressEvents <em>Suppress Events</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Suppress Events</em>' attribute.
     * @see #isSuppressEvents()
     * @generated
     */
    void setSuppressEvents ( boolean value );

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
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor_RequireAck()
     * @model required="true"
     * @generated
     */
    boolean isRequireAck ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isRequireAck <em>Require Ack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Require Ack</em>' attribute.
     * @see #isRequireAck()
     * @generated
     */
    void setRequireAck ( boolean value );

    /**
     * Returns the value of the '<em><b>Monitor Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Monitor Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Monitor Type</em>' attribute.
     * @see #setMonitorType(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getLevelMonitor_MonitorType()
     * @model required="true"
     * @generated
     */
    String getMonitorType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getMonitorType <em>Monitor Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Monitor Type</em>' attribute.
     * @see #getMonitorType()
     * @generated
     */
    void setMonitorType ( String value );

} // LevelMonitor
