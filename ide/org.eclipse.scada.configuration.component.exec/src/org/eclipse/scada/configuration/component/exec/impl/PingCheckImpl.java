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
package org.eclipse.scada.configuration.component.exec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.exec.ExecComponentsPackage;
import org.eclipse.scada.configuration.component.exec.PingCheck;
import org.eclipse.scada.configuration.infrastructure.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ping Check</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.impl.PingCheckImpl#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PingCheckImpl extends ExecJobImpl implements PingCheck
{
    /**
     * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNode()
     * @generated
     * @ordered
     */
    protected Node node;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PingCheckImpl ()
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
        return ExecComponentsPackage.Literals.PING_CHECK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Node getNode ()
    {
        if ( node != null && node.eIsProxy () )
        {
            InternalEObject oldNode = (InternalEObject)node;
            node = (Node)eResolveProxy ( oldNode );
            if ( node != oldNode )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ExecComponentsPackage.PING_CHECK__NODE, oldNode, node ) );
            }
        }
        return node;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Node basicGetNode ()
    {
        return node;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNode ( Node newNode )
    {
        Node oldNode = node;
        node = newNode;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ExecComponentsPackage.PING_CHECK__NODE, oldNode, node ) );
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
            case ExecComponentsPackage.PING_CHECK__NODE:
                if ( resolve )
                    return getNode ();
                return basicGetNode ();
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
            case ExecComponentsPackage.PING_CHECK__NODE:
                setNode ( (Node)newValue );
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
            case ExecComponentsPackage.PING_CHECK__NODE:
                setNode ( (Node)null );
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
            case ExecComponentsPackage.PING_CHECK__NODE:
                return node != null;
        }
        return super.eIsSet ( featureID );
    }

} //PingCheckImpl
