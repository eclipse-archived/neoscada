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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.UserService;

import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.Credentials;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Equinox Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractEquinoxDriverImpl#getInstanceNumber <em>Instance Number</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractEquinoxDriverImpl#getUserService <em>User Service</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractEquinoxDriverImpl#getSecurityConfiguration <em>Security Configuration</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractEquinoxDriverImpl#getAccessCredentials <em>Access Credentials</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractEquinoxDriverImpl extends DriverImpl implements AbstractEquinoxDriver
{
    /**
     * The default value of the '{@link #getInstanceNumber() <em>Instance Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceNumber()
     * @generated
     * @ordered
     */
    protected static final int INSTANCE_NUMBER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getInstanceNumber() <em>Instance Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceNumber()
     * @generated
     * @ordered
     */
    protected int instanceNumber = INSTANCE_NUMBER_EDEFAULT;

    /**
     * The cached value of the '{@link #getUserService() <em>User Service</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUserService()
     * @generated
     * @ordered
     */
    protected UserService userService;

    /**
     * The cached value of the '{@link #getSecurityConfiguration() <em>Security Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSecurityConfiguration()
     * @generated
     * @ordered
     */
    protected Configuration securityConfiguration;

    /**
     * The cached value of the '{@link #getAccessCredentials() <em>Access Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAccessCredentials()
     * @generated
     * @ordered
     */
    protected Credentials accessCredentials;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractEquinoxDriverImpl ()
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
        return InfrastructurePackage.Literals.ABSTRACT_EQUINOX_DRIVER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Configuration getSecurityConfiguration ()
    {
        if ( securityConfiguration != null && securityConfiguration.eIsProxy () )
        {
            InternalEObject oldSecurityConfiguration = (InternalEObject)securityConfiguration;
            securityConfiguration = (Configuration)eResolveProxy ( oldSecurityConfiguration );
            if ( securityConfiguration != oldSecurityConfiguration )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION, oldSecurityConfiguration, securityConfiguration ) );
            }
        }
        return securityConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Configuration basicGetSecurityConfiguration ()
    {
        return securityConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSecurityConfiguration ( Configuration newSecurityConfiguration )
    {
        Configuration oldSecurityConfiguration = securityConfiguration;
        securityConfiguration = newSecurityConfiguration;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION, oldSecurityConfiguration, securityConfiguration ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials getAccessCredentials ()
    {
        if ( accessCredentials != null && accessCredentials.eIsProxy () )
        {
            InternalEObject oldAccessCredentials = (InternalEObject)accessCredentials;
            accessCredentials = (Credentials)eResolveProxy ( oldAccessCredentials );
            if ( accessCredentials != oldAccessCredentials )
            {
                InternalEObject newAccessCredentials = (InternalEObject)accessCredentials;
                NotificationChain msgs = oldAccessCredentials.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS, null, null );
                if ( newAccessCredentials.eInternalContainer () == null )
                {
                    msgs = newAccessCredentials.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS, oldAccessCredentials, accessCredentials ) );
            }
        }
        return accessCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials basicGetAccessCredentials ()
    {
        return accessCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetAccessCredentials ( Credentials newAccessCredentials, NotificationChain msgs )
    {
        Credentials oldAccessCredentials = accessCredentials;
        accessCredentials = newAccessCredentials;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS, oldAccessCredentials, newAccessCredentials );
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
    public void setAccessCredentials ( Credentials newAccessCredentials )
    {
        if ( newAccessCredentials != accessCredentials )
        {
            NotificationChain msgs = null;
            if ( accessCredentials != null )
                msgs = ( (InternalEObject)accessCredentials ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS, null, msgs );
            if ( newAccessCredentials != null )
                msgs = ( (InternalEObject)newAccessCredentials ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS, null, msgs );
            msgs = basicSetAccessCredentials ( newAccessCredentials, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS, newAccessCredentials, newAccessCredentials ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserService getUserService ()
    {
        if ( userService != null && userService.eIsProxy () )
        {
            InternalEObject oldUserService = (InternalEObject)userService;
            userService = (UserService)eResolveProxy ( oldUserService );
            if ( userService != oldUserService )
            {
                InternalEObject newUserService = (InternalEObject)userService;
                NotificationChain msgs = oldUserService.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE, null, null );
                if ( newUserService.eInternalContainer () == null )
                {
                    msgs = newUserService.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE, oldUserService, userService ) );
            }
        }
        return userService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserService basicGetUserService ()
    {
        return userService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUserService ( UserService newUserService, NotificationChain msgs )
    {
        UserService oldUserService = userService;
        userService = newUserService;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE, oldUserService, newUserService );
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
    public void setUserService ( UserService newUserService )
    {
        if ( newUserService != userService )
        {
            NotificationChain msgs = null;
            if ( userService != null )
                msgs = ( (InternalEObject)userService ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE, null, msgs );
            if ( newUserService != null )
                msgs = ( (InternalEObject)newUserService ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE, null, msgs );
            msgs = basicSetUserService ( newUserService, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE, newUserService, newUserService ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getInstanceNumber ()
    {
        return instanceNumber;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInstanceNumber ( int newInstanceNumber )
    {
        int oldInstanceNumber = instanceNumber;
        instanceNumber = newInstanceNumber;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__INSTANCE_NUMBER, oldInstanceNumber, instanceNumber ) );
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
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE:
                return basicSetUserService ( null, msgs );
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS:
                return basicSetAccessCredentials ( null, msgs );
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
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__INSTANCE_NUMBER:
                return getInstanceNumber ();
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE:
                if ( resolve )
                    return getUserService ();
                return basicGetUserService ();
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION:
                if ( resolve )
                    return getSecurityConfiguration ();
                return basicGetSecurityConfiguration ();
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS:
                if ( resolve )
                    return getAccessCredentials ();
                return basicGetAccessCredentials ();
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
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__INSTANCE_NUMBER:
                setInstanceNumber ( (Integer)newValue );
                return;
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE:
                setUserService ( (UserService)newValue );
                return;
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION:
                setSecurityConfiguration ( (Configuration)newValue );
                return;
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS:
                setAccessCredentials ( (Credentials)newValue );
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
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__INSTANCE_NUMBER:
                setInstanceNumber ( INSTANCE_NUMBER_EDEFAULT );
                return;
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE:
                setUserService ( (UserService)null );
                return;
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION:
                setSecurityConfiguration ( (Configuration)null );
                return;
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS:
                setAccessCredentials ( (Credentials)null );
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
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__INSTANCE_NUMBER:
                return instanceNumber != INSTANCE_NUMBER_EDEFAULT;
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE:
                return userService != null;
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION:
                return securityConfiguration != null;
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS:
                return accessCredentials != null;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID ( int derivedFeatureID, Class<?> baseClass )
    {
        if ( baseClass == EquinoxBase.class )
        {
            switch ( derivedFeatureID )
            {
                case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__INSTANCE_NUMBER:
                    return InfrastructurePackage.EQUINOX_BASE__INSTANCE_NUMBER;
                case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE:
                    return InfrastructurePackage.EQUINOX_BASE__USER_SERVICE;
                case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION:
                    return InfrastructurePackage.EQUINOX_BASE__SECURITY_CONFIGURATION;
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID ( derivedFeatureID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID ( int baseFeatureID, Class<?> baseClass )
    {
        if ( baseClass == EquinoxBase.class )
        {
            switch ( baseFeatureID )
            {
                case InfrastructurePackage.EQUINOX_BASE__INSTANCE_NUMBER:
                    return InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__INSTANCE_NUMBER;
                case InfrastructurePackage.EQUINOX_BASE__USER_SERVICE:
                    return InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE;
                case InfrastructurePackage.EQUINOX_BASE__SECURITY_CONFIGURATION:
                    return InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID ( baseFeatureID, baseClass );
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
        result.append ( " (instanceNumber: " ); //$NON-NLS-1$
        result.append ( instanceNumber );
        result.append ( ')' );
        return result.toString ();
    }

} //AbstractEquinoxDriverImpl
