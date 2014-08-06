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
package org.eclipse.scada.configuration.setup.common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.world.setup.SetupPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.setup.common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "common"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Setup/Common"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "setupCommon"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CommonPackage eINSTANCE = org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.setup.common.impl.PostgresSetupModuleImpl <em>Postgres Setup Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.setup.common.impl.PostgresSetupModuleImpl
     * @see org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl#getPostgresSetupModule()
     * @generated
     */
    int POSTGRES_SETUP_MODULE = 0;

    /**
     * The feature id for the '<em><b>Database</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE__DATABASE = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Postgres User</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE__POSTGRES_USER = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Host Based Access File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE__HOST_BASED_ACCESS_FILE = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Configuration File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE__CONFIGURATION_FILE = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Postgres Setup Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE_FEATURE_COUNT = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 4;

    /**
     * The operation id for the '<em>Validate Operating System</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_IVALIDATIONCONTEXT = SetupPackage.SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_IVALIDATIONCONTEXT;

    /**
     * The number of operations of the '<em>Postgres Setup Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE_OPERATION_COUNT = SetupPackage.SETUP_MODULE_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule <em>Postgres Setup Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Postgres Setup Module</em>'.
     * @see org.eclipse.scada.configuration.setup.common.PostgresSetupModule
     * @generated
     */
    EClass getPostgresSetupModule ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getDatabase <em>Database</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Database</em>'.
     * @see org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getDatabase()
     * @see #getPostgresSetupModule()
     * @generated
     */
    EReference getPostgresSetupModule_Database ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getPostgresUser <em>Postgres User</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Postgres User</em>'.
     * @see org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getPostgresUser()
     * @see #getPostgresSetupModule()
     * @generated
     */
    EAttribute getPostgresSetupModule_PostgresUser ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getHostBasedAccessFile <em>Host Based Access File</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Host Based Access File</em>'.
     * @see org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getHostBasedAccessFile()
     * @see #getPostgresSetupModule()
     * @generated
     */
    EAttribute getPostgresSetupModule_HostBasedAccessFile ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getConfigurationFile <em>Configuration File</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Configuration File</em>'.
     * @see org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getConfigurationFile()
     * @see #getPostgresSetupModule()
     * @generated
     */
    EAttribute getPostgresSetupModule_ConfigurationFile ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CommonFactory getCommonFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.setup.common.impl.PostgresSetupModuleImpl <em>Postgres Setup Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.setup.common.impl.PostgresSetupModuleImpl
         * @see org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl#getPostgresSetupModule()
         * @generated
         */
        EClass POSTGRES_SETUP_MODULE = eINSTANCE.getPostgresSetupModule ();

        /**
         * The meta object literal for the '<em><b>Database</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POSTGRES_SETUP_MODULE__DATABASE = eINSTANCE.getPostgresSetupModule_Database ();

        /**
         * The meta object literal for the '<em><b>Postgres User</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POSTGRES_SETUP_MODULE__POSTGRES_USER = eINSTANCE.getPostgresSetupModule_PostgresUser ();

        /**
         * The meta object literal for the '<em><b>Host Based Access File</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POSTGRES_SETUP_MODULE__HOST_BASED_ACCESS_FILE = eINSTANCE.getPostgresSetupModule_HostBasedAccessFile ();

        /**
         * The meta object literal for the '<em><b>Configuration File</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POSTGRES_SETUP_MODULE__CONFIGURATION_FILE = eINSTANCE.getPostgresSetupModule_ConfigurationFile ();

    }

} //CommonPackage
