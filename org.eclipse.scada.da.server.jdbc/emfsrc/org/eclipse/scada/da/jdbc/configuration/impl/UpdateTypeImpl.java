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
import org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage;
import org.eclipse.scada.da.jdbc.configuration.UpdateMappingType;
import org.eclipse.scada.da.jdbc.configuration.UpdateType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateTypeImpl#getSql <em>Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateTypeImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateTypeImpl#getSql1 <em>Sql1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UpdateTypeImpl extends MinimalEObjectImpl.Container implements UpdateType
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
     * The cached value of the '{@link #getMapping() <em>Mapping</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMapping()
     * @generated
     * @ordered
     */
    protected EList<UpdateMappingType> mapping;

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
    protected UpdateTypeImpl ()
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
        return ConfigurationPackage.Literals.UPDATE_TYPE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.UPDATE_TYPE__SQL, oldSql, sql ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<UpdateMappingType> getMapping ()
    {
        if ( mapping == null )
        {
            mapping = new EObjectContainmentEList<UpdateMappingType> ( UpdateMappingType.class, this, ConfigurationPackage.UPDATE_TYPE__MAPPING );
        }
        return mapping;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.UPDATE_TYPE__ID, oldId, id ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.UPDATE_TYPE__SQL1, oldSql1, sql1 ) );
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
            case ConfigurationPackage.UPDATE_TYPE__MAPPING:
                return ( (InternalEList<?>)getMapping () ).basicRemove ( otherEnd, msgs );
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
            case ConfigurationPackage.UPDATE_TYPE__SQL:
                return getSql ();
            case ConfigurationPackage.UPDATE_TYPE__MAPPING:
                return getMapping ();
            case ConfigurationPackage.UPDATE_TYPE__ID:
                return getId ();
            case ConfigurationPackage.UPDATE_TYPE__SQL1:
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
            case ConfigurationPackage.UPDATE_TYPE__SQL:
                setSql ( (String)newValue );
                return;
            case ConfigurationPackage.UPDATE_TYPE__MAPPING:
                getMapping ().clear ();
                getMapping ().addAll ( (Collection<? extends UpdateMappingType>)newValue );
                return;
            case ConfigurationPackage.UPDATE_TYPE__ID:
                setId ( (String)newValue );
                return;
            case ConfigurationPackage.UPDATE_TYPE__SQL1:
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
            case ConfigurationPackage.UPDATE_TYPE__SQL:
                setSql ( SQL_EDEFAULT );
                return;
            case ConfigurationPackage.UPDATE_TYPE__MAPPING:
                getMapping ().clear ();
                return;
            case ConfigurationPackage.UPDATE_TYPE__ID:
                setId ( ID_EDEFAULT );
                return;
            case ConfigurationPackage.UPDATE_TYPE__SQL1:
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
            case ConfigurationPackage.UPDATE_TYPE__SQL:
                return SQL_EDEFAULT == null ? sql != null : !SQL_EDEFAULT.equals ( sql );
            case ConfigurationPackage.UPDATE_TYPE__MAPPING:
                return mapping != null && !mapping.isEmpty ();
            case ConfigurationPackage.UPDATE_TYPE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case ConfigurationPackage.UPDATE_TYPE__SQL1:
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
        result.append ( ", sql1: " ); //$NON-NLS-1$
        result.append ( sql1 );
        result.append ( ')' );
        return result.toString ();
    }

} //UpdateTypeImpl
