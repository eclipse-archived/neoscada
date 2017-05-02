/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration.impl;

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

import org.eclipse.scada.da.server.component.parser.factory.configuration.AttributeValue;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Field;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ValueDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ValueDescriptorImpl#getPrimaryValue <em>Primary Value</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ValueDescriptorImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueDescriptorImpl extends MinimalEObjectImpl.Container implements ValueDescriptor
{
    /**
     * The cached value of the '{@link #getPrimaryValue() <em>Primary Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrimaryValue()
     * @generated
     * @ordered
     */
    protected Field primaryValue;

    /**
     * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributes()
     * @generated
     * @ordered
     */
    protected EList<AttributeValue> attributes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValueDescriptorImpl ()
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
        return ParserPackage.Literals.VALUE_DESCRIPTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Field getPrimaryValue ()
    {
        if ( primaryValue != null && primaryValue.eIsProxy () )
        {
            InternalEObject oldPrimaryValue = (InternalEObject)primaryValue;
            primaryValue = (Field)eResolveProxy ( oldPrimaryValue );
            if ( primaryValue != oldPrimaryValue )
            {
                InternalEObject newPrimaryValue = (InternalEObject)primaryValue;
                NotificationChain msgs = oldPrimaryValue.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE, null, null );
                if ( newPrimaryValue.eInternalContainer () == null )
                {
                    msgs = newPrimaryValue.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE, oldPrimaryValue, primaryValue ) );
            }
        }
        return primaryValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Field basicGetPrimaryValue ()
    {
        return primaryValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPrimaryValue ( Field newPrimaryValue, NotificationChain msgs )
    {
        Field oldPrimaryValue = primaryValue;
        primaryValue = newPrimaryValue;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE, oldPrimaryValue, newPrimaryValue );
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
    public void setPrimaryValue ( Field newPrimaryValue )
    {
        if ( newPrimaryValue != primaryValue )
        {
            NotificationChain msgs = null;
            if ( primaryValue != null )
                msgs = ( (InternalEObject)primaryValue ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE, null, msgs );
            if ( newPrimaryValue != null )
                msgs = ( (InternalEObject)newPrimaryValue ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE, null, msgs );
            msgs = basicSetPrimaryValue ( newPrimaryValue, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE, newPrimaryValue, newPrimaryValue ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<AttributeValue> getAttributes ()
    {
        if ( attributes == null )
        {
            attributes = new EObjectContainmentEList.Resolving<AttributeValue> ( AttributeValue.class, this, ParserPackage.VALUE_DESCRIPTOR__ATTRIBUTES );
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
            case ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE:
                return basicSetPrimaryValue ( null, msgs );
            case ParserPackage.VALUE_DESCRIPTOR__ATTRIBUTES:
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
            case ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE:
                if ( resolve )
                    return getPrimaryValue ();
                return basicGetPrimaryValue ();
            case ParserPackage.VALUE_DESCRIPTOR__ATTRIBUTES:
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
            case ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE:
                setPrimaryValue ( (Field)newValue );
                return;
            case ParserPackage.VALUE_DESCRIPTOR__ATTRIBUTES:
                getAttributes ().clear ();
                getAttributes ().addAll ( (Collection<? extends AttributeValue>)newValue );
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
            case ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE:
                setPrimaryValue ( (Field)null );
                return;
            case ParserPackage.VALUE_DESCRIPTOR__ATTRIBUTES:
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
            case ParserPackage.VALUE_DESCRIPTOR__PRIMARY_VALUE:
                return primaryValue != null;
            case ParserPackage.VALUE_DESCRIPTOR__ATTRIBUTES:
                return attributes != null && !attributes.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //ValueDescriptorImpl
