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
import org.eclipse.scada.configuration.world.osgi.LevelMonitor;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Level Monitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl#getPreset <em>Preset</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl#isCap <em>Cap</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl#isLowerOk <em>Lower Ok</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl#isIncludedOk <em>Included Ok</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl#getDemotePrefix <em>Demote Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl#isSuppressEvents <em>Suppress Events</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl#isRequireAck <em>Require Ack</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl#getMonitorType <em>Monitor Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LevelMonitorImpl extends ItemFeatureEntryImpl implements LevelMonitor
{
    /**
     * The default value of the '{@link #getPreset() <em>Preset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPreset()
     * @generated
     * @ordered
     */
    protected static final Double PRESET_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPreset() <em>Preset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPreset()
     * @generated
     * @ordered
     */
    protected Double preset = PRESET_EDEFAULT;

    /**
     * The default value of the '{@link #isCap() <em>Cap</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isCap()
     * @generated
     * @ordered
     */
    protected static final boolean CAP_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isCap() <em>Cap</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isCap()
     * @generated
     * @ordered
     */
    protected boolean cap = CAP_EDEFAULT;

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
     * The default value of the '{@link #isLowerOk() <em>Lower Ok</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLowerOk()
     * @generated
     * @ordered
     */
    protected static final boolean LOWER_OK_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isLowerOk() <em>Lower Ok</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLowerOk()
     * @generated
     * @ordered
     */
    protected boolean lowerOk = LOWER_OK_EDEFAULT;

    /**
     * The default value of the '{@link #isIncludedOk() <em>Included Ok</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIncludedOk()
     * @generated
     * @ordered
     */
    protected static final boolean INCLUDED_OK_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIncludedOk() <em>Included Ok</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIncludedOk()
     * @generated
     * @ordered
     */
    protected boolean includedOk = INCLUDED_OK_EDEFAULT;

    /**
     * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected static final String PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected String prefix = PREFIX_EDEFAULT;

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
     * The default value of the '{@link #getMonitorType() <em>Monitor Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMonitorType()
     * @generated
     * @ordered
     */
    protected static final String MONITOR_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMonitorType() <em>Monitor Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMonitorType()
     * @generated
     * @ordered
     */
    protected String monitorType = MONITOR_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LevelMonitorImpl ()
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
        return OsgiPackage.Literals.LEVEL_MONITOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Double getPreset ()
    {
        return preset;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPreset ( Double newPreset )
    {
        Double oldPreset = preset;
        preset = newPreset;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LEVEL_MONITOR__PRESET, oldPreset, preset ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isCap ()
    {
        return cap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCap ( boolean newCap )
    {
        boolean oldCap = cap;
        cap = newCap;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LEVEL_MONITOR__CAP, oldCap, cap ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LEVEL_MONITOR__SEVERITY, oldSeverity, severity ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLowerOk ()
    {
        return lowerOk;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLowerOk ( boolean newLowerOk )
    {
        boolean oldLowerOk = lowerOk;
        lowerOk = newLowerOk;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LEVEL_MONITOR__LOWER_OK, oldLowerOk, lowerOk ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIncludedOk ()
    {
        return includedOk;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIncludedOk ( boolean newIncludedOk )
    {
        boolean oldIncludedOk = includedOk;
        includedOk = newIncludedOk;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LEVEL_MONITOR__INCLUDED_OK, oldIncludedOk, includedOk ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPrefix ()
    {
        return prefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrefix ( String newPrefix )
    {
        String oldPrefix = prefix;
        prefix = newPrefix;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LEVEL_MONITOR__PREFIX, oldPrefix, prefix ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LEVEL_MONITOR__DEMOTE_PREFIX, oldDemotePrefix, demotePrefix ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LEVEL_MONITOR__SUPPRESS_EVENTS, oldSuppressEvents, suppressEvents ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LEVEL_MONITOR__REQUIRE_ACK, oldRequireAck, requireAck ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMonitorType ()
    {
        return monitorType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMonitorType ( String newMonitorType )
    {
        String oldMonitorType = monitorType;
        monitorType = newMonitorType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LEVEL_MONITOR__MONITOR_TYPE, oldMonitorType, monitorType ) );
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
            case OsgiPackage.LEVEL_MONITOR__PRESET:
                return getPreset ();
            case OsgiPackage.LEVEL_MONITOR__CAP:
                return isCap ();
            case OsgiPackage.LEVEL_MONITOR__SEVERITY:
                return getSeverity ();
            case OsgiPackage.LEVEL_MONITOR__LOWER_OK:
                return isLowerOk ();
            case OsgiPackage.LEVEL_MONITOR__INCLUDED_OK:
                return isIncludedOk ();
            case OsgiPackage.LEVEL_MONITOR__PREFIX:
                return getPrefix ();
            case OsgiPackage.LEVEL_MONITOR__DEMOTE_PREFIX:
                return getDemotePrefix ();
            case OsgiPackage.LEVEL_MONITOR__SUPPRESS_EVENTS:
                return isSuppressEvents ();
            case OsgiPackage.LEVEL_MONITOR__REQUIRE_ACK:
                return isRequireAck ();
            case OsgiPackage.LEVEL_MONITOR__MONITOR_TYPE:
                return getMonitorType ();
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
            case OsgiPackage.LEVEL_MONITOR__PRESET:
                setPreset ( (Double)newValue );
                return;
            case OsgiPackage.LEVEL_MONITOR__CAP:
                setCap ( (Boolean)newValue );
                return;
            case OsgiPackage.LEVEL_MONITOR__SEVERITY:
                setSeverity ( (Severity)newValue );
                return;
            case OsgiPackage.LEVEL_MONITOR__LOWER_OK:
                setLowerOk ( (Boolean)newValue );
                return;
            case OsgiPackage.LEVEL_MONITOR__INCLUDED_OK:
                setIncludedOk ( (Boolean)newValue );
                return;
            case OsgiPackage.LEVEL_MONITOR__PREFIX:
                setPrefix ( (String)newValue );
                return;
            case OsgiPackage.LEVEL_MONITOR__DEMOTE_PREFIX:
                setDemotePrefix ( (String)newValue );
                return;
            case OsgiPackage.LEVEL_MONITOR__SUPPRESS_EVENTS:
                setSuppressEvents ( (Boolean)newValue );
                return;
            case OsgiPackage.LEVEL_MONITOR__REQUIRE_ACK:
                setRequireAck ( (Boolean)newValue );
                return;
            case OsgiPackage.LEVEL_MONITOR__MONITOR_TYPE:
                setMonitorType ( (String)newValue );
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
            case OsgiPackage.LEVEL_MONITOR__PRESET:
                setPreset ( PRESET_EDEFAULT );
                return;
            case OsgiPackage.LEVEL_MONITOR__CAP:
                setCap ( CAP_EDEFAULT );
                return;
            case OsgiPackage.LEVEL_MONITOR__SEVERITY:
                setSeverity ( SEVERITY_EDEFAULT );
                return;
            case OsgiPackage.LEVEL_MONITOR__LOWER_OK:
                setLowerOk ( LOWER_OK_EDEFAULT );
                return;
            case OsgiPackage.LEVEL_MONITOR__INCLUDED_OK:
                setIncludedOk ( INCLUDED_OK_EDEFAULT );
                return;
            case OsgiPackage.LEVEL_MONITOR__PREFIX:
                setPrefix ( PREFIX_EDEFAULT );
                return;
            case OsgiPackage.LEVEL_MONITOR__DEMOTE_PREFIX:
                setDemotePrefix ( DEMOTE_PREFIX_EDEFAULT );
                return;
            case OsgiPackage.LEVEL_MONITOR__SUPPRESS_EVENTS:
                setSuppressEvents ( SUPPRESS_EVENTS_EDEFAULT );
                return;
            case OsgiPackage.LEVEL_MONITOR__REQUIRE_ACK:
                setRequireAck ( REQUIRE_ACK_EDEFAULT );
                return;
            case OsgiPackage.LEVEL_MONITOR__MONITOR_TYPE:
                setMonitorType ( MONITOR_TYPE_EDEFAULT );
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
            case OsgiPackage.LEVEL_MONITOR__PRESET:
                return PRESET_EDEFAULT == null ? preset != null : !PRESET_EDEFAULT.equals ( preset );
            case OsgiPackage.LEVEL_MONITOR__CAP:
                return cap != CAP_EDEFAULT;
            case OsgiPackage.LEVEL_MONITOR__SEVERITY:
                return SEVERITY_EDEFAULT == null ? severity != null : !SEVERITY_EDEFAULT.equals ( severity );
            case OsgiPackage.LEVEL_MONITOR__LOWER_OK:
                return lowerOk != LOWER_OK_EDEFAULT;
            case OsgiPackage.LEVEL_MONITOR__INCLUDED_OK:
                return includedOk != INCLUDED_OK_EDEFAULT;
            case OsgiPackage.LEVEL_MONITOR__PREFIX:
                return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals ( prefix );
            case OsgiPackage.LEVEL_MONITOR__DEMOTE_PREFIX:
                return DEMOTE_PREFIX_EDEFAULT == null ? demotePrefix != null : !DEMOTE_PREFIX_EDEFAULT.equals ( demotePrefix );
            case OsgiPackage.LEVEL_MONITOR__SUPPRESS_EVENTS:
                return suppressEvents != SUPPRESS_EVENTS_EDEFAULT;
            case OsgiPackage.LEVEL_MONITOR__REQUIRE_ACK:
                return requireAck != REQUIRE_ACK_EDEFAULT;
            case OsgiPackage.LEVEL_MONITOR__MONITOR_TYPE:
                return MONITOR_TYPE_EDEFAULT == null ? monitorType != null : !MONITOR_TYPE_EDEFAULT.equals ( monitorType );
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
        result.append ( " (preset: " ); //$NON-NLS-1$
        result.append ( preset );
        result.append ( ", cap: " ); //$NON-NLS-1$
        result.append ( cap );
        result.append ( ", severity: " ); //$NON-NLS-1$
        result.append ( severity );
        result.append ( ", lowerOk: " ); //$NON-NLS-1$
        result.append ( lowerOk );
        result.append ( ", includedOk: " ); //$NON-NLS-1$
        result.append ( includedOk );
        result.append ( ", prefix: " ); //$NON-NLS-1$
        result.append ( prefix );
        result.append ( ", demotePrefix: " ); //$NON-NLS-1$
        result.append ( demotePrefix );
        result.append ( ", suppressEvents: " ); //$NON-NLS-1$
        result.append ( suppressEvents );
        result.append ( ", requireAck: " ); //$NON-NLS-1$
        result.append ( requireAck );
        result.append ( ", monitorType: " ); //$NON-NLS-1$
        result.append ( monitorType );
        result.append ( ')' );
        return result.toString ();
    }

} //LevelMonitorImpl
