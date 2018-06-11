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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.neoscada.configuration.iec62541.DriverApplication;
import org.eclipse.neoscada.configuration.iec62541.HiveDevice;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Device;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Driver;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Factory;
import org.eclipse.neoscada.configuration.iec62541.IEC62541Package;

import org.eclipse.scada.configuration.component.ComponentPackage;

import org.eclipse.scada.configuration.globalization.GlobalizePackage;

import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;

import org.eclipse.scada.configuration.item.ItemPackage;

import org.eclipse.scada.configuration.script.ScriptPackage;

import org.eclipse.scada.configuration.security.SecurityPackage;

import org.eclipse.scada.configuration.world.WorldPackage;

import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IEC62541PackageImpl extends EPackageImpl implements IEC62541Package
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iec62541DriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iec62541DeviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass driverApplicationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass hiveDeviceEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Package#eNS_URI
     * @see #init()
     * @generated
     */
    private IEC62541PackageImpl ()
    {
        super ( eNS_URI, IEC62541Factory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link IEC62541Package#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static IEC62541Package init ()
    {
        if ( isInited )
            return (IEC62541Package)EPackage.Registry.INSTANCE.getEPackage ( IEC62541Package.eNS_URI );

        // Obtain or create and register package
        IEC62541PackageImpl theIEC62541Package = (IEC62541PackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof IEC62541PackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new IEC62541PackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        ComponentPackage.eINSTANCE.eClass ();
        ConfigurationPackage.eINSTANCE.eClass ();
        GlobalizePackage.eINSTANCE.eClass ();
        InfrastructurePackage.eINSTANCE.eClass ();
        ItemPackage.eINSTANCE.eClass ();
        ScriptPackage.eINSTANCE.eClass ();
        SecurityPackage.eINSTANCE.eClass ();
        WorldPackage.eINSTANCE.eClass ();
        EcorePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theIEC62541Package.createPackageContents ();

        // Initialize created meta-data
        theIEC62541Package.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theIEC62541Package.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( IEC62541Package.eNS_URI, theIEC62541Package );
        return theIEC62541Package;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIEC62541Driver ()
    {
        return iec62541DriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getIEC62541Driver_Devices ()
    {
        return (EReference)iec62541DriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIEC62541Device ()
    {
        return iec62541DeviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIEC62541Device_ServerUrl ()
    {
        return (EAttribute)iec62541DeviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDriverApplication ()
    {
        return driverApplicationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDriverApplication_Devices ()
    {
        return (EReference)driverApplicationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHiveDevice ()
    {
        return hiveDeviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHiveDevice_Id ()
    {
        return (EAttribute)hiveDeviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHiveDevice_ServerUrl ()
    {
        return (EAttribute)hiveDeviceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC62541Factory getIEC62541Factory ()
    {
        return (IEC62541Factory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents ()
    {
        if ( isCreated )
            return;
        isCreated = true;

        // Create classes and their features
        iec62541DriverEClass = createEClass ( IEC62541_DRIVER );
        createEReference ( iec62541DriverEClass, IEC62541_DRIVER__DEVICES );

        iec62541DeviceEClass = createEClass ( IEC62541_DEVICE );
        createEAttribute ( iec62541DeviceEClass, IEC62541_DEVICE__SERVER_URL );

        driverApplicationEClass = createEClass ( DRIVER_APPLICATION );
        createEReference ( driverApplicationEClass, DRIVER_APPLICATION__DEVICES );

        hiveDeviceEClass = createEClass ( HIVE_DEVICE );
        createEAttribute ( hiveDeviceEClass, HIVE_DEVICE__ID );
        createEAttribute ( hiveDeviceEClass, HIVE_DEVICE__SERVER_URL );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( isInitialized )
            return;
        isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Obtain other dependent packages
        InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );
        WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage ( EcorePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        iec62541DriverEClass.getESuperTypes ().add ( theInfrastructurePackage.getAbstractEquinoxDriver () );
        iec62541DeviceEClass.getESuperTypes ().add ( theInfrastructurePackage.getDevice () );
        driverApplicationEClass.getESuperTypes ().add ( theWorldPackage.getDriver () );
        driverApplicationEClass.getESuperTypes ().add ( theOsgiPackage.getEquinoxApplication () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( iec62541DriverEClass, IEC62541Driver.class, "IEC62541Driver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getIEC62541Driver_Devices (), this.getIEC62541Device (), null, "devices", null, 0, -1, IEC62541Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( iec62541DeviceEClass, IEC62541Device.class, "IEC62541Device", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getIEC62541Device_ServerUrl (), ecorePackage.getEString (), "serverUrl", null, 1, 1, IEC62541Device.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( driverApplicationEClass, DriverApplication.class, "DriverApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDriverApplication_Devices (), this.getHiveDevice (), null, "devices", null, 0, -1, DriverApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( hiveDeviceEClass, HiveDevice.class, "HiveDevice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getHiveDevice_Id (), theEcorePackage.getEString (), "id", null, 1, 1, HiveDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getHiveDevice_ServerUrl (), ecorePackage.getEString (), "serverUrl", null, 1, 1, HiveDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //IEC62541PackageImpl
