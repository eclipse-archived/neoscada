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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.globalization.GlobalizePackage;
import org.eclipse.scada.configuration.globalization.ItemNameFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Name Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.ItemNameFilterImpl#isInclude <em>Include</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.ItemNameFilterImpl#getItemName <em>Item Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ItemNameFilterImpl extends MinimalEObjectImpl.Container implements ItemNameFilter
{
    /**
     * The default value of the '{@link #isInclude() <em>Include</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInclude()
     * @generated
     * @ordered
     */
    protected static final boolean INCLUDE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isInclude() <em>Include</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isInclude()
     * @generated
     * @ordered
     */
    protected boolean include = INCLUDE_EDEFAULT;

    /**
     * The default value of the '{@link #getItemName() <em>Item Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemName()
     * @generated
     * @ordered
     */
    protected static final String ITEM_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getItemName() <em>Item Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemName()
     * @generated
     * @ordered
     */
    protected String itemName = ITEM_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemNameFilterImpl ()
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
        return GlobalizePackage.Literals.ITEM_NAME_FILTER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isInclude ()
    {
        return include;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInclude ( boolean newInclude )
    {
        boolean oldInclude = include;
        include = newInclude;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.ITEM_NAME_FILTER__INCLUDE, oldInclude, include ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getItemName ()
    {
        return itemName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setItemName ( String newItemName )
    {
        String oldItemName = itemName;
        itemName = newItemName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.ITEM_NAME_FILTER__ITEM_NAME, oldItemName, itemName ) );
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
            case GlobalizePackage.ITEM_NAME_FILTER__INCLUDE:
                return isInclude ();
            case GlobalizePackage.ITEM_NAME_FILTER__ITEM_NAME:
                return getItemName ();
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
            case GlobalizePackage.ITEM_NAME_FILTER__INCLUDE:
                setInclude ( (Boolean)newValue );
                return;
            case GlobalizePackage.ITEM_NAME_FILTER__ITEM_NAME:
                setItemName ( (String)newValue );
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
            case GlobalizePackage.ITEM_NAME_FILTER__INCLUDE:
                setInclude ( INCLUDE_EDEFAULT );
                return;
            case GlobalizePackage.ITEM_NAME_FILTER__ITEM_NAME:
                setItemName ( ITEM_NAME_EDEFAULT );
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
            case GlobalizePackage.ITEM_NAME_FILTER__INCLUDE:
                return include != INCLUDE_EDEFAULT;
            case GlobalizePackage.ITEM_NAME_FILTER__ITEM_NAME:
                return ITEM_NAME_EDEFAULT == null ? itemName != null : !ITEM_NAME_EDEFAULT.equals ( itemName );
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
        result.append ( " (include: " ); //$NON-NLS-1$
        result.append ( include );
        result.append ( ", itemName: " ); //$NON-NLS-1$
        result.append ( itemName );
        result.append ( ')' );
        return result.toString ();
    }

} //ItemNameFilterImpl
