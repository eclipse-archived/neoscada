/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Event Storage Jdbc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getJdbcProperties <em>Jdbc Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#isEnableReplication <em>Enable Replication</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getArchiveDays <em>Archive Days</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getCleanupPeriodSeconds <em>Cleanup Period Seconds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractEventStorageJdbcImpl extends
        MinimalEObjectImpl.Container implements AbstractEventStorageJdbc
{
    /**
     * The cached value of the '{@link #getJdbcProperties() <em>Jdbc Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJdbcProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> jdbcProperties;

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
     * The default value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceName()
     * @generated
     * @ordered
     */
    protected static final String INSTANCE_NAME_EDEFAULT = "default"; //$NON-NLS-1$

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
     * The default value of the '{@link #isEnableReplication() <em>Enable Replication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableReplication()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLE_REPLICATION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isEnableReplication() <em>Enable Replication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableReplication()
     * @generated
     * @ordered
     */
    protected boolean enableReplication = ENABLE_REPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #getArchiveDays() <em>Archive Days</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArchiveDays()
     * @generated
     * @ordered
     */
    protected static final Integer ARCHIVE_DAYS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getArchiveDays() <em>Archive Days</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArchiveDays()
     * @generated
     * @ordered
     */
    protected Integer archiveDays = ARCHIVE_DAYS_EDEFAULT;

    /**
     * The default value of the '{@link #getCleanupPeriodSeconds() <em>Cleanup Period Seconds</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCleanupPeriodSeconds()
     * @generated
     * @ordered
     */
    protected static final Integer CLEANUP_PERIOD_SECONDS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCleanupPeriodSeconds() <em>Cleanup Period Seconds</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCleanupPeriodSeconds()
     * @generated
     * @ordered
     */
    protected Integer cleanupPeriodSeconds = CLEANUP_PERIOD_SECONDS_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractEventStorageJdbcImpl ()
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
        return OsgiPackage.Literals.ABSTRACT_EVENT_STORAGE_JDBC;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getJdbcProperties ()
    {
        if ( jdbcProperties == null )
        {
            jdbcProperties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES );
        }
        return jdbcProperties;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA, oldSchema, schema ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME, oldInstanceName, instanceName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEnableReplication ()
    {
        return enableReplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnableReplication ( boolean newEnableReplication )
    {
        boolean oldEnableReplication = enableReplication;
        enableReplication = newEnableReplication;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION, oldEnableReplication, enableReplication ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getArchiveDays ()
    {
        return archiveDays;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setArchiveDays ( Integer newArchiveDays )
    {
        Integer oldArchiveDays = archiveDays;
        archiveDays = newArchiveDays;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS, oldArchiveDays, archiveDays ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getCleanupPeriodSeconds ()
    {
        return cleanupPeriodSeconds;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCleanupPeriodSeconds ( Integer newCleanupPeriodSeconds )
    {
        Integer oldCleanupPeriodSeconds = cleanupPeriodSeconds;
        cleanupPeriodSeconds = newCleanupPeriodSeconds;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS, oldCleanupPeriodSeconds, cleanupPeriodSeconds ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getJdbcDriverName ()
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getDriverBundles ()
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd,
            int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES:
                return ( (InternalEList<?>)getJdbcProperties () ).basicRemove ( otherEnd, msgs );
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
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES:
                return getJdbcProperties ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA:
                return getSchema ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME:
                return getInstanceName ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION:
                return isEnableReplication ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS:
                return getArchiveDays ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS:
                return getCleanupPeriodSeconds ();
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
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES:
                getJdbcProperties ().clear ();
                getJdbcProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA:
                setSchema ( (String)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME:
                setInstanceName ( (String)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION:
                setEnableReplication ( (Boolean)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS:
                setArchiveDays ( (Integer)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS:
                setCleanupPeriodSeconds ( (Integer)newValue );
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
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES:
                getJdbcProperties ().clear ();
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA:
                setSchema ( SCHEMA_EDEFAULT );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME:
                setInstanceName ( INSTANCE_NAME_EDEFAULT );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION:
                setEnableReplication ( ENABLE_REPLICATION_EDEFAULT );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS:
                setArchiveDays ( ARCHIVE_DAYS_EDEFAULT );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS:
                setCleanupPeriodSeconds ( CLEANUP_PERIOD_SECONDS_EDEFAULT );
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
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES:
                return jdbcProperties != null && !jdbcProperties.isEmpty ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA:
                return SCHEMA_EDEFAULT == null ? schema != null : !SCHEMA_EDEFAULT.equals ( schema );
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME:
                return INSTANCE_NAME_EDEFAULT == null ? instanceName != null : !INSTANCE_NAME_EDEFAULT.equals ( instanceName );
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION:
                return enableReplication != ENABLE_REPLICATION_EDEFAULT;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS:
                return ARCHIVE_DAYS_EDEFAULT == null ? archiveDays != null : !ARCHIVE_DAYS_EDEFAULT.equals ( archiveDays );
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS:
                return CLEANUP_PERIOD_SECONDS_EDEFAULT == null ? cleanupPeriodSeconds != null : !CLEANUP_PERIOD_SECONDS_EDEFAULT.equals ( cleanupPeriodSeconds );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments )
            throws InvocationTargetException
    {
        switch ( operationID )
        {
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC___GET_JDBC_DRIVER_NAME:
                return getJdbcDriverName ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC___GET_DRIVER_BUNDLES:
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
        result.append ( " (schema: " ); //$NON-NLS-1$
        result.append ( schema );
        result.append ( ", instanceName: " ); //$NON-NLS-1$
        result.append ( instanceName );
        result.append ( ", enableReplication: " ); //$NON-NLS-1$
        result.append ( enableReplication );
        result.append ( ", archiveDays: " ); //$NON-NLS-1$
        result.append ( archiveDays );
        result.append ( ", cleanupPeriodSeconds: " ); //$NON-NLS-1$
        result.append ( cleanupPeriodSeconds );
        result.append ( ')' );
        return result.toString ();
    }

} //AbstractEventStorageJdbcImpl
