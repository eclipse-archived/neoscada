/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.neoscada.configuration.iec60870.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.neoscada.configuration.iec60870.IECType;
import org.eclipse.neoscada.configuration.iec60870.ItemType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ItemTypeImpl#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ItemTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItemTypeImpl extends MinimalEObjectImpl.Container implements ItemType
{
    /**
     * The default value of the '{@link #getItem() <em>Item</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItem()
     * @generated
     * @ordered
     */
    protected static final String ITEM_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getItem() <em>Item</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItem()
     * @generated
     * @ordered
     */
    protected String item = ITEM_EDEFAULT;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final IECType TYPE_EDEFAULT = IECType.CSC_NA_1;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected IECType type = TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemTypeImpl ()
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
        return IEC60870Package.Literals.ITEM_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getItem ()
    {
        return item;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setItem ( String newItem )
    {
        String oldItem = item;
        item = newItem;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.ITEM_TYPE__ITEM, oldItem, item ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IECType getType ()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType ( IECType newType )
    {
        IECType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.ITEM_TYPE__TYPE, oldType, type ) );
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
            case IEC60870Package.ITEM_TYPE__ITEM:
                return getItem ();
            case IEC60870Package.ITEM_TYPE__TYPE:
                return getType ();
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
            case IEC60870Package.ITEM_TYPE__ITEM:
                setItem ( (String)newValue );
                return;
            case IEC60870Package.ITEM_TYPE__TYPE:
                setType ( (IECType)newValue );
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
            case IEC60870Package.ITEM_TYPE__ITEM:
                setItem ( ITEM_EDEFAULT );
                return;
            case IEC60870Package.ITEM_TYPE__TYPE:
                setType ( TYPE_EDEFAULT );
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
            case IEC60870Package.ITEM_TYPE__ITEM:
                return ITEM_EDEFAULT == null ? item != null : !ITEM_EDEFAULT.equals ( item );
            case IEC60870Package.ITEM_TYPE__TYPE:
                return type != TYPE_EDEFAULT;
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
        result.append ( " (item: " ); //$NON-NLS-1$
        result.append ( item );
        result.append ( ", type: " ); //$NON-NLS-1$
        result.append ( type );
        result.append ( ')' );
        return result.toString ();
    }

} //ItemTypeImpl
