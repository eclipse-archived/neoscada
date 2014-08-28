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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.world.Endpoint;

import org.eclipse.scada.configuration.world.osgi.EventInjectorSyslog;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Injector Syslog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorSyslogImpl#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorSyslogImpl#getBindAddress <em>Bind Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventInjectorSyslogImpl extends MinimalEObjectImpl.Container implements EventInjectorSyslog
{
    /**
     * The cached value of the '{@link #getEndpoint() <em>Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpoint()
     * @generated
     * @ordered
     */
    protected Endpoint endpoint;

    /**
     * The default value of the '{@link #getBindAddress() <em>Bind Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBindAddress()
     * @generated
     * @ordered
     */
    protected static final String BIND_ADDRESS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBindAddress() <em>Bind Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBindAddress()
     * @generated
     * @ordered
     */
    protected String bindAddress = BIND_ADDRESS_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventInjectorSyslogImpl ()
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
        return OsgiPackage.Literals.EVENT_INJECTOR_SYSLOG;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Endpoint getEndpoint ()
    {
        if ( endpoint != null && endpoint.eIsProxy () )
        {
            InternalEObject oldEndpoint = (InternalEObject)endpoint;
            endpoint = (Endpoint)eResolveProxy ( oldEndpoint );
            if ( endpoint != oldEndpoint )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.EVENT_INJECTOR_SYSLOG__ENDPOINT, oldEndpoint, endpoint ) );
            }
        }
        return endpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Endpoint basicGetEndpoint ()
    {
        return endpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEndpoint ( Endpoint newEndpoint )
    {
        Endpoint oldEndpoint = endpoint;
        endpoint = newEndpoint;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR_SYSLOG__ENDPOINT, oldEndpoint, endpoint ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBindAddress ()
    {
        return bindAddress;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBindAddress ( String newBindAddress )
    {
        String oldBindAddress = bindAddress;
        bindAddress = newBindAddress;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR_SYSLOG__BIND_ADDRESS, oldBindAddress, bindAddress ) );
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
            case OsgiPackage.EVENT_INJECTOR_SYSLOG__ENDPOINT:
                if ( resolve )
                    return getEndpoint ();
                return basicGetEndpoint ();
            case OsgiPackage.EVENT_INJECTOR_SYSLOG__BIND_ADDRESS:
                return getBindAddress ();
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
            case OsgiPackage.EVENT_INJECTOR_SYSLOG__ENDPOINT:
                setEndpoint ( (Endpoint)newValue );
                return;
            case OsgiPackage.EVENT_INJECTOR_SYSLOG__BIND_ADDRESS:
                setBindAddress ( (String)newValue );
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
            case OsgiPackage.EVENT_INJECTOR_SYSLOG__ENDPOINT:
                setEndpoint ( (Endpoint)null );
                return;
            case OsgiPackage.EVENT_INJECTOR_SYSLOG__BIND_ADDRESS:
                setBindAddress ( BIND_ADDRESS_EDEFAULT );
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
            case OsgiPackage.EVENT_INJECTOR_SYSLOG__ENDPOINT:
                return endpoint != null;
            case OsgiPackage.EVENT_INJECTOR_SYSLOG__BIND_ADDRESS:
                return BIND_ADDRESS_EDEFAULT == null ? bindAddress != null : !BIND_ADDRESS_EDEFAULT.equals ( bindAddress );
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
        result.append ( " (bindAddress: " ); //$NON-NLS-1$
        result.append ( bindAddress );
        result.append ( ')' );
        return result.toString ();
    }

} //EventInjectorSyslogImpl
