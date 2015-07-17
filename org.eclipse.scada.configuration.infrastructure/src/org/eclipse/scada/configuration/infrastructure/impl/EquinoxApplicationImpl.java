/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
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
import org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration;
import org.eclipse.scada.configuration.infrastructure.EquinoxApplication;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.Module;
import org.eclipse.scada.configuration.infrastructure.UserService;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.osgi.IndependentConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equinox Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl#getInstanceNumber
 * <em>Instance Number</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl#getUserService
 * <em>User Service</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl#getSecurityConfiguration
 * <em>Security Configuration</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl#getModules
 * <em>Modules</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl#getConfiguration
 * <em>Configuration</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl#getConfigurations
 * <em>Configurations</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl#getLocalCredentials
 * <em>Local Credentials</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EquinoxApplicationImpl extends MinimalEObjectImpl.Container implements EquinoxApplication
{
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getInstanceNumber()
     * <em>Instance Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInstanceNumber()
     * @generated
     * @ordered
     */
    protected static final int INSTANCE_NUMBER_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getInstanceNumber()
     * <em>Instance Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInstanceNumber()
     * @generated
     * @ordered
     */
    protected int instanceNumber = INSTANCE_NUMBER_EDEFAULT;

    /**
     * The cached value of the '{@link #getUserService() <em>User Service</em>}'
     * containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getUserService()
     * @generated
     * @ordered
     */
    protected UserService userService;

    /**
     * The cached value of the '{@link #getSecurityConfiguration()
     * <em>Security Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getSecurityConfiguration()
     * @generated
     * @ordered
     */
    protected Configuration securityConfiguration;

    /**
     * The cached value of the '{@link #getModules() <em>Modules</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getModules()
     * @generated
     * @ordered
     */
    protected EList<Module> modules;

    /**
     * The cached value of the '{@link #getConfiguration()
     * <em>Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getConfiguration()
     * @generated
     * @ordered
     */
    protected ApplicationConfiguration configuration;

    /**
     * The cached value of the '{@link #getConfigurations()
     * <em>Configurations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getConfigurations()
     * @generated
     * @ordered
     */
    protected EList<IndependentConfiguration> configurations;

    /**
     * The cached value of the '{@link #getLocalCredentials()
     * <em>Local Credentials</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getLocalCredentials()
     * @generated
     * @ordered
     */
    protected Credentials localCredentials;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EquinoxApplicationImpl ()
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
        return InfrastructurePackage.Literals.EQUINOX_APPLICATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName ()
    {
        return this.name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setName ( final String newName )
    {
        final String oldName = this.name;
        this.name = newName;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EQUINOX_APPLICATION__NAME, oldName, this.name ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getInstanceNumber ()
    {
        return this.instanceNumber;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInstanceNumber ( final int newInstanceNumber )
    {
        final int oldInstanceNumber = this.instanceNumber;
        this.instanceNumber = newInstanceNumber;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EQUINOX_APPLICATION__INSTANCE_NUMBER, oldInstanceNumber, this.instanceNumber ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public UserService getUserService ()
    {
        if ( this.userService != null && this.userService.eIsProxy () )
        {
            final InternalEObject oldUserService = (InternalEObject)this.userService;
            this.userService = (UserService)eResolveProxy ( oldUserService );
            if ( this.userService != oldUserService )
            {
                final InternalEObject newUserService = (InternalEObject)this.userService;
                NotificationChain msgs = oldUserService.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE, null, null );
                if ( newUserService.eInternalContainer () == null )
                {
                    msgs = newUserService.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE, null, msgs );
                }
                if ( msgs != null )
                {
                    msgs.dispatch ();
                }
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE, oldUserService, this.userService ) );
                }
            }
        }
        return this.userService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public UserService basicGetUserService ()
    {
        return this.userService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetUserService ( final UserService newUserService, NotificationChain msgs )
    {
        final UserService oldUserService = this.userService;
        this.userService = newUserService;
        if ( eNotificationRequired () )
        {
            final ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE, oldUserService, newUserService );
            if ( msgs == null )
            {
                msgs = notification;
            }
            else
            {
                msgs.add ( notification );
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setUserService ( final UserService newUserService )
    {
        if ( newUserService != this.userService )
        {
            NotificationChain msgs = null;
            if ( this.userService != null )
            {
                msgs = ( (InternalEObject)this.userService ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE, null, msgs );
            }
            if ( newUserService != null )
            {
                msgs = ( (InternalEObject)newUserService ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE, null, msgs );
            }
            msgs = basicSetUserService ( newUserService, msgs );
            if ( msgs != null )
            {
                msgs.dispatch ();
            }
        }
        else if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE, newUserService, newUserService ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<IndependentConfiguration> getConfigurations ()
    {
        if ( this.configurations == null )
        {
            this.configurations = new EObjectContainmentEList.Resolving<IndependentConfiguration> ( IndependentConfiguration.class, this, InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATIONS );
        }
        return this.configurations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ApplicationConfiguration getConfiguration ()
    {
        if ( this.configuration != null && this.configuration.eIsProxy () )
        {
            final InternalEObject oldConfiguration = (InternalEObject)this.configuration;
            this.configuration = (ApplicationConfiguration)eResolveProxy ( oldConfiguration );
            if ( this.configuration != oldConfiguration )
            {
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATION, oldConfiguration, this.configuration ) );
                }
            }
        }
        return this.configuration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ApplicationConfiguration basicGetConfiguration ()
    {
        return this.configuration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setConfiguration ( final ApplicationConfiguration newConfiguration )
    {
        final ApplicationConfiguration oldConfiguration = this.configuration;
        this.configuration = newConfiguration;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATION, oldConfiguration, this.configuration ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Credentials getLocalCredentials ()
    {
        if ( this.localCredentials != null && this.localCredentials.eIsProxy () )
        {
            final InternalEObject oldLocalCredentials = (InternalEObject)this.localCredentials;
            this.localCredentials = (Credentials)eResolveProxy ( oldLocalCredentials );
            if ( this.localCredentials != oldLocalCredentials )
            {
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.EQUINOX_APPLICATION__LOCAL_CREDENTIALS, oldLocalCredentials, this.localCredentials ) );
                }
            }
        }
        return this.localCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Credentials basicGetLocalCredentials ()
    {
        return this.localCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLocalCredentials ( final Credentials newLocalCredentials )
    {
        final Credentials oldLocalCredentials = this.localCredentials;
        this.localCredentials = newLocalCredentials;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EQUINOX_APPLICATION__LOCAL_CREDENTIALS, oldLocalCredentials, this.localCredentials ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Configuration getSecurityConfiguration ()
    {
        if ( this.securityConfiguration != null && this.securityConfiguration.eIsProxy () )
        {
            final InternalEObject oldSecurityConfiguration = (InternalEObject)this.securityConfiguration;
            this.securityConfiguration = (Configuration)eResolveProxy ( oldSecurityConfiguration );
            if ( this.securityConfiguration != oldSecurityConfiguration )
            {
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.EQUINOX_APPLICATION__SECURITY_CONFIGURATION, oldSecurityConfiguration, this.securityConfiguration ) );
                }
            }
        }
        return this.securityConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Configuration basicGetSecurityConfiguration ()
    {
        return this.securityConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSecurityConfiguration ( final Configuration newSecurityConfiguration )
    {
        final Configuration oldSecurityConfiguration = this.securityConfiguration;
        this.securityConfiguration = newSecurityConfiguration;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EQUINOX_APPLICATION__SECURITY_CONFIGURATION, oldSecurityConfiguration, this.securityConfiguration ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Module> getModules ()
    {
        if ( this.modules == null )
        {
            this.modules = new EObjectContainmentEList.Resolving<Module> ( Module.class, this, InfrastructurePackage.EQUINOX_APPLICATION__MODULES );
        }
        return this.modules;
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
            case InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE:
                return basicSetUserService ( null, msgs );
            case InfrastructurePackage.EQUINOX_APPLICATION__MODULES:
                return ( (InternalEList<?>)getModules () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATIONS:
                return ( (InternalEList<?>)getConfigurations () ).basicRemove ( otherEnd, msgs );
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
    public Object eGet ( final int featureID, final boolean resolve, final boolean coreType )
    {
        switch ( featureID )
        {
            case InfrastructurePackage.EQUINOX_APPLICATION__NAME:
                return getName ();
            case InfrastructurePackage.EQUINOX_APPLICATION__INSTANCE_NUMBER:
                return getInstanceNumber ();
            case InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE:
                if ( resolve )
                {
                    return getUserService ();
                }
                return basicGetUserService ();
            case InfrastructurePackage.EQUINOX_APPLICATION__SECURITY_CONFIGURATION:
                if ( resolve )
                {
                    return getSecurityConfiguration ();
                }
                return basicGetSecurityConfiguration ();
            case InfrastructurePackage.EQUINOX_APPLICATION__MODULES:
                return getModules ();
            case InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATION:
                if ( resolve )
                {
                    return getConfiguration ();
                }
                return basicGetConfiguration ();
            case InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATIONS:
                return getConfigurations ();
            case InfrastructurePackage.EQUINOX_APPLICATION__LOCAL_CREDENTIALS:
                if ( resolve )
                {
                    return getLocalCredentials ();
                }
                return basicGetLocalCredentials ();
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
            case InfrastructurePackage.EQUINOX_APPLICATION__NAME:
                setName ( (String)newValue );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__INSTANCE_NUMBER:
                setInstanceNumber ( (Integer)newValue );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE:
                setUserService ( (UserService)newValue );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__SECURITY_CONFIGURATION:
                setSecurityConfiguration ( (Configuration)newValue );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__MODULES:
                getModules ().clear ();
                getModules ().addAll ( (Collection<? extends Module>)newValue );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATION:
                setConfiguration ( (ApplicationConfiguration)newValue );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATIONS:
                getConfigurations ().clear ();
                getConfigurations ().addAll ( (Collection<? extends IndependentConfiguration>)newValue );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__LOCAL_CREDENTIALS:
                setLocalCredentials ( (Credentials)newValue );
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
            case InfrastructurePackage.EQUINOX_APPLICATION__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__INSTANCE_NUMBER:
                setInstanceNumber ( INSTANCE_NUMBER_EDEFAULT );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE:
                setUserService ( (UserService)null );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__SECURITY_CONFIGURATION:
                setSecurityConfiguration ( (Configuration)null );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__MODULES:
                getModules ().clear ();
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATION:
                setConfiguration ( (ApplicationConfiguration)null );
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATIONS:
                getConfigurations ().clear ();
                return;
            case InfrastructurePackage.EQUINOX_APPLICATION__LOCAL_CREDENTIALS:
                setLocalCredentials ( (Credentials)null );
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
            case InfrastructurePackage.EQUINOX_APPLICATION__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals ( this.name );
            case InfrastructurePackage.EQUINOX_APPLICATION__INSTANCE_NUMBER:
                return this.instanceNumber != INSTANCE_NUMBER_EDEFAULT;
            case InfrastructurePackage.EQUINOX_APPLICATION__USER_SERVICE:
                return this.userService != null;
            case InfrastructurePackage.EQUINOX_APPLICATION__SECURITY_CONFIGURATION:
                return this.securityConfiguration != null;
            case InfrastructurePackage.EQUINOX_APPLICATION__MODULES:
                return this.modules != null && !this.modules.isEmpty ();
            case InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATION:
                return this.configuration != null;
            case InfrastructurePackage.EQUINOX_APPLICATION__CONFIGURATIONS:
                return this.configurations != null && !this.configurations.isEmpty ();
            case InfrastructurePackage.EQUINOX_APPLICATION__LOCAL_CREDENTIALS:
                return this.localCredentials != null;
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
    public String toString ()
    {
        if ( eIsProxy () )
        {
            return super.toString ();
        }

        final StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( this.name );
        result.append ( ", instanceNumber: " ); //$NON-NLS-1$
        result.append ( this.instanceNumber );
        result.append ( ')' );
        return result.toString ();
    }

} //EquinoxApplicationImpl
