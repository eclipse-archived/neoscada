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
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Archive Slave</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveSlaveImpl#getStoragePath <em>Storage Path</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveSlaveImpl#getStorageLayout <em>Storage Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueArchiveSlaveImpl extends EquinoxApplicationImpl implements ValueArchiveSlave
{
    /**
     * The default value of the '{@link #getStoragePath() <em>Storage Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStoragePath()
     * @generated
     * @ordered
     */
    protected static final String STORAGE_PATH_EDEFAULT = "/var/lib/neoscada/hds.slave"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getStoragePath() <em>Storage Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStoragePath()
     * @generated
     * @ordered
     */
    protected String storagePath = STORAGE_PATH_EDEFAULT;

    /**
     * The default value of the '{@link #getStorageLayout() <em>Storage Layout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStorageLayout()
     * @generated
     * @ordered
     */
    protected static final SlaveStorageLayout STORAGE_LAYOUT_EDEFAULT = SlaveStorageLayout.MULTI;

    /**
     * The cached value of the '{@link #getStorageLayout() <em>Storage Layout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStorageLayout()
     * @generated
     * @ordered
     */
    protected SlaveStorageLayout storageLayout = STORAGE_LAYOUT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValueArchiveSlaveImpl ()
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
        return InfrastructurePackage.Literals.VALUE_ARCHIVE_SLAVE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getStoragePath ()
    {
        return storagePath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStoragePath ( String newStoragePath )
    {
        String oldStoragePath = storagePath;
        storagePath = newStoragePath;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.VALUE_ARCHIVE_SLAVE__STORAGE_PATH, oldStoragePath, storagePath ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SlaveStorageLayout getStorageLayout ()
    {
        return storageLayout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStorageLayout ( SlaveStorageLayout newStorageLayout )
    {
        SlaveStorageLayout oldStorageLayout = storageLayout;
        storageLayout = newStorageLayout == null ? STORAGE_LAYOUT_EDEFAULT : newStorageLayout;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.VALUE_ARCHIVE_SLAVE__STORAGE_LAYOUT, oldStorageLayout, storageLayout ) );
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
            case InfrastructurePackage.VALUE_ARCHIVE_SLAVE__STORAGE_PATH:
                return getStoragePath ();
            case InfrastructurePackage.VALUE_ARCHIVE_SLAVE__STORAGE_LAYOUT:
                return getStorageLayout ();
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
            case InfrastructurePackage.VALUE_ARCHIVE_SLAVE__STORAGE_PATH:
                setStoragePath ( (String)newValue );
                return;
            case InfrastructurePackage.VALUE_ARCHIVE_SLAVE__STORAGE_LAYOUT:
                setStorageLayout ( (SlaveStorageLayout)newValue );
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
            case InfrastructurePackage.VALUE_ARCHIVE_SLAVE__STORAGE_PATH:
                setStoragePath ( STORAGE_PATH_EDEFAULT );
                return;
            case InfrastructurePackage.VALUE_ARCHIVE_SLAVE__STORAGE_LAYOUT:
                setStorageLayout ( STORAGE_LAYOUT_EDEFAULT );
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
            case InfrastructurePackage.VALUE_ARCHIVE_SLAVE__STORAGE_PATH:
                return STORAGE_PATH_EDEFAULT == null ? storagePath != null : !STORAGE_PATH_EDEFAULT.equals ( storagePath );
            case InfrastructurePackage.VALUE_ARCHIVE_SLAVE__STORAGE_LAYOUT:
                return storageLayout != STORAGE_LAYOUT_EDEFAULT;
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
        result.append ( " (storagePath: " ); //$NON-NLS-1$
        result.append ( storagePath );
        result.append ( ", storageLayout: " ); //$NON-NLS-1$
        result.append ( storageLayout );
        result.append ( ')' );
        return result.toString ();
    }

} //ValueArchiveSlaveImpl
