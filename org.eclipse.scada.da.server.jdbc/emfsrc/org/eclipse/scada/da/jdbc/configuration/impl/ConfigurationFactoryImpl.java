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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.scada.da.jdbc.configuration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationFactoryImpl extends EFactoryImpl implements ConfigurationFactory
{
    //$NON-NLS-1$

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ConfigurationFactory init ()
    {
        try
        {
            ConfigurationFactory theConfigurationFactory = (ConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory ( ConfigurationPackage.eNS_URI );
            if ( theConfigurationFactory != null )
            {
                return theConfigurationFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ConfigurationFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case ConfigurationPackage.COLUMN_MAPPING_TYPE:
                return createColumnMappingType ();
            case ConfigurationPackage.COMMANDS_TYPE:
                return createCommandsType ();
            case ConfigurationPackage.CONNECTION_TYPE:
                return createConnectionType ();
            case ConfigurationPackage.DOCUMENT_ROOT:
                return createDocumentRoot ();
            case ConfigurationPackage.QUERY_TYPE:
                return createQueryType ();
            case ConfigurationPackage.ROOT_TYPE:
                return createRootType ();
            case ConfigurationPackage.TABULAR_QUERY_TYPE:
                return createTabularQueryType ();
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE:
                return createUpdateColumnsType ();
            case ConfigurationPackage.UPDATE_MAPPING_TYPE:
                return createUpdateMappingType ();
            case ConfigurationPackage.UPDATE_TYPE:
                return createUpdateType ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ConfigurationPackage.ALIAS_NAME_TYPE:
                return createAliasNameTypeFromString ( eDataType, initialValue );
            case ConfigurationPackage.COLUMN_NUMBER_TYPE:
                return createColumnNumberTypeFromString ( eDataType, initialValue );
            case ConfigurationPackage.COLUMN_NUMBER_TYPE_OBJECT:
                return createColumnNumberTypeObjectFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ConfigurationPackage.ALIAS_NAME_TYPE:
                return convertAliasNameTypeToString ( eDataType, instanceValue );
            case ConfigurationPackage.COLUMN_NUMBER_TYPE:
                return convertColumnNumberTypeToString ( eDataType, instanceValue );
            case ConfigurationPackage.COLUMN_NUMBER_TYPE_OBJECT:
                return convertColumnNumberTypeObjectToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ColumnMappingType createColumnMappingType ()
    {
        ColumnMappingTypeImpl columnMappingType = new ColumnMappingTypeImpl ();
        return columnMappingType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommandsType createCommandsType ()
    {
        CommandsTypeImpl commandsType = new CommandsTypeImpl ();
        return commandsType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConnectionType createConnectionType ()
    {
        ConnectionTypeImpl connectionType = new ConnectionTypeImpl ();
        return connectionType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentRoot createDocumentRoot ()
    {
        DocumentRootImpl documentRoot = new DocumentRootImpl ();
        return documentRoot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public QueryType createQueryType ()
    {
        QueryTypeImpl queryType = new QueryTypeImpl ();
        return queryType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RootType createRootType ()
    {
        RootTypeImpl rootType = new RootTypeImpl ();
        return rootType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TabularQueryType createTabularQueryType ()
    {
        TabularQueryTypeImpl tabularQueryType = new TabularQueryTypeImpl ();
        return tabularQueryType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UpdateColumnsType createUpdateColumnsType ()
    {
        UpdateColumnsTypeImpl updateColumnsType = new UpdateColumnsTypeImpl ();
        return updateColumnsType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UpdateMappingType createUpdateMappingType ()
    {
        UpdateMappingTypeImpl updateMappingType = new UpdateMappingTypeImpl ();
        return updateMappingType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UpdateType createUpdateType ()
    {
        UpdateTypeImpl updateType = new UpdateTypeImpl ();
        return updateType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String createAliasNameTypeFromString ( EDataType eDataType, String initialValue )
    {
        return (String)XMLTypeFactory.eINSTANCE.createFromString ( XMLTypePackage.Literals.STRING, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertAliasNameTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return XMLTypeFactory.eINSTANCE.convertToString ( XMLTypePackage.Literals.STRING, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer createColumnNumberTypeFromString ( EDataType eDataType, String initialValue )
    {
        return (Integer)XMLTypeFactory.eINSTANCE.createFromString ( XMLTypePackage.Literals.INT, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertColumnNumberTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return XMLTypeFactory.eINSTANCE.convertToString ( XMLTypePackage.Literals.INT, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer createColumnNumberTypeObjectFromString ( EDataType eDataType, String initialValue )
    {
        return createColumnNumberTypeFromString ( ConfigurationPackage.Literals.COLUMN_NUMBER_TYPE, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertColumnNumberTypeObjectToString ( EDataType eDataType, Object instanceValue )
    {
        return convertColumnNumberTypeToString ( ConfigurationPackage.Literals.COLUMN_NUMBER_TYPE, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationPackage getConfigurationPackage ()
    {
        return (ConfigurationPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ConfigurationPackage getPackage ()
    {
        return ConfigurationPackage.eINSTANCE;
    }

} //ConfigurationFactoryImpl
