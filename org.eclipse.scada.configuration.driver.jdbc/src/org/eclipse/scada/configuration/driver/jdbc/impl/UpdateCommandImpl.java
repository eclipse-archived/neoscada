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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.configuration.component.impl.SingleValueImpl;

import org.eclipse.scada.configuration.driver.jdbc.JdbcDriver;
import org.eclipse.scada.configuration.driver.jdbc.JdbcPackage;
import org.eclipse.scada.configuration.driver.jdbc.QueryBase;
import org.eclipse.scada.configuration.driver.jdbc.UpdateCommand;
import org.eclipse.scada.configuration.driver.jdbc.UpdateMapping;

import org.eclipse.scada.configuration.infrastructure.DatabaseSettings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.UpdateCommandImpl#getSql <em>Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.UpdateCommandImpl#getDatabase <em>Database</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.UpdateCommandImpl#getQueryTimeout <em>Query Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.UpdateCommandImpl#getRunsOn <em>Runs On</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.UpdateCommandImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UpdateCommandImpl extends SingleValueImpl implements UpdateCommand
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
     * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappings()
     * @generated
     * @ordered
     */
    protected EList<UpdateMapping> mappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UpdateCommandImpl ()
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
        return JdbcPackage.Literals.UPDATE_COMMAND;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.UPDATE_COMMAND__SQL, oldSql, sql ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, JdbcPackage.UPDATE_COMMAND__DATABASE, oldDatabase, database ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.UPDATE_COMMAND__DATABASE, oldDatabase, database ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.UPDATE_COMMAND__QUERY_TIMEOUT, oldQueryTimeout, queryTimeout ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, JdbcPackage.UPDATE_COMMAND__RUNS_ON, oldRunsOn, runsOn ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.UPDATE_COMMAND__RUNS_ON, oldRunsOn, runsOn ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<UpdateMapping> getMappings ()
    {
        if ( mappings == null )
        {
            mappings = new EObjectContainmentEList.Resolving<UpdateMapping> ( UpdateMapping.class, this, JdbcPackage.UPDATE_COMMAND__MAPPINGS );
        }
        return mappings;
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
            case JdbcPackage.UPDATE_COMMAND__MAPPINGS:
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
            case JdbcPackage.UPDATE_COMMAND__SQL:
                return getSql ();
            case JdbcPackage.UPDATE_COMMAND__DATABASE:
                if ( resolve )
                    return getDatabase ();
                return basicGetDatabase ();
            case JdbcPackage.UPDATE_COMMAND__QUERY_TIMEOUT:
                return getQueryTimeout ();
            case JdbcPackage.UPDATE_COMMAND__RUNS_ON:
                if ( resolve )
                    return getRunsOn ();
                return basicGetRunsOn ();
            case JdbcPackage.UPDATE_COMMAND__MAPPINGS:
                return getMappings ();
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
            case JdbcPackage.UPDATE_COMMAND__SQL:
                setSql ( (String)newValue );
                return;
            case JdbcPackage.UPDATE_COMMAND__DATABASE:
                setDatabase ( (DatabaseSettings)newValue );
                return;
            case JdbcPackage.UPDATE_COMMAND__QUERY_TIMEOUT:
                setQueryTimeout ( (Integer)newValue );
                return;
            case JdbcPackage.UPDATE_COMMAND__RUNS_ON:
                setRunsOn ( (JdbcDriver)newValue );
                return;
            case JdbcPackage.UPDATE_COMMAND__MAPPINGS:
                getMappings ().clear ();
                getMappings ().addAll ( (Collection<? extends UpdateMapping>)newValue );
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
            case JdbcPackage.UPDATE_COMMAND__SQL:
                setSql ( SQL_EDEFAULT );
                return;
            case JdbcPackage.UPDATE_COMMAND__DATABASE:
                setDatabase ( (DatabaseSettings)null );
                return;
            case JdbcPackage.UPDATE_COMMAND__QUERY_TIMEOUT:
                setQueryTimeout ( QUERY_TIMEOUT_EDEFAULT );
                return;
            case JdbcPackage.UPDATE_COMMAND__RUNS_ON:
                setRunsOn ( (JdbcDriver)null );
                return;
            case JdbcPackage.UPDATE_COMMAND__MAPPINGS:
                getMappings ().clear ();
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
            case JdbcPackage.UPDATE_COMMAND__SQL:
                return SQL_EDEFAULT == null ? sql != null : !SQL_EDEFAULT.equals ( sql );
            case JdbcPackage.UPDATE_COMMAND__DATABASE:
                return database != null;
            case JdbcPackage.UPDATE_COMMAND__QUERY_TIMEOUT:
                return QUERY_TIMEOUT_EDEFAULT == null ? queryTimeout != null : !QUERY_TIMEOUT_EDEFAULT.equals ( queryTimeout );
            case JdbcPackage.UPDATE_COMMAND__RUNS_ON:
                return runsOn != null;
            case JdbcPackage.UPDATE_COMMAND__MAPPINGS:
                return mappings != null && !mappings.isEmpty ();
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
                case JdbcPackage.UPDATE_COMMAND__SQL:
                    return JdbcPackage.QUERY_BASE__SQL;
                case JdbcPackage.UPDATE_COMMAND__DATABASE:
                    return JdbcPackage.QUERY_BASE__DATABASE;
                case JdbcPackage.UPDATE_COMMAND__QUERY_TIMEOUT:
                    return JdbcPackage.QUERY_BASE__QUERY_TIMEOUT;
                case JdbcPackage.UPDATE_COMMAND__RUNS_ON:
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
                    return JdbcPackage.UPDATE_COMMAND__SQL;
                case JdbcPackage.QUERY_BASE__DATABASE:
                    return JdbcPackage.UPDATE_COMMAND__DATABASE;
                case JdbcPackage.QUERY_BASE__QUERY_TIMEOUT:
                    return JdbcPackage.UPDATE_COMMAND__QUERY_TIMEOUT;
                case JdbcPackage.QUERY_BASE__RUNS_ON:
                    return JdbcPackage.UPDATE_COMMAND__RUNS_ON;
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
        result.append ( ')' );
        return result.toString ();
    }

} //UpdateCommandImpl
