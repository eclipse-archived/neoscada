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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.memory.TypeDefinition;
import org.eclipse.scada.configuration.memory.TypeHelper;
import org.eclipse.scada.configuration.memory.UserDefinedType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Defined Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.memory.impl.UserDefinedTypeImpl#getIndex
 * <em>Index</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.memory.impl.UserDefinedTypeImpl#getLength
 * <em>Length</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.memory.impl.UserDefinedTypeImpl#getType
 * <em>Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UserDefinedTypeImpl extends MinimalEObjectImpl.Container implements UserDefinedType
{
    /**
     * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getIndex()
     * @generated
     * @ordered
     */
    protected static final int INDEX_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getIndex()
     * @generated
     * @ordered
     */
    protected int index = INDEX_EDEFAULT;

    /**
     * The default value of the '{@link #getLength() <em>Length</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getLength()
     * @generated
     * @ordered
     */
    protected static final int LENGTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected TypeDefinition type;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected UserDefinedTypeImpl ()
    {
        super ();
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
        return MemoryPackage.Literals.USER_DEFINED_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TypeDefinition getType ()
    {
        if ( this.type != null && this.type.eIsProxy () )
        {
            final InternalEObject oldType = (InternalEObject)this.type;
            this.type = (TypeDefinition)eResolveProxy ( oldType );
            if ( this.type != oldType )
            {
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, MemoryPackage.USER_DEFINED_TYPE__TYPE, oldType, this.type ) );
                }
            }
        }
        return this.type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public TypeDefinition basicGetType ()
    {
        return this.type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setType ( final TypeDefinition newType )
    {
        final TypeDefinition oldType = this.type;
        this.type = newType;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, MemoryPackage.USER_DEFINED_TYPE__TYPE, oldType, this.type ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getIndex ()
    {
        return this.index;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setIndex ( final int newIndex )
    {
        final int oldIndex = this.index;
        this.index = newIndex;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, MemoryPackage.USER_DEFINED_TYPE__INDEX, oldIndex, this.index ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public int getLength ()
    {
        if ( this.type != null )
        {
            return TypeHelper.calculateByteSize ( this.type );
        }
        else
        {
            return 0;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public String encode ()
    {
        return String.format ( "UDT:%s:%s", this.index, this.type.getName () );
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
            case MemoryPackage.USER_DEFINED_TYPE__INDEX:
                return getIndex ();
            case MemoryPackage.USER_DEFINED_TYPE__LENGTH:
                return getLength ();
            case MemoryPackage.USER_DEFINED_TYPE__TYPE:
                if ( resolve )
                {
                    return getType ();
                }
                return basicGetType ();
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
            case MemoryPackage.USER_DEFINED_TYPE__INDEX:
                setIndex ( (Integer)newValue );
                return;
            case MemoryPackage.USER_DEFINED_TYPE__TYPE:
                setType ( (TypeDefinition)newValue );
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
            case MemoryPackage.USER_DEFINED_TYPE__INDEX:
                setIndex ( INDEX_EDEFAULT );
                return;
            case MemoryPackage.USER_DEFINED_TYPE__TYPE:
                setType ( (TypeDefinition)null );
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
            case MemoryPackage.USER_DEFINED_TYPE__INDEX:
                return this.index != INDEX_EDEFAULT;
            case MemoryPackage.USER_DEFINED_TYPE__LENGTH:
                return getLength () != LENGTH_EDEFAULT;
            case MemoryPackage.USER_DEFINED_TYPE__TYPE:
                return this.type != null;
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
    public Object eInvoke ( final int operationID, final EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case MemoryPackage.USER_DEFINED_TYPE___ENCODE:
                return encode ();
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( " (index: " ); //$NON-NLS-1$
        result.append ( this.index );
        result.append ( ')' );
        return result.toString ();
    }
} //UserDefinedTypeImpl
