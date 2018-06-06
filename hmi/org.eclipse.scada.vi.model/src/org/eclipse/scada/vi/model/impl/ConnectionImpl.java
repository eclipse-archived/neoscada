/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.scada.vi.model.Connection;
import org.eclipse.scada.vi.model.Primitive;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.ConnectionImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.ConnectionImpl#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionImpl extends EObjectImpl implements Connection
{
    /**
     * The cached value of the '{@link #getStart() <em>Start</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStart()
     * @generated
     * @ordered
     */
    protected Primitive start;

    /**
     * The cached value of the '{@link #getEnd() <em>End</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnd()
     * @generated
     * @ordered
     */
    protected Primitive end;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConnectionImpl ()
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
        return VisualInterfacePackage.Literals.CONNECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Primitive getStart ()
    {
        if ( start != null && start.eIsProxy () )
        {
            InternalEObject oldStart = (InternalEObject)start;
            start = (Primitive)eResolveProxy ( oldStart );
            if ( start != oldStart )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, VisualInterfacePackage.CONNECTION__START, oldStart, start ) );
            }
        }
        return start;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Primitive basicGetStart ()
    {
        return start;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStart ( Primitive newStart )
    {
        Primitive oldStart = start;
        start = newStart;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.CONNECTION__START, oldStart, start ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Primitive getEnd ()
    {
        if ( end != null && end.eIsProxy () )
        {
            InternalEObject oldEnd = (InternalEObject)end;
            end = (Primitive)eResolveProxy ( oldEnd );
            if ( end != oldEnd )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, VisualInterfacePackage.CONNECTION__END, oldEnd, end ) );
            }
        }
        return end;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Primitive basicGetEnd ()
    {
        return end;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnd ( Primitive newEnd )
    {
        Primitive oldEnd = end;
        end = newEnd;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.CONNECTION__END, oldEnd, end ) );
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
            case VisualInterfacePackage.CONNECTION__START:
                if ( resolve )
                    return getStart ();
                return basicGetStart ();
            case VisualInterfacePackage.CONNECTION__END:
                if ( resolve )
                    return getEnd ();
                return basicGetEnd ();
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
            case VisualInterfacePackage.CONNECTION__START:
                setStart ( (Primitive)newValue );
                return;
            case VisualInterfacePackage.CONNECTION__END:
                setEnd ( (Primitive)newValue );
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
            case VisualInterfacePackage.CONNECTION__START:
                setStart ( (Primitive)null );
                return;
            case VisualInterfacePackage.CONNECTION__END:
                setEnd ( (Primitive)null );
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
            case VisualInterfacePackage.CONNECTION__START:
                return start != null;
            case VisualInterfacePackage.CONNECTION__END:
                return end != null;
        }
        return super.eIsSet ( featureID );
    }

} //ConnectionImpl
