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
package org.eclipse.scada.da.jdbc.configuration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.scada.da.jdbc.configuration.AbstractQueryType;
import org.eclipse.scada.da.jdbc.configuration.ColumnMappingType;
import org.eclipse.scada.da.jdbc.configuration.CommandsType;
import org.eclipse.scada.da.jdbc.configuration.ConfigurationFactory;
import org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage;
import org.eclipse.scada.da.jdbc.configuration.ConnectionType;
import org.eclipse.scada.da.jdbc.configuration.DocumentRoot;
import org.eclipse.scada.da.jdbc.configuration.QueryType;
import org.eclipse.scada.da.jdbc.configuration.RootType;
import org.eclipse.scada.da.jdbc.configuration.TabularQueryType;
import org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType;
import org.eclipse.scada.da.jdbc.configuration.UpdateMappingType;
import org.eclipse.scada.da.jdbc.configuration.UpdateType;
import org.eclipse.scada.da.jdbc.configuration.util.ConfigurationValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationPackageImpl extends EPackageImpl implements ConfigurationPackage
{
    //$NON-NLS-1$

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractQueryTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass columnMappingTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass commandsTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass connectionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass documentRootEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass queryTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rootTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass tabularQueryTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass updateColumnsTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass updateMappingTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass updateTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType aliasNameTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType columnNumberTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType columnNumberTypeObjectEDataType = null;

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
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ConfigurationPackageImpl ()
    {
        super ( eNS_URI, ConfigurationFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link ConfigurationPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ConfigurationPackage init ()
    {
        if ( isInited )
            return (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage ( ConfigurationPackage.eNS_URI );

        // Obtain or create and register package
        ConfigurationPackageImpl theConfigurationPackage = (ConfigurationPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ConfigurationPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theConfigurationPackage.createPackageContents ();

        // Initialize created meta-data
        theConfigurationPackage.initializePackageContents ();

        // Register package validator
        EValidator.Registry.INSTANCE.put ( theConfigurationPackage, new EValidator.Descriptor () {
            public EValidator getEValidator ()
            {
                return ConfigurationValidator.INSTANCE;
            }
        } );

        // Mark meta-data to indicate it can't be changed
        theConfigurationPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ConfigurationPackage.eNS_URI, theConfigurationPackage );
        return theConfigurationPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractQueryType ()
    {
        return abstractQueryTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractQueryType_Sql ()
    {
        return (EAttribute)abstractQueryTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAbstractQueryType_ColumnMapping ()
    {
        return (EReference)abstractQueryTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractQueryType_Id ()
    {
        return (EAttribute)abstractQueryTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractQueryType_Period ()
    {
        return (EAttribute)abstractQueryTypeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractQueryType_Sql1 ()
    {
        return (EAttribute)abstractQueryTypeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getColumnMappingType ()
    {
        return columnMappingTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColumnMappingType_AliasName ()
    {
        return (EAttribute)columnMappingTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getColumnMappingType_ColumnNumber ()
    {
        return (EAttribute)columnMappingTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCommandsType ()
    {
        return commandsTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCommandsType_Sql ()
    {
        return (EAttribute)commandsTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCommandsType_LocalName ()
    {
        return (EAttribute)commandsTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCommandsType_Sql1 ()
    {
        return (EAttribute)commandsTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConnectionType ()
    {
        return connectionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnectionType_Query ()
    {
        return (EReference)connectionTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnectionType_TabularQuery ()
    {
        return (EReference)connectionTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnectionType_Update ()
    {
        return (EReference)connectionTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnectionType_ConnectionClass ()
    {
        return (EAttribute)connectionTypeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnectionType_Id ()
    {
        return (EAttribute)connectionTypeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnectionType_Password ()
    {
        return (EAttribute)connectionTypeEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnectionType_Timeout ()
    {
        return (EAttribute)connectionTypeEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnectionType_Uri ()
    {
        return (EAttribute)connectionTypeEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnectionType_Username ()
    {
        return (EAttribute)connectionTypeEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDocumentRoot ()
    {
        return documentRootEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentRoot_Mixed ()
    {
        return (EAttribute)documentRootEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_XMLNSPrefixMap ()
    {
        return (EReference)documentRootEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_XSISchemaLocation ()
    {
        return (EReference)documentRootEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Root ()
    {
        return (EReference)documentRootEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getQueryType ()
    {
        return queryTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRootType ()
    {
        return rootTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRootType_Connection ()
    {
        return (EReference)rootTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTabularQueryType ()
    {
        return tabularQueryTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTabularQueryType_UpdateColumns ()
    {
        return (EReference)tabularQueryTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTabularQueryType_DefaultUpdateSql ()
    {
        return (EAttribute)tabularQueryTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTabularQueryType_Commands ()
    {
        return (EReference)tabularQueryTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTabularQueryType_DefaultUpdateSql1 ()
    {
        return (EAttribute)tabularQueryTypeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTabularQueryType_IdColumn ()
    {
        return (EAttribute)tabularQueryTypeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUpdateColumnsType ()
    {
        return updateColumnsTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUpdateColumnsType_ColumnName ()
    {
        return (EAttribute)updateColumnsTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUpdateColumnsType_CustomUpdateSql ()
    {
        return (EAttribute)updateColumnsTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUpdateMappingType ()
    {
        return updateMappingTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUpdateMappingType_Name ()
    {
        return (EAttribute)updateMappingTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUpdateMappingType_NamedParameter ()
    {
        return (EAttribute)updateMappingTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUpdateType ()
    {
        return updateTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUpdateType_Sql ()
    {
        return (EAttribute)updateTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUpdateType_Mapping ()
    {
        return (EReference)updateTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUpdateType_Id ()
    {
        return (EAttribute)updateTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUpdateType_Sql1 ()
    {
        return (EAttribute)updateTypeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getAliasNameType ()
    {
        return aliasNameTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getColumnNumberType ()
    {
        return columnNumberTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getColumnNumberTypeObject ()
    {
        return columnNumberTypeObjectEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationFactory getConfigurationFactory ()
    {
        return (ConfigurationFactory)getEFactoryInstance ();
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
        abstractQueryTypeEClass = createEClass ( ABSTRACT_QUERY_TYPE );
        createEAttribute ( abstractQueryTypeEClass, ABSTRACT_QUERY_TYPE__SQL );
        createEReference ( abstractQueryTypeEClass, ABSTRACT_QUERY_TYPE__COLUMN_MAPPING );
        createEAttribute ( abstractQueryTypeEClass, ABSTRACT_QUERY_TYPE__ID );
        createEAttribute ( abstractQueryTypeEClass, ABSTRACT_QUERY_TYPE__PERIOD );
        createEAttribute ( abstractQueryTypeEClass, ABSTRACT_QUERY_TYPE__SQL1 );

        columnMappingTypeEClass = createEClass ( COLUMN_MAPPING_TYPE );
        createEAttribute ( columnMappingTypeEClass, COLUMN_MAPPING_TYPE__ALIAS_NAME );
        createEAttribute ( columnMappingTypeEClass, COLUMN_MAPPING_TYPE__COLUMN_NUMBER );

        commandsTypeEClass = createEClass ( COMMANDS_TYPE );
        createEAttribute ( commandsTypeEClass, COMMANDS_TYPE__SQL );
        createEAttribute ( commandsTypeEClass, COMMANDS_TYPE__LOCAL_NAME );
        createEAttribute ( commandsTypeEClass, COMMANDS_TYPE__SQL1 );

        connectionTypeEClass = createEClass ( CONNECTION_TYPE );
        createEReference ( connectionTypeEClass, CONNECTION_TYPE__QUERY );
        createEReference ( connectionTypeEClass, CONNECTION_TYPE__TABULAR_QUERY );
        createEReference ( connectionTypeEClass, CONNECTION_TYPE__UPDATE );
        createEAttribute ( connectionTypeEClass, CONNECTION_TYPE__CONNECTION_CLASS );
        createEAttribute ( connectionTypeEClass, CONNECTION_TYPE__ID );
        createEAttribute ( connectionTypeEClass, CONNECTION_TYPE__PASSWORD );
        createEAttribute ( connectionTypeEClass, CONNECTION_TYPE__TIMEOUT );
        createEAttribute ( connectionTypeEClass, CONNECTION_TYPE__URI );
        createEAttribute ( connectionTypeEClass, CONNECTION_TYPE__USERNAME );

        documentRootEClass = createEClass ( DOCUMENT_ROOT );
        createEAttribute ( documentRootEClass, DOCUMENT_ROOT__MIXED );
        createEReference ( documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP );
        createEReference ( documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION );
        createEReference ( documentRootEClass, DOCUMENT_ROOT__ROOT );

        queryTypeEClass = createEClass ( QUERY_TYPE );

        rootTypeEClass = createEClass ( ROOT_TYPE );
        createEReference ( rootTypeEClass, ROOT_TYPE__CONNECTION );

        tabularQueryTypeEClass = createEClass ( TABULAR_QUERY_TYPE );
        createEReference ( tabularQueryTypeEClass, TABULAR_QUERY_TYPE__UPDATE_COLUMNS );
        createEAttribute ( tabularQueryTypeEClass, TABULAR_QUERY_TYPE__DEFAULT_UPDATE_SQL );
        createEReference ( tabularQueryTypeEClass, TABULAR_QUERY_TYPE__COMMANDS );
        createEAttribute ( tabularQueryTypeEClass, TABULAR_QUERY_TYPE__DEFAULT_UPDATE_SQL1 );
        createEAttribute ( tabularQueryTypeEClass, TABULAR_QUERY_TYPE__ID_COLUMN );

        updateColumnsTypeEClass = createEClass ( UPDATE_COLUMNS_TYPE );
        createEAttribute ( updateColumnsTypeEClass, UPDATE_COLUMNS_TYPE__COLUMN_NAME );
        createEAttribute ( updateColumnsTypeEClass, UPDATE_COLUMNS_TYPE__CUSTOM_UPDATE_SQL );

        updateMappingTypeEClass = createEClass ( UPDATE_MAPPING_TYPE );
        createEAttribute ( updateMappingTypeEClass, UPDATE_MAPPING_TYPE__NAME );
        createEAttribute ( updateMappingTypeEClass, UPDATE_MAPPING_TYPE__NAMED_PARAMETER );

        updateTypeEClass = createEClass ( UPDATE_TYPE );
        createEAttribute ( updateTypeEClass, UPDATE_TYPE__SQL );
        createEReference ( updateTypeEClass, UPDATE_TYPE__MAPPING );
        createEAttribute ( updateTypeEClass, UPDATE_TYPE__ID );
        createEAttribute ( updateTypeEClass, UPDATE_TYPE__SQL1 );

        // Create data types
        aliasNameTypeEDataType = createEDataType ( ALIAS_NAME_TYPE );
        columnNumberTypeEDataType = createEDataType ( COLUMN_NUMBER_TYPE );
        columnNumberTypeObjectEDataType = createEDataType ( COLUMN_NUMBER_TYPE_OBJECT );
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
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage ( XMLTypePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        queryTypeEClass.getESuperTypes ().add ( this.getAbstractQueryType () );
        tabularQueryTypeEClass.getESuperTypes ().add ( this.getAbstractQueryType () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( abstractQueryTypeEClass, AbstractQueryType.class, "AbstractQueryType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAbstractQueryType_Sql (), theXMLTypePackage.getString (), "sql", null, 0, 1, AbstractQueryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAbstractQueryType_ColumnMapping (), this.getColumnMappingType (), null, "columnMapping", null, 0, -1, AbstractQueryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAbstractQueryType_Id (), theXMLTypePackage.getString (), "id", null, 1, 1, AbstractQueryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAbstractQueryType_Period (), theXMLTypePackage.getInt (), "period", null, 1, 1, AbstractQueryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAbstractQueryType_Sql1 (), theXMLTypePackage.getString (), "sql1", null, 0, 1, AbstractQueryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( columnMappingTypeEClass, ColumnMappingType.class, "ColumnMappingType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getColumnMappingType_AliasName (), this.getAliasNameType (), "aliasName", null, 1, 1, ColumnMappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getColumnMappingType_ColumnNumber (), this.getColumnNumberType (), "columnNumber", null, 1, 1, ColumnMappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( commandsTypeEClass, CommandsType.class, "CommandsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCommandsType_Sql (), theXMLTypePackage.getString (), "sql", null, 0, 1, CommandsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCommandsType_LocalName (), theXMLTypePackage.getString (), "localName", null, 1, 1, CommandsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCommandsType_Sql1 (), theXMLTypePackage.getString (), "sql1", null, 0, 1, CommandsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( connectionTypeEClass, ConnectionType.class, "ConnectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getConnectionType_Query (), this.getQueryType (), null, "query", null, 0, -1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getConnectionType_TabularQuery (), this.getTabularQueryType (), null, "tabularQuery", null, 0, -1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getConnectionType_Update (), this.getUpdateType (), null, "update", null, 0, -1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnectionType_ConnectionClass (), theXMLTypePackage.getString (), "connectionClass", null, 0, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnectionType_Id (), theXMLTypePackage.getString (), "id", null, 1, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnectionType_Password (), theXMLTypePackage.getString (), "password", null, 0, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnectionType_Timeout (), theXMLTypePackage.getInt (), "timeout", null, 0, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnectionType_Uri (), theXMLTypePackage.getString (), "uri", null, 1, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnectionType_Username (), theXMLTypePackage.getString (), "username", null, 0, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDocumentRoot_Mixed (), ecorePackage.getEFeatureMapEntry (), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDocumentRoot_XMLNSPrefixMap (), ecorePackage.getEStringToStringMapEntry (), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDocumentRoot_XSISchemaLocation (), ecorePackage.getEStringToStringMapEntry (), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDocumentRoot_Root (), this.getRootType (), null, "root", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( queryTypeEClass, QueryType.class, "QueryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( rootTypeEClass, RootType.class, "RootType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getRootType_Connection (), this.getConnectionType (), null, "connection", null, 0, -1, RootType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( tabularQueryTypeEClass, TabularQueryType.class, "TabularQueryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getTabularQueryType_UpdateColumns (), this.getUpdateColumnsType (), null, "updateColumns", null, 0, -1, TabularQueryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTabularQueryType_DefaultUpdateSql (), theXMLTypePackage.getString (), "defaultUpdateSql", null, 0, 1, TabularQueryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getTabularQueryType_Commands (), this.getCommandsType (), null, "commands", null, 0, -1, TabularQueryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTabularQueryType_DefaultUpdateSql1 (), theXMLTypePackage.getString (), "defaultUpdateSql1", null, 0, 1, TabularQueryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTabularQueryType_IdColumn (), theXMLTypePackage.getInt (), "idColumn", null, 1, 1, TabularQueryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( updateColumnsTypeEClass, UpdateColumnsType.class, "UpdateColumnsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getUpdateColumnsType_ColumnName (), theXMLTypePackage.getString (), "columnName", null, 1, 1, UpdateColumnsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getUpdateColumnsType_CustomUpdateSql (), theXMLTypePackage.getString (), "customUpdateSql", null, 0, 1, UpdateColumnsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( updateMappingTypeEClass, UpdateMappingType.class, "UpdateMappingType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getUpdateMappingType_Name (), theXMLTypePackage.getString (), "name", null, 0, 1, UpdateMappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getUpdateMappingType_NamedParameter (), theXMLTypePackage.getString (), "namedParameter", null, 1, 1, UpdateMappingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( updateTypeEClass, UpdateType.class, "UpdateType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getUpdateType_Sql (), theXMLTypePackage.getString (), "sql", null, 0, 1, UpdateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getUpdateType_Mapping (), this.getUpdateMappingType (), null, "mapping", null, 0, -1, UpdateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getUpdateType_Id (), theXMLTypePackage.getString (), "id", null, 1, 1, UpdateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getUpdateType_Sql1 (), theXMLTypePackage.getString (), "sql1", null, 0, 1, UpdateType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize data types
        initEDataType ( aliasNameTypeEDataType, String.class, "AliasNameType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( columnNumberTypeEDataType, int.class, "ColumnNumberType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( columnNumberTypeObjectEDataType, Integer.class, "ColumnNumberTypeObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations ();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations ()
    {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$		
        addAnnotation ( abstractQueryTypeEClass, source, new String[] { "name", "AbstractQueryType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getAbstractQueryType_Sql (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "sql", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getAbstractQueryType_ColumnMapping (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "columnMapping", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getAbstractQueryType_Id (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "id" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getAbstractQueryType_Period (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "period" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getAbstractQueryType_Sql1 (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "sql" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( aliasNameTypeEDataType, source, new String[] { "name", "aliasName_._type", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
        "minLength", "1" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( columnMappingTypeEClass, source, new String[] { "name", "ColumnMappingType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getColumnMappingType_AliasName (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "aliasName" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getColumnMappingType_ColumnNumber (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "columnNumber" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( columnNumberTypeEDataType, source, new String[] { "name", "columnNumber_._type", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "http://www.eclipse.org/emf/2003/XMLType#int", //$NON-NLS-1$ //$NON-NLS-2$
        "minInclusive", "1" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( columnNumberTypeObjectEDataType, source, new String[] { "name", "columnNumber_._type:Object", //$NON-NLS-1$ //$NON-NLS-2$
        "baseType", "columnNumber_._type" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( commandsTypeEClass, source, new String[] { "name", "CommandsType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getCommandsType_Sql (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "sql", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getCommandsType_LocalName (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "localName" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getCommandsType_Sql1 (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "sql" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( connectionTypeEClass, source, new String[] { "name", "ConnectionType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Query (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "query", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_TabularQuery (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "tabularQuery", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Update (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "update", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_ConnectionClass (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "connectionClass" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Id (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "id" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Password (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "password" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Timeout (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "timeout" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Uri (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "uri" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Username (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "username" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( documentRootEClass, source, new String[] { "name", "", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_Mixed (), source, new String[] { "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
        "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_XMLNSPrefixMap (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_XSISchemaLocation (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_Root (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "root", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( queryTypeEClass, source, new String[] { "name", "QueryType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( rootTypeEClass, source, new String[] { "name", "RootType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRootType_Connection (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "connection", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( tabularQueryTypeEClass, source, new String[] { "name", "TabularQueryType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getTabularQueryType_UpdateColumns (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "updateColumns", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getTabularQueryType_DefaultUpdateSql (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "defaultUpdateSql", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getTabularQueryType_Commands (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "commands", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getTabularQueryType_DefaultUpdateSql1 (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "defaultUpdateSql" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getTabularQueryType_IdColumn (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "idColumn" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( updateColumnsTypeEClass, source, new String[] { "name", "UpdateColumnsType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getUpdateColumnsType_ColumnName (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "columnName" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getUpdateColumnsType_CustomUpdateSql (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "customUpdateSql" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( updateMappingTypeEClass, source, new String[] { "name", "UpdateMappingType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getUpdateMappingType_Name (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getUpdateMappingType_NamedParameter (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "namedParameter" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( updateTypeEClass, source, new String[] { "name", "UpdateType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getUpdateType_Sql (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "sql", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getUpdateType_Mapping (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "mapping", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getUpdateType_Id (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "id" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getUpdateType_Sql1 (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "sql" //$NON-NLS-1$ //$NON-NLS-2$
        } );
    }

} //ConfigurationPackageImpl
