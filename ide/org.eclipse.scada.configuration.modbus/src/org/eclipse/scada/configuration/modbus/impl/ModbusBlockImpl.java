/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.modbus.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.memory.TypeDefinition;
import org.eclipse.scada.configuration.modbus.ModbusBlock;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.da.server.osgi.modbus.RequestType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl#getBlockType <em>Block Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl#getStartAddress <em>Start Address</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModbusBlockImpl extends MinimalEObjectImpl.Container implements ModbusBlock
{
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
     * The default value of the '{@link #getBlockType() <em>Block Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlockType()
     * @generated
     * @ordered
     */
    protected static final RequestType BLOCK_TYPE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBlockType() <em>Block Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlockType()
     * @generated
     * @ordered
     */
    protected RequestType blockType = BLOCK_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getStartAddress() <em>Start Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStartAddress()
     * @generated
     * @ordered
     */
    protected static final int START_ADDRESS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getStartAddress() <em>Start Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStartAddress()
     * @generated
     * @ordered
     */
    protected int startAddress = START_ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCount()
     * @generated
     * @ordered
     */
    protected static final int COUNT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCount()
     * @generated
     * @ordered
     */
    protected int count = COUNT_EDEFAULT;

    /**
     * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected static final long PERIOD_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected long period = PERIOD_EDEFAULT;

    /**
     * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout()
     * @generated
     * @ordered
     */
    protected static final long TIMEOUT_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout()
     * @generated
     * @ordered
     */
    protected long timeout = TIMEOUT_EDEFAULT;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected TypeDefinition type;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModbusBlockImpl ()
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
        return ModbusPackage.Literals.MODBUS_BLOCK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TypeDefinition getType ()
    {
        if ( type != null && type.eIsProxy () )
        {
            InternalEObject oldType = (InternalEObject)type;
            type = (TypeDefinition)eResolveProxy ( oldType );
            if ( type != oldType )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ModbusPackage.MODBUS_BLOCK__TYPE, oldType, type ) );
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeDefinition basicGetType ()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setType ( TypeDefinition newType )
    {
        TypeDefinition oldType = type;
        type = newType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_BLOCK__TYPE, oldType, type ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public RequestType getBlockType ()
    {
        return blockType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setBlockType ( RequestType newBlockType )
    {
        RequestType oldBlockType = blockType;
        blockType = newBlockType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_BLOCK__BLOCK_TYPE, oldBlockType, blockType ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getStartAddress ()
    {
        return startAddress;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setStartAddress ( int newStartAddress )
    {
        int oldStartAddress = startAddress;
        startAddress = newStartAddress;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_BLOCK__START_ADDRESS, oldStartAddress, startAddress ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getCount ()
    {
        return count;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setCount ( int newCount )
    {
        int oldCount = count;
        count = newCount;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_BLOCK__COUNT, oldCount, count ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public long getPeriod ()
    {
        return period;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPeriod ( long newPeriod )
    {
        long oldPeriod = period;
        period = newPeriod;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_BLOCK__PERIOD, oldPeriod, period ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public long getTimeout ()
    {
        return timeout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTimeout ( long newTimeout )
    {
        long oldTimeout = timeout;
        timeout = newTimeout;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_BLOCK__TIMEOUT, oldTimeout, timeout ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_BLOCK__ID, oldId, id ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_BLOCK__NAME, oldName, name ) );
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
            case ModbusPackage.MODBUS_BLOCK__ID:
                return getId ();
            case ModbusPackage.MODBUS_BLOCK__NAME:
                return getName ();
            case ModbusPackage.MODBUS_BLOCK__BLOCK_TYPE:
                return getBlockType ();
            case ModbusPackage.MODBUS_BLOCK__START_ADDRESS:
                return getStartAddress ();
            case ModbusPackage.MODBUS_BLOCK__COUNT:
                return getCount ();
            case ModbusPackage.MODBUS_BLOCK__PERIOD:
                return getPeriod ();
            case ModbusPackage.MODBUS_BLOCK__TIMEOUT:
                return getTimeout ();
            case ModbusPackage.MODBUS_BLOCK__TYPE:
                if ( resolve )
                    return getType ();
                return basicGetType ();
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
            case ModbusPackage.MODBUS_BLOCK__ID:
                setId ( (String)newValue );
                return;
            case ModbusPackage.MODBUS_BLOCK__NAME:
                setName ( (String)newValue );
                return;
            case ModbusPackage.MODBUS_BLOCK__BLOCK_TYPE:
                setBlockType ( (RequestType)newValue );
                return;
            case ModbusPackage.MODBUS_BLOCK__START_ADDRESS:
                setStartAddress ( (Integer)newValue );
                return;
            case ModbusPackage.MODBUS_BLOCK__COUNT:
                setCount ( (Integer)newValue );
                return;
            case ModbusPackage.MODBUS_BLOCK__PERIOD:
                setPeriod ( (Long)newValue );
                return;
            case ModbusPackage.MODBUS_BLOCK__TIMEOUT:
                setTimeout ( (Long)newValue );
                return;
            case ModbusPackage.MODBUS_BLOCK__TYPE:
                setType ( (TypeDefinition)newValue );
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
            case ModbusPackage.MODBUS_BLOCK__ID:
                setId ( ID_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_BLOCK__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_BLOCK__BLOCK_TYPE:
                setBlockType ( BLOCK_TYPE_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_BLOCK__START_ADDRESS:
                setStartAddress ( START_ADDRESS_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_BLOCK__COUNT:
                setCount ( COUNT_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_BLOCK__PERIOD:
                setPeriod ( PERIOD_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_BLOCK__TIMEOUT:
                setTimeout ( TIMEOUT_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_BLOCK__TYPE:
                setType ( (TypeDefinition)null );
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
            case ModbusPackage.MODBUS_BLOCK__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case ModbusPackage.MODBUS_BLOCK__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ModbusPackage.MODBUS_BLOCK__BLOCK_TYPE:
                return BLOCK_TYPE_EDEFAULT == null ? blockType != null : !BLOCK_TYPE_EDEFAULT.equals ( blockType );
            case ModbusPackage.MODBUS_BLOCK__START_ADDRESS:
                return startAddress != START_ADDRESS_EDEFAULT;
            case ModbusPackage.MODBUS_BLOCK__COUNT:
                return count != COUNT_EDEFAULT;
            case ModbusPackage.MODBUS_BLOCK__PERIOD:
                return period != PERIOD_EDEFAULT;
            case ModbusPackage.MODBUS_BLOCK__TIMEOUT:
                return timeout != TIMEOUT_EDEFAULT;
            case ModbusPackage.MODBUS_BLOCK__TYPE:
                return type != null;
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
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", blockType: " ); //$NON-NLS-1$
        result.append ( blockType );
        result.append ( ", startAddress: " ); //$NON-NLS-1$
        result.append ( startAddress );
        result.append ( ", count: " ); //$NON-NLS-1$
        result.append ( count );
        result.append ( ", period: " ); //$NON-NLS-1$
        result.append ( period );
        result.append ( ", timeout: " ); //$NON-NLS-1$
        result.append ( timeout );
        result.append ( ')' );
        return result.toString ();
    }

} //ModbusBlockImpl
