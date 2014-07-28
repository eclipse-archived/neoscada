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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.DatabaseSettings;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.PullEvents;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pull Events</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getJobInterval <em>Job Interval</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getCustomSelectSql <em>Custom Select Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getCustomDeleteSql <em>Custom Delete Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getDatabase <em>Database</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PullEventsImpl extends MinimalEObjectImpl.Container implements
        PullEvents
{
    /**
     * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getJobInterval() <em>Job Interval</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJobInterval()
     * @generated
     * @ordered
     */
    protected static final Integer JOB_INTERVAL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getJobInterval() <em>Job Interval</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJobInterval()
     * @generated
     * @ordered
     */
    protected Integer jobInterval = JOB_INTERVAL_EDEFAULT;

    /**
     * The default value of the '{@link #getCustomSelectSql() <em>Custom Select Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomSelectSql()
     * @generated
     * @ordered
     */
    protected static final String CUSTOM_SELECT_SQL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCustomSelectSql() <em>Custom Select Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomSelectSql()
     * @generated
     * @ordered
     */
    protected String customSelectSql = CUSTOM_SELECT_SQL_EDEFAULT;

    /**
     * The default value of the '{@link #getCustomDeleteSql() <em>Custom Delete Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomDeleteSql()
     * @generated
     * @ordered
     */
    protected static final String CUSTOM_DELETE_SQL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCustomDeleteSql() <em>Custom Delete Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomDeleteSql()
     * @generated
     * @ordered
     */
    protected String customDeleteSql = CUSTOM_DELETE_SQL_EDEFAULT;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PullEventsImpl ()
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
        return OsgiPackage.Literals.PULL_EVENTS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getShortDescription ()
    {
        return shortDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShortDescription ( String newShortDescription )
    {
        String oldShortDescription = shortDescription;
        shortDescription = newShortDescription;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.PULL_EVENTS__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.PULL_EVENTS__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getJobInterval ()
    {
        return jobInterval;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setJobInterval ( Integer newJobInterval )
    {
        Integer oldJobInterval = jobInterval;
        jobInterval = newJobInterval;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.PULL_EVENTS__JOB_INTERVAL, oldJobInterval, jobInterval ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCustomSelectSql ()
    {
        return customSelectSql;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCustomSelectSql ( String newCustomSelectSql )
    {
        String oldCustomSelectSql = customSelectSql;
        customSelectSql = newCustomSelectSql;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.PULL_EVENTS__CUSTOM_SELECT_SQL, oldCustomSelectSql, customSelectSql ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCustomDeleteSql ()
    {
        return customDeleteSql;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCustomDeleteSql ( String newCustomDeleteSql )
    {
        String oldCustomDeleteSql = customDeleteSql;
        customDeleteSql = newCustomDeleteSql;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.PULL_EVENTS__CUSTOM_DELETE_SQL, oldCustomDeleteSql, customDeleteSql ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.PULL_EVENTS__DATABASE, oldDatabase, database ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.PULL_EVENTS__DATABASE, oldDatabase, database ) );
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
            case OsgiPackage.PULL_EVENTS__SHORT_DESCRIPTION:
                return getShortDescription ();
            case OsgiPackage.PULL_EVENTS__NAME:
                return getName ();
            case OsgiPackage.PULL_EVENTS__JOB_INTERVAL:
                return getJobInterval ();
            case OsgiPackage.PULL_EVENTS__CUSTOM_SELECT_SQL:
                return getCustomSelectSql ();
            case OsgiPackage.PULL_EVENTS__CUSTOM_DELETE_SQL:
                return getCustomDeleteSql ();
            case OsgiPackage.PULL_EVENTS__DATABASE:
                if ( resolve )
                    return getDatabase ();
                return basicGetDatabase ();
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
            case OsgiPackage.PULL_EVENTS__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case OsgiPackage.PULL_EVENTS__NAME:
                setName ( (String)newValue );
                return;
            case OsgiPackage.PULL_EVENTS__JOB_INTERVAL:
                setJobInterval ( (Integer)newValue );
                return;
            case OsgiPackage.PULL_EVENTS__CUSTOM_SELECT_SQL:
                setCustomSelectSql ( (String)newValue );
                return;
            case OsgiPackage.PULL_EVENTS__CUSTOM_DELETE_SQL:
                setCustomDeleteSql ( (String)newValue );
                return;
            case OsgiPackage.PULL_EVENTS__DATABASE:
                setDatabase ( (DatabaseSettings)newValue );
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
            case OsgiPackage.PULL_EVENTS__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case OsgiPackage.PULL_EVENTS__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case OsgiPackage.PULL_EVENTS__JOB_INTERVAL:
                setJobInterval ( JOB_INTERVAL_EDEFAULT );
                return;
            case OsgiPackage.PULL_EVENTS__CUSTOM_SELECT_SQL:
                setCustomSelectSql ( CUSTOM_SELECT_SQL_EDEFAULT );
                return;
            case OsgiPackage.PULL_EVENTS__CUSTOM_DELETE_SQL:
                setCustomDeleteSql ( CUSTOM_DELETE_SQL_EDEFAULT );
                return;
            case OsgiPackage.PULL_EVENTS__DATABASE:
                setDatabase ( (DatabaseSettings)null );
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
            case OsgiPackage.PULL_EVENTS__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case OsgiPackage.PULL_EVENTS__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case OsgiPackage.PULL_EVENTS__JOB_INTERVAL:
                return JOB_INTERVAL_EDEFAULT == null ? jobInterval != null : !JOB_INTERVAL_EDEFAULT.equals ( jobInterval );
            case OsgiPackage.PULL_EVENTS__CUSTOM_SELECT_SQL:
                return CUSTOM_SELECT_SQL_EDEFAULT == null ? customSelectSql != null : !CUSTOM_SELECT_SQL_EDEFAULT.equals ( customSelectSql );
            case OsgiPackage.PULL_EVENTS__CUSTOM_DELETE_SQL:
                return CUSTOM_DELETE_SQL_EDEFAULT == null ? customDeleteSql != null : !CUSTOM_DELETE_SQL_EDEFAULT.equals ( customDeleteSql );
            case OsgiPackage.PULL_EVENTS__DATABASE:
                return database != null;
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
        result.append ( " (shortDescription: " ); //$NON-NLS-1$
        result.append ( shortDescription );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", jobInterval: " ); //$NON-NLS-1$
        result.append ( jobInterval );
        result.append ( ", customSelectSql: " ); //$NON-NLS-1$
        result.append ( customSelectSql );
        result.append ( ", customDeleteSql: " ); //$NON-NLS-1$
        result.append ( customDeleteSql );
        result.append ( ')' );
        return result.toString ();
    }

} //PullEventsImpl
