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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.infrastructure.EventInjectorHttp;
import org.eclipse.scada.configuration.infrastructure.HttpServiceModule;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Injector Http</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.EventInjectorHttpImpl#getHttpService <em>Http Service</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventInjectorHttpImpl extends MinimalEObjectImpl.Container implements EventInjectorHttp
{
    /**
     * The cached value of the '{@link #getHttpService() <em>Http Service</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHttpService()
     * @generated
     * @ordered
     */
    protected HttpServiceModule httpService;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventInjectorHttpImpl ()
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
        return InfrastructurePackage.Literals.EVENT_INJECTOR_HTTP;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HttpServiceModule getHttpService ()
    {
        if ( httpService != null && httpService.eIsProxy () )
        {
            InternalEObject oldHttpService = (InternalEObject)httpService;
            httpService = (HttpServiceModule)eResolveProxy ( oldHttpService );
            if ( httpService != oldHttpService )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.EVENT_INJECTOR_HTTP__HTTP_SERVICE, oldHttpService, httpService ) );
            }
        }
        return httpService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HttpServiceModule basicGetHttpService ()
    {
        return httpService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHttpService ( HttpServiceModule newHttpService )
    {
        HttpServiceModule oldHttpService = httpService;
        httpService = newHttpService;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EVENT_INJECTOR_HTTP__HTTP_SERVICE, oldHttpService, httpService ) );
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
            case InfrastructurePackage.EVENT_INJECTOR_HTTP__HTTP_SERVICE:
                if ( resolve )
                    return getHttpService ();
                return basicGetHttpService ();
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
            case InfrastructurePackage.EVENT_INJECTOR_HTTP__HTTP_SERVICE:
                setHttpService ( (HttpServiceModule)newValue );
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
            case InfrastructurePackage.EVENT_INJECTOR_HTTP__HTTP_SERVICE:
                setHttpService ( (HttpServiceModule)null );
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
            case InfrastructurePackage.EVENT_INJECTOR_HTTP__HTTP_SERVICE:
                return httpService != null;
        }
        return super.eIsSet ( featureID );
    }

} //EventInjectorHttpImpl
