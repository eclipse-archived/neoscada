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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.protocol.ngp.model.Protocol.Attribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;
import org.eclipse.scada.protocol.ngp.model.Protocol.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeImpl#getFieldNumber <em>Field Number</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeImpl#isEquality <em>Equality</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeImpl#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeImpl#isDeleted <em>Deleted</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AttributeImpl extends DocumentedElementImpl implements Attribute
{
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
     * The default value of the '{@link #getFieldNumber() <em>Field Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFieldNumber()
     * @generated
     * @ordered
     */
    protected static final byte FIELD_NUMBER_EDEFAULT = 0x00;

    /**
     * The cached value of the '{@link #getFieldNumber() <em>Field Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFieldNumber()
     * @generated
     * @ordered
     */
    protected byte fieldNumber = FIELD_NUMBER_EDEFAULT;

    /**
     * The default value of the '{@link #isEquality() <em>Equality</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEquality()
     * @generated
     * @ordered
     */
    protected static final boolean EQUALITY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isEquality() <em>Equality</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEquality()
     * @generated
     * @ordered
     */
    protected boolean equality = EQUALITY_EDEFAULT;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final Type TYPE_EDEFAULT = Type.SCALAR;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected Type type = TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTransient()
     * @generated
     * @ordered
     */
    protected static final boolean TRANSIENT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isTransient() <em>Transient</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTransient()
     * @generated
     * @ordered
     */
    protected boolean transient_ = TRANSIENT_EDEFAULT;

    /**
     * The default value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleted()
     * @generated
     * @ordered
     */
    protected static final boolean DELETED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDeleted() <em>Deleted</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDeleted()
     * @generated
     * @ordered
     */
    protected boolean deleted = DELETED_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AttributeImpl ()
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
        return ProtocolPackage.Literals.ATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.ATTRIBUTE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public byte getFieldNumber ()
    {
        return fieldNumber;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setFieldNumber ( byte newFieldNumber )
    {
        byte oldFieldNumber = fieldNumber;
        fieldNumber = newFieldNumber;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.ATTRIBUTE__FIELD_NUMBER, oldFieldNumber, fieldNumber ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isEquality ()
    {
        return equality;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEquality ( boolean newEquality )
    {
        boolean oldEquality = equality;
        equality = newEquality;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.ATTRIBUTE__EQUALITY, oldEquality, equality ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Type getType ()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setType ( Type newType )
    {
        Type oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.ATTRIBUTE__TYPE, oldType, type ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isTransient ()
    {
        return transient_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTransient ( boolean newTransient )
    {
        boolean oldTransient = transient_;
        transient_ = newTransient;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.ATTRIBUTE__TRANSIENT, oldTransient, transient_ ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isDeleted ()
    {
        return deleted;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDeleted ( boolean newDeleted )
    {
        boolean oldDeleted = deleted;
        deleted = newDeleted;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.ATTRIBUTE__DELETED, oldDeleted, deleted ) );
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
            case ProtocolPackage.ATTRIBUTE__NAME:
                return getName ();
            case ProtocolPackage.ATTRIBUTE__FIELD_NUMBER:
                return getFieldNumber ();
            case ProtocolPackage.ATTRIBUTE__EQUALITY:
                return isEquality ();
            case ProtocolPackage.ATTRIBUTE__TYPE:
                return getType ();
            case ProtocolPackage.ATTRIBUTE__TRANSIENT:
                return isTransient ();
            case ProtocolPackage.ATTRIBUTE__DELETED:
                return isDeleted ();
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
            case ProtocolPackage.ATTRIBUTE__NAME:
                setName ( (String)newValue );
                return;
            case ProtocolPackage.ATTRIBUTE__FIELD_NUMBER:
                setFieldNumber ( (Byte)newValue );
                return;
            case ProtocolPackage.ATTRIBUTE__EQUALITY:
                setEquality ( (Boolean)newValue );
                return;
            case ProtocolPackage.ATTRIBUTE__TYPE:
                setType ( (Type)newValue );
                return;
            case ProtocolPackage.ATTRIBUTE__TRANSIENT:
                setTransient ( (Boolean)newValue );
                return;
            case ProtocolPackage.ATTRIBUTE__DELETED:
                setDeleted ( (Boolean)newValue );
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
            case ProtocolPackage.ATTRIBUTE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ProtocolPackage.ATTRIBUTE__FIELD_NUMBER:
                setFieldNumber ( FIELD_NUMBER_EDEFAULT );
                return;
            case ProtocolPackage.ATTRIBUTE__EQUALITY:
                setEquality ( EQUALITY_EDEFAULT );
                return;
            case ProtocolPackage.ATTRIBUTE__TYPE:
                setType ( TYPE_EDEFAULT );
                return;
            case ProtocolPackage.ATTRIBUTE__TRANSIENT:
                setTransient ( TRANSIENT_EDEFAULT );
                return;
            case ProtocolPackage.ATTRIBUTE__DELETED:
                setDeleted ( DELETED_EDEFAULT );
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
            case ProtocolPackage.ATTRIBUTE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ProtocolPackage.ATTRIBUTE__FIELD_NUMBER:
                return fieldNumber != FIELD_NUMBER_EDEFAULT;
            case ProtocolPackage.ATTRIBUTE__EQUALITY:
                return equality != EQUALITY_EDEFAULT;
            case ProtocolPackage.ATTRIBUTE__TYPE:
                return type != TYPE_EDEFAULT;
            case ProtocolPackage.ATTRIBUTE__TRANSIENT:
                return transient_ != TRANSIENT_EDEFAULT;
            case ProtocolPackage.ATTRIBUTE__DELETED:
                return deleted != DELETED_EDEFAULT;
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
        result.append ( ", fieldNumber: " ); //$NON-NLS-1$
        result.append ( fieldNumber );
        result.append ( ", equality: " ); //$NON-NLS-1$
        result.append ( equality );
        result.append ( ", type: " ); //$NON-NLS-1$
        result.append ( type );
        result.append ( ", transient: " ); //$NON-NLS-1$
        result.append ( transient_ );
        result.append ( ", deleted: " ); //$NON-NLS-1$
        result.append ( deleted );
        result.append ( ')' );
        return result.toString ();
    }

} //AttributeImpl
