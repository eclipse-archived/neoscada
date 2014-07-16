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
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.infrastructure.CommonDriver;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.world.PasswordCredentials;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Common Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.CommonDriverImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.CommonDriverImpl#getPortNumber <em>Port Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommonDriverImpl extends AbstractFactoryDriverImpl implements CommonDriver
{
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
     * The default value of the '{@link #getPortNumber() <em>Port Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPortNumber()
     * @generated
     * @ordered
     */
    protected static final int PORT_NUMBER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPortNumber() <em>Port Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPortNumber()
     * @generated
     * @ordered
     */
    protected int portNumber = PORT_NUMBER_EDEFAULT;

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
        return InfrastructurePackage.Literals.COMMON_DRIVER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PasswordCredentials getPassword ()
    {
        if ( password != null && password.eIsProxy () )
        {
            InternalEObject oldPassword = (InternalEObject)password;
            password = (PasswordCredentials)eResolveProxy ( oldPassword );
            if ( password != oldPassword )
            {
                InternalEObject newPassword = (InternalEObject)password;
                NotificationChain msgs = oldPassword.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.COMMON_DRIVER__PASSWORD, null, null );
                if ( newPassword.eInternalContainer () == null )
                {
                    msgs = newPassword.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.COMMON_DRIVER__PASSWORD, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.COMMON_DRIVER__PASSWORD, oldPassword, password ) );
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
    public NotificationChain basicSetPassword ( PasswordCredentials newPassword, NotificationChain msgs )
    {
        PasswordCredentials oldPassword = password;
        password = newPassword;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.COMMON_DRIVER__PASSWORD, oldPassword, newPassword );
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
                msgs = ( (InternalEObject)password ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.COMMON_DRIVER__PASSWORD, null, msgs );
            if ( newPassword != null )
                msgs = ( (InternalEObject)newPassword ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.COMMON_DRIVER__PASSWORD, null, msgs );
            msgs = basicSetPassword ( newPassword, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.COMMON_DRIVER__PASSWORD, newPassword, newPassword ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getPortNumber ()
    {
        return portNumber;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPortNumber ( int newPortNumber )
    {
        int oldPortNumber = portNumber;
        portNumber = newPortNumber;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.COMMON_DRIVER__PORT_NUMBER, oldPortNumber, portNumber ) );
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
            case InfrastructurePackage.COMMON_DRIVER__PASSWORD:
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
            case InfrastructurePackage.COMMON_DRIVER__PASSWORD:
                if ( resolve )
                    return getPassword ();
                return basicGetPassword ();
            case InfrastructurePackage.COMMON_DRIVER__PORT_NUMBER:
                return getPortNumber ();
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
            case InfrastructurePackage.COMMON_DRIVER__PASSWORD:
                setPassword ( (PasswordCredentials)newValue );
                return;
            case InfrastructurePackage.COMMON_DRIVER__PORT_NUMBER:
                setPortNumber ( (Integer)newValue );
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
            case InfrastructurePackage.COMMON_DRIVER__PASSWORD:
                setPassword ( (PasswordCredentials)null );
                return;
            case InfrastructurePackage.COMMON_DRIVER__PORT_NUMBER:
                setPortNumber ( PORT_NUMBER_EDEFAULT );
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
            case InfrastructurePackage.COMMON_DRIVER__PASSWORD:
                return password != null;
            case InfrastructurePackage.COMMON_DRIVER__PORT_NUMBER:
                return portNumber != PORT_NUMBER_EDEFAULT;
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
        result.append ( " (portNumber: " ); //$NON-NLS-1$
        result.append ( portNumber );
        result.append ( ')' );
        return result.toString ();
    }

} //CommonDriverImpl
