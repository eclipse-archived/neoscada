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
package org.eclipse.scada.configuration.component.exec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.exec.ExecComponentsPackage;
import org.eclipse.scada.configuration.component.exec.PingCheckConfiguration;
import org.eclipse.scada.configuration.component.impl.ConfigurationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ping Check Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.impl.PingCheckConfigurationImpl#getPingDelay <em>Ping Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PingCheckConfigurationImpl extends ConfigurationImpl implements PingCheckConfiguration
{
    /**
     * The default value of the '{@link #getPingDelay() <em>Ping Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPingDelay()
     * @generated
     * @ordered
     */
    protected static final Integer PING_DELAY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPingDelay() <em>Ping Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPingDelay()
     * @generated
     * @ordered
     */
    protected Integer pingDelay = PING_DELAY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PingCheckConfigurationImpl ()
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
        return ExecComponentsPackage.Literals.PING_CHECK_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getPingDelay ()
    {
        return pingDelay;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPingDelay ( Integer newPingDelay )
    {
        Integer oldPingDelay = pingDelay;
        pingDelay = newPingDelay;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ExecComponentsPackage.PING_CHECK_CONFIGURATION__PING_DELAY, oldPingDelay, pingDelay ) );
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
            case ExecComponentsPackage.PING_CHECK_CONFIGURATION__PING_DELAY:
                return getPingDelay ();
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
            case ExecComponentsPackage.PING_CHECK_CONFIGURATION__PING_DELAY:
                setPingDelay ( (Integer)newValue );
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
            case ExecComponentsPackage.PING_CHECK_CONFIGURATION__PING_DELAY:
                setPingDelay ( PING_DELAY_EDEFAULT );
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
            case ExecComponentsPackage.PING_CHECK_CONFIGURATION__PING_DELAY:
                return PING_DELAY_EDEFAULT == null ? pingDelay != null : !PING_DELAY_EDEFAULT.equals ( pingDelay );
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
        result.append ( " (pingDelay: " ); //$NON-NLS-1$
        result.append ( pingDelay );
        result.append ( ')' );
        return result.toString ();
    }

} //PingCheckConfigurationImpl
