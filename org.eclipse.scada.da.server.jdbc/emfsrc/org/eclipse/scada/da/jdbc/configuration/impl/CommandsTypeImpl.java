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
import org.eclipse.scada.da.jdbc.configuration.CommandsType;
import org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Commands Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.CommandsTypeImpl#getSql <em>Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.CommandsTypeImpl#getLocalName <em>Local Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.CommandsTypeImpl#getSql1 <em>Sql1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandsTypeImpl extends MinimalEObjectImpl.Container implements CommandsType
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
     * The default value of the '{@link #getLocalName() <em>Local Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalName()
     * @generated
     * @ordered
     */
    protected static final String LOCAL_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLocalName() <em>Local Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalName()
     * @generated
     * @ordered
     */
    protected String localName = LOCAL_NAME_EDEFAULT;

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
    protected CommandsTypeImpl ()
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
        return ConfigurationPackage.Literals.COMMANDS_TYPE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.COMMANDS_TYPE__SQL, oldSql, sql ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLocalName ()
    {
        return localName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocalName ( String newLocalName )
    {
        String oldLocalName = localName;
        localName = newLocalName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.COMMANDS_TYPE__LOCAL_NAME, oldLocalName, localName ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.COMMANDS_TYPE__SQL1, oldSql1, sql1 ) );
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
            case ConfigurationPackage.COMMANDS_TYPE__SQL:
                return getSql ();
            case ConfigurationPackage.COMMANDS_TYPE__LOCAL_NAME:
                return getLocalName ();
            case ConfigurationPackage.COMMANDS_TYPE__SQL1:
                return getSql1 ();
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
            case ConfigurationPackage.COMMANDS_TYPE__SQL:
                setSql ( (String)newValue );
                return;
            case ConfigurationPackage.COMMANDS_TYPE__LOCAL_NAME:
                setLocalName ( (String)newValue );
                return;
            case ConfigurationPackage.COMMANDS_TYPE__SQL1:
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
            case ConfigurationPackage.COMMANDS_TYPE__SQL:
                setSql ( SQL_EDEFAULT );
                return;
            case ConfigurationPackage.COMMANDS_TYPE__LOCAL_NAME:
                setLocalName ( LOCAL_NAME_EDEFAULT );
                return;
            case ConfigurationPackage.COMMANDS_TYPE__SQL1:
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
            case ConfigurationPackage.COMMANDS_TYPE__SQL:
                return SQL_EDEFAULT == null ? sql != null : !SQL_EDEFAULT.equals ( sql );
            case ConfigurationPackage.COMMANDS_TYPE__LOCAL_NAME:
                return LOCAL_NAME_EDEFAULT == null ? localName != null : !LOCAL_NAME_EDEFAULT.equals ( localName );
            case ConfigurationPackage.COMMANDS_TYPE__SQL1:
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
        result.append ( ", localName: " ); //$NON-NLS-1$
        result.append ( localName );
        result.append ( ", sql1: " ); //$NON-NLS-1$
        result.append ( sql1 );
        result.append ( ')' );
        return result.toString ();
    }

} //CommandsTypeImpl
