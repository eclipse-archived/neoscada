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
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.infrastructure.ExternalDriver;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.world.Credentials;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverImpl#getPortNumber <em>Port Number</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverImpl#getAccessCredentials <em>Access Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverImpl#isBinding <em>Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalDriverImpl extends DriverImpl implements ExternalDriver
{
    /**
     * The default value of the '{@link #getPortNumber() <em>Port Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPortNumber()
     * @generated
     * @ordered
     */
    protected static final int PORT_NUMBER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPortNumber() <em>Port Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPortNumber()
     * @generated
     * @ordered
     */
    protected int portNumber = PORT_NUMBER_EDEFAULT;

    /**
     * The cached value of the '{@link #getAccessCredentials() <em>Access Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAccessCredentials()
     * @generated
     * @ordered
     */
    protected Credentials accessCredentials;

    /**
     * The default value of the '{@link #isBinding() <em>Binding</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isBinding()
     * @generated
     * @ordered
     */
    protected static final boolean BINDING_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isBinding() <em>Binding</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isBinding()
     * @generated
     * @ordered
     */
    protected boolean binding = BINDING_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExternalDriverImpl ()
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
        return InfrastructurePackage.Literals.EXTERNAL_DRIVER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPortNumber ()
    {
        return portNumber;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPortNumber ( int newPortNumber )
    {
        int oldPortNumber = portNumber;
        portNumber = newPortNumber;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EXTERNAL_DRIVER__PORT_NUMBER, oldPortNumber, portNumber ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials getAccessCredentials ()
    {
        if ( accessCredentials != null && accessCredentials.eIsProxy () )
        {
            InternalEObject oldAccessCredentials = (InternalEObject)accessCredentials;
            accessCredentials = (Credentials)eResolveProxy ( oldAccessCredentials );
            if ( accessCredentials != oldAccessCredentials )
            {
                InternalEObject newAccessCredentials = (InternalEObject)accessCredentials;
                NotificationChain msgs = oldAccessCredentials.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS, null, null );
                if ( newAccessCredentials.eInternalContainer () == null )
                {
                    msgs = newAccessCredentials.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS, oldAccessCredentials, accessCredentials ) );
            }
        }
        return accessCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials basicGetAccessCredentials ()
    {
        return accessCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetAccessCredentials ( Credentials newAccessCredentials, NotificationChain msgs )
    {
        Credentials oldAccessCredentials = accessCredentials;
        accessCredentials = newAccessCredentials;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS, oldAccessCredentials, newAccessCredentials );
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
    public void setAccessCredentials ( Credentials newAccessCredentials )
    {
        if ( newAccessCredentials != accessCredentials )
        {
            NotificationChain msgs = null;
            if ( accessCredentials != null )
                msgs = ( (InternalEObject)accessCredentials ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS, null, msgs );
            if ( newAccessCredentials != null )
                msgs = ( (InternalEObject)newAccessCredentials ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS, null, msgs );
            msgs = basicSetAccessCredentials ( newAccessCredentials, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS, newAccessCredentials, newAccessCredentials ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isBinding ()
    {
        return binding;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBinding ( boolean newBinding )
    {
        boolean oldBinding = binding;
        binding = newBinding;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.EXTERNAL_DRIVER__BINDING, oldBinding, binding ) );
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
            case InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS:
                return basicSetAccessCredentials ( null, msgs );
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
            case InfrastructurePackage.EXTERNAL_DRIVER__PORT_NUMBER:
                return getPortNumber ();
            case InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS:
                if ( resolve )
                    return getAccessCredentials ();
                return basicGetAccessCredentials ();
            case InfrastructurePackage.EXTERNAL_DRIVER__BINDING:
                return isBinding ();
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
            case InfrastructurePackage.EXTERNAL_DRIVER__PORT_NUMBER:
                setPortNumber ( (Integer)newValue );
                return;
            case InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS:
                setAccessCredentials ( (Credentials)newValue );
                return;
            case InfrastructurePackage.EXTERNAL_DRIVER__BINDING:
                setBinding ( (Boolean)newValue );
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
            case InfrastructurePackage.EXTERNAL_DRIVER__PORT_NUMBER:
                setPortNumber ( PORT_NUMBER_EDEFAULT );
                return;
            case InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS:
                setAccessCredentials ( (Credentials)null );
                return;
            case InfrastructurePackage.EXTERNAL_DRIVER__BINDING:
                setBinding ( BINDING_EDEFAULT );
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
            case InfrastructurePackage.EXTERNAL_DRIVER__PORT_NUMBER:
                return portNumber != PORT_NUMBER_EDEFAULT;
            case InfrastructurePackage.EXTERNAL_DRIVER__ACCESS_CREDENTIALS:
                return accessCredentials != null;
            case InfrastructurePackage.EXTERNAL_DRIVER__BINDING:
                return binding != BINDING_EDEFAULT;
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
        result.append ( " (portNumber: " ); //$NON-NLS-1$
        result.append ( portNumber );
        result.append ( ", binding: " ); //$NON-NLS-1$
        result.append ( binding );
        result.append ( ')' );
        return result.toString ();
    }

} //ExternalDriverImpl
