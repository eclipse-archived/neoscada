/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.scada.da.server.exporter.ExporterFactory
 * @model kind="package"
 * @generated
 */
public interface ExporterPackage extends EPackage
{

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "exporter"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://openscada.org/DA/Server/Exporter"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "exporter"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ExporterPackage eINSTANCE = org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.exporter.impl.AnnouncerTypeImpl <em>Announcer Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.exporter.impl.AnnouncerTypeImpl
     * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getAnnouncerType()
     * @generated
     */
    int ANNOUNCER_TYPE = 0;

    /**
     * The feature id for the '<em><b>Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANNOUNCER_TYPE__CLASS = 0;

    /**
     * The number of structural features of the '<em>Announcer Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANNOUNCER_TYPE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Announcer Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ANNOUNCER_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.exporter.impl.ConfigurationTypeImpl <em>Configuration Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.exporter.impl.ConfigurationTypeImpl
     * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getConfigurationType()
     * @generated
     */
    int CONFIGURATION_TYPE = 1;

    /**
     * The feature id for the '<em><b>Hive</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_TYPE__HIVE = 0;

    /**
     * The feature id for the '<em><b>Announcer</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_TYPE__ANNOUNCER = 1;

    /**
     * The number of structural features of the '<em>Configuration Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Configuration Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.exporter.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.exporter.impl.DocumentRootImpl
     * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getDocumentRoot()
     * @generated
     */
    int DOCUMENT_ROOT = 2;

    /**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MIXED = 0;

    /**
     * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

    /**
     * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

    /**
     * The feature id for the '<em><b>Configuration</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__CONFIGURATION = 3;

    /**
     * The number of structural features of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.exporter.impl.ExportTypeImpl <em>Export Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.exporter.impl.ExportTypeImpl
     * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getExportType()
     * @generated
     */
    int EXPORT_TYPE = 3;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORT_TYPE__URI = 0;

    /**
     * The number of structural features of the '<em>Export Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORT_TYPE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Export Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORT_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.exporter.impl.HiveConfigurationTypeImpl <em>Hive Configuration Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.exporter.impl.HiveConfigurationTypeImpl
     * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getHiveConfigurationType()
     * @generated
     */
    int HIVE_CONFIGURATION_TYPE = 4;

    /**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_CONFIGURATION_TYPE__MIXED = 0;

    /**
     * The feature id for the '<em><b>Any</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_CONFIGURATION_TYPE__ANY = 1;

    /**
     * The number of structural features of the '<em>Hive Configuration Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_CONFIGURATION_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Hive Configuration Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_CONFIGURATION_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.exporter.impl.HiveTypeImpl <em>Hive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.exporter.impl.HiveTypeImpl
     * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getHiveType()
     * @generated
     */
    int HIVE_TYPE = 5;

    /**
     * The feature id for the '<em><b>Configuration</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_TYPE__CONFIGURATION = 0;

    /**
     * The feature id for the '<em><b>Export</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_TYPE__EXPORT = 1;

    /**
     * The feature id for the '<em><b>Ref</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_TYPE__REF = 2;

    /**
     * The number of structural features of the '<em>Hive Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_TYPE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Hive Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_TYPE_OPERATION_COUNT = 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.exporter.AnnouncerType <em>Announcer Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Announcer Type</em>'.
     * @see org.eclipse.scada.da.server.exporter.AnnouncerType
     * @generated
     */
    EClass getAnnouncerType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.exporter.AnnouncerType#getClass_ <em>Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Class</em>'.
     * @see org.eclipse.scada.da.server.exporter.AnnouncerType#getClass_()
     * @see #getAnnouncerType()
     * @generated
     */
    EAttribute getAnnouncerType_Class ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.exporter.ConfigurationType <em>Configuration Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configuration Type</em>'.
     * @see org.eclipse.scada.da.server.exporter.ConfigurationType
     * @generated
     */
    EClass getConfigurationType ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.server.exporter.ConfigurationType#getHive <em>Hive</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Hive</em>'.
     * @see org.eclipse.scada.da.server.exporter.ConfigurationType#getHive()
     * @see #getConfigurationType()
     * @generated
     */
    EReference getConfigurationType_Hive ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.server.exporter.ConfigurationType#getAnnouncer <em>Announcer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Announcer</em>'.
     * @see org.eclipse.scada.da.server.exporter.ConfigurationType#getAnnouncer()
     * @see #getConfigurationType()
     * @generated
     */
    EReference getConfigurationType_Announcer ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.exporter.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document Root</em>'.
     * @see org.eclipse.scada.da.server.exporter.DocumentRoot
     * @generated
     */
    EClass getDocumentRoot ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.server.exporter.DocumentRoot#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.eclipse.scada.da.server.exporter.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Mixed ();

    /**
     * Returns the meta object for the map '{@link org.eclipse.scada.da.server.exporter.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see org.eclipse.scada.da.server.exporter.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XMLNSPrefixMap ();

    /**
     * Returns the meta object for the map '{@link org.eclipse.scada.da.server.exporter.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see org.eclipse.scada.da.server.exporter.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XSISchemaLocation ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.da.server.exporter.DocumentRoot#getConfiguration <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Configuration</em>'.
     * @see org.eclipse.scada.da.server.exporter.DocumentRoot#getConfiguration()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Configuration ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.exporter.ExportType <em>Export Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Export Type</em>'.
     * @see org.eclipse.scada.da.server.exporter.ExportType
     * @generated
     */
    EClass getExportType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.exporter.ExportType#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see org.eclipse.scada.da.server.exporter.ExportType#getUri()
     * @see #getExportType()
     * @generated
     */
    EAttribute getExportType_Uri ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.exporter.HiveConfigurationType <em>Hive Configuration Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Hive Configuration Type</em>'.
     * @see org.eclipse.scada.da.server.exporter.HiveConfigurationType
     * @generated
     */
    EClass getHiveConfigurationType ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.server.exporter.HiveConfigurationType#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.eclipse.scada.da.server.exporter.HiveConfigurationType#getMixed()
     * @see #getHiveConfigurationType()
     * @generated
     */
    EAttribute getHiveConfigurationType_Mixed ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.server.exporter.HiveConfigurationType#getAny <em>Any</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Any</em>'.
     * @see org.eclipse.scada.da.server.exporter.HiveConfigurationType#getAny()
     * @see #getHiveConfigurationType()
     * @generated
     */
    EAttribute getHiveConfigurationType_Any ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.exporter.HiveType <em>Hive Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Hive Type</em>'.
     * @see org.eclipse.scada.da.server.exporter.HiveType
     * @generated
     */
    EClass getHiveType ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.da.server.exporter.HiveType#getConfiguration <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Configuration</em>'.
     * @see org.eclipse.scada.da.server.exporter.HiveType#getConfiguration()
     * @see #getHiveType()
     * @generated
     */
    EReference getHiveType_Configuration ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.server.exporter.HiveType#getExport <em>Export</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Export</em>'.
     * @see org.eclipse.scada.da.server.exporter.HiveType#getExport()
     * @see #getHiveType()
     * @generated
     */
    EReference getHiveType_Export ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.exporter.HiveType#getRef <em>Ref</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ref</em>'.
     * @see org.eclipse.scada.da.server.exporter.HiveType#getRef()
     * @see #getHiveType()
     * @generated
     */
    EAttribute getHiveType_Ref ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ExporterFactory getExporterFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.da.server.exporter.impl.AnnouncerTypeImpl <em>Announcer Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.exporter.impl.AnnouncerTypeImpl
         * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getAnnouncerType()
         * @generated
         */
        EClass ANNOUNCER_TYPE = eINSTANCE.getAnnouncerType ();

        /**
         * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ANNOUNCER_TYPE__CLASS = eINSTANCE.getAnnouncerType_Class ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.exporter.impl.ConfigurationTypeImpl <em>Configuration Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.exporter.impl.ConfigurationTypeImpl
         * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getConfigurationType()
         * @generated
         */
        EClass CONFIGURATION_TYPE = eINSTANCE.getConfigurationType ();

        /**
         * The meta object literal for the '<em><b>Hive</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONFIGURATION_TYPE__HIVE = eINSTANCE.getConfigurationType_Hive ();

        /**
         * The meta object literal for the '<em><b>Announcer</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONFIGURATION_TYPE__ANNOUNCER = eINSTANCE.getConfigurationType_Announcer ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.exporter.impl.DocumentRootImpl <em>Document Root</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.exporter.impl.DocumentRootImpl
         * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getDocumentRoot()
         * @generated
         */
        EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot ();

        /**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed ();

        /**
         * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap ();

        /**
         * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation ();

        /**
         * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__CONFIGURATION = eINSTANCE.getDocumentRoot_Configuration ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.exporter.impl.ExportTypeImpl <em>Export Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.exporter.impl.ExportTypeImpl
         * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getExportType()
         * @generated
         */
        EClass EXPORT_TYPE = eINSTANCE.getExportType ();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXPORT_TYPE__URI = eINSTANCE.getExportType_Uri ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.exporter.impl.HiveConfigurationTypeImpl <em>Hive Configuration Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.exporter.impl.HiveConfigurationTypeImpl
         * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getHiveConfigurationType()
         * @generated
         */
        EClass HIVE_CONFIGURATION_TYPE = eINSTANCE.getHiveConfigurationType ();

        /**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HIVE_CONFIGURATION_TYPE__MIXED = eINSTANCE.getHiveConfigurationType_Mixed ();

        /**
         * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HIVE_CONFIGURATION_TYPE__ANY = eINSTANCE.getHiveConfigurationType_Any ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.exporter.impl.HiveTypeImpl <em>Hive Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.exporter.impl.HiveTypeImpl
         * @see org.eclipse.scada.da.server.exporter.impl.ExporterPackageImpl#getHiveType()
         * @generated
         */
        EClass HIVE_TYPE = eINSTANCE.getHiveType ();

        /**
         * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HIVE_TYPE__CONFIGURATION = eINSTANCE.getHiveType_Configuration ();

        /**
         * The meta object literal for the '<em><b>Export</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HIVE_TYPE__EXPORT = eINSTANCE.getHiveType_Export ();

        /**
         * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HIVE_TYPE__REF = eINSTANCE.getHiveType_Ref ();

    }

} //ExporterPackage
