/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.RestInterceptor;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.RestExporterModule;
import org.eclipse.scada.configuration.item.Selector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rest Interceptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.RestInterceptorImpl#getMasterOn <em>Master On</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.RestInterceptorImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.RestInterceptorImpl#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RestInterceptorImpl extends MinimalEObjectImpl.Container implements RestInterceptor
{
    /**
     * The cached value of the '{@link #getMasterOn() <em>Master On</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMasterOn()
     * @generated
     * @ordered
     */
    protected EList<MasterServer> masterOn;

    /**
     * The cached value of the '{@link #getSelector() <em>Selector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelector()
     * @generated
     * @ordered
     */
    protected Selector selector;

    /**
     * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefinition()
     * @generated
     * @ordered
     */
    protected RestExporterModule definition;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RestInterceptorImpl ()
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
        return ComponentPackage.Literals.REST_INTERCEPTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MasterServer> getMasterOn ()
    {
        if ( masterOn == null )
        {
            masterOn = new EObjectResolvingEList<MasterServer> ( MasterServer.class, this, ComponentPackage.REST_INTERCEPTOR__MASTER_ON );
        }
        return masterOn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Selector getSelector ()
    {
        if ( selector != null && selector.eIsProxy () )
        {
            InternalEObject oldSelector = (InternalEObject)selector;
            selector = (Selector)eResolveProxy ( oldSelector );
            if ( selector != oldSelector )
            {
                InternalEObject newSelector = (InternalEObject)selector;
                NotificationChain msgs = oldSelector.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.REST_INTERCEPTOR__SELECTOR, null, null );
                if ( newSelector.eInternalContainer () == null )
                {
                    msgs = newSelector.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.REST_INTERCEPTOR__SELECTOR, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.REST_INTERCEPTOR__SELECTOR, oldSelector, selector ) );
            }
        }
        return selector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Selector basicGetSelector ()
    {
        return selector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSelector ( Selector newSelector, NotificationChain msgs )
    {
        Selector oldSelector = selector;
        selector = newSelector;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.REST_INTERCEPTOR__SELECTOR, oldSelector, newSelector );
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
    public void setSelector ( Selector newSelector )
    {
        if ( newSelector != selector )
        {
            NotificationChain msgs = null;
            if ( selector != null )
                msgs = ( (InternalEObject)selector ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.REST_INTERCEPTOR__SELECTOR, null, msgs );
            if ( newSelector != null )
                msgs = ( (InternalEObject)newSelector ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.REST_INTERCEPTOR__SELECTOR, null, msgs );
            msgs = basicSetSelector ( newSelector, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.REST_INTERCEPTOR__SELECTOR, newSelector, newSelector ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RestExporterModule getDefinition ()
    {
        if ( definition != null && definition.eIsProxy () )
        {
            InternalEObject oldDefinition = (InternalEObject)definition;
            definition = (RestExporterModule)eResolveProxy ( oldDefinition );
            if ( definition != oldDefinition )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.REST_INTERCEPTOR__DEFINITION, oldDefinition, definition ) );
            }
        }
        return definition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RestExporterModule basicGetDefinition ()
    {
        return definition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefinition ( RestExporterModule newDefinition )
    {
        RestExporterModule oldDefinition = definition;
        definition = newDefinition;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.REST_INTERCEPTOR__DEFINITION, oldDefinition, definition ) );
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
            case ComponentPackage.REST_INTERCEPTOR__SELECTOR:
                return basicSetSelector ( null, msgs );
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
            case ComponentPackage.REST_INTERCEPTOR__MASTER_ON:
                return getMasterOn ();
            case ComponentPackage.REST_INTERCEPTOR__SELECTOR:
                if ( resolve )
                    return getSelector ();
                return basicGetSelector ();
            case ComponentPackage.REST_INTERCEPTOR__DEFINITION:
                if ( resolve )
                    return getDefinition ();
                return basicGetDefinition ();
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
            case ComponentPackage.REST_INTERCEPTOR__MASTER_ON:
                getMasterOn ().clear ();
                getMasterOn ().addAll ( (Collection<? extends MasterServer>)newValue );
                return;
            case ComponentPackage.REST_INTERCEPTOR__SELECTOR:
                setSelector ( (Selector)newValue );
                return;
            case ComponentPackage.REST_INTERCEPTOR__DEFINITION:
                setDefinition ( (RestExporterModule)newValue );
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
            case ComponentPackage.REST_INTERCEPTOR__MASTER_ON:
                getMasterOn ().clear ();
                return;
            case ComponentPackage.REST_INTERCEPTOR__SELECTOR:
                setSelector ( (Selector)null );
                return;
            case ComponentPackage.REST_INTERCEPTOR__DEFINITION:
                setDefinition ( (RestExporterModule)null );
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
            case ComponentPackage.REST_INTERCEPTOR__MASTER_ON:
                return masterOn != null && !masterOn.isEmpty ();
            case ComponentPackage.REST_INTERCEPTOR__SELECTOR:
                return selector != null;
            case ComponentPackage.REST_INTERCEPTOR__DEFINITION:
                return definition != null;
        }
        return super.eIsSet ( featureID );
    }

} //RestInterceptorImpl
