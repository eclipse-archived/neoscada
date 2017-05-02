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
package org.eclipse.scada.configuration.arduino.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.arduino.ArduinoConnection;
import org.eclipse.scada.configuration.arduino.ArduinoDevice;
import org.eclipse.scada.configuration.arduino.ArduinoDriver;
import org.eclipse.scada.configuration.arduino.ArduinoFactory;
import org.eclipse.scada.configuration.arduino.ArduinoPackage;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArduinoPackageImpl extends EPackageImpl implements ArduinoPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass arduinoDriverEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass arduinoConnectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass arduinoDeviceEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package
     * package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.configuration.arduino.ArduinoPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ArduinoPackageImpl ()
    {
        super ( eNS_URI, ArduinoFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link ArduinoPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ArduinoPackage init ()
    {
        if ( isInited )
            return (ArduinoPackage)EPackage.Registry.INSTANCE.getEPackage ( ArduinoPackage.eNS_URI );

        // Obtain or create and register package
        ArduinoPackageImpl theArduinoPackage = (ArduinoPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ArduinoPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ArduinoPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        InfrastructurePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theArduinoPackage.createPackageContents ();

        // Initialize created meta-data
        theArduinoPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theArduinoPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ArduinoPackage.eNS_URI, theArduinoPackage );
        return theArduinoPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getArduinoDriver ()
    {
        return arduinoDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getArduinoDriver_ArduinoConnections ()
    {
        return (EReference)arduinoDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getArduinoConnection ()
    {
        return arduinoConnectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getArduinoConnection_Endpoint ()
    {
        return (EReference)arduinoConnectionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getArduinoDevice ()
    {
        return arduinoDeviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getArduinoDevice_Port ()
    {
        return (EAttribute)arduinoDeviceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ArduinoFactory getArduinoFactory ()
    {
        return (ArduinoFactory)getEFactoryInstance ();
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
        arduinoDriverEClass = createEClass ( ARDUINO_DRIVER );
        createEReference ( arduinoDriverEClass, ARDUINO_DRIVER__ARDUINO_CONNECTIONS );

        arduinoConnectionEClass = createEClass ( ARDUINO_CONNECTION );
        createEReference ( arduinoConnectionEClass, ARDUINO_CONNECTION__ENDPOINT );

        arduinoDeviceEClass = createEClass ( ARDUINO_DEVICE );
        createEAttribute ( arduinoDeviceEClass, ARDUINO_DEVICE__PORT );
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
        WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        arduinoDriverEClass.getESuperTypes ().add ( theWorldPackage.getDriver () );
        arduinoDriverEClass.getESuperTypes ().add ( theOsgiPackage.getEquinoxApplication () );
        arduinoConnectionEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        arduinoDeviceEClass.getESuperTypes ().add ( theInfrastructurePackage.getDevice () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( arduinoDriverEClass, ArduinoDriver.class, "ArduinoDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getArduinoDriver_ArduinoConnections (), this.getArduinoConnection (), null, "arduinoConnections", null, 0, -1, ArduinoDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( arduinoConnectionEClass, ArduinoConnection.class, "ArduinoConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getArduinoConnection_Endpoint (), theWorldPackage.getEndpoint (), null, "endpoint", null, 1, 1, ArduinoConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( arduinoDeviceEClass, ArduinoDevice.class, "ArduinoDevice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getArduinoDevice_Port (), ecorePackage.getEShort (), "port", null, 1, 1, ArduinoDevice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ArduinoPackageImpl
