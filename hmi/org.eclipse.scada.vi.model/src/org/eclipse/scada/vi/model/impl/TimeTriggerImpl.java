/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.scada.vi.model.TimeTrigger;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TimeTriggerImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.TimeTriggerImpl#getOnTrigger <em>On Trigger</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeTriggerImpl extends EObjectImpl implements TimeTrigger
{
    /**
     * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected static final long PERIOD_EDEFAULT = 0L;

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
     * The default value of the '{@link #getOnTrigger() <em>On Trigger</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnTrigger()
     * @generated
     * @ordered
     */
    protected static final String ON_TRIGGER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnTrigger() <em>On Trigger</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnTrigger()
     * @generated
     * @ordered
     */
    protected String onTrigger = ON_TRIGGER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TimeTriggerImpl ()
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
        return VisualInterfacePackage.Literals.TIME_TRIGGER;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TIME_TRIGGER__PERIOD, oldPeriod, period ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOnTrigger ()
    {
        return onTrigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnTrigger ( String newOnTrigger )
    {
        String oldOnTrigger = onTrigger;
        onTrigger = newOnTrigger;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.TIME_TRIGGER__ON_TRIGGER, oldOnTrigger, onTrigger ) );
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
            case VisualInterfacePackage.TIME_TRIGGER__PERIOD:
                return getPeriod ();
            case VisualInterfacePackage.TIME_TRIGGER__ON_TRIGGER:
                return getOnTrigger ();
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
            case VisualInterfacePackage.TIME_TRIGGER__PERIOD:
                setPeriod ( (Long)newValue );
                return;
            case VisualInterfacePackage.TIME_TRIGGER__ON_TRIGGER:
                setOnTrigger ( (String)newValue );
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
            case VisualInterfacePackage.TIME_TRIGGER__PERIOD:
                setPeriod ( PERIOD_EDEFAULT );
                return;
            case VisualInterfacePackage.TIME_TRIGGER__ON_TRIGGER:
                setOnTrigger ( ON_TRIGGER_EDEFAULT );
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
            case VisualInterfacePackage.TIME_TRIGGER__PERIOD:
                return period != PERIOD_EDEFAULT;
            case VisualInterfacePackage.TIME_TRIGGER__ON_TRIGGER:
                return ON_TRIGGER_EDEFAULT == null ? onTrigger != null : !ON_TRIGGER_EDEFAULT.equals ( onTrigger );
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
        result.append ( ", onTrigger: " ); //$NON-NLS-1$
        result.append ( onTrigger );
        result.append ( ')' );
        return result.toString ();
    }

} //TimeTriggerImpl
