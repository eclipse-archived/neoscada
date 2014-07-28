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
package org.eclipse.scada.configuration.driver.jdbc.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.driver.jdbc.ColumnMapping;
import org.eclipse.scada.configuration.driver.jdbc.JdbcDriver;
import org.eclipse.scada.configuration.driver.jdbc.JdbcDriverInstance;
import org.eclipse.scada.configuration.driver.jdbc.JdbcFactory;
import org.eclipse.scada.configuration.driver.jdbc.JdbcPackage;
import org.eclipse.scada.configuration.driver.jdbc.QueryBase;
import org.eclipse.scada.configuration.driver.jdbc.QueryComponent;
import org.eclipse.scada.configuration.driver.jdbc.UpdateCommand;
import org.eclipse.scada.configuration.driver.jdbc.UpdateMapping;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.da.server.jdbc.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JdbcPackageImpl extends EPackageImpl implements JdbcPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass jdbcDriverInstanceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass updateCommandEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass queryComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass queryBaseEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass updateMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass columnMappingEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass jdbcDriverEClass = null;

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
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private JdbcPackageImpl ()
    {
        super ( eNS_URI, JdbcFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link JdbcPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static JdbcPackage init ()
    {
        if ( isInited )
            return (JdbcPackage)EPackage.Registry.INSTANCE.getEPackage ( JdbcPackage.eNS_URI );

        // Obtain or create and register package
        JdbcPackageImpl theJdbcPackage = (JdbcPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof JdbcPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new JdbcPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        ComponentPackage.eINSTANCE.eClass ();
        ConfigurationPackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theJdbcPackage.createPackageContents ();

        // Initialize created meta-data
        theJdbcPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theJdbcPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( JdbcPackage.eNS_URI, theJdbcPackage );
        return theJdbcPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJdbcDriverInstance ()
    {
        return jdbcDriverInstanceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getJdbcDriverInstance_Root ()
    {
        return (EReference)jdbcDriverInstanceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUpdateCommand ()
    {
        return updateCommandEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUpdateCommand_Mappings ()
    {
        return (EReference)updateCommandEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getQueryComponent ()
    {
        return queryComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQueryComponent_Name ()
    {
        return (EAttribute)queryComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getQueryComponent_Mappings ()
    {
        return (EReference)queryComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQueryComponent_Period ()
    {
        return (EAttribute)queryComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQueryComponent_DefaultCustomizationTags ()
    {
        return (EAttribute)queryComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQueryComponent_DefaultDataType ()
    {
        return (EAttribute)queryComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getQueryBase ()
    {
        return queryBaseEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQueryBase_Sql ()
    {
        return (EAttribute)queryBaseEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getQueryBase_Database ()
    {
        return (EReference)queryBaseEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQueryBase_QueryTimeout ()
    {
        return (EAttribute)queryBaseEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getQueryBase_RunsOn ()
    {
        return (EReference)queryBaseEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUpdateMapping ()
    {
        return updateMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUpdateMapping_NamedParameter ()
    {
        return (EAttribute)updateMappingEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getColumnMapping ()
    {
        return columnMappingEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColumnMapping_ColumnNumber ()
    {
        return (EAttribute)columnMappingEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColumnMapping_Name ()
    {
        return (EAttribute)columnMappingEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColumnMapping_CustomizationTags ()
    {
        return (EAttribute)columnMappingEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColumnMapping_DataType ()
    {
        return (EAttribute)columnMappingEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJdbcDriver ()
    {
        return jdbcDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JdbcFactory getJdbcFactory ()
    {
        return (JdbcFactory)getEFactoryInstance ();
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
        jdbcDriverInstanceEClass = createEClass ( JDBC_DRIVER_INSTANCE );
        createEReference ( jdbcDriverInstanceEClass, JDBC_DRIVER_INSTANCE__ROOT );

        updateCommandEClass = createEClass ( UPDATE_COMMAND );
        createEReference ( updateCommandEClass, UPDATE_COMMAND__MAPPINGS );

        queryComponentEClass = createEClass ( QUERY_COMPONENT );
        createEAttribute ( queryComponentEClass, QUERY_COMPONENT__NAME );
        createEReference ( queryComponentEClass, QUERY_COMPONENT__MAPPINGS );
        createEAttribute ( queryComponentEClass, QUERY_COMPONENT__PERIOD );
        createEAttribute ( queryComponentEClass, QUERY_COMPONENT__DEFAULT_CUSTOMIZATION_TAGS );
        createEAttribute ( queryComponentEClass, QUERY_COMPONENT__DEFAULT_DATA_TYPE );

        queryBaseEClass = createEClass ( QUERY_BASE );
        createEAttribute ( queryBaseEClass, QUERY_BASE__SQL );
        createEReference ( queryBaseEClass, QUERY_BASE__DATABASE );
        createEAttribute ( queryBaseEClass, QUERY_BASE__QUERY_TIMEOUT );
        createEReference ( queryBaseEClass, QUERY_BASE__RUNS_ON );

        updateMappingEClass = createEClass ( UPDATE_MAPPING );
        createEAttribute ( updateMappingEClass, UPDATE_MAPPING__NAMED_PARAMETER );

        columnMappingEClass = createEClass ( COLUMN_MAPPING );
        createEAttribute ( columnMappingEClass, COLUMN_MAPPING__COLUMN_NUMBER );
        createEAttribute ( columnMappingEClass, COLUMN_MAPPING__NAME );
        createEAttribute ( columnMappingEClass, COLUMN_MAPPING__CUSTOMIZATION_TAGS );
        createEAttribute ( columnMappingEClass, COLUMN_MAPPING__DATA_TYPE );

        jdbcDriverEClass = createEClass ( JDBC_DRIVER );
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
        ConfigurationPackage theConfigurationPackage = (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage ( ConfigurationPackage.eNS_URI );
        ComponentPackage theComponentPackage = (ComponentPackage)EPackage.Registry.INSTANCE.getEPackage ( ComponentPackage.eNS_URI );
        OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        jdbcDriverInstanceEClass.getESuperTypes ().add ( theWorldPackage.getCommonDriver () );
        updateCommandEClass.getESuperTypes ().add ( theComponentPackage.getSingleValue () );
        updateCommandEClass.getESuperTypes ().add ( this.getQueryBase () );
        queryComponentEClass.getESuperTypes ().add ( theComponentPackage.getMasterComponent () );
        queryComponentEClass.getESuperTypes ().add ( this.getQueryBase () );
        jdbcDriverEClass.getESuperTypes ().add ( theInfrastructurePackage.getAbstractCommonDriver () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( jdbcDriverInstanceEClass, JdbcDriverInstance.class, "JdbcDriverInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getJdbcDriverInstance_Root (), theConfigurationPackage.getRootType (), null, "root", null, 0, 1, JdbcDriverInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( updateCommandEClass, UpdateCommand.class, "UpdateCommand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getUpdateCommand_Mappings (), this.getUpdateMapping (), null, "mappings", null, 0, -1, UpdateCommand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( queryComponentEClass, QueryComponent.class, "QueryComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getQueryComponent_Name (), ecorePackage.getEString (), "name", null, 1, 1, QueryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getQueryComponent_Mappings (), this.getColumnMapping (), null, "mappings", null, 0, -1, QueryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getQueryComponent_Period (), ecorePackage.getEInt (), "period", null, 1, 1, QueryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getQueryComponent_DefaultCustomizationTags (), ecorePackage.getEString (), "defaultCustomizationTags", null, 0, -1, QueryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getQueryComponent_DefaultDataType (), theOsgiPackage.getDataType (), "defaultDataType", null, 0, 1, QueryComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( queryBaseEClass, QueryBase.class, "QueryBase", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getQueryBase_Sql (), ecorePackage.getEString (), "sql", null, 1, 1, QueryBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getQueryBase_Database (), theWorldPackage.getDatabaseSettings (), null, "database", null, 1, 1, QueryBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getQueryBase_QueryTimeout (), ecorePackage.getEIntegerObject (), "queryTimeout", null, 0, 1, QueryBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getQueryBase_RunsOn (), this.getJdbcDriver (), null, "runsOn", null, 1, 1, QueryBase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( updateMappingEClass, UpdateMapping.class, "UpdateMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getUpdateMapping_NamedParameter (), ecorePackage.getEString (), "namedParameter", null, 1, 1, UpdateMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( columnMappingEClass, ColumnMapping.class, "ColumnMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getColumnMapping_ColumnNumber (), ecorePackage.getEInt (), "columnNumber", "1", 1, 1, ColumnMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getColumnMapping_Name (), ecorePackage.getEString (), "name", null, 1, 1, ColumnMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getColumnMapping_CustomizationTags (), ecorePackage.getEString (), "customizationTags", null, 0, -1, ColumnMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getColumnMapping_DataType (), theOsgiPackage.getDataType (), "dataType", "NULL", 0, 1, ColumnMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( jdbcDriverEClass, JdbcDriver.class, "JdbcDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //JdbcPackageImpl
