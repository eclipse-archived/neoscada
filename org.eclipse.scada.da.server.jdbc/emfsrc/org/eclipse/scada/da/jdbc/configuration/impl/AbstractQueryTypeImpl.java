/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.jdbc.configuration.impl;

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
import org.eclipse.scada.da.jdbc.configuration.AbstractQueryType;
import org.eclipse.scada.da.jdbc.configuration.ColumnMappingType;
import org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Query Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.AbstractQueryTypeImpl#getSql <em>Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.AbstractQueryTypeImpl#getColumnMapping <em>Column Mapping</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.AbstractQueryTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.AbstractQueryTypeImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.AbstractQueryTypeImpl#getSql1 <em>Sql1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractQueryTypeImpl extends MinimalEObjectImpl.Container implements AbstractQueryType
{
    //$NON-NLS-1$

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
     * The cached value of the '{@link #getColumnMapping() <em>Column Mapping</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumnMapping()
     * @generated
     * @ordered
     */
    protected EList<ColumnMappingType> columnMapping;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

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
     * This is true if the Period attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean periodESet;

    /**
     * The default value of the '{@link #getSql1() <em>Sql1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSql1()
     * @generated
     * @ordered
     */
    protected static final String SQL1_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSql1() <em>Sql1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSql1()
     * @generated
     * @ordered
     */
    protected String sql1 = SQL1_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractQueryTypeImpl ()
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
        return ConfigurationPackage.Literals.ABSTRACT_QUERY_TYPE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.ABSTRACT_QUERY_TYPE__SQL, oldSql, sql ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ColumnMappingType> getColumnMapping ()
    {
        if ( columnMapping == null )
        {
            columnMapping = new EObjectContainmentEList<ColumnMappingType> ( ColumnMappingType.class, this, ConfigurationPackage.ABSTRACT_QUERY_TYPE__COLUMN_MAPPING );
        }
        return columnMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.ABSTRACT_QUERY_TYPE__ID, oldId, id ) );
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
        boolean oldPeriodESet = periodESet;
        periodESet = true;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.ABSTRACT_QUERY_TYPE__PERIOD, oldPeriod, period, !oldPeriodESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetPeriod ()
    {
        int oldPeriod = period;
        boolean oldPeriodESet = periodESet;
        period = PERIOD_EDEFAULT;
        periodESet = false;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.UNSET, ConfigurationPackage.ABSTRACT_QUERY_TYPE__PERIOD, oldPeriod, PERIOD_EDEFAULT, oldPeriodESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetPeriod ()
    {
        return periodESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSql1 ()
    {
        return sql1;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSql1 ( String newSql1 )
    {
        String oldSql1 = sql1;
        sql1 = newSql1;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.ABSTRACT_QUERY_TYPE__SQL1, oldSql1, sql1 ) );
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
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__COLUMN_MAPPING:
                return ( (InternalEList<?>)getColumnMapping () ).basicRemove ( otherEnd, msgs );
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
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__SQL:
                return getSql ();
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__COLUMN_MAPPING:
                return getColumnMapping ();
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__ID:
                return getId ();
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__PERIOD:
                return getPeriod ();
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__SQL1:
                return getSql1 ();
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
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__SQL:
                setSql ( (String)newValue );
                return;
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__COLUMN_MAPPING:
                getColumnMapping ().clear ();
                getColumnMapping ().addAll ( (Collection<? extends ColumnMappingType>)newValue );
                return;
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__ID:
                setId ( (String)newValue );
                return;
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__PERIOD:
                setPeriod ( (Integer)newValue );
                return;
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__SQL1:
                setSql1 ( (String)newValue );
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
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__SQL:
                setSql ( SQL_EDEFAULT );
                return;
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__COLUMN_MAPPING:
                getColumnMapping ().clear ();
                return;
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__ID:
                setId ( ID_EDEFAULT );
                return;
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__PERIOD:
                unsetPeriod ();
                return;
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__SQL1:
                setSql1 ( SQL1_EDEFAULT );
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
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__SQL:
                return SQL_EDEFAULT == null ? sql != null : !SQL_EDEFAULT.equals ( sql );
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__COLUMN_MAPPING:
                return columnMapping != null && !columnMapping.isEmpty ();
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__PERIOD:
                return isSetPeriod ();
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE__SQL1:
                return SQL1_EDEFAULT == null ? sql1 != null : !SQL1_EDEFAULT.equals ( sql1 );
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
        result.append ( " (sql: " ); //$NON-NLS-1$
        result.append ( sql );
        result.append ( ", id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ", period: " ); //$NON-NLS-1$
        if ( periodESet )
            result.append ( period );
        else
            result.append ( "<unset>" ); //$NON-NLS-1$
        result.append ( ", sql1: " ); //$NON-NLS-1$
        result.append ( sql1 );
        result.append ( ')' );
        return result.toString ();
    }

} //AbstractQueryTypeImpl
