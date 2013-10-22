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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.ItemExport;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Export</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ItemExportImpl#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ItemExportImpl#getExportName <em>Export Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ItemExportImpl extends MinimalEObjectImpl.Container implements ItemExport
{
    /**
     * The cached value of the '{@link #getItem() <em>Item</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItem()
     * @generated
     * @ordered
     */
    protected Item item;

    /**
     * The default value of the '{@link #getExportName() <em>Export Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExportName()
     * @generated
     * @ordered
     */
    protected static final String EXPORT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExportName() <em>Export Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExportName()
     * @generated
     * @ordered
     */
    protected String exportName = EXPORT_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemExportImpl ()
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
        return OsgiPackage.Literals.ITEM_EXPORT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Item getItem ()
    {
        if ( item != null && item.eIsProxy () )
        {
            InternalEObject oldItem = (InternalEObject)item;
            item = (Item)eResolveProxy ( oldItem );
            if ( item != oldItem )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.ITEM_EXPORT__ITEM, oldItem, item ) );
            }
        }
        return item;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Item basicGetItem ()
    {
        return item;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setItem ( Item newItem )
    {
        Item oldItem = item;
        item = newItem;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ITEM_EXPORT__ITEM, oldItem, item ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExportName ()
    {
        return exportName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExportName ( String newExportName )
    {
        String oldExportName = exportName;
        exportName = newExportName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ITEM_EXPORT__EXPORT_NAME, oldExportName, exportName ) );
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
            case OsgiPackage.ITEM_EXPORT__ITEM:
                if ( resolve )
                    return getItem ();
                return basicGetItem ();
            case OsgiPackage.ITEM_EXPORT__EXPORT_NAME:
                return getExportName ();
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
            case OsgiPackage.ITEM_EXPORT__ITEM:
                setItem ( (Item)newValue );
                return;
            case OsgiPackage.ITEM_EXPORT__EXPORT_NAME:
                setExportName ( (String)newValue );
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
            case OsgiPackage.ITEM_EXPORT__ITEM:
                setItem ( (Item)null );
                return;
            case OsgiPackage.ITEM_EXPORT__EXPORT_NAME:
                setExportName ( EXPORT_NAME_EDEFAULT );
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
            case OsgiPackage.ITEM_EXPORT__ITEM:
                return item != null;
            case OsgiPackage.ITEM_EXPORT__EXPORT_NAME:
                return EXPORT_NAME_EDEFAULT == null ? exportName != null : !EXPORT_NAME_EDEFAULT.equals ( exportName );
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
        result.append ( " (exportName: " ); //$NON-NLS-1$
        result.append ( exportName );
        result.append ( ')' );
        return result.toString ();
    }

} //ItemExportImpl
