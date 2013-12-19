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
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.Options;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.WorldImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.WorldImpl#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorldImpl extends MinimalEObjectImpl.Container implements World
{
    /**
     * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNodes()
     * @generated
     * @ordered
     */
    protected EList<Node> nodes;

    /**
     * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOptions()
     * @generated
     * @ordered
     */
    protected Options options;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WorldImpl ()
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
        return WorldPackage.Literals.WORLD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Node> getNodes ()
    {
        if ( nodes == null )
        {
            nodes = new EObjectContainmentEList.Resolving<Node> ( Node.class, this, WorldPackage.WORLD__NODES );
        }
        return nodes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Options getOptions ()
    {
        if ( options != null && options.eIsProxy () )
        {
            InternalEObject oldOptions = (InternalEObject)options;
            options = (Options)eResolveProxy ( oldOptions );
            if ( options != oldOptions )
            {
                InternalEObject newOptions = (InternalEObject)options;
                NotificationChain msgs = oldOptions.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.WORLD__OPTIONS, null, null );
                if ( newOptions.eInternalContainer () == null )
                {
                    msgs = newOptions.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.WORLD__OPTIONS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, WorldPackage.WORLD__OPTIONS, oldOptions, options ) );
            }
        }
        return options;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Options basicGetOptions ()
    {
        return options;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOptions ( Options newOptions,
            NotificationChain msgs )
    {
        Options oldOptions = options;
        options = newOptions;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, WorldPackage.WORLD__OPTIONS, oldOptions, newOptions );
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
    public void setOptions ( Options newOptions )
    {
        if ( newOptions != options )
        {
            NotificationChain msgs = null;
            if ( options != null )
                msgs = ( (InternalEObject)options ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.WORLD__OPTIONS, null, msgs );
            if ( newOptions != null )
                msgs = ( (InternalEObject)newOptions ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - WorldPackage.WORLD__OPTIONS, null, msgs );
            msgs = basicSetOptions ( newOptions, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.WORLD__OPTIONS, newOptions, newOptions ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd,
            int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case WorldPackage.WORLD__NODES:
                return ( (InternalEList<?>)getNodes () ).basicRemove ( otherEnd, msgs );
            case WorldPackage.WORLD__OPTIONS:
                return basicSetOptions ( null, msgs );
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
            case WorldPackage.WORLD__NODES:
                return getNodes ();
            case WorldPackage.WORLD__OPTIONS:
                if ( resolve )
                    return getOptions ();
                return basicGetOptions ();
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
            case WorldPackage.WORLD__NODES:
                getNodes ().clear ();
                getNodes ().addAll ( (Collection<? extends Node>)newValue );
                return;
            case WorldPackage.WORLD__OPTIONS:
                setOptions ( (Options)newValue );
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
            case WorldPackage.WORLD__NODES:
                getNodes ().clear ();
                return;
            case WorldPackage.WORLD__OPTIONS:
                setOptions ( (Options)null );
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
            case WorldPackage.WORLD__NODES:
                return nodes != null && !nodes.isEmpty ();
            case WorldPackage.WORLD__OPTIONS:
                return options != null;
        }
        return super.eIsSet ( featureID );
    }

} //WorldImpl
