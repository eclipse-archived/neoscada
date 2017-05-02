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

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.configuration.world.osgi.EventInjectorJdbc;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Injector Jdbc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorJdbcImpl#getSelectSql <em>Select Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorJdbcImpl#getDeleteSql <em>Delete Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.EventInjectorJdbcImpl#getExistsSql <em>Exists Sql</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventInjectorJdbcImpl extends EventInjectorImpl implements EventInjectorJdbc
{
    /**
     * The default value of the '{@link #getSelectSql() <em>Select Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectSql()
     * @generated
     * @ordered
     */
    protected static final String SELECT_SQL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSelectSql() <em>Select Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectSql()
     * @generated
     * @ordered
     */
    protected String selectSql = SELECT_SQL_EDEFAULT;

    /**
     * The default value of the '{@link #getDeleteSql() <em>Delete Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeleteSql()
     * @generated
     * @ordered
     */
    protected static final String DELETE_SQL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDeleteSql() <em>Delete Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeleteSql()
     * @generated
     * @ordered
     */
    protected String deleteSql = DELETE_SQL_EDEFAULT;

    /**
     * The default value of the '{@link #getExistsSql() <em>Exists Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExistsSql()
     * @generated
     * @ordered
     */
    protected static final String EXISTS_SQL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExistsSql() <em>Exists Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExistsSql()
     * @generated
     * @ordered
     */
    protected String existsSql = EXISTS_SQL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventInjectorJdbcImpl ()
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
        return OsgiPackage.Literals.EVENT_INJECTOR_JDBC;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSelectSql ()
    {
        return selectSql;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSelectSql ( String newSelectSql )
    {
        String oldSelectSql = selectSql;
        selectSql = newSelectSql;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR_JDBC__SELECT_SQL, oldSelectSql, selectSql ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDeleteSql ()
    {
        return deleteSql;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeleteSql ( String newDeleteSql )
    {
        String oldDeleteSql = deleteSql;
        deleteSql = newDeleteSql;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR_JDBC__DELETE_SQL, oldDeleteSql, deleteSql ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExistsSql ()
    {
        return existsSql;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExistsSql ( String newExistsSql )
    {
        String oldExistsSql = existsSql;
        existsSql = newExistsSql;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.EVENT_INJECTOR_JDBC__EXISTS_SQL, oldExistsSql, existsSql ) );
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
            case OsgiPackage.EVENT_INJECTOR_JDBC__SELECT_SQL:
                return getSelectSql ();
            case OsgiPackage.EVENT_INJECTOR_JDBC__DELETE_SQL:
                return getDeleteSql ();
            case OsgiPackage.EVENT_INJECTOR_JDBC__EXISTS_SQL:
                return getExistsSql ();
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
            case OsgiPackage.EVENT_INJECTOR_JDBC__SELECT_SQL:
                setSelectSql ( (String)newValue );
                return;
            case OsgiPackage.EVENT_INJECTOR_JDBC__DELETE_SQL:
                setDeleteSql ( (String)newValue );
                return;
            case OsgiPackage.EVENT_INJECTOR_JDBC__EXISTS_SQL:
                setExistsSql ( (String)newValue );
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
            case OsgiPackage.EVENT_INJECTOR_JDBC__SELECT_SQL:
                setSelectSql ( SELECT_SQL_EDEFAULT );
                return;
            case OsgiPackage.EVENT_INJECTOR_JDBC__DELETE_SQL:
                setDeleteSql ( DELETE_SQL_EDEFAULT );
                return;
            case OsgiPackage.EVENT_INJECTOR_JDBC__EXISTS_SQL:
                setExistsSql ( EXISTS_SQL_EDEFAULT );
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
            case OsgiPackage.EVENT_INJECTOR_JDBC__SELECT_SQL:
                return SELECT_SQL_EDEFAULT == null ? selectSql != null : !SELECT_SQL_EDEFAULT.equals ( selectSql );
            case OsgiPackage.EVENT_INJECTOR_JDBC__DELETE_SQL:
                return DELETE_SQL_EDEFAULT == null ? deleteSql != null : !DELETE_SQL_EDEFAULT.equals ( deleteSql );
            case OsgiPackage.EVENT_INJECTOR_JDBC__EXISTS_SQL:
                return EXISTS_SQL_EDEFAULT == null ? existsSql != null : !EXISTS_SQL_EDEFAULT.equals ( existsSql );
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
        result.append ( " (selectSql: " ); //$NON-NLS-1$
        result.append ( selectSql );
        result.append ( ", deleteSql: " ); //$NON-NLS-1$
        result.append ( deleteSql );
        result.append ( ", existsSql: " ); //$NON-NLS-1$
        result.append ( existsSql );
        result.append ( ')' );
        return result.toString ();
    }

} //EventInjectorJdbcImpl
