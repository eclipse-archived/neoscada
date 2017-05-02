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
import org.eclipse.scada.configuration.modbus.ModbusExporterModule;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exporter Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterModuleImpl#getDataOrder <em>Data Order</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterModuleImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModbusExporterModuleImpl extends MinimalEObjectImpl.Container implements ModbusExporterModule
{
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
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> properties;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModbusExporterModuleImpl ()
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
        return ModbusPackage.Literals.MODBUS_EXPORTER_MODULE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_EXPORTER_MODULE__DATA_ORDER, oldDataOrder, dataOrder ) );
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
            properties = new EObjectContainmentEList<PropertyEntry> ( PropertyEntry.class, this, ModbusPackage.MODBUS_EXPORTER_MODULE__PROPERTIES );
        }
        return properties;
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
            case ModbusPackage.MODBUS_EXPORTER_MODULE__PROPERTIES:
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
            case ModbusPackage.MODBUS_EXPORTER_MODULE__DATA_ORDER:
                return getDataOrder ();
            case ModbusPackage.MODBUS_EXPORTER_MODULE__PROPERTIES:
                return getProperties ();
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
            case ModbusPackage.MODBUS_EXPORTER_MODULE__DATA_ORDER:
                setDataOrder ( (ByteOrder)newValue );
                return;
            case ModbusPackage.MODBUS_EXPORTER_MODULE__PROPERTIES:
                getProperties ().clear ();
                getProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
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
            case ModbusPackage.MODBUS_EXPORTER_MODULE__DATA_ORDER:
                setDataOrder ( DATA_ORDER_EDEFAULT );
                return;
            case ModbusPackage.MODBUS_EXPORTER_MODULE__PROPERTIES:
                getProperties ().clear ();
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
            case ModbusPackage.MODBUS_EXPORTER_MODULE__DATA_ORDER:
                return dataOrder != DATA_ORDER_EDEFAULT;
            case ModbusPackage.MODBUS_EXPORTER_MODULE__PROPERTIES:
                return properties != null && !properties.isEmpty ();
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
        result.append ( " (dataOrder: " ); //$NON-NLS-1$
        result.append ( dataOrder );
        result.append ( ')' );
        return result.toString ();
    }

} //ModbusExporterModuleImpl
