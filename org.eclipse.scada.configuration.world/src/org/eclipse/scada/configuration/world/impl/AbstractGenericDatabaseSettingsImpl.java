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
package org.eclipse.scada.configuration.world.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.WorldFactory;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Abstract Generic Database Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl#getId
 * <em>Id</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl#getUsername
 * <em>Username</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl#getPassword
 * <em>Password</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl#getLoginTimeout
 * <em>Login Timeout</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl#getAdditionalProperties
 * <em>Additional Properties</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl#getDatabaseName
 * <em>Database Name</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl#getServerName
 * <em>Server Name</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl#getPortNumber
 * <em>Port Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractGenericDatabaseSettingsImpl extends MinimalEObjectImpl.Container implements AbstractGenericDatabaseSettings
{
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getUsername() <em>Username</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getUsername()
     * @generated
     * @ordered
     */
    protected static final String USERNAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUsername() <em>Username</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getUsername()
     * @generated
     * @ordered
     */
    protected String username = USERNAME_EDEFAULT;

    /**
     * The default value of the '{@link #getPassword() <em>Password</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected static final String PASSWORD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPassword() <em>Password</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected String password = PASSWORD_EDEFAULT;

    /**
     * The default value of the '{@link #getLoginTimeout()
     * <em>Login Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getLoginTimeout()
     * @generated
     * @ordered
     */
    protected static final Integer LOGIN_TIMEOUT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLoginTimeout()
     * <em>Login Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getLoginTimeout()
     * @generated
     * @ordered
     */
    protected Integer loginTimeout = LOGIN_TIMEOUT_EDEFAULT;

    /**
     * The cached value of the '{@link #getAdditionalProperties()
     * <em>Additional Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getAdditionalProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> additionalProperties;

    /**
     * The default value of the '{@link #getDatabaseName()
     * <em>Database Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getDatabaseName()
     * @generated
     * @ordered
     */
    protected static final String DATABASE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDatabaseName()
     * <em>Database Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getDatabaseName()
     * @generated
     * @ordered
     */
    protected String databaseName = DATABASE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getServerName() <em>Server Name</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getServerName()
     * @generated
     * @ordered
     */
    protected static final String SERVER_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getServerName() <em>Server Name</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getServerName()
     * @generated
     * @ordered
     */
    protected String serverName = SERVER_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getPortNumber() <em>Port Number</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getPortNumber()
     * @generated
     * @ordered
     */
    protected static final Integer PORT_NUMBER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPortNumber() <em>Port Number</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getPortNumber()
     * @generated
     * @ordered
     */
    protected Integer portNumber = PORT_NUMBER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected AbstractGenericDatabaseSettingsImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return WorldPackage.Literals.ABSTRACT_GENERIC_DATABASE_SETTINGS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getId ()
    {
        return this.id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setId ( final String newId )
    {
        final String oldId = this.id;
        this.id = newId;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ID, oldId, this.id ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getUsername ()
    {
        return this.username;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setUsername ( final String newUsername )
    {
        final String oldUsername = this.username;
        this.username = newUsername;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__USERNAME, oldUsername, this.username ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getPassword ()
    {
        return this.password;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPassword ( final String newPassword )
    {
        final String oldPassword = this.password;
        this.password = newPassword;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__PASSWORD, oldPassword, this.password ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public abstract String getDriverName ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public EList<PropertyEntry> getProperties ()
    {
        final Map<String, String> properties = new HashMap<> ();

        fillLocalProperties ( properties );

        final Map<String, String> entries = getSpecificProperties ();
        if ( entries != null )
        {
            properties.putAll ( entries );
        }

        final EList<PropertyEntry> additionalEntries = getAdditionalProperties ();
        if ( additionalEntries != null )
        {
            for ( final PropertyEntry pe : additionalEntries )
            {
                properties.put ( pe.getKey (), pe.getValue () );
            }
        }

        final BasicEList<PropertyEntry> result = ECollections.newBasicEList ();
        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            final PropertyEntry pe = WorldFactory.eINSTANCE.createPropertyEntry ();
            pe.setKey ( entry.getKey () );
            pe.setValue ( entry.getValue () );
            result.add ( pe );
        }

        return result;
    }

    protected void fillLocalProperties ( final Map<String, String> properties )
    {
        if ( this.username != null )
        {
            properties.put ( "user", this.username );
        }
        if ( this.password != null )
        {
            properties.put ( "password", this.password );
        }
        if ( this.databaseName != null )
        {
            properties.put ( "databaseName", this.databaseName );
        }
        if ( this.serverName != null )
        {
            properties.put ( "serverName", this.serverName );
        }
        if ( this.portNumber != null )
        {
            properties.put ( "portNumber", "" + this.portNumber );
        }
    }

    protected abstract Map<String, String> getSpecificProperties ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public abstract String getUrl ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public EList<String> getBundles ()
    {
        return ECollections.emptyEList ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( final InternalEObject otherEnd, final int featureID, final NotificationChain msgs )
    {
        switch ( featureID )
        {
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES:
                return ( (InternalEList<?>)getAdditionalProperties () ).basicRemove ( otherEnd, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Integer getLoginTimeout ()
    {
        return this.loginTimeout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLoginTimeout ( final Integer newLoginTimeout )
    {
        final Integer oldLoginTimeout = this.loginTimeout;
        this.loginTimeout = newLoginTimeout;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__LOGIN_TIMEOUT, oldLoginTimeout, this.loginTimeout ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<PropertyEntry> getAdditionalProperties ()
    {
        if ( this.additionalProperties == null )
        {
            this.additionalProperties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES );
        }
        return this.additionalProperties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getDatabaseName ()
    {
        return this.databaseName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDatabaseName ( final String newDatabaseName )
    {
        final String oldDatabaseName = this.databaseName;
        this.databaseName = newDatabaseName;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__DATABASE_NAME, oldDatabaseName, this.databaseName ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getServerName ()
    {
        return this.serverName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setServerName ( final String newServerName )
    {
        final String oldServerName = this.serverName;
        this.serverName = newServerName;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__SERVER_NAME, oldServerName, this.serverName ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Integer getPortNumber ()
    {
        return this.portNumber;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPortNumber ( final Integer newPortNumber )
    {
        final Integer oldPortNumber = this.portNumber;
        this.portNumber = newPortNumber;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__PORT_NUMBER, oldPortNumber, this.portNumber ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet ( final int featureID, final boolean resolve, final boolean coreType )
    {
        switch ( featureID )
        {
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ID:
                return getId ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__USERNAME:
                return getUsername ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__PASSWORD:
                return getPassword ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__LOGIN_TIMEOUT:
                return getLoginTimeout ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES:
                return getAdditionalProperties ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__DATABASE_NAME:
                return getDatabaseName ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__SERVER_NAME:
                return getServerName ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__PORT_NUMBER:
                return getPortNumber ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( final int featureID, final Object newValue )
    {
        switch ( featureID )
        {
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ID:
                setId ( (String)newValue );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__USERNAME:
                setUsername ( (String)newValue );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__PASSWORD:
                setPassword ( (String)newValue );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__LOGIN_TIMEOUT:
                setLoginTimeout ( (Integer)newValue );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES:
                getAdditionalProperties ().clear ();
                getAdditionalProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__DATABASE_NAME:
                setDatabaseName ( (String)newValue );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__SERVER_NAME:
                setServerName ( (String)newValue );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__PORT_NUMBER:
                setPortNumber ( (Integer)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset ( final int featureID )
    {
        switch ( featureID )
        {
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ID:
                setId ( ID_EDEFAULT );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__USERNAME:
                setUsername ( USERNAME_EDEFAULT );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__PASSWORD:
                setPassword ( PASSWORD_EDEFAULT );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__LOGIN_TIMEOUT:
                setLoginTimeout ( LOGIN_TIMEOUT_EDEFAULT );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES:
                getAdditionalProperties ().clear ();
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__DATABASE_NAME:
                setDatabaseName ( DATABASE_NAME_EDEFAULT );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__SERVER_NAME:
                setServerName ( SERVER_NAME_EDEFAULT );
                return;
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__PORT_NUMBER:
                setPortNumber ( PORT_NUMBER_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet ( final int featureID )
    {
        switch ( featureID )
        {
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ID:
                return ID_EDEFAULT == null ? this.id != null : !ID_EDEFAULT.equals ( this.id );
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__USERNAME:
                return USERNAME_EDEFAULT == null ? this.username != null : !USERNAME_EDEFAULT.equals ( this.username );
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__PASSWORD:
                return PASSWORD_EDEFAULT == null ? this.password != null : !PASSWORD_EDEFAULT.equals ( this.password );
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__LOGIN_TIMEOUT:
                return LOGIN_TIMEOUT_EDEFAULT == null ? this.loginTimeout != null : !LOGIN_TIMEOUT_EDEFAULT.equals ( this.loginTimeout );
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES:
                return this.additionalProperties != null && !this.additionalProperties.isEmpty ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__DATABASE_NAME:
                return DATABASE_NAME_EDEFAULT == null ? this.databaseName != null : !DATABASE_NAME_EDEFAULT.equals ( this.databaseName );
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__SERVER_NAME:
                return SERVER_NAME_EDEFAULT == null ? this.serverName != null : !SERVER_NAME_EDEFAULT.equals ( this.serverName );
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS__PORT_NUMBER:
                return PORT_NUMBER_EDEFAULT == null ? this.portNumber != null : !PORT_NUMBER_EDEFAULT.equals ( this.portNumber );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eInvoke ( final int operationID, final EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_DRIVER_NAME:
                return getDriverName ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_PROPERTIES:
                return getProperties ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_URL:
                return getUrl ();
            case WorldPackage.ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_BUNDLES:
                return getBundles ();
        }
        return super.eInvoke ( operationID, arguments );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
        {
            return super.toString ();
        }

        final StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (id: " ); //$NON-NLS-1$
        result.append ( this.id );
        result.append ( ", username: " ); //$NON-NLS-1$
        result.append ( this.username );
        result.append ( ", password: " ); //$NON-NLS-1$
        result.append ( this.password );
        result.append ( ", loginTimeout: " ); //$NON-NLS-1$
        result.append ( this.loginTimeout );
        result.append ( ", databaseName: " ); //$NON-NLS-1$
        result.append ( this.databaseName );
        result.append ( ", serverName: " ); //$NON-NLS-1$
        result.append ( this.serverName );
        result.append ( ", portNumber: " ); //$NON-NLS-1$
        result.append ( this.portNumber );
        result.append ( ')' );
        return result.toString ();
    }

} //AbstractGenericDatabaseSettingsImpl
