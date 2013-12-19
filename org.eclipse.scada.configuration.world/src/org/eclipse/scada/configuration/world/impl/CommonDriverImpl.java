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
package org.eclipse.scada.configuration.world.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.scada.configuration.world.CommonDriver;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.PasswordCredentials;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Common Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.CommonDriverImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.CommonDriverImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.CommonDriverImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.CommonDriverImpl#getEndpoints <em>Endpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CommonDriverImpl extends MinimalEObjectImpl.Container
        implements CommonDriver
{
    /**
     * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getPassword() <em>Password</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected PasswordCredentials password;

    /**
     * The cached value of the '{@link #getEndpoints() <em>Endpoints</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpoints()
     * @generated
     * @ordered
     */
    protected EList<Endpoint> endpoints;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CommonDriverImpl ()
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
        return WorldPackage.Literals.COMMON_DRIVER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getShortDescription ()
    {
        return shortDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShortDescription ( String newShortDescription )
    {
        String oldShortDescription = shortDescription;
        shortDescription = newShortDescription;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.COMMON_DRIVER__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.COMMON_DRIVER__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Endpoint> getEndpoints ()
    {
        if ( endpoints == null )
        {
            endpoints = new EObjectResolvingEList<Endpoint> ( Endpoint.class, this, WorldPackage.COMMON_DRIVER__ENDPOINTS );
        }
        return endpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PasswordCredentials getPassword ()
    {
        if ( password != null && password.eIsProxy () )
        {
            InternalEObject oldPassword = (InternalEObject)password;
            password = (PasswordCredentials)eResolveProxy ( oldPassword );
            if ( password != oldPassword )
            {
                InternalEObject newPassword = (InternalEObject)password;
                NotificationChain msgs = oldPassword.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.COMMON_DRIVER__PASSWORD, null, null );
                if ( newPassword.eInternalContainer () == null )
                {
                    msgs = newPassword.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.COMMON_DRIVER__PASSWORD, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, WorldPackage.COMMON_DRIVER__PASSWORD, oldPassword, password ) );
            }
        }
        return password;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PasswordCredentials basicGetPassword ()
    {
        return password;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPassword ( PasswordCredentials newPassword,
            NotificationChain msgs )
    {
        PasswordCredentials oldPassword = password;
        password = newPassword;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, WorldPackage.COMMON_DRIVER__PASSWORD, oldPassword, newPassword );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPassword ( PasswordCredentials newPassword )
    {
        if ( newPassword != password )
        {
            NotificationChain msgs = null;
            if ( password != null )
                msgs = ( (InternalEObject)password ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.COMMON_DRIVER__PASSWORD, null, msgs );
            if ( newPassword != null )
                msgs = ( (InternalEObject)newPassword ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.COMMON_DRIVER__PASSWORD, null, msgs );
            msgs = basicSetPassword ( newPassword, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.COMMON_DRIVER__PASSWORD, newPassword, newPassword ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd,
            int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case WorldPackage.COMMON_DRIVER__PASSWORD:
                return basicSetPassword ( null, msgs );
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
            case WorldPackage.COMMON_DRIVER__SHORT_DESCRIPTION:
                return getShortDescription ();
            case WorldPackage.COMMON_DRIVER__NAME:
                return getName ();
            case WorldPackage.COMMON_DRIVER__PASSWORD:
                if ( resolve )
                    return getPassword ();
                return basicGetPassword ();
            case WorldPackage.COMMON_DRIVER__ENDPOINTS:
                return getEndpoints ();
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
            case WorldPackage.COMMON_DRIVER__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case WorldPackage.COMMON_DRIVER__NAME:
                setName ( (String)newValue );
                return;
            case WorldPackage.COMMON_DRIVER__PASSWORD:
                setPassword ( (PasswordCredentials)newValue );
                return;
            case WorldPackage.COMMON_DRIVER__ENDPOINTS:
                getEndpoints ().clear ();
                getEndpoints ().addAll ( (Collection<? extends Endpoint>)newValue );
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
            case WorldPackage.COMMON_DRIVER__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case WorldPackage.COMMON_DRIVER__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case WorldPackage.COMMON_DRIVER__PASSWORD:
                setPassword ( (PasswordCredentials)null );
                return;
            case WorldPackage.COMMON_DRIVER__ENDPOINTS:
                getEndpoints ().clear ();
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
            case WorldPackage.COMMON_DRIVER__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case WorldPackage.COMMON_DRIVER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case WorldPackage.COMMON_DRIVER__PASSWORD:
                return password != null;
            case WorldPackage.COMMON_DRIVER__ENDPOINTS:
                return endpoints != null && !endpoints.isEmpty ();
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
        result.append ( " (shortDescription: " ); //$NON-NLS-1$
        result.append ( shortDescription );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ')' );
        return result.toString ();
    }

} //CommonDriverImpl
