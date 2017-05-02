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
import org.eclipse.scada.configuration.modbus.ByteOrder;
import org.eclipse.scada.configuration.modbus.ModbusBlock;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.modbus.ModbusSlave;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slave</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusSlaveImpl#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusSlaveImpl#getUnitAddress <em>Unit Address</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusSlaveImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusSlaveImpl#getDataOrder <em>Data Order</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModbusSlaveImpl extends MinimalEObjectImpl.Container implements ModbusSlave
{
    /**
     * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlocks()
     * @generated
     * @ordered
     */
    protected EList<ModbusBlock> blocks;

    /**
     * The default value of the '{@link #getUnitAddress() <em>Unit Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUnitAddress()
     * @generated
     * @ordered
     */
    protected static final byte UNIT_ADDRESS_EDEFAULT = 0x00;

    /**
     * The cached value of the '{@link #getUnitAddress() <em>Unit Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUnitAddress()
     * @generated
     * @ordered
     */
    protected byte unitAddress = UNIT_ADDRESS_EDEFAULT;

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
     * The default value of the '{@link #getDataOrder() <em>Data Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataOrder()
     * @generated
     * @ordered
     */
    protected static final ByteOrder DATA_ORDER_EDEFAULT = ByteOrder.BIG_ENDIAN;

    /**
     * The cached value of the '{@link #getDataOrder() <em>Data Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataOrder()
     * @generated
     * @ordered
     */
    protected ByteOrder dataOrder = DATA_ORDER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModbusSlaveImpl ()
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
        return ModbusPackage.Literals.MODBUS_SLAVE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ModbusBlock> getBlocks ()
    {
        if ( blocks == null )
        {
            blocks = new EObjectContainmentEList<ModbusBlock> ( ModbusBlock.class, this, ModbusPackage.MODBUS_SLAVE__BLOCKS );
        }
        return blocks;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public byte getUnitAddress ()
    {
        return unitAddress;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUnitAddress ( byte newUnitAddress )
    {
        byte oldUnitAddress = unitAddress;
        unitAddress = newUnitAddress;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_SLAVE__UNIT_ADDRESS, oldUnitAddress, unitAddress ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_SLAVE__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ByteOrder getDataOrder ()
    {
        return dataOrder;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataOrder ( ByteOrder newDataOrder )
    {
        ByteOrder oldDataOrder = dataOrder;
        dataOrder = newDataOrder == null ? DATA_ORDER_EDEFAULT : newDataOrder;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_SLAVE__DATA_ORDER, oldDataOrder, dataOrder ) );
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
            case ModbusPackage.MODBUS_SLAVE__BLOCKS:
                return ( (InternalEList<?>)getBlocks () ).basicRemove ( otherEnd, msgs );
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
            case ModbusPackage.MODBUS_SLAVE__BLOCKS:
                return getBlocks ();
            case ModbusPackage.MODBUS_SLAVE__UNIT_ADDRESS:
                return getUnitAddress ();
            case ModbusPackage.MODBUS_SLAVE__ID:
                return getId ();
            case ModbusPackage.MODBUS_SLAVE__DATA_ORDER:
                return getDataOrder ();
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
            case ModbusPackage.MODBUS_SLAVE__BLOCKS:
                getBlocks ().clear ();
                getBlocks ().addAll ( (Collection<? extends ModbusBlock>)newValue );
                return;
            case ModbusPackage.MODBUS_SLAVE__UNIT_ADDRESS:
                setUnitAddress ( (Byte)newValue );
                return;
            case ModbusPackage.MODBUS_SLAVE__ID:
                setId ( (String)newValue );
                return;
            case ModbusPackage.MODBUS_SLAVE__DATA_ORDER:
                setDataOrder ( (ByteOrder)newValue );
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
            case ModbusPackage.MODBUS_SLAVE__BLOCKS:
                getBlocks ().clear ();
                return;
            case ModbusPackage.MODBUS_SLAVE__UNIT_ADDRESS:
                setUnitAddress ( UNIT_ADDRESS_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_SLAVE__ID:
                setId ( ID_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_SLAVE__DATA_ORDER:
                setDataOrder ( DATA_ORDER_EDEFAULT );
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
            case ModbusPackage.MODBUS_SLAVE__BLOCKS:
                return blocks != null && !blocks.isEmpty ();
            case ModbusPackage.MODBUS_SLAVE__UNIT_ADDRESS:
                return unitAddress != UNIT_ADDRESS_EDEFAULT;
            case ModbusPackage.MODBUS_SLAVE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case ModbusPackage.MODBUS_SLAVE__DATA_ORDER:
                return dataOrder != DATA_ORDER_EDEFAULT;
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
        result.append ( " (unitAddress: " ); //$NON-NLS-1$
        result.append ( unitAddress );
        result.append ( ", id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ", dataOrder: " ); //$NON-NLS-1$
        result.append ( dataOrder );
        result.append ( ')' );
        return result.toString ();
    }

} //ModbusSlaveImpl
