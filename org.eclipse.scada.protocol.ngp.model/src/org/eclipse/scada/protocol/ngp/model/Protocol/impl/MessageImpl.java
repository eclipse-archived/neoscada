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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.protocol.ngp.model.Protocol.Interface;
import org.eclipse.scada.protocol.ngp.model.Protocol.Message;
import org.eclipse.scada.protocol.ngp.model.Protocol.Protocol;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.MessageImpl#getCode
 * <em>Code</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.MessageImpl#getProtocol
 * <em>Protocol</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.MessageImpl#getInterfaces
 * <em>Interfaces</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MessageImpl extends AttributeStructureImpl implements Message
{
    /**
     * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getCode()
     * @generated
     * @ordered
     */
    protected static final int CODE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getCode()
     * @generated
     * @ordered
     */
    protected int code = CODE_EDEFAULT;

    /**
     * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}'
     * reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInterfaces()
     * @generated
     * @ordered
     */
    protected EList<Interface> interfaces;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MessageImpl ()
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
        return ProtocolPackage.Literals.MESSAGE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getCode ()
    {
        return this.code;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCode ( final int newCode )
    {
        final int oldCode = this.code;
        this.code = newCode;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.MESSAGE__CODE, oldCode, this.code ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Protocol getProtocol ()
    {
        if ( eContainerFeatureID () != ProtocolPackage.MESSAGE__PROTOCOL )
        {
            return null;
        }
        return (Protocol)eContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Protocol basicGetProtocol ()
    {
        if ( eContainerFeatureID () != ProtocolPackage.MESSAGE__PROTOCOL )
        {
            return null;
        }
        return (Protocol)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetProtocol ( final Protocol newProtocol, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newProtocol, ProtocolPackage.MESSAGE__PROTOCOL, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setProtocol ( final Protocol newProtocol )
    {
        if ( newProtocol != eInternalContainer () || eContainerFeatureID () != ProtocolPackage.MESSAGE__PROTOCOL && newProtocol != null )
        {
            if ( EcoreUtil.isAncestor ( this, newProtocol ) )
            {
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () );
            }
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
            {
                msgs = eBasicRemoveFromContainer ( msgs );
            }
            if ( newProtocol != null )
            {
                msgs = ( (InternalEObject)newProtocol ).eInverseAdd ( this, ProtocolPackage.PROTOCOL__MESSAGES, Protocol.class, msgs );
            }
            msgs = basicSetProtocol ( newProtocol, msgs );
            if ( msgs != null )
            {
                msgs.dispatch ();
            }
        }
        else if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.MESSAGE__PROTOCOL, newProtocol, newProtocol ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Interface> getInterfaces ()
    {
        if ( this.interfaces == null )
        {
            this.interfaces = new EObjectResolvingEList<Interface> ( Interface.class, this, ProtocolPackage.MESSAGE__INTERFACES );
        }
        return this.interfaces;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd ( final InternalEObject otherEnd, final int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ProtocolPackage.MESSAGE__PROTOCOL:
                if ( eInternalContainer () != null )
                {
                    msgs = eBasicRemoveFromContainer ( msgs );
                }
                return basicSetProtocol ( (Protocol)otherEnd, msgs );
        }
        return super.eInverseAdd ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( final InternalEObject otherEnd, final int featureID, final NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ProtocolPackage.MESSAGE__PROTOCOL:
                return basicSetProtocol ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature ( final NotificationChain msgs )
    {
        switch ( eContainerFeatureID () )
        {
            case ProtocolPackage.MESSAGE__PROTOCOL:
                return eInternalContainer ().eInverseRemove ( this, ProtocolPackage.PROTOCOL__MESSAGES, Protocol.class, msgs );
        }
        return super.eBasicRemoveFromContainerFeature ( msgs );
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
            case ProtocolPackage.MESSAGE__CODE:
                return getCode ();
            case ProtocolPackage.MESSAGE__PROTOCOL:
                if ( resolve )
                {
                    return getProtocol ();
                }
                return basicGetProtocol ();
            case ProtocolPackage.MESSAGE__INTERFACES:
                return getInterfaces ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( final int featureID, final Object newValue )
    {
        switch ( featureID )
        {
            case ProtocolPackage.MESSAGE__CODE:
                setCode ( (Integer)newValue );
                return;
            case ProtocolPackage.MESSAGE__PROTOCOL:
                setProtocol ( (Protocol)newValue );
                return;
            case ProtocolPackage.MESSAGE__INTERFACES:
                getInterfaces ().clear ();
                getInterfaces ().addAll ( (Collection<? extends Interface>)newValue );
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
            case ProtocolPackage.MESSAGE__CODE:
                setCode ( CODE_EDEFAULT );
                return;
            case ProtocolPackage.MESSAGE__PROTOCOL:
                setProtocol ( (Protocol)null );
                return;
            case ProtocolPackage.MESSAGE__INTERFACES:
                getInterfaces ().clear ();
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
            case ProtocolPackage.MESSAGE__CODE:
                return this.code != CODE_EDEFAULT;
            case ProtocolPackage.MESSAGE__PROTOCOL:
                return basicGetProtocol () != null;
            case ProtocolPackage.MESSAGE__INTERFACES:
                return this.interfaces != null && !this.interfaces.isEmpty ();
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
        result.append ( " (code: " );
        result.append ( this.code );
        result.append ( ')' );
        return result.toString ();
    }

} //MessageImpl
