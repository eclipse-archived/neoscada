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
 * 
 * @generated
 */
public class GlobalizePackageImpl extends EPackageImpl implements GlobalizePackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass globalizationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass localEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass includeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass excludeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass filterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass patternFilterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass globalEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass eventPoolImportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass monitorPoolImportEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass authorativeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass itemNameFilterEClass = null;

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
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link GlobalizePackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static GlobalizePackage init ()
    {
        if ( isInited )
        {
            return (GlobalizePackage)EPackage.Registry.INSTANCE.getEPackage ( GlobalizePackage.eNS_URI );
        }

        // Obtain or create and register package
        final GlobalizePackageImpl theGlobalizePackage = (GlobalizePackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof GlobalizePackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new GlobalizePackageImpl () );

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
     * 
     * @generated
     */
    @Override
    public EClass getGlobalization ()
    {
        return this.globalizationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGlobalization_World ()
    {
        return (EReference)this.globalizationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGlobalization_DefaultLogonCredentials ()
    {
        return (EReference)this.globalizationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGlobalization_Globals ()
    {
        return (EReference)this.globalizationEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getLocal ()
    {
        return this.localEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getLocal_Local ()
    {
        return (EReference)this.localEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getLocal_LogonCredentials ()
    {
        return (EReference)this.localEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getLocal_Filters ()
    {
        return (EReference)this.localEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLocal_DefaultInclude ()
    {
        return (EAttribute)this.localEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getLocal_Global ()
    {
        return (EReference)this.localEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getLocal_Authoratives ()
    {
        return (EReference)this.localEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getLocal_Id ()
    {
        return (EAttribute)this.localEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getInclude ()
    {
        return this.includeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExclude ()
    {
        return this.excludeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFilter ()
    {
        return this.filterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPatternFilter ()
    {
        return this.patternFilterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPatternFilter_Pattern ()
    {
        return (EAttribute)this.patternFilterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getGlobal ()
    {
        return this.globalEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGlobal_Global ()
    {
        return (EReference)this.globalEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGlobal_DefaultLogonCredentials ()
    {
        return (EReference)this.globalEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGlobal_Locals ()
    {
        return (EReference)this.globalEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGlobal_EventPoolImports ()
    {
        return (EReference)this.globalEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGlobal_MonitorPoolImports ()
    {
        return (EReference)this.globalEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGlobal_LocalPull ()
    {
        return (EReference)this.globalEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGlobal_Filters ()
    {
        return (EReference)this.globalEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEventPoolImport ()
    {
        return this.eventPoolImportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventPoolImport_LocalName ()
    {
        return (EAttribute)this.eventPoolImportEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventPoolImport_IncludeLocal ()
    {
        return (EAttribute)this.eventPoolImportEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEventPoolImport_PoolSize ()
    {
        return (EAttribute)this.eventPoolImportEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getMonitorPoolImport ()
    {
        return this.monitorPoolImportEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitorPoolImport_LocalName ()
    {
        return (EAttribute)this.monitorPoolImportEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMonitorPoolImport_IncludeLocal ()
    {
        return (EAttribute)this.monitorPoolImportEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAuthorative ()
    {
        return this.authorativeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAuthorative_Hierarchy ()
    {
        return (EAttribute)this.authorativeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getItemNameFilter ()
    {
        return this.itemNameFilterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItemNameFilter_Include ()
    {
        return (EAttribute)this.itemNameFilterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getItemNameFilter_ItemName ()
    {
        return (EAttribute)this.itemNameFilterEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public GlobalizeFactory getGlobalizeFactory ()
    {
        return (GlobalizeFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents ()
    {
        if ( this.isCreated )
        {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.globalizationEClass = createEClass ( GLOBALIZATION );
        createEReference ( this.globalizationEClass, GLOBALIZATION__WORLD );
        createEReference ( this.globalizationEClass, GLOBALIZATION__DEFAULT_LOGON_CREDENTIALS );
        createEReference ( this.globalizationEClass, GLOBALIZATION__GLOBALS );

        this.localEClass = createEClass ( LOCAL );
        createEReference ( this.localEClass, LOCAL__LOCAL );
        createEReference ( this.localEClass, LOCAL__LOGON_CREDENTIALS );
        createEReference ( this.localEClass, LOCAL__FILTERS );
        createEAttribute ( this.localEClass, LOCAL__DEFAULT_INCLUDE );
        createEReference ( this.localEClass, LOCAL__GLOBAL );
        createEReference ( this.localEClass, LOCAL__AUTHORATIVES );
        createEAttribute ( this.localEClass, LOCAL__ID );

        this.includeEClass = createEClass ( INCLUDE );

        this.excludeEClass = createEClass ( EXCLUDE );

        this.filterEClass = createEClass ( FILTER );

        this.patternFilterEClass = createEClass ( PATTERN_FILTER );
        createEAttribute ( this.patternFilterEClass, PATTERN_FILTER__PATTERN );

        this.globalEClass = createEClass ( GLOBAL );
        createEReference ( this.globalEClass, GLOBAL__GLOBAL );
        createEReference ( this.globalEClass, GLOBAL__DEFAULT_LOGON_CREDENTIALS );
        createEReference ( this.globalEClass, GLOBAL__LOCALS );
        createEReference ( this.globalEClass, GLOBAL__EVENT_POOL_IMPORTS );
        createEReference ( this.globalEClass, GLOBAL__MONITOR_POOL_IMPORTS );
        createEReference ( this.globalEClass, GLOBAL__LOCAL_PULL );
        createEReference ( this.globalEClass, GLOBAL__FILTERS );

        this.eventPoolImportEClass = createEClass ( EVENT_POOL_IMPORT );
        createEAttribute ( this.eventPoolImportEClass, EVENT_POOL_IMPORT__LOCAL_NAME );
        createEAttribute ( this.eventPoolImportEClass, EVENT_POOL_IMPORT__INCLUDE_LOCAL );
        createEAttribute ( this.eventPoolImportEClass, EVENT_POOL_IMPORT__POOL_SIZE );

        this.monitorPoolImportEClass = createEClass ( MONITOR_POOL_IMPORT );
        createEAttribute ( this.monitorPoolImportEClass, MONITOR_POOL_IMPORT__LOCAL_NAME );
        createEAttribute ( this.monitorPoolImportEClass, MONITOR_POOL_IMPORT__INCLUDE_LOCAL );

        this.authorativeEClass = createEClass ( AUTHORATIVE );
        createEAttribute ( this.authorativeEClass, AUTHORATIVE__HIERARCHY );

        this.itemNameFilterEClass = createEClass ( ITEM_NAME_FILTER );
        createEAttribute ( this.itemNameFilterEClass, ITEM_NAME_FILTER__INCLUDE );
        createEAttribute ( this.itemNameFilterEClass, ITEM_NAME_FILTER__ITEM_NAME );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( this.isInitialized )
        {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Obtain other dependent packages
        final WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        final OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.includeEClass.getESuperTypes ().add ( getPatternFilter () );
        this.excludeEClass.getESuperTypes ().add ( getPatternFilter () );
        this.patternFilterEClass.getESuperTypes ().add ( getFilter () );
        this.eventPoolImportEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        this.monitorPoolImportEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        this.itemNameFilterEClass.getESuperTypes ().add ( getFilter () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( this.globalizationEClass, Globalization.class, "Globalization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getGlobalization_World (), theWorldPackage.getWorld (), null, "world", null, 1, 1, Globalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobalization_DefaultLogonCredentials (), theWorldPackage.getCredentials (), null, "defaultLogonCredentials", null, 0, 1, Globalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobalization_Globals (), getGlobal (), null, "globals", null, 0, -1, Globalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.localEClass, Local.class, "Local", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getLocal_Local (), theOsgiPackage.getMasterServer (), null, "local", null, 1, 1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLocal_LogonCredentials (), theWorldPackage.getCredentials (), null, "logonCredentials", null, 0, 1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLocal_Filters (), getFilter (), null, "filters", null, 0, -1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLocal_DefaultInclude (), this.ecorePackage.getEBoolean (), "defaultInclude", "false", 1, 1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getLocal_Global (), getGlobal (), getGlobal_Locals (), "global", null, 1, 1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLocal_Authoratives (), getAuthorative (), null, "authoratives", null, 0, -1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLocal_Id (), this.ecorePackage.getEString (), "id", null, 1, 1, Local.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.includeEClass, Include.class, "Include", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.excludeEClass, Exclude.class, "Exclude", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.filterEClass, Filter.class, "Filter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.patternFilterEClass, PatternFilter.class, "PatternFilter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPatternFilter_Pattern (), theWorldPackage.getPattern (), "pattern", null, 1, 1, PatternFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.globalEClass, Global.class, "Global", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getGlobal_Global (), theOsgiPackage.getMasterServer (), null, "global", null, 1, 1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_DefaultLogonCredentials (), theWorldPackage.getCredentials (), null, "defaultLogonCredentials", null, 0, 1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_Locals (), getLocal (), getLocal_Global (), "locals", null, 0, -1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_EventPoolImports (), getEventPoolImport (), null, "eventPoolImports", null, 0, -1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_MonitorPoolImports (), getMonitorPoolImport (), null, "monitorPoolImports", null, 0, -1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_LocalPull (), theOsgiPackage.getPullEvents (), null, "localPull", null, 0, 1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobal_Filters (), getFilter (), null, "filters", null, 0, -1, Global.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.eventPoolImportEClass, EventPoolImport.class, "EventPoolImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEventPoolImport_LocalName (), this.ecorePackage.getEString (), "localName", null, 1, 1, EventPoolImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventPoolImport_IncludeLocal (), this.ecorePackage.getEBoolean (), "includeLocal", null, 1, 1, EventPoolImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEventPoolImport_PoolSize (), this.ecorePackage.getEInt (), "poolSize", null, 1, 1, EventPoolImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.monitorPoolImportEClass, MonitorPoolImport.class, "MonitorPoolImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMonitorPoolImport_LocalName (), this.ecorePackage.getEString (), "localName", null, 1, 1, MonitorPoolImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMonitorPoolImport_IncludeLocal (), this.ecorePackage.getEBoolean (), "includeLocal", null, 1, 1, MonitorPoolImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.authorativeEClass, Authorative.class, "Authorative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAuthorative_Hierarchy (), this.ecorePackage.getEString (), "hierarchy", null, 1, -1, Authorative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.itemNameFilterEClass, ItemNameFilter.class, "ItemNameFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemNameFilter_Include (), this.ecorePackage.getEBoolean (), "include", "true", 1, 1, ItemNameFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getItemNameFilter_ItemName (), this.ecorePackage.getEString (), "itemName", null, 1, 1, ItemNameFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //GlobalizePackageImpl
