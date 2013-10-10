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
package org.eclipse.scada.da.exec.configuration.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;
import org.eclipse.scada.da.exec.configuration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage
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
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.scada.da.exec.configuration"; //$NON-NLS-1$

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
            case ConfigurationPackage.COMMAND_TYPE:
                return validateCommandType ( (CommandType)value, diagnostics, context );
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE:
                return validateContinuousCommandType ( (ContinuousCommandType)value, diagnostics, context );
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE:
                return validateCustomExtractorType ( (CustomExtractorType)value, diagnostics, context );
            case ConfigurationPackage.DOCUMENT_ROOT:
                return validateDocumentRoot ( (DocumentRoot)value, diagnostics, context );
            case ConfigurationPackage.ENV_ENTRY_TYPE:
                return validateEnvEntryType ( (EnvEntryType)value, diagnostics, context );
            case ConfigurationPackage.EXTRACTOR_TYPE:
                return validateExtractorType ( (ExtractorType)value, diagnostics, context );
            case ConfigurationPackage.FIELD_EXTRACTOR_TYPE:
                return validateFieldExtractorType ( (FieldExtractorType)value, diagnostics, context );
            case ConfigurationPackage.FIELD_TYPE:
                return validateFieldType ( (FieldType)value, diagnostics, context );
            case ConfigurationPackage.HIVE_PROCESS_COMMAND_TYPE:
                return validateHiveProcessCommandType ( (HiveProcessCommandType)value, diagnostics, context );
            case ConfigurationPackage.NAGIOS_RETURN_CODE_EXTRACTOR_TYPE:
                return validateNagiosReturnCodeExtractorType ( (NagiosReturnCodeExtractorType)value, diagnostics, context );
            case ConfigurationPackage.PLAIN_STREAM_EXTRACTOR_TYPE:
                return validatePlainStreamExtractorType ( (PlainStreamExtractorType)value, diagnostics, context );
            case ConfigurationPackage.PROCESS_TYPE:
                return validateProcessType ( (ProcessType)value, diagnostics, context );
            case ConfigurationPackage.QUEUE_TYPE:
                return validateQueueType ( (QueueType)value, diagnostics, context );
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE:
                return validateRegExExtractorType ( (RegExExtractorType)value, diagnostics, context );
            case ConfigurationPackage.RETURN_CODE_EXTRACTOR_TYPE:
                return validateReturnCodeExtractorType ( (ReturnCodeExtractorType)value, diagnostics, context );
            case ConfigurationPackage.ROOT_TYPE:
                return validateRootType ( (RootType)value, diagnostics, context );
            case ConfigurationPackage.SIMPLE_EXTRACTOR_TYPE:
                return validateSimpleExtractorType ( (SimpleExtractorType)value, diagnostics, context );
            case ConfigurationPackage.SINGLE_COMMAND_TYPE:
                return validateSingleCommandType ( (SingleCommandType)value, diagnostics, context );
            case ConfigurationPackage.SPLIT_CONTINUOUS_COMMAND_TYPE:
                return validateSplitContinuousCommandType ( (SplitContinuousCommandType)value, diagnostics, context );
            case ConfigurationPackage.SPLITTER_EXTRACTOR_TYPE:
                return validateSplitterExtractorType ( (SplitterExtractorType)value, diagnostics, context );
            case ConfigurationPackage.SPLITTER_TYPE:
                return validateSplitterType ( (SplitterType)value, diagnostics, context );
            case ConfigurationPackage.TRIGGER_COMMAND_TYPE:
                return validateTriggerCommandType ( (TriggerCommandType)value, diagnostics, context );
            case ConfigurationPackage.VARIANT_TYPE_TYPE:
                return validateVariantTypeType ( (VariantTypeType)value, diagnostics, context );
            case ConfigurationPackage.CLASS_TYPE:
                return validateClassType ( (String)value, diagnostics, context );
            case ConfigurationPackage.NAME_TYPE:
                return validateNameType ( (String)value, diagnostics, context );
            case ConfigurationPackage.NAME_TYPE1:
                return validateNameType1 ( (String)value, diagnostics, context );
            case ConfigurationPackage.PERIOD_TYPE:
                return validatePeriodType ( (Integer)value, diagnostics, context );
            case ConfigurationPackage.PERIOD_TYPE_OBJECT:
                return validatePeriodTypeObject ( (Integer)value, diagnostics, context );
            case ConfigurationPackage.RESTART_DELAY_TYPE:
                return validateRestartDelayType ( (Integer)value, diagnostics, context );
            case ConfigurationPackage.RESTART_DELAY_TYPE_OBJECT:
                return validateRestartDelayTypeObject ( (Integer)value, diagnostics, context );
            case ConfigurationPackage.TYPE_TYPE:
                return validateTypeType ( (String)value, diagnostics, context );
            case ConfigurationPackage.VARIANT_TYPE_TYPE_OBJECT:
                return validateVariantTypeTypeObject ( (VariantTypeType)value, diagnostics, context );
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCommandType ( CommandType commandType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( commandType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateContinuousCommandType ( ContinuousCommandType continuousCommandType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( continuousCommandType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCustomExtractorType ( CustomExtractorType customExtractorType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( customExtractorType, diagnostics, context );
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
    public boolean validateEnvEntryType ( EnvEntryType envEntryType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( envEntryType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExtractorType ( ExtractorType extractorType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( extractorType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFieldExtractorType ( FieldExtractorType fieldExtractorType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( fieldExtractorType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateFieldType ( FieldType fieldType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( fieldType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateHiveProcessCommandType ( HiveProcessCommandType hiveProcessCommandType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( hiveProcessCommandType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNagiosReturnCodeExtractorType ( NagiosReturnCodeExtractorType nagiosReturnCodeExtractorType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( nagiosReturnCodeExtractorType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePlainStreamExtractorType ( PlainStreamExtractorType plainStreamExtractorType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( plainStreamExtractorType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateProcessType ( ProcessType processType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( processType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateQueueType ( QueueType queueType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( queueType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateRegExExtractorType ( RegExExtractorType regExExtractorType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( regExExtractorType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateReturnCodeExtractorType ( ReturnCodeExtractorType returnCodeExtractorType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( returnCodeExtractorType, diagnostics, context );
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
    public boolean validateSimpleExtractorType ( SimpleExtractorType simpleExtractorType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( simpleExtractorType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSingleCommandType ( SingleCommandType singleCommandType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( singleCommandType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSplitContinuousCommandType ( SplitContinuousCommandType splitContinuousCommandType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( splitContinuousCommandType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSplitterExtractorType ( SplitterExtractorType splitterExtractorType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( splitterExtractorType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSplitterType ( SplitterType splitterType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( splitterType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTriggerCommandType ( TriggerCommandType triggerCommandType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( triggerCommandType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariantTypeType ( VariantTypeType variantTypeType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateClassType ( String classType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = validateClassType_Pattern ( classType, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @see #validateClassType_Pattern
     */
    public static final PatternMatcher[][] CLASS_TYPE__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil.createPatternMatcher ( "\\w+(\\.\\w+)*" ) } };

    /**
     * Validates the Pattern constraint of '<em>Class Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateClassType_Pattern ( String classType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validatePattern ( ConfigurationPackage.Literals.CLASS_TYPE, classType, CLASS_TYPE__PATTERN__VALUES, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNameType ( String nameType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNameType1 ( String nameType1, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = validateNameType1_Pattern ( nameType1, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @see #validateNameType1_Pattern
     */
    public static final PatternMatcher[][] NAME_TYPE1__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil.createPatternMatcher ( "\\w+" ) } };

    /**
     * Validates the Pattern constraint of '<em>Name Type1</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNameType1_Pattern ( String nameType1, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validatePattern ( ConfigurationPackage.Literals.NAME_TYPE1, nameType1, NAME_TYPE1__PATTERN__VALUES, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePeriodType ( int periodType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = validatePeriodType_Min ( periodType, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @see #validatePeriodType_Min
     */
    public static final int PERIOD_TYPE__MIN__VALUE = 0;

    /**
     * Validates the Min constraint of '<em>Period Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePeriodType_Min ( int periodType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = periodType > PERIOD_TYPE__MIN__VALUE;
        if ( !result && diagnostics != null )
            reportMinViolation ( ConfigurationPackage.Literals.PERIOD_TYPE, periodType, PERIOD_TYPE__MIN__VALUE, false, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePeriodTypeObject ( Integer periodTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = validatePeriodType_Min ( periodTypeObject, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateRestartDelayType ( int restartDelayType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateRestartDelayTypeObject ( Integer restartDelayTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTypeType ( String typeType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = validateTypeType_Pattern ( typeType, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @see #validateTypeType_Pattern
     */
    public static final PatternMatcher[][] TYPE_TYPE__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil.createPatternMatcher ( "(newline|regexpMatch|regexpSplit|split|class#.*)" ) } };

    /**
     * Validates the Pattern constraint of '<em>Type Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTypeType_Pattern ( String typeType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validatePattern ( ConfigurationPackage.Literals.TYPE_TYPE, typeType, TYPE_TYPE__PATTERN__VALUES, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariantTypeTypeObject ( VariantTypeType variantTypeTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return true;
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
