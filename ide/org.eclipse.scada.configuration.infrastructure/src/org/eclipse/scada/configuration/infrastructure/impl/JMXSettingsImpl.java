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

import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.JMXSettings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JMX Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.JMXSettingsImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.JMXSettingsImpl#getInstancePortOffset <em>Instance Port Offset</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.JMXSettingsImpl#getLocalOnly <em>Local Only</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.JMXSettingsImpl#getAuthenticated <em>Authenticated</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.JMXSettingsImpl#getSsl <em>Ssl</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.JMXSettingsImpl#isAssignNodeHostname <em>Assign Node Hostname</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JMXSettingsImpl extends MinimalEObjectImpl.Container implements JMXSettings
{
    /**
     * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected static final Integer PORT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected Integer port = PORT_EDEFAULT;

    /**
     * The default value of the '{@link #getInstancePortOffset() <em>Instance Port Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstancePortOffset()
     * @generated
     * @ordered
     */
    protected static final Integer INSTANCE_PORT_OFFSET_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInstancePortOffset() <em>Instance Port Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstancePortOffset()
     * @generated
     * @ordered
     */
    protected Integer instancePortOffset = INSTANCE_PORT_OFFSET_EDEFAULT;

    /**
     * The default value of the '{@link #getLocalOnly() <em>Local Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalOnly()
     * @generated
     * @ordered
     */
    protected static final Boolean LOCAL_ONLY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLocalOnly() <em>Local Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalOnly()
     * @generated
     * @ordered
     */
    protected Boolean localOnly = LOCAL_ONLY_EDEFAULT;

    /**
     * The default value of the '{@link #getAuthenticated() <em>Authenticated</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthenticated()
     * @generated
     * @ordered
     */
    protected static final Boolean AUTHENTICATED_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAuthenticated() <em>Authenticated</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthenticated()
     * @generated
     * @ordered
     */
    protected Boolean authenticated = AUTHENTICATED_EDEFAULT;

    /**
     * The default value of the '{@link #getSsl() <em>Ssl</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSsl()
     * @generated
     * @ordered
     */
    protected static final Boolean SSL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSsl() <em>Ssl</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSsl()
     * @generated
     * @ordered
     */
    protected Boolean ssl = SSL_EDEFAULT;

    /**
     * The default value of the '{@link #isAssignNodeHostname() <em>Assign Node Hostname</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAssignNodeHostname()
     * @generated
     * @ordered
     */
    protected static final boolean ASSIGN_NODE_HOSTNAME_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAssignNodeHostname() <em>Assign Node Hostname</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAssignNodeHostname()
     * @generated
     * @ordered
     */
    protected boolean assignNodeHostname = ASSIGN_NODE_HOSTNAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JMXSettingsImpl ()
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
        return InfrastructurePackage.Literals.JMX_SETTINGS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getPort ()
    {
        return port;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPort ( Integer newPort )
    {
        Integer oldPort = port;
        port = newPort;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.JMX_SETTINGS__PORT, oldPort, port ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getInstancePortOffset ()
    {
        return instancePortOffset;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInstancePortOffset ( Integer newInstancePortOffset )
    {
        Integer oldInstancePortOffset = instancePortOffset;
        instancePortOffset = newInstancePortOffset;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.JMX_SETTINGS__INSTANCE_PORT_OFFSET, oldInstancePortOffset, instancePortOffset ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getLocalOnly ()
    {
        return localOnly;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocalOnly ( Boolean newLocalOnly )
    {
        Boolean oldLocalOnly = localOnly;
        localOnly = newLocalOnly;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.JMX_SETTINGS__LOCAL_ONLY, oldLocalOnly, localOnly ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getAuthenticated ()
    {
        return authenticated;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAuthenticated ( Boolean newAuthenticated )
    {
        Boolean oldAuthenticated = authenticated;
        authenticated = newAuthenticated;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.JMX_SETTINGS__AUTHENTICATED, oldAuthenticated, authenticated ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getSsl ()
    {
        return ssl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSsl ( Boolean newSsl )
    {
        Boolean oldSsl = ssl;
        ssl = newSsl;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.JMX_SETTINGS__SSL, oldSsl, ssl ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAssignNodeHostname ()
    {
        return assignNodeHostname;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssignNodeHostname ( boolean newAssignNodeHostname )
    {
        boolean oldAssignNodeHostname = assignNodeHostname;
        assignNodeHostname = newAssignNodeHostname;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.JMX_SETTINGS__ASSIGN_NODE_HOSTNAME, oldAssignNodeHostname, assignNodeHostname ) );
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
            case InfrastructurePackage.JMX_SETTINGS__PORT:
                return getPort ();
            case InfrastructurePackage.JMX_SETTINGS__INSTANCE_PORT_OFFSET:
                return getInstancePortOffset ();
            case InfrastructurePackage.JMX_SETTINGS__LOCAL_ONLY:
                return getLocalOnly ();
            case InfrastructurePackage.JMX_SETTINGS__AUTHENTICATED:
                return getAuthenticated ();
            case InfrastructurePackage.JMX_SETTINGS__SSL:
                return getSsl ();
            case InfrastructurePackage.JMX_SETTINGS__ASSIGN_NODE_HOSTNAME:
                return isAssignNodeHostname ();
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
            case InfrastructurePackage.JMX_SETTINGS__PORT:
                setPort ( (Integer)newValue );
                return;
            case InfrastructurePackage.JMX_SETTINGS__INSTANCE_PORT_OFFSET:
                setInstancePortOffset ( (Integer)newValue );
                return;
            case InfrastructurePackage.JMX_SETTINGS__LOCAL_ONLY:
                setLocalOnly ( (Boolean)newValue );
                return;
            case InfrastructurePackage.JMX_SETTINGS__AUTHENTICATED:
                setAuthenticated ( (Boolean)newValue );
                return;
            case InfrastructurePackage.JMX_SETTINGS__SSL:
                setSsl ( (Boolean)newValue );
                return;
            case InfrastructurePackage.JMX_SETTINGS__ASSIGN_NODE_HOSTNAME:
                setAssignNodeHostname ( (Boolean)newValue );
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
            case InfrastructurePackage.JMX_SETTINGS__PORT:
                setPort ( PORT_EDEFAULT );
                return;
            case InfrastructurePackage.JMX_SETTINGS__INSTANCE_PORT_OFFSET:
                setInstancePortOffset ( INSTANCE_PORT_OFFSET_EDEFAULT );
                return;
            case InfrastructurePackage.JMX_SETTINGS__LOCAL_ONLY:
                setLocalOnly ( LOCAL_ONLY_EDEFAULT );
                return;
            case InfrastructurePackage.JMX_SETTINGS__AUTHENTICATED:
                setAuthenticated ( AUTHENTICATED_EDEFAULT );
                return;
            case InfrastructurePackage.JMX_SETTINGS__SSL:
                setSsl ( SSL_EDEFAULT );
                return;
            case InfrastructurePackage.JMX_SETTINGS__ASSIGN_NODE_HOSTNAME:
                setAssignNodeHostname ( ASSIGN_NODE_HOSTNAME_EDEFAULT );
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
            case InfrastructurePackage.JMX_SETTINGS__PORT:
                return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals ( port );
            case InfrastructurePackage.JMX_SETTINGS__INSTANCE_PORT_OFFSET:
                return INSTANCE_PORT_OFFSET_EDEFAULT == null ? instancePortOffset != null : !INSTANCE_PORT_OFFSET_EDEFAULT.equals ( instancePortOffset );
            case InfrastructurePackage.JMX_SETTINGS__LOCAL_ONLY:
                return LOCAL_ONLY_EDEFAULT == null ? localOnly != null : !LOCAL_ONLY_EDEFAULT.equals ( localOnly );
            case InfrastructurePackage.JMX_SETTINGS__AUTHENTICATED:
                return AUTHENTICATED_EDEFAULT == null ? authenticated != null : !AUTHENTICATED_EDEFAULT.equals ( authenticated );
            case InfrastructurePackage.JMX_SETTINGS__SSL:
                return SSL_EDEFAULT == null ? ssl != null : !SSL_EDEFAULT.equals ( ssl );
            case InfrastructurePackage.JMX_SETTINGS__ASSIGN_NODE_HOSTNAME:
                return assignNodeHostname != ASSIGN_NODE_HOSTNAME_EDEFAULT;
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
        result.append ( " (port: " ); //$NON-NLS-1$
        result.append ( port );
        result.append ( ", instancePortOffset: " ); //$NON-NLS-1$
        result.append ( instancePortOffset );
        result.append ( ", localOnly: " ); //$NON-NLS-1$
        result.append ( localOnly );
        result.append ( ", authenticated: " ); //$NON-NLS-1$
        result.append ( authenticated );
        result.append ( ", ssl: " ); //$NON-NLS-1$
        result.append ( ssl );
        result.append ( ", assignNodeHostname: " ); //$NON-NLS-1$
        result.append ( assignNodeHostname );
        result.append ( ')' );
        return result.toString ();
    }

} //JMXSettingsImpl
