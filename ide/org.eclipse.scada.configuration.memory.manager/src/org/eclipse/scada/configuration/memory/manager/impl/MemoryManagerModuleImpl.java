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
package org.eclipse.scada.configuration.memory.manager.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.memory.TypeSystem;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerModule;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.memory.manager.impl.MemoryManagerModuleImpl#getTypeSystem <em>Type System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemoryManagerModuleImpl extends MinimalEObjectImpl.Container implements MemoryManagerModule
{
    /**
     * The cached value of the '{@link #getTypeSystem() <em>Type System</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypeSystem()
     * @generated
     * @ordered
     */
    protected TypeSystem typeSystem;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MemoryManagerModuleImpl ()
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
        return MemoryManagerPackage.Literals.MEMORY_MANAGER_MODULE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeSystem getTypeSystem ()
    {
        if ( typeSystem != null && typeSystem.eIsProxy () )
        {
            InternalEObject oldTypeSystem = (InternalEObject)typeSystem;
            typeSystem = (TypeSystem)eResolveProxy ( oldTypeSystem );
            if ( typeSystem != oldTypeSystem )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, MemoryManagerPackage.MEMORY_MANAGER_MODULE__TYPE_SYSTEM, oldTypeSystem, typeSystem ) );
            }
        }
        return typeSystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeSystem basicGetTypeSystem ()
    {
        return typeSystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTypeSystem ( TypeSystem newTypeSystem )
    {
        TypeSystem oldTypeSystem = typeSystem;
        typeSystem = newTypeSystem;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, MemoryManagerPackage.MEMORY_MANAGER_MODULE__TYPE_SYSTEM, oldTypeSystem, typeSystem ) );
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
            case MemoryManagerPackage.MEMORY_MANAGER_MODULE__TYPE_SYSTEM:
                if ( resolve )
                    return getTypeSystem ();
                return basicGetTypeSystem ();
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
            case MemoryManagerPackage.MEMORY_MANAGER_MODULE__TYPE_SYSTEM:
                setTypeSystem ( (TypeSystem)newValue );
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
            case MemoryManagerPackage.MEMORY_MANAGER_MODULE__TYPE_SYSTEM:
                setTypeSystem ( (TypeSystem)null );
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
            case MemoryManagerPackage.MEMORY_MANAGER_MODULE__TYPE_SYSTEM:
                return typeSystem != null;
        }
        return super.eIsSet ( featureID );
    }

} //MemoryManagerModuleImpl
