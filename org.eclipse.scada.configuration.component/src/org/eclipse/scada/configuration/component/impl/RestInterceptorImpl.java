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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.RestInterceptor;
import org.eclipse.scada.configuration.item.Selector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rest Interceptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.RestInterceptorImpl#getContextId <em>Context Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.RestInterceptorImpl#getSelector <em>Selector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RestInterceptorImpl extends MinimalEObjectImpl.Container implements RestInterceptor
{
    /**
     * The default value of the '{@link #getContextId() <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextId()
     * @generated
     * @ordered
     */
    protected static final String CONTEXT_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContextId() <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextId()
     * @generated
     * @ordered
     */
    protected String contextId = CONTEXT_ID_EDEFAULT;

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
    public String getContextId ()
    {
        return contextId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContextId ( String newContextId )
    {
        String oldContextId = contextId;
        contextId = newContextId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.REST_INTERCEPTOR__CONTEXT_ID, oldContextId, contextId ) );
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
            case ComponentPackage.REST_INTERCEPTOR__CONTEXT_ID:
                return getContextId ();
            case ComponentPackage.REST_INTERCEPTOR__SELECTOR:
                if ( resolve )
                    return getSelector ();
                return basicGetSelector ();
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
            case ComponentPackage.REST_INTERCEPTOR__CONTEXT_ID:
                setContextId ( (String)newValue );
                return;
            case ComponentPackage.REST_INTERCEPTOR__SELECTOR:
                setSelector ( (Selector)newValue );
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
            case ComponentPackage.REST_INTERCEPTOR__CONTEXT_ID:
                setContextId ( CONTEXT_ID_EDEFAULT );
                return;
            case ComponentPackage.REST_INTERCEPTOR__SELECTOR:
                setSelector ( (Selector)null );
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
            case ComponentPackage.REST_INTERCEPTOR__CONTEXT_ID:
                return CONTEXT_ID_EDEFAULT == null ? contextId != null : !CONTEXT_ID_EDEFAULT.equals ( contextId );
            case ComponentPackage.REST_INTERCEPTOR__SELECTOR:
                return selector != null;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (contextId: " ); //$NON-NLS-1$
        result.append ( contextId );
        result.append ( ')' );
        return result.toString ();
    }

} //RestInterceptorImpl
