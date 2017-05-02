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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.neoscada.configuration.iec60870.AddressInformation;
import org.eclipse.neoscada.configuration.iec60870.DataType;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.neoscada.configuration.iec60870.Item;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ItemImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ItemImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ItemImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItemImpl extends MinimalEObjectImpl.Container implements Item
{
    /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
    protected org.eclipse.scada.configuration.world.osgi.Item source;

    /**
     * The default value of the '{@link #getAddress() <em>Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAddress()
     * @generated
     * @ordered
     */
    protected static final AddressInformation ADDRESS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAddress()
     * @generated
     * @ordered
     */
    protected AddressInformation address = ADDRESS_EDEFAULT;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final DataType TYPE_EDEFAULT = DataType.FLOAT;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected DataType type = TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemImpl ()
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
        return IEC60870Package.Literals.ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public org.eclipse.scada.configuration.world.osgi.Item getSource ()
    {
        if ( source != null && source.eIsProxy () )
        {
            InternalEObject oldSource = (InternalEObject)source;
            source = (org.eclipse.scada.configuration.world.osgi.Item)eResolveProxy ( oldSource );
            if ( source != oldSource )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, IEC60870Package.ITEM__SOURCE, oldSource, source ) );
            }
        }
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public org.eclipse.scada.configuration.world.osgi.Item basicGetSource ()
    {
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSource ( org.eclipse.scada.configuration.world.osgi.Item newSource )
    {
        org.eclipse.scada.configuration.world.osgi.Item oldSource = source;
        source = newSource;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.ITEM__SOURCE, oldSource, source ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public AddressInformation getAddress ()
    {
        return address;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setAddress ( AddressInformation newAddress )
    {
        AddressInformation oldAddress = address;
        address = newAddress;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.ITEM__ADDRESS, oldAddress, address ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataType getType ()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setType ( DataType newType )
    {
        DataType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.ITEM__TYPE, oldType, type ) );
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
            case IEC60870Package.ITEM__SOURCE:
                if ( resolve )
                    return getSource ();
                return basicGetSource ();
            case IEC60870Package.ITEM__ADDRESS:
                return getAddress ();
            case IEC60870Package.ITEM__TYPE:
                return getType ();
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
            case IEC60870Package.ITEM__SOURCE:
                setSource ( (org.eclipse.scada.configuration.world.osgi.Item)newValue );
                return;
            case IEC60870Package.ITEM__ADDRESS:
                setAddress ( (AddressInformation)newValue );
                return;
            case IEC60870Package.ITEM__TYPE:
                setType ( (DataType)newValue );
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
            case IEC60870Package.ITEM__SOURCE:
                setSource ( (org.eclipse.scada.configuration.world.osgi.Item)null );
                return;
            case IEC60870Package.ITEM__ADDRESS:
                setAddress ( ADDRESS_EDEFAULT );
                return;
            case IEC60870Package.ITEM__TYPE:
                setType ( TYPE_EDEFAULT );
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
            case IEC60870Package.ITEM__SOURCE:
                return source != null;
            case IEC60870Package.ITEM__ADDRESS:
                return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals ( address );
            case IEC60870Package.ITEM__TYPE:
                return type != TYPE_EDEFAULT;
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
        result.append ( " (address: " ); //$NON-NLS-1$
        result.append ( address );
        result.append ( ", type: " ); //$NON-NLS-1$
        result.append ( type );
        result.append ( ')' );
        return result.toString ();
    }

} //ItemImpl
