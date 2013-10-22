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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.JdbcUserService;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jdbc User Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.JdbcUserServiceImpl#getImplementation <em>Implementation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JdbcUserServiceImpl extends MinimalEObjectImpl.Container implements JdbcUserService
{
    /**
     * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImplementation()
     * @generated
     * @ordered
     */
    protected org.eclipse.scada.configuration.world.osgi.JdbcUserService implementation;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JdbcUserServiceImpl ()
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
        return InfrastructurePackage.Literals.JDBC_USER_SERVICE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.eclipse.scada.configuration.world.osgi.JdbcUserService getImplementation ()
    {
        if ( implementation != null && implementation.eIsProxy () )
        {
            InternalEObject oldImplementation = (InternalEObject)implementation;
            implementation = (org.eclipse.scada.configuration.world.osgi.JdbcUserService)eResolveProxy ( oldImplementation );
            if ( implementation != oldImplementation )
            {
                InternalEObject newImplementation = (InternalEObject)implementation;
                NotificationChain msgs = oldImplementation.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION, null, null );
                if ( newImplementation.eInternalContainer () == null )
                {
                    msgs = newImplementation.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION, oldImplementation, implementation ) );
            }
        }
        return implementation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.eclipse.scada.configuration.world.osgi.JdbcUserService basicGetImplementation ()
    {
        return implementation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetImplementation ( org.eclipse.scada.configuration.world.osgi.JdbcUserService newImplementation, NotificationChain msgs )
    {
        org.eclipse.scada.configuration.world.osgi.JdbcUserService oldImplementation = implementation;
        implementation = newImplementation;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION, oldImplementation, newImplementation );
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
    public void setImplementation ( org.eclipse.scada.configuration.world.osgi.JdbcUserService newImplementation )
    {
        if ( newImplementation != implementation )
        {
            NotificationChain msgs = null;
            if ( implementation != null )
                msgs = ( (InternalEObject)implementation ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION, null, msgs );
            if ( newImplementation != null )
                msgs = ( (InternalEObject)newImplementation ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION, null, msgs );
            msgs = basicSetImplementation ( newImplementation, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION, newImplementation, newImplementation ) );
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
            case InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION:
                return basicSetImplementation ( null, msgs );
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
            case InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION:
                if ( resolve )
                    return getImplementation ();
                return basicGetImplementation ();
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
            case InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION:
                setImplementation ( (org.eclipse.scada.configuration.world.osgi.JdbcUserService)newValue );
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
            case InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION:
                setImplementation ( (org.eclipse.scada.configuration.world.osgi.JdbcUserService)null );
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
            case InfrastructurePackage.JDBC_USER_SERVICE__IMPLEMENTATION:
                return implementation != null;
        }
        return super.eIsSet ( featureID );
    }

} //JdbcUserServiceImpl
