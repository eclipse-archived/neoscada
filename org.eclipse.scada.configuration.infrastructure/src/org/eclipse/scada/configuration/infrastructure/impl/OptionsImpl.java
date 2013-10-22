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
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.configuration.infrastructure.UserService;
import org.eclipse.scada.configuration.world.osgi.EventPool;
import org.eclipse.scada.configuration.world.osgi.MonitorPool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl#getBaseDaNgpPort <em>Base Da Ngp Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl#getBaseAeNgpPort <em>Base Ae Ngp Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl#getBaseCaNgpPort <em>Base Ca Ngp Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl#getBaseHdNgpPort <em>Base Hd Ngp Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl#getMonitorPools <em>Monitor Pools</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl#getEventPools <em>Event Pools</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl#getDefaultUserService <em>Default User Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptionsImpl extends MinimalEObjectImpl.Container implements Options
{
    /**
     * The default value of the '{@link #getBaseDaNgpPort() <em>Base Da Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaseDaNgpPort()
     * @generated
     * @ordered
     */
    protected static final short BASE_DA_NGP_PORT_EDEFAULT = 2100;

    /**
     * The cached value of the '{@link #getBaseDaNgpPort() <em>Base Da Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaseDaNgpPort()
     * @generated
     * @ordered
     */
    protected short baseDaNgpPort = BASE_DA_NGP_PORT_EDEFAULT;

    /**
     * The default value of the '{@link #getBaseAeNgpPort() <em>Base Ae Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaseAeNgpPort()
     * @generated
     * @ordered
     */
    protected static final short BASE_AE_NGP_PORT_EDEFAULT = 2200;

    /**
     * The cached value of the '{@link #getBaseAeNgpPort() <em>Base Ae Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaseAeNgpPort()
     * @generated
     * @ordered
     */
    protected short baseAeNgpPort = BASE_AE_NGP_PORT_EDEFAULT;

    /**
     * The default value of the '{@link #getBaseCaNgpPort() <em>Base Ca Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaseCaNgpPort()
     * @generated
     * @ordered
     */
    protected static final short BASE_CA_NGP_PORT_EDEFAULT = 2400;

    /**
     * The cached value of the '{@link #getBaseCaNgpPort() <em>Base Ca Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaseCaNgpPort()
     * @generated
     * @ordered
     */
    protected short baseCaNgpPort = BASE_CA_NGP_PORT_EDEFAULT;

    /**
     * The default value of the '{@link #getBaseHdNgpPort() <em>Base Hd Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaseHdNgpPort()
     * @generated
     * @ordered
     */
    protected static final short BASE_HD_NGP_PORT_EDEFAULT = 2300;

    /**
     * The cached value of the '{@link #getBaseHdNgpPort() <em>Base Hd Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaseHdNgpPort()
     * @generated
     * @ordered
     */
    protected short baseHdNgpPort = BASE_HD_NGP_PORT_EDEFAULT;

    /**
     * The cached value of the '{@link #getMonitorPools() <em>Monitor Pools</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMonitorPools()
     * @generated
     * @ordered
     */
    protected EList<MonitorPool> monitorPools;

    /**
     * The cached value of the '{@link #getEventPools() <em>Event Pools</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEventPools()
     * @generated
     * @ordered
     */
    protected EList<EventPool> eventPools;

    /**
     * The cached value of the '{@link #getDefaultUserService() <em>Default User Service</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultUserService()
     * @generated
     * @ordered
     */
    protected UserService defaultUserService;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OptionsImpl ()
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
        return InfrastructurePackage.Literals.OPTIONS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getBaseDaNgpPort ()
    {
        return baseDaNgpPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBaseDaNgpPort ( short newBaseDaNgpPort )
    {
        short oldBaseDaNgpPort = baseDaNgpPort;
        baseDaNgpPort = newBaseDaNgpPort;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.OPTIONS__BASE_DA_NGP_PORT, oldBaseDaNgpPort, baseDaNgpPort ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getBaseAeNgpPort ()
    {
        return baseAeNgpPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBaseAeNgpPort ( short newBaseAeNgpPort )
    {
        short oldBaseAeNgpPort = baseAeNgpPort;
        baseAeNgpPort = newBaseAeNgpPort;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.OPTIONS__BASE_AE_NGP_PORT, oldBaseAeNgpPort, baseAeNgpPort ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getBaseCaNgpPort ()
    {
        return baseCaNgpPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBaseCaNgpPort ( short newBaseCaNgpPort )
    {
        short oldBaseCaNgpPort = baseCaNgpPort;
        baseCaNgpPort = newBaseCaNgpPort;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.OPTIONS__BASE_CA_NGP_PORT, oldBaseCaNgpPort, baseCaNgpPort ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getBaseHdNgpPort ()
    {
        return baseHdNgpPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBaseHdNgpPort ( short newBaseHdNgpPort )
    {
        short oldBaseHdNgpPort = baseHdNgpPort;
        baseHdNgpPort = newBaseHdNgpPort;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.OPTIONS__BASE_HD_NGP_PORT, oldBaseHdNgpPort, baseHdNgpPort ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MonitorPool> getMonitorPools ()
    {
        if ( monitorPools == null )
        {
            monitorPools = new EObjectContainmentEList.Resolving<MonitorPool> ( MonitorPool.class, this, InfrastructurePackage.OPTIONS__MONITOR_POOLS );
        }
        return monitorPools;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EventPool> getEventPools ()
    {
        if ( eventPools == null )
        {
            eventPools = new EObjectContainmentEList.Resolving<EventPool> ( EventPool.class, this, InfrastructurePackage.OPTIONS__EVENT_POOLS );
        }
        return eventPools;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserService getDefaultUserService ()
    {
        if ( defaultUserService != null && defaultUserService.eIsProxy () )
        {
            InternalEObject oldDefaultUserService = (InternalEObject)defaultUserService;
            defaultUserService = (UserService)eResolveProxy ( oldDefaultUserService );
            if ( defaultUserService != oldDefaultUserService )
            {
                InternalEObject newDefaultUserService = (InternalEObject)defaultUserService;
                NotificationChain msgs = oldDefaultUserService.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE, null, null );
                if ( newDefaultUserService.eInternalContainer () == null )
                {
                    msgs = newDefaultUserService.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE, oldDefaultUserService, defaultUserService ) );
            }
        }
        return defaultUserService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserService basicGetDefaultUserService ()
    {
        return defaultUserService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefaultUserService ( UserService newDefaultUserService, NotificationChain msgs )
    {
        UserService oldDefaultUserService = defaultUserService;
        defaultUserService = newDefaultUserService;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE, oldDefaultUserService, newDefaultUserService );
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
    public void setDefaultUserService ( UserService newDefaultUserService )
    {
        if ( newDefaultUserService != defaultUserService )
        {
            NotificationChain msgs = null;
            if ( defaultUserService != null )
                msgs = ( (InternalEObject)defaultUserService ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE, null, msgs );
            if ( newDefaultUserService != null )
                msgs = ( (InternalEObject)newDefaultUserService ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE, null, msgs );
            msgs = basicSetDefaultUserService ( newDefaultUserService, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE, newDefaultUserService, newDefaultUserService ) );
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
            case InfrastructurePackage.OPTIONS__MONITOR_POOLS:
                return ( (InternalEList<?>)getMonitorPools () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.OPTIONS__EVENT_POOLS:
                return ( (InternalEList<?>)getEventPools () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE:
                return basicSetDefaultUserService ( null, msgs );
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
            case InfrastructurePackage.OPTIONS__BASE_DA_NGP_PORT:
                return getBaseDaNgpPort ();
            case InfrastructurePackage.OPTIONS__BASE_AE_NGP_PORT:
                return getBaseAeNgpPort ();
            case InfrastructurePackage.OPTIONS__BASE_CA_NGP_PORT:
                return getBaseCaNgpPort ();
            case InfrastructurePackage.OPTIONS__BASE_HD_NGP_PORT:
                return getBaseHdNgpPort ();
            case InfrastructurePackage.OPTIONS__MONITOR_POOLS:
                return getMonitorPools ();
            case InfrastructurePackage.OPTIONS__EVENT_POOLS:
                return getEventPools ();
            case InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE:
                if ( resolve )
                    return getDefaultUserService ();
                return basicGetDefaultUserService ();
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
            case InfrastructurePackage.OPTIONS__BASE_DA_NGP_PORT:
                setBaseDaNgpPort ( (Short)newValue );
                return;
            case InfrastructurePackage.OPTIONS__BASE_AE_NGP_PORT:
                setBaseAeNgpPort ( (Short)newValue );
                return;
            case InfrastructurePackage.OPTIONS__BASE_CA_NGP_PORT:
                setBaseCaNgpPort ( (Short)newValue );
                return;
            case InfrastructurePackage.OPTIONS__BASE_HD_NGP_PORT:
                setBaseHdNgpPort ( (Short)newValue );
                return;
            case InfrastructurePackage.OPTIONS__MONITOR_POOLS:
                getMonitorPools ().clear ();
                getMonitorPools ().addAll ( (Collection<? extends MonitorPool>)newValue );
                return;
            case InfrastructurePackage.OPTIONS__EVENT_POOLS:
                getEventPools ().clear ();
                getEventPools ().addAll ( (Collection<? extends EventPool>)newValue );
                return;
            case InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE:
                setDefaultUserService ( (UserService)newValue );
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
            case InfrastructurePackage.OPTIONS__BASE_DA_NGP_PORT:
                setBaseDaNgpPort ( BASE_DA_NGP_PORT_EDEFAULT );
                return;
            case InfrastructurePackage.OPTIONS__BASE_AE_NGP_PORT:
                setBaseAeNgpPort ( BASE_AE_NGP_PORT_EDEFAULT );
                return;
            case InfrastructurePackage.OPTIONS__BASE_CA_NGP_PORT:
                setBaseCaNgpPort ( BASE_CA_NGP_PORT_EDEFAULT );
                return;
            case InfrastructurePackage.OPTIONS__BASE_HD_NGP_PORT:
                setBaseHdNgpPort ( BASE_HD_NGP_PORT_EDEFAULT );
                return;
            case InfrastructurePackage.OPTIONS__MONITOR_POOLS:
                getMonitorPools ().clear ();
                return;
            case InfrastructurePackage.OPTIONS__EVENT_POOLS:
                getEventPools ().clear ();
                return;
            case InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE:
                setDefaultUserService ( (UserService)null );
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
            case InfrastructurePackage.OPTIONS__BASE_DA_NGP_PORT:
                return baseDaNgpPort != BASE_DA_NGP_PORT_EDEFAULT;
            case InfrastructurePackage.OPTIONS__BASE_AE_NGP_PORT:
                return baseAeNgpPort != BASE_AE_NGP_PORT_EDEFAULT;
            case InfrastructurePackage.OPTIONS__BASE_CA_NGP_PORT:
                return baseCaNgpPort != BASE_CA_NGP_PORT_EDEFAULT;
            case InfrastructurePackage.OPTIONS__BASE_HD_NGP_PORT:
                return baseHdNgpPort != BASE_HD_NGP_PORT_EDEFAULT;
            case InfrastructurePackage.OPTIONS__MONITOR_POOLS:
                return monitorPools != null && !monitorPools.isEmpty ();
            case InfrastructurePackage.OPTIONS__EVENT_POOLS:
                return eventPools != null && !eventPools.isEmpty ();
            case InfrastructurePackage.OPTIONS__DEFAULT_USER_SERVICE:
                return defaultUserService != null;
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
        result.append ( " (baseDaNgpPort: " ); //$NON-NLS-1$
        result.append ( baseDaNgpPort );
        result.append ( ", baseAeNgpPort: " ); //$NON-NLS-1$
        result.append ( baseAeNgpPort );
        result.append ( ", baseCaNgpPort: " ); //$NON-NLS-1$
        result.append ( baseCaNgpPort );
        result.append ( ", baseHdNgpPort: " ); //$NON-NLS-1$
        result.append ( baseHdNgpPort );
        result.append ( ')' );
        return result.toString ();
    }

} //OptionsImpl
