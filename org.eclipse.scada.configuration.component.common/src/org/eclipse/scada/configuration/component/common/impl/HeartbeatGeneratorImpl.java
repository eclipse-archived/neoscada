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
import org.eclipse.scada.configuration.component.common.CommonPackage;
import org.eclipse.scada.configuration.component.common.HeartbeatGenerator;

import org.eclipse.scada.configuration.component.impl.DataComponentImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Heartbeat Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.HeartbeatGeneratorImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.HeartbeatGeneratorImpl#getTargetItem <em>Target Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class HeartbeatGeneratorImpl extends DataComponentImpl implements HeartbeatGenerator
{
    /**
     * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected static final long PERIOD_EDEFAULT = 1000L;

    /**
     * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected long period = PERIOD_EDEFAULT;

    /**
     * The cached value of the '{@link #getTargetItem() <em>Target Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetItem()
     * @generated
     * @ordered
     */
    protected InputDefinition targetItem;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HeartbeatGeneratorImpl ()
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
        return CommonPackage.Literals.HEARTBEAT_GENERATOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getPeriod ()
    {
        return period;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPeriod ( long newPeriod )
    {
        long oldPeriod = period;
        period = newPeriod;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.HEARTBEAT_GENERATOR__PERIOD, oldPeriod, period ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition getTargetItem ()
    {
        return targetItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTargetItem ( InputDefinition newTargetItem, NotificationChain msgs )
    {
        InputDefinition oldTargetItem = targetItem;
        targetItem = newTargetItem;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, CommonPackage.HEARTBEAT_GENERATOR__TARGET_ITEM, oldTargetItem, newTargetItem );
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
    public void setTargetItem ( InputDefinition newTargetItem )
    {
        if ( newTargetItem != targetItem )
        {
            NotificationChain msgs = null;
            if ( targetItem != null )
                msgs = ( (InternalEObject)targetItem ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.HEARTBEAT_GENERATOR__TARGET_ITEM, null, msgs );
            if ( newTargetItem != null )
                msgs = ( (InternalEObject)newTargetItem ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.HEARTBEAT_GENERATOR__TARGET_ITEM, null, msgs );
            msgs = basicSetTargetItem ( newTargetItem, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.HEARTBEAT_GENERATOR__TARGET_ITEM, newTargetItem, newTargetItem ) );
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
            case CommonPackage.HEARTBEAT_GENERATOR__TARGET_ITEM:
                return basicSetTargetItem ( null, msgs );
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
            case CommonPackage.HEARTBEAT_GENERATOR__PERIOD:
                return getPeriod ();
            case CommonPackage.HEARTBEAT_GENERATOR__TARGET_ITEM:
                return getTargetItem ();
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
            case CommonPackage.HEARTBEAT_GENERATOR__PERIOD:
                setPeriod ( (Long)newValue );
                return;
            case CommonPackage.HEARTBEAT_GENERATOR__TARGET_ITEM:
                setTargetItem ( (InputDefinition)newValue );
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
            case CommonPackage.HEARTBEAT_GENERATOR__PERIOD:
                setPeriod ( PERIOD_EDEFAULT );
                return;
            case CommonPackage.HEARTBEAT_GENERATOR__TARGET_ITEM:
                setTargetItem ( (InputDefinition)null );
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
            case CommonPackage.HEARTBEAT_GENERATOR__PERIOD:
                return period != PERIOD_EDEFAULT;
            case CommonPackage.HEARTBEAT_GENERATOR__TARGET_ITEM:
                return targetItem != null;
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
        result.append ( " (period: " ); //$NON-NLS-1$
        result.append ( period );
        result.append ( ')' );
        return result.toString ();
    }

} //HeartbeatGeneratorImpl
