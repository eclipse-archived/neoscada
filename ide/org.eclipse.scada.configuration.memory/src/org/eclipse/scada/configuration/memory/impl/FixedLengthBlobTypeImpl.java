/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.scada.configuration.memory.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.memory.FixedLengthBlobType;
import org.eclipse.scada.configuration.memory.MemoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Length Blob Type</b></em>
 * '.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.memory.impl.FixedLengthBlobTypeImpl#getMaxLength <em>Max Length</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FixedLengthBlobTypeImpl extends BaseScalarTypeImpl implements FixedLengthBlobType
{
    /**
     * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxLength()
     * @generated
     * @ordered
     */
    protected static final int MAX_LENGTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxLength()
     * @generated
     * @ordered
     */
    protected int maxLength = MAX_LENGTH_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FixedLengthBlobTypeImpl ()
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
        return MemoryPackage.Literals.FIXED_LENGTH_BLOB_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getMaxLength ()
    {
        return maxLength;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMaxLength ( int newMaxLength )
    {
        int oldMaxLength = maxLength;
        maxLength = newMaxLength;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, MemoryPackage.FIXED_LENGTH_BLOB_TYPE__MAX_LENGTH, oldMaxLength, maxLength ) );
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
            case MemoryPackage.FIXED_LENGTH_BLOB_TYPE__MAX_LENGTH:
                return getMaxLength ();
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
            case MemoryPackage.FIXED_LENGTH_BLOB_TYPE__MAX_LENGTH:
                setMaxLength ( (Integer)newValue );
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
            case MemoryPackage.FIXED_LENGTH_BLOB_TYPE__MAX_LENGTH:
                setMaxLength ( MAX_LENGTH_EDEFAULT );
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
            case MemoryPackage.FIXED_LENGTH_BLOB_TYPE__MAX_LENGTH:
                return maxLength != MAX_LENGTH_EDEFAULT;
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
        result.append ( " (maxLength: " );
        result.append ( maxLength );
        result.append ( ')' );
        return result.toString ();
    }

    /**
     * @generated NOT
     */
    @Override
    public int getLength ()
    {
        return this.maxLength;
    }

    /**
     * @generated NOT
     */
    @Override
    public String encode ()
    {
        return String.format ( "BLOB:%s:0:%s", this.index, this.maxLength );
    }

} //FixedLengthBlobTypeImpl
