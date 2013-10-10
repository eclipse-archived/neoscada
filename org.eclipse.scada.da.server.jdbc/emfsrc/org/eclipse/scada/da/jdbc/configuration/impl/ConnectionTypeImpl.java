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
package org.eclipse.scada.da.jdbc.configuration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage;
import org.eclipse.scada.da.jdbc.configuration.ConnectionType;
import org.eclipse.scada.da.jdbc.configuration.QueryType;
import org.eclipse.scada.da.jdbc.configuration.TabularQueryType;
import org.eclipse.scada.da.jdbc.configuration.UpdateType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl#getTabularQuery <em>Tabular Query</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl#getUpdate <em>Update</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl#getConnectionClass <em>Connection Class</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl#getUsername <em>Username</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionTypeImpl extends MinimalEObjectImpl.Container implements ConnectionType
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQuery()
     * @generated
     * @ordered
     */
    protected EList<QueryType> query;

    /**
     * The cached value of the '{@link #getTabularQuery() <em>Tabular Query</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTabularQuery()
     * @generated
     * @ordered
     */
    protected EList<TabularQueryType> tabularQuery;

    /**
     * The cached value of the '{@link #getUpdate() <em>Update</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpdate()
     * @generated
     * @ordered
     */
    protected EList<UpdateType> update;

    /**
     * The default value of the '{@link #getConnectionClass() <em>Connection Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnectionClass()
     * @generated
     * @ordered
     */
    protected static final String CONNECTION_CLASS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConnectionClass() <em>Connection Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnectionClass()
     * @generated
     * @ordered
     */
    protected String connectionClass = CONNECTION_CLASS_EDEFAULT;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected static final String PASSWORD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected String password = PASSWORD_EDEFAULT;

    /**
     * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout()
     * @generated
     * @ordered
     */
    protected static final int TIMEOUT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout()
     * @generated
     * @ordered
     */
    protected int timeout = TIMEOUT_EDEFAULT;

    /**
     * This is true if the Timeout attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean timeoutESet;

    /**
     * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected static final String URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected String uri = URI_EDEFAULT;

    /**
     * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsername()
     * @generated
     * @ordered
     */
    protected static final String USERNAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsername()
     * @generated
     * @ordered
     */
    protected String username = USERNAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConnectionTypeImpl ()
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
        return ConfigurationPackage.Literals.CONNECTION_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<QueryType> getQuery ()
    {
        if ( query == null )
        {
            query = new EObjectContainmentEList<QueryType> ( QueryType.class, this, ConfigurationPackage.CONNECTION_TYPE__QUERY );
        }
        return query;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TabularQueryType> getTabularQuery ()
    {
        if ( tabularQuery == null )
        {
            tabularQuery = new EObjectContainmentEList<TabularQueryType> ( TabularQueryType.class, this, ConfigurationPackage.CONNECTION_TYPE__TABULAR_QUERY );
        }
        return tabularQuery;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<UpdateType> getUpdate ()
    {
        if ( update == null )
        {
            update = new EObjectContainmentEList<UpdateType> ( UpdateType.class, this, ConfigurationPackage.CONNECTION_TYPE__UPDATE );
        }
        return update;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getConnectionClass ()
    {
        return connectionClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConnectionClass ( String newConnectionClass )
    {
        String oldConnectionClass = connectionClass;
        connectionClass = newConnectionClass;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__CONNECTION_CLASS, oldConnectionClass, connectionClass ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPassword ()
    {
        return password;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPassword ( String newPassword )
    {
        String oldPassword = password;
        password = newPassword;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__PASSWORD, oldPassword, password ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getTimeout ()
    {
        return timeout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimeout ( int newTimeout )
    {
        int oldTimeout = timeout;
        timeout = newTimeout;
        boolean oldTimeoutESet = timeoutESet;
        timeoutESet = true;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__TIMEOUT, oldTimeout, timeout, !oldTimeoutESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetTimeout ()
    {
        int oldTimeout = timeout;
        boolean oldTimeoutESet = timeoutESet;
        timeout = TIMEOUT_EDEFAULT;
        timeoutESet = false;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.UNSET, ConfigurationPackage.CONNECTION_TYPE__TIMEOUT, oldTimeout, TIMEOUT_EDEFAULT, oldTimeoutESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetTimeout ()
    {
        return timeoutESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUri ()
    {
        return uri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUri ( String newUri )
    {
        String oldUri = uri;
        uri = newUri;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__URI, oldUri, uri ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUsername ()
    {
        return username;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUsername ( String newUsername )
    {
        String oldUsername = username;
        username = newUsername;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__USERNAME, oldUsername, username ) );
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
            case ConfigurationPackage.CONNECTION_TYPE__QUERY:
                return ( (InternalEList<?>)getQuery () ).basicRemove ( otherEnd, msgs );
            case ConfigurationPackage.CONNECTION_TYPE__TABULAR_QUERY:
                return ( (InternalEList<?>)getTabularQuery () ).basicRemove ( otherEnd, msgs );
            case ConfigurationPackage.CONNECTION_TYPE__UPDATE:
                return ( (InternalEList<?>)getUpdate () ).basicRemove ( otherEnd, msgs );
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
            case ConfigurationPackage.CONNECTION_TYPE__QUERY:
                return getQuery ();
            case ConfigurationPackage.CONNECTION_TYPE__TABULAR_QUERY:
                return getTabularQuery ();
            case ConfigurationPackage.CONNECTION_TYPE__UPDATE:
                return getUpdate ();
            case ConfigurationPackage.CONNECTION_TYPE__CONNECTION_CLASS:
                return getConnectionClass ();
            case ConfigurationPackage.CONNECTION_TYPE__ID:
                return getId ();
            case ConfigurationPackage.CONNECTION_TYPE__PASSWORD:
                return getPassword ();
            case ConfigurationPackage.CONNECTION_TYPE__TIMEOUT:
                return getTimeout ();
            case ConfigurationPackage.CONNECTION_TYPE__URI:
                return getUri ();
            case ConfigurationPackage.CONNECTION_TYPE__USERNAME:
                return getUsername ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ConfigurationPackage.CONNECTION_TYPE__QUERY:
                getQuery ().clear ();
                getQuery ().addAll ( (Collection<? extends QueryType>)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__TABULAR_QUERY:
                getTabularQuery ().clear ();
                getTabularQuery ().addAll ( (Collection<? extends TabularQueryType>)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__UPDATE:
                getUpdate ().clear ();
                getUpdate ().addAll ( (Collection<? extends UpdateType>)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__CONNECTION_CLASS:
                setConnectionClass ( (String)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__ID:
                setId ( (String)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__PASSWORD:
                setPassword ( (String)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__TIMEOUT:
                setTimeout ( (Integer)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__URI:
                setUri ( (String)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__USERNAME:
                setUsername ( (String)newValue );
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
            case ConfigurationPackage.CONNECTION_TYPE__QUERY:
                getQuery ().clear ();
                return;
            case ConfigurationPackage.CONNECTION_TYPE__TABULAR_QUERY:
                getTabularQuery ().clear ();
                return;
            case ConfigurationPackage.CONNECTION_TYPE__UPDATE:
                getUpdate ().clear ();
                return;
            case ConfigurationPackage.CONNECTION_TYPE__CONNECTION_CLASS:
                setConnectionClass ( CONNECTION_CLASS_EDEFAULT );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__ID:
                setId ( ID_EDEFAULT );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__PASSWORD:
                setPassword ( PASSWORD_EDEFAULT );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__TIMEOUT:
                unsetTimeout ();
                return;
            case ConfigurationPackage.CONNECTION_TYPE__URI:
                setUri ( URI_EDEFAULT );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__USERNAME:
                setUsername ( USERNAME_EDEFAULT );
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
            case ConfigurationPackage.CONNECTION_TYPE__QUERY:
                return query != null && !query.isEmpty ();
            case ConfigurationPackage.CONNECTION_TYPE__TABULAR_QUERY:
                return tabularQuery != null && !tabularQuery.isEmpty ();
            case ConfigurationPackage.CONNECTION_TYPE__UPDATE:
                return update != null && !update.isEmpty ();
            case ConfigurationPackage.CONNECTION_TYPE__CONNECTION_CLASS:
                return CONNECTION_CLASS_EDEFAULT == null ? connectionClass != null : !CONNECTION_CLASS_EDEFAULT.equals ( connectionClass );
            case ConfigurationPackage.CONNECTION_TYPE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case ConfigurationPackage.CONNECTION_TYPE__PASSWORD:
                return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals ( password );
            case ConfigurationPackage.CONNECTION_TYPE__TIMEOUT:
                return isSetTimeout ();
            case ConfigurationPackage.CONNECTION_TYPE__URI:
                return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals ( uri );
            case ConfigurationPackage.CONNECTION_TYPE__USERNAME:
                return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals ( username );
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
        result.append ( " (connectionClass: " ); //$NON-NLS-1$
        result.append ( connectionClass );
        result.append ( ", id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ", password: " ); //$NON-NLS-1$
        result.append ( password );
        result.append ( ", timeout: " ); //$NON-NLS-1$
        if ( timeoutESet )
            result.append ( timeout );
        else
            result.append ( "<unset>" ); //$NON-NLS-1$
        result.append ( ", uri: " ); //$NON-NLS-1$
        result.append ( uri );
        result.append ( ", username: " ); //$NON-NLS-1$
        result.append ( username );
        result.append ( ')' );
        return result.toString ();
    }

} //ConnectionTypeImpl
