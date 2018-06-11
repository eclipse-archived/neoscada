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
package org.eclipse.neoscada.configuration.iec62541.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.neoscada.configuration.iec62541.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IEC62541FactoryImpl extends EFactoryImpl implements IEC62541Factory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static IEC62541Factory init ()
    {
        try
        {
            IEC62541Factory theIEC62541Factory = (IEC62541Factory)EPackage.Registry.INSTANCE.getEFactory ( IEC62541Package.eNS_URI );
            if ( theIEC62541Factory != null )
            {
                return theIEC62541Factory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new IEC62541FactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC62541FactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case IEC62541Package.IEC62541_DRIVER:
                return createIEC62541Driver ();
            case IEC62541Package.IEC62541_DEVICE:
                return createIEC62541Device ();
            case IEC62541Package.DRIVER_APPLICATION:
                return createDriverApplication ();
            case IEC62541Package.HIVE_DEVICE:
                return createHiveDevice ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public IEC62541Driver createIEC62541Driver ()
    {
        IEC62541DriverImpl iec62541Driver = new IEC62541DriverImpl ();
        iec62541Driver.setInstanceNumber ( 17 );
        iec62541Driver.setName ( "opcua" ); //$NON-NLS-1$
        return iec62541Driver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC62541Device createIEC62541Device ()
    {
        IEC62541DeviceImpl iec62541Device = new IEC62541DeviceImpl ();
        return iec62541Device;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DriverApplication createDriverApplication ()
    {
        DriverApplicationImpl driverApplication = new DriverApplicationImpl ();
        return driverApplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HiveDevice createHiveDevice ()
    {
        HiveDeviceImpl hiveDevice = new HiveDeviceImpl ();
        return hiveDevice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC62541Package getIEC62541Package ()
    {
        return (IEC62541Package)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static IEC62541Package getPackage ()
    {
        return IEC62541Package.eINSTANCE;
    }

} //IEC62541FactoryImpl
