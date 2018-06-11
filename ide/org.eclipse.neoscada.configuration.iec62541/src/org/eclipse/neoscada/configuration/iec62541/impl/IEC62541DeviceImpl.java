/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.neoscada.configuration.iec62541.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.neoscada.configuration.iec62541.IEC62541Device;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Package;

import org.eclipse.scada.configuration.infrastructure.impl.DeviceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec62541.impl.IEC62541DeviceImpl#getServerUrl <em>Server Url</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IEC62541DeviceImpl extends DeviceImpl implements IEC62541Device
{
    /**
     * The default value of the '{@link #getServerUrl() <em>Server Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServerUrl()
     * @generated
     * @ordered
     */
    protected static final String SERVER_URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getServerUrl() <em>Server Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServerUrl()
     * @generated
     * @ordered
     */
    protected String serverUrl = SERVER_URL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IEC62541DeviceImpl ()
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
        return IEC62541Package.Literals.IEC62541_DEVICE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getServerUrl ()
    {
        return serverUrl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setServerUrl ( String newServerUrl )
    {
        String oldServerUrl = serverUrl;
        serverUrl = newServerUrl;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC62541Package.IEC62541_DEVICE__SERVER_URL, oldServerUrl, serverUrl ) );
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
            case IEC62541Package.IEC62541_DEVICE__SERVER_URL:
                return getServerUrl ();
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
            case IEC62541Package.IEC62541_DEVICE__SERVER_URL:
                setServerUrl ( (String)newValue );
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
            case IEC62541Package.IEC62541_DEVICE__SERVER_URL:
                setServerUrl ( SERVER_URL_EDEFAULT );
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
            case IEC62541Package.IEC62541_DEVICE__SERVER_URL:
                return SERVER_URL_EDEFAULT == null ? serverUrl != null : !SERVER_URL_EDEFAULT.equals ( serverUrl );
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
        result.append ( " (serverUrl: " ); //$NON-NLS-1$
        result.append ( serverUrl );
        result.append ( ')' );
        return result.toString ();
    }

} //IEC62541DeviceImpl
