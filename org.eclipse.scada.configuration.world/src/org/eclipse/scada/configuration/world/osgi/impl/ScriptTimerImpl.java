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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.ScriptTimer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Timer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptTimerImpl#getScript <em>Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptTimerImpl#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptTimerImpl extends MinimalEObjectImpl.Container implements
        ScriptTimer
{
    /**
     * The cached value of the '{@link #getScript() <em>Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScript()
     * @generated
     * @ordered
     */
    protected CodeFragment script;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ScriptTimerImpl ()
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
        return OsgiPackage.Literals.SCRIPT_TIMER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CodeFragment getScript ()
    {
        if ( script != null && script.eIsProxy () )
        {
            InternalEObject oldScript = (InternalEObject)script;
            script = (CodeFragment)eResolveProxy ( oldScript );
            if ( script != oldScript )
            {
                InternalEObject newScript = (InternalEObject)script;
                NotificationChain msgs = oldScript.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.SCRIPT_TIMER__SCRIPT, null, null );
                if ( newScript.eInternalContainer () == null )
                {
                    msgs = newScript.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.SCRIPT_TIMER__SCRIPT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.SCRIPT_TIMER__SCRIPT, oldScript, script ) );
            }
        }
        return script;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CodeFragment basicGetScript ()
    {
        return script;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetScript ( CodeFragment newScript,
            NotificationChain msgs )
    {
        CodeFragment oldScript = script;
        script = newScript;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, OsgiPackage.SCRIPT_TIMER__SCRIPT, oldScript, newScript );
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
    public void setScript ( CodeFragment newScript )
    {
        if ( newScript != script )
        {
            NotificationChain msgs = null;
            if ( script != null )
                msgs = ( (InternalEObject)script ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.SCRIPT_TIMER__SCRIPT, null, msgs );
            if ( newScript != null )
                msgs = ( (InternalEObject)newScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.SCRIPT_TIMER__SCRIPT, null, msgs );
            msgs = basicSetScript ( newScript, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.SCRIPT_TIMER__SCRIPT, newScript, newScript ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.SCRIPT_TIMER__PERIOD, oldPeriod, period ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd,
            int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case OsgiPackage.SCRIPT_TIMER__SCRIPT:
                return basicSetScript ( null, msgs );
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
            case OsgiPackage.SCRIPT_TIMER__SCRIPT:
                if ( resolve )
                    return getScript ();
                return basicGetScript ();
            case OsgiPackage.SCRIPT_TIMER__PERIOD:
                return getPeriod ();
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
            case OsgiPackage.SCRIPT_TIMER__SCRIPT:
                setScript ( (CodeFragment)newValue );
                return;
            case OsgiPackage.SCRIPT_TIMER__PERIOD:
                setPeriod ( (Long)newValue );
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
            case OsgiPackage.SCRIPT_TIMER__SCRIPT:
                setScript ( (CodeFragment)null );
                return;
            case OsgiPackage.SCRIPT_TIMER__PERIOD:
                setPeriod ( PERIOD_EDEFAULT );
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
            case OsgiPackage.SCRIPT_TIMER__SCRIPT:
                return script != null;
            case OsgiPackage.SCRIPT_TIMER__PERIOD:
                return period != PERIOD_EDEFAULT;
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

} //ScriptTimerImpl
