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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.world.ReferencedServiceBinding;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Referenced Service Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.ReferencedServiceBindingImpl#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferencedServiceBindingImpl extends MinimalEObjectImpl.Container implements ReferencedServiceBinding
{
    /**
     * The cached value of the '{@link #getService() <em>Service</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getService()
     * @generated
     * @ordered
     */
    protected EObject service;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ReferencedServiceBindingImpl ()
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
        return WorldPackage.Literals.REFERENCED_SERVICE_BINDING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EObject getService ()
    {
        if ( service != null && service.eIsProxy () )
        {
            InternalEObject oldService = (InternalEObject)service;
            service = eResolveProxy ( oldService );
            if ( service != oldService )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, WorldPackage.REFERENCED_SERVICE_BINDING__SERVICE, oldService, service ) );
            }
        }
        return service;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EObject basicGetService ()
    {
        return service;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setService ( EObject newService )
    {
        EObject oldService = service;
        service = newService;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.REFERENCED_SERVICE_BINDING__SERVICE, oldService, service ) );
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
            case WorldPackage.REFERENCED_SERVICE_BINDING__SERVICE:
                if ( resolve )
                    return getService ();
                return basicGetService ();
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
            case WorldPackage.REFERENCED_SERVICE_BINDING__SERVICE:
                setService ( (EObject)newValue );
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
            case WorldPackage.REFERENCED_SERVICE_BINDING__SERVICE:
                setService ( (EObject)null );
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
            case WorldPackage.REFERENCED_SERVICE_BINDING__SERVICE:
                return service != null;
        }
        return super.eIsSet ( featureID );
    }

} //ReferencedServiceBindingImpl
