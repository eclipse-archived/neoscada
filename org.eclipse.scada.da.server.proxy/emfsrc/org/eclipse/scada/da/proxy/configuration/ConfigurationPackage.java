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
package org.eclipse.scada.da.proxy.configuration;

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
 * @see org.eclipse.scada.da.proxy.configuration.ConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigurationPackage extends EPackage
{

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "configuration"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://openscada.org/DA/Proxy/Configuration"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "configuration"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ConfigurationPackage eINSTANCE = org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.proxy.configuration.impl.ConnectionTypeImpl <em>Connection Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.proxy.configuration.impl.ConnectionTypeImpl
     * @see org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl#getConnectionType()
     * @generated
     */
    int CONNECTION_TYPE = 0;

    /**
     * The feature id for the '<em><b>Folder</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__FOLDER = 0;

    /**
     * The feature id for the '<em><b>Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__CLASS_NAME = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__ID = 2;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__PREFIX = 3;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__URI = 4;

    /**
     * The number of structural features of the '<em>Connection Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Connection Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.proxy.configuration.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.proxy.configuration.impl.DocumentRootImpl
     * @see org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl#getDocumentRoot()
     * @generated
     */
    int DOCUMENT_ROOT = 1;

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
     * The feature id for the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__ROOT = 3;

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
     * The meta object id for the '{@link org.eclipse.scada.da.proxy.configuration.impl.FolderTypeImpl <em>Folder Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.proxy.configuration.impl.FolderTypeImpl
     * @see org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl#getFolderType()
     * @generated
     */
    int FOLDER_TYPE = 2;

    /**
     * The feature id for the '<em><b>Group</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FOLDER_TYPE__GROUP = 0;

    /**
     * The feature id for the '<em><b>Location</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FOLDER_TYPE__LOCATION = 1;

    /**
     * The number of structural features of the '<em>Folder Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FOLDER_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Folder Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FOLDER_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.proxy.configuration.impl.ProxyTypeImpl <em>Proxy Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.proxy.configuration.impl.ProxyTypeImpl
     * @see org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl#getProxyType()
     * @generated
     */
    int PROXY_TYPE = 3;

    /**
     * The feature id for the '<em><b>Connection</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_TYPE__CONNECTION = 0;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_TYPE__PREFIX = 1;

    /**
     * The feature id for the '<em><b>Wait</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_TYPE__WAIT = 2;

    /**
     * The number of structural features of the '<em>Proxy Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_TYPE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Proxy Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROXY_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.proxy.configuration.impl.RootTypeImpl <em>Root Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.proxy.configuration.impl.RootTypeImpl
     * @see org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl#getRootType()
     * @generated
     */
    int ROOT_TYPE = 4;

    /**
     * The feature id for the '<em><b>Proxy</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE__PROXY = 0;

    /**
     * The feature id for the '<em><b>Separator</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE__SEPARATOR = 1;

    /**
     * The number of structural features of the '<em>Root Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Root Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE_OPERATION_COUNT = 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType <em>Connection Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connection Type</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.ConnectionType
     * @generated
     */
    EClass getConnectionType ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getFolder <em>Folder</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Folder</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.ConnectionType#getFolder()
     * @see #getConnectionType()
     * @generated
     */
    EReference getConnectionType_Folder ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getClassName <em>Class Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Class Name</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.ConnectionType#getClassName()
     * @see #getConnectionType()
     * @generated
     */
    EAttribute getConnectionType_ClassName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.ConnectionType#getId()
     * @see #getConnectionType()
     * @generated
     */
    EAttribute getConnectionType_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getPrefix <em>Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.ConnectionType#getPrefix()
     * @see #getConnectionType()
     * @generated
     */
    EAttribute getConnectionType_Prefix ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.ConnectionType#getUri()
     * @see #getConnectionType()
     * @generated
     */
    EAttribute getConnectionType_Uri ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.proxy.configuration.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document Root</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.DocumentRoot
     * @generated
     */
    EClass getDocumentRoot ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.proxy.configuration.DocumentRoot#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Mixed ();

    /**
     * Returns the meta object for the map '{@link org.eclipse.scada.da.proxy.configuration.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XMLNSPrefixMap ();

    /**
     * Returns the meta object for the map '{@link org.eclipse.scada.da.proxy.configuration.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XSISchemaLocation ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.da.proxy.configuration.DocumentRoot#getRoot <em>Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Root</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.DocumentRoot#getRoot()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Root ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.proxy.configuration.FolderType <em>Folder Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Folder Type</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.FolderType
     * @generated
     */
    EClass getFolderType ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.proxy.configuration.FolderType#getGroup <em>Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Group</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.FolderType#getGroup()
     * @see #getFolderType()
     * @generated
     */
    EAttribute getFolderType_Group ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.proxy.configuration.FolderType#getLocation <em>Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Location</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.FolderType#getLocation()
     * @see #getFolderType()
     * @generated
     */
    EAttribute getFolderType_Location ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.proxy.configuration.ProxyType <em>Proxy Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Proxy Type</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.ProxyType
     * @generated
     */
    EClass getProxyType ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.proxy.configuration.ProxyType#getConnection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Connection</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.ProxyType#getConnection()
     * @see #getProxyType()
     * @generated
     */
    EReference getProxyType_Connection ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.proxy.configuration.ProxyType#getPrefix <em>Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.ProxyType#getPrefix()
     * @see #getProxyType()
     * @generated
     */
    EAttribute getProxyType_Prefix ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.proxy.configuration.ProxyType#getWait <em>Wait</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Wait</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.ProxyType#getWait()
     * @see #getProxyType()
     * @generated
     */
    EAttribute getProxyType_Wait ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.proxy.configuration.RootType <em>Root Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Root Type</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.RootType
     * @generated
     */
    EClass getRootType ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.proxy.configuration.RootType#getProxy <em>Proxy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Proxy</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.RootType#getProxy()
     * @see #getRootType()
     * @generated
     */
    EReference getRootType_Proxy ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.proxy.configuration.RootType#getSeparator <em>Separator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Separator</em>'.
     * @see org.eclipse.scada.da.proxy.configuration.RootType#getSeparator()
     * @see #getRootType()
     * @generated
     */
    EAttribute getRootType_Separator ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ConfigurationFactory getConfigurationFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.da.proxy.configuration.impl.ConnectionTypeImpl <em>Connection Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.proxy.configuration.impl.ConnectionTypeImpl
         * @see org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl#getConnectionType()
         * @generated
         */
        EClass CONNECTION_TYPE = eINSTANCE.getConnectionType ();

        /**
         * The meta object literal for the '<em><b>Folder</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION_TYPE__FOLDER = eINSTANCE.getConnectionType_Folder ();

        /**
         * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION_TYPE__CLASS_NAME = eINSTANCE.getConnectionType_ClassName ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION_TYPE__ID = eINSTANCE.getConnectionType_Id ();

        /**
         * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION_TYPE__PREFIX = eINSTANCE.getConnectionType_Prefix ();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION_TYPE__URI = eINSTANCE.getConnectionType_Uri ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.proxy.configuration.impl.DocumentRootImpl <em>Document Root</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.proxy.configuration.impl.DocumentRootImpl
         * @see org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl#getDocumentRoot()
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
         * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__ROOT = eINSTANCE.getDocumentRoot_Root ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.proxy.configuration.impl.FolderTypeImpl <em>Folder Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.proxy.configuration.impl.FolderTypeImpl
         * @see org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl#getFolderType()
         * @generated
         */
        EClass FOLDER_TYPE = eINSTANCE.getFolderType ();

        /**
         * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FOLDER_TYPE__GROUP = eINSTANCE.getFolderType_Group ();

        /**
         * The meta object literal for the '<em><b>Location</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FOLDER_TYPE__LOCATION = eINSTANCE.getFolderType_Location ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.proxy.configuration.impl.ProxyTypeImpl <em>Proxy Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.proxy.configuration.impl.ProxyTypeImpl
         * @see org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl#getProxyType()
         * @generated
         */
        EClass PROXY_TYPE = eINSTANCE.getProxyType ();

        /**
         * The meta object literal for the '<em><b>Connection</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROXY_TYPE__CONNECTION = eINSTANCE.getProxyType_Connection ();

        /**
         * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROXY_TYPE__PREFIX = eINSTANCE.getProxyType_Prefix ();

        /**
         * The meta object literal for the '<em><b>Wait</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROXY_TYPE__WAIT = eINSTANCE.getProxyType_Wait ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.proxy.configuration.impl.RootTypeImpl <em>Root Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.proxy.configuration.impl.RootTypeImpl
         * @see org.eclipse.scada.da.proxy.configuration.impl.ConfigurationPackageImpl#getRootType()
         * @generated
         */
        EClass ROOT_TYPE = eINSTANCE.getRootType ();

        /**
         * The meta object literal for the '<em><b>Proxy</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ROOT_TYPE__PROXY = eINSTANCE.getRootType_Proxy ();

        /**
         * The meta object literal for the '<em><b>Separator</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ROOT_TYPE__SEPARATOR = eINSTANCE.getRootType_Separator ();

    }

} //ConfigurationPackage
