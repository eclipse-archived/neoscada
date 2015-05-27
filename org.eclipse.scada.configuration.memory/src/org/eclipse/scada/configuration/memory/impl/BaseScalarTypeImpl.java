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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.memory.BaseScalarType;
import org.eclipse.scada.configuration.memory.MemoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Scalar Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.memory.impl.BaseScalarTypeImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.memory.impl.BaseScalarTypeImpl#getLength <em>Length</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BaseScalarTypeImpl extends MinimalEObjectImpl.Container implements BaseScalarType
{
    /**
     * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIndex()
     * @generated
     * @ordered
     */
    protected static final int INDEX_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIndex()
     * @generated
     * @ordered
     */
    protected int index = INDEX_EDEFAULT;

    /**
     * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
    protected static final int LENGTH_EDEFAULT = 0;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BaseScalarTypeImpl ()
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
        return MemoryPackage.Literals.BASE_SCALAR_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getIndex ()
    {
        return index;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setIndex ( int newIndex )
    {
        int oldIndex = index;
        index = newIndex;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, MemoryPackage.BASE_SCALAR_TYPE__INDEX, oldIndex, index ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getLength ()
    {
        // TODO: implement this method to return the 'Length' attribute
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String encode ()
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
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
            case MemoryPackage.BASE_SCALAR_TYPE__INDEX:
                return getIndex ();
            case MemoryPackage.BASE_SCALAR_TYPE__LENGTH:
                return getLength ();
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
            case MemoryPackage.BASE_SCALAR_TYPE__INDEX:
                setIndex ( (Integer)newValue );
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
            case MemoryPackage.BASE_SCALAR_TYPE__INDEX:
                setIndex ( INDEX_EDEFAULT );
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
            case MemoryPackage.BASE_SCALAR_TYPE__INDEX:
                return index != INDEX_EDEFAULT;
            case MemoryPackage.BASE_SCALAR_TYPE__LENGTH:
                return getLength () != LENGTH_EDEFAULT;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case MemoryPackage.BASE_SCALAR_TYPE___ENCODE:
                return encode ();
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( " (index: " );
        result.append ( index );
        result.append ( ')' );
        return result.toString ();
    }

} //BaseScalarTypeImpl
