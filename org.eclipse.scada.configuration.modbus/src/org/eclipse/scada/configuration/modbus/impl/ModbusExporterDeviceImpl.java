/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
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
import org.eclipse.scada.configuration.modbus.ModbusExporterDevice;
import org.eclipse.scada.configuration.modbus.ModbusExporterItem;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exporter Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterDeviceImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterDeviceImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterDeviceImpl#getSlaveId <em>Slave Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterDeviceImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterDeviceImpl#getDataOrder <em>Data Order</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModbusExporterDeviceImpl extends MinimalEObjectImpl.Container implements ModbusExporterDevice
{
    /**
     * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItems()
     * @generated
     * @ordered
     */
    protected EList<ModbusExporterItem> items;

    /**
     * The cached value of the '{@link #getPort() <em>Port</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected Endpoint port;

    /**
     * The default value of the '{@link #getSlaveId() <em>Slave Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSlaveId()
     * @generated
     * @ordered
     */
    protected static final int SLAVE_ID_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSlaveId() <em>Slave Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSlaveId()
     * @generated
     * @ordered
     */
    protected int slaveId = SLAVE_ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> properties;

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
    protected ModbusExporterDeviceImpl ()
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
        return ModbusPackage.Literals.MODBUS_EXPORTER_DEVICE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ModbusExporterItem> getItems ()
    {
        if ( items == null )
        {
            items = new EObjectContainmentEList<ModbusExporterItem> ( ModbusExporterItem.class, this, ModbusPackage.MODBUS_EXPORTER_DEVICE__ITEMS );
        }
        return items;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Endpoint getPort ()
    {
        if ( port != null && port.eIsProxy () )
        {
            InternalEObject oldPort = (InternalEObject)port;
            port = (Endpoint)eResolveProxy ( oldPort );
            if ( port != oldPort )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ModbusPackage.MODBUS_EXPORTER_DEVICE__PORT, oldPort, port ) );
            }
        }
        return port;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Endpoint basicGetPort ()
    {
        return port;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPort ( Endpoint newPort )
    {
        Endpoint oldPort = port;
        port = newPort;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_EXPORTER_DEVICE__PORT, oldPort, port ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getSlaveId ()
    {
        return slaveId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSlaveId ( int newSlaveId )
    {
        int oldSlaveId = slaveId;
        slaveId = newSlaveId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_EXPORTER_DEVICE__SLAVE_ID, oldSlaveId, slaveId ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getProperties ()
    {
        if ( properties == null )
        {
            properties = new EObjectContainmentEList<PropertyEntry> ( PropertyEntry.class, this, ModbusPackage.MODBUS_EXPORTER_DEVICE__PROPERTIES );
        }
        return properties;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_EXPORTER_DEVICE__DATA_ORDER, oldDataOrder, dataOrder ) );
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
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__ITEMS:
                return ( (InternalEList<?>)getItems () ).basicRemove ( otherEnd, msgs );
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__PROPERTIES:
                return ( (InternalEList<?>)getProperties () ).basicRemove ( otherEnd, msgs );
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
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__ITEMS:
                return getItems ();
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__PORT:
                if ( resolve )
                    return getPort ();
                return basicGetPort ();
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__SLAVE_ID:
                return getSlaveId ();
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__PROPERTIES:
                return getProperties ();
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__DATA_ORDER:
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
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__ITEMS:
                getItems ().clear ();
                getItems ().addAll ( (Collection<? extends ModbusExporterItem>)newValue );
                return;
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__PORT:
                setPort ( (Endpoint)newValue );
                return;
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__SLAVE_ID:
                setSlaveId ( (Integer)newValue );
                return;
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__PROPERTIES:
                getProperties ().clear ();
                getProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
                return;
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__DATA_ORDER:
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
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__ITEMS:
                getItems ().clear ();
                return;
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__PORT:
                setPort ( (Endpoint)null );
                return;
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__SLAVE_ID:
                setSlaveId ( SLAVE_ID_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__PROPERTIES:
                getProperties ().clear ();
                return;
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__DATA_ORDER:
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
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__ITEMS:
                return items != null && !items.isEmpty ();
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__PORT:
                return port != null;
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__SLAVE_ID:
                return slaveId != SLAVE_ID_EDEFAULT;
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__PROPERTIES:
                return properties != null && !properties.isEmpty ();
            case ModbusPackage.MODBUS_EXPORTER_DEVICE__DATA_ORDER:
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
        result.append ( " (slaveId: " ); //$NON-NLS-1$
        result.append ( slaveId );
        result.append ( ", dataOrder: " ); //$NON-NLS-1$
        result.append ( dataOrder );
        result.append ( ')' );
        return result.toString ();
    }

} //ModbusExporterDeviceImpl
