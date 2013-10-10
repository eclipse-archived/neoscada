/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.proxy.configuration.impl;

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
import org.eclipse.scada.da.proxy.configuration.ConfigurationPackage;
import org.eclipse.scada.da.proxy.configuration.ProxyType;
import org.eclipse.scada.da.proxy.configuration.RootType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.impl.RootTypeImpl#getProxy <em>Proxy</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.impl.RootTypeImpl#getSeparator <em>Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootTypeImpl extends MinimalEObjectImpl.Container implements RootType
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getProxy() <em>Proxy</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProxy()
     * @generated
     * @ordered
     */
    protected EList<ProxyType> proxy;

    /**
     * The default value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSeparator()
     * @generated
     * @ordered
     */
    protected static final String SEPARATOR_EDEFAULT = "."; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getSeparator() <em>Separator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSeparator()
     * @generated
     * @ordered
     */
    protected String separator = SEPARATOR_EDEFAULT;

    /**
     * This is true if the Separator attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean separatorESet;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RootTypeImpl ()
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
        return ConfigurationPackage.Literals.ROOT_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ProxyType> getProxy ()
    {
        if ( proxy == null )
        {
            proxy = new EObjectContainmentEList<ProxyType> ( ProxyType.class, this, ConfigurationPackage.ROOT_TYPE__PROXY );
        }
        return proxy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSeparator ()
    {
        return separator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSeparator ( String newSeparator )
    {
        String oldSeparator = separator;
        separator = newSeparator;
        boolean oldSeparatorESet = separatorESet;
        separatorESet = true;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.ROOT_TYPE__SEPARATOR, oldSeparator, separator, !oldSeparatorESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetSeparator ()
    {
        String oldSeparator = separator;
        boolean oldSeparatorESet = separatorESet;
        separator = SEPARATOR_EDEFAULT;
        separatorESet = false;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.UNSET, ConfigurationPackage.ROOT_TYPE__SEPARATOR, oldSeparator, SEPARATOR_EDEFAULT, oldSeparatorESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetSeparator ()
    {
        return separatorESet;
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
            case ConfigurationPackage.ROOT_TYPE__PROXY:
                return ( (InternalEList<?>)getProxy () ).basicRemove ( otherEnd, msgs );
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
            case ConfigurationPackage.ROOT_TYPE__PROXY:
                return getProxy ();
            case ConfigurationPackage.ROOT_TYPE__SEPARATOR:
                return getSeparator ();
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
            case ConfigurationPackage.ROOT_TYPE__PROXY:
                getProxy ().clear ();
                getProxy ().addAll ( (Collection<? extends ProxyType>)newValue );
                return;
            case ConfigurationPackage.ROOT_TYPE__SEPARATOR:
                setSeparator ( (String)newValue );
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
            case ConfigurationPackage.ROOT_TYPE__PROXY:
                getProxy ().clear ();
                return;
            case ConfigurationPackage.ROOT_TYPE__SEPARATOR:
                unsetSeparator ();
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
            case ConfigurationPackage.ROOT_TYPE__PROXY:
                return proxy != null && !proxy.isEmpty ();
            case ConfigurationPackage.ROOT_TYPE__SEPARATOR:
                return isSetSeparator ();
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
        result.append ( " (separator: " ); //$NON-NLS-1$
        if ( separatorESet )
            result.append ( separator );
        else
            result.append ( "<unset>" ); //$NON-NLS-1$
        result.append ( ')' );
        return result.toString ();
    }

} //RootTypeImpl
