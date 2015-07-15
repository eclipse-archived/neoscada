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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Weak Reference Data Source Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.WeakReferenceDataSourceItemImpl#getDataSourceId <em>Data Source Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WeakReferenceDataSourceItemImpl extends ItemImpl implements WeakReferenceDataSourceItem
{
    /**
     * The default value of the '{@link #getDataSourceId() <em>Data Source Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataSourceId()
     * @generated
     * @ordered
     */
    protected static final String DATA_SOURCE_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDataSourceId() <em>Data Source Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataSourceId()
     * @generated
     * @ordered
     */
    protected String dataSourceId = DATA_SOURCE_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WeakReferenceDataSourceItemImpl ()
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
        return OsgiPackage.Literals.WEAK_REFERENCE_DATA_SOURCE_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDataSourceId ()
    {
        return dataSourceId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataSourceId ( String newDataSourceId )
    {
        String oldDataSourceId = dataSourceId;
        dataSourceId = newDataSourceId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.WEAK_REFERENCE_DATA_SOURCE_ITEM__DATA_SOURCE_ID, oldDataSourceId, dataSourceId ) );
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
            case OsgiPackage.WEAK_REFERENCE_DATA_SOURCE_ITEM__DATA_SOURCE_ID:
                return getDataSourceId ();
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
            case OsgiPackage.WEAK_REFERENCE_DATA_SOURCE_ITEM__DATA_SOURCE_ID:
                setDataSourceId ( (String)newValue );
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
            case OsgiPackage.WEAK_REFERENCE_DATA_SOURCE_ITEM__DATA_SOURCE_ID:
                setDataSourceId ( DATA_SOURCE_ID_EDEFAULT );
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
            case OsgiPackage.WEAK_REFERENCE_DATA_SOURCE_ITEM__DATA_SOURCE_ID:
                return DATA_SOURCE_ID_EDEFAULT == null ? dataSourceId != null : !DATA_SOURCE_ID_EDEFAULT.equals ( dataSourceId );
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
        result.append ( " (dataSourceId: " ); //$NON-NLS-1$
        result.append ( dataSourceId );
        result.append ( ')' );
        return result.toString ();
    }

} //WeakReferenceDataSourceItemImpl
