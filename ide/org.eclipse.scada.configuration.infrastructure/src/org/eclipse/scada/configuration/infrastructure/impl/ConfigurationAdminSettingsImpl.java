/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.infrastructure.ConfigurationAdminSettings;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Admin Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ConfigurationAdminSettingsImpl#isAutomaticMerge <em>Automatic Merge</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ConfigurationAdminSettingsImpl#getSettleTimeout <em>Settle Timeout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationAdminSettingsImpl extends MinimalEObjectImpl.Container implements ConfigurationAdminSettings
{
    /**
     * The default value of the '{@link #isAutomaticMerge() <em>Automatic Merge</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAutomaticMerge()
     * @generated
     * @ordered
     */
    protected static final boolean AUTOMATIC_MERGE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAutomaticMerge() <em>Automatic Merge</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAutomaticMerge()
     * @generated
     * @ordered
     */
    protected boolean automaticMerge = AUTOMATIC_MERGE_EDEFAULT;

    /**
     * The default value of the '{@link #getSettleTimeout() <em>Settle Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSettleTimeout()
     * @generated
     * @ordered
     */
    protected static final Long SETTLE_TIMEOUT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSettleTimeout() <em>Settle Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSettleTimeout()
     * @generated
     * @ordered
     */
    protected Long settleTimeout = SETTLE_TIMEOUT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConfigurationAdminSettingsImpl ()
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
        return InfrastructurePackage.Literals.CONFIGURATION_ADMIN_SETTINGS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAutomaticMerge ()
    {
        return automaticMerge;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAutomaticMerge ( boolean newAutomaticMerge )
    {
        boolean oldAutomaticMerge = automaticMerge;
        automaticMerge = newAutomaticMerge;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.CONFIGURATION_ADMIN_SETTINGS__AUTOMATIC_MERGE, oldAutomaticMerge, automaticMerge ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Long getSettleTimeout ()
    {
        return settleTimeout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSettleTimeout ( Long newSettleTimeout )
    {
        Long oldSettleTimeout = settleTimeout;
        settleTimeout = newSettleTimeout;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.CONFIGURATION_ADMIN_SETTINGS__SETTLE_TIMEOUT, oldSettleTimeout, settleTimeout ) );
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
            case InfrastructurePackage.CONFIGURATION_ADMIN_SETTINGS__AUTOMATIC_MERGE:
                return isAutomaticMerge ();
            case InfrastructurePackage.CONFIGURATION_ADMIN_SETTINGS__SETTLE_TIMEOUT:
                return getSettleTimeout ();
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
            case InfrastructurePackage.CONFIGURATION_ADMIN_SETTINGS__AUTOMATIC_MERGE:
                setAutomaticMerge ( (Boolean)newValue );
                return;
            case InfrastructurePackage.CONFIGURATION_ADMIN_SETTINGS__SETTLE_TIMEOUT:
                setSettleTimeout ( (Long)newValue );
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
            case InfrastructurePackage.CONFIGURATION_ADMIN_SETTINGS__AUTOMATIC_MERGE:
                setAutomaticMerge ( AUTOMATIC_MERGE_EDEFAULT );
                return;
            case InfrastructurePackage.CONFIGURATION_ADMIN_SETTINGS__SETTLE_TIMEOUT:
                setSettleTimeout ( SETTLE_TIMEOUT_EDEFAULT );
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
            case InfrastructurePackage.CONFIGURATION_ADMIN_SETTINGS__AUTOMATIC_MERGE:
                return automaticMerge != AUTOMATIC_MERGE_EDEFAULT;
            case InfrastructurePackage.CONFIGURATION_ADMIN_SETTINGS__SETTLE_TIMEOUT:
                return SETTLE_TIMEOUT_EDEFAULT == null ? settleTimeout != null : !SETTLE_TIMEOUT_EDEFAULT.equals ( settleTimeout );
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
        result.append ( " (automaticMerge: " ); //$NON-NLS-1$
        result.append ( automaticMerge );
        result.append ( ", settleTimeout: " ); //$NON-NLS-1$
        result.append ( settleTimeout );
        result.append ( ')' );
        return result.toString ();
    }

} //ConfigurationAdminSettingsImpl
