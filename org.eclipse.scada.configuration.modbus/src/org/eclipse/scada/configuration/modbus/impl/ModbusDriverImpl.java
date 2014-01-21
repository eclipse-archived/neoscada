/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.modbus.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.modbus.ModbusDriver;
import org.eclipse.scada.configuration.modbus.ModbusMaster;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl#getShortDescription
 * <em>Short Description</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl#getConnections
 * <em>Connections</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl#getExporter
 * <em>Exporter</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl#getCustomizationProfile
 * <em>Customization Profile</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl#getSecurityConfiguration
 * <em>Security Configuration</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl#getModules
 * <em>Modules</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl#getMasters
 * <em>Masters</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModbusDriverImpl extends MinimalEObjectImpl.Container implements ModbusDriver
{
    /**
     * The default value of the '{@link #getShortDescription()
     * <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getShortDescription()
     * <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

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
     * The cached value of the '{@link #getConnections() <em>Connections</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getConnections()
     * @generated
     * @ordered
     */
    protected EList<Connection> connections;

    /**
     * The cached value of the '{@link #getExporter() <em>Exporter</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getExporter()
     * @generated
     * @ordered
     */
    protected EList<Exporter> exporter;

    /**
     * The cached value of the '{@link #getCustomizationProfile()
     * <em>Customization Profile</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getCustomizationProfile()
     * @generated
     * @ordered
     */
    protected Profile customizationProfile;

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
    protected EList<ApplicationModule> modules;

    /**
     * The cached value of the '{@link #getMasters() <em>Masters</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMasters()
     * @generated
     * @ordered
     */
    protected EList<ModbusMaster> masters;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ModbusDriverImpl ()
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
        return ModbusPackage.Literals.MODBUS_DRIVER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getShortDescription ()
    {
        return this.shortDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setShortDescription ( final String newShortDescription )
    {
        final String oldShortDescription = this.shortDescription;
        this.shortDescription = newShortDescription;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_DRIVER__SHORT_DESCRIPTION, oldShortDescription, this.shortDescription ) );
        }
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_DRIVER__NAME, oldName, this.name ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Connection> getConnections ()
    {
        if ( this.connections == null )
        {
            this.connections = new EObjectContainmentEList.Resolving<Connection> ( Connection.class, this, ModbusPackage.MODBUS_DRIVER__CONNECTIONS );
        }
        return this.connections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Exporter> getExporter ()
    {
        if ( this.exporter == null )
        {
            this.exporter = new EObjectContainmentEList.Resolving<Exporter> ( Exporter.class, this, ModbusPackage.MODBUS_DRIVER__EXPORTER );
        }
        return this.exporter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Profile getCustomizationProfile ()
    {
        if ( this.customizationProfile != null && this.customizationProfile.eIsProxy () )
        {
            final InternalEObject oldCustomizationProfile = (InternalEObject)this.customizationProfile;
            this.customizationProfile = (Profile)eResolveProxy ( oldCustomizationProfile );
            if ( this.customizationProfile != oldCustomizationProfile )
            {
                final InternalEObject newCustomizationProfile = (InternalEObject)this.customizationProfile;
                NotificationChain msgs = oldCustomizationProfile.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE, null, null );
                if ( newCustomizationProfile.eInternalContainer () == null )
                {
                    msgs = newCustomizationProfile.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE, null, msgs );
                }
                if ( msgs != null )
                {
                    msgs.dispatch ();
                }
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE, oldCustomizationProfile, this.customizationProfile ) );
                }
            }
        }
        return this.customizationProfile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Profile basicGetCustomizationProfile ()
    {
        return this.customizationProfile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetCustomizationProfile ( final Profile newCustomizationProfile, NotificationChain msgs )
    {
        final Profile oldCustomizationProfile = this.customizationProfile;
        this.customizationProfile = newCustomizationProfile;
        if ( eNotificationRequired () )
        {
            final ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE, oldCustomizationProfile, newCustomizationProfile );
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
    public void setCustomizationProfile ( final Profile newCustomizationProfile )
    {
        if ( newCustomizationProfile != this.customizationProfile )
        {
            NotificationChain msgs = null;
            if ( this.customizationProfile != null )
            {
                msgs = ( (InternalEObject)this.customizationProfile ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE, null, msgs );
            }
            if ( newCustomizationProfile != null )
            {
                msgs = ( (InternalEObject)newCustomizationProfile ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE, null, msgs );
            }
            msgs = basicSetCustomizationProfile ( newCustomizationProfile, msgs );
            if ( msgs != null )
            {
                msgs.dispatch ();
            }
        }
        else if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE, newCustomizationProfile, newCustomizationProfile ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ModbusPackage.MODBUS_DRIVER__SECURITY_CONFIGURATION, oldSecurityConfiguration, this.securityConfiguration ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_DRIVER__SECURITY_CONFIGURATION, oldSecurityConfiguration, this.securityConfiguration ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<ApplicationModule> getModules ()
    {
        if ( this.modules == null )
        {
            this.modules = new EObjectContainmentEList.Resolving<ApplicationModule> ( ApplicationModule.class, this, ModbusPackage.MODBUS_DRIVER__MODULES );
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
    public EList<ModbusMaster> getMasters ()
    {
        if ( this.masters == null )
        {
            this.masters = new EObjectContainmentEList<ModbusMaster> ( ModbusMaster.class, this, ModbusPackage.MODBUS_DRIVER__MASTERS );
        }
        return this.masters;
    }

    private static final String DEFAULT_URI = "platform:/plugin/org.eclipse.scada.configuration.modbus/model/default.modbus.xml#/";

    private Profile profile;

    @Override
    public Profile getProfile ()
    {
        if ( this.profile == null )
        {
            final ResourceSet rs = new ResourceSetImpl ();
            final Resource r = rs.createResource ( URI.createURI ( DEFAULT_URI ), "org.eclipse.scada.configuration.world.osgi.profile" );
            try
            {
                r.load ( null );
            }
            catch ( final IOException e )
            {
                throw new RuntimeException ( e );
            }
            this.profile = (Profile)EcoreUtil.getObjectByType ( r.getContents (), ProfilePackage.Literals.PROFILE );
            if ( this.profile == null )
            {
                throw new IllegalStateException ( String.format ( "Resource loaded from %s does not contain an object of type %s", DEFAULT_URI, Profile.class.getName () ) );
            }
        }

        return this.profile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public EList<Endpoint> getEndpoints ()
    {
        final EList<Endpoint> result = ECollections.newBasicEList ();
        for ( final Exporter exporter : getExporter () )
        {
            result.addAll ( exporter.getEndpoints () );
        }
        return result;
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
            case ModbusPackage.MODBUS_DRIVER__CONNECTIONS:
                return ( (InternalEList<?>)getConnections () ).basicRemove ( otherEnd, msgs );
            case ModbusPackage.MODBUS_DRIVER__EXPORTER:
                return ( (InternalEList<?>)getExporter () ).basicRemove ( otherEnd, msgs );
            case ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE:
                return basicSetCustomizationProfile ( null, msgs );
            case ModbusPackage.MODBUS_DRIVER__MODULES:
                return ( (InternalEList<?>)getModules () ).basicRemove ( otherEnd, msgs );
            case ModbusPackage.MODBUS_DRIVER__MASTERS:
                return ( (InternalEList<?>)getMasters () ).basicRemove ( otherEnd, msgs );
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
            case ModbusPackage.MODBUS_DRIVER__SHORT_DESCRIPTION:
                return getShortDescription ();
            case ModbusPackage.MODBUS_DRIVER__NAME:
                return getName ();
            case ModbusPackage.MODBUS_DRIVER__CONNECTIONS:
                return getConnections ();
            case ModbusPackage.MODBUS_DRIVER__EXPORTER:
                return getExporter ();
            case ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE:
                if ( resolve )
                {
                    return getCustomizationProfile ();
                }
                return basicGetCustomizationProfile ();
            case ModbusPackage.MODBUS_DRIVER__SECURITY_CONFIGURATION:
                if ( resolve )
                {
                    return getSecurityConfiguration ();
                }
                return basicGetSecurityConfiguration ();
            case ModbusPackage.MODBUS_DRIVER__MODULES:
                return getModules ();
            case ModbusPackage.MODBUS_DRIVER__MASTERS:
                return getMasters ();
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
            case ModbusPackage.MODBUS_DRIVER__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case ModbusPackage.MODBUS_DRIVER__NAME:
                setName ( (String)newValue );
                return;
            case ModbusPackage.MODBUS_DRIVER__CONNECTIONS:
                getConnections ().clear ();
                getConnections ().addAll ( (Collection<? extends Connection>)newValue );
                return;
            case ModbusPackage.MODBUS_DRIVER__EXPORTER:
                getExporter ().clear ();
                getExporter ().addAll ( (Collection<? extends Exporter>)newValue );
                return;
            case ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE:
                setCustomizationProfile ( (Profile)newValue );
                return;
            case ModbusPackage.MODBUS_DRIVER__SECURITY_CONFIGURATION:
                setSecurityConfiguration ( (Configuration)newValue );
                return;
            case ModbusPackage.MODBUS_DRIVER__MODULES:
                getModules ().clear ();
                getModules ().addAll ( (Collection<? extends ApplicationModule>)newValue );
                return;
            case ModbusPackage.MODBUS_DRIVER__MASTERS:
                getMasters ().clear ();
                getMasters ().addAll ( (Collection<? extends ModbusMaster>)newValue );
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
            case ModbusPackage.MODBUS_DRIVER__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_DRIVER__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_DRIVER__CONNECTIONS:
                getConnections ().clear ();
                return;
            case ModbusPackage.MODBUS_DRIVER__EXPORTER:
                getExporter ().clear ();
                return;
            case ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE:
                setCustomizationProfile ( (Profile)null );
                return;
            case ModbusPackage.MODBUS_DRIVER__SECURITY_CONFIGURATION:
                setSecurityConfiguration ( (Configuration)null );
                return;
            case ModbusPackage.MODBUS_DRIVER__MODULES:
                getModules ().clear ();
                return;
            case ModbusPackage.MODBUS_DRIVER__MASTERS:
                getMasters ().clear ();
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
            case ModbusPackage.MODBUS_DRIVER__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? this.shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( this.shortDescription );
            case ModbusPackage.MODBUS_DRIVER__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals ( this.name );
            case ModbusPackage.MODBUS_DRIVER__CONNECTIONS:
                return this.connections != null && !this.connections.isEmpty ();
            case ModbusPackage.MODBUS_DRIVER__EXPORTER:
                return this.exporter != null && !this.exporter.isEmpty ();
            case ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE:
                return this.customizationProfile != null;
            case ModbusPackage.MODBUS_DRIVER__SECURITY_CONFIGURATION:
                return this.securityConfiguration != null;
            case ModbusPackage.MODBUS_DRIVER__MODULES:
                return this.modules != null && !this.modules.isEmpty ();
            case ModbusPackage.MODBUS_DRIVER__MASTERS:
                return this.masters != null && !this.masters.isEmpty ();
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
    public int eBaseStructuralFeatureID ( final int derivedFeatureID, final Class<?> baseClass )
    {
        if ( baseClass == EquinoxApplication.class )
        {
            switch ( derivedFeatureID )
            {
                case ModbusPackage.MODBUS_DRIVER__CONNECTIONS:
                    return OsgiPackage.EQUINOX_APPLICATION__CONNECTIONS;
                case ModbusPackage.MODBUS_DRIVER__EXPORTER:
                    return OsgiPackage.EQUINOX_APPLICATION__EXPORTER;
                case ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE:
                    return OsgiPackage.EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE;
                case ModbusPackage.MODBUS_DRIVER__SECURITY_CONFIGURATION:
                    return OsgiPackage.EQUINOX_APPLICATION__SECURITY_CONFIGURATION;
                case ModbusPackage.MODBUS_DRIVER__MODULES:
                    return OsgiPackage.EQUINOX_APPLICATION__MODULES;
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID ( derivedFeatureID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID ( final int baseFeatureID, final Class<?> baseClass )
    {
        if ( baseClass == EquinoxApplication.class )
        {
            switch ( baseFeatureID )
            {
                case OsgiPackage.EQUINOX_APPLICATION__CONNECTIONS:
                    return ModbusPackage.MODBUS_DRIVER__CONNECTIONS;
                case OsgiPackage.EQUINOX_APPLICATION__EXPORTER:
                    return ModbusPackage.MODBUS_DRIVER__EXPORTER;
                case OsgiPackage.EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE:
                    return ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE;
                case OsgiPackage.EQUINOX_APPLICATION__SECURITY_CONFIGURATION:
                    return ModbusPackage.MODBUS_DRIVER__SECURITY_CONFIGURATION;
                case OsgiPackage.EQUINOX_APPLICATION__MODULES:
                    return ModbusPackage.MODBUS_DRIVER__MODULES;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID ( baseFeatureID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedOperationID ( final int baseOperationID, final Class<?> baseClass )
    {
        if ( baseClass == EquinoxApplication.class )
        {
            switch ( baseOperationID )
            {
                case OsgiPackage.EQUINOX_APPLICATION___GET_PROFILE:
                    return ModbusPackage.MODBUS_DRIVER___GET_PROFILE;
                default:
                    return -1;
            }
        }
        return super.eDerivedOperationID ( baseOperationID, baseClass );
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
            case ModbusPackage.MODBUS_DRIVER___GET_PROFILE:
                return getProfile ();
            case ModbusPackage.MODBUS_DRIVER___GET_ENDPOINTS:
                return getEndpoints ();
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
        result.append ( " (shortDescription: " ); //$NON-NLS-1$
        result.append ( this.shortDescription );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( this.name );
        result.append ( ')' );
        return result.toString ();
    }

} //ModbusDriverImpl
