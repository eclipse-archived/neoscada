/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.model.Protocol.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumAttributeImpl#getEnumType <em>Enum Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumAttributeImpl extends AttributeImpl implements EnumAttribute
{
    /**
     * The cached value of the '{@link #getEnumType() <em>Enum Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnumType()
     * @generated
     * @ordered
     */
    protected org.eclipse.scada.protocol.ngp.model.Protocol.Enum enumType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EnumAttributeImpl ()
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
        return ProtocolPackage.Literals.ENUM_ATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public org.eclipse.scada.protocol.ngp.model.Protocol.Enum getEnumType ()
    {
        if ( enumType != null && enumType.eIsProxy () )
        {
            InternalEObject oldEnumType = (InternalEObject)enumType;
            enumType = (org.eclipse.scada.protocol.ngp.model.Protocol.Enum)eResolveProxy ( oldEnumType );
            if ( enumType != oldEnumType )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ProtocolPackage.ENUM_ATTRIBUTE__ENUM_TYPE, oldEnumType, enumType ) );
            }
        }
        return enumType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.eclipse.scada.protocol.ngp.model.Protocol.Enum basicGetEnumType ()
    {
        return enumType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEnumType ( org.eclipse.scada.protocol.ngp.model.Protocol.Enum newEnumType )
    {
        org.eclipse.scada.protocol.ngp.model.Protocol.Enum oldEnumType = enumType;
        enumType = newEnumType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.ENUM_ATTRIBUTE__ENUM_TYPE, oldEnumType, enumType ) );
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
            case ProtocolPackage.ENUM_ATTRIBUTE__ENUM_TYPE:
                if ( resolve )
                    return getEnumType ();
                return basicGetEnumType ();
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
            case ProtocolPackage.ENUM_ATTRIBUTE__ENUM_TYPE:
                setEnumType ( (org.eclipse.scada.protocol.ngp.model.Protocol.Enum)newValue );
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
            case ProtocolPackage.ENUM_ATTRIBUTE__ENUM_TYPE:
                setEnumType ( (org.eclipse.scada.protocol.ngp.model.Protocol.Enum)null );
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
            case ProtocolPackage.ENUM_ATTRIBUTE__ENUM_TYPE:
                return enumType != null;
        }
        return super.eIsSet ( featureID );
    }

} //EnumAttributeImpl
