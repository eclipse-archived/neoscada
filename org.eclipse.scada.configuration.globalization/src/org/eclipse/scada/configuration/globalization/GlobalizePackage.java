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
package org.eclipse.scada.configuration.globalization;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.world.WorldPackage;

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
 * @see org.eclipse.scada.configuration.globalization.GlobalizeFactory
 * @model kind="package"
 * @generated
 */
public interface GlobalizePackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "globalization"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Globalization"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "globalization"; //$NON-NLS-1$

    /**
     * The package content type ID.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eCONTENT_TYPE = "org.eclipse.scada.configuration.globalization"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    GlobalizePackage eINSTANCE = org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.impl.GlobalizationImpl <em>Globalization</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizationImpl
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getGlobalization()
     * @generated
     */
    int GLOBALIZATION = 0;

    /**
     * The feature id for the '<em><b>World</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZATION__WORLD = 0;

    /**
     * The feature id for the '<em><b>Default Logon Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS = 1;

    /**
     * The feature id for the '<em><b>Globals</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZATION__GLOBALS = 2;

    /**
     * The number of structural features of the '<em>Globalization</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZATION_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Globalization</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.impl.LocalImpl <em>Local</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.impl.LocalImpl
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getLocal()
     * @generated
     */
    int LOCAL = 1;

    /**
     * The feature id for the '<em><b>Local</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL__LOCAL = 0;

    /**
     * The feature id for the '<em><b>Logon Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL__LOGON_CREDENTIALS = 1;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL__FILTERS = 2;

    /**
     * The feature id for the '<em><b>Default Include</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL__DEFAULT_INCLUDE = 3;

    /**
     * The feature id for the '<em><b>Global</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL__GLOBAL = 4;

    /**
     * The feature id for the '<em><b>Authoratives</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL__AUTHORATIVES = 5;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL__ID = 6;

    /**
     * The number of structural features of the '<em>Local</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Local</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOCAL_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.Filter <em>Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.Filter
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getFilter()
     * @generated
     */
    int FILTER = 4;

    /**
     * The number of structural features of the '<em>Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILTER_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILTER_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.impl.PatternFilterImpl <em>Pattern Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.impl.PatternFilterImpl
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getPatternFilter()
     * @generated
     */
    int PATTERN_FILTER = 5;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_FILTER__PATTERN = FILTER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Pattern Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_FILTER_FEATURE_COUNT = FILTER_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Pattern Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PATTERN_FILTER_OPERATION_COUNT = FILTER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.impl.IncludeImpl <em>Include</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.impl.IncludeImpl
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getInclude()
     * @generated
     */
    int INCLUDE = 2;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INCLUDE__PATTERN = PATTERN_FILTER__PATTERN;

    /**
     * The number of structural features of the '<em>Include</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INCLUDE_FEATURE_COUNT = PATTERN_FILTER_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Include</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INCLUDE_OPERATION_COUNT = PATTERN_FILTER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.impl.ExcludeImpl <em>Exclude</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.impl.ExcludeImpl
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getExclude()
     * @generated
     */
    int EXCLUDE = 3;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXCLUDE__PATTERN = PATTERN_FILTER__PATTERN;

    /**
     * The number of structural features of the '<em>Exclude</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXCLUDE_FEATURE_COUNT = PATTERN_FILTER_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Exclude</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXCLUDE_OPERATION_COUNT = PATTERN_FILTER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.impl.GlobalImpl <em>Global</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalImpl
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getGlobal()
     * @generated
     */
    int GLOBAL = 6;

    /**
     * The feature id for the '<em><b>Global</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL__GLOBAL = 0;

    /**
     * The feature id for the '<em><b>Default Logon Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL__DEFAULT_LOGON_CREDENTIALS = 1;

    /**
     * The feature id for the '<em><b>Locals</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL__LOCALS = 2;

    /**
     * The feature id for the '<em><b>Event Pool Imports</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL__EVENT_POOL_IMPORTS = 3;

    /**
     * The feature id for the '<em><b>Monitor Pool Imports</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL__MONITOR_POOL_IMPORTS = 4;

    /**
     * The feature id for the '<em><b>Local Pull</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL__LOCAL_PULL = 5;

    /**
     * The feature id for the '<em><b>Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL__FILTERS = 6;

    /**
     * The number of structural features of the '<em>Global</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Global</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBAL_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.impl.EventPoolImportImpl <em>Event Pool Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.impl.EventPoolImportImpl
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getEventPoolImport()
     * @generated
     */
    int EVENT_POOL_IMPORT = 7;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_IMPORT__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_IMPORT__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Local Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_IMPORT__LOCAL_NAME = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Include Local</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_IMPORT__INCLUDE_LOCAL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Pool Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_IMPORT__POOL_SIZE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Event Pool Import</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_IMPORT_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Event Pool Import</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EVENT_POOL_IMPORT_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.impl.MonitorPoolImportImpl <em>Monitor Pool Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.impl.MonitorPoolImportImpl
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getMonitorPoolImport()
     * @generated
     */
    int MONITOR_POOL_IMPORT = 8;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_IMPORT__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_IMPORT__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Local Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_IMPORT__LOCAL_NAME = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Include Local</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_IMPORT__INCLUDE_LOCAL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Monitor Pool Import</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_IMPORT_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Monitor Pool Import</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MONITOR_POOL_IMPORT_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.impl.AuthorativeImpl <em>Authorative</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.impl.AuthorativeImpl
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getAuthorative()
     * @generated
     */
    int AUTHORATIVE = 9;

    /**
     * The feature id for the '<em><b>Hierarchy</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTHORATIVE__HIERARCHY = 0;

    /**
     * The number of structural features of the '<em>Authorative</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTHORATIVE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Authorative</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AUTHORATIVE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.globalization.impl.ItemNameFilterImpl <em>Item Name Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.globalization.impl.ItemNameFilterImpl
     * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getItemNameFilter()
     * @generated
     */
    int ITEM_NAME_FILTER = 10;

    /**
     * The feature id for the '<em><b>Include</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_NAME_FILTER__INCLUDE = FILTER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Item Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_NAME_FILTER__ITEM_NAME = FILTER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Item Name Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_NAME_FILTER_FEATURE_COUNT = FILTER_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Item Name Filter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_NAME_FILTER_OPERATION_COUNT = FILTER_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.Globalization <em>Globalization</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Globalization</em>'.
     * @see org.eclipse.scada.configuration.globalization.Globalization
     * @generated
     */
    EClass getGlobalization ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.globalization.Globalization#getWorld <em>World</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>World</em>'.
     * @see org.eclipse.scada.configuration.globalization.Globalization#getWorld()
     * @see #getGlobalization()
     * @generated
     */
    EReference getGlobalization_World ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.globalization.Globalization#getDefaultLogonCredentials <em>Default Logon Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default Logon Credentials</em>'.
     * @see org.eclipse.scada.configuration.globalization.Globalization#getDefaultLogonCredentials()
     * @see #getGlobalization()
     * @generated
     */
    EReference getGlobalization_DefaultLogonCredentials ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.globalization.Globalization#getGlobals <em>Globals</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Globals</em>'.
     * @see org.eclipse.scada.configuration.globalization.Globalization#getGlobals()
     * @see #getGlobalization()
     * @generated
     */
    EReference getGlobalization_Globals ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.Local <em>Local</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Local</em>'.
     * @see org.eclipse.scada.configuration.globalization.Local
     * @generated
     */
    EClass getLocal ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.globalization.Local#getLocal <em>Local</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Local</em>'.
     * @see org.eclipse.scada.configuration.globalization.Local#getLocal()
     * @see #getLocal()
     * @generated
     */
    EReference getLocal_Local ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.globalization.Local#getLogonCredentials <em>Logon Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Logon Credentials</em>'.
     * @see org.eclipse.scada.configuration.globalization.Local#getLogonCredentials()
     * @see #getLocal()
     * @generated
     */
    EReference getLocal_LogonCredentials ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.globalization.Local#getFilters <em>Filters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Filters</em>'.
     * @see org.eclipse.scada.configuration.globalization.Local#getFilters()
     * @see #getLocal()
     * @generated
     */
    EReference getLocal_Filters ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.globalization.Local#isDefaultInclude <em>Default Include</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Include</em>'.
     * @see org.eclipse.scada.configuration.globalization.Local#isDefaultInclude()
     * @see #getLocal()
     * @generated
     */
    EAttribute getLocal_DefaultInclude ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.globalization.Local#getGlobal <em>Global</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Global</em>'.
     * @see org.eclipse.scada.configuration.globalization.Local#getGlobal()
     * @see #getLocal()
     * @generated
     */
    EReference getLocal_Global ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.globalization.Local#getAuthoratives <em>Authoratives</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Authoratives</em>'.
     * @see org.eclipse.scada.configuration.globalization.Local#getAuthoratives()
     * @see #getLocal()
     * @generated
     */
    EReference getLocal_Authoratives ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.globalization.Local#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.globalization.Local#getId()
     * @see #getLocal()
     * @generated
     */
    EAttribute getLocal_Id ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.Include <em>Include</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Include</em>'.
     * @see org.eclipse.scada.configuration.globalization.Include
     * @generated
     */
    EClass getInclude ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.Exclude <em>Exclude</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exclude</em>'.
     * @see org.eclipse.scada.configuration.globalization.Exclude
     * @generated
     */
    EClass getExclude ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.Filter <em>Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Filter</em>'.
     * @see org.eclipse.scada.configuration.globalization.Filter
     * @generated
     */
    EClass getFilter ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.PatternFilter <em>Pattern Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Pattern Filter</em>'.
     * @see org.eclipse.scada.configuration.globalization.PatternFilter
     * @generated
     */
    EClass getPatternFilter ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.globalization.PatternFilter#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pattern</em>'.
     * @see org.eclipse.scada.configuration.globalization.PatternFilter#getPattern()
     * @see #getPatternFilter()
     * @generated
     */
    EAttribute getPatternFilter_Pattern ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.Global <em>Global</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Global</em>'.
     * @see org.eclipse.scada.configuration.globalization.Global
     * @generated
     */
    EClass getGlobal ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.globalization.Global#getGlobal <em>Global</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Global</em>'.
     * @see org.eclipse.scada.configuration.globalization.Global#getGlobal()
     * @see #getGlobal()
     * @generated
     */
    EReference getGlobal_Global ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.globalization.Global#getDefaultLogonCredentials <em>Default Logon Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default Logon Credentials</em>'.
     * @see org.eclipse.scada.configuration.globalization.Global#getDefaultLogonCredentials()
     * @see #getGlobal()
     * @generated
     */
    EReference getGlobal_DefaultLogonCredentials ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.globalization.Global#getLocals <em>Locals</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Locals</em>'.
     * @see org.eclipse.scada.configuration.globalization.Global#getLocals()
     * @see #getGlobal()
     * @generated
     */
    EReference getGlobal_Locals ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.globalization.Global#getEventPoolImports <em>Event Pool Imports</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Event Pool Imports</em>'.
     * @see org.eclipse.scada.configuration.globalization.Global#getEventPoolImports()
     * @see #getGlobal()
     * @generated
     */
    EReference getGlobal_EventPoolImports ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.globalization.Global#getMonitorPoolImports <em>Monitor Pool Imports</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Monitor Pool Imports</em>'.
     * @see org.eclipse.scada.configuration.globalization.Global#getMonitorPoolImports()
     * @see #getGlobal()
     * @generated
     */
    EReference getGlobal_MonitorPoolImports ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.globalization.Global#getLocalPull <em>Local Pull</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Local Pull</em>'.
     * @see org.eclipse.scada.configuration.globalization.Global#getLocalPull()
     * @see #getGlobal()
     * @generated
     */
    EReference getGlobal_LocalPull ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.globalization.Global#getFilters <em>Filters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Filters</em>'.
     * @see org.eclipse.scada.configuration.globalization.Global#getFilters()
     * @see #getGlobal()
     * @generated
     */
    EReference getGlobal_Filters ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.EventPoolImport <em>Event Pool Import</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Pool Import</em>'.
     * @see org.eclipse.scada.configuration.globalization.EventPoolImport
     * @generated
     */
    EClass getEventPoolImport ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.globalization.EventPoolImport#getLocalName <em>Local Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Local Name</em>'.
     * @see org.eclipse.scada.configuration.globalization.EventPoolImport#getLocalName()
     * @see #getEventPoolImport()
     * @generated
     */
    EAttribute getEventPoolImport_LocalName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.globalization.EventPoolImport#isIncludeLocal <em>Include Local</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Include Local</em>'.
     * @see org.eclipse.scada.configuration.globalization.EventPoolImport#isIncludeLocal()
     * @see #getEventPoolImport()
     * @generated
     */
    EAttribute getEventPoolImport_IncludeLocal ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.globalization.EventPoolImport#getPoolSize <em>Pool Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pool Size</em>'.
     * @see org.eclipse.scada.configuration.globalization.EventPoolImport#getPoolSize()
     * @see #getEventPoolImport()
     * @generated
     */
    EAttribute getEventPoolImport_PoolSize ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.MonitorPoolImport <em>Monitor Pool Import</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Monitor Pool Import</em>'.
     * @see org.eclipse.scada.configuration.globalization.MonitorPoolImport
     * @generated
     */
    EClass getMonitorPoolImport ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.globalization.MonitorPoolImport#getLocalName <em>Local Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Local Name</em>'.
     * @see org.eclipse.scada.configuration.globalization.MonitorPoolImport#getLocalName()
     * @see #getMonitorPoolImport()
     * @generated
     */
    EAttribute getMonitorPoolImport_LocalName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.globalization.MonitorPoolImport#isIncludeLocal <em>Include Local</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Include Local</em>'.
     * @see org.eclipse.scada.configuration.globalization.MonitorPoolImport#isIncludeLocal()
     * @see #getMonitorPoolImport()
     * @generated
     */
    EAttribute getMonitorPoolImport_IncludeLocal ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.Authorative <em>Authorative</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Authorative</em>'.
     * @see org.eclipse.scada.configuration.globalization.Authorative
     * @generated
     */
    EClass getAuthorative ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.globalization.Authorative#getHierarchy <em>Hierarchy</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Hierarchy</em>'.
     * @see org.eclipse.scada.configuration.globalization.Authorative#getHierarchy()
     * @see #getAuthorative()
     * @generated
     */
    EAttribute getAuthorative_Hierarchy ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.globalization.ItemNameFilter <em>Item Name Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Name Filter</em>'.
     * @see org.eclipse.scada.configuration.globalization.ItemNameFilter
     * @generated
     */
    EClass getItemNameFilter ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.globalization.ItemNameFilter#isInclude <em>Include</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Include</em>'.
     * @see org.eclipse.scada.configuration.globalization.ItemNameFilter#isInclude()
     * @see #getItemNameFilter()
     * @generated
     */
    EAttribute getItemNameFilter_Include ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.globalization.ItemNameFilter#getItemName <em>Item Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Item Name</em>'.
     * @see org.eclipse.scada.configuration.globalization.ItemNameFilter#getItemName()
     * @see #getItemNameFilter()
     * @generated
     */
    EAttribute getItemNameFilter_ItemName ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    GlobalizeFactory getGlobalizeFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.impl.GlobalizationImpl <em>Globalization</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizationImpl
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getGlobalization()
         * @generated
         */
        EClass GLOBALIZATION = eINSTANCE.getGlobalization ();

        /**
         * The meta object literal for the '<em><b>World</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBALIZATION__WORLD = eINSTANCE.getGlobalization_World ();

        /**
         * The meta object literal for the '<em><b>Default Logon Credentials</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS = eINSTANCE.getGlobalization_DefaultLogonCredentials ();

        /**
         * The meta object literal for the '<em><b>Globals</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBALIZATION__GLOBALS = eINSTANCE.getGlobalization_Globals ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.impl.LocalImpl <em>Local</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.impl.LocalImpl
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getLocal()
         * @generated
         */
        EClass LOCAL = eINSTANCE.getLocal ();

        /**
         * The meta object literal for the '<em><b>Local</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOCAL__LOCAL = eINSTANCE.getLocal_Local ();

        /**
         * The meta object literal for the '<em><b>Logon Credentials</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOCAL__LOGON_CREDENTIALS = eINSTANCE.getLocal_LogonCredentials ();

        /**
         * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOCAL__FILTERS = eINSTANCE.getLocal_Filters ();

        /**
         * The meta object literal for the '<em><b>Default Include</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LOCAL__DEFAULT_INCLUDE = eINSTANCE.getLocal_DefaultInclude ();

        /**
         * The meta object literal for the '<em><b>Global</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOCAL__GLOBAL = eINSTANCE.getLocal_Global ();

        /**
         * The meta object literal for the '<em><b>Authoratives</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LOCAL__AUTHORATIVES = eINSTANCE.getLocal_Authoratives ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LOCAL__ID = eINSTANCE.getLocal_Id ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.impl.IncludeImpl <em>Include</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.impl.IncludeImpl
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getInclude()
         * @generated
         */
        EClass INCLUDE = eINSTANCE.getInclude ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.impl.ExcludeImpl <em>Exclude</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.impl.ExcludeImpl
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getExclude()
         * @generated
         */
        EClass EXCLUDE = eINSTANCE.getExclude ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.Filter <em>Filter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.Filter
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getFilter()
         * @generated
         */
        EClass FILTER = eINSTANCE.getFilter ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.impl.PatternFilterImpl <em>Pattern Filter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.impl.PatternFilterImpl
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getPatternFilter()
         * @generated
         */
        EClass PATTERN_FILTER = eINSTANCE.getPatternFilter ();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PATTERN_FILTER__PATTERN = eINSTANCE.getPatternFilter_Pattern ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.impl.GlobalImpl <em>Global</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalImpl
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getGlobal()
         * @generated
         */
        EClass GLOBAL = eINSTANCE.getGlobal ();

        /**
         * The meta object literal for the '<em><b>Global</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBAL__GLOBAL = eINSTANCE.getGlobal_Global ();

        /**
         * The meta object literal for the '<em><b>Default Logon Credentials</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBAL__DEFAULT_LOGON_CREDENTIALS = eINSTANCE.getGlobal_DefaultLogonCredentials ();

        /**
         * The meta object literal for the '<em><b>Locals</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBAL__LOCALS = eINSTANCE.getGlobal_Locals ();

        /**
         * The meta object literal for the '<em><b>Event Pool Imports</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBAL__EVENT_POOL_IMPORTS = eINSTANCE.getGlobal_EventPoolImports ();

        /**
         * The meta object literal for the '<em><b>Monitor Pool Imports</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBAL__MONITOR_POOL_IMPORTS = eINSTANCE.getGlobal_MonitorPoolImports ();

        /**
         * The meta object literal for the '<em><b>Local Pull</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBAL__LOCAL_PULL = eINSTANCE.getGlobal_LocalPull ();

        /**
         * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBAL__FILTERS = eINSTANCE.getGlobal_Filters ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.impl.EventPoolImportImpl <em>Event Pool Import</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.impl.EventPoolImportImpl
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getEventPoolImport()
         * @generated
         */
        EClass EVENT_POOL_IMPORT = eINSTANCE.getEventPoolImport ();

        /**
         * The meta object literal for the '<em><b>Local Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_POOL_IMPORT__LOCAL_NAME = eINSTANCE.getEventPoolImport_LocalName ();

        /**
         * The meta object literal for the '<em><b>Include Local</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_POOL_IMPORT__INCLUDE_LOCAL = eINSTANCE.getEventPoolImport_IncludeLocal ();

        /**
         * The meta object literal for the '<em><b>Pool Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EVENT_POOL_IMPORT__POOL_SIZE = eINSTANCE.getEventPoolImport_PoolSize ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.impl.MonitorPoolImportImpl <em>Monitor Pool Import</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.impl.MonitorPoolImportImpl
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getMonitorPoolImport()
         * @generated
         */
        EClass MONITOR_POOL_IMPORT = eINSTANCE.getMonitorPoolImport ();

        /**
         * The meta object literal for the '<em><b>Local Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MONITOR_POOL_IMPORT__LOCAL_NAME = eINSTANCE.getMonitorPoolImport_LocalName ();

        /**
         * The meta object literal for the '<em><b>Include Local</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MONITOR_POOL_IMPORT__INCLUDE_LOCAL = eINSTANCE.getMonitorPoolImport_IncludeLocal ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.impl.AuthorativeImpl <em>Authorative</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.impl.AuthorativeImpl
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getAuthorative()
         * @generated
         */
        EClass AUTHORATIVE = eINSTANCE.getAuthorative ();

        /**
         * The meta object literal for the '<em><b>Hierarchy</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AUTHORATIVE__HIERARCHY = eINSTANCE.getAuthorative_Hierarchy ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.globalization.impl.ItemNameFilterImpl <em>Item Name Filter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.globalization.impl.ItemNameFilterImpl
         * @see org.eclipse.scada.configuration.globalization.impl.GlobalizePackageImpl#getItemNameFilter()
         * @generated
         */
        EClass ITEM_NAME_FILTER = eINSTANCE.getItemNameFilter ();

        /**
         * The meta object literal for the '<em><b>Include</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_NAME_FILTER__INCLUDE = eINSTANCE.getItemNameFilter_Include ();

        /**
         * The meta object literal for the '<em><b>Item Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_NAME_FILTER__ITEM_NAME = eINSTANCE.getItemNameFilter_ItemName ();

    }

} //GlobalizePackage
