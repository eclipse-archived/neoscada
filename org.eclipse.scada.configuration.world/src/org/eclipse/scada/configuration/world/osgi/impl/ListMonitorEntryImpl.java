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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.configuration.world.osgi.ListMonitorEntry;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.core.Variant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Monitor Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorEntryImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorEntryImpl#getRequireAck <em>Require Ack</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorEntryImpl#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListMonitorEntryImpl extends MinimalEObjectImpl.Container
        implements ListMonitorEntry
{
    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final Variant VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected Variant value = VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getRequireAck() <em>Require Ack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequireAck()
     * @generated
     * @ordered
     */
    protected static final Boolean REQUIRE_ACK_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRequireAck() <em>Require Ack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRequireAck()
     * @generated
     * @ordered
     */
    protected Boolean requireAck = REQUIRE_ACK_EDEFAULT;

    /**
     * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSeverity()
     * @generated
     * @ordered
     */
    protected static final Severity SEVERITY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSeverity()
     * @generated
     * @ordered
     */
    protected Severity severity = SEVERITY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ListMonitorEntryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return OsgiPackage.Literals.LIST_MONITOR_ENTRY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Variant getValue ()
    {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValue ( Variant newValue )
    {
        Variant oldValue = value;
        value = newValue;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LIST_MONITOR_ENTRY__VALUE, oldValue, value ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getRequireAck ()
    {
        return requireAck;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRequireAck ( Boolean newRequireAck )
    {
        Boolean oldRequireAck = requireAck;
        requireAck = newRequireAck;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LIST_MONITOR_ENTRY__REQUIRE_ACK, oldRequireAck, requireAck ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Severity getSeverity ()
    {
        return severity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSeverity ( Severity newSeverity )
    {
        Severity oldSeverity = severity;
        severity = newSeverity;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LIST_MONITOR_ENTRY__SEVERITY, oldSeverity, severity ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case OsgiPackage.LIST_MONITOR_ENTRY__VALUE:
                return getValue ();
            case OsgiPackage.LIST_MONITOR_ENTRY__REQUIRE_ACK:
                return getRequireAck ();
            case OsgiPackage.LIST_MONITOR_ENTRY__SEVERITY:
                return getSeverity ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case OsgiPackage.LIST_MONITOR_ENTRY__VALUE:
                setValue ( (Variant)newValue );
                return;
            case OsgiPackage.LIST_MONITOR_ENTRY__REQUIRE_ACK:
                setRequireAck ( (Boolean)newValue );
                return;
            case OsgiPackage.LIST_MONITOR_ENTRY__SEVERITY:
                setSeverity ( (Severity)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case OsgiPackage.LIST_MONITOR_ENTRY__VALUE:
                setValue ( VALUE_EDEFAULT );
                return;
            case OsgiPackage.LIST_MONITOR_ENTRY__REQUIRE_ACK:
                setRequireAck ( REQUIRE_ACK_EDEFAULT );
                return;
            case OsgiPackage.LIST_MONITOR_ENTRY__SEVERITY:
                setSeverity ( SEVERITY_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case OsgiPackage.LIST_MONITOR_ENTRY__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals ( value );
            case OsgiPackage.LIST_MONITOR_ENTRY__REQUIRE_ACK:
                return REQUIRE_ACK_EDEFAULT == null ? requireAck != null : !REQUIRE_ACK_EDEFAULT.equals ( requireAck );
            case OsgiPackage.LIST_MONITOR_ENTRY__SEVERITY:
                return SEVERITY_EDEFAULT == null ? severity != null : !SEVERITY_EDEFAULT.equals ( severity );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (value: " ); //$NON-NLS-1$
        result.append ( value );
        result.append ( ", requireAck: " ); //$NON-NLS-1$
        result.append ( requireAck );
        result.append ( ", severity: " ); //$NON-NLS-1$
        result.append ( severity );
        result.append ( ')' );
        return result.toString ();
    }

} //ListMonitorEntryImpl
