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
package org.eclipse.scada.da.jdbc.configuration.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;
import org.eclipse.scada.da.jdbc.configuration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage
 * @generated
 */
public class ConfigurationValidator extends EObjectValidator
{
    //$NON-NLS-1$

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final ConfigurationValidator INSTANCE = new ConfigurationValidator ();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.scada.da.jdbc.configuration"; //$NON-NLS-1$

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * The cached base package validator.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected XMLTypeValidator xmlTypeValidator;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationValidator ()
    {
        super ();
        xmlTypeValidator = XMLTypeValidator.INSTANCE;
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EPackage getEPackage ()
    {
        return ConfigurationPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate ( int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        switch ( classifierID )
        {
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE:
                return validateAbstractQueryType ( (AbstractQueryType)value, diagnostics, context );
            case ConfigurationPackage.COLUMN_MAPPING_TYPE:
                return validateColumnMappingType ( (ColumnMappingType)value, diagnostics, context );
            case ConfigurationPackage.COMMANDS_TYPE:
                return validateCommandsType ( (CommandsType)value, diagnostics, context );
            case ConfigurationPackage.CONNECTION_TYPE:
                return validateConnectionType ( (ConnectionType)value, diagnostics, context );
            case ConfigurationPackage.DOCUMENT_ROOT:
                return validateDocumentRoot ( (DocumentRoot)value, diagnostics, context );
            case ConfigurationPackage.QUERY_TYPE:
                return validateQueryType ( (QueryType)value, diagnostics, context );
            case ConfigurationPackage.ROOT_TYPE:
                return validateRootType ( (RootType)value, diagnostics, context );
            case ConfigurationPackage.TABULAR_QUERY_TYPE:
                return validateTabularQueryType ( (TabularQueryType)value, diagnostics, context );
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE:
                return validateUpdateColumnsType ( (UpdateColumnsType)value, diagnostics, context );
            case ConfigurationPackage.UPDATE_MAPPING_TYPE:
                return validateUpdateMappingType ( (UpdateMappingType)value, diagnostics, context );
            case ConfigurationPackage.UPDATE_TYPE:
                return validateUpdateType ( (UpdateType)value, diagnostics, context );
            case ConfigurationPackage.ALIAS_NAME_TYPE:
                return validateAliasNameType ( (String)value, diagnostics, context );
            case ConfigurationPackage.COLUMN_NUMBER_TYPE:
                return validateColumnNumberType ( (Integer)value, diagnostics, context );
            case ConfigurationPackage.COLUMN_NUMBER_TYPE_OBJECT:
                return validateColumnNumberTypeObject ( (Integer)value, diagnostics, context );
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAbstractQueryType ( AbstractQueryType abstractQueryType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( abstractQueryType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateColumnMappingType ( ColumnMappingType columnMappingType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( columnMappingType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCommandsType ( CommandsType commandsType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( commandsType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateConnectionType ( ConnectionType connectionType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( connectionType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDocumentRoot ( DocumentRoot documentRoot, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( documentRoot, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateQueryType ( QueryType queryType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( queryType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateRootType ( RootType rootType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( rootType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTabularQueryType ( TabularQueryType tabularQueryType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( tabularQueryType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUpdateColumnsType ( UpdateColumnsType updateColumnsType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( updateColumnsType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUpdateMappingType ( UpdateMappingType updateMappingType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( updateMappingType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUpdateType ( UpdateType updateType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( updateType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAliasNameType ( String aliasNameType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = validateAliasNameType_MinLength ( aliasNameType, diagnostics, context );
        return result;
    }

    /**
     * Validates the MinLength constraint of '<em>Alias Name Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAliasNameType_MinLength ( String aliasNameType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        int length = aliasNameType.length ();
        boolean result = length >= 1;
        if ( !result && diagnostics != null )
            reportMinLengthViolation ( ConfigurationPackage.Literals.ALIAS_NAME_TYPE, aliasNameType, length, 1, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateColumnNumberType ( int columnNumberType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = validateColumnNumberType_Min ( columnNumberType, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @see #validateColumnNumberType_Min
     */
    public static final int COLUMN_NUMBER_TYPE__MIN__VALUE = 1;

    /**
     * Validates the Min constraint of '<em>Column Number Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateColumnNumberType_Min ( int columnNumberType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = columnNumberType >= COLUMN_NUMBER_TYPE__MIN__VALUE;
        if ( !result && diagnostics != null )
            reportMinViolation ( ConfigurationPackage.Literals.COLUMN_NUMBER_TYPE, columnNumberType, COLUMN_NUMBER_TYPE__MIN__VALUE, true, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateColumnNumberTypeObject ( Integer columnNumberTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = validateColumnNumberType_Min ( columnNumberTypeObject, diagnostics, context );
        return result;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator ()
    {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator ();
    }

} //ConfigurationValidator
