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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.globalization.EventPoolImport;
import org.eclipse.scada.configuration.globalization.Filter;
import org.eclipse.scada.configuration.globalization.Global;
import org.eclipse.scada.configuration.globalization.GlobalizePackage;
import org.eclipse.scada.configuration.globalization.Local;
import org.eclipse.scada.configuration.globalization.MonitorPoolImport;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.PullEvents;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.GlobalImpl#getGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.GlobalImpl#getDefaultLogonCredentials <em>Default Logon Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.GlobalImpl#getLocals <em>Locals</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.GlobalImpl#getEventPoolImports <em>Event Pool Imports</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.GlobalImpl#getMonitorPoolImports <em>Monitor Pool Imports</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.GlobalImpl#getLocalPull <em>Local Pull</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.GlobalImpl#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GlobalImpl extends MinimalEObjectImpl.Container implements Global
{
    /**
     * The cached value of the '{@link #getGlobal() <em>Global</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGlobal()
     * @generated
     * @ordered
     */
    protected MasterServer global;

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
     * The cached value of the '{@link #getLocals() <em>Locals</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocals()
     * @generated
     * @ordered
     */
    protected EList<Local> locals;

    /**
     * The cached value of the '{@link #getEventPoolImports() <em>Event Pool Imports</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEventPoolImports()
     * @generated
     * @ordered
     */
    protected EList<EventPoolImport> eventPoolImports;

    /**
     * The cached value of the '{@link #getMonitorPoolImports() <em>Monitor Pool Imports</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMonitorPoolImports()
     * @generated
     * @ordered
     */
    protected EList<MonitorPoolImport> monitorPoolImports;

    /**
     * The cached value of the '{@link #getLocalPull() <em>Local Pull</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalPull()
     * @generated
     * @ordered
     */
    protected PullEvents localPull;

    /**
     * The cached value of the '{@link #getFilters() <em>Filters</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilters()
     * @generated
     * @ordered
     */
    protected EList<Filter> filters;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GlobalImpl ()
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
        return GlobalizePackage.Literals.GLOBAL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterServer getGlobal ()
    {
        if ( global != null && global.eIsProxy () )
        {
            InternalEObject oldGlobal = (InternalEObject)global;
            global = (MasterServer)eResolveProxy ( oldGlobal );
            if ( global != oldGlobal )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, GlobalizePackage.GLOBAL__GLOBAL, oldGlobal, global ) );
            }
        }
        return global;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterServer basicGetGlobal ()
    {
        return global;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGlobal ( MasterServer newGlobal )
    {
        MasterServer oldGlobal = global;
        global = newGlobal;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.GLOBAL__GLOBAL, oldGlobal, global ) );
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
                NotificationChain msgs = oldDefaultLogonCredentials.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS, null, null );
                if ( newDefaultLogonCredentials.eInternalContainer () == null )
                {
                    msgs = newDefaultLogonCredentials.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS, oldDefaultLogonCredentials, defaultLogonCredentials ) );
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
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS, oldDefaultLogonCredentials, newDefaultLogonCredentials );
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
                msgs = ( (InternalEObject)defaultLogonCredentials ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS, null, msgs );
            if ( newDefaultLogonCredentials != null )
                msgs = ( (InternalEObject)newDefaultLogonCredentials ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS, null, msgs );
            msgs = basicSetDefaultLogonCredentials ( newDefaultLogonCredentials, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS, newDefaultLogonCredentials, newDefaultLogonCredentials ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Local> getLocals ()
    {
        if ( locals == null )
        {
            locals = new EObjectContainmentWithInverseEList.Resolving<Local> ( Local.class, this, GlobalizePackage.GLOBAL__LOCALS, GlobalizePackage.LOCAL__GLOBAL );
        }
        return locals;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EventPoolImport> getEventPoolImports ()
    {
        if ( eventPoolImports == null )
        {
            eventPoolImports = new EObjectContainmentEList.Resolving<EventPoolImport> ( EventPoolImport.class, this, GlobalizePackage.GLOBAL__EVENT_POOL_IMPORTS );
        }
        return eventPoolImports;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MonitorPoolImport> getMonitorPoolImports ()
    {
        if ( monitorPoolImports == null )
        {
            monitorPoolImports = new EObjectContainmentEList.Resolving<MonitorPoolImport> ( MonitorPoolImport.class, this, GlobalizePackage.GLOBAL__MONITOR_POOL_IMPORTS );
        }
        return monitorPoolImports;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PullEvents getLocalPull ()
    {
        if ( localPull != null && localPull.eIsProxy () )
        {
            InternalEObject oldLocalPull = (InternalEObject)localPull;
            localPull = (PullEvents)eResolveProxy ( oldLocalPull );
            if ( localPull != oldLocalPull )
            {
                InternalEObject newLocalPull = (InternalEObject)localPull;
                NotificationChain msgs = oldLocalPull.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBAL__LOCAL_PULL, null, null );
                if ( newLocalPull.eInternalContainer () == null )
                {
                    msgs = newLocalPull.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBAL__LOCAL_PULL, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, GlobalizePackage.GLOBAL__LOCAL_PULL, oldLocalPull, localPull ) );
            }
        }
        return localPull;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PullEvents basicGetLocalPull ()
    {
        return localPull;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLocalPull ( PullEvents newLocalPull, NotificationChain msgs )
    {
        PullEvents oldLocalPull = localPull;
        localPull = newLocalPull;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, GlobalizePackage.GLOBAL__LOCAL_PULL, oldLocalPull, newLocalPull );
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
    public void setLocalPull ( PullEvents newLocalPull )
    {
        if ( newLocalPull != localPull )
        {
            NotificationChain msgs = null;
            if ( localPull != null )
                msgs = ( (InternalEObject)localPull ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBAL__LOCAL_PULL, null, msgs );
            if ( newLocalPull != null )
                msgs = ( (InternalEObject)newLocalPull ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.GLOBAL__LOCAL_PULL, null, msgs );
            msgs = basicSetLocalPull ( newLocalPull, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.GLOBAL__LOCAL_PULL, newLocalPull, newLocalPull ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Filter> getFilters ()
    {
        if ( filters == null )
        {
            filters = new EObjectContainmentEList.Resolving<Filter> ( Filter.class, this, GlobalizePackage.GLOBAL__FILTERS );
        }
        return filters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case GlobalizePackage.GLOBAL__LOCALS:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getLocals () ).basicAdd ( otherEnd, msgs );
        }
        return super.eInverseAdd ( otherEnd, featureID, msgs );
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
            case GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS:
                return basicSetDefaultLogonCredentials ( null, msgs );
            case GlobalizePackage.GLOBAL__LOCALS:
                return ( (InternalEList<?>)getLocals () ).basicRemove ( otherEnd, msgs );
            case GlobalizePackage.GLOBAL__EVENT_POOL_IMPORTS:
                return ( (InternalEList<?>)getEventPoolImports () ).basicRemove ( otherEnd, msgs );
            case GlobalizePackage.GLOBAL__MONITOR_POOL_IMPORTS:
                return ( (InternalEList<?>)getMonitorPoolImports () ).basicRemove ( otherEnd, msgs );
            case GlobalizePackage.GLOBAL__LOCAL_PULL:
                return basicSetLocalPull ( null, msgs );
            case GlobalizePackage.GLOBAL__FILTERS:
                return ( (InternalEList<?>)getFilters () ).basicRemove ( otherEnd, msgs );
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
            case GlobalizePackage.GLOBAL__GLOBAL:
                if ( resolve )
                    return getGlobal ();
                return basicGetGlobal ();
            case GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS:
                if ( resolve )
                    return getDefaultLogonCredentials ();
                return basicGetDefaultLogonCredentials ();
            case GlobalizePackage.GLOBAL__LOCALS:
                return getLocals ();
            case GlobalizePackage.GLOBAL__EVENT_POOL_IMPORTS:
                return getEventPoolImports ();
            case GlobalizePackage.GLOBAL__MONITOR_POOL_IMPORTS:
                return getMonitorPoolImports ();
            case GlobalizePackage.GLOBAL__LOCAL_PULL:
                if ( resolve )
                    return getLocalPull ();
                return basicGetLocalPull ();
            case GlobalizePackage.GLOBAL__FILTERS:
                return getFilters ();
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
            case GlobalizePackage.GLOBAL__GLOBAL:
                setGlobal ( (MasterServer)newValue );
                return;
            case GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS:
                setDefaultLogonCredentials ( (Credentials)newValue );
                return;
            case GlobalizePackage.GLOBAL__LOCALS:
                getLocals ().clear ();
                getLocals ().addAll ( (Collection<? extends Local>)newValue );
                return;
            case GlobalizePackage.GLOBAL__EVENT_POOL_IMPORTS:
                getEventPoolImports ().clear ();
                getEventPoolImports ().addAll ( (Collection<? extends EventPoolImport>)newValue );
                return;
            case GlobalizePackage.GLOBAL__MONITOR_POOL_IMPORTS:
                getMonitorPoolImports ().clear ();
                getMonitorPoolImports ().addAll ( (Collection<? extends MonitorPoolImport>)newValue );
                return;
            case GlobalizePackage.GLOBAL__LOCAL_PULL:
                setLocalPull ( (PullEvents)newValue );
                return;
            case GlobalizePackage.GLOBAL__FILTERS:
                getFilters ().clear ();
                getFilters ().addAll ( (Collection<? extends Filter>)newValue );
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
            case GlobalizePackage.GLOBAL__GLOBAL:
                setGlobal ( (MasterServer)null );
                return;
            case GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS:
                setDefaultLogonCredentials ( (Credentials)null );
                return;
            case GlobalizePackage.GLOBAL__LOCALS:
                getLocals ().clear ();
                return;
            case GlobalizePackage.GLOBAL__EVENT_POOL_IMPORTS:
                getEventPoolImports ().clear ();
                return;
            case GlobalizePackage.GLOBAL__MONITOR_POOL_IMPORTS:
                getMonitorPoolImports ().clear ();
                return;
            case GlobalizePackage.GLOBAL__LOCAL_PULL:
                setLocalPull ( (PullEvents)null );
                return;
            case GlobalizePackage.GLOBAL__FILTERS:
                getFilters ().clear ();
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
            case GlobalizePackage.GLOBAL__GLOBAL:
                return global != null;
            case GlobalizePackage.GLOBAL__DEFAULT_LOGON_CREDENTIALS:
                return defaultLogonCredentials != null;
            case GlobalizePackage.GLOBAL__LOCALS:
                return locals != null && !locals.isEmpty ();
            case GlobalizePackage.GLOBAL__EVENT_POOL_IMPORTS:
                return eventPoolImports != null && !eventPoolImports.isEmpty ();
            case GlobalizePackage.GLOBAL__MONITOR_POOL_IMPORTS:
                return monitorPoolImports != null && !monitorPoolImports.isEmpty ();
            case GlobalizePackage.GLOBAL__LOCAL_PULL:
                return localPull != null;
            case GlobalizePackage.GLOBAL__FILTERS:
                return filters != null && !filters.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //GlobalImpl
