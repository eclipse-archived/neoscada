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
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.configuration.world.osgi.BooleanMonitor;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Monitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl#isReferenceValue <em>Reference Value</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl#isActive <em>Active</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl#getDemotePrefix <em>Demote Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl#isSuppressEvents <em>Suppress Events</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl#isRequireAck <em>Require Ack</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanMonitorImpl extends ItemFeatureEntryImpl implements BooleanMonitor
{
    /**
     * The default value of the '{@link #isReferenceValue() <em>Reference Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReferenceValue()
     * @generated
     * @ordered
     */
    protected static final boolean REFERENCE_VALUE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isReferenceValue() <em>Reference Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReferenceValue()
     * @generated
     * @ordered
     */
    protected boolean referenceValue = REFERENCE_VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isActive()
     * @generated
     * @ordered
     */
    protected static final boolean ACTIVE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isActive()
     * @generated
     * @ordered
     */
    protected boolean active = ACTIVE_EDEFAULT;

    /**
     * The default value of the '{@link #getDemotePrefix() <em>Demote Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDemotePrefix()
     * @generated
     * @ordered
     */
    protected static final String DEMOTE_PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDemotePrefix() <em>Demote Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDemotePrefix()
     * @generated
     * @ordered
     */
    protected String demotePrefix = DEMOTE_PREFIX_EDEFAULT;

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
     * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessage()
     * @generated
     * @ordered
     */
    protected static final String MESSAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessage()
     * @generated
     * @ordered
     */
    protected String message = MESSAGE_EDEFAULT;

    /**
     * The default value of the '{@link #isSuppressEvents() <em>Suppress Events</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSuppressEvents()
     * @generated
     * @ordered
     */
    protected static final boolean SUPPRESS_EVENTS_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isSuppressEvents() <em>Suppress Events</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSuppressEvents()
     * @generated
     * @ordered
     */
    protected boolean suppressEvents = SUPPRESS_EVENTS_EDEFAULT;

    /**
     * The default value of the '{@link #isRequireAck() <em>Require Ack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRequireAck()
     * @generated
     * @ordered
     */
    protected static final boolean REQUIRE_ACK_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isRequireAck() <em>Require Ack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRequireAck()
     * @generated
     * @ordered
     */
    protected boolean requireAck = REQUIRE_ACK_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BooleanMonitorImpl ()
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
        return OsgiPackage.Literals.BOOLEAN_MONITOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isReferenceValue ()
    {
        return referenceValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReferenceValue ( boolean newReferenceValue )
    {
        boolean oldReferenceValue = referenceValue;
        referenceValue = newReferenceValue;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BOOLEAN_MONITOR__REFERENCE_VALUE, oldReferenceValue, referenceValue ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isActive ()
    {
        return active;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setActive ( boolean newActive )
    {
        boolean oldActive = active;
        active = newActive;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BOOLEAN_MONITOR__ACTIVE, oldActive, active ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDemotePrefix ()
    {
        return demotePrefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDemotePrefix ( String newDemotePrefix )
    {
        String oldDemotePrefix = demotePrefix;
        demotePrefix = newDemotePrefix;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BOOLEAN_MONITOR__DEMOTE_PREFIX, oldDemotePrefix, demotePrefix ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BOOLEAN_MONITOR__SEVERITY, oldSeverity, severity ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMessage ()
    {
        return message;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMessage ( String newMessage )
    {
        String oldMessage = message;
        message = newMessage;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BOOLEAN_MONITOR__MESSAGE, oldMessage, message ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSuppressEvents ()
    {
        return suppressEvents;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSuppressEvents ( boolean newSuppressEvents )
    {
        boolean oldSuppressEvents = suppressEvents;
        suppressEvents = newSuppressEvents;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BOOLEAN_MONITOR__SUPPRESS_EVENTS, oldSuppressEvents, suppressEvents ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isRequireAck ()
    {
        return requireAck;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRequireAck ( boolean newRequireAck )
    {
        boolean oldRequireAck = requireAck;
        requireAck = newRequireAck;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BOOLEAN_MONITOR__REQUIRE_ACK, oldRequireAck, requireAck ) );
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
            case OsgiPackage.BOOLEAN_MONITOR__REFERENCE_VALUE:
                return isReferenceValue ();
            case OsgiPackage.BOOLEAN_MONITOR__ACTIVE:
                return isActive ();
            case OsgiPackage.BOOLEAN_MONITOR__DEMOTE_PREFIX:
                return getDemotePrefix ();
            case OsgiPackage.BOOLEAN_MONITOR__SEVERITY:
                return getSeverity ();
            case OsgiPackage.BOOLEAN_MONITOR__MESSAGE:
                return getMessage ();
            case OsgiPackage.BOOLEAN_MONITOR__SUPPRESS_EVENTS:
                return isSuppressEvents ();
            case OsgiPackage.BOOLEAN_MONITOR__REQUIRE_ACK:
                return isRequireAck ();
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
            case OsgiPackage.BOOLEAN_MONITOR__REFERENCE_VALUE:
                setReferenceValue ( (Boolean)newValue );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__ACTIVE:
                setActive ( (Boolean)newValue );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__DEMOTE_PREFIX:
                setDemotePrefix ( (String)newValue );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__SEVERITY:
                setSeverity ( (Severity)newValue );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__MESSAGE:
                setMessage ( (String)newValue );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__SUPPRESS_EVENTS:
                setSuppressEvents ( (Boolean)newValue );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__REQUIRE_ACK:
                setRequireAck ( (Boolean)newValue );
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
            case OsgiPackage.BOOLEAN_MONITOR__REFERENCE_VALUE:
                setReferenceValue ( REFERENCE_VALUE_EDEFAULT );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__ACTIVE:
                setActive ( ACTIVE_EDEFAULT );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__DEMOTE_PREFIX:
                setDemotePrefix ( DEMOTE_PREFIX_EDEFAULT );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__SEVERITY:
                setSeverity ( SEVERITY_EDEFAULT );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__MESSAGE:
                setMessage ( MESSAGE_EDEFAULT );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__SUPPRESS_EVENTS:
                setSuppressEvents ( SUPPRESS_EVENTS_EDEFAULT );
                return;
            case OsgiPackage.BOOLEAN_MONITOR__REQUIRE_ACK:
                setRequireAck ( REQUIRE_ACK_EDEFAULT );
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
            case OsgiPackage.BOOLEAN_MONITOR__REFERENCE_VALUE:
                return referenceValue != REFERENCE_VALUE_EDEFAULT;
            case OsgiPackage.BOOLEAN_MONITOR__ACTIVE:
                return active != ACTIVE_EDEFAULT;
            case OsgiPackage.BOOLEAN_MONITOR__DEMOTE_PREFIX:
                return DEMOTE_PREFIX_EDEFAULT == null ? demotePrefix != null : !DEMOTE_PREFIX_EDEFAULT.equals ( demotePrefix );
            case OsgiPackage.BOOLEAN_MONITOR__SEVERITY:
                return SEVERITY_EDEFAULT == null ? severity != null : !SEVERITY_EDEFAULT.equals ( severity );
            case OsgiPackage.BOOLEAN_MONITOR__MESSAGE:
                return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals ( message );
            case OsgiPackage.BOOLEAN_MONITOR__SUPPRESS_EVENTS:
                return suppressEvents != SUPPRESS_EVENTS_EDEFAULT;
            case OsgiPackage.BOOLEAN_MONITOR__REQUIRE_ACK:
                return requireAck != REQUIRE_ACK_EDEFAULT;
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
        result.append ( " (referenceValue: " ); //$NON-NLS-1$
        result.append ( referenceValue );
        result.append ( ", active: " ); //$NON-NLS-1$
        result.append ( active );
        result.append ( ", demotePrefix: " ); //$NON-NLS-1$
        result.append ( demotePrefix );
        result.append ( ", severity: " ); //$NON-NLS-1$
        result.append ( severity );
        result.append ( ", message: " ); //$NON-NLS-1$
        result.append ( message );
        result.append ( ", suppressEvents: " ); //$NON-NLS-1$
        result.append ( suppressEvents );
        result.append ( ", requireAck: " ); //$NON-NLS-1$
        result.append ( requireAck );
        result.append ( ')' );
        return result.toString ();
    }

} //BooleanMonitorImpl
