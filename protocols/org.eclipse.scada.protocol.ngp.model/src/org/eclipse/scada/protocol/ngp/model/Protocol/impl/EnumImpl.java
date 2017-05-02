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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.protocol.ngp.model.Protocol.Protocol;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumImpl#getLiterals <em>Literals</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumImpl#getProtocol <em>Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumImpl extends DocumentedElementImpl implements org.eclipse.scada.protocol.ngp.model.Protocol.Enum
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
     * The cached value of the '{@link #getLiterals() <em>Literals</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLiterals()
     * @generated
     * @ordered
     */
    protected EList<String> literals;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EnumImpl ()
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
        return ProtocolPackage.Literals.ENUM;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.ENUM__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<String> getLiterals ()
    {
        if ( literals == null )
        {
            literals = new EDataTypeUniqueEList<String> ( String.class, this, ProtocolPackage.ENUM__LITERALS );
        }
        return literals;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Protocol getProtocol ()
    {
        if ( eContainerFeatureID () != ProtocolPackage.ENUM__PROTOCOL )
            return null;
        return (Protocol)eContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Protocol basicGetProtocol ()
    {
        if ( eContainerFeatureID () != ProtocolPackage.ENUM__PROTOCOL )
            return null;
        return (Protocol)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProtocol ( Protocol newProtocol, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newProtocol, ProtocolPackage.ENUM__PROTOCOL, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setProtocol ( Protocol newProtocol )
    {
        if ( newProtocol != eInternalContainer () || ( eContainerFeatureID () != ProtocolPackage.ENUM__PROTOCOL && newProtocol != null ) )
        {
            if ( EcoreUtil.isAncestor ( this, newProtocol ) )
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
                msgs = eBasicRemoveFromContainer ( msgs );
            if ( newProtocol != null )
                msgs = ( (InternalEObject)newProtocol ).eInverseAdd ( this, ProtocolPackage.PROTOCOL__ENUMS, Protocol.class, msgs );
            msgs = basicSetProtocol ( newProtocol, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.ENUM__PROTOCOL, newProtocol, newProtocol ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ProtocolPackage.ENUM__PROTOCOL:
                if ( eInternalContainer () != null )
                    msgs = eBasicRemoveFromContainer ( msgs );
                return basicSetProtocol ( (Protocol)otherEnd, msgs );
        }
        return super.eInverseAdd ( otherEnd, featureID, msgs );
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
            case ProtocolPackage.ENUM__PROTOCOL:
                return basicSetProtocol ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature ( NotificationChain msgs )
    {
        switch ( eContainerFeatureID () )
        {
            case ProtocolPackage.ENUM__PROTOCOL:
                return eInternalContainer ().eInverseRemove ( this, ProtocolPackage.PROTOCOL__ENUMS, Protocol.class, msgs );
        }
        return super.eBasicRemoveFromContainerFeature ( msgs );
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
            case ProtocolPackage.ENUM__NAME:
                return getName ();
            case ProtocolPackage.ENUM__LITERALS:
                return getLiterals ();
            case ProtocolPackage.ENUM__PROTOCOL:
                if ( resolve )
                    return getProtocol ();
                return basicGetProtocol ();
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
            case ProtocolPackage.ENUM__NAME:
                setName ( (String)newValue );
                return;
            case ProtocolPackage.ENUM__LITERALS:
                getLiterals ().clear ();
                getLiterals ().addAll ( (Collection<? extends String>)newValue );
                return;
            case ProtocolPackage.ENUM__PROTOCOL:
                setProtocol ( (Protocol)newValue );
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
            case ProtocolPackage.ENUM__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ProtocolPackage.ENUM__LITERALS:
                getLiterals ().clear ();
                return;
            case ProtocolPackage.ENUM__PROTOCOL:
                setProtocol ( (Protocol)null );
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
            case ProtocolPackage.ENUM__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ProtocolPackage.ENUM__LITERALS:
                return literals != null && !literals.isEmpty ();
            case ProtocolPackage.ENUM__PROTOCOL:
                return basicGetProtocol () != null;
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
        result.append ( ", literals: " ); //$NON-NLS-1$
        result.append ( literals );
        result.append ( ')' );
        return result.toString ();
    }

} //EnumImpl
