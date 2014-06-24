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
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getJdbcDriverName <em>Jdbc Driver Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getJdbcProperties <em>Jdbc Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getJobInterval <em>Job Interval</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getCustomSelectSql <em>Custom Select Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl#getCustomDeleteSql <em>Custom Delete Sql</em>}</li>
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
     * The default value of the '{@link #getJdbcDriverName() <em>Jdbc Driver Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJdbcDriverName()
     * @generated
     * @ordered
     */
    protected static final String JDBC_DRIVER_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getJdbcDriverName() <em>Jdbc Driver Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJdbcDriverName()
     * @generated
     * @ordered
     */
    protected String jdbcDriverName = JDBC_DRIVER_NAME_EDEFAULT;

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
    public String getJdbcDriverName ()
    {
        return jdbcDriverName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setJdbcDriverName ( String newJdbcDriverName )
    {
        String oldJdbcDriverName = jdbcDriverName;
        jdbcDriverName = newJdbcDriverName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.PULL_EVENTS__JDBC_DRIVER_NAME, oldJdbcDriverName, jdbcDriverName ) );
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
            jdbcProperties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, OsgiPackage.PULL_EVENTS__JDBC_PROPERTIES );
        }
        return jdbcProperties;
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
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd,
            int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case OsgiPackage.PULL_EVENTS__JDBC_PROPERTIES:
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
            case OsgiPackage.PULL_EVENTS__SHORT_DESCRIPTION:
                return getShortDescription ();
            case OsgiPackage.PULL_EVENTS__NAME:
                return getName ();
            case OsgiPackage.PULL_EVENTS__JDBC_DRIVER_NAME:
                return getJdbcDriverName ();
            case OsgiPackage.PULL_EVENTS__JDBC_PROPERTIES:
                return getJdbcProperties ();
            case OsgiPackage.PULL_EVENTS__JOB_INTERVAL:
                return getJobInterval ();
            case OsgiPackage.PULL_EVENTS__CUSTOM_SELECT_SQL:
                return getCustomSelectSql ();
            case OsgiPackage.PULL_EVENTS__CUSTOM_DELETE_SQL:
                return getCustomDeleteSql ();
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
            case OsgiPackage.PULL_EVENTS__JDBC_DRIVER_NAME:
                setJdbcDriverName ( (String)newValue );
                return;
            case OsgiPackage.PULL_EVENTS__JDBC_PROPERTIES:
                getJdbcProperties ().clear ();
                getJdbcProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
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
            case OsgiPackage.PULL_EVENTS__JDBC_DRIVER_NAME:
                setJdbcDriverName ( JDBC_DRIVER_NAME_EDEFAULT );
                return;
            case OsgiPackage.PULL_EVENTS__JDBC_PROPERTIES:
                getJdbcProperties ().clear ();
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
            case OsgiPackage.PULL_EVENTS__JDBC_DRIVER_NAME:
                return JDBC_DRIVER_NAME_EDEFAULT == null ? jdbcDriverName != null : !JDBC_DRIVER_NAME_EDEFAULT.equals ( jdbcDriverName );
            case OsgiPackage.PULL_EVENTS__JDBC_PROPERTIES:
                return jdbcProperties != null && !jdbcProperties.isEmpty ();
            case OsgiPackage.PULL_EVENTS__JOB_INTERVAL:
                return JOB_INTERVAL_EDEFAULT == null ? jobInterval != null : !JOB_INTERVAL_EDEFAULT.equals ( jobInterval );
            case OsgiPackage.PULL_EVENTS__CUSTOM_SELECT_SQL:
                return CUSTOM_SELECT_SQL_EDEFAULT == null ? customSelectSql != null : !CUSTOM_SELECT_SQL_EDEFAULT.equals ( customSelectSql );
            case OsgiPackage.PULL_EVENTS__CUSTOM_DELETE_SQL:
                return CUSTOM_DELETE_SQL_EDEFAULT == null ? customDeleteSql != null : !CUSTOM_DELETE_SQL_EDEFAULT.equals ( customDeleteSql );
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
        result.append ( ", jdbcDriverName: " ); //$NON-NLS-1$
        result.append ( jdbcDriverName );
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
