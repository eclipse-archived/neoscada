/**
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.neoscada.configuration.iec60870.impl;

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
import org.eclipse.neoscada.configuration.iec60870.ClientDevice;
import org.eclipse.neoscada.configuration.iec60870.DriverApplication;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
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
 * An implementation of the model object '<em><b>Driver Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl#getExporter <em>Exporter</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl#getCustomizationProfile <em>Customization Profile</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl#getSecurityConfiguration <em>Security Configuration</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl#getDevices <em>Devices</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DriverApplicationImpl extends MinimalEObjectImpl.Container implements DriverApplication
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
     * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnections()
     * @generated
     * @ordered
     */
    protected EList<Connection> connections;

    /**
     * The cached value of the '{@link #getExporter() <em>Exporter</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExporter()
     * @generated
     * @ordered
     */
    protected EList<Exporter> exporter;

    /**
     * The cached value of the '{@link #getCustomizationProfile() <em>Customization Profile</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomizationProfile()
     * @generated
     * @ordered
     */
    protected Profile customizationProfile;

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
     * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModules()
     * @generated
     * @ordered
     */
    protected EList<ApplicationModule> modules;

    /**
     * The cached value of the '{@link #getDevices() <em>Devices</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDevices()
     * @generated
     * @ordered
     */
    protected EList<ClientDevice> devices;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DriverApplicationImpl ()
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
        return IEC60870Package.Literals.DRIVER_APPLICATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getShortDescription ()
    {
        return shortDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setShortDescription ( String newShortDescription )
    {
        String oldShortDescription = shortDescription;
        shortDescription = newShortDescription;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DRIVER_APPLICATION__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DRIVER_APPLICATION__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Connection> getConnections ()
    {
        if ( connections == null )
        {
            connections = new EObjectContainmentEList.Resolving<Connection> ( Connection.class, this, IEC60870Package.DRIVER_APPLICATION__CONNECTIONS );
        }
        return connections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Exporter> getExporter ()
    {
        if ( exporter == null )
        {
            exporter = new EObjectContainmentEList.Resolving<Exporter> ( Exporter.class, this, IEC60870Package.DRIVER_APPLICATION__EXPORTER );
        }
        return exporter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Profile getCustomizationProfile ()
    {
        if ( customizationProfile != null && customizationProfile.eIsProxy () )
        {
            InternalEObject oldCustomizationProfile = (InternalEObject)customizationProfile;
            customizationProfile = (Profile)eResolveProxy ( oldCustomizationProfile );
            if ( customizationProfile != oldCustomizationProfile )
            {
                InternalEObject newCustomizationProfile = (InternalEObject)customizationProfile;
                NotificationChain msgs = oldCustomizationProfile.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE, null, null );
                if ( newCustomizationProfile.eInternalContainer () == null )
                {
                    msgs = newCustomizationProfile.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE, oldCustomizationProfile, customizationProfile ) );
            }
        }
        return customizationProfile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Profile basicGetCustomizationProfile ()
    {
        return customizationProfile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCustomizationProfile ( Profile newCustomizationProfile, NotificationChain msgs )
    {
        Profile oldCustomizationProfile = customizationProfile;
        customizationProfile = newCustomizationProfile;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE, oldCustomizationProfile, newCustomizationProfile );
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
    @Override
    public void setCustomizationProfile ( Profile newCustomizationProfile )
    {
        if ( newCustomizationProfile != customizationProfile )
        {
            NotificationChain msgs = null;
            if ( customizationProfile != null )
                msgs = ( (InternalEObject)customizationProfile ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE, null, msgs );
            if ( newCustomizationProfile != null )
                msgs = ( (InternalEObject)newCustomizationProfile ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE, null, msgs );
            msgs = basicSetCustomizationProfile ( newCustomizationProfile, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE, newCustomizationProfile, newCustomizationProfile ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Configuration getSecurityConfiguration ()
    {
        if ( securityConfiguration != null && securityConfiguration.eIsProxy () )
        {
            InternalEObject oldSecurityConfiguration = (InternalEObject)securityConfiguration;
            securityConfiguration = (Configuration)eResolveProxy ( oldSecurityConfiguration );
            if ( securityConfiguration != oldSecurityConfiguration )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, IEC60870Package.DRIVER_APPLICATION__SECURITY_CONFIGURATION, oldSecurityConfiguration, securityConfiguration ) );
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
    @Override
    public void setSecurityConfiguration ( Configuration newSecurityConfiguration )
    {
        Configuration oldSecurityConfiguration = securityConfiguration;
        securityConfiguration = newSecurityConfiguration;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DRIVER_APPLICATION__SECURITY_CONFIGURATION, oldSecurityConfiguration, securityConfiguration ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<ApplicationModule> getModules ()
    {
        if ( modules == null )
        {
            modules = new EObjectContainmentEList.Resolving<ApplicationModule> ( ApplicationModule.class, this, IEC60870Package.DRIVER_APPLICATION__MODULES );
        }
        return modules;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<ClientDevice> getDevices ()
    {
        if ( devices == null )
        {
            devices = new EObjectContainmentEList<ClientDevice> ( ClientDevice.class, this, IEC60870Package.DRIVER_APPLICATION__DEVICES );
        }
        return devices;
    }

    /**
     * @generated NOT
     */
    private static final String DEFAULT_URI = "platform:/plugin/org.eclipse.neoscada.configuration.iec60870/model/default.driver.xml#/";

    /**
     * @generated NOT
     */
    private Profile profile;

    /**
     * @generated NOT
     */
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
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case IEC60870Package.DRIVER_APPLICATION__CONNECTIONS:
                return ( (InternalEList<?>)getConnections () ).basicRemove ( otherEnd, msgs );
            case IEC60870Package.DRIVER_APPLICATION__EXPORTER:
                return ( (InternalEList<?>)getExporter () ).basicRemove ( otherEnd, msgs );
            case IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE:
                return basicSetCustomizationProfile ( null, msgs );
            case IEC60870Package.DRIVER_APPLICATION__MODULES:
                return ( (InternalEList<?>)getModules () ).basicRemove ( otherEnd, msgs );
            case IEC60870Package.DRIVER_APPLICATION__DEVICES:
                return ( (InternalEList<?>)getDevices () ).basicRemove ( otherEnd, msgs );
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
            case IEC60870Package.DRIVER_APPLICATION__SHORT_DESCRIPTION:
                return getShortDescription ();
            case IEC60870Package.DRIVER_APPLICATION__NAME:
                return getName ();
            case IEC60870Package.DRIVER_APPLICATION__CONNECTIONS:
                return getConnections ();
            case IEC60870Package.DRIVER_APPLICATION__EXPORTER:
                return getExporter ();
            case IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE:
                if ( resolve )
                    return getCustomizationProfile ();
                return basicGetCustomizationProfile ();
            case IEC60870Package.DRIVER_APPLICATION__SECURITY_CONFIGURATION:
                if ( resolve )
                    return getSecurityConfiguration ();
                return basicGetSecurityConfiguration ();
            case IEC60870Package.DRIVER_APPLICATION__MODULES:
                return getModules ();
            case IEC60870Package.DRIVER_APPLICATION__DEVICES:
                return getDevices ();
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
            case IEC60870Package.DRIVER_APPLICATION__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case IEC60870Package.DRIVER_APPLICATION__NAME:
                setName ( (String)newValue );
                return;
            case IEC60870Package.DRIVER_APPLICATION__CONNECTIONS:
                getConnections ().clear ();
                getConnections ().addAll ( (Collection<? extends Connection>)newValue );
                return;
            case IEC60870Package.DRIVER_APPLICATION__EXPORTER:
                getExporter ().clear ();
                getExporter ().addAll ( (Collection<? extends Exporter>)newValue );
                return;
            case IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE:
                setCustomizationProfile ( (Profile)newValue );
                return;
            case IEC60870Package.DRIVER_APPLICATION__SECURITY_CONFIGURATION:
                setSecurityConfiguration ( (Configuration)newValue );
                return;
            case IEC60870Package.DRIVER_APPLICATION__MODULES:
                getModules ().clear ();
                getModules ().addAll ( (Collection<? extends ApplicationModule>)newValue );
                return;
            case IEC60870Package.DRIVER_APPLICATION__DEVICES:
                getDevices ().clear ();
                getDevices ().addAll ( (Collection<? extends ClientDevice>)newValue );
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
            case IEC60870Package.DRIVER_APPLICATION__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case IEC60870Package.DRIVER_APPLICATION__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case IEC60870Package.DRIVER_APPLICATION__CONNECTIONS:
                getConnections ().clear ();
                return;
            case IEC60870Package.DRIVER_APPLICATION__EXPORTER:
                getExporter ().clear ();
                return;
            case IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE:
                setCustomizationProfile ( (Profile)null );
                return;
            case IEC60870Package.DRIVER_APPLICATION__SECURITY_CONFIGURATION:
                setSecurityConfiguration ( (Configuration)null );
                return;
            case IEC60870Package.DRIVER_APPLICATION__MODULES:
                getModules ().clear ();
                return;
            case IEC60870Package.DRIVER_APPLICATION__DEVICES:
                getDevices ().clear ();
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
            case IEC60870Package.DRIVER_APPLICATION__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case IEC60870Package.DRIVER_APPLICATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case IEC60870Package.DRIVER_APPLICATION__CONNECTIONS:
                return connections != null && !connections.isEmpty ();
            case IEC60870Package.DRIVER_APPLICATION__EXPORTER:
                return exporter != null && !exporter.isEmpty ();
            case IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE:
                return customizationProfile != null;
            case IEC60870Package.DRIVER_APPLICATION__SECURITY_CONFIGURATION:
                return securityConfiguration != null;
            case IEC60870Package.DRIVER_APPLICATION__MODULES:
                return modules != null && !modules.isEmpty ();
            case IEC60870Package.DRIVER_APPLICATION__DEVICES:
                return devices != null && !devices.isEmpty ();
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
        if ( baseClass == EquinoxApplication.class )
        {
            switch ( derivedFeatureID )
            {
                case IEC60870Package.DRIVER_APPLICATION__CONNECTIONS:
                    return OsgiPackage.EQUINOX_APPLICATION__CONNECTIONS;
                case IEC60870Package.DRIVER_APPLICATION__EXPORTER:
                    return OsgiPackage.EQUINOX_APPLICATION__EXPORTER;
                case IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE:
                    return OsgiPackage.EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE;
                case IEC60870Package.DRIVER_APPLICATION__SECURITY_CONFIGURATION:
                    return OsgiPackage.EQUINOX_APPLICATION__SECURITY_CONFIGURATION;
                case IEC60870Package.DRIVER_APPLICATION__MODULES:
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
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID ( int baseFeatureID, Class<?> baseClass )
    {
        if ( baseClass == EquinoxApplication.class )
        {
            switch ( baseFeatureID )
            {
                case OsgiPackage.EQUINOX_APPLICATION__CONNECTIONS:
                    return IEC60870Package.DRIVER_APPLICATION__CONNECTIONS;
                case OsgiPackage.EQUINOX_APPLICATION__EXPORTER:
                    return IEC60870Package.DRIVER_APPLICATION__EXPORTER;
                case OsgiPackage.EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE:
                    return IEC60870Package.DRIVER_APPLICATION__CUSTOMIZATION_PROFILE;
                case OsgiPackage.EQUINOX_APPLICATION__SECURITY_CONFIGURATION:
                    return IEC60870Package.DRIVER_APPLICATION__SECURITY_CONFIGURATION;
                case OsgiPackage.EQUINOX_APPLICATION__MODULES:
                    return IEC60870Package.DRIVER_APPLICATION__MODULES;
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
    public int eDerivedOperationID ( int baseOperationID, Class<?> baseClass )
    {
        if ( baseClass == EquinoxApplication.class )
        {
            switch ( baseOperationID )
            {
                case OsgiPackage.EQUINOX_APPLICATION___GET_PROFILE:
                    return IEC60870Package.DRIVER_APPLICATION___GET_PROFILE;
                default:
                    return -1;
            }
        }
        return super.eDerivedOperationID ( baseOperationID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case IEC60870Package.DRIVER_APPLICATION___GET_PROFILE:
                return getProfile ();
            case IEC60870Package.DRIVER_APPLICATION___GET_ENDPOINTS:
                return getEndpoints ();
        }
        return super.eInvoke ( operationID, arguments );
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

} //DriverApplicationImpl
