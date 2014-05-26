/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration;
import org.eclipse.scada.configuration.infrastructure.Configurations;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.Settings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configurations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ConfigurationsImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ConfigurationsImpl#getSettings <em>Settings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationsImpl extends MinimalEObjectImpl.Container implements Configurations
{
    /**
     * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurations()
     * @generated
     * @ordered
     */
    protected EList<ApplicationConfiguration> configurations;

    /**
     * The cached value of the '{@link #getSettings() <em>Settings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSettings()
     * @generated
     * @ordered
     */
    protected EList<Settings> settings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConfigurationsImpl ()
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
        return InfrastructurePackage.Literals.CONFIGURATIONS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<ApplicationConfiguration> getConfigurations ()
    {
        if ( configurations == null )
        {
            configurations = new EObjectContainmentEList.Resolving<ApplicationConfiguration> ( ApplicationConfiguration.class, this, InfrastructurePackage.CONFIGURATIONS__CONFIGURATIONS );
        }
        return configurations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Settings> getSettings ()
    {
        if ( settings == null )
        {
            settings = new EObjectContainmentEList.Resolving<Settings> ( Settings.class, this, InfrastructurePackage.CONFIGURATIONS__SETTINGS );
        }
        return settings;
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
            case InfrastructurePackage.CONFIGURATIONS__CONFIGURATIONS:
                return ( (InternalEList<?>)getConfigurations () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.CONFIGURATIONS__SETTINGS:
                return ( (InternalEList<?>)getSettings () ).basicRemove ( otherEnd, msgs );
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
            case InfrastructurePackage.CONFIGURATIONS__CONFIGURATIONS:
                return getConfigurations ();
            case InfrastructurePackage.CONFIGURATIONS__SETTINGS:
                return getSettings ();
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
            case InfrastructurePackage.CONFIGURATIONS__CONFIGURATIONS:
                getConfigurations ().clear ();
                getConfigurations ().addAll ( (Collection<? extends ApplicationConfiguration>)newValue );
                return;
            case InfrastructurePackage.CONFIGURATIONS__SETTINGS:
                getSettings ().clear ();
                getSettings ().addAll ( (Collection<? extends Settings>)newValue );
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
            case InfrastructurePackage.CONFIGURATIONS__CONFIGURATIONS:
                getConfigurations ().clear ();
                return;
            case InfrastructurePackage.CONFIGURATIONS__SETTINGS:
                getSettings ().clear ();
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
            case InfrastructurePackage.CONFIGURATIONS__CONFIGURATIONS:
                return configurations != null && !configurations.isEmpty ();
            case InfrastructurePackage.CONFIGURATIONS__SETTINGS:
                return settings != null && !settings.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //ConfigurationsImpl
