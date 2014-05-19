/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.memory.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.memory.BitType;
import org.eclipse.scada.configuration.memory.MemoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bit Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.memory.impl.BitTypeImpl#getSubIndex
 * <em>Sub Index</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BitTypeImpl extends BaseScalarTypeImpl implements BitType
{
    /**
     * The default value of the '{@link #getSubIndex() <em>Sub Index</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getSubIndex()
     * @generated
     * @ordered
     */
    protected static final int SUB_INDEX_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSubIndex() <em>Sub Index</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getSubIndex()
     * @generated
     * @ordered
     */
    protected int subIndex = SUB_INDEX_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BitTypeImpl ()
    {
        super ();
    }

    @Override
    public String encode ()
    {
        return String.format ( "BIT:%s:%s:0", this.index, this.subIndex );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return MemoryPackage.Literals.BIT_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getSubIndex ()
    {
        return this.subIndex;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSubIndex ( final int newSubIndex )
    {
        final int oldSubIndex = this.subIndex;
        this.subIndex = newSubIndex;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, MemoryPackage.BIT_TYPE__SUB_INDEX, oldSubIndex, this.subIndex ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet ( final int featureID, final boolean resolve, final boolean coreType )
    {
        switch ( featureID )
        {
            case MemoryPackage.BIT_TYPE__SUB_INDEX:
                return getSubIndex ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet ( final int featureID, final Object newValue )
    {
        switch ( featureID )
        {
            case MemoryPackage.BIT_TYPE__SUB_INDEX:
                setSubIndex ( (Integer)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset ( final int featureID )
    {
        switch ( featureID )
        {
            case MemoryPackage.BIT_TYPE__SUB_INDEX:
                setSubIndex ( SUB_INDEX_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet ( final int featureID )
    {
        switch ( featureID )
        {
            case MemoryPackage.BIT_TYPE__SUB_INDEX:
                return this.subIndex != SUB_INDEX_EDEFAULT;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
        {
            return super.toString ();
        }

        final StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (subIndex: " ); //$NON-NLS-1$
        result.append ( this.subIndex );
        result.append ( ')' );
        return result.toString ();
    }

    /**
     * @generated NOT
     */
    @Override
    public int getLength ()
    {
        return 1; // takes at least one byte
    }

} //BitTypeImpl
