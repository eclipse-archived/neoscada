/**
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.neoscada.configuration.iec60870.impl;

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
import org.eclipse.neoscada.configuration.iec60870.DataModuleOptions;
import org.eclipse.neoscada.configuration.iec60870.Device;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.neoscada.configuration.iec60870.Item;
import org.eclipse.neoscada.configuration.iec60870.ProtocolOptions;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl#getProtocolOptions <em>Protocol Options</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl#getDataModuleOptions <em>Data Module Options</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl#getHiveProperties <em>Hive Properties</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl#getSpontaneousBufferWindow <em>Spontaneous Buffer Window</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl#getCyclicPeriod <em>Cyclic Period</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeviceImpl extends MinimalEObjectImpl.Container implements Device
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
     * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItems()
     * @generated
     * @ordered
     */
    protected EList<Item> items;

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
     * The cached value of the '{@link #getProtocolOptions() <em>Protocol Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocolOptions()
     * @generated
     * @ordered
     */
    protected ProtocolOptions protocolOptions;

    /**
     * The cached value of the '{@link #getDataModuleOptions() <em>Data Module Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataModuleOptions()
     * @generated
     * @ordered
     */
    protected DataModuleOptions dataModuleOptions;

    /**
     * The cached value of the '{@link #getHiveProperties() <em>Hive Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHiveProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> hiveProperties;

    /**
     * The default value of the '{@link #getSpontaneousBufferWindow() <em>Spontaneous Buffer Window</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpontaneousBufferWindow()
     * @generated
     * @ordered
     */
    protected static final Long SPONTANEOUS_BUFFER_WINDOW_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSpontaneousBufferWindow() <em>Spontaneous Buffer Window</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpontaneousBufferWindow()
     * @generated
     * @ordered
     */
    protected Long spontaneousBufferWindow = SPONTANEOUS_BUFFER_WINDOW_EDEFAULT;

    /**
     * The default value of the '{@link #getCyclicPeriod() <em>Cyclic Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCyclicPeriod()
     * @generated
     * @ordered
     */
    protected static final Long CYCLIC_PERIOD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCyclicPeriod() <em>Cyclic Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCyclicPeriod()
     * @generated
     * @ordered
     */
    protected Long cyclicPeriod = CYCLIC_PERIOD_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DeviceImpl ()
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
        return IEC60870Package.Literals.DEVICE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DEVICE__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Item> getItems ()
    {
        if ( items == null )
        {
            items = new EObjectContainmentEList<Item> ( Item.class, this, IEC60870Package.DEVICE__ITEMS );
        }
        return items;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Endpoint getEndpoint ()
    {
        if ( endpoint != null && endpoint.eIsProxy () )
        {
            InternalEObject oldEndpoint = (InternalEObject)endpoint;
            endpoint = (Endpoint)eResolveProxy ( oldEndpoint );
            if ( endpoint != oldEndpoint )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, IEC60870Package.DEVICE__ENDPOINT, oldEndpoint, endpoint ) );
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
    @Override
    public void setEndpoint ( Endpoint newEndpoint )
    {
        Endpoint oldEndpoint = endpoint;
        endpoint = newEndpoint;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DEVICE__ENDPOINT, oldEndpoint, endpoint ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ProtocolOptions getProtocolOptions ()
    {
        return protocolOptions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProtocolOptions ( ProtocolOptions newProtocolOptions, NotificationChain msgs )
    {
        ProtocolOptions oldProtocolOptions = protocolOptions;
        protocolOptions = newProtocolOptions;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, IEC60870Package.DEVICE__PROTOCOL_OPTIONS, oldProtocolOptions, newProtocolOptions );
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
    @Override
    public void setProtocolOptions ( ProtocolOptions newProtocolOptions )
    {
        if ( newProtocolOptions != protocolOptions )
        {
            NotificationChain msgs = null;
            if ( protocolOptions != null )
                msgs = ( (InternalEObject)protocolOptions ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.DEVICE__PROTOCOL_OPTIONS, null, msgs );
            if ( newProtocolOptions != null )
                msgs = ( (InternalEObject)newProtocolOptions ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.DEVICE__PROTOCOL_OPTIONS, null, msgs );
            msgs = basicSetProtocolOptions ( newProtocolOptions, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DEVICE__PROTOCOL_OPTIONS, newProtocolOptions, newProtocolOptions ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataModuleOptions getDataModuleOptions ()
    {
        return dataModuleOptions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataModuleOptions ( DataModuleOptions newDataModuleOptions, NotificationChain msgs )
    {
        DataModuleOptions oldDataModuleOptions = dataModuleOptions;
        dataModuleOptions = newDataModuleOptions;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, IEC60870Package.DEVICE__DATA_MODULE_OPTIONS, oldDataModuleOptions, newDataModuleOptions );
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
    @Override
    public void setDataModuleOptions ( DataModuleOptions newDataModuleOptions )
    {
        if ( newDataModuleOptions != dataModuleOptions )
        {
            NotificationChain msgs = null;
            if ( dataModuleOptions != null )
                msgs = ( (InternalEObject)dataModuleOptions ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.DEVICE__DATA_MODULE_OPTIONS, null, msgs );
            if ( newDataModuleOptions != null )
                msgs = ( (InternalEObject)newDataModuleOptions ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.DEVICE__DATA_MODULE_OPTIONS, null, msgs );
            msgs = basicSetDataModuleOptions ( newDataModuleOptions, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DEVICE__DATA_MODULE_OPTIONS, newDataModuleOptions, newDataModuleOptions ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<PropertyEntry> getHiveProperties ()
    {
        if ( hiveProperties == null )
        {
            hiveProperties = new EObjectContainmentEList<PropertyEntry> ( PropertyEntry.class, this, IEC60870Package.DEVICE__HIVE_PROPERTIES );
        }
        return hiveProperties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Long getSpontaneousBufferWindow ()
    {
        return spontaneousBufferWindow;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSpontaneousBufferWindow ( Long newSpontaneousBufferWindow )
    {
        Long oldSpontaneousBufferWindow = spontaneousBufferWindow;
        spontaneousBufferWindow = newSpontaneousBufferWindow;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DEVICE__SPONTANEOUS_BUFFER_WINDOW, oldSpontaneousBufferWindow, spontaneousBufferWindow ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Long getCyclicPeriod ()
    {
        return cyclicPeriod;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCyclicPeriod ( Long newCyclicPeriod )
    {
        Long oldCyclicPeriod = cyclicPeriod;
        cyclicPeriod = newCyclicPeriod;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DEVICE__CYCLIC_PERIOD, oldCyclicPeriod, cyclicPeriod ) );
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
            case IEC60870Package.DEVICE__ITEMS:
                return ( (InternalEList<?>)getItems () ).basicRemove ( otherEnd, msgs );
            case IEC60870Package.DEVICE__PROTOCOL_OPTIONS:
                return basicSetProtocolOptions ( null, msgs );
            case IEC60870Package.DEVICE__DATA_MODULE_OPTIONS:
                return basicSetDataModuleOptions ( null, msgs );
            case IEC60870Package.DEVICE__HIVE_PROPERTIES:
                return ( (InternalEList<?>)getHiveProperties () ).basicRemove ( otherEnd, msgs );
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
            case IEC60870Package.DEVICE__ID:
                return getId ();
            case IEC60870Package.DEVICE__ITEMS:
                return getItems ();
            case IEC60870Package.DEVICE__ENDPOINT:
                if ( resolve )
                    return getEndpoint ();
                return basicGetEndpoint ();
            case IEC60870Package.DEVICE__PROTOCOL_OPTIONS:
                return getProtocolOptions ();
            case IEC60870Package.DEVICE__DATA_MODULE_OPTIONS:
                return getDataModuleOptions ();
            case IEC60870Package.DEVICE__HIVE_PROPERTIES:
                return getHiveProperties ();
            case IEC60870Package.DEVICE__SPONTANEOUS_BUFFER_WINDOW:
                return getSpontaneousBufferWindow ();
            case IEC60870Package.DEVICE__CYCLIC_PERIOD:
                return getCyclicPeriod ();
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
            case IEC60870Package.DEVICE__ID:
                setId ( (String)newValue );
                return;
            case IEC60870Package.DEVICE__ITEMS:
                getItems ().clear ();
                getItems ().addAll ( (Collection<? extends Item>)newValue );
                return;
            case IEC60870Package.DEVICE__ENDPOINT:
                setEndpoint ( (Endpoint)newValue );
                return;
            case IEC60870Package.DEVICE__PROTOCOL_OPTIONS:
                setProtocolOptions ( (ProtocolOptions)newValue );
                return;
            case IEC60870Package.DEVICE__DATA_MODULE_OPTIONS:
                setDataModuleOptions ( (DataModuleOptions)newValue );
                return;
            case IEC60870Package.DEVICE__HIVE_PROPERTIES:
                getHiveProperties ().clear ();
                getHiveProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
                return;
            case IEC60870Package.DEVICE__SPONTANEOUS_BUFFER_WINDOW:
                setSpontaneousBufferWindow ( (Long)newValue );
                return;
            case IEC60870Package.DEVICE__CYCLIC_PERIOD:
                setCyclicPeriod ( (Long)newValue );
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
            case IEC60870Package.DEVICE__ID:
                setId ( ID_EDEFAULT );
                return;
            case IEC60870Package.DEVICE__ITEMS:
                getItems ().clear ();
                return;
            case IEC60870Package.DEVICE__ENDPOINT:
                setEndpoint ( (Endpoint)null );
                return;
            case IEC60870Package.DEVICE__PROTOCOL_OPTIONS:
                setProtocolOptions ( (ProtocolOptions)null );
                return;
            case IEC60870Package.DEVICE__DATA_MODULE_OPTIONS:
                setDataModuleOptions ( (DataModuleOptions)null );
                return;
            case IEC60870Package.DEVICE__HIVE_PROPERTIES:
                getHiveProperties ().clear ();
                return;
            case IEC60870Package.DEVICE__SPONTANEOUS_BUFFER_WINDOW:
                setSpontaneousBufferWindow ( SPONTANEOUS_BUFFER_WINDOW_EDEFAULT );
                return;
            case IEC60870Package.DEVICE__CYCLIC_PERIOD:
                setCyclicPeriod ( CYCLIC_PERIOD_EDEFAULT );
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
            case IEC60870Package.DEVICE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case IEC60870Package.DEVICE__ITEMS:
                return items != null && !items.isEmpty ();
            case IEC60870Package.DEVICE__ENDPOINT:
                return endpoint != null;
            case IEC60870Package.DEVICE__PROTOCOL_OPTIONS:
                return protocolOptions != null;
            case IEC60870Package.DEVICE__DATA_MODULE_OPTIONS:
                return dataModuleOptions != null;
            case IEC60870Package.DEVICE__HIVE_PROPERTIES:
                return hiveProperties != null && !hiveProperties.isEmpty ();
            case IEC60870Package.DEVICE__SPONTANEOUS_BUFFER_WINDOW:
                return SPONTANEOUS_BUFFER_WINDOW_EDEFAULT == null ? spontaneousBufferWindow != null : !SPONTANEOUS_BUFFER_WINDOW_EDEFAULT.equals ( spontaneousBufferWindow );
            case IEC60870Package.DEVICE__CYCLIC_PERIOD:
                return CYCLIC_PERIOD_EDEFAULT == null ? cyclicPeriod != null : !CYCLIC_PERIOD_EDEFAULT.equals ( cyclicPeriod );
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
        result.append ( ", spontaneousBufferWindow: " ); //$NON-NLS-1$
        result.append ( spontaneousBufferWindow );
        result.append ( ", cyclicPeriod: " ); //$NON-NLS-1$
        result.append ( cyclicPeriod );
        result.append ( ')' );
        return result.toString ();
    }

} //DeviceImpl
