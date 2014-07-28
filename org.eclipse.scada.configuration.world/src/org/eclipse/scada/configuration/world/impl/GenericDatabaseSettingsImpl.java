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

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.configuration.world.GenericDatabaseSettings;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Generic Database Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.GenericDatabaseSettingsImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.GenericDatabaseSettingsImpl#getDriverName <em>Driver Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.GenericDatabaseSettingsImpl#getBundles <em>Bundles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenericDatabaseSettingsImpl extends AbstractGenericDatabaseSettingsImpl implements GenericDatabaseSettings
{
    /**
     * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected static final String URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected String url = URL_EDEFAULT;

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
     * The cached value of the '{@link #getBundles() <em>Bundles</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBundles()
     * @generated
     * @ordered
     */
    protected EList<String> bundles;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GenericDatabaseSettingsImpl ()
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
        return WorldPackage.Literals.GENERIC_DATABASE_SETTINGS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUrl ()
    {
        return url;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUrl ( String newUrl )
    {
        String oldUrl = url;
        url = newUrl;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.GENERIC_DATABASE_SETTINGS__URL, oldUrl, url ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getDriverName ()
    {
        return driverName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDriverName ( String newDriverName )
    {
        String oldDriverName = driverName;
        driverName = newDriverName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.GENERIC_DATABASE_SETTINGS__DRIVER_NAME, oldDriverName, driverName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<String> getBundles ()
    {
        if ( bundles == null )
        {
            bundles = new EDataTypeUniqueEList<String> ( String.class, this, WorldPackage.GENERIC_DATABASE_SETTINGS__BUNDLES );
        }
        return bundles;
    }

    @Override
    protected Map<String, String> getSpecificProperties ()
    {
        // we don't have specific properties
        return null;
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
            case WorldPackage.GENERIC_DATABASE_SETTINGS__URL:
                return getUrl ();
            case WorldPackage.GENERIC_DATABASE_SETTINGS__DRIVER_NAME:
                return getDriverName ();
            case WorldPackage.GENERIC_DATABASE_SETTINGS__BUNDLES:
                return getBundles ();
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
            case WorldPackage.GENERIC_DATABASE_SETTINGS__URL:
                setUrl ( (String)newValue );
                return;
            case WorldPackage.GENERIC_DATABASE_SETTINGS__DRIVER_NAME:
                setDriverName ( (String)newValue );
                return;
            case WorldPackage.GENERIC_DATABASE_SETTINGS__BUNDLES:
                getBundles ().clear ();
                getBundles ().addAll ( (Collection<? extends String>)newValue );
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
            case WorldPackage.GENERIC_DATABASE_SETTINGS__URL:
                setUrl ( URL_EDEFAULT );
                return;
            case WorldPackage.GENERIC_DATABASE_SETTINGS__DRIVER_NAME:
                setDriverName ( DRIVER_NAME_EDEFAULT );
                return;
            case WorldPackage.GENERIC_DATABASE_SETTINGS__BUNDLES:
                getBundles ().clear ();
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
            case WorldPackage.GENERIC_DATABASE_SETTINGS__URL:
                return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals ( url );
            case WorldPackage.GENERIC_DATABASE_SETTINGS__DRIVER_NAME:
                return DRIVER_NAME_EDEFAULT == null ? driverName != null : !DRIVER_NAME_EDEFAULT.equals ( driverName );
            case WorldPackage.GENERIC_DATABASE_SETTINGS__BUNDLES:
                return bundles != null && !bundles.isEmpty ();
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
        result.append ( " (url: " ); //$NON-NLS-1$
        result.append ( url );
        result.append ( ", driverName: " ); //$NON-NLS-1$
        result.append ( driverName );
        result.append ( ", bundles: " ); //$NON-NLS-1$
        result.append ( bundles );
        result.append ( ')' );
        return result.toString ();
    }

} //GenericDatabaseSettingsImpl
