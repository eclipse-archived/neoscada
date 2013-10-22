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
package org.eclipse.scada.configuration.globalization.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.globalization.Authorative;
import org.eclipse.scada.configuration.globalization.EventPoolImport;
import org.eclipse.scada.configuration.globalization.Exclude;
import org.eclipse.scada.configuration.globalization.Filter;
import org.eclipse.scada.configuration.globalization.Global;
import org.eclipse.scada.configuration.globalization.Globalization;
import org.eclipse.scada.configuration.globalization.GlobalizeFactory;
import org.eclipse.scada.configuration.globalization.GlobalizePackage;
import org.eclipse.scada.configuration.globalization.Include;
import org.eclipse.scada.configuration.globalization.ItemNameFilter;
import org.eclipse.scada.configuration.globalization.Local;
import org.eclipse.scada.configuration.globalization.MonitorPoolImport;
import org.eclipse.scada.configuration.globalization.PatternFilter;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GlobalizePackageImpl extends EPackageImpl implements GlobalizePackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass globalizationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass localEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass includeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass excludeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass filterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass patternFilterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass globalEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eventPoolImportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass monitorPoolImportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass authorativeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemNameFilterEClass = null;

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
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private GlobalizePackageImpl ()
    {
        super ( eNS_URI, GlobalizeFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link GlobalizePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static GlobalizePackage init ()
    {
        if ( isInited )
            return (GlobalizePackage)EPackage.Registry.INSTANCE.getEPackage ( GlobalizePackage.eNS_URI );

        // Obtain or create and register package
        GlobalizePackageImpl theGlobalizePackage = (GlobalizePackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof GlobalizePackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new GlobalizePackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        WorldPackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theGlobalizePackage.createPackageContents ();

        // Initialize created meta-data
        theGlobalizePackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theGlobalizePackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( GlobalizePackage.eNS_URI, theGlobalizePackage );
        return theGlobalizePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGlobalization ()
    {
        return globalizationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobalization_World ()
    {
        return (EReference)globalizationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobalization_DefaultLogonCredentials ()
    {
        return (EReference)globalizationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobalization_Globals ()
    {
        return (EReference)globalizationEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLocal ()
    {
        return localEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLocal_Local ()
    {
        return (EReference)localEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLocal_LogonCredentials ()
    {
        return (EReference)localEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLocal_Filters ()
    {
        return (EReference)localEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLocal_DefaultInclude ()
    {
        return (EAttribute)localEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLocal_Global ()
    {
        return (EReference)localEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLocal_Authoratives ()
    {
        return (EReference)localEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLocal_Id ()
    {
        return (EAttribute)localEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInclude ()
    {
        return includeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExclude ()
    {
        return excludeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFilter ()
    {
        return filterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPatternFilter ()
    {
        return patternFilterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPatternFilter_Pattern ()
    {
        return (EAttribute)patternFilterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGlobal ()
    {
        return globalEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobal_Global ()
    {
        return (EReference)globalEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobal_DefaultLogonCredentials ()
    {
        return (EReference)globalEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobal_Locals ()
    {
        return (EReference)globalEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobal_EventPoolImports ()
    {
        return (EReference)globalEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobal_MonitorPoolImports ()
    {
        return (EReference)globalEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobal_LocalPull ()
    {
        return (EReference)globalEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobal_Filters ()
    {
        return (EReference)globalEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getEventPoolImport ()
    {
        return eventPoolImportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEventPoolImport_LocalName ()
    {
        return (EAttribute)eventPoolImportEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEventPoolImport_IncludeLocal ()
    {
        return (EAttribute)eventPoolImportEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEventPoolImport_PoolSize ()
    {
        return (EAttribute)eventPoolImportEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMonitorPoolImport ()
    {
        return monitorPoolImportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMonitorPoolImport_LocalName ()
    {
        return (EAttribute)monitorPoolImportEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMonitorPoolImport_IncludeLocal ()
    {
        return (EAttribute)monitorPoolImportEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAuthorative ()
    {
        return authorativeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAuthorative_Hierarchy ()
    {
        return (EAttribute)authorativeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItemNameFilter ()
    {
        return itemNameFilterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItemNameFilter_Include ()
    {
        return (EAttribute)itemNameFilterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItemNameFilter_ItemName ()
    {
        return (EAttribute)itemNameFilterEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GlobalizeFactory getGlobalizeFactory ()
    {
        return (GlobalizeFactory)getEFactoryInstance ();
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
        globalizationEClass = createEClass ( GLOBALIZATION );
        createEReference ( globalizationEClass, GLOBALIZATION__WORLD );
        createEReference ( globalizationEClass, GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS );
        createEReference ( globalizationEClass, GLOBALIZATION__GLOBALS );

        localEClass = createEClass ( LOCAL );
        createEReference ( localEClass, LOCAL__LOCAL );
        createEReference ( localEClass, LOCAL__LOGON_CREDENTIALS );
        createEReference ( localEClass, LOCAL__FILTERS );
        createEAttribute ( localEClass, LOCAL__DEFAULT_INCLUDE );
        createEReference ( localEClass, LOCAL__GLOBAL );
        createEReference ( localEClass, LOCAL__AUTHORATIVES );
        createEAttribute ( localEClass, LOCAL__ID );

        includeEClass = createEClass ( INCLUDE );

        excludeEClass = createEClass ( EXCLUDE );

        filterEClass = createEClass ( FILTER );

        patternFilterEClass = createEClass ( PATTERN_FILTER );
        createEAttribute ( patternFilterEClass, PATTERN_FILTER__PATTERN );

        globalEClass = createEClass ( GLOBAL );
        createEReference ( globalEClass, GLOBAL__GLOBAL );
        createEReference ( globalEClass, GLOBAL__DEFAULT_LOGON_CREDENTIALS );
        createEReference ( globalEClass, GLOBAL__LOCALS );
        createEReference ( globalEClass, GLOBAL__EVENT_POOL_IMPORTS );
        createEReference ( globalEClass, GLOBAL__MONITOR_POOL_IMPORTS );
        createEReference ( globalEClass, GLOBAL__LOCAL_PULL );
        createEReference ( globalEClass, GLOBAL__FILTERS );

        eventPoolImportEClass = createEClass ( EVENT_POOL_IMPORT );
        createEAttribute ( eventPoolImportEClass, EVENT_POOL_IMPORT__LOCAL_NAME );
        createEAttribute ( eventPoolImportEClass, EVENT_POOL_IMPORT__INCLUDE_LOCAL );
        createEAttribute ( eventPoolImportEClass, EVENT_POOL_IMPORT__POOL_SIZE );

        monitorPoolImportEClass = createEClass ( MONITOR_POOL_IMPORT );
        createEAttribute ( monitorPoolImportEClass, MONITOR_POOL_IMPORT__LOCAL_NAME );
        createEAttribute ( monitorPoolImportEClass, MONITOR_POOL_IMPORT__INCLUDE_LOCAL );

        authorativeEClass = createEClass ( AUTHORATIVE );
        createEAttribute ( authorativeEClass, AUTHORATIVE__HIERARCHY );

        itemNameFilterEClass = createEClass ( ITEM_NAME_FILTER );
        createEAttribute ( itemNameFilterEClass, ITEM_NAME_FILTER__INCLUDE );
        createEAttribute ( itemNameFilterEClass, ITEM_NAME_FILTER__ITEM_NAME );
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        includeEClass.getESuperTypes ().add ( this.getPatternFilter () );
        excludeEClass.getESuperTypes ().add ( this.getPatternFilter () );
        patternFilterEClass.getESuperTypes ().add ( this.getFilter () );
        eventPoolImportEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        monitorPoolImportEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        itemNameFilterEClass.getESuperTypes ().add ( this.getFilter () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( globalizationEClass, Globalization.class, "Globalization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getGlobalization_World (), theWorldPackage.getWorld (), null, "world", null, 1, 1, Globalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobalization_DefaultLogonCredentials (), theWorldPackage.getCredentials (), null, "defaultLogonCredentials", null, 0, 1, Globalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobalization_Globals (), this.getGlobal (), null, "globals", null, 0, -1, Globalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( localEClass, Local.class, "Local", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getLocal_Local (), theOsgiPackage.getMasterServer (), null, "local", null, 1, 1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLocal_LogonCredentials (), theWorldPackage.getCredentials (), null, "logonCredentials", null, 0, 1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLocal_Filters (), this.getFilter (), null, "filters", null, 0, -1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLocal_DefaultInclude (), ecorePackage.getEBoolean (), "defaultInclude", "false", 1, 1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getLocal_Global (), this.getGlobal (), this.getGlobal_Locals (), "global", null, 1, 1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLocal_Authoratives (), this.getAuthorative (), null, "authoratives", null, 0, -1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLocal_Id (), ecorePackage.getEString (), "id", null, 1, 1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( includeEClass, Include.class, "Include", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( excludeEClass, Exclude.class, "Exclude", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( filterEClass, Filter.class, "Filter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( patternFilterEClass, PatternFilter.class, "PatternFilter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPatternFilter_Pattern (), theWorldPackage.getPattern (), "pattern", null, 1, 1, PatternFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( globalEClass, Global.class, "Global", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getGlobal_Global (), theOsgiPackage.getMasterServer (), null, "global", null, 1, 1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_DefaultLogonCredentials (), theWorldPackage.getCredentials (), null, "defaultLogonCredentials", null, 0, 1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_Locals (), this.getLocal (), this.getLocal_Global (), "locals", null, 0, -1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_EventPoolImports (), this.getEventPoolImport (), null, "eventPoolImports", null, 0, -1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_MonitorPoolImports (), this.getMonitorPoolImport (), null, "monitorPoolImports", null, 0, -1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_LocalPull (), theOsgiPackage.getPullEvents (), null, "localPull", null, 0, 1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_Filters (), this.getFilter (), null, "filters", null, 0, -1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( eventPoolImportEClass, EventPoolImport.class, "EventPoolImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventPoolImport_LocalName (), ecorePackage.getEString (), "localName", null, 1, 1, EventPoolImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventPoolImport_IncludeLocal (), ecorePackage.getEBoolean (), "includeLocal", null, 1, 1, EventPoolImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventPoolImport_PoolSize (), ecorePackage.getEInt (), "poolSize", null, 1, 1, EventPoolImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( monitorPoolImportEClass, MonitorPoolImport.class, "MonitorPoolImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMonitorPoolImport_LocalName (), ecorePackage.getEString (), "localName", null, 1, 1, MonitorPoolImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMonitorPoolImport_IncludeLocal (), ecorePackage.getEBoolean (), "includeLocal", null, 1, 1, MonitorPoolImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( authorativeEClass, Authorative.class, "Authorative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAuthorative_Hierarchy (), ecorePackage.getEString (), "hierarchy", null, 1, -1, Authorative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemNameFilterEClass, ItemNameFilter.class, "ItemNameFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemNameFilter_Include (), ecorePackage.getEBoolean (), "include", "true", 1, 1, ItemNameFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getItemNameFilter_ItemName (), ecorePackage.getEString (), "itemName", null, 1, 1, ItemNameFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //GlobalizePackageImpl
