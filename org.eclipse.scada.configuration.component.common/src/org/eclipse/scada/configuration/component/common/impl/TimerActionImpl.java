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
import org.eclipse.scada.configuration.component.common.TimerAction;

import org.eclipse.scada.configuration.component.impl.MasterComponentImpl;

import org.eclipse.scada.core.Variant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timer Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.TimerActionImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.TimerActionImpl#getTargetItem <em>Target Item</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.TimerActionImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimerActionImpl extends MasterComponentImpl implements TimerAction
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TimerActionImpl ()
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
        return CommonPackage.Literals.TIMER_ACTION;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.TIMER_ACTION__PERIOD, oldPeriod, period ) );
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
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, CommonPackage.TIMER_ACTION__TARGET_ITEM, oldTargetItem, newTargetItem );
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
                msgs = ( (InternalEObject)targetItem ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.TIMER_ACTION__TARGET_ITEM, null, msgs );
            if ( newTargetItem != null )
                msgs = ( (InternalEObject)newTargetItem ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.TIMER_ACTION__TARGET_ITEM, null, msgs );
            msgs = basicSetTargetItem ( newTargetItem, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.TIMER_ACTION__TARGET_ITEM, newTargetItem, newTargetItem ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.TIMER_ACTION__VALUE, oldValue, value ) );
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
            case CommonPackage.TIMER_ACTION__TARGET_ITEM:
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
            case CommonPackage.TIMER_ACTION__PERIOD:
                return getPeriod ();
            case CommonPackage.TIMER_ACTION__TARGET_ITEM:
                return getTargetItem ();
            case CommonPackage.TIMER_ACTION__VALUE:
                return getValue ();
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
            case CommonPackage.TIMER_ACTION__PERIOD:
                setPeriod ( (Long)newValue );
                return;
            case CommonPackage.TIMER_ACTION__TARGET_ITEM:
                setTargetItem ( (InputDefinition)newValue );
                return;
            case CommonPackage.TIMER_ACTION__VALUE:
                setValue ( (Variant)newValue );
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
            case CommonPackage.TIMER_ACTION__PERIOD:
                setPeriod ( PERIOD_EDEFAULT );
                return;
            case CommonPackage.TIMER_ACTION__TARGET_ITEM:
                setTargetItem ( (InputDefinition)null );
                return;
            case CommonPackage.TIMER_ACTION__VALUE:
                setValue ( VALUE_EDEFAULT );
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
            case CommonPackage.TIMER_ACTION__PERIOD:
                return period != PERIOD_EDEFAULT;
            case CommonPackage.TIMER_ACTION__TARGET_ITEM:
                return targetItem != null;
            case CommonPackage.TIMER_ACTION__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals ( value );
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
        result.append ( ", value: " ); //$NON-NLS-1$
        result.append ( value );
        result.append ( ')' );
        return result.toString ();
    }

} //TimerActionImpl
