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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ContainerImpl#getItemInterceptors <em>Item Interceptors</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ContainerImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ContainerImpl extends MinimalEObjectImpl.Container implements org.eclipse.scada.configuration.component.Container
{
    /**
     * The cached value of the '{@link #getItemInterceptors() <em>Item Interceptors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemInterceptors()
     * @generated
     * @ordered
     */
    protected EList<ItemInterceptor> itemInterceptors;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> properties;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ContainerImpl ()
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
        return ComponentPackage.Literals.CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ItemInterceptor> getItemInterceptors ()
    {
        if ( itemInterceptors == null )
        {
            itemInterceptors = new EObjectContainmentEList.Resolving<ItemInterceptor> ( ItemInterceptor.class, this, ComponentPackage.CONTAINER__ITEM_INTERCEPTORS );
        }
        return itemInterceptors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getProperties ()
    {
        if ( properties == null )
        {
            properties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, ComponentPackage.CONTAINER__PROPERTIES );
        }
        return properties;
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
            case ComponentPackage.CONTAINER__ITEM_INTERCEPTORS:
                return ( (InternalEList<?>)getItemInterceptors () ).basicRemove ( otherEnd, msgs );
            case ComponentPackage.CONTAINER__PROPERTIES:
                return ( (InternalEList<?>)getProperties () ).basicRemove ( otherEnd, msgs );
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
            case ComponentPackage.CONTAINER__ITEM_INTERCEPTORS:
                return getItemInterceptors ();
            case ComponentPackage.CONTAINER__PROPERTIES:
                return getProperties ();
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
            case ComponentPackage.CONTAINER__ITEM_INTERCEPTORS:
                getItemInterceptors ().clear ();
                getItemInterceptors ().addAll ( (Collection<? extends ItemInterceptor>)newValue );
                return;
            case ComponentPackage.CONTAINER__PROPERTIES:
                getProperties ().clear ();
                getProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
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
            case ComponentPackage.CONTAINER__ITEM_INTERCEPTORS:
                getItemInterceptors ().clear ();
                return;
            case ComponentPackage.CONTAINER__PROPERTIES:
                getProperties ().clear ();
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
            case ComponentPackage.CONTAINER__ITEM_INTERCEPTORS:
                return itemInterceptors != null && !itemInterceptors.isEmpty ();
            case ComponentPackage.CONTAINER__PROPERTIES:
                return properties != null && !properties.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //ContainerImpl
