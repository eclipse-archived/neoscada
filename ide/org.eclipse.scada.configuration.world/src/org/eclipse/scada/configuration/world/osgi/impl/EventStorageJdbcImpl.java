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
import org.eclipse.scada.configuration.world.osgi.EventStorageJdbc;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Storage Jdbc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventStorageJdbcImpl#getMaxFieldLength <em>Max Field Length</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventStorageJdbcImpl#getQueryFetchSize <em>Query Fetch Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventStorageJdbcImpl extends AbstractEventStorageJdbcImpl implements EventStorageJdbc
{
    /**
     * The default value of the '{@link #getMaxFieldLength() <em>Max Field Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxFieldLength()
     * @generated
     * @ordered
     */
    protected static final Integer MAX_FIELD_LENGTH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMaxFieldLength() <em>Max Field Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxFieldLength()
     * @generated
     * @ordered
     */
    protected Integer maxFieldLength = MAX_FIELD_LENGTH_EDEFAULT;

    /**
     * The default value of the '{@link #getQueryFetchSize() <em>Query Fetch Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQueryFetchSize()
     * @generated
     * @ordered
     */
    protected static final Integer QUERY_FETCH_SIZE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQueryFetchSize() <em>Query Fetch Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQueryFetchSize()
     * @generated
     * @ordered
     */
    protected Integer queryFetchSize = QUERY_FETCH_SIZE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventStorageJdbcImpl ()
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
        return OsgiPackage.Literals.EVENT_STORAGE_JDBC;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Integer getMaxFieldLength ()
    {
        return maxFieldLength;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMaxFieldLength ( Integer newMaxFieldLength )
    {
        Integer oldMaxFieldLength = maxFieldLength;
        maxFieldLength = newMaxFieldLength;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_STORAGE_JDBC__MAX_FIELD_LENGTH, oldMaxFieldLength, maxFieldLength ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Integer getQueryFetchSize ()
    {
        return queryFetchSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setQueryFetchSize ( Integer newQueryFetchSize )
    {
        Integer oldQueryFetchSize = queryFetchSize;
        queryFetchSize = newQueryFetchSize;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_STORAGE_JDBC__QUERY_FETCH_SIZE, oldQueryFetchSize, queryFetchSize ) );
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
            case OsgiPackage.EVENT_STORAGE_JDBC__MAX_FIELD_LENGTH:
                return getMaxFieldLength ();
            case OsgiPackage.EVENT_STORAGE_JDBC__QUERY_FETCH_SIZE:
                return getQueryFetchSize ();
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
            case OsgiPackage.EVENT_STORAGE_JDBC__MAX_FIELD_LENGTH:
                setMaxFieldLength ( (Integer)newValue );
                return;
            case OsgiPackage.EVENT_STORAGE_JDBC__QUERY_FETCH_SIZE:
                setQueryFetchSize ( (Integer)newValue );
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
            case OsgiPackage.EVENT_STORAGE_JDBC__MAX_FIELD_LENGTH:
                setMaxFieldLength ( MAX_FIELD_LENGTH_EDEFAULT );
                return;
            case OsgiPackage.EVENT_STORAGE_JDBC__QUERY_FETCH_SIZE:
                setQueryFetchSize ( QUERY_FETCH_SIZE_EDEFAULT );
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
            case OsgiPackage.EVENT_STORAGE_JDBC__MAX_FIELD_LENGTH:
                return MAX_FIELD_LENGTH_EDEFAULT == null ? maxFieldLength != null : !MAX_FIELD_LENGTH_EDEFAULT.equals ( maxFieldLength );
            case OsgiPackage.EVENT_STORAGE_JDBC__QUERY_FETCH_SIZE:
                return QUERY_FETCH_SIZE_EDEFAULT == null ? queryFetchSize != null : !QUERY_FETCH_SIZE_EDEFAULT.equals ( queryFetchSize );
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
        result.append ( " (maxFieldLength: " ); //$NON-NLS-1$
        result.append ( maxFieldLength );
        result.append ( ", queryFetchSize: " ); //$NON-NLS-1$
        result.append ( queryFetchSize );
        result.append ( ')' );
        return result.toString ();
    }

} //EventStorageJdbcImpl
