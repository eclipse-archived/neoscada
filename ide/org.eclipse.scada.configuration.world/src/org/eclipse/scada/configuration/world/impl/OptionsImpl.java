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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.Options;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.OptionsImpl#getMasterHandlerPriorities <em>Master Handler Priorities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptionsImpl extends MinimalEObjectImpl.Container implements Options
{
    /**
     * The cached value of the '{@link #getMasterHandlerPriorities() <em>Master Handler Priorities</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMasterHandlerPriorities()
     * @generated
     * @ordered
     */
    protected MasterHandlerPriorities masterHandlerPriorities;

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
        return WorldPackage.Literals.OPTIONS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterHandlerPriorities getMasterHandlerPriorities ()
    {
        if ( masterHandlerPriorities != null && masterHandlerPriorities.eIsProxy () )
        {
            InternalEObject oldMasterHandlerPriorities = (InternalEObject)masterHandlerPriorities;
            masterHandlerPriorities = (MasterHandlerPriorities)eResolveProxy ( oldMasterHandlerPriorities );
            if ( masterHandlerPriorities != oldMasterHandlerPriorities )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, WorldPackage.OPTIONS__MASTER_HANDLER_PRIORITIES, oldMasterHandlerPriorities, masterHandlerPriorities ) );
            }
        }
        return masterHandlerPriorities;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterHandlerPriorities basicGetMasterHandlerPriorities ()
    {
        return masterHandlerPriorities;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMasterHandlerPriorities ( MasterHandlerPriorities newMasterHandlerPriorities )
    {
        MasterHandlerPriorities oldMasterHandlerPriorities = masterHandlerPriorities;
        masterHandlerPriorities = newMasterHandlerPriorities;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.OPTIONS__MASTER_HANDLER_PRIORITIES, oldMasterHandlerPriorities, masterHandlerPriorities ) );
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
            case WorldPackage.OPTIONS__MASTER_HANDLER_PRIORITIES:
                if ( resolve )
                    return getMasterHandlerPriorities ();
                return basicGetMasterHandlerPriorities ();
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
            case WorldPackage.OPTIONS__MASTER_HANDLER_PRIORITIES:
                setMasterHandlerPriorities ( (MasterHandlerPriorities)newValue );
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
            case WorldPackage.OPTIONS__MASTER_HANDLER_PRIORITIES:
                setMasterHandlerPriorities ( (MasterHandlerPriorities)null );
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
            case WorldPackage.OPTIONS__MASTER_HANDLER_PRIORITIES:
                return masterHandlerPriorities != null;
        }
        return super.eIsSet ( featureID );
    }

} //OptionsImpl
