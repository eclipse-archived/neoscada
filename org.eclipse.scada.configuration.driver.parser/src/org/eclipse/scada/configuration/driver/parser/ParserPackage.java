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
package org.eclipse.scada.configuration.driver.parser;

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
 * @see org.eclipse.scada.configuration.driver.parser.ParserFactory
 * @model kind="package"
 * @generated
 */
public interface ParserPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "parser"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Driver/Parser"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "parserDriver"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ParserPackage eINSTANCE = org.eclipse.scada.configuration.driver.parser.impl.ParserPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.driver.parser.impl.ParserDriverImpl <em>Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.driver.parser.impl.ParserDriverImpl
     * @see org.eclipse.scada.configuration.driver.parser.impl.ParserPackageImpl#getParserDriver()
     * @generated
     */
    int PARSER_DRIVER = 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER__SHORT_DESCRIPTION = WorldPackage.DRIVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER__NAME = WorldPackage.DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER__CONNECTIONS = WorldPackage.DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER__EXPORTER = WorldPackage.DRIVER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER__CUSTOMIZATION_PROFILE = WorldPackage.DRIVER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER__SECURITY_CONFIGURATION = WorldPackage.DRIVER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER__MODULES = WorldPackage.DRIVER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Components</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER__COMPONENTS = WorldPackage.DRIVER_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER_FEATURE_COUNT = WorldPackage.DRIVER_FEATURE_COUNT + 6;

    /**
     * The operation id for the '<em>Get Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER___GET_ENDPOINTS = WorldPackage.DRIVER___GET_ENDPOINTS;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER___GET_PROFILE = WorldPackage.DRIVER_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_DRIVER_OPERATION_COUNT = WorldPackage.DRIVER_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.driver.parser.impl.ParserComponentHostImpl <em>Component Host</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.driver.parser.impl.ParserComponentHostImpl
     * @see org.eclipse.scada.configuration.driver.parser.impl.ParserPackageImpl#getParserComponentHost()
     * @generated
     */
    int PARSER_COMPONENT_HOST = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_COMPONENT_HOST__NAME = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_COMPONENT_HOST__NODE = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__NODE;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_COMPONENT_HOST__SECURITY_CONFIGURATION = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION;

    /**
     * The feature id for the '<em><b>User Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_COMPONENT_HOST__USER_SERVICE = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE;

    /**
     * The feature id for the '<em><b>Components</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_COMPONENT_HOST__COMPONENTS = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Component Host</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_COMPONENT_HOST_FEATURE_COUNT = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Component Host</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PARSER_COMPONENT_HOST_OPERATION_COUNT = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.driver.parser.ParserDriver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver</em>'.
     * @see org.eclipse.scada.configuration.driver.parser.ParserDriver
     * @generated
     */
    EClass getParserDriver ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.driver.parser.ParserDriver#getComponents <em>Components</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Components</em>'.
     * @see org.eclipse.scada.configuration.driver.parser.ParserDriver#getComponents()
     * @see #getParserDriver()
     * @generated
     */
    EReference getParserDriver_Components ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.driver.parser.ParserComponentHost <em>Component Host</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Component Host</em>'.
     * @see org.eclipse.scada.configuration.driver.parser.ParserComponentHost
     * @generated
     */
    EClass getParserComponentHost ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.driver.parser.ParserComponentHost#getComponents <em>Components</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Components</em>'.
     * @see org.eclipse.scada.configuration.driver.parser.ParserComponentHost#getComponents()
     * @see #getParserComponentHost()
     * @generated
     */
    EReference getParserComponentHost_Components ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ParserFactory getParserFactory ();

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
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.driver.parser.impl.ParserDriverImpl <em>Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.driver.parser.impl.ParserDriverImpl
         * @see org.eclipse.scada.configuration.driver.parser.impl.ParserPackageImpl#getParserDriver()
         * @generated
         */
        EClass PARSER_DRIVER = eINSTANCE.getParserDriver ();

        /**
         * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PARSER_DRIVER__COMPONENTS = eINSTANCE.getParserDriver_Components ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.driver.parser.impl.ParserComponentHostImpl <em>Component Host</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.driver.parser.impl.ParserComponentHostImpl
         * @see org.eclipse.scada.configuration.driver.parser.impl.ParserPackageImpl#getParserComponentHost()
         * @generated
         */
        EClass PARSER_COMPONENT_HOST = eINSTANCE.getParserComponentHost ();

        /**
         * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PARSER_COMPONENT_HOST__COMPONENTS = eINSTANCE.getParserComponentHost_Components ();

    }

} //ParserPackage
