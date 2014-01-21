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
package org.eclipse.scada.configuration.arduino;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.scada.configuration.arduino.ArduinoFactory
 * @model kind="package"
 * @generated
 */
public interface ArduinoPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "arduino"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://eclipe.org/SCADA/Configuration/Arduino"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "arduino"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    ArduinoPackage eINSTANCE = org.eclipse.scada.configuration.arduino.impl.ArduinoPackageImpl.init ();

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.configuration.arduino.impl.ArduinoDriverImpl
     * <em>Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.configuration.arduino.impl.ArduinoDriverImpl
     * @see org.eclipse.scada.configuration.arduino.impl.ArduinoPackageImpl#getArduinoDriver()
     * @generated
     */
    int ARDUINO_DRIVER = 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER__SHORT_DESCRIPTION = WorldPackage.DRIVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER__NAME = WorldPackage.DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment
     * reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER__CONNECTIONS = WorldPackage.DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER__EXPORTER = WorldPackage.DRIVER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>'
     * containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER__CUSTOMIZATION_PROFILE = WorldPackage.DRIVER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>'
     * reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER__SECURITY_CONFIGURATION = WorldPackage.DRIVER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER__MODULES = WorldPackage.DRIVER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Arduino Connections</b></em>' containment
     * reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER__ARDUINO_CONNECTIONS = WorldPackage.DRIVER_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER_FEATURE_COUNT = WorldPackage.DRIVER_FEATURE_COUNT + 6;

    /**
     * The operation id for the '<em>Get Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER___GET_ENDPOINTS = WorldPackage.DRIVER___GET_ENDPOINTS;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER___GET_PROFILE = WorldPackage.DRIVER_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DRIVER_OPERATION_COUNT = WorldPackage.DRIVER_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.configuration.arduino.impl.ArduinoConnectionImpl
     * <em>Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.configuration.arduino.impl.ArduinoConnectionImpl
     * @see org.eclipse.scada.configuration.arduino.impl.ArduinoPackageImpl#getArduinoConnection()
     * @generated
     */
    int ARDUINO_CONNECTION = 1;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_CONNECTION__SHORT_DESCRIPTION = WorldPackage.NAMED_DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_CONNECTION__NAME = WorldPackage.NAMED_DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_CONNECTION__ENDPOINT = WorldPackage.NAMED_DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_CONNECTION_FEATURE_COUNT = WorldPackage.NAMED_DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_CONNECTION_OPERATION_COUNT = WorldPackage.NAMED_DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.configuration.arduino.impl.ArduinoDeviceImpl
     * <em>Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.configuration.arduino.impl.ArduinoDeviceImpl
     * @see org.eclipse.scada.configuration.arduino.impl.ArduinoPackageImpl#getArduinoDevice()
     * @generated
     */
    int ARDUINO_DEVICE = 2;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DEVICE__SHORT_DESCRIPTION = InfrastructurePackage.DEVICE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DEVICE__NAME = InfrastructurePackage.DEVICE__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DEVICE__NODE = InfrastructurePackage.DEVICE__NODE;

    /**
     * The feature id for the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DEVICE__PORT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DEVICE_FEATURE_COUNT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ARDUINO_DEVICE_OPERATION_COUNT = InfrastructurePackage.DEVICE_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.configuration.arduino.ArduinoDriver
     * <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Driver</em>'.
     * @see org.eclipse.scada.configuration.arduino.ArduinoDriver
     * @generated
     */
    EClass getArduinoDriver ();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.scada.configuration.arduino.ArduinoDriver#getArduinoConnections
     * <em>Arduino Connections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Arduino Connections</em>'.
     * @see org.eclipse.scada.configuration.arduino.ArduinoDriver#getArduinoConnections()
     * @see #getArduinoDriver()
     * @generated
     */
    EReference getArduinoDriver_ArduinoConnections ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.configuration.arduino.ArduinoConnection
     * <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Connection</em>'.
     * @see org.eclipse.scada.configuration.arduino.ArduinoConnection
     * @generated
     */
    EClass getArduinoConnection ();

    /**
     * Returns the meta object for the reference '
     * {@link org.eclipse.scada.configuration.arduino.ArduinoConnection#getEndpoint
     * <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Endpoint</em>'.
     * @see org.eclipse.scada.configuration.arduino.ArduinoConnection#getEndpoint()
     * @see #getArduinoConnection()
     * @generated
     */
    EReference getArduinoConnection_Endpoint ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.configuration.arduino.ArduinoDevice
     * <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Device</em>'.
     * @see org.eclipse.scada.configuration.arduino.ArduinoDevice
     * @generated
     */
    EClass getArduinoDevice ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.configuration.arduino.ArduinoDevice#getPort
     * <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see org.eclipse.scada.configuration.arduino.ArduinoDevice#getPort()
     * @see #getArduinoDevice()
     * @generated
     */
    EAttribute getArduinoDevice_Port ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ArduinoFactory getArduinoFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each operation of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.configuration.arduino.impl.ArduinoDriverImpl
         * <em>Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.configuration.arduino.impl.ArduinoDriverImpl
         * @see org.eclipse.scada.configuration.arduino.impl.ArduinoPackageImpl#getArduinoDriver()
         * @generated
         */
        EClass ARDUINO_DRIVER = eINSTANCE.getArduinoDriver ();

        /**
         * The meta object literal for the '<em><b>Arduino Connections</b></em>'
         * containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ARDUINO_DRIVER__ARDUINO_CONNECTIONS = eINSTANCE.getArduinoDriver_ArduinoConnections ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.configuration.arduino.impl.ArduinoConnectionImpl
         * <em>Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.configuration.arduino.impl.ArduinoConnectionImpl
         * @see org.eclipse.scada.configuration.arduino.impl.ArduinoPackageImpl#getArduinoConnection()
         * @generated
         */
        EClass ARDUINO_CONNECTION = eINSTANCE.getArduinoConnection ();

        /**
         * The meta object literal for the '<em><b>Endpoint</b></em>' reference
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ARDUINO_CONNECTION__ENDPOINT = eINSTANCE.getArduinoConnection_Endpoint ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.configuration.arduino.impl.ArduinoDeviceImpl
         * <em>Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.configuration.arduino.impl.ArduinoDeviceImpl
         * @see org.eclipse.scada.configuration.arduino.impl.ArduinoPackageImpl#getArduinoDevice()
         * @generated
         */
        EClass ARDUINO_DEVICE = eINSTANCE.getArduinoDevice ();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ARDUINO_DEVICE__PORT = eINSTANCE.getArduinoDevice_Port ();

    }

} //ArduinoPackage
