/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.common.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector;
import org.eclipse.scada.configuration.component.common.CommonPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Heartbeat Detector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.ChangeHeartbeatDetectorImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.ChangeHeartbeatDetectorImpl#getCheckPeriod <em>Check Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.ChangeHeartbeatDetectorImpl#getSourceItem <em>Source Item</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChangeHeartbeatDetectorImpl extends HeartbeatDetectorImpl implements ChangeHeartbeatDetector
{
    /**
     * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout()
     * @generated
     * @ordered
     */
    protected static final long TIMEOUT_EDEFAULT = 10000L;

    /**
     * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout()
     * @generated
     * @ordered
     */
    protected long timeout = TIMEOUT_EDEFAULT;

    /**
     * The default value of the '{@link #getCheckPeriod() <em>Check Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCheckPeriod()
     * @generated
     * @ordered
     */
    protected static final long CHECK_PERIOD_EDEFAULT = 1000L;

    /**
     * The cached value of the '{@link #getCheckPeriod() <em>Check Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCheckPeriod()
     * @generated
     * @ordered
     */
    protected long checkPeriod = CHECK_PERIOD_EDEFAULT;

    /**
     * The cached value of the '{@link #getSourceItem() <em>Source Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceItem()
     * @generated
     * @ordered
     */
    protected InputDefinition sourceItem;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChangeHeartbeatDetectorImpl ()
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
        return CommonPackage.Literals.CHANGE_HEARTBEAT_DETECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getTimeout ()
    {
        return timeout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimeout ( long newTimeout )
    {
        long oldTimeout = timeout;
        timeout = newTimeout;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.CHANGE_HEARTBEAT_DETECTOR__TIMEOUT, oldTimeout, timeout ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getCheckPeriod ()
    {
        return checkPeriod;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCheckPeriod ( long newCheckPeriod )
    {
        long oldCheckPeriod = checkPeriod;
        checkPeriod = newCheckPeriod;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.CHANGE_HEARTBEAT_DETECTOR__CHECK_PERIOD, oldCheckPeriod, checkPeriod ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition getSourceItem ()
    {
        return sourceItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSourceItem ( InputDefinition newSourceItem, NotificationChain msgs )
    {
        InputDefinition oldSourceItem = sourceItem;
        sourceItem = newSourceItem;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, CommonPackage.CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM, oldSourceItem, newSourceItem );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceItem ( InputDefinition newSourceItem )
    {
        if ( newSourceItem != sourceItem )
        {
            NotificationChain msgs = null;
            if ( sourceItem != null )
                msgs = ( (InternalEObject)sourceItem ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM, null, msgs );
            if ( newSourceItem != null )
                msgs = ( (InternalEObject)newSourceItem ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM, null, msgs );
            msgs = basicSetSourceItem ( newSourceItem, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM, newSourceItem, newSourceItem ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM:
                return basicSetSourceItem ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
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
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__TIMEOUT:
                return getTimeout ();
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__CHECK_PERIOD:
                return getCheckPeriod ();
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM:
                return getSourceItem ();
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
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__TIMEOUT:
                setTimeout ( (Long)newValue );
                return;
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__CHECK_PERIOD:
                setCheckPeriod ( (Long)newValue );
                return;
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM:
                setSourceItem ( (InputDefinition)newValue );
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
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__TIMEOUT:
                setTimeout ( TIMEOUT_EDEFAULT );
                return;
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__CHECK_PERIOD:
                setCheckPeriod ( CHECK_PERIOD_EDEFAULT );
                return;
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM:
                setSourceItem ( (InputDefinition)null );
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
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__TIMEOUT:
                return timeout != TIMEOUT_EDEFAULT;
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__CHECK_PERIOD:
                return checkPeriod != CHECK_PERIOD_EDEFAULT;
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM:
                return sourceItem != null;
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
        result.append ( " (timeout: " ); //$NON-NLS-1$
        result.append ( timeout );
        result.append ( ", checkPeriod: " ); //$NON-NLS-1$
        result.append ( checkPeriod );
        result.append ( ')' );
        return result.toString ();
    }

} //ChangeHeartbeatDetectorImpl
