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
package org.eclipse.scada.configuration.world.osgi.impl;

import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.ValueArchive;
import org.eclipse.scada.configuration.world.osgi.ValueArchiveServer;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Archive Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl#getExporter <em>Exporter</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl#getCustomizationProfile <em>Customization Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl#getSecurityConfiguration <em>Security Configuration</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl#getArchives <em>Archives</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ValueArchiveServerImpl extends MinimalEObjectImpl.Container implements ValueArchiveServer
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
     * The cached value of the '{@link #getArchives() <em>Archives</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArchives()
     * @generated
     * @ordered
     */
    protected EList<ValueArchive> archives;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValueArchiveServerImpl ()
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
        return OsgiPackage.Literals.VALUE_ARCHIVE_SERVER;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.VALUE_ARCHIVE_SERVER__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.VALUE_ARCHIVE_SERVER__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connection> getConnections ()
    {
        if ( connections == null )
        {
            connections = new EObjectContainmentEList.Resolving<Connection> ( Connection.class, this, OsgiPackage.VALUE_ARCHIVE_SERVER__CONNECTIONS );
        }
        return connections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Exporter> getExporter ()
    {
        if ( exporter == null )
        {
            exporter = new EObjectContainmentEList.Resolving<Exporter> ( Exporter.class, this, OsgiPackage.VALUE_ARCHIVE_SERVER__EXPORTER );
        }
        return exporter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Profile getCustomizationProfile ()
    {
        if ( customizationProfile != null && customizationProfile.eIsProxy () )
        {
            InternalEObject oldCustomizationProfile = (InternalEObject)customizationProfile;
            customizationProfile = (Profile)eResolveProxy ( oldCustomizationProfile );
            if ( customizationProfile != oldCustomizationProfile )
            {
                InternalEObject newCustomizationProfile = (InternalEObject)customizationProfile;
                NotificationChain msgs = oldCustomizationProfile.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE, null, null );
                if ( newCustomizationProfile.eInternalContainer () == null )
                {
                    msgs = newCustomizationProfile.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE, oldCustomizationProfile, customizationProfile ) );
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
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE, oldCustomizationProfile, newCustomizationProfile );
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
    public void setCustomizationProfile ( Profile newCustomizationProfile )
    {
        if ( newCustomizationProfile != customizationProfile )
        {
            NotificationChain msgs = null;
            if ( customizationProfile != null )
                msgs = ( (InternalEObject)customizationProfile ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE, null, msgs );
            if ( newCustomizationProfile != null )
                msgs = ( (InternalEObject)newCustomizationProfile ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE, null, msgs );
            msgs = basicSetCustomizationProfile ( newCustomizationProfile, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE, newCustomizationProfile, newCustomizationProfile ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.VALUE_ARCHIVE_SERVER__SECURITY_CONFIGURATION, oldSecurityConfiguration, securityConfiguration ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.VALUE_ARCHIVE_SERVER__SECURITY_CONFIGURATION, oldSecurityConfiguration, securityConfiguration ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ApplicationModule> getModules ()
    {
        if ( modules == null )
        {
            modules = new EObjectContainmentEList.Resolving<ApplicationModule> ( ApplicationModule.class, this, OsgiPackage.VALUE_ARCHIVE_SERVER__MODULES );
        }
        return modules;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ValueArchive> getArchives ()
    {
        if ( archives == null )
        {
            archives = new EObjectContainmentEList.Resolving<ValueArchive> ( ValueArchive.class, this, OsgiPackage.VALUE_ARCHIVE_SERVER__ARCHIVES );
        }
        return archives;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Profile getProfile ()
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
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
            case OsgiPackage.VALUE_ARCHIVE_SERVER__CONNECTIONS:
                return ( (InternalEList<?>)getConnections () ).basicRemove ( otherEnd, msgs );
            case OsgiPackage.VALUE_ARCHIVE_SERVER__EXPORTER:
                return ( (InternalEList<?>)getExporter () ).basicRemove ( otherEnd, msgs );
            case OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE:
                return basicSetCustomizationProfile ( null, msgs );
            case OsgiPackage.VALUE_ARCHIVE_SERVER__MODULES:
                return ( (InternalEList<?>)getModules () ).basicRemove ( otherEnd, msgs );
            case OsgiPackage.VALUE_ARCHIVE_SERVER__ARCHIVES:
                return ( (InternalEList<?>)getArchives () ).basicRemove ( otherEnd, msgs );
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
            case OsgiPackage.VALUE_ARCHIVE_SERVER__SHORT_DESCRIPTION:
                return getShortDescription ();
            case OsgiPackage.VALUE_ARCHIVE_SERVER__NAME:
                return getName ();
            case OsgiPackage.VALUE_ARCHIVE_SERVER__CONNECTIONS:
                return getConnections ();
            case OsgiPackage.VALUE_ARCHIVE_SERVER__EXPORTER:
                return getExporter ();
            case OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE:
                if ( resolve )
                    return getCustomizationProfile ();
                return basicGetCustomizationProfile ();
            case OsgiPackage.VALUE_ARCHIVE_SERVER__SECURITY_CONFIGURATION:
                if ( resolve )
                    return getSecurityConfiguration ();
                return basicGetSecurityConfiguration ();
            case OsgiPackage.VALUE_ARCHIVE_SERVER__MODULES:
                return getModules ();
            case OsgiPackage.VALUE_ARCHIVE_SERVER__ARCHIVES:
                return getArchives ();
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
            case OsgiPackage.VALUE_ARCHIVE_SERVER__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__NAME:
                setName ( (String)newValue );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__CONNECTIONS:
                getConnections ().clear ();
                getConnections ().addAll ( (Collection<? extends Connection>)newValue );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__EXPORTER:
                getExporter ().clear ();
                getExporter ().addAll ( (Collection<? extends Exporter>)newValue );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE:
                setCustomizationProfile ( (Profile)newValue );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__SECURITY_CONFIGURATION:
                setSecurityConfiguration ( (Configuration)newValue );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__MODULES:
                getModules ().clear ();
                getModules ().addAll ( (Collection<? extends ApplicationModule>)newValue );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__ARCHIVES:
                getArchives ().clear ();
                getArchives ().addAll ( (Collection<? extends ValueArchive>)newValue );
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
            case OsgiPackage.VALUE_ARCHIVE_SERVER__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__CONNECTIONS:
                getConnections ().clear ();
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__EXPORTER:
                getExporter ().clear ();
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE:
                setCustomizationProfile ( (Profile)null );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__SECURITY_CONFIGURATION:
                setSecurityConfiguration ( (Configuration)null );
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__MODULES:
                getModules ().clear ();
                return;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__ARCHIVES:
                getArchives ().clear ();
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
            case OsgiPackage.VALUE_ARCHIVE_SERVER__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case OsgiPackage.VALUE_ARCHIVE_SERVER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case OsgiPackage.VALUE_ARCHIVE_SERVER__CONNECTIONS:
                return connections != null && !connections.isEmpty ();
            case OsgiPackage.VALUE_ARCHIVE_SERVER__EXPORTER:
                return exporter != null && !exporter.isEmpty ();
            case OsgiPackage.VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE:
                return customizationProfile != null;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__SECURITY_CONFIGURATION:
                return securityConfiguration != null;
            case OsgiPackage.VALUE_ARCHIVE_SERVER__MODULES:
                return modules != null && !modules.isEmpty ();
            case OsgiPackage.VALUE_ARCHIVE_SERVER__ARCHIVES:
                return archives != null && !archives.isEmpty ();
        }
        return super.eIsSet ( featureID );
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
            case OsgiPackage.VALUE_ARCHIVE_SERVER___GET_PROFILE:
                return getProfile ();
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

} //ValueArchiveServerImpl
