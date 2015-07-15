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
package org.eclipse.scada.configuration.world.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.world.ExecDriver;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.da.exec.configuration.RootType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exec Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.ExecDriverImpl#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecDriverImpl extends CommonDriverImpl implements ExecDriver
{
    /**
     * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRoot()
     * @generated
     * @ordered
     */
    protected RootType root;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExecDriverImpl ()
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
        return WorldPackage.Literals.EXEC_DRIVER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RootType getRoot ()
    {
        if ( root != null && root.eIsProxy () )
        {
            InternalEObject oldRoot = (InternalEObject)root;
            root = (RootType)eResolveProxy ( oldRoot );
            if ( root != oldRoot )
            {
                InternalEObject newRoot = (InternalEObject)root;
                NotificationChain msgs = oldRoot.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.EXEC_DRIVER__ROOT, null, null );
                if ( newRoot.eInternalContainer () == null )
                {
                    msgs = newRoot.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.EXEC_DRIVER__ROOT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, WorldPackage.EXEC_DRIVER__ROOT, oldRoot, root ) );
            }
        }
        return root;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RootType basicGetRoot ()
    {
        return root;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRoot ( RootType newRoot, NotificationChain msgs )
    {
        RootType oldRoot = root;
        root = newRoot;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, WorldPackage.EXEC_DRIVER__ROOT, oldRoot, newRoot );
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
    public void setRoot ( RootType newRoot )
    {
        if ( newRoot != root )
        {
            NotificationChain msgs = null;
            if ( root != null )
                msgs = ( (InternalEObject)root ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.EXEC_DRIVER__ROOT, null, msgs );
            if ( newRoot != null )
                msgs = ( (InternalEObject)newRoot ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.EXEC_DRIVER__ROOT, null, msgs );
            msgs = basicSetRoot ( newRoot, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.EXEC_DRIVER__ROOT, newRoot, newRoot ) );
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
            case WorldPackage.EXEC_DRIVER__ROOT:
                return basicSetRoot ( null, msgs );
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
            case WorldPackage.EXEC_DRIVER__ROOT:
                if ( resolve )
                    return getRoot ();
                return basicGetRoot ();
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
            case WorldPackage.EXEC_DRIVER__ROOT:
                setRoot ( (RootType)newValue );
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
            case WorldPackage.EXEC_DRIVER__ROOT:
                setRoot ( (RootType)null );
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
            case WorldPackage.EXEC_DRIVER__ROOT:
                return root != null;
        }
        return super.eIsSet ( featureID );
    }

} //ExecDriverImpl
