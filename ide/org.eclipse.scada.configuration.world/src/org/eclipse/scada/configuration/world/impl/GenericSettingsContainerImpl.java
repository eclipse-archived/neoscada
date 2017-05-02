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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.world.GenericSettingsContainer;
import org.eclipse.scada.configuration.world.Settings;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Settings Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.GenericSettingsContainerImpl#getSettings <em>Settings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenericSettingsContainerImpl extends MinimalEObjectImpl.Container implements GenericSettingsContainer
{
    /**
     * The cached value of the '{@link #getSettings() <em>Settings</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSettings()
     * @generated
     * @ordered
     */
    protected Settings settings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GenericSettingsContainerImpl ()
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
        return WorldPackage.Literals.GENERIC_SETTINGS_CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Settings getSettings ()
    {
        if ( settings != null && settings.eIsProxy () )
        {
            InternalEObject oldSettings = (InternalEObject)settings;
            settings = (Settings)eResolveProxy ( oldSettings );
            if ( settings != oldSettings )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, WorldPackage.GENERIC_SETTINGS_CONTAINER__SETTINGS, oldSettings, settings ) );
            }
        }
        return settings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Settings basicGetSettings ()
    {
        return settings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSettings ( Settings newSettings )
    {
        Settings oldSettings = settings;
        settings = newSettings;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.GENERIC_SETTINGS_CONTAINER__SETTINGS, oldSettings, settings ) );
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
            case WorldPackage.GENERIC_SETTINGS_CONTAINER__SETTINGS:
                if ( resolve )
                    return getSettings ();
                return basicGetSettings ();
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
            case WorldPackage.GENERIC_SETTINGS_CONTAINER__SETTINGS:
                setSettings ( (Settings)newValue );
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
            case WorldPackage.GENERIC_SETTINGS_CONTAINER__SETTINGS:
                setSettings ( (Settings)null );
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
            case WorldPackage.GENERIC_SETTINGS_CONTAINER__SETTINGS:
                return settings != null;
        }
        return super.eIsSet ( featureID );
    }

} //GenericSettingsContainerImpl
