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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.configuration.world.osgi.EventStoragePostgres;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Storage Postgres</b></em>
 * '.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventStoragePostgresImpl#getBatchSize <em>Batch Size</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventStoragePostgresImpl#getPostgresDriverBundles <em>Postgres Driver Bundles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventStoragePostgresImpl extends AbstractEventStorageJdbcImpl implements EventStoragePostgres
{
    /**
     * The default value of the '{@link #getBatchSize() <em>Batch Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBatchSize()
     * @generated
     * @ordered
     */
    protected static final Integer BATCH_SIZE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBatchSize() <em>Batch Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBatchSize()
     * @generated
     * @ordered
     */
    protected Integer batchSize = BATCH_SIZE_EDEFAULT;

    /**
     * The cached value of the '{@link #getPostgresDriverBundles() <em>Postgres Driver Bundles</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPostgresDriverBundles()
     * @generated
     * @ordered
     */
    protected EList<String> postgresDriverBundles;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventStoragePostgresImpl ()
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
        return OsgiPackage.Literals.EVENT_STORAGE_POSTGRES;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getBatchSize ()
    {
        return batchSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBatchSize ( Integer newBatchSize )
    {
        Integer oldBatchSize = batchSize;
        batchSize = newBatchSize;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_STORAGE_POSTGRES__BATCH_SIZE, oldBatchSize, batchSize ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getPostgresDriverBundles ()
    {
        if ( postgresDriverBundles == null )
        {
            postgresDriverBundles = new EDataTypeUniqueEList<String> ( String.class, this, OsgiPackage.EVENT_STORAGE_POSTGRES__POSTGRES_DRIVER_BUNDLES );
        }
        return postgresDriverBundles;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getJdbcDriverName ()
    {
        return "org.postgresql.Driver";
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getDriverBundles ()
    {
        return getPostgresDriverBundles ();
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
            case OsgiPackage.EVENT_STORAGE_POSTGRES__BATCH_SIZE:
                return getBatchSize ();
            case OsgiPackage.EVENT_STORAGE_POSTGRES__POSTGRES_DRIVER_BUNDLES:
                return getPostgresDriverBundles ();
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
            case OsgiPackage.EVENT_STORAGE_POSTGRES__BATCH_SIZE:
                setBatchSize ( (Integer)newValue );
                return;
            case OsgiPackage.EVENT_STORAGE_POSTGRES__POSTGRES_DRIVER_BUNDLES:
                getPostgresDriverBundles ().clear ();
                getPostgresDriverBundles ().addAll ( (Collection<? extends String>)newValue );
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
            case OsgiPackage.EVENT_STORAGE_POSTGRES__BATCH_SIZE:
                setBatchSize ( BATCH_SIZE_EDEFAULT );
                return;
            case OsgiPackage.EVENT_STORAGE_POSTGRES__POSTGRES_DRIVER_BUNDLES:
                getPostgresDriverBundles ().clear ();
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
            case OsgiPackage.EVENT_STORAGE_POSTGRES__BATCH_SIZE:
                return BATCH_SIZE_EDEFAULT == null ? batchSize != null : !BATCH_SIZE_EDEFAULT.equals ( batchSize );
            case OsgiPackage.EVENT_STORAGE_POSTGRES__POSTGRES_DRIVER_BUNDLES:
                return postgresDriverBundles != null && !postgresDriverBundles.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case OsgiPackage.EVENT_STORAGE_POSTGRES___GET_JDBC_DRIVER_NAME:
                return getJdbcDriverName ();
            case OsgiPackage.EVENT_STORAGE_POSTGRES___GET_DRIVER_BUNDLES:
                return getDriverBundles ();
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( " (batchSize: " ); //$NON-NLS-1$
        result.append ( batchSize );
        result.append ( ", postgresDriverBundles: " ); //$NON-NLS-1$
        result.append ( postgresDriverBundles );
        result.append ( ')' );
        return result.toString ();
    }

} //EventStoragePostgresImpl
