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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.configuration.dave.DaveCommunicationProcessor;
import org.eclipse.scada.configuration.dave.DavePackage;
import org.eclipse.scada.configuration.dave.DaveRequestBlock;

import org.eclipse.scada.configuration.world.Endpoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveCommunicationProcessorImpl#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveCommunicationProcessorImpl#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveCommunicationProcessorImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveCommunicationProcessorImpl#getRack <em>Rack</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveCommunicationProcessorImpl#getSlot <em>Slot</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveCommunicationProcessorImpl#getReadTimeout <em>Read Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DaveCommunicationProcessorImpl extends MinimalEObjectImpl.Container implements DaveCommunicationProcessor
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
     * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlocks()
     * @generated
     * @ordered
     */
    protected EList<DaveRequestBlock> blocks;

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
     * The default value of the '{@link #getRack() <em>Rack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRack()
     * @generated
     * @ordered
     */
    protected static final int RACK_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getRack() <em>Rack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRack()
     * @generated
     * @ordered
     */
    protected int rack = RACK_EDEFAULT;

    /**
     * The default value of the '{@link #getSlot() <em>Slot</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSlot()
     * @generated
     * @ordered
     */
    protected static final int SLOT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSlot() <em>Slot</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSlot()
     * @generated
     * @ordered
     */
    protected int slot = SLOT_EDEFAULT;

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
    protected DaveCommunicationProcessorImpl ()
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
        return DavePackage.Literals.DAVE_COMMUNICATION_PROCESSOR;
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, DavePackage.DAVE_COMMUNICATION_PROCESSOR__ENDPOINT, oldEndpoint, endpoint ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_COMMUNICATION_PROCESSOR__ENDPOINT, oldEndpoint, endpoint ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DaveRequestBlock> getBlocks ()
    {
        if ( blocks == null )
        {
            blocks = new EObjectContainmentWithInverseEList.Resolving<DaveRequestBlock> ( DaveRequestBlock.class, this, DavePackage.DAVE_COMMUNICATION_PROCESSOR__BLOCKS, DavePackage.DAVE_REQUEST_BLOCK__DEVICE );
        }
        return blocks;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_COMMUNICATION_PROCESSOR__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getRack ()
    {
        return rack;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRack ( int newRack )
    {
        int oldRack = rack;
        rack = newRack;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_COMMUNICATION_PROCESSOR__RACK, oldRack, rack ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getSlot ()
    {
        return slot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSlot ( int newSlot )
    {
        int oldSlot = slot;
        slot = newSlot;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_COMMUNICATION_PROCESSOR__SLOT, oldSlot, slot ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_COMMUNICATION_PROCESSOR__READ_TIMEOUT, oldReadTimeout, readTimeout ) );
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
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__BLOCKS:
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
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__BLOCKS:
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
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__ENDPOINT:
                if ( resolve )
                    return getEndpoint ();
                return basicGetEndpoint ();
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__BLOCKS:
                return getBlocks ();
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__ID:
                return getId ();
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__RACK:
                return getRack ();
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__SLOT:
                return getSlot ();
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__READ_TIMEOUT:
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
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__ENDPOINT:
                setEndpoint ( (Endpoint)newValue );
                return;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__BLOCKS:
                getBlocks ().clear ();
                getBlocks ().addAll ( (Collection<? extends DaveRequestBlock>)newValue );
                return;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__ID:
                setId ( (String)newValue );
                return;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__RACK:
                setRack ( (Integer)newValue );
                return;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__SLOT:
                setSlot ( (Integer)newValue );
                return;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__READ_TIMEOUT:
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
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__ENDPOINT:
                setEndpoint ( (Endpoint)null );
                return;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__BLOCKS:
                getBlocks ().clear ();
                return;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__ID:
                setId ( ID_EDEFAULT );
                return;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__RACK:
                setRack ( RACK_EDEFAULT );
                return;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__SLOT:
                setSlot ( SLOT_EDEFAULT );
                return;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__READ_TIMEOUT:
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
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__ENDPOINT:
                return endpoint != null;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__BLOCKS:
                return blocks != null && !blocks.isEmpty ();
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__RACK:
                return rack != RACK_EDEFAULT;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__SLOT:
                return slot != SLOT_EDEFAULT;
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR__READ_TIMEOUT:
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
        result.append ( " (id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ", rack: " ); //$NON-NLS-1$
        result.append ( rack );
        result.append ( ", slot: " ); //$NON-NLS-1$
        result.append ( slot );
        result.append ( ", readTimeout: " ); //$NON-NLS-1$
        result.append ( readTimeout );
        result.append ( ')' );
        return result.toString ();
    }

} //DaveCommunicationProcessorImpl
