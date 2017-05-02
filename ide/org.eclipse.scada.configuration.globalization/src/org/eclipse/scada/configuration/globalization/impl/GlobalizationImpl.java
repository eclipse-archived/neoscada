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
package org.eclipse.scada.configuration.globalization.impl;

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
import org.eclipse.scada.configuration.globalization.Global;
import org.eclipse.scada.configuration.globalization.Globalization;
import org.eclipse.scada.configuration.globalization.GlobalizePackage;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.World;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Globalization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.GlobalizationImpl#getWorld <em>World</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.GlobalizationImpl#getDefaultLogonCredentials <em>Default Logon Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.GlobalizationImpl#getGlobals <em>Globals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GlobalizationImpl extends MinimalEObjectImpl.Container implements Globalization
{
    /**
     * The cached value of the '{@link #getWorld() <em>World</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWorld()
     * @generated
     * @ordered
     */
    protected World world;

    /**
     * The cached value of the '{@link #getDefaultLogonCredentials() <em>Default Logon Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultLogonCredentials()
     * @generated
     * @ordered
     */
    protected Credentials defaultLogonCredentials;

    /**
     * The cached value of the '{@link #getGlobals() <em>Globals</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGlobals()
     * @generated
     * @ordered
     */
    protected EList<Global> globals;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GlobalizationImpl ()
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
        return GlobalizePackage.Literals.GLOBALIZATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public World getWorld ()
    {
        if ( world != null && world.eIsProxy () )
        {
            InternalEObject oldWorld = (InternalEObject)world;
            world = (World)eResolveProxy ( oldWorld );
            if ( world != oldWorld )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, GlobalizePackage.GLOBALIZATION__WORLD, oldWorld, world ) );
            }
        }
        return world;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public World basicGetWorld ()
    {
        return world;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWorld ( World newWorld )
    {
        World oldWorld = world;
        world = newWorld;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.GLOBALIZATION__WORLD, oldWorld, world ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials getDefaultLogonCredentials ()
    {
        if ( defaultLogonCredentials != null && defaultLogonCredentials.eIsProxy () )
        {
            InternalEObject oldDefaultLogonCredentials = (InternalEObject)defaultLogonCredentials;
            defaultLogonCredentials = (Credentials)eResolveProxy ( oldDefaultLogonCredentials );
            if ( defaultLogonCredentials != oldDefaultLogonCredentials )
            {
                InternalEObject newDefaultLogonCredentials = (InternalEObject)defaultLogonCredentials;
                NotificationChain msgs = oldDefaultLogonCredentials.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS, null, null );
                if ( newDefaultLogonCredentials.eInternalContainer () == null )
                {
                    msgs = newDefaultLogonCredentials.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS, oldDefaultLogonCredentials, defaultLogonCredentials ) );
            }
        }
        return defaultLogonCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials basicGetDefaultLogonCredentials ()
    {
        return defaultLogonCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefaultLogonCredentials ( Credentials newDefaultLogonCredentials, NotificationChain msgs )
    {
        Credentials oldDefaultLogonCredentials = defaultLogonCredentials;
        defaultLogonCredentials = newDefaultLogonCredentials;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS, oldDefaultLogonCredentials, newDefaultLogonCredentials );
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
    public void setDefaultLogonCredentials ( Credentials newDefaultLogonCredentials )
    {
        if ( newDefaultLogonCredentials != defaultLogonCredentials )
        {
            NotificationChain msgs = null;
            if ( defaultLogonCredentials != null )
                msgs = ( (InternalEObject)defaultLogonCredentials ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS, null, msgs );
            if ( newDefaultLogonCredentials != null )
                msgs = ( (InternalEObject)newDefaultLogonCredentials ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS, null, msgs );
            msgs = basicSetDefaultLogonCredentials ( newDefaultLogonCredentials, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS, newDefaultLogonCredentials, newDefaultLogonCredentials ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Global> getGlobals ()
    {
        if ( globals == null )
        {
            globals = new EObjectContainmentEList.Resolving<Global> ( Global.class, this, GlobalizePackage.GLOBALIZATION__GLOBALS );
        }
        return globals;
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
            case GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS:
                return basicSetDefaultLogonCredentials ( null, msgs );
            case GlobalizePackage.GLOBALIZATION__GLOBALS:
                return ( (InternalEList<?>)getGlobals () ).basicRemove ( otherEnd, msgs );
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
            case GlobalizePackage.GLOBALIZATION__WORLD:
                if ( resolve )
                    return getWorld ();
                return basicGetWorld ();
            case GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS:
                if ( resolve )
                    return getDefaultLogonCredentials ();
                return basicGetDefaultLogonCredentials ();
            case GlobalizePackage.GLOBALIZATION__GLOBALS:
                return getGlobals ();
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
            case GlobalizePackage.GLOBALIZATION__WORLD:
                setWorld ( (World)newValue );
                return;
            case GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS:
                setDefaultLogonCredentials ( (Credentials)newValue );
                return;
            case GlobalizePackage.GLOBALIZATION__GLOBALS:
                getGlobals ().clear ();
                getGlobals ().addAll ( (Collection<? extends Global>)newValue );
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
            case GlobalizePackage.GLOBALIZATION__WORLD:
                setWorld ( (World)null );
                return;
            case GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS:
                setDefaultLogonCredentials ( (Credentials)null );
                return;
            case GlobalizePackage.GLOBALIZATION__GLOBALS:
                getGlobals ().clear ();
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
            case GlobalizePackage.GLOBALIZATION__WORLD:
                return world != null;
            case GlobalizePackage.GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS:
                return defaultLogonCredentials != null;
            case GlobalizePackage.GLOBALIZATION__GLOBALS:
                return globals != null && !globals.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //GlobalizationImpl
