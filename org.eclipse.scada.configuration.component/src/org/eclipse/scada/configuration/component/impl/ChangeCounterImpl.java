/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.configuration.component.BufferedValue;
import org.eclipse.scada.configuration.component.ChangeCounter;
import org.eclipse.scada.configuration.component.ComponentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Counter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ChangeCounterImpl#getBuffer <em>Buffer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangeCounterImpl extends SingleValueImpl implements ChangeCounter
{
    /**
     * The cached value of the '{@link #getBuffer() <em>Buffer</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuffer()
     * @generated
     * @ordered
     */
    protected BufferedValue buffer;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChangeCounterImpl ()
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
        return ComponentPackage.Literals.CHANGE_COUNTER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BufferedValue getBuffer ()
    {
        if ( buffer != null && buffer.eIsProxy () )
        {
            InternalEObject oldBuffer = (InternalEObject)buffer;
            buffer = (BufferedValue)eResolveProxy ( oldBuffer );
            if ( buffer != oldBuffer )
            {
                InternalEObject newBuffer = (InternalEObject)buffer;
                NotificationChain msgs = oldBuffer.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.CHANGE_COUNTER__BUFFER, null, null );
                if ( newBuffer.eInternalContainer () == null )
                {
                    msgs = newBuffer.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.CHANGE_COUNTER__BUFFER, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.CHANGE_COUNTER__BUFFER, oldBuffer, buffer ) );
            }
        }
        return buffer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BufferedValue basicGetBuffer ()
    {
        return buffer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetBuffer ( BufferedValue newBuffer, NotificationChain msgs )
    {
        BufferedValue oldBuffer = buffer;
        buffer = newBuffer;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.CHANGE_COUNTER__BUFFER, oldBuffer, newBuffer );
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
    public void setBuffer ( BufferedValue newBuffer )
    {
        if ( newBuffer != buffer )
        {
            NotificationChain msgs = null;
            if ( buffer != null )
                msgs = ( (InternalEObject)buffer ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.CHANGE_COUNTER__BUFFER, null, msgs );
            if ( newBuffer != null )
                msgs = ( (InternalEObject)newBuffer ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.CHANGE_COUNTER__BUFFER, null, msgs );
            msgs = basicSetBuffer ( newBuffer, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.CHANGE_COUNTER__BUFFER, newBuffer, newBuffer ) );
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
            case ComponentPackage.CHANGE_COUNTER__BUFFER:
                return basicSetBuffer ( null, msgs );
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
            case ComponentPackage.CHANGE_COUNTER__BUFFER:
                if ( resolve )
                    return getBuffer ();
                return basicGetBuffer ();
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
            case ComponentPackage.CHANGE_COUNTER__BUFFER:
                setBuffer ( (BufferedValue)newValue );
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
            case ComponentPackage.CHANGE_COUNTER__BUFFER:
                setBuffer ( (BufferedValue)null );
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
            case ComponentPackage.CHANGE_COUNTER__BUFFER:
                return buffer != null;
        }
        return super.eIsSet ( featureID );
    }

} //ChangeCounterImpl
