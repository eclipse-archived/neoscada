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
package org.eclipse.scada.configuration.modbus.impl;

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
import org.eclipse.scada.configuration.modbus.ModbusMaster;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.modbus.ModbusSlave;
import org.eclipse.scada.configuration.modbus.ProtocolType;
import org.eclipse.scada.configuration.world.Endpoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Master</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusMasterImpl#getSlaves <em>Slaves</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusMasterImpl#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusMasterImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusMasterImpl#getProtocolType <em>Protocol Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusMasterImpl#getInterFrameDelay <em>Inter Frame Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModbusMasterImpl extends MinimalEObjectImpl.Container implements ModbusMaster
{
    /**
     * The cached value of the '{@link #getSlaves() <em>Slaves</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSlaves()
     * @generated
     * @ordered
     */
    protected EList<ModbusSlave> slaves;

    /**
     * The cached value of the '{@link #getEndpoint() <em>Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpoint()
     * @generated
     * @ordered
     */
    protected Endpoint endpoint;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getProtocolType() <em>Protocol Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocolType()
     * @generated
     * @ordered
     */
    protected static final ProtocolType PROTOCOL_TYPE_EDEFAULT = ProtocolType.TCP;

    /**
     * The cached value of the '{@link #getProtocolType() <em>Protocol Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocolType()
     * @generated
     * @ordered
     */
    protected ProtocolType protocolType = PROTOCOL_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getInterFrameDelay() <em>Inter Frame Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInterFrameDelay()
     * @generated
     * @ordered
     */
    protected static final Double INTER_FRAME_DELAY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInterFrameDelay() <em>Inter Frame Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInterFrameDelay()
     * @generated
     * @ordered
     */
    protected Double interFrameDelay = INTER_FRAME_DELAY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModbusMasterImpl ()
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
        return ModbusPackage.Literals.MODBUS_MASTER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ModbusSlave> getSlaves ()
    {
        if ( slaves == null )
        {
            slaves = new EObjectContainmentEList<ModbusSlave> ( ModbusSlave.class, this, ModbusPackage.MODBUS_MASTER__SLAVES );
        }
        return slaves;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Endpoint getEndpoint ()
    {
        if ( endpoint != null && endpoint.eIsProxy () )
        {
            InternalEObject oldEndpoint = (InternalEObject)endpoint;
            endpoint = (Endpoint)eResolveProxy ( oldEndpoint );
            if ( endpoint != oldEndpoint )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ModbusPackage.MODBUS_MASTER__ENDPOINT, oldEndpoint, endpoint ) );
            }
        }
        return endpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Endpoint basicGetEndpoint ()
    {
        return endpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEndpoint ( Endpoint newEndpoint )
    {
        Endpoint oldEndpoint = endpoint;
        endpoint = newEndpoint;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_MASTER__ENDPOINT, oldEndpoint, endpoint ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_MASTER__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProtocolType getProtocolType ()
    {
        return protocolType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProtocolType ( ProtocolType newProtocolType )
    {
        ProtocolType oldProtocolType = protocolType;
        protocolType = newProtocolType == null ? PROTOCOL_TYPE_EDEFAULT : newProtocolType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_MASTER__PROTOCOL_TYPE, oldProtocolType, protocolType ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Double getInterFrameDelay ()
    {
        return interFrameDelay;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInterFrameDelay ( Double newInterFrameDelay )
    {
        Double oldInterFrameDelay = interFrameDelay;
        interFrameDelay = newInterFrameDelay;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_MASTER__INTER_FRAME_DELAY, oldInterFrameDelay, interFrameDelay ) );
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
            case ModbusPackage.MODBUS_MASTER__SLAVES:
                return ( (InternalEList<?>)getSlaves () ).basicRemove ( otherEnd, msgs );
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
            case ModbusPackage.MODBUS_MASTER__SLAVES:
                return getSlaves ();
            case ModbusPackage.MODBUS_MASTER__ENDPOINT:
                if ( resolve )
                    return getEndpoint ();
                return basicGetEndpoint ();
            case ModbusPackage.MODBUS_MASTER__ID:
                return getId ();
            case ModbusPackage.MODBUS_MASTER__PROTOCOL_TYPE:
                return getProtocolType ();
            case ModbusPackage.MODBUS_MASTER__INTER_FRAME_DELAY:
                return getInterFrameDelay ();
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
            case ModbusPackage.MODBUS_MASTER__SLAVES:
                getSlaves ().clear ();
                getSlaves ().addAll ( (Collection<? extends ModbusSlave>)newValue );
                return;
            case ModbusPackage.MODBUS_MASTER__ENDPOINT:
                setEndpoint ( (Endpoint)newValue );
                return;
            case ModbusPackage.MODBUS_MASTER__ID:
                setId ( (String)newValue );
                return;
            case ModbusPackage.MODBUS_MASTER__PROTOCOL_TYPE:
                setProtocolType ( (ProtocolType)newValue );
                return;
            case ModbusPackage.MODBUS_MASTER__INTER_FRAME_DELAY:
                setInterFrameDelay ( (Double)newValue );
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
            case ModbusPackage.MODBUS_MASTER__SLAVES:
                getSlaves ().clear ();
                return;
            case ModbusPackage.MODBUS_MASTER__ENDPOINT:
                setEndpoint ( (Endpoint)null );
                return;
            case ModbusPackage.MODBUS_MASTER__ID:
                setId ( ID_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_MASTER__PROTOCOL_TYPE:
                setProtocolType ( PROTOCOL_TYPE_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_MASTER__INTER_FRAME_DELAY:
                setInterFrameDelay ( INTER_FRAME_DELAY_EDEFAULT );
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
            case ModbusPackage.MODBUS_MASTER__SLAVES:
                return slaves != null && !slaves.isEmpty ();
            case ModbusPackage.MODBUS_MASTER__ENDPOINT:
                return endpoint != null;
            case ModbusPackage.MODBUS_MASTER__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case ModbusPackage.MODBUS_MASTER__PROTOCOL_TYPE:
                return protocolType != PROTOCOL_TYPE_EDEFAULT;
            case ModbusPackage.MODBUS_MASTER__INTER_FRAME_DELAY:
                return INTER_FRAME_DELAY_EDEFAULT == null ? interFrameDelay != null : !INTER_FRAME_DELAY_EDEFAULT.equals ( interFrameDelay );
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
        result.append ( " (id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ", protocolType: " ); //$NON-NLS-1$
        result.append ( protocolType );
        result.append ( ", interFrameDelay: " ); //$NON-NLS-1$
        result.append ( interFrameDelay );
        result.append ( ')' );
        return result.toString ();
    }

} //ModbusMasterImpl
