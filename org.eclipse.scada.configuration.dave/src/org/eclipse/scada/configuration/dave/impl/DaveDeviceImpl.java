/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.dave.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.dave.DaveBlockDefinition;
import org.eclipse.scada.configuration.dave.DaveDevice;
import org.eclipse.scada.configuration.dave.DavePackage;
import org.eclipse.scada.configuration.infrastructure.impl.DeviceImpl;
import org.eclipse.scada.configuration.memory.TypeSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveDeviceImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveDeviceImpl#getRack <em>Rack</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveDeviceImpl#getSlot <em>Slot</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveDeviceImpl#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveDeviceImpl#getTypeSystem <em>Type System</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveDeviceImpl#getReadTimeout <em>Read Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DaveDeviceImpl extends DeviceImpl implements DaveDevice
{
    /**
     * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected static final int PORT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected int port = PORT_EDEFAULT;

    /**
     * The default value of the '{@link #getRack() <em>Rack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRack()
     * @generated
     * @ordered
     */
    protected static final short RACK_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getRack() <em>Rack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRack()
     * @generated
     * @ordered
     */
    protected short rack = RACK_EDEFAULT;

    /**
     * The default value of the '{@link #getSlot() <em>Slot</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSlot()
     * @generated
     * @ordered
     */
    protected static final short SLOT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSlot() <em>Slot</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSlot()
     * @generated
     * @ordered
     */
    protected short slot = SLOT_EDEFAULT;

    /**
     * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlocks()
     * @generated
     * @ordered
     */
    protected EList<DaveBlockDefinition> blocks;

    /**
     * The cached value of the '{@link #getTypeSystem() <em>Type System</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypeSystem()
     * @generated
     * @ordered
     */
    protected TypeSystem typeSystem;

    /**
     * The default value of the '{@link #getReadTimeout() <em>Read Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReadTimeout()
     * @generated
     * @ordered
     */
    protected static final int READ_TIMEOUT_EDEFAULT = 5000;

    /**
     * The cached value of the '{@link #getReadTimeout() <em>Read Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReadTimeout()
     * @generated
     * @ordered
     */
    protected int readTimeout = READ_TIMEOUT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DaveDeviceImpl ()
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
        return DavePackage.Literals.DAVE_DEVICE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPort ()
    {
        return port;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPort ( int newPort )
    {
        int oldPort = port;
        port = newPort;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_DEVICE__PORT, oldPort, port ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getRack ()
    {
        return rack;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRack ( short newRack )
    {
        short oldRack = rack;
        rack = newRack;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_DEVICE__RACK, oldRack, rack ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getSlot ()
    {
        return slot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSlot ( short newSlot )
    {
        short oldSlot = slot;
        slot = newSlot;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_DEVICE__SLOT, oldSlot, slot ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DaveBlockDefinition> getBlocks ()
    {
        if ( blocks == null )
        {
            blocks = new EObjectContainmentWithInverseEList.Resolving<DaveBlockDefinition> ( DaveBlockDefinition.class, this, DavePackage.DAVE_DEVICE__BLOCKS, DavePackage.DAVE_BLOCK_DEFINITION__DEVICE );
        }
        return blocks;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeSystem getTypeSystem ()
    {
        if ( typeSystem != null && typeSystem.eIsProxy () )
        {
            InternalEObject oldTypeSystem = (InternalEObject)typeSystem;
            typeSystem = (TypeSystem)eResolveProxy ( oldTypeSystem );
            if ( typeSystem != oldTypeSystem )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, DavePackage.DAVE_DEVICE__TYPE_SYSTEM, oldTypeSystem, typeSystem ) );
            }
        }
        return typeSystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeSystem basicGetTypeSystem ()
    {
        return typeSystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTypeSystem ( TypeSystem newTypeSystem )
    {
        TypeSystem oldTypeSystem = typeSystem;
        typeSystem = newTypeSystem;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_DEVICE__TYPE_SYSTEM, oldTypeSystem, typeSystem ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getReadTimeout ()
    {
        return readTimeout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReadTimeout ( int newReadTimeout )
    {
        int oldReadTimeout = readTimeout;
        readTimeout = newReadTimeout;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_DEVICE__READ_TIMEOUT, oldReadTimeout, readTimeout ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case DavePackage.DAVE_DEVICE__BLOCKS:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getBlocks () ).basicAdd ( otherEnd, msgs );
        }
        return super.eInverseAdd ( otherEnd, featureID, msgs );
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
            case DavePackage.DAVE_DEVICE__BLOCKS:
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
            case DavePackage.DAVE_DEVICE__PORT:
                return getPort ();
            case DavePackage.DAVE_DEVICE__RACK:
                return getRack ();
            case DavePackage.DAVE_DEVICE__SLOT:
                return getSlot ();
            case DavePackage.DAVE_DEVICE__BLOCKS:
                return getBlocks ();
            case DavePackage.DAVE_DEVICE__TYPE_SYSTEM:
                if ( resolve )
                    return getTypeSystem ();
                return basicGetTypeSystem ();
            case DavePackage.DAVE_DEVICE__READ_TIMEOUT:
                return getReadTimeout ();
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
            case DavePackage.DAVE_DEVICE__PORT:
                setPort ( (Integer)newValue );
                return;
            case DavePackage.DAVE_DEVICE__RACK:
                setRack ( (Short)newValue );
                return;
            case DavePackage.DAVE_DEVICE__SLOT:
                setSlot ( (Short)newValue );
                return;
            case DavePackage.DAVE_DEVICE__BLOCKS:
                getBlocks ().clear ();
                getBlocks ().addAll ( (Collection<? extends DaveBlockDefinition>)newValue );
                return;
            case DavePackage.DAVE_DEVICE__TYPE_SYSTEM:
                setTypeSystem ( (TypeSystem)newValue );
                return;
            case DavePackage.DAVE_DEVICE__READ_TIMEOUT:
                setReadTimeout ( (Integer)newValue );
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
            case DavePackage.DAVE_DEVICE__PORT:
                setPort ( PORT_EDEFAULT );
                return;
            case DavePackage.DAVE_DEVICE__RACK:
                setRack ( RACK_EDEFAULT );
                return;
            case DavePackage.DAVE_DEVICE__SLOT:
                setSlot ( SLOT_EDEFAULT );
                return;
            case DavePackage.DAVE_DEVICE__BLOCKS:
                getBlocks ().clear ();
                return;
            case DavePackage.DAVE_DEVICE__TYPE_SYSTEM:
                setTypeSystem ( (TypeSystem)null );
                return;
            case DavePackage.DAVE_DEVICE__READ_TIMEOUT:
                setReadTimeout ( READ_TIMEOUT_EDEFAULT );
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
            case DavePackage.DAVE_DEVICE__PORT:
                return port != PORT_EDEFAULT;
            case DavePackage.DAVE_DEVICE__RACK:
                return rack != RACK_EDEFAULT;
            case DavePackage.DAVE_DEVICE__SLOT:
                return slot != SLOT_EDEFAULT;
            case DavePackage.DAVE_DEVICE__BLOCKS:
                return blocks != null && !blocks.isEmpty ();
            case DavePackage.DAVE_DEVICE__TYPE_SYSTEM:
                return typeSystem != null;
            case DavePackage.DAVE_DEVICE__READ_TIMEOUT:
                return readTimeout != READ_TIMEOUT_EDEFAULT;
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
        result.append ( " (port: " ); //$NON-NLS-1$
        result.append ( port );
        result.append ( ", rack: " ); //$NON-NLS-1$
        result.append ( rack );
        result.append ( ", slot: " ); //$NON-NLS-1$
        result.append ( slot );
        result.append ( ", readTimeout: " ); //$NON-NLS-1$
        result.append ( readTimeout );
        result.append ( ')' );
        return result.toString ();
    }

} //DaveDeviceImpl
