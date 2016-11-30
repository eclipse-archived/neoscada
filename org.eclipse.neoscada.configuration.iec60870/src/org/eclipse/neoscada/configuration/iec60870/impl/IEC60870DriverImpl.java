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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Device;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Driver;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.scada.configuration.infrastructure.impl.AbstractEquinoxDriverImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.IEC60870DriverImpl#getDevices <em>Devices</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IEC60870DriverImpl extends AbstractEquinoxDriverImpl implements IEC60870Driver
{
    /**
     * The cached value of the '{@link #getDevices() <em>Devices</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDevices()
     * @generated
     * @ordered
     */
    protected EList<IEC60870Device> devices;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IEC60870DriverImpl ()
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
        return IEC60870Package.Literals.IEC60870_DRIVER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IEC60870Device> getDevices ()
    {
        if ( devices == null )
        {
            devices = new EObjectResolvingEList<IEC60870Device> ( IEC60870Device.class, this, IEC60870Package.IEC60870_DRIVER__DEVICES );
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
            case IEC60870Package.IEC60870_DRIVER__DEVICES:
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
            case IEC60870Package.IEC60870_DRIVER__DEVICES:
                getDevices ().clear ();
                getDevices ().addAll ( (Collection<? extends IEC60870Device>)newValue );
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
            case IEC60870Package.IEC60870_DRIVER__DEVICES:
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
            case IEC60870Package.IEC60870_DRIVER__DEVICES:
                return devices != null && !devices.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //IEC60870DriverImpl
