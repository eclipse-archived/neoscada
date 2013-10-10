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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage;
import org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Columns Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateColumnsTypeImpl#getColumnName <em>Column Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateColumnsTypeImpl#getCustomUpdateSql <em>Custom Update Sql</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UpdateColumnsTypeImpl extends MinimalEObjectImpl.Container implements UpdateColumnsType
{
    //$NON-NLS-1$

    /**
     * The default value of the '{@link #getColumnName() <em>Column Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumnName()
     * @generated
     * @ordered
     */
    protected static final String COLUMN_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getColumnName() <em>Column Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumnName()
     * @generated
     * @ordered
     */
    protected String columnName = COLUMN_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getCustomUpdateSql() <em>Custom Update Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomUpdateSql()
     * @generated
     * @ordered
     */
    protected static final String CUSTOM_UPDATE_SQL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCustomUpdateSql() <em>Custom Update Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomUpdateSql()
     * @generated
     * @ordered
     */
    protected String customUpdateSql = CUSTOM_UPDATE_SQL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UpdateColumnsTypeImpl ()
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
        return ConfigurationPackage.Literals.UPDATE_COLUMNS_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getColumnName ()
    {
        return columnName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setColumnName ( String newColumnName )
    {
        String oldColumnName = columnName;
        columnName = newColumnName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.UPDATE_COLUMNS_TYPE__COLUMN_NAME, oldColumnName, columnName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCustomUpdateSql ()
    {
        return customUpdateSql;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCustomUpdateSql ( String newCustomUpdateSql )
    {
        String oldCustomUpdateSql = customUpdateSql;
        customUpdateSql = newCustomUpdateSql;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.UPDATE_COLUMNS_TYPE__CUSTOM_UPDATE_SQL, oldCustomUpdateSql, customUpdateSql ) );
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
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE__COLUMN_NAME:
                return getColumnName ();
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE__CUSTOM_UPDATE_SQL:
                return getCustomUpdateSql ();
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
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE__COLUMN_NAME:
                setColumnName ( (String)newValue );
                return;
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE__CUSTOM_UPDATE_SQL:
                setCustomUpdateSql ( (String)newValue );
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
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE__COLUMN_NAME:
                setColumnName ( COLUMN_NAME_EDEFAULT );
                return;
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE__CUSTOM_UPDATE_SQL:
                setCustomUpdateSql ( CUSTOM_UPDATE_SQL_EDEFAULT );
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
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE__COLUMN_NAME:
                return COLUMN_NAME_EDEFAULT == null ? columnName != null : !COLUMN_NAME_EDEFAULT.equals ( columnName );
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE__CUSTOM_UPDATE_SQL:
                return CUSTOM_UPDATE_SQL_EDEFAULT == null ? customUpdateSql != null : !CUSTOM_UPDATE_SQL_EDEFAULT.equals ( customUpdateSql );
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
        result.append ( " (columnName: " ); //$NON-NLS-1$
        result.append ( columnName );
        result.append ( ", customUpdateSql: " ); //$NON-NLS-1$
        result.append ( customUpdateSql );
        result.append ( ')' );
        return result.toString ();
    }

} //UpdateColumnsTypeImpl
