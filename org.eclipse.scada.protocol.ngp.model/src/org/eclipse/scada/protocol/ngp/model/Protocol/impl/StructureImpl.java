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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.protocol.ngp.model.Protocol.Protocol;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;
import org.eclipse.scada.protocol.ngp.model.Protocol.Structure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.StructureImpl#getProtocol <em>Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructureImpl extends AttributeStructureImpl implements Structure
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StructureImpl ()
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
        return ProtocolPackage.Literals.STRUCTURE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Protocol getProtocol ()
    {
        if ( eContainerFeatureID () != ProtocolPackage.STRUCTURE__PROTOCOL )
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
        if ( eContainerFeatureID () != ProtocolPackage.STRUCTURE__PROTOCOL )
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
        msgs = eBasicSetContainer ( (InternalEObject)newProtocol, ProtocolPackage.STRUCTURE__PROTOCOL, msgs );
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
        if ( newProtocol != eInternalContainer () || ( eContainerFeatureID () != ProtocolPackage.STRUCTURE__PROTOCOL && newProtocol != null ) )
        {
            if ( EcoreUtil.isAncestor ( this, newProtocol ) )
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
                msgs = eBasicRemoveFromContainer ( msgs );
            if ( newProtocol != null )
                msgs = ( (InternalEObject)newProtocol ).eInverseAdd ( this, ProtocolPackage.PROTOCOL__STRUCTURES, Protocol.class, msgs );
            msgs = basicSetProtocol ( newProtocol, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.STRUCTURE__PROTOCOL, newProtocol, newProtocol ) );
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
            case ProtocolPackage.STRUCTURE__PROTOCOL:
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
            case ProtocolPackage.STRUCTURE__PROTOCOL:
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
            case ProtocolPackage.STRUCTURE__PROTOCOL:
                return eInternalContainer ().eInverseRemove ( this, ProtocolPackage.PROTOCOL__STRUCTURES, Protocol.class, msgs );
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
            case ProtocolPackage.STRUCTURE__PROTOCOL:
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
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ProtocolPackage.STRUCTURE__PROTOCOL:
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
            case ProtocolPackage.STRUCTURE__PROTOCOL:
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
            case ProtocolPackage.STRUCTURE__PROTOCOL:
                return basicGetProtocol () != null;
        }
        return super.eIsSet ( featureID );
    }

} //StructureImpl
