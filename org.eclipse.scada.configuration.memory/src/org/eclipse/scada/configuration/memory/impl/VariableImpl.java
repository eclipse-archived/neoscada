/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.memory.impl;

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
import org.eclipse.scada.configuration.memory.Attribute;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.memory.Type;
import org.eclipse.scada.configuration.memory.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.memory.impl.VariableImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.memory.impl.VariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.memory.impl.VariableImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends MinimalEObjectImpl.Container implements Variable
{
    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected Type type;

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
     * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributes()
     * @generated
     * @ordered
     */
    protected EList<Attribute> attributes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariableImpl ()
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
        return MemoryPackage.Literals.VARIABLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type getType ()
    {
        if ( type != null && type.eIsProxy () )
        {
            InternalEObject oldType = (InternalEObject)type;
            type = (Type)eResolveProxy ( oldType );
            if ( type != oldType )
            {
                InternalEObject newType = (InternalEObject)type;
                NotificationChain msgs = oldType.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - MemoryPackage.VARIABLE__TYPE, null, null );
                if ( newType.eInternalContainer () == null )
                {
                    msgs = newType.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - MemoryPackage.VARIABLE__TYPE, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, MemoryPackage.VARIABLE__TYPE, oldType, type ) );
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type basicGetType ()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetType ( Type newType, NotificationChain msgs )
    {
        Type oldType = type;
        type = newType;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, MemoryPackage.VARIABLE__TYPE, oldType, newType );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType ( Type newType )
    {
        if ( newType != type )
        {
            NotificationChain msgs = null;
            if ( type != null )
                msgs = ( (InternalEObject)type ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - MemoryPackage.VARIABLE__TYPE, null, msgs );
            if ( newType != null )
                msgs = ( (InternalEObject)newType ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - MemoryPackage.VARIABLE__TYPE, null, msgs );
            msgs = basicSetType ( newType, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, MemoryPackage.VARIABLE__TYPE, newType, newType ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, MemoryPackage.VARIABLE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Attribute> getAttributes ()
    {
        if ( attributes == null )
        {
            attributes = new EObjectContainmentEList.Resolving<Attribute> ( Attribute.class, this, MemoryPackage.VARIABLE__ATTRIBUTES );
        }
        return attributes;
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
            case MemoryPackage.VARIABLE__TYPE:
                return basicSetType ( null, msgs );
            case MemoryPackage.VARIABLE__ATTRIBUTES:
                return ( (InternalEList<?>)getAttributes () ).basicRemove ( otherEnd, msgs );
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
            case MemoryPackage.VARIABLE__TYPE:
                if ( resolve )
                    return getType ();
                return basicGetType ();
            case MemoryPackage.VARIABLE__NAME:
                return getName ();
            case MemoryPackage.VARIABLE__ATTRIBUTES:
                return getAttributes ();
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
            case MemoryPackage.VARIABLE__TYPE:
                setType ( (Type)newValue );
                return;
            case MemoryPackage.VARIABLE__NAME:
                setName ( (String)newValue );
                return;
            case MemoryPackage.VARIABLE__ATTRIBUTES:
                getAttributes ().clear ();
                getAttributes ().addAll ( (Collection<? extends Attribute>)newValue );
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
            case MemoryPackage.VARIABLE__TYPE:
                setType ( (Type)null );
                return;
            case MemoryPackage.VARIABLE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case MemoryPackage.VARIABLE__ATTRIBUTES:
                getAttributes ().clear ();
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
            case MemoryPackage.VARIABLE__TYPE:
                return type != null;
            case MemoryPackage.VARIABLE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case MemoryPackage.VARIABLE__ATTRIBUTES:
                return attributes != null && !attributes.isEmpty ();
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
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ')' );
        return result.toString ();
    }

} //VariableImpl
