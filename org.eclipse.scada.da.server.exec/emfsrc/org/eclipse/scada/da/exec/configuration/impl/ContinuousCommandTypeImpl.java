/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.exec.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.ContinuousCommandType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Continuous Command Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.ContinuousCommandTypeImpl#getMaxInputBuffer <em>Max Input Buffer</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.ContinuousCommandTypeImpl#getRestartDelay <em>Restart Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContinuousCommandTypeImpl extends CommandTypeImpl implements ContinuousCommandType
{
    //$NON-NLS-1$

    /**
     * The default value of the '{@link #getMaxInputBuffer() <em>Max Input Buffer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxInputBuffer()
     * @generated
     * @ordered
     */
    protected static final int MAX_INPUT_BUFFER_EDEFAULT = 4000;

    /**
     * The cached value of the '{@link #getMaxInputBuffer() <em>Max Input Buffer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxInputBuffer()
     * @generated
     * @ordered
     */
    protected int maxInputBuffer = MAX_INPUT_BUFFER_EDEFAULT;

    /**
     * This is true if the Max Input Buffer attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean maxInputBufferESet;

    /**
     * The default value of the '{@link #getRestartDelay() <em>Restart Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRestartDelay()
     * @generated
     * @ordered
     */
    protected static final int RESTART_DELAY_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getRestartDelay() <em>Restart Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRestartDelay()
     * @generated
     * @ordered
     */
    protected int restartDelay = RESTART_DELAY_EDEFAULT;

    /**
     * This is true if the Restart Delay attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean restartDelayESet;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ContinuousCommandTypeImpl ()
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
        return ConfigurationPackage.Literals.CONTINUOUS_COMMAND_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getMaxInputBuffer ()
    {
        return maxInputBuffer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMaxInputBuffer ( int newMaxInputBuffer )
    {
        int oldMaxInputBuffer = maxInputBuffer;
        maxInputBuffer = newMaxInputBuffer;
        boolean oldMaxInputBufferESet = maxInputBufferESet;
        maxInputBufferESet = true;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER, oldMaxInputBuffer, maxInputBuffer, !oldMaxInputBufferESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetMaxInputBuffer ()
    {
        int oldMaxInputBuffer = maxInputBuffer;
        boolean oldMaxInputBufferESet = maxInputBufferESet;
        maxInputBuffer = MAX_INPUT_BUFFER_EDEFAULT;
        maxInputBufferESet = false;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.UNSET, ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER, oldMaxInputBuffer, MAX_INPUT_BUFFER_EDEFAULT, oldMaxInputBufferESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetMaxInputBuffer ()
    {
        return maxInputBufferESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getRestartDelay ()
    {
        return restartDelay;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRestartDelay ( int newRestartDelay )
    {
        int oldRestartDelay = restartDelay;
        restartDelay = newRestartDelay;
        boolean oldRestartDelayESet = restartDelayESet;
        restartDelayESet = true;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__RESTART_DELAY, oldRestartDelay, restartDelay, !oldRestartDelayESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetRestartDelay ()
    {
        int oldRestartDelay = restartDelay;
        boolean oldRestartDelayESet = restartDelayESet;
        restartDelay = RESTART_DELAY_EDEFAULT;
        restartDelayESet = false;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.UNSET, ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__RESTART_DELAY, oldRestartDelay, RESTART_DELAY_EDEFAULT, oldRestartDelayESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetRestartDelay ()
    {
        return restartDelayESet;
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
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER:
                return getMaxInputBuffer ();
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__RESTART_DELAY:
                return getRestartDelay ();
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
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER:
                setMaxInputBuffer ( (Integer)newValue );
                return;
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__RESTART_DELAY:
                setRestartDelay ( (Integer)newValue );
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
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER:
                unsetMaxInputBuffer ();
                return;
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__RESTART_DELAY:
                unsetRestartDelay ();
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
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER:
                return isSetMaxInputBuffer ();
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE__RESTART_DELAY:
                return isSetRestartDelay ();
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
        result.append ( " (maxInputBuffer: " ); //$NON-NLS-1$
        if ( maxInputBufferESet )
            result.append ( maxInputBuffer );
        else
            result.append ( "<unset>" ); //$NON-NLS-1$
        result.append ( ", restartDelay: " ); //$NON-NLS-1$
        if ( restartDelayESet )
            result.append ( restartDelay );
        else
            result.append ( "<unset>" ); //$NON-NLS-1$
        result.append ( ')' );
        return result.toString ();
    }

} //ContinuousCommandTypeImpl
