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
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.infrastructure.EventInjectorSyslog;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Injector Syslog</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.EventInjectorSyslogImpl#getBindAddress <em>Bind Address</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.EventInjectorSyslogImpl#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventInjectorSyslogImpl extends MinimalEObjectImpl.Container implements EventInjectorSyslog
{
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
     * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected static final int PORT_EDEFAULT = 20514;

    /**
     * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected int port = PORT_EDEFAULT;

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
        return InfrastructurePackage.Literals.EVENT_INJECTOR_SYSLOG;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EVENT_INJECTOR_SYSLOG__BIND_ADDRESS, oldBindAddress, bindAddress ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPort ()
    {
        return port;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPort ( int newPort )
    {
        int oldPort = port;
        port = newPort;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EVENT_INJECTOR_SYSLOG__PORT, oldPort, port ) );
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
            case InfrastructurePackage.EVENT_INJECTOR_SYSLOG__BIND_ADDRESS:
                return getBindAddress ();
            case InfrastructurePackage.EVENT_INJECTOR_SYSLOG__PORT:
                return getPort ();
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
            case InfrastructurePackage.EVENT_INJECTOR_SYSLOG__BIND_ADDRESS:
                setBindAddress ( (String)newValue );
                return;
            case InfrastructurePackage.EVENT_INJECTOR_SYSLOG__PORT:
                setPort ( (Integer)newValue );
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
            case InfrastructurePackage.EVENT_INJECTOR_SYSLOG__BIND_ADDRESS:
                setBindAddress ( BIND_ADDRESS_EDEFAULT );
                return;
            case InfrastructurePackage.EVENT_INJECTOR_SYSLOG__PORT:
                setPort ( PORT_EDEFAULT );
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
            case InfrastructurePackage.EVENT_INJECTOR_SYSLOG__BIND_ADDRESS:
                return BIND_ADDRESS_EDEFAULT == null ? bindAddress != null : !BIND_ADDRESS_EDEFAULT.equals ( bindAddress );
            case InfrastructurePackage.EVENT_INJECTOR_SYSLOG__PORT:
                return port != PORT_EDEFAULT;
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
        result.append ( ", port: " ); //$NON-NLS-1$
        result.append ( port );
        result.append ( ')' );
        return result.toString ();
    }

} //EventInjectorSyslogImpl
