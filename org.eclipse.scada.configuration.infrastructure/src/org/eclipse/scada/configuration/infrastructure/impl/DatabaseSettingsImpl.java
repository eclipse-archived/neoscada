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

import org.eclipse.scada.configuration.infrastructure.DatabaseSettings;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;

import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Database Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.DatabaseSettingsImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.DatabaseSettingsImpl#getDriverName <em>Driver Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.DatabaseSettingsImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.DatabaseSettingsImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.DatabaseSettingsImpl#getUser <em>User</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.DatabaseSettingsImpl#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DatabaseSettingsImpl extends MinimalEObjectImpl.Container implements DatabaseSettings
{
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
     * The default value of the '{@link #getDriverName() <em>Driver Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDriverName()
     * @generated
     * @ordered
     */
    protected static final String DRIVER_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDriverName() <em>Driver Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDriverName()
     * @generated
     * @ordered
     */
    protected String driverName = DRIVER_NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> properties;

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
     * The default value of the '{@link #getUser() <em>User</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUser()
     * @generated
     * @ordered
     */
    protected static final String USER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUser() <em>User</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUser()
     * @generated
     * @ordered
     */
    protected String user = USER_EDEFAULT;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DatabaseSettingsImpl ()
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
        return InfrastructurePackage.Literals.DATABASE_SETTINGS;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.DATABASE_SETTINGS__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDriverName ()
    {
        return driverName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDriverName ( String newDriverName )
    {
        String oldDriverName = driverName;
        driverName = newDriverName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.DATABASE_SETTINGS__DRIVER_NAME, oldDriverName, driverName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getProperties ()
    {
        if ( properties == null )
        {
            properties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, InfrastructurePackage.DATABASE_SETTINGS__PROPERTIES );
        }
        return properties;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.DATABASE_SETTINGS__URI, oldUri, uri ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUser ()
    {
        return user;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUser ( String newUser )
    {
        String oldUser = user;
        user = newUser;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.DATABASE_SETTINGS__USER, oldUser, user ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.DATABASE_SETTINGS__PASSWORD, oldPassword, password ) );
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
            case InfrastructurePackage.DATABASE_SETTINGS__PROPERTIES:
                return ( (InternalEList<?>)getProperties () ).basicRemove ( otherEnd, msgs );
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
            case InfrastructurePackage.DATABASE_SETTINGS__ID:
                return getId ();
            case InfrastructurePackage.DATABASE_SETTINGS__DRIVER_NAME:
                return getDriverName ();
            case InfrastructurePackage.DATABASE_SETTINGS__PROPERTIES:
                return getProperties ();
            case InfrastructurePackage.DATABASE_SETTINGS__URI:
                return getUri ();
            case InfrastructurePackage.DATABASE_SETTINGS__USER:
                return getUser ();
            case InfrastructurePackage.DATABASE_SETTINGS__PASSWORD:
                return getPassword ();
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
            case InfrastructurePackage.DATABASE_SETTINGS__ID:
                setId ( (String)newValue );
                return;
            case InfrastructurePackage.DATABASE_SETTINGS__DRIVER_NAME:
                setDriverName ( (String)newValue );
                return;
            case InfrastructurePackage.DATABASE_SETTINGS__PROPERTIES:
                getProperties ().clear ();
                getProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
                return;
            case InfrastructurePackage.DATABASE_SETTINGS__URI:
                setUri ( (String)newValue );
                return;
            case InfrastructurePackage.DATABASE_SETTINGS__USER:
                setUser ( (String)newValue );
                return;
            case InfrastructurePackage.DATABASE_SETTINGS__PASSWORD:
                setPassword ( (String)newValue );
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
            case InfrastructurePackage.DATABASE_SETTINGS__ID:
                setId ( ID_EDEFAULT );
                return;
            case InfrastructurePackage.DATABASE_SETTINGS__DRIVER_NAME:
                setDriverName ( DRIVER_NAME_EDEFAULT );
                return;
            case InfrastructurePackage.DATABASE_SETTINGS__PROPERTIES:
                getProperties ().clear ();
                return;
            case InfrastructurePackage.DATABASE_SETTINGS__URI:
                setUri ( URI_EDEFAULT );
                return;
            case InfrastructurePackage.DATABASE_SETTINGS__USER:
                setUser ( USER_EDEFAULT );
                return;
            case InfrastructurePackage.DATABASE_SETTINGS__PASSWORD:
                setPassword ( PASSWORD_EDEFAULT );
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
            case InfrastructurePackage.DATABASE_SETTINGS__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case InfrastructurePackage.DATABASE_SETTINGS__DRIVER_NAME:
                return DRIVER_NAME_EDEFAULT == null ? driverName != null : !DRIVER_NAME_EDEFAULT.equals ( driverName );
            case InfrastructurePackage.DATABASE_SETTINGS__PROPERTIES:
                return properties != null && !properties.isEmpty ();
            case InfrastructurePackage.DATABASE_SETTINGS__URI:
                return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals ( uri );
            case InfrastructurePackage.DATABASE_SETTINGS__USER:
                return USER_EDEFAULT == null ? user != null : !USER_EDEFAULT.equals ( user );
            case InfrastructurePackage.DATABASE_SETTINGS__PASSWORD:
                return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals ( password );
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
        result.append ( " (id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ", driverName: " ); //$NON-NLS-1$
        result.append ( driverName );
        result.append ( ", uri: " ); //$NON-NLS-1$
        result.append ( uri );
        result.append ( ", user: " ); //$NON-NLS-1$
        result.append ( user );
        result.append ( ", password: " ); //$NON-NLS-1$
        result.append ( password );
        result.append ( ')' );
        return result.toString ();
    }

} //DatabaseSettingsImpl
