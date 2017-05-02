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
package org.eclipse.scada.configuration.infrastructure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Abstract Factory Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractFactoryDriverImpl#getDriverTypeId <em>Driver Type Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractFactoryDriverImpl#getDevices <em>Devices</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractFactoryDriverImpl extends DriverImpl implements AbstractFactoryDriver
{
    /**
     * The default value of the '{@link #getDriverTypeId() <em>Driver Type Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDriverTypeId()
     * @generated
     * @ordered
     */
    protected static final String DRIVER_TYPE_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDriverTypeId() <em>Driver Type Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDriverTypeId()
     * @generated
     * @ordered
     */
    protected String driverTypeId = DRIVER_TYPE_ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getDevices() <em>Devices</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDevices()
     * @generated
     * @ordered
     */
    protected EList<Device> devices;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractFactoryDriverImpl ()
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
        return InfrastructurePackage.Literals.ABSTRACT_FACTORY_DRIVER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDriverTypeId ()
    {
        return driverTypeId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDriverTypeId ( String newDriverTypeId )
    {
        String oldDriverTypeId = driverTypeId;
        driverTypeId = newDriverTypeId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID, oldDriverTypeId, driverTypeId ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Device> getDevices ()
    {
        if ( devices == null )
        {
            devices = new EObjectResolvingEList<Device> ( Device.class, this, InfrastructurePackage.ABSTRACT_FACTORY_DRIVER__DEVICES );
        }
        return devices;
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
            case InfrastructurePackage.ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID:
                return getDriverTypeId ();
            case InfrastructurePackage.ABSTRACT_FACTORY_DRIVER__DEVICES:
                return getDevices ();
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
            case InfrastructurePackage.ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID:
                setDriverTypeId ( (String)newValue );
                return;
            case InfrastructurePackage.ABSTRACT_FACTORY_DRIVER__DEVICES:
                getDevices ().clear ();
                getDevices ().addAll ( (Collection<? extends Device>)newValue );
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
            case InfrastructurePackage.ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID:
                setDriverTypeId ( DRIVER_TYPE_ID_EDEFAULT );
                return;
            case InfrastructurePackage.ABSTRACT_FACTORY_DRIVER__DEVICES:
                getDevices ().clear ();
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
            case InfrastructurePackage.ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID:
                return DRIVER_TYPE_ID_EDEFAULT == null ? driverTypeId != null : !DRIVER_TYPE_ID_EDEFAULT.equals ( driverTypeId );
            case InfrastructurePackage.ABSTRACT_FACTORY_DRIVER__DEVICES:
                return devices != null && !devices.isEmpty ();
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
        result.append ( " (driverTypeId: " ); //$NON-NLS-1$
        result.append ( driverTypeId );
        result.append ( ')' );
        return result.toString ();
    }

} //AbstractFactoryDriverImpl
