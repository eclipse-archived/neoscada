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
import org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions;
import org.eclipse.neoscada.configuration.iec60870.ClientDevice;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.neoscada.configuration.iec60870.ItemType;
import org.eclipse.neoscada.configuration.iec60870.ProtocolOptions;
import org.eclipse.scada.configuration.world.Endpoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Client Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDeviceImpl#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDeviceImpl#getProtocolOptions <em>Protocol Options</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDeviceImpl#getDataModuleOptions <em>Data Module Options</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDeviceImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDeviceImpl#getItemTypes <em>Item Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClientDeviceImpl extends MinimalEObjectImpl.Container implements ClientDevice
{
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
    protected ClientDataModuleOptions dataModuleOptions;

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
     * The cached value of the '{@link #getItemTypes() <em>Item Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemTypes()
     * @generated
     * @ordered
     */
    protected EList<ItemType> itemTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ClientDeviceImpl ()
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
        return IEC60870Package.Literals.CLIENT_DEVICE;
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, IEC60870Package.CLIENT_DEVICE__ENDPOINT, oldEndpoint, endpoint ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.CLIENT_DEVICE__ENDPOINT, oldEndpoint, endpoint ) );
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
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, IEC60870Package.CLIENT_DEVICE__PROTOCOL_OPTIONS, oldProtocolOptions, newProtocolOptions );
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
                msgs = ( (InternalEObject)protocolOptions ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.CLIENT_DEVICE__PROTOCOL_OPTIONS, null, msgs );
            if ( newProtocolOptions != null )
                msgs = ( (InternalEObject)newProtocolOptions ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.CLIENT_DEVICE__PROTOCOL_OPTIONS, null, msgs );
            msgs = basicSetProtocolOptions ( newProtocolOptions, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.CLIENT_DEVICE__PROTOCOL_OPTIONS, newProtocolOptions, newProtocolOptions ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ClientDataModuleOptions getDataModuleOptions ()
    {
        return dataModuleOptions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataModuleOptions ( ClientDataModuleOptions newDataModuleOptions, NotificationChain msgs )
    {
        ClientDataModuleOptions oldDataModuleOptions = dataModuleOptions;
        dataModuleOptions = newDataModuleOptions;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, IEC60870Package.CLIENT_DEVICE__DATA_MODULE_OPTIONS, oldDataModuleOptions, newDataModuleOptions );
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
    public void setDataModuleOptions ( ClientDataModuleOptions newDataModuleOptions )
    {
        if ( newDataModuleOptions != dataModuleOptions )
        {
            NotificationChain msgs = null;
            if ( dataModuleOptions != null )
                msgs = ( (InternalEObject)dataModuleOptions ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.CLIENT_DEVICE__DATA_MODULE_OPTIONS, null, msgs );
            if ( newDataModuleOptions != null )
                msgs = ( (InternalEObject)newDataModuleOptions ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.CLIENT_DEVICE__DATA_MODULE_OPTIONS, null, msgs );
            msgs = basicSetDataModuleOptions ( newDataModuleOptions, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.CLIENT_DEVICE__DATA_MODULE_OPTIONS, newDataModuleOptions, newDataModuleOptions ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.CLIENT_DEVICE__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ItemType> getItemTypes ()
    {
        if ( itemTypes == null )
        {
            itemTypes = new EObjectContainmentEList<ItemType> ( ItemType.class, this, IEC60870Package.CLIENT_DEVICE__ITEM_TYPES );
        }
        return itemTypes;
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
            case IEC60870Package.CLIENT_DEVICE__PROTOCOL_OPTIONS:
                return basicSetProtocolOptions ( null, msgs );
            case IEC60870Package.CLIENT_DEVICE__DATA_MODULE_OPTIONS:
                return basicSetDataModuleOptions ( null, msgs );
            case IEC60870Package.CLIENT_DEVICE__ITEM_TYPES:
                return ( (InternalEList<?>)getItemTypes () ).basicRemove ( otherEnd, msgs );
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
            case IEC60870Package.CLIENT_DEVICE__ENDPOINT:
                if ( resolve )
                    return getEndpoint ();
                return basicGetEndpoint ();
            case IEC60870Package.CLIENT_DEVICE__PROTOCOL_OPTIONS:
                return getProtocolOptions ();
            case IEC60870Package.CLIENT_DEVICE__DATA_MODULE_OPTIONS:
                return getDataModuleOptions ();
            case IEC60870Package.CLIENT_DEVICE__ID:
                return getId ();
            case IEC60870Package.CLIENT_DEVICE__ITEM_TYPES:
                return getItemTypes ();
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
            case IEC60870Package.CLIENT_DEVICE__ENDPOINT:
                setEndpoint ( (Endpoint)newValue );
                return;
            case IEC60870Package.CLIENT_DEVICE__PROTOCOL_OPTIONS:
                setProtocolOptions ( (ProtocolOptions)newValue );
                return;
            case IEC60870Package.CLIENT_DEVICE__DATA_MODULE_OPTIONS:
                setDataModuleOptions ( (ClientDataModuleOptions)newValue );
                return;
            case IEC60870Package.CLIENT_DEVICE__ID:
                setId ( (String)newValue );
                return;
            case IEC60870Package.CLIENT_DEVICE__ITEM_TYPES:
                getItemTypes ().clear ();
                getItemTypes ().addAll ( (Collection<? extends ItemType>)newValue );
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
            case IEC60870Package.CLIENT_DEVICE__ENDPOINT:
                setEndpoint ( (Endpoint)null );
                return;
            case IEC60870Package.CLIENT_DEVICE__PROTOCOL_OPTIONS:
                setProtocolOptions ( (ProtocolOptions)null );
                return;
            case IEC60870Package.CLIENT_DEVICE__DATA_MODULE_OPTIONS:
                setDataModuleOptions ( (ClientDataModuleOptions)null );
                return;
            case IEC60870Package.CLIENT_DEVICE__ID:
                setId ( ID_EDEFAULT );
                return;
            case IEC60870Package.CLIENT_DEVICE__ITEM_TYPES:
                getItemTypes ().clear ();
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
            case IEC60870Package.CLIENT_DEVICE__ENDPOINT:
                return endpoint != null;
            case IEC60870Package.CLIENT_DEVICE__PROTOCOL_OPTIONS:
                return protocolOptions != null;
            case IEC60870Package.CLIENT_DEVICE__DATA_MODULE_OPTIONS:
                return dataModuleOptions != null;
            case IEC60870Package.CLIENT_DEVICE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case IEC60870Package.CLIENT_DEVICE__ITEM_TYPES:
                return itemTypes != null && !itemTypes.isEmpty ();
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
        result.append ( ')' );
        return result.toString ();
    }

} //ClientDeviceImpl
