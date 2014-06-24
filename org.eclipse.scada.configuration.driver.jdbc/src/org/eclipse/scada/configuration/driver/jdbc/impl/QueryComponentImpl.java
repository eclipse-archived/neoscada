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
package org.eclipse.scada.configuration.driver.jdbc.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.component.impl.MasterComponentImpl;

import org.eclipse.scada.configuration.driver.jdbc.ColumnMapping;
import org.eclipse.scada.configuration.driver.jdbc.JdbcDriver;
import org.eclipse.scada.configuration.driver.jdbc.JdbcPackage;
import org.eclipse.scada.configuration.driver.jdbc.QueryBase;
import org.eclipse.scada.configuration.driver.jdbc.QueryComponent;

import org.eclipse.scada.configuration.infrastructure.DatabaseSettings;
import org.eclipse.scada.configuration.world.osgi.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl#getSql <em>Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl#getDatabase <em>Database</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl#getQueryTimeout <em>Query Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl#getRunsOn <em>Runs On</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl#getDefaultCustomizationTags <em>Default Customization Tags</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl#getDefaultDataType <em>Default Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryComponentImpl extends MasterComponentImpl implements QueryComponent
{
    /**
     * The default value of the '{@link #getSql() <em>Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSql()
     * @generated
     * @ordered
     */
    protected static final String SQL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSql() <em>Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSql()
     * @generated
     * @ordered
     */
    protected String sql = SQL_EDEFAULT;

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
     * The default value of the '{@link #getQueryTimeout() <em>Query Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQueryTimeout()
     * @generated
     * @ordered
     */
    protected static final Integer QUERY_TIMEOUT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQueryTimeout() <em>Query Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQueryTimeout()
     * @generated
     * @ordered
     */
    protected Integer queryTimeout = QUERY_TIMEOUT_EDEFAULT;

    /**
     * The cached value of the '{@link #getRunsOn() <em>Runs On</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRunsOn()
     * @generated
     * @ordered
     */
    protected JdbcDriver runsOn;

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
     * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappings()
     * @generated
     * @ordered
     */
    protected EList<ColumnMapping> mappings;

    /**
     * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected static final int PERIOD_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected int period = PERIOD_EDEFAULT;

    /**
     * The cached value of the '{@link #getDefaultCustomizationTags() <em>Default Customization Tags</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultCustomizationTags()
     * @generated
     * @ordered
     */
    protected EList<String> defaultCustomizationTags;

    /**
     * The default value of the '{@link #getDefaultDataType() <em>Default Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultDataType()
     * @generated
     * @ordered
     */
    protected static final DataType DEFAULT_DATA_TYPE_EDEFAULT = DataType.VARIANT;

    /**
     * The cached value of the '{@link #getDefaultDataType() <em>Default Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultDataType()
     * @generated
     * @ordered
     */
    protected DataType defaultDataType = DEFAULT_DATA_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected QueryComponentImpl ()
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
        return JdbcPackage.Literals.QUERY_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSql ()
    {
        return sql;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSql ( String newSql )
    {
        String oldSql = sql;
        sql = newSql;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.QUERY_COMPONENT__SQL, oldSql, sql ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, JdbcPackage.QUERY_COMPONENT__DATABASE, oldDatabase, database ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.QUERY_COMPONENT__DATABASE, oldDatabase, database ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getQueryTimeout ()
    {
        return queryTimeout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQueryTimeout ( Integer newQueryTimeout )
    {
        Integer oldQueryTimeout = queryTimeout;
        queryTimeout = newQueryTimeout;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.QUERY_COMPONENT__QUERY_TIMEOUT, oldQueryTimeout, queryTimeout ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JdbcDriver getRunsOn ()
    {
        if ( runsOn != null && runsOn.eIsProxy () )
        {
            InternalEObject oldRunsOn = (InternalEObject)runsOn;
            runsOn = (JdbcDriver)eResolveProxy ( oldRunsOn );
            if ( runsOn != oldRunsOn )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, JdbcPackage.QUERY_COMPONENT__RUNS_ON, oldRunsOn, runsOn ) );
            }
        }
        return runsOn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JdbcDriver basicGetRunsOn ()
    {
        return runsOn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRunsOn ( JdbcDriver newRunsOn )
    {
        JdbcDriver oldRunsOn = runsOn;
        runsOn = newRunsOn;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.QUERY_COMPONENT__RUNS_ON, oldRunsOn, runsOn ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.QUERY_COMPONENT__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ColumnMapping> getMappings ()
    {
        if ( mappings == null )
        {
            mappings = new EObjectContainmentEList.Resolving<ColumnMapping> ( ColumnMapping.class, this, JdbcPackage.QUERY_COMPONENT__MAPPINGS );
        }
        return mappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPeriod ()
    {
        return period;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPeriod ( int newPeriod )
    {
        int oldPeriod = period;
        period = newPeriod;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.QUERY_COMPONENT__PERIOD, oldPeriod, period ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getDefaultCustomizationTags ()
    {
        if ( defaultCustomizationTags == null )
        {
            defaultCustomizationTags = new EDataTypeUniqueEList<String> ( String.class, this, JdbcPackage.QUERY_COMPONENT__DEFAULT_CUSTOMIZATION_TAGS );
        }
        return defaultCustomizationTags;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataType getDefaultDataType ()
    {
        return defaultDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultDataType ( DataType newDefaultDataType )
    {
        DataType oldDefaultDataType = defaultDataType;
        defaultDataType = newDefaultDataType == null ? DEFAULT_DATA_TYPE_EDEFAULT : newDefaultDataType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.QUERY_COMPONENT__DEFAULT_DATA_TYPE, oldDefaultDataType, defaultDataType ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case JdbcPackage.QUERY_COMPONENT__MAPPINGS:
                return ( (InternalEList<?>)getMappings () ).basicRemove ( otherEnd, msgs );
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
            case JdbcPackage.QUERY_COMPONENT__SQL:
                return getSql ();
            case JdbcPackage.QUERY_COMPONENT__DATABASE:
                if ( resolve )
                    return getDatabase ();
                return basicGetDatabase ();
            case JdbcPackage.QUERY_COMPONENT__QUERY_TIMEOUT:
                return getQueryTimeout ();
            case JdbcPackage.QUERY_COMPONENT__RUNS_ON:
                if ( resolve )
                    return getRunsOn ();
                return basicGetRunsOn ();
            case JdbcPackage.QUERY_COMPONENT__NAME:
                return getName ();
            case JdbcPackage.QUERY_COMPONENT__MAPPINGS:
                return getMappings ();
            case JdbcPackage.QUERY_COMPONENT__PERIOD:
                return getPeriod ();
            case JdbcPackage.QUERY_COMPONENT__DEFAULT_CUSTOMIZATION_TAGS:
                return getDefaultCustomizationTags ();
            case JdbcPackage.QUERY_COMPONENT__DEFAULT_DATA_TYPE:
                return getDefaultDataType ();
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
            case JdbcPackage.QUERY_COMPONENT__SQL:
                setSql ( (String)newValue );
                return;
            case JdbcPackage.QUERY_COMPONENT__DATABASE:
                setDatabase ( (DatabaseSettings)newValue );
                return;
            case JdbcPackage.QUERY_COMPONENT__QUERY_TIMEOUT:
                setQueryTimeout ( (Integer)newValue );
                return;
            case JdbcPackage.QUERY_COMPONENT__RUNS_ON:
                setRunsOn ( (JdbcDriver)newValue );
                return;
            case JdbcPackage.QUERY_COMPONENT__NAME:
                setName ( (String)newValue );
                return;
            case JdbcPackage.QUERY_COMPONENT__MAPPINGS:
                getMappings ().clear ();
                getMappings ().addAll ( (Collection<? extends ColumnMapping>)newValue );
                return;
            case JdbcPackage.QUERY_COMPONENT__PERIOD:
                setPeriod ( (Integer)newValue );
                return;
            case JdbcPackage.QUERY_COMPONENT__DEFAULT_CUSTOMIZATION_TAGS:
                getDefaultCustomizationTags ().clear ();
                getDefaultCustomizationTags ().addAll ( (Collection<? extends String>)newValue );
                return;
            case JdbcPackage.QUERY_COMPONENT__DEFAULT_DATA_TYPE:
                setDefaultDataType ( (DataType)newValue );
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
            case JdbcPackage.QUERY_COMPONENT__SQL:
                setSql ( SQL_EDEFAULT );
                return;
            case JdbcPackage.QUERY_COMPONENT__DATABASE:
                setDatabase ( (DatabaseSettings)null );
                return;
            case JdbcPackage.QUERY_COMPONENT__QUERY_TIMEOUT:
                setQueryTimeout ( QUERY_TIMEOUT_EDEFAULT );
                return;
            case JdbcPackage.QUERY_COMPONENT__RUNS_ON:
                setRunsOn ( (JdbcDriver)null );
                return;
            case JdbcPackage.QUERY_COMPONENT__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case JdbcPackage.QUERY_COMPONENT__MAPPINGS:
                getMappings ().clear ();
                return;
            case JdbcPackage.QUERY_COMPONENT__PERIOD:
                setPeriod ( PERIOD_EDEFAULT );
                return;
            case JdbcPackage.QUERY_COMPONENT__DEFAULT_CUSTOMIZATION_TAGS:
                getDefaultCustomizationTags ().clear ();
                return;
            case JdbcPackage.QUERY_COMPONENT__DEFAULT_DATA_TYPE:
                setDefaultDataType ( DEFAULT_DATA_TYPE_EDEFAULT );
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
            case JdbcPackage.QUERY_COMPONENT__SQL:
                return SQL_EDEFAULT == null ? sql != null : !SQL_EDEFAULT.equals ( sql );
            case JdbcPackage.QUERY_COMPONENT__DATABASE:
                return database != null;
            case JdbcPackage.QUERY_COMPONENT__QUERY_TIMEOUT:
                return QUERY_TIMEOUT_EDEFAULT == null ? queryTimeout != null : !QUERY_TIMEOUT_EDEFAULT.equals ( queryTimeout );
            case JdbcPackage.QUERY_COMPONENT__RUNS_ON:
                return runsOn != null;
            case JdbcPackage.QUERY_COMPONENT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case JdbcPackage.QUERY_COMPONENT__MAPPINGS:
                return mappings != null && !mappings.isEmpty ();
            case JdbcPackage.QUERY_COMPONENT__PERIOD:
                return period != PERIOD_EDEFAULT;
            case JdbcPackage.QUERY_COMPONENT__DEFAULT_CUSTOMIZATION_TAGS:
                return defaultCustomizationTags != null && !defaultCustomizationTags.isEmpty ();
            case JdbcPackage.QUERY_COMPONENT__DEFAULT_DATA_TYPE:
                return defaultDataType != DEFAULT_DATA_TYPE_EDEFAULT;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID ( int derivedFeatureID, Class<?> baseClass )
    {
        if ( baseClass == QueryBase.class )
        {
            switch ( derivedFeatureID )
            {
                case JdbcPackage.QUERY_COMPONENT__SQL:
                    return JdbcPackage.QUERY_BASE__SQL;
                case JdbcPackage.QUERY_COMPONENT__DATABASE:
                    return JdbcPackage.QUERY_BASE__DATABASE;
                case JdbcPackage.QUERY_COMPONENT__QUERY_TIMEOUT:
                    return JdbcPackage.QUERY_BASE__QUERY_TIMEOUT;
                case JdbcPackage.QUERY_COMPONENT__RUNS_ON:
                    return JdbcPackage.QUERY_BASE__RUNS_ON;
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID ( derivedFeatureID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID ( int baseFeatureID, Class<?> baseClass )
    {
        if ( baseClass == QueryBase.class )
        {
            switch ( baseFeatureID )
            {
                case JdbcPackage.QUERY_BASE__SQL:
                    return JdbcPackage.QUERY_COMPONENT__SQL;
                case JdbcPackage.QUERY_BASE__DATABASE:
                    return JdbcPackage.QUERY_COMPONENT__DATABASE;
                case JdbcPackage.QUERY_BASE__QUERY_TIMEOUT:
                    return JdbcPackage.QUERY_COMPONENT__QUERY_TIMEOUT;
                case JdbcPackage.QUERY_BASE__RUNS_ON:
                    return JdbcPackage.QUERY_COMPONENT__RUNS_ON;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID ( baseFeatureID, baseClass );
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
        result.append ( " (sql: " ); //$NON-NLS-1$
        result.append ( sql );
        result.append ( ", queryTimeout: " ); //$NON-NLS-1$
        result.append ( queryTimeout );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", period: " ); //$NON-NLS-1$
        result.append ( period );
        result.append ( ", defaultCustomizationTags: " ); //$NON-NLS-1$
        result.append ( defaultCustomizationTags );
        result.append ( ", defaultDataType: " ); //$NON-NLS-1$
        result.append ( defaultDataType );
        result.append ( ')' );
        return result.toString ();
    }

} //QueryComponentImpl
