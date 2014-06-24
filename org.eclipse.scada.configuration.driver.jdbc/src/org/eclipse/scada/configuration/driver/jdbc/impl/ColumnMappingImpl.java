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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.configuration.driver.jdbc.ColumnMapping;
import org.eclipse.scada.configuration.driver.jdbc.JdbcPackage;
import org.eclipse.scada.configuration.world.osgi.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Column Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.ColumnMappingImpl#getColumnNumber <em>Column Number</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.ColumnMappingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.ColumnMappingImpl#getCustomizationTags <em>Customization Tags</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.ColumnMappingImpl#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColumnMappingImpl extends MinimalEObjectImpl.Container implements ColumnMapping
{
    /**
     * The default value of the '{@link #getColumnNumber() <em>Column Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumnNumber()
     * @generated
     * @ordered
     */
    protected static final int COLUMN_NUMBER_EDEFAULT = 1;

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
     * The cached value of the '{@link #getCustomizationTags() <em>Customization Tags</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomizationTags()
     * @generated
     * @ordered
     */
    protected EList<String> customizationTags;

    /**
     * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataType()
     * @generated
     * @ordered
     */
    protected static final DataType DATA_TYPE_EDEFAULT = DataType.NULL;

    /**
     * The cached value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataType()
     * @generated
     * @ordered
     */
    protected DataType dataType = DATA_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ColumnMappingImpl ()
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
        return JdbcPackage.Literals.COLUMN_MAPPING;
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
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.COLUMN_MAPPING__COLUMN_NUMBER, oldColumnNumber, columnNumber ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.COLUMN_MAPPING__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getCustomizationTags ()
    {
        if ( customizationTags == null )
        {
            customizationTags = new EDataTypeUniqueEList<String> ( String.class, this, JdbcPackage.COLUMN_MAPPING__CUSTOMIZATION_TAGS );
        }
        return customizationTags;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataType getDataType ()
    {
        return dataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataType ( DataType newDataType )
    {
        DataType oldDataType = dataType;
        dataType = newDataType == null ? DATA_TYPE_EDEFAULT : newDataType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.COLUMN_MAPPING__DATA_TYPE, oldDataType, dataType ) );
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
            case JdbcPackage.COLUMN_MAPPING__COLUMN_NUMBER:
                return getColumnNumber ();
            case JdbcPackage.COLUMN_MAPPING__NAME:
                return getName ();
            case JdbcPackage.COLUMN_MAPPING__CUSTOMIZATION_TAGS:
                return getCustomizationTags ();
            case JdbcPackage.COLUMN_MAPPING__DATA_TYPE:
                return getDataType ();
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
            case JdbcPackage.COLUMN_MAPPING__COLUMN_NUMBER:
                setColumnNumber ( (Integer)newValue );
                return;
            case JdbcPackage.COLUMN_MAPPING__NAME:
                setName ( (String)newValue );
                return;
            case JdbcPackage.COLUMN_MAPPING__CUSTOMIZATION_TAGS:
                getCustomizationTags ().clear ();
                getCustomizationTags ().addAll ( (Collection<? extends String>)newValue );
                return;
            case JdbcPackage.COLUMN_MAPPING__DATA_TYPE:
                setDataType ( (DataType)newValue );
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
            case JdbcPackage.COLUMN_MAPPING__COLUMN_NUMBER:
                setColumnNumber ( COLUMN_NUMBER_EDEFAULT );
                return;
            case JdbcPackage.COLUMN_MAPPING__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case JdbcPackage.COLUMN_MAPPING__CUSTOMIZATION_TAGS:
                getCustomizationTags ().clear ();
                return;
            case JdbcPackage.COLUMN_MAPPING__DATA_TYPE:
                setDataType ( DATA_TYPE_EDEFAULT );
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
            case JdbcPackage.COLUMN_MAPPING__COLUMN_NUMBER:
                return columnNumber != COLUMN_NUMBER_EDEFAULT;
            case JdbcPackage.COLUMN_MAPPING__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case JdbcPackage.COLUMN_MAPPING__CUSTOMIZATION_TAGS:
                return customizationTags != null && !customizationTags.isEmpty ();
            case JdbcPackage.COLUMN_MAPPING__DATA_TYPE:
                return dataType != DATA_TYPE_EDEFAULT;
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
        result.append ( " (columnNumber: " ); //$NON-NLS-1$
        result.append ( columnNumber );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", customizationTags: " ); //$NON-NLS-1$
        result.append ( customizationTags );
        result.append ( ", dataType: " ); //$NON-NLS-1$
        result.append ( dataType );
        result.append ( ')' );
        return result.toString ();
    }

} //ColumnMappingImpl
