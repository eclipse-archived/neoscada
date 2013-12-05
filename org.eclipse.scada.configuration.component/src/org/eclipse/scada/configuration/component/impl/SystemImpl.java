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
package org.eclipse.scada.configuration.component.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.Configuration;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.component.Service;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SystemImpl#getLevels <em>Levels</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SystemImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SystemImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SystemImpl#getInfrastructure <em>Infrastructure</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SystemImpl#getDefaultCustomizationPipeline <em>Default Customization Pipeline</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SystemImpl#getDefaultArchiveSelector <em>Default Archive Selector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends ContainerImpl implements org.eclipse.scada.configuration.component.System
{
    /**
     * The cached value of the '{@link #getLevels() <em>Levels</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLevels()
     * @generated
     * @ordered
     */
    protected EList<Level> levels;

    /**
     * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurations()
     * @generated
     * @ordered
     */
    protected EList<Configuration> configurations;

    /**
     * The cached value of the '{@link #getServices() <em>Services</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServices()
     * @generated
     * @ordered
     */
    protected EList<Service> services;

    /**
     * The cached value of the '{@link #getInfrastructure() <em>Infrastructure</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInfrastructure()
     * @generated
     * @ordered
     */
    protected World infrastructure;

    /**
     * The cached value of the '{@link #getDefaultCustomizationPipeline() <em>Default Customization Pipeline</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultCustomizationPipeline()
     * @generated
     * @ordered
     */
    protected CustomizationPipeline defaultCustomizationPipeline;

    /**
     * The cached value of the '{@link #getDefaultArchiveSelector() <em>Default Archive Selector</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultArchiveSelector()
     * @generated
     * @ordered
     */
    protected Selector defaultArchiveSelector;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SystemImpl ()
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
        return ComponentPackage.Literals.SYSTEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Level> getLevels ()
    {
        if ( levels == null )
        {
            levels = new EObjectContainmentEList.Resolving<Level> ( Level.class, this, ComponentPackage.SYSTEM__LEVELS );
        }
        return levels;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Configuration> getConfigurations ()
    {
        if ( configurations == null )
        {
            configurations = new EObjectContainmentEList.Resolving<Configuration> ( Configuration.class, this, ComponentPackage.SYSTEM__CONFIGURATIONS );
        }
        return configurations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Service> getServices ()
    {
        if ( services == null )
        {
            services = new EObjectContainmentEList.Resolving<Service> ( Service.class, this, ComponentPackage.SYSTEM__SERVICES );
        }
        return services;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public World getInfrastructure ()
    {
        if ( infrastructure != null && infrastructure.eIsProxy () )
        {
            InternalEObject oldInfrastructure = (InternalEObject)infrastructure;
            infrastructure = (World)eResolveProxy ( oldInfrastructure );
            if ( infrastructure != oldInfrastructure )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SYSTEM__INFRASTRUCTURE, oldInfrastructure, infrastructure ) );
            }
        }
        return infrastructure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public World basicGetInfrastructure ()
    {
        return infrastructure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInfrastructure ( World newInfrastructure )
    {
        World oldInfrastructure = infrastructure;
        infrastructure = newInfrastructure;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SYSTEM__INFRASTRUCTURE, oldInfrastructure, infrastructure ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomizationPipeline getDefaultCustomizationPipeline ()
    {
        if ( defaultCustomizationPipeline != null && defaultCustomizationPipeline.eIsProxy () )
        {
            InternalEObject oldDefaultCustomizationPipeline = (InternalEObject)defaultCustomizationPipeline;
            defaultCustomizationPipeline = (CustomizationPipeline)eResolveProxy ( oldDefaultCustomizationPipeline );
            if ( defaultCustomizationPipeline != oldDefaultCustomizationPipeline )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SYSTEM__DEFAULT_CUSTOMIZATION_PIPELINE, oldDefaultCustomizationPipeline, defaultCustomizationPipeline ) );
            }
        }
        return defaultCustomizationPipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomizationPipeline basicGetDefaultCustomizationPipeline ()
    {
        return defaultCustomizationPipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultCustomizationPipeline ( CustomizationPipeline newDefaultCustomizationPipeline )
    {
        CustomizationPipeline oldDefaultCustomizationPipeline = defaultCustomizationPipeline;
        defaultCustomizationPipeline = newDefaultCustomizationPipeline;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SYSTEM__DEFAULT_CUSTOMIZATION_PIPELINE, oldDefaultCustomizationPipeline, defaultCustomizationPipeline ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Selector getDefaultArchiveSelector ()
    {
        if ( defaultArchiveSelector != null && defaultArchiveSelector.eIsProxy () )
        {
            InternalEObject oldDefaultArchiveSelector = (InternalEObject)defaultArchiveSelector;
            defaultArchiveSelector = (Selector)eResolveProxy ( oldDefaultArchiveSelector );
            if ( defaultArchiveSelector != oldDefaultArchiveSelector )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SYSTEM__DEFAULT_ARCHIVE_SELECTOR, oldDefaultArchiveSelector, defaultArchiveSelector ) );
            }
        }
        return defaultArchiveSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Selector basicGetDefaultArchiveSelector ()
    {
        return defaultArchiveSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultArchiveSelector ( Selector newDefaultArchiveSelector )
    {
        Selector oldDefaultArchiveSelector = defaultArchiveSelector;
        defaultArchiveSelector = newDefaultArchiveSelector;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SYSTEM__DEFAULT_ARCHIVE_SELECTOR, oldDefaultArchiveSelector, defaultArchiveSelector ) );
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
            case ComponentPackage.SYSTEM__LEVELS:
                return ( (InternalEList<?>)getLevels () ).basicRemove ( otherEnd, msgs );
            case ComponentPackage.SYSTEM__CONFIGURATIONS:
                return ( (InternalEList<?>)getConfigurations () ).basicRemove ( otherEnd, msgs );
            case ComponentPackage.SYSTEM__SERVICES:
                return ( (InternalEList<?>)getServices () ).basicRemove ( otherEnd, msgs );
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
            case ComponentPackage.SYSTEM__LEVELS:
                return getLevels ();
            case ComponentPackage.SYSTEM__CONFIGURATIONS:
                return getConfigurations ();
            case ComponentPackage.SYSTEM__SERVICES:
                return getServices ();
            case ComponentPackage.SYSTEM__INFRASTRUCTURE:
                if ( resolve )
                    return getInfrastructure ();
                return basicGetInfrastructure ();
            case ComponentPackage.SYSTEM__DEFAULT_CUSTOMIZATION_PIPELINE:
                if ( resolve )
                    return getDefaultCustomizationPipeline ();
                return basicGetDefaultCustomizationPipeline ();
            case ComponentPackage.SYSTEM__DEFAULT_ARCHIVE_SELECTOR:
                if ( resolve )
                    return getDefaultArchiveSelector ();
                return basicGetDefaultArchiveSelector ();
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
            case ComponentPackage.SYSTEM__LEVELS:
                getLevels ().clear ();
                getLevels ().addAll ( (Collection<? extends Level>)newValue );
                return;
            case ComponentPackage.SYSTEM__CONFIGURATIONS:
                getConfigurations ().clear ();
                getConfigurations ().addAll ( (Collection<? extends Configuration>)newValue );
                return;
            case ComponentPackage.SYSTEM__SERVICES:
                getServices ().clear ();
                getServices ().addAll ( (Collection<? extends Service>)newValue );
                return;
            case ComponentPackage.SYSTEM__INFRASTRUCTURE:
                setInfrastructure ( (World)newValue );
                return;
            case ComponentPackage.SYSTEM__DEFAULT_CUSTOMIZATION_PIPELINE:
                setDefaultCustomizationPipeline ( (CustomizationPipeline)newValue );
                return;
            case ComponentPackage.SYSTEM__DEFAULT_ARCHIVE_SELECTOR:
                setDefaultArchiveSelector ( (Selector)newValue );
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
            case ComponentPackage.SYSTEM__LEVELS:
                getLevels ().clear ();
                return;
            case ComponentPackage.SYSTEM__CONFIGURATIONS:
                getConfigurations ().clear ();
                return;
            case ComponentPackage.SYSTEM__SERVICES:
                getServices ().clear ();
                return;
            case ComponentPackage.SYSTEM__INFRASTRUCTURE:
                setInfrastructure ( (World)null );
                return;
            case ComponentPackage.SYSTEM__DEFAULT_CUSTOMIZATION_PIPELINE:
                setDefaultCustomizationPipeline ( (CustomizationPipeline)null );
                return;
            case ComponentPackage.SYSTEM__DEFAULT_ARCHIVE_SELECTOR:
                setDefaultArchiveSelector ( (Selector)null );
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
            case ComponentPackage.SYSTEM__LEVELS:
                return levels != null && !levels.isEmpty ();
            case ComponentPackage.SYSTEM__CONFIGURATIONS:
                return configurations != null && !configurations.isEmpty ();
            case ComponentPackage.SYSTEM__SERVICES:
                return services != null && !services.isEmpty ();
            case ComponentPackage.SYSTEM__INFRASTRUCTURE:
                return infrastructure != null;
            case ComponentPackage.SYSTEM__DEFAULT_CUSTOMIZATION_PIPELINE:
                return defaultCustomizationPipeline != null;
            case ComponentPackage.SYSTEM__DEFAULT_ARCHIVE_SELECTOR:
                return defaultArchiveSelector != null;
        }
        return super.eIsSet ( featureID );
    }

} //SystemImpl
