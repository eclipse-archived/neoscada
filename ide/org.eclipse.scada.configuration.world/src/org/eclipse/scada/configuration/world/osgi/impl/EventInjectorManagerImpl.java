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
package org.eclipse.scada.configuration.world.osgi.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.osgi.EventHandler;
import org.eclipse.scada.configuration.world.osgi.EventInjectorManager;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Injector Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorManagerImpl#getHandler <em>Handler</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventInjectorManagerImpl extends MinimalEObjectImpl.Container implements EventInjectorManager
{
    /**
     * The cached value of the '{@link #getHandler() <em>Handler</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHandler()
     * @generated
     * @ordered
     */
    protected EList<EventHandler> handler;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventInjectorManagerImpl ()
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
        return OsgiPackage.Literals.EVENT_INJECTOR_MANAGER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EventHandler> getHandler ()
    {
        if ( handler == null )
        {
            handler = new EObjectContainmentEList.Resolving<EventHandler> ( EventHandler.class, this, OsgiPackage.EVENT_INJECTOR_MANAGER__HANDLER );
        }
        return handler;
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
            case OsgiPackage.EVENT_INJECTOR_MANAGER__HANDLER:
                return ( (InternalEList<?>)getHandler () ).basicRemove ( otherEnd, msgs );
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
            case OsgiPackage.EVENT_INJECTOR_MANAGER__HANDLER:
                return getHandler ();
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
            case OsgiPackage.EVENT_INJECTOR_MANAGER__HANDLER:
                getHandler ().clear ();
                getHandler ().addAll ( (Collection<? extends EventHandler>)newValue );
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
            case OsgiPackage.EVENT_INJECTOR_MANAGER__HANDLER:
                getHandler ().clear ();
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
            case OsgiPackage.EVENT_INJECTOR_MANAGER__HANDLER:
                return handler != null && !handler.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //EventInjectorManagerImpl
