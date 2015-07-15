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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.world.DatabaseSettings;

import org.eclipse.scada.configuration.world.osgi.EventInjector;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Injector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorImpl#getDatabase <em>Database</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorImpl#getLoopDelay <em>Loop Delay</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorImpl#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorImpl#getReplicationSchema <em>Replication Schema</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorImpl#isDeleteFailed <em>Delete Failed</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EventInjectorImpl extends MinimalEObjectImpl.Container implements EventInjector
{
    /**
     * The cached value of the '{@link #getDatabase() <em>Database</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabase()
     * @generated
     * @ordered
     */
    protected DatabaseSettings database;

    /**
     * The default value of the '{@link #getLoopDelay() <em>Loop Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLoopDelay()
     * @generated
     * @ordered
     */
    protected static final Integer LOOP_DELAY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLoopDelay() <em>Loop Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLoopDelay()
     * @generated
     * @ordered
     */
    protected Integer loopDelay = LOOP_DELAY_EDEFAULT;

    /**
     * The default value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceName()
     * @generated
     * @ordered
     */
    protected static final String INSTANCE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceName()
     * @generated
     * @ordered
     */
    protected String instanceName = INSTANCE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getSchema() <em>Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSchema()
     * @generated
     * @ordered
     */
    protected static final String SCHEMA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSchema() <em>Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSchema()
     * @generated
     * @ordered
     */
    protected String schema = SCHEMA_EDEFAULT;

    /**
     * The default value of the '{@link #getReplicationSchema() <em>Replication Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReplicationSchema()
     * @generated
     * @ordered
     */
    protected static final String REPLICATION_SCHEMA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getReplicationSchema() <em>Replication Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReplicationSchema()
     * @generated
     * @ordered
     */
    protected String replicationSchema = REPLICATION_SCHEMA_EDEFAULT;

    /**
     * The default value of the '{@link #isDeleteFailed() <em>Delete Failed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleteFailed()
     * @generated
     * @ordered
     */
    protected static final boolean DELETE_FAILED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDeleteFailed() <em>Delete Failed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleteFailed()
     * @generated
     * @ordered
     */
    protected boolean deleteFailed = DELETE_FAILED_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventInjectorImpl ()
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
        return OsgiPackage.Literals.EVENT_INJECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatabaseSettings getDatabase ()
    {
        if ( database != null && database.eIsProxy () )
        {
            InternalEObject oldDatabase = (InternalEObject)database;
            database = (DatabaseSettings)eResolveProxy ( oldDatabase );
            if ( database != oldDatabase )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.EVENT_INJECTOR__DATABASE, oldDatabase, database ) );
            }
        }
        return database;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatabaseSettings basicGetDatabase ()
    {
        return database;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDatabase ( DatabaseSettings newDatabase )
    {
        DatabaseSettings oldDatabase = database;
        database = newDatabase;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR__DATABASE, oldDatabase, database ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getLoopDelay ()
    {
        return loopDelay;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLoopDelay ( Integer newLoopDelay )
    {
        Integer oldLoopDelay = loopDelay;
        loopDelay = newLoopDelay;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR__LOOP_DELAY, oldLoopDelay, loopDelay ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInstanceName ()
    {
        return instanceName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInstanceName ( String newInstanceName )
    {
        String oldInstanceName = instanceName;
        instanceName = newInstanceName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR__INSTANCE_NAME, oldInstanceName, instanceName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSchema ()
    {
        return schema;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSchema ( String newSchema )
    {
        String oldSchema = schema;
        schema = newSchema;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR__SCHEMA, oldSchema, schema ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getReplicationSchema ()
    {
        return replicationSchema;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReplicationSchema ( String newReplicationSchema )
    {
        String oldReplicationSchema = replicationSchema;
        replicationSchema = newReplicationSchema;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR__REPLICATION_SCHEMA, oldReplicationSchema, replicationSchema ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDeleteFailed ()
    {
        return deleteFailed;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeleteFailed ( boolean newDeleteFailed )
    {
        boolean oldDeleteFailed = deleteFailed;
        deleteFailed = newDeleteFailed;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR__DELETE_FAILED, oldDeleteFailed, deleteFailed ) );
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
            case OsgiPackage.EVENT_INJECTOR__DATABASE:
                if ( resolve )
                    return getDatabase ();
                return basicGetDatabase ();
            case OsgiPackage.EVENT_INJECTOR__LOOP_DELAY:
                return getLoopDelay ();
            case OsgiPackage.EVENT_INJECTOR__INSTANCE_NAME:
                return getInstanceName ();
            case OsgiPackage.EVENT_INJECTOR__SCHEMA:
                return getSchema ();
            case OsgiPackage.EVENT_INJECTOR__REPLICATION_SCHEMA:
                return getReplicationSchema ();
            case OsgiPackage.EVENT_INJECTOR__DELETE_FAILED:
                return isDeleteFailed ();
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
            case OsgiPackage.EVENT_INJECTOR__DATABASE:
                setDatabase ( (DatabaseSettings)newValue );
                return;
            case OsgiPackage.EVENT_INJECTOR__LOOP_DELAY:
                setLoopDelay ( (Integer)newValue );
                return;
            case OsgiPackage.EVENT_INJECTOR__INSTANCE_NAME:
                setInstanceName ( (String)newValue );
                return;
            case OsgiPackage.EVENT_INJECTOR__SCHEMA:
                setSchema ( (String)newValue );
                return;
            case OsgiPackage.EVENT_INJECTOR__REPLICATION_SCHEMA:
                setReplicationSchema ( (String)newValue );
                return;
            case OsgiPackage.EVENT_INJECTOR__DELETE_FAILED:
                setDeleteFailed ( (Boolean)newValue );
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
            case OsgiPackage.EVENT_INJECTOR__DATABASE:
                setDatabase ( (DatabaseSettings)null );
                return;
            case OsgiPackage.EVENT_INJECTOR__LOOP_DELAY:
                setLoopDelay ( LOOP_DELAY_EDEFAULT );
                return;
            case OsgiPackage.EVENT_INJECTOR__INSTANCE_NAME:
                setInstanceName ( INSTANCE_NAME_EDEFAULT );
                return;
            case OsgiPackage.EVENT_INJECTOR__SCHEMA:
                setSchema ( SCHEMA_EDEFAULT );
                return;
            case OsgiPackage.EVENT_INJECTOR__REPLICATION_SCHEMA:
                setReplicationSchema ( REPLICATION_SCHEMA_EDEFAULT );
                return;
            case OsgiPackage.EVENT_INJECTOR__DELETE_FAILED:
                setDeleteFailed ( DELETE_FAILED_EDEFAULT );
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
            case OsgiPackage.EVENT_INJECTOR__DATABASE:
                return database != null;
            case OsgiPackage.EVENT_INJECTOR__LOOP_DELAY:
                return LOOP_DELAY_EDEFAULT == null ? loopDelay != null : !LOOP_DELAY_EDEFAULT.equals ( loopDelay );
            case OsgiPackage.EVENT_INJECTOR__INSTANCE_NAME:
                return INSTANCE_NAME_EDEFAULT == null ? instanceName != null : !INSTANCE_NAME_EDEFAULT.equals ( instanceName );
            case OsgiPackage.EVENT_INJECTOR__SCHEMA:
                return SCHEMA_EDEFAULT == null ? schema != null : !SCHEMA_EDEFAULT.equals ( schema );
            case OsgiPackage.EVENT_INJECTOR__REPLICATION_SCHEMA:
                return REPLICATION_SCHEMA_EDEFAULT == null ? replicationSchema != null : !REPLICATION_SCHEMA_EDEFAULT.equals ( replicationSchema );
            case OsgiPackage.EVENT_INJECTOR__DELETE_FAILED:
                return deleteFailed != DELETE_FAILED_EDEFAULT;
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
        result.append ( " (loopDelay: " ); //$NON-NLS-1$
        result.append ( loopDelay );
        result.append ( ", instanceName: " ); //$NON-NLS-1$
        result.append ( instanceName );
        result.append ( ", schema: " ); //$NON-NLS-1$
        result.append ( schema );
        result.append ( ", replicationSchema: " ); //$NON-NLS-1$
        result.append ( replicationSchema );
        result.append ( ", deleteFailed: " ); //$NON-NLS-1$
        result.append ( deleteFailed );
        result.append ( ')' );
        return result.toString ();
    }

} //EventInjectorImpl
