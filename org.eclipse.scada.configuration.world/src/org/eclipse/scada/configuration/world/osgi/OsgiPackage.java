/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
 * @see org.eclipse.scada.configuration.world.osgi.OsgiFactory
 * @model kind="package"
 * @generated
 */
public interface OsgiPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "osgi"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/World/OSGi"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "osgi"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    OsgiPackage eINSTANCE = org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication <em>Equinox Application</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEquinoxApplication()
     * @generated
     */
    int EQUINOX_APPLICATION = 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__SHORT_DESCRIPTION = WorldPackage.APPLICATION__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__NAME = WorldPackage.APPLICATION__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__CONNECTIONS = WorldPackage.APPLICATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__EXPORTER = WorldPackage.APPLICATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE = WorldPackage.APPLICATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__SECURITY_CONFIGURATION = WorldPackage.APPLICATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__MODULES = WorldPackage.APPLICATION_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Equinox Application</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION_FEATURE_COUNT = WorldPackage.APPLICATION_FEATURE_COUNT + 5;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION___GET_PROFILE = WorldPackage.APPLICATION_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Equinox Application</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION_OPERATION_COUNT = WorldPackage.APPLICATION_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ConnectionImpl <em>Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ConnectionImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getConnection()
     * @generated
     */
    int CONNECTION = 1;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__ENDPOINT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Endpoint Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__ENDPOINT_LABEL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__CREDENTIALS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__TIMEOUT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 4;

    /**
     * The operation id for the '<em>Get Type Tag</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION___GET_TYPE_TAG = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Get Possible Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION___GET_POSSIBLE_ENDPOINTS__EXPORTER = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 1;

    /**
     * The operation id for the '<em>Make Uri</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION___MAKE_URI__BOOLEAN = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 2;

    /**
     * The number of operations of the '<em>Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ExporterImpl <em>Exporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ExporterImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getExporter()
     * @generated
     */
    int EXPORTER = 2;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER__ENDPOINTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Type Tag</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER___GET_TYPE_TAG = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DataAccessConnectionImpl <em>Data Access Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.DataAccessConnectionImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDataAccessConnection()
     * @generated
     */
    int DATA_ACCESS_CONNECTION = 3;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION__SHORT_DESCRIPTION = CONNECTION__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION__NAME = CONNECTION__NAME;

    /**
     * The feature id for the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION__ENDPOINT = CONNECTION__ENDPOINT;

    /**
     * The feature id for the '<em><b>Endpoint Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION__ENDPOINT_LABEL = CONNECTION__ENDPOINT_LABEL;

    /**
     * The feature id for the '<em><b>Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION__CREDENTIALS = CONNECTION__CREDENTIALS;

    /**
     * The feature id for the '<em><b>Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION__TIMEOUT = CONNECTION__TIMEOUT;

    /**
     * The number of structural features of the '<em>Data Access Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Possible Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION___GET_POSSIBLE_ENDPOINTS__EXPORTER = CONNECTION___GET_POSSIBLE_ENDPOINTS__EXPORTER;

    /**
     * The operation id for the '<em>Get Type Tag</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION___GET_TYPE_TAG = CONNECTION_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Make Uri</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION___MAKE_URI__BOOLEAN = CONNECTION_OPERATION_COUNT + 1;

    /**
     * The number of operations of the '<em>Data Access Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_CONNECTION_OPERATION_COUNT = CONNECTION_OPERATION_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DataAccessExporterImpl <em>Data Access Exporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.DataAccessExporterImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDataAccessExporter()
     * @generated
     */
    int DATA_ACCESS_EXPORTER = 4;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_EXPORTER__SHORT_DESCRIPTION = EXPORTER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_EXPORTER__NAME = EXPORTER__NAME;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_EXPORTER__ENDPOINTS = EXPORTER__ENDPOINTS;

    /**
     * The feature id for the '<em><b>Exports</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_EXPORTER__EXPORTS = EXPORTER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Data Access Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_EXPORTER_FEATURE_COUNT = EXPORTER_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Type Tag</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_EXPORTER___GET_TYPE_TAG = EXPORTER_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Data Access Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ACCESS_EXPORTER_OPERATION_COUNT = EXPORTER_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ItemImpl <em>Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getItem()
     * @generated
     */
    int ITEM = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__NAME = 0;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__INFORMATION = 1;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__ITEM_FEATURES = 2;

    /**
     * The number of structural features of the '<em>Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.SourceItemImpl <em>Source Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.SourceItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSourceItem()
     * @generated
     */
    int SOURCE_ITEM = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Connection</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ITEM__CONNECTION = ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ITEM__SOURCE_NAME = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Source Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Source Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SOURCE_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ItemExportImpl <em>Item Export</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ItemExportImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getItemExport()
     * @generated
     */
    int ITEM_EXPORT = 7;

    /**
     * The feature id for the '<em><b>Item</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_EXPORT__ITEM = 0;

    /**
     * The feature id for the '<em><b>Export Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_EXPORT__EXPORT_NAME = 1;

    /**
     * The number of structural features of the '<em>Item Export</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_EXPORT_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Item Export</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_EXPORT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ItemInformationImpl <em>Item Information</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ItemInformationImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getItemInformation()
     * @generated
     */
    int ITEM_INFORMATION = 8;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_INFORMATION__DESCRIPTION = 0;

    /**
     * The feature id for the '<em><b>Unit</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_INFORMATION__UNIT = 1;

    /**
     * The feature id for the '<em><b>Hierarchy</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_INFORMATION__HIERARCHY = 2;

    /**
     * The feature id for the '<em><b>System</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_INFORMATION__SYSTEM = 3;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_INFORMATION__DATA_TYPE = 4;

    /**
     * The number of structural features of the '<em>Item Information</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_INFORMATION_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Item Information</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_INFORMATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ItemFeatureEntryImpl <em>Item Feature Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ItemFeatureEntryImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getItemFeatureEntry()
     * @generated
     */
    int ITEM_FEATURE_ENTRY = 10;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_ENTRY__NAME = 0;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_ENTRY__ITEM = 1;

    /**
     * The number of structural features of the '<em>Item Feature Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_ENTRY_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Item Feature Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_ENTRY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl <em>Level Monitor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getLevelMonitor()
     * @generated
     */
    int LEVEL_MONITOR = 9;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Preset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__PRESET = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Cap</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__CAP = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Severity</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__SEVERITY = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Lower Ok</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__LOWER_OK = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Included Ok</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__INCLUDED_OK = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__PREFIX = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Demote Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__DEMOTE_PREFIX = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Suppress Events</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__SUPPRESS_EVENTS = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Require Ack</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__REQUIRE_ACK = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Monitor Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR__MONITOR_TYPE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 9;

    /**
     * The number of structural features of the '<em>Level Monitor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 10;

    /**
     * The number of operations of the '<em>Level Monitor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_MONITOR_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl <em>Script Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getScriptItem()
     * @generated
     */
    int SCRIPT_ITEM = 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM__INPUTS = ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Init Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM__INIT_SCRIPT = ITEM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Update Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM__UPDATE_SCRIPT = ITEM_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Timer</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM__TIMER = ITEM_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Script Engine</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM__SCRIPT_ENGINE = ITEM_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Commands</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM__COMMANDS = ITEM_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Write Command Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM__WRITE_COMMAND_SCRIPT = ITEM_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Script Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 7;

    /**
     * The number of operations of the '<em>Script Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ImportItemImpl <em>Import Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ImportItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getImportItem()
     * @generated
     */
    int IMPORT_ITEM = 12;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPORT_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPORT_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPORT_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Export</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPORT_ITEM__EXPORT = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Import Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPORT_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Import Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMPORT_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.SummaryGroupImpl <em>Summary Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.SummaryGroupImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSummaryGroup()
     * @generated
     */
    int SUMMARY_GROUP = 13;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_GROUP__NAME = 0;

    /**
     * The feature id for the '<em><b>Sub Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_GROUP__SUB_GROUPS = 1;

    /**
     * The feature id for the '<em><b>Items</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_GROUP__ITEMS = 2;

    /**
     * The number of structural features of the '<em>Summary Group</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_GROUP_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Summary Group</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_GROUP_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MarkerGroupImpl <em>Marker Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.MarkerGroupImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMarkerGroup()
     * @generated
     */
    int MARKER_GROUP = 14;

    /**
     * The feature id for the '<em><b>Items</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_GROUP__ITEMS = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_GROUP__NAME = 1;

    /**
     * The feature id for the '<em><b>Markers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_GROUP__MARKERS = 2;

    /**
     * The number of structural features of the '<em>Marker Group</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_GROUP_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Marker Group</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_GROUP_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MarkersImpl <em>Markers</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.MarkersImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMarkers()
     * @generated
     */
    int MARKERS = 15;

    /**
     * The feature id for the '<em><b>Marker Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKERS__MARKER_GROUPS = 0;

    /**
     * The number of structural features of the '<em>Markers</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKERS_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Markers</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKERS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ConstantItemImpl <em>Constant Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ConstantItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getConstantItem()
     * @generated
     */
    int CONSTANT_ITEM = 16;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_ITEM__VALUE = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Constant Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Constant Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.SummaryItemImpl <em>Summary Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.SummaryItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSummaryItem()
     * @generated
     */
    int SUMMARY_ITEM = 17;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Group</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_ITEM__GROUP = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Summary Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Summary Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARY_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MarkerEntryImpl <em>Marker Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.MarkerEntryImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMarkerEntry()
     * @generated
     */
    int MARKER_ENTRY = 18;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_ENTRY__NAME = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_ENTRY__VALUE = 1;

    /**
     * The number of structural features of the '<em>Marker Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_ENTRY_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Marker Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_ENTRY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ManualOverrideImpl <em>Manual Override</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ManualOverrideImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getManualOverride()
     * @generated
     */
    int MANUAL_OVERRIDE = 19;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MANUAL_OVERRIDE__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MANUAL_OVERRIDE__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Initial Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MANUAL_OVERRIDE__INITIAL_VALUE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Manual Override</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MANUAL_OVERRIDE_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Manual Override</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MANUAL_OVERRIDE_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl <em>Master Server</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMasterServer()
     * @generated
     */
    int MASTER_SERVER = 20;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__SHORT_DESCRIPTION = EQUINOX_APPLICATION__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__NAME = EQUINOX_APPLICATION__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__CONNECTIONS = EQUINOX_APPLICATION__CONNECTIONS;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__EXPORTER = EQUINOX_APPLICATION__EXPORTER;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__CUSTOMIZATION_PROFILE = EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__SECURITY_CONFIGURATION = EQUINOX_APPLICATION__SECURITY_CONFIGURATION;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__MODULES = EQUINOX_APPLICATION__MODULES;

    /**
     * The feature id for the '<em><b>Summary Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__SUMMARY_GROUPS = EQUINOX_APPLICATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__ITEMS = EQUINOX_APPLICATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Markers</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__MARKERS = EQUINOX_APPLICATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Ae Server Information Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX = EQUINOX_APPLICATION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Monitor Pools</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__MONITOR_POOLS = EQUINOX_APPLICATION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Event Pools</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__EVENT_POOLS = EQUINOX_APPLICATION_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Data Mapper</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__DATA_MAPPER = EQUINOX_APPLICATION_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>External Event Monitors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__EXTERNAL_EVENT_MONITORS = EQUINOX_APPLICATION_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>External Event Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__EXTERNAL_EVENT_FILTERS = EQUINOX_APPLICATION_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Averages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__AVERAGES = EQUINOX_APPLICATION_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Moving Averages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__MOVING_AVERAGES = EQUINOX_APPLICATION_FEATURE_COUNT + 10;

    /**
     * The number of structural features of the '<em>Master Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER_FEATURE_COUNT = EQUINOX_APPLICATION_FEATURE_COUNT + 11;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER___GET_PROFILE = EQUINOX_APPLICATION___GET_PROFILE;

    /**
     * The number of operations of the '<em>Master Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER_OPERATION_COUNT = EQUINOX_APPLICATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl <em>Value Archive Server</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getValueArchiveServer()
     * @generated
     */
    int VALUE_ARCHIVE_SERVER = 21;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__SHORT_DESCRIPTION = EQUINOX_APPLICATION__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__NAME = EQUINOX_APPLICATION__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__CONNECTIONS = EQUINOX_APPLICATION__CONNECTIONS;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__EXPORTER = EQUINOX_APPLICATION__EXPORTER;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE = EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__SECURITY_CONFIGURATION = EQUINOX_APPLICATION__SECURITY_CONFIGURATION;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__MODULES = EQUINOX_APPLICATION__MODULES;

    /**
     * The feature id for the '<em><b>Archives</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__ARCHIVES = EQUINOX_APPLICATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Value Archive Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER_FEATURE_COUNT = EQUINOX_APPLICATION_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER___GET_PROFILE = EQUINOX_APPLICATION___GET_PROFILE;

    /**
     * The number of operations of the '<em>Value Archive Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER_OPERATION_COUNT = EQUINOX_APPLICATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DefaultMasterServerImpl <em>Default Master Server</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.DefaultMasterServerImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDefaultMasterServer()
     * @generated
     */
    int DEFAULT_MASTER_SERVER = 22;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__SHORT_DESCRIPTION = MASTER_SERVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__NAME = MASTER_SERVER__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__CONNECTIONS = MASTER_SERVER__CONNECTIONS;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__EXPORTER = MASTER_SERVER__EXPORTER;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__CUSTOMIZATION_PROFILE = MASTER_SERVER__CUSTOMIZATION_PROFILE;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__SECURITY_CONFIGURATION = MASTER_SERVER__SECURITY_CONFIGURATION;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__MODULES = MASTER_SERVER__MODULES;

    /**
     * The feature id for the '<em><b>Summary Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__SUMMARY_GROUPS = MASTER_SERVER__SUMMARY_GROUPS;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__ITEMS = MASTER_SERVER__ITEMS;

    /**
     * The feature id for the '<em><b>Markers</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__MARKERS = MASTER_SERVER__MARKERS;

    /**
     * The feature id for the '<em><b>Ae Server Information Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX = MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX;

    /**
     * The feature id for the '<em><b>Monitor Pools</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__MONITOR_POOLS = MASTER_SERVER__MONITOR_POOLS;

    /**
     * The feature id for the '<em><b>Event Pools</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__EVENT_POOLS = MASTER_SERVER__EVENT_POOLS;

    /**
     * The feature id for the '<em><b>Data Mapper</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__DATA_MAPPER = MASTER_SERVER__DATA_MAPPER;

    /**
     * The feature id for the '<em><b>External Event Monitors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__EXTERNAL_EVENT_MONITORS = MASTER_SERVER__EXTERNAL_EVENT_MONITORS;

    /**
     * The feature id for the '<em><b>External Event Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__EXTERNAL_EVENT_FILTERS = MASTER_SERVER__EXTERNAL_EVENT_FILTERS;

    /**
     * The feature id for the '<em><b>Averages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__AVERAGES = MASTER_SERVER__AVERAGES;

    /**
     * The feature id for the '<em><b>Moving Averages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER__MOVING_AVERAGES = MASTER_SERVER__MOVING_AVERAGES;

    /**
     * The number of structural features of the '<em>Default Master Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER_FEATURE_COUNT = MASTER_SERVER_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER___GET_PROFILE = MASTER_SERVER___GET_PROFILE;

    /**
     * The number of operations of the '<em>Default Master Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_MASTER_SERVER_OPERATION_COUNT = MASTER_SERVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.CustomMasterServerImpl <em>Custom Master Server</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.CustomMasterServerImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getCustomMasterServer()
     * @generated
     */
    int CUSTOM_MASTER_SERVER = 23;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__SHORT_DESCRIPTION = MASTER_SERVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__NAME = MASTER_SERVER__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__CONNECTIONS = MASTER_SERVER__CONNECTIONS;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__EXPORTER = MASTER_SERVER__EXPORTER;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__CUSTOMIZATION_PROFILE = MASTER_SERVER__CUSTOMIZATION_PROFILE;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__SECURITY_CONFIGURATION = MASTER_SERVER__SECURITY_CONFIGURATION;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__MODULES = MASTER_SERVER__MODULES;

    /**
     * The feature id for the '<em><b>Summary Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__SUMMARY_GROUPS = MASTER_SERVER__SUMMARY_GROUPS;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__ITEMS = MASTER_SERVER__ITEMS;

    /**
     * The feature id for the '<em><b>Markers</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__MARKERS = MASTER_SERVER__MARKERS;

    /**
     * The feature id for the '<em><b>Ae Server Information Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX = MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX;

    /**
     * The feature id for the '<em><b>Monitor Pools</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__MONITOR_POOLS = MASTER_SERVER__MONITOR_POOLS;

    /**
     * The feature id for the '<em><b>Event Pools</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__EVENT_POOLS = MASTER_SERVER__EVENT_POOLS;

    /**
     * The feature id for the '<em><b>Data Mapper</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__DATA_MAPPER = MASTER_SERVER__DATA_MAPPER;

    /**
     * The feature id for the '<em><b>External Event Monitors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__EXTERNAL_EVENT_MONITORS = MASTER_SERVER__EXTERNAL_EVENT_MONITORS;

    /**
     * The feature id for the '<em><b>External Event Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__EXTERNAL_EVENT_FILTERS = MASTER_SERVER__EXTERNAL_EVENT_FILTERS;

    /**
     * The feature id for the '<em><b>Averages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__AVERAGES = MASTER_SERVER__AVERAGES;

    /**
     * The feature id for the '<em><b>Moving Averages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__MOVING_AVERAGES = MASTER_SERVER__MOVING_AVERAGES;

    /**
     * The feature id for the '<em><b>Profile</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER__PROFILE = MASTER_SERVER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Custom Master Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER_FEATURE_COUNT = MASTER_SERVER_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER___GET_PROFILE = MASTER_SERVER___GET_PROFILE;

    /**
     * The number of operations of the '<em>Custom Master Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_MASTER_SERVER_OPERATION_COUNT = MASTER_SERVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.ApplicationModule <em>Application Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.ApplicationModule
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getApplicationModule()
     * @generated
     */
    int APPLICATION_MODULE = 24;

    /**
     * The number of structural features of the '<em>Application Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_MODULE_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Application Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_MODULE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AttributesSummaryImpl <em>Attributes Summary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.AttributesSummaryImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAttributesSummary()
     * @generated
     */
    int ATTRIBUTES_SUMMARY = 25;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTES_SUMMARY__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTES_SUMMARY__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTES_SUMMARY__ATTRIBUTES = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Output Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTES_SUMMARY__OUTPUT_PREFIX = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Attributes Summary</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTES_SUMMARY_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Attributes Summary</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTES_SUMMARY_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.EventLoggerImpl <em>Event Logger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.EventLoggerImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventLogger()
     * @generated
     */
    int EVENT_LOGGER = 26;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_LOGGER__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_LOGGER__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Log Attributes Change</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_LOGGER__LOG_ATTRIBUTES_CHANGE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Log Value Change</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_LOGGER__LOG_VALUE_CHANGE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Log Subscription Change</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_LOGGER__LOG_SUBSCRIPTION_CHANGE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Log Writes</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_LOGGER__LOG_WRITES = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Event Logger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_LOGGER_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Event Logger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_LOGGER_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MonitorPoolImpl <em>Monitor Pool</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.MonitorPoolImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMonitorPool()
     * @generated
     */
    int MONITOR_POOL = 27;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL__FILTER = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Monitor Pool</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Monitor Pool</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.EventPoolImpl <em>Event Pool</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.EventPoolImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventPool()
     * @generated
     */
    int EVENT_POOL = 28;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL__FILTER = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL__SIZE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Event Pool</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Event Pool</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DataMapperImpl <em>Data Mapper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.DataMapperImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDataMapper()
     * @generated
     */
    int DATA_MAPPER = 29;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The number of structural features of the '<em>Data Mapper</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Data Mapper</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.SimpleDataMapperImpl <em>Simple Data Mapper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.SimpleDataMapperImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSimpleDataMapper()
     * @generated
     */
    int SIMPLE_DATA_MAPPER = 30;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_DATA_MAPPER__SHORT_DESCRIPTION = DATA_MAPPER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_DATA_MAPPER__NAME = DATA_MAPPER__NAME;

    /**
     * The feature id for the '<em><b>Entries</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_DATA_MAPPER__ENTRIES = DATA_MAPPER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Simple Data Mapper</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_DATA_MAPPER_FEATURE_COUNT = DATA_MAPPER_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Simple Data Mapper</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_DATA_MAPPER_OPERATION_COUNT = DATA_MAPPER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcDataMapperImpl <em>Jdbc Data Mapper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.JdbcDataMapperImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getJdbcDataMapper()
     * @generated
     */
    int JDBC_DATA_MAPPER = 31;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DATA_MAPPER__SHORT_DESCRIPTION = DATA_MAPPER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DATA_MAPPER__NAME = DATA_MAPPER__NAME;

    /**
     * The feature id for the '<em><b>Jdbc Driver</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DATA_MAPPER__JDBC_DRIVER = DATA_MAPPER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DATA_MAPPER__SQL = DATA_MAPPER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DATA_MAPPER__PROPERTIES = DATA_MAPPER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Jdbc Data Mapper</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DATA_MAPPER_FEATURE_COUNT = DATA_MAPPER_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Jdbc Data Mapper</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DATA_MAPPER_OPERATION_COUNT = DATA_MAPPER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DataMapperEntryImpl <em>Data Mapper Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.DataMapperEntryImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDataMapperEntry()
     * @generated
     */
    int DATA_MAPPER_ENTRY = 32;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ENTRY__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ENTRY__VALUE = 1;

    /**
     * The number of structural features of the '<em>Data Mapper Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ENTRY_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Data Mapper Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ENTRY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ValueMapperImpl <em>Value Mapper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ValueMapperImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getValueMapper()
     * @generated
     */
    int VALUE_MAPPER = 33;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MAPPER__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MAPPER__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Source Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MAPPER__SOURCE_ATTRIBUTE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MAPPER__TARGET_ATTRIBUTE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Data Mapper</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MAPPER__DATA_MAPPER = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Value Mapper</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MAPPER_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Value Mapper</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MAPPER_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.PersistentItemImpl <em>Persistent Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.PersistentItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getPersistentItem()
     * @generated
     */
    int PERSISTENT_ITEM = 34;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The number of structural features of the '<em>Persistent Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Persistent Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ProxyItemImpl <em>Proxy Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ProxyItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getProxyItem()
     * @generated
     */
    int PROXY_ITEM = 35;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Items</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_ITEM__ITEMS = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Proxy Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Proxy Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ScaleImpl <em>Scale</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ScaleImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getScale()
     * @generated
     */
    int SCALE = 36;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE__ACTIVE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Factor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE__FACTOR = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE__OFFSET = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Scale</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Scale</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.NegateImpl <em>Negate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.NegateImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getNegate()
     * @generated
     */
    int NEGATE = 37;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEGATE__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEGATE__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEGATE__ACTIVE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Negate</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEGATE_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Negate</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NEGATE_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.RoundingImpl <em>Rounding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.RoundingImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getRounding()
     * @generated
     */
    int ROUNDING = 38;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDING__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDING__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDING__TYPE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Rounding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDING_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Rounding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDING_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ExternalEventMonitorImpl <em>External Event Monitor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ExternalEventMonitorImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getExternalEventMonitor()
     * @generated
     */
    int EXTERNAL_EVENT_MONITOR = 39;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_EVENT_MONITOR__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_EVENT_MONITOR__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_EVENT_MONITOR__FILTER = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_EVENT_MONITOR__PROPERTIES = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>External Event Monitor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_EVENT_MONITOR_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>External Event Monitor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_EVENT_MONITOR_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.PropertyEntryImpl <em>Property Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.PropertyEntryImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getPropertyEntry()
     * @generated
     */
    int PROPERTY_ENTRY = 40;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_ENTRY__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_ENTRY__VALUE = 1;

    /**
     * The number of structural features of the '<em>Property Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_ENTRY_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Property Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_ENTRY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ExternalEventFilterImpl <em>External Event Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ExternalEventFilterImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getExternalEventFilter()
     * @generated
     */
    int EXTERNAL_EVENT_FILTER = 41;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_EVENT_FILTER__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_EVENT_FILTER__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The number of structural features of the '<em>External Event Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_EVENT_FILTER_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>External Event Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_EVENT_FILTER_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.StaticExternalEventFilterImpl <em>Static External Event Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.StaticExternalEventFilterImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getStaticExternalEventFilter()
     * @generated
     */
    int STATIC_EXTERNAL_EVENT_FILTER = 42;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATIC_EXTERNAL_EVENT_FILTER__SHORT_DESCRIPTION = EXTERNAL_EVENT_FILTER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATIC_EXTERNAL_EVENT_FILTER__NAME = EXTERNAL_EVENT_FILTER__NAME;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATIC_EXTERNAL_EVENT_FILTER__VALUE = EXTERNAL_EVENT_FILTER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Static External Event Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATIC_EXTERNAL_EVENT_FILTER_FEATURE_COUNT = EXTERNAL_EVENT_FILTER_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Static External Event Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATIC_EXTERNAL_EVENT_FILTER_OPERATION_COUNT = EXTERNAL_EVENT_FILTER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.SimpleExternalEventFilterImpl <em>Simple External Event Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.SimpleExternalEventFilterImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSimpleExternalEventFilter()
     * @generated
     */
    int SIMPLE_EXTERNAL_EVENT_FILTER = 43;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_EXTERNAL_EVENT_FILTER__SHORT_DESCRIPTION = EXTERNAL_EVENT_FILTER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_EXTERNAL_EVENT_FILTER__NAME = EXTERNAL_EVENT_FILTER__NAME;

    /**
     * The feature id for the '<em><b>Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_EXTERNAL_EVENT_FILTER__FILTER = EXTERNAL_EVENT_FILTER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Simple External Event Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_EXTERNAL_EVENT_FILTER_FEATURE_COUNT = EXTERNAL_EVENT_FILTER_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Simple External Event Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_EXTERNAL_EVENT_FILTER_OPERATION_COUNT = EXTERNAL_EVENT_FILTER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ItemReferenceImpl <em>Item Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ItemReferenceImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getItemReference()
     * @generated
     */
    int ITEM_REFERENCE = 47;

    /**
     * The feature id for the '<em><b>Item</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_REFERENCE__ITEM = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_REFERENCE__NAME = 1;

    /**
     * The number of structural features of the '<em>Item Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_REFERENCE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Item Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_REFERENCE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.TypedItemReferenceImpl <em>Typed Item Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.TypedItemReferenceImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getTypedItemReference()
     * @generated
     */
    int TYPED_ITEM_REFERENCE = 44;

    /**
     * The feature id for the '<em><b>Item</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPED_ITEM_REFERENCE__ITEM = ITEM_REFERENCE__ITEM;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPED_ITEM_REFERENCE__NAME = ITEM_REFERENCE__NAME;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPED_ITEM_REFERENCE__TYPE = ITEM_REFERENCE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Typed Item Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPED_ITEM_REFERENCE_FEATURE_COUNT = ITEM_REFERENCE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Typed Item Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TYPED_ITEM_REFERENCE_OPERATION_COUNT = ITEM_REFERENCE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.CodeFragmentImpl <em>Code Fragment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.CodeFragmentImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getCodeFragment()
     * @generated
     */
    int CODE_FRAGMENT = 45;

    /**
     * The feature id for the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CODE_FRAGMENT__CODE = 0;

    /**
     * The number of structural features of the '<em>Code Fragment</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CODE_FRAGMENT_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Code Fragment</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CODE_FRAGMENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptTimerImpl <em>Script Timer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ScriptTimerImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getScriptTimer()
     * @generated
     */
    int SCRIPT_TIMER = 46;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TIMER__SCRIPT = 0;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TIMER__PERIOD = 1;

    /**
     * The number of structural features of the '<em>Script Timer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TIMER_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Script Timer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_TIMER_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemImpl <em>Formula Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.FormulaItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getFormulaItem()
     * @generated
     */
    int FORMULA_ITEM = 48;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Script Engine</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM__SCRIPT_ENGINE = ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Init Scripts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM__INIT_SCRIPTS = ITEM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Outbound</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM__OUTBOUND = ITEM_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Inbound</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM__INBOUND = ITEM_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Formula Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Formula Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemOutboundImpl <em>Formula Item Outbound</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.FormulaItemOutboundImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getFormulaItemOutbound()
     * @generated
     */
    int FORMULA_ITEM_OUTBOUND = 49;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_OUTBOUND__OUTPUT = 0;

    /**
     * The feature id for the '<em><b>Output Formula</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_OUTBOUND__OUTPUT_FORMULA = 1;

    /**
     * The feature id for the '<em><b>Write Value Variable Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_OUTBOUND__WRITE_VALUE_VARIABLE_NAME = 2;

    /**
     * The number of structural features of the '<em>Formula Item Outbound</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_OUTBOUND_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Formula Item Outbound</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_OUTBOUND_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemInboundImpl <em>Formula Item Inbound</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.FormulaItemInboundImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getFormulaItemInbound()
     * @generated
     */
    int FORMULA_ITEM_INBOUND = 50;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_INBOUND__INPUTS = 0;

    /**
     * The feature id for the '<em><b>Input Formula</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_INBOUND__INPUT_FORMULA = 1;

    /**
     * The number of structural features of the '<em>Formula Item Inbound</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_INBOUND_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Formula Item Inbound</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_ITEM_INBOUND_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl <em>Boolean Monitor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getBooleanMonitor()
     * @generated
     */
    int BOOLEAN_MONITOR = 51;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Reference Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR__REFERENCE_VALUE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR__ACTIVE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Demote Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR__DEMOTE_PREFIX = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Severity</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR__SEVERITY = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR__MESSAGE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Suppress Events</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR__SUPPRESS_EVENTS = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Require Ack</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR__REQUIRE_ACK = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Boolean Monitor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 7;

    /**
     * The number of operations of the '<em>Boolean Monitor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BOOLEAN_MONITOR_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl <em>List Monitor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getListMonitor()
     * @generated
     */
    int LIST_MONITOR = 52;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Message</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR__MESSAGE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Message Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR__MESSAGE_ATTRIBUTE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Default Ack</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR__DEFAULT_ACK = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Default Severity</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR__DEFAULT_SEVERITY = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Monitor Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR__MONITOR_TYPE = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Demote Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR__DEMOTE_PREFIX = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Entries</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR__ENTRIES = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>List Monitor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 7;

    /**
     * The number of operations of the '<em>List Monitor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorEntryImpl <em>List Monitor Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ListMonitorEntryImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getListMonitorEntry()
     * @generated
     */
    int LIST_MONITOR_ENTRY = 53;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR_ENTRY__VALUE = 0;

    /**
     * The feature id for the '<em><b>Require Ack</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR_ENTRY__REQUIRE_ACK = 1;

    /**
     * The feature id for the '<em><b>Severity</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR_ENTRY__SEVERITY = 2;

    /**
     * The number of structural features of the '<em>List Monitor Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR_ENTRY_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>List Monitor Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_MONITOR_ENTRY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AverageImpl <em>Average</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.AverageImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAverage()
     * @generated
     */
    int AVERAGE = 54;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Items</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE__ITEMS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Sources Required</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE__SOURCES_REQUIRED = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Average</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Average</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl <em>Moving Average</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMovingAverage()
     * @generated
     */
    int MOVING_AVERAGE = 55;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE__ITEM = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Range</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE__RANGE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Null Range</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE__NULL_RANGE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE__TRIGGER = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Trigger Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE__TRIGGER_ONLY = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Moving Average</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 5;

    /**
     * The number of operations of the '<em>Moving Average</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AverageItemImpl <em>Average Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.AverageItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAverageItem()
     * @generated
     */
    int AVERAGE_ITEM = 56;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_ITEM__SOURCE = ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_ITEM__TYPE = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Average Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Average Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageItemImpl <em>Moving Average Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.MovingAverageItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMovingAverageItem()
     * @generated
     */
    int MOVING_AVERAGE_ITEM = 57;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE_ITEM__SOURCE = ITEM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE_ITEM__TYPE = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Moving Average Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Moving Average Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOVING_AVERAGE_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.BlockingsImpl <em>Blockings</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.BlockingsImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getBlockings()
     * @generated
     */
    int BLOCKINGS = 58;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCKINGS__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCKINGS__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Groups</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCKINGS__GROUPS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Blockings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCKINGS_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Blockings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCKINGS_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.BlockGroupImpl <em>Block Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.BlockGroupImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getBlockGroup()
     * @generated
     */
    int BLOCK_GROUP = 59;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_GROUP__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_GROUP__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Handlers</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_GROUP__HANDLERS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Hierarchy</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_GROUP__HIERARCHY = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Block Group</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_GROUP_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Block Group</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_GROUP_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.BlockHandlerImpl <em>Block Handler</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.BlockHandlerImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getBlockHandler()
     * @generated
     */
    int BLOCK_HANDLER = 60;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_HANDLER__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_HANDLER__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The feature id for the '<em><b>Group</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_HANDLER__GROUP = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Block Handler</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_HANDLER_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Block Handler</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_HANDLER_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.BlockImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getBlock()
     * @generated
     */
    int BLOCK = 61;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK__NAME = ITEM_FEATURE_ENTRY__NAME;

    /**
     * The feature id for the '<em><b>Item</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK__ITEM = ITEM_FEATURE_ENTRY__ITEM;

    /**
     * The number of structural features of the '<em>Block</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_FEATURE_COUNT = ITEM_FEATURE_ENTRY_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Block</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BLOCK_OPERATION_COUNT = ITEM_FEATURE_ENTRY_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.GlobalSummaryItemImpl <em>Global Summary Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.GlobalSummaryItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getGlobalSummaryItem()
     * @generated
     */
    int GLOBAL_SUMMARY_ITEM = 62;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL_SUMMARY_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL_SUMMARY_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL_SUMMARY_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL_SUMMARY_ITEM__ATTRIBUTE = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Global Summary Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL_SUMMARY_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Global Summary Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL_SUMMARY_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.WeakReferenceDataSourceItemImpl <em>Weak Reference Data Source Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.WeakReferenceDataSourceItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getWeakReferenceDataSourceItem()
     * @generated
     */
    int WEAK_REFERENCE_DATA_SOURCE_ITEM = 63;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_REFERENCE_DATA_SOURCE_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_REFERENCE_DATA_SOURCE_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_REFERENCE_DATA_SOURCE_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Data Source Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_REFERENCE_DATA_SOURCE_ITEM__DATA_SOURCE_ID = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Weak Reference Data Source Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_REFERENCE_DATA_SOURCE_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Weak Reference Data Source Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEAK_REFERENCE_DATA_SOURCE_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsExporterImpl <em>Alarms Events Exporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsExporterImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAlarmsEventsExporter()
     * @generated
     */
    int ALARMS_EVENTS_EXPORTER = 64;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_EXPORTER__SHORT_DESCRIPTION = EXPORTER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_EXPORTER__NAME = EXPORTER__NAME;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_EXPORTER__ENDPOINTS = EXPORTER__ENDPOINTS;

    /**
     * The number of structural features of the '<em>Alarms Events Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_EXPORTER_FEATURE_COUNT = EXPORTER_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Type Tag</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_EXPORTER___GET_TYPE_TAG = EXPORTER_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Alarms Events Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_EXPORTER_OPERATION_COUNT = EXPORTER_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsConnectionImpl <em>Alarms Events Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsConnectionImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAlarmsEventsConnection()
     * @generated
     */
    int ALARMS_EVENTS_CONNECTION = 65;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION__SHORT_DESCRIPTION = CONNECTION__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION__NAME = CONNECTION__NAME;

    /**
     * The feature id for the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION__ENDPOINT = CONNECTION__ENDPOINT;

    /**
     * The feature id for the '<em><b>Endpoint Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION__ENDPOINT_LABEL = CONNECTION__ENDPOINT_LABEL;

    /**
     * The feature id for the '<em><b>Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION__CREDENTIALS = CONNECTION__CREDENTIALS;

    /**
     * The feature id for the '<em><b>Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION__TIMEOUT = CONNECTION__TIMEOUT;

    /**
     * The number of structural features of the '<em>Alarms Events Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Possible Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION___GET_POSSIBLE_ENDPOINTS__EXPORTER = CONNECTION___GET_POSSIBLE_ENDPOINTS__EXPORTER;

    /**
     * The operation id for the '<em>Get Type Tag</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION___GET_TYPE_TAG = CONNECTION_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Make Uri</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION___MAKE_URI__BOOLEAN = CONNECTION_OPERATION_COUNT + 1;

    /**
     * The number of operations of the '<em>Alarms Events Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_CONNECTION_OPERATION_COUNT = CONNECTION_OPERATION_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MonitorPoolProxyImpl <em>Monitor Pool Proxy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.MonitorPoolProxyImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMonitorPoolProxy()
     * @generated
     */
    int MONITOR_POOL_PROXY = 66;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_PROXY__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_PROXY__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Local</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_PROXY__LOCAL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Remote</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_PROXY__REMOTE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Monitor Pool Proxy</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_PROXY_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Monitor Pool Proxy</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_PROXY_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.EventPoolProxyImpl <em>Event Pool Proxy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.EventPoolProxyImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventPoolProxy()
     * @generated
     */
    int EVENT_POOL_PROXY = 67;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_PROXY__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_PROXY__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Local</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_PROXY__LOCAL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Remote</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_PROXY__REMOTE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_PROXY__SIZE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Event Pool Proxy</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_PROXY_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Event Pool Proxy</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_PROXY_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsModuleImpl <em>Alarms Events Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsModuleImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAlarmsEventsModule()
     * @generated
     */
    int ALARMS_EVENTS_MODULE = 68;

    /**
     * The feature id for the '<em><b>Monitor Pool Proxies</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_MODULE__MONITOR_POOL_PROXIES = APPLICATION_MODULE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Event Pool Proxies</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_MODULE__EVENT_POOL_PROXIES = APPLICATION_MODULE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Akn Proxies</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_MODULE__AKN_PROXIES = APPLICATION_MODULE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Pull Events</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_MODULE__PULL_EVENTS = APPLICATION_MODULE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Alarms Events Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_MODULE_FEATURE_COUNT = APPLICATION_MODULE_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Alarms Events Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ALARMS_EVENTS_MODULE_OPERATION_COUNT = APPLICATION_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AknProxyImpl <em>Akn Proxy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.AknProxyImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAknProxy()
     * @generated
     */
    int AKN_PROXY = 69;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AKN_PROXY__PATTERN = 0;

    /**
     * The feature id for the '<em><b>Connection</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AKN_PROXY__CONNECTION = 1;

    /**
     * The feature id for the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AKN_PROXY__PRIORITY = 2;

    /**
     * The feature id for the '<em><b>Authorative</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AKN_PROXY__AUTHORATIVE = 3;

    /**
     * The number of structural features of the '<em>Akn Proxy</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AKN_PROXY_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Akn Proxy</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AKN_PROXY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl <em>Pull Events</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getPullEvents()
     * @generated
     */
    int PULL_EVENTS = 70;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PULL_EVENTS__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PULL_EVENTS__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Jdbc Driver Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PULL_EVENTS__JDBC_DRIVER_NAME = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Jdbc Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PULL_EVENTS__JDBC_PROPERTIES = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Job Interval</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PULL_EVENTS__JOB_INTERVAL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Custom Select Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PULL_EVENTS__CUSTOM_SELECT_SQL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Custom Delete Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PULL_EVENTS__CUSTOM_DELETE_SQL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Pull Events</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PULL_EVENTS_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 5;

    /**
     * The number of operations of the '<em>Pull Events</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PULL_EVENTS_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceModuleImpl <em>Jdbc User Service Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceModuleImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getJdbcUserServiceModule()
     * @generated
     */
    int JDBC_USER_SERVICE_MODULE = 71;

    /**
     * The feature id for the '<em><b>User Services</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE_MODULE__USER_SERVICES = APPLICATION_MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Jdbc User Service Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE_MODULE_FEATURE_COUNT = APPLICATION_MODULE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Jdbc User Service Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE_MODULE_OPERATION_COUNT = APPLICATION_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl <em>Jdbc User Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getJdbcUserService()
     * @generated
     */
    int JDBC_USER_SERVICE = 72;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Jdbc Propeties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__JDBC_PROPETIES = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Jdbc Driver</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__JDBC_DRIVER = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Authorative</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__AUTHORATIVE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Find User Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__FIND_USER_SQL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Find Roles For User Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Update Password Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>User Id Column Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__USER_ID_COLUMN_NAME = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Password Column Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Password Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__PASSWORD_TYPE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>Jdbc User Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 9;

    /**
     * The number of operations of the '<em>Jdbc User Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DefaultValueArchiveServerImpl <em>Default Value Archive Server</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.DefaultValueArchiveServerImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDefaultValueArchiveServer()
     * @generated
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER = 73;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER__SHORT_DESCRIPTION = VALUE_ARCHIVE_SERVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER__NAME = VALUE_ARCHIVE_SERVER__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER__CONNECTIONS = VALUE_ARCHIVE_SERVER__CONNECTIONS;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER__EXPORTER = VALUE_ARCHIVE_SERVER__EXPORTER;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE = VALUE_ARCHIVE_SERVER__CUSTOMIZATION_PROFILE;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER__SECURITY_CONFIGURATION = VALUE_ARCHIVE_SERVER__SECURITY_CONFIGURATION;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER__MODULES = VALUE_ARCHIVE_SERVER__MODULES;

    /**
     * The feature id for the '<em><b>Archives</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER__ARCHIVES = VALUE_ARCHIVE_SERVER__ARCHIVES;

    /**
     * The number of structural features of the '<em>Default Value Archive Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER_FEATURE_COUNT = VALUE_ARCHIVE_SERVER_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER___GET_PROFILE = VALUE_ARCHIVE_SERVER___GET_PROFILE;

    /**
     * The number of operations of the '<em>Default Value Archive Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_VALUE_ARCHIVE_SERVER_OPERATION_COUNT = VALUE_ARCHIVE_SERVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.HistoricalDataExporterImpl <em>Historical Data Exporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.HistoricalDataExporterImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getHistoricalDataExporter()
     * @generated
     */
    int HISTORICAL_DATA_EXPORTER = 74;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HISTORICAL_DATA_EXPORTER__SHORT_DESCRIPTION = EXPORTER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HISTORICAL_DATA_EXPORTER__NAME = EXPORTER__NAME;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HISTORICAL_DATA_EXPORTER__ENDPOINTS = EXPORTER__ENDPOINTS;

    /**
     * The number of structural features of the '<em>Historical Data Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HISTORICAL_DATA_EXPORTER_FEATURE_COUNT = EXPORTER_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Type Tag</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HISTORICAL_DATA_EXPORTER___GET_TYPE_TAG = EXPORTER_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Historical Data Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HISTORICAL_DATA_EXPORTER_OPERATION_COUNT = EXPORTER_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveImpl <em>Value Archive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getValueArchive()
     * @generated
     */
    int VALUE_ARCHIVE = 75;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Items</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE__ITEMS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Value Archive</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Value Archive</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ConfigurationAdministratorExporterImpl <em>Configuration Administrator Exporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ConfigurationAdministratorExporterImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getConfigurationAdministratorExporter()
     * @generated
     */
    int CONFIGURATION_ADMINISTRATOR_EXPORTER = 76;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_ADMINISTRATOR_EXPORTER__SHORT_DESCRIPTION = EXPORTER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_ADMINISTRATOR_EXPORTER__NAME = EXPORTER__NAME;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_ADMINISTRATOR_EXPORTER__ENDPOINTS = EXPORTER__ENDPOINTS;

    /**
     * The number of structural features of the '<em>Configuration Administrator Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_ADMINISTRATOR_EXPORTER_FEATURE_COUNT = EXPORTER_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Type Tag</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_ADMINISTRATOR_EXPORTER___GET_TYPE_TAG = EXPORTER_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Configuration Administrator Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_ADMINISTRATOR_EXPORTER_OPERATION_COUNT = EXPORTER_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ReferenceItemImpl <em>Reference Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.ReferenceItemImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getReferenceItem()
     * @generated
     */
    int REFERENCE_ITEM = 77;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_ITEM__NAME = ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_ITEM__INFORMATION = ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_ITEM__ITEM_FEATURES = ITEM__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_ITEM__SOURCE = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Reference Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Reference Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCE_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration <em>Application Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getApplicationConfiguration()
     * @generated
     */
    int APPLICATION_CONFIGURATION = 82;

    /**
     * The number of structural features of the '<em>Application Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_CONFIGURATION_FEATURE_COUNT = APPLICATION_MODULE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Application Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_CONFIGURATION_OPERATION_COUNT = APPLICATION_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.IndependentConfiguration <em>Independent Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.IndependentConfiguration
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getIndependentConfiguration()
     * @generated
     */
    int INDEPENDENT_CONFIGURATION = 85;

    /**
     * The number of structural features of the '<em>Independent Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INDEPENDENT_CONFIGURATION_FEATURE_COUNT = APPLICATION_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Independent Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INDEPENDENT_CONFIGURATION_OPERATION_COUNT = APPLICATION_CONFIGURATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.EventStorage <em>Event Storage</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.EventStorage
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventStorage()
     * @generated
     */
    int EVENT_STORAGE = 78;

    /**
     * The number of structural features of the '<em>Event Storage</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_FEATURE_COUNT = INDEPENDENT_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Event Storage</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_OPERATION_COUNT = INDEPENDENT_CONFIGURATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl <em>Abstract Event Storage Jdbc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAbstractEventStorageJdbc()
     * @generated
     */
    int ABSTRACT_EVENT_STORAGE_JDBC = 81;

    /**
     * The feature id for the '<em><b>Jdbc Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES = EVENT_STORAGE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Schema</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA = EVENT_STORAGE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Instance Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME = EVENT_STORAGE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Enable Replication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION = EVENT_STORAGE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Archive Days</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS = EVENT_STORAGE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Cleanup Period Seconds</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS = EVENT_STORAGE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Abstract Event Storage Jdbc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EVENT_STORAGE_JDBC_FEATURE_COUNT = EVENT_STORAGE_FEATURE_COUNT + 6;

    /**
     * The operation id for the '<em>Get Jdbc Driver Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EVENT_STORAGE_JDBC___GET_JDBC_DRIVER_NAME = EVENT_STORAGE_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Get Driver Bundles</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EVENT_STORAGE_JDBC___GET_DRIVER_BUNDLES = EVENT_STORAGE_OPERATION_COUNT + 1;

    /**
     * The number of operations of the '<em>Abstract Event Storage Jdbc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EVENT_STORAGE_JDBC_OPERATION_COUNT = EVENT_STORAGE_OPERATION_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.EventStorageJdbcImpl <em>Event Storage Jdbc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.EventStorageJdbcImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventStorageJdbc()
     * @generated
     */
    int EVENT_STORAGE_JDBC = 79;

    /**
     * The feature id for the '<em><b>Jdbc Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC__JDBC_PROPERTIES = ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES;

    /**
     * The feature id for the '<em><b>Schema</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC__SCHEMA = ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA;

    /**
     * The feature id for the '<em><b>Instance Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC__INSTANCE_NAME = ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME;

    /**
     * The feature id for the '<em><b>Enable Replication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC__ENABLE_REPLICATION = ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION;

    /**
     * The feature id for the '<em><b>Archive Days</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC__ARCHIVE_DAYS = ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS;

    /**
     * The feature id for the '<em><b>Cleanup Period Seconds</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS = ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS;

    /**
     * The feature id for the '<em><b>Jdbc Driver Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC__JDBC_DRIVER_NAME = ABSTRACT_EVENT_STORAGE_JDBC_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Driver Bundles</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC__DRIVER_BUNDLES = ABSTRACT_EVENT_STORAGE_JDBC_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Max Field Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC__MAX_FIELD_LENGTH = ABSTRACT_EVENT_STORAGE_JDBC_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Query Fetch Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC__QUERY_FETCH_SIZE = ABSTRACT_EVENT_STORAGE_JDBC_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Event Storage Jdbc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC_FEATURE_COUNT = ABSTRACT_EVENT_STORAGE_JDBC_FEATURE_COUNT + 4;

    /**
     * The operation id for the '<em>Get Jdbc Driver Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC___GET_JDBC_DRIVER_NAME = ABSTRACT_EVENT_STORAGE_JDBC___GET_JDBC_DRIVER_NAME;

    /**
     * The operation id for the '<em>Get Driver Bundles</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC___GET_DRIVER_BUNDLES = ABSTRACT_EVENT_STORAGE_JDBC___GET_DRIVER_BUNDLES;

    /**
     * The number of operations of the '<em>Event Storage Jdbc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_JDBC_OPERATION_COUNT = ABSTRACT_EVENT_STORAGE_JDBC_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.EventStoragePostgresImpl <em>Event Storage Postgres</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.EventStoragePostgresImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventStoragePostgres()
     * @generated
     */
    int EVENT_STORAGE_POSTGRES = 80;

    /**
     * The feature id for the '<em><b>Jdbc Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES__JDBC_PROPERTIES = ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES;

    /**
     * The feature id for the '<em><b>Schema</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES__SCHEMA = ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA;

    /**
     * The feature id for the '<em><b>Instance Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES__INSTANCE_NAME = ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME;

    /**
     * The feature id for the '<em><b>Enable Replication</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES__ENABLE_REPLICATION = ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION;

    /**
     * The feature id for the '<em><b>Archive Days</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES__ARCHIVE_DAYS = ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS;

    /**
     * The feature id for the '<em><b>Cleanup Period Seconds</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES__CLEANUP_PERIOD_SECONDS = ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS;

    /**
     * The feature id for the '<em><b>Batch Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES__BATCH_SIZE = ABSTRACT_EVENT_STORAGE_JDBC_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Postgres Driver Bundles</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES__POSTGRES_DRIVER_BUNDLES = ABSTRACT_EVENT_STORAGE_JDBC_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Event Storage Postgres</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES_FEATURE_COUNT = ABSTRACT_EVENT_STORAGE_JDBC_FEATURE_COUNT + 2;

    /**
     * The operation id for the '<em>Get Jdbc Driver Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES___GET_JDBC_DRIVER_NAME = ABSTRACT_EVENT_STORAGE_JDBC_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Get Driver Bundles</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES___GET_DRIVER_BUNDLES = ABSTRACT_EVENT_STORAGE_JDBC_OPERATION_COUNT + 1;

    /**
     * The number of operations of the '<em>Event Storage Postgres</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_STORAGE_POSTGRES_OPERATION_COUNT = ABSTRACT_EVENT_STORAGE_JDBC_OPERATION_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.RestExporterImpl <em>Rest Exporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.RestExporterImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getRestExporter()
     * @generated
     */
    int REST_EXPORTER = 83;

    /**
     * The feature id for the '<em><b>Items</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_EXPORTER__ITEMS = APPLICATION_MODULE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Hive Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_EXPORTER__HIVE_PROPERTIES = APPLICATION_MODULE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Context Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_EXPORTER__CONTEXT_ID = APPLICATION_MODULE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Rest Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_EXPORTER_FEATURE_COUNT = APPLICATION_MODULE_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Rest Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_EXPORTER_OPERATION_COUNT = APPLICATION_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.impl.HttpServiceImpl <em>Http Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.impl.HttpServiceImpl
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getHttpService()
     * @generated
     */
    int HTTP_SERVICE = 84;

    /**
     * The feature id for the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HTTP_SERVICE__ENDPOINT = APPLICATION_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Http Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HTTP_SERVICE_FEATURE_COUNT = APPLICATION_CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Http Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HTTP_SERVICE_OPERATION_COUNT = APPLICATION_CONFIGURATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.AverageReferenceType <em>Average Reference Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.AverageReferenceType
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAverageReferenceType()
     * @generated
     */
    int AVERAGE_REFERENCE_TYPE = 86;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType <em>Moving Average Reference Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMovingAverageReferenceType()
     * @generated
     */
    int MOVING_AVERAGE_REFERENCE_TYPE = 87;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.RoundingType <em>Rounding Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.RoundingType
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getRoundingType()
     * @generated
     */
    int ROUNDING_TYPE = 88;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.DataType <em>Data Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.DataType
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDataType()
     * @generated
     */
    int DATA_TYPE = 89;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.PasswordType <em>Password Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.PasswordType
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getPasswordType()
     * @generated
     */
    int PASSWORD_TYPE = 90;

    /**
     * The meta object id for the '<em>Severity</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ae.data.Severity
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSeverity()
     * @generated
     */
    int SEVERITY = 91;

    /**
     * The meta object id for the '<em>Variant</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.core.Variant
     * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getVariant()
     * @generated
     */
    int VARIANT = 92;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication <em>Equinox Application</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Equinox Application</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication
     * @generated
     */
    EClass getEquinoxApplication ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getConnections <em>Connections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Connections</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getConnections()
     * @see #getEquinoxApplication()
     * @generated
     */
    EReference getEquinoxApplication_Connections ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getExporter <em>Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Exporter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getExporter()
     * @see #getEquinoxApplication()
     * @generated
     */
    EReference getEquinoxApplication_Exporter ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getCustomizationProfile <em>Customization Profile</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Customization Profile</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getCustomizationProfile()
     * @see #getEquinoxApplication()
     * @generated
     */
    EReference getEquinoxApplication_CustomizationProfile ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getSecurityConfiguration <em>Security Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Security Configuration</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getSecurityConfiguration()
     * @see #getEquinoxApplication()
     * @generated
     */
    EReference getEquinoxApplication_SecurityConfiguration ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getModules <em>Modules</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Modules</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getModules()
     * @see #getEquinoxApplication()
     * @generated
     */
    EReference getEquinoxApplication_Modules ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getProfile() <em>Get Profile</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Profile</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication#getProfile()
     * @generated
     */
    EOperation getEquinoxApplication__GetProfile ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connection</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Connection
     * @generated
     */
    EClass getConnection ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.Connection#getEndpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Endpoint</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Connection#getEndpoint()
     * @see #getConnection()
     * @generated
     */
    EReference getConnection_Endpoint ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.Connection#getEndpointLabel <em>Endpoint Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Endpoint Label</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Connection#getEndpointLabel()
     * @see #getConnection()
     * @generated
     */
    EAttribute getConnection_EndpointLabel ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.Connection#getCredentials <em>Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Credentials</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Connection#getCredentials()
     * @see #getConnection()
     * @generated
     */
    EReference getConnection_Credentials ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.Connection#getTimeout <em>Timeout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timeout</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Connection#getTimeout()
     * @see #getConnection()
     * @generated
     */
    EAttribute getConnection_Timeout ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.Connection#getTypeTag() <em>Get Type Tag</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Type Tag</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.Connection#getTypeTag()
     * @generated
     */
    EOperation getConnection__GetTypeTag ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.Connection#getPossibleEndpoints(org.eclipse.scada.configuration.world.osgi.Exporter) <em>Get Possible Endpoints</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Possible Endpoints</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.Connection#getPossibleEndpoints(org.eclipse.scada.configuration.world.osgi.Exporter)
     * @generated
     */
    EOperation getConnection__GetPossibleEndpoints__Exporter ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.Connection#makeUri(boolean) <em>Make Uri</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Make Uri</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.Connection#makeUri(boolean)
     * @generated
     */
    EOperation getConnection__MakeUri__boolean ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.Exporter <em>Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exporter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Exporter
     * @generated
     */
    EClass getExporter ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.Exporter#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Endpoints</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Exporter#getEndpoints()
     * @see #getExporter()
     * @generated
     */
    EReference getExporter_Endpoints ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.Exporter#getTypeTag() <em>Get Type Tag</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Type Tag</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.Exporter#getTypeTag()
     * @generated
     */
    EOperation getExporter__GetTypeTag ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.DataAccessConnection <em>Data Access Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Access Connection</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.DataAccessConnection
     * @generated
     */
    EClass getDataAccessConnection ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.DataAccessConnection#getTypeTag() <em>Get Type Tag</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Type Tag</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.DataAccessConnection#getTypeTag()
     * @generated
     */
    EOperation getDataAccessConnection__GetTypeTag ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.DataAccessConnection#makeUri(boolean) <em>Make Uri</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Make Uri</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.DataAccessConnection#makeUri(boolean)
     * @generated
     */
    EOperation getDataAccessConnection__MakeUri__boolean ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.DataAccessExporter <em>Data Access Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Access Exporter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.DataAccessExporter
     * @generated
     */
    EClass getDataAccessExporter ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.DataAccessExporter#getExports <em>Exports</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Exports</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.DataAccessExporter#getExports()
     * @see #getDataAccessExporter()
     * @generated
     */
    EReference getDataAccessExporter_Exports ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.DataAccessExporter#getTypeTag() <em>Get Type Tag</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Type Tag</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.DataAccessExporter#getTypeTag()
     * @generated
     */
    EOperation getDataAccessExporter__GetTypeTag ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Item
     * @generated
     */
    EClass getItem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.Item#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Item#getName()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_Name ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.Item#getInformation <em>Information</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Information</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Item#getInformation()
     * @see #getItem()
     * @generated
     */
    EReference getItem_Information ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.Item#getItemFeatures <em>Item Features</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Item Features</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Item#getItemFeatures()
     * @see #getItem()
     * @generated
     */
    EReference getItem_ItemFeatures ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.SourceItem <em>Source Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Source Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SourceItem
     * @generated
     */
    EClass getSourceItem ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.SourceItem#getConnection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Connection</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SourceItem#getConnection()
     * @see #getSourceItem()
     * @generated
     */
    EReference getSourceItem_Connection ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.SourceItem#getSourceName <em>Source Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SourceItem#getSourceName()
     * @see #getSourceItem()
     * @generated
     */
    EAttribute getSourceItem_SourceName ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ItemExport <em>Item Export</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Export</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemExport
     * @generated
     */
    EClass getItemExport ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.ItemExport#getItem <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemExport#getItem()
     * @see #getItemExport()
     * @generated
     */
    EReference getItemExport_Item ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ItemExport#getExportName <em>Export Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Export Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemExport#getExportName()
     * @see #getItemExport()
     * @generated
     */
    EAttribute getItemExport_ExportName ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ItemInformation <em>Item Information</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Information</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemInformation
     * @generated
     */
    EClass getItemInformation ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ItemInformation#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemInformation#getDescription()
     * @see #getItemInformation()
     * @generated
     */
    EAttribute getItemInformation_Description ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ItemInformation#getUnit <em>Unit</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Unit</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemInformation#getUnit()
     * @see #getItemInformation()
     * @generated
     */
    EAttribute getItemInformation_Unit ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.world.osgi.ItemInformation#getHierarchy <em>Hierarchy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Hierarchy</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemInformation#getHierarchy()
     * @see #getItemInformation()
     * @generated
     */
    EAttribute getItemInformation_Hierarchy ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ItemInformation#getSystem <em>System</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>System</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemInformation#getSystem()
     * @see #getItemInformation()
     * @generated
     */
    EAttribute getItemInformation_System ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ItemInformation#getDataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Data Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemInformation#getDataType()
     * @see #getItemInformation()
     * @generated
     */
    EAttribute getItemInformation_DataType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor <em>Level Monitor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Level Monitor</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor
     * @generated
     */
    EClass getLevelMonitor ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getPreset <em>Preset</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Preset</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor#getPreset()
     * @see #getLevelMonitor()
     * @generated
     */
    EAttribute getLevelMonitor_Preset ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isCap <em>Cap</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Cap</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor#isCap()
     * @see #getLevelMonitor()
     * @generated
     */
    EAttribute getLevelMonitor_Cap ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getSeverity <em>Severity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Severity</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor#getSeverity()
     * @see #getLevelMonitor()
     * @generated
     */
    EAttribute getLevelMonitor_Severity ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isLowerOk <em>Lower Ok</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Lower Ok</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor#isLowerOk()
     * @see #getLevelMonitor()
     * @generated
     */
    EAttribute getLevelMonitor_LowerOk ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isIncludedOk <em>Included Ok</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Included Ok</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor#isIncludedOk()
     * @see #getLevelMonitor()
     * @generated
     */
    EAttribute getLevelMonitor_IncludedOk ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getPrefix <em>Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor#getPrefix()
     * @see #getLevelMonitor()
     * @generated
     */
    EAttribute getLevelMonitor_Prefix ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getDemotePrefix <em>Demote Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Demote Prefix</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor#getDemotePrefix()
     * @see #getLevelMonitor()
     * @generated
     */
    EAttribute getLevelMonitor_DemotePrefix ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isSuppressEvents <em>Suppress Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Suppress Events</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor#isSuppressEvents()
     * @see #getLevelMonitor()
     * @generated
     */
    EAttribute getLevelMonitor_SuppressEvents ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#isRequireAck <em>Require Ack</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Require Ack</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor#isRequireAck()
     * @see #getLevelMonitor()
     * @generated
     */
    EAttribute getLevelMonitor_RequireAck ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.LevelMonitor#getMonitorType <em>Monitor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Monitor Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.LevelMonitor#getMonitorType()
     * @see #getLevelMonitor()
     * @generated
     */
    EAttribute getLevelMonitor_MonitorType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry <em>Item Feature Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Feature Entry</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry
     * @generated
     */
    EClass getItemFeatureEntry ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry#getName()
     * @see #getItemFeatureEntry()
     * @generated
     */
    EAttribute getItemFeatureEntry_Name ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry#getItem <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry#getItem()
     * @see #getItemFeatureEntry()
     * @generated
     */
    EReference getItemFeatureEntry_Item ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem <em>Script Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptItem
     * @generated
     */
    EClass getScriptItem ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getInputs <em>Inputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Inputs</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptItem#getInputs()
     * @see #getScriptItem()
     * @generated
     */
    EReference getScriptItem_Inputs ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getInitScript <em>Init Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Init Script</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptItem#getInitScript()
     * @see #getScriptItem()
     * @generated
     */
    EReference getScriptItem_InitScript ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getUpdateScript <em>Update Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Update Script</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptItem#getUpdateScript()
     * @see #getScriptItem()
     * @generated
     */
    EReference getScriptItem_UpdateScript ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getTimer <em>Timer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Timer</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptItem#getTimer()
     * @see #getScriptItem()
     * @generated
     */
    EReference getScriptItem_Timer ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getScriptEngine <em>Script Engine</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Script Engine</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptItem#getScriptEngine()
     * @see #getScriptItem()
     * @generated
     */
    EAttribute getScriptItem_ScriptEngine ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getCommands <em>Commands</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Commands</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptItem#getCommands()
     * @see #getScriptItem()
     * @generated
     */
    EReference getScriptItem_Commands ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getWriteCommandScript <em>Write Command Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Write Command Script</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptItem#getWriteCommandScript()
     * @see #getScriptItem()
     * @generated
     */
    EReference getScriptItem_WriteCommandScript ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ImportItem <em>Import Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Import Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ImportItem
     * @generated
     */
    EClass getImportItem ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.ImportItem#getExport <em>Export</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Export</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ImportItem#getExport()
     * @see #getImportItem()
     * @generated
     */
    EReference getImportItem_Export ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.SummaryGroup <em>Summary Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Summary Group</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SummaryGroup
     * @generated
     */
    EClass getSummaryGroup ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.SummaryGroup#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SummaryGroup#getName()
     * @see #getSummaryGroup()
     * @generated
     */
    EAttribute getSummaryGroup_Name ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.SummaryGroup#getSubGroups <em>Sub Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sub Groups</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SummaryGroup#getSubGroups()
     * @see #getSummaryGroup()
     * @generated
     */
    EReference getSummaryGroup_SubGroups ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.SummaryGroup#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Items</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SummaryGroup#getItems()
     * @see #getSummaryGroup()
     * @generated
     */
    EReference getSummaryGroup_Items ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.MarkerGroup <em>Marker Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Marker Group</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MarkerGroup
     * @generated
     */
    EClass getMarkerGroup ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.MarkerGroup#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MarkerGroup#getName()
     * @see #getMarkerGroup()
     * @generated
     */
    EAttribute getMarkerGroup_Name ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.MarkerGroup#getMarkers <em>Markers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Markers</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MarkerGroup#getMarkers()
     * @see #getMarkerGroup()
     * @generated
     */
    EReference getMarkerGroup_Markers ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.Markers <em>Markers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Markers</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Markers
     * @generated
     */
    EClass getMarkers ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.Markers#getMarkerGroups <em>Marker Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Marker Groups</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Markers#getMarkerGroups()
     * @see #getMarkers()
     * @generated
     */
    EReference getMarkers_MarkerGroups ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ConstantItem <em>Constant Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Constant Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ConstantItem
     * @generated
     */
    EClass getConstantItem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ConstantItem#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ConstantItem#getValue()
     * @see #getConstantItem()
     * @generated
     */
    EAttribute getConstantItem_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.SummaryItem <em>Summary Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Summary Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SummaryItem
     * @generated
     */
    EClass getSummaryItem ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.SummaryItem#getGroup <em>Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Group</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SummaryItem#getGroup()
     * @see #getSummaryItem()
     * @generated
     */
    EReference getSummaryItem_Group ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.MarkerEntry <em>Marker Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Marker Entry</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MarkerEntry
     * @generated
     */
    EClass getMarkerEntry ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.MarkerEntry#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MarkerEntry#getName()
     * @see #getMarkerEntry()
     * @generated
     */
    EAttribute getMarkerEntry_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.MarkerEntry#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MarkerEntry#getValue()
     * @see #getMarkerEntry()
     * @generated
     */
    EAttribute getMarkerEntry_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ManualOverride <em>Manual Override</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Manual Override</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ManualOverride
     * @generated
     */
    EClass getManualOverride ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ManualOverride#getInitialValue <em>Initial Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Initial Value</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ManualOverride#getInitialValue()
     * @see #getManualOverride()
     * @generated
     */
    EAttribute getManualOverride_InitialValue ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.MasterServer <em>Master Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Master Server</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer
     * @generated
     */
    EClass getMasterServer ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getSummaryGroups <em>Summary Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Summary Groups</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getSummaryGroups()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_SummaryGroups ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Items</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getItems()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_Items ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getMarkers <em>Markers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Markers</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getMarkers()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_Markers ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getAeServerInformationPrefix <em>Ae Server Information Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ae Server Information Prefix</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getAeServerInformationPrefix()
     * @see #getMasterServer()
     * @generated
     */
    EAttribute getMasterServer_AeServerInformationPrefix ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getMonitorPools <em>Monitor Pools</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Monitor Pools</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getMonitorPools()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_MonitorPools ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getEventPools <em>Event Pools</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Event Pools</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getEventPools()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_EventPools ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getDataMapper <em>Data Mapper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Data Mapper</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getDataMapper()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_DataMapper ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getExternalEventMonitors <em>External Event Monitors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>External Event Monitors</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getExternalEventMonitors()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_ExternalEventMonitors ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getExternalEventFilters <em>External Event Filters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>External Event Filters</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getExternalEventFilters()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_ExternalEventFilters ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getAverages <em>Averages</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Averages</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getAverages()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_Averages ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.MasterServer#getMovingAverages <em>Moving Averages</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Moving Averages</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MasterServer#getMovingAverages()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_MovingAverages ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ValueArchiveServer <em>Value Archive Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Archive Server</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ValueArchiveServer
     * @generated
     */
    EClass getValueArchiveServer ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.ValueArchiveServer#getArchives <em>Archives</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Archives</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ValueArchiveServer#getArchives()
     * @see #getValueArchiveServer()
     * @generated
     */
    EReference getValueArchiveServer_Archives ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.DefaultMasterServer <em>Default Master Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Default Master Server</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.DefaultMasterServer
     * @generated
     */
    EClass getDefaultMasterServer ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.CustomMasterServer <em>Custom Master Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Custom Master Server</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.CustomMasterServer
     * @generated
     */
    EClass getCustomMasterServer ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.CustomMasterServer#getProfile <em>Profile</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Profile</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.CustomMasterServer#getProfile()
     * @see #getCustomMasterServer()
     * @generated
     */
    EReference getCustomMasterServer_Profile ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ApplicationModule <em>Application Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Application Module</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ApplicationModule
     * @generated
     */
    EClass getApplicationModule ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.AttributesSummary <em>Attributes Summary</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attributes Summary</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AttributesSummary
     * @generated
     */
    EClass getAttributesSummary ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.world.osgi.AttributesSummary#getAttributes <em>Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Attributes</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AttributesSummary#getAttributes()
     * @see #getAttributesSummary()
     * @generated
     */
    EAttribute getAttributesSummary_Attributes ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.AttributesSummary#getOutputPrefix <em>Output Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Output Prefix</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AttributesSummary#getOutputPrefix()
     * @see #getAttributesSummary()
     * @generated
     */
    EAttribute getAttributesSummary_OutputPrefix ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.EventLogger <em>Event Logger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Logger</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventLogger
     * @generated
     */
    EClass getEventLogger ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogAttributesChange <em>Log Attributes Change</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Log Attributes Change</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventLogger#isLogAttributesChange()
     * @see #getEventLogger()
     * @generated
     */
    EAttribute getEventLogger_LogAttributesChange ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogValueChange <em>Log Value Change</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Log Value Change</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventLogger#isLogValueChange()
     * @see #getEventLogger()
     * @generated
     */
    EAttribute getEventLogger_LogValueChange ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogSubscriptionChange <em>Log Subscription Change</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Log Subscription Change</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventLogger#isLogSubscriptionChange()
     * @see #getEventLogger()
     * @generated
     */
    EAttribute getEventLogger_LogSubscriptionChange ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventLogger#isLogWrites <em>Log Writes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Log Writes</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventLogger#isLogWrites()
     * @see #getEventLogger()
     * @generated
     */
    EAttribute getEventLogger_LogWrites ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.MonitorPool <em>Monitor Pool</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Monitor Pool</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MonitorPool
     * @generated
     */
    EClass getMonitorPool ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.MonitorPool#getFilter <em>Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Filter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MonitorPool#getFilter()
     * @see #getMonitorPool()
     * @generated
     */
    EAttribute getMonitorPool_Filter ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.EventPool <em>Event Pool</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Pool</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventPool
     * @generated
     */
    EClass getEventPool ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventPool#getFilter <em>Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Filter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventPool#getFilter()
     * @see #getEventPool()
     * @generated
     */
    EAttribute getEventPool_Filter ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventPool#getSize <em>Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Size</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventPool#getSize()
     * @see #getEventPool()
     * @generated
     */
    EAttribute getEventPool_Size ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.DataMapper <em>Data Mapper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Mapper</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.DataMapper
     * @generated
     */
    EClass getDataMapper ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.SimpleDataMapper <em>Simple Data Mapper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Data Mapper</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SimpleDataMapper
     * @generated
     */
    EClass getSimpleDataMapper ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.SimpleDataMapper#getEntries <em>Entries</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Entries</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SimpleDataMapper#getEntries()
     * @see #getSimpleDataMapper()
     * @generated
     */
    EReference getSimpleDataMapper_Entries ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.JdbcDataMapper <em>Jdbc Data Mapper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Jdbc Data Mapper</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcDataMapper
     * @generated
     */
    EClass getJdbcDataMapper ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getJdbcDriver <em>Jdbc Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Jdbc Driver</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getJdbcDriver()
     * @see #getJdbcDataMapper()
     * @generated
     */
    EAttribute getJdbcDataMapper_JdbcDriver ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getSql <em>Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sql</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getSql()
     * @see #getJdbcDataMapper()
     * @generated
     */
    EAttribute getJdbcDataMapper_Sql ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getProperties()
     * @see #getJdbcDataMapper()
     * @generated
     */
    EReference getJdbcDataMapper_Properties ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.DataMapperEntry <em>Data Mapper Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Mapper Entry</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.DataMapperEntry
     * @generated
     */
    EClass getDataMapperEntry ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.DataMapperEntry#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.DataMapperEntry#getKey()
     * @see #getDataMapperEntry()
     * @generated
     */
    EAttribute getDataMapperEntry_Key ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.DataMapperEntry#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.DataMapperEntry#getValue()
     * @see #getDataMapperEntry()
     * @generated
     */
    EAttribute getDataMapperEntry_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ValueMapper <em>Value Mapper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Mapper</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ValueMapper
     * @generated
     */
    EClass getValueMapper ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ValueMapper#getSourceAttribute <em>Source Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source Attribute</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ValueMapper#getSourceAttribute()
     * @see #getValueMapper()
     * @generated
     */
    EAttribute getValueMapper_SourceAttribute ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ValueMapper#getTargetAttribute <em>Target Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Target Attribute</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ValueMapper#getTargetAttribute()
     * @see #getValueMapper()
     * @generated
     */
    EAttribute getValueMapper_TargetAttribute ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.ValueMapper#getDataMapper <em>Data Mapper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Data Mapper</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ValueMapper#getDataMapper()
     * @see #getValueMapper()
     * @generated
     */
    EReference getValueMapper_DataMapper ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.PersistentItem <em>Persistent Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Persistent Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PersistentItem
     * @generated
     */
    EClass getPersistentItem ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ProxyItem <em>Proxy Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Proxy Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ProxyItem
     * @generated
     */
    EClass getProxyItem ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.ProxyItem#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Items</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ProxyItem#getItems()
     * @see #getProxyItem()
     * @generated
     */
    EReference getProxyItem_Items ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.Scale <em>Scale</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Scale</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Scale
     * @generated
     */
    EClass getScale ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.Scale#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Scale#isActive()
     * @see #getScale()
     * @generated
     */
    EAttribute getScale_Active ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.Scale#getFactor <em>Factor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Factor</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Scale#getFactor()
     * @see #getScale()
     * @generated
     */
    EAttribute getScale_Factor ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.Scale#getOffset <em>Offset</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Offset</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Scale#getOffset()
     * @see #getScale()
     * @generated
     */
    EAttribute getScale_Offset ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.Negate <em>Negate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Negate</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Negate
     * @generated
     */
    EClass getNegate ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.Negate#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Negate#isActive()
     * @see #getNegate()
     * @generated
     */
    EAttribute getNegate_Active ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.Rounding <em>Rounding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rounding</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Rounding
     * @generated
     */
    EClass getRounding ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.Rounding#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Rounding#getType()
     * @see #getRounding()
     * @generated
     */
    EAttribute getRounding_Type ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor <em>External Event Monitor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>External Event Monitor</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor
     * @generated
     */
    EClass getExternalEventMonitor ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor#getFilter <em>Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Filter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor#getFilter()
     * @see #getExternalEventMonitor()
     * @generated
     */
    EAttribute getExternalEventMonitor_Filter ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor#getProperties()
     * @see #getExternalEventMonitor()
     * @generated
     */
    EReference getExternalEventMonitor_Properties ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.PropertyEntry <em>Property Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property Entry</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PropertyEntry
     * @generated
     */
    EClass getPropertyEntry ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.PropertyEntry#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PropertyEntry#getKey()
     * @see #getPropertyEntry()
     * @generated
     */
    EAttribute getPropertyEntry_Key ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.PropertyEntry#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PropertyEntry#getValue()
     * @see #getPropertyEntry()
     * @generated
     */
    EAttribute getPropertyEntry_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ExternalEventFilter <em>External Event Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>External Event Filter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ExternalEventFilter
     * @generated
     */
    EClass getExternalEventFilter ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.StaticExternalEventFilter <em>Static External Event Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Static External Event Filter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.StaticExternalEventFilter
     * @generated
     */
    EClass getStaticExternalEventFilter ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.StaticExternalEventFilter#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.StaticExternalEventFilter#getValue()
     * @see #getStaticExternalEventFilter()
     * @generated
     */
    EAttribute getStaticExternalEventFilter_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.SimpleExternalEventFilter <em>Simple External Event Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple External Event Filter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SimpleExternalEventFilter
     * @generated
     */
    EClass getSimpleExternalEventFilter ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.SimpleExternalEventFilter#getFilter <em>Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Filter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.SimpleExternalEventFilter#getFilter()
     * @see #getSimpleExternalEventFilter()
     * @generated
     */
    EAttribute getSimpleExternalEventFilter_Filter ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.TypedItemReference <em>Typed Item Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Typed Item Reference</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.TypedItemReference
     * @generated
     */
    EClass getTypedItemReference ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.TypedItemReference#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.TypedItemReference#getType()
     * @see #getTypedItemReference()
     * @generated
     */
    EAttribute getTypedItemReference_Type ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.CodeFragment <em>Code Fragment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Code Fragment</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.CodeFragment
     * @generated
     */
    EClass getCodeFragment ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.CodeFragment#getCode <em>Code</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Code</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.CodeFragment#getCode()
     * @see #getCodeFragment()
     * @generated
     */
    EAttribute getCodeFragment_Code ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ScriptTimer <em>Script Timer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script Timer</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptTimer
     * @generated
     */
    EClass getScriptTimer ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.ScriptTimer#getScript <em>Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Script</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptTimer#getScript()
     * @see #getScriptTimer()
     * @generated
     */
    EReference getScriptTimer_Script ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ScriptTimer#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ScriptTimer#getPeriod()
     * @see #getScriptTimer()
     * @generated
     */
    EAttribute getScriptTimer_Period ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ItemReference <em>Item Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Reference</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemReference
     * @generated
     */
    EClass getItemReference ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.ItemReference#getItem <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemReference#getItem()
     * @see #getItemReference()
     * @generated
     */
    EReference getItemReference_Item ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ItemReference#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ItemReference#getName()
     * @see #getItemReference()
     * @generated
     */
    EAttribute getItemReference_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.FormulaItem <em>Formula Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Formula Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItem
     * @generated
     */
    EClass getFormulaItem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getScriptEngine <em>Script Engine</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Script Engine</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItem#getScriptEngine()
     * @see #getFormulaItem()
     * @generated
     */
    EAttribute getFormulaItem_ScriptEngine ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getInitScripts <em>Init Scripts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Init Scripts</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItem#getInitScripts()
     * @see #getFormulaItem()
     * @generated
     */
    EReference getFormulaItem_InitScripts ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getOutbound <em>Outbound</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Outbound</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItem#getOutbound()
     * @see #getFormulaItem()
     * @generated
     */
    EReference getFormulaItem_Outbound ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getInbound <em>Inbound</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Inbound</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItem#getInbound()
     * @see #getFormulaItem()
     * @generated
     */
    EReference getFormulaItem_Inbound ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound <em>Formula Item Outbound</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Formula Item Outbound</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound
     * @generated
     */
    EClass getFormulaItemOutbound ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getOutput <em>Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Output</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getOutput()
     * @see #getFormulaItemOutbound()
     * @generated
     */
    EReference getFormulaItemOutbound_Output ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getOutputFormula <em>Output Formula</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Output Formula</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getOutputFormula()
     * @see #getFormulaItemOutbound()
     * @generated
     */
    EAttribute getFormulaItemOutbound_OutputFormula ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getWriteValueVariableName <em>Write Value Variable Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Write Value Variable Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getWriteValueVariableName()
     * @see #getFormulaItemOutbound()
     * @generated
     */
    EAttribute getFormulaItemOutbound_WriteValueVariableName ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemInbound <em>Formula Item Inbound</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Formula Item Inbound</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItemInbound
     * @generated
     */
    EClass getFormulaItemInbound ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemInbound#getInputs <em>Inputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Inputs</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItemInbound#getInputs()
     * @see #getFormulaItemInbound()
     * @generated
     */
    EReference getFormulaItemInbound_Inputs ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemInbound#getInputFormula <em>Input Formula</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Input Formula</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.FormulaItemInbound#getInputFormula()
     * @see #getFormulaItemInbound()
     * @generated
     */
    EAttribute getFormulaItemInbound_InputFormula ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor <em>Boolean Monitor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Boolean Monitor</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BooleanMonitor
     * @generated
     */
    EClass getBooleanMonitor ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isReferenceValue <em>Reference Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Reference Value</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isReferenceValue()
     * @see #getBooleanMonitor()
     * @generated
     */
    EAttribute getBooleanMonitor_ReferenceValue ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isActive <em>Active</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Active</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isActive()
     * @see #getBooleanMonitor()
     * @generated
     */
    EAttribute getBooleanMonitor_Active ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getDemotePrefix <em>Demote Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Demote Prefix</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getDemotePrefix()
     * @see #getBooleanMonitor()
     * @generated
     */
    EAttribute getBooleanMonitor_DemotePrefix ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getSeverity <em>Severity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Severity</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getSeverity()
     * @see #getBooleanMonitor()
     * @generated
     */
    EAttribute getBooleanMonitor_Severity ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getMessage <em>Message</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Message</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BooleanMonitor#getMessage()
     * @see #getBooleanMonitor()
     * @generated
     */
    EAttribute getBooleanMonitor_Message ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isSuppressEvents <em>Suppress Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Suppress Events</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isSuppressEvents()
     * @see #getBooleanMonitor()
     * @generated
     */
    EAttribute getBooleanMonitor_SuppressEvents ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isRequireAck <em>Require Ack</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Require Ack</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BooleanMonitor#isRequireAck()
     * @see #getBooleanMonitor()
     * @generated
     */
    EAttribute getBooleanMonitor_RequireAck ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor <em>List Monitor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>List Monitor</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitor
     * @generated
     */
    EClass getListMonitor ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getMessage <em>Message</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Message</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitor#getMessage()
     * @see #getListMonitor()
     * @generated
     */
    EAttribute getListMonitor_Message ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getMessageAttribute <em>Message Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Message Attribute</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitor#getMessageAttribute()
     * @see #getListMonitor()
     * @generated
     */
    EAttribute getListMonitor_MessageAttribute ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#isDefaultAck <em>Default Ack</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Ack</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitor#isDefaultAck()
     * @see #getListMonitor()
     * @generated
     */
    EAttribute getListMonitor_DefaultAck ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getDefaultSeverity <em>Default Severity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Severity</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitor#getDefaultSeverity()
     * @see #getListMonitor()
     * @generated
     */
    EAttribute getListMonitor_DefaultSeverity ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getMonitorType <em>Monitor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Monitor Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitor#getMonitorType()
     * @see #getListMonitor()
     * @generated
     */
    EAttribute getListMonitor_MonitorType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getDemotePrefix <em>Demote Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Demote Prefix</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitor#getDemotePrefix()
     * @see #getListMonitor()
     * @generated
     */
    EAttribute getListMonitor_DemotePrefix ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.ListMonitor#getEntries <em>Entries</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Entries</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitor#getEntries()
     * @see #getListMonitor()
     * @generated
     */
    EReference getListMonitor_Entries ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry <em>List Monitor Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>List Monitor Entry</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitorEntry
     * @generated
     */
    EClass getListMonitorEntry ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getValue()
     * @see #getListMonitorEntry()
     * @generated
     */
    EAttribute getListMonitorEntry_Value ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getRequireAck <em>Require Ack</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Require Ack</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getRequireAck()
     * @see #getListMonitorEntry()
     * @generated
     */
    EAttribute getListMonitorEntry_RequireAck ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getSeverity <em>Severity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Severity</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ListMonitorEntry#getSeverity()
     * @see #getListMonitorEntry()
     * @generated
     */
    EAttribute getListMonitorEntry_Severity ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.Average <em>Average</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Average</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Average
     * @generated
     */
    EClass getAverage ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.Average#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Items</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Average#getItems()
     * @see #getAverage()
     * @generated
     */
    EReference getAverage_Items ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.Average#getSourcesRequired <em>Sources Required</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sources Required</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Average#getSourcesRequired()
     * @see #getAverage()
     * @generated
     */
    EAttribute getAverage_SourcesRequired ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.MovingAverage <em>Moving Average</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Moving Average</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverage
     * @generated
     */
    EClass getMovingAverage ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.MovingAverage#getItem <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverage#getItem()
     * @see #getMovingAverage()
     * @generated
     */
    EReference getMovingAverage_Item ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.MovingAverage#getRange <em>Range</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Range</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverage#getRange()
     * @see #getMovingAverage()
     * @generated
     */
    EAttribute getMovingAverage_Range ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.MovingAverage#getNullRange <em>Null Range</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Null Range</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverage#getNullRange()
     * @see #getMovingAverage()
     * @generated
     */
    EAttribute getMovingAverage_NullRange ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.MovingAverage#getTrigger <em>Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Trigger</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverage#getTrigger()
     * @see #getMovingAverage()
     * @generated
     */
    EAttribute getMovingAverage_Trigger ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.MovingAverage#getTriggerOnly <em>Trigger Only</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Trigger Only</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverage#getTriggerOnly()
     * @see #getMovingAverage()
     * @generated
     */
    EAttribute getMovingAverage_TriggerOnly ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.AverageItem <em>Average Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Average Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AverageItem
     * @generated
     */
    EClass getAverageItem ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.AverageItem#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AverageItem#getSource()
     * @see #getAverageItem()
     * @generated
     */
    EReference getAverageItem_Source ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.AverageItem#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AverageItem#getType()
     * @see #getAverageItem()
     * @generated
     */
    EAttribute getAverageItem_Type ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.MovingAverageItem <em>Moving Average Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Moving Average Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverageItem
     * @generated
     */
    EClass getMovingAverageItem ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.MovingAverageItem#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverageItem#getSource()
     * @see #getMovingAverageItem()
     * @generated
     */
    EReference getMovingAverageItem_Source ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.MovingAverageItem#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverageItem#getType()
     * @see #getMovingAverageItem()
     * @generated
     */
    EAttribute getMovingAverageItem_Type ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.Blockings <em>Blockings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Blockings</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Blockings
     * @generated
     */
    EClass getBlockings ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.Blockings#getGroups <em>Groups</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Groups</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Blockings#getGroups()
     * @see #getBlockings()
     * @generated
     */
    EReference getBlockings_Groups ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.BlockGroup <em>Block Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Block Group</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BlockGroup
     * @generated
     */
    EClass getBlockGroup ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.BlockGroup#getHandlers <em>Handlers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Handlers</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BlockGroup#getHandlers()
     * @see #getBlockGroup()
     * @generated
     */
    EReference getBlockGroup_Handlers ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.world.osgi.BlockGroup#getHierarchy <em>Hierarchy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Hierarchy</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BlockGroup#getHierarchy()
     * @see #getBlockGroup()
     * @generated
     */
    EAttribute getBlockGroup_Hierarchy ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.BlockHandler <em>Block Handler</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Block Handler</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BlockHandler
     * @generated
     */
    EClass getBlockHandler ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.BlockHandler#getGroup <em>Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Group</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.BlockHandler#getGroup()
     * @see #getBlockHandler()
     * @generated
     */
    EReference getBlockHandler_Group ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.Block <em>Block</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Block</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.Block
     * @generated
     */
    EClass getBlock ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.GlobalSummaryItem <em>Global Summary Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Global Summary Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.GlobalSummaryItem
     * @generated
     */
    EClass getGlobalSummaryItem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.GlobalSummaryItem#getAttribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Attribute</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.GlobalSummaryItem#getAttribute()
     * @see #getGlobalSummaryItem()
     * @generated
     */
    EAttribute getGlobalSummaryItem_Attribute ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem <em>Weak Reference Data Source Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Weak Reference Data Source Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem
     * @generated
     */
    EClass getWeakReferenceDataSourceItem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem#getDataSourceId <em>Data Source Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Data Source Id</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem#getDataSourceId()
     * @see #getWeakReferenceDataSourceItem()
     * @generated
     */
    EAttribute getWeakReferenceDataSourceItem_DataSourceId ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsExporter <em>Alarms Events Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Alarms Events Exporter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsExporter
     * @generated
     */
    EClass getAlarmsEventsExporter ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsExporter#getTypeTag() <em>Get Type Tag</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Type Tag</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsExporter#getTypeTag()
     * @generated
     */
    EOperation getAlarmsEventsExporter__GetTypeTag ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection <em>Alarms Events Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Alarms Events Connection</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection
     * @generated
     */
    EClass getAlarmsEventsConnection ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection#getTypeTag() <em>Get Type Tag</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Type Tag</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection#getTypeTag()
     * @generated
     */
    EOperation getAlarmsEventsConnection__GetTypeTag ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection#makeUri(boolean) <em>Make Uri</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Make Uri</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsConnection#makeUri(boolean)
     * @generated
     */
    EOperation getAlarmsEventsConnection__MakeUri__boolean ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy <em>Monitor Pool Proxy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Monitor Pool Proxy</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy
     * @generated
     */
    EClass getMonitorPoolProxy ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy#getLocal <em>Local</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Local</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy#getLocal()
     * @see #getMonitorPoolProxy()
     * @generated
     */
    EReference getMonitorPoolProxy_Local ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy#getRemote <em>Remote</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Remote</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy#getRemote()
     * @see #getMonitorPoolProxy()
     * @generated
     */
    EReference getMonitorPoolProxy_Remote ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.EventPoolProxy <em>Event Pool Proxy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Pool Proxy</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventPoolProxy
     * @generated
     */
    EClass getEventPoolProxy ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.EventPoolProxy#getLocal <em>Local</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Local</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventPoolProxy#getLocal()
     * @see #getEventPoolProxy()
     * @generated
     */
    EReference getEventPoolProxy_Local ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.EventPoolProxy#getRemote <em>Remote</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Remote</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventPoolProxy#getRemote()
     * @see #getEventPoolProxy()
     * @generated
     */
    EReference getEventPoolProxy_Remote ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventPoolProxy#getSize <em>Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Size</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventPoolProxy#getSize()
     * @see #getEventPoolProxy()
     * @generated
     */
    EAttribute getEventPoolProxy_Size ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule <em>Alarms Events Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Alarms Events Module</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule
     * @generated
     */
    EClass getAlarmsEventsModule ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getMonitorPoolProxies <em>Monitor Pool Proxies</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Monitor Pool Proxies</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getMonitorPoolProxies()
     * @see #getAlarmsEventsModule()
     * @generated
     */
    EReference getAlarmsEventsModule_MonitorPoolProxies ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getEventPoolProxies <em>Event Pool Proxies</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Event Pool Proxies</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getEventPoolProxies()
     * @see #getAlarmsEventsModule()
     * @generated
     */
    EReference getAlarmsEventsModule_EventPoolProxies ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getAknProxies <em>Akn Proxies</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Akn Proxies</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getAknProxies()
     * @see #getAlarmsEventsModule()
     * @generated
     */
    EReference getAlarmsEventsModule_AknProxies ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getPullEvents <em>Pull Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Pull Events</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AlarmsEventsModule#getPullEvents()
     * @see #getAlarmsEventsModule()
     * @generated
     */
    EReference getAlarmsEventsModule_PullEvents ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.AknProxy <em>Akn Proxy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Akn Proxy</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AknProxy
     * @generated
     */
    EClass getAknProxy ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.AknProxy#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pattern</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AknProxy#getPattern()
     * @see #getAknProxy()
     * @generated
     */
    EAttribute getAknProxy_Pattern ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.AknProxy#getConnection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Connection</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AknProxy#getConnection()
     * @see #getAknProxy()
     * @generated
     */
    EReference getAknProxy_Connection ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.AknProxy#getPriority <em>Priority</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Priority</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AknProxy#getPriority()
     * @see #getAknProxy()
     * @generated
     */
    EAttribute getAknProxy_Priority ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.AknProxy#isAuthorative <em>Authorative</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Authorative</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AknProxy#isAuthorative()
     * @see #getAknProxy()
     * @generated
     */
    EAttribute getAknProxy_Authorative ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.PullEvents <em>Pull Events</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Pull Events</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PullEvents
     * @generated
     */
    EClass getPullEvents ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getJdbcDriverName <em>Jdbc Driver Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Jdbc Driver Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PullEvents#getJdbcDriverName()
     * @see #getPullEvents()
     * @generated
     */
    EAttribute getPullEvents_JdbcDriverName ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getJdbcProperties <em>Jdbc Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Jdbc Properties</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PullEvents#getJdbcProperties()
     * @see #getPullEvents()
     * @generated
     */
    EReference getPullEvents_JdbcProperties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getJobInterval <em>Job Interval</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Job Interval</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PullEvents#getJobInterval()
     * @see #getPullEvents()
     * @generated
     */
    EAttribute getPullEvents_JobInterval ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomSelectSql <em>Custom Select Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Custom Select Sql</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomSelectSql()
     * @see #getPullEvents()
     * @generated
     */
    EAttribute getPullEvents_CustomSelectSql ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomDeleteSql <em>Custom Delete Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Custom Delete Sql</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomDeleteSql()
     * @see #getPullEvents()
     * @generated
     */
    EAttribute getPullEvents_CustomDeleteSql ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserServiceModule <em>Jdbc User Service Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Jdbc User Service Module</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserServiceModule
     * @generated
     */
    EClass getJdbcUserServiceModule ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserServiceModule#getUserServices <em>User Services</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>User Services</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserServiceModule#getUserServices()
     * @see #getJdbcUserServiceModule()
     * @generated
     */
    EReference getJdbcUserServiceModule_UserServices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService <em>Jdbc User Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Jdbc User Service</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService
     * @generated
     */
    EClass getJdbcUserService ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getJdbcPropeties <em>Jdbc Propeties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Jdbc Propeties</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService#getJdbcPropeties()
     * @see #getJdbcUserService()
     * @generated
     */
    EReference getJdbcUserService_JdbcPropeties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getJdbcDriver <em>Jdbc Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Jdbc Driver</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService#getJdbcDriver()
     * @see #getJdbcUserService()
     * @generated
     */
    EAttribute getJdbcUserService_JdbcDriver ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#isAuthorative <em>Authorative</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Authorative</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService#isAuthorative()
     * @see #getJdbcUserService()
     * @generated
     */
    EAttribute getJdbcUserService_Authorative ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getFindUserSql <em>Find User Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Find User Sql</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService#getFindUserSql()
     * @see #getJdbcUserService()
     * @generated
     */
    EAttribute getJdbcUserService_FindUserSql ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getFindRolesForUserSql <em>Find Roles For User Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Find Roles For User Sql</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService#getFindRolesForUserSql()
     * @see #getJdbcUserService()
     * @generated
     */
    EAttribute getJdbcUserService_FindRolesForUserSql ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getUpdatePasswordSql <em>Update Password Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Update Password Sql</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService#getUpdatePasswordSql()
     * @see #getJdbcUserService()
     * @generated
     */
    EAttribute getJdbcUserService_UpdatePasswordSql ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getUserIdColumnName <em>User Id Column Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>User Id Column Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService#getUserIdColumnName()
     * @see #getJdbcUserService()
     * @generated
     */
    EAttribute getJdbcUserService_UserIdColumnName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getPasswordColumnName <em>Password Column Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password Column Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService#getPasswordColumnName()
     * @see #getJdbcUserService()
     * @generated
     */
    EAttribute getJdbcUserService_PasswordColumnName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getPasswordType <em>Password Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.JdbcUserService#getPasswordType()
     * @see #getJdbcUserService()
     * @generated
     */
    EAttribute getJdbcUserService_PasswordType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.DefaultValueArchiveServer <em>Default Value Archive Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Default Value Archive Server</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.DefaultValueArchiveServer
     * @generated
     */
    EClass getDefaultValueArchiveServer ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.HistoricalDataExporter <em>Historical Data Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Historical Data Exporter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.HistoricalDataExporter
     * @generated
     */
    EClass getHistoricalDataExporter ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.HistoricalDataExporter#getTypeTag() <em>Get Type Tag</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Type Tag</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.HistoricalDataExporter#getTypeTag()
     * @generated
     */
    EOperation getHistoricalDataExporter__GetTypeTag ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ValueArchive <em>Value Archive</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Archive</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ValueArchive
     * @generated
     */
    EClass getValueArchive ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.ValueArchive#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Items</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ValueArchive#getItems()
     * @see #getValueArchive()
     * @generated
     */
    EReference getValueArchive_Items ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter <em>Configuration Administrator Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configuration Administrator Exporter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter
     * @generated
     */
    EClass getConfigurationAdministratorExporter ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter#getTypeTag() <em>Get Type Tag</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Type Tag</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter#getTypeTag()
     * @generated
     */
    EOperation getConfigurationAdministratorExporter__GetTypeTag ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ReferenceItem <em>Reference Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reference Item</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ReferenceItem
     * @generated
     */
    EClass getReferenceItem ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.ReferenceItem#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ReferenceItem#getSource()
     * @see #getReferenceItem()
     * @generated
     */
    EReference getReferenceItem_Source ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.EventStorage <em>Event Storage</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Storage</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventStorage
     * @generated
     */
    EClass getEventStorage ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc <em>Event Storage Jdbc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Storage Jdbc</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventStorageJdbc
     * @generated
     */
    EClass getEventStorageJdbc ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getJdbcDriverName <em>Jdbc Driver Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Jdbc Driver Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getJdbcDriverName()
     * @see #getEventStorageJdbc()
     * @generated
     */
    EAttribute getEventStorageJdbc_JdbcDriverName ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getDriverBundles <em>Driver Bundles</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Driver Bundles</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getDriverBundles()
     * @see #getEventStorageJdbc()
     * @generated
     */
    EAttribute getEventStorageJdbc_DriverBundles ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getMaxFieldLength <em>Max Field Length</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Field Length</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getMaxFieldLength()
     * @see #getEventStorageJdbc()
     * @generated
     */
    EAttribute getEventStorageJdbc_MaxFieldLength ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getQueryFetchSize <em>Query Fetch Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Query Fetch Size</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getQueryFetchSize()
     * @see #getEventStorageJdbc()
     * @generated
     */
    EAttribute getEventStorageJdbc_QueryFetchSize ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres <em>Event Storage Postgres</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Storage Postgres</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventStoragePostgres
     * @generated
     */
    EClass getEventStoragePostgres ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getBatchSize <em>Batch Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Batch Size</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getBatchSize()
     * @see #getEventStoragePostgres()
     * @generated
     */
    EAttribute getEventStoragePostgres_BatchSize ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getPostgresDriverBundles <em>Postgres Driver Bundles</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Postgres Driver Bundles</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getPostgresDriverBundles()
     * @see #getEventStoragePostgres()
     * @generated
     */
    EAttribute getEventStoragePostgres_PostgresDriverBundles ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getJdbcDriverName() <em>Get Jdbc Driver Name</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Jdbc Driver Name</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getJdbcDriverName()
     * @generated
     */
    EOperation getEventStoragePostgres__GetJdbcDriverName ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getDriverBundles() <em>Get Driver Bundles</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Driver Bundles</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getDriverBundles()
     * @generated
     */
    EOperation getEventStoragePostgres__GetDriverBundles ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc <em>Abstract Event Storage Jdbc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Event Storage Jdbc</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc
     * @generated
     */
    EClass getAbstractEventStorageJdbc ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getJdbcProperties <em>Jdbc Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Jdbc Properties</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getJdbcProperties()
     * @see #getAbstractEventStorageJdbc()
     * @generated
     */
    EReference getAbstractEventStorageJdbc_JdbcProperties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getSchema <em>Schema</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Schema</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getSchema()
     * @see #getAbstractEventStorageJdbc()
     * @generated
     */
    EAttribute getAbstractEventStorageJdbc_Schema ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getInstanceName <em>Instance Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instance Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getInstanceName()
     * @see #getAbstractEventStorageJdbc()
     * @generated
     */
    EAttribute getAbstractEventStorageJdbc_InstanceName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#isEnableReplication <em>Enable Replication</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enable Replication</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#isEnableReplication()
     * @see #getAbstractEventStorageJdbc()
     * @generated
     */
    EAttribute getAbstractEventStorageJdbc_EnableReplication ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getArchiveDays <em>Archive Days</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Archive Days</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getArchiveDays()
     * @see #getAbstractEventStorageJdbc()
     * @generated
     */
    EAttribute getAbstractEventStorageJdbc_ArchiveDays ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getCleanupPeriodSeconds <em>Cleanup Period Seconds</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Cleanup Period Seconds</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getCleanupPeriodSeconds()
     * @see #getAbstractEventStorageJdbc()
     * @generated
     */
    EAttribute getAbstractEventStorageJdbc_CleanupPeriodSeconds ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getJdbcDriverName() <em>Get Jdbc Driver Name</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Jdbc Driver Name</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getJdbcDriverName()
     * @generated
     */
    EOperation getAbstractEventStorageJdbc__GetJdbcDriverName ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getDriverBundles() <em>Get Driver Bundles</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Driver Bundles</em>' operation.
     * @see org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getDriverBundles()
     * @generated
     */
    EOperation getAbstractEventStorageJdbc__GetDriverBundles ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration <em>Application Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Application Configuration</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration
     * @generated
     */
    EClass getApplicationConfiguration ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.RestExporter <em>Rest Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rest Exporter</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.RestExporter
     * @generated
     */
    EClass getRestExporter ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.RestExporter#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Items</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.RestExporter#getItems()
     * @see #getRestExporter()
     * @generated
     */
    EReference getRestExporter_Items ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.RestExporter#getHiveProperties <em>Hive Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Hive Properties</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.RestExporter#getHiveProperties()
     * @see #getRestExporter()
     * @generated
     */
    EReference getRestExporter_HiveProperties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.RestExporter#getContextId <em>Context Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context Id</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.RestExporter#getContextId()
     * @see #getRestExporter()
     * @generated
     */
    EAttribute getRestExporter_ContextId ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.HttpService <em>Http Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Http Service</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.HttpService
     * @generated
     */
    EClass getHttpService ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.osgi.HttpService#getEndpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Endpoint</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.HttpService#getEndpoint()
     * @see #getHttpService()
     * @generated
     */
    EReference getHttpService_Endpoint ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.IndependentConfiguration <em>Independent Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Independent Configuration</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.IndependentConfiguration
     * @generated
     */
    EClass getIndependentConfiguration ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.configuration.world.osgi.AverageReferenceType <em>Average Reference Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Average Reference Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.AverageReferenceType
     * @generated
     */
    EEnum getAverageReferenceType ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType <em>Moving Average Reference Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Moving Average Reference Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType
     * @generated
     */
    EEnum getMovingAverageReferenceType ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.configuration.world.osgi.RoundingType <em>Rounding Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Rounding Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.RoundingType
     * @generated
     */
    EEnum getRoundingType ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.configuration.world.osgi.DataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Data Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.DataType
     * @generated
     */
    EEnum getDataType ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.configuration.world.osgi.PasswordType <em>Password Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Password Type</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.PasswordType
     * @generated
     */
    EEnum getPasswordType ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.scada.ae.data.Severity <em>Severity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Severity</em>'.
     * @see org.eclipse.scada.ae.data.Severity
     * @model instanceClass="org.eclipse.scada.ae.data.Severity"
     * @generated
     */
    EDataType getSeverity ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.scada.core.Variant <em>Variant</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Variant</em>'.
     * @see org.eclipse.scada.core.Variant
     * @model instanceClass="org.eclipse.scada.core.Variant"
     * @generated
     */
    EDataType getVariant ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.MarkerGroup#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Items</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.MarkerGroup#getItems()
     * @see #getMarkerGroup()
     * @generated
     */
    EReference getMarkerGroup_Items ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    OsgiFactory getOsgiFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.EquinoxApplication <em>Equinox Application</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.EquinoxApplication
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEquinoxApplication()
         * @generated
         */
        EClass EQUINOX_APPLICATION = eINSTANCE.getEquinoxApplication ();

        /**
         * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_APPLICATION__CONNECTIONS = eINSTANCE.getEquinoxApplication_Connections ();

        /**
         * The meta object literal for the '<em><b>Exporter</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_APPLICATION__EXPORTER = eINSTANCE.getEquinoxApplication_Exporter ();

        /**
         * The meta object literal for the '<em><b>Customization Profile</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE = eINSTANCE.getEquinoxApplication_CustomizationProfile ();

        /**
         * The meta object literal for the '<em><b>Security Configuration</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_APPLICATION__SECURITY_CONFIGURATION = eINSTANCE.getEquinoxApplication_SecurityConfiguration ();

        /**
         * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_APPLICATION__MODULES = eINSTANCE.getEquinoxApplication_Modules ();

        /**
         * The meta object literal for the '<em><b>Get Profile</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation EQUINOX_APPLICATION___GET_PROFILE = eINSTANCE.getEquinoxApplication__GetProfile ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ConnectionImpl <em>Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ConnectionImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getConnection()
         * @generated
         */
        EClass CONNECTION = eINSTANCE.getConnection ();

        /**
         * The meta object literal for the '<em><b>Endpoint</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION__ENDPOINT = eINSTANCE.getConnection_Endpoint ();

        /**
         * The meta object literal for the '<em><b>Endpoint Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION__ENDPOINT_LABEL = eINSTANCE.getConnection_EndpointLabel ();

        /**
         * The meta object literal for the '<em><b>Credentials</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION__CREDENTIALS = eINSTANCE.getConnection_Credentials ();

        /**
         * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION__TIMEOUT = eINSTANCE.getConnection_Timeout ();

        /**
         * The meta object literal for the '<em><b>Get Type Tag</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation CONNECTION___GET_TYPE_TAG = eINSTANCE.getConnection__GetTypeTag ();

        /**
         * The meta object literal for the '<em><b>Get Possible Endpoints</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation CONNECTION___GET_POSSIBLE_ENDPOINTS__EXPORTER = eINSTANCE.getConnection__GetPossibleEndpoints__Exporter ();

        /**
         * The meta object literal for the '<em><b>Make Uri</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation CONNECTION___MAKE_URI__BOOLEAN = eINSTANCE.getConnection__MakeUri__boolean ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ExporterImpl <em>Exporter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ExporterImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getExporter()
         * @generated
         */
        EClass EXPORTER = eINSTANCE.getExporter ();

        /**
         * The meta object literal for the '<em><b>Endpoints</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXPORTER__ENDPOINTS = eINSTANCE.getExporter_Endpoints ();

        /**
         * The meta object literal for the '<em><b>Get Type Tag</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation EXPORTER___GET_TYPE_TAG = eINSTANCE.getExporter__GetTypeTag ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DataAccessConnectionImpl <em>Data Access Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.DataAccessConnectionImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDataAccessConnection()
         * @generated
         */
        EClass DATA_ACCESS_CONNECTION = eINSTANCE.getDataAccessConnection ();

        /**
         * The meta object literal for the '<em><b>Get Type Tag</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DATA_ACCESS_CONNECTION___GET_TYPE_TAG = eINSTANCE.getDataAccessConnection__GetTypeTag ();

        /**
         * The meta object literal for the '<em><b>Make Uri</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DATA_ACCESS_CONNECTION___MAKE_URI__BOOLEAN = eINSTANCE.getDataAccessConnection__MakeUri__boolean ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DataAccessExporterImpl <em>Data Access Exporter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.DataAccessExporterImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDataAccessExporter()
         * @generated
         */
        EClass DATA_ACCESS_EXPORTER = eINSTANCE.getDataAccessExporter ();

        /**
         * The meta object literal for the '<em><b>Exports</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_ACCESS_EXPORTER__EXPORTS = eINSTANCE.getDataAccessExporter_Exports ();

        /**
         * The meta object literal for the '<em><b>Get Type Tag</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DATA_ACCESS_EXPORTER___GET_TYPE_TAG = eINSTANCE.getDataAccessExporter__GetTypeTag ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ItemImpl <em>Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getItem()
         * @generated
         */
        EClass ITEM = eINSTANCE.getItem ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__NAME = eINSTANCE.getItem_Name ();

        /**
         * The meta object literal for the '<em><b>Information</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM__INFORMATION = eINSTANCE.getItem_Information ();

        /**
         * The meta object literal for the '<em><b>Item Features</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM__ITEM_FEATURES = eINSTANCE.getItem_ItemFeatures ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.SourceItemImpl <em>Source Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.SourceItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSourceItem()
         * @generated
         */
        EClass SOURCE_ITEM = eINSTANCE.getSourceItem ();

        /**
         * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SOURCE_ITEM__CONNECTION = eINSTANCE.getSourceItem_Connection ();

        /**
         * The meta object literal for the '<em><b>Source Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SOURCE_ITEM__SOURCE_NAME = eINSTANCE.getSourceItem_SourceName ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ItemExportImpl <em>Item Export</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ItemExportImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getItemExport()
         * @generated
         */
        EClass ITEM_EXPORT = eINSTANCE.getItemExport ();

        /**
         * The meta object literal for the '<em><b>Item</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM_EXPORT__ITEM = eINSTANCE.getItemExport_Item ();

        /**
         * The meta object literal for the '<em><b>Export Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_EXPORT__EXPORT_NAME = eINSTANCE.getItemExport_ExportName ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ItemInformationImpl <em>Item Information</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ItemInformationImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getItemInformation()
         * @generated
         */
        EClass ITEM_INFORMATION = eINSTANCE.getItemInformation ();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_INFORMATION__DESCRIPTION = eINSTANCE.getItemInformation_Description ();

        /**
         * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_INFORMATION__UNIT = eINSTANCE.getItemInformation_Unit ();

        /**
         * The meta object literal for the '<em><b>Hierarchy</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_INFORMATION__HIERARCHY = eINSTANCE.getItemInformation_Hierarchy ();

        /**
         * The meta object literal for the '<em><b>System</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_INFORMATION__SYSTEM = eINSTANCE.getItemInformation_System ();

        /**
         * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_INFORMATION__DATA_TYPE = eINSTANCE.getItemInformation_DataType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl <em>Level Monitor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.LevelMonitorImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getLevelMonitor()
         * @generated
         */
        EClass LEVEL_MONITOR = eINSTANCE.getLevelMonitor ();

        /**
         * The meta object literal for the '<em><b>Preset</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL_MONITOR__PRESET = eINSTANCE.getLevelMonitor_Preset ();

        /**
         * The meta object literal for the '<em><b>Cap</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL_MONITOR__CAP = eINSTANCE.getLevelMonitor_Cap ();

        /**
         * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL_MONITOR__SEVERITY = eINSTANCE.getLevelMonitor_Severity ();

        /**
         * The meta object literal for the '<em><b>Lower Ok</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL_MONITOR__LOWER_OK = eINSTANCE.getLevelMonitor_LowerOk ();

        /**
         * The meta object literal for the '<em><b>Included Ok</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL_MONITOR__INCLUDED_OK = eINSTANCE.getLevelMonitor_IncludedOk ();

        /**
         * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL_MONITOR__PREFIX = eINSTANCE.getLevelMonitor_Prefix ();

        /**
         * The meta object literal for the '<em><b>Demote Prefix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL_MONITOR__DEMOTE_PREFIX = eINSTANCE.getLevelMonitor_DemotePrefix ();

        /**
         * The meta object literal for the '<em><b>Suppress Events</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL_MONITOR__SUPPRESS_EVENTS = eINSTANCE.getLevelMonitor_SuppressEvents ();

        /**
         * The meta object literal for the '<em><b>Require Ack</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL_MONITOR__REQUIRE_ACK = eINSTANCE.getLevelMonitor_RequireAck ();

        /**
         * The meta object literal for the '<em><b>Monitor Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL_MONITOR__MONITOR_TYPE = eINSTANCE.getLevelMonitor_MonitorType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ItemFeatureEntryImpl <em>Item Feature Entry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ItemFeatureEntryImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getItemFeatureEntry()
         * @generated
         */
        EClass ITEM_FEATURE_ENTRY = eINSTANCE.getItemFeatureEntry ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_FEATURE_ENTRY__NAME = eINSTANCE.getItemFeatureEntry_Name ();

        /**
         * The meta object literal for the '<em><b>Item</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM_FEATURE_ENTRY__ITEM = eINSTANCE.getItemFeatureEntry_Item ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl <em>Script Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ScriptItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getScriptItem()
         * @generated
         */
        EClass SCRIPT_ITEM = eINSTANCE.getScriptItem ();

        /**
         * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_ITEM__INPUTS = eINSTANCE.getScriptItem_Inputs ();

        /**
         * The meta object literal for the '<em><b>Init Script</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_ITEM__INIT_SCRIPT = eINSTANCE.getScriptItem_InitScript ();

        /**
         * The meta object literal for the '<em><b>Update Script</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_ITEM__UPDATE_SCRIPT = eINSTANCE.getScriptItem_UpdateScript ();

        /**
         * The meta object literal for the '<em><b>Timer</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_ITEM__TIMER = eINSTANCE.getScriptItem_Timer ();

        /**
         * The meta object literal for the '<em><b>Script Engine</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCRIPT_ITEM__SCRIPT_ENGINE = eINSTANCE.getScriptItem_ScriptEngine ();

        /**
         * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_ITEM__COMMANDS = eINSTANCE.getScriptItem_Commands ();

        /**
         * The meta object literal for the '<em><b>Write Command Script</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_ITEM__WRITE_COMMAND_SCRIPT = eINSTANCE.getScriptItem_WriteCommandScript ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ImportItemImpl <em>Import Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ImportItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getImportItem()
         * @generated
         */
        EClass IMPORT_ITEM = eINSTANCE.getImportItem ();

        /**
         * The meta object literal for the '<em><b>Export</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IMPORT_ITEM__EXPORT = eINSTANCE.getImportItem_Export ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.SummaryGroupImpl <em>Summary Group</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.SummaryGroupImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSummaryGroup()
         * @generated
         */
        EClass SUMMARY_GROUP = eINSTANCE.getSummaryGroup ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SUMMARY_GROUP__NAME = eINSTANCE.getSummaryGroup_Name ();

        /**
         * The meta object literal for the '<em><b>Sub Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SUMMARY_GROUP__SUB_GROUPS = eINSTANCE.getSummaryGroup_SubGroups ();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SUMMARY_GROUP__ITEMS = eINSTANCE.getSummaryGroup_Items ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MarkerGroupImpl <em>Marker Group</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.MarkerGroupImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMarkerGroup()
         * @generated
         */
        EClass MARKER_GROUP = eINSTANCE.getMarkerGroup ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MARKER_GROUP__NAME = eINSTANCE.getMarkerGroup_Name ();

        /**
         * The meta object literal for the '<em><b>Markers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MARKER_GROUP__MARKERS = eINSTANCE.getMarkerGroup_Markers ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MarkersImpl <em>Markers</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.MarkersImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMarkers()
         * @generated
         */
        EClass MARKERS = eINSTANCE.getMarkers ();

        /**
         * The meta object literal for the '<em><b>Marker Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MARKERS__MARKER_GROUPS = eINSTANCE.getMarkers_MarkerGroups ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ConstantItemImpl <em>Constant Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ConstantItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getConstantItem()
         * @generated
         */
        EClass CONSTANT_ITEM = eINSTANCE.getConstantItem ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONSTANT_ITEM__VALUE = eINSTANCE.getConstantItem_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.SummaryItemImpl <em>Summary Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.SummaryItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSummaryItem()
         * @generated
         */
        EClass SUMMARY_ITEM = eINSTANCE.getSummaryItem ();

        /**
         * The meta object literal for the '<em><b>Group</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SUMMARY_ITEM__GROUP = eINSTANCE.getSummaryItem_Group ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MarkerEntryImpl <em>Marker Entry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.MarkerEntryImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMarkerEntry()
         * @generated
         */
        EClass MARKER_ENTRY = eINSTANCE.getMarkerEntry ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MARKER_ENTRY__NAME = eINSTANCE.getMarkerEntry_Name ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MARKER_ENTRY__VALUE = eINSTANCE.getMarkerEntry_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ManualOverrideImpl <em>Manual Override</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ManualOverrideImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getManualOverride()
         * @generated
         */
        EClass MANUAL_OVERRIDE = eINSTANCE.getManualOverride ();

        /**
         * The meta object literal for the '<em><b>Initial Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MANUAL_OVERRIDE__INITIAL_VALUE = eINSTANCE.getManualOverride_InitialValue ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl <em>Master Server</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.MasterServerImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMasterServer()
         * @generated
         */
        EClass MASTER_SERVER = eINSTANCE.getMasterServer ();

        /**
         * The meta object literal for the '<em><b>Summary Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__SUMMARY_GROUPS = eINSTANCE.getMasterServer_SummaryGroups ();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__ITEMS = eINSTANCE.getMasterServer_Items ();

        /**
         * The meta object literal for the '<em><b>Markers</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__MARKERS = eINSTANCE.getMasterServer_Markers ();

        /**
         * The meta object literal for the '<em><b>Ae Server Information Prefix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MASTER_SERVER__AE_SERVER_INFORMATION_PREFIX = eINSTANCE.getMasterServer_AeServerInformationPrefix ();

        /**
         * The meta object literal for the '<em><b>Monitor Pools</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__MONITOR_POOLS = eINSTANCE.getMasterServer_MonitorPools ();

        /**
         * The meta object literal for the '<em><b>Event Pools</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__EVENT_POOLS = eINSTANCE.getMasterServer_EventPools ();

        /**
         * The meta object literal for the '<em><b>Data Mapper</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__DATA_MAPPER = eINSTANCE.getMasterServer_DataMapper ();

        /**
         * The meta object literal for the '<em><b>External Event Monitors</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__EXTERNAL_EVENT_MONITORS = eINSTANCE.getMasterServer_ExternalEventMonitors ();

        /**
         * The meta object literal for the '<em><b>External Event Filters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__EXTERNAL_EVENT_FILTERS = eINSTANCE.getMasterServer_ExternalEventFilters ();

        /**
         * The meta object literal for the '<em><b>Averages</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__AVERAGES = eINSTANCE.getMasterServer_Averages ();

        /**
         * The meta object literal for the '<em><b>Moving Averages</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__MOVING_AVERAGES = eINSTANCE.getMasterServer_MovingAverages ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl <em>Value Archive Server</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveServerImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getValueArchiveServer()
         * @generated
         */
        EClass VALUE_ARCHIVE_SERVER = eINSTANCE.getValueArchiveServer ();

        /**
         * The meta object literal for the '<em><b>Archives</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VALUE_ARCHIVE_SERVER__ARCHIVES = eINSTANCE.getValueArchiveServer_Archives ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DefaultMasterServerImpl <em>Default Master Server</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.DefaultMasterServerImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDefaultMasterServer()
         * @generated
         */
        EClass DEFAULT_MASTER_SERVER = eINSTANCE.getDefaultMasterServer ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.CustomMasterServerImpl <em>Custom Master Server</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.CustomMasterServerImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getCustomMasterServer()
         * @generated
         */
        EClass CUSTOM_MASTER_SERVER = eINSTANCE.getCustomMasterServer ();

        /**
         * The meta object literal for the '<em><b>Profile</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CUSTOM_MASTER_SERVER__PROFILE = eINSTANCE.getCustomMasterServer_Profile ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.ApplicationModule <em>Application Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.ApplicationModule
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getApplicationModule()
         * @generated
         */
        EClass APPLICATION_MODULE = eINSTANCE.getApplicationModule ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AttributesSummaryImpl <em>Attributes Summary</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.AttributesSummaryImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAttributesSummary()
         * @generated
         */
        EClass ATTRIBUTES_SUMMARY = eINSTANCE.getAttributesSummary ();

        /**
         * The meta object literal for the '<em><b>Attributes</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTES_SUMMARY__ATTRIBUTES = eINSTANCE.getAttributesSummary_Attributes ();

        /**
         * The meta object literal for the '<em><b>Output Prefix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTES_SUMMARY__OUTPUT_PREFIX = eINSTANCE.getAttributesSummary_OutputPrefix ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.EventLoggerImpl <em>Event Logger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.EventLoggerImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventLogger()
         * @generated
         */
        EClass EVENT_LOGGER = eINSTANCE.getEventLogger ();

        /**
         * The meta object literal for the '<em><b>Log Attributes Change</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_LOGGER__LOG_ATTRIBUTES_CHANGE = eINSTANCE.getEventLogger_LogAttributesChange ();

        /**
         * The meta object literal for the '<em><b>Log Value Change</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_LOGGER__LOG_VALUE_CHANGE = eINSTANCE.getEventLogger_LogValueChange ();

        /**
         * The meta object literal for the '<em><b>Log Subscription Change</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_LOGGER__LOG_SUBSCRIPTION_CHANGE = eINSTANCE.getEventLogger_LogSubscriptionChange ();

        /**
         * The meta object literal for the '<em><b>Log Writes</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_LOGGER__LOG_WRITES = eINSTANCE.getEventLogger_LogWrites ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MonitorPoolImpl <em>Monitor Pool</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.MonitorPoolImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMonitorPool()
         * @generated
         */
        EClass MONITOR_POOL = eINSTANCE.getMonitorPool ();

        /**
         * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MONITOR_POOL__FILTER = eINSTANCE.getMonitorPool_Filter ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.EventPoolImpl <em>Event Pool</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.EventPoolImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventPool()
         * @generated
         */
        EClass EVENT_POOL = eINSTANCE.getEventPool ();

        /**
         * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_POOL__FILTER = eINSTANCE.getEventPool_Filter ();

        /**
         * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_POOL__SIZE = eINSTANCE.getEventPool_Size ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DataMapperImpl <em>Data Mapper</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.DataMapperImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDataMapper()
         * @generated
         */
        EClass DATA_MAPPER = eINSTANCE.getDataMapper ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.SimpleDataMapperImpl <em>Simple Data Mapper</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.SimpleDataMapperImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSimpleDataMapper()
         * @generated
         */
        EClass SIMPLE_DATA_MAPPER = eINSTANCE.getSimpleDataMapper ();

        /**
         * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIMPLE_DATA_MAPPER__ENTRIES = eINSTANCE.getSimpleDataMapper_Entries ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcDataMapperImpl <em>Jdbc Data Mapper</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.JdbcDataMapperImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getJdbcDataMapper()
         * @generated
         */
        EClass JDBC_DATA_MAPPER = eINSTANCE.getJdbcDataMapper ();

        /**
         * The meta object literal for the '<em><b>Jdbc Driver</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JDBC_DATA_MAPPER__JDBC_DRIVER = eINSTANCE.getJdbcDataMapper_JdbcDriver ();

        /**
         * The meta object literal for the '<em><b>Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JDBC_DATA_MAPPER__SQL = eINSTANCE.getJdbcDataMapper_Sql ();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JDBC_DATA_MAPPER__PROPERTIES = eINSTANCE.getJdbcDataMapper_Properties ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DataMapperEntryImpl <em>Data Mapper Entry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.DataMapperEntryImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDataMapperEntry()
         * @generated
         */
        EClass DATA_MAPPER_ENTRY = eINSTANCE.getDataMapperEntry ();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA_MAPPER_ENTRY__KEY = eINSTANCE.getDataMapperEntry_Key ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA_MAPPER_ENTRY__VALUE = eINSTANCE.getDataMapperEntry_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ValueMapperImpl <em>Value Mapper</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ValueMapperImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getValueMapper()
         * @generated
         */
        EClass VALUE_MAPPER = eINSTANCE.getValueMapper ();

        /**
         * The meta object literal for the '<em><b>Source Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALUE_MAPPER__SOURCE_ATTRIBUTE = eINSTANCE.getValueMapper_SourceAttribute ();

        /**
         * The meta object literal for the '<em><b>Target Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALUE_MAPPER__TARGET_ATTRIBUTE = eINSTANCE.getValueMapper_TargetAttribute ();

        /**
         * The meta object literal for the '<em><b>Data Mapper</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VALUE_MAPPER__DATA_MAPPER = eINSTANCE.getValueMapper_DataMapper ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.PersistentItemImpl <em>Persistent Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.PersistentItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getPersistentItem()
         * @generated
         */
        EClass PERSISTENT_ITEM = eINSTANCE.getPersistentItem ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ProxyItemImpl <em>Proxy Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ProxyItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getProxyItem()
         * @generated
         */
        EClass PROXY_ITEM = eINSTANCE.getProxyItem ();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROXY_ITEM__ITEMS = eINSTANCE.getProxyItem_Items ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ScaleImpl <em>Scale</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ScaleImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getScale()
         * @generated
         */
        EClass SCALE = eINSTANCE.getScale ();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALE__ACTIVE = eINSTANCE.getScale_Active ();

        /**
         * The meta object literal for the '<em><b>Factor</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALE__FACTOR = eINSTANCE.getScale_Factor ();

        /**
         * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALE__OFFSET = eINSTANCE.getScale_Offset ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.NegateImpl <em>Negate</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.NegateImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getNegate()
         * @generated
         */
        EClass NEGATE = eINSTANCE.getNegate ();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NEGATE__ACTIVE = eINSTANCE.getNegate_Active ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.RoundingImpl <em>Rounding</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.RoundingImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getRounding()
         * @generated
         */
        EClass ROUNDING = eINSTANCE.getRounding ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ROUNDING__TYPE = eINSTANCE.getRounding_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ExternalEventMonitorImpl <em>External Event Monitor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ExternalEventMonitorImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getExternalEventMonitor()
         * @generated
         */
        EClass EXTERNAL_EVENT_MONITOR = eINSTANCE.getExternalEventMonitor ();

        /**
         * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXTERNAL_EVENT_MONITOR__FILTER = eINSTANCE.getExternalEventMonitor_Filter ();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXTERNAL_EVENT_MONITOR__PROPERTIES = eINSTANCE.getExternalEventMonitor_Properties ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.PropertyEntryImpl <em>Property Entry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.PropertyEntryImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getPropertyEntry()
         * @generated
         */
        EClass PROPERTY_ENTRY = eINSTANCE.getPropertyEntry ();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROPERTY_ENTRY__KEY = eINSTANCE.getPropertyEntry_Key ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROPERTY_ENTRY__VALUE = eINSTANCE.getPropertyEntry_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ExternalEventFilterImpl <em>External Event Filter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ExternalEventFilterImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getExternalEventFilter()
         * @generated
         */
        EClass EXTERNAL_EVENT_FILTER = eINSTANCE.getExternalEventFilter ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.StaticExternalEventFilterImpl <em>Static External Event Filter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.StaticExternalEventFilterImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getStaticExternalEventFilter()
         * @generated
         */
        EClass STATIC_EXTERNAL_EVENT_FILTER = eINSTANCE.getStaticExternalEventFilter ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STATIC_EXTERNAL_EVENT_FILTER__VALUE = eINSTANCE.getStaticExternalEventFilter_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.SimpleExternalEventFilterImpl <em>Simple External Event Filter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.SimpleExternalEventFilterImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSimpleExternalEventFilter()
         * @generated
         */
        EClass SIMPLE_EXTERNAL_EVENT_FILTER = eINSTANCE.getSimpleExternalEventFilter ();

        /**
         * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIMPLE_EXTERNAL_EVENT_FILTER__FILTER = eINSTANCE.getSimpleExternalEventFilter_Filter ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.TypedItemReferenceImpl <em>Typed Item Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.TypedItemReferenceImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getTypedItemReference()
         * @generated
         */
        EClass TYPED_ITEM_REFERENCE = eINSTANCE.getTypedItemReference ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TYPED_ITEM_REFERENCE__TYPE = eINSTANCE.getTypedItemReference_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.CodeFragmentImpl <em>Code Fragment</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.CodeFragmentImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getCodeFragment()
         * @generated
         */
        EClass CODE_FRAGMENT = eINSTANCE.getCodeFragment ();

        /**
         * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CODE_FRAGMENT__CODE = eINSTANCE.getCodeFragment_Code ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptTimerImpl <em>Script Timer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ScriptTimerImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getScriptTimer()
         * @generated
         */
        EClass SCRIPT_TIMER = eINSTANCE.getScriptTimer ();

        /**
         * The meta object literal for the '<em><b>Script</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_TIMER__SCRIPT = eINSTANCE.getScriptTimer_Script ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCRIPT_TIMER__PERIOD = eINSTANCE.getScriptTimer_Period ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ItemReferenceImpl <em>Item Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ItemReferenceImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getItemReference()
         * @generated
         */
        EClass ITEM_REFERENCE = eINSTANCE.getItemReference ();

        /**
         * The meta object literal for the '<em><b>Item</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM_REFERENCE__ITEM = eINSTANCE.getItemReference_Item ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_REFERENCE__NAME = eINSTANCE.getItemReference_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemImpl <em>Formula Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.FormulaItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getFormulaItem()
         * @generated
         */
        EClass FORMULA_ITEM = eINSTANCE.getFormulaItem ();

        /**
         * The meta object literal for the '<em><b>Script Engine</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORMULA_ITEM__SCRIPT_ENGINE = eINSTANCE.getFormulaItem_ScriptEngine ();

        /**
         * The meta object literal for the '<em><b>Init Scripts</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORMULA_ITEM__INIT_SCRIPTS = eINSTANCE.getFormulaItem_InitScripts ();

        /**
         * The meta object literal for the '<em><b>Outbound</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORMULA_ITEM__OUTBOUND = eINSTANCE.getFormulaItem_Outbound ();

        /**
         * The meta object literal for the '<em><b>Inbound</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORMULA_ITEM__INBOUND = eINSTANCE.getFormulaItem_Inbound ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemOutboundImpl <em>Formula Item Outbound</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.FormulaItemOutboundImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getFormulaItemOutbound()
         * @generated
         */
        EClass FORMULA_ITEM_OUTBOUND = eINSTANCE.getFormulaItemOutbound ();

        /**
         * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORMULA_ITEM_OUTBOUND__OUTPUT = eINSTANCE.getFormulaItemOutbound_Output ();

        /**
         * The meta object literal for the '<em><b>Output Formula</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORMULA_ITEM_OUTBOUND__OUTPUT_FORMULA = eINSTANCE.getFormulaItemOutbound_OutputFormula ();

        /**
         * The meta object literal for the '<em><b>Write Value Variable Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORMULA_ITEM_OUTBOUND__WRITE_VALUE_VARIABLE_NAME = eINSTANCE.getFormulaItemOutbound_WriteValueVariableName ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemInboundImpl <em>Formula Item Inbound</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.FormulaItemInboundImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getFormulaItemInbound()
         * @generated
         */
        EClass FORMULA_ITEM_INBOUND = eINSTANCE.getFormulaItemInbound ();

        /**
         * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORMULA_ITEM_INBOUND__INPUTS = eINSTANCE.getFormulaItemInbound_Inputs ();

        /**
         * The meta object literal for the '<em><b>Input Formula</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORMULA_ITEM_INBOUND__INPUT_FORMULA = eINSTANCE.getFormulaItemInbound_InputFormula ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl <em>Boolean Monitor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.BooleanMonitorImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getBooleanMonitor()
         * @generated
         */
        EClass BOOLEAN_MONITOR = eINSTANCE.getBooleanMonitor ();

        /**
         * The meta object literal for the '<em><b>Reference Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOLEAN_MONITOR__REFERENCE_VALUE = eINSTANCE.getBooleanMonitor_ReferenceValue ();

        /**
         * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOLEAN_MONITOR__ACTIVE = eINSTANCE.getBooleanMonitor_Active ();

        /**
         * The meta object literal for the '<em><b>Demote Prefix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOLEAN_MONITOR__DEMOTE_PREFIX = eINSTANCE.getBooleanMonitor_DemotePrefix ();

        /**
         * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOLEAN_MONITOR__SEVERITY = eINSTANCE.getBooleanMonitor_Severity ();

        /**
         * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOLEAN_MONITOR__MESSAGE = eINSTANCE.getBooleanMonitor_Message ();

        /**
         * The meta object literal for the '<em><b>Suppress Events</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOLEAN_MONITOR__SUPPRESS_EVENTS = eINSTANCE.getBooleanMonitor_SuppressEvents ();

        /**
         * The meta object literal for the '<em><b>Require Ack</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BOOLEAN_MONITOR__REQUIRE_ACK = eINSTANCE.getBooleanMonitor_RequireAck ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl <em>List Monitor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getListMonitor()
         * @generated
         */
        EClass LIST_MONITOR = eINSTANCE.getListMonitor ();

        /**
         * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_MONITOR__MESSAGE = eINSTANCE.getListMonitor_Message ();

        /**
         * The meta object literal for the '<em><b>Message Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_MONITOR__MESSAGE_ATTRIBUTE = eINSTANCE.getListMonitor_MessageAttribute ();

        /**
         * The meta object literal for the '<em><b>Default Ack</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_MONITOR__DEFAULT_ACK = eINSTANCE.getListMonitor_DefaultAck ();

        /**
         * The meta object literal for the '<em><b>Default Severity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_MONITOR__DEFAULT_SEVERITY = eINSTANCE.getListMonitor_DefaultSeverity ();

        /**
         * The meta object literal for the '<em><b>Monitor Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_MONITOR__MONITOR_TYPE = eINSTANCE.getListMonitor_MonitorType ();

        /**
         * The meta object literal for the '<em><b>Demote Prefix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_MONITOR__DEMOTE_PREFIX = eINSTANCE.getListMonitor_DemotePrefix ();

        /**
         * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LIST_MONITOR__ENTRIES = eINSTANCE.getListMonitor_Entries ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorEntryImpl <em>List Monitor Entry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ListMonitorEntryImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getListMonitorEntry()
         * @generated
         */
        EClass LIST_MONITOR_ENTRY = eINSTANCE.getListMonitorEntry ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_MONITOR_ENTRY__VALUE = eINSTANCE.getListMonitorEntry_Value ();

        /**
         * The meta object literal for the '<em><b>Require Ack</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_MONITOR_ENTRY__REQUIRE_ACK = eINSTANCE.getListMonitorEntry_RequireAck ();

        /**
         * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_MONITOR_ENTRY__SEVERITY = eINSTANCE.getListMonitorEntry_Severity ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AverageImpl <em>Average</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.AverageImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAverage()
         * @generated
         */
        EClass AVERAGE = eINSTANCE.getAverage ();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference AVERAGE__ITEMS = eINSTANCE.getAverage_Items ();

        /**
         * The meta object literal for the '<em><b>Sources Required</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AVERAGE__SOURCES_REQUIRED = eINSTANCE.getAverage_SourcesRequired ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl <em>Moving Average</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMovingAverage()
         * @generated
         */
        EClass MOVING_AVERAGE = eINSTANCE.getMovingAverage ();

        /**
         * The meta object literal for the '<em><b>Item</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MOVING_AVERAGE__ITEM = eINSTANCE.getMovingAverage_Item ();

        /**
         * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MOVING_AVERAGE__RANGE = eINSTANCE.getMovingAverage_Range ();

        /**
         * The meta object literal for the '<em><b>Null Range</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MOVING_AVERAGE__NULL_RANGE = eINSTANCE.getMovingAverage_NullRange ();

        /**
         * The meta object literal for the '<em><b>Trigger</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MOVING_AVERAGE__TRIGGER = eINSTANCE.getMovingAverage_Trigger ();

        /**
         * The meta object literal for the '<em><b>Trigger Only</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MOVING_AVERAGE__TRIGGER_ONLY = eINSTANCE.getMovingAverage_TriggerOnly ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AverageItemImpl <em>Average Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.AverageItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAverageItem()
         * @generated
         */
        EClass AVERAGE_ITEM = eINSTANCE.getAverageItem ();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference AVERAGE_ITEM__SOURCE = eINSTANCE.getAverageItem_Source ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AVERAGE_ITEM__TYPE = eINSTANCE.getAverageItem_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageItemImpl <em>Moving Average Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.MovingAverageItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMovingAverageItem()
         * @generated
         */
        EClass MOVING_AVERAGE_ITEM = eINSTANCE.getMovingAverageItem ();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MOVING_AVERAGE_ITEM__SOURCE = eINSTANCE.getMovingAverageItem_Source ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MOVING_AVERAGE_ITEM__TYPE = eINSTANCE.getMovingAverageItem_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.BlockingsImpl <em>Blockings</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.BlockingsImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getBlockings()
         * @generated
         */
        EClass BLOCKINGS = eINSTANCE.getBlockings ();

        /**
         * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BLOCKINGS__GROUPS = eINSTANCE.getBlockings_Groups ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.BlockGroupImpl <em>Block Group</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.BlockGroupImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getBlockGroup()
         * @generated
         */
        EClass BLOCK_GROUP = eINSTANCE.getBlockGroup ();

        /**
         * The meta object literal for the '<em><b>Handlers</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BLOCK_GROUP__HANDLERS = eINSTANCE.getBlockGroup_Handlers ();

        /**
         * The meta object literal for the '<em><b>Hierarchy</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BLOCK_GROUP__HIERARCHY = eINSTANCE.getBlockGroup_Hierarchy ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.BlockHandlerImpl <em>Block Handler</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.BlockHandlerImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getBlockHandler()
         * @generated
         */
        EClass BLOCK_HANDLER = eINSTANCE.getBlockHandler ();

        /**
         * The meta object literal for the '<em><b>Group</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BLOCK_HANDLER__GROUP = eINSTANCE.getBlockHandler_Group ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.BlockImpl <em>Block</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.BlockImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getBlock()
         * @generated
         */
        EClass BLOCK = eINSTANCE.getBlock ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.GlobalSummaryItemImpl <em>Global Summary Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.GlobalSummaryItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getGlobalSummaryItem()
         * @generated
         */
        EClass GLOBAL_SUMMARY_ITEM = eINSTANCE.getGlobalSummaryItem ();

        /**
         * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GLOBAL_SUMMARY_ITEM__ATTRIBUTE = eINSTANCE.getGlobalSummaryItem_Attribute ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.WeakReferenceDataSourceItemImpl <em>Weak Reference Data Source Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.WeakReferenceDataSourceItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getWeakReferenceDataSourceItem()
         * @generated
         */
        EClass WEAK_REFERENCE_DATA_SOURCE_ITEM = eINSTANCE.getWeakReferenceDataSourceItem ();

        /**
         * The meta object literal for the '<em><b>Data Source Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute WEAK_REFERENCE_DATA_SOURCE_ITEM__DATA_SOURCE_ID = eINSTANCE.getWeakReferenceDataSourceItem_DataSourceId ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsExporterImpl <em>Alarms Events Exporter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsExporterImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAlarmsEventsExporter()
         * @generated
         */
        EClass ALARMS_EVENTS_EXPORTER = eINSTANCE.getAlarmsEventsExporter ();

        /**
         * The meta object literal for the '<em><b>Get Type Tag</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ALARMS_EVENTS_EXPORTER___GET_TYPE_TAG = eINSTANCE.getAlarmsEventsExporter__GetTypeTag ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsConnectionImpl <em>Alarms Events Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsConnectionImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAlarmsEventsConnection()
         * @generated
         */
        EClass ALARMS_EVENTS_CONNECTION = eINSTANCE.getAlarmsEventsConnection ();

        /**
         * The meta object literal for the '<em><b>Get Type Tag</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ALARMS_EVENTS_CONNECTION___GET_TYPE_TAG = eINSTANCE.getAlarmsEventsConnection__GetTypeTag ();

        /**
         * The meta object literal for the '<em><b>Make Uri</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ALARMS_EVENTS_CONNECTION___MAKE_URI__BOOLEAN = eINSTANCE.getAlarmsEventsConnection__MakeUri__boolean ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.MonitorPoolProxyImpl <em>Monitor Pool Proxy</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.MonitorPoolProxyImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMonitorPoolProxy()
         * @generated
         */
        EClass MONITOR_POOL_PROXY = eINSTANCE.getMonitorPoolProxy ();

        /**
         * The meta object literal for the '<em><b>Local</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MONITOR_POOL_PROXY__LOCAL = eINSTANCE.getMonitorPoolProxy_Local ();

        /**
         * The meta object literal for the '<em><b>Remote</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MONITOR_POOL_PROXY__REMOTE = eINSTANCE.getMonitorPoolProxy_Remote ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.EventPoolProxyImpl <em>Event Pool Proxy</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.EventPoolProxyImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventPoolProxy()
         * @generated
         */
        EClass EVENT_POOL_PROXY = eINSTANCE.getEventPoolProxy ();

        /**
         * The meta object literal for the '<em><b>Local</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EVENT_POOL_PROXY__LOCAL = eINSTANCE.getEventPoolProxy_Local ();

        /**
         * The meta object literal for the '<em><b>Remote</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EVENT_POOL_PROXY__REMOTE = eINSTANCE.getEventPoolProxy_Remote ();

        /**
         * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_POOL_PROXY__SIZE = eINSTANCE.getEventPoolProxy_Size ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsModuleImpl <em>Alarms Events Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.AlarmsEventsModuleImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAlarmsEventsModule()
         * @generated
         */
        EClass ALARMS_EVENTS_MODULE = eINSTANCE.getAlarmsEventsModule ();

        /**
         * The meta object literal for the '<em><b>Monitor Pool Proxies</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ALARMS_EVENTS_MODULE__MONITOR_POOL_PROXIES = eINSTANCE.getAlarmsEventsModule_MonitorPoolProxies ();

        /**
         * The meta object literal for the '<em><b>Event Pool Proxies</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ALARMS_EVENTS_MODULE__EVENT_POOL_PROXIES = eINSTANCE.getAlarmsEventsModule_EventPoolProxies ();

        /**
         * The meta object literal for the '<em><b>Akn Proxies</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ALARMS_EVENTS_MODULE__AKN_PROXIES = eINSTANCE.getAlarmsEventsModule_AknProxies ();

        /**
         * The meta object literal for the '<em><b>Pull Events</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ALARMS_EVENTS_MODULE__PULL_EVENTS = eINSTANCE.getAlarmsEventsModule_PullEvents ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AknProxyImpl <em>Akn Proxy</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.AknProxyImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAknProxy()
         * @generated
         */
        EClass AKN_PROXY = eINSTANCE.getAknProxy ();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AKN_PROXY__PATTERN = eINSTANCE.getAknProxy_Pattern ();

        /**
         * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference AKN_PROXY__CONNECTION = eINSTANCE.getAknProxy_Connection ();

        /**
         * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AKN_PROXY__PRIORITY = eINSTANCE.getAknProxy_Priority ();

        /**
         * The meta object literal for the '<em><b>Authorative</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AKN_PROXY__AUTHORATIVE = eINSTANCE.getAknProxy_Authorative ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl <em>Pull Events</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.PullEventsImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getPullEvents()
         * @generated
         */
        EClass PULL_EVENTS = eINSTANCE.getPullEvents ();

        /**
         * The meta object literal for the '<em><b>Jdbc Driver Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PULL_EVENTS__JDBC_DRIVER_NAME = eINSTANCE.getPullEvents_JdbcDriverName ();

        /**
         * The meta object literal for the '<em><b>Jdbc Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PULL_EVENTS__JDBC_PROPERTIES = eINSTANCE.getPullEvents_JdbcProperties ();

        /**
         * The meta object literal for the '<em><b>Job Interval</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PULL_EVENTS__JOB_INTERVAL = eINSTANCE.getPullEvents_JobInterval ();

        /**
         * The meta object literal for the '<em><b>Custom Select Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PULL_EVENTS__CUSTOM_SELECT_SQL = eINSTANCE.getPullEvents_CustomSelectSql ();

        /**
         * The meta object literal for the '<em><b>Custom Delete Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PULL_EVENTS__CUSTOM_DELETE_SQL = eINSTANCE.getPullEvents_CustomDeleteSql ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceModuleImpl <em>Jdbc User Service Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceModuleImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getJdbcUserServiceModule()
         * @generated
         */
        EClass JDBC_USER_SERVICE_MODULE = eINSTANCE.getJdbcUserServiceModule ();

        /**
         * The meta object literal for the '<em><b>User Services</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JDBC_USER_SERVICE_MODULE__USER_SERVICES = eINSTANCE.getJdbcUserServiceModule_UserServices ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl <em>Jdbc User Service</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.JdbcUserServiceImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getJdbcUserService()
         * @generated
         */
        EClass JDBC_USER_SERVICE = eINSTANCE.getJdbcUserService ();

        /**
         * The meta object literal for the '<em><b>Jdbc Propeties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JDBC_USER_SERVICE__JDBC_PROPETIES = eINSTANCE.getJdbcUserService_JdbcPropeties ();

        /**
         * The meta object literal for the '<em><b>Jdbc Driver</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JDBC_USER_SERVICE__JDBC_DRIVER = eINSTANCE.getJdbcUserService_JdbcDriver ();

        /**
         * The meta object literal for the '<em><b>Authorative</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JDBC_USER_SERVICE__AUTHORATIVE = eINSTANCE.getJdbcUserService_Authorative ();

        /**
         * The meta object literal for the '<em><b>Find User Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JDBC_USER_SERVICE__FIND_USER_SQL = eINSTANCE.getJdbcUserService_FindUserSql ();

        /**
         * The meta object literal for the '<em><b>Find Roles For User Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL = eINSTANCE.getJdbcUserService_FindRolesForUserSql ();

        /**
         * The meta object literal for the '<em><b>Update Password Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL = eINSTANCE.getJdbcUserService_UpdatePasswordSql ();

        /**
         * The meta object literal for the '<em><b>User Id Column Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JDBC_USER_SERVICE__USER_ID_COLUMN_NAME = eINSTANCE.getJdbcUserService_UserIdColumnName ();

        /**
         * The meta object literal for the '<em><b>Password Column Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME = eINSTANCE.getJdbcUserService_PasswordColumnName ();

        /**
         * The meta object literal for the '<em><b>Password Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute JDBC_USER_SERVICE__PASSWORD_TYPE = eINSTANCE.getJdbcUserService_PasswordType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.DefaultValueArchiveServerImpl <em>Default Value Archive Server</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.DefaultValueArchiveServerImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDefaultValueArchiveServer()
         * @generated
         */
        EClass DEFAULT_VALUE_ARCHIVE_SERVER = eINSTANCE.getDefaultValueArchiveServer ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.HistoricalDataExporterImpl <em>Historical Data Exporter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.HistoricalDataExporterImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getHistoricalDataExporter()
         * @generated
         */
        EClass HISTORICAL_DATA_EXPORTER = eINSTANCE.getHistoricalDataExporter ();

        /**
         * The meta object literal for the '<em><b>Get Type Tag</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation HISTORICAL_DATA_EXPORTER___GET_TYPE_TAG = eINSTANCE.getHistoricalDataExporter__GetTypeTag ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveImpl <em>Value Archive</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ValueArchiveImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getValueArchive()
         * @generated
         */
        EClass VALUE_ARCHIVE = eINSTANCE.getValueArchive ();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VALUE_ARCHIVE__ITEMS = eINSTANCE.getValueArchive_Items ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ConfigurationAdministratorExporterImpl <em>Configuration Administrator Exporter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ConfigurationAdministratorExporterImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getConfigurationAdministratorExporter()
         * @generated
         */
        EClass CONFIGURATION_ADMINISTRATOR_EXPORTER = eINSTANCE.getConfigurationAdministratorExporter ();

        /**
         * The meta object literal for the '<em><b>Get Type Tag</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation CONFIGURATION_ADMINISTRATOR_EXPORTER___GET_TYPE_TAG = eINSTANCE.getConfigurationAdministratorExporter__GetTypeTag ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.ReferenceItemImpl <em>Reference Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.ReferenceItemImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getReferenceItem()
         * @generated
         */
        EClass REFERENCE_ITEM = eINSTANCE.getReferenceItem ();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCE_ITEM__SOURCE = eINSTANCE.getReferenceItem_Source ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.EventStorage <em>Event Storage</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.EventStorage
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventStorage()
         * @generated
         */
        EClass EVENT_STORAGE = eINSTANCE.getEventStorage ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.EventStorageJdbcImpl <em>Event Storage Jdbc</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.EventStorageJdbcImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventStorageJdbc()
         * @generated
         */
        EClass EVENT_STORAGE_JDBC = eINSTANCE.getEventStorageJdbc ();

        /**
         * The meta object literal for the '<em><b>Jdbc Driver Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_STORAGE_JDBC__JDBC_DRIVER_NAME = eINSTANCE.getEventStorageJdbc_JdbcDriverName ();

        /**
         * The meta object literal for the '<em><b>Driver Bundles</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_STORAGE_JDBC__DRIVER_BUNDLES = eINSTANCE.getEventStorageJdbc_DriverBundles ();

        /**
         * The meta object literal for the '<em><b>Max Field Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_STORAGE_JDBC__MAX_FIELD_LENGTH = eINSTANCE.getEventStorageJdbc_MaxFieldLength ();

        /**
         * The meta object literal for the '<em><b>Query Fetch Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_STORAGE_JDBC__QUERY_FETCH_SIZE = eINSTANCE.getEventStorageJdbc_QueryFetchSize ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.EventStoragePostgresImpl <em>Event Storage Postgres</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.EventStoragePostgresImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getEventStoragePostgres()
         * @generated
         */
        EClass EVENT_STORAGE_POSTGRES = eINSTANCE.getEventStoragePostgres ();

        /**
         * The meta object literal for the '<em><b>Batch Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_STORAGE_POSTGRES__BATCH_SIZE = eINSTANCE.getEventStoragePostgres_BatchSize ();

        /**
         * The meta object literal for the '<em><b>Postgres Driver Bundles</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_STORAGE_POSTGRES__POSTGRES_DRIVER_BUNDLES = eINSTANCE.getEventStoragePostgres_PostgresDriverBundles ();

        /**
         * The meta object literal for the '<em><b>Get Jdbc Driver Name</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation EVENT_STORAGE_POSTGRES___GET_JDBC_DRIVER_NAME = eINSTANCE.getEventStoragePostgres__GetJdbcDriverName ();

        /**
         * The meta object literal for the '<em><b>Get Driver Bundles</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation EVENT_STORAGE_POSTGRES___GET_DRIVER_BUNDLES = eINSTANCE.getEventStoragePostgres__GetDriverBundles ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl <em>Abstract Event Storage Jdbc</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAbstractEventStorageJdbc()
         * @generated
         */
        EClass ABSTRACT_EVENT_STORAGE_JDBC = eINSTANCE.getAbstractEventStorageJdbc ();

        /**
         * The meta object literal for the '<em><b>Jdbc Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_EVENT_STORAGE_JDBC__JDBC_PROPERTIES = eINSTANCE.getAbstractEventStorageJdbc_JdbcProperties ();

        /**
         * The meta object literal for the '<em><b>Schema</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA = eINSTANCE.getAbstractEventStorageJdbc_Schema ();

        /**
         * The meta object literal for the '<em><b>Instance Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME = eINSTANCE.getAbstractEventStorageJdbc_InstanceName ();

        /**
         * The meta object literal for the '<em><b>Enable Replication</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION = eINSTANCE.getAbstractEventStorageJdbc_EnableReplication ();

        /**
         * The meta object literal for the '<em><b>Archive Days</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS = eINSTANCE.getAbstractEventStorageJdbc_ArchiveDays ();

        /**
         * The meta object literal for the '<em><b>Cleanup Period Seconds</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS = eINSTANCE.getAbstractEventStorageJdbc_CleanupPeriodSeconds ();

        /**
         * The meta object literal for the '<em><b>Get Jdbc Driver Name</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ABSTRACT_EVENT_STORAGE_JDBC___GET_JDBC_DRIVER_NAME = eINSTANCE.getAbstractEventStorageJdbc__GetJdbcDriverName ();

        /**
         * The meta object literal for the '<em><b>Get Driver Bundles</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ABSTRACT_EVENT_STORAGE_JDBC___GET_DRIVER_BUNDLES = eINSTANCE.getAbstractEventStorageJdbc__GetDriverBundles ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration <em>Application Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getApplicationConfiguration()
         * @generated
         */
        EClass APPLICATION_CONFIGURATION = eINSTANCE.getApplicationConfiguration ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.RestExporterImpl <em>Rest Exporter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.RestExporterImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getRestExporter()
         * @generated
         */
        EClass REST_EXPORTER = eINSTANCE.getRestExporter ();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REST_EXPORTER__ITEMS = eINSTANCE.getRestExporter_Items ();

        /**
         * The meta object literal for the '<em><b>Hive Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REST_EXPORTER__HIVE_PROPERTIES = eINSTANCE.getRestExporter_HiveProperties ();

        /**
         * The meta object literal for the '<em><b>Context Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REST_EXPORTER__CONTEXT_ID = eINSTANCE.getRestExporter_ContextId ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.impl.HttpServiceImpl <em>Http Service</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.impl.HttpServiceImpl
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getHttpService()
         * @generated
         */
        EClass HTTP_SERVICE = eINSTANCE.getHttpService ();

        /**
         * The meta object literal for the '<em><b>Endpoint</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HTTP_SERVICE__ENDPOINT = eINSTANCE.getHttpService_Endpoint ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.IndependentConfiguration <em>Independent Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.IndependentConfiguration
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getIndependentConfiguration()
         * @generated
         */
        EClass INDEPENDENT_CONFIGURATION = eINSTANCE.getIndependentConfiguration ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.AverageReferenceType <em>Average Reference Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.AverageReferenceType
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getAverageReferenceType()
         * @generated
         */
        EEnum AVERAGE_REFERENCE_TYPE = eINSTANCE.getAverageReferenceType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType <em>Moving Average Reference Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getMovingAverageReferenceType()
         * @generated
         */
        EEnum MOVING_AVERAGE_REFERENCE_TYPE = eINSTANCE.getMovingAverageReferenceType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.RoundingType <em>Rounding Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.RoundingType
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getRoundingType()
         * @generated
         */
        EEnum ROUNDING_TYPE = eINSTANCE.getRoundingType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.DataType <em>Data Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.DataType
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getDataType()
         * @generated
         */
        EEnum DATA_TYPE = eINSTANCE.getDataType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.PasswordType <em>Password Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.PasswordType
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getPasswordType()
         * @generated
         */
        EEnum PASSWORD_TYPE = eINSTANCE.getPasswordType ();

        /**
         * The meta object literal for the '<em>Severity</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ae.data.Severity
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getSeverity()
         * @generated
         */
        EDataType SEVERITY = eINSTANCE.getSeverity ();

        /**
         * The meta object literal for the '<em>Variant</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.core.Variant
         * @see org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl#getVariant()
         * @generated
         */
        EDataType VARIANT = eINSTANCE.getVariant ();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MARKER_GROUP__ITEMS = eINSTANCE.getMarkerGroup_Items ();

    }

} //OsgiPackage
