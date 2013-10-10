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
import org.eclipse.scada.da.jdbc.configuration.ColumnMappingType;
import org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column Mapping Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ColumnMappingTypeImpl#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.ColumnMappingTypeImpl#getColumnNumber <em>Column Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnMappingTypeImpl extends MinimalEObjectImpl.Container implements ColumnMappingType
{
    //$NON-NLS-1$

    /**
     * The default value of the '{@link #getAliasName() <em>Alias Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAliasName()
     * @generated
     * @ordered
     */
    protected static final String ALIAS_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAliasName() <em>Alias Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAliasName()
     * @generated
     * @ordered
     */
    protected String aliasName = ALIAS_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getColumnNumber() <em>Column Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumnNumber()
     * @generated
     * @ordered
     */
    protected static final int COLUMN_NUMBER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getColumnNumber() <em>Column Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumnNumber()
     * @generated
     * @ordered
     */
    protected int columnNumber = COLUMN_NUMBER_EDEFAULT;

    /**
     * This is true if the Column Number attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean columnNumberESet;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ColumnMappingTypeImpl ()
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
        return ConfigurationPackage.Literals.COLUMN_MAPPING_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAliasName ()
    {
        return aliasName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAliasName ( String newAliasName )
    {
        String oldAliasName = aliasName;
        aliasName = newAliasName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.COLUMN_MAPPING_TYPE__ALIAS_NAME, oldAliasName, aliasName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getColumnNumber ()
    {
        return columnNumber;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setColumnNumber ( int newColumnNumber )
    {
        int oldColumnNumber = columnNumber;
        columnNumber = newColumnNumber;
        boolean oldColumnNumberESet = columnNumberESet;
        columnNumberESet = true;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.COLUMN_MAPPING_TYPE__COLUMN_NUMBER, oldColumnNumber, columnNumber, !oldColumnNumberESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetColumnNumber ()
    {
        int oldColumnNumber = columnNumber;
        boolean oldColumnNumberESet = columnNumberESet;
        columnNumber = COLUMN_NUMBER_EDEFAULT;
        columnNumberESet = false;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.UNSET, ConfigurationPackage.COLUMN_MAPPING_TYPE__COLUMN_NUMBER, oldColumnNumber, COLUMN_NUMBER_EDEFAULT, oldColumnNumberESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetColumnNumber ()
    {
        return columnNumberESet;
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
            case ConfigurationPackage.COLUMN_MAPPING_TYPE__ALIAS_NAME:
                return getAliasName ();
            case ConfigurationPackage.COLUMN_MAPPING_TYPE__COLUMN_NUMBER:
                return getColumnNumber ();
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
            case ConfigurationPackage.COLUMN_MAPPING_TYPE__ALIAS_NAME:
                setAliasName ( (String)newValue );
                return;
            case ConfigurationPackage.COLUMN_MAPPING_TYPE__COLUMN_NUMBER:
                setColumnNumber ( (Integer)newValue );
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
            case ConfigurationPackage.COLUMN_MAPPING_TYPE__ALIAS_NAME:
                setAliasName ( ALIAS_NAME_EDEFAULT );
                return;
            case ConfigurationPackage.COLUMN_MAPPING_TYPE__COLUMN_NUMBER:
                unsetColumnNumber ();
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
            case ConfigurationPackage.COLUMN_MAPPING_TYPE__ALIAS_NAME:
                return ALIAS_NAME_EDEFAULT == null ? aliasName != null : !ALIAS_NAME_EDEFAULT.equals ( aliasName );
            case ConfigurationPackage.COLUMN_MAPPING_TYPE__COLUMN_NUMBER:
                return isSetColumnNumber ();
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
        result.append ( " (aliasName: " ); //$NON-NLS-1$
        result.append ( aliasName );
        result.append ( ", columnNumber: " ); //$NON-NLS-1$
        if ( columnNumberESet )
            result.append ( columnNumber );
        else
            result.append ( "<unset>" ); //$NON-NLS-1$
        result.append ( ')' );
        return result.toString ();
    }

} //ColumnMappingTypeImpl
