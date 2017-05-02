/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService;
import org.eclipse.scada.configuration.infrastructure.UserEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>System Property User Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.SystemPropertyUserServiceImpl#getUsers <em>Users</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemPropertyUserServiceImpl extends MinimalEObjectImpl.Container implements SystemPropertyUserService
{
    /**
     * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsers()
     * @generated
     * @ordered
     */
    protected EList<UserEntry> users;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SystemPropertyUserServiceImpl ()
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
        return InfrastructurePackage.Literals.SYSTEM_PROPERTY_USER_SERVICE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<UserEntry> getUsers ()
    {
        if ( users == null )
        {
            users = new EObjectContainmentEList.Resolving<UserEntry> ( UserEntry.class, this, InfrastructurePackage.SYSTEM_PROPERTY_USER_SERVICE__USERS );
        }
        return users;
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
            case InfrastructurePackage.SYSTEM_PROPERTY_USER_SERVICE__USERS:
                return ( (InternalEList<?>)getUsers () ).basicRemove ( otherEnd, msgs );
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
            case InfrastructurePackage.SYSTEM_PROPERTY_USER_SERVICE__USERS:
                return getUsers ();
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
            case InfrastructurePackage.SYSTEM_PROPERTY_USER_SERVICE__USERS:
                getUsers ().clear ();
                getUsers ().addAll ( (Collection<? extends UserEntry>)newValue );
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
            case InfrastructurePackage.SYSTEM_PROPERTY_USER_SERVICE__USERS:
                getUsers ().clear ();
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
            case InfrastructurePackage.SYSTEM_PROPERTY_USER_SERVICE__USERS:
                return users != null && !users.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //SystemPropertyUserServiceImpl
